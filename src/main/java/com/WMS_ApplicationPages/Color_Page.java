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
import org.openqa.selenium.TimeoutException;
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

public class Color_Page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public Color_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@id='contentframe']")
	private WebElement iframeContentframe;

//	@FindBy(xpath = "//td[@id='lscoColorName']")
//	private WebElement lscoArtworkName;
//	
//	@FindBy(xpath = "//td[@id='lscoArtwork']")
//	private WebElement lscoArtwork;
//	
//	@FindBy(xpath = "//td[@id='lscoColorCombo']")
//	private WebElement colorComboElement;
//	
//	@FindBy(xpath = "//td[@id='lscoPrintType']")
//	private WebElement printTypeElement;

	@FindBy(xpath = "//div[contains(text(),'Supplier')]/following-sibling::div")
	private WebElement supplierDropdown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement searchField;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement searchOption;

	@FindBy(xpath = "//span[contains(text(),'Colors')]")
	private WebElement ColorsTabFeild;

	@FindBy(xpath = "//span[normalize-space()='Details']")
	private WebElement detailsTabFeild;

	@FindBy(xpath = "(//div[@class='dropdown menu-icon'])[2]/img")
	private WebElement dpdownMenuIcon;

	@FindBy(xpath = "//span[normalize-space()='Create Multiple Material Colors']")
	private WebElement addMultipleColorsButton;

	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement iframeMateriallibraryframe;

	@FindBy(xpath = "//div[@class='p-multiselect-label ng-tns-c34-3 p-placeholder']")
	private WebElement ColorLookDropdown;

	@FindBy(xpath = "//div[@class='tableDebuggerCls']/following::a/following::a[1]")
	private WebElement firstColorSelect;

	@FindBy(xpath = "//input[@class='p-tree-filter p-inputtext p-component']")
	private WebElement searchInput;

	@FindBy(xpath = "//span[contains(text(),'Solid Colors')]")
	private WebElement solidColorOption;

	@FindBy(xpath = "//div[@class='ag-row-even ag-row-no-focus ag-row ag-row-level-0 ag-row-position-absolute ag-row-first']//a[@class='pointer-link ng-star-inserted'][normalize-space()='(choose)']")
	private WebElement choosenFirstColor;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='LS&Co. Color']/following::input[1]")
	private WebElement lSAndCoColorInput;

	@FindBy(xpath = "//span[normalize-space()='Clear Criteria']")
	private WebElement clearCriteria;

	@FindBy(xpath = "//span[normalize-space()='Reset Defaults']")
	private WebElement resetDefaults;

	@FindBy(xpath = "//div[@ref='eCheckbox']/child::div[2]/input")
	private WebElement firstCheckBox;

	@FindBy(xpath = "(//*[text()='Select'])[1]")
	private WebElement selectOptn;

	@FindBy(xpath = "//a[normalize-space()='Create']")
	private WebElement createOptn;

	@FindBy(xpath = "//span[normalize-space()='Run']")
	private WebElement runButton;

	@FindBy(xpath = "//div[contains(text(),'Material Color')]/following::div[1]")
	private WebElement materialColordropdown;

	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='Name']/following::input[1]")
	private WebElement nameSearchField;

	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='LS&Co. Color']/following::input[1]")
	private WebElement lscoColornameSearchField;

	@FindBy(xpath = "//td[contains(text(),'Actions:')]/child::select")
	private WebElement actionsDropdown;

	@FindBy(xpath = "//input[@id='ptc_str_5']")
	private WebElement lookNameInput;

	@FindBy(xpath = "//select[@id='ptc_str_4']")
	private WebElement ColorFamily;

	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement save_Btn;

	@FindBy(xpath = "//td[@id='lscoColorName']")
	private WebElement lookNameExtract;

	@FindBy(xpath = "//td[@id='lscoColorFamily']")
	private WebElement colorFamilyExtract;

	@FindBy(xpath = "//td[@class='ERROR']")
	private WebElement errorMsgExtract;

	@FindBy(xpath = "(//td[@class='DISPLAYTEXT'])[1]")
	private WebElement ViewLookName;

	@FindBy(xpath = "//td[@id='lscoColorCode']")
	private WebElement colorcodeExtract;

	@FindBy(xpath = "//td[@id='lscoSeason']")
	private WebElement seasonExtract;

	@FindBy(xpath = "(//td[@class='DISPLAYTEXT'])[1]/following-sibling::td[2]")
	private WebElement colorTypeExtract;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeftPanel;

	@FindBy(xpath = "//div[@id='pinbutton']")
	private WebElement pinbutton;

	@FindBy(xpath = "//label[normalize-space()='Libraries']")
	private WebElement librariesoptn;

	@FindBy(xpath = "//a[normalize-space()='Color/Look']")
	private WebElement colorLookoptn;

	@FindBy(xpath = "//a[normalize-space()='Color/Look']")
	private WebElement filterData;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	private boolean Capture;

	public void selectSupplierFromDropDown(String supplierName, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(supplierDropdown));
		supplierDropdown.click();
		Thread.sleep(3000);

		List<WebElement> options = driver
				.findElements(By.xpath("//div[contains(text(),'Supplier')]/following-sibling::div/following::li"));

		for (WebElement option : options) {
			if (option.getText().contains(supplierName)) {
				option.click();
				addSrceenShot("Selected supplier from Drop Down", test, Capture);
				break;
			}
		}

	}

	public void selectColorsTab() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ColorsTabFeild));
		ColorsTabFeild.click();
	}

	public void selectDetailsTab() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(detailsTabFeild));
		detailsTabFeild.click();
	}

	public void addMultipleColors(String colorType, String colorItem, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dpdownMenuIcon));
		dpdownMenuIcon.click();
		test.log(Status.INFO, "Clicked on dropdown menu icon");
		addSrceenShot("Clicked on dropdown menu icon", test, Capture);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(addMultipleColorsButton));
		addMultipleColorsButton.click();
		test.log(Status.INFO, "Clicked on 'Add multiple colors' button");
		addSrceenShot("Clicked on 'Add multiple colors' button", test, Capture);
		Thread.sleep(2000);
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ColorLookDropdown));
		ColorLookDropdown.click();
		test.log(Status.INFO, "Clicked on Color Look dropdown");
		addSrceenShot("Clicked on Color Look dropdown", test, Capture);

		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchInput));
		searchInput.sendKeys(colorType);
		test.log(Status.INFO, "Entered color type: " + colorType);
		addSrceenShot("Entered color type", test, Capture);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(solidColorOption));
		solidColorOption.click();
		Thread.sleep(1000);
		test.log(Status.INFO, "Selected solid color option");
		addSrceenShot("Selected solid color option", test, Capture);
		clearCriteria.click();
		// ColorLookDropdown.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(lSAndCoColorInput));
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		lSAndCoColorInput.sendKeys(colorItem);
		test.log(Status.INFO, "Entered color item: " + colorItem);
		addSrceenShot("Entered color item", test, Capture);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);
		Thread.sleep(3000);

		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@name='center']")));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCheckBox);

		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(selectOptn));
		selectOptn.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicked on select option");
		addSrceenShot("Clicked on select option", test, Capture);
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", createOptn);
		driver.switchTo().window(ParentWinhadle);

	}

	public void validateColorInDropdown(String colorItem, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(materialColordropdown));
		materialColordropdown.click();
		test.log(Status.INFO, "Material/Supplier screen is visible");
		addSrceenShot("Material/Supplier screen is visible", test, Capture);

		List<WebElement> options = driver.findElements(
				By.xpath("//div[contains(text(), 'Material Color')]/following-sibling::div/following::li"));
		boolean isColorPresent = false;
		for (WebElement option : options) {
			if (option.getText().equals(colorItem)) {
				isColorPresent = true;
				break;
			}
		}

		if (isColorPresent) {
			System.out.println("Added Color is present in dropdown: " + colorItem);
			test.log(Status.PASS, "Added Color is present in dropdown: " + colorItem);
			addSrceenShot("Added Color is present in dropdown", test, Capture);

		} else {
			System.out.println("Added Color is not present in dropdown");
			test.log(Status.FAIL, "Added Color is not present in dropdown");
		}
	}

	public void clickOnColorLook(String colorLookType, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
		ColorLookDropdown.click();
		test.log(Status.INFO, "Clicked on Color Look dropdown");
		addSrceenShot("Clicked on Color Look dropdown", test, Capture);

		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchInput));
		searchInput.sendKeys(colorLookType);
		test.log(Status.INFO, "Entered color type: " + colorLookType);
		addSrceenShot("Entered color type", test, Capture);
		Thread.sleep(3000);

		WebElement colorType = driver.findElement(By.xpath("//span[contains(text(),'" + colorLookType.trim() + "')]"));
		colorType.click();
		Thread.sleep(2000);
		ColorLookDropdown.click();
	}

	public void selectSeasonalLook(String value, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(nameSearchField));
		System.out.println("name search feild found");
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		Thread.sleep(5000);
		nameSearchField.sendKeys(value);
		System.out.println("Look ID: " + value);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);

	}

	public void selectLook(String value, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lscoColornameSearchField));
		System.out.println("name search feild found");
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		Thread.sleep(5000);
		lscoColornameSearchField.sendKeys(value);
		System.out.println("Look ID: " + value);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);

	}

	public void clickOnUpdate() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(actionsDropdown));
		clickElement(actionsDropdown);
		Select dropdown = new Select(actionsDropdown);
		dropdown.selectByVisibleText("Update");

	}

	public void modifyAttributes(String lookName, String colorFamily) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(lookNameInput));
		lookNameInput.clear();
		lookNameInput.sendKeys(lookName);
		Thread.sleep(2000);
		selectValueFromDropdown(ColorFamily, colorFamily);

	}

	public void UpdateAttributes(String colorName, String colorFamily) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(lookNameInput));
		lookNameInput.clear();
		lookNameInput.sendKeys(colorName);
		Thread.sleep(2000);
		selectValueFromDropdown(ColorFamily, colorFamily);

	}

	public void clickOnSave() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(save_Btn));
		save_Btn.click();

	}

	public boolean verifyUpdatedValues(String seasonalLook, String lookName, String colorFamily, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			// Wait for the updated values to be visible
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lookNameExtract));
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(colorFamilyExtract));
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ViewLookName));
			String viewLookNmae = ViewLookName.getText();
			test.log(Status.INFO, "Before Update - Seasonal Look Name: " + seasonalLook
					+ ", After Update - Seasonal Look Name: " + viewLookNmae);

			// Verify the updated values
			return lookNameExtract.getText().contains(lookName) && colorFamilyExtract.getText().contains(colorFamily);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean verifyColorNameFormat(String lookName, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ViewLookName));
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(colorcodeExtract));
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(seasonExtract));

			String actualLookName = ViewLookName.getText();
			String actualColorCode = colorcodeExtract.getText();
			String actualSeason = seasonExtract.getText();
			test.log(Status.INFO, "Actual Season: " + actualSeason + ", Actual Color Code: " + actualColorCode
					+ ", Actual Color Name: " + actualLookName);
			addSrceenShot("Actual Values", test, Capture);

			String expectedColorName = actualSeason + " " + actualColorCode + " " + lookName;
