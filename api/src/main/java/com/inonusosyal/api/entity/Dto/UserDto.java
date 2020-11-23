package com.inonusosyal.api.entity.Dto;

import com.inonusosyal.api.entity.User;

import java.util.UUID;

public class UserDto {
    private UUID id;
    private String profilePicture;
    private String name;
    private String surname;
    private String email;
    private User.Gender gender;
    private User.Status status;

    public UserDto() {
    }

    public UserDto(UUID id, String profilePicture, String name, String surname, String email, User.Gender gender, User.Status status) {
        this.id = id;
        this.profilePicture = profilePicture;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.status = status;
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

    public User.Gender getGender() {
        return gender;
    }

    public void setGender(User.Gender gender) {
        this.gender = gender;
    }

    public User.Status getStatus() {
        return status;
    }

    public void setStatus(User.Status status) {
        this.status = status;
    }
}
