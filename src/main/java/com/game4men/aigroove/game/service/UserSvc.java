package com.game4men.aigroove.game.service;
import com.game4men.aigroove.common.entity.User;
import com.game4men.aigroove.common.repository.UserRepository;
import com.game4men.aigroove.common.utils.JwtUtils;
import com.game4men.aigroove.game.DTO.LoginRequest;
import com.game4men.aigroove.game.DTO.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserSvc(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }
    
    public String login(LoginRequest loginRequest) {
        
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found with username: " + loginRequest.getUsername()));
        
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getHashed_password())) {
            throw new RuntimeException("Invalid password");
        }    

        // 인증 성공 - JWT 토큰 생성 및 반환
        return jwtUtils.generateToken(user.getUsername());
    }

    public void signup(UserDTO request){
        
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setHashed_password(passwordEncoder.encode(request.getPassword()));
        user.setNickname(request.getNickname());
        
        userRepository.save(user);
    }

    public void deleteAccount(int user_id){
        userRepository.deleteById(user_id);
    }
}