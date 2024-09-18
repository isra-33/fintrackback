package com.example.helpdeskv2.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helpdeskv2.entity.Agent;
import com.example.helpdeskv2.enums.Role;
import com.example.helpdeskv2.interfaces.AgentService;
import com.example.helpdeskv2.repository.AgentRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Agent updateAgent(Long id, Agent agentDetails) {
        Agent agent = agentRepository.findById(id).orElse(null);
        if (agentDetails != null) {
            agent.setAgentName(agentDetails.getAgentName());
            agent.setAgentEmail(agentDetails.getAgentEmail());
            agent.setComplaints(agentDetails.getComplaints());
        }
        return agent;
    }
    @Override
    public void deleteAgent(Long id) {
        agentRepository.findById(id).ifPresent(
                agent -> agentRepository.delete(agent)
        );
    }

    @Override
    public Agent findByEmail(String agentEmail) {
        Optional<Agent> agent = agentRepository.findByAgentEmail(agentEmail);
        return agent.orElse(null);  
    }

}
