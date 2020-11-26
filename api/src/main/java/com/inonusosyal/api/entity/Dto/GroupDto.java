package com.inonusosyal.api.entity.Dto;

import com.inonusosyal.api.entity.User;

import java.util.List;
import java.util.UUID;

public class GroupDto {
    private UUID id;
    private String groupIcon;
    private String title;
    private String description;
    private List<User> members;

    public GroupDto() {
    }

    public GroupDto(UUID id, String groupIcon, String title, String description, List<User> members) {
        this.id = id;
        this.groupIcon = groupIcon;
        this.title = title;
        this.description = description;
        this.members = members;
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
}
