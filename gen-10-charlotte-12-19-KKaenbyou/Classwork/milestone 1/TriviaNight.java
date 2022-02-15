import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
     
        Scanner s = new Scanner(System.in);
        String a, b, c;
        int d = 0;
        
        System.out.print("What is 2 + 2? \n A. 1 \n B. 2 \n C. 3 \n D. 4 \n Your Answer: ");
        a = s.nextLine();
        System.out.print("What is 4 + 4? \n A. 2 \n B. 4 \n C. 6 \n D. 8 \n Your Answer: ");
        b = s.nextLine();
        System.out.print("What is 8 + 8? \n A. 4 \n B. 8 \n C. 12 \n D. 16 \n Your Answer: ");
        c = s.nextLine();
        
        if(a.equalsIgnoreCase("d")) {
            d++;
        }
        if(b.equalsIgnoreCase("d")) {
            d++;
        }
        if(c.equalsIgnoreCase("d")) {
            d++;
        }
        System.out.println("You got " + d + " correct!");
    }
}
