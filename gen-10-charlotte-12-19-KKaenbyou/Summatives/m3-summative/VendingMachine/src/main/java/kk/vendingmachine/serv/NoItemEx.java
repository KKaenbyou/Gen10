package kk.vendingmachine.serv;

public class NoItemEx extends Exception{

    public NoItemEx(String message) {
        super(message);
    }
    
    public NoItemEx(String message, Throwable cause) {
        super(message, cause);
    }
}