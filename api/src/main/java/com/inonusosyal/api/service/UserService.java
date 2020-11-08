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

    public List<User> selectAllUsers(){
        return userDao.getAllUsers();
    }

    public Optional<User> getUserById(UUID id){return userDao.getUserById(id);}

}
