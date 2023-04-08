package com.ui.automation.steps;


import org.openqa.selenium.WebDriver;

import com.ui.api.automation.config.datapath.UiJsonFilePath;
import com.ui.api.automation.config.datapath.UiYamlFilePath;
import com.ui.api.automation.configuration.Hooks;

public class BaseStepDefn {

	private final Hooks hooks;
	public WebDriver driver;
	public UiYamlFilePath uiYamlFilePath;
	public UiJsonFilePath uiJsonFilePath;

	
	public BaseStepDefn(Hooks hooks) {
		this.hooks = hooks;
		this.driver = hooks.getDriver();
		this.uiYamlFilePath = hooks.getYamlFilePathObject();
		this.uiJsonFilePath = hooks.getJsonFilePathObject();
	}
	
}