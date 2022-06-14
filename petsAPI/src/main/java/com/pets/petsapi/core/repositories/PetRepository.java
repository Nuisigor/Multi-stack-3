package com.pets.petsapi.core.repositories;

import com.pets.petsapi.core.exceptions.PetNotFoundException;
import com.pets.petsapi.core.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Long> {

  default Pet findByIdOrElseThrow(Long id){
//    var petOptional = findById(id);
//    if(petOptional.isPresent())
//      return petOptional.get();
//    throw new PetNotFoundException();

//    return findById(id).orElseThrow(() -> new PetNotFoundException());

      return findById(id).orElseThrow(PetNotFoundException::new);
  }

}
