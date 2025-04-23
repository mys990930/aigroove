package com.game4men.aigroove.game.controller;
import com.game4men.aigroove.game.DTO.InquiryDTO;
import com.game4men.aigroove.game.DTO.UserDTO;
import com.game4men.aigroove.game.service.InquirySvc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.game4men.aigroove.common.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class InquiryController {
    @Autowired
    InquirySvc inquirySvc;
    
    @Operation(summary = "문의 등록", description = "문의를 DB에 등록하여 관리자가 열람할 수 있게 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "문의 등록 성공"),
            @ApiResponse(responseCode = "400", description = "오류"),
            @ApiResponse(responseCode = "401", description = "사용자가 인증되지 않았습니다.")
    })
    @PostMapping("/settings/inquiry")
    public ResponseEntity<Void> uploadInquiry(
        @RequestBody InquiryDTO inquiry,
        HttpServletRequest request
    ) {
        User user = (User) request.getAttribute("user");
        inquirySvc.saveInquiry(user, inquiry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}