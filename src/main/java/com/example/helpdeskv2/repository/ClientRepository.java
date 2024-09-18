package com.example.helpdeskv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helpdeskv2.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}