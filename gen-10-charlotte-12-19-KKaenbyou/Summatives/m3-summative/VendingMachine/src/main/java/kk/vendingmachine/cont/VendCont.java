package kk.vendingmachine.cont;
import java.util.List;
import kk.vendingmachine.dao.VendEx;
import kk.vendingmachine.dto.Vend;
import kk.vendingmachine.serv.LowFundsEx;
import kk.vendingmachine.serv.NoItemEx;
import kk.vendingmachine.serv.VendServLayer;
import kk.vendingmachine.ui.VendView;

public class VendCont {
 
    private VendView view;
    private VendServLayer service;
    public VendCont(VendServLayer service, VendView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws VendEx, NoItemEx, LowFundsEx {
        
        String selection;
        String money;
        
        try {
            money = displayDrinkList();
            selection = makeSelection(money);            
            switch (selection.toUpperCase()) {
                case "DRINK1":
                    service.daoChange("Drink1", money);
                    service.boughtVend("Drink1");
                    break;
                case "DRINK2":
                    service.daoChange("Drink2", money);
                    service.boughtVend("Drink2");
                    break;
                case "DRINK3":
                    service.daoChange("Drink3", money);
                    service.boughtVend("Drink3");
                    break;
                case "DRINK4":
                    service.daoChange("Drink4", money);
                    service.boughtVend("Drink4");
                    break;
                case "DRINK5":
                    service.daoChange("Drink5", money);
                    service.boughtVend("Drink5");
                    break;
                default:
                    unknownCommand();
            }
        } catch (VendEx e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    public String displayDrinkList() throws VendEx {
        List<Vend> vendList = service.getAllVend();
        String money = view.displayDrinkList(vendList);
        return money;
    }
    
    public String makeSelection(String money) {
        String selection =  view.makeSelection(money);
        return selection;
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}