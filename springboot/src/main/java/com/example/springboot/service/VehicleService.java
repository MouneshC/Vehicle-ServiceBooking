package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.springboot.model.Vehicle; // Update import to Vehicle
import com.example.springboot.repository.VehicleRepo; // Update import to VehicleRepo

@Service
public class VehicleService { // Change service name to VehicleService

    @Autowired
    VehicleRepo vehicleRepository; // Change repository reference to VehicleRepo

    public Vehicle create(Vehicle vehicle) { // Update method parameter and return type to Vehicle
        return vehicleRepository.save(vehicle); // Change repository method to save vehicle
    }

    public List<Vehicle> getAllVehicles() { // Update return type to List<Vehicle>
        return vehicleRepository.findAll(); // Change repository method to findAll()
    }

    public Optional<Vehicle> getVehicleById(int id) { // Update return type to Optional<Vehicle>
        return vehicleRepository.findById(id); // Change repository method to findById()
    }

    public boolean updateVehicle(int id, Vehicle vehicle) { // Update method parameter and return type to Vehicle
        if (!vehicleRepository.existsById(id)) {
            return false;
        }
        vehicle.setId(id); // Adjust setter method name for ID
        vehicleRepository.save(vehicle); // Change repository method to save vehicle
        return true;
    }

    public boolean deleteVehicle(int id) { // Update method parameter and return type to Vehicle
        if (!vehicleRepository.existsById(id)) {
            return false;
        }
        vehicleRepository.deleteById(id); // Change repository method to deleteById()
        return true;
    }

    public List<Vehicle> getAllVehiclesSortedBy(String sortBy) { // Update return type to List<Vehicle>
        return vehicleRepository.findAll(Sort.by(sortBy)); // Change repository method to findAll(Sort)
    }

    public Page<Vehicle> getAllVehiclesPaginated(int pageNo, int pageSize) { // Update return type to Page<Vehicle>
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return vehicleRepository.findAll(pageable); // Change repository method to findAll(Pageable)
    }
    
    public List<Vehicle> findByVehicleName(String vehicleName) { // Update method name and parameter to findByVehicleName
        return vehicleRepository.findByVehicleName(vehicleName); // Change repository method to findByVehicleName
    }

    public List<Vehicle> findByUserId(int userId) { 
        return vehicleRepository.findByUserId(userId); 
    }
}
