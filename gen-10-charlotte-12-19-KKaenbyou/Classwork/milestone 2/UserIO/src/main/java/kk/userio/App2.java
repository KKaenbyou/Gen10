// @author Kenji Kaenbyou

package kk.userio;
import java.util.Scanner;

public class App2 extends User {
    public static void main(String[] args) {
        
        double x, y;
        int z;
        User u = new User();
        Scanner s = new Scanner(System.in);
        u.print("Greetings user. This is a simple calculator program.");
        SimpleCalculator sc = new SimpleCalculator();
        
        while(true) {            
            u.print("Enter 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division, or 5 to exit this program.");
            z = s.nextInt();
            
            if(z == 1) {
                x = u.readDouble("Please enter the first that number you want to add to.");
                y = u.readDouble("Please enter the second number you want to add.");
                u.print("The result is: " + sc.add(x, y));
            } else if(z == 2) {
                x = u.readDouble("Please enter the first number that you want to subtract from.");
                y = u.readDouble("Please enter the second number you want to subtract.");
                u.print("The result is: " + sc.sub(x, y));
            } else if(z == 3) {
                x = u.readDouble("Please enter the first number you want to multiply.");
                y = u.readDouble("Please enter the second number you want to multiply by.");
                u.print("The result is: " + sc.mult(x, y));
            } else if(z == 4) {
                x = u.readDouble("Please enter the first number that you want to divide from.");
                y = u.readDouble("Please enter the second number you want to divide by.");
                u.print("The result is: " + sc.div(x, y));
            } else if(z == 5) {
                u.print("Thank you for using this calculator.");
                System.exit(0);
            }
        }
    }
}