//			String expectedColorName = actualColorCode + " " + lookName;
			boolean isColorNameCorrect = actualLookName.contains(expectedColorName);

			if (isColorNameCorrect) {
				test.log(Status.PASS, "Color Name format is correct: " + expectedColorName);
				addSrceenShot("Color Name format is correct", test, Capture);
			} else {
				test.log(Status.FAIL, "Color Name format is incorrect. Expected: " + expectedColorName + ", Actual: "
						+ actualLookName);
				addSrceenShot("Color Name format is incorrect", test, Capture);
			}

			return isColorNameCorrect;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void viewColorRecord(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ViewLookName));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(colorcodeExtract));
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lookNameExtract));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(colorFamilyExtract));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(colorTypeExtract));

		String colorID = ViewLookName.getText();
		String colorNameValue = lookNameExtract.getText();
		String colorFamily = colorFamilyExtract.getText();
		String colorType = colorFamilyExtract.getText();
		String colorCode = colorcodeExtract.getText();

		test.log(Status.INFO, "Color Record Details - Color ID: " + colorID + ", Color Name: " + colorNameValue
				+ ", Type: " + colorType + ", Color Family: " + colorFamily + ", code: " + colorCode);
		addSrceenShot("Viewed color record", test, Capture);
	}

	public String getColorNameValue() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lookNameExtract));
		String lookName_Extract = lookNameExtract.getText();
		return lookName_Extract;
	}

	public String getColorFamily() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorFamilyExtract));
		String colorFamily_Extract = colorFamilyExtract.getText();

		return colorFamily_Extract;
	}

	public String getExceptionMessage(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(errorMsgExtract));
		String errorMsg_Extract = errorMsgExtract.getText();

		test.log(Status.INFO, "Error:  " + errorMsg_Extract);
		addSrceenShot("Error", test, Capture);

		return errorMsg_Extract;
	}

	public void openNewTabAndNavigateToColor(String URL, ExtentTest test) throws InterruptedException {
		// Logic to open new tab and navigate to another existing color solid
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // Switch to new tab

		driver.get(URL); // Navigate to the color look library URL
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pinbutton));
		clickElement(pinbutton);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(librariesoptn));
		librariesoptn.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(colorLookoptn));
		colorLookoptn.click();
		Thread.sleep(2000);

		test.log(Status.INFO, "Opened new tab and navigated to the Color/Look Library");
		addSrceenShot("Opened new tab and navigated to the Color/Look Library", test, Capture);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement iframeColorlibraryframe;

	public void addColorToMaterialRecord(String colorItem, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(dpdownMenuIcon));
		dpdownMenuIcon.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(addMultipleColorsButton));
		addMultipleColorsButton.click();
		test.log(Status.INFO, "Clicked on 'Add multiple colors' button");
		addSrceenShot("Clicked on 'Add multiple colors' button", test, Capture);
		Thread.sleep(2000);
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeColorlibraryframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameSearchField));
		Thread.sleep(5000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		Thread.sleep(2000);
		nameSearchField.sendKeys(colorItem);
		test.log(Status.INFO, "Entered color item: " + colorItem);
		addSrceenShot("Entered color item", test, Capture);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);
		Thread.sleep(3000);
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@name='center']")));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCheckBox);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(selectOptn));
		selectOptn.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicked on select option");
		addSrceenShot("Clicked on select option", test, Capture);

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", createOptn);
		driver.switchTo().window(ParentWinhadle);

	}

}
