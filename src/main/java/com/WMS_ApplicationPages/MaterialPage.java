package com.WMS_ApplicationPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
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

import com.PLM_Utilities.ExtentUtility;
import com.PLM_Utilities.ReadDataSheet;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

public class MaterialPage extends WMS_WebDriverUtilities {
	WebDriver driver;
	JavascriptExecutor js;

	public MaterialPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//iframe[@name='headerframe'")
	private WebElement iframeHeader;

	@FindBy(id = "siteNavLink")
	private WebElement siteLabel;

	@FindBy(xpath = "//iframe[@id='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//img[@title='Create New Material']")
	private WebElement createNewMaterialIcon;

	@FindBy(xpath = "//div[@class='scope-header'][normalize-space()='Material']/following::input[1]")
	private WebElement materialSearchField;

	@FindBy(xpath = "div[id='lscoMaterialCode']")
	private WebElement materialCode;

	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement actionsDropDown;

	@FindBy(xpath = "//li[@class='ui-menu-item']//a[@id='editMaterial']")
	private WebElement editMaterialOption;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[normalize-space()='Knits']")
	private WebElement fabrictypeOption;

	@FindBy(xpath = "//div[contains(text(), 'Fabric Type')]/following-sibling::div")
	// div[normalize-space()='* Fabric Type']/following-sibling::div
	private WebElement fabricTypeDropdown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement searchField;

	@FindBy(xpath = "//input[@role='searchbox']/following::li[@role='option']")
	private WebElement searchResult;

	@FindBy(xpath = "//div[contains(text(), 'Season First Introduced')]/following-sibling::div")
	private WebElement seasonFirstIntroducedDropdown;

	@FindBy(xpath = "//div[contains(text(),'Fabric Description')]/following-sibling::div")
	private WebElement fabricDescriptionSearchBox;

	@FindBy(xpath = "//div[contains(text(),'* Description')]/following-sibling::div/child::input")
	private WebElement finishRecipeDescriptionSearchBox;

	@FindBy(xpath = "// div[normalize-space()='* UOM']/following-sibling::div")
	private WebElement uomDropdown;

	@FindBy(xpath = "//div[@class='multi-select-outer']/child::select/child::option")
	private List<WebElement> options;

	@FindBy(xpath = "//div[@class='compositeWidget__choosen']/child::a")
	private WebElement removeButton;

	@FindBy(xpath = "//label[normalize-space()='Content']/following-sibling::div")
	private WebElement brandedContentDropdown;

	@FindBy(xpath = "//label[normalize-space()='Percentage']/following-sibling::input")
	private WebElement percentageSearchBox;

	@FindBy(xpath = "//label[normalize-space()='Percentage']/following-sibling::input")
	private WebElement percentageField;

	@FindBy(xpath = "//label[normalize-space()='Content']/following-sibling::a")
	private WebElement addButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[normalize-space()='Description']/following-sibling::div")
	private WebElement descriptionElement;

	@FindBy(xpath = "//div[normalize-space()='Sundry Description']/following-sibling::div")
	private WebElement sundryDescriptionElement;

	@FindBy(xpath = "//div[normalize-space()='Material Code']/following-sibling::div")
	private WebElement materialCodeElement;

	@FindBy(xpath = "//div[normalize-space()='Raymark Fiber Code']/following-sibling::div")
	private WebElement raymarkFiberCodeCodeElement;

	@FindBy(xpath = "//div[normalize-space()='Fabric Type']/following-sibling::div")
	private WebElement fabricType;

	@FindBy(xpath = "//div[normalize-space()='Fabric Type']/following-sibling::div")
	private WebElement fabricTypeInput;

	@FindBy(xpath = "//div[normalize-space()='Fabric Description']/following-sibling::div")
	private WebElement fabricDescription;

	@FindBy(xpath = "//div[normalize-space()='Fabric Description']/following-sibling::div")
	private WebElement fabricDescriptionInput;

	@FindBy(xpath = "//div[normalize-space()='Season First Introduced']/following-sibling::div")
	private WebElement seasonFirstIntroduced;

	@FindBy(xpath = "//div[normalize-space()='Season First Introduced']/following-sibling::div")
	private WebElement seasonFirstIntroducedInput;

	@FindBy(xpath = "//div[normalize-space()='UOM']/following-sibling::div")
	private WebElement uom;

	@FindBy(xpath = "//div[normalize-space()='UOM']/following-sibling::div")
	private WebElement uomInput;

	@FindBy(xpath = "//div[normalize-space()='Branded Content']/following-sibling::div")
	private WebElement brandedContentElement;

	@FindBy(xpath = "//div[normalize-space()='Generic Content']/following-sibling::div")
	private WebElement genericContentElement;

	@FindBy(xpath = "//div[contains(text(), 'Sundry Type')]/following-sibling::div")
	private WebElement sundryTypeDropDown;

	@FindBy(xpath = "//div[contains(text(), 'Sundry Sub-Type')]/following-sibling::div")
	private WebElement sundrySubTypeDropDown;

	@FindBy(xpath = "//div[contains(text(), 'Gender')]/following-sibling::div")
	private WebElement genderTypeDropDown;

	@FindBy(xpath = "//div[contains(text(),'Sundry Description')]/following-sibling::div")
	private WebElement sundryDescriptionSearchBox;

	@FindBy(xpath = "//div[contains(text(), 'Product Category')]/following-sibling::div")
	private WebElement productCategoryDropDown;

	@FindBy(xpath = "//div[contains(text(), 'Brand')]/following-sibling::div")
	private WebElement brandDropDown;

	@FindBy(xpath = "//div[@class='input-title-required'][normalize-space()='* Size']/following-sibling::div")
	// div[@class='input-title-required' and contains(text(),
	// 'Size')]/following-sibling::div
	private WebElement sizeSearchBox;

	@FindBy(xpath = "//div[contains(text(), 'Size UOM')]/following-sibling::div")
	private WebElement sizeUOMDropdown;

	@FindBy(xpath = "//span[normalize-space()='Clear Criteria']")
	private WebElement clearCriteria;

	@FindBy(xpath = "//span[normalize-space()='Reset Defaults']")
	private WebElement resetDefaults;

	@FindBy(xpath = "//div[@id='lscoContent']/div[2]")
	private WebElement contentElement;

	@FindBy(xpath = "//div[@id='navHeader']/a")
	private WebElement materialNameElement;

	@FindBy(xpath = "//div[normalize-space()='Fabric Description']/following-sibling::div")
	private WebElement fabricDescriptionElement;

	@FindBy(xpath = "//div[contains(text(),'Size Length')]/following-sibling::div/input")
	private WebElement sizeLengthSearchBox;

	@FindBy(xpath = "//div[contains(text(),'Size Width')]/following-sibling::div/input")
	private WebElement sizeWidthSearchBox;

	@FindBy(xpath = "//div[@class='dropdown menu-icon']/img")
	private WebElement edit;

	@FindBy(xpath = "//span[normalize-space()='Add...']")
	private WebElement addAction;

	@FindBy(xpath = "//span[normalize-space()='Add Suppliers']")
	private WebElement addSupplier;

	@FindBy(xpath = "(//*[text()='Search'])[1]")
	private WebElement supSearch;

	@FindBy(xpath = "(//*[@id='checkboxlist']//following::span)[1]")
	private WebElement supChoose;

	@FindBy(xpath = "(//*[text()='Select'])[1]")
	private WebElement supSelect;

	@FindBy(xpath = "(//*[@id='checkboxlist']//following::span//following::td[2]/a)[1]")
	private WebElement supName;

	@FindBy(xpath = "//*[@id='select2-supplierLinkId-container']")
	private WebElement supDropDown;

	@FindBy(xpath = "//*[@id='select2-supplierLinkId-results']//li[2]")
	private WebElement supValue1;

	@FindBy(xpath = "//a[contains(text(),'Fabric-Mill')]")
	private WebElement fabricMillLink;

	@FindBy(xpath = "//div[contains(text(),'Material Code')]/following::input[1]")
	private WebElement MaterailCodeInput;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement searchoptn;

	@FindBy(xpath = "(//a[contains(text(),'(choose)')])[1]")
	private WebElement optnSelect;

	@FindBy(xpath = "//iframe[@id='materiallibraryframe']")
	private WebElement iframeMateriallibraryframe;

	@FindBy(xpath = "//div[normalize-space()='Fabric-Mill']/following-sibling::div/a")
	private WebElement fabricMillValue;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	private boolean Capture;

