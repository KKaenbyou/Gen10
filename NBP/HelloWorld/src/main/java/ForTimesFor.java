import java.util.Scanner;

public class ForTimesFor {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int answer = 0;
        int points = 0;
        
        System.out.print("Which times table shall I recite? ");
        String input = s.nextLine();
        int table = Integer.parseInt(input);
        
        for(int i = 1; i <= 15; i++) {
            answer = i * table;
            System.out.println(i + " times " + table + " equals? ");
            String input2 = s.nextLine();
            int guess = Integer.parseInt(input2);
            if(guess == answer) {
                System.out.println("Correct!");
                points++;
            } else {
                System.out.println("Incorrect! The answer is " + answer);
            }
        }
        
        System.out.println("You got " + points + " correct.");
        if(points > 13) {
            System.out.println("You got over 90% right! Congratulations!");
        }
        if(points < 8) {
            System.out.println("You got less than half right, you should study more.");
        }
    }
}
