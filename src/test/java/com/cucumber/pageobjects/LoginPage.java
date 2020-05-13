package com.cucumber.pageobjects;

import org.openqa.selenium.By;

import com.cucumber.helper.ObjectHelper;

public class LoginPage extends ObjectHelper{
	
	public static final By UserName = InputBox_With_name("username");
	
	public static final By Password = InputBox_With_name("password");

	public static final By SubmitButton = Button("Sign in");

	

}
