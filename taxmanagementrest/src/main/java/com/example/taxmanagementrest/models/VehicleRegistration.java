package com.example.taxmanagementrest.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * VEHICLE REGISTRATION MODEL -
 * Creates the vehicle registration entity and initialises the variables using getters and setters.
 */

@Entity
public class VehicleRegistration implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;
    private LocalDate registrationdate;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = TaxInformation.class, mappedBy = "vehicleRegistration")
    private TaxInformation taxInformation;

    public VehicleRegistration() {

    }

    public VehicleRegistration(VehicleRegistration vehicleRegistration, Owner owner, Vehicle vehicle, LocalDate registrationdate){
        this.setOwner(owner);
        this.setVehicle(vehicle);
        this.registrationdate = registrationdate;
    }

    public int getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(int registrationid) {
        this.registrationid = registrationid;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }
}
