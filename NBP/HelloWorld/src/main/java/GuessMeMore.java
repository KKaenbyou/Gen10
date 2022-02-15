import java.util.Scanner;
import java.util.Random;

public class GuessMeMore {
    public static void main(String[] args) {
        
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        String guess;
        int answer =r.nextInt(100 + 100) -100 ;
        
        System.out.print("I have chosen a number between -100 and 100. Enter a guess: ");
        guess = s.nextLine();
        int input = Integer.parseInt(guess);
        
         while(answer != input) {
             if(input < answer) {
                System.out.print("Ha, nice try - too low! Try again! Guess: ");
                guess = s.nextLine();
                input = Integer.parseInt(guess);
            } else if(input > answer) {
                System.out.print("Too bad, way too high. Try again! Guess: ");
                guess = s.nextLine();
                input = Integer.parseInt(guess);
            }
         }     
        if(answer == input) {
           System.out.print("Wow, nice guess! That was it!");
       }
    }
}
