package com.example.taxmanagementrest.models;
import java.time.LocalDate;

/**
 * TAX PAYMENT DTO -
 * Creates the Tax payment Data transfer object allowing variables stored in entities linked with tax payment to be grouped together
 * and initialises the variables using getters and setters.
 */

public class TaxPaymentDTO
{
    private int paymentid;
    private int taxid;
    private String enginestatsband;
    private boolean isclassic;
    private boolean isvalue;
    private double cost;
    private String paymentmethod;
    private LocalDate paymentdate;

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public int getTaxid() {
        return taxid;
    }

    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }

    public String getEnginestatsband() {
        return enginestatsband;
    }

    public void setEnginestatsband(String enginestatsband) {
        this.enginestatsband = enginestatsband;
    }

    public boolean isIsclassic() {
        return isclassic;
    }

    public void setIsclassic(boolean isclassic) {
        this.isclassic = isclassic;
    }

    public boolean isIsvalue() {
        return isvalue;
    }

    public void setIsvalue(boolean isvalue) {
        this.isvalue = isvalue;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public LocalDate getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(LocalDate paymentdate) {
        this.paymentdate = paymentdate;
    }
}
