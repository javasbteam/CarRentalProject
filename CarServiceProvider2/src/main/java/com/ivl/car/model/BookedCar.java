package com.ivl.car.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class BookedCar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int bookId;
	private int carId;
	private String bkFromDt;
	private String bkToDt;

}
