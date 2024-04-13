package com.example.springboot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vehicleName; // Adjust attribute name

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<User> users; // Adjust mappedBy attribute

    // Constructors, getters, and setters
    public Vehicle() {
    }

    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
