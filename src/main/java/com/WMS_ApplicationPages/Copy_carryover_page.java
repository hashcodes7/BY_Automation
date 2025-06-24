package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bouncycastle.asn1.cms.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class Copy_carryover_page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public Copy_carryover_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	boolean Capture = true;
//	WebElement Loactors------------------------------------------------------

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//label[contains(text(),'My Seasons')]")
	private WebElement Myseason;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement SeasonsDropdown;

	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement Action_dropdown;

	@FindBy(xpath = "//a[@id='copyAction']")
	private WebElement CopyAction;

	@FindBy(xpath = "//div[@class='dropdown menu-icon']//a[@id='copyProduct']")
	private WebElement CopyProductmenu;

	@FindBy(xpath = "//select[@id='selectedSeason']")
	private WebElement season_DD_carryover;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement FilterTextbox;

	@FindBy(xpath = "//input[@id='ag-151-input']")
	private WebElement select_product;

	@FindBy(xpath = "//name-cell-renderer[@class='ng-star-inserted']")
	private WebElement Click_Product;

	@FindBy(xpath = "//select[@id='seasondata']")
	private WebElement Seasondata_DD;

	@FindBy(xpath = "//input[@value='source']")
	private WebElement Source_checkbox;

	@FindBy(xpath = "//input[@value='colorway']")
	private WebElement Colorway_checkbox;

	@FindBy(xpath = "//input[@value='sizes']")
	private WebElement ProductSizes_checkbox;

	@FindBy(xpath = "//input[@value='specComps']")
	private WebElement SpecComs_checkbox;

	@FindBy(xpath = "//a[@class='button' and contains(text(),'Next')]")
	private WebElement Next_Button;

	@FindBy(xpath = "//input[@id='ptc_str_1']")
	private WebElement CopiedProduct_Name;

	@FindBy(xpath = "//a[@id='nextButton']")
	private WebElement Product_Next_Button;

	@FindBy(xpath = "(//a[@id='createAnotherProduct'])[2]")
	private WebElement View_Product;

	@FindBy(xpath = "//span[@id='pr_id_2_label']")
	private WebElement Filter_View;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c59-2']")
	private WebElement Filter_View_textbox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement Filter_selection;

	@FindBy(xpath = "(//div[contains(@col-id,'product.productName')])[2]")
	private WebElement Product_Value;

	@FindBy(xpath = "//span[contains(text(),'Copy: Colorway')]")
	private WebElement Copy_colorway;

	@FindBy(xpath = "//span[normalize-space()='Colorway']")
	private WebElement Colorway_contextclick;

	@FindBy(xpath = "//div[@id='ptc_ref_1Display']/a")
	private WebElement ColorwayLook_colorvalue;

	@FindBy(xpath = "//select[@id='ptc_str_32']")
	private WebElement MerchFabricType;

	@FindBy(xpath = "//select[@id='ptc_ref_6']")
	private WebElement ProductSegLSUS_DD;

	@FindBy(xpath = "//select[@id='ptc_ref_5']")
	private WebElement ProductSegLSE_DD;

	@FindBy(xpath = "//a[contains(text(),'Save')]")
	private WebElement Save_button;

	@FindBy(xpath = "//div[@id='lscoProdSegmentEUR']//a")
	private WebElement ProductSegLSE_Value;

	@FindBy(xpath = "//div[@id='lscoProdSegmentUS']//a")
	private WebElement ProductSegLSUS_Value;

	@FindBy(xpath = "//div[@id='lscoHubOfferedTo']/div[2]")
	private WebElement HubOfferedTo_value;

	@FindBy(xpath = "//div[@id='lscoMerchFabricType']/div[2]")
	private WebElement MerchFabric_value;

	@FindBy(xpath = "//span[@id='select2-ptc_str_39-container']")
	private WebElement HubOfferedTo;

	@FindBy(xpath = "//ul[@id='select2-ptc_str_39-results']/li")
	private WebElement HubOfferedTo_select;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement HubOfferedTo_Textbox;

	@FindBy(xpath = "(//a[@id='createAnotherProduct'])[2]")
	private WebElement View_product;

	@FindBy(xpath = "//div[@id='navHeader']/a")
	private WebElement Copyproduct;

	@FindBy(xpath = "//*[@id='quickSearchText']")
	private WebElement filterdata;

	@FindBy(xpath = "(//*[contains(@col-id,'colorway.skuName')])[2]//a")
	private WebElement colorwayName;

	@FindBy(xpath = "//*[@id='lscoLSECSTrigger']/div[2]")
	private WebElement LSECSTrigger;

	@FindBy(xpath = "//*[@id='lscoLSUSCSTrigger']/div[2]")
	private WebElement LSUSCSTrigger;

	@FindBy(xpath = "//*[@id='lscoLSEValidation']/div[2]")
	private WebElement LSEValidation;

	@FindBy(xpath = "//*[@id='lscoLSUSValidation']/div[2]")
	private WebElement LSUSValidation;

	@FindBy(xpath = "//*[@id='lscoLSEValidationReport']/div[2]")
	private WebElement LSEValidationReport;

	@FindBy(xpath = "//*[@id='lscoLSUSValidationReport']/div[2]")
	private WebElement LSUSValidationReport;

	@FindBy(xpath = "//*[@id='lscoLSEStatus']/div[2]")
	private WebElement LSEStatus;

	@FindBy(xpath = "//*[@id='lscoLSUSStatus']/div[2]")
	private WebElement LSUSStatus;

	@FindBy(xpath = "//*[@id='lscoNewCarryover']/div[2]")
	private WebElement NewCarryover;

	@FindBy(xpath = "//*[@id='lscoColorwayCode']/div[2]")
	private WebElement ColorwayCode;

	@FindBy(xpath = "//*[@id='lscoProductCode']/div[2]")
	private WebElement ProductCode;

	@FindBy(xpath = "//*[@id='lscoCreateColorwayBOMs']/div[2]")
	private WebElement CreateColorwayBOMs;

	@FindBy(xpath = "//*[@id='lscoUseProductTemplate']/div[2]")
	private WebElement UseProductTemplate;

	@FindBy(xpath = "//*[@id='lscoSeasonalLook']/div[2]")
	private WebElement Seasonal;

	@FindBy(xpath = "//*[@id='lscoGTMTrack']/div[2]")
	private WebElement GTMTrack;

	@FindBy(xpath = "//*[@id='lscoEarlyDelivery']/div[2]")
	private WebElement earlyDelivery;

	@FindBy(xpath = "//*[@id='lscoSourcePC9Status']/div[2]")
	private WebElement SourcePC9Status;

	@FindBy(xpath = "//*[@id='lscoLinkSrcToPC9']/div[2]")
	private WebElement LinkSrcToPC9;

	@FindBy(xpath = "//*[@id='lscoVendorList']/div[2]")
	private WebElement VendorList;

	@FindBy(xpath = "//*[@id='lscoSizeGridCodeProcessStatus']/div[2]")
	private WebElement SizeGridCodeProcessStatus;

	@FindBy(xpath = "//*[@id='lscoSizeGridErrorDetails']/div[2]")
	private WebElement SizeGridErrorDetails;

	@FindBy(xpath = "//*[@id='lscoSizeGridErrorMsg']/div[2]")
	private WebElement SizeGridErrorMsg;

	@FindBy(xpath = "//*[@id='lscoOrgnlDevSeason']/div[2]")
	private WebElement OrgnlDevSeason;

	@FindBy(xpath = "(//*[@id='lscoDesigner']/div[2])[1]")
	private WebElement Designer;

	@FindBy(xpath = "(//*[@id='lscoFieldPDSObjRef']/div[2])[1]")
	private WebElement FieldPDSObjRef;

	@FindBy(xpath = "(//*[@id='lscoGarmentDeveloperObjRef']/div[2])[1]")
	private WebElement GarmentDeveloperObjRef;

	@FindBy(xpath = "(//*[@id='lscoMerchantObjRef']/div[2])[1]")
	private WebElement MerchantObjRef;

	@FindBy(xpath = "(//*[@id='lscoPDSObjRef']/div[2])[1]")
	private WebElement PDSObjRef;

	@FindBy(xpath = "(//*[@id='lscoProductManagerObjRef']/div[2])[1]")
	private WebElement ProductManagerObjRef;

	@FindBy(xpath = "//*[text()='Brief Code']//following::div[1]")
	private WebElement BriefCode;

	@FindBy(xpath = "//*[@id='lscoChinaApproved']/div[2]")
	private WebElement ChinaApproved;

	@FindBy(xpath = "//*[@id='lscoCarryoverComponents']/div[2]")
	private WebElement CarryoverComponents;

	@FindBy(xpath = "//*[@id='lscoBlankLinked']/div[2]")
	private WebElement BlankLinked;

	@FindBy(xpath = "//*[@id='lscoOriginalBFF']/div[2]")
	private WebElement OriginalBFF;

	@FindBy(xpath = "//*[@id='lscoTechPackGrouping']/div[2]")
	private WebElement TechPackGrouping;

	@FindBy(xpath = "//*[text()='Set Up LSE Feedback from SAP']//following::div[1]")
	private WebElement SAPFeedback;

	@FindBy(xpath = "//*[text()='BOM Comments']//following::div[1]")
	private WebElement BOMComments;
	
	@FindBy(xpath = "//a[text()='Select All']")
	private WebElement Select_All;
	
	@FindBy(xpath = "//select[@id='productTypedata']/option")
	private WebElement ProductType;
	
	@FindBy(xpath = "//div[contains(text(),'Brand Hierarchy')]/following-sibling::div")
	private WebElement brandHierarchyDropDown;

	@FindBy(xpath = "//div[contains(text(), 'Season')]/following-sibling::div")
	private WebElement seasonDropDown;

	@FindBy(xpath = "//div[contains(text(),'Product Sub Cat 1')]/following-sibling::div")
	private WebElement proSubCat1DropDown;

	@FindBy(xpath = "//div[contains(text(),'Product Sub Cat 2')]/following-sibling::div")
	private WebElement proSubCat2DropDown;

	@FindBy(xpath = "//div[@id='lscoProductCategory']/following::div[@class='input-title-required'][1]/following::div[1]")
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
	
	@FindBy(xpath = "//div[contains(text(),'Customs Classification')]/following-sibling::div[1]")
	private WebElement customsClassificationDropDown;

