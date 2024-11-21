package com.esprit.tic.twin.springproject.controllers;

import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/remove-reservation/{id-reservation}")
    public void removeReservation(@PathVariable("id-reservation") String idReservation) {
        reservationService.removeReservation(idReservation);
    }
}