	public void addSupplierToMaterial(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addAction)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addSupplier)).click();
			Thread.sleep(2000);
			String ParentWinhadle = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supSearch)).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supChoose)).click();
			Thread.sleep(3000);
			String addSupplier = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supName))
					.getText();
			System.out.println("supplier need to add is " + addSupplier);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supSelect)).click();
			Thread.sleep(3000);
			driver.switchTo().window(ParentWinhadle);

			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supDropDown)).click();
			Thread.sleep(5000);
			String addedSupplier = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supValue1))
					.getText();
			System.out.println("supplier added is " + addedSupplier);
			Assert.assertEquals(addSupplier, addedSupplier);
			test.log(Status.INFO, "supplier details added");
			System.out.println("supplier details are added to the material");
		} catch (Exception e) {
			System.out.println("supplier details are not added");
		}
	}

	public String getMaterial_Code(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialCodeElement));

		// Check if the material code element is displayed and contains a non-empty
		// value
		if (materialCodeElement.isDisplayed() && !materialCodeElement.getText().isEmpty()) {
			String materialCode = materialCodeElement.getText();
			System.out.println("Material code is updated correctly: " + materialCode);
			test.log(Status.PASS, "Material code is updated correctly: " + materialCode);
			addScreenShot("Material code is updated correctly", test, Capture);
			return materialCode;
		} else {
			System.out.println("Material code is not updated correctly.");
			test.log(Status.FAIL, "Material code is not updated correctly.");
			addScreenShot("Material code is not updated correctly", test, Capture);
			return null;
		}
	}

	public void selectFabricMill(String materialCode, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();

		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(fabricMillLink));

		fabricMillLink.click();

		String ParentWinhadle = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

		}

		driver.switchTo().defaultContent();

		driver.switchTo().frame(iframeMateriallibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailCodeInput));

		Thread.sleep(10000);

		clearCriteria.click();

		Thread.sleep(2000);

		resetDefaults.click();

		MaterailCodeInput.sendKeys(materialCode);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", searchButton);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));

		js.executeScript("arguments[0].click();", optnSelect);

		driver.switchTo().window(ParentWinhadle);

		test.log(Status.INFO, "Selected Fabric Mill");

		addScreenShot("Selected Fabric Mill", test, Capture);

	}

	public boolean isFabricCodeAssociatedWithLookFinish(String materialCode, ExtentTest test) {

		try {

			driver.switchTo().defaultContent();

			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(fabricMillValue));

			js.executeScript("arguments[0].scrollIntoView(true);", fabricMillValue);

			String associatedFabricCodes = fabricMillValue.getText();

			boolean isAssociated = associatedFabricCodes.contains(materialCode);

			if (isAssociated) {

				test.log(Status.PASS, "Fabric code is associated with Look Finish: " + associatedFabricCodes);

				addScreenShot("Fabric code association", test, Capture);

			} else {

				test.log(Status.FAIL, "Fabric code is not associated with Look Finish: " + associatedFabricCodes);

				addScreenShot("Fabric code association failed", test, Capture);

			}

			return isAssociated;

		} catch (Exception e) {

			test.log(Status.ERROR, "Error occurred while verifying fabric code association: " + e.getMessage());

			addScreenShot("Error in fabric code association", test, Capture);

			return false;

		}

	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void enterSizeLength(String sizeLength) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sizeLengthSearchBox));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeLengthSearchBox);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(sizeLengthSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE).perform();
		actions.moveToElement(sizeLengthSearchBox).click().sendKeys(sizeLength).build().perform();
	}

	public void enterSizeWidth(String sizeWidth) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sizeWidthSearchBox));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeWidthSearchBox);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(sizeWidthSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE).perform();
		actions.moveToElement(sizeWidthSearchBox).click().sendKeys(sizeWidth).build().perform();
	}

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

	public void selectMaterial(String submenu) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" + ":" + submenu);
		driver.findElement(By.xpath("//a[normalize-space()='Material']")).click();

	}

	public void chooseMaterial(String materialName) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialSearchField));
		Thread.sleep(5000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		Thread.sleep(2000);
		materialSearchField.sendKeys(materialName);
		System.out.println("Material Name: " + materialName);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchButton));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", searchButton);

	}

	public void clickOnEditMaterial() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(actionsDropDown));
		actionsDropDown.click();
		editMaterialOption.click();

	}

	public void createNewMaterial() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createNewMaterialIcon));
		createNewMaterialIcon.click();
	}

	public void chooseFabricType(String typeOfFabric) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabrictypeOption));
		WebElement option = driver.findElement(By.xpath("//a[normalize-space()='" + typeOfFabric.trim() + "']"));
		option.click();
	}

	public void chooseFinishRecipeType(String typeOfFinishRecipe) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabrictypeOption));
		WebElement option = driver.findElement(By.xpath("//a[normalize-space()='" + typeOfFinishRecipe.trim() + "']"));
		option.click();
	}

	public void chooseSundryType(String sundryType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabrictypeOption));
		WebElement option = driver.findElement(By.xpath("//a[normalize-space()='" + sundryType.trim() + "']"));
		option.click();
	}

	public void chooseSundryTypeValue(String sundryTypeValue) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sundryTypeDropDown));
		} catch (TimeoutException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", sundryTypeDropDown);
		}
		sundryTypeDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(sundryTypeValue);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();

	}

	public void chooseSundrySubTypeValue(String sundrySubTypeValue) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sundrySubTypeDropDown));
		} catch (TimeoutException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';",
					sundrySubTypeDropDown);
		}
		sundrySubTypeDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		Thread.sleep(2000);
		searchField.sendKeys(sundrySubTypeValue);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();

	}

	public void chooseGender(String genderType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(genderTypeDropDown));
		} catch (TimeoutException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", genderTypeDropDown);
		}
		genderTypeDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(genderType);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
	}

	public void enterSundryDescription(String sundryDescription) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sundryDescriptionSearchBox));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sundryDescriptionSearchBox);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(sundryDescriptionSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();

		actions.moveToElement(sundryDescriptionSearchBox).click().sendKeys(sundryDescription).build().perform();
	}

	public void chooseProductCategory(String ProductCategoryType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productCategoryDropDown));
		productCategoryDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(ProductCategoryType);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
	}

	public void chooseBrand(String brandType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandDropDown));
		brandDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(brandType);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
	}

	public void enterSize(String size, String sundryType, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

	    System.out.println("sundryType: '" + sundryType + "'"); // Debug statement

	    
	    if (sundryType.trim().equalsIgnoreCase("Packaging") || sundryType.trim().equalsIgnoreCase("Embellishments")) {
	        System.out.println("Skipping steps for sundryType: " + sundryType); // Debug statement
		} else {
			// Proceed with the steps
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(sizeSearchBox));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeSearchBox);
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(sizeSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).perform();
			actions.moveToElement(sizeSearchBox).click().sendKeys(size).build().perform();
			test.log(Status.INFO, "Entered/updated Size: " + size);
			addScreenShot("Entered/updated Size", test, Capture);
		}

	}

	public void enterFabricType(String fabricType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricTypeDropdown));
		fabricTypeDropdown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(fabricType);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
	}

	public void enterSeasonFirstIntroduced(String seasonFirstIntroduced) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonFirstIntroducedDropdown));
		seasonFirstIntroducedDropdown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(seasonFirstIntroduced);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
	}

	public void enterFabricDescription(String fabricDescription) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(fabricDescriptionSearchBox));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fabricDescriptionSearchBox);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(fabricDescriptionSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		actions.moveToElement(fabricDescriptionSearchBox).click().sendKeys(fabricDescription).build().perform();
	}

	public void enterFinishRecipeDescription(String finishRecipeDescription) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(finishRecipeDescriptionSearchBox));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				finishRecipeDescriptionSearchBox);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(finishRecipeDescriptionSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		actions.moveToElement(finishRecipeDescriptionSearchBox).click().sendKeys(finishRecipeDescription).build()
				.perform();
	}

	public void enterUOM(String uom) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(uomDropdown));
		} catch (TimeoutException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", uomDropdown);
		}
		uomDropdown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(uom);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
	}

	public void enterSize_Length(String sizeLength, String sundryType, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		if (sundryType.contains("Labels") || sundryType.contains("Packaging")) {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sizeLengthSearchBox));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeLengthSearchBox);
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(sizeLengthSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).perform();
			actions.moveToElement(sizeLengthSearchBox).click().sendKeys(sizeLength).build().perform();
			test.log(Status.INFO, "Entered/updated Size Length: " + sizeLength);
			addScreenShot("Entered Size Length: ", test, Capture);

		} else if (sundryType.equals(sundryType)) {
			Thread.sleep(1000);
		}
	}

	public void enterSize_Width(String sizeWidth, String sundryType, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		if (sundryType.contains("Labels") || sundryType.contains("Packaging")) {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sizeWidthSearchBox));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeWidthSearchBox);
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(sizeWidthSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.BACK_SPACE).perform();
			actions.moveToElement(sizeWidthSearchBox).click().sendKeys(sizeWidth).build().perform();
			test.log(Status.INFO, "Entered/updated Size Width: " + sizeWidth);
			addScreenShot("Entered Size Width: ", test, Capture);
		} else if (sundryType.equals(sundryType)) {
			Thread.sleep(1000);
		}
	}

	public void enterSizeUOM(String uom) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sizeUOMDropdown));
		sizeUOMDropdown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(uom);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();
	}

	public void removeChosenContents() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		while (!options.isEmpty()) {
			options.get(0).click();
			removeButton.click();
			// Refresh the list of options after each removal
			options = driver.findElements(By.xpath("//div[@class='multi-select-outer']/child::select/child::option"));
		}
	}

	public void enterBrandedContent(String brandedContent, String percentage) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandedContentDropdown));
		brandedContentDropdown.click();
		searchField.sendKeys(brandedContent);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(percentageSearchBox));
		percentageSearchBox.sendKeys(percentage);

		addButton.click();
	}

