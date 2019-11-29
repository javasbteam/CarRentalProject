package com.ivl.car.domain;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SearchModel implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Please Select Car Type")
	private String carType;
	@NotEmpty(message = "Please Select City")
	private String city;
	@NotEmpty(message="Please Select Start date")
	private String startDt;
	@NotEmpty(message="Please Select End date")
	private String endDt;

	

}
