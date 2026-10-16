package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Employe;

public interface IEmployeService {
    Employe create(Employe entite);

    Employe findById(Long id);

    List<Employe> findAll();

    Employe update(Long id, Employe entite);

    void deleteById(Long id);
}