package com.example.app.repository;

import com.example.app.entity.Bet;
import com.example.app.enums.BetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

    @Query(value="select exists(select * from bets where status='ACTIVE')", nativeQuery = true)
    boolean existsActiveBets();


    @Query(value="select b from Bet b where b.user.id=:userId and b.status=:status")
    List<Bet> findByUserIdAndStatus(Long userId, BetStatus status);


    @Query(value="select b from Bet b where b.status=:status")
    List<Bet> findByStatus(BetStatus status);
}
