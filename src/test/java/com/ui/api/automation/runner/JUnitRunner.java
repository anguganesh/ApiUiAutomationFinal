package com.ui.api.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "./Features",
		glue = {"com.ui.automation.steps",
				"com.api.automation.steps",
				"com.ui.api.automation.configuration"},
		plugin = {"pretty","html:target/cucumberHTML/cucumber-html-report.html",
				   "json:target/cucumberJson/cucumber.json", 				
				   "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		monochrome = true,
		publish = true,
		dryRun = false,
		tags = "@UI"
						
		
		)

public class JUnitRunner {


}