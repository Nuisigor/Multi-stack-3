package com.pets.petsapi.api.pet.controller;

import com.pets.petsapi.api.pet.dtos.PetRequest;
import com.pets.petsapi.api.pet.dtos.PetResponse;
import com.pets.petsapi.api.pet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

  @Autowired
  private PetService petService;

  @GetMapping
  public List<PetResponse> findAll(){
    return petService.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PetResponse create(@RequestBody @Valid PetRequest petRequest) {
    return petService.create(petRequest);
  }
}
