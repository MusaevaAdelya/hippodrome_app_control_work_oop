package com.example.app.service;

import com.example.app.dto.HorseDTO;
import com.example.app.dto.RegisterHorse;
import com.example.app.entity.Horse;
import com.example.app.enums.HorseStatus;
import com.example.app.mapper.HorseMapper;
import com.example.app.repository.HorseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HorseService {
    private final HorseRepository horseRepository;
    private final HorseMapper horseMapper;

    public void registerNewHorse(RegisterHorse horse) {
        Horse newHorse= Horse.builder()
                .name(horse.getName())
                .build();

        horseRepository.save(newHorse);
    }

    public List<HorseDTO> getAllHorses() {
        return horseRepository.findByStatus(HorseStatus.ACTIVE)
                .stream().map(horseMapper::mapToHorseDTO).toList();
    }

    public HorseDTO getWinnerHorse() {
        Optional<Horse> winner=horseRepository.findWinnerHorse();
        if(winner.isEmpty()){
            return null;
        }else{
            return horseMapper.mapToHorseDTO(winner.get());
        }
    }
}
