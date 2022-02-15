// @author Kenji Kaenbyou

package kk.mp3.ui;
import java.util.Scanner;

public class UserIOImp implements UserIO {
    
    Scanner s = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(s.nextLine());
    }
    @Override
    public int readInt(String prompt, int min, int max) {
        int p;
        System.out.println(prompt);
        p = Integer.parseInt(s.nextLine());
        while(p <= min && p >= max) {
            System.out.println(prompt);
            p = Integer.parseInt(s.nextLine());
        }
        return p;
    }
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String string = s.nextLine();
        return string;
    }
}