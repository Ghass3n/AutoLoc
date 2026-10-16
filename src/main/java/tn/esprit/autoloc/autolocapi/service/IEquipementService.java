package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Equipement;

public interface IEquipementService {
    Equipement create(Equipement entite);

    Equipement findById(Long id);

    List<Equipement> findAll();

    Equipement update(Long id, Equipement entite);

    void deleteById(Long id);
}