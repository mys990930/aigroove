package com.game4men.aigroove.game.controller;
import com.game4men.aigroove.game.DTO.BadgeDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game/badge")
public class BadgeController {
    

    @GetMapping("/status/play")
    public ResponseEntity<List<BadgeDTO>> getCurrentBadgeStatus(
        @RequestParam(required=true) String user_id
    ) {
        List<BadgeDTO> list = new ArrayList<>();
        BadgeDTO badge1 = new BadgeDTO();
        list.add(badge1);

        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/status/all")
    public ResponseEntity<List<BadgeDTO>> getAllBadgeStatus(
        @RequestParam(required=true) String user_id
    ) {
        List<BadgeDTO> list = new ArrayList<>();
        BadgeDTO badge1 = new BadgeDTO();
        list.add(badge1);

        return ResponseEntity.ok(list);
    }

    @PutMapping("/status/play")
    public ResponseEntity<Void> updateBadgeStatus(
        @RequestParam(required=true) String user_id,
        @RequestBody List<BadgeDTO> request
    ) {
        return ResponseEntity.ok().build();
    }
}