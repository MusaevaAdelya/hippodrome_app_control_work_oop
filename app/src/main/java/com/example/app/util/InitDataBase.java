package com.example.app.util;

import com.example.app.entity.Horse;
import com.example.app.entity.User;
import com.example.app.enums.Role;
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
    CommandLineRunner initData(UserRepository userRepository, HorseRepository horseRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if(userRepository.findAll().size()==0){
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
            }

            if(horseRepository.findAll().size()==0){
                Horse horse1= Horse.builder()
                        .name("Apple Jack")
                        .build();

                Horse horse2= Horse.builder()
                        .name("Twilight Sparkle")
                        .winner(true)
                        .build();

                horse2.setWinner(true);

                horseRepository.saveAll(List.of(horse1,horse2));
            }



        };

    }
}