package com.inonusosyal.api.service;

import com.inonusosyal.api.entity.Enums.Role;
import com.inonusosyal.api.entity.UserEntity;
import com.inonusosyal.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final IUserRepository repo;

    @Autowired
    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    public Optional<UserEntity> getUserById(String userid) {
        UUID uuid;
        try {
            uuid = UUID.fromString(userid);
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
        return repo.findById(uuid);
    }

    public Optional<UserEntity> addUser(UserEntity user) {
        if (repo.findByEmail(user.getEmail()) != null || repo.findByEmail(user.getEmail()) != null) {
            return Optional.empty();
        }
        if (emailCheck(user.getEmail())) {
            user.setRole(getUserRoleByEmail(user.getEmail()));
            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return Optional.of(repo.save(user));
        } else {
            return Optional.empty();
        }
    }

    private Role getUserRoleByEmail(String email) {
        return email.contains("ogr") ? Role.STUDENT : Role.ACADEMICIAN;
    }

    private boolean emailCheck(String email) {
        email = email.substring(email.indexOf("@") + 1);
        String domain = "inonu.edu.tr";
        if (email.contains("ogr")) {
            domain = "ogr." + domain;
        }
        return email.equals(domain);
    }

}
