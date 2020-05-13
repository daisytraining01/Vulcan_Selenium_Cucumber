package com.cucumber.pageobjects;

import org.openqa.selenium.By;
import com.cucumber.helper.ObjectHelper;

public class Transfer extends ObjectHelper {

	public static final By TransferButton = Button("Transfer");

	public static final By transfer = By.xpath("//a[contains(text(),'Transfer ')]");

	public static final By betwenaccount = By.xpath("//a[@href='/transfer/betweenAccounts']");
	public static final By accountTX = By.xpath("//select[@id='transferFrom']");
	public static final By accountRX = By.xpath("//select[@id='transferTo']");
	public static final By accountAmount = By.xpath("//input[@id='amount']");
	public static final By accountdetails = By.xpath("//span[@class='pull-left'])[1]");
}
