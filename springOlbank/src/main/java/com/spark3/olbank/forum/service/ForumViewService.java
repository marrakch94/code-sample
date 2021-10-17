package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.ForumView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForumViewService {
    public List<ForumView> getAll();
}