//	public void setFabricContent(String content, String percentage) throws Exception {
//	    driver.switchTo().defaultContent();
//	    driver.switchTo().frame(iframeContentframe);
//	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandedContentDropdown));
//	    brandedContentDropdown.click();
//	    WebElement searchField = driver.findElement(By.xpath("//input[@role='searchbox']"));
//	    searchField.sendKeys(content);
//	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='searchbox']/following::li")));
//	    driver.findElement(By.xpath("//input[@role='searchbox']/following::li")).click();
//	    
//	    WebElement percentageField = driver.findElement(By.xpath("//input[@name='percentage']"));
//	    percentageField.sendKeys(percentage);
//	    WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
//	    addButton.click();
//	}

	public void setFabricContent(Map<String, String> fabricContents, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		double totalPercentage = 0.0;

		for (Map.Entry<String, String> entry : fabricContents.entrySet()) {
			String content = entry.getKey();
			String percentage = entry.getValue();

			totalPercentage += Double.parseDouble(percentage);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandedContentDropdown));
			brandedContentDropdown.click();
			searchField.sendKeys(content);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
			searchResult.click();

			percentageField.clear();
			percentageField.sendKeys(percentage);
			System.out.println("Set Fabric Content: " + content + " with Percentage: " + percentage);
			test.log(Status.INFO, "Set Fabric Content: " + content + " with Percentage: " + percentage);
			WaitforPage(4000);
			addButton.click();
		}

		if (totalPercentage != 100.0) {
			throw new Exception(
					"Total percentage of fabric content must equal 100%. Current total: " + totalPercentage);
		}
	}

	public void setContents(Map<String, String> Contents, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		double totalPercentage = 0.0;

		for (Map.Entry<String, String> entry : Contents.entrySet()) {
			String content = entry.getKey();
			String percentage = entry.getValue();

			totalPercentage += Double.parseDouble(percentage);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandedContentDropdown));
			brandedContentDropdown.click();
			searchField.sendKeys(content);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchResult));
			searchResult.click();

			percentageField.clear();
			percentageField.sendKeys(percentage);
			System.out.println("Set Content: " + content + " with Percentage: " + percentage);
			test.log(Status.INFO, "Set Content: " + content + " with Percentage: " + percentage);
			WaitforPage(4000);
			addButton.click();
		}

		if (totalPercentage != 100.0) {
			throw new Exception("Total percentage of content must equal 100%. Current total: " + totalPercentage);
		}
	}

	public Map<String, Double> getBrandedContent(ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialNameElement));
		String actualMaterialName = materialNameElement.getText();
		test.log(Status.INFO, "Created Material name : " + actualMaterialName);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Map<String, Double> brandedContent = new HashMap<>();
		String[] contents = brandedContentElement.getText().split(", ");
		for (String content : contents) {
			String[] parts = content.split("% ");
			double percentage = Double.parseDouble(parts[0]);
			String type = parts[1];
			brandedContent.put(type, brandedContent.getOrDefault(type, 0.0) + percentage);
		}
		return brandedContent;
	}

	public Map<String, Double> getGenericContent() {
		Map<String, Double> genericContent = new HashMap<>();
		String[] contents = genericContentElement.getText().split(", ");
		for (String content : contents) {
			String[] parts = content.split("% ");
			double percentage = Double.parseDouble(parts[0]);
			String type = parts[1];
			genericContent.put(type, percentage);
		}
		return genericContent;
	}

	public void verifySortedGenericContent(Map<String, Double> genericContent, ExtentTest test) {
		List<Map.Entry<String, Double>> entries = new ArrayList<>(genericContent.entrySet());
		entries.sort(Map.Entry.comparingByKey());

		boolean isSorted = true;
		for (int i = 1; i < entries.size(); i++) {
			if (entries.get(i - 1).getKey().compareTo(entries.get(i).getKey()) > 0) {
				isSorted = false;
				break;
			}
		}

		if (isSorted) {
			test.log(Status.PASS, "Generic content values are sorted.");
			System.out.println("Generic content values are sorted.");
		} else {
			test.log(Status.FAIL, "Generic content values are not sorted.");
			System.out.println("Generic content values are not sorted.");
		}

		Assert.assertTrue(isSorted, "Generic content values are not sorted.");
	}

	public void saveMaterial() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();

	}

	public String getMaterialCode(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialNameElement));
		String actualMaterialName = materialNameElement.getText();
		test.log(Status.INFO, "Material name : " + actualMaterialName);
		System.out.println(actualMaterialName);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialCodeElement));

		String materialCode = materialCodeElement.getText();
		test.log(Status.INFO, "Material Code: " + materialCode);
		addScreenShot("Material Code", test, Capture);

		return materialCode;
//		return materialCodeElement.getText();
	}

	public String getRaymarkFiberCode(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(raymarkFiberCodeCodeElement));
		js.executeScript("arguments[0].scrollIntoView(true);", raymarkFiberCodeCodeElement);

		String raymarkFiberCode = raymarkFiberCodeCodeElement.getText();
		test.log(Status.INFO, "Raymark Fiber Code: " + raymarkFiberCode);
		addScreenShot("Raymark Fiber Code", test, Capture);

		return raymarkFiberCode;
//		return raymarkFiberCodeCodeElement.getText();
	}

	public boolean verifyMaterialUpdate(String fabricType, String seasonFirstIntroduced, String fabricDescription,
			String uom, ExtentTest test) {
		try {
			// Verify the updated attributes
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			js.executeScript("arguments[0].scrollIntoView(true);", fabricTypeInput);
			String displayedFabricType = fabricTypeInput.getText();
			test.log(Status.INFO, "Displayed Fabric Type: " + displayedFabricType);
			addScreenShot("Displayed Fabric Type", test, Capture);

			js.executeScript("arguments[0].scrollIntoView(true);", fabricDescriptionInput);
			String displayedFabricDescription = fabricDescriptionInput.getText();
			test.log(Status.INFO, "Displayed Fabric Description: " + displayedFabricDescription);
			addScreenShot("Displayed Fabric Description", test, Capture);

			js.executeScript("arguments[0].scrollIntoView(true);", seasonFirstIntroducedInput);
			String displayedSeasonFirstIntroduced = seasonFirstIntroducedInput.getText();
			test.log(Status.INFO, "Displayed Season First Introduced: " + displayedSeasonFirstIntroduced);
			addScreenShot("Displayed Season First Introduced", test, Capture);

			js.executeScript("arguments[0].scrollIntoView(true);", uomInput);
			String displayedUOM = uomInput.getText();
			test.log(Status.INFO, "Displayed UOM: " + displayedUOM);
			addScreenShot("Displayed UOM", test, Capture);

			boolean isUpdated = displayedFabricType.equals(fabricType)
					&& displayedSeasonFirstIntroduced.equals(seasonFirstIntroduced)
					&& displayedFabricDescription.equals(fabricDescription) && displayedUOM.equals(uom);

			if (isUpdated) {
				test.log(Status.PASS, "Material attributes updated successfully");
				addScreenShot("Material attributes updated successfully", test, Capture);
			} else {
				test.log(Status.FAIL, "Material attributes update failed");
				addScreenShot("Material attributes update failed", test, Capture);
			}

			return isUpdated;
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Element not found: " + e.getMessage());
			addScreenShot("Element not found", test, Capture);
			return false;
		}
	}

	public boolean isFinishRecordCreated(String finishRecipeDescription, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialNameElement));
		String actualMaterialName = materialNameElement.getText();
		test.log(Status.INFO, "created Material name: " + actualMaterialName);
		System.out.println(actualMaterialName);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(descriptionElement));
		js.executeScript("arguments[0].scrollIntoView(true);", descriptionElement);
		String actualDescription = descriptionElement.getText();

		boolean isCreated = actualDescription.equals(finishRecipeDescription);
		if (isCreated) {
			test.log(Status.PASS, "Finish record created with description: " + finishRecipeDescription);
			addScreenShot("Finish record created", test, Capture);
		} else {
			test.log(Status.FAIL, "Finish record not created with description: " + finishRecipeDescription);
			addScreenShot("Finish record not created", test, Capture);
		}

		return isCreated;

