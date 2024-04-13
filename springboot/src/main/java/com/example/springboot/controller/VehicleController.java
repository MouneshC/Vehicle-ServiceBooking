package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.model.Vehicle; // Adjust import
import com.example.springboot.service.VehicleService; // Adjust import

import java.util.List;

@RestController
@RequestMapping("/api/vehicle") // Change endpoint to /api/vehicle
public class VehicleController {

    @Autowired
    private VehicleService vehicleService; // Adjust service reference

    @PostMapping // No changes needed here
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleService.create(vehicle); // Adjust service method
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @GetMapping // No changes needed here
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles(); // Adjust service method
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{id}") // No changes needed here
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id).orElse(null); // Adjust service method
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}") // No changes needed here
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicle) {
        if (vehicleService.updateVehicle(id, vehicle)) { // Adjust service method
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}") // No changes needed here
    public ResponseEntity<Boolean> deleteVehicle(@PathVariable("id") int id) {
        if (vehicleService.deleteVehicle(id)) { // Adjust service method
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
