package com.example.helpdeskv2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helpdeskv2.enums.Role;

@RestController
public class RoleController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/roles")
    public Role[] getRoles() {
        return Role.values();
    }
}
