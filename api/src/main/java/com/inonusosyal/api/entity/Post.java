package com.inonusosyal.api.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Post {
    private UUID id;
    private User owner;
    private String content;
    private List<Media> medias;
    private List<Comment> comments;
    private Date publishedTime;

    public Post(){}

    public Post(UUID id, User owner, String content, List<Media> medias, List<Comment> comments, Date publishedTime) {
        this.id = id;
        this.owner = owner;
        this.content = content;
        this.medias = medias;
        this.comments = comments;
        this.publishedTime = publishedTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }
}
