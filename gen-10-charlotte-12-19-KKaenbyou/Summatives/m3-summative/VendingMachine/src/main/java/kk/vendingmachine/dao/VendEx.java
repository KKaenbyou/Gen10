package kk.vendingmachine.dao;

public class VendEx extends Exception {
    
    public VendEx(String message) {
        super(message);
    }
    
    public VendEx(String message, Throwable cause) {
        super(message, cause);
    }
}