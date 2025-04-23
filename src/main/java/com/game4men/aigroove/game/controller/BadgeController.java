package com.game4men.aigroove.game.controller;
import com.game4men.aigroove.game.DTO.BadgeDTO;
import com.game4men.aigroove.game.DTO.JwtResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game/badge")
@Tag(name = "o[개발중]뱃지 API", description = "뱃지 관련 API")
public class BadgeController {   

    @Operation(summary = "현재 뱃지 상태 가져오기", description = "badge_id 에 해당하는 뱃지 상태를 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BadgeDTO.class)))),
            @ApiResponse(responseCode = "400", description = "오류")
    })
    @GetMapping("/status/play")
    public ResponseEntity<List<BadgeDTO>> getCurrentBadgeStatus(
        @RequestParam(name = "badge_id", required=true) String badge_id,
        HttpServletRequest request
    ) {
        List<BadgeDTO> list = new ArrayList<>();
        BadgeDTO badge1 = new BadgeDTO();
        list.add(badge1);

        return ResponseEntity.ok(list);
    }
    
    @Operation(summary = "모든 뱃지 상태 가져오기", description = "모든 뱃지 상태를 반환합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공", content = @Content(array = @ArraySchema(schema = @Schema(implementation = BadgeDTO.class)))),
        @ApiResponse(responseCode = "400", description = "오류")
    })
    @GetMapping("/status/all")
    public ResponseEntity<List<BadgeDTO>> getAllBadgeStatus(
        HttpServletRequest request) 
    {
        List<BadgeDTO> list = new ArrayList<>();
        BadgeDTO badge1 = new BadgeDTO();
        list.add(badge1);

        return ResponseEntity.ok(list);
    }

    @Operation(summary = "뱃지 상태 업데이트", description = "뱃지 리스트를 통해 뱃지 상태를 업데이트합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공", content = @Content(schema = @Schema(implementation = JwtResponse.class))),
            @ApiResponse(responseCode = "401", description = "패스워드 오류")
    })
    @PutMapping("/status/play")
    public ResponseEntity<Void> updateBadgeStatus(
        @RequestBody List<BadgeDTO> badgeStatus,
        HttpServletRequest request
    ) {
        return ResponseEntity.ok().build();
    }
}