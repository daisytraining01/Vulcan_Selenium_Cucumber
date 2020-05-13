package com.cucumber.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.cucumber.helper.UserActions;
import com.cucumber.pageobjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	UserActions User;
	Hashtable<String,String> Data;

	public LoginSteps(UserActions User) {
		this.User = User;
	}

	@Given("^User Launched \"([^\"]*)\" in Browser$")
	public void user_Launched_in_Browser(String URL) throws Throwable {
		User.OpenUrl(URL);
		Log.info("Application is launched with URL");
	}

	@And("^Application base page is displayed with Login Username and Password Fields$")
	public void application_base_page_is_displayed_with_Login_Username_and_Password_Fields() throws Throwable {
		assertEquals(true, User.isDisplayed(LoginPage.UserName));
		assertEquals(true, User.isDisplayed(LoginPage.Password));
		Log.info("Username and Password are displayed as expected");
	}

	@When("^User enters Username : \"([^\"]*)\" , Password : \"([^\"]*)\"$")
	public void user_enters_Username_Password(String Username, String Password) throws Throwable {
		User.SendKeys(LoginPage.UserName, Username);
		User.SendKeys(LoginPage.Password,Password);
		Log.info("Username "+Username+"and Password are filled with data ");
	}

	@And("^Clicks on the submit button$")
	public void clicks_on_the_submit_button() throws Throwable {
		
		  assertEquals(true,User.isEnabled(LoginPage.SubmitButton));
		  User.Click(LoginPage.SubmitButton);
		  Log.info("Clicked on the Submit Button");
	}

	@Then("^User Verifies the application is logged in successfully$")
	public void user_Verifies_the_application_is_logged_in_successfully() throws Throwable {
		Log.info("User has logged successfully");
	}
}
