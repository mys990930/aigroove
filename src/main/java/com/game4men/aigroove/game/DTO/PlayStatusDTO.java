package com.game4men.aigroove.game.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayStatusDTO {
    @NotNull
    private float current_progress;
    @NotNull
    private float last_checkpoint;
    private int deaths;
    @NotNull
    private boolean has_cleared;
}
