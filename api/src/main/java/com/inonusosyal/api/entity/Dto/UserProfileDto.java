package com.inonusosyal.api.entity.Dto;

import com.inonusosyal.api.entity.Group;
import com.inonusosyal.api.entity.User;

import java.util.List;
import java.util.UUID;

public class UserProfileDto extends UserDto {
    private List<UserDto> followers;
    private List<UserDto> following;
    private List<Group> groups;

    public UserProfileDto(UUID id, String profilePicture, String name, String surname, String email,
                          User.Gender gender, User.Status status, List<UserDto> followers, List<UserDto> following, List<Group> groups) {
        super(id, profilePicture, name, surname, email, gender, status);
        this.followers = followers;
        this.following = following;
        this.groups = groups;
    }

    public List<UserDto> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDto> followers) {
        this.followers = followers;
    }

    public List<UserDto> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserDto> following) {
        this.following = following;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
