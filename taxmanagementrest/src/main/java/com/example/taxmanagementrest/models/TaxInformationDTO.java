package com.example.taxmanagementrest.models;
import java.time.LocalDate;

/**
 * TAX INFORMATION DTO -
 * Creates the Tax information Data transfer object allowing variables stored in entities linked with tax information to be grouped together
 * and initialises the variables using getters and setters.
 */

public class TaxInformationDTO
{
    private int taxid;
    private int registrationid;
    private LocalDate registrationdate;
    private String firstname;
    private String secondname;
    private String regno;
    private String make;
    private String model;
    private int year;
    private boolean isclassic;
    private double value;
    private boolean isvalue;
    private double enginestats;
    private String fueltype;
    private String enginestatsband;

    public int getTaxid() {
        return taxid;
    }

    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }

    public int getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(int registrationid) {
        this.registrationid = registrationid;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isIsclassic() {
        return isclassic;
    }

    public void setIsclassic(boolean isclassic) {
        this.isclassic = isclassic;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isIsvalue() {
        return isvalue;
    }

    public void setIsvalue(boolean isvalue) {
        this.isvalue = isvalue;
    }

    public double getEnginestats() {
        return enginestats;
    }

    public void setEnginestats(double enginestats) {
        this.enginestats = enginestats;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getEnginestatsband() {
        return enginestatsband;
    }

    public void setEnginestatsband(String enginestatsband) {
        this.enginestatsband = enginestatsband;
    }
}
