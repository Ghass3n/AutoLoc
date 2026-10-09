package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;

public interface IVehiculeService {
    Vehicule create(Vehicule vehicule);
    Vehicule getById(Long id);
    List<Vehicule> getAll();
    Vehicule update(Long id, Vehicule vehicule);
    void delete(Long id);
}