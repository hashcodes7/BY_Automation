package com.WMS_ApplicationPages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.relevantcodes.extentreports.LogStatus;

public class SourcingPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public SourcingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeftPanel;

	@FindBy(xpath = "//iframe[@name='headerframe']")
	private WebElement iframeHeader;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	private WebElement newBtn;

	@FindBy(xpath = "//a[.='Vertical']")
	private WebElement vertical;

	@FindBy(xpath = "//a[contains(text(),'Bottoms')][1]")
	private WebElement productTypeLink;

	@FindBy(xpath = "//div[@id='pinbutton']")
	private WebElement pinbutton;

	@FindBy(xpath = "//div[@class='x-tool x-tool-unpin collapseExpandAndPin']")
	private WebElement pinbuttonclose;

	@FindBy(xpath = "//a[.='* Product Type']")
	private WebElement productType;

	@FindBy(xpath = "//div[@id='userLabelDiv']")
	private WebElement UserNameLabel;

	@FindBy(xpath = "//select[@id='quickLinkSelectionId']")
	private WebElement quickLinkDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Category')]/following-sibling::td[1]")
	private WebElement CategoryDropdown1;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Category')]/following-sibling::td[1]/select")
	private WebElement CategoryDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Brand')]/following-sibling::td[1]/select")
	private WebElement BrandDropdown;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Gender')]//following-sibling::td/select")
	private WebElement GenderDropdown;

	@FindBy(xpath = "//div[contains(text(),'Brand Hierarchy')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")
	private WebElement BrandValueDropdown2;

	@FindBy(xpath = "//div[contains(text(),'Brand Hierarchy')]/following::span[@class='select2-selection select2-selection--single'][1]")
	private WebElement BrandValueDropdown1;

	@FindBy(xpath = "//span[@id='select2-ptc_str_6-container']")
	private WebElement CapsuleDropdown;

	@FindBy(xpath = "//select[@name='ptc_str_22select']")
	private WebElement BrandHierarchyDropdown;

	@FindBy(xpath = "//div[contains(text(),'Product Sub Cat 1')]")
	private WebElement ProductSubCatDropdown;

	@FindBy(xpath = "//div[contains(text(),'Product Sub Cat 2')]")
	private WebElement ProductSubCat2Dropdown;

	@FindBy(xpath = "//div[contains(text(),'Class (Product Hierarchy)')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")
	private WebElement ClassDropdown;

	@FindBy(xpath = "//select[@name='ptc_str_46select']")
	private WebElement SubClassDropdown;

	@FindBy(xpath = "//select[@name='ptc_str_49select']")
	private WebElement ConsumerDropdown;

	@FindBy(xpath = "//select[@name='ptc_str_50select']")
	private WebElement ConsumerGrp1Dropdown;

	@FindBy(xpath = "//select[@name='ptc_str_51select']")
	private WebElement ConsumerGrp2Dropdown;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement createColorwayDropdown;

	@FindBy(xpath = "(//a[contains(text(),'Search')])[1]")
	private WebElement searchButton;

	// ul[@id='select2-ptc_str_22select-results']/li

	/*
	 * @FindBy(xpath =
	 * "//div[@class='BlueBody']//td[contains(.,'*Season')]//following-sibling::td[1]/select")
	 * private WebElement SeasonDropdown;
	 */
	@FindBy(xpath = "//a[.='Create']")
	private WebElement createBtn;

	@FindBy(xpath = "//td[@class='HEADING2']//select")
	private WebElement actionDD;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Quarter')]//preceding-sibling::td/select")
	private WebElement yearDD;

	@FindBy(xpath = "//a[.='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[normalize-space()='View Product']")
	private WebElement viewProductButton;

	@FindBy(xpath = "//a[.='Go to Line Sheet']")
	private WebElement GoToLineSheet;

	@FindBy(xpath = "//a[.='View Product']")
	private WebElement viewProduct;

	@FindBy(xpath = "//a[.='Delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//td[@class='HEADING1']")
	private WebElement deleteMessage;

	@FindBy(xpath = "(//div[@class='BlueBox']//td[@class='BlueHeader'])[1]")
	private WebElement seasonIdentificationValue;

	@FindBy(xpath = "//div[@id='null']//td[contains(.,'Name')]//following-sibling::td[@class='DISPLAYTEXT'][1]")
	private WebElement nameValue;

	@FindBy(xpath = "//div[@class='BlueBody']//td[contains(.,'*Season Introduced Code')]//following-sibling::td/select")
	private WebElement SeasonCodeDropdown;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//div[@id='allSpace']")
	private WebElement dashboardElement;

	@FindBy(xpath = "//select[@id='quickLinkSelectionId']")
	private WebElement logout;

	@FindBy(xpath = "//div[contains(text(),'Product Name')]//following::input[1]")
	private WebElement productNameText;

	@FindBy(xpath = "//div[@class='single-list-body']//select")
	private WebElement seasonDropdown;

	@FindBy(xpath = "//div[@class='single-list-body']/select[@name='selectedSeasonId']")
	private WebElement seasonDropdown1;

	@FindBy(xpath = "//center[contains(text(),'Logged Out')]")
	private WebElement logoutText;

	private static By productTypeOption = By.xpath("//a[.='<productType>']");

	@FindBy(xpath = "//div[normalize-space()='* Brand Hierarchy']/following-sibling::div")
	private WebElement brandHierarchyDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Product Sub Cat 1']/following-sibling::div")
	private WebElement proSubCat1DropDown;

	@FindBy(xpath = "//div[normalize-space()='* Product Sub Cat 2']/following-sibling::div")
	private WebElement proSubCat2DropDown;

	@FindBy(xpath = "//div[normalize-space()='* Class (Product Hierarchy)']/following-sibling::div")
	private WebElement classDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Sub Class (Product Hierarchy)']/following-sibling::div")
	private WebElement subClassDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Consumer (Product Hierarchy)']/following-sibling::div")
	private WebElement consumerDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Consumer Group 1']/following-sibling::div")
	private WebElement consumerGrp1DropDown;

	@FindBy(xpath = "//div[normalize-space()='* Consumer Group 2']/following-sibling::div")
	private WebElement consumerGrp2DropDown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement searchField;

	@FindBy(xpath = "//input[@role='searchbox']/following::li[@role='option']")
	private WebElement searchResult;

	@FindBy(xpath = "//div[normalize-space()='Style Type']/following-sibling::div")
	private WebElement styleTypeElement;

	@FindBy(xpath = "//div[@id='navHeader']/child::a")
	private WebElement productNameElement;

	@FindBy(xpath = "//div[normalize-space()='Colorway (Look/Color)']/following::div[1]/a")
	private WebElement linkToColorDetails;

	@FindBy(xpath = "//div[normalize-space()='Colorway Code']/following::div[1]")
	private WebElement pc9CodeElement;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement colourwayNameElement;

	@FindBy(xpath = "//div[@id='lscoProdMarketingName']/child::div[2]")
	private WebElement productMarketingNameElement;

	@FindBy(xpath = "//div[normalize-space()='Merch Fabric Type']/following-sibling::div")
	private WebElement merchFabricTypeElement;

	@FindBy(xpath = "//td[@id='lscoColorName']")
	private WebElement lscoArtworkName;

	@FindBy(xpath = "//td[@id='lscoArtwork']")
	private WebElement lscoArtwork;

	@FindBy(xpath = "//td[@id='lscoColorCombo']")
	private WebElement colorComboElement;

	@FindBy(xpath = "//td[@id='lscoPrintType']")
	private WebElement printTypeElement;

	@FindBy(xpath = "//a[normalize-space()='New']")
	private WebElement newIconElement;

	@FindBy(xpath = "//td[@class='BlueHeader']")
	private WebElement blueHeader;

	@FindBy(xpath = "//div[contains(text(), 'Gender / Cons. Group')]/following::div[1]/child::span")
	private WebElement gender_consGroupDropDown;

	@FindBy(xpath = "//div[contains(text(),'* Fit Block Name')]/following-sibling::div/child::input")
	private WebElement fitBlockNameSearchBox;

	@FindBy(xpath = "//span[normalize-space()='Specifications']")
	private WebElement SpecificationFeild;

	@FindBy(xpath = "//span[normalize-space()='Sourcing']")
	private WebElement SourcingFeild;

	@FindBy(xpath = "//span[contains(text(),'Sizing')]")
	private WebElement sizingOptn;

	@FindBy(xpath = "//span[contains(text(),'Samples')]")
	private WebElement samplesOptn;

	@FindBy(xpath = "//a[contains(text(),'New Sample')]")
	private WebElement newSamplesOptn;

	@FindBy(xpath = "//a[contains(text(),'Template')]")
	private WebElement chooseTemplatelink;

	@FindBy(xpath = "//a[contains(text(),'(choose)')][1]")
	private WebElement firstOptn;

	@FindBy(xpath = "//span[normalize-space()='Create']")
	private WebElement createButton;

	@FindBy(xpath = "//span[contains(text(),'Measurements')]")
	private WebElement measurementOptn;

	@FindBy(xpath = "//div[@class='input-title-required']/following-sibling::div/input")
	private WebElement measurementNameInput;

	@FindBy(xpath = "//div[@class='input-title-required']/following-sibling::div/input")
	private WebElement saveAndCheckIn;

	@FindBy(xpath = "//span[contains(text(), 'Construction')]")
	private WebElement constructionOptn;

	@FindBy(xpath = "//div[contains(text(),'*Name')]/following-sibling::div/input")
	private WebElement constructionNameInput;

	@FindBy(xpath = "//span[normalize-space()='Sizes']")
	private WebElement sizesOption;

	@FindBy(xpath = "//input[@id='newLCSMEASUREMENTS_sizeRun']")
	private WebElement sizeField;

	@FindBy(xpath = "//a[@id='LCSMEASUREMENTS_sizeRunaddSingleEntryOption']")
	private WebElement addButton;

	@FindBy(xpath = "//td[contains(text(),'Name')]/following-sibling::td[1]/child::input[1]")
	private WebElement nameInput;

	@FindBy(xpath = "(//a[contains(text(),'Search')])[2]")
	private WebElement searchBtn;

	@FindBy(xpath = "(//a[contains(text(),'(choose)')])[1]")
	private WebElement optnSelect;

	@FindBy(xpath = "//div[contains(text(), 'Source')]/following-sibling::div")
	private WebElement sourceDropDown;

	@FindBy(xpath = "//div[contains(text(), 'Specification')]/following-sibling::div")
	private WebElement specificationDropDown;

	@FindBy(xpath = "//ul[@role='listbox']/li[2]")
	private WebElement soucrceFirstoptn;

	@FindBy(xpath = "//ul[@role='listbox']/li[2]")
	private WebElement specificationFirstoptn;

	@FindBy(xpath = "//td[contains(text(), 'Sample Request Type')]/following-sibling::td[1]/child::select")
	private WebElement RequestTypeDropDown;

	@FindBy(xpath = "//td[contains(text(), 'Request Name')]/following-sibling::td[1]/child::input")
	private WebElement requestNameInput;

	@FindBy(xpath = "//td[contains(text(), 'Quantity')]/following-sibling::td[1]/child::input")
	private WebElement quantityInput;

	@FindBy(xpath = "//div[@id='navHeader']/child::a")
	private WebElement productNameFeild;

	@FindBy(xpath = "//span[normalize-space()='Samples']")
	private WebElement samplesTitleBar;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoVendorList|~*~|SourceConfig-LinkSourcetoColorway'])[2]")
	private WebElement Vendor_List_Value;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	private WebElement text_feild;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement checkbox;

	@FindBy(xpath = "//label[normalize-space()='View']/following::span[1]")
	// label[normalize-space()='View']/following-sibling::rfa-singleselect-dropdown
	private WebElement viewDropDown;

	@FindBy(xpath = "//button[@title='To cancel without saving, click Run']//span")
	private WebElement saveBtnn;
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoSourcePC9Status|~*~|SourceConfig-LinkSourcetoColorway'])[2]")
	private WebElement successMessage;

	String currentTest;
	boolean Capture = true;

	public void clikOnNewBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(newBtn));
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
		clickElement(newBtn);
	}

	public void clickOnSaveBtn(ExtentTest test) throws Exception {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveBtnn));

		Thread.sleep(3000);
		saveBtnn.click();

		Thread.sleep(5000);

		System.out.println("Clicked On Save Button");

		test.log(Status.PASS, "Clicked On Save Button");

		addSrceenShot("Clicked On Save Button", test, Capture);

	}

	public void verifySuccessMessage(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();

		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);

		// Assuming the success message has a specific locator

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(successMessage));

		if (successMessage.isDisplayed()) {

			String messageText = successMessage.getText();

			test.log(Status.PASS, "Success message is displayed: " + messageText);

			addSrceenShot("Success message is displayed", test, Capture);

		} else {

			throw new Exception("Success message is not displayed");

		}

	}

	public void editProduct() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Edit Product']")).click();
			addSrceenShot("Clicked Edit Product dropdown", test, Capture);
			System.out.println("string menu" + ":");
		} catch (Exception e) {
			System.out.println("string menu" + ":");
		}
	}

	public String getStyleType() {
		// Locate the element that displays the style type
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(styleTypeElement));
		String styleType = styleTypeElement.getText();

		return styleType;
	}

	public void selectColorwayFromMenu(String colourWayName, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement dropdownSymbol = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(createColorwayDropdown));
		dropdownSymbol.click();

		WebElement searchBox = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='searchbox']")));
		searchBox.sendKeys(colourWayName);

		WebElement option = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option']")));
		option.click();

		test.log(Status.INFO, "Selected Colorway from menu: " + colourWayName);
		addSrceenShot("Selected Colorway from menu", test, Capture);
	}

	public void clickOnColorDetailsLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(linkToColorDetails));
		linkToColorDetails.click();
	}

	public String getPc9Code(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9CodeElement));
		String pc9Code = pc9CodeElement.getText();
		test.log(Status.INFO, "Pc9 code extracted: " + pc9Code);
		addSrceenShot("Pc9 code extracted", test, Capture);
		return pc9Code;
	}

	public String getColourwayName(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colourwayNameElement));
		String colourwayName = colourwayNameElement.getText();
		test.log(Status.INFO, "Colorway name extracted: " + colourwayName);
		addSrceenShot("Colorway name extracted", test, Capture);
		return colourwayName;
	}

	public String getProductName(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productNameElement));
		String productName = productNameElement.getText();
		test.log(Status.INFO, "Product Name extracted: " + productName);
		addSrceenShot("Product Name extracted", test, Capture);
		return productName;
	}

	public String getProductMarketingName(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productMarketingNameElement));
		String productMarketingName = productMarketingNameElement.getText();
		test.log(Status.INFO, "Product Marketing Name extracted: " + productMarketingName);
		addSrceenShot("Product Marketing Name extracted", test, Capture);
		return productMarketingName;
	}

	public String getmerchFabricType(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(merchFabricTypeElement));
		String merchFabricTypeName = merchFabricTypeElement.getText();
		test.log(Status.INFO, "Merch FabricType extracted: " + merchFabricTypeName);
		addSrceenShot("Merch FabricType extracted", test, Capture);
		return merchFabricTypeName;
	}

	public String getLscoArtworkName(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lscoArtworkName));
		String lscoartworkName = lscoArtworkName.getText();
		test.log(Status.INFO, "lsco Artwork Name From Color Extracted: " + lscoArtworkName);
		addSrceenShot("lsco Artwork Name From Color Extracted", test, Capture);
		return lscoartworkName;
	}

	public String getLscoArtwork(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lscoArtwork));
		String lscoartwork = lscoArtwork.getText();
		test.log(Status.INFO, "lsco Artwork From Color Extracted: " + lscoArtwork);
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

	public void clickOnNewIcon() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(newIconElement));
		newIconElement.click();
	}

	public void chooseType(String typeOfProduct) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(blueHeader));
		WebElement option = driver.findElement(By.xpath("//a[normalize-space()='" + typeOfProduct.trim() + "']"));
		option.click();
	}

	public void gender_ConsGroup(String gender_consGroup) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(gender_consGroupDropDown));
		gender_consGroupDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(gender_consGroup);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
	}

	public void enterFitBlockName(String fitBlockName) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(fitBlockNameSearchBox));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fitBlockNameSearchBox);
		Actions actions = new Actions(driver);
		actions.moveToElement(fitBlockNameSearchBox).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE).perform();
		actions.moveToElement(fitBlockNameSearchBox).click().sendKeys(fitBlockName).build().perform();
	}

	public void clickOnSave() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();
	}

	public boolean verifyFitBlockCreation(String fitBlockName) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(text(), '" + fitBlockName + "')]")));
			WebElement createdFitBlock = driver
					.findElement(By.xpath("//div[contains(text(), '" + fitBlockName + "')]"));
			return createdFitBlock.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void navigateToSpecificationSection() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(SpecificationFeild));
		SpecificationFeild.click();
	}

	public void addSizingDetails() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sizingOptn));
		sizingOptn.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(chooseTemplatelink));
		chooseTemplatelink.click();

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(firstOptn));

		js.executeScript("arguments[0].click();", firstOptn);
		driver.switchTo().window(ParentWinhadle);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createButton));
		createButton.click();
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createButton));
		createButton.click();

	}

	public void addMeasurementData(String measurementData, List<String> sizes, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(measurementOptn));
		measurementOptn.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(measurementNameInput));
		measurementNameInput.sendKeys(measurementData);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(chooseTemplatelink));
		chooseTemplatelink.click();

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(firstOptn));

		js.executeScript("arguments[0].click();", firstOptn);

		driver.switchTo().window(ParentWinhadle);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createButton));
		createButton.click();
		Thread.sleep(3000);
		// adding sizes
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sizesOption));
		Thread.sleep(3000);
		sizesOption.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveAndCheckIn));
		saveAndCheckIn.click();

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
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveAndCheckIn));
		saveAndCheckIn.click();

	}

	public void addConstructionData(String measurementData) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(constructionOptn));
		constructionOptn.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(constructionNameInput));
		constructionNameInput.sendKeys(measurementData);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(chooseTemplatelink));
		chooseTemplatelink.click();

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(firstOptn));
		js.executeScript("arguments[0].click();", firstOptn);

		driver.switchTo().window(ParentWinhadle);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createButton));
		createButton.click();
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveAndCheckIn));
		saveAndCheckIn.click();

	}

	public void filterProductByName(String productName) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(productName);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);
		Thread.sleep(3000);

	}

	public void selectSourcingTab() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(SourcingFeild));
		SourcingFeild.click();
	}

	public void clickOnSamples() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(samplesOptn));
		samplesOptn.click();

	}

	public void clickOnNewSamples() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(newSamplesOptn));
		newSamplesOptn.click();

	}

	public void selectSource() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceDropDown));
		sourceDropDown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(soucrceFirstoptn));
		soucrceFirstoptn.click();
	}

	public void selectSpecifications() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specificationDropDown));
		specificationDropDown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(specificationFirstoptn));
		specificationFirstoptn.click();
	}

	public void selectSampleRequestType(String sampleRequestType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(RequestTypeDropDown));

		Select selectvalue = new Select(RequestTypeDropDown);
		selectvalue.selectByVisibleText(sampleRequestType);
	}

	public void enterRequestName(String requestName) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(requestNameInput));
		requestNameInput.sendKeys(requestName);

	}

	public void enterQuantity(String quantity) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(quantityInput));
		Thread.sleep(2000);
		quantityInput.sendKeys(quantity);

	}

	public void clickOnCreate() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createBtn));
		createBtn.click();
	}

	public void navigateToProduct() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productNameFeild));
		productNameFeild.click();
	}

	public boolean isSampleRequestDisplayed(String requestName) {
		try {

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(samplesTitleBar));
			WebElement sampleRequestElement = driver
					.findElement(By.xpath("//a[contains(text(), '" + requestName + "')]"));

			// Check if the element is displayed
			return sampleRequestElement.isDisplayed();
		} catch (NoSuchElementException e) {
			// If the element is not found, return false
			return false;
		}
	}

	public void selectVendorsFromList(List<String> vendorNames, ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);

		ArrayList<String> header = new ArrayList<String>();
		header = linkSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 7; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Vendor List")) {
				Actions action = new Actions(driver);
				action.moveToElement(Vendor_List_Value).doubleClick().build().perform();
				for (String vendorName : vendorNames) {
					Thread.sleep(2000);
					text_feild.clear();
					text_feild.sendKeys(vendorName);
					Thread.sleep(3000);
					action.moveToElement(checkbox).click().build().perform();
					Thread.sleep(3000);
					test.log(Status.INFO, "Selected vendor: " + vendorName);
					Thread.sleep(1000);

				}

				Actions ac = new Actions(driver);
				ac.sendKeys(Keys.ENTER).perform();

			}
		}
		test.log(Status.INFO, "Selected vendors from Vendor List: " + String.join(", ", vendorNames)); // names
		addSrceenShot("Selected vendors from Vendor List", test, Capture);
		Thread.sleep(2000);

	}

	public boolean isVendorListBlank() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(viewDropDown));

		String vendorListText = Vendor_List_Value.getText();
		return vendorListText.isEmpty();
	}

	@FindBy(xpath = "(//div[@col-id='colorway.skuName|~*~|SourceConfig-LinkSourcetoColorway'])[2]/name-cell-renderer/a")
	private WebElement colorWayNameEle;

	@FindBy(xpath = "//span[@id='select2-sourcingConfigId-container']")
	private WebElement sourceContainer;

	public void isNewSourceToColorwayAssociationCreated(List<String> vendorNames, ExtentTest test) throws Exception {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		colorWayNameEle.click();
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		test.log(Status.INFO, "Product Details Page Opened");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceContainer));
		test.log(Status.INFO, "Located Vendor List dropdown element");
		addSrceenShot("Located Vendor List dropdown element", test, Capture);

		sourceContainer.click();
		test.log(Status.INFO, "Clicked on Vendor List dropdown to expand it");
		addSrceenShot("Expanded Vendor List dropdown", test, Capture);

		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		test.log(Status.INFO, "Located all options within the Vendor List dropdown");
		addSrceenShot("Located options in Vendor List dropdown", test, Capture);

