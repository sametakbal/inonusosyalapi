package com.inonusosyal.api.entity.Dto;
import com.inonusosyal.api.entity.*;
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
public class PostDto extends Post {
    private List<Media> medias;
    private List<CommentDto> comments;

    public PostDto(UUID id, UserDto owner, String content, Group group, Date publishedTime, List<Media> medias, List<CommentDto> comments) {
        super(id, owner, content, group, publishedTime);
        this.medias = medias;
        this.comments = comments;
    }
}
