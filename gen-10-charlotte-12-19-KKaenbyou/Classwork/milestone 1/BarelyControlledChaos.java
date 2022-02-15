import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {
        
        String color = ranColor(); 
        String animal = ranimal(); 
        String colorAgain = ranColor();
        int weight = ranRange(5, 200);
            // with a range between 5 - 200 
        int distance = ranRange(10, 20); 
            // with a range between 10 - 20 
        int number = ranRange(10000, 20000); 
            // with a range between 10000 - 20000 
        int time = ranRange(2, 6); 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");
        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");
        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");
        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    }
    
    public static int ranRange(int x, int y) {
        Random r = new Random();
        int z = r.nextInt((y - x) + 1) + x;
        return z;
    }
    
    public static String ranColor() {
        Random r = new Random();
        String c = null;
        int x = r.nextInt(4);
        switch(x) {
            case 0:
                c = "Red";
            break;
            case 1:
                c = "Blue";
            break;
            case 2:
                c = "Yellow";
            break;
            case 3:
                c = "Green";
            break;
            case 4:
                c = "Purple";
            break;
        }
        return c;
    }
    
    public static String ranimal() {
        Random r = new Random();
        String c = null;
        int x = r.nextInt(4);
        switch(x) {
            case 0:
                c = "Dog";
            break;
            case 1:
                c = "Cat";
            break;
            case 2:
                c = "Bird";
            break;
            case 3:
                c = "Fish";
            break;
            case 4:
                c = "Insect";
            break;
        }
        return c;
    }
}