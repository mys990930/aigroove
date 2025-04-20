package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GameStatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameStatus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer statusId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_code", nullable = false)
    private GameRoom gameRoom;
    
    @Column(name = "current_progress", nullable = false)
    private Float currentProgress;
    
    @Column(name = "last_checkpoint", nullable = false)
    private Float lastCheckpoint;
    
    @Column(name = "deaths", nullable = false)
    private Integer deaths;
    
    @Column(name = "has_cleared", nullable = false)
    private Boolean hasCleared;
}