import java.util.Random;
import java.util.Scanner;

public class HighRoller {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Random diceRoller = new Random();
        int rollResult = diceRoller.nextInt(6) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        }
        
        System.out.println("Now it's your turn. How many sides does your dice have?");
        String sides = s.nextLine();
        int x = Integer.parseInt(sides);
        int y = diceRoller.nextInt(x) + 1;
        System.out.println("You rolled a " + y);
        
        switch(y) {
            case 1:
                System.out.println("You rolled a critical failure!");
            break;
            case 99:
                System.out.println("You rolled a critical! Nice Job!");
            break;
        }
    }
}