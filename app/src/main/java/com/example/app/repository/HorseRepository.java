package com.example.app.repository;

import com.example.app.entity.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Long> {
}
