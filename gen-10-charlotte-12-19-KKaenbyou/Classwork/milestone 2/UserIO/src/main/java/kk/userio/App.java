// @author Kenji Kaenbyou

package kk.userio;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        double x, y;
        int z;
        Scanner s = new Scanner(System.in);
        System.out.println("Greetings user. This is a simple calculator program.");
        SimpleCalculator sc = new SimpleCalculator();
        
        while(true) {            
            System.out.println("Enter 1 for addition, 2 for subtraction, 3 for multiplication,"
                    + " 4 for division, or 5 to exit this program.");
            z = s.nextInt();
            
            if(z == 5) {
                System.out.println("Thank you for using this calculator.");
                System.exit(0);
            } else if(z == 1) {
                System.out.println("Please enter the first that number you want to add to.");
                x = s.nextDouble();
                System.out.println("Please enter the second number you want to add.");
                y = s.nextDouble();
                System.out.println("The result is: " + sc.add(x, y));
            } else if(z == 2) {
                System.out.println("Please enter the first number that you want to subtract from.");
                x = s.nextDouble();
                System.out.println("Please enter the second number you want to subtract.");
                y = s.nextDouble();
                System.out.println("The result is: " + sc.sub(x, y));
            } else if(z == 3) {
                System.out.println("Please enter the first number you want to multiply.");
                x = s.nextDouble();
                System.out.println("Please enter the second number you want to multiply by.");
                y = s.nextDouble();
                System.out.println("The result is: " + sc.mult(x, y));
            } else if(z == 4) {
                System.out.println("Please enter the first number that you want to divide from.");
                x = s.nextDouble();
                System.out.println("Please enter the second number you want to divide by.");
                y = s.nextDouble();
                System.out.println("The result is: " + sc.div(x, y));
            }
        }
    }
}