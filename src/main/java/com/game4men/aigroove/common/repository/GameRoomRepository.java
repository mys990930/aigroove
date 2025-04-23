package com.game4men.aigroove.common.repository;

import com.game4men.aigroove.common.entity.GameRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoomRepository extends JpaRepository<GameRoom, String> {

} 