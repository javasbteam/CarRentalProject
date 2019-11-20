package com.ivl.car.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchModel {

	private String carType;
	private String city;
	private String startDt;
	private String   endDt;
}
