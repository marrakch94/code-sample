package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.model.MessageView;
import com.spark3.olbank.forum.model.Stat;
import com.spark3.olbank.forum.repository.MessageViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class MessageViewServiceImpl implements MessageViewService{
    @Autowired
    MessageViewRepository agent;
    @Override
    public List<MessageView> getAll() {
        return agent//.findAll();
                .findAll(Sort.by(Sort.Direction.ASC,"messageGroupDate"));
    }

    @Override
    public Stat getStat() {
       int year = LocalDate.now().getYear();
       int month = LocalDate.now().getMonth().getValue();
      System.out.println("MsgViewServ Month and year: "+ month +" "+year);
      float valueN = new Long(agent
              .findMessageViewByMessageYearAndMessageMonth(year,month)
              .getMessageNbr()).floatValue();
      float valueNMinus1 = new Long(agent
              .findMessageViewByMessageYearAndMessageMonth(year,month-1)
              .getMessageNbr()).floatValue();
        return new Stat("Monthly number of posts",valueN,valueNMinus1);
    }
}
