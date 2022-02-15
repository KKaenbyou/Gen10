package kk.vendingmachine.ui;

import java.util.List;
import kk.vendingmachine.dto.Vend;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class VendView {

    private UserIO io;

    public VendView(UserIO io) {
        this.io = io;
    }

    public String displayDrinkList(List<Vend> vendList) {
        io.print("=== Drink Menu ===");
        for (Vend currentVend : vendList) {
            if (currentVend.getAmount() > 0) {
                io.print(currentVend.getVend() + " | Price: $"
                        + currentVend.getPrice());
            }
        }
        String money = io.readString("Enter how many dollars you are inserting or enter 0 to cancel.");
        try {
            double moneyTest = Double.parseDouble(money);
            if (moneyTest <= 0) {
                if (moneyTest < 0) {
                    io.print("Invalid amount.");
                } else if (moneyTest == 0) {
                    io.print("Order cancelled.");
                }
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            io.print("Invalid Input.");
            System.exit(0);
        }
        return money;
    }

    public String makeSelection(String money) {
        String choice;
        BigDecimal bd = new BigDecimal(money).setScale(2, RoundingMode.DOWN);
        System.out.println("You have a credit of $" + bd);
        choice = io.readString("Please enter the name of which drink you would like.");
        return choice;
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("=== Unknown Command, Order Cancelled ===");
    }
}
