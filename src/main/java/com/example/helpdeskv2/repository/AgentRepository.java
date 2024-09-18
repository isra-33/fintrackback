package com.example.helpdeskv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.helpdeskv2.entity.Agent;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByAgentEmail(String agentEmail);
}


