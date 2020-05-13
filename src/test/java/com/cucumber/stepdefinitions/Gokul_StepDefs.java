package com.cucumber.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.cucumber.helper.UserActions;
import com.cucumber.pageobjects.Appointment;
import com.cucumber.pageobjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Gokul_StepDefs {

	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	UserActions User;
	Hashtable<String,String> Data;

	public Gokul_StepDefs(UserActions User) {
		this.User = User;
	}
	
	@Given("user launched {string} in browser")
	public void user_launched_in_browser(String Url) {
		User.OpenUrl(Url);
		Log.info("Application is launched with URL");
	}

	@Then("user should login with valid {string},{string} and clickon submit button on login page")
	public void user_should_login_with_valid_and_clickon_submit_button_on_login_page(String userName, String password) {
		User.SendKeys(LoginPage.UserName, userName);
		User.SendKeys(LoginPage.Password, password);
		User.Click(LoginPage.SubmitButton);
		Log.info("Username " + userName + "and Password " + password
				+ "are filled with data and clicked on SignIn button");

	}

	@Then("user should click on appointment button")
	public void user_should_click_on_appointment_button() {
		User.Click(Appointment.appointmentButton);
		User.Click(Appointment.scheduleAppointLink);
		Log.info("Appointment page should be open");
	   
	}

	@Then("application base page is displayed with pick a date and time,location and notes on the page")
	public void application_base_page_is_displayed_with_pick_a_date_and_time_location_and_notes_on_the_page() {
		assertEquals(true, User.isDisplayed(Appointment.clickOnCalendar));
		assertEquals(true, User.isDisplayed(Appointment.selectLocation));
		assertEquals(true, User.isDisplayed(Appointment.notes));
		assertEquals(true, User.isDisplayed(Appointment.submitShedulintButton));
		Log.info("Calender, Location are displayed as expected");
	   
	}

	@When("user select date and time {string} and {string} in appointment page")
	public void user_select_date_and_time_and_in_appointment_page(String location, String notes) {
		User.Click(Appointment.clickOnCalendar);
		User.Click(Appointment.selectdate);
		User.SelectByVisible_Text(Appointment.selectLocation, location);
		User.Click(Appointment.notes);
		Log.info("Appointment details are submitted");
	   
	}

	@When("user clicks on the submit scheduling button and confirm appointment")
	public void user_clicks_on_the_submit_scheduling_button_and_confirm_appointment() {
		User.Click(Appointment.scheduleAppointLink);
		User.Click(Appointment.confirmBtn);
		Log.info("Appointment details are submitted");
	}

	@Then("user should logout the application")
	public void user_should_logout_the_application() {
	   User.Click(Appointment.signUpButton);
	   Log.info("Application Logout");
	}
}
