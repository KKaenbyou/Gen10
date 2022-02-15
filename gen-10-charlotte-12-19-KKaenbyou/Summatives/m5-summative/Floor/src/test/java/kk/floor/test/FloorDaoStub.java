package kk.floor.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kk.floor.dao.FloorDao;
import kk.floor.dto.Order;
import kk.floor.serv.FloorEx;

public class FloorDaoStub implements FloorDao {
    
    private Order order;
    public Map<String, Order> orderMap = new HashMap<>();
    
    public List<Order> getAllOrders() throws FloorEx {
        return new ArrayList<>(orderMap.values());
    }

    public Order getOrder(String orderID) throws FloorEx {
        return order;
    }

    public Order addOrder(List<Order> orderList, Order order) throws FloorEx {
        return order;
    }

    public Order editOrder(String orderID, Order order) throws FloorEx {
        return order;
    }

    public Order removeOrder(String orderID) throws FloorEx {
        return order;
    }
}
