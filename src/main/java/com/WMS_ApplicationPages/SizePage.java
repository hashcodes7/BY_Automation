package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
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

public class SizePage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public SizePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//iframe[@id='contentframe']")
	public WebElement iframeContentframe;

	@FindBy(xpath = "//a[@id='FilterButton']//img[@align='absmiddle']")
	public WebElement createNewFilterIcon;

	@FindBy(xpath = "//input[@id='displayName']")
	public WebElement filterNameInput;

	@FindBy(xpath = "//a[normalize-space()='Create']")
	public WebElement createButton;

	@FindBy(xpath = "//input[@id='LCSCOLOR_ptc_str_3']")
	public WebElement textBoxLocator;

	@FindBy(xpath = "//a[normalize-space()='Create']")
	public WebElement addButtonLocator;

	@FindBy(xpath = "//a[normalize-space()='Update']")
	public WebElement updateButton;

	@FindBy(xpath = "//a[normalize-space()='Return']")
	public WebElement returnButton;

	@FindBy(xpath = "//select[@id='filterId']")
	public WebElement filtersDropdown;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	private WebElement newBtn;

	@FindBy(xpath = "//td[@class='REQUIRED']/following-sibling::td/child::input[1]")
	private WebElement dimensionNameField;

	@FindBy(xpath = "//td[contains(text(),'Code')]/following-sibling::td[1]/child::input")
	private WebElement dimensionCodeField;

	@FindBy(xpath = "//a[normalize-space()='Add']/following-sibling::input")
	private WebElement sizeField;

	@FindBy(xpath = "//td[@class='PAGEHEADINGTITLE']/following-sibling::td/child::a[1]")
	private WebElement saveButton;

	@FindBy(xpath = "//a[normalize-space()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//td[contains(text(),'Dimension Name')]/following-sibling::td[1]/child::input")
	private WebElement dimension_NameField;

	@FindBy(xpath = "//td[@class='REQUIRED']/following-sibling::td/child::input[1]")
	private WebElement sizeScaleNameField;

	@FindBy(xpath = "//td[contains(text(),'Column Abbreviation')]/following-sibling::td[1]/child::input")
	private WebElement columnAbbreviationField;

	@FindBy(xpath = "//a[normalize-space()='Column Dimension:']/following::div[1]/child::a")
	private WebElement columnDimensionField;

	@FindBy(xpath = "//td[contains(text(),'Column Name')]/following-sibling::td[1]/child::input")
	private WebElement columnNameField;

	@FindBy(xpath = "//td[contains(text(),'Size Scale Code')]/following-sibling::td[1]/child::input")
	private WebElement sizeScaleCodeField;

	@FindBy(xpath = "//td[contains(text(),'Row Abbreviation')]/following-sibling::td[1]/child::input")
	private WebElement rowAbbreviationField;

	@FindBy(xpath = "//td[contains(text(),'Row Name')]/following-sibling::td[1]/child::input")
	private WebElement rowNameField;

	@FindBy(xpath = "//td[contains(text(),'Description')]/following-sibling::td[1]/child::input")
	private WebElement descriptionField;

	@FindBy(xpath = "(//a[contains(text(),'Search')])[2]")
	private WebElement searchBtn;

	@FindBy(xpath = "(//a[contains(text(),'(choose)')])[1]")
	private WebElement optnSelect;

	@FindBy(xpath = "//input[@id='quickSearchInput']")
	private WebElement quickSearchInput;

	@FindBy(xpath = "//td[contains(text(),'Name')]/following-sibling::td[1]/child::input[1]")
	private WebElement nameInput;

	@FindBy(xpath = "//a[normalize-space()='Column Dimension:']")
	private WebElement ColumnDimensionLink;

	@FindBy(xpath = "//a[normalize-space()='Row Dimension:']")
	private WebElement rowDimensionLink;

	@FindBy(xpath = "//td[contains(text(),'Global Dimension')]/following-sibling::td[1]/child::input[2]")
	private WebElement globalDimensionField;

	@FindBy(xpath = "//td[contains(text(),'Code')]/following-sibling::td[1]/child::input")
	private WebElement codeField;

	@FindBy(xpath = "//td[contains(text(),'Sample Size')]/following-sibling::td[1]/child::input")
	private WebElement sampleSizeField;

	@FindBy(xpath = "//td[contains(text(),'Core/Seasonal?')]/following::select[1]")
	private WebElement coreOrSeasonalDropdown;

	@FindBy(xpath = "//td[contains(text(),'Size Grid Status')]/following::select[1]")
	private WebElement sizeGridStatusDropdown;

	@FindBy(xpath = "//a[normalize-space()='Size Scale:']")
	private WebElement sizeScaleLink;

	@FindBy(xpath = "//div[@class='tableDebuggerCls']/following::table/child::tbody")
	private WebElement sizeDimensionTable;

	@FindBy(xpath = "(//a[contains(text(),'Search')])[1]")
	private WebElement searchButton;

	@FindBy(xpath = "//td[contains(text(),'Actions:')]/child::select")
	private WebElement actionsDropdown;

	@FindBy(xpath = "//a[normalize-space()='Save']")
	private WebElement popupSaveButton;

	@FindBy(xpath = "//a[normalize-space()='Close']")
	private WebElement popupCloseButton;

	@FindBy(xpath = "//td[contains(text(),'Sizes')]/following-sibling::td")
	private WebElement sizeGridDetails;

	String currentTest;

	private boolean Capture;

	public void clikOnNewBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(newBtn));
		clickElement(newBtn);
	}

	public void enterDimensionName(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(dimensionNameField));
		clickElement(dimensionNameField);
		dimensionNameField.sendKeys(value);
		dimensionNameField.click();
		test.log(Status.INFO, "Entered Dimension Name: " + value);
		addSrceenShot("Entered Dimension Name", test, Capture);
	}

	public void enterDimensionCode(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(dimensionCodeField));
		clickElement(dimensionCodeField);
		dimensionCodeField.sendKeys(value);
		dimensionCodeField.click();
		test.log(Status.INFO, "Entered Dimension Code: " + value);
		addSrceenShot("Entered Dimension Code", test, Capture);
	}

	public void enterDimension_Name(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(dimension_NameField));
		clickElement(dimension_NameField);
		dimension_NameField.sendKeys(value);
		dimension_NameField.click();
		test.log(Status.INFO, "Entered Dimension Name: " + value);
		addSrceenShot("Entered Dimension Name", test, Capture);
	}

	public void addMultipleSizes(List<String> sizes, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		for (String size : sizes) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sizeField));
			clickElement(sizeField);
			sizeField.clear();
			sizeField.sendKeys(size);
			sizeField.click();
			test.log(Status.INFO, "Entered Size: " + size);
			addSrceenShot("Entered Size", test, Capture);

			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addButton));
			clickElement(addButton);
			test.log(Status.INFO, "Clicked Add button for Size: " + size);
			addSrceenShot("Clicked Add button", test, Capture);

			Thread.sleep(2000); // Wait for the size to be added
		}
	}

