package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Client;

public interface IClientService {
    Client create(Client entite);

    Client findById(Long id);

    List<Client> findAll();

    Client update(Long id, Client entite);

    void deleteById(Long id);
}