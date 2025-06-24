package com.WMS_ApplicationPages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.plm.Utilities.ReadDataSheet;
/*import com.plm.myseason.pages.Create_Product_SeasonDetails_Page;
import com.plm.testbase.PageBase;*/
import com.relevantcodes.extentreports.LogStatus;

//import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * @author MANSS023
 *
 */
public class CreateNewProductPage extends WMS_WebDriverUtilities {
	WebDriver driver;
	
	public CreateNewProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();
	public static String productNameValue = "";
	Select globalClearance;

	@FindBy(xpath = "//div[@class='hero-text-img']")
	private WebElement pagetitle;

	@FindBy(xpath = "//span[text()='Style Guides']/following::span[text()='Assets'][1]")
	private WebElement Assets;

	@FindBy(xpath = "//a[@class='homeLink']/following::mat-card-actions[@class='mat-card-actions'][5]")
	private WebElement selectingdmcproduct;

	@FindBy(xpath = "//button[@routerlink='/plmcart']")
	private WebElement plmAddtocart;

	@FindBy(xpath = "//h1[contains(text(),'Your Cart')]/following::span[@class='filler']")
	private WebElement productvalue;

	@FindBy(xpath = "//span[contains(text(),'Send to PLM')]")
	private WebElement sendingtoplm;

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement pageFrame;

	@FindBy(xpath = "//span[text()='Create Product']")
	private WebElement createProduct;

	@FindBy(xpath = "//span[text()='Create Product'] | //*[text()='Edit Product Details']")
	private WebElement createNewProduct;

	@FindBy(xpath = "//a[text()='Program:']/../..//input[contains(@id,'quickSearchInput_ptc_verRef')]")
	private WebElement program;

	@FindBy(xpath = "//input[@id='ptc_verRef_2']")
	private WebElement programValue;

	@FindBy(xpath = "//*[contains(text(),'Family (GS1)')]/..//select")
	private WebElement family;

	@FindBy(xpath = "//*[contains(text(),'Class (GS1)')]/..//select")
	private WebElement classGS;

	@FindBy(xpath = "//*[contains(text(),'Brick (GS1)')]/..//select")
	private WebElement brick;

	@FindBy(xpath = "//div[@id='productNavigator']//a")
	private WebElement productName;

	@FindBy(xpath = "//div[text()='Type']/following-sibling::div")
	private WebElement productType;

	@FindBy(xpath = "//div[text()='Product Short Description']/..//div//textarea")
	private WebElement productShortDescription;

	@FindBy(xpath = "//a[@name='saveButton']")
	private WebElement saveButton;

	@FindBy(xpath = "///form[1]//span[@class='checkbox-custom rectangular']")
	private WebElement confidentialIndicator;

	@FindBy(xpath = "//ul[@id='select2-ptc_str_6-results']")
	private WebElement confidentialIndicatorDD;

	@FindBy(xpath = "//span[@id='select2-ptc_str_38-container']")
	private WebElement productStatus;

	@FindBy(xpath = "//span[@id='select2-ptc_str_25Options-container']")
	private WebElement distributionChannel;

	@FindBy(xpath = "//span[@id='select2-ptc_str_13-container']")
	private WebElement baStatus;

	@FindBy(xpath = "//span[@id='select2-ptc_str_17-container']")
	private WebElement globalClearence;

	@FindBy(xpath = "//div[contains(text(),'GRC#')]/following::input[1]")
	private WebElement grc;

	@FindBy(xpath = "//input[@id='ptc_lng_2Input']")
	private WebElement LESize;

	@FindBy(xpath = "//*[contains(text(),'Earliest Set Date')]/following::input[1]")
	private WebElement EarlierSetDate;

	@FindBy(xpath = "//div[contains(text(),'Franchise Pillar')]/..")
	private WebElement FrancisePillarDD;

	@FindBy(xpath = "//div[contains(text(),'Vendor Assist')]/..")
	private WebElement VerticalDD;

	@FindBy(xpath = "//div[contains(text(),'Family')]/..")
	private WebElement FamilyDD;

	@FindBy(xpath = "//div[contains(text(),'Class (GS1)')]/..")
	private WebElement Classgs1DD;

	@FindBy(xpath = "//div[contains(text(),'Brick')]/..")
	private WebElement BrickDD;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement hiddenvalues;

	@FindBy(xpath = "//div[contains(text(),'Tooling Budget')]/following::input[1]")
	private WebElement toolBudget;

