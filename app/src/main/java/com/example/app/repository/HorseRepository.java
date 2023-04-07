package com.example.app.repository;

import com.example.app.entity.Horse;
import com.example.app.enums.HorseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Long> {
    List<Horse> findByStatus(HorseStatus status);

    @Query(value = "select * from horses where winner=true  order by id desc limit 1", nativeQuery = true)
    Optional<Horse> findWinnerHorse();
}
