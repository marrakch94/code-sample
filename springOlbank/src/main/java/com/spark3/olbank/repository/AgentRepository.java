package com.spark3.olbank.repository;

import com.spark3.olbank.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    // List<Agent> findByJob(String Job_Title);

}
