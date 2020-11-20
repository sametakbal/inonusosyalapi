package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IMessageDao;
import com.inonusosyal.api.entity.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MessageDao extends Dao implements IMessageDao {
    @Override
    public List<Message> get() {
        return null;
    }

    @Override
    public Optional<Message> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Message message) {
        return 0;
    }

    @Override
    public int update(Message message) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }
}
