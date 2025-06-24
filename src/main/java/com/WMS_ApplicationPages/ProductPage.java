package com.WMS_ApplicationPages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.relevantcodes.extentreports.LogStatus;

public class ProductPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
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

	@FindBy(xpath = "//div[normalize-space()='* Class (Product Hierarchy)']/following-sibling::div[1]")
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
	// div[contains(text(),'Product Sub Cat 1')]/following-sibling::div
	private WebElement productNameText;

	@FindBy(xpath = "//div[@class='single-list-body']//select")
	private WebElement seasonDropdown;

	@FindBy(xpath = "//div[@class='single-list-body']/select[@name='selectedSeasonId']")
	private WebElement seasonDropdown1;

	@FindBy(xpath = "//center[contains(text(),'Logged Out')]")
	private WebElement logoutText;

	private static By productTypeOption = By.xpath("//a[.='<productType>']");

	@FindBy(xpath = "//div[contains(text(),'Brand Hierarchy')]/following-sibling::div")
	private WebElement brandHierarchyDropDown;

	@FindBy(xpath = "//div[contains(text(), 'Season')]/following-sibling::div")
	private WebElement seasonDropDown;

	@FindBy(xpath = "//div[contains(text(),'Product Sub Cat 1')]/following-sibling::div")
	private WebElement proSubCat1DropDown;

	@FindBy(xpath = "//div[contains(text(),'Product Sub Cat 2')]/following-sibling::div")
	private WebElement proSubCat2DropDown;

	@FindBy(xpath = "(//div[contains(text(), 'Class (Product Hierarchy)')]/following-sibling::div[1])[1]")
	// div[contains(text(),'Class (Product Hierarchy)')]/following-sibling::div[1]
	private WebElement classDropDown;

	@FindBy(xpath = "//div[contains(text(),'Sub Class (Product Hierarchy)')]/following-sibling::div[1]")
	private WebElement subClassDropDown;

	@FindBy(xpath = "//div[contains(text(),'Consumer (Product Hierarchy)')]/following-sibling::div[1]")
	private WebElement consumerDropDown;

	@FindBy(xpath = "//div[contains(text(),'Consumer Group 1')]/following-sibling::div[1]")
	private WebElement consumerGrp1DropDown;

	@FindBy(xpath = "//div[contains(text(),'Consumer Group 2')]/following-sibling::div[1]")
	private WebElement consumerGrp2DropDown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement searchField;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement searchOption;

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

	@FindBy(xpath = "//span[contains(text(),'Sourcing')]/following::span[contains(text(),'Summary')][1]")
	private WebElement summaryOptn;

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

	@FindBy(xpath = "//div[normalize-space()='Name']/following-sibling::div")
	private WebElement PC5CodeName;

	@FindBy(xpath = "//div[@class='sourcing-toolbar']/child::div")
	private WebElement primarySourceAttribute;

	@FindBy(xpath = "//div[normalize-space()='Sourcing Configuration']/following-sibling::div")
	private WebElement sourcingConfigNameInput;

	@FindBy(xpath = "//div[contains(text(),'Product Country of Origin')]/following-sibling::div")
	private WebElement countryOfOrigin;

	@FindBy(xpath = "//select[@id='sourcingConfigId']/ancestor::div[1]")
	private WebElement sourceDropdown;

	@FindBy(xpath = "//a[@id='updateSourcingConfig']/child::img")
	private WebElement sourceUpdateIcon;

	@FindBy(xpath = "//a[contains(text(),'Vendor:')]")
	private WebElement vendorLink;

	@FindBy(xpath = "//div[normalize-space()='Name']/following-sibling::div")
	// div[normalize-space()='Name']/following-sibling::div
	private WebElement updatedSourceDetails;
	
	
	
	
	@FindBy(xpath = "//div[normalize-space()='Product Category']/following-sibling::div")
	private WebElement productCategoryElement;

	@FindBy(xpath = "//div[normalize-space()='Product Sub Cat 1']/following-sibling::div")
	private WebElement productSubCat1Element;

	@FindBy(xpath = "//div[normalize-space()='Product Sub Cat 2']/following-sibling::div")
	private WebElement productSubCat2Element;

	@FindBy(xpath = "//div[contains(text(),'Customs Classification')]/following-sibling::div[1]")
	private WebElement customsClassificationDropDown;

	@FindBy(xpath = "//div[normalize-space()='Class (Product Hierarchy)']/following-sibling::div")
	private WebElement classPHTEXT;

	public String getProductCategory() {
		// Locate the element that displays the style type
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productCategoryElement));
		String productCategory = productCategoryElement.getText();

		return productCategory;
	}

	public String getProductSubCat1() {
		// Locate the element that displays the style type
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productSubCat1Element));
		String productSubCat1 = productSubCat1Element.getText();

		return productSubCat1;
	}

	public String getProductSubCat2() {
		// Locate the element that displays the style type
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productSubCat2Element));
		String productSubCat2 = productSubCat2Element.getText();

		return productSubCat2;
	}

	public void updateProduct(String updatedProductName, String updatedBrandHierarchy, String updatedClassValue,
			String updatedSubClassValue, String updatedProSubCat1, String updatedProSubCat2, String updatedConsumer,
			String updatedConsumerGrp1, String updatedConsumerGrp2, String updatedCustomsClassification,
			ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(productNameText));
		productNameText.clear();
		Thread.sleep(1000);
		productNameText.sendKeys(updatedProductName);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandHierarchyDropDown));
		brandHierarchyDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedBrandHierarchy);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(classDropDown));
		classDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedClassValue);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(subClassDropDown));
		subClassDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedSubClassValue);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(proSubCat1DropDown));
		proSubCat1DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedProSubCat1);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(proSubCat2DropDown));
		proSubCat2DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedProSubCat2);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerDropDown));
		consumerDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumer);
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp1DropDown));
		consumerGrp1DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumerGrp1);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp2DropDown));
		consumerGrp2DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumerGrp2);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(customsClassificationDropDown));
		customsClassificationDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedCustomsClassification);
		Thread.sleep(5000);
		searchResult.click();

		test.log(Status.INFO,
				"Updated product details: Updated Product Name - " + updatedProductName + ", Brand Hierarchy - "
						+ updatedBrandHierarchy + ", Product Sub Category 1 - " + updatedProSubCat1
						+ ", Product Sub Category 2 - " + updatedProSubCat2 + ", Class - " + updatedClassValue
						+ ", Sub Class - " + updatedSubClassValue + ", Consumer - " + updatedConsumer
						+ ", Consumer Group 1 - " + updatedConsumerGrp1 + ", Consumer Group 2 - " + updatedConsumerGrp2
						+ ", Customs Classification - " + updatedCustomsClassification);
		addSrceenShot("Updated product details", test, Capture);
	}

	public void updateProduct_SetUpLSE_LSUS(String updatedBrandHierarchy, String updatedClassValue,String updatedSubClassValue, String updatedProSubCat1,
			String updatedProSubCat2, String updatedConsumer,String updatedConsumerGrp1, String updatedConsumerGrp2, String updatedCustomsClassification,ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);


		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandHierarchyDropDown));
		brandHierarchyDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedBrandHierarchy);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(classDropDown));
		classDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedClassValue);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(subClassDropDown));
		subClassDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedSubClassValue);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(proSubCat1DropDown));
		proSubCat1DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedProSubCat1);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(proSubCat2DropDown));
		proSubCat2DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedProSubCat2);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerDropDown));
		consumerDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumer);
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp1DropDown));
		consumerGrp1DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumerGrp1);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp2DropDown));
		consumerGrp2DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumerGrp2);
		Thread.sleep(5000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(customsClassificationDropDown));
		customsClassificationDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedCustomsClassification);
		Thread.sleep(5000);
		searchResult.click();
		
		

		test.log(Status.INFO,
				"Updated product details:  Brand Hierarchy - "
						+ updatedBrandHierarchy + ", Product Sub Category 1 - " + updatedProSubCat1
						+ ", Product Sub Category 2 - " + updatedProSubCat2 + ", Class - " + updatedClassValue
						+ ", Sub Class - " + updatedSubClassValue + ", Consumer - " + updatedConsumer
						+ ", Consumer Group 1 - " + updatedConsumerGrp1 + ", Consumer Group 2 - " + updatedConsumerGrp2
						+ ", Customs Classification - " + updatedCustomsClassification);
		addSrceenShot("Updated product details", test, Capture);
	}

	
	
	public void selectSourceFromDropDown(String sourceName, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(sourceDropdown));
		sourceDropdown.click();

