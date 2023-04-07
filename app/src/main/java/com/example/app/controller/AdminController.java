package com.example.app.controller;

import com.example.app.dto.BetDTO;
import com.example.app.dto.BetResultDTO;
import com.example.app.dto.RegisterHorse;
import com.example.app.entity.User;
import com.example.app.enums.BetStatus;
import com.example.app.mapper.BetResultMapper;
import com.example.app.repository.BetRepository;
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
    private final BetRepository betRepository;
    private final BetResultMapper betResultMapper;

    @PostMapping("/add/horse")
    public ResponseEntity<Void> addNewHorse(@Valid @RequestBody RegisterHorse horse) {
        horseService.registerNewHorse(horse);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/all-bets")
    public ResponseEntity<List<BetDTO>> getAllActiveBets(){
        return ResponseEntity.ok().body(betService.getAllBets());

    }

    @PostMapping("/close/racing")
    public ResponseEntity<Void> closeRacing(){
        betService.closeRacing();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/calc/bet-money")
    public ResponseEntity<List<BetResultDTO>> calcResultMoney(){
        List<User> users=betRepository.getBetUsersByStatus(BetStatus.CLOSED);
        List<BetResultDTO> result=users.stream().map(betResultMapper::map).toList();
        return ResponseEntity.ok().body(result);
    }



}
