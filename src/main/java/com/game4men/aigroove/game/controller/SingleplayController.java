package com.game4men.aigroove.game.controller;
import com.game4men.aigroove.game.DTO.GameRoomDTO;
import com.game4men.aigroove.game.DTO.PlayResultDTO;
import com.game4men.aigroove.game.DTO.PlayStatusDTO;

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
@RequestMapping("/game/play/single")
public class SingleplayController {
    
    @GetMapping("/room")
    public ResponseEntity<GameRoomDTO> getRoom(
        @RequestParam(required=true) String user_id,
        @RequestParam(required=true) String room_code
    ) {
        GameRoomDTO dto = new GameRoomDTO();
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/result")
    public ResponseEntity<Void> addPlayResult(
        @RequestParam(required=true) String user_id,
        @RequestBody PlayResultDTO playResult
    ) {
        // 응답 반환
        return ResponseEntity.ok().build();
    }
}