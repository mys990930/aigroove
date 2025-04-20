package com.game4men.aigroove.game.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RankingDTO {
    @NotBlank
    private String nickname;
    @NotNull
    private int rank;
    @NotNull
    private int badge_number;
}
