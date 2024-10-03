package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Foyer implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;
    @OneToOne
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;
}
