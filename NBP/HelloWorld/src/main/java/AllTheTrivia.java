//package com.tsguild.foundations.scanner;
import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        String name, color, fruit;
        
        System.out.print("Hello! What is your name? ");
        name = s.nextLine();
        System.out.print("What is your favorite color? ");
        color = s.nextLine();
        System.out.print("What is your favorite fruit? ");
        fruit = s.nextLine();
        
        System.out.println("Your name is " + fruit + "!");
        System.out.println("Your favorite color is " + name + "!");
        System.out.println("Your favorite fruit is " + color + "!");
    }    
}
