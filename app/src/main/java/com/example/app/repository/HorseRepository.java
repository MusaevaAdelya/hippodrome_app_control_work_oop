package com.example.app.repository;

import com.example.app.entity.Horse;
import com.example.app.enums.HorseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Long> {
    List<Horse> findByStatus(HorseStatus status);
}
