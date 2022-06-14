package com.pets.petsapi;

import com.pets.petsapi.core.model.Pet;
import com.pets.petsapi.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetsApiApplication implements CommandLineRunner {

  @Autowired
  private PetRepository petRepository;

  public static void main(String[] args) {
    SpringApplication.run(PetsApiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    var pet = new Pet();
    pet.setNome("Bidu");
    pet.setHistoria("Qualquer coisa");
    pet.setFoto("https://www.petlove.com.br/dicas/wp-content/uploads/2019/12/border-collie-petlove.jpg");
    petRepository.save(pet);
  }
}
