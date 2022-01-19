package com.zee.zee5app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Subscription  {

	private String type;
	private Date dateOfPurchase;
	private boolean status;
	private String packCountry;
	private String paymentMode;
	private boolean autoRenewal;
	private Date expriryDate;
	private String id;
	

}
