// @author Kenji Kaenbyou

package kk.enummath;
import java.util.Scanner;

public class IntMath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       int x, y, c;
       String choice, user;
       
       while(true) {
           System.out.println("Enter 1 to add, 2 to subtract, 3 to multiply, 4 to divide, or 0 to exit.");
            choice = s.nextLine();
            c = Integer.parseInt(choice);
            
            switch(c) {
                case 1:
                     System.out.println("Enter the number to add to.");
                     user = s.nextLine();
                     x = Integer.parseInt(user);
                     System.out.println("Enter the number to add.");
                     user = s.nextLine();
                     y = Integer.parseInt(user);
                     System.out.println("The result is " + calculate(MathOperator.PLUS, x, y));
                     break;
               case 2:
                     System.out.println("Enter the number to subtract from.");
                     user = s.nextLine();
                     x = Integer.parseInt(user);
                     System.out.println("Enter the number to subtract.");
                     user = s.nextLine();
                     y = Integer.parseInt(user);
                     System.out.println("The result is " + calculate(MathOperator.MINUS, x, y));
                     break;
               case 3:
                     System.out.println("Enter the number to multiply.");
                     user = s.nextLine();
                     x = Integer.parseInt(user);
                     System.out.println("Enter the number to multiply by.");
                     user = s.nextLine();
                     y = Integer.parseInt(user);
                     System.out.println("The result is " + calculate(MathOperator.MULTIPLY, x, y));
                     break;
               case 4:
                     System.out.println("Enter the number to divide from.");
                     user = s.nextLine();
                     x = Integer.parseInt(user);
                     System.out.println("Enter the number to divide by.");
                     user = s.nextLine();
                     y = Integer.parseInt(user);
                     System.out.println("The result is " + calculate(MathOperator.DIVIDE, x, y) + " with a remainder of " + (x % y));
                     break;
               case 0:
                   System.out.println("Program Terminated.");
                   System.exit(0);
               default:
                   System.out.println("Unknown Command.");
         }
       }
    }
    
    public enum MathOperator {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }
    
    public static int calculate(MathOperator operator, int operand1, int operand2) {
        switch(operator) {
                case PLUS:
                      return operand1 + operand2;
                case MINUS:
                      return operand1 - operand2;
                case MULTIPLY:
                      return operand1 * operand2;
                case DIVIDE:
                      return operand1 / operand2;
                default:
                      throw new UnsupportedOperationException();
        }
   }
}