package com.example.app.entity;

import com.example.app.enums.HorseStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "horses")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="name is required")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @Builder.Default
    private HorseStatus status=HorseStatus.ACTIVE;

    @Builder.Default
    private Boolean winner=false;
}
