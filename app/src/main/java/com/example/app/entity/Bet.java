package com.example.app.entity;

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
    Horse horse;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

}
