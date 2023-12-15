package controllers;

import com.atJava.JavaApideezer.model.Artista;
import com.atJava.JavaApideezer.util.ArtistaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    private static final Logger logger = LoggerFactory.getLogger(ArtistaController.class);
    private final ArtistaUtil artistaUtil;

    public ArtistaController(ArtistaUtil artistaUtil) {
        this.artistaUtil = artistaUtil;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> getArtistaById(@PathVariable int id) {
        try {
            Artista artista = artistaUtil.getById(id);
            return ResponseEntity.ok(artista);
        } catch (RuntimeException e) {
            logger.error("Erro ao obter artista pelo ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createArtista(@RequestBody Artista artista) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body("Artista criado com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao criar artista", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar artista");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArtista(@PathVariable int id) {

        try {

            return ResponseEntity.ok("Artista excluído com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao excluir artista", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir artista");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateArtista(@PathVariable int id, @RequestBody Artista updatedArtista) {

        try {

            return ResponseEntity.ok("Artista atualizado com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao atualizar artista", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar artista");
        }
    }
}
