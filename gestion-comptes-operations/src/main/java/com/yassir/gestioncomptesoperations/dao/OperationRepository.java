package com.yassir.gestioncomptesoperations.dao;

import com.yassir.gestioncomptesoperations.entities.Compte;
import com.yassir.gestioncomptesoperations.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.PagedModel;

import java.util.List;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long> {
  Page<Operation> findOperationByCompte(Compte compte, Pageable pageable);
}
