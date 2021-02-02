package com.parking.service.parkingservice.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parking.service.parkingservice.config.ConfigurationProperties;
import com.parking.service.parkingservice.dao.ParkingRepository;
import com.parking.service.parkingservice.model.Parking;
import com.parking.service.parkingservice.service.ParkingService;

/**
 * The Class ParkingServiceImpl.
 */
@Service
public class ParkingServiceImpl implements ParkingService{
	
	/** The repository. */
	@Autowired
	private ParkingRepository repository;
	
	/** The config. */
	@Autowired
	private ConfigurationProperties config;

	/**
	 * In coming vehicle.
	 *
	 * @param parkInComingVehicle the park in coming vehicle
	 * @return the parking
	 */
	@Override
	@Transactional
	public Parking inComingVehicle(Parking parkInComingVehicle) {
		
		if(null == isVehicleParked(parkInComingVehicle.getVehicleNumber()) && checkParkingLimit())
			repository.save(parkInComingVehicle);
		return parkInComingVehicle;
	}

	/**
	 * Out going vehicle.
	 *
	 * @param vehicleNumber the vehicle number
	 * @return the parking
	 */
	@Override
	public Parking outGoingVehicle(String vehicleNumber) {
		
		Parking vehicleParked = this.isVehicleParked(vehicleNumber);
		if(null != vehicleParked) {
			vehicleParked.setOutTime(LocalDateTime.now());
			
			repository.save(vehicleParked);
			
			return vehicleParked;
		}
		return null;
	}
	
	/**
	 * Checks if is vehicle parked.
	 *
	 * @param number the number
	 * @return the parking
	 */
	private Parking isVehicleParked(String number) {
		
		Parking vehicle = null;
		if(null == number || number.isBlank())
			return null;
		
		List<Parking> findByVehicleNumber = repository.findByVehicleNumber(number);
		
		findByVehicleNumber.stream().forEach(System.out::println);
		
		if(findByVehicleNumber != null) {
			java.util.Optional<Parking> parking= findByVehicleNumber.stream().filter(vehicle1 -> vehicle1.getOutTime() == null).findFirst();
			
			if(parking.isPresent())
				vehicle = parking.get();
		}
			
		
		if(vehicle != null)
			return vehicle;
		
		return null;
		
	}

	/**
	 * Gets the all praked vehicles.
	 *
	 * @return the all praked vehicles
	 */
	@Override
	public List<Parking> getAllPrakedVehicles() {
		
		List<Parking> findAll = repository.findAll();
		
		List<Parking> collect = findAll.stream().filter(vehicle -> vehicle.getOutTime() == null).collect(Collectors.toList());
		
		return collect;
	}
	
	/**
	 * Check parking limit.
	 *
	 * @return true, if successful
	 */
	private boolean checkParkingLimit() {
		
		Long collect = getParkedCount();
		
		return config.getLimit() > collect ? true : false;
	}
	
	/**
	 * Available S lots.
	 *
	 * @return the long
	 */
	@Override
	public Long availableSLots() {
		Long collect = getParkedCount();
		
		return config.getLimit() - collect;
	}

	/**
	 * Gets the parked count.
	 *
	 * @return the parked count
	 */
	private Long getParkedCount() {
		List<Parking> findAll = repository.findAll();
		Long collect = findAll.stream().filter(vehicle -> vehicle.getOutTime() == null).collect(Collectors.counting());
		return collect;
	}
	
	/**
	 * Gets the current charge.
	 *
	 * @param number the number
	 * @return the current charge
	 */
	@Override
	public Long getCurrentCharge(String number) {
		Parking vehicleParked = isVehicleParked(number);
		
		return vehicleParked != null ? ChronoUnit.HOURS.between(vehicleParked.getInTime(), LocalDateTime.now()) * 10 : 0;
	}

}
