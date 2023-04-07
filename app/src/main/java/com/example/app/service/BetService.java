package com.example.app.service;

import com.example.app.entity.Bet;
import com.example.app.entity.Horse;
import com.example.app.entity.User;
import com.example.app.repository.BetRepository;
import com.example.app.repository.HorseRepository;
import com.example.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetService {
    private final UserRepository userRepository;
    private final HorseRepository horseRepository;
    private final BetRepository betRepository;

    public void makeBet(Long horseId, String email, Integer money) {
        User user=userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("user not found: "+email));
        Horse horse=horseRepository.findById(horseId)
                .orElseThrow(()->new IllegalArgumentException(String.format("Horse with id %s not found",horseId)));

        Bet newBet= Bet.builder()
                .horse(horse)
                .user(user)
                .money(money)
                .build();

        betRepository.save(newBet);


    }
}
