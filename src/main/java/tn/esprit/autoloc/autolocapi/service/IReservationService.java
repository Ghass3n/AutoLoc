package tn.esprit.autoloc.autolocapi.service;

import java.util.List;
import tn.esprit.autoloc.autolocapi.domain.Reservation;

public interface IReservationService {
    Reservation create(Reservation entite);

    Reservation findById(Long id);

    List<Reservation> findAll();

    Reservation update(Long id, Reservation entite);

    void deleteById(Long id);
}