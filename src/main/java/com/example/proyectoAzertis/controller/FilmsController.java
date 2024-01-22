package com.example.proyectoAzertis.controller;

import com.example.proyectoAzertis.client.FilmsRepository;
import com.example.proyectoAzertis.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FilmsController {

    private final FilmsRepository filmsRepository;

    @Autowired
    public FilmsController(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFilms") // Exponer al público
    @ResponseBody
    public List<Movie> getFilmList(@RequestParam String name){
        return filmsRepository.getMovies(name);
    }

}
