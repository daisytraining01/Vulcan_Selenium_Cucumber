package com.cucumber.stepdefinitions;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.cucumber.helper.UserActions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Swetha_StepDefs {

	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	UserActions User;
	Hashtable<String,String> Data;

	public Swetha_StepDefs(UserActions User) {
		this.User = User;
	}
	

@Then("User clicks on To some Else tab under Transfer menu")
public void user_clicks_on_To_some_Else_tab_under_Transfer_menu() {
    // Write code here that turns the phrase above into concrete actions
   System.out.println("User Clicks on to Transfer Screen");
}

@Then("Application base page is displayed with the fields Recipient details, Account Type, Amount field")
public void application_base_page_is_displayed_with_the_fields_Recipient_details_Account_Type_Amount_field() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Application Base Page is displayed");
}

@When("User selects the  Receipient, Account Type , enters {string}")
public void user_selects_the_Receipient_Account_Type_enters(String string) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("User selects the Receipient");
}

@When("Clicks on Transter button")
public void clicks_on_Transter_button() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Clicks on Transfer Button");
}

@Then("Amount should be debited from the Account")
public void amount_should_be_debited_from_the_Account() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("Amount should be debited from the account");
}

}
