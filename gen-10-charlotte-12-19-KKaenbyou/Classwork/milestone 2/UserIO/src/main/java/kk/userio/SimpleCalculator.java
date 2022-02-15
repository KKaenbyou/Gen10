// @author Kenji Kaenbyou

package kk.userio;

public class SimpleCalculator {
    
    private double x;
    private double y;
    
    public SimpleCalculator() {        
    }
    
    public SimpleCalculator(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getx() {
        return x;
    }
    
    public double gety() {
        return y;
    }
    
    public double setx(double x) {
        this.x = x;
        return x;
    }
    
    public double sety(double y) {
        this.y = y;
        return y;
    }
    
    public double add(double x, double y) {
        double z;
        z = x + y;
        return z;
    }
    
    public double sub(double x, double y) {
        double z;
        z = x - y;
        return z;
    }
    
    public double mult(double x, double y) {
        double z;
        z = x * y;
        return z;
    }
    
    public double div(double x, double y) {
        double z;
        z = x / y;
        return z;
    }
}