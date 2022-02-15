// @author Kenji Kaenbyou

package kk.userio;
import java.util.Scanner;

public class User implements UserIO {
    
    Scanner s = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(s.nextLine());
    }
    @Override
    public double readDouble(String prompt, double min, double max) {
        double p;
        System.out.println(prompt);
        p = Double.parseDouble(s.nextLine());
        while(p <= min && p >= max) {
            System.out.println(prompt);
            p = Double.parseDouble(s.nextLine());
        }
        return p;
    }
    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(s.nextLine());
    }
    @Override
    public float readFloat(String prompt, float min, float max) {
        float p;
        System.out.println(prompt);
        p = Float.parseFloat(s.nextLine());
        while(p <= min && p >= max) {
            System.out.println(prompt);
            p = Float.parseFloat(s.nextLine());
        }
        return p;
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
    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(s.nextLine());
    }
    @Override
    public long readLong(String prompt, long min, long max) {
        long p;
        System.out.println(prompt);
        p = Long.parseLong(s.nextLine());
            
        while(p <= min && p >= max) {
            System.out.println(prompt);
            p = Long.parseLong(s.nextLine());
        }
        return p;
    }
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return prompt;
    }
}