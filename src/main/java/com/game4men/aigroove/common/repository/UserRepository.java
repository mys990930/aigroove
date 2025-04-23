package com.game4men.aigroove.common.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game4men.aigroove.common.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String Username);
    List<User> findByUsernameContainingOrNicknameContainingOrEmailContaining(
            String username, String nickname, String email);
}