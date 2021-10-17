package com.spark3.olbank.service;

import com.spark3.olbank.model.Agent;
import com.spark3.olbank.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;


@Service
@Transactional
public class AgentServiceImpl implements AgentService {


    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent findById(long id) {
        return agentRepository.findById(id).get();
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agent create(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent update(Agent agent) { return agentRepository.save(agent); }

    @Override
    public void delete(long id) {
        agentRepository.deleteById(id);
    }

    @Override
    public List<Agent> getAgentByFeature(String Job_Title) {
        return null;// agentRepository.findByJob(Job_Title);
    }



}
