package com.inonusosyal.api.entity.Dto;

import com.inonusosyal.api.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private UUID id;
    private UserDto owner;
    private String content;
    private List<Comment> replies;
    private Date publishedTime;
}
