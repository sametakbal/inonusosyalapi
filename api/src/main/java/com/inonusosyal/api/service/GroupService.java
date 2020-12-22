package com.inonusosyal.api.service;

import com.inonusosyal.api.dao.GroupDao;
import com.inonusosyal.api.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupService {
    private final GroupDao groupDao;

    @Autowired
    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public List<Group> getUserGroupByUuid(UUID uuid){
        return groupDao.getUserGroups(uuid);
    }
}
