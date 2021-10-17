package com.spark3.olbank.forum.service;


import com.spark3.olbank.forum.model.ForumView;
import com.spark3.olbank.forum.repository.ForumViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ForumViewServiceImpl implements ForumViewService {
    @Autowired
    ForumViewRepository agent;

    @Override
    public List<ForumView> getAll() {
        return agent.findAll()
                .stream().sorted(Comparator.reverseOrder()).limit(10).collect(Collectors.toList());
    }
}
