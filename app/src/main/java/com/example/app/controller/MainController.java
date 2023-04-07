package com.example.app.controller;

import com.example.app.dto.NewBetDTO;
import com.example.app.service.BetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final BetService betService;

    @PostMapping("/make-bet")
    public ResponseEntity<Void> makeBet(@Valid @RequestBody NewBetDTO newBet, Authentication authentication) {
        betService.makeBet(newBet,authentication.getName());
        return ResponseEntity.ok().build();
    }
}
