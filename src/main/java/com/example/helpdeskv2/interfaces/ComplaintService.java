package com.example.helpdeskv2.interfaces;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.helpdeskv2.entity.Complaint;
import com.example.helpdeskv2.enums.Status;

public interface ComplaintService {

    Complaint addComplaint(Complaint complaint);
    Complaint updateComplaint(Long id, Complaint complaintDetails);
    //Complaint statusComplaint(Long id);
    void deleteComplaint(Long id);
    List<Complaint> getAllComplaints();
    Complaint getComplaintById(Long id);

    long getTotalComplaints();
    long getComplaintsByStatus(Status status);
    List<Complaint> getComplaintsByAgent(Long agentId);

    

}
