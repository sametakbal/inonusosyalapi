package com.inonusosyal.api.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Group {
    private UUID id;
    private String groupIcon;
    private String title;
    private String description;
    private User founder;
    private Date lastUpdate;

    public Group() {
    }

    public Group(UUID id, String groupIcon, String title, String description, User founder) {
        this.id = id;
        this.groupIcon = groupIcon;
        this.title = title;
        this.description = description;
        this.founder = founder;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGroupIcon() {
        return groupIcon;
    }

    public void setGroupIcon(String groupIcon) {
        this.groupIcon = groupIcon;
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

}
