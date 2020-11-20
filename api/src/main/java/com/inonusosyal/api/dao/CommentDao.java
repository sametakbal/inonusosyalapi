package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.ICommentDao;
import com.inonusosyal.api.entity.Comment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CommentDao extends Dao implements ICommentDao {
    @Override
    public List<Comment> get() {
        return null;
    }

    @Override
    public Optional<Comment> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Comment comment) {
        return 0;
    }

    @Override
    public int update(Comment comment) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }
}
