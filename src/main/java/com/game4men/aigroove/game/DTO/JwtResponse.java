package com.game4men.aigroove.game.DTO;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    
    private String type = "Bearer";
}
