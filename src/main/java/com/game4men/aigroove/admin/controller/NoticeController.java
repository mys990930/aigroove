package com.game4men.aigroove.admin.controller;

import com.game4men.aigroove.common.entity.Admin;
import com.game4men.aigroove.common.entity.Notice;
import com.game4men.aigroove.admin.service.AdminSvc;
import com.game4men.aigroove.admin.service.NoticeSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notices")
public class NoticeController {
    private final NoticeSvc noticeService;
    private final AdminSvc adminService;

    // 1. 공지사항 목록 조회
    @GetMapping
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.findAllNotices();
        return ResponseEntity.ok(notices);
    }

    // 2. 공지사항 상세 조회
    @GetMapping("/{noticeId}")
    public ResponseEntity<Notice> getNotice(@PathVariable Integer noticeId) {
        Notice notice = noticeService.findNotice(noticeId);
        return ResponseEntity.ok(notice);
    }

    // 3. 공지사항 작성
    @PostMapping
    public ResponseEntity<Notice> createNotice(
            @RequestBody Map<String, String> request,
            @RequestAttribute("adminId") Integer adminId) {
        Admin author = adminService.findAdmin(adminId);
        Notice notice = noticeService.createNotice(
                request.get("title"),
                request.get("content"),
                author
        );
        return ResponseEntity.ok(notice);
    }

    // 4. 공지사항 수정
    @PutMapping("/{noticeId}")
    public ResponseEntity<Notice> updateNotice(
            @PathVariable Integer noticeId,
            @RequestBody Map<String, String> request) {
        Notice notice = noticeService.updateNotice(
                noticeId,
                request.get("title"),
                request.get("content")
        );
        return ResponseEntity.ok(notice);
    }

    // 5. 공지사항 삭제
    @DeleteMapping("/{noticeId}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Integer noticeId) {
        noticeService.deleteNotice(noticeId);
        return ResponseEntity.ok().build();
    }
} 