//		return actualDescription.equals(finishRecipeDescription);
	}

	public boolean isSundryRecordCreated(String sundryDescription, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialNameElement));
		String actualMaterialName = materialNameElement.getText();
		test.log(Status.INFO, "created Material name: " + actualMaterialName);
		System.out.println(actualMaterialName);

		try {

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sundryDescriptionElement));
			js.executeScript("arguments[0].scrollIntoView(true);", sundryDescriptionElement);

			String actualDescription = sundryDescriptionElement.getText();

			boolean isCreated = actualDescription.equals(sundryDescription);

			if (isCreated) {
				test.log(Status.PASS, "Sundry record created with description: " + sundryDescription);
				addScreenShot("Sundry record created", test, Capture);
			} else {
				test.log(Status.FAIL, "Sundry record not created with description: " + sundryDescription);
				addScreenShot("Sundry record not created", test, Capture);
			}

			return isCreated;
		} catch (Exception e) {
			test.log(Status.FAIL, "Error while verifying sundry record creation: " + e.getMessage());
			addScreenShot("Error while verifying sundry record creation", test, Capture);
			return false;
		}
//		return actualDescription.equals(sundryDescription);
	}

	public boolean isMaterialUpdated(String sundryDescription, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialNameElement));
		String actualMaterialName = materialNameElement.getText();
		test.log(Status.INFO, "Updated Sundry Material name: " + actualMaterialName);
		System.out.println(actualMaterialName);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sundryDescriptionElement));
		js.executeScript("arguments[0].scrollIntoView(true);", sundryDescriptionElement);

		String actualDescription = sundryDescriptionElement.getText();

		return actualDescription.equals(sundryDescription);
	}

	public boolean isMaterialCodeUpdated(ExtentTest test) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialCodeElement));

		// Check if the material code element is displayed and contains a non-empty
		// value
		if (materialCodeElement.isDisplayed() && !materialCodeElement.getText().isEmpty()) {
			String materialCode = materialCodeElement.getText();
			System.out.println("Material code is updated correctly: " + materialCode);
			test.log(Status.PASS, "Material code is updated correctly: " + materialCode);
			addScreenShot("Material code is updated correctly", test, Capture);
			return true;
		} else {
			System.out.println("Material code is not updated correctly.");
			test.log(Status.FAIL, "Material code is not updated correctly.");
			addScreenShot("Material code is not updated correctly", test, Capture);

			return false;
		}
	}

	public void verifySortedContents(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Locate the element containing the content values
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(contentElement));
		String contentText = contentElement.getText();
		System.out.println("Extracted Content Text: " + contentText);
		test.log(Status.INFO, "Extracted Content Text: " + contentText);

		// Split the content text into individual content items
		String[] contentItems = contentText.split(", ");

		// Create a list to store content and their percentages
		List<Double> percentages = new ArrayList<>();

		// Parse each content item and store the percentages in the list
		for (String item : contentItems) {
			String[] parts = item.split("% ");
			double percentage = Double.parseDouble(parts[0]);
			percentages.add(percentage);
		}

		// Check if the list is sorted in descending order
		boolean isSorted = true;
		for (int i = 0; i < percentages.size() - 1; i++) {
			if (percentages.get(i) < percentages.get(i + 1)) {
				isSorted = false;
				break;
			}
		}

		// Log the result
		if (isSorted) {
			System.out.println("Contents are sorted in descending order.");
			test.log(Status.PASS, "Contents are sorted in descending order.");
		} else {
			System.out.println("Contents are not sorted in descending order.");
			test.log(Status.FAIL, "Contents are not sorted in descending order.");
		}
	}

	public String getFabricType() {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricType));
		js.executeScript("arguments[0].scrollIntoView(true);", fabricType);

		return fabricType.getText();
	}

	public String getFabricDescription() {
		js.executeScript("arguments[0].scrollIntoView(true);", fabricDescription);

		return fabricDescription.getText();
	}

	public String getSeasonFirstIntroduced() {
		js.executeScript("arguments[0].scrollIntoView(true);", seasonFirstIntroduced);

		return seasonFirstIntroduced.getText();
	}

	public String getUOM() {
		js.executeScript("arguments[0].scrollIntoView(true);", uom);

		return uom.getText();
	}

	public boolean isMaterialCreated(String fabricDescription, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialNameElement));
		String actualMaterialName = materialNameElement.getText();
		test.log(Status.PASS, "Created Material Name: " + actualMaterialName);
		System.out.println(actualMaterialName);

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricDescriptionElement));
			js.executeScript("arguments[0].scrollIntoView(true);", fabricDescriptionElement);
			String actualDescription = fabricDescriptionElement.getText();
			System.out.println(actualDescription);

			boolean isCreated = actualDescription.equals(fabricDescription);

			if (isCreated) {
				test.log(Status.PASS, "Material created with description: " + actualMaterialName);
				System.out.println("Material created with description: " + actualMaterialName);
				addScreenShot("Sundry record created", test, Capture);
			} else {
				test.log(Status.FAIL, "Material is  not created with description: " + actualMaterialName);
				addScreenShot("Sundry record not created", test, Capture);
			}

			return isCreated;
		} catch (Exception e) {
			test.log(Status.FAIL, "Error while verifying Material creation: " + e.getMessage());
			addScreenShot("Error while verifying Material creation", test, Capture);
			return false;
		}
	}

