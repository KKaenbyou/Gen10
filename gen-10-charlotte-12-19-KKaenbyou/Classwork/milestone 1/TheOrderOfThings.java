//package com.tsguild.foundations.variables;

public class TheOrderOfThings {
    public static void main(String[] args) {
        
        int number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;

        number = 5;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "yellow";
        origin = "Alpha-Centaurian";
        material = "platinum";
        purpose = "good";

        noun = "dragons";

        // When you use + with strings, Java concatenates (e.g., string them together) them instead of adding them.
        System.out.println(number + " " + opinion + " " + size + " " + age + " " + shape
                 + " " + color + " " + origin + " " + material + " " + purpose + " " + noun);
        System.out.println(material + " " + purpose + " " + opinion + " " + size + " " + age + " " + shape
                 + " " + color + " " + origin + " " + number + " " + noun);
        System.out.println(color + " " + origin + " " + material + " " + purpose + " " + opinion + " " + size + " " + age + " " + shape
                 + " " + number + " " + noun);
    }
}