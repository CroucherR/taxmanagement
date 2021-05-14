package com.example.taxmanagementrest.models;
import javax.persistence.*;
import java.util.List;

/**
 * OWNER MODEL -
 * Creates the owner entity and initialises the variables using getters and setters.
 */

@Entity
public class Owner implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerid;
    private String firstname;
    private String secondname;
    private String address;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = VehicleRegistration.class, mappedBy = "owner")
    private List<VehicleRegistration> owner;


    public Owner() {

    }

    public Owner(Owner owner, String firstname, String secondname, String address) {
        this.firstname = firstname;
        this.address = address;
        this.secondname = secondname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}