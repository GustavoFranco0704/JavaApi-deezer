package com.atJava.JavaApideezer;

import com.atJava.JavaApideezer.model.Albuns;
import com.atJava.JavaApideezer.util.AlbunsUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
class AlbunsControllerTest {

    @Mock
    private AlbunsUtil albunsUtil;

    @InjectMocks
    private AlbunsController albunsController;

    @Test
    void testGetAlbumById() {
        Mockito.when(albunsUtil.getById(anyInt()))
                .thenReturn(new Albuns(227);

        ResponseEntity<Albuns> responseEntity = albunsController.getAlbumById(1);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getTitle()).isEqualTo("Album Teste");


        assertThrows(RuntimeException.class, () -> albunsController.getAlbumById(999));
    }
}