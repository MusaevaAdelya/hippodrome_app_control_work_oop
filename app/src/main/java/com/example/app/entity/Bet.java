package com.example.app.entity;

import com.example.app.enums.BetStatus;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "horse_id", referencedColumnName = "id")
    private Horse horse;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private BetStatus status=BetStatus.ACTIVE;

    private Integer money;

}