//		WebElement src = driver.findElement(By.xpath("//select[@id='sourcingConfigId']//option"));

		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='sourcingConfigId']//option"));

		for (WebElement option : options) {
			if (option.getAttribute("title").contains(sourceName)) {
				option.getText();
				System.out.println("option");
				test.log(Status.INFO, "source: " + option.getText());
				option.click();

				break;
			}
		}
	}
	
	public String verifySourceDetails(String sourceName, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// Locate the element that displays the source name
		try {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(updatedSourceDetails));
 
		String actualSourceName = updatedSourceDetails.getText();
		if (!actualSourceName.equals(sourceName)) {
			System.out.println("Updated source '"+sourceName+"' To '" + actualSourceName);
			test.log(Status.PASS, "Updated source from '"+sourceName+" ' To ' " + actualSourceName);
			addSrceenShot("Updated source details", test, Capture);
 
        }
		return actualSourceName;
		} catch (Exception e) {			
	        return null;
		}
	}
 
	public boolean isVendorAlreadySourceConfigured() {
	    try {
	        WebElement messageElement = driver.findElement(By.xpath("//div[@class='error-message']"));
	        return messageElement.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	public boolean verifyUpdatedProductAttributes(String updatedProductName, String updatedBrandHierarchy,
			String updatedClassValue, String updatedSubClassValue, String updatedProSubCat1, String updatedProSubCat2,
			String updatedConsumer, String updatedConsumerGrp1, String updatedConsumerGrp2,
			String updatedCustomsClassification, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(productCategoryElement));
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		String actualProductName = productNameElement.getText();
		test.log(Status.INFO, "Product is updated with updated attributes: "+actualProductName);
		if (!actualProductName.contains(updatedProductName)) {
			return false;
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		String actualBrandHierarchy = brandHierarchyDropDown.getText();
		if (!actualBrandHierarchy.equals(updatedBrandHierarchy)) {
			return false;
		}

		String actualClassValue = classPHTEXT.getText();
		if (!actualClassValue.equals(updatedClassValue)) {
			return false;
		}

		String actualSubClassValue = subClassDropDown.getText();
		if (!actualSubClassValue.equals(updatedSubClassValue)) {
			return false;
		}

		String actualProSubCat1 = proSubCat1DropDown.getText();
		if (!actualProSubCat1.equals(updatedProSubCat1)) {
			return false;
		}

		String actualProSubCat2 = proSubCat2DropDown.getText();
		if (!actualProSubCat2.equals(updatedProSubCat2)) {
			return false;
		}

		String actualConsumer = consumerDropDown.getText();
		if (!actualConsumer.equals(updatedConsumer)) {
			return false;
		}

		String actualConsumerGrp1 = consumerGrp1DropDown.getText();
		if (!actualConsumerGrp1.equals(updatedConsumerGrp1)) {
			return false;
		}

		String actualConsumerGrp2 = consumerGrp2DropDown.getText();
		if (!actualConsumerGrp2.equals(updatedConsumerGrp2)) {
			return false;
		}

		return true;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Include Merch Fabric Type in CW Name')]/following-sibling::div[1]")
	private WebElement includeMerchFabricTypeinCWNameDropDown;

	@FindBy(xpath = "//div[contains(text(),'Code Type')]/following-sibling::div[1]")
	private WebElement codeTypeDropDown;
	
	@FindBy(xpath = "//div[contains(text(),'Product Type')]/following-sibling::div[1]")
	private WebElement productTypeDropDown;
	
	@FindBy(xpath = "//div[contains(text(),'Product Report Characteristics')]/following-sibling::div[1]")
	private WebElement productReportCharacteristicsField;

	@FindBy(xpath = "//div[contains(text(),'Dimensions')]/following-sibling::div[1]/input")
	private WebElement dimensionsField;
	
	@FindBy(xpath = "//div[contains(text(),'Dimensions')]/following-sibling::div[1]")
	private WebElement dimensionsFieldElement;
	
	@FindBy(xpath = "//div[contains(text(),'Type of closure')]/following-sibling::div[1]")
	private WebElement typeOfClosureField;

	@FindBy(xpath = "//div[contains(text(),'Fit Reference')]/following-sibling::div[1]")
	private WebElement fitReferenceField;
	
	@FindBy(xpath = "//div[contains(text(),'Capacity')]/following-sibling::div[1]/input")
	private WebElement capacityField;
	
	@FindBy(xpath = "//div[contains(text(),'Capacity')]/following-sibling::div[1]")
	private WebElement capacityFieldElement;
	
	
	public void selectcustomsClassification(String customsClassification) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(customsClassificationDropDown));
		customsClassificationDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(customsClassification);
		Thread.sleep(5000);
		searchResult.click();
		Thread.sleep(2000);
	}

	public void fillNonMandatoryFieldsinCreateProduct(String includeMerchFabricTypeinCWName, String codeType, String productType,
			String productReportCharacteristics, String dimensions, String typeOfClosure, String fitReference,
			String capacity, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(includeMerchFabricTypeinCWNameDropDown));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", includeMerchFabricTypeinCWNameDropDown);
		includeMerchFabricTypeinCWNameDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(includeMerchFabricTypeinCWName);
		Thread.sleep(5000);
		searchResult.click();
		test.log(Status.INFO, "Selected Include Merch Fabric Type in CW Name: " + includeMerchFabricTypeinCWName);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(codeTypeDropDown));
		codeTypeDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(codeType);
		Thread.sleep(5000);
		searchResult.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Selected Code Type: " + codeType);
		
		try {
			productTypeDropDown.click();
			Thread.sleep(2000);
			searchField.clear();
			searchField.sendKeys(productType);
			Thread.sleep(5000);
			searchResult.click();
			test.log(Status.INFO, "Selected Product Type: " + productType);
		} catch (Exception e) {
			test.log(Status.INFO, "Product Type DropDown not found or an error occurred, skipping this step. Exception");
		}
	
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productReportCharacteristicsField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productReportCharacteristicsField);
		productReportCharacteristicsField.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(productReportCharacteristics);
		Thread.sleep(5000);
		searchResult.click();
		Thread.sleep(2000);		
		test.log(Status.INFO, "Entered Product Report Characteristics: " + productReportCharacteristics);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(dimensionsField));
		dimensionsField.clear();
		dimensionsField.sendKeys(dimensions);
		test.log(Status.INFO, "Entered Dimensions: " + dimensions);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(typeOfClosureField));
		typeOfClosureField.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(typeOfClosure);
		Thread.sleep(5000);
		searchResult.click();
		Thread.sleep(2000);			
		test.log(Status.INFO, "Entered Type of Closure: " + typeOfClosure);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fitReferenceField));
		fitReferenceField.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(fitReference);
		Thread.sleep(5000);
		searchResult.click();
		Thread.sleep(2000);			
		test.log(Status.INFO, "Entered Fit Reference: " + fitReference);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(capacityField));
		capacityField.clear();
		capacityField.sendKeys(capacity);
		test.log(Status.INFO, "Entered Capacity: " + capacity);
		Thread.sleep(4000);			
	}
	
	public boolean verifyNonRequiredAttributes(String codeType, String productReportCharacteristics, String dimensions, String typeOfClosure, String fitReference, String capacity, ExtentTest test) throws InterruptedException {

	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(iframeContentframe);
	    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productSubCat1Element));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", includeMerchFabricTypeinCWNameDropDown);

	    String isCodeTypeCorrect = codeTypeDropDown.getText();
	    String isProductReportCharacteristicsCorrect = productReportCharacteristicsField.getText();
	    String isDimensionsCorrect = dimensionsFieldElement.getText();
	    String isTypeOfClosureCorrect = typeOfClosureField.getText();
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeOfClosureField);
	    String isFitReferenceCorrect = fitReferenceField.getText();
	    String isCapacityCorrect = capacityFieldElement.getText();
	    Thread.sleep(3000);

	    boolean allFieldsVerified = isCodeTypeCorrect.equals(codeType) &&
	                                isProductReportCharacteristicsCorrect.equals(productReportCharacteristics) &&
	                                isDimensionsCorrect.equals(dimensions) &&
	                                isTypeOfClosureCorrect.equals(typeOfClosure) &&
	                                isFitReferenceCorrect.equals(fitReference) &&
	                                isCapacityCorrect.contains(capacity);

	    if (allFieldsVerified) {
	        test.log(Status.INFO, "Non-required attributes were filled successfully.");
			addSrceenShot("Non-required attributes were filled successfully.", test, Capture);
	    } else {
	        test.log(Status.FAIL, "Verification: Non-required attributes were not filled in successfully.");
			addSrceenShot("Non-required attributes were not filled successfully.", test, Capture);
	    }

	    return allFieldsVerified;
	}


	String currentTest;
	boolean Capture = true;

	public void clikOnNewBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(newBtn));
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
		clickElement(newBtn);
	}

	public void chooseProductType(String seasonType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(productTypeLink));
		clickElement(productTypeLink);
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
	}

	public void enterProductName(String value) throws Exception {
		driver.switchTo().defaultContent();
		// driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(productNameText));
		sendInputToTextField(productNameText, value, " ' Product Name ");
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

		// seasonDropdown
	}

	/**
	 * Function to click Vertical button
	 * 
	 * @throws Exception
	 */
	public void clikOnVerticalBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(vertical));
		clickElement(vertical);
	}

	/**
	 * Function to click product type
	 * 
	 * @throws Exception
	 */
	public void clikOnProductType() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(productType));
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
		clickElement(productType);
	}

	public void switchToWindowTitle() throws Exception {

		try {

			String ParentWinhadle = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);

			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	/**
	 * Function to select product type option
	 * 
	 * @throws Exception
	 */
	public void selectProductType(String option) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		try {
			this.clikOnProductType();
			String parentWindow = driver.getWindowHandle();
			this.switchToWindowTitle();
			By.xpath("//a[.='<productType>']");
			String locator = productTypeOption.toString().replace("By.xpath:", "").replace("<productType>",
					option.trim());
			WebElement ele = driver.findElement(By.xpath(locator));
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ele));
			clickElement(ele);
			driver.switchTo().window(parentWindow);
		} catch (Exception e) {
			String parentWindow = driver.getWindowHandle();
			driver.switchTo().window(parentWindow);
		}
	}
	/*
	 * public CreateNewProductPage clickOnToProductType(String materialType) throws
	 * Exception{ driver.switchTo().defaultContent();
	 * driver.switchTo().frame(iframeContentframe);
	 * 
	 * this.click("//a[text()='"+materialType+"']", "Product Type :-"+materialType);
	 * return new CreateNewProductPage(driver,currentTest);
	 * 
	 * }
	 */

	public void selectSeasonType(String seasonType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonDropDown));
		seasonDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(seasonType);
		Thread.sleep(3000);
		searchResult.click();
	}

	public void selectBrandHierarchy(String brandHierarchy) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandHierarchyDropDown));
		brandHierarchyDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(brandHierarchy);
		Thread.sleep(4000);
		searchResult.click();
	}

	public void selectProSubCat1(String proSubCat1) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(proSubCat1DropDown));
		proSubCat1DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(proSubCat1);
		Thread.sleep(4000);
		searchResult.click();
	}

	public void selectProSubCat2(String proSubCat2) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(proSubCat2DropDown));
		proSubCat2DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(proSubCat2);
		Thread.sleep(4000);
		searchResult.click();
	}

	public void selectClass(String classValue) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(classDropDown));
		classDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(classValue);
		Thread.sleep(4000);
		searchResult.click();
	}

	public void selectSubClass(String subClassValue) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(subClassDropDown));
		subClassDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(subClassValue);
		Thread.sleep(4000);
		searchResult.click();
	}

	public void selectConsumer(String consumer) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerDropDown));
		consumerDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(consumer);
		Thread.sleep(4000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
	}

	public void selectConsumerGrp1(String consumerGrp1) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp1DropDown));
		consumerGrp1DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(consumerGrp1);
		Thread.sleep(4000);
		searchResult.click();
	}

	public void selectConsumerGrp2(String consumerGrp2) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp2DropDown));
		consumerGrp2DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(consumerGrp2);
		Thread.sleep(4000);
		searchResult.click();
	}
	
	public void selectCustomclassification() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp2DropDown));
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
		if (isDisplayed) {
			test.log(Status.PASS, "PC5 Details Page displayed: " + isDisplayed);
			addSrceenShot("PC5 Details Page displayed", test, Capture);
		} else {
			test.log(Status.FAIL, "PC5 Details Page not displayed.");
			addSrceenShot("PC5 Details Page not displayed", test, Capture);
		}

		return isDisplayed;
	}

