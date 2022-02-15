package kk.floor.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import kk.floor.dto.Order;
import kk.floor.serv.FloorEx;

public class FloorView {

    private UserIO io;

    public FloorView(UserIO io) {
        this.io = io;
    }
    
    public boolean train() {
        boolean confirm = false;
        String choice = io.readString("Training mode? Y/N");
        while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            choice = io.readString("Invalid input. Training mode? Y/N");
        }
        if(choice.equalsIgnoreCase("n")) {
            io.print("=== Production Mode ===");
        } else if(choice.equalsIgnoreCase("y")) {
            io.print("=== Training Mode ===");
            confirm = true;
        }
        return confirm;
    }

    public void displayOrder(List<Order> orderList) {
        int valid = 0;
        while(valid == 0) {
            try {
                LocalDate ld = LocalDate.parse(io.readString("Enter the date of the orders you would like displayed."
                        + " Format: YYYY-MM-DD"));
                io.print("=== Order List ===");
                for (Order currentOrder : orderList) {
                    if (ld.compareTo(currentOrder.getDate()) == 0) {
                        io.print("Order#:" + currentOrder.getOrderID() + " Customer:"
                                + currentOrder.getCustID() + " State:"
                                + currentOrder.getState() + " Tax:%"
                                + currentOrder.getTaxRate() + " Product:"
                                + currentOrder.getProduct() + " Area:"
                                + currentOrder.getArea() + "\n Cost/ft:"
                                + currentOrder.getCostft() + " Labor/ft:"
                                + currentOrder.getLabft() + " Materials:$"
                                + currentOrder.getMatCost() + " Labor:$"
                                + currentOrder.getLabCost() + " Tax:$"
                                + currentOrder.getTax() + " Total:$"
                                + currentOrder.getTotal() + " Date:"
                                + currentOrder.getDate() + "\n");
                    }
                }
                valid = 1;
            } catch (DateTimeException e) {
                io.print("Invalid Input.");
            }
        }
    }

    public Order addOrder(Order currentOrder) {
        io.print("=== Entries are case-sensitive ===");
        String custID = io.readString("Please enter the customer name");
        String state = io.readString("Please enter the state (OH, PA, MI, IN)");
        while(!state.equals("OH") && !state.equals("PA") && !state.equals("MI") && !state.equals("IN")) {
            state = io.readString("Invalid state. Please enter the state (OH, PA, MI, IN)");
        }
        String product = io.readString("Please enter the product type (Carpet, Laminate, Tile, Wood)");
        while(!product.equals("Carpet") && !product.equals("Laminate") && !product.equals("Tile") && !product.equals("Wood")) {
            product = io.readString("Invalid product. Please enter the product type (Carpet, Laminate, Tile, Wood)");
        }
        double area = 0;
        while(area <= 0) {
            try {
                area = Double.parseDouble(io.readString("Please enter the area in feet (Cannot be 0 or less)"));
            } catch (NumberFormatException e) {
            io.print("Invalid Input.");
            }
        }
        
        currentOrder.setCustID(custID);
        currentOrder.setState(state);
        currentOrder.setProduct(product);
        currentOrder.setArea(String.valueOf(area));
        
        switch(state) { 
            case "OH": 
                currentOrder.setTaxRate("6.25");
                break;
            case "PA": 
                currentOrder.setTaxRate("6.75");
                break;
            case "MI": 
                currentOrder.setTaxRate("5.75");
                break;
            case "IN": 
                currentOrder.setTaxRate("6.00");
                break;
        }
        switch(product) { 
            case "Carpet": 
                currentOrder.setCostft("2.25");
                currentOrder.setLabft("2.10");
                break;
            case "Laminate": 
                currentOrder.setCostft("1.75");
                currentOrder.setLabft("2.10");
                break;
            case "Tile": 
                currentOrder.setCostft("3.50");
                currentOrder.setLabft("4.15");
                break;
            case "Wood": 
                currentOrder.setCostft("5.15");
                currentOrder.setLabft("4.75");
                break;
        }
        
        double matCost = Math.round((area * Double.parseDouble(currentOrder.getCostft())) * 100.00) / 100.00;
        double labCost = Math.round((area * Double.parseDouble(currentOrder.getLabft())) * 100.00) / 100.00;
        double total = matCost + labCost;
        double tax = Math.round((total * (Double.parseDouble(currentOrder.getTaxRate()) / 100.00)) * 100.00) / 100.00;
        total = Math.round((total + tax) * 100.00) / 100.00;
        currentOrder.setMatCost(String.valueOf(matCost));
        currentOrder.setLabCost(String.valueOf(labCost));
        currentOrder.setTax(String.valueOf(tax));
        currentOrder.setTotal(String.valueOf(total));
        
        io.print("Customer:"
                    + currentOrder.getCustID() + " State:"
                    + currentOrder.getState() + " Tax:%"
                    + currentOrder.getTaxRate() + " Product:"
                    + currentOrder.getProduct() + " Area:"
                    + currentOrder.getArea() + "\n Cost/ft:"
                    + currentOrder.getCostft() + " Labor/ft:"
                    + currentOrder.getLabft() + " Materials:$"
                    + currentOrder.getMatCost() + " Labor:$"
                    + currentOrder.getLabCost() + " Tax:$"
                    + currentOrder.getTax() + " Total:$"
                    + currentOrder.getTotal() + "\n");
        return currentOrder;
    }
    
    public boolean addConfirm() {
        boolean confirm = false;
        String choice = io.readString("Confirm entry? Y/N");
        while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            choice = io.readString("Invalid input. Confirm entry? Y/N");
        }
        if(choice.equalsIgnoreCase("n")) {
            io.print("Entry discarded.");
        } else if(choice.equalsIgnoreCase("y")) {
            io.print("Entry added.");
            confirm = true;
        }
        return confirm;
    }
    
    public String editOrder(List<Order> orderList) {
        boolean found = false;
        int valid = 0;
        int orderID = 0;
        while(valid == 0) {
            try {
                LocalDate ld = LocalDate.parse(io.readString("Enter the date of the order you would like edit."
                        + " Format: YYYY-MM-DD"));
                int orderID2 = Integer.parseInt(io.readString("Enter the order number of the order you would like to edit."));
                for (Order currentOrder : orderList) {
                    if (ld.compareTo(currentOrder.getDate()) == 0 && String.valueOf(orderID2).equals(currentOrder.getOrderID())) {
                        io.print("Order#:" + currentOrder.getOrderID() + " Customer:"
                                + currentOrder.getCustID() + " State:"
                                + currentOrder.getState() + " Tax:%"
                                + currentOrder.getTaxRate() + " Product:"
                                + currentOrder.getProduct() + " Area:"
                                + currentOrder.getArea() + "\n Cost/ft:"
                                + currentOrder.getCostft() + " Labor/ft:"
                                + currentOrder.getLabft() + " Materials:$"
                                + currentOrder.getMatCost() + " Labor:$"
                                + currentOrder.getLabCost() + " Tax:$"
                                + currentOrder.getTax() + " Total:$"
                                + currentOrder.getTotal() + " Date:"
                                + currentOrder.getDate() + "\n");
                        found = true;
                        orderID = orderID2;
                    }
                }
                valid = 1;
            } catch (DateTimeException | NumberFormatException e) {
             io.print("Invalid Input.");
            }
        }
        if (found == false) {
            io.print("Order not found.");
        }
        return String.valueOf(orderID);
    }
    
    public Order editOrder2(Order currentOrder, String orderID) {
        String empty = new String();
        io.print("=== Entries are case-sensitive. Press enter to leave data unchanged. ===");
        String custID = io.readString("Please enter the customer name");
        String state = io.readString("Please enter the state (OH, PA, MI, IN)");
        while(!state.equals("OH") && !state.equals("PA") && !state.equals("MI") && !state.equals("IN") && !state.equals(empty)) {
            state = io.readString("Invalid state. Please enter the state (OH, PA, MI, IN)");
        }
        String product = io.readString("Please enter the product type (Carpet, Laminate, Tile, Wood)");
        while(!product.equals("Carpet") && !product.equals("Laminate") && !product.equals("Tile") && !product.equals("Wood") && !product.equals(empty)) {
            product = io.readString("Invalid product. Please enter the product type (Carpet, Laminate, Tile, Wood)");
        }
        double area = 0;
        String areaE = " ";
        while(area <= 0 && !areaE.equals(empty)) {
            try {
                areaE = io.readString("Please enter the area in feet (Cannot be 0 or less)");
                if(!areaE.equals(empty)) {
                    area = Double.parseDouble(areaE);
                }
            } catch (NumberFormatException e) {
            io.print("Invalid Input.");
            }
        }
        
        if(custID.equals(empty)) {
            custID = currentOrder.getCustID();
        } else if(!custID.equals(empty)) {
            currentOrder.setCustID(custID);
        }
        if(state.equals(empty)) {
            state = currentOrder.getState();
        } else if(!state.equals(empty)) {
            currentOrder.setState(state);
        }
        if(product.equals(empty)) {
            product = currentOrder.getProduct();
        } else if(!product.equals(empty)) {
            currentOrder.setProduct(product);
        }
        if(areaE.equals(empty)) {
            areaE = currentOrder.getArea();
            area = Double.parseDouble(areaE);
        } else if(!areaE.equals(empty)) {
            currentOrder.setArea(String.valueOf(area));
        }
        
        
        
        switch(state) { 
            case "OH": 
                currentOrder.setTaxRate("6.25");
                break;
            case "PA": 
                currentOrder.setTaxRate("6.75");
                break;
            case "MI": 
                currentOrder.setTaxRate("5.75");
                break;
            case "IN": 
                currentOrder.setTaxRate("6.00");
                break;
        }
        switch(product) { 
            case "Carpet": 
                currentOrder.setCostft("2.25");
                currentOrder.setLabft("2.10");
                break;
            case "Laminate": 
                currentOrder.setCostft("1.75");
                currentOrder.setLabft("2.10");
                break;
            case "Tile": 
                currentOrder.setCostft("3.50");
                currentOrder.setLabft("4.15");
                break;
            case "Wood": 
                currentOrder.setCostft("5.15");
                currentOrder.setLabft("4.75");
                break;
        }
        
        double matCost = Math.round((area * Double.parseDouble(currentOrder.getCostft())) * 100.00) / 100.00;
        double labCost = Math.round((area * Double.parseDouble(currentOrder.getLabft())) * 100.00) / 100.00;
        double total = matCost + labCost;
        double tax = Math.round((total * (Double.parseDouble(currentOrder.getTaxRate()) / 100.00)) * 100.00) / 100.00;
        total = Math.round((total + tax) * 100.00) / 100.00;
        currentOrder.setMatCost(String.valueOf(matCost));
        currentOrder.setLabCost(String.valueOf(labCost));
        currentOrder.setTax(String.valueOf(tax));
        currentOrder.setTotal(String.valueOf(total));
        
        io.print("Customer:"
                    + currentOrder.getCustID() + " State:"
                    + currentOrder.getState() + " Tax:%"
                    + currentOrder.getTaxRate() + " Product:"
                    + currentOrder.getProduct() + " Area:"
                    + currentOrder.getArea() + "\n Cost/ft:"
                    + currentOrder.getCostft() + " Labor/ft:"
                    + currentOrder.getLabft() + " Materials:$"
                    + currentOrder.getMatCost() + " Labor:$"
                    + currentOrder.getLabCost() + " Tax:$"
                    + currentOrder.getTax() + " Total:$"
                    + currentOrder.getTotal() + "\n");
        return currentOrder;
    }
    
    public String removeOrder(List<Order> orderList) throws FloorEx {
        boolean found = false;
        int valid = 0;
        int orderID = 0;
        while(valid == 0) {
            try {
                LocalDate ld = LocalDate.parse(io.readString("Enter the date of the order you would like removed."
                        + " Format: YYYY-MM-DD"));
                int orderID2 = Integer.parseInt(io.readString("Enter the order number of the order you would like removed."));
                for (Order currentOrder : orderList) {
                    if (ld.compareTo(currentOrder.getDate()) == 0 && String.valueOf(orderID2).equals(currentOrder.getOrderID())) {
                        io.print("Order#:" + currentOrder.getOrderID() + " Customer:"
                                + currentOrder.getCustID() + " State:"
                                + currentOrder.getState() + " Tax:%"
                                + currentOrder.getTaxRate() + " Product:"
                                + currentOrder.getProduct() + " Area:"
                                + currentOrder.getArea() + "\n Cost/ft:"
                                + currentOrder.getCostft() + " Labor/ft:"
                                + currentOrder.getLabft() + " Materials:$"
                                + currentOrder.getMatCost() + " Labor:$"
                                + currentOrder.getLabCost() + " Tax:$"
                                + currentOrder.getTax() + " Total:$"
                                + currentOrder.getTotal() + " Date:"
                                + currentOrder.getDate() + "\n");
                        found = true;
                        orderID = orderID2;
                    }
                }
                valid = 1;
            } catch (DateTimeException | NumberFormatException e) {
             io.print("Invalid Input.");
            }
        }
        if (found == false) {
            io.print("Order not found.");
        }
        return String.valueOf(orderID);
    }
    
    public boolean removeConfirm() {
        boolean confirm = false;
        String choice = io.readString("Confirm removal? Y/N");
        while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            choice = io.readString("Invalid input. Confirm removal? Y/N");
        }
        if(choice.equalsIgnoreCase("n")) {
            io.print("Order removal cancelled.");
        } else if(choice.equalsIgnoreCase("y")) {
            io.print("Order removed.");
            confirm = true;
        }
        return confirm;
    }

    public void displayOrderList(List<Order> orderList) {
        io.print("=== Order List ===");
        for (Order currentOrder : orderList) {
            io.print("Order#:" + currentOrder.getOrderID() + " Customer:"
                    + currentOrder.getCustID() + " State:"
                    + currentOrder.getState() + " Tax:%"
                    + currentOrder.getTaxRate() + " Product:"
                    + currentOrder.getProduct() + " Area:"
                    + currentOrder.getArea() + "\n Cost/ft:"
                    + currentOrder.getCostft() + " Labor/ft:"
                    + currentOrder.getLabft() + " Materials:$"
                    + currentOrder.getMatCost() + " Labor:$"
                    + currentOrder.getLabCost() + " Tax:$"
                    + currentOrder.getTax() + " Total:$"
                    + currentOrder.getTotal() + " Date:"
                    + currentOrder.getDate() + "\n");
        }
    }

    public int printMenuAndGetSelection() {
        io.print("=== Main Menu ===");
        io.print("1. Display Orders by Date");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Display All Orders");
        io.print("6. Save Current Work");
        io.print("7. Exit Program");
        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public void displaySave() {
        io.print("=== Work Saved ===");
    }

    public void displayError(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }

    public void displayUnknown() {
        io.print("=== Unknown Command ===");
    }
}