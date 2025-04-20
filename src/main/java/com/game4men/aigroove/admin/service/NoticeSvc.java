package com.game4men.aigroove.admin.service;

import com.game4men.aigroove.common.entity.Admin;
import com.game4men.aigroove.common.entity.Notice;
import com.game4men.aigroove.common.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeSvc {
    private final NoticeRepository noticeRepository;

    // 1. 공지사항 목록 조회
    public List<Notice> findAllNotices() {
        return noticeRepository.findAll();
    }

    // 2. 공지사항 상세 조회
    public Notice findNotice(Integer noticeId) {
        return noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지사항입니다."));
    }

    // 3. 공지사항 작성
    @Transactional
    public Notice createNotice(String title, String content, Admin author) {
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setAuthor(author);
        notice.setCreatedAt(LocalDateTime.now());
        
        return noticeRepository.save(notice);
    }

    // 4. 공지사항 수정
    @Transactional
    public Notice updateNotice(Integer noticeId, String title, String content) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지사항입니다."));
        
        notice.setTitle(title);
        notice.setContent(content);
        
        return noticeRepository.save(notice);
    }

    // 5. 공지사항 삭제
    @Transactional
    public void deleteNotice(Integer noticeId) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지사항입니다."));
        
        noticeRepository.delete(notice);
    }
} 