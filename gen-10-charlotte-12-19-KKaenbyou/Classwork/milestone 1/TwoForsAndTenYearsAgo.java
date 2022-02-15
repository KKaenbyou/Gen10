import java.util.Scanner;

public class TwoForsAndTenYearsAgo {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");
        // The starting range is the user input number and the stopping range is 10 years ago
        // The first one is more clear to me but I cannot discern why

        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
}