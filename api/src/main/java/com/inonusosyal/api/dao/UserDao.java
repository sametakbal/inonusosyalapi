package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IUserDao;
import com.inonusosyal.api.entity.Dto.UserDto;
import com.inonusosyal.api.entity.Dto.UserProfileDto;
import com.inonusosyal.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class UserDao extends Dao implements IUserDao {

    private final GroupDao groupDao;
    @Autowired
    public UserDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<User> get() {
        String q = "select * from users";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                User.Gender gender = rs.getInt("gender") == 0 ? User.Gender.Male : User.Gender.Female;
                User.Status status = rs.getInt("status") == 0 ? User.Status.Student : User.Status.Academician;
                User tmp = new User(rs.getObject("id", java.util.UUID.class), rs.getString("profilepicture"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("email"), rs.getString("password"), gender, status);
                list.add(tmp);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Optional<UserProfileDto> getById(UUID id) {
        String q = "select * from users where id=?";
        UserProfileDto tmp = null;
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User.Gender gender = rs.getInt("gender") == 0 ? User.Gender.Male : User.Gender.Female;
                User.Status status = rs.getInt("status") == 0 ? User.Status.Student : User.Status.Academician;
                tmp = new UserProfileDto(rs.getObject("id", java.util.UUID.class), rs.getString("profilepicture"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("email"), gender, status,getUserFollowers(id),getUserFollows(id),groupDao.getUserGroups(id));
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(tmp);
    }

    @Override
    public boolean followUser(UUID userId, UUID userToFollow) {
        String q = "insert into users_followers (user_id,follower_id) values (?,?)";
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, userToFollow);
            pst.setObject(2, userId);

            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean unFollowUser(UUID userId, UUID userToFollow) {
        String q = "delete from users_followers (user_id,follower_id) values (?,?)";
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, userToFollow);
            pst.setObject(2, userId);

            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public int add(User user) {
        String q = "insert into users (id,profilePicture,name,surname,email,password,gender,status) values (default,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setString(1, user.getProfilePicture());
            pst.setString(2, user.getName());
            pst.setString(3, user.getSurname());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getPassword());
            pst.setInt(6, user.getGender().ordinal());
            pst.setInt(7, user.getStatus().ordinal());

            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    @Override
    public int update(User user) {
        String q = "update users set profilePicture=?,name=?,surname=?,email=?,password=?,gender=?,status=? where id=?";
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setString(1, user.getProfilePicture());
            pst.setString(2, user.getName());
            pst.setString(3, user.getSurname());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getPassword());
            pst.setInt(6, user.getGender().ordinal());
            pst.setInt(7, user.getStatus().ordinal());
            pst.setObject(8, user.getId());
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    @Override
    public int remove(UUID id) {
        String q ="delete from users where id = ?";
        try (PreparedStatement pst = this.getConn().prepareStatement(q)) {
            pst.setObject(1, id);
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    @Override
    public List<UserDto> getUserFollowers(UUID uuid) {
        String q ="select users.id,users.profilepicture,users.name,users.surname,users.email,users.gender,users.status from users \n" +
                "inner join users_followers on (users.id = users_followers.follower_id and users_followers.user_id=?)";
        List<UserDto> list = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, uuid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User.Gender gender = rs.getInt("gender") == 0 ? User.Gender.Male : User.Gender.Female;
                User.Status status = rs.getInt("status") == 0 ? User.Status.Student : User.Status.Academician;
                UserDto tmp = new UserDto(rs.getObject("id", java.util.UUID.class), rs.getString("profilepicture"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("email"), gender, status);
                list.add(tmp);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }

    @Override
    public List<UserDto> getUserFollows(UUID uuid) {
        String q ="select users.id,users.profilepicture,users.name,users.surname,users.email,users.gender,users.status from users\n" +
                "inner join users_followers on (users.id = users_followers.user_id and users_followers.follower_id=?)";
        List<UserDto> userFollows = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, uuid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User.Gender gender = rs.getInt("gender") == 0 ? User.Gender.Male : User.Gender.Female;
                User.Status status = rs.getInt("status") == 0 ? User.Status.Student : User.Status.Academician;
                UserDto tmp = new UserDto(rs.getObject("id", java.util.UUID.class), rs.getString("profilepicture"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("email"), gender, status);
                userFollows.add(tmp);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userFollows;
    }

    @Override
    public List<UserDto> searchUserByNameOrSurname(String term) {
        String q ="select users.id,users.profilepicture,users.name,users.surname,users.email,users.gender,users.status from users\n" +
                "where name like ? or  name like ? or  name like ? or\n" +
                "surname like ? or surname like ? or surname like ?;";
        List<UserDto> users = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setString(1,"%"+term);
            pst.setString(2,"%"+term+"%");
            pst.setString(3,term+"%");
            pst.setString(4,"%"+term);
            pst.setString(5,"%"+term+"%");
            pst.setString(6,term+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User.Gender gender = rs.getInt("gender") == 0 ? User.Gender.Male : User.Gender.Female;
                User.Status status = rs.getInt("status") == 0 ? User.Status.Student : User.Status.Academician;
                UserDto tmp = new UserDto(rs.getObject("id", java.util.UUID.class), rs.getString("profilepicture"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("email"), gender, status);
                users.add(tmp);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
