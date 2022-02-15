// @author Kenji Kaenbyou
import java.util.Scanner;
import java.util.Random;

public class DogGenetics {
    public static void main(String[] args) {        
        Scanner s = new Scanner(System.in);
        String dog;
        
        System.out.println("What is your dog's name?");
        dog = s.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dog
                + "'s prestigious background right here.");
        System.out.println(dog + "'s breed is");
        genes();
        System.out.println("Wow, that's QUITE the dog!: ");
    }
    
    public static void genes() {
        Random r = new Random();
        int a = r.nextInt(100);
        int b = r.nextInt(100 - a);
        int c = r.nextInt(100 - a - b);
        int d = r.nextInt(100 - a - b - c);
        int e = 100 - a - b - c - d;
        
        System.out.println(a + "% St. Bernard");
        System.out.println(b + "% Chihuahua");
        System.out.println(c + "% Dramatic RedNosed Asian Pug");
        System.out.println(d + "% Common Cur");
        System.out.println(e + "% King Doberman");
    }
}