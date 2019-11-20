package com.ivl.car.entity;

import java.io.Serializable;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BookedCar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int bookId;
	private int carId;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String bkFromDt;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String bkToDt;

}