//		// Check if each vendor name is present in the options
//		for (String vendorName : vendorNames) {
//			boolean vendorFound = false;
//			for (WebElement option : options) {
//				if (option.getText().contains(vendorName)) {
//					vendorFound = true;
//					break;
//				}
		// Check if each vendor name is present in the options
		for (String vendorName : vendorNames) {
			boolean vendorFound = false;
			for (WebElement option : options) {
				String optionText = option.getText().toLowerCase();
				String normalizedVendorName = vendorName.toLowerCase();

				// Check if all letters of vendorName are present in option text
				if (containsAllLetters(optionText, normalizedVendorName)) {
					vendorFound = true;
					break;
				}
			}
			if (!vendorFound) {
				test.log(Status.FAIL, "Vendor name not found: " + vendorName);
				addSrceenShot("Vendor name not found: " + vendorName, test, Capture);
			}
		}
		test.log(Status.PASS, "All specified vendor names are present in the Vendor List");
		addSrceenShot("All specified vendor names are present", test, Capture);
		driver.switchTo().window(ParentWinhadle);

	}

//	public void isNewSourceToColorwayAssociationCreated(List<String> vendorNames, ExtentTest test) throws Exception{
//
//		Thread.sleep(5000);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//
//		productNameEle.click();
//		String ParentWinhadle = driver.getWindowHandle();
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		test.log(Status.INFO, "Product Details Page Opened");
//
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//
//		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceContainer));
//		test.log(Status.INFO, "Located Vendor List dropdown element");
//		addSrceenShot("Located Vendor List dropdown element", test, Capture);
//
//		sourceContainer.click();
//		test.log(Status.INFO, "Clicked on Vendor List dropdown to expand it");
//		addSrceenShot("Expanded Vendor List dropdown", test, Capture);
//
//		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
//		test.log(Status.INFO, "Located all options within the Vendor List dropdown");
//		addSrceenShot("Located options in Vendor List dropdown", test, Capture);
//
//		// Store the text of all options in a list
//		List<String> optionTexts = new ArrayList<>();
//		for (WebElement option : options) {
//			optionTexts.add(option.getText());
//		}
//
//		// Check if each vendor name is present in the options
//		for (String vendorName : vendorNames) {
//			if (!optionTexts.contains(vendorName)) {
//				test.log(Status.FAIL, "Vendor name not found: " + vendorName);
//				addSrceenShot("Vendor name not found: " + vendorName, test, Capture);
//			}
//		}
//		test.log(Status.PASS, "All specified vendor names are present in the Vendor List");
//		addSrceenShot("All specified vendor names are present", test, Capture);
//	}

	public void clickOnSaveBtn() throws Exception {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveBtnn));
		saveBtnn.click();
		System.out.println("Clicked On Save Button");
	}
