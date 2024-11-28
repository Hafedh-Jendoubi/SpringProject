package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
import com.esprit.tic.twin.springproject.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService{
    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambresParNomBlocAndTypeChambre(String s, TypeChambre t) {
        return chambreRepository.findByBlocNomBlocAndTypeC(s, t);
    }

    @Scheduled(fixedRate = 60000)
    void pourcentageChambreParTypeChambre() {
        int nbTotalsChambres = chambreRepository.findAll().size();
        log.info("nbTotalsChambres : " + nbTotalsChambres);
        log.info("le pourcentage des chambres pour le type SIMPLE est égale à " + (chambreRepository.nbTypeChambre(TypeChambre.SIMPLE) / nbTotalsChambres) * 100);
        log.info("le pourcentage des chambres pour le type DOUBLE est égale à " + (chambreRepository.nbTypeChambre(TypeChambre.DOUBLE) / nbTotalsChambres) * 100);
        log.info("le pourcentage des chambres pour le type TRIPLE est égale à " + (chambreRepository.nbTypeChambre(TypeChambre.TRIPLE) / nbTotalsChambres) * 100);
    }
}
