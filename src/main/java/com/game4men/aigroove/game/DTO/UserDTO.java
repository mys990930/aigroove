package com.game4men.aigroove.game.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private String nickname;
}
