package com.WMS_ApplicationPages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ReadDataSheet;

public class BusinessObjectPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public BusinessObjectPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	boolean Capture = true;

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//a[@id='SearchButton2']")
	private WebElement searchbutton_2;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	public void chooseBusinessObjectType(String businessObjectType) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchbutton_2));
		WebElement business_Object = driver
				.findElement(By.xpath("//a[normalize-space()='" + businessObjectType.trim() + "']"));
		business_Object.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//td[contains(text(),'Action')]/following::select[1]")
	private WebElement actionTypeDropdown;

	@FindBy(xpath = "//td[contains(text(),'Action')]/following::a[1]")
	private WebElement addActionButton;

	@FindBy(xpath = "//input[@id='LCSLIFECYCLEMANAGED_CREATESTAMPA2FromInput']")
	private WebElement createdDateField;

	@FindBy(xpath = "//td[contains(text(),'Message Table')]/following::input[1]")
	private WebElement messageTableField;

	@FindBy(xpath = "//td[contains(text(),'Hierarchy')]/following::input[1]")
	private WebElement hierarchyField;

	@FindBy(xpath = "//span[normalize-space()='Hide/Show Columns']")
	private WebElement hideColButton;
	
	@FindBy(xpath = "//td[@id='lscoStagingRowId']")
	private WebElement StagingId;

	public void chooseActionType(String actionType) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(actionTypeDropdown));
		Thread.sleep(2000);
		selectValueFromDropdown(actionTypeDropdown, actionType);
		Thread.sleep(2000);
		addActionButton.click();
	}

	public void enterCreatedDate(String createdDate) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createdDateField));
		Thread.sleep(2000);
		createdDateField.clear();
		createdDateField.sendKeys(createdDate);
	}

	public void enterMessageTable(String messageTableValue) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(messageTableField));
		Thread.sleep(2000);
		messageTableField.clear();
		messageTableField.sendKeys(messageTableValue);
		Thread.sleep(2000);
	}

	public void enterHierarchy(String hierarchyValue) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(hierarchyField));
		Thread.sleep(2000);
		hierarchyField.clear();
		hierarchyField.sendKeys(hierarchyValue);
		Thread.sleep(30000);
	}
	

	@FindBy(xpath = "//tr//td[contains(text(),'Event Hour')]/following::input[1]")
	private WebElement eventHourFrom;
	
	@FindBy(xpath = "//tr//td[contains(text(),'Event Hour')]/following::input[2]")
	private WebElement eventHourTo;
	
	public void enterEventHourFrom(String createdDate) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(eventHourFrom));
		Thread.sleep(2000);
		eventHourFrom.clear();
		eventHourFrom.sendKeys(createdDate);
	}
	
	public void enterEventHourTo(String createdDate) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(eventHourTo));
		Thread.sleep(2000);
		eventHourTo.clear();
		eventHourTo.sendKeys(createdDate);
	}
	

	public void clickSearch() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchbutton_2));
		Thread.sleep(2000);
		searchbutton_2.click();
		Thread.sleep(2000);
	}

	public void verifyStagingRowId(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hideColButton));
			Thread.sleep(3000);
			// Check if the last button is present
	        try {
	            WebElement lastButton = driver.findElement(By.xpath("(//a[contains(text(),'Last')])[1]"));
	            lastButton.click();
	        } catch (NoSuchElementException e) {
	            System.out.println("Last button not found, proceeding with further steps.");
	        }

			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='TABLE_OUTLINE']//tr"));
			WebElement lastRow = rows.get(rows.size() - 1);
			WebElement transactionId = lastRow.findElement(By.xpath(".//td[1]/a"));
			transactionId.click();
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(StagingId));
			Thread.sleep(2000);
			String stagingRowId = StagingId.getText();

			if (!stagingRowId.equals("0")) {
				System.out.println("Staging Row ID is updated in LSCOTransactionTable: " + stagingRowId);
				test.log(Status.PASS, "Staging Row ID is updated in LSCOTransactionTable: " + stagingRowId);
			} else {
				System.out.println("Staging Row ID is not updated in LSCOTransactionTable");
				test.log(Status.FAIL, "Staging Row ID is not updated in LSCOTransactionTable");
			}
		} catch (TimeoutException e) {

			
			String stagingRowId = StagingId.getText();

			if (!stagingRowId.equals("0")) {
				System.out.println("Staging Row ID is updated in LSCOTransactionTable: " + stagingRowId);
				test.log(Status.PASS, "Staging Row ID is updated in LSCOTransactionTable: " + stagingRowId);
			} else {
				System.out.println("Staging Row ID is not updated in LSCOTransactionTable");
				test.log(Status.FAIL, "Staging Row ID is not updated in LSCOTransactionTable");
			}

		}
	}

}