//
//	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoRemoveLink|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])[2]")
//	private WebElement delink_SourceToColorway_Value;
//	
//	public void setDelinkSourceToColorway(List<String> vendorNames, ExtentTest test) throws Exception {
//	    driver.switchTo().defaultContent();
//	    driver.switchTo().frame(iframeContentframe);
//	    Thread.sleep(10000);
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(
//				"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft = document.querySelector('.ag-body-horizontal-scroll-viewport').scrollWidth");
//		Thread.sleep(2000);
//		
//	    for (String vendorName : vendorNames) {
//	        // Locate the vendor name elements
//	        List<WebElement> vendorElements = driver.findElements(By.xpath("//div[@col-id='source.lscoVendor|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink']/object-reference-cell-renderer/div/a"));
//
//	        for (int i = 0; i < vendorElements.size(); i++) {
//	            WebElement vendorElement = vendorElements.get(i);
//	            if (vendorElement.getText().contains(vendorName)) {
//	                Thread.sleep(2000);
//
//	                // Locate the corresponding cell to remove the link, ignoring the first one
//	                WebElement removeLinkCell = driver.findElement(By.xpath("(//div[@col-id='colorway-source.lscoRemoveLink|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])[position() > 1][" + (i + 1) + "]"));	                
//	                Actions action = new Actions(driver);
//					action.moveToElement(removeLinkCell).doubleClick().build().perform();
//					Thread.sleep(2000);
//					WebElement option = driver
//							.findElement(By.xpath("//span[@title='Yes']"));
//					option.click();
//					action.sendKeys(Keys.ENTER).perform();
//					Thread.sleep(2000);
//	                test.log(Status.INFO, "Delinked Source-Colorway: " + vendorName);
//	                addSrceenShot("Delinked vendor: " + vendorName, test, Capture);
//	                Thread.sleep(2000);
//	            }
//	        }
//	        saveBtnn.click();
//            Thread.sleep(10000);
//
//            test.log(Status.INFO, "Clicked On save Button");
//            addSrceenShot("Clicked On save Button" + vendorName, test, Capture);
//	        
//	    }
//	}

	public void setDelinkSourceToColorway(List<String> vendorNames, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft = document.querySelector('.ag-body-horizontal-scroll-viewport').scrollWidth");
		Thread.sleep(2000);

		for (String vendorName : vendorNames) {
			// Locate the vendor name elements
			List<WebElement> vendorElements = driver.findElements(By.xpath(
					"//div[@col-id='source.lscoVendor|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink']/object-reference-cell-renderer/div/a"));

			for (int i = 0; i < vendorElements.size(); i++) {
				WebElement vendorElement = vendorElements.get(i);
				String vendorText = vendorElement.getText().toLowerCase();
				String normalizedVendorName = vendorName.toLowerCase();

				// Check if all letters of vendorName are present in vendorElement text
				if (containsAllLetters(vendorText, normalizedVendorName)) {
					Thread.sleep(2000);

					// Locate the corresponding cell to remove the link, ignoring the first one
					WebElement removeLinkCell = driver.findElement(By.xpath(
							"(//div[@col-id='colorway-source.lscoRemoveLink|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])[position() > 1]["
									+ (i + 1) + "]"));
					Actions action = new Actions(driver);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", removeLinkCell);
					Thread.sleep(3000);
					action.moveToElement(removeLinkCell).doubleClick().build().perform();
					Thread.sleep(2000);
					WebElement option = driver.findElement(By.xpath("//span[@title='Yes']"));
					option.click();
					action.sendKeys(Keys.ENTER).perform();
					Thread.sleep(4000);
					test.log(Status.INFO, "Delinked Source-Colorway: " + vendorName);
					addSrceenShot("Delinked vendor: " + vendorName, test, Capture);
					Thread.sleep(2000);
				}
			}
			
		}
			saveBtnn.click();
			Thread.sleep(10000);

			test.log(Status.INFO, "Clicked On save Button");
			addSrceenShot("Clicked On save Button", test, Capture);
	}

	private boolean containsAllLetters(String text, String subText) {
		text = text.replaceAll("[^a-zA-Z]", "");
		subText = subText.replaceAll("[^a-zA-Z]", "");
		return text.contains(subText);
	}

	public void isDelinkedSourceToColorwayAssociation(List<String> vendorNames, ExtentTest test) throws Exception {

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		test.log(Status.INFO, "Product Details Page Opened");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceContainer));
		Thread.sleep(4000);
		test.log(Status.INFO, "Located Vendor List dropdown element");
		addSrceenShot("Located Vendor List dropdown element", test, Capture);

		sourceContainer.click();
		test.log(Status.INFO, "Clicked on Vendor List dropdown to expand it");
		addSrceenShot("Expanded Vendor List dropdown", test, Capture);

		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		test.log(Status.INFO, "Located all options within the Vendor List dropdown");
		addSrceenShot("Located options in Vendor List dropdown", test, Capture);

