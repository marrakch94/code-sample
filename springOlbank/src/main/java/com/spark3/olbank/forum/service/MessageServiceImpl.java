package com.spark3.olbank.forum.service;


import com.spark3.olbank.forum.model.Forum;
import com.spark3.olbank.forum.model.Message;
import com.spark3.olbank.forum.model.Stat;
import com.spark3.olbank.forum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository agent;


    @Override
    public List<Message> getAllMessage() {
        return agent.findAll();
    }

    @Override
    public Message getMessageById(long id) {
        return agent.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Message message) {
        agent.save(message);
    }

    @Override
    public void deleteMessage(long id) {
        agent.deleteById(id);
    }

    @Override
    public Message getMessageByName(String name) {
        return null;
    }

    @Override
    public List<Message> getMessageByForum(long forumId){
        return agent.findMessageByForum(new Forum(forumId));
    }


}
