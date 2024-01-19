package com.example.proyectoAzertis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.netty.handler.codec.http.HttpHeaders.addHeader;

@Service
public class FilmsRepository {

    private final ObjectMapper objectMapper;

    @Autowired
    public FilmsRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Movie A(String movie){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/search/movie?")
                .get()

                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4YjRjNjg3MjdmMTRjMjJjZWQyOWIwMzhmYTM0MzI2YiIsInN1YiI6IjY1YTc5YWZkMDViNTQ5MDBjNWE4MTZjOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O5s5rffnD274aSbu1io0hFZxfqX1zslhp0M3sNa4Ym8")
                .build();

        Response response = client.newCall(request).execute();

        return objectMapper.readValue("", Movie.class);
    }
}
