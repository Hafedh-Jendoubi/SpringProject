package com.esprit.tic.twin.springproject.controllers;

import com.esprit.tic.twin.springproject.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BlocRestController {
    IBlocService blocService;
}