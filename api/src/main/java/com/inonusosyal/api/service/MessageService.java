package com.inonusosyal.api.service;

import com.inonusosyal.api.dao.MessageDao;
import com.inonusosyal.api.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    private final MessageDao messageDao;

    @Autowired
    public MessageService(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public List<Message> getConversationByIds(UUID sender,UUID receiver){
        return messageDao.getConversation(sender, receiver);
    }
}
