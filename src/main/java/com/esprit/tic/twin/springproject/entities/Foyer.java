package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Foyer implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
    @OneToOne
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;
}
