package com.example.helpdeskv2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helpdeskv2.enums.Status;

@RestController
public class StatusController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/status")
    public Status[] getStatus() {
        return Status.values();
    }
}
