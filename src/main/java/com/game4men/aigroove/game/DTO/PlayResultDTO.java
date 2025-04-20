package com.game4men.aigroove.game.DTO;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayResultDTO {
    private float highscore;
    private int deaths;
    private List<BadgeDTO> achieved_badges;
    @NotNull
    private int opponent_user_id;
}
