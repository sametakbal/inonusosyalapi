package com.inonusosyal.api.dao;

import com.inonusosyal.api.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class UserDao extends Dao implements IUserDao {

    @Override
    public List<User> get() {
        String q = "select * from users";
        List<User> list = new ArrayList<>();
        try (PreparedStatement pst = this.getConn().prepareStatement(q)){
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
    public Optional<User> getById(UUID id) {
        String q = "select * from users where id=?";
        User tmp = null;
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User.Gender gender = rs.getInt("gender") == 0 ? User.Gender.Male : User.Gender.Female;
                User.Status status = rs.getInt("status") == 0 ? User.Status.Student : User.Status.Academician;
                tmp = new User(rs.getObject("id", java.util.UUID.class), rs.getString("profilepicture"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("email"), rs.getString("password"), gender, status);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(tmp);
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

}
