package com.game4men.aigroove.game.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
        
    @GetMapping("/hello")
    public String hello(
        ) {
            return "hello";
    }
}
