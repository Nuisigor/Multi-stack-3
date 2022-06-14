package com.pets.petsapi.api.adocao.controller;

import com.pets.petsapi.api.adocao.dtos.AdocaoRequest;
import com.pets.petsapi.api.adocao.dtos.AdocaoResponse;
import com.pets.petsapi.api.adocao.services.AdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/adocoes")
public class AdocaoController {

  @Autowired
  private AdocaoService adocaoService;

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public AdocaoResponse create(@RequestBody @Valid AdocaoRequest adocaoRequest){
    return adocaoService.create(adocaoRequest);
  }

  @GetMapping
  public List<AdocaoResponse> findAll() {
    return adocaoService.findAll();
  }

}
