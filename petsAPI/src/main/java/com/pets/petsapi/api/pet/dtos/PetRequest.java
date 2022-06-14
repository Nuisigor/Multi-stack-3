package com.pets.petsapi.api.pet.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {

  @Size(max = 255)
  @NotNull
  @NotEmpty
  private String nome;

  @Size(max = 255)
  @NotNull
  @NotEmpty
  private String historia;

  @URL
  @Size(max = 255)
  @NotNull
  @NotEmpty
  private String foto;

}
