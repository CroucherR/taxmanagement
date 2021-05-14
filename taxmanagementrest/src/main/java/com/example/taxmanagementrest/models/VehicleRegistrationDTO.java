package com.example.taxmanagementrest.models;

import java.time.LocalDate;

/**
 * VEHICLE REGISTRATION DTO -
 * Creates the Vehicle Registration Data transfer object allowing variables stored in entities linked with vehicle registration to be grouped together
 * and initialises the variables using getters and setters.
 */

public class VehicleRegistrationDTO
{
    private int registrationid;
    private LocalDate registrationdate;
    private int ownerid;
    private String firstname;
    private String secondname;
    private int vehicleid;
    private String regno;
    private String make;
    private String model;

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

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
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

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
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
}
