package com.game4men.aigroove.common.repository;

import com.game4men.aigroove.common.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    int countByUser_UserId(Integer userId);
} 