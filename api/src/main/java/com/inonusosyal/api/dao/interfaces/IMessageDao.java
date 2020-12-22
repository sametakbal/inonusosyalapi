package com.inonusosyal.api.dao.interfaces;

import com.inonusosyal.api.entity.Message;

import java.util.List;
import java.util.UUID;

public interface IMessageDao extends IDao<Message>{
    List<Message> getConversation(UUID sender,UUID receiver);
}
