package com.example.app.util;

import com.example.app.entity.Bet;
import com.example.app.entity.Horse;
import com.example.app.entity.User;
import com.example.app.enums.BetStatus;
import com.example.app.enums.Role;
import com.example.app.repository.BetRepository;
import com.example.app.repository.HorseRepository;
import com.example.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class InitDataBase {
    @Bean
    CommandLineRunner initData(UserRepository userRepository, HorseRepository horseRepository, BetRepository betRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if(userRepository.findAll().size()==0 && horseRepository.findAll().size()==0){
                User admin=User.builder()
                        .username("adelya")
                        .password(passwordEncoder.encode("123"))
                        .email("adelya@gmail.com")
                        .role(Role.ADMIN)
                        .build();

                User user=User.builder()
                        .username("msvadelya")
                        .password(passwordEncoder.encode("123"))
                        .email("msvadelya@gmail.com")
                        .build();

                userRepository.saveAll(List.of(admin,user));

                Horse horse1= Horse.builder()
                        .name("Apple Jack")
                        .build();

                Horse horse2= Horse.builder()
                        .name("Twilight Sparkle")
                        .winner(true)
                        .build();

                horse2.setWinner(true);

                horseRepository.saveAll(List.of(horse1,horse2));

                Bet bet= Bet.builder()
                        .user(admin)
                        .horse(horse1)
                        .money(300)
                        .status(BetStatus.CLOSED)
                        .build();

                Bet bet1= Bet.builder()
                        .user(admin)
                        .horse(horse2)
                        .money(500)
                        .status(BetStatus.CLOSED)
                        .build();

                betRepository.saveAll(List.of(bet,bet1));
            }



        };

    }
}