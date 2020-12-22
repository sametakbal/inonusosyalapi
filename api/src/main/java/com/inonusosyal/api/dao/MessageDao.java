package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IMessageDao;
import com.inonusosyal.api.entity.Message;
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
public class MessageDao extends Dao implements IMessageDao {
    private final UserDao userDao;

    @Autowired
    public MessageDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Message> get() {
        return null;
    }

    public Optional<Message> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Message message) {
        return 0;
    }

    @Override
    public int update(Message message) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }

    @Override
    public List<Message> getConversation(UUID sender, UUID receiver) {
        String q = "select * from message where (sender =? and receiver=?)\n" +
                "or (sender =? and receiver=?) order by created_at";
        List<Message> messageList = new ArrayList<>();

        try{
            PreparedStatement pst = getConn().prepareStatement(q);
            pst.setObject(1,sender);
            pst.setObject(2,receiver);
            pst.setObject(3,receiver);
            pst.setObject(4,sender);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Message tmp = new Message(rs.getObject("id",java.util.UUID.class),rs.getString("content"),
                        userDao.getUserDtoById(rs.getObject("sender",java.util.UUID.class)),
                        userDao.getUserDtoById(rs.getObject("receiver",java.util.UUID.class)),rs.getDate("created_at"));
                messageList.add(tmp);
            }


        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return messageList;
    }
}
