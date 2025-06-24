package com.WMS_ApplicationPages;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class ColorLookPage extends WMS_WebDriverUtilities{
	WebDriver driver;
	
	public ColorLookPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement Locators------------------------------------------------------

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;
	
	@FindBy(xpath = "//*[text()='Prints and Patterns']")
	private WebElement printPatterns;
	
	@FindBy(xpath = "//*[@id='imageFile']")
	private WebElement thumbnail;
	
	@FindBy(xpath = "//*[@id='lscoVendorCreated']")
	private WebElement vendorCreated;
	
	@FindBy(xpath = "//*[text()='Sundry Color']")
	private WebElement sundryColor;
	
	@FindBy(xpath = "//*[@class='PAGEHEADING']//following::select[1]")
	private WebElement actions;
	
	@FindBy(xpath = "//*[@name='ptc_str_5']")
	private WebElement colorName;
	
	@FindBy(xpath = "//*[@name='ptc_str_18']")
	private WebElement artWorkName;
	
	@FindBy(xpath = "//*[text()=' Color Code ']//following::div[1]//input")
	private WebElement colorCode;	
	
	@FindBy(xpath = "(//*[text()='Search'])[1]")
	private WebElement search;	
	
	@FindBy(xpath = "//*[text()='Save']")
	private WebElement save;
	
	@FindBy(xpath = "//*[@id='quickSearchText']")
	private WebElement filterdata;
	
	@FindBy(xpath = "(//*[contains(@col-id,'colorway.skuName')])[2]//a")
	private WebElement colorwayName;	
	

	
	
//	Page Methods------------------------------------------------------
	
	public void selectPrintPatternsColor(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(printPatterns)).click();
		Thread.sleep(5000);
		System.out.println("Print and patterns color is selected");
	}
	
	public void selectSundryColor(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sundryColor)).click();
		Thread.sleep(5000);
		System.out.println("Sundry color is selected");
	}
	
	public void uploadThumbnail(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(thumbnail));
		String filepath ="C:\\Users\\770660\\OneDrive - Cognizant\\Desktop\\levis_logo.jpg";
		thumbnail.sendKeys(filepath);
		Thread.sleep(5000);
		
		System.out.println("Thumbnail is uploaded");
	}
	
	public void validateVendorCreatedFlag(ExtentTest test) throws Exception {
		String flag=new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(vendorCreated)).getText();
		Thread.sleep(5000);
		System.out.println("flag is "+flag);
	//	Assert.assertEquals(flag, "Yes");
		System.out.println("vendor Created flag is set to "+flag);
		
	}
	
	public void updateSundryColor(ExtentTest test) throws Exception {
	/*	driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe); */
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(actions));
		selectValueFromDropdown(actions,"Update");
		Thread.sleep(5000);
		String name = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorName)).getAttribute("value");
		String editname= name+"_editted";
		System.out.println("name is "+name);
		System.out.println("editted name is "+editname);
		colorName.clear();
		colorName.sendKeys(editname);
		Thread.sleep(6000);
		Assert.assertNotSame(name,editname);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
		Thread.sleep(6000);
		System.out.println("Sundry Color name is editted");
		
	}
	
	public void updatepickPatternsColor(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(actions));
		selectValueFromDropdown(actions,"Update");
		Thread.sleep(5000);
		String name = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(artWorkName)).getAttribute("value");
		String editname= name+"_editted";
		System.out.println("name is "+name);
		System.out.println("editted name is "+editname);
		artWorkName.clear();
		artWorkName.sendKeys(editname);
		Thread.sleep(6000);
		Assert.assertNotSame(name,editname);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
		Thread.sleep(6000);
		System.out.println("Pick and patterns Color name is editted");
		
		
	}
	
	public void openPrintColor(ExtentTest test,String printColor) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorCode)).sendKeys(printColor);;
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(search)).click();
		Thread.sleep(5000);
		System.out.println("color page opened");
	}
	public void openSundryColor(ExtentTest test,String sundryColor) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorCode)).sendKeys(sundryColor);;
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(search)).click();
		Thread.sleep(5000);
		System.out.println("color page opened");
	}
		

}
