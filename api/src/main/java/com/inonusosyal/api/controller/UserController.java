package com.inonusosyal.api.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inonusosyal.api.entity.UserEntity;
import com.inonusosyal.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{userid}")
    public ResponseEntity<?> fetchUser(@PathVariable String userid) {
        return userService.getUserById(userid).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("user " + userid + " was not found"));
    }

    @PostMapping("user")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity user) {
        return userService.addUser(user).isPresent() ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

class UserCreateParams {
    private UserEntity userEntity;
    private Password password;

    public UserCreateParams() {
    }

    public UserCreateParams(UserEntity userEntity, Password password) {
        this.userEntity = userEntity;
        this.password = password;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}

class Password {
    @JsonProperty("password")
    private String userPassword;
    private List<String> policies = Arrays.asList("inventory");

    public Password() {
    }

    public Password(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<String> getPolicies() {
        return policies;
    }

    public void setPolicies(List<String> policies) {
        this.policies = policies;
    }


}