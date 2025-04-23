package com.game4men.aigroove.admin.service;

import com.game4men.aigroove.admin.DTO.AdminResponse;
import com.game4men.aigroove.common.entity.Admin;
import com.game4men.aigroove.common.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminSvc {
    private final AdminRepository adminRepository;

    // 1. 관리자 조회
    @Transactional(readOnly = true)
    public List<AdminResponse> findAllAdmins() {
        return adminRepository.findAll().stream()
                .map(AdminResponse::new)
                .collect(Collectors.toList());
    }

    // 2. 관리자 탈퇴 , 관리자 승인 거절
    @Transactional
    public void deleteAdmin(Integer adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("해당 관리자를 찾을 수 없습니다. ID: " + adminId));
        
        adminRepository.delete(admin);
    }

    // 3. 관리자 승인
    @Transactional
    public void approveAdmin(Integer adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("해당 관리자를 찾을 수 없습니다"));
        
        if (admin.getSignupDate() != null) {
            throw new IllegalArgumentException("이미 승인된 관리자입니다.");
        }

        admin.setSignupDate(LocalDate.now());
        adminRepository.save(admin);
    }

    @Transactional(readOnly = true)
    public Admin findAdmin(Integer adminId) {
        return adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("해당 관리자를 찾을 수 없습니다. ID: " + adminId));
    }
} 