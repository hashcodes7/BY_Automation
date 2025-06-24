package com.WMS_ApplicationPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.plm.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;

public class LineSheetPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public LineSheetPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//iframe[@name='headerframe'")
	private WebElement iframeHeader;

	@FindBy(id = "siteNavLink")
	private WebElement siteLabel;

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement selectseason;

	@FindBy(xpath = "//select[@name='linePlanActions']")
	private WebElement ActionsDD;

	@FindBy(xpath = "//div[contains(text(),'Family (GS1)')]//following::div[1]/select[@name]")
	private WebElement family_GS1;

	@FindBy(xpath = "//div[contains(text(),'Class (GS1)')]//following::div[1]/select[@name]")
	private WebElement select_ClassGS1;

	@FindBy(xpath = "//div[contains(text(),'Brick')]//following::div[1]/select")
	private WebElement brick_GS1;

	@FindBy(xpath = "//div[contains(text(),'Product Confidentiality')]/following::span[@class='checkbox-custom rectangular'][1]")
	private WebElement productConfidentiality;

	@FindBy(xpath = "//div[contains(text(),'Supplier Driven Design')]/following::input[2]")
	private WebElement SupplierDrivenDesignCheckBox;

	@FindBy(xpath = "//div[contains(text(),'Development Type')]/following::span[@class='select2-selection__rendered'][1]")
	private WebElement Developmenttype;

	@FindBy(xpath = "//div[contains(text(),'Development Type')]//following::div[1]/select")
	private WebElement developmentType;

	@FindBy(xpath = "//a[@name='saveButton']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[text()='Product Short Description']//following::div[1]/textarea[1]")
	private WebElement productShortDetails;

	@FindBy(xpath = "//div[@name='center']/descendant::div[7]/child::name-cell-renderer")
	private WebElement FilteredProductName;

	@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Product Name']")
	private WebElement ProductNameHeader;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement filterInput;

	@FindBy(xpath = "//label[normalize-space()='View']/following::span[1]")
	// label[normalize-space()='View']/following-sibling::rfa-singleselect-dropdown
	private WebElement viewDropDown;

	@FindBy(xpath = "//button[@title='Options']//span[@class='p-button-label']")
	private WebElement settingsIcon;

	@FindBy(xpath = "//div[normalize-space()='LSCO\\Levis\\Global']//following::p-dropdown[1]")
	//div[text()=' Season Groups ']/following::div[@role='button'][2]
	private WebElement globalDropDown;

	@FindBy(xpath = "//span[@title='Global']")
	private WebElement globalElement;

	@FindBy(xpath = "//span[normalize-space()='Apply']")
	private WebElement applyButton;

	@FindBy(xpath = "//div[normalize-space()='LSCO\\Levis\\Local Hub']//following::p-dropdown[1]")
	//div[text()=' Season Groups ']/following::div[@role='button'][3]
	private WebElement localHubDropDown;

	@FindBy(xpath = "//span[@title='Global']")
	private WebElement localHubValue;

	@FindBy(xpath = "//div[normalize-space()='LSCO\\Levis\\Affiliate']//following::p-dropdown[1]")
	//div[text()=' Season Groups ']/following::div[@role='button'][1]
	private WebElement affiliateDropDown;

	@FindBy(xpath = "//button[@title='To cancel without saving, click Run']//span")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[normalize-space()='Run']")
	private WebElement RunButton;

	@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Adopted? GB']/preceding::span[1]")
	private WebElement filterButton;

	@FindBy(xpath = "//span[contains(@ref,'eText')][normalize-space()='Adopted? GB']/preceding::span[1]")
	private WebElement adoptedGBFilterButton;

	@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Adopted? LH']/preceding::span[1]")
	private WebElement adoptedLH_Filter;

	@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Adopted AFF']/preceding::span[1]")
	private WebElement adoptedAFF_Filter;

	@FindBy(xpath = "//label[normalize-space()='Filter']/following::p-dropdown")
	private WebElement filterDropDown;

	@FindBy(xpath = "//div[contains(text(),'Colorway Code')]/following-sibling::div")
	private WebElement colorwayCodeInput;

	@FindBy(xpath = "//div[@class='ag-set-filter-list']/descendant::div[text()='Yes']/following::input[1]")
	private WebElement yesOption;

	@FindBy(xpath = "//div[@class='ag-set-filter-list']/descendant::div[text()='Select All']/following::input[1]")
	private WebElement selectAllOption;

	@FindBy(xpath = "//div[@col-id='product.productName|~*~|1.Adoption']")
	private List<WebElement> productNames;

	@FindBy(xpath = "//div[@class='filter-container']//img[@id='createViewImg']")
	private WebElement createFilterButton;

	@FindBy(xpath = "//input[@id='displayName']")
	private WebElement filterNameField;

	@FindBy(xpath = "//a[normalize-space()='Create']")
	private WebElement saveFilterButton;

	@FindBy(xpath = "//td[normalize-space()='Filter Options']")
	private WebElement verificationElement;

	@FindBy(xpath = "//td[contains(text(),'Colorway Name')]/following::input[1]")
	private WebElement colorwayNameTextBox;

	@FindBy(xpath = "//a[normalize-space()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//a[normalize-space()='Update']")
	private WebElement updateButton;

	@FindBy(xpath = "//a[normalize-space()='Return']")
	public WebElement returnButton;

	@FindBy(xpath = "//select[@id='columnOrderSelect']")
	private WebElement updatedFiltersElement;

	@FindBy(xpath = "//div[@id='selectedDiv']")
	private WebElement currentFiltersDiv;

	@FindBy(xpath = "//a[normalize-space()='Copy Filter']")
	private WebElement copyFilterButton;

	@FindBy(xpath = "//div[@id='selectedDiv']")
	private WebElement copyFiltersDiv;

	@FindBy(xpath = "//select[@id='columnOrderSelect']")
	private WebElement copiedFilterVerificationElement;

	@FindBy(xpath = "//a[normalize-space()='Share Filter']")
	private WebElement shareFilterButton;

	@FindBy(xpath = "//td[normalize-space()='New Message']")
	private WebElement sharedFilterElement;

	@FindBy(xpath = "//a[normalize-space()='Delete']")
	private WebElement deleteFilterElement;

	@FindBy(xpath = "//li[@id='p-highlighted-option']/following::p-dropdownitem")
	private List<WebElement> currentFilters;

	@FindBy(xpath = "//div[@class='p-dropdown-filter-container ng-tns-c59-5']")
	private WebElement searchBox;

	@FindBy(xpath = "//img[@title='Edit Filter']")
	private WebElement editFilterButton;

	@FindBy(xpath = "//p-dropdownitem/ancestor::div[1]")
	private WebElement searchCriteriaContainer;

	@FindBy(xpath = "//input[@role='listbox']/following::input[@type='text'][1]")
	private WebElement ViewTypeSearchBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement searchOption;

	@FindBy(xpath = "//div[@class='ag-body-horizontal-scroll-viewport']")
	private WebElement eViewport;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoPDCValue|~*~|1.Adoption'])[2]")
	private WebElement ProductDevCenter_Value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoAdopted|~*~|1.Adoption'])[2]")
	private WebElement Adopted_GB_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoAdopted|~*~|1.Adoption'])[2]")
	private WebElement Adopted_LH_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAdopted|~*~|1.Adoption'])[2]")
	private WebElement Adopted_AFF_value;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	private WebElement Adopted_text;

	@FindBy(xpath = "//span[@title='Yes']")
	private WebElement option;

	@FindBy(xpath = "(//div[@col-id='product.productName|~*~|1.Adoption'])[2]/child::name-cell-renderer/a")
	private WebElement productElement;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement Save_button;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement ColorwayCode_Value;
	
	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement search_Box;
 
	@FindBy(xpath = "//li[@role='option']/child::span")
	private WebElement filteredOptn;
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoSampleSize|~*~|3.SizeSelection'])[2]")
	private WebElement getSampleSize;
 
	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoSelectedSizes|~*~|3.SizeSelection'])[2]/div[1]/span[1]")
	private WebElement getSelectedSizesGB;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	private boolean Capture;

	public void openSubMenu(String menu, String submenu) throws Exception {
		System.out.println("string menu" + menu + ":" + submenu);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" + menu + ":" + submenu);
		driver.findElement(By.xpath("//label[@title='" + menu + "']")).click();
		driver.findElement(By.xpath("//a[text()='" + submenu + "']")).click();
		/*
		 * clickElement("//label[@title='My Work']");
		 * clickElement("//label[@title='Season']");
		 */
		// click("//label[@title='" + menu + "']", menu);
	}

	@FindBy(xpath = "//line-sheet-grid[@class='box-stretched']")
	private WebElement linesheetGrid;

	public void filterProductByName(String productName, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
//		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(linesheetGrid));
		Thread.sleep(5000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(viewDropDown));
		viewDropDown.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(ViewTypeSearchBox));
		ViewTypeSearchBox.sendKeys("None Selected");
		Thread.sleep(5000);

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@aria-label='None Selected']"))).click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));
		filterInput.clear();
		filterInput.sendKeys(productName);
		Thread.sleep(3000);
		FilteredProductName.click();
		test.log(Status.INFO, "Filtered product by name: " + productName);
		addSrceenShot("Filtered product by name", test, Capture);

	}
	public boolean isPC5DetailsPageDisplayed(ExtentTest test) throws InterruptedException {

		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Details']")));

		boolean isDisplayed = driver.findElement(By.xpath("//span[normalize-space()='Product Details']")).isDisplayed();
		test.log(Status.PASS, "PC5 Details Page displayed: " + isDisplayed);
		addSrceenShot("PC5 Details Page displayed", test, Capture);

		return isDisplayed;
//		return driver.findElement(By.xpath("//span[normalize-space()='Product Details']")).isDisplayed();
	}

	public void filterProduct(String productName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));

		filterInput.clear();
		filterInput.sendKeys(productName);
		Thread.sleep(3000);
//		test.log(Status.INFO, "Filtered product by name: " + productName);
//		addSrceenShot("Filtered product by name", test, Capture);

	}

	public void chooseFilter(String filterName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		test.log(Status.INFO, "Clicked on Settings icon");
		addSrceenShot("Clicked on Settings icon", test, Capture);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterDropDown));
		System.out.println("filterDropDown visibled");
		test.log(Status.INFO, "Filter dropdown is visible");
		addSrceenShot("Filter dropdown is visible", test, Capture);

		Actions actions = new Actions(driver);
		actions.moveToElement(filterDropDown).click().perform();
		System.out.println("filterDropDown clicked");
		test.log(Status.INFO, "Clicked on Filter dropdown");
		addSrceenShot("Clicked on Filter dropdown", test, Capture);
		Thread.sleep(5000);

		actions.moveToElement(searchBox).click().sendKeys(filterName).perform();
		System.out.println("Data entered in searchBox");
		test.log(Status.INFO, "Entered data in searchBox: " + filterName);
		addSrceenShot("Entered data in searchBox", test, Capture);

		WebElement itemToSelect = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option']")));
		actions.moveToElement(itemToSelect).click().perform();
		System.out.println("Item selected");
		test.log(Status.INFO, "Item selected from dropdown");
		addSrceenShot("Item selected from dropdown", test, Capture);
	}

	public void clickOnEditIcon(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(editFilterButton));
		editFilterButton.click();
		test.log(Status.INFO, "Clicked on Edit Icon");
		addSrceenShot("Clicked on Edit Icon", test, Capture);

	}

	public void clickCreateFilterButton() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createFilterButton));
		createFilterButton.click();
	}

	public void enterFilterName(String filterName) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterNameField));
		filterNameField.sendKeys(filterName);

	}

	public void saveFilter() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveFilterButton));
		saveFilterButton.click();

	}

	public boolean isFilterCreated() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(verificationElement));

		return verificationElement.isDisplayed();
	}

	public void addToFilters(String attributeValue, String colorwayName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(verificationElement));
		WebElement staticDropDown = driver.findElement(By.xpath("//select[@name='attributeSelect']"));
		Select selectvalue = new Select(staticDropDown);
		selectvalue.selectByVisibleText(attributeValue);
		test.log(Status.INFO, "Selected Attribute: " + attributeValue);
		addSrceenShot("Selected Attribute", test, Capture);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwayNameTextBox));
		colorwayNameTextBox.sendKeys(colorwayName);
		test.log(Status.INFO, "Entered Colorway Name: " + colorwayName);
		addSrceenShot("Entered Colorway Name", test, Capture);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
		test.log(Status.INFO, "Clicked on Add button");
		addSrceenShot("Clicked on Add button", test, Capture);

	}

	public void clickUpdateButton(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(updateButton));
		clickElement(updateButton);
		test.log(Status.INFO, "Clicked on Update button");
		addSrceenShot("Clicked on Update button", test, Capture);

	}

	public void clickReturnButton(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(returnButton));
		clickElement(returnButton);
		test.log(Status.INFO, "Clicked on Return button");
		addSrceenShot("Clicked on Return button", test, Capture);

	}

	public void clickFiltersDropdown(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		test.log(Status.INFO, "Clicked on Settings icon");
		addSrceenShot("Clicked on Settings icon", test, Capture);

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filterDropDown));
		System.out.println("filterDropDown visible");
		test.log(Status.INFO, "Filter dropdown is visible");
		addSrceenShot("Filter dropdown is visible", test, Capture);

		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		actions.moveToElement(filterDropDown).click().perform();
		System.out.println("filterDropDown clicked");
		test.log(Status.INFO, "Clicked on Filter dropdown");
		addSrceenShot("Clicked on Filter dropdown", test, Capture);

	}

	public boolean isFilterPresentInSearchCriteria(String filterName, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

//		return searchCriteriaContainer.getText().contains(filterName);
		boolean isPresent = searchCriteriaContainer.getText().contains(filterName);
		if (isPresent) {
			test.log(Status.PASS, "Filter is present in search criteria: " + filterName);
			addSrceenShot("Filter is present in search criteria", test, Capture);
		} else {
			test.log(Status.FAIL, "Filter is not present in search criteria: " + filterName);
			addSrceenShot("Filter is not present in search criteria", test, Capture);
		}
		return isPresent;

	}

	public boolean isCopyFilterPresentInSearchCriteria(String copyFilterName, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		boolean isPresent = searchCriteriaContainer.getText().contains(copyFilterName);
		if (isPresent) {
			test.log(Status.PASS, "Copy Filter is present in search criteria: " + copyFilterName);
			addSrceenShot("Copy Filter is present in search criteria", test, Capture);
		} else {
			test.log(Status.FAIL, "Copy Filter is not present in search criteria: " + copyFilterName);
			addSrceenShot("Copy Filter is not present in search criteria", test, Capture);
		}
		return isPresent;
//		return searchCriteriaContainer.getText().contains(copyFilterName);
	}

	public boolean isFilterUpdated(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(updatedFiltersElement));

