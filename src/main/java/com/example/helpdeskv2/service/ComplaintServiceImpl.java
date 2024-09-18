package com.example.helpdeskv2.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helpdeskv2.entity.Complaint;
import com.example.helpdeskv2.enums.Status;
import com.example.helpdeskv2.interfaces.ComplaintService;
import com.example.helpdeskv2.repository.AgentRepository;
import com.example.helpdeskv2.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private AgentRepository agentRepository;
    @Override
    public Complaint addComplaint(Complaint complaint) {
        if (complaint.getAgent() == null || complaint.getAgent().getId() == null || 
            !agentRepository.existsById(complaint.getAgent().getId())) {
            throw new IllegalArgumentException("Invalid agent ID");
        }
        complaint.setCreationDate(new Date());
        return complaintRepository.save(complaint);
    }


    @Override
    public Complaint updateComplaint(Long id, Complaint complaintDetails) {
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        if (complaint == null || complaintDetails == null) {
            throw new IllegalArgumentException("Complaint or complaint details cannot be null");
        }
        
        complaint.setTitle(complaintDetails.getTitle());
        complaint.setCreationDate(complaintDetails.getCreationDate());
        complaint.setStatus(complaintDetails.getStatus());
        
        // Ensure agent and client exist
        if (complaintDetails.getAgent() != null && complaintDetails.getAgent().getId() != null) {
            if (agentRepository.existsById(complaintDetails.getAgent().getId())) {
                complaint.setAgent(complaintDetails.getAgent());
            } else {
                throw new IllegalArgumentException("Invalid agent ID");
            }
        }
        
        complaint.setClient(complaintDetails.getClient()); // Add similar validation for client if needed

        return complaintRepository.save(complaint);
    }


    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.findById(id).ifPresent(
                complaint -> complaintRepository.delete(complaint)
        );
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }


    @Override
    public long getTotalComplaints() {
        return complaintRepository.count();
    }


    @Override
    public long getComplaintsByStatus(Status status) {
        System.out.println("Received status: " + status);
        return complaintRepository.countByStatus(status);
    }

    

}
