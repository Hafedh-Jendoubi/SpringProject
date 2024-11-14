package com.esprit.tic.twin.springproject.controllers;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
import com.esprit.tic.twin.springproject.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChambreRestController {
    IChambreService chambreService;

    @GetMapping("/retrieve-blocs-keywords/{nom-bloc}/{type-chambre}")
    public List<Chambre> retrieveBlocsByNameAndTypeChambre(@PathVariable("nom-bloc") String s, @PathVariable("type-chambre") TypeChambre t) {
        return chambreService.getChambresParNomBlocAndTypeChambre(s, t);
    }
}