//		// Check if each vendor name is NOT present in the options
//		for (String vendorName : vendorNames) {
//			boolean vendorFound = false;
//			for (WebElement option : options) {
//				if (option.getText().contains(vendorName)) {
//					vendorFound = true;
//					break;
//				}
		// Check if each vendor name is NOT present in the options
	    for (String vendorName : vendorNames) {
	        boolean vendorFound = false;
	        for (WebElement option : options) {
	            String optionText = option.getText().toLowerCase();
	            String normalizedVendorName = vendorName.toLowerCase();

	            // Check if all letters of vendorName are present in option text
	            if (containsAllLetters(optionText, normalizedVendorName)) {
	                vendorFound = true;
	                break;
	            }
			}
			if (vendorFound) {
				test.log(Status.FAIL, "Vendor name still found: " + vendorName);
				addSrceenShot("Vendor name still found: " + vendorName, test, Capture);
			} else {
				test.log(Status.PASS, "Vendor name successfully delinked: " + vendorName);
				addSrceenShot("Vendor name successfully delinked: " + vendorName, test, Capture);
			}
		}
		driver.switchTo().window(ParentWinhadle);
	}

	@FindBy(xpath = "//*[@id='quickSearchText']")
	private WebElement filterdata;

	@FindBy(xpath = "//span[text()='Colorway']")
	private WebElement colorway;

	@FindBy(xpath = "//*[text()='Copy: Colorway']")
	private WebElement copycolorway;

	@FindBy(xpath = "//*[text()='Colorway (Look/Color):']")
	private WebElement colorwayLink;

	@FindBy(xpath = "//*[text()=' Color Code ']//following::input[1]")
	private WebElement colorcodefield;

	@FindBy(xpath = "//span[text()='Search']")
	private WebElement search;

	@FindBy(xpath = "(//*[@col-id='chooseLink'])[1]//following::a[1]")
	private WebElement choose;

	@FindBy(xpath = "//*[text()='Save']")
	private WebElement save;

	@FindBy(xpath = "//*[text()='Go to Line Sheet']")
	private WebElement goToLinesheet;

	@FindBy(xpath = "//*[@id='ptc_ref_1']//following::a[1]")
	private WebElement colorwayadded;

	@FindBy(xpath = "//*[@id='select2-contextSpecId-container']")
	private WebElement specdropdown;

	@FindBy(xpath = "//*[@id='select2-contextSKUId-container']")
	private WebElement colorwaydropdown;

	@FindBy(xpath = "//*[@id='select2-sourcingConfigId-container']")
	private WebElement srcDropDown;

	@FindBy(xpath = "(//*[text()='Source - Colorway Association Status'])[1]")
	private WebElement srcColorway;

	@FindBy(xpath = "(//*[text()='Vendor List'])[1]")
	private WebElement vendorList;

	@FindBy(xpath = "//*[@id='colorlibraryframe']")
	private WebElement iframeColor;

	@FindBy(xpath = "(//*[contains(@col-id,'lscoVendor')])[2]")
	private WebElement VendorField1;

	@FindBy(xpath = "(//*[contains(@col-id,'lscoVendor')])[3]")
	private WebElement VendorField2;

	@FindBy(xpath = "(//*[contains(@col-id,'SourcePC9')])[2]")
	private WebElement srcColorField1;

	@FindBy(xpath = "(//*[contains(@col-id,'SourcePC9')])[3]")
	private WebElement srcColorField2;

	@FindBy(xpath = "(//*[contains(@col-id,'productName')])[2]//a")
	private WebElement productName;

	@FindBy(xpath = "(//*[contains(@col-id,'lscoRemoveLink')])[2]")
	private WebElement delink1;

	@FindBy(xpath = "//*[text()='Yes ']")
	private WebElement yes;

	@FindBy(xpath = "(//span[text()='Product Type'])[1]")
	private WebElement prodType;

	@FindBy(xpath = "//*[text()='No Rows To Show']")
	private WebElement noRows;

	@FindBy(xpath = "(//*[contains(@col-id,'lscoVendor')])[4]")
	private WebElement VendorField3;

	@FindBy(xpath = "(//*[contains(@col-id,'lscoVendor')])[5]")
	private WebElement VendorField4;

	@FindBy(xpath = "(//*[contains(@col-id,'lscoVendor')])[6]")
	private WebElement VendorField5;

	@FindBy(xpath = "(//*[contains(@col-id,'lscoNewCarryover')])[2]")
	private WebElement carryoverField1;

