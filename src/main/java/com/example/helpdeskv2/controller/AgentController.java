package com.example.helpdeskv2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helpdeskv2.entity.Agent;
import com.example.helpdeskv2.interfaces.AgentService;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public Agent createAgent(@RequestBody Agent agent) {
        // Ensure the role is set before saving the agent
        if (agent.getRole() == null) {
            throw new IllegalArgumentException("Role must be specified");
        }
        return agentService.addAgent(agent);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Agent getAgentById(@PathVariable Long id) {
        return agentService.getAgentById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Agent updateAgent(@PathVariable Long id, @RequestBody Agent agentDetails) {
        return agentService.updateAgent(id, agentDetails);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteAgent(@PathVariable Long id) {
        System.out.println("888");
        agentService.deleteAgent(id);
    }
    
}