//	public void enterSize(String value, ExtentTest test) throws Exception {
//	    driver.switchTo().defaultContent();
//	    driver.switchTo().frame(iframeContentframe);
//	    new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sizeField));
//	    clickElement(sizeField);
//	    sizeField.sendKeys(value);
//	    sizeField.click();
//	    test.log(Status.INFO, "Entered Size: " + value);
//	    addSrceenShot("Entered Size", test, Capture);
//	}

	public void clickSaveBtn(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(saveButton));
		clickElement(saveButton);
		test.log(Status.INFO, "Clicked Save button");
		addSrceenShot("Clicked Save button", test, Capture);
	}

	public void enterSizeScaleName(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sizeScaleNameField));
		clickElement(sizeScaleNameField);
		sizeScaleNameField.sendKeys(value);
		sizeScaleNameField.click();
		test.log(Status.INFO, "Entered SizeScale Name: " + value);
		addSrceenShot("Entered SizeScale Name", test, Capture);
	}

	public void enterColumnAbbreviation(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(columnAbbreviationField));
		clickElement(columnAbbreviationField);
		columnAbbreviationField.sendKeys(value);
		columnAbbreviationField.click();
		test.log(Status.INFO, "Entered Column Abbreviation: " + value);
		addSrceenShot("Entered Column Abbreviation", test, Capture);
	}

	public void clickOnColumnDimension() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(ColumnDimensionLink));
		ColumnDimensionLink.click();

	}

	public void selectColumnDimension(String value, ExtentTest test) throws Exception {

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(value);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);

		driver.switchTo().window(ParentWinhadle);
		test.log(Status.INFO, "Selected Column Dimension: " + value);
		addSrceenShot("Selected Column Dimension", test, Capture);

	}

	public void selectRowDimension(String value, ExtentTest test) throws Exception {

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(value);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);

		driver.switchTo().window(ParentWinhadle);

	}

	public void enterColumnName(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(columnNameField));
		clickElement(columnNameField);
		columnNameField.sendKeys(value);
		columnNameField.click();
		test.log(Status.INFO, "Entered Column Name: " + value);
		addSrceenShot("Entered Column Name", test, Capture);
	}

	public void ClickOnGlobalDimension() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(globalDimensionField));
		globalDimensionField.click();

	}

	public void clickOnRowDimension() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(rowDimensionLink));
		rowDimensionLink.click();

	}

	public void enterSizeScaleCode(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sizeScaleCodeField));
		clickElement(sizeScaleCodeField);
		sizeScaleCodeField.sendKeys(value);
		sizeScaleCodeField.click();
		test.log(Status.INFO, "Entered Size Scale Code: " + value);
		addSrceenShot("Entered Size Scale Code", test, Capture);
	}

	public void enterRowAbbreviation(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(rowAbbreviationField));
		clickElement(rowAbbreviationField);
		rowAbbreviationField.sendKeys(value);
		rowAbbreviationField.click();
		test.log(Status.INFO, "Entered Row Abbreviation: " + value);
		addSrceenShot("Entered Row Abbreviation", test, Capture);
	}


	@FindBy(xpath = "//td[@id='name']")
	public WebElement newSizeDimentionName;
	

	public boolean verifySizeDimensionCreation(String dimensionName, ExtentTest test) throws Exception {
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(iframeContentframe);
	    try {
		    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(newSizeDimentionName));
		    Thread.sleep(2000);
	        boolean isPopulated = newSizeDimentionName.getText().equals(dimensionName);
	        if (isPopulated) {
	            System.out.println("Size Dimension ('" + dimensionName + "') Created");
	            test.log(Status.INFO, "Size Dimension ('" + dimensionName + "') created");
	            addSrceenShot("Size Dimension created", test, Capture);
	        } else {
	            System.out.println("Size Dimension Not Created");
	            test.log(Status.FAIL, "Size Dimension Not Created");
	            addSrceenShot("Size Dimension Not Created", test, Capture);
	        }
	        return isPopulated;
	    } catch (Exception e) {
	        System.out.println("Size Dimension Not Created");
	        test.log(Status.FAIL, "Size Dimension Not Created");
	        addSrceenShot("Size Dimension Not Created", test, Capture);
	        return false;
	    }
	}

	public boolean verifySizeScaleCreation(String sizeScaleName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
		    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(newSizeDimentionName));
		    Thread.sleep(2000);
	        boolean isPopulated = newSizeDimentionName.getText().equals(sizeScaleName);
	        if (isPopulated) {
	            System.out.println("New Size Scale ('" + sizeScaleName + "') Created");
	            test.log(Status.INFO, "New Size Scale ('" + sizeScaleName + "') created");
	            addSrceenShot("New Size Scale created", test, Capture);
	        } else {
	            System.out.println("New Size Scale Not Created");
	            test.log(Status.FAIL, "New Size Scale Not Created");
	            addSrceenShot("New Size Scale Not Created", test, Capture);
	        }
	        return isPopulated;
	    } catch (Exception e) {
	        System.out.println("Size Scale Not Created");
	        test.log(Status.FAIL, "Size Scale Not Created");
	        addSrceenShot("Size Scale Not Created", test, Capture);
	        return false;
	    }
	}

	public void enterRowName(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(rowNameField));
		clickElement(rowNameField);
		rowNameField.sendKeys(value);
		rowNameField.click();
		test.log(Status.INFO, "Entered Row Name: " + value);
		addSrceenShot("Entered Row Name", test, Capture);
	}

	public void enterDescription(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(descriptionField));
		clickElement(descriptionField);
		descriptionField.sendKeys(value);
		descriptionField.click();
		test.log(Status.INFO, "Entered Description: " + value);
		addSrceenShot("Entered Description", test, Capture);
	}

	public void enterSizeGridName(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sizeScaleNameField));
		clickElement(sizeScaleNameField);
		sizeScaleNameField.sendKeys(value);
		sizeScaleNameField.click();
		test.log(Status.INFO, "Entered SizeScale Name: " + value);
		addSrceenShot("Entered SizeScale Name", test, Capture);
	}

	public void enterCode(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(codeField));
		clickElement(codeField);
		codeField.sendKeys(value);
		codeField.click();
		test.log(Status.INFO, "Entered Code: " + value);
		addSrceenShot("Entered Code", test, Capture);
	}

	public void enterSampleSize(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sampleSizeField));
		clickElement(sampleSizeField);
		sampleSizeField.sendKeys(value);
		sampleSizeField.click();
		test.log(Status.INFO, "Entered Sample Size: " + value);
		addSrceenShot("Entered Sample Size", test, Capture);
	}

	public void selectCoreOrSeasonal(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(coreOrSeasonalDropdown));
		clickElement(coreOrSeasonalDropdown);
		Select dropdown = new Select(coreOrSeasonalDropdown);
		dropdown.selectByVisibleText(value);
		test.log(Status.INFO, "Selected Core/Seasonal: " + value);
		addSrceenShot("Selected Core/Seasonal", test, Capture);
	}

	public void clickOnSizeScale() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sizeScaleLink));
		sizeScaleLink.click();

	}

	public void selectSizeScale(String value, ExtentTest test) throws Exception {

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(value);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);

		driver.switchTo().window(ParentWinhadle);
		test.log(Status.INFO, "Selected Size Scale: " + value);
		addSrceenShot("Selected Size Scale", test, Capture);

	}

	public void selectSizeGridStatus(String value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sizeGridStatusDropdown));
		clickElement(sizeGridStatusDropdown);
		Select dropdown = new Select(sizeGridStatusDropdown);
		dropdown.selectByVisibleText(value);
		test.log(Status.INFO, "Selected Size Grid Status: " + value);
		addSrceenShot("Selected Size Grid Status", test, Capture);
	}

	public void viewAndUpdateSizeGrid(String actiondpdwnValue, String sizeGridName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(actionsDropdown));
		clickElement(actionsDropdown);
		Select dropdown = new Select(actionsDropdown);
		dropdown.selectByVisibleText(actiondpdwnValue);
		test.log(Status.PASS, "New Size Grid '" + sizeGridName + "' created successfully");
		test.log(Status.INFO, "Clicked on View / Update Size Grid in actions dropdown");
		addSrceenShot("Clicked on View / Update Size Grid in actions dropdown", test, Capture);

		// Switch to the new pop-up window
		String parentWindowHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// Perform actions in the new window
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
		WebElement sizeGridTable = driver.findElement(By.tagName("table"));
		List<WebElement> checkboxes = sizeGridTable.findElements(By.cssSelector("input[type='checkbox']"));
		List<String> selectedSizes = new ArrayList<>();
		for (int i = 0; i < 3 && i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			checkbox.click();
			String size = checkbox.getAttribute("name"); // Assuming the name attribute holds the size value
			selectedSizes.add(size);
			test.log(Status.INFO, "Selected size: " + size);
			addSrceenShot("Selected size: " + size, test, Capture);
		}
		test.log(Status.INFO, "Clicked on the first three checkboxes");
		addSrceenShot("Clicked on the first three checkboxes", test, Capture);

		// Scroll to the Save button and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popupSaveButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", popupSaveButton);
		test.log(Status.INFO, "Clicked on Save button");
		addSrceenShot("Clicked on Save button", test, Capture);

		// Scroll to the Close button and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popupCloseButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", popupCloseButton);
		test.log(Status.INFO, "Clicked on Close button");
		addSrceenShot("Clicked on Close button", test, Capture);

		driver.switchTo().window(parentWindowHandle);
		test.log(Status.INFO, "Closed pop-up and switched back to parent window");
		addSrceenShot("Closed pop-up and switched back to parent window", test, Capture);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		driver.findElement(By.xpath("//a[normalize-space()='Size Grid']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(sizeGridName);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchBtn.click();

		// Verify the selected sizes are populated correctly
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sizeGridDetails));
//		String sizeGridText = sizeGridDetails.getText();
		String sizeGridText = sizeGridDetails.getText();
		System.out.println("Extracted Size Grid Text: " + sizeGridText); // Debugging line
		test.log(Status.INFO, "Extracted Size Grid Text: " + sizeGridText);

		for (String size : selectedSizes) {
//		    String formattedSize = size.toLowerCase().trim().replace("0x", ""); // Adjust format if needed
			// Find the index of the first "X" and get the substring before it
			int index = size.indexOf("X");
			String firstPart = (index != -1) ? size.substring(0, index) : size;
			if (!sizeGridText.contains(firstPart)) {
				test.log(Status.FAIL, "Size " + size + " not found in sizes attribute");
				addSrceenShot("Size " + size + " not found in sizes attribute", test, Capture);
			} else {
				test.log(Status.PASS, "Size " + size + " found in sizes attribute");
				addSrceenShot("Size " + size + " found in Size sizes attribute", test, Capture);
			}
		}

		test.log(Status.PASS, "Sizes attribute showed sizes you selected on View/Update Size Grid page.");
		addSrceenShot("Sizes attribute validation log", test, Capture);
	}

