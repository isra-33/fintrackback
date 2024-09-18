package com.example.helpdeskv2.interfaces;

import java.util.*;

import com.example.helpdeskv2.entity.Agent;

public interface AgentService {
    
    Agent addAgent(Agent agent);
    Agent getAgentById(Long id);
    List<Agent> getAllAgents();
    Agent updateAgent(Long id, Agent agentDetails);
    void deleteAgent(Long id);
    Agent findByEmail(String agentEmail);


}
