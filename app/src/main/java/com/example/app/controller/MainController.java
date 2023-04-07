package com.example.app.controller;

import com.example.app.service.BetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final BetService betService;

    @PostMapping("/make-bet/{horse_id}")
    public ResponseEntity<Void> makeBet(@PathVariable(name="horse_id") Long horseId, Authentication authentication) {
        betService.makeBet(horseId,authentication.getName());
        return ResponseEntity.ok().build();
    }
}
