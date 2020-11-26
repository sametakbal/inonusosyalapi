package com.inonusosyal.api.entity.Dto;

import com.inonusosyal.api.entity.Comment;
import com.inonusosyal.api.entity.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CommentDto {

    private UUID id;
    private UserDto owner;
    private String content;
    private List<Comment> replies;
    private Date publishedTime;

    public CommentDto(UUID id, UserDto owner, String content, List<Comment> replies, Date publishedTime) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.replies = replies;
        this.publishedTime = publishedTime;
    }

    public CommentDto() {}

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

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }
}
