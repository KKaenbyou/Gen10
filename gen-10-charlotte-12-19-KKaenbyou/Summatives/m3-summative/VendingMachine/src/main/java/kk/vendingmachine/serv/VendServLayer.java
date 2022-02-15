package kk.vendingmachine.serv;
import java.util.List;
import kk.vendingmachine.dao.VendEx;
import kk.vendingmachine.dto.Vend;

public interface VendServLayer {
    
    void daoChange(String vend, String money) throws VendEx, LowFundsEx, NoItemEx;
    public void boughtVend(String vend) throws VendEx;
    public List<Vend> getAllVend() throws VendEx;
}