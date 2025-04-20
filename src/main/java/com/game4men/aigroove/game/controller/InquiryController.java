package com.game4men.aigroove.game.controller;
import com.game4men.aigroove.game.DTO.InquiryDTO;

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
@RequestMapping("/game")
public class InquiryController {
        
    @PostMapping("/settings/inquiry")
    public ResponseEntity<Void> uploadInquiry(
        @RequestParam(required = true) String user_id,
        @RequestBody InquiryDTO inquiry
    ) {
        //upload inquiry to db
        return ResponseEntity.ok().build();
    }
}