//////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////

	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='Name']/following::input[1]")
	private WebElement nameSearchField;

	@FindBy(xpath = "(//td[contains(text(),'Name')])[1]/following::td[1]/input")
	private WebElement supNameInput;

	@FindBy(xpath = "//a[@id='SearchButton2']")
	private WebElement searchBtn2;

	@FindBy(xpath = "//div[contains(text(),'Supplier')]/following-sibling::div[1]")
	private WebElement supplierDropdown;

	@FindBy(xpath = "//div[contains(text(),'Material Color')]/following-sibling::div[1]")
	private WebElement materialColorDropdown;

	@FindBy(xpath = "//div[contains(text(),'Supplier')]/following-sibling::div/following::li")
	private WebElement supplierDropdownValues;

	@FindBy(xpath = "//div[@class='type-container-dropdown']//div[1]")
	private WebElement typeContainerdrpdown;

	@FindBy(xpath = "//div[@class='p-tree-filter-container ng-star-inserted']/input")
	private WebElement TextBox;

	@FindBy(xpath = "//div[contains(text(),'Name')]/following::input[1]")
	private WebElement MaterailNameInput;

	@FindBy(xpath = "//div[normalize-space()='Fabric-Mill']/following-sibling::div[1]")
	private WebElement fabricElement;

	@FindBy(xpath = "//div[normalize-space()='Primary Supplier']/following-sibling::div")
	private WebElement primaryIndicator;

	@FindBy(xpath = "//div[normalize-space()='Price UOM']/following-sibling::div")
	private WebElement priceUOM;

	@FindBy(xpath = "//div[normalize-space()='UOM']/following-sibling::div")
	private WebElement materialUOM;

	@FindBy(xpath = "//div[contains(text(),'Material Country of Origin')]/following-sibling::div")
	// div[normalize-space()='Material Country of Origin']/following-sibling::div
	private WebElement materialCountryOfOrigin;

	@FindBy(xpath = "//span[normalize-space()='Edit Material Supplier']")
	private WebElement editMaterialSupplier;

	@FindBy(xpath = "//div[contains(text(),'Material Country of Origin')]/following-sibling::div")
	// div[normalize-space()='Material Country of Origin']/following-sibling::div
	private WebElement materialCountryOfOrigin_Element;

	@FindBy(xpath = "//div[contains(text(),'Fabric Cuttable Width')]/following-sibling::div/input")
	private WebElement fabricCuttableWidth_Element;

	@FindBy(xpath = "//div[contains(text(),'Fabric Cuttable Width UOM')]/following-sibling::div")
	private WebElement fabricCuttableWidthUOM_Element;

	@FindBy(xpath = "//div[contains(text(),'Fabric Purchase Weight')]/following-sibling::div/input")
	private WebElement fabricPurchaseWeight_Element;

	@FindBy(xpath = "//div[contains(text(),'Fabric Purchase Weight UOM')]/following-sibling::div")
	private WebElement fabricPurchaseWeightUOM_Element;

	@FindBy(xpath = "//div[contains(text(),'Supplier Article No')]/following-sibling::div/input")
	private WebElement supplierArticleNo_Element;

	@FindBy(xpath = "//div[contains(text(),'UOM Conversion Factor')]/following-sibling::div/input")
	private WebElement uomConversionFactor_Element;

	@FindBy(xpath = "//div[contains(text(),'Supplier Description')]/following-sibling::div/input")
	private WebElement supplierDescription_Element;

	@FindBy(xpath = "//div[contains(text(),'Minimum Per Color UOM')]/following-sibling::div")
	private WebElement minimumPerColorUOM_Element;

	@FindBy(xpath = "//div[contains(text(),'Approval Date')]/following-sibling::div/input")
	private WebElement approvalDate_MMDDYYYY_Element;

	@FindBy(xpath = "//div[contains(text(),'Minimum Per Order UOM')]/following-sibling::div")
	private WebElement MinimumPerOrderUOM_Element;

	@FindBy(xpath = "//div[contains(text(),'Inco Terms')]/following-sibling::div")
	private WebElement IncoTerms_Element;

	@FindBy(xpath = "//div[contains(text(),'Test Results')]/following::div/textarea")
	private WebElement testResults_Element;

	@FindBy(xpath = "//div[contains(text(),'Physical Test Passed')]/following-sibling::div")
	private WebElement physicalTestPassed_Element;

	@FindBy(xpath = "//div[contains(text(),'Performance Test Pass')]/following-sibling::div")
	private WebElement performanceTestPass_Element;

	@FindBy(xpath = "//div[contains(text(),'Lab Test Report Number')]/following-sibling::div/input")
	private WebElement labTestReportNumber_Element;

	@FindBy(xpath = "//div[contains(text(),'Minimum Per Color')]/following-sibling::div/input")
	private WebElement minimumPerColor_Element;

	@FindBy(xpath = "//div[contains(text(),'Minimums Per Order')]/following-sibling::div/input")
	private WebElement minimumsPerOrder_Element;

	@FindBy(xpath = "//div[contains(text(),'Lead Time - Production Calendar days')]/following-sibling::div/input")
	private WebElement leadTimeProductionCalendardays_Element;

	@FindBy(xpath = "//div[contains(text(),'UOM Conversion Factor')]/following-sibling::div/input")
	private WebElement uomConversionFactorr_Element;

	@FindBy(xpath = "//div[contains(text(),'Lead Time - Sample Calendar days')]/following-sibling::div/input")
	private WebElement leadTimeSampleCalendardays_Element;

	@FindBy(xpath = "//div[contains(text(),'Material Price')]/following-sibling::div/input")
	private WebElement MaterialPrice_Element;

	@FindBy(xpath = "//div[contains(text(),'Price/Each')]/following-sibling::div")
	private WebElement priceEach_Element;

	@FindBy(xpath = "//div[normalize-space()='UOM']//following-sibling::div[1]")
	private WebElement uomElement;

	@FindBy(xpath = "//div[normalize-space()='Fabric-Mill']")
	private WebElement fabricMill_Attribute;

	@FindBy(xpath = "//div[@name='center']")
	private WebElement rowConainer;

	@FindBy(xpath = "//div[contains(text(),'Staging MaterialSupplier')]/following-sibling::div")
	private WebElement stagingRowIdElement;

	public void selectMaterialType(String materialType, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(typeContainerdrpdown));
		if (materialType.contains("Finish Recipe")) {
			Thread.sleep(1000);
		} else if (materialType.equals(materialType)) {
			Thread.sleep(1000);
			typeContainerdrpdown.click();
			Thread.sleep(3000);
			TextBox.sendKeys(materialType);
			Thread.sleep(3000);
			WebElement material_Type = driver.findElement(By.xpath("//span[contains(text(),'" + materialType + "')]"));
			material_Type.click();
			Thread.sleep(2000);
			typeContainerdrpdown.click();
			Thread.sleep(2000);
		}
	}

	public void searchMaterial(String materialName, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(nameSearchField));
		System.out.println("name search feild found");

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		nameSearchField.sendKeys(materialName);
		Thread.sleep(2000);
		System.out.println("Material Name: " + materialName);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", searchButton);

	}

	@FindBy(xpath = "//span[@class='ag-icon ag-icon-columns']")
	private WebElement columnIcon;

	@FindBy(xpath = "//div[@class='ag-column-select-header']//input[@type='checkbox']")
	private WebElement columnCheckBox;

	@FindBy(xpath = "//div[@class='ag-column-select-header']//input[@type='text']")
	private WebElement columnTextBox;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeftPanel;

	@FindBy(xpath = "//div[@id='pinbutton']")
	private WebElement pinbutton;

	public void clickOnMaterial(String materialName) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);
		if (driver.getTitle().equals("Material Search Criteria")) {

			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@name='center']")));
			WebElement material_Link = driver
					.findElement(By.xpath("(//div[@name='center']//a[normalize-space()='" + materialName + "'])"));
			material_Link.click();
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().window(tabs.get(0)).close();
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(3000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeLeftPanel);
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pinbutton));
			clickElement(pinbutton);

		} else if (materialName.equals(materialName)) {
			Thread.sleep(2000);
		}
	}

	public void addSupplier(String supplier, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addAction)).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(addSupplier)).click();
			Thread.sleep(2000);
			String ParentWinhadle = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(supNameInput));
			supNameInput.sendKeys(supplier);
			Thread.sleep(5000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchBtn2)).click();
			Thread.sleep(10000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(supChoose));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", supChoose);
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(supSelect)).click();
			test.log(Status.INFO, "supplier was selected: " + supplier);
			addScreenShot("supplier was selected", test, Capture);
			System.out.println("supplier details are added to the material");
			Thread.sleep(3000);
			driver.switchTo().window(ParentWinhadle);
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println("supplier details are not added");
		}
	}

	public boolean verifySupplierInDropdown(String supplier, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supplierDropdown));
			supplierDropdown.click();
			test.log(Status.INFO, "Supplier dropdown values are visible");
			addScreenShot("Supplier dropdown values are visible", test, Capture);
			Thread.sleep(3000);

			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supplierDropdownValues));
			List<WebElement> options = driver
					.findElements(By.xpath("//div[contains(text(),'Supplier')]/following-sibling::div/following::li"));

			for (WebElement option : options) {
				if (option.getText().contains(supplier)) {
					test.log(Status.INFO, "Supplier found in dropdown: " + supplier);
					addScreenShot("Supplier found in dropdown", test, Capture);
					option.click();
					test.log(Status.INFO, "Supplier was selected fromin dropdown: " + supplier);
					return true;
				}
			}
			test.log(Status.FAIL, "Supplier not found in dropdown: " + supplier);
			addScreenShot("Supplier not found in dropdown", test, Capture);
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Supplier dropdown not found or interrupted: " + e.getMessage());
			addScreenShot("Supplier dropdown not found or interrupted", test, Capture);
		}
		return false;
	}

	public boolean verifyNoColorInDropdown(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(materialColorDropdown));
			materialColorDropdown.click();
			test.log(Status.INFO, "Clicked on Material color dropdown");
			addScreenShot("Clicked on Material color dropdown", test, Capture);
			Thread.sleep(3000);

			test.log(Status.INFO, "Material color dropdown values are visible");
			addScreenShot("Material color dropdown values are visible", test, Capture);

			List<WebElement> options = driver.findElements(
					By.xpath("//div[contains(text(),'Material Color')]/following-sibling::div/following::li"));

			// Iterate through the options to check if 'No color' is present
			for (WebElement option : options) {
				if (option.getText().contains("No Color")) {
					test.log(Status.INFO, "'No color' found in Material color dropdown");
					addScreenShot("'No color' found in Material color dropdown", test, Capture);
					return true;
				}
			}
			test.log(Status.FAIL, "'No color' not found in Material color dropdown");
			addScreenShot("'No color' not found in Material color dropdown", test, Capture);
		} catch (NoSuchElementException | InterruptedException e) {
			test.log(Status.FAIL, "Material color dropdown not found or interrupted: " + e.getMessage());
			addScreenShot("Material color dropdown not found or interrupted", test, Capture);
		}
		return false;
	}

	public void selectFabric_Mill(String fabric, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(fabricMillLink));
		fabricMillLink.click();

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		MaterailNameInput.sendKeys(fabric);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		driver.switchTo().window(ParentWinhadle);

		test.log(Status.INFO, "Selected Fabric Mill");
		addScreenShot("Selected Fabric Mill", test, Capture);

	}

	public void validateFabricInGeneralAttributes(String fabric, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(materialColorDropdown));
			test.log(Status.INFO, "Located General Attributes section");

			// Extract the fabric name from the General Attributes section
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(fabricElement));
			String actualFabricName = fabricElement.getText();
			test.log(Status.INFO, "Extracted fabric name: " + actualFabricName);

			// Compare the extracted fabric name with the expected fabric name
			if (actualFabricName.contains(fabric)) {
				test.log(Status.PASS, "Fabric found in General Attributes section: " + actualFabricName);
				System.out.println("Fabric found in General Attributes section: " + actualFabricName);
			} else {
				test.log(Status.FAIL, "Validation: Fabric not found in General Attributes section. Expected: " + fabric
						+ ", but found: " + actualFabricName);
				System.out.println("Fabric not found in General Attributes section. Expected: " + fabric
						+ ", but found: " + actualFabricName);
			}
		} catch (Exception e) {
			test.log(Status.FAIL,
					"Exception occurred while validating fabric in General Attributes section: " + e.getMessage());
			System.out.println(
					"Exception occurred while validating fabric in General Attributes section: " + e.getMessage());
		}
	}

	public boolean verifyPrimaryIndicatorSet(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(primaryIndicator));
			String primaryIndicatorValue = primaryIndicator.getText();
			if (primaryIndicatorValue.equals("Yes")) {
				test.log(Status.INFO,
						"Primary indicator on Material supplier is set to Yes for first Supplier added to Material: "
								+ primaryIndicatorValue);
				addScreenShot(
						"Primary indicator on Material supplier is set to Yes for first Supplier added to Material",
						test, Capture);
				return true;
			} else {
				test.log(Status.FAIL,
						"Primary indicator on Material supplier is not set to Yes for first Supplier added to Material.");
				addScreenShot(
						"Primary indicator on Material supplier is not set to Yes for first Supplier added to Material",
						test, Capture);
			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Primary indicator attribute not found or interrupted: " + e.getMessage());
			addScreenShot("Primary indicator attribute not found or interrupted", test, Capture);
		}
		return false;
	}

	public boolean verifyPriceUOMUpdated(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(priceUOM));
			String priceUOMValue = priceUOM.getText();
			String expectedUOM = materialUOM.getText();
			if (priceUOMValue.equals(expectedUOM)) {
				test.log(Status.INFO, "Price UOM - '" + priceUOMValue
						+ "'on Material Supplier is updated from UOM attribute on Material - '" + expectedUOM + "'");
				addScreenShot("Price UOM on Material Supplier is updated from UOM attribute on Material", test,
						Capture);
				return true;
			} else {
				test.log(Status.FAIL, "Price UOM on Material Supplier is not updated from UOM attribute on Material.");
				addScreenShot("Price UOM on Material Supplier is not updated from UOM attribute on Material", test,
						Capture);
			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Price UOM attribute not found or interrupted: " + e.getMessage());
			addScreenShot("Price UOM attribute not found or interrupted", test, Capture);
		}
		return false;
	}

	public boolean verifyStagingRowIdUpdated(String supplier, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			if (stagingRowIdElement.isDisplayed()) {
				boolean isUpdated = false;
				for (int i = 0; i < 6; i++) {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(iframeLeft);
					new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(materialNameElement))
							.click();
					driver.switchTo().defaultContent();
					driver.switchTo().frame(iframeContentframe);
					new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supplierDropdown)).click();
					new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supplierDropdownValues));
					List<WebElement> options = driver.findElements(
							By.xpath("//div[contains(text(),'Supplier')]/following-sibling::div/following::li"));

					for (WebElement option : options) {
						if (option.getText().contains(supplier)) {
							option.click();
							break;
						}
					}

					Thread.sleep(10000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame(iframeContentframe);

					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							stagingRowIdElement);
					String stagingRowIdValue = stagingRowIdElement.getText();

					if (!stagingRowIdValue.isEmpty() && !stagingRowIdValue.equals("0")) {
						test.log(Status.INFO,
								"Material supplier staging row id is updated on the Material Supplier Details Page: "
										+ stagingRowIdValue);
						addScreenShot(
								"Material supplier staging row id is updated on the Material Supplier Details Page",
								test, Capture);
						isUpdated = true;
						break;
					}
				}

				if (!isUpdated) {
					test.log(Status.INFO,
							"Material supplier staging row id is not updated on the Material Supplier Details Page");
					addScreenShot(
							"Material supplier staging row id is not updated on the Material Supplier Details Page",
							test, Capture);
				}
			} else {
				test.log(Status.INFO,
						"Material supplier staging row id is not updated on the Material Supplier Details Page in PDS.");
				addScreenShot(
						"Material supplier staging row id is not updated on the Material Supplier Details Page in PDS",
						test, Capture);
			}
		} catch (NoSuchElementException e) {
			test.log(Status.ERROR, "Element not found: " + e.getMessage());
		}
		return false;
	}

