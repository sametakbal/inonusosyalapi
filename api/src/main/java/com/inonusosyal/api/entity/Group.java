package com.inonusosyal.api.entity;

import java.util.List;
import java.util.UUID;

public class Group {
    private UUID id;
    private String title;
    private String description;
    private User founder;
    private List<User> members;

    public Group() {
    }

    public Group(UUID id, String title, String description, User founder, List<User> members) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.founder = founder;
        this.members = members;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getFounder() {
        return founder;
    }

    public void setFounder(User founder) {
        this.founder = founder;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
