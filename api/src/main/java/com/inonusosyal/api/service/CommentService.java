package com.inonusosyal.api.service;

import com.inonusosyal.api.dao.CommentDao;
import com.inonusosyal.api.entity.Dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    private final CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<CommentDto> getComment(UUID uuid){
        return commentDao.getCommentDtos(uuid);
    }
}
