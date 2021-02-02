package com.parking.service.parkingservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Parking.
 */
@Entity
@Table(name = "PARKING")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parking implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	/** The in time. */
	@Column(name = "IN_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime inTime;

	/** The out time. */
	@Column(name = "OUT_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime outTime;

	/** The vehicle number. */
	@JsonProperty
	@Column(name = "VEHICLE_NUMBER")
	private String vehicleNumber;

	/** The vehicle type. */
	@JsonProperty
	@Column(name = "VEHICLE_TYPE")
	private String vehicleType;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the in time.
	 *
	 * @return the in time
	 */
	public LocalDateTime getInTime() {
		return inTime;
	}

	/**
	 * Sets the in time.
	 *
	 * @param inTime the new in time
	 */
	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}

	/**
	 * Gets the out time.
	 *
	 * @return the out time
	 */
	public LocalDateTime getOutTime() {
		return outTime;
	}

	/**
	 * Sets the out time.
	 *
	 * @param outTime the new out time
	 */
	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
	}

	/**
	 * Gets the vehicle number.
	 *
	 * @return the vehicle number
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * Sets the vehicle number.
	 *
	 * @param vehicleNumber the new vehicle number
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * Gets the vehicle type.
	 *
	 * @return the vehicle type
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * Sets the vehicle type.
	 *
	 * @param vehicleType the new vehicle type
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Parking [id=" + id + ", inTime=" + inTime + ", outTime=" + outTime + ", vehicleNumber=" + vehicleNumber
				+ ", vehicleType=" + vehicleType + "]";
	}

}
