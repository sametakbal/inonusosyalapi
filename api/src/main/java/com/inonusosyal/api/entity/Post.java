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
public class Post {
    private UUID id;
    private UserDto owner;
    private String content;
    private Group group;
    private Date publishedTime;
}
