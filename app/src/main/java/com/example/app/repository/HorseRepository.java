package com.example.app.repository;

import com.example.app.entity.Horse;
import com.example.app.enums.HorseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Long> {
    List<Horse> findByStatus(HorseStatus status);

    @Query(value = "select * from horses where winner=true  order by id desc limit 1", nativeQuery = true)
    Optional<Horse> findWinnerHorse();


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update horses set winner=true where id = (select id from horses offset random() * (select count(*) from horses) limit 1)", nativeQuery = true)
    void setRandomHorseWinner();
}
