package kk.bnc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kk.bnc.dto.BnC;
import kk.bnc.dto.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
// @Profile("database")
public class BnCDDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BnCDDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void begin() throws SQLException {
        Random random = new Random();
        int first = random.nextInt(10);
        int second = random.nextInt(10);
        int third = random.nextInt(10);
        int fourth = random.nextInt(10);
        while (first == second || first == third || first == fourth || second == third || second == fourth || third == fourth) {
            first = random.nextInt(10);
            second = random.nextInt(10);
            third = random.nextInt(10);
            fourth = random.nextInt(10);
        }

        String answer = Integer.toString(first) + Integer.toString(second) + Integer.toString(third) + Integer.toString(fourth);
        jdbcTemplate.update("INSERT INTO bnc(answer) VALUES(?)", answer);
    }

    public Round guess(int gameId, String guess) {
        BnC game = jdbcTemplate.queryForObject("SELECT * FROM bnc WHERE id = ?", new BnCMapper2(), gameId);
        int exact = 0;
        int partial = 0;
        String secret = game.getAnswer();
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1==c2)
                exact++;
            else{
                arr1[c1-'0']++;
                arr2[c2-'0']++;
            }    
        }
        for(int i=0; i<10; i++){
            partial += Math.min(arr1[i], arr2[i]);
        }

        if (exact == 4) {
            jdbcTemplate.update("UPDATE bnc SET finished = true WHERE id = ?", gameId);
        }

        jdbcTemplate.update("INSERT INTO round(gameId, guess, result, time) VALUES(?,?,?,?)", gameId, guess,
                ("e:" + exact + " p:" + partial), String.valueOf(LocalTime.now()));
        final String sql = "SELECT gameId, guess, result, time "
                + "FROM round ORDER BY id DESC LIMIT 0, 1;";

        return jdbcTemplate.queryForObject(sql, new roundMapper());
    }

    public List<BnC> getAll() {
        final String sql = "SELECT id, answer, finished FROM bnc;";
        return jdbcTemplate.query(sql, new BnCMapper());
    }
    
    public BnC findById(int id) {
        final String sql = "SELECT * FROM bnc WHERE id = ?;";
        return jdbcTemplate.queryForObject(sql, new BnCMapper(), id);
    }
    
    public List<Round> roundById(int gameId) {
        final String sql = "SELECT gameId, guess, result, time FROM round where gameid = ?;";
        return jdbcTemplate.query(sql, new roundMapper(), gameId);
    }

    private static final class BnCMapper implements RowMapper<BnC> {
        @Override
        public BnC mapRow(ResultSet rs, int index) throws SQLException {
            BnC td = new BnC();
            td.setId(rs.getInt("id"));
            if (rs.getBoolean("finished")) {
                td.setAnswer(rs.getString("answer"));
            } else if (!rs.getBoolean("finished")) {
                td.setAnswer("****");
            }
            td.setFinished(rs.getBoolean("finished"));
            return td;
        }
    }
    
    private static final class BnCMapper2 implements RowMapper<BnC> {
        @Override
        public BnC mapRow(ResultSet rs, int index) throws SQLException {
            BnC td = new BnC();
            td.setId(rs.getInt("id"));
            td.setAnswer(rs.getString("answer"));
            td.setFinished(rs.getBoolean("finished"));
            return td;
        }
    }

    private static final class roundMapper implements RowMapper<Round> {
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round td = new Round();
            td.setGameId(rs.getInt("gameId"));
            td.setGuess(rs.getString("guess"));
            td.setResult(rs.getString("result"));
            td.setTime(rs.getString("time"));
            return td;
        }
    }
}
