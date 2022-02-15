package kk.floor.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import kk.floor.dto.Order;
import kk.floor.serv.FloorEx;

public class FloorDaoImp implements FloorDao {

    public Map<String, Order> orderMap = new HashMap<>();
    public static final String LIST_FILE = "Orders.txt";
    public static final String DELIMITER = " : ";

    @Override
    public List<Order> getAllOrders() throws FloorEx {
        loadList();
        return new ArrayList<>(orderMap.values());
    }

    @Override
    public Order getOrder(String orderID) throws FloorEx {
        loadList();
        return orderMap.get(orderID);
    }

    @Override
    public Order addOrder(List<Order> orderList, Order order) throws FloorEx {
        loadList();
        int orderMax = 0;
        for (Order currentOrder : orderList) {
            if(Integer.parseInt(currentOrder.getOrderID()) > orderMax) {
                orderMax = Integer.parseInt(currentOrder.getOrderID());
            }
        }
        orderMax++;
        order.setOrderID(String.valueOf(orderMax));
        order.setDate(LocalDate.now());
        Order newOrder = orderMap.put(String.valueOf(orderMax), order);
        writeList();
        return newOrder;
    }

    @Override
    public Order editOrder(String orderID, Order order) throws FloorEx {
        loadList();
        Order newOrder = orderMap.put(orderID, order);
        writeList();
        return newOrder;
    }

    @Override
    public Order removeOrder(String orderID) throws FloorEx {
        loadList();
        Order newOrder = orderMap.remove(orderID);
        writeList();
        return newOrder;
    }

    private String marshallOrder(Order order) {
        String OrderAsText = order.getOrderID() + DELIMITER;
        OrderAsText += order.getCustID() + DELIMITER;
        OrderAsText += order.getState() + DELIMITER;
        OrderAsText += order.getTaxRate() + DELIMITER;
        OrderAsText += order.getProduct() + DELIMITER;
        OrderAsText += order.getArea() + DELIMITER;
        OrderAsText += order.getCostft() + DELIMITER;
        OrderAsText += order.getLabft() + DELIMITER;
        OrderAsText += order.getMatCost() + DELIMITER;
        OrderAsText += order.getLabCost() + DELIMITER;
        OrderAsText += order.getTax() + DELIMITER;
        OrderAsText += order.getTotal() + DELIMITER;
        OrderAsText += order.getDate();
        return OrderAsText;
    }

    private Order unmarshallOrder(String OrderAsText) {
        String[] OrderTokens = OrderAsText.split(DELIMITER);
        String orderID = OrderTokens[0];
        Order OrderFromFile = new Order(orderID);
        OrderFromFile.setCustID(OrderTokens[1]);
        OrderFromFile.setState(OrderTokens[2]);
        OrderFromFile.setTaxRate(OrderTokens[3]);
        OrderFromFile.setProduct(OrderTokens[4]);
        OrderFromFile.setArea(OrderTokens[5]);
        OrderFromFile.setCostft(OrderTokens[6]);
        OrderFromFile.setLabft(OrderTokens[7]);
        OrderFromFile.setMatCost(OrderTokens[8]);
        OrderFromFile.setLabCost(OrderTokens[9]);
        OrderFromFile.setTax(OrderTokens[10]);
        OrderFromFile.setTotal(OrderTokens[11]);
        OrderFromFile.setDate(LocalDate.parse(OrderTokens[12]));
        return OrderFromFile;
    }

    private void loadList() throws FloorEx {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIST_FILE)));
        } catch (FileNotFoundException e) {
            throw new FloorEx("Could not load Order data into memory.", e);
        }
        String currentLine;
        Order currentOrder;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentOrder = unmarshallOrder(currentLine);
            orderMap.put(currentOrder.getOrderID(), currentOrder);
        }
        scanner.close();
    }

    private void writeList() throws FloorEx {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIST_FILE));
        } catch (IOException e) {
            throw new FloorEx("Could not save Vend data.", e);
        }
        String VendAsText;
        List<Order> orderList = this.getAllOrders();
        for (Order currentVend : orderList) {
            VendAsText = marshallOrder(currentVend);
            out.println(VendAsText);
            out.flush();
        }
        out.close();
    }
}
