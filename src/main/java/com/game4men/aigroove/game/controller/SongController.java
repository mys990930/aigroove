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
@RequestMapping("/game/song")
public class SongController {

    // @GetMapping("/thumbnail")
    // public ResponseEntity<ThumbnailBinary> getThumbnail(
    //     @RequestParam(required=true) String query
    // ) {
    //     var response;
    //     return ResponseEntity.ok(response);
    // }

    // @PostMapping("/map_file", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    // public ResponseEntity<MapFile> login(
    //     @RequestParam String user_id
    //     ) {
    //     var response;
    //     // 응답 반환
    //     return ResponseEntity.ok(response);
    // }
}