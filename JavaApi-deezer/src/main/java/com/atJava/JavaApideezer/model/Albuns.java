package com.atJava.JavaApideezer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
@SpringBootApplication
@Data
public class Albuns {
    private int id;
    private String title;
    private String upc;
    private String link;
    private String share;
    private String cover;
    private String label;
    private int nb_Tracks;
    private LocalDate release_Date;
}
