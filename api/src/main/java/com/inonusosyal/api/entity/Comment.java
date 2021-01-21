package com.inonusosyal.api.entity;

import com.inonusosyal.api.entity.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    private UUID id;
    private UserDto owner;
    private String content;
    private Date publishedTime;
}
