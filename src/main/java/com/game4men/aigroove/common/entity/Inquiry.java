package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Inquiry")
@Getter @Setter
@NoArgsConstructor
public class Inquiry {
    @Id
    @Column(name = "inquiry_id")
    private Integer inquiryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "is_answered", nullable = false)
    private Boolean isAnswered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answered_admin_id")
    private Admin answeredAdmin;
} 