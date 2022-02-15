package kk.floor.serv;

import java.util.List;
import kk.floor.dto.Order;

public interface FloorServ {
    
    List<Order> getAllOrders() throws FloorEx;

    public Order getOrder(String orderID) throws FloorEx;

    public Order addOrder(List<Order> orderList, Order order) throws FloorEx;

    public Order editOrder(String orderID, Order order) throws FloorEx;

    public Order removeOrder(String orderID) throws FloorEx;
}