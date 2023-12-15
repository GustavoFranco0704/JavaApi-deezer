package com.atJava.JavaApideezer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Artista {
    private int id;
    private String name;
    private String link;
    private String share;
    private String picture;
    private int album;
    private boolean radio;

}
