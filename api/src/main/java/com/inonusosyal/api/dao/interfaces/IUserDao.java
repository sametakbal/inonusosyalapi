package com.inonusosyal.api.dao.interfaces;

import com.inonusosyal.api.entity.Dto.UserDto;
import com.inonusosyal.api.entity.Dto.UserProfileDto;
import com.inonusosyal.api.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserDao extends IDao<User>{
    List<UserDto> getUserFollowers(UUID uuid);
    List<UserDto> getUserFollows(UUID uuid);
    List<UserDto> searchUserByNameOrSurname(String term);
    Optional<UserProfileDto> getById(UUID id);
}
