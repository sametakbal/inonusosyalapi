package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IPostDao;
import com.inonusosyal.api.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PostDao extends Dao implements IPostDao {
    @Override
    public List<Post> get() {
        return null;
    }

    @Override
    public Optional<Post> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Post post) {
        return 0;
    }

    @Override
    public int update(Post post) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }
}
