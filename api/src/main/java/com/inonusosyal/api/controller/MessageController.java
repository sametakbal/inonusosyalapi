package com.inonusosyal.api.controller;

import com.inonusosyal.api.entity.Message;
import com.inonusosyal.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(
        path = "/api/messages"
)
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/conversation"
    )
    public List<Message> fetchConversationByUuids(@RequestParam UUID sender,@RequestParam UUID receiver){
        return  messageService.getConversationByIds(sender,receiver);
    }
}
