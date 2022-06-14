package com.pets.petsapi.api.adocao.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pets.petsapi.api.pet.validators.PetExistsById;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoRequest {

  @Email
  @Size(max = 255)
  @NotNull
  @NotEmpty
  private String email;

  @NotNull
  @Min(50)
  @Max(200)
  private BigDecimal valor;

  @NotNull
  @Positive
  @PetExistsById
  @JsonProperty("pet_id")
  private Long petId;
}
