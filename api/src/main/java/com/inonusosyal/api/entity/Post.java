package com.inonusosyal.api.entity;

import com.inonusosyal.api.entity.Dto.UserDto;

import java.util.Date;
import java.util.UUID;

public class Post {
    private UUID id;
    private UserDto owner;
    private String content;
    private Group group;
    private Date publishedTime;

    public Post(){}

    public Post(UUID id, UserDto owner, String content, Group group, Date publishedTime) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.group = group;
        this.publishedTime = publishedTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }
}
