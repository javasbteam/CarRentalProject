package com.ivl.car.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class CarModel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int carId;
	private String apiAddress;
	private String carType;
	private String startDt;
	private String endDt;
	private double fare;
	private String carModel;
	public CarModel( int carId, String carType, String startDt, String endDt, double fare, String carModel) {
		this.carId = carId;
		this.carType = carType;
		this.startDt = startDt;
		this.endDt = endDt;
		this.fare = fare;
		this.carModel = carModel;
	}

}
