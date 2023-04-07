package com.example.app.service;

import com.example.app.dto.RegisterHorse;
import com.example.app.entity.Horse;
import com.example.app.repository.HorseRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HorseService {
    HorseRepository horseRepository;

    public void registerNewHorse(RegisterHorse horse) {
        Horse newHorse= Horse.builder()
                .name(horse.getName())
                .build();

        horseRepository.save(newHorse);
    }
}
