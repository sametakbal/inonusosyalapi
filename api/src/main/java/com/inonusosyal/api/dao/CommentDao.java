package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.ICommentDao;
import com.inonusosyal.api.entity.Comment;
import com.inonusosyal.api.entity.Dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CommentDao extends Dao implements ICommentDao {

    private final UserDao userDao;

    @Autowired
    public CommentDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Comment> get() {
        return null;
    }

    public Optional<Comment> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Comment comment) {
        return 0;
    }

    @Override
    public int update(Comment comment) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }

    @Override
    public List<CommentDto> getCommentDtos(UUID postId) {
        String q = "select * from comment where post_id=?";
        List<CommentDto> commentDtos = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, postId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UUID commentUuid = rs.getObject("id", java.util.UUID.class);
                CommentDto tmp = new CommentDto(commentUuid,
                        userDao.getUserDtoById(rs.getObject("owner", java.util.UUID.class)),
                        rs.getString("content"), getCommentReplies(commentUuid), rs.getDate("publish_time"));
                commentDtos.add(tmp);
            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return commentDtos;
    }

    private List<Comment> getCommentReplies(UUID commentUuid) {
        String q = "select * from comment where reply_id=?";
        List<Comment> replies = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, commentUuid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Comment tmp = new Comment(rs.getObject("id", java.util.UUID.class),
                        userDao.getUserDtoById(rs.getObject("owner", java.util.UUID.class)),
                        rs.getString("content"), rs.getDate("publish_time"));
                replies.add(tmp);
            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return replies;
    }
}
