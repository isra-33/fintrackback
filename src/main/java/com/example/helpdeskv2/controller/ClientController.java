package com.example.helpdeskv2.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helpdeskv2.entity.Client;
import com.example.helpdeskv2.interfaces.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public Client createClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        return clientService.updateClient(id, clientDetails);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
