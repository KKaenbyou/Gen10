//package com.tsguild.foundations.scanner;
import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        String name, color, fruit, number;
        
        System.out.print("Hello! What is your name? ");
        name = s.nextLine();
        System.out.print(name + " is a nice name. Mine is Kaenbyou. What is your favorite color? ");
        color = s.nextLine();
        System.out.print("I think " + color + " is a pretty color. What is your favorite number? ");
        number = s.nextLine();
        System.out.print(number + " is my favorite number too. What is your favorite fruit? ");
        fruit = s.nextLine();
        System.out.println("What fruit is " + fruit + "? I've never heard of that fruit. My favorite fruit is lychee.");
        System.out.print("Thank you for talking with me, " + name + "!");
    }    
}
