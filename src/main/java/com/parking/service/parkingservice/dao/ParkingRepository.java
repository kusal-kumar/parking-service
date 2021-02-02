package com.parking.service.parkingservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.service.parkingservice.model.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer>{
	
	public List<Parking> findByVehicleNumber(String vehicleNumber);

}
