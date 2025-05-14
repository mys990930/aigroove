package com.game4men.aigroove.admin.controller;

import com.game4men.aigroove.admin.dto.ModelResponseDto;
import com.game4men.aigroove.admin.service.AiModelSvc;
import com.game4men.aigroove.common.entity.ModelInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/ai/model")
public class AiModelController {
    private final AiModelSvc aiModelSvc;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllModelVersions(@RequestParam(name="admin_id") String adminId) {
        try {
            List<ModelResponseDto> models = aiModelSvc.getAllModelVersions(adminId);

            Map<String, Object> response = new HashMap<>();

            response.put("result_code", 201);
            response.put("models", models);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("result_code", 500);
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping("/detail")
    public ResponseEntity<Map<String, Object>> getModelDetail(@RequestParam("model_id") Integer modelId) {
        try {
            // 1. ModelInfo 조회
            ModelInfo model = aiModelSvc.getModelInfoById(modelId);
            
            if (model == null) {
                Map<String, Object> error = new HashMap<>();
                error.put("result_code", 404);
                error.put("error", "Model not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            // 2. dataset_ids, params 등은 서비스에서 조회/가공 (여기선 예시)
            List<String> datasetIds = model.getDatasets()
                    .stream()
                    .map(ds -> ds.getDatasetId().toString())
                    .collect(Collectors.toList());
            Map<String, Object> params = new HashMap<>();
            params.put("learning_rate", model.getLearningRate());
            params.put("batch_size", model.getBatchSize());
            params.put("epoch_number", model.getEpochNumber());
            params.put("input_size", model.getInputSize());
            params.put("hidden_size", model.getHiddenSize());
            params.put("num_layers", model.getNumLayers());

            // 3. 응답 JSON 구성
            Map<String, Object> response = new HashMap<>();
            response.put("result_code", 200);
            response.put("version_name", model.getVersion());
            response.put("released_date", model.getReleasedDate());
            response.put("accuracy", model.getAccuracy());
            response.put("f1_score", model.getF1Score());
            response.put("key_updates", model.getKeyUpdates());
            response.put("dataset_ids", datasetIds);
            response.put("params", params);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("result_code", 500);
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}