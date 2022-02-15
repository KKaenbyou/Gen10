import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args) {
        
        Random r = new Random();
        boolean isHeads = r.nextBoolean();
        System.out.println("Ready, Set, Flip....!!");
        
        if(isHeads) {
            System.out.println("You got HEADS!");
        } else {
            System.out.println("You got TAILS!");
        }
    }
}
