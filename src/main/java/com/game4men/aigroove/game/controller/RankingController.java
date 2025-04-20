package com.game4men.aigroove.game.controller;
import com.game4men.aigroove.game.DTO.BadgeDTO;
import com.game4men.aigroove.game.DTO.RankingDTO;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game/ranking")
public class RankingController {

    @GetMapping()
    public ResponseEntity<List<RankingDTO>> getAllRankings(
        @RequestParam(required=true) String user_id
    ) {
        List<RankingDTO> list = new ArrayList<>();
        RankingDTO ranking1 = new RankingDTO();
        list.add(ranking1);

        return ResponseEntity.ok(list);
    }
}