package com.example.helpdeskv2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helpdeskv2.entity.Client;
import com.example.helpdeskv2.interfaces.ClientService;
import com.example.helpdeskv2.repository.AgentRepository;
import com.example.helpdeskv2.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Client addClient(Client client) {
        client.setCreationDate(new Date());
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id).orElse(null);
        if (clientDetails != null) {
            client.setClientName(clientDetails.getClientName());
            client.setClientCardId(clientDetails.getClientCardId());
            client.setClientMail(clientDetails.getClientMail());
            client.setComplaints(clientDetails.getComplaints());
        }
        return client;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.findById(id).ifPresent(
                client -> clientRepository.delete(client)
        );
    }
}