//public void selectBrandHierarchy() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		System.out.println("test:" );
//		driver.switchTo().frame(iframeContentframe);
//		Thread.sleep(6000);
//			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(BrandHierarchyDropdown));
//		driver.findElement(By.xpath("//div[contains(text(),'Brand Hierarchy')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")).click();
//		Thread.sleep(4000);
//		WebElement HierarcyValue=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_22select-results']/li[1]"));
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		HierarcyValue.click();
//		System.out.println("selected the Brand :");
//	}
//		catch (Exception e) {
//			System.out.println("selected the Brand :" );
//			driver.findElement(By.xpath("//select[@name='ptc_str_22select']")).click();
//		}
//		}

	public void selectCapsule() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Thread.sleep(6000);
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CapsuleDropdown));
			driver.findElement(By.xpath("//span[@id='select2-ptc_str_6-container']")).click();
			Thread.sleep(4000);
			WebElement capsuleValue = driver.findElement(By.xpath("//ul[@id='select2-ptc_str_6-results']/li[2]"));
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			capsuleValue.click();
			System.out.println("selected the Brand :");
		} catch (Exception e) {
			System.out.println("selected the Brand :");
			driver.findElement(By.xpath("//select[@name='ptc_str_22select']")).click();
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

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchField));
		searchField.sendKeys(colourWayName);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchOption));
		searchOption.click();

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

	public void clickOnSummary() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(summaryOptn));
		summaryOptn.click();

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

	public String isPrimarySourceCreated(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceDropDown));
		sourceDropDown.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchField));
		searchField.sendKeys("Primary");
		Thread.sleep(2000);
