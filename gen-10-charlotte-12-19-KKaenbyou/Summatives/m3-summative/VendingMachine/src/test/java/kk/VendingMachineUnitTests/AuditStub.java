package kk.VendingMachineUnitTests;
import kk.vendingmachine.dao.AuditDao;
import kk.vendingmachine.dao.VendEx;

public class AuditStub implements AuditDao{
    
    @Override
    public void writeAuditEntry(String entry) throws VendEx {
        
    }
}