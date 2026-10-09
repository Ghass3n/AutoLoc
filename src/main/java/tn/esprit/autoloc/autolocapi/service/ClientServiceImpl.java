package tn.esprit.autoloc.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.autolocapi.domain.Client;
import tn.esprit.autoloc.autolocapi.repository.IClientRepository;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private static final ZoneId ZONE = ZoneId.of("Africa/Tunis");

    private final IClientRepository clientRepository;

    @Override
    @Transactional
    public Client create(Client client) {
        if (client.getDateInscription() == null) {
            client.setDateInscription(LocalDate.now(ZONE));
        }
        return clientRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client getById(Long id) {
        return findOrThrow(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client update(Long id, Client client) {
        Client existing = findOrThrow(id);
        existing.setNom(client.getNom());
        existing.setPrenom(client.getPrenom());
        existing.setEmail(client.getEmail());
        existing.setTelephone(client.getTelephone());
        existing.setNumPermis(client.getNumPermis());
        return clientRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientRepository.delete(findOrThrow(id));
    }

    private Client findOrThrow(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : " + id));
    }
}