//	        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(PC5CodeName));
		if (searchOption.isDisplayed()) {
			String primarySourceText = searchOption.getText();
			System.out.println("Primary source text: " + primarySourceText);
			test.log(Status.PASS, "Primary source text: " + primarySourceText);
			searchOption.click();
			test.log(Status.INFO, "Source was selected successfully: " + primarySourceText);
			addSrceenShot("Source was selected successfully", test, Capture);

			return primarySourceText;
		} else {
			return null;
		}
	}

	public void verifyAttributes(ExtentTest test) throws Exception {
		// Verify Primary Source attribute
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String primarySourceAttributeText = primarySourceAttribute.getText();
		System.out.println("Primary Source attribute: " + primarySourceAttributeText);
		test.log(Status.PASS, "Primary Source attribute: " + primarySourceAttributeText);
		addSrceenShot("Primary Source attribute", test, Capture);

		// Verify Sourcing configuration name
		String sourcingConfigName = sourcingConfigNameInput.getText();
		System.out.println("Sourcing configuration name: " + sourcingConfigName);
		test.log(Status.PASS, "Sourcing configuration name: " + sourcingConfigName);
		addSrceenShot("\"Sourcing configuration name", test, Capture);

		// Verify Vendor and Product country of Origin
		String countryOfOriginText = countryOfOrigin.getText();
		if (countryOfOriginText.isEmpty()) {
			System.out.println("Vendor and Product country of Origin is set to blank");
			test.log(Status.PASS, "Vendor and Product country of Origin is set to blank");
			addSrceenShot("Vendor and Product country of Origin is set to blank", test, Capture);

		} else {
			System.out.println("Vendor and Product country of Origin is not blank" + countryOfOriginText);
			test.log(Status.FAIL, "Vendor and Product country of Origin is not blank: " + countryOfOriginText);
		}

	}


	public void clickOnUpdateSource() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(sourceUpdateIcon));
		sourceUpdateIcon.click();

	}

	public void clickOnVendorLink() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(vendorLink));
		vendorLink.click();

	}

	public void selectVendor(String vendor, ExtentTest test) throws Exception {

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(vendor);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		test.log(Status.INFO, "Selected Vendor: " + vendor);
		addSrceenShot("Selected Vendor", test, Capture);
		driver.switchTo().window(ParentWinhadle);

	}

	public String verifySourceDetails(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// Locate the element that displays the source name
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(updatedSourceDetails));

		String actualSourceName = updatedSourceDetails.getText();
		System.out.println("Updated source details: " + actualSourceName);
		test.log(Status.PASS, "Updated source details: " + actualSourceName);
		addSrceenShot("Updated source details", test, Capture);
		return actualSourceName;
	}

	public String verifyUpdatedSource(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(updatedSourceDetails));

		// Get the text of the updated source details
		String updatedSourceText = updatedSourceDetails.getText();
		System.out.println("Updated source details: " + updatedSourceText);
		test.log(Status.PASS, "Updated source details: " + updatedSourceText);
		addSrceenShot("Updated source details", test, Capture);

		return updatedSourceText;
	}

