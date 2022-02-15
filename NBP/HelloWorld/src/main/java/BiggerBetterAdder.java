//package com.tsguild.foundations.variables;
import java.util.Scanner;

public class BiggerBetterAdder {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        String a, b, c;
        
        System.out.print("Let's add three numbers together. What is the first number? ");
        a = s.nextLine();
        System.out.print("What is the second number? ");
        b = s.nextLine();
        System.out.print("What is the third number? ");
        c = s.nextLine();
        
        int d = Integer.parseInt(a);
        int e = Integer.parseInt(b);
        int f = Integer.parseInt(c);
        int g = d + e + f;
        
        System.out.print("The result is " + g);
    }    
}
