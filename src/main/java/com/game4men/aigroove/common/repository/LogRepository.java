package com.game4men.aigroove.common.repository;

import com.game4men.aigroove.common.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log , Integer> {

}
