package com.spark3.olbank.forum.repository;

import com.spark3.olbank.forum.model.Forum;
import com.spark3.olbank.forum.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessageByForum(Forum forum);


}
