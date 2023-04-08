package com.ui.automation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrowserDetailsModel {

	String browserName;
	String baseUrl;
	Boolean headless;
	Boolean remote;
	Integer pageLoadTimeOut;
	Integer explicitWait;
	Integer implicitWait;
	Integer waitForAttributeTimeout;
	Integer waitForAttributePollingInterval;

	
}

