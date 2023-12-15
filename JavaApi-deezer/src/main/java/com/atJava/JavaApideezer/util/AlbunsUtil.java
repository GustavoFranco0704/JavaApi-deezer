package com.atJava.JavaApideezer.util;

import com.atJava.JavaApideezer.model.Albuns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AlbunsUtil {
    private static final Logger logger = LoggerFactory.getLogger(AlbunsUtil.class);

    public Albuns getById(int id) {
        String uri = "https://api.deezer.com/album/" + id;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(uri))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client .send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            Albuns albuns = objectMapper.readValue(response.body(), Albuns.class);
            logger.debug("Albuns: {}", albuns);
            return albuns;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
