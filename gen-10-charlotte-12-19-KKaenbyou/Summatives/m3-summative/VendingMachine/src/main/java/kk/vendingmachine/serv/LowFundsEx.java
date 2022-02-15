package kk.vendingmachine.serv;

public class LowFundsEx extends Exception{

    public LowFundsEx(String message) {
        super(message);
    }
    
    public LowFundsEx(String message, Throwable cause) {
        super(message, cause);
    }
}