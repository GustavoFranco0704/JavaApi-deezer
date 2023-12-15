package com.atJava.JavaApideezer;
import com.atJava.JavaApideezer.model.Artista;
import com.atJava.JavaApideezer.util.ArtistaUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ArtistaTest {

    @Test
    @DisplayName("Deve retorna um artista pelo id")
    public void testaArtistaPeloId(){
        ArtistaUtil artistaUtil = new ArtistaUtil();
        Artista artista = artistaUtil.getById(27);
        assertEquals("Mandrill", artista.getName());
        assertEquals(2727, artista.getId());

    }



}
