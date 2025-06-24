package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class CarryoverPage extends WMS_WebDriverUtilities{
WebDriver driver;
	
	public CarryoverPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement Loactors------------------------------------------------------
	
	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;
	
	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement Actions_menu;

	@FindBy(xpath = "//a[@id='addAction']")
	private WebElement Add_menu;

	@FindBy(xpath = "//a[@id='carryOverSKU']")
	private WebElement Carryover_colorways;

	@FindBy(xpath = "//select[@id='selectedSeason']")
	private WebElement SelectInitialseason;

	@FindBy(xpath = "//div[@ref='eCheckbox']//div/input")
	private WebElement Firstcheckbox;

	@FindBy(xpath = "//span[normalize-space()='Select']")
	private WebElement Select_button;
	
	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement FilterTextbox;
	
//	--------------------------------Methods---------------------------------------
	public void Select_CarryOvercolorways() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(Actions_menu)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(Add_menu)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(Carryover_colorways)).click();
	}

	public void SelectInitialSeason(String initialseason) throws InterruptedException {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		selectValueFromDropdown(SelectInitialseason, initialseason);
	}
	public void SelectCarryovercolorway() throws InterruptedException {
		Firstcheckbox.click();
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Firstcheckbox)).click();
		new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(Select_button)).click();
		
		Thread.sleep(3000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
	}
	public void filterdata(String filtervalue) {
		new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(FilterTextbox));
		FilterTextbox.sendKeys(filtervalue);
	}
	
	
}
