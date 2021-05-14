package com.example.taxmanagementrest.models;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * TAX PAYMENT MODEL -
 * Creates the Tax payment entity and initialises the variables using getters and setters.
 */

@Entity
public class TaxPayment implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentid;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxInformation")
    private TaxInformation taxInformation;
    private double cost;
    private String paymentmethod;
    private LocalDate paymentdate;

    public TaxPayment()
    {

    }

    public TaxPayment(TaxPayment taxPayment,TaxInformation taxInformation, Double cost, String paymentmethod, LocalDate paymentdate)
    {
        this.setTaxInformation(taxInformation);
        this.cost =cost;
        this.paymentmethod =paymentmethod;
        this.paymentdate =paymentdate;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public TaxInformation getTaxInformation() {
        return taxInformation;
    }

    public void setTaxInformation(TaxInformation taxInformation) {
        this.taxInformation = taxInformation;
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
