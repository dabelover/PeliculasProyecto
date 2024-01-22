package com.example.proyectoAzertis.client;

import com.example.proyectoAzertis.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie map(TMDbClientResponseMovieDTO dto) {
        Movie movie = new Movie();

        movie.setAdult(dto.adult);
        movie.setBackdropPath(dto.backdropPath);
        movie.setGenreIds(dto.genreIds);
        movie.setId(dto.id);
        movie.setOriginalLanguage(dto.originalLanguage);
        movie.setOriginalTitle(dto.originalTitle);
        movie.setOverview(dto.overview);
        movie.setPopularity(dto.popularity);
        movie.setPosterPath(dto.posterPath);
        movie.setReleaseDate(dto.releaseDate);
        movie.setTitle(dto.title);
        movie.setVideo(dto.video);
        movie.setVoteAverage(dto.voteAverage);
        movie.setVoteCount(dto.voteCount);

        return movie;
    }
}
