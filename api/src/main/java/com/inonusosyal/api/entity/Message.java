package com.inonusosyal.api.entity;

import com.inonusosyal.api.entity.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private UUID id;
    private String content;
    private UserDto sender;
    private UserDto receiver;
    private Date timeStamp;
}
