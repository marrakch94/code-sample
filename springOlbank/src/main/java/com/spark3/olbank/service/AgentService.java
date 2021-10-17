package com.spark3.olbank.service;

import com.spark3.olbank.model.Agent;

import java.util.List;

public interface AgentService {

    Agent findById(long id);

    List<Agent> findAll();

    Agent create(Agent agent);

    Agent update(Agent agent);

    void delete(long id);

    List<Agent> getAgentByFeature(String Job_Title);


}