//		return updatedFiltersElement.isDisplayed();
		boolean isUpdated = updatedFiltersElement.isDisplayed();
		if (isUpdated) {
			test.log(Status.PASS, "Filter was updated successfully");
			addSrceenShot("Filter was updated successfully", test, Capture);
		} else {
			test.log(Status.FAIL, "Filter was not updated successfully");
			addSrceenShot("Filter was not updated successfully", test, Capture);
		}
		return isUpdated;

	}

	public String getCurrentFilterAttribues(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String attributes = currentFiltersDiv.getText();
		test.log(Status.INFO, "Retrieved current filter attributes: " + attributes);
		addSrceenShot("Retrieved current filter attributes", test, Capture);
		return attributes;
//		return currentFiltersDiv.getText();

	}

	public void clickCopyFilterButton(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(copyFilterButton));
		copyFilterButton.click();
	}

	public void enterNewFilterName(String copyFilterName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterNameField));
		filterNameField.sendKeys(copyFilterName);
		test.log(Status.INFO, "Entered new filter name: " + copyFilterName);
		addSrceenShot("Entered new filter name", test, Capture);

	}

	public void saveCopiedFilter(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveFilterButton));
		saveFilterButton.click();
		test.log(Status.INFO, "Clicked on Save Copied Filter button");
		addSrceenShot("Clicked on Save Copied Filter button", test, Capture);

	}

	public boolean isFilterCopied() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(copiedFilterVerificationElement));

		return updatedFiltersElement.isDisplayed();
	}

	public String getcopyFilterAttributes(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String attributes = copyFiltersDiv.getText();
		test.log(Status.INFO, "Retrieved copied filter attributes: " + attributes);
		addSrceenShot("Retrieved copied filter attributes", test, Capture);
		return attributes;
//		return copyFiltersDiv.getText();
	}

	public void clickShareFilter(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(shareFilterButton));
		clickElement(shareFilterButton);
		test.log(Status.INFO, "Clicked on Share Filter button");
		addSrceenShot("Clicked on Share Filter button", test, Capture);

	}

	public void verifyPageTitle(String expectedTitle, ExtentTest test) {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sharedFilterElement));
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Page title verified: " + actualTitle);
			test.log(Status.PASS, "Page title verified: " + actualTitle);
			addSrceenShot("Page title verified", test, Capture);
		} else {
			System.out.println("Page title mismatch. Expected: " + expectedTitle + ", but got: " + actualTitle);
			test.log(Status.FAIL, "Page title mismatch. Expected: " + expectedTitle + ", but got: " + actualTitle);
			addSrceenShot("Page title mismatch", test, Capture);
		}
	}

	public boolean isFilterShared(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sharedFilterElement));
		boolean isShared = sharedFilterElement.isDisplayed();
		if (isShared) {
			test.log(Status.PASS, "Filter was shared successfully");
			addSrceenShot("Filter was shared successfully", test, Capture);
		} else {
			test.log(Status.FAIL, "Filter was not shared successfully");
			addSrceenShot("Filter was not shared successfully", test, Capture);
		}
		return isShared;
//		return sharedFilterElement.isDisplayed();
	}

	public void clickDeleteFilter(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(deleteFilterElement));
		clickElement(deleteFilterElement);
		test.log(Status.INFO, "Clicked on Delete Filter button");
		addSrceenShot("Clicked on Delete Filter button", test, Capture);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		test.log(Status.INFO, "Accepted alert for Delete Filter");
		addSrceenShot("Accepted alert for Delete Filter", test, Capture);
	}

	public boolean isFilterPresent(String filterName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		test.log(Status.INFO, "Clicked on Settings icon");
		addSrceenShot("Clicked on Settings icon", test, Capture);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filterDropDown));
		System.out.println("filterDropDown visibled");
		test.log(Status.INFO, "Filter dropdown is visible");
		addSrceenShot("Filter dropdown is visible", test, Capture);

		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		actions.moveToElement(filterDropDown).click().perform();
		System.out.println("filterDropDown clicked");
		test.log(Status.INFO, "Clicked on Filter dropdown");
		addSrceenShot("Clicked on Filter dropdown", test, Capture);

		actions.moveToElement(searchBox).click().sendKeys(filterName).perform();
		System.out.println("Data entered in searchBox");
		test.log(Status.INFO, "Entered data in searchBox: " + filterName);
		addSrceenShot("Entered data in searchBox", test, Capture);

		for (WebElement filter : currentFilters) {
			if (filter.getText().equals(filterName)) {
				test.log(Status.FAIL, "Filter is still present: " + filterName);
				addSrceenShot("Filter is still present", test, Capture);
				return true;
			}
		}
		test.log(Status.PASS, "Filter is not present: " + filterName);
		addSrceenShot("Filter is not present", test, Capture);
		return false;
	}

	public void changeseason() throws Exception {
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame(iframeLeft);
		// PlmUtills.switchheaderFrame(driver);
		String user = this.getElement("//font[@id='userNameLabel']").getText();
		System.out.println("user name :--->" + user);
		this.driver.switchTo().frame(iframeLeft);
		WebElement myseasondd = driver.findElement(By.xpath("//select[@name='seasonSelectList']"));
		if (user.contains("Licensing")) {
			this.selectOPtionByVisibleText(myseasondd, "Denizen S1 2022 Female Bottoms");
		} else {
			this.selectOPtionByVisibleText(myseasondd, "Denizen S1 2022 Female Bottoms", "Selecting Season");
		}
		this.click("//label[@title='Development']/following::a[2]", "click on linesheet");
	}

	public void selectLineSheet(String submenu) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" + ":" + submenu);
		driver.findElement(By.xpath("//a[normalize-space()='" +submenu+ "']")).click();
		/*
		 * clickElement("//label[@title='My Work']");
		 * clickElement("//label[@title='Season']");
		 */
		// click("//label[@title='" + menu + "']", menu);
	}
	
	public void clickOncolorwayNameLinkInLSC_View() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorWayName_textINLSC));
		colorWayName_textINLSC.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "(//div[@col-id='colorway.skuName|~*~|SourceConfig-LinkSourcetoColorway'])[2]//a")
	private WebElement colorWayName_textINLSC;
	

	public void selectViewDropdown(String viewType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		System.out.println("string menu" + ":" + viewType);
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(linesheetGrid));
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(viewDropDown));
		viewDropDown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(ViewTypeSearchBox));
		ViewTypeSearchBox.sendKeys(viewType);
		Thread.sleep(4000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchOption));
		searchOption.click();

	}
	@FindBy(xpath = "(//li[@role='option'])[2]")
	private WebElement SeasonGroups_Global_value;

	public void selectSeasonGroupAsGlobal(String globalVaue, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		test.log(Status.INFO, "Clicked On settings Icon ");
		addSrceenShot("Clicked On settings Icon", test, Capture);

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(globalDropDown));

		Actions actions = new Actions(driver);
		actions.moveToElement(globalDropDown).click().perform();
		Thread.sleep(2000);
		WebElement option = driver.findElement(By.xpath("//span[@title='" + globalVaue.trim() + "']/parent::li"));
//		actions.moveToElement(SeasonGroups_Global_value).click().perform();
		actions.moveToElement(option).click().perform();
		test.log(Status.INFO, "Season Group As Global chosen: " + globalVaue);
		addSrceenShot("Season Group As Global chosen", test, Capture);

		Thread.sleep(4000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();
		test.log(Status.INFO, "Clicked On Apply Button");
		addSrceenShot("Clicked On Apply Button", test, Capture);

		Thread.sleep(4000);

	}

	public void changeTheAdoptedGBToYes(String localHubValue, String affiliateValue, ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 15; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Product Dev. Center")) {
				Assert.assertTrue(ProductDevCenter_Value.getText().equalsIgnoreCase("Global"));
			}
			if (ColumnHeader.equals("Adopted? GB")) {
				String adoptedGBText = Adopted_GB_value.getText();
				Thread.sleep(2000);
				System.out.println("Current Adopted? GB value: " + adoptedGBText);
				if (!adoptedGBText.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Adopted? GB value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(Adopted_GB_value).perform();
					Adopted_text.click();
					Adopted_text.clear();
					Adopted_text.sendKeys("Yes");
					option.click();
					Save_button.click();

					System.out.println("Adopted? GB value changed to Yes");
					addSrceenShot("Adopted? GB value changed to Yes", test, Capture);

				} else {
					System.out.println("Adopted? GB value is already Yes, no change needed");
					addSrceenShot("Adopted? GB value is already Yes, no change needed", test, Capture);

				}
			}

		}
		System.out.println("Finished changeTheAdoptedGBToYes method");
	}

	public void changeTheAdoptedLHToYes(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Adopted_LH_value));
		String adoptedLHText = Adopted_LH_value.getText();
		System.out.println("Current Adopted? LH value: " + adoptedLHText);
		if (!adoptedLHText.equalsIgnoreCase("Yes")) {
			System.out.println("Changing Adopted? LH value to Yes");
			Actions actions = new Actions(driver);
			actions.doubleClick(Adopted_LH_value).perform();
			Thread.sleep(2000);
			Adopted_text.click();
			Adopted_text.clear();
			Adopted_text.sendKeys("Yes");
			Thread.sleep(2000);
			option.click();
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(5000);
			Save_button.click();
			test.log(Status.INFO, "Clicked On Save Button");
			Thread.sleep(5000);
			System.out.println("Adopted? LH value changed to Yes");
			addSrceenShot("Adopted? LH value changed to Yes", test, Capture);

		} else {
			System.out.println("Adopted? LH value is already Yes, no change needed");
			addSrceenShot("Adopted? LH value is already Yes, no change needed", test, Capture);

		}
	}

	public void changeTheAdoptedAFFToYes(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Adopted_AFF_value));
		String adoptedAFFText = Adopted_AFF_value.getText();
		System.out.println("Current Adopted? AFF value: " + adoptedAFFText);
		if (!adoptedAFFText.equalsIgnoreCase("Yes")) {
			System.out.println("Changing Adopted? AFF value to Yes");
			Actions actions = new Actions(driver);
			actions.doubleClick(Adopted_AFF_value).perform();
			Thread.sleep(2000);
			Adopted_text.click();
			Adopted_text.clear();
			Adopted_text.sendKeys("Yes");
			Thread.sleep(2000);
			option.click();
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(5000);
			Save_button.click();
			test.log(Status.INFO, "Clicked On Save Button");
			Thread.sleep(5000);
			System.out.println("Adopted? AFF value changed to Yes");
			addSrceenShot("Adopted? AFF value changed to Yes", test, Capture);

		} else {
			System.out.println("Adopted? AFF value is already Yes, no change needed");
			addSrceenShot("Adopted? AFF value is already Yes, no change needed", test, Capture);

		}
	}

	public String getDisplayedProduct(ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productElement));

		if (productElement.isDisplayed()) {
			String displayedProduct = productElement.getText();
			System.out.println("Displayed product: " + displayedProduct);
			test.log(Status.PASS, "Displayed product: " + displayedProduct);
			addSrceenShot("Displayed product", test, Capture);
			return displayedProduct;
		} else {
			test.log(Status.FAIL, "Product element not displayed.");
			addSrceenShot("Product element not displayed", test, Capture);
			return null;
		}
	}

	public void selectlocalHubdropdownValue(String localHubValue, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		test.log(Status.INFO, "Clicked On settings Icon ");
		addSrceenShot("Clicked On settings Icon", test, Capture);

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(localHubDropDown));

		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		actions.moveToElement(localHubDropDown).click().perform();
		WebElement option = driver.findElement(By.xpath("//span[@title='" + localHubValue.trim() + "']"));
		actions.moveToElement(option).click().perform();
		test.log(Status.INFO, "Season Group As LocalHub chosen: " + localHubValue);
		addSrceenShot("Season Group As LocalHub chosen", test, Capture);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();
		test.log(Status.INFO, "Clicked On Apply Button");
		addSrceenShot("Clicked On Apply Button", test, Capture);

		Thread.sleep(4000);

	}

	public void clickOnSave() throws Exception {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();

	}

	public void clickOnRun() throws Exception {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(RunButton));
		RunButton.click();

	}

	public void selectAffiliateAaccordingToTheLocalHub_FromAffiliateDropDown(String affiliateValue) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(affiliateDropDown));

		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		actions.moveToElement(affiliateDropDown).click().perform();
		WebElement option = driver.findElement(By.xpath("//span[@title='" + affiliateValue.trim() + "']"));
		actions.moveToElement(option).click().perform();

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();

		Thread.sleep(4000);

	}

	public List<String> getProductNames(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");

		List<String> productNamesList = productNames.stream().map(WebElement::getText).collect(Collectors.toList());
		test.log(Status.PASS, "Product names retrieved: " + productNamesList);
		addSrceenShot("Product names retrieved", test, Capture);

		return productNamesList;
//		return productNames.stream().map(WebElement::getText).collect(Collectors.toList());

	}

	public void filterProductsByColorway(String filterType, String colorwayCode, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filterDropDown));
		System.out.println("filterDropDown visibled");

		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		actions.moveToElement(filterDropDown).click().perform();
		System.out.println("filterDropDown clicked");

		WebElement option = driver.findElement(By.xpath("//span[@title='" + filterType.trim() + "']"));
		actions.moveToElement(option).click().perform();
		System.out.println("filtered type choosen");
		test.log(Status.INFO, "Filtered type chosen: " + filterType);
		addSrceenShot("Filtered type chosen", test, Capture);
		Thread.sleep(4000);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwayCodeInput));
		actions.moveToElement(colorwayCodeInput).click().sendKeys(colorwayCode).perform();
		System.out.println("Colorway code is entered");
		test.log(Status.INFO, "Colorway code entered: " + colorwayCode);
		addSrceenShot("Colorway code entered", test, Capture);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();

		Thread.sleep(4000);

	}

	public void displayTheFilteredProduct(String colorwayCode, ExtentTest test) throws Exception {
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(iframeContentframe);

	    Thread.sleep(2000);

	    ArrayList<String> header = new ArrayList<String>();
	    header = getAdoptionColumnHeaderValue();
	    for (int i = 0; i < 15; i++) {
	        String ColumnHeader = header.get(i);
	        scroll(i + 3);
	        System.out.println(ColumnHeader);
	        if (ColumnHeader.equals("Colorway Code")) {
	            Assert.assertTrue(ColorwayCode_Value.getText().equalsIgnoreCase(colorwayCode));
	            System.out.println("Product is displayed in the Line Sheet");
	            test.log(Status.PASS, "Product is displayed in the Line Sheet");
	            addSrceenShot("Product is displayed in the Line Sheet", test, Capture);
	            break; // Exit the loop once the product is found
	        }
	    }
	}

