package com.pets.petsapi.api.adocao.mappers;

import com.pets.petsapi.api.adocao.dtos.AdocaoRequest;
import com.pets.petsapi.api.adocao.dtos.AdocaoResponse;
import com.pets.petsapi.api.pet.mappers.PetMapper;
import com.pets.petsapi.core.model.Adocao;
import com.pets.petsapi.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdocaoMapper {

  @Autowired
  private PetRepository petRepository;

  @Autowired
  private PetMapper petMapper;

  public Adocao toModel(AdocaoRequest adocaoRequest){
//    var adocao = new Adocao();
//    adocao.setEmail(adocaoRequest.getEmail());
//    adocao.setValor(adocaoRequest.getValor());
//    adocao.setPet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()));
//    return adocao;
    return Adocao.builder()
            .email(adocaoRequest.getEmail())
            .valor(adocaoRequest.getValor())
            .pet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()))
            .build();
  }

  public AdocaoResponse toResponse(Adocao adocao){
//    var adocaoResponse = new AdocaoResponse();
//    adocaoResponse.setEmail(adocao.getEmail());
//    adocaoResponse.setId(adocao.getId());
//    adocaoResponse.setValor(adocao.getValor());
//    adocaoResponse.setPet(petMapper.toResponse(adocao.getPet()));
//    return adocaoResponse;

    return AdocaoResponse.builder()
            .email(adocao.getEmail())
            .id(adocao.getId())
            .valor(adocao.getValor())
            .pet(petMapper.toResponse(adocao.getPet()))
            .build();
  }

}
