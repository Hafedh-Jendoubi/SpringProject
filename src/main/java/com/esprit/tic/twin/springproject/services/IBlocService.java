package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Bloc;
import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc(Bloc b);
    Bloc updateBloc(Bloc b);
    Bloc retrieveBloc(Long idBloc);
    void removeBloc(Long idBloc);
}
