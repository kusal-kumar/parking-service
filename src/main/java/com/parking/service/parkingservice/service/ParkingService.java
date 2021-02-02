package com.parking.service.parkingservice.service;

import java.util.List;

import com.parking.service.parkingservice.model.Parking;

/**
 * The Interface ParkingService.
 */
public interface ParkingService {

	/**
	 * In coming vehicle.
	 *
	 * @param parkInComingVehicle the park in coming vehicle
	 * @return the parking
	 */
	Parking inComingVehicle(Parking parkInComingVehicle);
	
	/**
	 * Out going vehicle.
	 *
	 * @param vehicleNumber the vehicle number
	 * @return the parking
	 */
	Parking outGoingVehicle(String vehicleNumber);
	
	/**
	 * Gets the all praked vehicles.
	 *
	 * @return the all praked vehicles
	 */
	List<Parking> getAllPrakedVehicles();
	
	/**
	 * Available S lots.
	 *
	 * @return the long
	 */
	Long availableSLots();
	
	/**
	 * Gets the current charge.
	 *
	 * @param number the number
	 * @return the current charge
	 */
	Long getCurrentCharge(String number);
}
