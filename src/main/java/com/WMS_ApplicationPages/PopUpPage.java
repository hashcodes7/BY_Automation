package com.WMS_ApplicationPages;

import java.util.ArrayList;
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

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;

public class PopUpPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public PopUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement iframeColorLibraryframe;

	@FindBy(xpath = "//div[@class='p-multiselect-label ng-tns-c34-3 p-placeholder']")
	private WebElement ColorLookDropdown;

	@FindBy(xpath = "//a[normalize-space()='(choose)']")
	private WebElement choosenFirstColor;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement optionsContainerLocator;

	@FindBy(xpath = "//div[@id='lscoBrand']/div[@class='display-only-label']")
	//// div[@id='lscoBrand']/div[2]
	private WebElement productBrand;

	@FindBy(xpath = "//div[@id='paletteTab']")
	private WebElement paletteTabButton;

	@FindBy(xpath = "//div[@class='tableDebuggerCls']/following::a/following::a[1]")
	private WebElement firstColorSelect;

	@FindBy(xpath = "//input[@class='p-tree-filter p-inputtext p-component']")
	private WebElement searchInput;

	@FindBy(xpath = "//span[contains(text(),'Sundry Color')]")
	private WebElement sundryColorOption;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement searchButton;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	public void selectSundrycolour(String colorType, String sundryColorName) throws InterruptedException {

		String parent = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));
		String thirdwindowId = driver.getWindowHandle();
		System.out.println("third window Id " + thirdwindowId);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeColorLibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
		ColorLookDropdown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchInput));
		searchInput.sendKeys(colorType);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sundryColorOption));
		sundryColorOption.click();
		Thread.sleep(2000);
		clearCriteria.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(nameSearchField));
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		Thread.sleep(5000);
		nameSearchField.sendKeys(sundryColorName);
		System.out.println("Sundry Color Name: " + sundryColorName);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();

		driver.switchTo().window(tabs.get(1));
	}

	private boolean Capture;
	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='Name']/following::input[1]")
	private WebElement nameSearchField;

	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement iframeMateriallibraryframe;

	@FindBy(xpath = "//span[normalize-space()='Clear Criteria']")
	private WebElement clearCriteria;

	@FindBy(xpath = "//span[normalize-space()='Reset Defaults']")
	private WebElement resetDefaults;

	public void select_Color(String colorName, ExtentTest test) throws InterruptedException {

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);
		Thread.sleep(10000);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(nameSearchField));
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		Thread.sleep(5000);
		nameSearchField.sendKeys(colorName);
		System.out.println("Color Name: " + colorName);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		addSrceenShot("Clicked on search button again", test, Capture);
		Thread.sleep(7000);
		js.executeScript("arguments[0].click();", choosenFirstColor);
		driver.switchTo().window(tabs.get(0));

	}

}
