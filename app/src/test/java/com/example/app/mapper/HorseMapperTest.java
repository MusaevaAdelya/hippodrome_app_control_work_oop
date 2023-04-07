package com.example.app.mapper;

import com.example.app.dto.HorseDTO;
import com.example.app.entity.Horse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class HorseMapperTest {
    private HorseMapper mapper = Mappers.getMapper(HorseMapper.class);


    @Test
    void mapToHorseDTO() {
        Horse horse= Horse.builder()
                .id(1L)
                .name("Pinkie Pie")
                .build();

        HorseDTO horseDTO=mapper.mapToHorseDTO(horse);

        log.info(horseDTO.toString());
        log.info(horse.toString());

        assertEquals(horse.getId(),horseDTO.getId());
        assertEquals(horse.getName(),horseDTO.getName());
    }
}