package com.game4men.aigroove.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GameRoom")
@Getter @Setter
@NoArgsConstructor
public class GameRoom {
    @Id
    @Column(name = "room_code", length = 5)
    private String roomCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id")
    private User host;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private User guest;

    @Column(name = "has_guest", nullable = false)
    private Boolean hasGuest;

    @Column(name = "is_download_complete", nullable = false)
    private Boolean isDownloadComplete;

    @Column(name = "is_game_started", nullable = false)
    private Boolean isGameStarted;

    @Column(name = "playfile_uri", nullable = false, length = 256)
    private String playfileUri;
} 