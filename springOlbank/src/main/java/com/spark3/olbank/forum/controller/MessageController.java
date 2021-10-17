package com.spark3.olbank.forum.controller;

import com.spark3.olbank.forum.model.Message;
import com.spark3.olbank.forum.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @MessageMapping("/incomingmsg/{forumId}")
    @SendTo("/topic/{forumId}")
    public Message response(@DestinationVariable String forumId, Message message) throws Exception {
        messageService.saveOrUpdate(message);
        Thread.sleep(1000);
        return message;
        // return new Message("Hello, " + HtmlUtils.htmlEscape(message.getMessageTxt()) + "!");
    }

    @MessageMapping("/deleteMsg/{forumId}")
    @SendTo("/topic/{forumId}")
    public Message delete(@DestinationVariable String forumId, Message message) throws Exception {
        messageService.deleteMessage(message.getMessageId());
        Thread.sleep(1000);
        message.setMessageId(-message.getMessageId());
        return message;
    }


}
