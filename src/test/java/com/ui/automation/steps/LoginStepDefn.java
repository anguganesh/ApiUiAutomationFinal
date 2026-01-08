package com.ui.automation.steps;

import java.io.IOException;

import org.testng.Assert;
import com.ui.api.automation.configuration.Hooks;
import com.ui.automation.model.LoginDataModel;
import com.ui.automation.pages.LoginPage;
import com.ui.automation.helpers.JsonHelper;
import com.ui.automation.helpers.YamlHelper;
import io.cucumber.java.en.Given;

public class LoginStepDefn extends BaseStepDefn {

	private final LoginPage loginPage;
	private final YamlHelper yamlHelper;
	private final JsonHelper jsonHelper;
	private LoginDataModel inputLoginData;

	public LoginStepDefn(LoginPage loginPage, YamlHelper yamlHelper, JsonHelper jsonHelper, Hooks hooks) {
		super(hooks);
		this.loginPage = loginPage;
		this.yamlHelper = yamlHelper;
		this.jsonHelper = jsonHelper;

	}

	@Given("User has to login first")
	public void userHasToLoginFirst() {

		setLoginPagePojo();
		System.out.println("InputLoginData " + inputLoginData);
		loginPage.login(inputLoginData);
		System.out.println("Executed in User has to login first");
	//	loginPage.clickElement();
		System.out.println("completed successfully");
	}

	@Given("User navigate to {string}")
	public void user_navigate_to(String url) {

		super.driver.get(url);
		System.out.println(super.driver.getTitle());
	}

	@Given("User navigates to {string}")
	public void user_navigates_to(String url) {
		super.driver.get(url);
		Assert.assertTrue(false);
	}

	@Given("User click on logoff in HomePage")
	public void userClickLogoff() {
		System.out.println("HomePage in gherkin line");
	}

	@Given("User click on logoff")
	public void userClickLogoffAgain() {
		Assert.assertTrue(true);
		System.out.println("LogOff in gherkin line");
	}

	@Given("finally Validated")
	public void finallValidated() {
		Assert.assertTrue(true);
		System.out.println("LogOff in gherkin line");
	}

	@Given("finally twist")
	public void finTwist() {
		Assert.assertTrue(true);
		System.out.println("final Twist");
	}

	@Given("finally twist2")
	public void finTwist2() {
		Assert.assertTrue(true);
		System.out.println("final Twist2");
	}

	public LoginDataModel setLoginPagePojo() {

		// Read Login Data Using YamlHelper

		try {
			String filepath = super.uiYamlFilePath.getLoginYamlFilePath();
			System.out.println("Login File Path" + filepath);
			System.out.println("Yaml Object : " + yamlHelper);
			inputLoginData = yamlHelper.readYamlToPojo(LoginDataModel.class, filepath);
			System.out.println("Application Properties Address : " + super.uiYamlFilePath);
			System.out.println("Application Properties Address : " + super.uiJsonFilePath);
		} catch (IOException IoEx) {
			System.out.println("Yaml to POJO exception: " + IoEx.getMessage());
		}
		return inputLoginData;

		// Read Login Data Using JsonHelper

		/*try {
			inputLoginData = jsonHelper.readJsonToPojo(LoginDataModel.class, super.jsonFilePath.getLoginJsonFilePath());
		} catch (IOException IoEx) {
			System.out.println("Json to POJO exception: " + IoEx.getMessage());
		}

		return inputLoginData; */

	}

}