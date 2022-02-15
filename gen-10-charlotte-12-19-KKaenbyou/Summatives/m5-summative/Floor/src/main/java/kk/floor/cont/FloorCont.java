package kk.floor.cont;

import java.time.DateTimeException;
import java.util.List;
import kk.floor.dto.Order;
import kk.floor.serv.FloorEx;
import kk.floor.serv.FloorServ;
import kk.floor.ui.FloorView;

public class FloorCont {

    private FloorView view;
    private FloorServ service;
    private boolean train;

    public FloorCont(FloorServ service, FloorView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws FloorEx {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            train();
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        displayOrder();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        listOrders();
                        break;
                    case 6:
                        saveOrders();
                        break;
                    case 7:
                        keepGoing = false;
                        System.exit(0);
                    default:
                        unknownCommand();
                }
            }
        } catch (FloorEx | NumberFormatException | DateTimeException e) {
            view.displayError(e.getMessage());
            System.exit(0);
        }
    }
    
    private void train() throws FloorEx {
        train = view.train();
    }
    
    private void displayOrder() throws FloorEx {
        List<Order> orderList = service.getAllOrders();
        view.displayOrder(orderList);
    }
    
    private void addOrder() throws FloorEx {
        List<Order> orderList = service.getAllOrders();
        Order order = new Order();
        order = view.addOrder(order);
        boolean confirm = view.addConfirm();
        if(confirm == true && train == false) {
            service.addOrder(orderList, order);
        }
    }
    
    private void editOrder() throws FloorEx {
        List<Order> orderList = service.getAllOrders();
        String orderID = view.editOrder(orderList);
        if(Integer.parseInt(orderID) > 0) {
            Order order = service.getOrder(orderID);
            order = view.editOrder2(order, orderID);
            if(train == false) {
                service.editOrder(orderID, order);
            }
        }
    }
    
    private void removeOrder() throws FloorEx {
        List<Order> orderList = service.getAllOrders();
        String orderID = view.removeOrder(orderList);
        if(Integer.parseInt(orderID) > 0) {
            boolean confirm = view.removeConfirm();
            if(confirm == true && train == false) {
                service.removeOrder(orderID);
            }
        }
    }

    private void listOrders() throws FloorEx {
        List<Order> orderList = service.getAllOrders();
        view.displayOrderList(orderList);
    }
    
    private void saveOrders() {
        view.displaySave();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void unknownCommand() {
        view.displayUnknown();
    }
}
