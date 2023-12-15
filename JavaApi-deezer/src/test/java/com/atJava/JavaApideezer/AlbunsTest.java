package com.atJava.JavaApideezer;

import com.atJava.JavaApideezer.model.Albuns;
import com.atJava.JavaApideezer.util.AlbunsUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AlbunsTest {
    private static final Logger logger = LoggerFactory.getLogger(AlbunsTest.class);
    @Test
    @DisplayName("Deve retornar o Album pelo id ")

    public void testaAlbumPeloId() {
        AlbunsUtil albunsUtil = new AlbunsUtil();
        logger.info("Iniciando teste");
        Albuns albuns = albunsUtil.getById(302127);
        logger.info("Resultado do getById: {}", albuns);
        assertEquals("Discovery", albuns.getTitle());
        assertEquals(302127, albuns.getId());
    }
}
