package com.ivl.car.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CarModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int carId;
	private String carType;
	private Date startDt;
	private Date endDt;
	private double fare;
	private String carModel;


}