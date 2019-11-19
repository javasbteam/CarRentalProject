package com.ivl.car.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SearchModel {

	private long city;
	private long carType;
	private String fromDate;
	private String toDate;
}
