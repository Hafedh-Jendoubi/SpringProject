package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Tache;
import com.esprit.tic.twin.springproject.repositories.TacheRepository;

import java.util.List;

public class TacheServiceImpl implements ITacheService{
    TacheRepository tacheRepository;

    @Override
    public List<Tache> retrieveAllTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache addTache(Tache t) {
        return tacheRepository.save(t);
    }

    @Override
    public Tache updateTache(Tache t) {
        return tacheRepository.save(t);
    }

    @Override
    public Tache retrieveTache(Long idTache) {
        return tacheRepository.findById(idTache).orElse(null);
    }

    @Override
    public void removeTache(Long idTache) {
        tacheRepository.deleteById(idTache);
    }
}
