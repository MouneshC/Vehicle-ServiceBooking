package com.example.springboot.repository;

import com.example.springboot.model.Vehicle; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT v FROM Vehicle v WHERE v.vehicleName = ?1") 
    List<Vehicle> findByVehicleName(String vehicleName); 
    
    @Query("SELECT v FROM Vehicle v WHERE v.id IN (SELECT DISTINCT v.id FROM Vehicle v INNER JOIN v.users u WHERE u.id = ?1)") 
    List<Vehicle> findByUserId(int userId); 
}
