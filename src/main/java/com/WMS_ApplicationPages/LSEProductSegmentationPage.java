package com.WMS_ApplicationPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.plm.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;

public class LSEProductSegmentationPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public LSEProductSegmentationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeSidebar;

	@FindBy(id = "siteNavLink")
	private WebElement siteLabel;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement selectseason;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement MySeasonsOption;

	@FindBy(xpath = "//label[normalize-space()='Favorites']")
	private WebElement FavoritesOption;

	@FindBy(xpath = "//label[@title='Seasons']")
	private WebElement SeasonsDropdown;

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	@FindBy(xpath = "//td[@id='lscoBrand']")
	private WebElement lseProductBrand;

	@FindBy(xpath = "//td[@id='lscoProductCat']")
	private WebElement lseProductCategory;

	@FindBy(xpath = "//td[@id='lscoConsumerGrp1']")
	private WebElement lseConsumerGroup;

	// Getters for the LSE product segmentation details
	public String getLSEProductBrand() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(lseProductBrand));

		return lseProductBrand.getText();
	}

	public String getLSEProductCategory() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(lseProductCategory));

		return lseProductCategory.getText();
	}

	public String getLSEConsumerGroup() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(lseConsumerGroup));

		return lseConsumerGroup.getText();
	}
}
