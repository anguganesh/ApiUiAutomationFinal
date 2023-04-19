package com.api.automation.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleInfo {

	String country;
	String saleability;
	Boolean isEbook;
	ListPrice listPrice;
	RetailPrice retailPrice;
	String buyLink;
	List<Offers> offers;
	
}
