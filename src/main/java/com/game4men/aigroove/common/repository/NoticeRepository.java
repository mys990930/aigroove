package com.game4men.aigroove.common.repository;

import com.game4men.aigroove.common.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    List<Notice> findByAuthorAdminIdOrderByCreatedAtDesc(Integer adminId);
} 