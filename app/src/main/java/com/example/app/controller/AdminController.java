package com.example.app.controller;

import com.example.app.dto.BetDTO;
import com.example.app.dto.RegisterHorse;
import com.example.app.service.BetService;
import com.example.app.service.HorseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {
    private final HorseService horseService;
    private final BetService betService;

    @PostMapping("/add/horse")
    public ResponseEntity<Void> addNewHorse(@Valid @RequestBody RegisterHorse horse) {
        horseService.registerNewHorse(horse);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/get/all-bets")
//    public ResponseEntity<List<BetDTO>> getAllActiveBets(){
//
//        ResponseEntity.ok().body(betService.getAllBets());
//    }

}
