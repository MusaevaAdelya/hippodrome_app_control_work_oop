package com.example.app.service;

import com.example.app.dto.NewBetDTO;
import com.example.app.entity.Bet;
import com.example.app.entity.Horse;
import com.example.app.entity.User;
import com.example.app.enums.BetStatus;
import com.example.app.repository.BetRepository;
import com.example.app.repository.HorseRepository;
import com.example.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class BetService {
    private final UserRepository userRepository;
    private final HorseRepository horseRepository;
    private final BetRepository betRepository;
    private final HorseService horseService;

    public void makeBet(NewBetDTO newBetDTO, String email) {
        User user=userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("user not found: "+email));
        Horse horse=horseRepository.findById(newBetDTO.getHorseId())
                .orElseThrow(()->new IllegalArgumentException(String.format("Horse with id %s not found",newBetDTO.getHorseId())));

        Bet newBet= Bet.builder()
                .horse(horse)
                .user(user)
                .money(newBetDTO.getMoney())
                .build();

        betRepository.save(newBet);


    }

    public Integer getMoney(String email) {
        User user= userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("no user found with email "+email));

        if(betRepository.existsActiveBets()){
            return null;
        }else{
            List<Bet> userBets=betRepository.findByUserIdAndStatus(user.getId(), BetStatus.CLOSED);
            Long winnerHorseId=horseService.getWinnerHorse().getId();
            return calcBetMoney(userBets,winnerHorseId);
        }

    }

    private Integer calcBetMoney(List<Bet> bets, Long winnerId){
        AtomicReference<Integer> result= new AtomicReference<>(0);
        bets.forEach(bet -> {
            if(!Objects.equals(bet.getHorse().getId(), winnerId)){
                result.updateAndGet(v -> v - bet.getMoney());
            }else{
                result.updateAndGet(v->v+bet.getMoney());
            }

        });

        return result.get();
    }
}
