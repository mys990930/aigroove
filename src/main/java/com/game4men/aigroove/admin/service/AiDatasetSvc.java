package com.game4men.aigroove.admin.service;

import com.game4men.aigroove.admin.dto.DatasetInfoDTO;
import com.game4men.aigroove.common.entity.DatasetInfo;
import com.game4men.aigroove.common.entity.Admin;
import com.game4men.aigroove.common.repository.DatasetInfoRepository;
import com.game4men.aigroove.common.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AiDatasetSvc {
    private final DatasetInfoRepository datasetInfoRepository;
    private final AdminRepository adminRepository;

    /* 1. 데이터셋 목록 조회 */
    public List<DatasetInfoDTO> findAllAiDataSets() {
        List<DatasetInfo> datasets = datasetInfoRepository.findAll();
        // stream 사용 => 객체 리스트를 스트림으로 직렬화 
        return datasets.stream()
                .map(DatasetInfoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 특정 데이터셋 조회
    public DatasetInfoDTO findDatasetInfoById(Integer datasetId) {
        return datasetInfoRepository.findById(datasetId)
                .map(DatasetInfoDTO::fromEntity)
                .orElse(null);
    }

    /* 3. 특정 데이터셋 삭제 */
    @Transactional
    public boolean deleteAiDataSet(Integer adminId , Integer datasetId) {
        try {
            DatasetInfo datasetInfo = datasetInfoRepository.findById(datasetId)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 데이터셋입니다."));
            System.out.println("관리자 이름 : " + datasetInfo.getUploader().getName() + "");
            datasetInfo.setUploader(null);
            datasetInfoRepository.save(datasetInfo); // <- 변경 사항 DB에 반영
            datasetInfoRepository.delete(datasetInfo); // <- 그 다음 삭제
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 청크 저장 및 병합 메서드
    public int saveDatasetChunk(Integer adminId, String name, String fileBase64, int index, int totalChunks) throws IOException {
        // 임시 디렉토리 경로 : tmp 디렉토리에 파일 저장 => C:\Users\hunei\AppData\Local\Temp
        String tempDir = System.getProperty("java.io.tmpdir");
        String chunkFileName = tempDir + File.separator + adminId + "_" + name + ".part" + index;
        byte[] chunkBytes = Base64.getDecoder().decode(fileBase64);

        // 청크 파일 저장
        try (FileOutputStream fos = new FileOutputStream(chunkFileName)) {
            fos.write(chunkBytes);
        }
        // 마지막 청크라면 병합
        if (index == totalChunks) {
            String mergedFileName = tempDir + File.separator + adminId + "_" + name;

            // 파일 병합 로직 : mergedOut에 청크 파일을 합쳐서 저장함
            try (FileOutputStream mergedOut = new FileOutputStream(mergedFileName)) {
                for (int i = 1; i <= totalChunks; i++) {
                    String partFile = tempDir + File.separator + adminId + "_" + name + ".part" + i;
                    byte[] partBytes = Files.readAllBytes(Path.of(partFile));
                    mergedOut.write(partBytes);
                    Files.delete(Path.of(partFile));
                }
            }
            // 1. 영구 저장소로 이동
            String currentDir = System.getProperty("user.dir");
            String destDir = currentDir + File.separator + "data" + File.separator + "datasets";
            System.out.println(destDir);
            File destDirFile = new File(destDir);
            if (!destDirFile.exists()) destDirFile.mkdirs();
            String destPath = destDir + File.separator + name; // 예: ../data/datasets/파일명
            Files.move(Path.of(mergedFileName), Path.of(destPath), StandardCopyOption.REPLACE_EXISTING);

            // 2. DB에 등록
            DatasetInfo datasetInfo = new DatasetInfo();
            datasetInfo.setName(name);
            datasetInfo.setUploadDate(LocalDate.now());
            // 둘째자리까지 표시 
            datasetInfo.setSize(Math.round((float) new File(destPath).length() / (1024 * 1024 * 1024) * 100.0) / 100.0f); // GB 단위, 소수점 둘째자리까지 반올림
            datasetInfo.setUri(destPath);
            Admin uploader = adminRepository.findById(adminId).orElse(null);
            datasetInfo.setUploader(uploader);
            datasetInfoRepository.save(datasetInfo);
        }
        return index;
    }
}
