package com.inonusosyal.api.entity;

import com.inonusosyal.api.entity.Dto.UserDto;

import java.util.Date;
import java.util.UUID;

public class Message {
    private UUID id;
    private String content;
    private UserDto sender;
    private UserDto receiver;
    private Date timeStamp;

    public  Message(){}

    public Message(UUID id, String content, UserDto sender, UserDto receiver,Date timeStamp) {
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.timeStamp = timeStamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }

    public UserDto getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDto receiver) {
        this.receiver = receiver;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