//	public void selectProSubCat1() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ProductSubCatDropdown));
//			System.out.println("selected selectProSubCat1 :" );
//			driver.findElement(By.xpath("//div[contains(text(),'Product Sub Cat 1')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")).click();
//		WebElement ProductSubCatValue=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_19select-results']/li[2]"));
//		Thread.sleep(2000);
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		ProductSubCatValue.click();
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		System.out.println("selected the Brand :" );
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//select[@name='ptc_str_22select']")).click();
//		}
//		}

//	public void selectProSubCat2() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ProductSubCat2Dropdown));
//			System.out.println("selected selectProSubCat2 :" );
//			driver.findElement(By.xpath("//div[contains(text(),'Product Sub Cat 2')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")).click();
//			Thread.sleep(2000);
//		WebElement ProductSubCatValue=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_20select-results']/li[1]"));
//		Thread.sleep(3000);
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		ProductSubCatValue.click();
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		System.out.println("selected the Brand :" );
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//li[text()='Not Applicable']")).click();
//		}
//		}

//	public void selectClass() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//		//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ClassDropdown));
//			driver.findElement(By.xpath("//div[contains(text(),'Class (Product Hierarchy)')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")).click();
//		WebElement classValue=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_45select-results']/li[3]"));
//		Thread.sleep(2000);
//		classValue.click();
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		System.out.println("selected the selectClass :" );
//		System.out.println("selected the selectClass :" );
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//select[@name='ptc_str_22select']")).click();
//		}
//		}

