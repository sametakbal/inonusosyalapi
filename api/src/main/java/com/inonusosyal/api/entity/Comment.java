package com.inonusosyal.api.entity;

import com.inonusosyal.api.entity.Dto.UserDto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Comment {
    private UUID id;
    private UserDto owner;
    private String content;
    private Date publishedTime;


    public Comment(){}
    public Comment(UUID id, UserDto owner, String content,Date publishedTime) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.publishedTime = publishedTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
