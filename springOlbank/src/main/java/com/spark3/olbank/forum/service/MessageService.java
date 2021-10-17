package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.Message;
import com.spark3.olbank.forum.model.Stat;

import java.util.List;

public interface MessageService {

    public List<Message> getAllMessage();

    public Message getMessageById(long id);

    public void saveOrUpdate(Message message);

    public void deleteMessage(long id);

    public Message getMessageByName(String name);

    public List<Message> getMessageByForum(long forumId);


}
