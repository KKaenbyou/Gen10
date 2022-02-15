// @author Kenji Kaenbyou
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        
		// uw stands for User Win, cw stands for Computer Win
        int rounds, tie, uw, cw;
        boolean play = true;
        
        while(play) {
            Scanner s = new Scanner(System.in);
            rounds = start();
            System.out.println("Enter 0 for rock, 1 for paper, or 2 for scissors.");
            int user, comp;
            String playAgain;
            tie = 0;
            uw = 0; 
            cw = 0;
            
            for(int i = 0; i < rounds; i++) {
                user = user();
                comp = comp();
                if(comp == 0) {
                    System.out.println("I chose rock!");
                } else if(comp == 1) {
                    System.out.println("I chose paper!");
                } else if(comp == 2) {
                    System.out.println("I chose scissors!");
                }

                if(user == 0) {
                    if(comp == 0) {
                        System.out.println("It was a tie!");
                        tie++;
                    } else if(comp == 1) {
                        System.out.println("I win!");
                        cw++;
                    } else if(comp == 2) {
                        System.out.println("You win!");
                        uw++;
                    }
                }
                if(user == 1) {
                    if(comp == 0) {
                        System.out.println("You win!");
                        uw++;
                    } else if(comp == 1) {
                        System.out.println("It was a tie!");
                        tie++;
                    } else if(comp == 2) {
                        System.out.println("I win!");
                        cw++;
                    }
                }
                if(user == 2) {
                    if(comp == 0) {
                        System.out.println("I win!");
                        cw++;
                    } else if(comp == 1) {
                        System.out.println("You win!");
                        uw++;
                    } else if(comp == 2) {
                        System.out.println("It was a tie!");
                        tie++;
                    }
                }
            }
            
            System.out.println("There were " + tie + " ties, you won " + uw + " times, and I won " + cw + " times.");
            if(uw == cw){
                System.out.println("We tied!");
            } else if(uw > cw){
                System.out.println("You won!");
            } else if(uw < cw){
                System.out.println("I won!");
            }
            
            System.out.println("Would you like to play again? y/n");
            playAgain = s.nextLine();
            if(playAgain.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing!");
                System.exit(0);
            }
        }
    }
    
    // Sets the user's choice
    public static int user() {
        Scanner s = new Scanner(System.in);
        int user;
        String u;        
        u = s.nextLine();
        user = Integer.parseInt(u);
        return user;
    }
    
    // Sets the computer's choice
    public static int comp() {
        Random r = new Random();
        int comp;
        comp = r.nextInt(3);
        return comp;
    }
    
    // Welcomes the user and sets the number of rounds to their input. 
    // If the userinput is invalid, displays an error message and terminates the program
    public static int start() {
        Scanner s = new Scanner(System.in);
        int rounds;
        String r;
        System.out.println("Welcome to Rock Paper Scissors! How many rounds would you like to play? \n"
                + "(maximum 10 rounds, minimum 1 round)");
        r = s.nextLine();
        rounds = Integer.parseInt(r);
        if(rounds < 1 || rounds > 10) {
            System.out.println("Sorry, that is an invalid number of rounds.");
            System.exit(0);
        }
        return rounds;
    }
}