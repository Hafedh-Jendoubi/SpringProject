package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private TypeEtudiant typeEtudiant;
    @ManyToMany
    private Set<Reservation> reservations;
    @OneToMany(mappedBy = "etudiant")
    private Set<Tache> taches;
    @OneToOne
    private Tache tache;
}