//	--------------------------------Methods---------------------------------------
	public void SeasonDropdown(String season) throws InterruptedException {
		selectValueFromDropdown(SeasonsDropdown, season);
	}

	public void CopyProduct(String newname, String newseason, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Action_dropdown.click();
		CopyAction.click();
		CopyProductmenu.click();
		selectValueFromDropdown(Seasondata_DD, newseason);
		test.log(Status.INFO, "The season in which user have to copy: " + newseason);
		
		Thread.sleep(1000);
		test.log(Status.INFO, "The Product type for the selected Season is:  " + ProductType.getText());
		Select_All.click();
//		Source_checkbox.click();
//		Colorway_checkbox.click();
//		ProductSizes_checkbox.click();
//		SpecComs_checkbox.click();
		Next_Button.click();
	}
	
	public void Update_productName(ExtentTest test,String newname) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		Assert.assertTrue(driver.getTitle().equals("CopyProduct"));
		test.log(Status.INFO, "Page title is CopyProduct ");
		
		CopiedProduct_Name.clear();
		CopiedProduct_Name.sendKeys(newname);
		test.log(Status.INFO, "The new product name is" + newname);
		Product_Next_Button.click();
		WaitforPage(5000);
		View_Product.click();
		Thread.sleep(5000);
		
	}
	
	public void UpdateAllMandatoryFields(String newname,String updatedBrandHierarchy, String updatedClassValue,String updatedSubClassValue, String updatedProSubCat1,
			String updatedProSubCat2, String updatedConsumer,String updatedConsumerGrp1, String updatedConsumerGrp2, String updatedCustomsClassification,ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Assert.assertTrue(driver.getTitle().equals("CopyProduct"));
		test.log(Status.INFO, "Page title is CopyProduct ");

		CopiedProduct_Name.clear();
		CopiedProduct_Name.sendKeys(newname);
		test.log(Status.INFO, "The new product name is" + newname);
		
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
		Thread.sleep(6000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp1DropDown));
		consumerGrp1DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumerGrp1);
		Thread.sleep(7000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGrp2DropDown));
		consumerGrp2DropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedConsumerGrp2);
		Thread.sleep(7000);
		searchResult.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(customsClassificationDropDown));
		customsClassificationDropDown.click();
		Thread.sleep(2000);
		searchField.clear();
		searchField.sendKeys(updatedCustomsClassification);
		Thread.sleep(5000);
		searchResult.click();
		
		Thread.sleep(3000);
		Product_Next_Button.click();
		WaitforPage(5000);
		View_Product.click();
		Thread.sleep(6000);

		test.log(Status.INFO,
				"Updated product details:  Brand Hierarchy - "
						+ updatedBrandHierarchy + ", Product Sub Category 1 - " + updatedProSubCat1
						+ ", Product Sub Category 2 - " + updatedProSubCat2 + ", Class - " + updatedClassValue
						+ ", Sub Class - " + updatedSubClassValue + ", Consumer - " + updatedConsumer
						+ ", Consumer Group 1 - " + updatedConsumerGrp1 + ", Consumer Group 2 - " + updatedConsumerGrp2
						+ ", Customs Classification - " + updatedCustomsClassification);
		addSrceenShot("Updated product details", test, Capture);
	}


	public void Validate_CopyProduct(String newname, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		String copiedproduct = Copyproduct.getText();
		if (copiedproduct.contains(newname)) {
			System.out.println("validated the copied product and the name is  " + newname);
			test.log(Status.INFO, "validated the copied product and the name is  " + newname);
		}
	}

	public void openProduct(String product) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		FilterTextbox.sendKeys(product);
		Click_Product.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
	}

	public void filter_View_Change(String Filterview, String product, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		test.log(Status.INFO, "The view selected is" + Filterview);
		Filter_View.click();
		Filter_View_textbox.sendKeys(Filterview);
		Filter_selection.click();
		FilterTextbox.sendKeys(product);
	}

	public void colorwayseasonfield(String hubofferedto) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		HubOfferedTo.click();
		HubOfferedTo_Textbox.sendKeys(hubofferedto);
		HubOfferedTo_select.click();
		View_product.click();
		Assert.assertTrue(driver.getTitle().equals("View Season Product Information"));
	}

	public void copyColorwayUsingContextClick(String merchfabricType, String productsegLSE, String productsegLSUS,
			ExtentTest test) throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.contextClick(Product_Value).build().perform();
		Colorway_contextclick.click();
		Copy_colorway.click();
		WaitforPage(5000);

		selectValueFromDropdown(ProductSegLSUS_DD, productsegLSUS);
		test.log(Status.INFO, "The product LSUS value is" + productsegLSUS);
		selectValueFromDropdown(ProductSegLSE_DD, productsegLSE);
		test.log(Status.INFO, "The product LSE value is" + productsegLSE);
		if (ColorwayLook_colorvalue.isDisplayed()) {
			selectValueFromDropdown(MerchFabricType, merchfabricType);
			test.log(Status.INFO, "The merch fabric type value is" + merchfabricType);
		}
		Save_button.click();
	}

	public void validationOfAttributes(String merchfabricType, String productsegLSE, String productsegLSUS,
			ExtentTest test) {
		String proSegLSE = ProductSegLSE_Value.getText();
		System.out.println(proSegLSE);
		Assert.assertTrue(proSegLSE.equals(productsegLSE));
		String proSegLSUS = ProductSegLSUS_Value.getText();
		System.out.println(proSegLSUS);
		Assert.assertTrue(ProductSegLSUS_Value.getText().equals(productsegLSUS));
		String merchType = MerchFabric_value.getText();
		System.out.println(merchType);
		Assert.assertTrue(merchType.equals(merchfabricType));
	}
		

	public void copycarryoverAttributeValidation(ExtentTest test, String colorwayCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(colorwayCode);
		;
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwayName)).click();
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		driver.switchTo().frame(iframeContentframe);
		String LSECSTriggerValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSECSTrigger))
				.getText();
		Thread.sleep(2000);
		String LSUSCSTriggerValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSUSCSTrigger))
				.getText();
		Thread.sleep(2000);
		String LSEValidationValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSEValidation))
				.getText();
		Thread.sleep(2000);
		String LSUSValidationValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(LSUSValidation)).getText();
		Thread.sleep(2000);
		String LSEValidationReportValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(LSEValidationReport)).getText();
		Thread.sleep(2000);
		String LSUSValidationReportValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(LSUSValidationReport)).getText();
		Thread.sleep(2000);
		String LSEStatusValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSEStatus))
				.getText();
		Thread.sleep(2000);
		String LSUSStatusValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSUSStatus))
				.getText();
		Thread.sleep(2000);
		String NewCarryoverValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(NewCarryover))
				.getText();
		Thread.sleep(2000);
		String ColorwayCodeValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ColorwayCode))
				.getText();
		Thread.sleep(2000);
		String ProductCodeValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductCode))
				.getText();
		Thread.sleep(2000);
		String CreateColorwayBOMsValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(CreateColorwayBOMs)).getText();
		Thread.sleep(2000);
		String UseProductTemplateValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(UseProductTemplate)).getText();
		Thread.sleep(2000);
		String SeasonalValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Seasonal)).getText();
		Thread.sleep(2000);
		String GTMTrackValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(GTMTrack)).getText();
		Thread.sleep(2000);
		String earlyDeliveryValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(earlyDelivery))
				.getText();
		Thread.sleep(2000);
		String SourcePC9StatusValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(SourcePC9Status)).getText();
		Thread.sleep(2000);
		String LinkSrcToPC9Value = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LinkSrcToPC9))
				.getText();
		Thread.sleep(2000);
		String VendorListValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(VendorList))
				.getText();
		Thread.sleep(2000);
		String SizeGridCodeProcessStatusValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(SizeGridCodeProcessStatus)).getText();
		Thread.sleep(2000);
		String SizeGridErrorDetailsValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(SizeGridErrorDetails)).getText();
		Thread.sleep(2000);
		String SizeGridErrorMsgValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(SizeGridErrorMsg)).getText();
		Thread.sleep(2000);
		String OrgnlDevSeasonValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(OrgnlDevSeason)).getText();
		Thread.sleep(2000);
		String DesignerValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Designer)).getText();
		Thread.sleep(2000);
		String FieldPDSObjRefValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(FieldPDSObjRef)).getText();
		Thread.sleep(2000);
		String GarmentDeveloperObjRefValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(GarmentDeveloperObjRef)).getText();
		Thread.sleep(2000);
		String MerchantObjRefValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(MerchantObjRef)).getText();
		Thread.sleep(2000);
		String PDSObjRefValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(PDSObjRef))
				.getText();
		Thread.sleep(2000);
		String ProductManagerObjRefValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(ProductManagerObjRef)).getText();
		Thread.sleep(2000);
		String BriefCodeValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(BriefCode))
				.getText();
		Thread.sleep(2000);
		String ChinaApprovedValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ChinaApproved))
				.getText();
		Thread.sleep(2000);
		String CarryoverComponentsValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(CarryoverComponents)).getText();
		Thread.sleep(2000);
		String BlankLinkedValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(BlankLinked))
				.getText();
		Thread.sleep(2000);
		String OriginalBFFValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(OriginalBFF))
				.getText();
		Thread.sleep(2000);
		String TechPackGroupingValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(TechPackGrouping)).getText();
		Thread.sleep(2000);
		String SAPFeedbackValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(SAPFeedback))
				.getText();
		Thread.sleep(2000);
		String BOMCommentsValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(BOMComments))
				.getText();
		Thread.sleep(2000);

		if (LSECSTriggerValue.equalsIgnoreCase("No") && LSECSTriggerValue.equalsIgnoreCase("No")
				&& LSEValidationValue.equalsIgnoreCase("No") && LSUSValidationValue.equalsIgnoreCase("No")
				&& BlankLinkedValue.equalsIgnoreCase("No")&& CreateColorwayBOMsValue.equalsIgnoreCase("No")
				&& UseProductTemplateValue.equalsIgnoreCase("No")) {
			System.out.println("LSECSTrigger,LSECSTrigger,LSEValidation,LSUSValidation,BlankLinked,UseProductTemplateValue,CreateColorwayBOMsValue values are No ");
			test.log(Status.INFO,"LSECSTrigger,LSECSTrigger,LSEValidation,LSUSValidation,BlankLinked,UseProductTemplateValue,CreateColorwayBOMsValue values are No ");
			addSrceenShot("LSECSTrigger,LSECSTrigger,LSEValidation,LSUSValidation,BlankLinked,CreateColorwayBOMsValue,UseProductTemplateValue values are No ", test, Capture);
			
		}
		
		List<WebElement> Attributeslist=Arrays.asList(LSEValidationReport,LSUSValidationReport,LSEStatus,LSUSStatus,Seasonal,SourcePC9Status,LinkSrcToPC9,VendorList,SizeGridCodeProcessStatus,SizeGridErrorDetails,
				SizeGridErrorMsg,Designer,FieldPDSObjRef,GarmentDeveloperObjRef,MerchantObjRef,PDSObjRef,ProductManagerObjRef,BriefCode,ChinaApproved,CarryoverComponents,OriginalBFF,SAPFeedback,BOMComments);
		
		List<String> Attributesname=Arrays.asList("LSEValidationReport","LSUSValidationReport","LSEStatus", "LSUSStatus", "Seasonal", "SourcePC9Status", "LinkSrcToPC9", "VendorList", "SizeGridCodeProcessStatus",
				"SizeGridErrorDetails", "SizeGridErrorMsg", "Designer", "FieldPDSObjRef", "GarmentDeveloperObjRef", "MerchantObjRef","PDSObjRef", "ProductManagerObjRef", "BriefCode", "ChinaApproved", "CarryoverComponents", 
				"OriginalBFF", "SAPFeedback", "BOMComments");
		
		for (int i=0;i<Attributeslist.size();i++) {
			if(Attributeslist.get(i).getText().isEmpty()) {
				System.out.println("The value of  "+ Attributesname.get(i)+"  is blank/empty");
				test.log(Status.INFO,"The value of  "+ Attributesname.get(i)+"  is blank/empty");
				addSrceenShot("The value of  "+ Attributesname.get(i)+"  is blank/empty", test, Capture);
				
			}else {
				System.out.println("The value of  "+ Attributesname.get(i)+"  is  not blank/empty");
				test.log(Status.INFO,"The value of  "+ Attributesname.get(i)+"  is not blank/empty");
				
			}
		}
		

