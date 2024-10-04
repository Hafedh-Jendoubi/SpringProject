package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Bloc implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
    @ManyToOne
    Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambres;
}
