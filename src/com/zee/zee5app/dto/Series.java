package com.zee.zee5app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Series {

	private String name;
	private String category;
	private Date releaseDate;
	private String trailer;
	private String language;
	private String cast[];
	private int length;
	private String id;

}