	@FindBy(xpath = "//div[contains(text(),'Target IMU %')]/following::input[1]")
	private WebElement targetIMU;

	@FindBy(xpath = "//*[contains(text(),'Program:')]/following::input[1]")
	private WebElement ProgramField;

	@FindBy(xpath = "//input[@id='login-username']")
	private WebElement Disneyid;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement DisnPassword;

	@FindBy(xpath = "//button[@id='login-submit']")
	private WebElement Dissubmit;

	@FindBy(xpath = "//td[@id='r1_dsnyArtworkName']")
	private WebElement Assetproductvalues;

	@FindBy(xpath = "//div[@class='message-normal']")
	private WebElement Dmcalert;
	// label[contains(text(),'Artwork/Assets')]

	@FindBy(xpath = "//label[contains(text(),'Artwork/Assets')]")
	private WebElement AssetorArtwork;

	@FindBy(xpath = "//div[@id='title-bar']/following::div[text()='Disney Vertical\\Arts-Crafts-Needlework']")
	private WebElement producttype;

	@FindBy(xpath = "//span[text()='Arts/Crafts/Needlework']")
	private WebElement defaultSegment;

	@FindBy(xpath = "//textarea[@name='ptc_str_34']")
	private WebElement artworktextarea;

	// span[text()='Arts/Crafts/Needlework']

	@FindBy(xpath = "//input[@id='ptc_bln_1box']/..")
	private WebElement confidential;

	@FindBy(xpath = "//div[contains(text(),'Development Type')]/following::span[@class='select2-selection__rendered'][1]")
	private WebElement Developmenttype;

	@FindBy(xpath = "//div[contains(text(),'Class (Business)')]/following::span[1]")
	private WebElement classbusinessdd;

	@FindBy(xpath = "//div[contains(text(),'Sub-Class (Business)')]/following::span[1]")
	private WebElement subclassbusinessdd;

	@FindBy(xpath = "//*[contains(text(),'Intended Age Range')]/following::span[1]")
	private WebElement Agerange;

	@FindBy(xpath = "//*[contains(text(),'Limited Edition Size Qty')]/following::input[1]")
	private WebElement LimitedSizeQuantity;

	@FindBy(xpath = "//*[contains(text(),'Division (Business)')]/following::span[1]")
	private WebElement Divisiondd;

	@FindBy(xpath = "//*[contains(text(),'Department (Business)')]/following::span[1]")
	private WebElement Departmentdd;

	@FindBy(xpath = "//*[contains(text(),'Brand Pillar')]/following::span[1]")
	private WebElement BrandPillardd;

	@FindBy(xpath = "//*[contains(text(),'Product Active Status')]/following::span[1]")
	private WebElement ProductActiveList;

	@FindBy(xpath = "//*[contains(text(),'Intended Age Range')]/following::span[1]")
	private WebElement intendrange;

	@FindBy(xpath = "//*[contains(text(),'Exit Date')]/following::input[1]")
	private WebElement Exitdate;

	@FindBy(xpath = "//*[contains(text(),'Earliest Set Date')]/following::input[1]")
	private WebElement EarliersetDate;

	@FindBy(xpath = "//*[contains(text(),'Article Number')]/following::input[1]")
	private WebElement ArticleNo;

	@FindBy(xpath = "//*[contains(text(),'Vendor Currency')]/following::span[1]")
	private WebElement VendorCurrencydropdown;

	public static String segment = "select2-ptc_str_12";

	public static String farnchise = "select2-ptc_str_51";

	public static String Vertical = "select2-ptc_str_30";

	public static String familyLocator = "select2-ptc_str_24";

	public static String classLocator = "select2-ptc_str_16";

	public static String bricksLocator = "select2-ptc_str_60";

	public static String confidentialIndicatorString = "select2-ptc_str_6";

	public static String artworkSource = "select2-ptc_str_3";

	public static String productIntegrity = "//*[contains(text(),'Product Guideline #')]/following::li[1]";

	@FindBy(xpath = "//span[text()='View Product']")
	private WebElement viewproduct;

	@FindBy(xpath = "//a[text()='Product']")
	private WebElement new_Product;

	@FindBy(xpath = "//a[@id='SearchButton1']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[@id='delete']/span[2]")
	private WebElement deleteNavigation;

	@FindBy(xpath = "//a[@id='deleteProduct']/span")
	private WebElement delete;

