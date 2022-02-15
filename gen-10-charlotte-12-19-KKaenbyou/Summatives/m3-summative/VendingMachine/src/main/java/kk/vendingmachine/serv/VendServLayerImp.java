package kk.vendingmachine.serv;

import java.util.List;
import java.util.Map;
import kk.vendingmachine.dao.AuditDao;
import kk.vendingmachine.dao.VendDao;
import kk.vendingmachine.dao.VendEx;
import kk.vendingmachine.dto.Vend;

public class VendServLayerImp implements VendServLayer {

    VendDao dao;
    AuditDao audit;

    public VendServLayerImp(VendDao dao, AuditDao audit) {
        this.dao = dao;
        this.audit = audit;
    }

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

    @Override
    public List<Vend> getAllVend() throws VendEx {
        return dao.getAllVend();
    }
}
