package com.inonusosyal.api.entity.Dto;
import com.inonusosyal.api.entity.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PostDto extends Post {

    private List<Media> medias;
    private List<CommentDto> comments;

    public PostDto() {}

    public PostDto(UUID id, UserDto owner, String content, Group group, Date publishedTime, List<Media> medias, List<CommentDto> comments) {
        super(id, owner, content, group, publishedTime);
        this.medias = medias;
        this.comments = comments;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}
