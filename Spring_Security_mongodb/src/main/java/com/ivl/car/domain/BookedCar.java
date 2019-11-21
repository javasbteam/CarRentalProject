package com.ivl.car.domain;

import java.io.Serializable;




import lombok.Data;

@Data
public class BookedCar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int bookId;
	private int carId;
	private String bkFromDt;
	private String bkToDt;

}
