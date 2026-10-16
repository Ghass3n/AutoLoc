package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Contrat;

public interface IContratService {
    Contrat create(Contrat entite);

    Contrat findById(Long id);

    List<Contrat> findAll();

    Contrat update(Long id, Contrat entite);

    void deleteById(Long id);
}