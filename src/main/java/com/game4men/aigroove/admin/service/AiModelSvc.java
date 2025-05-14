package com.game4men.aigroove.admin.service;

import com.game4men.aigroove.admin.dto.ModelResponseDto;
import com.game4men.aigroove.common.entity.ModelInfo;
import com.game4men.aigroove.common.repository.ModelInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AiModelSvc {
    private final ModelInfoRepository aiModelRepository;

    public List<ModelResponseDto> getAllModelVersions(String adminId) {
        // 실제로는 adminId로 권한 체크 등 가능
        List<ModelInfo> modelInfos = aiModelRepository.findAllByOrderByModelIdDesc();

        System.out.println(modelInfos.get(0).getVersion());
        return modelInfos.stream().map(model -> new ModelResponseDto(
                model.getModelId(),
                model.getVersion(),
                model.getReleasedDate(),
                model.getAccuracy(),
                model.getF1Score(),
                model.getKeyUpdates()
        )).collect(Collectors.toList());
    }

    // 특정 모델 리턴
    public ModelInfo getModelInfoById(Integer modelId) {
        return aiModelRepository.findById(modelId).orElse(null);
    }
}