//	Page Methods------------------------------------------------------
	String addedcolor, vendor1, vendor2, vendor3, vendor4, vendor5, carryoverVendor1, carryoverVendor2,
			carryoverVendor3, carryoverVendor4, carryoverVendor5;

	public void copyColorway(ExtentTest test, String colorwayCode, String colorCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(colorwayCode);
		Thread.sleep(5000);
		WebElement colele = driver.findElement(By.xpath("(//*[text()=\'" + colorwayCode + "\'])[1]"));
		Actions actions = new Actions(driver);
		actions.contextClick(colele).perform();
		Thread.sleep(5000);
		actions.moveToElement(prodType);
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorway)).click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(copycolorway)).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwayLink)).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().frame(iframeColor);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorcodefield)).sendKeys(colorCode);
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(search)).click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(choose)).click();
		Thread.sleep(5000);
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().frame(iframeContentframe);
		addedcolor = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwayadded)).getText();
		System.out.println("colorway added is " + addedcolor);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(goToLinesheet)).click();
		Thread.sleep(5000);
		System.out.println("copycolorway is done");
	}

	public void validateColorway(ExtentTest test, String colorwayCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(colorwayCode);
		Thread.sleep(5000);
		WebElement colele = driver.findElement(By.xpath("(//*[text()=\'" + colorwayCode + "\'])[1]"));
		colele.click();
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().frame(iframeContentframe);

		for (int j = 1; j < 6; j++) {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcDropDown)).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='select2-sourcingConfigId-results']//li[" + (j + 1) + "]")).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwaydropdown)).click();
			Thread.sleep(5000);
			List<WebElement> colorwayDrpdownValues = driver
					.findElements(By.xpath("//*[@id='select2-contextSKUId-results']//li"));
			for (int k = 0; k < colorwayDrpdownValues.size(); k++) {
				String value = colorwayDrpdownValues.get(k).getText();
				System.out.println("value is " + value);
				// addedcolor="0WPWD-0001 Auto_test_02";
				System.out.println("colorway added is " + addedcolor);
				if (value.contains(addedcolor)) {
					System.out.println("added colorway is associated with source");
				} else {
					System.out.println("added colorway is not associated with source");
				}
			}
		}

	}

	public void validateLinkSourceColorwayView(ExtentTest test, String colorwayCode2) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(colorwayCode2);
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = linkSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 8; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Source - Colorway Association Status")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1));
				String colorwayvendor1 = VendorField1.getText();
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcColorField1));
				String srccolorway1 = srcColorField1.getText();
				if (colorwayvendor1.equals("") && srccolorway1.equals("")) {
					System.out.println("post vendor association of vendor is " + colorwayvendor1);
					System.out.println("post vendor association of sourcecolorway is " + srccolorway1);
				} else {
					System.out.println("vendor association of colorway is not done");
				}
			}
		}
	}

	public void multiplecolorwaySourcesAssociation(ExtentTest test, String productCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(productCode);
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = linkSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 8; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Source - Colorway Association Status")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1));
				Actions actions = new Actions(driver);
				actions.doubleClick(VendorField1).perform();
				Thread.sleep(5000);
				// adding first 5 vendors to colorway1
				for (int j = 1; j < 6; j++) {
					driver.findElement(By.xpath("(//*[@class='p-checkbox-box'])[" + (j) + "]")).click();
				}
				Thread.sleep(3000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField2));
				actions.doubleClick(VendorField2).perform();
				Thread.sleep(5000);
				// adding next 3 vendors to colorway2
				for (int j = 6; j < 9; j++) {
					driver.findElement(By.xpath("(//*[@class='p-checkbox-box'])[" + (j) + "]")).click();
				}
				Thread.sleep(3000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
				Thread.sleep(3000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1));
				String colorwayvendor1 = VendorField1.getText();
				String colorwayvendor2 = VendorField2.getText();
				if (colorwayvendor1.equals("") && colorwayvendor2.equals("")) {
					System.out.println("post vendor association of colorway1 is " + colorwayvendor1);
					System.out.println("post vendor association of colorway2 is " + colorwayvendor2);
				} else {
					System.out.println("vendor association of colorway is not done");
				}
				String srccolorway1 = srcColorField1.getText();
				String srccolorway2 = srcColorField2.getText();
				if (srccolorway1.equals("Success") && srccolorway1.equals("Success")) {
					System.out.println("post color association of colorway1 is " + srccolorway1);
					System.out.println("post color association of colorway2 is " + srccolorway2);
				} else {
					System.out.println("color association of colorway is not done");
				}
			}
		}
	}

	public void validateMultipleColorwaySourcesAssociation(ExtentTest test) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productName)).click();
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwaydropdown)).click();
		Thread.sleep(5000);
		String colorway1 = driver.findElement(By.xpath("//*[@id='select2-contextSKUId-results']//li[2]")).getText();
		String colorway2 = driver.findElement(By.xpath("//*[@id='select2-contextSKUId-results']//li[3]")).getText();
		System.out.println("colorway1 is " + colorway1);
		System.out.println("colorway2 is " + colorway2);
		Thread.sleep(5000);
		// validating non primary sources are associated to colorways
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcDropDown)).click();
		Thread.sleep(4000);
		List<WebElement> srcDrpdownValues = driver
				.findElements(By.xpath("//*[@id='select2-sourcingConfigId-results']//li"));
		System.out.println("supplier drop down values are " + srcDrpdownValues.size());
		if (srcDrpdownValues.size() > 2) {
			// 5 non primary and 1 primary source and 1 none selected value
			System.out.println("non primary sources are associated to the colorway");
		}
		// validating non primary specifications are associated to colorways
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specdropdown)).click();
		Thread.sleep(4000);
		List<WebElement> specDrpdownValues = driver
				.findElements(By.xpath("//*[@id='select2-contextSpecId-results']//li"));
		if (specDrpdownValues.size() > 2) {
			// 3 non primary and 1 primary specifications and 1 none selected value
			System.out.println("non primary specifications are associated to the colorway");
		}
		// validating colorway is associated with sources
		int colorwayCount1 = 0;
		int colorwayCount2 = 0;
		for (int j = 1; j < srcDrpdownValues.size() - 1; j++) {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcDropDown)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='select2-sourcingConfigId-results']//li[" + (j + 1) + "]")).click();
			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwaydropdown)).click();
			Thread.sleep(3000);
			String colorwayValue = driver.findElement(By.xpath("//*[@id='select2-contextSKUId-results']//li[2]"))
					.getText();
			if (colorwayValue.equals(colorway1)) {
				System.out.println("source is associated with colorway1");
				colorwayCount1++;
			}
			if (colorwayValue.equals(colorway2)) {
				System.out.println("source is associated with colorway2");
				colorwayCount2++;
			}
		}
		if (colorwayCount1 == 5) {
			System.out.println("5 sources are associated with colorway1");
		}
		if (colorwayCount2 == 3) {
			System.out.println("3 sources are associated with colorway2");
		}

	}

	public void colorwaySourcesAssociation(ExtentTest test, String productCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(productCode);
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = linkSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 8; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Source - Colorway Association Status")) {
				// adding 1 source to colorway1
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1));
				Actions actions = new Actions(driver);
				actions.doubleClick(VendorField1).perform();
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//*[@class='p-checkbox-box'])[1]")).click();
				Thread.sleep(3000);
				// adding 1 source to colorway2
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField2));
				actions.doubleClick(VendorField2).perform();
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//*[@class='p-checkbox-box'])[2]")).click();
				Thread.sleep(3000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();

				// check vendor field is set to blank, post the colorway source association
				String colorwayvendor1 = VendorField1.getText();
				String colorwayvendor2 = VendorField2.getText();
				if (colorwayvendor1.equals("") && colorwayvendor2.equals("")) {
					System.out.println("post vendor association of colorway1 is " + colorwayvendor1);
					System.out.println("post vendor association of colorway2 is " + colorwayvendor2);
				} else {
					System.out.println("vendor association of colorway is not done");
				}
				// check cource-colorway association is set to Success, post the colorway source
				// association
				String srccolorway1 = srcColorField1.getText();
				String srccolorway2 = srcColorField2.getText();
				if (srccolorway1.equals("Success") && srccolorway1.equals("Success")) {
					System.out.println("post color association of colorway1 is " + srccolorway1);
					System.out.println("post color association of colorway2 is " + srccolorway2);
				} else {
					System.out.println("color association of colorway is not done");
				}
			}
		}
	}

	public void validateColorwaySourcesAssociation(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		ArrayList<String> header = new ArrayList<String>();
		header = ViewEditRemoveSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 9; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Vendor")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1));
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField2));
				String colorwayvendor1 = VendorField1.getText();
				String colorwayvendor2 = VendorField2.getText();
				if (!colorwayvendor1.equals("") && !colorwayvendor2.equals("")) {
					System.out.println("newly added vendor association of colorway1 is " + colorwayvendor1
							+ "and it is not blank");
					System.out.println("newly added vendor association of colorway2 is " + colorwayvendor2
							+ "and it is not blank");
				} else {
					System.out.println("newly added vendor association of colorway is blank");
				}
			}
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productName)).click();
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().frame(iframeContentframe);
		// validating non primary sources are associated to colorways
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcDropDown)).click();
		Thread.sleep(4000);
		List<WebElement> srcDrpdownValues = driver
				.findElements(By.xpath("//*[@id='select2-sourcingConfigId-results']//li"));
		if (srcDrpdownValues.size() > 2) {
			// 1 primary source and 1 none selected value, remaining will be vendor
			// associated
			System.out.println("non primary sources are associated to the colorway");
		}
		// validating non primary specifications are associated to colorways
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specdropdown)).click();
		Thread.sleep(4000);
		List<WebElement> specDrpdownValues = driver
				.findElements(By.xpath("//*[@id='select2-contextSpecId-results']//li"));
		if (specDrpdownValues.size() > 2) {
			// 1 primary specifications and 1 none selected value,remaining will be vendor
			// associated
			System.out.println("non primary specifications are associated to the colorway");
		}
	}

	public void delinkSourceColorway(ExtentTest test, String productCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(productCode);
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = dlinkSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 10; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Delink Source-Colorway?")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(delink1));
				Actions actions = new Actions(driver);
				actions.doubleClick(delink1).perform();
				Thread.sleep(5000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(yes)).click();
				Thread.sleep(5000);
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).click();
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(save)).click();
				Thread.sleep(5000);
				System.out.println("Delink source to Colorway is done");
			}
		}
	}

	public void validateDelinkSourceColorway(ExtentTest test, String productCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(productCode);
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(noRows));
		Assert.assertTrue(noRows.isDisplayed());
		System.out.println("Delink source to Colorway is updated successfully");
	}

	public void validateCarryoverColorwayFields(ExtentTest test, String prodCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(prodCode);
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = linkSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 8; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Source - Colorway Association Status")) {
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1));
				String colorwayvendor1 = VendorField1.getText();
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(srcColorField1));
				String srccolorway1 = srcColorField1.getText();
				if (colorwayvendor1.equals("") && srccolorway1.equals("")) {
					System.out.println("post carryovercolorway, vendor and source colorway fields are set to blank");

				}
			}
		}
	}

	public void getSourceAssociatedValues(ExtentTest test, String prodCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(prodCode);
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = ViewEditRemoveSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 9; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Vendor")) {
				vendor1 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1)).getText();
				vendor2 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField2)).getText();
				vendor3 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField3)).getText();
				vendor4 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField4)).getText();
				vendor5 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField5)).getText();
			}
		}
	}

	public void validateCarryoverColorwaySources(ExtentTest test, String prodCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(prodCode);
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = ViewEditRemoveSourceToColorwayColumnHeaderValue();
		for (int i = 0; i < 9; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Vendor")) {
				Thread.sleep(5000);
				carryoverVendor1 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField1))
						.getText();
				carryoverVendor2 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField2))
						.getText();
				carryoverVendor3 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField3))
						.getText();
				carryoverVendor4 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField4))
						.getText();
				carryoverVendor5 = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorField5))
						.getText();
				Assert.assertEquals(vendor1, carryoverVendor1);
				Assert.assertEquals(vendor2, carryoverVendor2);
				Assert.assertEquals(vendor3, carryoverVendor3);
				Assert.assertEquals(vendor4, carryoverVendor4);
				Assert.assertEquals(vendor5, carryoverVendor5);
				System.out.println("carryover colorway associated to same sources");

			}
		}
	}

	public void validateCarryovercolorway(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionLinesheetheaderValue();
		for (int i = 0; i < 8; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Carryover/New")) {
				String value = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(carryoverField1))
						.getText();
				Assert.assertEquals(value, "Carryover");
				System.out.println("colorway carried over to new season successfully");

			}
			break;
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////

	public void selectCreateSourcingConfiguration() throws Exception {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
			driver.findElement(By.xpath("//a[@id='createAction']")).click();
			driver.findElement(By.xpath("//a[@id='addSourcing']")).click();
			System.out.println("string menu" + ":");
		} catch (Exception e) {
			System.out.println("string menu" + ":");
		}
	}

	public void selectCreateMultipleSourcingConfiguration() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
			driver.findElement(By.xpath("//a[@id='createAction']")).click();
			driver.findElement(By.xpath("//a[@id='addMultipleSourcings']")).click();
			System.out.println("string menu" + ":");
		} catch (Exception e) {
			System.out.println("string menu" + ":");
		}
	}

	@FindBy(xpath = "//div[@id='lscoIsPrimarySource']//div[2]")
	private WebElement primaryAttribute;

	@FindBy(xpath = "//div[normalize-space()='Sourcing Configuration']//following-sibling::div")
	private WebElement sourceConfigName;

	@FindBy(xpath = "//div[@id='lscoProductCode']//div[2]")
	private WebElement productCode;

	public void validatePrimaryAttribute(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(primaryAttribute));
			String primaryAttributeValue = primaryAttribute.getText();
			if (primaryAttributeValue.equals("No")) {
				System.out.println("Primary attribute value is set to 'No'.");
				test.log(Status.PASS, "Validation: Primary attribute value is set to 'No'.");
				addSrceenShot("Primary Attribute Validation", test, Capture);
			} else {
				System.out.println("Primary attribute value is not set to 'No'.");
				test.log(Status.FAIL, "Validation: Primary attribute value is not set to 'No'.");
				addSrceenShot("Primary Attribute Validation Failed", test, Capture);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Validation: Primary attribute value check failed due to an exception.");
			addSrceenShot("Primary Attribute Validation Exception", test, Capture);
		}
	}

	public void validateSourceConfigName(String vendor, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sourceConfigName));
			String sourceConfigNameValue = sourceConfigName.getText();
			String productCodeValue = productCode.getText();
			test.log(Status.INFO, "Product Code: " + productCodeValue);
			String expectedConfigName = productCodeValue + " -  - " + vendor;
			if (sourceConfigNameValue.equals(expectedConfigName)) {
				System.out.println("Source Configuration Name is correctly derived.");
				test.log(Status.PASS,
						"Source Configuration Name is  derived from product code and vendor name as 'PC5Code -- Vendor Name'"
								+ sourceConfigNameValue);
				test.log(Status.PASS,
						"Validation: Source Configuration Name is correctly derived: " + sourceConfigNameValue);
				addSrceenShot("Source Config Name Validation", test, Capture);
			} else {
				System.out.println("Source Configuration Name is not correctly derived.");
				test.log(Status.FAIL, "Validation: Source Configuration Name is not correctly derived.");
				addSrceenShot("Source Config Name Validation Failed", test, Capture);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Validation: Source Configuration Name check failed due to an exception.");
			addSrceenShot("Source Config Name Validation Exception", test, Capture);
		}
	}

	public void validateNewSourceAssociationToProduct(String vendor, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sourceConfigName));
			String sourceConfigNameValue = sourceConfigName.getText();
			if (sourceConfigNameValue.contains(vendor)) {
				System.out.println("New Source is correctly associated with the product.");
				test.log(Status.PASS,
						"Validation: New Source is correctly associated with the product: " + sourceConfigNameValue);
				addSrceenShot("New Source Association Validation", test, Capture);
			} else {
				System.out.println("New Source is not correctly associated with the product.");
				test.log(Status.FAIL, "Validation: New Source is not correctly associated with the product.");
				addSrceenShot("New Source Association Validation Failed", test, Capture);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Validation: New Source association check failed due to an exception.");
			addSrceenShot("New Source Association Validation Exception", test, Capture);
		}
	}

	@FindBy(xpath = "//*[text()='Sourcing']")
	private WebElement srcTab;

	@FindBy(xpath = "//*[text()='Sourcing']//following::ul[1]/li[1]/a/span[2]")
	private WebElement srcSummary;

	@FindBy(xpath = "//*[@id='select2-sourcingConfigId-container']")
	private WebElement source;

	@FindBy(xpath = "//*[@id='sourcingConfigId']/option[2]")
	private WebElement sourceValue;

	@FindBy(xpath = "//*[@id='lscoIsPrimarySource']/div[2]")
	private WebElement primarySrc;

	@FindBy(xpath = "//*[@id='lscoIsCustomSource']/div[2]")
	private WebElement customSrc;

	@FindBy(xpath = "//*[text()='Sourcing Configuration']//following::div[1]")
	private WebElement srcConfigName;

	@FindBy(xpath = "//*[@id='lscoSourceName']/div[2]")
	private WebElement srcName;

	@FindBy(xpath = "//*[@id='lscoVendor']/div[2]")
	private WebElement vendor;

	@FindBy(xpath = "//*[@id='actions-menu']/div/img")
	private WebElement edit;

	@FindBy(xpath = "//*[@id='removeSTSL']/span")
	private WebElement removeSrc;

	@FindBy(xpath = "//*[@id='product-context-selector']/div[2]/div/div[1]")
	private WebElement sourceBox;

	public void removeSourceFromSeason(ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String srcBoxName = sourceBox.getText();
		StringBuilder digitStr = new StringBuilder();
		for (char c : srcBoxName.toCharArray()) {
			if (Character.isDigit(c)) {
				digitStr.append(c);
			}
		}
		if (digitStr.length() > 0) {
			int digit = Integer.parseInt(digitStr.toString());
			if (digit > 1) {

				String actSrcVal = sourceValue.getText();
				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(edit)).click();
				addSrceenShot("Clicked on edit", test, Capture);

				new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(removeSrc)).click();
				addSrceenShot("Clicked on remove source", test, Capture);
				test.log(Status.INFO,
						"Clicked on 'Remove Source From Season' from 'Actions:' drop down of 'Sourcing Details' Page");

				if (new WebDriverWait(driver, 60).until(ExpectedConditions.alertIsPresent()) != null) {
// Switch to the alert and accept it
					Alert alt = driver.switchTo().alert();
					String ActalertMsg = alt.getText();
					String ExpalertMsg = "Are you sure you want to remove the Sourcing Configuration?";
					Assert.assertEquals(ActalertMsg, ExpalertMsg);
					Thread.sleep(2000);
					alt.accept();
					System.out.println("Alert was present and accepted: " + ActalertMsg);
					test.log(Status.PASS, "Source Is Removed from Season: " + ActalertMsg);

				} else {
					System.out.println("No alert was present");
					test.log(Status.PASS, "Source Is Not Removed from Season");
					addSrceenShot("No alert was present", test, Capture);

				}
			}

			else {
				System.out.println("More than one source is not available for the product");
			}
		}

	}

	public boolean isSourceRemovedFromDropDown(String sourceName) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

