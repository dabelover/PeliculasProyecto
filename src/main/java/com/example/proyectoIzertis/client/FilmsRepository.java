package com.example.proyectoIzertis.client;

import com.example.proyectoIzertis.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FilmsRepository {

    private final MovieMapper movieMapper;
    private final String tmdbApiKey;

//    @Autowired
//    public FilmsRepository(MovieMapper movieMapper) {
//        this.movieMapper = movieMapper;
//    }

    @Autowired
    public FilmsRepository(@Value("${tmdb.api.key}") String tmdbApiKey, MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
        this.tmdbApiKey = tmdbApiKey;
    }

    public List<Movie> getMovies(String movieName) {
        String uri = String.format("https://api.themoviedb.org/3/search/movie?query=%s&include_adult=%s&language=%s&page=%d",
                movieName, false, "en-US", 1);
        List<Movie> movieList = new ArrayList<Movie>();

        TMDbClientResponseDTO tmdbResponse = WebClient.create()
                .get()
                .uri(uri)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4YjRjNjg3MjdmMTRjMjJjZWQyOWIwMzhmYTM0MzI2YiIsInN1YiI6IjY1YTc5YWZkMDViNTQ5MDBjNWE4MTZjOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O5s5rffnD274aSbu1io0hFZxfqX1zslhp0M3sNa4Ym8")
                .retrieve()
                .bodyToMono(TMDbClientResponseDTO.class)
                .block();

        return tmdbResponse.getResults()
                .stream()
                .map(movieMapper::map)
                .collect(Collectors.toList());
    }
}
