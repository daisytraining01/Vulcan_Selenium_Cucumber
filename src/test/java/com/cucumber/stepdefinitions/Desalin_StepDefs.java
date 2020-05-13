package com.cucumber.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;
import java.util.logging.Logger;

import com.cucumber.helper.UserActions;
import com.cucumber.pageobjects.LoginPage;
import com.cucumber.pageobjects.Transfer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Desalin_StepDefs {
	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	UserActions User;
	Hashtable<String, String> Data;

	public Desalin_StepDefs(UserActions User) {
		this.User = User;
	}

	@Given("User Launched {string} in Browser")
	public void user_Launched_in_Browser(String URL) {
		User.OpenUrl(URL);
		Log.info("Application is launched with URL");
	}

	@Given("Application base page is displayed with Login Username and Password Fields")
	public void application_base_page_is_displayed_with_Login_Username_and_Password_Fields() {
		assertEquals(true, User.isDisplayed(LoginPage.UserName));
		assertEquals(true, User.isDisplayed(LoginPage.Password));
		Log.info("Username and Password are displayed as expected");

	}

//
	@When("User enters Username : {string} , Password : {string}")
	public void user_enters_Username_Password(String string, String string2) {
		User.SendKeys(LoginPage.UserName, "labuser");
		User.SendKeys(LoginPage.Password, "labuser@01");

	}

	@When("Clicks on the submit button")
	public void clicks_on_the_submit_button() throws InterruptedException {
		User.Click(LoginPage.SubmitButton);
	}

	@Then("User Verifies the application is logged in successfully")
	public void user_Verifies_the_application_is_logged_in_successfully() {
	}

	@Given("User can navigate to home page")
	public void user_can_navigate_to_home_page() {

	}

	@Given("click on transfer tab")
	public void click_on_transfer_tab() throws InterruptedException {
		User.Click(Transfer.transfer);
	}

	@Given("click on the between account under transfer tab")
	public void click_on_the_between_account_under_transfer_tab() throws InterruptedException {
		User.Click(Transfer.betwenaccount);

	}

	@Given("application balance transfer page is displayed with transfer from and transfer to and transfer ammount fields")
	public void application_balance_transfer_page_is_displayed_with_transfer_from_and_transfer_to_and_transfer_ammount_fields() {

	}

	@When("User enters transfer to  : {string} , transfer from : {string}, transfer ammount: {string}")
	public void user_enters_transfer_to_transfer_from_transfer_ammount(String transferX, String transferY,
			String balanceXY) {
		User.selectFromDropdownsendKeys(Transfer.accountRX, "Primary");
		User.selectFromDropdownsendKeys(Transfer.accountTX, "Savings");
		User.selectFromDropdownsendKeys(Transfer.accountAmount, "1000");
	}

	@Then("User Verifies the transaction is done  successfully")
	public void user_Verifies_the_transaction_is_done_successfully() {
	}

	
	@And("click on view accountdetails")
	public void click_on_view_accountdetails()
	{
		
	}

	@Then("user should on home page")
	public void user_should_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
}
