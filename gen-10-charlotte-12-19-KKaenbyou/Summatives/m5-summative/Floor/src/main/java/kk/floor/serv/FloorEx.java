package kk.floor.serv;

public class FloorEx extends Exception {

    public FloorEx(String message) {
        super(message);
    }

    public FloorEx(String message, Throwable cause) {
        super(message, cause);
    }
}
