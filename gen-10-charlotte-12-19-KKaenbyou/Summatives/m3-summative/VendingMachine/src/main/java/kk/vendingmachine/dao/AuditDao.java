package kk.vendingmachine.dao;

public interface AuditDao {
    public void writeAuditEntry(String entry) throws VendEx;
}