package com.pets.petsapi.api.adocao.dtos;

import com.pets.petsapi.api.pet.dtos.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoResponse {

  private Long id;
  private String email;
  private BigDecimal valor;
  private PetResponse pet;

}
