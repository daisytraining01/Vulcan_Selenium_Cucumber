package com.cucumber.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.enumerations.BrowserType;
import com.manager.DriverManager;
import com.manager.TestData;

import io.cucumber.java.Scenario;

public class UserActions {

	private static Logger Log = Logger.getLogger(UserActions.class.getName());

	WebDriver driver;
	TestData Data = new TestData();

	public void LaunchBrowser(BrowserType browser) {
		driver = new DriverManager(browser).getDriver();
	}

	public void OpenUrl(String URL) {
		Log.info("Application URL :" + URL);
		driver.get(URL);
	}

	public void SelectByVisible_Text(By Locator, String text) {
		WebElement element = driver.findElement(Locator);
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}

	public void CaptureScreenshot(Scenario scenario, String text) {
		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", text + " Screenshot");
			Log.info("Captured Screenshot");
		} catch (WebDriverException e) {
			Log.error(e.getMessage());
			System.err.println(e.getMessage());

		}
	}

	public boolean isDisplayed(By Locator) {
		return driver.findElement(Locator).isDisplayed();
	}

	public String getText(By Locator) {
		return driver.findElement(Locator).getText();
	}

	public boolean isEnabled(By Locator) {
		return driver.findElement(Locator).isEnabled();
	}

	public boolean isSelected(By Locator) {
		return driver.findElement(Locator).isSelected();
	}

	public void Click(By Locator) {
		driver.findElement(Locator).click();
	}

	public void selectromDropDown(By Locator, String text) {
		Select element = new Select(driver.findElement(Locator));
		element.selectByVisibleText(text);
	}

	public void SendKeys(By Locator, String text) {
		driver.findElement(Locator).sendKeys(text);
	}

	public void ClearAndSendKeys(By Locator, String Text) {
		driver.findElement(Locator).click();
		driver.findElement(Locator).clear();
		driver.findElement(Locator).sendKeys(Text);
	}

	public void WaitAndClick(By Locator, int TimeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
	}

	public void WaitAndSendKeys(By Locator, int TimeOutInSeconds, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		ele.click();
		ele.sendKeys(Text);
	}

	public void WaitClearAndSendKeys(By Locator, int TimeOutInSeconds, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		ele.click();
		ele.clear();
		ele.sendKeys(Text);
	}

	public void Quit() {
		driver.quit();

	}

	public void selectFromDropdownsendKeys(By by, String string) {
		Select sc = new Select(driver.findElement(by));
		sc.selectByVisibleText(string);

	}

}
