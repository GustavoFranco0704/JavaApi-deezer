package com.atJava.JavaApideezer.util;

import com.atJava.JavaApideezer.model.Artista;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ArtistaUtil {
    public Artista getById(int id) {
        String uri = "https://api.deezer.com/artist/27" + id;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(uri))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient cliente = HttpClient.newBuilder().build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            Artista artista = objectMapper.readValue(response.body(), Artista.class);
            System.out.println(artista);
            return artista;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
