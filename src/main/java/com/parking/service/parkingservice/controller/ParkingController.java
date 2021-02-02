package com.parking.service.parkingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.service.parkingservice.model.Parking;
import com.parking.service.parkingservice.service.ParkingService;

/**
 * The Class ParkingController.
 */
@RestController
public class ParkingController {
	
	/** The parking service. */
	@Autowired
	private ParkingService parkingService;
	
	/**
	 * In coming vehicle.
	 *
	 * @param parkingVehicle the parking vehicle
	 * @return the response entity
	 */
	@PostMapping("/incoming-vehicle")
	public ResponseEntity<Parking> inComingVehicle(@RequestBody Parking parkingVehicle) {
		
		return new ResponseEntity<>(parkingService.inComingVehicle(parkingVehicle), HttpStatus.OK);
		
	}
	
	/**
	 * Out going vehicle.
	 *
	 * @param vehicle the vehicle
	 * @return the response entity
	 */
	@PatchMapping("/outgoing-vehicle")
	public ResponseEntity<Parking> outGoingVehicle(@RequestBody Parking vehicle) {
		
		return new ResponseEntity<>(parkingService.outGoingVehicle(vehicle.getVehicleNumber()), HttpStatus.OK);
		
	}
	
	/**
	 * All parked vehicle.
	 *
	 * @return the response entity
	 */
	@GetMapping("/all-parked-vehicle")
	public ResponseEntity<List<Parking>> AllParkedVehicle() {
		
		return new ResponseEntity<>(parkingService.getAllPrakedVehicles(), HttpStatus.OK);
		
	}
	
	/**
	 * Available slots.
	 *
	 * @return the response entity
	 */
	@GetMapping("/available-slots")
	public ResponseEntity<Long> AvailableSlots() {
		
		return new ResponseEntity<>(parkingService.availableSLots(), HttpStatus.OK);
		
	}
	
	/**
	 * Gets the charge.
	 *
	 * @param vehicle the vehicle
	 * @return the charge
	 */
	@GetMapping("/parking-charge")
	public ResponseEntity<Long> getCharge(@RequestBody Parking vehicle) {
		
		return new ResponseEntity<>(parkingService.getCurrentCharge(vehicle.getVehicleNumber()), HttpStatus.OK);
		
	}

}
