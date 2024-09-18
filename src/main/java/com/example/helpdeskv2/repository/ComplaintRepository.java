package com.example.helpdeskv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helpdeskv2.entity.Complaint;
import com.example.helpdeskv2.enums.Status;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

    long count();
    long countByStatus(Status status);

}

