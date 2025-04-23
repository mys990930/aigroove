package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
} 