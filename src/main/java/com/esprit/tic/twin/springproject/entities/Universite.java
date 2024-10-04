package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    @OneToOne(mappedBy = "universite")
    Foyer foyer;
}
