package com.WMS_ApplicationPages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;

public class ColorDetailsPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public ColorDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//iframe[@id='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//td[@id='lscoColorName']")
	private WebElement lscoArtworkName;
	
	@FindBy(xpath = "//td[@id='lscoArtwork']")
	private WebElement lscoArtwork;
	
	@FindBy(xpath = "//td[@id='lscoColorCombo']")
	private WebElement colorComboElement;
	
	@FindBy(xpath = "//td[@id='lscoPrintType']")
	private WebElement printTypeElement;

	

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	private boolean Capture;
	

	 public String getLscoArtworkName(ExtentTest test) throws InterruptedException {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(iframeContentframe);
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lscoArtworkName));
	        String lscoartworkName = lscoArtworkName.getText();
	        test.log(Status.INFO, "lsco Artwork Name From Color Extracted: " + lscoartworkName);
	        addSrceenShot("lsco Artwork Name From Color Extracted", test, Capture);
	        return lscoartworkName;
	    }

	    public String getLscoArtwork(ExtentTest test) throws InterruptedException {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(iframeContentframe);
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lscoArtwork));
	        String lscoartwork = lscoArtwork.getText();
	        test.log(Status.INFO, "lsco Artwork From Color Extracted: " + lscoartwork);
	        addSrceenShot("lsco Artwork From Color Extracted", test, Capture);
	        return lscoartwork;
	    }

	    public String getColorCombo(ExtentTest test) throws InterruptedException {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(iframeContentframe);
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorComboElement));
	        String colorCombo = colorComboElement.getText();
	        test.log(Status.INFO, "color Combo From Color Extracted: " + colorCombo);
	        addSrceenShot("color Combo From Color Extracted", test, Capture);
	        return colorCombo;
	    }

	    public String getPrintType(ExtentTest test) throws InterruptedException {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(iframeContentframe);
	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(printTypeElement));
	        String printType = printTypeElement.getText();
	        test.log(Status.INFO, "Print Type From Color Extracted: " + printType);
	        addSrceenShot("Print Type From Color Extracted", test, Capture);
	        return printType;
	    }

	}