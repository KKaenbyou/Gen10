//package com.tsguild.foundations.scanner;
import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        String miles, hotdogs, lang;
        
        System.out.print("How many miles can you run? ");
        miles = s.nextLine();
        int a = Integer.parseInt(miles) * 2 + 1;
        System.out.println("I can run " + a + " miles!");

        System.out.print("How many hotdogs can you eat? ");
        hotdogs = s.nextLine();
        int b = Integer.parseInt(hotdogs) * 2 + 1;
        System.out.println("I can eat " + b + " hotdogs!");

        System.out.print("How many languages do you know? ");
        lang = s.nextLine();
        int c = Integer.parseInt(lang) * 2 + 1;
        System.out.println("I can speak " + c + " languages!");
    }    
}
