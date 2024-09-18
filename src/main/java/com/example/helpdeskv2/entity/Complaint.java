package com.example.helpdeskv2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

import com.example.helpdeskv2.enums.Category;
import com.example.helpdeskv2.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Complaint {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date creationDate;
    private String description;

    @Column(name = "status",length = 50)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "category",length = 50)
    private Category category;

    @ManyToOne
    private Client client;

    @JsonIgnoreProperties({"complaints"})
    @ManyToOne
    private Agent agent;

}
