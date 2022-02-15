import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
     
        Scanner s = new Scanner(System.in);
        String name, year;
        
        System.out.print("Hello. What's your name? ");
        name = s.nextLine();
        System.out.print("What year were you born? ");
        year = s.nextLine();
        int y = Integer.parseInt(year);
        
        System.out.println("Well, " +name + "...");
        if(y < 2005) {
            System.out.println("Pixar's 'Up' came out half a decade ago.");
        }  
        if(y < 1995) {
            System.out.println("The first Harry Potter came out over 15 years ago.");
        } 
        if(y < 1985) {
            System.out.println("Space Jam came out not last decade, but the one before THAT.");
        }
        if(y < 1975) {
            System.out.println("The original Jurassic Park release is closer to the date of the first"
                    + "lunar landing than it is to today.");
        }
        if(y < 1965) {
            System.out.println("The MASH TV series has been around for almost half a century.");
        }
    }
}
