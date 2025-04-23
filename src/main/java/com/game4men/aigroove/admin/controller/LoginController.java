package com.game4men.aigroove.admin.controller;

import com.game4men.aigroove.admin.DTO.LoginRequest;
import com.game4men.aigroove.admin.DTO.LoginResponse;
import com.game4men.aigroove.admin.DTO.SignupRequest;
import com.game4men.aigroove.admin.DTO.SignupResponse;
import com.game4men.aigroove.admin.service.LoginSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginSvc loginSvc;

    /* 1. 로그인 요청 */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        System.out.println(request.getPassword() + " " + request.getUsername());
        return loginSvc.login(request);
    }

    /* 2. 회원가입 요청 */
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        return loginSvc.signup(request);
    }

    /* 3. 로그아웃 기능 처리 */
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout() {
        Map<String, Object> response = new HashMap<>();
        try {
            // 여기에 로그아웃 관련 추가 로직이 필요하다면 구현
            response.put("result_code", 200);
            response.put("message", "Logout successful");
        } catch (Exception e) {
            response.put("result_code", 400);
            response.put("message", "Logout failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}