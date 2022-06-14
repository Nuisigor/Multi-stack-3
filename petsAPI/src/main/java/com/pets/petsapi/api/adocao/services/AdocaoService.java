package com.pets.petsapi.api.adocao.services;

import com.pets.petsapi.api.adocao.dtos.AdocaoRequest;
import com.pets.petsapi.api.adocao.dtos.AdocaoResponse;
import com.pets.petsapi.api.adocao.mappers.AdocaoMapper;
import com.pets.petsapi.core.repositories.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdocaoService {

  @Autowired
  private AdocaoRepository adocaoRepository;

  @Autowired
  private AdocaoMapper adocaoMapper;


  public AdocaoResponse create(AdocaoRequest adocaoRequest){
    var adocaoToCreate = adocaoMapper.toModel(adocaoRequest);
    var createdAdocao = adocaoRepository.save(adocaoToCreate);
    return adocaoMapper.toResponse(createdAdocao);
  }

  public List<AdocaoResponse> findAll(){
    return adocaoRepository.findAll()
            .stream().map(adocaoMapper::toResponse)
            .collect(Collectors.toList());
  }

}
