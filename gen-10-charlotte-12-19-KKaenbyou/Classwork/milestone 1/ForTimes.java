import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int table = 0;
        String input = null;
        
        System.out.print("Which times table shall I recite? ");
        input = s.nextLine();
        table = Integer.parseInt(input);
        
        for(int i = 1; i <= 15; i++) {
            System.out.println(i + " times " + table + " equals " + (i*table));
        }
    }
}
