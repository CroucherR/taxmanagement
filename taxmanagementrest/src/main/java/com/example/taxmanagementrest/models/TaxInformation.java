package com.example.taxmanagementrest.models;
import javax.persistence.*;

/**
 * TAX INFORMATION MODEL -
 * Creates the tax information entity and initialises the variables using getters and setters.
 */

@Entity
public class TaxInformation implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taxid;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleRegistration")
    private VehicleRegistration vehicleRegistration;
    private String enginestatsband;
    private boolean isclassic;
    private boolean isvalue;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = TaxPayment.class, mappedBy = "taxInformation")
    private TaxPayment taxPayment;

    public TaxInformation(){

    }

    public TaxInformation(TaxInformation taxInformation, VehicleRegistration vehicleRegistration, String enginestatsband, Boolean isclassic, Boolean isvalue){
        this.setVehicleRegistration(vehicleRegistration);
        this.enginestatsband =enginestatsband;
        this.isclassic =isclassic;
        this.isvalue =isvalue;
    }

    public int getTaxid() {
        return taxid;
    }

    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }

    public VehicleRegistration getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleRegistration(VehicleRegistration vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
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
}
