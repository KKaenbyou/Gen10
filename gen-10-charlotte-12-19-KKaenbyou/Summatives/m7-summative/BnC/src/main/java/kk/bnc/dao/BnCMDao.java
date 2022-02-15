package kk.bnc.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import kk.bnc.dto.BnC;
import kk.bnc.dto.Round;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;


@Repository
//@Profile("memory")
public class BnCMDao {
    
    private static final List<BnC> BnCList = new ArrayList<>();
    private static final List<Round> roundList = new ArrayList<>();

    public BnC begin() {
        int nextId = BnCList.stream()
                .mapToInt(i -> i.getId())
                .max()
                .orElse(0) + 1;
        BnC game = new BnC();
        game.setId(nextId);
        
        Random random = new Random();
        int first = random.nextInt(10);
        int second = random.nextInt(10);
        int third = random.nextInt(10);
        int fourth = random.nextInt(10);
        while(first == second || first == third || first == fourth || second == third || second == fourth || third == fourth) {
            first = random.nextInt(10);
            second = random.nextInt(10);
            third = random.nextInt(10);
            fourth = random.nextInt(10);
        }
        
        String answer = Integer.toString(first) + Integer.toString(second) + Integer.toString(third) + Integer.toString(fourth);
        game.setAnswer(answer);
        BnCList.add(game);
        return game;
    }
    
    public Round guess(int gameId, String guess) {
        BnC game = BnCList.get(gameId - 1);
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
        
        if(exact == 4) {
            game.setFinished(true);
            BnCList.set(gameId - 1, game);
        }
        
        Round round = new Round();
        round.setGameId(gameId);
        round.setGuess(guess);
        round.setResult("e:" + exact + " p:" + partial);
        round.setTime(String.valueOf(LocalTime.now()));
        roundList.add(round);
        return round;
    }

    //@Override
    public List<BnC> getAll() {
        return new ArrayList<>(BnCList);
    }

    //@Override
    public BnC findById(int id) {
        return BnCList.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //@Override
    public boolean update(BnC todo) {
        int index = 0;
        while (index < BnCList.size()
                && BnCList.get(index).getId() != todo.getId()) {
            index++;
        }

        if (index < BnCList.size()) {
            BnCList.set(index, todo);
        }
        return index < BnCList.size();
    }

    //@Override
    public boolean deleteById(int id) {
        return BnCList.removeIf(i -> i.getId() == id);
    }
}
