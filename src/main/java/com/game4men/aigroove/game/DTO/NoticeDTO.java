package com.game4men.aigroove.game.DTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NoticeDTO {
    private int author_id;
    private String title;    
    private String content;
    private LocalDateTime createdAt;
}