//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		int scrollAmount = 0;
//		boolean columnHeaderFound = false;
//
//		while (!columnHeaderFound) {
//			try {
//				js.executeScript(
//						"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft += " + scrollAmount);
//				WebElement columnHeader = driver
//						.findElement(By.xpath("//div[normalize-space()='" + colorwayCode.trim() + "']"));
//				boolean isProductDisplayed = columnHeader.getText().contains(colorwayCode);
//				if (isProductDisplayed) {
//					System.out.println("Product is displayed in the Line Sheet");
//					test.log(Status.PASS, "Product is displayed in the Line Sheet");
//					addSrceenShot("Product is displayed in the Line Sheet", test, Capture);
//				}
//				columnHeaderFound = true;
//			} catch (Exception e) {
//				scrollAmount += 800;
//				if (scrollAmount > 3000) {
//					test.log(Status.FAIL, "Product is not displayed in the Line Sheet");
//					addSrceenShot("Product is not displayed in the Line Sheet", test, Capture);
//					throw new NoSuchElementException("Product is not displayed in the Line Sheet");
//				}
//			}
//		}
//
//	}

	public void createProduct() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			System.out.println("string menu" + ":");
			driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Create...']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Create New: Product']")).click();
			System.out.println("string menu" + ":");
			System.out.println("string menu" + ":");
			System.out.println("string menu" + ":");
		} catch (Exception e) {
			System.out.println("string menu" + ":");
		}
	}

	public void editProduct() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Edit Product']")).click();
			System.out.println("string menu" + ":");
		} catch (Exception e) {
			System.out.println("string menu" + ":");
		}
	}

	public void selectOPtionByVisibleText(WebElement e, String text) throws InterruptedException {
		Thread.sleep(5000);
		e.click();
		Select sl = new Select(e);
		sl.selectByVisibleText(text);

	}

	public void selectCreateProductInActionsDropdown() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		this.selectOPtionByVisibleText(ActionsDD, "Create New: Product");
	}

	private WebElement getElement(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectOPtionByVisibleText(WebElement e, String text, String elementName) throws Exception {
		Thread.sleep(5000);

		try {

			WebDriverWait waitSelenium = new WebDriverWait(driver, 80, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
			e.click();
			// e.click();
			Select sl = new Select(e);
			sl.selectByVisibleText(text);
			System.out.println("test:" + e + text);
			System.out.println("test:" + e + text);

		} catch (Exception exc) {

			throw new Exception(elementName + " not found because of ::->" + exc.getStackTrace());

		}
	}

	public WebElement findElementByXPath1(String using) {
		return findElement("xpath", using);
	}

	public static void switchheaderFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame((WebElement) driver.findElement(By.xpath("//iframe[@name='headerframe']")));
	}

	/**
	 * Function to navigate to SubMenus
	 * 
	 * @param mainMenu
	 * @param submenu
	 * @throws Exception
	 */
	public void openSubMenu(String mainMenu, String submenu, boolean... season) throws Exception {
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame(iframeLeft);
		this.click("//label[@title='" + mainMenu + "']", mainMenu);
		String subMenuItems = "//label[@title='" + mainMenu + "']/../../div[@class='card-content']";
		this.waitForVisibilityOfElement(subMenuItems);
		if (season.length > 0) {
			this.scrollTo(subMenuItems + "//a[contains(@href,'" + submenu + "')]", (submenu));
			this.click(subMenuItems + "//a[contains(@href,'" + submenu + "')]", (submenu));
		} else {
			this.scrollTo(subMenuItems + "//a[normalize-space()='" + submenu + "']", (submenu));
			this.click(subMenuItems + "//a[normalize-space()='" + submenu + "']", submenu);
		}
	}

	public void scrollTo(String xpath, String element) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath(xpath)));
			String logMessage = "Scrolled to element " + element;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception exc) {
			/*
			 * ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element"
			 * + element, ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			 */throw new Exception(exc + "Exception on scroll to element" + element);
		}

	}

	public WebElement findElementByXPath(String using) {
		return findElement("xpath", using);
	}

	private WebElement findElement(String string, String using) {
		// TODO Auto-generated method stub
		return null;
	}

	public void waitForVisibilityOfElement(String xpath) throws Exception {

		try {

			WebDriverWait waitSelenium = new WebDriverWait(driver, 60, 500);

			waitSelenium.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath))));

		} catch (Exception exc) {
			/*
			 * assertFalse(false, " element not yet loaded in the webpage " + exc);
			 * Assert.assertEquals(false, true);
			 */
		}

	}

	public void click(String xpath, String elementName) throws Exception {
		try {
			WebDriverWait waitSelenium = new WebDriverWait(driver, 60, 500);

			waitSelenium.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

			// driver.findElements(xpath).click();
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully"
			/* ExtentUtility.getTest().addScreenCapture(takeScreenShot()) */);

		} catch (ElementClickInterceptedException e) {

			// assertFalse(false, elementName + " -- is not clickable ");

		} catch (Exception exc) {

			/*
			 * assertFalse(false, elementName +
			 * "--->> element is not clickable at this moment due to ::-" +
			 * exc.getStackTrace()[0].getMethodName());
			 */
		}
	}

	/**
	 * Function to open the menu items
	 * 
	 * @param menu
	 * @throws Exception
	 */
	public void openMenuItems(String menu) throws Exception {
		driver.switchTo().frame(iframeLeft);
		clickElement("//label[@title='" + menu + "']");
		// click("//label[@title='" + menu + "']", menu);
	}

	private void clickElement(String string) {
		// TODO Auto-generated method stub

	}

	public String createProductforlinesheet() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Select family = new Select(family_GS1);
		family.selectByIndex(1);
		Select gs1 = new Select(select_ClassGS1);
		gs1.selectByIndex(2);
		Select brick = new Select(brick_GS1);
		brick.selectByIndex(1);
		Select division_Business = new Select(
				driver.findElement(By.xpath("//div[contains(text(),'Division (Business)')]//following::select[1]")));
		division_Business.selectByIndex(1);
		Select department_Business = new Select(
				driver.findElement(By.xpath("//div[contains(text(),'Department (Business)')]//following::select[1]")));
		department_Business.selectByIndex(1);
		Select class_Business = new Select(
				driver.findElement(By.xpath("//div[contains(text(),'Department (Business)')]//following::select[2]")));
		class_Business.selectByIndex(1);
		Select sub_Class_Business = new Select(
				driver.findElement(By.xpath("//div[contains(text(),'Sub-Class (Business)')]//following::select[1]")));
		sub_Class_Business.selectByIndex(1);
		waitForClickable(productConfidentiality);
		productConfidentiality.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productConfidentiality);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", developmentType);
		Select development_Type = new Select(developmentType);
		development_Type.selectByIndex(1);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
		this.click("//*[contains(text(),'Program:')]", "Program");
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		driver.manage().window().fullscreen();
		this.click("//*[text()='Search']", currentTest); // TODO
		this.click("//table[contains(@id,'TBLT')]//tr[2]//td[1]/a", currentTest); // TODO
		driver.switchTo().window(parentwindow);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		this.moveToElement(productShortDetails, "Short description");
		try {
			productShortDetails.clear();
			productShortDetails.sendKeys("Auto");
		} catch (Exception e) {
			String message = "Unable to add product short description";
			/*
			 * ExtentUtility.getTest().log(LogStatus.FAIL, message +
			 * ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			 */throw new Exception(message);
		}
		this.click(saveButton, "Save button");
		/*
		 * ExtentUtility.getTest().log(LogStatus.INFO,
		 * ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		 */return new String(currentTest);
	}

	public void waitForClickable(WebElement e) throws Exception {
		boolean result = e.isEnabled() && e.isDisplayed();
		try {
			if (result == true) {
				WebDriverWait waitSelenium = new WebDriverWait(driver, 1000, 500);
				waitSelenium.until(ExpectedConditions.elementToBeClickable(e));

			}

		} catch (Exception exc) {
			exc.printStackTrace();
			/*
			 * ExtentUtility.getTest().log(LogStatus.FAIL,
			 * "Exception on waiting for webelement",
			 * ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			 */throw new Exception(exc + "Exception on waiting for webelement");
		}
	}

	public LineSheetPage clickOnToProductType(String materialType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		this.click("//a[text()='" + materialType + "']", "Product Type :-" + materialType);
		return new LineSheetPage(driver);
	}

	public void moveToElement(WebElement element, String elementName) throws Exception {
		Actions actions;
		try {

			actions = new Actions(driver);
			actions.moveToElement(element).build().perform();

			String logMessage = "Moved to element " + elementName;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);

		} catch (Exception exc) {
			/*
			 * ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Move to element" +
			 * elementName, ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			 */throw new Exception(exc + "Exception on Move to elementelementName" + elementName);
		}
	}
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoSizeGridCode|~*~|3.SizeSelection'])[2]")
	private WebElement sizeGridCode_value;
	
	public void selectAndVerifySizeGridCode(String sizeGridCode, ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
 
		Thread.sleep(2000);
 
		ArrayList<String> header = new ArrayList<String>();
		header = getSizeSelectionColumnHeaderValue();
		for (int i = 0; i < 16; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Size Grid Code")) {
				if(sizeGridCode_value.getText().isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(sizeGridCode_value).perform();
					Thread.sleep(4000);
					search_Box.click();
					Thread.sleep(2000);
					search_Box.clear();
					search_Box.sendKeys(sizeGridCode);
					Thread.sleep(7000);
					new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filteredOptn));
					filteredOptn.click();
					search_Box.sendKeys(Keys.RETURN);
					Thread.sleep(10000);
					Save_button.click();
					Thread.sleep(20000);
	 
					System.out.println("Size Grid Code Value Was choosen");
					addSrceenShot("Size Grid Code Value Was choosen", test, Capture);
					test.log(Status.PASS, "Size Grid Code Value Was choosen : " + sizeGridCode);
				}
				
 
			}
			if (ColumnHeader.equals("Sample Size")) {
				// Verify Sample Size is populated
				String actualSampleSize = getSampleSize.getText();
				if (actualSampleSize != null && !actualSampleSize.isEmpty()) {
					System.out.println("Sample Size is auto-populated: " + actualSampleSize);
					test.log(Status.PASS, "Sample Size is auto-populated: " + actualSampleSize);
				} else {
					System.out.println("Sample Size is not auto-populated");
					test.log(Status.FAIL, "Sample Size is not auto-populated");
				}
				addSrceenShot("Sample Size Verification", test, Capture);
 
			}
			if (ColumnHeader.equals("Selected Sizes GB")) {
				// Verify Selected Sizes - GB are populated
				String actualSelectedSizesGB = getSelectedSizesGB.getText();
				if (actualSelectedSizesGB != null && !actualSelectedSizesGB.isEmpty()) {
					System.out.println("Selected Sizes - GB are auto-populated: " + actualSelectedSizesGB);
					test.log(Status.PASS, "Selected Sizes - GB are auto-populated: " + actualSelectedSizesGB);
				} else {
					System.out.println("Selected Sizes - GB are not auto-populated");
					test.log(Status.FAIL, "Selected Sizes - GB are not auto-populated");
				}
 
			}
		}
 
	}
	
		@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoSizeCascadeLockAff|~*~|3.SizeSelection'])[2]")
		private WebElement selectedSizesAFFLocked;
	 
		@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoSizeCascadeLockAff|~*~|3.SizeSelection'])[2]/div[1]/span[1]")
		private WebElement selectedSizesAFFLocked_value;
	 
		@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoSizeCascadeLock|~*~|3.SizeSelection'])[2]")
		private WebElement selectedSizesLHLocked;
	 
		@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoSizeCascadeLock|~*~|3.SizeSelection'])[2]/div[1]/span[1]")
		private WebElement selectedSizesLHLocked_value;
		
		@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoSelectedSizes|~*~|3.SizeSelection'])[2]")
		private WebElement selectedSizesLH;
	 
		@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoSelectedSizes|~*~|3.SizeSelection'])[2]/div[1]/span[1]")
		private WebElement selectedSizesLH_value;
		
		@FindBy(xpath = "//input[@id='multiEntryInput']")
		private WebElement filtered_LH_Optn;
		
	public void editSelectedSizesLH(String sizes, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
 
		Thread.sleep(2000);
 
		ArrayList<String> header = new ArrayList<String>();
		header = getSizeSelection_LH_ColumnHeaderValue();
		for (int i = 0; i < 19; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Selected Sizes LH")) {
				String currentStatus = selectedSizesLH_value.getText();
				System.out.println("Current 'Selected sizes-LH' Sizes: " + currentStatus);
				test.log(Status.INFO, "Current 'Selected sizes-LH' Sizes: " + currentStatus);
				if (currentStatus.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(selectedSizesLH).perform();
					Thread.sleep(4000);
//					filtered_LH_Optn.clear();
//					for (int j = 0; j < 50; j++) {
//						filtered_LH_Optn.sendKeys(Keys.BACK_SPACE);
//					}
					Thread.sleep(2000);
					// Split the sizes by comma and send each size followed by a comma
					String[] sizesArray = sizes.split(", ");
					for (String size : sizesArray) {
						filtered_LH_Optn.sendKeys(size);
						Thread.sleep(1000);
						filtered_LH_Optn.sendKeys(Keys.chord(Keys.SHIFT, ","));
						Thread.sleep(1000);
					}
	 
					// Press Enter after all sizes are entered
					filtered_LH_Optn.sendKeys(Keys.RETURN);
					Thread.sleep(5000);
					Save_button.click();
					Thread.sleep(15000);
	 
					test.log(Status.INFO, "Updated Selected Sizes LH: " + currentStatus);
					addSrceenShot("Updated Selected Sizes LH", test, Capture);
				}else {
					System.out.println(" 'Selected sizes-LH' is aready populating and the Sizes are : " + currentStatus);
					test.log(Status.INFO, " 'Selected sizes-LH'  is aready populating and the Sizes are :  " + currentStatus);
					addSrceenShot(" 'Selected sizes-LH'  is aready populating and the Sizes are :  "  + currentStatus, test, Capture);
				}
			
 
			}
 
		}
	}
 
	public void editSelectedSizesLHLocked(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(selectedSizesLHLocked));
		String currentStatus = selectedSizesLHLocked_value.getText();
		System.out.println("Current 'Selected sizes LH Locked?' status: " + currentStatus);
		test.log(Status.INFO, "Current 'Selected sizes LH Locked?' status: " + currentStatus);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.doubleClick(selectedSizesLHLocked).perform();
 
		WebElement option;
		String newStatus;
		if (currentStatus.equalsIgnoreCase("Yes")) {
			option = driver.findElement(By.xpath("//li[@aria-label='No']"));
			newStatus = "No";
		} else {
			option = driver.findElement(By.xpath("//li[@aria-label='Yes']"));
			newStatus = "Yes";
		}
 
		option.click();
		selectedSizesLH_value.click();
		Thread.sleep(3000);
		Save_button.click();
		test.log(Status.INFO, "Toggled 'Selected sizes LH Locked?' status to: " + newStatus);
		addSrceenShot("Toggled 'Selected sizes LH Locked?' status", test, Capture);
		System.out.println("Toggled 'Selected sizes LH Locked?' from " + currentStatus + " to " + newStatus);
		Thread.sleep(4000);
	}
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoSelectedSizes|~*~|3.SizeSelection'])[2]")
	private WebElement selectedSizesAFF;
 
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoSelectedSizes|~*~|3.SizeSelection'])[2]/div[1]/span[1]")
	private WebElement selectedSizesAFF_value;

	
	public void editSelectedSizesAFF(String sizes, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
 
		Thread.sleep(2000);
 
		ArrayList<String> header = new ArrayList<String>();
		header = getSizeSelection_AFF_ColumnHeaderValue();
		for (int i = 0; i < 22; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Selected Sizes AFF")) {
				String currentStatus = selectedSizesAFF_value.getText();
				System.out.println("Current 'Selected sizes-AFF' Sizes: " + currentStatus);
				test.log(Status.INFO, "Current 'Selected sizes-AFF' Sizes: " + currentStatus);
				if(currentStatus.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(selectedSizesAFF).perform();
					Thread.sleep(4000);
//					filtered_LH_Optn.clear();
//					for (int j = 0; j < 50; j++) {
//						filtered_LH_Optn.sendKeys(Keys.BACK_SPACE);
//					}
					Thread.sleep(2000);
					// Split the sizes by comma and send each size followed by a comma
					String[] sizesArray = sizes.split(", ");
					for (String size : sizesArray) {
						filtered_LH_Optn.sendKeys(size);
						Thread.sleep(1000);
						filtered_LH_Optn.sendKeys(Keys.chord(Keys.SHIFT, ","));
						Thread.sleep(1000);
					}
	 
					// Press Enter after all sizes are entered
					filtered_LH_Optn.sendKeys(Keys.RETURN);
					Thread.sleep(5000);
					Save_button.click();
					Thread.sleep(30000);
	 
					test.log(Status.INFO, "Updated Selected Sizes AFF: " + currentStatus);
					addSrceenShot("Updated Selected Sizes AFF", test, Capture);
				}else {
					System.out.println(" 'Selected sizes-AFF' is aready populating and the Sizes are : " + currentStatus);
					test.log(Status.INFO, " 'Selected sizes-AFF'  is aready populating and the Sizes are :  " + currentStatus);
					addSrceenShot(" 'Selected sizes-AFF'  is aready populating and the Sizes are :  "  + currentStatus, test, Capture);
				}
				
 
			}
 
		}
	}
 
	public void editSelectedSizesAFFLocked(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
 
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(selectedSizesAFFLocked));
		String currentStatus = selectedSizesAFFLocked_value.getText();
		System.out.println("Current 'Selected sizes AFF Locked?' status: " + currentStatus);
		test.log(Status.INFO, "Current 'Selected sizes AFF Locked?' status: " + currentStatus);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.doubleClick(selectedSizesAFFLocked).perform();
 
		WebElement option;
		String newStatus;
		if (currentStatus.equalsIgnoreCase("Yes")) {
			option = driver.findElement(By.xpath("//li[@aria-label='No']"));
			newStatus = "No";
		} else {
			option = driver.findElement(By.xpath("//li[@aria-label='Yes']"));
			newStatus = "Yes";
		}
 
		option.click();
		selectedSizesAFF_value.click();
		Thread.sleep(3000);
		Save_button.click();
		test.log(Status.INFO, "Toggled 'Selected sizes AFF Locked?' status to: " + newStatus);
		addSrceenShot("Toggled 'Selected sizes AFF Locked?' status", test, Capture);
		System.out.println("Toggled 'Selected sizes AFF Locked?' from " + currentStatus + " to " + newStatus);
		Thread.sleep(6000);
	}
	
	public void changeTheAdoptedGBToYes(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 15; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Adopted? GB")) {
				String adoptedGBText = Adopted_GB_value.getText();
				Thread.sleep(2000);
				System.out.println("Current Adopted? GB value: " + adoptedGBText);
				if (!adoptedGBText.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Adopted? GB value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(Adopted_GB_value).perform();
					Thread.sleep(2000);
					Adopted_text.click();
					Adopted_text.clear();
					Adopted_text.sendKeys("Yes");
					Thread.sleep(2000);
					option.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					Save_button.click();
					test.log(Status.INFO, "Clicked On Save Button");
					Thread.sleep(5000);
					new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(Adopted_GB_value, "Yes"));
	                // Validate the value has been changed
	                adoptedGBText = Adopted_GB_value.getText();
	                if (adoptedGBText.equalsIgnoreCase("Yes")) {
	                    test.log(Status.PASS, "Adopted GB value is changed to YES ");
	                    System.out.println("Adopted GB value is changed to YES");
	                } else {
	                    test.log(Status.FAIL, "Failed to change Adopted GB value to YES ");
	                    System.out.println("Failed to change Adopted GB value to YES");
	                }


				} else {
					System.out.println("Adopted? GB value is already Yes, no change needed");
					addSrceenShot("Adopted? GB value is already Yes, no change needed", test, Capture);

				}
			}

		}
	}
	

	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoCrrtPlndLfcycl|~*~|5.Activate-LSA'])[2]")
	private WebElement current_Planned_LifecycleAFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoCrrtPlndLfcycl|~*~|5.Activate-LSA'])[2]")
	private WebElement first_On_Floor_Month_AFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvySelectedINST|~*~|5.Activate-LSA'])[2]")
	private WebElement dlvy_Selected_AFF;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvySelectedINST|~*~|5.Activate-LSA'])[2]/span")
	private WebElement dlvy_Selected_AFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvyStartDateINST|~*~|5.Activate-LSA'])[2]")
	private WebElement dlvyStartDateAFF;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvyEndDateINST|~*~|5.Activate-LSA'])[2]")
	private WebElement dlvyEndDateAFF;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTicketCode|~*~|5.Activate-LSA'])[2]/div/span")
	private WebElement ticket_Code_AFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTicketCode|~*~|5.Activate-LSA'])[2]")
	private WebElement ticket_Code_AFF;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoLSUSStockingCustServCntr|~*~|5.Activate-LSA'])[2]")
	private WebElement lsus_Stocking_CSC_AFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoPriceRetail|~*~|5.Activate-LSA'])[2]")
	private WebElement target_AFF_MSRP_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoPriceWhsl|~*~|5.Activate-LSA'])[2]")
	private WebElement price_Whsl_AFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoProdPricePosition|~*~|5.Activate-LSA'])[2]")
	private WebElement product_Price_Position_AFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoBucketCode|~*~|5.Activate-LSA'])[2]")
	private WebElement bucket_Code_AFF_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAdopted|~*~|5.Activate-LSA'])[2]")
	private WebElement Adopted_AFF_LSA_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoActivateValidation|~*~|5.Activate-LSA'])[2]")
	private WebElement active_run_Validation_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTriggerSAPforBulk|~*~|5.Activate-LSA'])[2]")
	private WebElement active_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoActivateStatus|~*~|5.Activate-LSA'])[2]")
	private WebElement activateStatus_value;
	
	
	
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement check_Box;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement textBox;

	@FindBy(xpath = "//input[@id='inputText']")
	private WebElement text_Input;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement filteredCheckkBox;

	@FindBy(xpath = "//div[@role='button']/following::input[@type='text'][5]")
	private WebElement search_Box1;
	

	
	public void updateAttributes(String currentPlannedLifecycleAFF, String firstOnFloorMonthAFF, String dlvySelectedAFF,
			String ticketCode, String lsusStockingCSC, String targetAFFMSRP, String priceWhslAFF, String bucketCodeAFF,
			ExtentTest test) throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);

		ArrayList<String> header = new ArrayList<String>();
		header = getActiveLSAColumnHeaderValue();
		for (int i = 0; i < 31; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Adopted AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Adopted_AFF_LSA_value));
				Thread.sleep(10000);
				String adoptedAFFText = Adopted_AFF_LSA_value.getText();
				System.out.println("Current Adopted? AFF value: " + adoptedAFFText);
				if (!adoptedAFFText.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Adopted? AFF value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(Adopted_AFF_LSA_value).perform();
					Adopted_text.click();
					Adopted_text.clear();
					Adopted_text.sendKeys("Yes");
					Thread.sleep(2000);
					option.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					Save_button.click();
					test.log(Status.INFO, "Clicked On Save Button");
					Thread.sleep(10000);

					System.out.println("Adopted? AFF value changed to Yes");
					addSrceenShot("Adopted? AFF value changed to Yes", test, Capture);

				} else {
					System.out.println("Adopted? AFF value is already Yes, no change needed");
					addSrceenShot("Adopted? AFF value is already Yes, no change needed", test, Capture);
				}
			}
			if (ColumnHeader.equals("Current Planned Lifecycle AFF")) {
				new WebDriverWait(driver, 60)
						.until(ExpectedConditions.visibilityOf(current_Planned_LifecycleAFF_value));
				Thread.sleep(10000);
				String currentStatusOfcplaff = current_Planned_LifecycleAFF_value.getText();
				System.out.println(" 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				test.log(Status.INFO, " 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				addSrceenShot(" 'Current Planned Lifecycle AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOfcplaff.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(current_Planned_LifecycleAFF_value).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(currentPlannedLifecycleAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Current Planned Lifecycle AFF' to: " + currentPlannedLifecycleAFF);
					addSrceenShot("Updated 'Current Planned Lifecycle AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current Planned Lifecycle AFF' is already set to: " + currentStatusOfcplaff);
				}

			}
			if (ColumnHeader.equals("First On Floor Month AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(first_On_Floor_Month_AFF_value));
				Thread.sleep(10000);
				String currentStatusOf_FOFMAFF = first_On_Floor_Month_AFF_value.getText();
				System.out.println(" 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				test.log(Status.INFO, " 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				addSrceenShot(" 'Current First On Floor Month AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOf_FOFMAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(first_On_Floor_Month_AFF_value).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(firstOnFloorMonthAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Current First On Floor Month AFF' to: " + firstOnFloorMonthAFF);
					addSrceenShot("Updated 'Current First On Floor Month AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current First On Floor Month AFF' is already set to: " + currentStatusOf_FOFMAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Selected - AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(dlvy_Selected_AFF_value));
				Thread.sleep(10000);
				String currentStatusOf_DSAFF = dlvy_Selected_AFF_value.getText();
				System.out.println("Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				test.log(Status.INFO, "Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				addSrceenShot("Current 'Dlvy Selected - AFF' Value", test, Capture);
				if (currentStatusOf_DSAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(dlvy_Selected_AFF_value).perform();
					Thread.sleep(4000);
					textBox.sendKeys(dlvySelectedAFF);
					Thread.sleep(3000);
					filteredCheckkBox.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Dlvy Selected - AFF' to: " + dlvySelectedAFF);
					addSrceenShot("Updated 'Dlvy Selected - AFF'", test, Capture);
				} else {
					test.log(Status.INFO, " 'Dlvy Selected - AFF' is already set to: " + currentStatusOf_DSAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Start Date - AFF")) {

				String actualDlvyStartDateAFF = dlvyStartDateAFF.getText();
				if (actualDlvyStartDateAFF != null && !actualDlvyStartDateAFF.isEmpty()) {
					System.out.println("Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
					test.log(Status.INFO, "Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
				} else {
					System.out.println("Dlvy Start Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy Start Date - AFF is not auto-populated");
				}
			}

			if (ColumnHeader.equals("Dlvy End Date - AFF")) {
				String actualDlvyEndDateAFF = dlvyEndDateAFF.getText();
				if (actualDlvyEndDateAFF != null && !actualDlvyEndDateAFF.isEmpty()) {
					System.out.println("Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
					test.log(Status.INFO, "Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
				} else {
					System.out.println("Dlvy End Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy End Date - AFF is not auto-populated");
				}
			}
			if (ColumnHeader.equals("Ticket Code AFF")) {
				String currentStatusOfTicketCode = ticket_Code_AFF_value.getText();
				System.out.println("Current 'Ticket Code AFF' Value: " + currentStatusOfTicketCode);
				test.log(Status.INFO, "Current 'Ticket Code AFF' Value: " + currentStatusOfTicketCode);
				addSrceenShot("Current 'Ticket Code AFF' Value", test, Capture);

				if (currentStatusOfTicketCode.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(ticket_Code_AFF).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(ticketCode);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.PASS, "Updated 'Ticket Code AFF' to: " + ticketCode);
					addSrceenShot("Updated 'Ticket Code AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Ticket Code AFF' is already set to: " + currentStatusOfTicketCode);
				}

			}

			if (ColumnHeader.equals("LSUS Stocking CSC AFF")) {

				String currentStatusOfLSUSStockingCSC = lsus_Stocking_CSC_AFF_value.getText();
				System.out.println("Current 'LSUS Stocking CSC AFF' Value: " + currentStatusOfLSUSStockingCSC);
				test.log(Status.INFO, "Current 'LSUS Stocking CSC AFF' Value: " + currentStatusOfLSUSStockingCSC);
				addSrceenShot("Current 'LSUS Stocking CSC AFF' Value", test, Capture);

				if (currentStatusOfLSUSStockingCSC.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(lsus_Stocking_CSC_AFF_value).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(lsusStockingCSC);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'LSUS Stocking CSC AFF' to: " + lsusStockingCSC);
					addSrceenShot("Updated 'LSUS Stocking CSC AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							"'LSUS Stocking CSC AFF' is already set to: " + currentStatusOfLSUSStockingCSC);
				}
			}
			if (ColumnHeader.equals("Target AFF MSRP")) {

				String currentStatusOfTargetAFFMSRP = target_AFF_MSRP_value.getText();
				System.out.println("Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				test.log(Status.INFO, "Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				addSrceenShot("Current 'Target AFF MSRP' Value", test, Capture);

				if (currentStatusOfTargetAFFMSRP.isEmpty() || currentStatusOfTargetAFFMSRP.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(target_AFF_MSRP_value).perform();
					Thread.sleep(4000);
					text_Input.clear();
					text_Input.sendKeys(targetAFFMSRP);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Target AFF MSRP' to: " + targetAFFMSRP);
					addSrceenShot("Updated 'Target AFF MSRP'", test, Capture);
				} else {
					test.log(Status.INFO, "'Target AFF MSRP' is already set to: " + currentStatusOfTargetAFFMSRP);
				}
			}

			if (ColumnHeader.equals("Price Whsl AFF")) {

				String currentStatusOfPriceWhslAFF = price_Whsl_AFF_value.getText();
				System.out.println("Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				test.log(Status.INFO, "Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				addSrceenShot("Current 'Price Whsl AFF' Value", test, Capture);

				if (currentStatusOfPriceWhslAFF.isEmpty() || currentStatusOfPriceWhslAFF.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(price_Whsl_AFF_value).perform();
					Thread.sleep(4000);
					text_Input.clear();
					actions.sendKeys(text_Input, priceWhslAFF).perform();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Price Whsl AFF' to: " + priceWhslAFF);
					addSrceenShot("Updated 'Price Whsl AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Price Whsl AFF' is already set to: " + currentStatusOfPriceWhslAFF);
				}
			}

			if (ColumnHeader.equals("Product Price Position AFF")) {
				String currentStatusOfProductPricePositionAFF = product_Price_Position_AFF_value.getText();
				System.out.println(
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				test.log(Status.INFO,
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				addSrceenShot("Current 'Product Price Position AFF' Value", test, Capture);

			}
			if (ColumnHeader.equals("Bucket Code AFF")) {

				String currentStatusOfBucketCodeAFF = bucket_Code_AFF_value.getText();
				System.out.println("Current 'Bucket Code AFF' Value: " + currentStatusOfBucketCodeAFF);
				test.log(Status.INFO, "Current 'Bucket Code AFF' Value: " + currentStatusOfBucketCodeAFF);
				addSrceenShot("Current 'Bucket Code AFF' Value", test, Capture);

				if (currentStatusOfBucketCodeAFF.isEmpty() || currentStatusOfBucketCodeAFF.contains("00000-0000")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(bucket_Code_AFF_value).perform();
					Thread.sleep(4000);
					text_Input.clear();
					text_Input.sendKeys(bucketCodeAFF);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Bucket Code AFF' to: " + bucketCodeAFF);
					addSrceenShot("Updated 'Bucket Code AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Bucket Code AFF' is already set to: " + currentStatusOfBucketCodeAFF);
				}
			}

			if (ColumnHeader.equals("Activate - Run Validation")) {
				String currentStatusOfRunValidation = active_run_Validation_value.getText();
				System.out.println("Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				test.log(Status.INFO, "Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				addSrceenShot("Current 'Active Run Validation' Value", test, Capture);
				if (!currentStatusOfRunValidation.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Activate - Run Validation value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(active_run_Validation_value).perform();
					actions.moveToElement(check_Box).click().perform();
//					check_Box.click();
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					System.out.println("Activate - Run Validation to Yes");
					
					addSrceenShot("Activate - Run Validation changed to Yes", test, Capture);

				} else {
					System.out.println("Activate - Run Validation value is already Yes, no change needed");
					addSrceenShot("Activate - Run Validation is already Yes, no change needed", test, Capture);
				}

			}

		}
//			if (ColumnHeader.equals("Activate")) {
		String currentStatusOfactive = active_value.getText();
		System.out.println("Current 'Active' Value: " + currentStatusOfactive);
		test.log(Status.INFO, "Current 'Active' Value: " + currentStatusOfactive);
		addSrceenShot("Current 'Active' Value", test, Capture);
		if (!currentStatusOfactive.equalsIgnoreCase("Yes")) {
			System.out.println("Changing Activate to Yes");
			Actions actions = new Actions(driver);
			actions.doubleClick(active_value).perform();
			actions.moveToElement(check_Box).click().perform();
			actions.sendKeys(Keys.ENTER).perform();
			Save_button.click();
			Thread.sleep(10000);
			System.out.println("Activate changed to Yes");
			addSrceenShot("Activate changed to Yes", test, Capture);

		} else {
			System.out.println("Activate value is already Yes, no change needed");
			addSrceenShot("Activate is already Yes, no change needed", test, Capture);
		}
	}
	
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoCrrtPlndLfcycl|~*~|5.Activate-LSE'])[2]")
	private WebElement current_Planned_LifecycleAFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoFOFMonth|~*~|5.Activate-LSE'])[2]")
	private WebElement first_On_Floor_Month_AFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvySelectedINST|~*~|5.Activate-LSE'])[2]/span")
	private WebElement dlvy_Selected_AFF_LSE;


	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvyStartDateINST|~*~|5.Activate-LSE'])[2]")
	private WebElement dlvyStartDateAFF_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvyEndDateINST|~*~|5.Activate-LSE'])[2]")
	private WebElement dlvyEndDateAFF_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTicketCode|~*~|5.Activate-LSE'])[2]/div/span")
	private WebElement ticket_Code_AFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTicketCode|~*~|5.Activate-LSE'])[2]")
	private WebElement ticket_Code_AFF_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoStockingCustServCntr|~*~|5.Activate-LSE'])[2]")
	private WebElement lsus_Stocking_CSC_AFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoPriceRetail|~*~|5.Activate-LSE'])[2]")
	private WebElement target_AFF_MSRP_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoPriceWhsl|~*~|5.Activate-LSE'])[2]")
	private WebElement price_Whsl_AFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoProdPricePosition|~*~|5.Activate-LSE'])[2]")
	private WebElement product_Price_Position_AFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoBucketCode|~*~|5.Activate-LSE'])[2]")
	private WebElement bucket_Code_AFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAdopted|~*~|5.Activate-LSE'])[2]")
	private WebElement Adopted_AFF_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoActivateValidation|~*~|5.Activate-LSE'])[2]")
	private WebElement active_run_Validation_value_LSE;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoValidationBO|~*~|5.Activate-LSE'])[2]//a")
	private WebElement active_run_Validation_status_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTriggerSAPforBulk|~*~|5.Activate-LSE'])[2]")
	private WebElement active_value_LSE;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoActivateStatus|~*~|5.Activate-LSE'])[2]")
	private WebElement activateStatus_value_LSE;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAdopted|~*~|5.Activate-APD'])[2]")
	private WebElement Adopted_AFF_value_APD;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoCrrtPlndLfcycl|~*~|5.Activate-APD'])[2]")
	private WebElement current_Planned_LifecycleAFF_value_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoFOFMonth|~*~|5.Activate-APD'])[2]")
	private WebElement first_On_Floor_Month_AFF_value_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvySelectedINST|~*~|5.Activate-APD'])[2]/span")
	private WebElement dlvy_Selected_AFF_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvyStartDateINST|~*~|5.Activate-APD'])[2]")
	private WebElement dlvyStartDateAFF_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoDlvyEndDateINST|~*~|5.Activate-APD'])[2]")
	private WebElement dlvyEndDateAFF_APD;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoPriceRetail|~*~|5.Activate-APD'])[2]")
	private WebElement target_AFF_MSRP_value_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoPriceWhsl|~*~|5.Activate-APD'])[2]")
	private WebElement price_Whsl_AFF_value_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoProdPricePosition|~*~|5.Activate-APD'])[2]")
	private WebElement product_Price_Position_AFF_value_APD;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoActivateValidation|~*~|5.Activate-APD'])[2]")
	private WebElement active_run_Validation_value_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTriggerSAPforBulk|~*~|5.Activate-APD'])[2]")
	private WebElement active_value_APD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoActivateStatus|~*~|5.Activate-APD'])[2]")
	private WebElement activateStatus_value_APD;
	
	
	public void updateAttributes_ActivateAPD(String currentPlannedLifecycleAFF, String firstOnFloorMonthAFF, String dlvySelectedAFF,
		  String targetAFFMSRP, String priceWhslAFF, ExtentTest test) throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);

		ArrayList<String> header = new ArrayList<String>();
		header = getActivateLSEColumnHeaderValue();
		for (int i = 0; i < 31; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Adopted AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Adopted_AFF_value_APD));
				Thread.sleep(10000);
				String adoptedAFFText = Adopted_AFF_value_APD.getText();
				System.out.println("Current Adopted? AFF value: " + adoptedAFFText);
				if (!adoptedAFFText.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Adopted? AFF value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(Adopted_AFF_value_APD).perform();
					Adopted_text.click();
					Adopted_text.clear();
					Adopted_text.sendKeys("Yes");
					Thread.sleep(2000);
					option.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					Save_button.click();
					test.log(Status.INFO, "Clicked On Save Button");
					Thread.sleep(10000);

					System.out.println("Adopted? AFF value changed to Yes");
					addSrceenShot("Adopted? AFF value changed to Yes", test, Capture);

				} else {
					System.out.println("Adopted? AFF value is already Yes, no change needed");
					addSrceenShot("Adopted? AFF value is already Yes, no change needed", test, Capture);
				}
			}
			if (ColumnHeader.equals("Current Planned Lifecycle AFF")) {
				new WebDriverWait(driver, 60)
						.until(ExpectedConditions.visibilityOf(current_Planned_LifecycleAFF_value_APD));
				Thread.sleep(10000);
				String currentStatusOfcplaff = current_Planned_LifecycleAFF_value_APD.getText();
				System.out.println(" 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				test.log(Status.INFO, " 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				addSrceenShot(" 'Current Planned Lifecycle AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOfcplaff.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(current_Planned_LifecycleAFF_value_APD).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(currentPlannedLifecycleAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Current Planned Lifecycle AFF' to: " + currentPlannedLifecycleAFF);
					addSrceenShot("Updated 'Current Planned Lifecycle AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current Planned Lifecycle AFF' is already set to: " + currentStatusOfcplaff);
				}

			}
			if (ColumnHeader.equals("First On Floor Month AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(first_On_Floor_Month_AFF_value_APD));
				Thread.sleep(10000);
				String currentStatusOf_FOFMAFF = first_On_Floor_Month_AFF_value_APD.getText();
				System.out.println(" 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				test.log(Status.INFO, " 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				addSrceenShot(" 'Current First On Floor Month AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOf_FOFMAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(first_On_Floor_Month_AFF_value_APD).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(firstOnFloorMonthAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Current First On Floor Month AFF' to: " + firstOnFloorMonthAFF);
					addSrceenShot("Updated 'Current First On Floor Month AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current First On Floor Month AFF' is already set to: " + currentStatusOf_FOFMAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Selected - AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(dlvy_Selected_AFF_APD));
				Thread.sleep(10000);
				String currentStatusOf_DSAFF = dlvy_Selected_AFF_APD.getText();
				System.out.println("Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				test.log(Status.INFO, "Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				addSrceenShot("Current 'Dlvy Selected - AFF' Value", test, Capture);
				if (currentStatusOf_DSAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(dlvy_Selected_AFF_APD).perform();
					Thread.sleep(4000);
					textBox.sendKeys(dlvySelectedAFF);
					Thread.sleep(3000);
					filteredCheckkBox.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Dlvy Selected - AFF' to: " + dlvySelectedAFF);
					addSrceenShot("Updated 'Dlvy Selected - AFF'", test, Capture);
				} else {
					test.log(Status.INFO, " 'Dlvy Selected - AFF' is already set to: " + currentStatusOf_DSAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Start Date - AFF")) {

				String actualDlvyStartDateAFF = dlvyStartDateAFF_APD.getText();
				if (actualDlvyStartDateAFF != null && !actualDlvyStartDateAFF.isEmpty()) {
					System.out.println("Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
					test.log(Status.INFO, "Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
				} else {
					System.out.println("Dlvy Start Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy Start Date - AFF is not auto-populated");
				}
			}

			if (ColumnHeader.equals("Dlvy End Date - AFF")) {
				String actualDlvyEndDateAFF = dlvyEndDateAFF_APD.getText();
				if (actualDlvyEndDateAFF != null && !actualDlvyEndDateAFF.isEmpty()) {
					System.out.println("Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
					test.log(Status.INFO, "Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
				} else {
					System.out.println("Dlvy End Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy End Date - AFF is not auto-populated");
				}
			}
			if (ColumnHeader.equals("Target AFF MSRP")) {

				String currentStatusOfTargetAFFMSRP = target_AFF_MSRP_value_APD.getText();
				System.out.println("Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				test.log(Status.INFO, "Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				addSrceenShot("Current 'Target AFF MSRP' Value", test, Capture);

				if (currentStatusOfTargetAFFMSRP.isEmpty() || currentStatusOfTargetAFFMSRP.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(target_AFF_MSRP_value_APD).perform();
					Thread.sleep(4000);
					text_Input.clear();
					text_Input.sendKeys(targetAFFMSRP);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Target AFF MSRP' to: " + targetAFFMSRP);
					addSrceenShot("Updated 'Target AFF MSRP'", test, Capture);
				} else {
					test.log(Status.INFO, "'Target AFF MSRP' is already set to: " + currentStatusOfTargetAFFMSRP);
				}
			}

			if (ColumnHeader.equals("Price Whsl AFF")) {

				String currentStatusOfPriceWhslAFF = price_Whsl_AFF_value_APD.getText();
				System.out.println("Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				test.log(Status.INFO, "Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				addSrceenShot("Current 'Price Whsl AFF' Value", test, Capture);

				if (currentStatusOfPriceWhslAFF.isEmpty() || currentStatusOfPriceWhslAFF.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(price_Whsl_AFF_value_APD).perform();
					Thread.sleep(4000);
					text_Input.clear();
					actions.sendKeys(text_Input, priceWhslAFF).perform();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Price Whsl AFF' to: " + priceWhslAFF);
					addSrceenShot("Updated 'Price Whsl AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Price Whsl AFF' is already set to: " + currentStatusOfPriceWhslAFF);
				}
			}

			if (ColumnHeader.equals("Product Price Position AFF")) {
				String currentStatusOfProductPricePositionAFF = product_Price_Position_AFF_value_APD.getText();
				System.out.println(
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				test.log(Status.INFO,
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				addSrceenShot("Current 'Product Price Position AFF' Value", test, Capture);

			}
			if (ColumnHeader.equals("Activate - Run Validation")) {
				String currentStatusOfRunValidation = active_run_Validation_value_APD.getText();
				System.out.println("Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				test.log(Status.INFO, "Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				addSrceenShot("Current 'Active Run Validation' Value", test, Capture);
				if (!currentStatusOfRunValidation.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Activate - Run Validation value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(active_run_Validation_value_APD).perform();
					actions.moveToElement(check_Box).click().perform();
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					System.out.println("Activate - Run Validation to Yes");
					
					addSrceenShot("Activate - Run Validation changed to Yes", test, Capture);

				} else {
					System.out.println("Activate - Run Validation value is already Yes, no change needed");
					addSrceenShot("Activate - Run Validation is already Yes, no change needed", test, Capture);
					test.log(Status.INFO,"Activate - Run Validation value is already Yes, no change needed");
				}

			}

		}
		String currentStatusOfactive = active_value_APD.getText();
		System.out.println("Current 'Active' Value: " + currentStatusOfactive);
		test.log(Status.INFO, "Current 'Active' Value: " + currentStatusOfactive);
		addSrceenShot("Current 'Active' Value", test, Capture);
		if (!currentStatusOfactive.equalsIgnoreCase("Yes")) {
			System.out.println("Changing Activate to Yes");
			Actions actions = new Actions(driver);
			actions.doubleClick(active_value_APD).perform();
			actions.moveToElement(check_Box).click().perform();
			actions.sendKeys(Keys.ENTER).perform();
			Save_button.click();
			Thread.sleep(30000);
			System.out.println("Activate changed to Yes");
			addSrceenShot("Activate changed to Yes", test, Capture);

		} else {
			System.out.println("Activate value is already Yes, no change needed");
			test.log(Status.FAIL,"Activate value is already Yes, no change needed");
			addSrceenShot("Activate is already Yes, no change needed", test, Capture);
		}
	}
	
	
	public void updateAttributes_ActivateLSE(String currentPlannedLifecycleAFF, String firstOnFloorMonthAFF, String dlvySelectedAFF,
			String ticketCode, String lsusStockingCSC, String targetAFFMSRP, String priceWhslAFF, String bucketCodeAFF,
			ExtentTest test) throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);

		ArrayList<String> header = new ArrayList<String>();
		header = getActivateLSEColumnHeaderValue();
		for (int i = 0; i < 31; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Adopted AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Adopted_AFF_value_LSE));
				Thread.sleep(10000);
				String adoptedAFFText = Adopted_AFF_value_LSE.getText();
				System.out.println("Current Adopted? AFF value: " + adoptedAFFText);
				if (!adoptedAFFText.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Adopted? AFF value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(Adopted_AFF_value_LSE).perform();
					Adopted_text.click();
					Adopted_text.clear();
					Adopted_text.sendKeys("Yes");
					Thread.sleep(2000);
					option.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					Save_button.click();
					test.log(Status.INFO, "Clicked On Save Button");
					Thread.sleep(10000);

					System.out.println("Adopted? AFF value changed to Yes");
					addSrceenShot("Adopted? AFF value changed to Yes", test, Capture);

				} else {
					System.out.println("Adopted? AFF value is already Yes, no change needed");
					addSrceenShot("Adopted? AFF value is already Yes, no change needed", test, Capture);
				}
			}
			if (ColumnHeader.equals("Current Planned Lifecycle AFF")) {
				new WebDriverWait(driver, 60)
						.until(ExpectedConditions.visibilityOf(current_Planned_LifecycleAFF_value_LSE));
				Thread.sleep(10000);
				String currentStatusOfcplaff = current_Planned_LifecycleAFF_value_LSE.getText();
				System.out.println(" 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				test.log(Status.INFO, " 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				addSrceenShot(" 'Current Planned Lifecycle AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOfcplaff.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(current_Planned_LifecycleAFF_value_LSE).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(currentPlannedLifecycleAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Current Planned Lifecycle AFF' to: " + currentPlannedLifecycleAFF);
					addSrceenShot("Updated 'Current Planned Lifecycle AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current Planned Lifecycle AFF' is already set to: " + currentStatusOfcplaff);
				}

			}
			if (ColumnHeader.equals("First On Floor Month AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(first_On_Floor_Month_AFF_value_LSE));
				Thread.sleep(10000);
				String currentStatusOf_FOFMAFF = first_On_Floor_Month_AFF_value_LSE.getText();
				System.out.println(" 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				test.log(Status.INFO, " 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				addSrceenShot(" 'Current First On Floor Month AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOf_FOFMAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(first_On_Floor_Month_AFF_value_LSE).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(firstOnFloorMonthAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Current First On Floor Month AFF' to: " + firstOnFloorMonthAFF);
					addSrceenShot("Updated 'Current First On Floor Month AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current First On Floor Month AFF' is already set to: " + currentStatusOf_FOFMAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Selected - AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(dlvy_Selected_AFF_LSE));
				Thread.sleep(10000);
				String currentStatusOf_DSAFF = dlvy_Selected_AFF_LSE.getText();
				System.out.println("Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				test.log(Status.INFO, "Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				addSrceenShot("Current 'Dlvy Selected - AFF' Value", test, Capture);
				if (currentStatusOf_DSAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(dlvy_Selected_AFF_LSE).perform();
					Thread.sleep(4000);
					textBox.sendKeys(dlvySelectedAFF);
					Thread.sleep(3000);
					filteredCheckkBox.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Dlvy Selected - AFF' to: " + dlvySelectedAFF);
					addSrceenShot("Updated 'Dlvy Selected - AFF'", test, Capture);
				} else {
					test.log(Status.INFO, " 'Dlvy Selected - AFF' is already set to: " + currentStatusOf_DSAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Start Date - AFF")) {

				String actualDlvyStartDateAFF = dlvyStartDateAFF_LSE.getText();
				if (actualDlvyStartDateAFF != null && !actualDlvyStartDateAFF.isEmpty()) {
					System.out.println("Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
					test.log(Status.INFO, "Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
				} else {
					System.out.println("Dlvy Start Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy Start Date - AFF is not auto-populated");
				}
			}

			if (ColumnHeader.equals("Dlvy End Date - AFF")) {
				String actualDlvyEndDateAFF = dlvyEndDateAFF_LSE.getText();
				if (actualDlvyEndDateAFF != null && !actualDlvyEndDateAFF.isEmpty()) {
					System.out.println("Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
					test.log(Status.INFO, "Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
				} else {
					System.out.println("Dlvy End Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy End Date - AFF is not auto-populated");
				}
			}
			if (ColumnHeader.equals("LSUS Stocking CSC AFF")) {

				String currentStatusOfLSUSStockingCSC = lsus_Stocking_CSC_AFF_value_LSE.getText();
				System.out.println("Current 'LSUS Stocking CSC AFF' Value: " + currentStatusOfLSUSStockingCSC);
				test.log(Status.INFO, "Current 'LSUS Stocking CSC AFF' Value: " + currentStatusOfLSUSStockingCSC);
				addSrceenShot("Current 'LSUS Stocking CSC AFF' Value", test, Capture);

				if (currentStatusOfLSUSStockingCSC.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(lsus_Stocking_CSC_AFF_value_LSE).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(lsusStockingCSC);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'LSUS Stocking CSC AFF' to: " + lsusStockingCSC);
					addSrceenShot("Updated 'LSUS Stocking CSC AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							"'LSUS Stocking CSC AFF' is already set to: " + currentStatusOfLSUSStockingCSC);
				}
			}
			if (ColumnHeader.equals("Target AFF MSRP")) {

				String currentStatusOfTargetAFFMSRP = target_AFF_MSRP_value_LSE.getText();
				System.out.println("Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				test.log(Status.INFO, "Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				addSrceenShot("Current 'Target AFF MSRP' Value", test, Capture);

				if (currentStatusOfTargetAFFMSRP.isEmpty() || currentStatusOfTargetAFFMSRP.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(target_AFF_MSRP_value_LSE).perform();
					Thread.sleep(4000);
					text_Input.clear();
					text_Input.sendKeys(targetAFFMSRP);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Target AFF MSRP' to: " + targetAFFMSRP);
					addSrceenShot("Updated 'Target AFF MSRP'", test, Capture);
				} else {
					test.log(Status.INFO, "'Target AFF MSRP' is already set to: " + currentStatusOfTargetAFFMSRP);
				}
			}

			if (ColumnHeader.equals("Price Whsl AFF")) {

				String currentStatusOfPriceWhslAFF = price_Whsl_AFF_value_LSE.getText();
				System.out.println("Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				test.log(Status.INFO, "Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				addSrceenShot("Current 'Price Whsl AFF' Value", test, Capture);

				if (currentStatusOfPriceWhslAFF.isEmpty() || currentStatusOfPriceWhslAFF.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(price_Whsl_AFF_value_LSE).perform();
					Thread.sleep(4000);
					text_Input.clear();
					actions.sendKeys(text_Input, priceWhslAFF).perform();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Price Whsl AFF' to: " + priceWhslAFF);
					addSrceenShot("Updated 'Price Whsl AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Price Whsl AFF' is already set to: " + currentStatusOfPriceWhslAFF);
				}
			}

			if (ColumnHeader.equals("Product Price Position AFF")) {
				String currentStatusOfProductPricePositionAFF = product_Price_Position_AFF_value_LSE.getText();
				System.out.println(
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				test.log(Status.INFO,
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				addSrceenShot("Current 'Product Price Position AFF' Value", test, Capture);

			}
			if (ColumnHeader.equals("Bucket Code AFF")) {

				String currentStatusOfBucketCodeAFF = bucket_Code_AFF_value_LSE.getText();
				System.out.println("Current 'Bucket Code AFF' Value: " + currentStatusOfBucketCodeAFF);
				test.log(Status.INFO, "Current 'Bucket Code AFF' Value: " + currentStatusOfBucketCodeAFF);
				addSrceenShot("Current 'Bucket Code AFF' Value", test, Capture);

				if (currentStatusOfBucketCodeAFF.isEmpty() || currentStatusOfBucketCodeAFF.contains("00000-0000")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(bucket_Code_AFF_value_LSE).perform();
					Thread.sleep(4000);
					text_Input.clear();
					text_Input.sendKeys(bucketCodeAFF);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Bucket Code AFF' to: " + bucketCodeAFF);
					addSrceenShot("Updated 'Bucket Code AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Bucket Code AFF' is already set to: " + currentStatusOfBucketCodeAFF);
				}
			}

			if (ColumnHeader.equals("Activate - Run Validation")) {
				String currentStatusOfRunValidation = active_run_Validation_value_LSE.getText();
				System.out.println("Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				test.log(Status.INFO, "Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				addSrceenShot("Current 'Active Run Validation' Value", test, Capture);
				if (!currentStatusOfRunValidation.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Activate - Run Validation value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(active_run_Validation_value_LSE).perform();
					actions.moveToElement(check_Box).click().perform();
//					check_Box.click();
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					System.out.println("Activate - Run Validation to Yes");
					
					addSrceenShot("Activate - Run Validation changed to Yes", test, Capture);

				} else {
					System.out.println("Activate - Run Validation value is already Yes, no change needed");
					addSrceenShot("Activate - Run Validation is already Yes, no change needed", test, Capture);
				}

			}

		}
//		if (ColumnHeader.equals("Activate")) {
		String currentStatusOfactive = active_value_LSE.getText();
		System.out.println("Current 'Active' Value: " + currentStatusOfactive);
		test.log(Status.INFO, "Current 'Active' Value: " + currentStatusOfactive);
		addSrceenShot("Current 'Active' Value", test, Capture);
		if (!currentStatusOfactive.equalsIgnoreCase("Yes")) {
			System.out.println("Changing Activate to Yes");
			Actions actions = new Actions(driver);
			actions.doubleClick(active_value_LSE).perform();
			actions.moveToElement(check_Box).click().perform();
			actions.sendKeys(Keys.ENTER).perform();
			Save_button.click();
			Thread.sleep(10000);
			System.out.println("Activate changed to Yes");
			addSrceenShot("Activate changed to Yes", test, Capture);

		} else {
			System.out.println("Activate value is already Yes, no change needed");
			addSrceenShot("Activate is already Yes, no change needed", test, Capture);
		}
	}
	
	public void updateAttributes_ActivateValidation_LSE(String currentPlannedLifecycleAFF, String firstOnFloorMonthAFF, String dlvySelectedAFF,
			String ticketCode, String lsusStockingCSC, String targetAFFMSRP, String priceWhslAFF, String bucketCodeAFF,
			ExtentTest test) throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);

		ArrayList<String> header = new ArrayList<String>();
		header = getActivateLSEColumnHeaderValue();
		for (int i = 0; i < 31; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Adopted AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Adopted_AFF_value_LSE));
				Thread.sleep(10000);
				String adoptedAFFText = Adopted_AFF_value_LSE.getText();
				System.out.println("Current Adopted? AFF value: " + adoptedAFFText);
				if (!adoptedAFFText.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Adopted? AFF value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(Adopted_AFF_value_LSE).perform();
					Adopted_text.click();
					Adopted_text.clear();
					Adopted_text.sendKeys("Yes");
					Thread.sleep(2000);
					option.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					Save_button.click();
					test.log(Status.INFO, "Clicked On Save Button");
					Thread.sleep(10000);

					System.out.println("Adopted? AFF value changed to Yes");
					addSrceenShot("Adopted? AFF value changed to Yes", test, Capture);

				} else {
					System.out.println("Adopted? AFF value is already Yes, no change needed");
					addSrceenShot("Adopted? AFF value is already Yes, no change needed", test, Capture);
				}
			}
			if (ColumnHeader.equals("Current Planned Lifecycle AFF")) {
				new WebDriverWait(driver, 60)
						.until(ExpectedConditions.visibilityOf(current_Planned_LifecycleAFF_value_LSE));
				Thread.sleep(10000);
				String currentStatusOfcplaff = current_Planned_LifecycleAFF_value_LSE.getText();
				System.out.println(" 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				test.log(Status.INFO, " 'Current Planned Lifecycle AFF' Value: " + currentStatusOfcplaff);
				addSrceenShot(" 'Current Planned Lifecycle AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOfcplaff.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(current_Planned_LifecycleAFF_value_LSE).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(currentPlannedLifecycleAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Current Planned Lifecycle AFF' to: " + currentPlannedLifecycleAFF);
					addSrceenShot("Updated 'Current Planned Lifecycle AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current Planned Lifecycle AFF' is already set to: " + currentStatusOfcplaff);
				}

			}
			if (ColumnHeader.equals("First On Floor Month AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(first_On_Floor_Month_AFF_value_LSE));
				Thread.sleep(10000);
				String currentStatusOf_FOFMAFF = first_On_Floor_Month_AFF_value_LSE.getText();
				System.out.println(" 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				test.log(Status.INFO, " 'Current First On Floor Month AFF' Value: " + currentStatusOf_FOFMAFF);
				addSrceenShot(" 'Current First On Floor Month AFF' Value", test, Capture);
				Thread.sleep(2000);
				if (currentStatusOf_FOFMAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(first_On_Floor_Month_AFF_value_LSE).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(firstOnFloorMonthAFF);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Current First On Floor Month AFF' to: " + firstOnFloorMonthAFF);
					addSrceenShot("Updated 'Current First On Floor Month AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							" 'Current First On Floor Month AFF' is already set to: " + currentStatusOf_FOFMAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Selected - AFF")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(dlvy_Selected_AFF_LSE));
				Thread.sleep(10000);
				String currentStatusOf_DSAFF = dlvy_Selected_AFF_LSE.getText();
				System.out.println("Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				test.log(Status.INFO, "Current 'Dlvy Selected - AFF' Value: " + currentStatusOf_DSAFF);
				addSrceenShot("Current 'Dlvy Selected - AFF' Value", test, Capture);
				if (currentStatusOf_DSAFF.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(dlvy_Selected_AFF_LSE).perform();
					Thread.sleep(4000);
					textBox.sendKeys(dlvySelectedAFF);
					Thread.sleep(3000);
					filteredCheckkBox.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Dlvy Selected - AFF' to: " + dlvySelectedAFF);
					addSrceenShot("Updated 'Dlvy Selected - AFF'", test, Capture);
				} else {
					test.log(Status.INFO, " 'Dlvy Selected - AFF' is already set to: " + currentStatusOf_DSAFF);
				}
			}
			if (ColumnHeader.equals("Dlvy Start Date - AFF")) {

				String actualDlvyStartDateAFF = dlvyStartDateAFF_LSE.getText();
				if (actualDlvyStartDateAFF != null && !actualDlvyStartDateAFF.isEmpty()) {
					System.out.println("Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
					test.log(Status.INFO, "Dlvy Start Date - AFF is auto-populated: " + actualDlvyStartDateAFF);
				} else {
					System.out.println("Dlvy Start Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy Start Date - AFF is not auto-populated");
				}
			}

			if (ColumnHeader.equals("Dlvy End Date - AFF")) {
				String actualDlvyEndDateAFF = dlvyEndDateAFF_LSE.getText();
				if (actualDlvyEndDateAFF != null && !actualDlvyEndDateAFF.isEmpty()) {
					System.out.println("Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
					test.log(Status.INFO, "Dlvy End Date - AFF is auto-populated: " + actualDlvyEndDateAFF);
				} else {
					System.out.println("Dlvy End Date - AFF is not auto-populated");
					test.log(Status.FAIL, "Dlvy End Date - AFF is not auto-populated");
				}
			}
			if (ColumnHeader.equals("LSUS Stocking CSC AFF")) {

				String currentStatusOfLSUSStockingCSC = lsus_Stocking_CSC_AFF_value_LSE.getText();
				System.out.println("Current 'LSUS Stocking CSC AFF' Value: " + currentStatusOfLSUSStockingCSC);
				test.log(Status.INFO, "Current 'LSUS Stocking CSC AFF' Value: " + currentStatusOfLSUSStockingCSC);
				addSrceenShot("Current 'LSUS Stocking CSC AFF' Value", test, Capture);

				if (currentStatusOfLSUSStockingCSC.isEmpty()) {
					Actions actions = new Actions(driver);
					actions.doubleClick(lsus_Stocking_CSC_AFF_value_LSE).perform();
					Thread.sleep(4000);
					search_Box1.sendKeys(lsusStockingCSC);
					Thread.sleep(3000);
					filteredOptn.click();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'LSUS Stocking CSC AFF' to: " + lsusStockingCSC);
					addSrceenShot("Updated 'LSUS Stocking CSC AFF'", test, Capture);
				} else {
					test.log(Status.INFO,
							"'LSUS Stocking CSC AFF' is already set to: " + currentStatusOfLSUSStockingCSC);
				}
			}
			if (ColumnHeader.equals("Target AFF MSRP")) {

				String currentStatusOfTargetAFFMSRP = target_AFF_MSRP_value_LSE.getText();
				System.out.println("Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				test.log(Status.INFO, "Current 'Target AFF MSRP' Value: " + currentStatusOfTargetAFFMSRP);
				addSrceenShot("Current 'Target AFF MSRP' Value", test, Capture);

				if (currentStatusOfTargetAFFMSRP.isEmpty() || currentStatusOfTargetAFFMSRP.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(target_AFF_MSRP_value_LSE).perform();
					Thread.sleep(4000);
					text_Input.clear();
					text_Input.sendKeys(targetAFFMSRP);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(12000);
					test.log(Status.INFO, "Updated 'Target AFF MSRP' to: " + targetAFFMSRP);
					addSrceenShot("Updated 'Target AFF MSRP'", test, Capture);
				} else {
					test.log(Status.INFO, "'Target AFF MSRP' is already set to: " + currentStatusOfTargetAFFMSRP);
				}
			}

			if (ColumnHeader.equals("Price Whsl AFF")) {

				String currentStatusOfPriceWhslAFF = price_Whsl_AFF_value_LSE.getText();
				System.out.println("Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				test.log(Status.INFO, "Current 'Price Whsl AFF' Value: " + currentStatusOfPriceWhslAFF);
				addSrceenShot("Current 'Price Whsl AFF' Value", test, Capture);

				if (currentStatusOfPriceWhslAFF.isEmpty() || currentStatusOfPriceWhslAFF.equals("0")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(price_Whsl_AFF_value_LSE).perform();
					Thread.sleep(4000);
					text_Input.clear();
					actions.sendKeys(text_Input, priceWhslAFF).perform();
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(3000);
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Price Whsl AFF' to: " + priceWhslAFF);
					addSrceenShot("Updated 'Price Whsl AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Price Whsl AFF' is already set to: " + currentStatusOfPriceWhslAFF);
				}
			}

			if (ColumnHeader.equals("Product Price Position AFF")) {
				String currentStatusOfProductPricePositionAFF = product_Price_Position_AFF_value_LSE.getText();
				System.out.println(
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				test.log(Status.INFO,
						"Current 'Product Price Position AFF' Value: " + currentStatusOfProductPricePositionAFF);
				addSrceenShot("Current 'Product Price Position AFF' Value", test, Capture);

			}
			if (ColumnHeader.equals("Bucket Code AFF")) {

				String currentStatusOfBucketCodeAFF = bucket_Code_AFF_value_LSE.getText();
				System.out.println("Current 'Bucket Code AFF' Value: " + currentStatusOfBucketCodeAFF);
				test.log(Status.INFO, "Current 'Bucket Code AFF' Value: " + currentStatusOfBucketCodeAFF);
				addSrceenShot("Current 'Bucket Code AFF' Value", test, Capture);

				if (currentStatusOfBucketCodeAFF.isEmpty() || currentStatusOfBucketCodeAFF.contains("00000-0000")) {
					Actions actions = new Actions(driver);
					actions.doubleClick(bucket_Code_AFF_value_LSE).perform();
					Thread.sleep(4000);
					text_Input.clear();
					text_Input.sendKeys(bucketCodeAFF);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER).perform();
					Save_button.click();
					Thread.sleep(10000);
					test.log(Status.INFO, "Updated 'Bucket Code AFF' to: " + bucketCodeAFF);
					addSrceenShot("Updated 'Bucket Code AFF'", test, Capture);
				} else {
					test.log(Status.INFO, "'Bucket Code AFF' is already set to: " + currentStatusOfBucketCodeAFF);
				}
			}

			if (ColumnHeader.equals("Activate - Run Validation")) {
				String currentStatusOfRunValidation = active_run_Validation_value_LSE.getText();
				System.out.println("Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				test.log(Status.INFO, "Current 'Active Run Validation' Value: " + currentStatusOfRunValidation);
				addSrceenShot("Current 'Active Run Validation' Value", test, Capture);
				if (!currentStatusOfRunValidation.equalsIgnoreCase("Yes")) {
					System.out.println("Changing Activate - Run Validation value to Yes");
					Actions actions = new Actions(driver);
					actions.doubleClick(active_run_Validation_value_LSE).perform();
					actions.moveToElement(check_Box).click().perform();
//					check_Box.click();
					actions.sendKeys(Keys.ENTER).perform();
					Thread.sleep(5000);
					System.out.println("Activate - Run Validation to Yes");
					test.log(Status.INFO, "changed Activate - Run Validation to Yes" );
					addSrceenShot("Activate - Run Validation changed to Yes", test, Capture);

				} else {
					System.out.println("Activate - Run Validation value is already Yes, no change needed");
					test.log(Status.INFO, "Activate - Run Validation value is already Yes, no change needed");
					addSrceenShot("Activate - Run Validation is already Yes, no change needed", test, Capture);
				}

			}
			

		}
	}
	
	public void Activation_RunValidation_LSE(ExtentTest test) {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		String runValidationStatus = active_run_Validation_value_LSE.getText();
		if (runValidationStatus.equalsIgnoreCase("Yes")) {
			System.out.println("Run Validation is successful: 'Activate - Run Validation' is set to Yes");
			test.log(Status.INFO, "Run Validation is successful: 'Activate - Run Validation' is set to Yes");
			addSrceenShot("Run Validation is successful", test, Capture);
		} else {
			System.out.println("Run Validation failed: 'Activate - Run Validation' is : "+ active_run_Validation_status_LSE.getText());
			test.log(Status.FAIL, "Run Validation failed: 'Activate - Run Validation' is : "+ active_run_Validation_status_LSE.getText());
			addSrceenShot("Run Validation failed", test, Capture);
			
		}
	}
	
	
	public void verifyActivation(ExtentTest test) throws InterruptedException {
		// Wait for any pending operations to complete
		Thread.sleep(5000);

		// Switch to the default content and then to the required iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Check if the 'Activate' attribute is set to 'Yes'
		String activateStatus = active_value.getText();
		if (activateStatus.equalsIgnoreCase("Yes")) {
			System.out.println("Activation is successful: 'Activate' is set to Yes");
			test.log(Status.INFO, "Activation is successful: 'Activate' is set to Yes");
			addSrceenShot("Activation is successful", test, Capture);
		} else {
			System.out.println("Activation failed: 'Activate' is not set to Yes");
			test.log(Status.FAIL, "Activation failed: 'Activate' is not set to Yes");
			addSrceenShot("Activation failed", test, Capture);
		}

		// Check if the 'Activate - Run Validation' attribute is set to 'Yes'
		String runValidationStatus = active_run_Validation_value.getText();
		if (runValidationStatus.equalsIgnoreCase("Yes")) {
			System.out.println("Run Validation is successful: 'Activate - Run Validation' is set to Yes");
			test.log(Status.INFO, "Run Validation is successful: 'Activate - Run Validation' is set to Yes");
			addSrceenShot("Run Validation is successful", test, Capture);
		} else {
			System.out.println("Run Validation failed: 'Activate - Run Validation' is not set to Yes");
			test.log(Status.FAIL, "Run Validation failed: 'Activate - Run Validation' is not set to Yes");
			addSrceenShot("Run Validation failed", test, Capture);
		}
		if(activateStatus_value.getText().contains("No Error")) {
			System.out.println("Activate Status is successful  and the value is : "+activateStatus_value.getText());
			test.log(Status.PASS, "Activate Status is successful and the value is : "+activateStatus_value.getText());
			addSrceenShot("Activate Status is successful  and the value is : "+activateStatus_value.getText(), test, Capture);
		} else {
			System.out.println("Activate Status is UnSuccessful/Failed");
			test.log(Status.FAIL, "Activate Status is UnSuccessful/Failed");
			addSrceenShot("Activate Status is UnSuccessful/Failed", test, Capture);
		}
		}

	public void verifyActivation_LSE(ExtentTest test) throws InterruptedException {
		// Wait for any pending operations to complete
		Thread.sleep(5000);

		// Switch to the default content and then to the required iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Check if the 'Activate' attribute is set to 'Yes'
		String activateStatus = active_value_LSE.getText();
		if (activateStatus.equalsIgnoreCase("Yes")) {
			System.out.println("Activation is successful: 'Activate' is set to Yes");
			test.log(Status.INFO, "Activation is successful: 'Activate' is set to Yes");
			addSrceenShot("Activation is successful", test, Capture);
		} else {
			System.out.println("Activation failed: 'Activate' is not set to Yes");
			test.log(Status.FAIL, "Activation failed: 'Activate' is not set to Yes");
			addSrceenShot("Activation failed", test, Capture);
		}

		// Check if the 'Activate - Run Validation' attribute is set to 'Yes'
		String runValidationStatus = active_run_Validation_value_LSE.getText();
		if (runValidationStatus.equalsIgnoreCase("Yes")) {
			System.out.println("Run Validation is successful: 'Activate - Run Validation' is set to Yes");
			test.log(Status.INFO, "Run Validation is successful: 'Activate - Run Validation' is set to Yes");
			addSrceenShot("Run Validation is successful", test, Capture);
		} else {
			System.out.println("Run Validation failed: 'Activate - Run Validation' is not set to Yes");
			test.log(Status.FAIL, "Run Validation failed: 'Activate - Run Validation' is not set to Yes");
			addSrceenShot("Run Validation failed", test, Capture);
		}
		if(activateStatus_value_LSE.getText().contains("No Error")) {
			System.out.println("Activate Status is successful  and the value is : "+activateStatus_value.getText());
			test.log(Status.PASS, "Activate Status is successful and the value is : "+activateStatus_value.getText());
			addSrceenShot("Activate Status is successful  and the value is : "+activateStatus_value.getText(), test, Capture);
		} else {
			System.out.println("Activate Status is UnSuccessful/Failed");
			test.log(Status.FAIL, "Activate Status is UnSuccessful/Failed");
			addSrceenShot("Activate Status is UnSuccessful/Failed", test, Capture);
		}
		}
	
	public void verifyActivation_APD(ExtentTest test) throws InterruptedException {
		// Wait for any pending operations to complete
		Thread.sleep(5000);

		// Switch to the default content and then to the required iframe
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Check if the 'Activate' attribute is set to 'Yes'
		String activateStatus = active_value_APD.getText();
		if (activateStatus.equalsIgnoreCase("Yes")) {
			System.out.println("Activation is successful: 'Activate' is set to Yes");
			test.log(Status.INFO, "Activation is successful: 'Activate' is set to Yes");
			addSrceenShot("Activation is successful", test, Capture);
		} else {
			System.out.println("Activation failed: 'Activate' is not set to Yes");
			test.log(Status.FAIL, "Activation failed: 'Activate' is not set to Yes");
			addSrceenShot("Activation failed", test, Capture);
		}
		if(activateStatus_value_APD.getText().contains("No Error")) {
			System.out.println("Activate Status is successful  and the value is : "+activateStatus_value_APD.getText());
			test.log(Status.PASS, "Activate Status is successful and the value is : "+activateStatus_value_APD.getText());
			addSrceenShot("Activate Status is successful  and the value is : "+activateStatus_value_APD.getText(), test, Capture);
		} else {
			System.out.println("Activate Status is UnSuccessful/Failed");
			test.log(Status.FAIL, "Activate Status is UnSuccessful/Failed");
			addSrceenShot("Activate Status is UnSuccessful/Failed", test, Capture);
		}
		}
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void filterByColorway(String colorWayName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));

		filterInput.clear();
		filterInput.sendKeys(colorWayName);
		Thread.sleep(3000);

	}

	public void selectSeasonGroups_GB_LH_AFF_Values(String globalVaue, String localHubValue, String affiliateValue,
			ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		test.log(Status.INFO, "Clicked On settings Icon ");
		addSrceenShot("Clicked On settings Icon", test, Capture);

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(globalDropDown));

		Actions actions = new Actions(driver);
		actions.moveToElement(globalDropDown).click().perform();
		Thread.sleep(2000);
		WebElement option = driver.findElement(By.xpath("//span[@title='" + globalVaue.trim() + "']"));
		actions.moveToElement(option).click().perform();
		test.log(Status.INFO, "Season Group As Global chosen: " + globalVaue);
		addSrceenShot("Season Group As Global chosen", test, Capture);
		Thread.sleep(2000);
		actions.moveToElement(localHubDropDown).click().perform();
		WebElement option1 = driver.findElement(By.xpath("//span[@title='" + localHubValue.trim() + "']"));
		actions.moveToElement(option1).click().perform();
		test.log(Status.INFO, "Season Group As LocalHub chosen: " + localHubValue);
		addSrceenShot("Season Group As LocalHub chosen", test, Capture);
		Thread.sleep(2000);
		actions.moveToElement(affiliateDropDown).click().perform();
		WebElement option2 = driver.findElement(By.xpath("//span[@title='" + affiliateValue.trim() + "']"));
		actions.moveToElement(option2).click().perform();
		test.log(Status.INFO,
				"Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub: "
						+ affiliateValue);
		addSrceenShot("Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub",
				test, Capture);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();
		test.log(Status.INFO, "Clicked On Apply Button");
		addSrceenShot("Clicked On Apply Button", test, Capture);
		Thread.sleep(4000);

	}

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoSelectedSizes|~*~|3.SizeSelection'])[2]")
	private WebElement selectedSizesGB;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoSelectedSizes|~*~|3.SizeSelection'])[2]//span")
	private WebElement selectedSizesGB_value;

	@FindBy(xpath = "//div[@class='clear pi pi-times ng-star-inserted']")
	private WebElement clearSymbol;

	public void replaceSizeGrid_CorrectCSSize(String newSizeGridCode, ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(4000);

		ArrayList<String> header = new ArrayList<String>();
		header = getSizeSelectionAT_GB_LH_AFF_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Size Grid Code")) {
				// Log previous size grid
				String previousSizeGridCode = sizeGridCode_text.getText();
				test.log(Status.INFO, "Previous Size Grid Code: " + previousSizeGridCode);
				addSrceenShot("Previous Size Grid Code", test, Capture);

			}
			if (ColumnHeader.equals("Selected Sizes GB")) {
				String currentStatus = selectedSizesGB_value.getText();
				System.out.println("Previous 'Selected sizes-GB' Sizes: " + currentStatus);
				test.log(Status.INFO, "Previous 'Selected sizes-GB' Sizes: " + currentStatus);
				Thread.sleep(2000);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript(
						"arguments[0].dispatchEvent(new MouseEvent('dblclick', {bubbles: true, cancelable: true, view: window}));",
						sizeGridCode_value);
				Thread.sleep(4000);
				search_Box.click();
				Thread.sleep(2000);
				search_Box.clear();
				search_Box.sendKeys(newSizeGridCode);
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filteredOptn));
				Thread.sleep(3000);
				filteredOptn.click();
				Thread.sleep(2000);
				search_Box.sendKeys(Keys.RETURN);
				Thread.sleep(3000);
				Save_button.click();
				Thread.sleep(10000);
				test.log(Status.INFO, "Replaced New Size Grid Code  with the correct CS size: " + newSizeGridCode);
				addSrceenShot("Replaced Size Grid Code with: ", test, Capture);
				// Verify the size grid changed
				String currentSizeGridCode = sizeGridCode_text.getText();
				if (currentSizeGridCode.equals(newSizeGridCode)) {
					// Capture error message from the size grid error section
					test.log(Status.INFO, "Size Grid Code changed as expected: " + newSizeGridCode);
					addSrceenShot("Size Grid Code changed as expected.", test, Capture);

				} else {
					test.log(Status.FAIL, "Size Grid Code not changed to: " + newSizeGridCode);
					addSrceenShot("Size Grid Code not changed to: ", test, Capture);
				}

				String afternewSizgGridStatus = selectedSizesGB_value.getText();
				System.out
						.println("'Selected sizes-GB' Sizes Based On New Size Grid Selecon: " + afternewSizgGridStatus);
				test.log(Status.INFO,
						"'Selected sizes-GB' Sizes Based On New Size Grid Selecon: " + afternewSizgGridStatus);
			}

			if (ColumnHeader.equals("Selected Sizes LH")) {
				// Log Selected Sizes AFF
				String currentStatus = selectedSizesLH_value.getText();
				System.out.println("'Selected sizes-LH' Sizes Based On New Size Grid Selecon: " + currentStatus);
				test.log(Status.INFO, "'Selected sizes-LH' Sizes Based On New Size Grid Selecon: " + currentStatus);

			}

			if (ColumnHeader.equals("Selected Sizes AFF")) {
				// Log Selected Sizes AFF
				String currentStatus = selectedSizesAFF_value.getText();
				System.out.println("'Selected sizes-AFF' Sizes Based On New Size Grid Selecon: " + currentStatus);
				test.log(Status.INFO, "'Selected sizes-AFF' Sizes Based On New Size Grid Selecon: " + currentStatus);
			}

		}
	}

	public void validateSizeGridCode(String expectedSizeGridCode, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(7000);

		String actualSizeGridCode_Text = sizeGridCode_text.getText();
		if (actualSizeGridCode_Text.equals(expectedSizeGridCode)) {
			System.out.println("Validation Passed: Size Grid Code is correctly updated to " + actualSizeGridCode_Text);
			test.log(Status.PASS,
					"Validation Passed: Size Grid Code is correctly updated to " + actualSizeGridCode_Text);
			addSrceenShot("Validation Passed", test, Capture);
		} else {
			System.out.println("Validation Failed: Expected Size Grid Code " + expectedSizeGridCode + " but found "
					+ actualSizeGridCode_Text);
			test.log(Status.FAIL, "Validation Failed: Expected Size Grid Code " + expectedSizeGridCode + " but found "
					+ actualSizeGridCode_Text);
			addSrceenShot("Validation Failed", test, Capture);
		}
	}

	public void navigateToColorwaySeasonPage(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		// Scroll to the Colorway Name column
		ArrayList<String> header = getSizeSelectionAT_GB_LH_AFF_ColumnHeaderValue();
		int colorwayNameIndex = header.indexOf("Colorway Name") + 3; // Adding 3 to match the column index in the table
		// Scroll to the Colorway Name column
		scroll(colorwayNameIndex);

//		int colorwayNameIndex = 4; // Example: 4 for "Colorway Name"
//
//	    scroll(colorwayNameIndex);

//		// Loop through the first 30 columns to find "Colorway Name"
//		for (int i = 0; i < 20; i++) {
//			scroll(i + 3); // Adjust the index as needed
//			String ColumnHeader = getSizeSelectionAT_GB_LH_AFF_ColumnHeaderValue().get(i);
//			if (ColumnHeader.equals("Colorway Name")) {

		WebElement colorwayName = driver
				.findElement(By.xpath("(//div[@col-id='colorway.skuName|~*~|3.SizeSelection'])[2]//a"));
		colorwayName.click();
		test.log(Status.INFO, "Clicked on Colorway Name");
		addSrceenShot("Clicked on Colorway Name", test, Capture);

		Thread.sleep(5000);

		System.out.println("Colorway Season Page opened successfully");
		test.log(Status.PASS, "Colorway Season Page opened successfully");
		addSrceenShot("Colorway Season Page opened successfully", test, Capture);

	}

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoSizeGridCode|~*~|3.SizeSelection'])[2]//a")
	private WebElement sizeGridCode_text;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoSizeGridErrorMsg|~*~|3.SizeSelection'])[2]")
	private WebElement size_Grid_Error_Msg_Text;

	public void logAndReplaceSizeGrid(String newSizeGridCode, ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(4000);

		ArrayList<String> header = new ArrayList<String>();
		header = getSizeSelectionAT_GB_LH_AFF_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Size Grid Code")) {
				// Log previous size grid
				String previousSizeGridCode = sizeGridCode_text.getText();
				test.log(Status.INFO, "Previous Size Grid Code: " + previousSizeGridCode);
				addSrceenShot("Previous Size Grid Code", test, Capture);
				// Attempt to change size grid
//				Actions actions = new Actions(driver);
//				actions.doubleClick(sizeGridCode_value).perform();
				Actions actions = new Actions(driver);
				actions.moveToElement(sizeGridCode_value, 10, 10).doubleClick().perform();
				Thread.sleep(4000);
				search_Box.click();
				Thread.sleep(2000);
				search_Box.clear();
				search_Box.sendKeys(newSizeGridCode);
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filteredOptn));
				Thread.sleep(3000);
				filteredOptn.click();
				Thread.sleep(2000);
				search_Box.sendKeys(Keys.RETURN);
				Thread.sleep(3000);
				Save_button.click();
				Thread.sleep(60000);
				Thread.sleep(60000);
				test.log(Status.INFO, "Attempted to replace Size Grid Code with: " + newSizeGridCode);
				addSrceenShot("Attempted Size Grid Code Replacement", test, Capture);
				// Verify the size grid did not change
				String currentSizeGridCode = sizeGridCode_text.getText();
				if (!currentSizeGridCode.equals(newSizeGridCode)) {
					// Capture error message from the size grid error section
					test.log(Status.PASS, "Size Grid Code did not change as expected.");
					addSrceenShot("Size Grid Code did not change as expected.", test, Capture);

				} else {
					test.log(Status.INFO, "Size Grid Code unexpectedly changed to: " + newSizeGridCode);
					addSrceenShot("Size Grid Code Changed", test, Capture);
				}

			}

			if (ColumnHeader.equals("Size Grid Error Message")) {
				// Verify Sample Size is populated
				String actualSizeGridErrorMsg = size_Grid_Error_Msg_Text.getText();
				if (actualSizeGridErrorMsg != null && !actualSizeGridErrorMsg.isEmpty()) {
					System.out.println("Error Message populated: " + actualSizeGridErrorMsg);
					test.log(Status.INFO, "Error Message populated: " + actualSizeGridErrorMsg);
				} else {
					System.out.println("Error Message Not populated");
					test.log(Status.FAIL, "Error Message Not populated");
				}
			}
		}

	}

	public String getSizeGridErrorMessage() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String actualSizeGridErrorMsg = size_Grid_Error_Msg_Text.getText();
//		if (actualSizeGridErrorMsg != null && !actualSizeGridErrorMsg.isEmpty()) {
//	}
		return actualSizeGridErrorMsg;
	}

	@FindBy(xpath = "(//div[@col-id='colorway.skuName|~*~|3.SizeSelection'])[2]//a")
	private WebElement colorWayName_text;

	@FindBy(xpath = "//div[normalize-space()='Size Grid Code']//following-sibling::div//a")
	private WebElement sizeGridCode_text_CS;

	@FindBy(xpath = "//div[normalize-space()='Sample Size']//following-sibling::div")
	private WebElement sampleSize_text;

	@FindBy(xpath = "//div[normalize-space()='Size Scale Code']//following-sibling::div")
	private WebElement sizeScaleCode_text;

	public void verifySizeGridDetailsOnColorwaySeasonPage(String newSizeGridCode, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);

		// Verify the new size grid code
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorWayName_text));
		colorWayName_text.click();
		Thread.sleep(2000);
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sizeGridCode_text_CS));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeGridCode_text_CS);
		String displayedSizeGridCode = sizeGridCode_text_CS.getText();
		if (displayedSizeGridCode.equals(newSizeGridCode)) {
			test.log(Status.PASS, "Size Grid Code Saved correctly On Colorway Season Page: " + displayedSizeGridCode);
			addSrceenShot("Size Grid Code Saved correctly On Colorway Season Page", test, Capture);
		} else {
			test.log(Status.FAIL,
					"Size Grid Code Not Saved correctly On Colorway Season Page: " + displayedSizeGridCode);
			addSrceenShot("Size Grid Code Not Saved correctly On Colorway Season Page", test, Capture);
		}

		// Verify the sample size
		String displayedSampleSize = sampleSize_text.getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sampleSize_text);
		if (displayedSampleSize != null && !displayedSampleSize.isEmpty()) {
			test.log(Status.PASS, "Sample Size Based On selected new Size Grid Code: " + displayedSampleSize);
			addSrceenShot("Sample Size Based On selected new Size Grid Code", test, Capture);
		} else {
			test.log(Status.FAIL, "Sample Size not displayed correctly: " + displayedSampleSize);
			addSrceenShot("Sample Size not displayed correctly", test, Capture);
		}

		// Verify the size scale code
		String displayedSizeScaleCode = sizeScaleCode_text.getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeScaleCode_text);
		if (displayedSizeScaleCode != null && !displayedSizeScaleCode.isEmpty()) {
			test.log(Status.PASS, "Size Scale Code Based On selected new Size Grid Code: " + displayedSizeScaleCode);
			addSrceenShot("Size Scale Code displayed correctly", test, Capture);
		} else {
			test.log(Status.FAIL, "Size Scale Code not displayed correctly: " + displayedSizeScaleCode);
			addSrceenShot("Size Scale Code not displayed correctly", test, Capture);
		}
	}
	
	public void replaceSizeGrid(String newSizeGridCode, ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(4000);

		ArrayList<String> header = new ArrayList<String>();
		header = getSizeSelectionAT_GB_LH_AFF_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Size Grid Code")) {
				// Log previous size grid
				String previousSizeGridCode = sizeGridCode_text.getText();
				test.log(Status.INFO, "Previous Size Grid Code: " + previousSizeGridCode);
				addSrceenShot("Previous Size Grid Code", test, Capture);

			}
			if (ColumnHeader.equals("Selected Sizes GB")) {
				String currentStatus = selectedSizesGB_value.getText();
				System.out.println("Previous 'Selected sizes-GB' Sizes: " + currentStatus);
				test.log(Status.INFO, "Previous 'Selected sizes-GB' Sizes: " + currentStatus);
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
				actions.doubleClick(selectedSizesGB).perform();
				Thread.sleep(4000);
//				filtered_LH_Optn.clear();
				for (int j = 0; j < 100; j++) {
					filtered_LH_Optn.sendKeys(Keys.BACK_SPACE);
				}
				Thread.sleep(2000);
				filtered_LH_Optn.sendKeys(Keys.RETURN);
				Thread.sleep(3000);
				Save_button.click();
				Thread.sleep(15000);
				System.out.println("Cleared sizes at global level clears at all local hubs and all affiliates");
				addSrceenShot("Cleared sizes at global level clears at all local hubs and all affiliates", test,
						Capture);
				test.log(Status.INFO,
						"Cleared sizes at global level clears at all local hubs and all affiliates Of: "+currentStatus);

//				actions.doubleClick(sizeGridCode_value).perform();
//				actions.moveToElement(sizeGridCode_value, 10, 10).doubleClick().perform();
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript(
						"arguments[0].dispatchEvent(new MouseEvent('dblclick', {bubbles: true, cancelable: true, view: window}));",
						sizeGridCode_value);
				Thread.sleep(4000);
				search_Box.click();
				Thread.sleep(2000);
				search_Box.clear();
				search_Box.sendKeys(newSizeGridCode);
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filteredOptn));
				Thread.sleep(3000);
				filteredOptn.click();
				Thread.sleep(2000);
				search_Box.sendKeys(Keys.RETURN);
				Thread.sleep(3000);
				Save_button.click();
				Thread.sleep(10000);
				test.log(Status.INFO, "Replaced Size Grid Code with: " + newSizeGridCode);
				addSrceenShot("Replaced Size Grid Code with: ", test, Capture);
				// Verify the size grid changed
				String currentSizeGridCode = sizeGridCode_text.getText();
				if (currentSizeGridCode.equals(newSizeGridCode)) {
					// Capture error message from the size grid error section
					test.log(Status.INFO, "Size Grid Code changed as expected: " + newSizeGridCode);
					addSrceenShot("Size Grid Code changed as expected.", test, Capture);

				} else {
					test.log(Status.FAIL, "Size Grid Code not changed to: " + newSizeGridCode);
					addSrceenShot("Size Grid Code not changed to: ", test, Capture);
				}

				String afternewSizgGridStatus = selectedSizesGB_value.getText();
				System.out
						.println("'Selected sizes-GB' Sizes Based On New Size Grid Selecon: " + afternewSizgGridStatus);
				test.log(Status.INFO,
						"'Selected sizes-GB' Sizes Based On New Size Grid Selecon: " + afternewSizgGridStatus);
			}

			if (ColumnHeader.equals("Selected Sizes LH")) {
				// Log Selected Sizes AFF
				String currentStatus = selectedSizesLH_value.getText();
				System.out.println("'Selected sizes-LH' Sizes Based On New Size Grid Selecon: " + currentStatus);
				test.log(Status.INFO, "'Selected sizes-LH' Sizes Based On New Size Grid Selecon: " + currentStatus);

			}

			if (ColumnHeader.equals("Selected Sizes AFF")) {
				// Log Selected Sizes AFF
				String currentStatus = selectedSizesAFF_value.getText();
				System.out.println("'Selected sizes-AFF' Sizes Based On New Size Grid Selecon: " + currentStatus);
				test.log(Status.INFO, "'Selected sizes-AFF' Sizes Based On New Size Grid Selecon: " + currentStatus);
			}

		}
	}
	
	//////////p3/////////////
	
	@FindBy(xpath = "//div[normalize-space()='LSCO\\Levis\\Global']//following::img[1]")
	//div[text()=' Season Groups ']/following::div[@role='button'][2]/following::img[1]
	private WebElement seasonGroupMenuIcon;

	@FindBy(xpath = "//span[normalize-space()='Create New']")
	private WebElement createNewSeasonGroupIcon;

	@FindBy(xpath = "seasonGroupDropdown")
	private WebElement seasonGroupDropdown;

	@FindBy(xpath = "//span[normalize-space()='Add Colorways']")
	private WebElement addColorwaysOption;

	public void clickOptionsIcon(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(10000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		Thread.sleep(2000);
	}

	public void clickCreateNewSeasonGroupIcon(ExtentTest test) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(seasonGroupMenuIcon));
		Thread.sleep(2000);
		seasonGroupMenuIcon.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(createNewSeasonGroupIcon));
		Thread.sleep(2000);
		createNewSeasonGroupIcon.click();
	}

	public void verifySeasonGroupCreationAndSelect(String seasonGroupName, ExtentTest test) throws Exception {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(globalDropDown));
		globalDropDown.click();
		Thread.sleep(4000);
		List<WebElement> seasonGroups = driver.findElements(By.xpath("//p-dropdownitem/li/span"));
		boolean found = false;

		for (WebElement group : seasonGroups) {
			if (group.getText().equals(seasonGroupName)) {
				group.click();
				test.log(Status.PASS, "Verified and selected season group: " + seasonGroupName);
				found = true;
				break;
			}
		}

		if (!found) {
			test.log(Status.FAIL, "Season group not found: " + seasonGroupName);
		}
	}

	public void chooseSeasonGroupInDropdown(String seasonGroupName, ExtentTest test) throws Exception {

		Actions actions = new Actions(driver);
		WebElement seasonGroup = driver.findElement(By.xpath("//span[text()='" + seasonGroupName.trim() + "']"));
		actions.moveToElement(seasonGroup).click().perform();
		seasonGroup.click();
		test.log(Status.INFO, "Chosen season group in dropdown: " + seasonGroupName);
	}

	public void clickApplyButton(ExtentTest test) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();
	}

	public void clickAddColorwaysOption(ExtentTest test) throws Exception {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(seasonGroupMenuIcon));
		Thread.sleep(2000);
		seasonGroupMenuIcon.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(addColorwaysOption));
		addColorwaysOption.click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
	}

	@FindBy(xpath = "//input[@id='ptc_str_1']")
	private WebElement seasonGroupNameField;

	public void fillSeasonGroupAttributes(String seasonGroupName, ExtentTest test) throws Exception {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(seasonGroupNameField));
		Thread.sleep(3000);
		seasonGroupNameField.sendKeys(seasonGroupName);
	}

	public void clickCreateButton(ExtentTest test) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(saveFilterButton));
		Thread.sleep(2000);
		saveFilterButton.click();

	}

	@FindBy(id = "colorwayFilterField")
	private WebElement colorwayFilterField;

	@FindBy(xpath = "//span[normalize-space()='Select']")
	private WebElement selectButton;

	@FindBy(xpath = "//div[@class='error-message']")
	private WebElement successMessage;

	@FindBy(xpath = "//div[@ref='eCheckbox']//input")
	private WebElement colorwayCheckbox;

	public void filterColorwayName(String colorwayName, ExtentTest test) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(colorwayFilterField));
		colorwayFilterField.sendKeys(colorwayName);
		test.log(Status.INFO, "Filtered colorway name: " + colorwayName);
	}

	public void selectColorwayCheckbox(String colorwayName, ExtentTest test) throws Exception {

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", colorwayCheckbox);
	}

	public void clickSelectOption(ExtentTest test) throws Exception {

		Thread.sleep(3000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(selectButton));
		selectButton.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));
	}

	public void verifySuccessMessage(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		if (successMessage.isDisplayed()) {
			test.log(Status.INFO, "Verified success message: added successfully");
		} else {
			test.log(Status.FAIL, "Success message not displayed");
		}
	}

	public void select_ViewDropdown(String viewType) throws Exception {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(linesheetGrid));
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(viewDropDown));
		viewDropDown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(ViewTypeSearchBox));
		ViewTypeSearchBox.sendKeys(viewType);
		Thread.sleep(4000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchOption));
		searchOption.click();

	}

	public void filter_Colorway(String colorwayName, ExtentTest test) throws Exception {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductNameHeader));

		filterInput.clear();
		filterInput.sendKeys(colorwayName);
		Thread.sleep(3000);

	}
	}


