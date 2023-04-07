package com.example.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBetDTO {

    @NotNull(message = "horse id is required")
    @JsonProperty("horse_id")
    private Long horseId;

    @Positive(message="number has to be positive")
    @JsonProperty("money")
    private Integer money;

}
