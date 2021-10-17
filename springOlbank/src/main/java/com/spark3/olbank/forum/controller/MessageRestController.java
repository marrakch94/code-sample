package com.spark3.olbank.forum.controller;


import com.spark3.olbank.forum.model.Forum;
import com.spark3.olbank.forum.model.Message;
import com.spark3.olbank.forum.model.MessageView;
import com.spark3.olbank.forum.model.Stat;
import com.spark3.olbank.forum.service.MessageService;
import com.spark3.olbank.forum.service.MessageViewService;
import com.spark3.olbank.forum.service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/message")
public class MessageRestController {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageViewService messageViewService;
    @Autowired
    UserViewService userViewService;

    @GetMapping("/")
    public List<Message> getAllMessages() {
        return messageService.getAllMessage();
    }

    @PostMapping("/")
    public void saveOrUpdate(@RequestBody Message message) {
        System.out.println("***********************************" + message);
        messageService.saveOrUpdate(message);
    }

    @GetMapping("/{forumId}")
    public List<Message> getByForumId(@PathVariable("forumId") long forumId) {
        return messageService.getMessageByForum(forumId);
    }

    @DeleteMapping("/{id}")
    public void deleteMessageById(@PathVariable("id") long id) {
        messageService.deleteMessage(id);
    }

    @GetMapping("/msgView")
    public List<MessageView> getAllMassageView() {
        return messageViewService.getAll();
    }

    @GetMapping("/stat")
    public Stat getStat() {
        return messageViewService.getStat();
    }

    @GetMapping("/users")
    public Map<Long,String> getUsers(){
        return userViewService.getAll();
    }
    //  @PostMapping()

}
