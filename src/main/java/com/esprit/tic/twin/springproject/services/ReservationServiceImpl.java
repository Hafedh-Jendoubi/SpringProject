package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.repositories.ChambreRepository;
import com.esprit.tic.twin.springproject.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation affecterReservationAChambre(String idReservation, Long idChambre) {
        Reservation reservation = reservationRepository.findByIdReservation(idReservation);
        Chambre chambre = chambreRepository.findByIdChambre(idChambre);

        chambre.getReservations().add(reservation);
        chambreRepository.save(chambre);

        return null;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(LocalDate dateDebut, LocalDate dateFin) {
        return reservationRepository.getReservationParAnneeUniversitaire(dateDebut, dateFin);
    }
}
