package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.Forum;
import com.spark3.olbank.forum.model.ForumMatch;

import java.util.List;

public interface ForumService {

    public List<Forum> getAllForum();

    public Forum getForumById(long id);

    public long saveOrUpdate(Forum forum);

    public void deleteForum(long id);

    public Forum getForumByName(String name);

    public List<ForumMatch> search (String topic);

    public List<ForumMatch> searchHard (String topic);

    
}
