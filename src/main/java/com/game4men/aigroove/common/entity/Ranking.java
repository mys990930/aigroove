package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ranking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {
    
    @Id
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "nickname", length = 20, nullable = false)
    private String nickname;
    
    @Column(name = "rank", nullable = false)
    private Integer rank;
    
    @Column(name = "badge_number", nullable = false)
    private Integer badgeNumber;
    
    @Column(name = "calculated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime calculatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false),
        @JoinColumn(name = "nickname", referencedColumnName = "nickname", insertable = false, updatable = false)
    })
    private User user;
}