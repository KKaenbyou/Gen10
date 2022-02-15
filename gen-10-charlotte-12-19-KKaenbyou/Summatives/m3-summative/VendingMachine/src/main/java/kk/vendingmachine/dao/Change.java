package kk.vendingmachine.dao;
import java.math.BigDecimal;

public class Change {

    private static BigDecimal money;

    public enum Coins {
        QUARTERS, DIMES, NICKELS, PENNIES
    }

    public static int calculate(Coins coin, BigDecimal credit) {
        switch (coin) {
            case QUARTERS:
                double q = credit.doubleValue() * 100;
                int quarters = (int) q / 25;
                money = new BigDecimal(q % 25);
                return quarters;
            case DIMES:
                double d = credit.doubleValue();
                int dimes = (int) d / 10;
                money = new BigDecimal(d % 10);
                return dimes;
            case NICKELS:
                double n = credit.doubleValue();
                int nickels = (int) n / 5;
                money = new BigDecimal(n % 5);
                return nickels;
            case PENNIES:
                int pennies = credit.intValue();
                return pennies;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static String makeChange(String price, String credit) {
        BigDecimal cost = new BigDecimal(price);
        money = new BigDecimal(credit);
        money = money.subtract(cost);
        return ("Drink dispensed. Your change is $" + money + ": "
                + calculate(Coins.QUARTERS, money) + " quarters, "
                + calculate(Coins.DIMES, money) + " dimes, "
                + calculate(Coins.NICKELS, money) + " nickels, and "
                + calculate(Coins.PENNIES, money) + " pennies.");
    }
}
