package com.game4men.aigroove.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "DailyLog")
@Getter @Setter
@NoArgsConstructor
public class DailyLog {
    @Id
    @Column(name = "log_date")
    private LocalDate logDate;

    @Column(name = "daily_users", nullable = false)
    private Integer dailyUsers;

    @Column(name = "song_uploads", nullable = false)
    private Integer songUploads;

    @Column(name = "inquirys", nullable = false)
    private Integer inquirys;
} 