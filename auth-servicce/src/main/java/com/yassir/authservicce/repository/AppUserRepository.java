package com.yassir.authservicce.repository;

import com.yassir.authservicce.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
