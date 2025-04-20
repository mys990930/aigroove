package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Badge")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Badge {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "badge_id")
    private Integer badgeId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "badge_code", nullable = false)
    private Integer badgeCode;
    
    @Column(name = "current_value", nullable = false)
    private Integer currentValue;
    
    @Column(name = "has_achieved", nullable = false)
    private Boolean hasAchieved;
}