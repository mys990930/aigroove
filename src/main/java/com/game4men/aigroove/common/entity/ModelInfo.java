package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ModelInfo")
@Getter @Setter
@NoArgsConstructor
public class ModelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer modelId;

    @Column(name = "version", nullable = false, length = 10)
    private String version;

    @Column(name = "released_date", nullable = false)
    private LocalDate releasedDate;

    @Column(name = "accuracy", nullable = false)
    private Float accuracy;

    @Column(name = "f1_score", nullable = false)
    private Float f1Score;

    @Column(name = "key_updates", nullable = false, length = 256)
    private String keyUpdates;

    @Column(name = "learning_rate", nullable = false)
    private Float learningRate;

    @Column(name = "batch_size", nullable = false)
    private Integer batchSize;

    @Column(name = "epoch_number", nullable = false)
    private Integer epochNumber;

    @Column(name = "input_size", nullable = false)
    private Integer inputSize;

    @Column(name = "hidden_size", nullable = false)
    private Integer hiddenSize;

    @Column(name = "num_layers", nullable = false)
    private Integer numLayers;

    // 추가 
    @ManyToMany
    @JoinTable(
        name = "ModelInfo_Dataset", // 중간 매핑 테이블명
        joinColumns = @JoinColumn(name = "model_id"),
        inverseJoinColumns = @JoinColumn(name = "dataset_id")
    )
    private List<DatasetInfo> datasets = new ArrayList<>();
} 