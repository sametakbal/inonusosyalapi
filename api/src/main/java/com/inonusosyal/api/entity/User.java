package com.inonusosyal.api.entity;

import com.inonusosyal.api.entity.Enums.Gender;
import com.inonusosyal.api.entity.Enums.Status;

import java.util.UUID;
public class User {
    private UUID id;
    private String profilePicture;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Gender gender;
    private Status status;

    public User(UUID id, String profilePicture, String name, String surname, String email, String password, Gender gender, Status status) {
        this.id = id;
        this.profilePicture = profilePicture;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.status = status;
    }

    public User(UUID id, String profilePicture, String name, String surname, String email, Gender gender, Status status) {
        this.id = id;
        this.profilePicture = profilePicture;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
