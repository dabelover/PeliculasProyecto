package com.example.proyectoAzertis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmsController {

    private final FilmsRepository filmsRepository;

    @Autowired
    public FilmsController(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFilms") // Exponer al público
    public void getFilmList(@RequestParam String name){


        // TODO Llamar a Servicio
        // TODO Mapear DTO
        // Olvidar todo lo que se de java (casi todo)

        Movie movie = filmsRepository.A(name);
    }


}
