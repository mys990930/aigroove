package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GameRoom")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameRoom {
    
    @Id
    @Column(name = "room_code", length = 5)
    private String roomCode;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    private User host;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", nullable = false)
    private User guest;
    
    @Column(name = "has_guest", nullable = false)
    private Boolean hasGuest;
    
    @Column(name = "is_download_complete", nullable = false)
    private Boolean isDownloadComplete;
    
    @Column(name = "is_game_started", nullable = false)
    private Boolean isGameStarted;
}