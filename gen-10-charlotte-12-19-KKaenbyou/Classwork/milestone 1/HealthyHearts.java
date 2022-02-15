// @Author Kenji Kaenbyou
import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        String age;
        double max, hr1, hr2;
        
        System.out.print("What is your age? ");
        age = s.nextLine();
        double a = Double.parseDouble(age);
        max = 220 - a;
        hr1 = max * 0.5;
        hr2 = max * 0.85;
        
        System.out.println("Your maximum heart rate should be " + max + " beats per minute.");
        System.out.println("Your target HR Zone is " + hr1 + " - " + hr2 + "beats per minute.");
    }    
}
