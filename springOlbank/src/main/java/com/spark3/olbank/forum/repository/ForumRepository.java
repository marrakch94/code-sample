package com.spark3.olbank.forum.repository;

import com.spark3.olbank.forum.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ForumRepository extends JpaRepository<Forum, Long> {


}
