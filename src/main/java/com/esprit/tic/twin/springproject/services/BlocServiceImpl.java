package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Bloc;
import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.repositories.BlocRepository;
import com.esprit.tic.twin.springproject.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Bloc> retrieveBlocsJPQL(String s) {
        return blocRepository.retrieveBlocs(s);
    }

    @Override
    public List<Bloc> retrieveBlocsKeywords(String s) {
        return blocRepository.findByFoyerUniversiteNomUniversite(s);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        //That's not good! Bad behaviours.. Posting SQL queries inside a a loop is bad in terms of optimization.
        numChambre.stream().forEach(
                numeroChambre -> {
                    Chambre c = chambreRepository.findByNumeroChambre(numeroChambre);
                    c.setBloc(bloc);
                    chambreRepository.save(c);
                }
        );
        return bloc;
    }
}