// Click to open the dropdown
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(sourceDropDown));
		Thread.sleep(2000);
		sourceDropDown.click();
		Thread.sleep(2000);
		List<WebElement> sourcesList = driver.findElements(By.xpath("//select[@id='sourcingConfigId']//option"));
		for (WebElement src : sourcesList) {
			if (src.getText().equals(sourceName)) {
				return false;
			}
		}
		return true;
	}

	@FindBy(xpath = "//button[@title='Options']")
	private WebElement settings;

	@FindBy(xpath = "//span[@id='pr_id_4_label']")
	private WebElement level_DD;

	@FindBy(xpath = "//li[@aria-label='Colorway']")
	private WebElement colorway_value;

	@FindBy(xpath = "//button[@title='Apply Changes']")
	private WebElement ApplyChanges;

	@FindBy(xpath = "//div[contains(text(),'Include All Sources')]/following::div[2]")
	private WebElement includeAllSources;

	public void SelectColorway(ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			settings.click();
			level_DD.click();
			colorway_value.click();
			System.out.println("Colorway selected");
			WaitforPage(5000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void SelectIncludeAllSources(ExtentTest test) throws Exception {
		WebElement checkbox = driver
				.findElement(By.xpath("//div[contains(text(),'Include All Sources')]/following::div[2]"));
		String chkboxStatus = checkbox.getAttribute("class");
		if (!(chkboxStatus.contains("checked"))) {
			checkbox.click();
		} else {
			System.out.println("Checkbox was already selected");
		}
		System.out.println("Include All Sources selected");
		WaitforPage(5000);
	}

	public void clickOnApply(ExtentTest test) throws Exception {
		ApplyChanges.click();
		WaitforPage(8000);
	}

	public boolean isRemovedSourceVisible(String sourceName) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
//		Thread.sleep(4000);
//
//		ArrayList<String> header = new ArrayList<String>();
//		header = ViewEditRemoveSourceToColorwayColumnHeaderValue();
//		for (int i = 0; i < 8; i++) {
//			String ColumnHeader = header.get(i);
//			scroll(i + 3);
//			System.out.println(ColumnHeader);
//			if (ColumnHeader.equals("Vendor")) {
		
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft = document.querySelector('.ag-body-horizontal-scroll-viewport').scrollWidth");
		Thread.sleep(3000);


				List<WebElement> vendorElements = driver.findElements(By.xpath(
						"(//div[@col-id='source.lscoVendor|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])//a"));
				if (vendorElements.isEmpty()) {
					return false; // If no vendor elements are found, return false
				} else {
					for (WebElement vendorElement : vendorElements) {
						String vendorText = vendorElement.getText().trim();
                        // Remove the prefix ending with " - - "
						if (vendorText.contains(" -  - ")) {
							vendorText = vendorText.split(" -  - ")[1].trim();
						}
						if (vendorText.equals(sourceName)) {
							return true; // If element is found, return true
						}
					}
					return false; // If element is not found, return false
				}
			
	}

	public void linkSourceToColorway(String sourceName, ExtentTest test) throws Exception {
        // Navigate to the "Link Source to Colorway" view
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft = document.querySelector('.ag-body-horizontal-scroll-viewport').scrollWidth");
		Thread.sleep(3000);

        // Select the "Link Source to Colorway" view
		Actions action = new Actions(driver);
		action.doubleClick(Vendor_List_Value).perform();
		Thread.sleep(2000);
		text_feild.sendKeys(sourceName);
		Thread.sleep(3000);
		action.click(checkbox).perform();

        //action.moveToElement(checkbox).click().build().perform();
		Thread.sleep(3000);
		test.log(Status.INFO, "Selected vendor: " + sourceName);
		Thread.sleep(1000);
		text_feild.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

        // Save the linesheet
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(saveBtnn));
		saveBtnn.click();
		test.log(Status.INFO, "Saved the linesheet");
		addSrceenShot("Saved the linesheet", test, Capture);
		Thread.sleep(60000);
	}

	public boolean isSourceLinkedToColorway(String sourceName, ExtentTest test) throws Exception {
        // Navigate to the "View/Edit/Remove Source to Colorway" view
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
//		Thread.sleep(30000);
// Check if the source is associated with the colorway/product
//		ArrayList<String> header = ViewEditRemoveSourceToColorwayColumnHeaderValue();
//		for (int i = 0; i < header.size(); i++) {
//			String ColumnHeader = header.get(i);
//			scroll(i + 3);
//			System.out.println(ColumnHeader);
//			if (ColumnHeader.equals("Vendor")) {
		
		Thread.sleep(20000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft = document.querySelector('.ag-body-horizontal-scroll-viewport').scrollWidth");
		Thread.sleep(3000);
		
				List<WebElement> vendorElements = driver.findElements(By.xpath(
						"(//div[@col-id='source.lscoVendor|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])//a"));
				if (vendorElements.isEmpty()) {
					return false; // If no vendor elements are found, return false
				} else {
					for (WebElement vendorElement : vendorElements) {
						String vendorText = vendorElement.getText().trim();
// Remove the prefix ending with " - - "
						if (vendorText.contains(" -  - ")) {
							vendorText = vendorText.split(" -  - ")[1].trim();
						}
						if (vendorText.contains(sourceName)) {
							return true; // If element is found, return true
						}
					}
					return false; // If element is not found, return false
				}
			}

	@FindBy(xpath = "(//div[@col-id='product.productName|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])[2]//a")
	private WebElement productNameElement_Value;

	@FindBy(xpath = "(//div[@col-id='source.lscoVendor|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])[2]//a")
	private WebElement Vendor_Value;

	public String getProduct_Name(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productNameElement_Value));
		String productName = productNameElement_Value.getText();
		return productName;
	}

	public String extractVendorName(String vendorName) {
// Define the regex pattern to match the desired part
		Pattern pattern = Pattern.compile(" -  - (.*?)(\\s+\\d+\\s+[A-Z]{2})?$");
		Matcher matcher = pattern.matcher(vendorName);

		if (matcher.find()) {
			return matcher.group(1).trim();
		} else {
			return vendorName; // Return the original if no match is found
		}
	}

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoRemoveLink|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])[2]")
	private WebElement delink_SourceToColorway_Value;
	
	public String setDelinkSourceToColorwayToYes(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			Thread.sleep(10000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft = document.querySelector('.ag-body-horizontal-scroll-viewport').scrollWidth");
			Thread.sleep(2000);

			String vendorName = Vendor_Value.getText();
			test.log(Status.INFO, "Source Name: " + vendorName);
			System.out.println("Source Name: " + vendorName);
			addSrceenShot("Source Name", test, Capture);
			vendorName = extractVendorName(vendorName);

			Actions action = new Actions(driver);
			action.doubleClick(delink_SourceToColorway_Value).perform();
			Thread.sleep(2000);
			WebElement option = driver.findElement(By.xpath("//span[@title='Yes']"));
			option.click();
			Thread.sleep(2000);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			saveBtnn.click();
			Thread.sleep(7000);
			test.log(Status.INFO, "Saved the linesheet");
			addSrceenShot("Saved the linesheet", test, Capture);

			return vendorName;
		} catch (Exception e) {
			test.log(Status.FAIL, "delink_Source To Colorway Header is not found: " + e.getMessage());
			addSrceenShot("delink_Source To Colorway Header is not found", test, Capture);
			return ""; // Stop further execution
		}
	}

	@FindBy(xpath = "//div[contains(text(), 'Colorway Name')]/following-sibling::div")
	private WebElement ColorWay_DropDown;

	public boolean isColorwayVisibleUnderDropdown(String colorWayName) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

