package com.example.app.controller;

import com.example.app.dto.HorseDTO;
import com.example.app.dto.NewBetDTO;
import com.example.app.service.BetService;
import com.example.app.service.HorseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final BetService betService;
    private final HorseService horseService;

    @PostMapping("/make-bet")
    public ResponseEntity<Void> makeBet(@Valid @RequestBody NewBetDTO newBet, Authentication authentication) {
        betService.makeBet(newBet,authentication.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/all-horses")
    public ResponseEntity<List<HorseDTO>> seeAllRacingHorses(){
        return ResponseEntity.ok().body(horseService.getAllHorses());
    }
//
//    @GetMapping("/get/winner-horse")
//    public ResponseEntity<HorseDTO> getWinnerHorse(){
//        return ResponseEntity.ok().body(horseService.getWinnerHorse());
//    }
//
//    @GetMapping("/get/money")
//    public ResponseEntity<Integer> getWinnerHorse(Authentication authentication){
//        return ResponseEntity.ok().body(betService.getMoney(authentication.getName()));
//    }


}
