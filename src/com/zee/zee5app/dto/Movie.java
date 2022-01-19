package com.zee.zee5app.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class Movie {

	private String name;
	private String category;
	private Date releaseDate;
	private String trailer;
	private String language;
	private String cast[];
	private int length;
	private String id;

}
