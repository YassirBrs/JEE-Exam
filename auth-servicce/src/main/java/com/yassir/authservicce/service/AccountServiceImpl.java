package com.yassir.authservicce.service;

import com.yassir.authservicce.entities.AppRole;
import com.yassir.authservicce.entities.AppUser;
import com.yassir.authservicce.repository.AppRoleRepository;
import com.yassir.authservicce.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
    @Service
    @Transactional
    public class AccountServiceImpl implements AccountService {
        private AppUserRepository appUserRepository;
        private AppRoleRepository appRoleRepository;
        private PasswordEncoder passwordEncoder;

        public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository,
                                  PasswordEncoder passwordEncoder) {
            this.appUserRepository = appUserRepository;
            this.appRoleRepository = appRoleRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public AppUser addNewUser(AppUser appUser) {
            String password=appUser.getPassword();
            appUser.setPassword(passwordEncoder.encode(password));
            return appUserRepository.save(appUser);
        }

        @Override
        public AppRole addNewRole(AppRole appRole) {
            return appRoleRepository.save(appRole);
        }

        @Override
        public void addRoleToUser(String username, String roleName) {
            AppUser appUser=appUserRepository.findByUsername(username);
            AppRole appRole=appRoleRepository.findByRoleName(roleName);
            appUser.getAppRoles().add(appRole);
        }

        @Override
        public AppUser loadUserByUsername(String username) {
            return appUserRepository.findByUsername(username);
        }

        @Override
        public List<AppUser> listUsers() {
            return appUserRepository.findAll();
        }
    }
