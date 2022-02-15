package kk.VendingMachineUnitTests;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kk.vendingmachine.dao.VendDao;
import kk.vendingmachine.dao.VendEx;
import kk.vendingmachine.dto.Vend;
import kk.vendingmachine.serv.NoItemEx;

public class VendDaoStub implements VendDao {

    private Vend onlyDrink;
    public List<Vend> vends = new ArrayList<>();
    public Map<String, Vend> vendMap = new HashMap<>();
    
    public VendDaoStub() {
        onlyDrink = new Vend("Drink0");
        onlyDrink.setPrice("1.00");
        onlyDrink.setAmount(0);
        vends.add(onlyDrink);
    }
    
    @Override
    public List<Vend> getAllVend() throws VendEx {
        return vends;
    }
    
    @Override
    public void boughtVend(String vend) throws VendEx {
    }
    
    @Override
    public void daoChange(String vend, String money) throws VendEx, NoItemEx {
    }
    
    @Override
    public Map<String, Vend> getVendMap() {
        return vendMap;
    }
}