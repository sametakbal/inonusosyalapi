package com.inonusosyal.api.service;

import com.inonusosyal.api.dao.UserDao;
import com.inonusosyal.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> selectAllUsers() {
        return userDao.get();
    }

    public Optional<User> getUserById(UUID id) {
        return userDao.getById(id);
    }

    public boolean addUser(User user) {
        return userDao.add(user) == 1;
    }

    public boolean update(User user) {
        return userDao.update(user) == 1;
    }

    public boolean deleteUser(UUID id) {
        return userDao.remove(id)==1;
    }
}
