package com.example.taxmanagementrest.models;
import javax.persistence.*;

/**
 * VEHICLE MODEL -
 * Creates the vehicle entity and initialises the variables using getters and setters.
 */

@Entity
public class Vehicle implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleid;
    private int year;
    private String regno;
    private String make;
    private String model;
    private double value;
    private double enginestats;
    private String fueltype;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = VehicleRegistration.class, mappedBy = "vehicle")
    private VehicleRegistration vehicleRegistration;


    public Vehicle() {

    }

    public Vehicle(Vehicle vehicle, Integer year, String regno, String make, String model, Double value, Double enginestats, String fueltype) {
        this.year =year;
        this.regno =regno;
        this.make =make;
        this.model =model;
        this.value =value;
        this.enginestats =enginestats;
        this.fueltype =fueltype;
    }

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
}
