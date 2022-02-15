package kk.floor.dto;

import java.time.LocalDate;

public class Order {

    private LocalDate date;
    private String orderID;
    private String custID;
    private String state;
    private String taxRate;
    private String product;
    private String area;
    private String costft;
    private String labft;
    private String matCost;
    private String labCost;
    private String tax;
    private String total;

    public Order() {
    }

    public Order(LocalDate date) {
        this.date = date;
    }
    
    public Order(String orderID) {
        this.orderID = orderID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCostft() {
        return costft;
    }

    public void setCostft(String costft) {
        this.costft = costft;
    }

    public String getLabft() {
        return labft;
    }

    public void setLabft(String labft) {
        this.labft = labft;
    }

    public String getMatCost() {
        return matCost;
    }

    public void setMatCost(String matCost) {
        this.matCost = matCost;
    }

    public String getLabCost() {
        return labCost;
    }

    public void setLabCost(String labCost) {
        this.labCost = labCost;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
