package com.game4men.aigroove.game.service;
import com.game4men.aigroove.common.entity.User;
import com.game4men.aigroove.common.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ExampleSvc {
    
    private final UserRepository userRepository;
    
    @Autowired
    public ExampleSvc(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // 모든 상품 조회
    public List<User> getAllProducts() {
        return userRepository.findAll();
    }
    
    // 상품 저장 (생성 또는 수정)
    public User saveProduct(User product) {
        return userRepository.save(product);
    }
    
    // 상품 삭제
    public void deleteProduct(Long id) {
        //userRepository.deleteById(id);
    }
    
}
