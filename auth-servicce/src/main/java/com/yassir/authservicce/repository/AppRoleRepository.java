package com.yassir.authservicce.repository;

import com.yassir.authservicce.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}

