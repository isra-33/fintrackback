package com.example.helpdeskv2.interfaces;

import java.util.*;

import com.example.helpdeskv2.entity.Client;

public interface ClientService {
    Client addClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
    Client updateClient(Long id, Client clientDetails);
    void deleteClient(Long id);
}

