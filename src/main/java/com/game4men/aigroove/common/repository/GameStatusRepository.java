package com.game4men.aigroove.common.repository;

import com.game4men.aigroove.common.entity.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStatusRepository extends JpaRepository<GameStatus, Integer> {

} 