	@FindBy(xpath = "//div[contains(text(),'Family (GS1)')]//following::div[1]/select[@name]")
	private WebElement family_GS1;

	@FindBy(xpath = "//a[text()='Program:']")
	private WebElement programName_input;

	@FindBy(xpath = "//div[contains(text(),'Class (GS1)')]//following::div[1]/select[@name]")
	private WebElement select_ClassGS1;

	@FindBy(xpath = "//div[contains(text(),'Brick')]//following::div[1]/select")
	private WebElement brick_GS1;

	@FindBy(xpath = "//div[contains(text(),'Franchise Pillar')]//following::div[1]/select[@name]")
	private WebElement frnachise_Pillar;

	@FindBy(xpath = "//div[contains(text(),'Vertical or Vendor Assist')]//following::div/select[@name]")
	private WebElement vertical;

	@FindBy(xpath = "//a[@id='SearchButton1']")
	private WebElement click_Search;

	@FindBy(xpath = "//a[text()='(choose)']")
	private WebElement chooseProduct;

	@FindBy(xpath = "//a[@id='saveButton']/span")
	private WebElement save_b;

	@FindBy(xpath = "//*[contains(text(),'Product Name')]//following::div[1]")
	private WebElement productNumber;

	@FindBy(xpath = "//div[@id='siteNavLink']")
	private WebElement clickOnSite;

	@FindBy(xpath = "//td[contains(text(),'*Franchise Pillar')] //following::select[1]")
	private WebElement franchisePillar_For_ProgramInCurrentWindow;

	@FindBy(xpath = "//a[contains(text(),'Property Title Attraction:')]")
	private WebElement property_Title_Attraction;

	@FindBy(xpath = "//td[contains(text(),'Franchise Pillar')] //following::select[1]")
	private WebElement franchisePillar_For_ProgramNewWindow;

	@FindBy(xpath = "//td[contains(text(),'Franchise Pillar')] //following::a[1][contains(text(),'Add')]")
	private WebElement franchisePillar_Add;

	@FindBy(xpath = "//tr[2]/td/a[contains(text(),'(choose)')]")
	private WebElement chooseButtonForFranchisePillar;

	@FindBy(xpath = "//div[contains(text(),'Development Type')]//following::div[1]/select")
	private WebElement developmentType;

	@FindBy(xpath = "//div[contains(text(),'Product Confidentiality')]/following::span[@class='checkbox-custom rectangular'][1]")
	private WebElement productConfidentiality;

	@FindBy(xpath = "//div[contains(text(),'Supplier Driven Design')]/following::input[2]")
	private WebElement SupplierDrivenDesignCheckBox;

	@FindBy(xpath = "//div[contains(text(),'Business Affairs Rush')]/following::input[2]")
	private WebElement BusinessAffairsRushCheckBox;

	@FindBy(xpath = "//div[contains(text(),'BA Status')]/following::select[1]")
	private WebElement BAStatus;

	@FindBy(xpath = "//div[text()='Product Short Description']//following::div[1]/textarea[1]")
	private WebElement productShortDetails;

	@FindBy(xpath = "//div[contains(text(),'Select Artwork From Source System')]/following::select[1]")
	private WebElement artWorkSourceDD;

	public static String exitDate = "01/01/2021";

	public static String articleNo = "10";

	@FindBy(xpath = "//div[contains(text(),'Approving Region')]/following::select[1]")
	private WebElement approvingRegion;

	@FindBy(xpath = "//div[contains(text(),'Select Project Manager')]/following::select[1]")
	private WebElement projectManager;

	@FindBy(xpath = "//div[contains(text(),'Project Name')]/following::textarea[1]")
	private WebElement projectName;

	@FindBy(xpath = "//div[contains(text(),'Project Description')]/following::textarea[1]")
	private WebElement projectDescription;

	@FindBy(xpath = "//div[contains(text(),'Please approve this workflow submission by')]/following::input[1]")
	private WebElement workFlowSubmission;

	@FindBy(xpath = "//div[contains(text(),'Intended Age Range')]/following::span[1]")
	private WebElement intendendedRange;

	@FindBy(xpath = "//div[contains(text(),'Live Date')]/following::input[1]")
	private WebElement liveDate;

	@FindBy(xpath = "//div[contains(text(),'End Date')]/following::input[1]")
	private WebElement endDate;

	@FindBy(xpath = "//div[contains(text(),'Issue Date')]/following::input[1]")
	private WebElement issueDate;

