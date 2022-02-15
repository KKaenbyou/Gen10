package kk.bnc.cont;

import java.sql.SQLException;
import java.util.List;
import kk.bnc.dao.BnCDDao;
import kk.bnc.dao.BnCMDao;
import kk.bnc.dto.BnC;
import kk.bnc.dto.Round;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bnc")
public class BnCCont {
    
    private final BnCDDao dao;
    //private final BnCMDao dao;

    public BnCCont(BnCDDao dao) {
        this.dao = dao;
    }
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public void begin() throws SQLException {
        dao.begin();
    }
    
    @PostMapping("/guess")
    public Round guess(int gameId, String guess) {
        return dao.guess(gameId, guess);
    }
    
    @GetMapping("/game")
    public List<BnC> all() {
        return dao.getAll();
    }
    
    @GetMapping("/game/{id}")
    public ResponseEntity<BnC> findById(@PathVariable int id) {
        BnC result = dao.findById(id);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/rounds/{id}")
    public List<Round> roundById(@PathVariable int id) {
        return dao.roundById(id);
    }
}
