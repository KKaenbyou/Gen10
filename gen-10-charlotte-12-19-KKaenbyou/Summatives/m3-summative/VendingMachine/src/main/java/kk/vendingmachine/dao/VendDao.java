package kk.vendingmachine.dao;
import java.util.List;
import java.util.Map;
import kk.vendingmachine.dto.Vend;
import kk.vendingmachine.serv.NoItemEx;

public interface VendDao {

    List<Vend> getAllVend() throws VendEx;
    void boughtVend(String vend) throws VendEx;
    void daoChange(String vend, String money) throws VendEx, NoItemEx;
    Map<String, Vend> getVendMap();
}