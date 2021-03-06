package com.yassir.gestioncomptesoperations.dao;

import com.yassir.gestioncomptesoperations.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
  Compte findByClientId(Long idClient);
}