//		try {
//			if (stagingRowIdElement.isDisplayed()) {
//				for (int i = 0; i < 6; i++) {
//				    driver.switchTo().defaultContent();
//				    driver.switchTo().frame(iframeLeft);
//				    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(materialNameElement)).click();
//				    driver.switchTo().defaultContent();
//				    driver.switchTo().frame(iframeContentframe);
//				    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supplierDropdown));
//				    Thread.sleep(10000);
//				}
//				driver.switchTo().defaultContent();
//			    driver.switchTo().frame(iframeContentframe);
//			    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supplierDropdown)).click();
//				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(supplierDropdownValues));
//				List<WebElement> options = driver
//						.findElements(By.xpath("//div[contains(text(),'Supplier')]/following-sibling::div/following::li"));
//
//				for (WebElement option : options) {
//					if (option.getText().contains(supplier)) {
//						option.click();
//					}
//				}
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stagingRowIdElement);
//				String stagingRowIdValue = stagingRowIdElement.getText();
//				if (!stagingRowIdValue.isEmpty() && !stagingRowIdValue.equals("0")) {
//					test.log(Status.INFO,
//							"Material supplier staging row id is updated on the Material Supplier Details Page: "
//									+ stagingRowIdValue);
//					addScreenShot("Material supplier staging row id is updated on the Material Supplier Details Page",
//							test, Capture);
//					return true;
//				} else {
//					test.log(Status.INFO,
//							"Material supplier staging row id is not updated on the Material Supplier Details Page");
//					addScreenShot(
//							"Material supplier staging row id is not updated on the Material Supplier Details Page",
//							test, Capture);
//				}
//			} else {
//				test.log(Status.INFO,
//						"Material supplier staging row id is not updated on the Material Supplier Details Page in PDS.");
//				addScreenShot(
//						"Material supplier staging row id is not updated on the Material Supplier Details Page in PDS",
//						test, Capture);
//			}
//		} catch (NoSuchElementException e) {
//		}
//		return false;
//	}

	public boolean verifyCountryOfOriginUpdated(String supplier, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(materialCountryOfOrigin));
			String countryCode = supplier.substring(supplier.length() - 2);
			String countryOfOrigin = materialCountryOfOrigin.getText();

			if (!countryOfOrigin.isEmpty()) {
				test.log(Status.PASS, "Material Country of Origin attribute is correctly updated.");
				test.log(Status.INFO, "Material Country of Origin - " + countryOfOrigin
						+ " attribute is updated from Country Name attribute on Supplier - " + countryCode);
				addScreenShot("Material Country of Origin attribute is correctly updated", test, Capture);
				return true;
			} else {
				test.log(Status.FAIL, "Material Country of Origin attribute is not correctly updated.");
				test.log(Status.INFO, "Material Country of Origin - " + countryOfOrigin
						+ " attribute is not updated from Country Name attribute on Supplier - " + countryCode);
				addScreenShot("Material Country of Origin attribute is not correctly updated", test, Capture);
			}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Material Country of Origin attribute not found or interrupted: " + e.getMessage());
			addScreenShot("Material Country of Origin attribute not found or interrupted", test, Capture);
		}
		return false;
	}

	public String extractUOMFromMaterialPage() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		String uomElement_Value = "";

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(uomElement));
			uomElement_Value = uomElement.getText();
		} catch (NoSuchElementException e) {
		}
		return uomElement_Value;
	}

	public void updateMaterialSupplier(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(actionsDropDown));
			actionsDropDown.click();
			editMaterialSupplier.click();
			test.log(Status.INFO, "Update Material/Supplier button clicked");
			addScreenShot("Update Material/Supplier button clicked", test, Capture);
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Update Material/Supplier button not found or interrupted: " + e.getMessage());
			addScreenShot("Update Material/Supplier button not found or interrupted", test, Capture);
		}

	}

	public void enterMaterialSupplierAttributes(String materialCountryOfOrigin, String fabricCuttableWidth,
			String fabricCuttableWidthUOM, String supplierArticleNo, String uomConversionFactor,
			String fabricPurchaseWeight, String fabricPurchaseWeightUOM, String materialPageUOM, ExtentTest test)
			throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			if (isElementPresent(materialCountryOfOrigin_Element)) {
				materialCountryOfOrigin_Element.click();
				Thread.sleep(2000);
				searchField.sendKeys(materialCountryOfOrigin);
				Thread.sleep(5000);
				searchResult.click();
				Thread.sleep(2000);
			}

		} catch (Exception e) {
		}

		try {
			if (isElementPresent(fabricCuttableWidth_Element)) {
				fabricCuttableWidth_Element.clear();
				fabricCuttableWidth_Element.sendKeys(fabricCuttableWidth);
				Thread.sleep(2000);
				test.log(Status.INFO, "Entered fabricCuttableWidth: " + fabricCuttableWidth);

			}
		} catch (Exception e) {
		}

		try {
			if (isElementPresent(fabricCuttableWidthUOM_Element)) {
				fabricCuttableWidthUOM_Element.click();
				Thread.sleep(2000);
				searchField.sendKeys(fabricCuttableWidthUOM);
				Thread.sleep(5000);
				searchResult.click();
				Thread.sleep(2000);

			}
		} catch (Exception e) {
		}

		try {
			if (isElementPresent(supplierArticleNo_Element)) {
				supplierArticleNo_Element.clear();
				supplierArticleNo_Element.sendKeys(supplierArticleNo);
				Thread.sleep(2000);
				test.log(Status.INFO, "Entered supplierArticleNo: " + supplierArticleNo);
			}
		} catch (Exception e) {
		}

		try {
			if (isElementPresent(uomConversionFactor_Element)) {
				uomConversionFactor_Element.clear();
				uomConversionFactor_Element.sendKeys(uomConversionFactor);
				Thread.sleep(2000);
				test.log(Status.INFO, "Entered uomConversionFactor: " + uomConversionFactor);
			}
		} catch (Exception e) {
		}

		try {
			if (isElementPresent(fabricPurchaseWeight_Element)) {
				fabricPurchaseWeight_Element.clear();
				fabricPurchaseWeight_Element.sendKeys(fabricPurchaseWeight);
				Thread.sleep(2000);
				test.log(Status.INFO, "Entered fabricPurchaseWeight: " + fabricPurchaseWeight);
			}
		} catch (Exception e) {
		}

		try {
			if (isElementPresent(fabricPurchaseWeightUOM_Element)) {
				fabricPurchaseWeightUOM_Element.click();
				Thread.sleep(2000);
				searchField.sendKeys(fabricPurchaseWeightUOM);
				Thread.sleep(5000);
				searchResult.click();
				Thread.sleep(2000);
				test.log(Status.INFO, "Entered fabricPurchaseWeightUOM: " + fabricPurchaseWeightUOM);
			}
		} catch (Exception e) {
		}

		try {

			String priceUOM_Value = priceUOM.getText();
			if (priceUOM_Value.equals(materialPageUOM)) {
				test.log(Status.PASS, "Price UOM matches the UOM on Material page: " + priceUOM_Value);
			}
		} catch (Exception e) {
		}

		test.log(Status.INFO, "Entered data for all material/supplier level attributes");
		addScreenShot("Entered data for all material/supplier level attributes", test, Capture);

	}

	private boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void selectFabricMillForFinishRecipeMaterial(String fabricMill, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			if (isElementPresent(fabricMill_Attribute)) {
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(actionsDropDown));
				actionsDropDown.click();
				editMaterialOption.click();
				test.log(Status.INFO, "Update Material button clicked");
				addScreenShot("Update Material button clicked", test, Capture);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricMillLink));
				fabricMillLink.click();
				String ParentWinhadle = driver.getWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}

				driver.switchTo().defaultContent();
				driver.switchTo().frame(iframeMateriallibraryframe);
				new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
				Thread.sleep(5000);
				clearCriteria.click();
				Thread.sleep(2000);
				resetDefaults.click();
				MaterailNameInput.sendKeys(fabricMill);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", searchButton);
				new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
				js.executeScript("arguments[0].click();", optnSelect);
				driver.switchTo().window(ParentWinhadle);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(iframeContentframe);
				Thread.sleep(2000);
				test.log(Status.INFO, "Selected Fabric Mill: " + fabricMill);
				addScreenShot("Selected Fabric Mill", test, Capture);
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(saveButton));
				saveButton.click();
			}
		} catch (Exception e) {
		}
	}

	public void enterMaterialSupplierAttributesSundries(String supplierArticleNo, String supplierDescription,
			String minimumPerColorUOM, String approvalDate_MMDDYYYY, String MinimumPerOrderUOM,
			String materialCountryOfOrigin, String IncoTerms, String testResults, String labTestReportNumber,
			String physicalTestPassed, String minimumPerColor, String performanceTestPass, String minimumsPerOrder,
			String leadTimeProductionCalendardays, String uomConversionFactor, String leadTimeSampleCalendardays,
			String MaterialPrice, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialCountryOfOrigin_Element));

			Thread.sleep(2000);
			supplierArticleNo_Element.clear();
			supplierArticleNo_Element.sendKeys(supplierArticleNo);
			Thread.sleep(1000);
			supplierDescription_Element.clear();
			supplierDescription_Element.sendKeys(supplierDescription);
			Thread.sleep(1000);
			minimumPerColorUOM_Element.click();
			Thread.sleep(2000);
			searchField.sendKeys(minimumPerColorUOM);
			System.out.println("minimumPerColorUOM " + minimumPerColorUOM);
			Thread.sleep(5000);
			searchResult.click();
			System.out.println("minimumPerColorUOM " + minimumPerColorUOM);
			Thread.sleep(2000);
			approvalDate_MMDDYYYY_Element.clear();
			approvalDate_MMDDYYYY_Element.sendKeys(approvalDate_MMDDYYYY);
			System.out.println(2000);
			MinimumPerOrderUOM_Element.click();
			System.out.println("minimumPerOrderUOM " + MinimumPerOrderUOM);
			Thread.sleep(2000);
			searchField.sendKeys(MinimumPerOrderUOM);
			Thread.sleep(5000);
			searchResult.click();
			System.out.println("minimumPerOrderUOM " + MinimumPerOrderUOM);
			Thread.sleep(2000);
			materialCountryOfOrigin_Element.click();
			Thread.sleep(2000);
			searchField.sendKeys(materialCountryOfOrigin);
			Thread.sleep(5000);
			searchResult.click();
			Thread.sleep(2000);
			IncoTerms_Element.click();
			Thread.sleep(2000);
			searchField.sendKeys(IncoTerms);
			Thread.sleep(5000);
			searchResult.click();
			Thread.sleep(2000);
			System.out.println("IncoTerms" + IncoTerms);
			testResults_Element.clear();
			testResults_Element.sendKeys(testResults);
			System.out.println("testResults" + testResults);
			Thread.sleep(2000);
			labTestReportNumber_Element.clear();
			labTestReportNumber_Element.sendKeys(labTestReportNumber);
			Thread.sleep(2000);
			physicalTestPassed_Element.click();
			Thread.sleep(2000);
			WebElement option = driver
					.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + physicalTestPassed + "']"));
			option.click();
			Thread.sleep(2000);
			minimumPerColor_Element.clear();
			minimumPerColor_Element.sendKeys(minimumPerColor);
			Thread.sleep(2000);
			performanceTestPass_Element.click();
			Thread.sleep(2000);
			WebElement option1 = driver
					.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + performanceTestPass + "']"));
			option1.click();
			Thread.sleep(2000);
			minimumsPerOrder_Element.clear();
			minimumsPerOrder_Element.sendKeys(minimumsPerOrder);
			Thread.sleep(1000);
			leadTimeProductionCalendardays_Element.clear();
			leadTimeProductionCalendardays_Element.sendKeys(leadTimeProductionCalendardays);
			Thread.sleep(1000);
			uomConversionFactor_Element.clear();
			uomConversionFactor_Element.sendKeys(uomConversionFactor);
			Thread.sleep(1000);
			leadTimeSampleCalendardays_Element.clear();
			leadTimeSampleCalendardays_Element.sendKeys(leadTimeSampleCalendardays);

			Thread.sleep(1000);
			MaterialPrice_Element.clear();
			MaterialPrice_Element.sendKeys(MaterialPrice);
			Thread.sleep(2000);

			test.log(Status.INFO, "Entered data for all material/supplier level attributes: Supplier Article No - "
					+ supplierArticleNo + ", Supplier Description - " + supplierDescription
					+ ", Minimum Per Color UOM - " + minimumPerColorUOM + ", Approval Date_MM/DD/YYYY - "
					+ approvalDate_MMDDYYYY + ", Minimum Per Order UOM - " + MinimumPerOrderUOM
					+ ", Material Country Of Origin - " + materialCountryOfOrigin + ", IncoTerms - " + IncoTerms
					+ ", Test Results - " + testResults + ", Lab Test Report Number - " + labTestReportNumber
					+ ", Physical Test Passed - " + physicalTestPassed + ", Minimum Per Color - " + minimumPerColor
					+ ", Performance Test Pass - " + performanceTestPass + ", Minimums Per Order - " + minimumsPerOrder
					+ ", Lead Time Production Calendar Days - " + leadTimeProductionCalendardays
					+ ", UOM Conversion Factor - " + uomConversionFactor + ", Lead Time Sample Calendar Days - "
					+ leadTimeSampleCalendardays + ", Material Price - " + MaterialPrice);

