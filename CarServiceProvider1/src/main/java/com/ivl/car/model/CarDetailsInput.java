package com.ivl.car.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CarDetailsInput implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String carType;
	private String city;
	private Date   startDt;
	private Date   endDt;
	

}
