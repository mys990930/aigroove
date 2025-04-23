package com.game4men.aigroove.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Inquiry")
@Getter @Setter
@NoArgsConstructor
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private Integer inquiryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

//    @JsonProperty("isAnswered")
    @Column(name = "is_answered", nullable = false)
    private Boolean answered;

    @Column(name = "inquiry_date", nullable = false)
    private LocalDate inquiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answered_admin_id")
    private Admin answeredAdmin;
} 