package com.ivl.car.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document("BOOKED_CAR")
public class BookedCar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int bookId;
	@Field(name = "CAR_ID",targetType = FieldType.INT32)
	private int carId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date bkFromDt;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date bkToDt;

}
