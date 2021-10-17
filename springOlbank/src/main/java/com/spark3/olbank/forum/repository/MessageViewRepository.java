package com.spark3.olbank.forum.repository;

import com.spark3.olbank.forum.model.MessageView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageViewRepository extends JpaRepository<MessageView,Integer> {
    MessageView findMessageViewByMessageYearAndMessageMonth (int year, int month);
}
