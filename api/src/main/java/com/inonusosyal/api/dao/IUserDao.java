package com.inonusosyal.api.dao;

import com.inonusosyal.api.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserDao {
    List<User> getAllUsers();
    Optional<User> getUserById(UUID id);
    int saveUser(User user);
    int removeUser(String id);
}
