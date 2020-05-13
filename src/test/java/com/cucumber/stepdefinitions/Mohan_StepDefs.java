package com.cucumber.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.codoid.products.exception.FilloException;
import com.cucumber.helper.UserActions;
import com.cucumber.pageobjects.LoginPage;
import com.cucumber.pageobjects.Transfer;
import com.manager.TestData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Mohan_StepDefs {

	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	UserActions User;
	Hashtable<String,String> Data;

	public Mohan_StepDefs(UserActions User) {
		this.User = User;
	}
	

	
	@Given("User is loggedin to the application with the  {string} , {string} and {string} in Browser")
	public void user_is_loggedin_to_the_application_with_the_and_in_Browser(String URL, String userName, String Password) {
		User.OpenUrl(URL);
		Log.info("Application is launched with URL");
		User.SendKeys(LoginPage.UserName, userName);
		User.SendKeys(LoginPage.Password,Password);
		User.Click(LoginPage.SubmitButton);
	}
	
	

	@Given("A fund transer of rs {string} has been done betweeb the same account")
	public void a_fund_transer_of_rs_has_been_done_betweeb_the_same_account(String amount) {
		User.Click(By.xpath("//a[@role='button' and contains(.,'Transfer')]"));
	  User.Click(By.linkText("Between Accounts"));
	  User.selectromDropDown(By.id("transferFrom") , "Primary");
	  User.SendKeys(By.id("amount"), amount);
	  User.Click(Transfer.TransferButton);
	}

	
	@When("The user opens the statement page")
	public void the_user_opens_the_statement_page() {
	    
		User.Click(By.xpath("//a[@role='button' and contains(.,'Accounts')]"));
		  User.Click(By.linkText("Primary"));
		
	}

	@When("The Statement is sorted for the last Done transaction")
	public void the_Statement_is_sorted_for_the_last_Done_transaction() {
		
		User.Click(By.xpath("//th[@class='sorting_asc' and contains(.,'Post Date')]"));
	   
	}

	
	
	@Then("User verifies that the last transaction {string}")
	public void user_verifies_that_the_last_transaction(String amountTransfered) {
		String  amountGet  = (User.getText(By.xpath("//tbody/tr[1]/td[5]")));
		String [] amountArray = amountGet.split("\\.");
		 int amount =Integer.parseInt(amountArray[0]);
		 int cmpAmount = Integer.parseInt(amountTransfered);
		 assertEquals(true, (amount==cmpAmount));
		 
	}
	
	@Then("User verifies last transaction amount and the balance")
	public void user_verifies_last_transaction_amount_and_the_balance() {
	    
		int currentBalance = Integer.parseInt( User.getText(By.xpath("//tbody/tr[1]/td[6]")).split("\\.")[0]);
		int oldBalance = Integer.parseInt( User.getText(By.xpath("//tbody/tr[2]/td[6]")).split("\\.")[0]);
		int transeredAmount = Integer.parseInt( User.getText(By.xpath("//tbody/tr[1]/td[5]")).split("\\.")[0]);
		assertEquals(true, (currentBalance==oldBalance-transeredAmount));
	}
	

	@Then("Logs out of the application")
	public void logs_out_of_the_application() {
		
		User.Click(By.xpath("//a[@role='button' and contains(.,'Me')]"));
		  User.Click(By.linkText("Logout"));
		
	   
	}


	
	
	
	
}
