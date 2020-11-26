package com.inonusosyal.api.dao.interfaces;

import com.inonusosyal.api.entity.Comment;
import com.inonusosyal.api.entity.Dto.CommentDto;

import java.util.List;
import java.util.UUID;

public interface ICommentDao extends IDao<Comment>{
    List<CommentDto> getCommentDtos(UUID postId);
}
