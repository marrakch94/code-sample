package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.MessageView;
import com.spark3.olbank.forum.model.Stat;

import java.util.List;

public interface MessageViewService {
    public List<MessageView> getAll();
    public Stat getStat();
}
