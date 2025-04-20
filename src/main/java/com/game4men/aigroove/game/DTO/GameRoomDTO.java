package com.game4men.aigroove.game.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GameRoomDTO {
    @NotBlank
    private String room_code;
    private boolean has_guest;
    private boolean is_download_complete;
    private boolean is_game_started;
}
