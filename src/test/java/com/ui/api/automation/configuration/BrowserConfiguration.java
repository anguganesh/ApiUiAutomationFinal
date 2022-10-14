package com.ui.api.automation.configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.hc.core5.http.ContentType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.ui.api.automation.config.datapath.JsonFilePath;
import com.ui.api.automation.config.datapath.YamlFilePath;
import com.ui.api.automation.configuration.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;


public class BrowserConfiguration {

	public final Hooks hooks;
	private final ReportsConfiguration reportConfiguration;
	private YamlFilePath yamlFilePath;
	private JsonFilePath jsonFilePath;
	
	public BrowserConfiguration(Hooks hooks,
			 ReportsConfiguration allureReportConfiguration) {
		// TODO Auto-generated constructor stub
		this.hooks = hooks;
		this.reportConfiguration = allureReportConfiguration;
	}
	
	@Before
	public void openBrowser(Scenario scenario) {
		

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ObjectConfig.class);
		this.yamlFilePath = context.getBean(YamlFilePath.class); 
		this.jsonFilePath = context.getBean(JsonFilePath.class);
		
			
		System.out.println("scenario Name : " + scenario.getName());
		System.out.println("Thread : " + Thread.currentThread().getId());
    	System.out.println("Driver Address Initial : " + hooks.getDriver());

    	hooks.launchBrowser(this.yamlFilePath, this.jsonFilePath);
		System.out.println("Driver Address after creating : " + hooks.getDriver());
	}

	@After
	public void closeBrowser(Scenario scenario) throws IOException {
		System.out.println("Executing CloseBrowser Method");
		if(scenario.isFailed())  {
			hooks.copyScreenshotAsFile(scenario);
			scenario.attach(hooks.getScreenshotAsBytes(), ContentType.IMAGE_PNG.toString(), scenario.getName());			
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(hooks.getBase64StringOfScreenshot()).build());
			Allure.addAttachment("Screenshot for test failure for scenario: " + scenario.getName(), 
					new ByteArrayInputStream(reportConfiguration.takesScreenshotForAllureReport()));
		}
		     	
		
		hooks.closeBrowser();
	}


	

}