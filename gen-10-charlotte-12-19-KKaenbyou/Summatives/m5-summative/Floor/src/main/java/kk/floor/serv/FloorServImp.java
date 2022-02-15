package kk.floor.serv;

import java.util.List;
import kk.floor.dao.FloorDao;
import kk.floor.dto.Order;

public class FloorServImp implements FloorServ {

    FloorDao dao;

    public FloorServImp(FloorDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Order> getAllOrders() throws FloorEx {
        return dao.getAllOrders();
    }

    @Override
    public Order getOrder(String orderID) throws FloorEx {
        return dao.getOrder(orderID);
    }

    @Override
    public Order addOrder(List<Order> orderList, Order order) throws FloorEx {
        return dao.addOrder(orderList, order);
    }

    @Override
    public Order editOrder(String orderID, Order order) throws FloorEx {
        return dao.editOrder(orderID, order);
    }

    @Override
    public Order removeOrder(String orderID) throws FloorEx {
        return dao.removeOrder(orderID);
    }
}

/*
    public class VendServLayerImp implements VendServLayer {

@Override
    public void daoChange(String vend, String money) throws VendEx, LowFundsEx, NoItemEx {
        Map<String, Vend> mapEx = dao.getVendMap();
        Vend vendEx = mapEx.get(vend);
        if (vendEx.getAmount() <= 0) {
            System.out.println("That item is out of stock.");
            System.exit(0);
        }
        if (Double.parseDouble(money) < Double.parseDouble(vendEx.getPrice())) {
            System.out.println("Insufficient funds. Amount refunded: $" + money);
            System.exit(0);
        }
        dao.daoChange(vend, money);
    }

    @Override
    public void boughtVend(String vend) throws VendEx {
        Map<String, Vend> mapEx = dao.getVendMap();
        Vend vendEx = mapEx.get(vend);
        audit.writeAuditEntry(
                "Item " + vendEx.getVend() + " has been purchased.");
        dao.boughtVend(vend);
    }
}
*/
