package com.inonusosyal.api.service;

import com.inonusosyal.api.dto.UserProfileDto;
import com.inonusosyal.api.entity.ConfirmationToken;
import com.inonusosyal.api.entity.Enums.Role;
import com.inonusosyal.api.entity.UserEntity;
import com.inonusosyal.api.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final IUserRepository repo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    public UserProfileDto getUserProfileById(String userid) {
        UUID uuid;
        try {
            uuid = UUID.fromString(userid);
        } catch (IllegalArgumentException ex) {
            return null;
        }
        Optional<UserEntity> userEntity = repo.findById(uuid);
        if (!userEntity.isEmpty()) {
           return new UserProfileDto(userEntity.get(),repo.getUserFollowers(uuid),repo.getUserFollowed(uuid));
        }
        return null;
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

    public Optional<UserEntity> getUserByEmail(String email){
        return repo.findByEmail(email);
    }

    public Optional<UserEntity> getEmailByUsername(String username){
        return repo.getEmailByUsername(username);
    }

    public String addUser(UserEntity user) {
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken!");
        } else {
            if (repo.findByUsername(user.getUsername()).isPresent()) {
                throw new IllegalStateException("Username already taken!");
            } else {
                if (emailCheck(user.getEmail())) {
                    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
                    user.setPassword(encodedPassword);
                    user.setRole(getUserRoleByEmail(user.getEmail()));
                    user.setCreatedAt(LocalDateTime.now());
                    user.setUpdatedAt(LocalDateTime.now());
                    repo.save(user);
                    String token = UUID.randomUUID().toString();
                    ConfirmationToken confirmationToken = new ConfirmationToken(
                            token,
                            LocalDateTime.now(),
                            LocalDateTime.now().plusMinutes(15),
                            user
                    );
                    confirmationTokenService.saveConfirmationToken(confirmationToken);
                    // TODO: SEND EMAIL
                    return token;
                }
            }
        }
        return null;
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

    public int enableUser(String email) {
        return repo.enableUser(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}
