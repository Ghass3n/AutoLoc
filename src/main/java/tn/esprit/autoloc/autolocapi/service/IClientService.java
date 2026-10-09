package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Client;

public interface IClientService {
    Client create(Client client);
    Client getById(Long id);
    List<Client> getAll();
    Client update(Long id, Client client);
    void delete(Long id);
}