//	public void selectSubClass() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//			//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SubClassDropdown));
//			driver.findElement(By.xpath("//div[contains(text(),'Sub Class (Product Hierarchy)')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")).click();
//		WebElement subClassValue=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_46select-results']/li[2]"));
//		Thread.sleep(2000);
//		subClassValue.click();
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		System.out.println("selected the Brand :" );
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//ul[@id='select2-ptc_str_46select-results']/child::li")).click();
//		}
//		}

//	public void selectConsumer() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//			//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ConsumerDropdown));
//			driver.findElement(By.xpath("//div[contains(text(),'Consumer (Product Hierarchy)')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")).click();
//		WebElement consumerValue=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_49select-results']/li[1]"));
//		Thread.sleep(2000);
//		consumerValue.click();
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		System.out.println("selected the Brand :" );
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//ul[@class='select2-results__options']/li")).click();
//		}
//		}

//	public void selectConsumerGrp1() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//		//	new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ConsumerGrp1Dropdown));
//			driver.findElement(By.xpath("//div[contains(text(),'Consumer Group 1')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]")).click();
//		WebElement consumerGrp1Value=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_50select-results']/li[1]"));
//		Thread.sleep(2000);
//		consumerGrp1Value.click();
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		System.out.println("selected the Brand :" );
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//span[@class='select2-results']/ul/li")).click();
//		}
//		}

