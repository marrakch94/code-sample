package com.spark3.olbank.forum.service;

import com.spark3.olbank.forum.repository.UserViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserViewServiceImpl implements UserViewService{
    @Autowired
    UserViewRepository agent;
    @Override
    public Map<Long, String> getAll() {
        Map<Long, String> uvm = new HashMap<>();
        agent.findAll().forEach(x->uvm.put(x.getId(), x.getUser_name()));
        return uvm;
    }
}
