package com.game4men.aigroove.admin.service;


import com.game4men.aigroove.admin.DTO.LoginRequest;
import com.game4men.aigroove.admin.DTO.LoginResponse;
import com.game4men.aigroove.admin.DTO.SignupRequest;
import com.game4men.aigroove.admin.DTO.SignupResponse;
import com.game4men.aigroove.common.entity.Admin;
import com.game4men.aigroove.common.repository.AdminRepository;
import com.game4men.aigroove.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoginSvc {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtil;

    /* 1. 로그인 처리 */
    public ResponseEntity<LoginResponse> login(LoginRequest request) {
        Admin admin = adminRepository.findByUsername(request.getUsername())
                .orElse(null);

        System.out.println(request.getPassword() + " " + request.getUsername());
        System.out.println(admin.getHashedPassword() + " " + admin.getUsername());
        if (admin == null || !passwordEncoder.matches(request.getPassword(), admin.getHashedPassword())) {
            System.out.println("인증 실패");
            return ResponseEntity.ok(new LoginResponse(401, "")); // 인증 실패
        }

        String token = jwtUtil.generateToken(admin.getUsername());
        return ResponseEntity.ok(new LoginResponse(201, token)); // 성공
    }

    /* 2. 회원가입 처리 */
    public ResponseEntity<SignupResponse> signup(SignupRequest request) {
        // 1. 아이디 중복 체크
        if (adminRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.ok(new SignupResponse(409)); // 중복된 아이디
        }

        // 2. 새로운 관리자 생성
        Admin admin = new Admin();
        admin.setUsername(request.getUsername());
        admin.setHashedPassword(passwordEncoder.encode(request.getPassword()));
        admin.setName(request.getName());
        admin.setBirth(request.getBirth());
        admin.setSignupDate(LocalDate.now());

        // 3. 관리자 ID 생성 (마지막 ID + 1)
        Integer lastAdminId = adminRepository.findTopByOrderByAdminIdDesc()
                .map(Admin::getAdminId)
                .orElse(0);
        admin.setAdminId(lastAdminId + 1);

        // 4. 저장
        adminRepository.save(admin);

        return ResponseEntity.ok(new SignupResponse(201)); // 성공
    }
} 