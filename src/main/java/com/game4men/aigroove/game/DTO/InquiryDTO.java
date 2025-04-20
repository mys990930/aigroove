package com.game4men.aigroove.game.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InquiryDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
