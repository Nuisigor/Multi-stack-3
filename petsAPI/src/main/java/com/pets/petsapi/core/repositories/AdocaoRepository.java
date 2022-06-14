package com.pets.petsapi.core.repositories;

import com.pets.petsapi.core.model.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
}
