package com.cucumber.helper;

import com.enumerations.BrowserType;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	UserActions User ;
	public Hooks(UserActions User) {
		this.User = User;
	}

	@Before
	public void before() {
		System.out.println("Before Hook");
		User.LaunchBrowser(BrowserType.Chrome);
	}

	@After
	public void after(Scenario scenario) {
		System.out.println("After Hook");
		if (scenario.isFailed()) {
			User.CaptureScreenshot(scenario,"Fail");

		}
		if (!scenario.isFailed()) {
			User.CaptureScreenshot(scenario,"Pass");
		}
		User.Quit();
	}

	@BeforeStep
	public void beforeStep(Scenario scenario) {

	}

	@AfterStep
	public void afterStep(Scenario scenario) {

		if (scenario.isFailed()) {
			User.CaptureScreenshot(scenario,"Fail");

		}
		if (!scenario.isFailed()) {
			User.CaptureScreenshot(scenario,"Pass");
		}

	}

}