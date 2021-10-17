package com.spark3.olbank.forum.controller;

import com.spark3.olbank.forum.model.Forum;
import com.spark3.olbank.forum.model.ForumMatch;
import com.spark3.olbank.forum.model.ForumView;
import com.spark3.olbank.forum.service.ForumService;
import com.spark3.olbank.forum.service.ForumViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/forum")
public class ForumRestController {
    @Autowired
    ForumService forumService;
    @Autowired
    ForumViewService forumViewService;

    @GetMapping("/")
    public List<Forum> getAllForum() {
        return forumService.getAllForum();
    }

    @GetMapping("/{id}")
    public Forum getForumById(@PathVariable("id") long id) {
        return forumService.getForumById(id);
    }

    @GetMapping("/recap")
    public List<ForumView> getAllForumRecap() {
        return forumViewService.getAll();
    }

    @GetMapping("/topic/{topic}")
    public List<ForumMatch> getForumByTopic(@PathVariable("topic") String topic) {
        return forumService.search(topic);
    }

    @GetMapping("/topich/{topic}")
    public List<ForumMatch> getForumByTopicHard(@PathVariable("topic") String topic) {
        return forumService.searchHard(topic);
    }

    @PostMapping("/")
    public long save(@RequestBody Forum forum) {
       return forumService.saveOrUpdate(forum);
    }


}
