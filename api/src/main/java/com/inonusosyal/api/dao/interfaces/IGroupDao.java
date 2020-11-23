package com.inonusosyal.api.dao.interfaces;

import com.inonusosyal.api.entity.Dto.GroupDto;
import com.inonusosyal.api.entity.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupDao extends IDao<Group>{
    List<GroupDto> getUserGroups(UUID userUuid);
}
