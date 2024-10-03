package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Reservation implements Serializable {
    @Id
    private String idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;
    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiants;
}
