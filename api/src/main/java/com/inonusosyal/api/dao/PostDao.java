package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IPostDao;
import com.inonusosyal.api.entity.*;
import com.inonusosyal.api.entity.Dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PostDao extends Dao implements IPostDao {

    private final UserDao userDao;
    private final GroupDao groupDao;

    @Autowired
    public PostDao(UserDao userDao, GroupDao groupDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
    }

    @Override
    public List<Post> get() {
        return null;
    }

    @Override
    public List<PostDto> getGroupPosts(UUID groupId) {
        String q = "select * from post where group_id=? order by publish_time";
        List<PostDto> groupPostList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, groupId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Group group = getGroupDao().getById(rs.getObject("owner", java.util.UUID.class)).isPresent() ?
                        getGroupDao().getById(rs.getObject("owner", java.util.UUID.class)).get() : null;
                PostDto tmp = new PostDto(rs.getObject("id", java.util.UUID.class),
                        getUserDao().getUserDtoById(rs.getObject("owner", java.util.UUID.class)),
                        rs.getString("content"),
                        group,
                        rs.getDate("publish_time"),
                        new ArrayList<>(),
                        new ArrayList<>());
                groupPostList.add(tmp);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groupPostList;
    }

    public Optional<Post> getById(UUID id) {
        String q = "select * from post where id=?";
        Post post = null;
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Group group = getGroupDao().getById(rs.getObject("owner", java.util.UUID.class)).isPresent() ?
                        getGroupDao().getById(rs.getObject("owner", java.util.UUID.class)).get() : null;
                post = new Post(rs.getObject("id", java.util.UUID.class),
                        getUserDao().getUserDtoById(rs.getObject("owner", java.util.UUID.class)),
                        rs.getString("content"),
                        group,
                        rs.getDate("publish_time"));
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(post);
    }

    @Override
    public int add(Post post) {

        return 0;
    }

    @Override
    public int update(Post post) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public GroupDao getGroupDao() {
        return groupDao;
    }
}