//		if (LSEValidationReportValue.equals("") && LSUSValidationReportValue.equals("")
//				&& LSEStatusValue.equals("") && LSUSStatusValue.equals("") && SeasonalValue.equals("")
//				&& SourcePC9StatusValue.equals("") && LinkSrcToPC9Value.equals("") && VendorListValue.equals("")
//				&& SizeGridCodeProcessStatusValue.equals("") && SizeGridErrorDetailsValue.equals("")
//				&& SizeGridErrorMsgValue.equals("") && DesignerValue.equals("") && FieldPDSObjRefValue.equals("")
//				&& GarmentDeveloperObjRefValue.equals("") && MerchantObjRefValue.equals("") && PDSObjRefValue.equals("")
//				&& ProductManagerObjRefValue.equals("") && BriefCodeValue.equals("") && ChinaApprovedValue.equals("")
//				&& CarryoverComponentsValue.equals("") && OriginalBFFValue.equals("") && SAPFeedbackValue.equals("")
//				&& BOMCommentsValue.equals("")) {
//			
//			System.out.println("LSEValidationReport,LSUSValidationReport,LSEStatus,LSUSStatus,Seasonal,"
//					+ "SourcePC9Status,LinkSrcToPC9,VendorList,SizeGridCodeProcessStatus,SizeGridErrorDetails,"
//					+ "SizeGridErrorMsg,Designer,FieldPDSObjRef,GarmentDeveloperObjRef,MerchantObjRef,PDSObjRef,"
//					+ "ProductManagerObjRef,BriefCode,ChinaApproved,CarryoverComponents,OriginalBFF,SAPFeedback,BOMComments Values are"
//					+ " set to blank ");
//			
//			test.log(Status.INFO,"LSEValidationReport,LSUSValidationReport,LSEStatus,LSUSStatus,Seasonal,"
//					+ "SourcePC9Status,LinkSrcToPC9,VendorList,SizeGridCodeProcessStatus,SizeGridErrorDetails,"
//					+ "SizeGridErrorMsg,Designer,FieldPDSObjRef,GarmentDeveloperObjRef,MerchantObjRef,PDSObjRef,"
//					+ "ProductManagerObjRef,BriefCode,ChinaApproved,CarryoverComponents,OriginalBFF,SAPFeedback,BOMComments Values are"
//					+ " set to blank ");
//			addSrceenShot("LSEValidationReport,LSUSValidationReport,LSEStatus,LSUSStatus,Seasonal,"
//					+ "SourcePC9Status,LinkSrcToPC9,VendorList,SizeGridCodeProcessStatus,SizeGridErrorDetails,"
//					+ "SizeGridErrorMsg,Designer,FieldPDSObjRef,GarmentDeveloperObjRef,MerchantObjRef,PDSObjRef,"
//					+ "ProductManagerObjRef,BriefCode,ChinaApproved,CarryoverComponents,OriginalBFF,SAPFeedback,BOMComments Values are"
//					+ " set to blank ", test, Capture);
//		}

		if (NewCarryoverValue.equalsIgnoreCase("New") ) {
			System.out.println("NewCarryover value is set to New ");
			test.log(Status.INFO,"NewCarryover value is set to New  ");
			addSrceenShot("NewCarryover value is set to New ", test, Capture);
		}

		if (GTMTrackValue.equalsIgnoreCase("Standard") && TechPackGroupingValue.equalsIgnoreCase("Standard")) {
			System.out.println("GTMTrack,TechPackGrouping values are Standard ");
			test.log(Status.INFO,"GTMTrack,TechPackGrouping values are Standard ");
			addSrceenShot("GTMTrack,TechPackGrouping values are Standard ", test, Capture);
		}

		if(!ColorwayCodeValue.isEmpty() || !ProductCodeValue.isEmpty() || !OrgnlDevSeasonValue.isEmpty()) {
			System.out.println("  ColorwayCode,ProductCode and originaldevseason value is populating according to the copied product and not null ");
			test.log(Status.INFO,"  ColorwayCode,ProductCode and originaldevseason value is populating according to the copied product and not null ");
			addSrceenShot("  ColorwayCode,ProductCode and originaldevseason value is populating according to the copied product and not null ", test, Capture);
		}

