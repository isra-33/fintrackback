package com.example.helpdeskv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.helpdeskv2.entity.Complaint;
import com.example.helpdeskv2.enums.Status;
import java.util.*;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

    long count();
    long countByStatus(Status status);
    
    @Query("SELECT c FROM Complaint c WHERE c.agent.id = :agentId")
    List<Complaint> findByAssignedAgentId(@Param("agentId") Long agentId);


}

