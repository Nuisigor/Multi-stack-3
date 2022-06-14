package com.pets.petsapi.api.pet.services;


import com.pets.petsapi.api.pet.dtos.PetRequest;
import com.pets.petsapi.api.pet.dtos.PetResponse;
import com.pets.petsapi.api.pet.mappers.PetMapper;
import com.pets.petsapi.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

  @Autowired
  private PetRepository petRepository;

  @Autowired
  private PetMapper petMapper;

  public List<PetResponse> findAll(){
//    var pets = petRepository.findAll();
//    var petResponse = new ArrayList<PetResponse>();
//    for (Pet pet : pets){
//      petResponse.add(petMapper.toResponse(pet));
//    }
//    return petResponse;

//    return petRepository.findAll().stream().map((pet) -> petMapper.toResponse(pet)).collect(Collectors.toList());
    return petRepository
            .findAll()
            .stream()
            .map(petMapper::toResponse)
            .collect(Collectors.toList());
  }

  public PetResponse create(PetRequest petRequest){
    var petCreate = petMapper.toModel(petRequest);
    var createdPet = petRepository.save(petCreate);
    return petMapper.toResponse(createdPet);
  }

}
