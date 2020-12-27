package com.inonusosyal.api.service;

import com.inonusosyal.api.dao.UserDao;
import com.inonusosyal.api.entity.Dto.UserDto;
import com.inonusosyal.api.entity.Dto.UserProfileDto;
import com.inonusosyal.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> selectAllUsers() {
        return userDao.get();
    }

    public List<UserDto> searchUsers(String term) {
        return userDao.searchUserByNameOrSurname(term);
    }

    public Optional<UserProfileDto> getUserById(UUID id) {
        return userDao.getUserProfileDtoById(id);
    }

    public boolean addUser(User user) {
        if (emailCheck(user.getEmail().substring(user.getEmail().indexOf("@")+1))){
           return false;
        }else if (userDao.isEmailExist(user.getEmail())){
            return false;
        }
        return userDao.add(user) == 1;
    }

    public boolean update(User user) {
        return userDao.update(user) == 1;
    }

    public boolean deleteUser(UUID id) {
        return userDao.remove(id) == 1;
    }

    private boolean emailCheck(String email) {
        String domain = "inonu.edu.tr";
        if (email.contains("ogr")) {
            domain = "ogr." + domain;
        }
        return !email.equals(domain);
    }
}
