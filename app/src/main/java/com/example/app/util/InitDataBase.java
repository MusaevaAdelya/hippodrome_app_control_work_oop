package com.example.app.util;

import com.example.app.entity.User;
import com.example.app.enums.Role;
import com.example.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitDataBase {
    @Bean
    CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if(userRepository.findByEmail("adelya@gmail.com").isEmpty()){
                User admin=User.builder()
                        .username("adelya")
                        .password(passwordEncoder.encode("123"))
                        .email("adelya@gmail.com")
                        .role(Role.ADMIN)
                        .build();

                userRepository.saveAndFlush(admin);
            }



        };

    }
}