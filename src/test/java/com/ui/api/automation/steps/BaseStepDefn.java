package com.ui.api.automation.steps;


import org.openqa.selenium.WebDriver;

import com.ui.api.automation.config.datapath.JsonFilePath;
import com.ui.api.automation.config.datapath.YamlFilePath;
import com.ui.api.automation.configuration.Hooks;

public class BaseStepDefn {

	private final Hooks hooks;
	public WebDriver driver;
	public YamlFilePath yamlFilePath;
	public JsonFilePath jsonFilePath;

	
	public BaseStepDefn(Hooks hooks) {
		this.hooks = hooks;
		this.driver = hooks.getDriver();
		this.yamlFilePath = hooks.getYamlFilePathObject();
		this.jsonFilePath = hooks.getJsonFilePathObject();
	}
	
}