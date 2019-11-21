package com.ivl.car.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
@Document("CAR_DETAILS")
public class CarModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Object id;
	
	@Field(name = "CAR_ID", targetType = FieldType.DOUBLE)
	private int carId;

	@Field(name = "CAR_TYPE", targetType = FieldType.STRING)
	private String carType;
	
	@Field(name = "START_DT", targetType = FieldType.STRING)
	private String startDt;
	
	@Field(name = "END_DT", targetType = FieldType.STRING)
	private String endDt;
	
	@Field(name = "FARE", targetType = FieldType.DOUBLE)
	private double fare;
	
	@Field(name = "CAR_MODEL", targetType = FieldType.STRING)
	private String carModel;

}
