package com.game4men.aigroove.admin.controller;

import com.game4men.aigroove.admin.DTO.AdminResponse;
import com.game4men.aigroove.admin.service.AdminSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminSvc adminService;

    // 1. 관리자 조회
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAdmins() {
        Map<String, Object> response = new HashMap<>();
        List<AdminResponse> admins = adminService.findAllAdmins();
        response.put("result_code", 200);
        response.put("admins", admins);
        return ResponseEntity.ok(response);
    }

    // 2. 관리자 삭제(관리자 승인 거절)
    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteAdmin(@RequestParam("admin_id") Integer adminId) {
        Map<String, Object> response = new HashMap<>();
        try {
            adminService.deleteAdmin(adminId);
            response.put("result_code", 200);
            response.put("message", "관리자가 성공적으로 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            response.put("result_code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            response.put("result_code", 500);
            response.put("message", "관리자 삭제 중 오류가 발생했습니다.");
            return ResponseEntity.internalServerError().body(response);
        }
        return ResponseEntity.ok(response);
    }

    // 3. 관리자 승인
    @PostMapping("/accept")
    public ResponseEntity<Map<String, Object>> approveAdmin(@RequestParam("admin_id") Integer adminId) {
        Map<String, Object> response = new HashMap<>();
        try {
            adminService.approveAdmin(adminId);
            response.put("result_code", 200);
            response.put("message", "관리자 승인이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            response.put("result_code", 400);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            response.put("result_code", 500);
            response.put("message", "관리자 승인 중 오류가 발생했습니다.");
            return ResponseEntity.internalServerError().body(response);
        }
        return ResponseEntity.ok(response);
    }
} 