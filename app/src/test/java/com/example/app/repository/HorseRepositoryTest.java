package com.example.app.repository;

import com.example.app.entity.Horse;
import com.example.app.enums.HorseStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
class HorseRepositoryTest {
    @Autowired
    HorseRepository horseRepository;

    @AfterEach
    void tearDown(){
        horseRepository.deleteAll();
    }


    @Test
    void findByStatus() {
        Horse horse1= Horse.builder()
                .name("Apple Jack")
                .build();

        Horse horse2= Horse.builder()
                .name("Pinkie Pie")
                .build();

        horseRepository.saveAll(List.of(horse1,horse2));

        List<Horse> result=horseRepository.findByStatus(HorseStatus.ACTIVE);

        log.info(result.toString());

        assertEquals(result.size(),2);
        assertEquals(result.get(0).getName(),horse1.getName());
    }

    @Test
    void findWinnerHorse(){
        Horse horse= Horse.builder()
                .name("Apple Jack")
                .winner(true)
                .build();

        horseRepository.save(horse);

        Optional<Horse> winner=horseRepository.findWinnerHorse();
        assertTrue(winner.isPresent());
        assertEquals(winner.get(),winner.get());
    }
}