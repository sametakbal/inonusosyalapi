package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IMediaDao;
import com.inonusosyal.api.entity.Media;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MediaDao extends Dao implements IMediaDao {
    @Override
    public List<Media> get() {
        return null;
    }

    public Optional<Media> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Media media) {
        return 0;
    }

    @Override
    public int update(Media media) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }
}
