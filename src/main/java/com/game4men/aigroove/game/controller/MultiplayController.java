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
@RequestMapping("/game/play/multi")
public class MultiplayController {
    
    @GetMapping("/room")
    public ResponseEntity<GameRoomDTO> getRoom(
        @RequestParam(required=true) String user_id,
        @RequestParam(required=true) String room_code
    ) {
        GameRoomDTO dto = new GameRoomDTO();

        return ResponseEntity.ok(dto);
    }

    // @GetMapping("/play_file")
    // public ResponseEntity<PlayFile> getPlayFile(
    //     @RequestParam(required=true) String user_id,
    //     @RequestParam(required=true) String room_code
    // ) {
    //     var response;
    //     return ResponseEntity.ok(response);
    // }

    @GetMapping("/room/status")
    public ResponseEntity<GameRoomDTO> getRoomStatus(
        @RequestParam(required=true) String user_id,
        @RequestParam(required=true) String room_code
    ) {
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/result")
    public ResponseEntity<Void> addPlayResult(
        @RequestParam(required=true) String user_id,
        @RequestBody PlayResultDTO playResult
    ) {        
        // 응답 반환
        return ResponseEntity.ok().build();
    }
    
    // @PostMapping("/room/play_file")
    // public ResponseEntity<Void> uploadPlayFile(
    //     @RequestParam(required=true) String user_id,
    //     @RequestBody PlayFile playFile
    // ) {
    //     var response;
        
    //     // 응답 반환
    //     return ResponseEntity.ok(response);
    // }

    @PostMapping("/room/game_status")
    public ResponseEntity<PlayStatusDTO> addPlayResult(
        @RequestParam(required=true) String user_id,
        @RequestParam(required=true) String room_code,
        @RequestBody PlayStatusDTO playStatus
    ) {
        PlayStatusDTO dto = new PlayStatusDTO();
        // 응답 반환
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/room/status")
    public ResponseEntity<Void> updateRoomStatus(
        @RequestParam(required=true) String user_id,
        @RequestParam(required=true) String room_code,
        @RequestBody GameRoomDTO gameRoom
    ) {
        
        // 응답 반환
        return ResponseEntity.ok().build();
    }

    @PutMapping("/room/game_start")
    public ResponseEntity<Void> startGame(
        @RequestParam(required=true) String user_id,
        @RequestParam(required=true) String room_code
    ) {
        
        // 응답 반환
        return ResponseEntity.ok().build();
    }
}