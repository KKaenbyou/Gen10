import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args) {
     
        Scanner s = new Scanner(System.in);
        String guess;
        int a = 9;
        
        System.out.print("I have chosen a number. Enter a guess: ");
        guess = s.nextLine();
        int b = Integer.parseInt(guess);
        
        if(a == b) {
            System.out.print("Wow, nice guess! That was it!");
        } else if(b < a) {
            System.out.print("Ha, nice try - too low! I chose " + a);
        } else if(b > a) {
            System.out.print("Too bad, way too high. I chose " + a);
        }
    }
}
