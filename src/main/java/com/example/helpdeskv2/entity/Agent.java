package com.example.helpdeskv2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import com.example.helpdeskv2.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString 
@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String agentName;

    @Column(unique = true, length = 100, nullable = false)
    private String agentEmail;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String password ;
   
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"client", "category", "status", "description", "agent", "creationDate"})
    private List<Complaint> complaints;

    public Agent(String agentName, String agentEmail, String password, Role role) {
        this.agentName = agentName;
        this.agentEmail = agentEmail;
        this.password = password; // Assuming password is a field
        this.role = role;
    }

}
