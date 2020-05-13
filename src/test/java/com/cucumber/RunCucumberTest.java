package com.cucumber;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:Features" }, glue = { "classpath:com.cucumber.stepdefinitions",
		"classpath:com.cucumber.helper" }, tags = {
				"@Mohan" }, strict = true, monochrome = true, dryRun = false, plugin = { "pretty",
						"html:target/reports/normal", "json:target/cucumber.json", "junit:target/cucumber.xml",
						"rerun:target/rerun.txt" }

)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

	private static Logger Log = Logger.getLogger(RunCucumberTest.class.getName());

	@BeforeMethod
	public void beforeMethod(ITestContext context) {
		Log.info("New Test Initiated Before Method");

	}

	@AfterMethod
	public void afterMethod(ITestContext context) {
		Log.info("New Test Initiated After Method");
	}

	@BeforeClass
	public void beforeClass() {

		try {
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f /im chrome.exe");

		} catch (IOException e) {
			System.out.println("Runtime Exception");
		}

	}

	@AfterClass
	public void afterClass() {

		try {
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f /im chrome.exe");

		} catch (IOException e) {
			System.out.println("Runtime Exception");
		}

	}

	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}
}