package com.example.proyectoAzertis.client;

import java.util.List;

public class TMDbClientResponseDTO {
    private int page;
    private List<TMDbClientResponseMovieDTO> results;
    private int totalPages;
    private int totalResults;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TMDbClientResponseMovieDTO> getResults() {
        return results;
    }

    public void setResults(List<TMDbClientResponseMovieDTO> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