//	for (String size : selectedSizes) {
//	    String formattedSize = size.toLowerCase().trim().replace("0x", ""); // Adjust format if needed
//		if (!sizeGridText.contains(formattedSize)) {
//			test.log(Status.FAIL, "Size " + size + " not found in sizes attribute");
//			addSrceenShot("Size " + size + " not found in sizes attribute", test, Capture);
//		} else {
//			test.log(Status.PASS, "Size " + size + " found in sizes attribute");
//			addSrceenShot("Size " + size + " found in Size sizes attribute", test, Capture);
//		}
//	}

	public void selectSizeDimension(String submenu) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" + ":" + submenu);
		driver.findElement(By.xpath("//a[normalize-space()='Size Dimension']")).click();
		/*
		 * clickElement("//label[@title='My Work']");
		 * clickElement("//label[@title='Season']");
		 */
		// click("//label[@title='" + menu + "']", menu);
	}

	public void selectSizeScale(String submenu) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" + ":" + submenu);
		driver.findElement(By.xpath("//a[normalize-space()='Size Scale']")).click();
		/*
		 * clickElement("//label[@title='My Work']");
		 * clickElement("//label[@title='Season']");
		 */
		// click("//label[@title='" + menu + "']", menu);
	}
}
//	public void enterName(String value, ExtentTest test) throws Exception {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(name));
//		clickElement(name);
//		name.sendKeys(value);
//		name.click();
//		test.log(Status.INFO, "Entered Name: " + value);
//		addSrceenShot("Entered Name", test, Capture);
//	}
//
//	public void clikOnCreateBtn(ExtentTest test) throws Exception {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(createBtn));
//		clickElement(createBtn);
//		test.log(Status.INFO, "Clicked on Create button");
//		addSrceenShot("Clicked on Create button", test, Capture);
//	}
//
//	public boolean isNewPalettePageDisplayed(ExtentTest test) {
//		try {
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame(iframeContentframe);
//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(newPalettePageElement));
//
//			String pageText = newPalettePageElement.getText();
//
//			test.log(Status.PASS, "New Palette Page is displayed with text: " + pageText);
//			addSrceenShot("New Palette Page is displayed", test, Capture);
//
//			return true;
//		} catch (Exception e) {
//			test.log(Status.FAIL, "New Palette Page is not displayed: " + e.getMessage());
//			addSrceenShot("New Palette Page is not displayed", test, Capture);
//			return false;
//		}
//	}
