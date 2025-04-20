package com.game4men.aigroove.game.controller;

import com.game4men.aigroove.game.DTO.UserDTO;
import com.game4men.aigroove.game.service.UserSvc;
import com.game4men.aigroove.game.DTO.LoginRequest;
import com.game4men.aigroove.common.repository.UserRepository;
import com.game4men.aigroove.game.DTO.JwtResponse;
import com.game4men.aigroove.common.entity.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/game/user")
@Tag(name = "사용자 관리", description = "사용자 관리 API")
public class UserController {
    private final UserRepository userRepository;
    
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    UserSvc userSvc;

    @Operation(
        summary = "로그인",
        description = "로그인 기능",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "로그인 성공",
                content = @Content(schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(responseCode = "401", description = "패스워드 오류")
        }
    )
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
        @RequestBody LoginRequest loginRequest
        ) {
        // LoginSvc를 통해 인증 및 JWT 토큰 생성
        String jwtToken = userSvc.login(loginRequest);
        JwtResponse jwtResponse = new JwtResponse(jwtToken, loginRequest.getUsername(), jwtToken);
        
        // 응답 반환
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(
        @RequestBody UserDTO request
    ) {
        try {
            userSvc.signup(request);
        } catch (Exception e) {
            System.err.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
        @RequestParam(required = true) String user_id
    ){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteAccount(
        @RequestParam(required = true) String user_id
    ){
        return ResponseEntity.ok().build();
    }
}