//	public void selectConsumerGrp2() throws Exception {
//		try {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//		//	new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ConsumerGrp2Dropdown));
//			driver.findElement(By.xpath("//div[contains(text(),'Customs Classification')]/following-sibling::div/child::span")).click();
//			Thread.sleep(4000);
//			WebElement consumerGrp2Value=driver.findElement(By.xpath("//ul[@id='select2-ptc_str_51select-results']/li[1]"));
//			Thread.sleep(3000);
//		
//		System.out.println("test");
//		consumerGrp2Value.click();
//		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
//		System.out.println("selected the Brand :" );
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//span[@class='select2-results']/ul/li")).click();
//		}
//		}

	public void selectCostomsClassification() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			driver.findElement(By.xpath(
					"//div[contains(text(),'Consumer Group 2')]/ancestor::div[@class='cascading-div f-attribute-box']/descendant::span[1]"))
					.click();
			Thread.sleep(4000);
			WebElement costomsClassificationValue = driver
					.findElement(By.xpath("//ul[@id='select2-ptc_str_49select-results']/li[1]"));
			Thread.sleep(3000);

			System.out.println("test");
			costomsClassificationValue.click();
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			System.out.println("selected the Brand :");
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@class='select2-results']/ul/li")).click();
		}
	}

	public void selectBrand(String value) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(BrandDropdown));
		this.selectOPtionByVisibleText(BrandDropdown, value.trim(), "Gender :-" + value);
	}

	public void selectSeason(String value) throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(seasonDropdown1));
		this.selectOPtionByVisibleText(seasonDropdown, value.trim(), "Gender :-" + value);
		System.out.println("error:" + seasonDropdown);
		System.out.println("error:" + seasonDropdown);
	}

	public void selectSeason() throws Exception {
		String value = "Denizen S1 2022 Female Bottoms";
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(seasonDropdown1));
		this.selectOPtionByVisibleText(seasonDropdown, value.trim(), "Gender :-" + value);
		System.out.println("error:" + seasonDropdown);
		System.out.println("error:" + seasonDropdown);
	}

	/**
	 * Function to click create button
	 * 
	 * @throws Exception
	 */
	public void clikOnCreateBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(createBtn));
		clickElement(createBtn);
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
	}

	/**
	 * Function to verify season creation
	 * 
	 * @throws Exception
	 */
	public void verifySeasonCreation() throws Exception {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		boolean flag = waitForElement(nameValue);
		System.out.println("Season created successfully :" + flag);
		// assertThat(flag, "Season created successfully", "Season not created", true);
	}

	public boolean waitForElement(WebElement element) throws Exception {
		boolean statusOfTheElement = false;
		WebDriverWait waitSelenium = new WebDriverWait(driver, 50, 500);
		try {
			WebElement waitElement = waitSelenium.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfTheElement = true;
			}
		} catch (Exception ex) {

			statusOfTheElement = false;
		}
		return statusOfTheElement;

	}

	public void selectOPtionByVisibleText(WebElement e, String text, String elementName) throws Exception {
		Thread.sleep(5000);

		try {

			WebDriverWait waitSelenium = new WebDriverWait(driver, 80, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
			e = driver.findElement(By.xpath("//ul[@id='select2-ptc_str_22select-results']/li"));
			// e=driver.findElement(By.xpath("//div[contains(text(),'Brand
			// Hierarchy')]/following::span[@class='select2-selection
			// select2-selection--single'][1]"));
			e.click();
			Select sl = new Select(e);
			sl.selectByVisibleText(text);
			System.out.println("test:" + e + text);
			System.out.println("test:" + e + text);

		} catch (Exception exc) {

			throw new Exception(elementName + " not found because of ::->" + exc.getStackTrace());

		}
	}

	/**
	 * Function to select action value from DD
	 * 
	 * @throws Exception
	 */
	public void selectAction(String value) throws Exception {
		System.out.println("test:" + value);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(actionDD));
		this.selectOPtionByVisibleText(actionDD, value, "Actions Dropdown :-" + value);
		System.out.println("test:" + value);

	}

	/**
	 * Function to click save button
	 * 
	 * @throws Exception
	 */
	public void clikOnSaveBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(saveBtn));
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
		clickElement(saveBtn);
		Thread.sleep(6000);
		System.out.println("saved test:");
	}

	public void clikOnViewProduct() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(viewProductButton));
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
		clickElement(viewProductButton);
		Thread.sleep(6000);
		System.out.println("saved test:");
	}

	public void clikOnLineSheet() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(GoToLineSheet));
		clickElement(GoToLineSheet);
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
		System.out.println("GoToLineSheet test:");
	}

	public void clikViewProduct() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(viewProduct));
		clickElement(viewProduct);
		addSrceenShot("Clicked on View Product", test, Capture);

	}

	public String getProductName() {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productNameElement));
		return productNameElement.getText();
	}

	public void clikCreatedProduct(String Value) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.visibilityOf(GoToLineSheet));
		driver.findElement(By.xpath("//a[normalize-space()='" + Value + "']")).click();
		System.out.println("GoToLineSheet test:");
	}

	/**
	 * Function to verify season creation
	 * 
	 * @throws Exception
	 */
	public void verifySeasonUpdatedupdated() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		boolean flag = waitForElement(seasonIdentificationValue);
		System.out.println("Season updated successfully" + flag);
	}

	/**
	 * Function to click delete button
	 * 
	 * @throws Exception
	 */
	public void clikOnDeleteBtn() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(deleteBtn));
		System.out.println("test:" + deleteBtn);
		clickElement(deleteBtn);
		this.clickAlert();
	}

	public void clickAlert() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			Alert a1 = driver.switchTo().alert();
			a1.accept();
		} catch (UnhandledAlertException f) {
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
			} catch (NoAlertPresentException exc) {
				throw new Exception(exc);
			}
		}
	}

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

	/**
	 * Function to verify delete message displays in the page
	 * 
	 * @throws Exception
	 */
	public void verifyDeleteMessage() throws Exception {
		driver.switchTo().frame(iframeContentframe);
		boolean flag = waitForElement(deleteMessage);
		System.out.println("Season deleted successfully:" + flag + true);
	}

	public void sendInputToTextField(WebElement element, String enterText, String elementName) throws Exception {
		Thread.sleep(500);
		try {
			element.clear();
			element.sendKeys(enterText);
		} catch (Exception e) {

			String message = "Text entered for " + elementName + " is not successfull ";
			throw new Exception(message);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	

	@FindBy(xpath = "//div[@id='SEASON_SUMMARYLayoutWrapper']")
	private WebElement homePageElement;

	public boolean isHomePageDisplayed() {
		driver.switchTo().frame(iframeContentframe);
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(homePageElement));
			return homePageElement.isDisplayed();
		} catch (Exception e) {
			System.out.println("Home page is not displayed: " + e.getMessage());
			return false;
		}
	}

	@FindBy(xpath = "//a[@id='SearchButton2']")
	private WebElement searchbutton_2;

	public void navigateToConsumerMapping(String businessObject, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchbutton_2));
		WebElement business_Object = driver
				.findElement(By.xpath("//a[normalize-space()='" + businessObject.trim() + "']"));
		business_Object.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Selected Business Object: " + businessObject);
		addSrceenShot("Selected Business Object", test, Capture);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchbutton_2));
		Thread.sleep(2000);
		searchbutton_2.click();

	}

	@FindBy(xpath = "//a[contains(text(),'Consumer (Product Hierarchy)')]")
	private WebElement consimerMappingAttributes;

	public void verifyLookupTablesCombinations(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// List of lookup table names
		List<String> lookupTableNames = Arrays.asList("Consumer (Product Hierarchy)", "Consumer Group",
				"Consumer Group 1", "Consumer Group 2", "Consumer Group Ext 1", "Consumer Group Ext 2");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(consimerMappingAttributes));

		for (String tableName : lookupTableNames) {
			WebElement table = driver.findElement(By.xpath("//a[contains(text(),'" + tableName + "')]"));
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(table));
			System.out.println(tableName + " : Present In Consumer Mappings Lookup Table");
			test.log(Status.INFO, tableName + " : Present In Consumer Mappings Lookup Table");
			addSrceenShot(tableName, test, Capture);
		}
	}

	public void openLeftPanel() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pinbutton));
		clickElement(pinbutton);

	}

	@FindBy(xpath = "//a[contains(text(),'Show All')]")
	private WebElement showAllOption;

	@FindBy(xpath = "//div[@id='criteriaToggle']")
	private WebElement showCriteria;

	@FindBy(xpath = "//a[@class='button'][normalize-space()='Select']")
	private WebElement slect_button;

	@FindBy(xpath = "//td[@class='INFO']")
	private WebElement infoMsg;

	@FindBy(xpath = "//td[@valign='bottom']/img")
	private WebElement closePopUp;

	public void selectVendors(String[] vendors, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);
		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(showAllOption));
		showAllOption.click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(showCriteria));
		Thread.sleep(7000);
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='table-wrapper']//tr//td[3]//a"));

		for (String vendor : vendors) {
			boolean vendorFound = false;
			for (int i = 0; i < links.size(); i++) {
				WebElement link = links.get(i);
				if (link.getText().equals(vendor)) {
					// Construct the XPath for the corresponding checkbox
					String checkboxXPath = "(//div[@class='table-wrapper']//tr//td[3]//a)[" + (i + 1)
							+ "]//parent::td//parent::tr//label//span";
					WebElement checkbox = driver.findElement(By.xpath(checkboxXPath));

					// Print the vendor name and checkbox details
					System.out.println("Vendor: " + vendor + ", Checkbox: " + checkbox);

					// Use JavaScript to click the checkbox
					js.executeScript("arguments[0].click();", checkbox);
					Thread.sleep(2000); // Wait for the scrolling to complete

					vendorFound = true;
					break; // Exit the loop once the checkbox is clicked
				}
			}
			if (!vendorFound) {
				System.out.println("Vendor not found: " + vendor);
				test.log(Status.FAIL, "Vendor not found: " + vendor);
			}
		}
	}

	public void clickOnSelect() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", slect_button);
		Thread.sleep(2000);
		clickElement(slect_button);

	}

	public void logAndClosePopUp(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(infoMsg));
		String infoMsgText = infoMsg.getText();
		test.log(Status.INFO, "Info: " + infoMsgText);
		System.out.println("Info: " + infoMsgText);
		addSrceenShot("Info", test, Capture);
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(closePopUp));
		closePopUp.click();
		Thread.sleep(4000);
	}

	public void validateSourcesInDropdown(String[] vendors, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Click to open the dropdown
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(sourceDropDown)).click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='sourcingConfigId']")); // Adjust the XPath as
																								// needed

		// Get the list of options in the dropdown
		List<WebElement> options = dropdown.findElements(By.xpath("//option"));

		// Extract the text of each option
		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : options) {
			optionTexts.add(option.getText().trim()); // Trim any extra spaces
		}

		// Log all options found in the dropdown
		test.log(Status.INFO, "Dropdown options: " + optionTexts);
		addSrceenShot("Dropdown options", test, Capture);

		// Validate that each expected vendor is in the list of options
		for (String expectedVendor : vendors) {
			expectedVendor = expectedVendor.trim(); // Trim any extra spaces
			boolean vendorFound = false;
			String matchingOption = "";
			for (String optionText : optionTexts) {
				if (optionText.contains(expectedVendor)) {
					vendorFound = true;
					matchingOption = optionText;
					break;
				}
			}
			if (vendorFound) {
				test.log(Status.PASS,
						"Vendor found in dropdown: " + expectedVendor + " (Source: " + matchingOption + ")");
				addSrceenShot("Vendor found in dropdown: " + expectedVendor + " (Source: " + matchingOption + ")", test,
						Capture);
			} else {
				test.log(Status.FAIL, "Vendor not found in dropdown: " + expectedVendor);
				addSrceenShot("Vendor not found in dropdown: " + expectedVendor, test, Capture);
			}
		}
	}

	@FindBy(xpath = "//div[@class='error-message']")
	private WebElement error_Message;

	public boolean isErrorMessageDisplayed(ExtentTest test) throws InterruptedException{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(error_Message));
		Thread.sleep(2000);
		String ErrorMsg = error_Message.getText();
		test.log(Status.INFO, "Error Message: " + ErrorMsg);
		addSrceenShot("Error Message", test, Capture);
		return error_Message.isDisplayed();
	}

	@FindBy(xpath = "//div[@id='lscoProductCode']/div[2]")
	private WebElement pc5CodeElement;
	
	 public String getProductCode() throws InterruptedException{
		 
		 driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
	        try {
	            // Locate the product code element on the page
	    		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pc5CodeElement));
	    		Thread.sleep(3000);
	            String productCode = pc5CodeElement.getText().trim();
	            
	            // Log the product code for debugging purposes
	            System.out.println("Product code found: " + productCode);
	            
	            return productCode;
	        } catch (NoSuchElementException e) {
	            // Log the exception if the element is not found
	            System.out.println("Product code element not found");
	            return "";
	        }
	    } 

}