	@FindBy(xpath = "//div[contains(text(),'Expiration Date')]/following::input[1]")
	private WebElement expirationDate;

	@FindBy(xpath = "//div[contains(text(),'Line of Business')]/following::select[1]")
	private WebElement lineOfBusiness;

	@FindBy(xpath = "//div[contains(text(),'Please approve this workflow submission by')]/following::span[1]")
	private WebElement category;

	@FindBy(xpath = "//div[contains(text(),'Product Category')]/following::span[1]")
	private WebElement productCategory;

	@FindBy(xpath = "//div[contains(text(),'Target Licensee')]/following::span[1]")
	private WebElement targetLicense;

	@FindBy(xpath = "//div[contains(text(),'Sub Category')]/following::span[1]")
	private WebElement SubCategory;

	@FindBy(xpath = "//div[contains(text(),'Product Status')]/following::select[1]")
	private WebElement productStatusLicence;

	@FindBy(xpath = "//div[contains(text(),'Country/Market of Distribution')]/following::span[1]")
	private WebElement countryDistribution;

	public static String region = "Approving Region";

	@FindBy(xpath = "//div[contains(text(),'Spec Description')]/following::input[1]")
	private WebElement SpecDescription;

	@FindBy(xpath = "//div[contains(text(),'Select Project Manager')]/following::span[1]")
	private WebElement selectProjectManager;

//	public Create_Product_SeasonDetails_Page createProductforlinesheet() throws Exception {
//		PlmUtills.switchContentFrame(remoteDriver);
//		remoteDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
//		Select family = new Select(family_GS1);
//		family.selectByIndex(1);
//		Select gs1 = new Select(select_ClassGS1);
//		gs1.selectByIndex(2);
//		Select brick = new Select(brick_GS1);
//		brick.selectByIndex(1);
//		Select division_Business = new Select(remoteDriver
//				.findElement(By.xpath("//div[contains(text(),'Division (Business)')]//following::select[1]")));
//		division_Business.selectByIndex(1);
//		Select department_Business = new Select(remoteDriver
//				.findElement(By.xpath("//div[contains(text(),'Department (Business)')]//following::select[1]")));
//		department_Business.selectByIndex(1);
//		Select class_Business = new Select(remoteDriver
//				.findElement(By.xpath("//div[contains(text(),'Department (Business)')]//following::select[2]")));
//		class_Business.selectByIndex(1);
//		Select sub_Class_Business = new Select(remoteDriver
//				.findElement(By.xpath("//div[contains(text(),'Sub-Class (Business)')]//following::select[1]")));
//		sub_Class_Business.selectByIndex(1);
//		waitForClickable(productConfidentiality);
//		productConfidentiality.click();
//		((JavascriptExecutor) remoteDriver).executeScript("arguments[0].scrollIntoView(true);", productConfidentiality);
//		((JavascriptExecutor) remoteDriver).executeScript("arguments[0].scrollIntoView(true);", developmentType);
//		Select development_Type = new Select(developmentType);
//		development_Type.selectByIndex(1);
//		((JavascriptExecutor) remoteDriver).executeScript("window.scrollTo(0,0)");
//		this.click("//*[contains(text(),'Program:')]", "Program");
//		Set<String> handler = remoteDriver.getWindowHandles();
//		Iterator<String> it = handler.iterator();
//		String parentwindow = it.next();
//		String childwindow = it.next();
//		remoteDriver.switchTo().window(childwindow);
//		remoteDriver.manage().window().fullscreen();
//		this.click("//*[text()='Search']", currentTest); // TODO
//		this.click("//table[contains(@id,'TBLT')]//tr[2]//td[1]/a", currentTest); // TODO
//		remoteDriver.switchTo().window(parentwindow);
//		PlmUtills.switchContentFrame(remoteDriver);
//		this.moveToElement(productShortDetails, "Short description");
//		try {
//			productShortDetails.clear();
//			productShortDetails.sendKeys("Auto");
//		} catch (Exception e) {
//			String message = "Unable to add product short description";
//			ExtentUtility.getTest().log(LogStatus.FAIL,
//					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
//			throw new Exception(message);
//		}
//		this.click(saveButton, "Save button");
//		ExtentUtility.getTest().log(LogStatus.INFO, ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
//		return new Create_Product_SeasonDetails_Page(remoteDriver, currentTest);
//	}
//
//	public void updateImage() throws Exception {}

	
}