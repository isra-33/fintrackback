package com.example.helpdeskv2.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helpdeskv2.entity.Complaint;
import com.example.helpdeskv2.enums.Status;
import com.example.helpdeskv2.interfaces.ComplaintService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintService.addComplaint(complaint);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestBody Complaint complaintDetails) {
        return complaintService.updateComplaint(id, complaintDetails);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/count")
    public long getTotalComplaints() {
        return complaintService.getTotalComplaints();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/count/status")
    public long getComplaintsByStatus(@RequestParam Status status) {
        return complaintService.getComplaintsByStatus(status);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/assigned-complaints")
    public List<Complaint> getAssignedComplaints(@RequestHeader("agentId") Long agentId) { 
        return complaintService.getComplaintsByAgent(agentId); 
    }


}
