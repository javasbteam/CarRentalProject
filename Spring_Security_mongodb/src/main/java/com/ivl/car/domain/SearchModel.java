package com.ivl.car.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class SearchModel implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String carType;
	private String city;
	private String startDt;
	private String endDt;

	

}
