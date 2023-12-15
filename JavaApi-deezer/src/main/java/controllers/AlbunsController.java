import com.atJava.JavaApideezer.model.Albuns;
import com.atJava.JavaApideezer.util.AlbunsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albuns")
public class AlbunsController {
    private static final Logger logger = LoggerFactory.getLogger(AlbunsController.class);
    private final AlbunsUtil albunsUtil;

    public AlbunsController(AlbunsUtil albunsUtil) {
        this.albunsUtil = albunsUtil;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Albuns> getAlbumById(@PathVariable int id) {
        try {
            Albuns albuns = albunsUtil.getById(id);
            return ResponseEntity.ok(albuns);
        } catch (RuntimeException e) {
            logger.error("Erro ao obter álbum pelo ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createAlbum(@RequestBody Albuns album) {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body("Álbum criado com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao criar álbum", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar álbum");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable int id) {

        try {

            return ResponseEntity.ok("Álbum excluído com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao excluir álbum", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir álbum");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlbum(@PathVariable int id, @RequestBody Albuns updatedAlbum) {

        try {

            return ResponseEntity.ok("Álbum atualizado com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao atualizar álbum", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar álbum");
        }
    }
}

