package com.spark3.olbank.controller;


import com.spark3.olbank.model.Agent;
import com.spark3.olbank.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("agent")
public class AgentController {

    @Autowired
    AgentService agentService;


    @GetMapping("")
    public List<Agent> getAll() {
        return agentService.findAll();
    }

    @GetMapping("{id}")
    public Agent getOne(@PathVariable("id") long id) {
        return agentService.findById(id);
    }

    @PostMapping("")
    public Agent addOne(@RequestBody Agent agent) {
        return agentService.create(agent);
    }

    @PutMapping("")
    public Agent updateOne(@RequestBody Agent agent) {
        return agentService.update(agent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteOne(@PathVariable("id") long id) {
        agentService.delete(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("{Job_Title}")
    public List<Agent> findAgentByFeature(@PathVariable("Job_Title") String Job_Title){
        return	agentService.getAgentByFeature(Job_Title);
    }

}
