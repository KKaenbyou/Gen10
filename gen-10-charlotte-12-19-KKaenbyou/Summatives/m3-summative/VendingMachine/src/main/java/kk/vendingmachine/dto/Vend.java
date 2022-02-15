package kk.vendingmachine.dto;

public class Vend {
 
    private String vend;
    private String price;
    private int amount;
    
    public Vend(String vend) {
        this.vend = vend;
    }
    
    public String getVend() {
        return vend;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}