//	        test.log(Status.INFO, "Entered data for all material/supplier level attributes");
			addScreenShot("Entered data for all material/supplier level attributes", test, Capture);
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Material/Supplier attributes not found or interrupted: " + e.getMessage());
			addScreenShot("Material/Supplier attributes not found or interrupted", test, Capture);
		}
	}

	public void validateMaterialSupplierInformationAndPrice(String materialCountryOfOrigin, String MaterialPrice,
			ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialCountryOfOrigin_Element));
			String actualmaterialCountryOfOrigin = materialCountryOfOrigin_Element.getText();
			Assert.assertEquals(actualmaterialCountryOfOrigin, materialCountryOfOrigin,
					"Material Country Of Origin name does not match!");

			System.out.println("Material Supplier Information is saved successfully");
			test.log(Status.PASS, "Verification: Material Supplier Information is saved successfully");
			addScreenShot("Material Supplier Information is saved successfully", test, Capture);

			String actualPriceEach = priceEach_Element.getText();
			Assert.assertTrue(actualPriceEach.contains(MaterialPrice),
					"Price /Each attribute does not contain the expected value!");

			System.out.println(
					"Price /Each attribute is calculated(Auto-updated) as the Material Price Entered mutliplied with  UOM Conversion Factor defined in the Look up table: "
							+ actualmaterialCountryOfOrigin);
			test.log(Status.PASS,
					"Verification: Price /Each attribute is calculated(Auto-updated) as the Material Price Entered mutliplied with  UOM Conversion Factor defined in the Look up table: "
							+ actualmaterialCountryOfOrigin);
			addScreenShot("Price /Each attribute is calculated (auto-updated) correctly", test, Capture);

		} catch (Exception e) {
			System.out.println("Validation failed: " + e.getMessage());
			test.log(Status.FAIL, "Validation failed: " + e.getMessage());
			addScreenShot("Validation failed", test, Capture);
			throw e;
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "(//a[contains(text(),'Colors')])[1]")
	private WebElement ColorsTabFeild;

	public void selectColorsTab() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ColorsTabFeild));
		ColorsTabFeild.click();
	}

	@FindBy(xpath = "//td/span[@class='LABEL']/following-sibling::select")
	private WebElement Actionsdropdown;

	public void action_DropDown(String actionvalue) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Actionsdropdown));
		Select select = new Select(Actionsdropdown);
		select.selectByVisibleText(actionvalue);

	}

	@FindBy(xpath = "//td[contains(text(),'Choose a Type')]")
	private WebElement chooseType;

	public void chooseColorType(String colorType) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(chooseType));
		WebElement option = driver.findElement(By.xpath("//a[normalize-space()='" + colorType.trim() + "']"));
		option.click();
	}

	@FindBy(xpath = "//td[contains(text(),'*Name')]/following::input[1]")
	private WebElement color_Name;

	@FindBy(xpath = "//td[contains(text(),'LS&Co. Color Name')]/following::input[1]")
	private WebElement LSAndCo_ColorName;

	@FindBy(xpath = "//td[contains(text(),'Color Family')]/following::select[1]")
	private WebElement color_Family;

	@FindBy(xpath = "//td[contains(text(),'Color Status')]/following::select[1]")
	private WebElement color_Status;

	@FindBy(xpath = "//td[contains(text(),'Season First Introduced')]/following::select[1]")
	private WebElement seasonFirst_Introduced;

	public void EnterValues(String colorName, String lSAndCo_ColorName, String colorFamily, String colorStatus,
			String seasonFirstIntroduced, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(color_Name));
		color_Name.sendKeys(colorName);
		Thread.sleep(2000);
		LSAndCo_ColorName.sendKeys(lSAndCo_ColorName);
		Thread.sleep(2000);
		selectValueFromDropdown(color_Family, colorFamily);
		Thread.sleep(2000);
		selectValueFromDropdown(color_Status, colorStatus);
		Thread.sleep(2000);
		selectValueFromDropdown(seasonFirst_Introduced, seasonFirstIntroduced);
		Thread.sleep(2000);

		test.log(Status.INFO, "Filled Values: " + "Color Name: " + colorName + ", Color Family: " + colorFamily
				+ ", Color Status: " + colorStatus + ", Season First Introduced: " + seasonFirstIntroduced);
	}

	@FindBy(xpath = "//input[@id='imageFile']")
	private WebElement chooseFile;

	public void chooseColorThumbnail(String imagePath) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		chooseFile.sendKeys(imagePath);
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement create_Btn;

	public void clickOnCreate() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(create_Btn)).click();
		Thread.sleep(2000);
	}

	public boolean isColorRecordCreated(String colorName, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			WebElement colorRecord = driver.findElement(By.xpath("//a[text()='" + colorName + "']"));
			String colorRecord_Name = colorRecord.getText();
			test.log(Status.INFO, "New color record is Displayed: " + colorRecord_Name);
			addScreenShot("New color record is Displayed", test, Capture);
			return colorRecord.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void navigateToColorDetailsPage(String colorName) throws Exception {

		Thread.sleep(60000);// for updating StagingRow ID
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		WebElement element = driver.findElement(By.xpath("//a[@href='javascript:viewSelectedPalette()']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ColorsTabFeild));
		Thread.sleep(4000);
		WebElement colorRecord = driver.findElement(By.xpath("//a[text()='" + colorName + "']"));
		colorRecord.click();
		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='PAGEHEADINGTITLE']")));
	}

	public boolean getColorStagingID() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement colorStagingIDElement = driver.findElement(By.xpath("//td[@id='lscoStColor']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colorStagingIDElement);
		Thread.sleep(2000);
		String colorStagingIDText = colorStagingIDElement.getText();

		if (!colorStagingIDText.equals("0")) {
			return true; // ID is valid
		} else {
			return false; // ID is zero
		}
	}

}
