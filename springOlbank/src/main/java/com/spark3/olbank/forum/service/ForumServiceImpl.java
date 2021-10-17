package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.Forum;
import com.spark3.olbank.forum.model.ForumMatch;
import com.spark3.olbank.forum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {

    @Autowired
    ForumRepository agent;
    @Autowired
    SentenceToWord sentenceToWord;

    @Override
    public List<Forum> getAllForum() {
        return agent.findAll();
    }

    @Override
    public Forum getForumById(long id) {
        return agent.findById(id).get();
    }

    @Override
    public long saveOrUpdate(Forum forum) {
        return agent.save(forum).getForumId();
    }

    @Override
    public void deleteForum(long id) {
        agent.deleteById(id);
    }

    @Override
    public Forum getForumByName(String name) {
        return null;
    }

    @Override
    public List<ForumMatch> search(String topic) {
     return    this.getAllForum().stream()
                .map(s-> new ForumMatch(s,sentenceToWord.compare(s.getTopic(),topic)))
                .filter(f->f.getNbrWordMatch()>0).sorted().collect(Collectors.toList());
    }

    @Override
    public List<ForumMatch> searchHard(String topic) {
        return    this.getAllForum().stream()
                .map(s-> new ForumMatch(s,sentenceToWord.compareHard(topic,s.getTopic())))
                .filter(f->f.getNbrWordMatch()>0).sorted().collect(Collectors.toList());
    }

}
