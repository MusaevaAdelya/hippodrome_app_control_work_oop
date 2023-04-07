package com.example.app.repository;

import com.example.app.entity.Bet;
import com.example.app.entity.Horse;
import com.example.app.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BetRepositoryTest {

    @Autowired
    BetRepository betRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HorseRepository horseRepository;

    @AfterEach
    void tearDown(){
        betRepository.deleteAll();
    }

    @Test
    void existsActiveBets(){
        User user=User.builder()
                .username("adelya")
                .password("$2a$10$XA682wc8ukGqvPkc2Fae3eHOAzIfMvaGoefA6JhNUvMRcaCwnlvj2")
                .email("adelya@gmail.com")
                .build();

        Horse horse= Horse.builder()
                .name("Apple Jack")
                .build();

        User savedUser=userRepository.save(user);
        Horse savedHorse=horseRepository.save(horse);

        Bet bet= Bet.builder()
                .horse(savedHorse)
                .user(savedUser)
                .money(300)
                .build();

        Bet savedBet=betRepository.save(bet);

        boolean result= betRepository.existsActiveBets();

        assertTrue(result);


    }

}