//		String[] strings = {LSECSTriggerValue,LSECSTriggerValue,LSEValidationValue,LSUSValidationValue,
//				BlankLinkedValue,LSEValidationReportValue,LSUSValidationReportValue, LSEStatusValue,
//				LSUSStatusValue,SeasonalValue,SourcePC9StatusValue,LinkSrcToPC9Value,VendorListValue,
//				SizeGridCodeProcessStatusValue,SizeGridErrorDetailsValue,SizeGridErrorMsgValue,
//				DesignerValue,FieldPDSObjRefValue,GarmentDeveloperObjRefValue,MerchantObjRefValue,
//				PDSObjRefValue,ProductManagerObjRefValue,BriefCodeValue,ChinaApprovedValue,
//				CarryoverComponentsValue,OriginalBFFValue,NewCarryoverValue,CreateColorwayBOMsValue,
//				UseProductTemplateValue,GTMTrackValue,TechPackGroupingValue,ColorwayCodeValue,
//				ProductCodeValue,OrgnlDevSeasonValue,SAPFeedbackValue,BOMCommentsValue	            
//	        };
//		for (String str : strings) {
//            if ("No".equals(str)) {
//                System.out.println(str+" values are set to No");
//            } else if (str.isEmpty()) {
//            	 System.out.println(str+" values are set to blank");
//            } else if ("New".equals(str)) {
//            	 System.out.println(str+" values are set to New");
//            } else {
//            	System.out.println(str+" values are set to any other value");
//            }
//        }
	}

	public void movecarryoverAttributeValidation(ExtentTest test, String colorwayCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(colorwayCode);
		;
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwayName)).click();
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().frame(iframeContentframe);
		String LSECSTriggerValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSECSTrigger))
				.getText();
		Thread.sleep(2000);
		String LSUSCSTriggerValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSUSCSTrigger))
				.getText();
		Thread.sleep(2000);
		String LSEValidationValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSEValidation))
				.getText();
		Thread.sleep(2000);
		String LSUSValidationValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(LSUSValidation)).getText();
		Thread.sleep(2000);
		String LSEValidationReportValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(LSEValidationReport)).getText();
		Thread.sleep(2000);
		String LSUSValidationReportValue = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOf(LSUSValidationReport)).getText();
		Thread.sleep(2000);
		String LSEStatusValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSEStatus))
				.getText();
		Thread.sleep(2000);
		String LSUSStatusValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LSUSStatus))
				.getText();
		Thread.sleep(2000);
		String SAPFeedbackValue = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(SAPFeedback))
				.getText();
		Thread.sleep(2000);
		if (LSECSTriggerValue.equalsIgnoreCase("No") && LSECSTriggerValue.equalsIgnoreCase("No")
				&& LSEValidationValue.equalsIgnoreCase("No") && LSUSValidationValue.equalsIgnoreCase("No")) {
			System.out.println("LSECSTrigger,LSECSTrigger,LSEValidation,LSUSValidation values are No ");
			test.log(Status.INFO,"LSECSTrigger,LSECSTrigger,LSEValidation,LSUSValidation values are No ");
			addSrceenShot("LSECSTrigger,LSECSTrigger,LSEValidation,LSUSValidation values are No ", test, Capture);
			
			
			
			
		}
		if (LSEValidationReportValue.equals("") && LSUSValidationReportValue.equals("") && LSEStatusValue.equals("")
				&& LSUSStatusValue.equals("") && SAPFeedbackValue.equals("")) {
			System.out.println(
					"LSEValidationReport,LSUSValidationReport,LSEStatus,LSUSStatus,SAPFeedback values are set to Blank ");
			test.log(Status.INFO,"LSEValidationReport,LSUSValidationReport,LSEStatus,LSUSStatus,SAPFeedback values are set to Blank ");
			addSrceenShot("LSEValidationReport,LSUSValidationReport,LSEStatus,LSUSStatus,SAPFeedback values are set to Blank ", test, Capture);
		}
	}
	
	/////////////p2__anand_///////////////////
	
	@FindBy(xpath = "//div[@id='lscoActivated']")
	private WebElement lscoActivated;
 
	@FindBy(xpath = "//div[@id='lscoNewCarryover']")
	private WebElement lscoNewCarryover;
 
	@FindBy(xpath = "//div[@id='lscoAllComponentsSKU']")
	private WebElement lscoAllComponentsSKU;
 
	@FindBy(xpath = "//div[@id='lscoAvailable']")
	private WebElement lscoAvailable;
 
	
	@FindBy(xpath = "//div[@id='lscoCreateColorwayBOMs']")
	private WebElement lscoCreateColorwayBOMs;
 
	@FindBy(xpath = "//div[@id='lscoUseProductTemplate']")
	private WebElement lscoUseProductTemplate;
 
	@FindBy(xpath = "//div[@id='lscoSeasonalLook']")
	private WebElement lscoSeason;
 
 
	@FindBy(xpath = "//div[@id='lscoGTMTrack']")
	private WebElement lscoGTMTrack;
 
	@FindBy(xpath = "//div[@id='lscoEarlyDelivery']")
	private WebElement lscoEarlyDelivery;
 
	@FindBy(xpath = "(//div[@id='lscoAllComponents'])")
	private WebElement lscoAllComponents;
 
	
	@FindBy(xpath = "//div[contains(text(),'Carryover Components Now?')]")
	private WebElement carryoverComponentsNow;
	
	public void CopyCarryoverForAttributesValidation(ExtentTest test, String colorwayCode) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(filterdata)).sendKeys(colorwayCode);
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colorwayName)).click();
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
	 
		driver.switchTo().frame(iframeContentframe);
		
		
		
		
		List<WebElement> Attributeslist=Arrays.asList(lscoActivated,carryoverComponentsNow,lscoNewCarryover,lscoAllComponents,lscoAllComponentsSKU,lscoAvailable,lscoCreateColorwayBOMs,lscoUseProductTemplate,BOMComments,
					lscoSeason,lscoGTMTrack,lscoEarlyDelivery,SourcePC9Status,LinkSrcToPC9,VendorList,BriefCode);
		
		List<String> Attributesname = Arrays.asList("lscoActivated","carryoverComponentsNow","lscoNewCarryover","lscoAllComponents","lscoAllComponentsSKU","lscoAvailable","lscoCreateColorwayBOMs",
														"lscoUseProductTemplate","BOM Comments","lscoSeason","lscoGTMTrack","lscoEarlyDelivery","SourcePC9Status","LinkSrcToPC9","VendorList","Brief code");
		
		
		for (int i=0;i<Attributeslist.size();i++) {
			if(Attributeslist.get(i).getText().isEmpty()) {
				System.out.println("The value of  "+ Attributesname.get(i)+"  is blank/empty");
				test.log(Status.INFO,"The value of  "+ Attributesname.get(i)+"  is blank/empty");
				addSrceenShot("The value of  "+ Attributesname.get(i)+"  is blank/empty", test, Capture);
				
			}else if(Attributeslist.get(i).getText().equalsIgnoreCase("no")){
				System.out.println("The value of  "+ Attributesname.get(i)+"  is No ");
				test.log(Status.INFO,"The value of  "+ Attributesname.get(i)+"  is No ");
				
				
			}
			else if(Attributeslist.get(i).getText().equalsIgnoreCase("yes")){
				System.out.println("The value of  "+ Attributesname.get(i)+"  is Yes ");
				test.log(Status.INFO,"The value of  "+ Attributesname.get(i)+"  is Yes ");
				
				
			}
			else{
				System.out.println("The value of  "+ Attributesname.get(i)+"  is  " + Attributeslist.get(i).getText());
				test.log(Status.INFO,"The value of  "+ Attributesname.get(i)+"  is  " + Attributeslist.get(i).getText());	
				
			}
		}
		
	}
	 

}
