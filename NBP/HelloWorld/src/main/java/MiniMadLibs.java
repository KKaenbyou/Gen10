//package com.tsguild.foundations.variables;
import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        String n1, adj1, n2, num, adj2, pn1, pn2, pn3;
        
        System.out.print("Give me the first singular noun. ");
        n1 = s.nextLine();
        System.out.print("Give me the first adjective. ");
        adj1 = s.nextLine();
        System.out.print("Give me the second singular noun. ");
        n2 = s.nextLine();
        System.out.print("Give me a number. ");
        num = s.nextLine();
        System.out.print("Give me the second adjective. ");
        adj2 = s.nextLine();
        System.out.print("Give me the first plural noun. ");
        pn1 = s.nextLine();
        System.out.print("Give me the second plural noun. ");
        pn2 = s.nextLine();
        System.out.print("Give me the third plural  noun. ");
        pn3 = s.nextLine();
        
        System.out.print(n1 + ": the " + adj1 + " frontier. These are the voyages of the starship "
                + n2 + ". Its " + num + "-year mission: to explore strange " + adj2 + " " + pn1 + ", to seek out "
                        +  adj2 + " " + pn2 + ", and " + adj2 + " " + pn3 + "!");
    }    
}
