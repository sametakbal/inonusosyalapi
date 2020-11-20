package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IGroupDao;
import com.inonusosyal.api.entity.Group;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GroupDao extends Dao implements IGroupDao {
    @Override
    public List<Group> get() {
        return null;
    }

    @Override
    public Optional<Group> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Group group) {
        return 0;
    }

    @Override
    public int update(Group group) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }
}