// Click to open the dropdown
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ColorWay_DropDown));
		Thread.sleep(2000);
		ColorWay_DropDown.click();
		Thread.sleep(2000);
		List<WebElement> colorwaysList = driver.findElements(By.xpath("//select[@id='contextSKUId']//option"));
		for (WebElement colorway : colorwaysList) {
			if (colorway.getText().equals(colorWayName)) {
				return false;
			}
		}
		return true;
	}

	public boolean isDlinkSourceVisible(String sourceName) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);

		List<WebElement> vendorElements = driver.findElements(By.xpath(
				"(//div[@col-id='source.lscoVendor|~*~|SourceConfig-View/Edit/RemoveSourcetoColorwayLink'])//a"));
		if (vendorElements.isEmpty()) {
			return false; // If no vendor elements are found, return false
		} else {
			for (WebElement vendorElement : vendorElements) {
				String vendorText = vendorElement.getText().trim();
                // Remove the prefix ending with " - - "
				if (vendorText.contains(" -  - ")) {
					vendorText = vendorText.split(" -  - ")[1].trim();
				}
				if (vendorText.equals(sourceName)) {
					return true; // If element is found, return true
				}
			}
			return false; // If element is not found, return false
		}
	}

	public String getSourceName() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceConfigName));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sourceConfigName);
		Thread.sleep(2000);
		String sourceName = sourceConfigName.getText();
		return sourceName;
	}

	public String getSpecificationName() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		specificationDropDown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(specificationFirstoptn));
		String specName = specificationFirstoptn.getText();
		specificationDropDown.click();

		return specName;
	}

	public void selectVendors_FromList(List<String> vendorNames, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft = document.querySelector('.ag-body-horizontal-scroll-viewport').scrollWidth");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(Vendor_List_Value).doubleClick().build().perform();
		for (String vendorName : vendorNames) {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//li[@aria-label='" + vendorName + "']/div/div"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
			Thread.sleep(2000);

		}
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		test.log(Status.INFO, "Selected vendors from Vendor List: " + String.join(", ", vendorNames)); // names
		addSrceenShot("Selected vendors from Vendor List", test, Capture);
		Thread.sleep(2000);

	}
}
