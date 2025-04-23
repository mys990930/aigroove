package com.game4men.aigroove.game.controller;

import com.game4men.aigroove.game.DTO.*;
import com.game4men.aigroove.game.service.MiscSvc;
import com.game4men.aigroove.admin.service.NoticeSvc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.game4men.aigroove.common.entity.Notice;
import com.game4men.aigroove.common.entity.User;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@Tag(name = "기타 API", description = "기타 API")
public class MiscController {
    @Autowired
    MiscSvc inquirySvc;
    @Autowired
    NoticeSvc noticeSvc;

    @Operation(summary = "공지사항 가져오기 [토큰 불필요]", description = "가장 최근의 공지사항을 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "공지사항 반환 성공"),
            @ApiResponse(responseCode = "400", description = "오류")
    })
    @PostMapping("/notice")
    public ResponseEntity<NoticeDTO> getRecentNotice() 
    {                
        NoticeDTO dto = new NoticeDTO();
        try {
            Notice notice = noticeSvc.findRecentNotice();
            dto.setAuthor_id(notice.getAuthor().getAdminId());
            dto.setTitle(notice.getTitle());
            dto.setContent(notice.getContent());
            dto.setCreatedAt(notice.getCreatedAt());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "문의 등록", description = "문의를 DB에 등록하여 관리자가 열람할 수 있게 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "문의 등록 성공"),
            @ApiResponse(responseCode = "400", description = "오류"),
            @ApiResponse(responseCode = "401", description = "사용자가 인증되지 않았습니다.")
    })
    @PostMapping("/settings/inquiry")
    public ResponseEntity<Void> uploadInquiry(
            @RequestBody InquiryDTO inquiry,
            HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        inquirySvc.saveInquiry(user, inquiry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}