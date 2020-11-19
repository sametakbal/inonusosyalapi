package com.inonusosyal.api.entity;

import java.util.UUID;

public class Media {
    private UUID id;
    private String name;
    private String path;
    private String type;
    private long fileSize;

    public Media() {
    }

    public Media(UUID id, String name, String path, String type, long fileSize) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.type = type;
        this.fileSize = fileSize;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
