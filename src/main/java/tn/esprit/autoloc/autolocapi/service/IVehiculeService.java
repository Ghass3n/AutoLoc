package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;

public interface IVehiculeService {
    Vehicule create(Vehicule entite);

    Vehicule findById(Long id);

    List<Vehicule> findAll();

    Vehicule update(Long id, Vehicule entite);

    void deleteById(Long id);
}