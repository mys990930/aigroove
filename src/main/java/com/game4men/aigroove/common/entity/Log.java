package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "Log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Integer logId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "log_time", nullable = false)
    private LocalDateTime logTime;
    
    @Column(name = "log_level", nullable = false)
    private Integer logLevel;
    
    @Column(name = "message", length = 256, nullable = false)
    private String message;
}