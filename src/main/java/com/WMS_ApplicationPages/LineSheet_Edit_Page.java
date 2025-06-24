package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class LineSheet_Edit_Page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public LineSheet_Edit_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	boolean Capture = true;

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//label[contains(text(),'My Seasons')]")
	private WebElement Myseason;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement SeasonsDropdown;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement FilterTextbox;

	@FindBy(xpath = "//button[@title='Options']")
	private WebElement settings;

	@FindBy(xpath = "//span[@id='pr_id_4_label']")
	private WebElement level_DD;

	@FindBy(xpath = "//button[@title='Apply Changes']")
	private WebElement ApplyChanges;

	@FindBy(xpath = "//li[@aria-label='Colorway']")
	private WebElement colorway_value;

	@FindBy(xpath = "//span[@id='pr_id_2_label']")
	private WebElement linesheet_View;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c59-2']")
	private WebElement linesheet_View_textbox;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement view_selection;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement Include_sources;

	@FindBy(xpath = "(//div[@class='p-checkbox p-component'])[1]")
	private WebElement uncheckedInclude_sources;

	@FindBy(xpath = "//div[text()=' Season Groups ']/following::div[@role='button'][2]")
	private WebElement SeasonGroups_Global;

	@FindBy(xpath = "(//li[@role='option'])[2]")
	private WebElement SeasonGroups_Global_value;

	@FindBy(xpath = "//div[text()=' Season Groups ']/following::div[@role='button'][3]")
	private WebElement SeasonGroups_LocalHub;

	@FindBy(xpath = "//div[@class='ng-tns-c59-11 p-dropdown p-component p-dropdown-open']")
	private WebElement SeasonGroups_LocalHub_open;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoHubOfferedTo|~*~|1.Adoption'])[2]")
	private WebElement HubOfferedTo_value;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoHubOfferedTo|~*~|1.Adoption'])[1]")
	private WebElement HubOfferedTo;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoAdopted|~*~|1.Adoption'])[2]")
	private WebElement Adopted_GB_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoMerchantNew|~*~|TEAMCONTACTS'])[2]")
	private WebElement Merchant_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoPDSObjRefNew|~*~|TEAMCONTACTS'])[2]")
	private WebElement PDS_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoGarmentDeveloperObjRefNew|~*~|TEAMCONTACTS'])[2]")
	private WebElement GarmentDeveloper_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoDesignerNew|~*~|TEAMCONTACTS'])[2]")
	private WebElement Designer_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoMerchantNew|~*~|TEAMCONTACTS'])//div/a")
	private WebElement SelectedMerchant_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoPDSObjRefNew|~*~|TEAMCONTACTS'])//div/a")
	private WebElement SelectedPDS_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoGarmentDeveloperObjRefNew|~*~|TEAMCONTACTS'])//div/a")
	private WebElement SelectedGarmentDeveloper_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoDesignerNew|~*~|TEAMCONTACTS'])//div/a")
	private WebElement SelectedDesigner_value;

	@FindBy(xpath = "(//input[@aria-activedescendant='p-highlighted-option'])[2]")
	private WebElement Adopted_TextBox;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoAdopted|~*~|1.Adoption'])[2]")
	private WebElement Adopted_LH_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoProductDevCenter|~*~|1.Adoption'])[2]")
	private WebElement ProductDevCenter_Value;

	@FindBy(xpath = "//li[@role='option']/span")
	private WebElement Adopted_SelectValue;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement Save_button;

	@FindBy(xpath = "(//button[@class='p-element Rectangle button p-button p-component ng-star-inserted'])[2]")
	private WebElement SaveButton;

	@FindBy(xpath = "//div[text()=' Season Groups ']/following::div[@role='button'][1]")
	private WebElement Affiliate_DD;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAdopted|~*~|1.Adoption'])[2]")
	private WebElement Adopted_AFF_Value;

	@FindBy(xpath = "(//div[@class='ng-tns-c59-5 p-dropdown p-component'])")
	private WebElement filter_DD;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c59-5']")
	private WebElement filter_textbox;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement filter_selection;

	@FindBy(xpath = "(//li[@role='option'])[2]")
	private WebElement filter_secondselection;

//	-------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//label[normalize-space()='View']/following-sibling::rfa-singleselect-dropdown")
	private WebElement viewDropDown;

	@FindBy(xpath = "//button[@title='Options']//span[@class='p-button-label']")
	private WebElement settingsIcon;

	@FindBy(xpath = "//div[text()=' Season Groups ']/following::div[@role='button'][2]")
	private WebElement globalDropDown;

	@FindBy(xpath = "//span[normalize-space()='Apply']")
	private WebElement applyButton;

	@FindBy(xpath = "//span[contains(@ref,'eText')][normalize-space()='Adopted? GB']/preceding::span[1]")
	private WebElement adoptedGBFilterButton;

	@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Adopted? LH']/preceding::span[1]")
	private WebElement adoptedLH_Filter;

	@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Adopted AFF']/preceding::span[1]")
	private WebElement adoptedAFF_Filter;

	@FindBy(xpath = "//div[text()=' Season Groups ']/following::div[@role='button'][3]")
	private WebElement localHubDropDown;

	@FindBy(xpath = "//span[normalize-space()='Run']")
	private WebElement RunButton;

	@FindBy(xpath = "//div[text()=' Season Groups ']/following::div[@role='button'][1]")
	private WebElement affiliateDropDown;

	@FindBy(xpath = "//div[@col-id='product.productName|~*~|1.Adoption']")
	private List<WebElement> productNames;

	@FindBy(xpath = "//label[normalize-space()='Filter']/following::p-dropdown")
	private WebElement filterDropDown;

	@FindBy(xpath = "//div[contains(text(),'Colorway Code')]/following-sibling::div")
	private WebElement colorwayCodeInput;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeftPanel;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement SearchBox;

	@FindBy(xpath = "(//div[@col-id='colorway.skuName|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement Colorwaycheck;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoAllComponentsSKU|~*~|TechpackGeneration:GarmentDeveloperView'])[2]")
	private WebElement Components_Colorway;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoAllComponentsSKU|~*~|TechpackGeneration:GarmentDeveloperView'])[2]//span")
	private WebElement ComponentsColorway_value;

	@FindBy(xpath = "//attribute-filter//div[@class='input-title']")
	private WebElement Activate_Attribute;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement productName_textbox_BFF;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[2]")
	private WebElement ColorwayName_textbox_BFF;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[3]")
	private WebElement ColorwayCode_textbox_BFF;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[4]")
	private WebElement ProductCode_textbox_BFF;

	@FindBy(xpath = "//div[@id='multilistid']//div[@class='p-element p-multiselect-label-container ng-tns-c119-12']")
	private WebElement productType_DD_BFF;

	@FindBy(xpath = "//div[@role='checkbox']")
	private WebElement Checkbox_BFF;

	@FindBy(xpath = "//div[@id='multilistid']//div[@class='p-element p-multiselect-label-container ng-tns-c119-13']")
	private WebElement Carryover_new_DD_BFF;

	@FindBy(xpath = "//div[@id='multilistid']//div[@class='p-element p-multiselect-label-container ng-tns-c119-14']")
	private WebElement Available_DD_BFF;

	@FindBy(xpath = "(//div[@col-id='product.productName|~*~|1.Adoption'])[2]//a")
	private WebElement Linesheet_ProductName_value;

	@FindBy(xpath = "(//div[@col-id='colorway.skuName|~*~|1.Adoption'])[2]//a")
	private WebElement Linesheet_ColorwayName_value;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement ColorwayName_textbox_Golbalfilter;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[2]")
	private WebElement ColorwayCode_textbox_Globalfilter;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container ng-tns-c119')])[1]")
	private WebElement Adopted_GB_DD_GlobalFilter;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container ng-tns-c119')])[2]")
	private WebElement Capsule_DD_GlobalFilter;

	@FindBy(xpath = "//div[@class='filter-critera-container']/span")
	private WebElement Filter_criteria;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement productName_textbox_PDSSSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[2]")
	private WebElement ColorwayName_textbox_PDSSSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[3]")
	private WebElement VendorId_textbox_PDSSSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[4]")
	private WebElement ColorwayCode_textbox_PDSSSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[5]")
	private WebElement ProductCode_textbox_PDSSSM;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[1]")
	private WebElement AuthorisedforPlacement_PDSSSM;

	@FindBy(xpath = "(//input[@role='searchbox'])[1]")
	private WebElement Merchant_PDSSSM;

	@FindBy(xpath = "(//input[@role='searchbox'])[2]")
	private WebElement PDS_PDSSSM;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[2]")
	private WebElement Carryover_new_DD_PDSSSM;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[4]")
	private WebElement Available_DD_PDSSSM;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[3]")
	private WebElement Capsule_DD_PDSSSM;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement Select_FirstOption;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[1]")
	private WebElement AdoptedLH_DD_sizeselection;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement TextBox;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[2]")
	private WebElement AdoptedLH_AFF_sizeselection;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[3]")
	private WebElement Carryover_new_DD_sizeselection;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[4]")
	private WebElement Capsule_DD_sizeselection;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[5]")
	private WebElement Available_DD_sizeselection;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[6]")
	private WebElement PDC_DD_sizeselection;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement Colorwaycode_sizeselection;

	@FindBy(xpath = "(//input[@role='searchbox'])[1]")
	private WebElement Sizegridcode_sizeselection;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement ColorwayName_textbox_SSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[2]")
	private WebElement productName_textbox_SSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[3]")
	private WebElement VendorId_textbox_SSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[4]")
	private WebElement ColorwayCode_textbox_SSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[5]")
	private WebElement ProductCode_textbox_SSM;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[1]")
	private WebElement Carryover_new_DD_SSM;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[2]")
	private WebElement Available_DD_SSM;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[2]")
	private WebElement ColorwayName_textbox_techpack;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement productName_textbox_techpack;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[3]")
	private WebElement VendorId_textbox_techpack;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[4]")
	private WebElement ColorwayCode_textbox_techpack;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[5]")
	private WebElement ProductCode_textbox_techpack;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[1]")
	private WebElement Available_DD_techpack;

	@FindBy(xpath = "(//input[@role='searchbox'])[1]")
	private WebElement GarmentDeveloper_techpack;

	@FindBy(xpath = "(//input[@role='searchbox'])[2]")
	private WebElement PDS_techpack;

	@FindBy(xpath = "(//div[@class='input-title'])[1]")
	private WebElement Available_placement;

	@FindBy(xpath = "(//div[@class='input-title'])[2]")
	private WebElement AuthorizedforPlacement_placement;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSUSValidation|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSUS_validation;
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement validationCheckbox;

	@FindBy(xpath = "(//div[@id='singlelistid']//span[contains(@class,'p-dropdown-label p-inputtext ng-star-inserted')])[1]")
	private WebElement Activate_DD_DataValidation;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSUSCSTrigger|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSUS;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSUSStatus|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSUS_Status;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoAvailable|~*~|1.Adoption'])[2]")
	private WebElement Available_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoStockingCustServCntr|~*~|NRFvalues'])[2]")
	private WebElement NRF_LSEStockingValue;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	private WebElement NRF_Textbox;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoFOFMonth|~*~|NRFvalues'])[2]")
	private WebElement NRF_FirstmonthOnFloorvalue;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoPriceRetail|~*~|NRFvalues'])[2]")
	private WebElement NRF_TargetGlobalMSRP;

	@FindBy(xpath = "(//input[@id='inputText'])")
	private WebElement Targetmsrp_Textbox;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoNRFClassUSOnly|~*~|NRFvalues'])[2]")
	private WebElement NRF_Classvalue;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoNRFColorCDUSOnly|~*~|NRFvalues'])[2]")
	private WebElement NRF_ColorCD_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715893766.lscoNRFSizeScaleUSOnly|~*~|NRFvalues'])[2]")
	private WebElement NRF_sizescale_value;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoNRFClassUSOnly|~*~|NRFvalues'])[2]")
	private WebElement NRF_class_value_LH;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoNRFColorCDUSOnly|~*~|NRFvalues'])[2]")
	private WebElement NRF_colorCD_value_LH;

	@FindBy(xpath = "(//div[@col-id='SGSKU2715894926.lscoNRFSizeScaleUSOnly|~*~|NRFvalues'])[2]")
	private WebElement NRF_sizescale_value_LH;

//	-----------------------Methods-----------------------------------------------------------------

	public void SeasonDropdown(String season) throws InterruptedException {
		selectValueFromDropdown(SeasonsDropdown, season);
	}

	public void filter_View_Change(String linesheetview, ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Thread.sleep(10000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(linesheet_View));

			linesheet_View.click();
			linesheet_View_textbox.sendKeys(linesheetview);
			Thread.sleep(2000);
			view_selection.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void remove_filters() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		if (!uncheckedInclude_sources.getAttribute("class").contains("checked")) {
			Include_sources.click();
		}

		filter_DD.click();
		Thread.sleep(1000);
		filter_selection.click();
		ApplyChanges.click();
		Thread.sleep(5000);
	}

	public void Seasonalgroupsfilter(String LocalHub_value, String Affiliatevalue, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		Thread.sleep(2000);
		colorway_value.click();
		Include_sources.click();
		Thread.sleep(2000);
		SeasonGroups_Global.click();
		Thread.sleep(2000);
		SeasonGroups_Global_value.click();
		Thread.sleep(2000);
		SeasonGroups_LocalHub.click();
		driver.findElement(By.xpath("//li[@role='option']/span[@title='" + LocalHub_value + "']")).click();
		test.log(Status.INFO, "Local Hub selected: " + LocalHub_value + "in setting menu");

		Affiliate_DD.click();
		driver.findElement(By.xpath("//li[@role='option']/span[@title='" + Affiliatevalue + "']")).click();
		test.log(Status.INFO, "Affiliate value selected: " + Affiliatevalue + "in setting menu");
		Thread.sleep(2000);

		ApplyChanges.click();
		Thread.sleep(5000);

	}

	public void Validate_carryovercolorway_garmentdeveloperview(ExtentTest test) {
		if (!Colorwaycheck.isDisplayed()) {
			System.out.println("Colorway is not present in Linesheet ");
			test.log(Status.INFO, "Colorway is not present in Linesheet");
			addSrceenShot("Colorway is not present in Linesheet ", test, Capture);

		}
	}

	public void Validate_componentscolorway_linesheet(ExtentTest test) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", Components_Colorway);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(Components_Colorway));

		if (ComponentsColorway_value.isDisplayed()) {
			System.out.println("Components colorway value is " + ComponentsColorway_value.getText());
			test.log(Status.INFO, "Components colorway value is " + ComponentsColorway_value.getText());
			addSrceenShot("Components colorway value is " + ComponentsColorway_value.getText(), test, Capture);
		}
		Thread.sleep(2000);
	}

	public void VerifyLinesheetview_Adoption(String columnName, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WaitforPage(5000);
			int count = 0;
			ArrayList<String> header = new ArrayList<String>();
			header = getAdoptionLinesheetheaderValue();
			for (int i = 0; i < header.size(); i++) {

				String ColumnHeader = header.get(i);
				scroll(i + 3);
				Thread.sleep(1000);
				test.log(Status.PASS, "Attributes present in linesheet are: " + ColumnHeader);
				System.out.println("Attributes are: " + ColumnHeader);
				count += 1;
			}
			System.out.println("Total number of attribute: " + count);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void VerifyLinesheetview_FLA_FinalizeDetails(ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WaitforPage(5000);
			int count = 0;
			ArrayList<String> header = new ArrayList<String>();
			header = getFLA_FinalizeDetails_LinesheetheaderValue();
			for (int i = 0; i < (header.size() - 1); i++) {
				String ColumnHeader = header.get(i);
				scroll(i + 3);
				Thread.sleep(500);
				test.log(Status.INFO, "Attributes present in linesheet are: " + ColumnHeader);
				System.out.println("Attributes are: " + ColumnHeader);
				count += 1;
			}
			System.out.println("Total number of attribute: " + count);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void SeasonalGroupsAttributesValidations(ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Thread.sleep(10000);
			settings.click();
			Assert.assertTrue(SeasonGroups_Global.isDisplayed());

			Thread.sleep(2000);
			test.log(Status.PASS, "Seasonal groups Global is present");
			Assert.assertTrue(SeasonGroups_LocalHub.isDisplayed());
			test.log(Status.PASS, "Seasonal groups LocalHub is present");
			Thread.sleep(2000);
			Assert.assertTrue(Affiliate_DD.isDisplayed());
			test.log(Status.PASS, "Seasonal groups Affiliate is present");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void Linesheet_SetUpLSUS(String colorway, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getLSUSColumnHeaderValue();
		for (int i = 0; i < (header.size()); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(500);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Set Up LSUS - Run Validation")) {
				String LSUSValidation = setUpLSUS_validation.getText();
				test.log(Status.INFO, "LSUS validation value is :  " + LSUSValidation);
				System.out.println(LSUSValidation);
				Thread.sleep(2000);
				if (LSUSValidation.equalsIgnoreCase("No")) {
					Actions action = new Actions(driver);
					action.doubleClick(setUpLSUS_validation).perform();
					Thread.sleep(2000);
					validationCheckbox.click();

				} else {
					test.log(Status.FAIL, " Set UP LSUS validation value is already YES ");
					System.out.println("Set UP LSUS validation value is already YES");
				}
			}
			if (ColumnHeader.equals("Set Up LSUS")) {
				String LSUSValue = setUpLSUS.getText();
				test.log(Status.INFO, "Set Up LSUS  value is :  " + LSUSValue);
				System.out.println(LSUSValue);
				Thread.sleep(2000);
				if (LSUSValue.equalsIgnoreCase("No")) {
					Actions action = new Actions(driver);
					action.doubleClick(setUpLSUS).perform();
					Thread.sleep(2000);
					validationCheckbox.click();
					Save_button.click();
					Thread.sleep(10000);
				} else {
					test.log(Status.FAIL, " Set UP LSUS value is already YES ");
					System.out.println("Set UP LSUS value is already YES");
				}
			}

			if (ColumnHeader.equals("Set Up LSUS Status")) {
				Thread.sleep(2000);
				String LSUSStatus = setUpLSUS_Status.getText();
				test.log(Status.INFO, "Set Up LSUS Status is :  " + LSUSStatus);
				System.out.println(LSUSStatus);
				Thread.sleep(2000);
				if (LSUSStatus.contains("No Validation Error")) {
					test.log(Status.PASS, " LSUS Set Up is done with no Error  ");
					System.out.println("LSUS Set Up is done with no Error");
				} else {
					test.log(Status.PASS, " Validation Error ");
					System.out.println("Validation Error");
				}
			}

		}

	}

	public void Update_PDS_GD_Designer_MerchantValue(String filterproduct, String merchant, String PDS,
			String garmentdeveloper, String designer, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		colorway_value.click();

		ApplyChanges.click();
		Thread.sleep(5000);
		FilterTextbox.sendKeys(filterproduct);
		test.log(Status.INFO, "Filter selected: " + filterproduct + "in setting menu");
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getTeamContactsColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Merchant")) {
				Actions action = new Actions(driver);
				action.doubleClick(Merchant_value).perform();
				Thread.sleep(2000);
				SearchBox.click();

				SearchBox.clear();
				Thread.sleep(1000);
				SearchBox.sendKeys(merchant);
				Thread.sleep(2000);
				filter_selection.click();
				test.log(Status.INFO, "Merchant value selected: " + merchant);
				Thread.sleep(2000);

			}

			if (ColumnHeader.equals("PDS")) {
				Actions action = new Actions(driver);
				action.doubleClick(PDS_value).perform();
				Thread.sleep(2000);
				SearchBox.click();

				SearchBox.clear();
				Thread.sleep(1000);
				SearchBox.sendKeys(PDS);
				Thread.sleep(2000);

				filter_selection.click();
				test.log(Status.INFO, "PDS value selected: " + PDS);
				Thread.sleep(2000);
			}
			if (ColumnHeader.equals("Garment Developer")) {
				Actions action = new Actions(driver);
				action.doubleClick(GarmentDeveloper_value).perform();
				Thread.sleep(2000);
				SearchBox.click();
				SearchBox.clear();
				Thread.sleep(1000);
				SearchBox.sendKeys(garmentdeveloper);
				Thread.sleep(2000);

				filter_selection.click();
				test.log(Status.INFO, "Garment developer value selected: " + garmentdeveloper);
				Thread.sleep(2000);
			}
			if (ColumnHeader.equals("Designer")) {
				Actions action = new Actions(driver);
				action.doubleClick(Designer_value).perform();
				Thread.sleep(2000);
				SearchBox.click();
				SearchBox.clear();
				Thread.sleep(1000);
				SearchBox.sendKeys(designer);
				Thread.sleep(2000);

				filter_selection.click();
				test.log(Status.INFO, "designer value selected: " + designer);
				Thread.sleep(2000);
			}

		}
		Save_button.click();

	}

	public void Validate_TeamContacts_UpdatedValue(String merchant, String PDS, String garmentdeveloper,
			String designer, ExtentTest test) {

		if (SelectedMerchant_value.getText().equals(merchant)) {
			System.out.println("Merchant value is updated and the value is: " + SelectedMerchant_value.getText());
			test.log(Status.INFO, "Merchant value is updated and the value is: " + SelectedMerchant_value.getText());
			addSrceenShot("Merchant value is updated and the value is: " + SelectedMerchant_value.getText(), test,
					Capture);
		}
		if (SelectedPDS_value.getText().equals(PDS)) {
			System.out.println("PDS value is updated and the value is: " + SelectedPDS_value.getText());
			test.log(Status.INFO, "PDS value is updated and the value is: " + SelectedPDS_value.getText());
			addSrceenShot("PDS value is updated and the value is: " + SelectedPDS_value.getText(), test, Capture);

		}
		if (SelectedGarmentDeveloper_value.getText().equals(garmentdeveloper)) {
			System.out.println("Garmment developer value is updated and the value is: "
					+ SelectedGarmentDeveloper_value.getText());
			test.log(Status.INFO, "Garmment developer value is updated and the value is: "
					+ SelectedGarmentDeveloper_value.getText());
			addSrceenShot(
					"Garmment developer value is updated and the value is: " + SelectedGarmentDeveloper_value.getText(),
					test, Capture);

		}
		if (SelectedDesigner_value.getText().equals(designer)) {
			System.out.println("Designer value is updated and the value is: " + SelectedDesigner_value.getText());
			test.log(Status.INFO, "Designer value is updated and the value is: " + SelectedDesigner_value.getText());
			addSrceenShot("Designer value is updated and the value is: " + SelectedDesigner_value.getText(), test,
					Capture);
		}
	}

	public void setting_colorway() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		colorway_value.click();
		Include_sources.click();
		ApplyChanges.click();
		Thread.sleep(4000);
	}

	public void changeLocalHub_Value(String filtercolorway, String LocalHub_value, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		colorway_value.click();
		Include_sources.click();
		SeasonGroups_Global.click();
		SeasonGroups_Global_value.click();
		SeasonGroups_LocalHub.click();
		driver.findElement(By.xpath("//li[@role='option']/span[@title='" + LocalHub_value + "']")).click();
		test.log(Status.INFO, "Local Hub selected: " + LocalHub_value + "in setting menu");
		ApplyChanges.click();
		Thread.sleep(4000);
		FilterTextbox.clear();
		FilterTextbox.sendKeys(filtercolorway);
		test.log(Status.INFO, "Filter selected: " + filtercolorway + "in setting menu");
		Thread.sleep(5000);

	}

	public void Change_Global_Value() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		colorway_value.click();
		Include_sources.click();
		SeasonGroups_Global.click();
		SeasonGroups_Global_value.click();
		ApplyChanges.click();
	}

	public void Linesheetfilter(String filtervalue) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Thread.sleep(2000);
			settings.click();
			Thread.sleep(2000);
			level_DD.click();
			Thread.sleep(2000);
			colorway_value.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(filter_DD));
			Thread.sleep(2000);
			filter_DD.click();
//	        js.executeScript("arguments[0].value='FLA';", filter_textbox);
			Thread.sleep(2000);

			if (filtervalue.equalsIgnoreCase("SSM")) {
				filter_textbox.sendKeys(filtervalue);
				Thread.sleep(1000);
				filter_secondselection.click();
				Thread.sleep(5000);
			} else {
				filter_textbox.sendKeys(filtervalue);
				Thread.sleep(1000);
				filter_selection.click();
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	can be used as common method-------
	public void Filters_Attribute_Validation(String expectedAttributes, ExtentTest test) {
		try {
			String[] listofattributes = expectedAttributes.split(",");
			List<WebElement> attributes = driver
					.findElements(By.xpath("//attribute-filter//div[@class='input-title']"));
			for (WebElement ele : attributes) {
				String Actualattribute = ele.getText();
//				System.out.println(Actualattribute);
				for (String ExpectedAttribute : listofattributes) {
//					System.out.println(ExpectedAttribute);
					if (ExpectedAttribute.equalsIgnoreCase("Merchant") || ExpectedAttribute.equalsIgnoreCase("PDS")
							|| ExpectedAttribute.equalsIgnoreCase("Size Grid Code")
							|| ExpectedAttribute.equalsIgnoreCase("Garment Developer")) {
						String expAttribute = driver
								.findElement(By.xpath("//attribute-filter//div[@class='input-title']/a")).getText();
						if (Actualattribute.equalsIgnoreCase(expAttribute)) {
							test.log(Status.INFO, "Actual attribute is : " + Actualattribute
									+ " matching with Expected attribute:  " + expAttribute);
						}
					} else {
						System.out.println(ExpectedAttribute);
						if (Actualattribute.equalsIgnoreCase(ExpectedAttribute)) {
							test.log(Status.INFO, "Actual attribute is : " + Actualattribute
									+ " matching with Expected attribute:  " + ExpectedAttribute);

						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Validate_placementFiltervalues(ExtentTest test) throws InterruptedException {

		System.out.println("Available value prepopulated is : " + Available_placement.getText());
		test.log(Status.INFO, "Available value prepopulated is : " + Available_placement.getText());
		addSrceenShot("Available value prepopulated is : " + Available_placement.getText(), test, Capture);

		System.out.println(
				"Authorized for placement value prepopulated is : " + AuthorizedforPlacement_placement.getText());
		test.log(Status.INFO,
				"Authorized for placement value prepopulated is : " + AuthorizedforPlacement_placement.getText());
		addSrceenShot("Authorized for placement value prepopulated is : " + AuthorizedforPlacement_placement.getText(),
				test, Capture);

		ApplyChanges.click();
		Thread.sleep(2000);

	}

	public void Enter_BFFFilterFieldsValues(String productname, String colorwayname, String colorwaycode,
			String productcode, ExtentTest test) throws InterruptedException {

		productName_textbox_BFF.sendKeys(productname);
		test.log(Status.INFO, "Productname Entered is " + productname);
		Thread.sleep(1000);

		ColorwayName_textbox_BFF.sendKeys(colorwayname);
		test.log(Status.INFO, "colorwayname Entered is " + colorwayname);
		Thread.sleep(1000);
		ColorwayCode_textbox_BFF.sendKeys(colorwaycode);
		test.log(Status.INFO, "colorwaycode Entered is " + colorwaycode);
		Thread.sleep(1000);
		ProductCode_textbox_BFF.sendKeys(productcode);
		test.log(Status.INFO, "productcode Entered is " + productcode);
		Thread.sleep(1000);
		productType_DD_BFF.click();
		Checkbox_BFF.click();
		Thread.sleep(1000);
		Carryover_new_DD_BFF.click();
		Checkbox_BFF.click();
		Thread.sleep(1000);
		Available_DD_BFF.click();
		Checkbox_BFF.click();
		Thread.sleep(1000);
		ApplyChanges.click();
		Thread.sleep(2000);

	}

	public void Enter_GlobalFiltervalues(String colorwayname, String colorwaycode, ExtentTest test)
			throws InterruptedException {

		Capsule_DD_GlobalFilter.click();
		Checkbox_BFF.click();
		Thread.sleep(1000);
		ColorwayName_textbox_Golbalfilter.sendKeys(colorwayname);
		Thread.sleep(1000);
		test.log(Status.INFO, "colorwayname Entered is " + colorwayname);
		ColorwayCode_textbox_Globalfilter.sendKeys(colorwaycode);
		Thread.sleep(1000);
		test.log(Status.INFO, "colorwaycode Entered is " + colorwaycode);
		Adopted_GB_DD_GlobalFilter.click();
		Checkbox_BFF.click();
		Thread.sleep(1000);

		ApplyChanges.click();
		Thread.sleep(6000);

	}

	public void Enter_PDSSSM_FilterValues(String productname, String colorwayname, String vendorId, String colorwaycode,
			String productcode, String merchant, String PDS, ExtentTest test) throws InterruptedException {

		productName_textbox_PDSSSM.sendKeys(productname);
		Thread.sleep(1000);
		test.log(Status.INFO, "productname Entered is " + productname);
		ColorwayName_textbox_PDSSSM.sendKeys(colorwayname);
		Thread.sleep(1000);
		test.log(Status.INFO, "colorwayname Entered is " + colorwayname);

		AuthorisedforPlacement_PDSSSM.click();
		Checkbox_BFF.click();
		Thread.sleep(2000);

		VendorId_textbox_PDSSSM.sendKeys(vendorId);
		Thread.sleep(1000);
		test.log(Status.INFO, "vendorId Entered is " + vendorId);

		Capsule_DD_PDSSSM.click();
		Checkbox_BFF.click();
		Thread.sleep(2000);

		ColorwayCode_textbox_PDSSSM.sendKeys(colorwaycode);
		Thread.sleep(1000);
		test.log(Status.INFO, "colorwaycode Entered is " + colorwaycode);

		Carryover_new_DD_PDSSSM.click();
		Checkbox_BFF.click();
		Thread.sleep(2000);

		ProductCode_textbox_PDSSSM.sendKeys(productcode);
		Thread.sleep(1000);
		test.log(Status.INFO, "productcode Entered is " + productcode);

		Available_DD_PDSSSM.click();
		Checkbox_BFF.click();
		Thread.sleep(2000);

		Merchant_PDSSSM.sendKeys(merchant);
		Thread.sleep(4000);
		Select_FirstOption.click();

		PDS_PDSSSM.sendKeys(PDS);
		Thread.sleep(4000);
		Select_FirstOption.click();

		ApplyChanges.click();
		Thread.sleep(6000);

	}

	public void Enter_SizeSelectionFilter_values(String adoptedLH, String adoptedAFF, String carryover, String capsule,
			String available, String productdevcenter, String colorwaycode, String sizegridcode, ExtentTest test)
			throws InterruptedException {

		AdoptedLH_DD_sizeselection.click();
		TextBox.sendKeys(adoptedLH);
		Checkbox_BFF.click();
		Thread.sleep(1000);
		test.log(Status.INFO, "adoptedLH selected is " + adoptedLH);

		Carryover_new_DD_sizeselection.click();
		TextBox.sendKeys(carryover);
		Checkbox_BFF.click();
		test.log(Status.INFO, "carryover selected is " + carryover);

		AdoptedLH_AFF_sizeselection.click();
		Thread.sleep(500);
		TextBox.sendKeys(adoptedAFF);
		Thread.sleep(500);
		Checkbox_BFF.click();
		test.log(Status.INFO, "adoptedAFF selected is " + adoptedAFF);
		Thread.sleep(1000);

		Available_DD_sizeselection.click();
		Thread.sleep(500);
		TextBox.sendKeys(available);
		Thread.sleep(500);
		Checkbox_BFF.click();
		Thread.sleep(1000);
		test.log(Status.INFO, "available selected is " + available);

		Capsule_DD_sizeselection.click();
		Thread.sleep(500);
		TextBox.sendKeys(capsule);
		Thread.sleep(500);
		Checkbox_BFF.click();
		Thread.sleep(1000);
		test.log(Status.INFO, "capsule selected is " + capsule);

		PDC_DD_sizeselection.click();
		Thread.sleep(500);
		TextBox.sendKeys(productdevcenter);
		Thread.sleep(500);
		Checkbox_BFF.click();
		Thread.sleep(1000);
		test.log(Status.INFO, "productdevcenter selected is " + productdevcenter);

		Sizegridcode_sizeselection.sendKeys(sizegridcode);
		test.log(Status.INFO, "sizegridcode Entered is " + sizegridcode);
		Thread.sleep(3000);
		Select_FirstOption.click();
		Thread.sleep(1000);
		settings.click();

		Colorwaycode_sizeselection.sendKeys(colorwaycode);
		test.log(Status.INFO, "colorwaycode Entered is " + colorwaycode);

		ApplyChanges.click();
		Thread.sleep(2000);

	}

	public void Enter_SSMFilter_Values(String productname, String colorwayname, String vendorId, String colorwaycode,
			String productcode, String available, String carryover, ExtentTest test) throws InterruptedException {

		productName_textbox_SSM.sendKeys(productname);
		test.log(Status.INFO, "Productname Entered is " + productname);
		Thread.sleep(1000);

		ColorwayName_textbox_SSM.sendKeys(colorwayname);
		test.log(Status.INFO, "colorwayname Entered is " + colorwayname);
		Thread.sleep(1000);

		VendorId_textbox_SSM.sendKeys(vendorId);
		Thread.sleep(1000);
		test.log(Status.INFO, "vendorId Entered is " + vendorId);

		Carryover_new_DD_SSM.click();
		TextBox.sendKeys(carryover);
		Checkbox_BFF.click();
		test.log(Status.INFO, "carryover selected is " + carryover);

		ColorwayCode_textbox_SSM.sendKeys(colorwaycode);
		test.log(Status.INFO, "colorwaycode Entered is " + colorwaycode);
		Thread.sleep(1000);

		Available_DD_SSM.click();
		Thread.sleep(500);
		TextBox.sendKeys(available);
		Thread.sleep(500);
		Checkbox_BFF.click();
		test.log(Status.INFO, "available selected is " + available);
		Thread.sleep(1000);

		ProductCode_textbox_SSM.sendKeys(productcode);
		test.log(Status.INFO, "productcode Entered is " + productcode);
		Thread.sleep(1000);

		ApplyChanges.click();
		Thread.sleep(2000);
	}

	public void Enter_DataValidationFilter_values(String activate, ExtentTest test) throws InterruptedException {

		Activate_DD_DataValidation.click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//li[@role='option' and @aria-label='" + activate + "']")).click();

		ApplyChanges.click();
		Thread.sleep(2000);

	}

	public void Enter_TechpackgroupingFilter_values(String productname, String colorwayname, String vendorId,
			String colorwaycode, String productcode, String available, String PDS, String garmentdeveloper,
			ExtentTest test) throws InterruptedException {

		productName_textbox_techpack.sendKeys(productname);
		Thread.sleep(1000);
		test.log(Status.INFO, "productname Entered is " + productname);

		ColorwayName_textbox_techpack.sendKeys(colorwayname);
		Thread.sleep(1000);
		test.log(Status.INFO, "colorwayname Entered is " + colorwayname);

		VendorId_textbox_techpack.sendKeys(vendorId);
		Thread.sleep(1000);
		test.log(Status.INFO, "vendorId Entered is " + vendorId);

		Available_DD_techpack.click();
		Thread.sleep(500);
		TextBox.sendKeys(available);
		Thread.sleep(500);
		Checkbox_BFF.click();
		test.log(Status.INFO, "available selected is " + available);
		Thread.sleep(1000);

		ColorwayCode_textbox_techpack.sendKeys(colorwaycode);
		Thread.sleep(1000);
		test.log(Status.INFO, "colorwaycode Entered is " + colorwaycode);

		ProductCode_textbox_techpack.sendKeys(productcode);
		Thread.sleep(1000);
		test.log(Status.INFO, "productcode Entered is " + productcode);

		GarmentDeveloper_techpack.sendKeys(garmentdeveloper);
		Thread.sleep(2000);
		Select_FirstOption.click();
		test.log(Status.INFO, "GarmentDeveloper_techpack Selected is " + garmentdeveloper);
		Thread.sleep(2000);
		settings.click();

		PDS_techpack.sendKeys(PDS);
		Thread.sleep(2000);
		Select_FirstOption.click();
		test.log(Status.INFO, "PDS Selected is " + PDS);
		Thread.sleep(2000);
		settings.click();

		ApplyChanges.click();
		Thread.sleep(2000);

	}

	public void validate_filteredLinesheet(ExtentTest test) {

		System.out.println("Filter criteria is : " + Filter_criteria.getAttribute("title"));
		test.log(Status.INFO, "Filter criteria is : " + Filter_criteria.getAttribute("title"));
		addSrceenShot("Filter criteria is : " + Filter_criteria.getAttribute("title"), test, Capture);

	}

	public void Validate_FilterAttributes_DataValidation(String expectedAttributes, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		if (Activate_Attribute.getText().equalsIgnoreCase(expectedAttributes)) {
			System.out.println(" Activate Attribute is present in UI for Data validation filter ");
			test.log(Status.INFO, " Activate Attribute is present in UI for Data validation filter ");
			addSrceenShot("Activate Attribute is present in UI for Data validation filter ", test, Capture);

		}
	}

	public void Change_AdoptedGB_value(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 14; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Adopted? GB")) {

				String adoptedGBvalue = Adopted_GB_value.getText();
				test.log(Status.INFO, "scrolled to Adopted GB and the value is :  " + adoptedGBvalue);
				System.out.println(adoptedGBvalue);
				Thread.sleep(2000);
				if (adoptedGBvalue.equalsIgnoreCase("No")) {
					Actions action = new Actions(driver);
					action.doubleClick(Adopted_GB_value).perform();
					Thread.sleep(2000);
					Adopted_TextBox.sendKeys("Yes");
					Thread.sleep(2000);
					Adopted_SelectValue.click();
					Adopted_GB_value.click();
					Save_button.click();
					Thread.sleep(100000);
					test.log(Status.PASS, "Adopted GB value is changed to YES ");
					System.out.println("Adopted GB value is changed to YES");

				} else {
					test.log(Status.PASS, "Adopted GB value is already YES ");
					System.out.println("Adopted GB value is already YES");
				}
			}

		}
	}

	public void Change_AdoptedLH_Value(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 14; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Adopted? LH")) {
				String adoptedLHvalue = Adopted_LH_value.getText();
				System.out.println(adoptedLHvalue);
				Thread.sleep(2000);
				if (adoptedLHvalue.equalsIgnoreCase("No") || adoptedLHvalue.isEmpty()
						|| adoptedLHvalue.equalsIgnoreCase("Dropped")) {
					test.log(Status.INFO, "scrolled to Adopted LH and the value is :  " + adoptedLHvalue);
					Thread.sleep(2000);
					Actions action = new Actions(driver);
					action.doubleClick(Adopted_LH_value).perform();
					Thread.sleep(2000);
					Adopted_TextBox.sendKeys("Yes");
					Adopted_SelectValue.click();
					Adopted_GB_value.click();
					Save_button.click();
					Thread.sleep(100000);
					test.log(Status.PASS, "Adopted LH value is changed and the value is YES ");
					System.out.println("Adopted LH value changed and the value is YES");
				} else {
					test.log(Status.PASS, "Adopted LH value is already YES ");
					System.out.println("Adopted LH value is already YES");
				}
			}
		}
	}

	public void Change_AdoptedLH_toNO(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			ArrayList<String> header = new ArrayList<String>();
			header = getAdoptionColumnHeaderValue();
			for (int i = 0; i < header.size(); i++) {
				String ColumnHeader = header.get(i);
				scroll(i + 3);
				System.out.println(ColumnHeader);
				if (ColumnHeader.equals("Adopted? LH")) {
					String adoptedLHvalue = Adopted_LH_value.getText();
					System.out.println("Adopted LH value before chnaging:  " + adoptedLHvalue);
					Thread.sleep(2000);
					if (adoptedLHvalue.equalsIgnoreCase("Yes") || adoptedLHvalue.isEmpty()) {
						test.log(Status.INFO,
								"scrolled to Adopted LH and the value before changing is :  " + adoptedLHvalue);
						Thread.sleep(2000);
						Actions action = new Actions(driver);
						action.doubleClick(Adopted_LH_value).perform();
						Thread.sleep(2000);
						Adopted_TextBox.sendKeys("No");
						Adopted_SelectValue.click();
						Adopted_GB_value.click();
						Save_button.click();
						Thread.sleep(110000);
						if (Adopted_LH_value.getText().equalsIgnoreCase("No")) {
							test.log(Status.PASS,
									"Adopted LH value is changed and the value is : " + Adopted_LH_value.getText());
							System.out.println(
									"Adopted LH value changed and the value is :  " + Adopted_LH_value.getText());
						} else {
							test.log(Status.FAIL, "Adopted LH value is not changed ");
							System.out.println("Adopted LH value not changed");
						}

					} else {
						test.log(Status.INFO, "Adopted LH value is already No ");
						System.out.println("Adopted LH value is already No");
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Validate_Available_Attribute(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		if (Available_value.getText().equalsIgnoreCase("Yes")) {
			test.log(Status.PASS, "Available? value is : " + Available_value.getText());
			System.out.println("Available? value is : " + Available_value.getText());
			addSrceenShot("Available? value is : " + Available_value.getText(), test, Capture);
		}
	}

	public void Change_AdoptedGB_value_toDROPPED(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 14; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Adopted? GB")) {

				String adoptedGBvalue = Adopted_GB_value.getText();
				test.log(Status.INFO, "scrolled to Adopted GB and the value is :  " + adoptedGBvalue);
				System.out.println(adoptedGBvalue);
				Thread.sleep(2000);
				if (!adoptedGBvalue.equalsIgnoreCase("Dropped")) {
					Actions action = new Actions(driver);
					action.doubleClick(Adopted_GB_value).perform();
					Thread.sleep(2000);
					Adopted_TextBox.sendKeys("Dropped");
					Thread.sleep(2000);
					Adopted_SelectValue.click();
					Adopted_GB_value.click();
					Save_button.click();
					Thread.sleep(120000);
					String changedadoptedGBvalue = Adopted_GB_value.getText();
					test.log(Status.PASS, "After changing Adopted GB value is :  " + changedadoptedGBvalue);
					test.log(Status.INFO, "Adopted GB value is changed to Dropped ");
					System.out.println("Adopted GB value is changed to Dropped");
					Thread.sleep(5000);

				} else {
					test.log(Status.INFO, "Adopted GB value is already Dropped ");
					System.out.println("Adopted GB value is already Dropped");
				}
			}

		}
	}

	public void Validate_AdoptedLH_DroppedValue(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 14; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Adopted? LH")) {
				String adoptedLHvalue = Adopted_LH_value.getText();
				System.out.println(adoptedLHvalue);
				Thread.sleep(2000);
				if (adoptedLHvalue.equalsIgnoreCase("Dropped")) {
					test.log(Status.PASS, "Adopted LH value is autopopulated and the value is: " + adoptedLHvalue);
					System.out.println("Adopted LH value autopopulated and the value is:  " + adoptedLHvalue);
					addSrceenShot("Adopted LH value autopopulated and the value is:  " + adoptedLHvalue, test, Capture);
				} else {
					test.log(Status.FAIL, "Adopted LH value is not autopopulating to Dropped ");
					System.out.println("Adopted LH value is not autopopulating to Dropped");
				}
				Thread.sleep(5000);
				Actions action = new Actions(driver);
				action.doubleClick(Adopted_LH_value).perform();
				Thread.sleep(2000);
				Adopted_TextBox.sendKeys("Yes");
				Adopted_SelectValue.click();
				Adopted_LH_value.sendKeys(Keys.ENTER);
				Save_button.click();
				Thread.sleep(100000);
				if (Adopted_LH_value.getText().equalsIgnoreCase("Dropped")) {
					test.log(Status.PASS, "Adopted LH value Remained Dropped ");
					System.out.println("Adopted LH value Remained Dropped");
				}

			}
		}
	}

	public void Change_AdoptedAFF_Value(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionAFFColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(500);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Adopted AFF")) {
				String adoptedAFF = Adopted_AFF_Value.getText();
				System.out.println(adoptedAFF);
				Thread.sleep(2000);
				if (adoptedAFF.equalsIgnoreCase("No")) {
					test.log(Status.INFO, "scrolled to Adopted AFF and the value is :  " + adoptedAFF);
					Thread.sleep(2000);
					Actions action = new Actions(driver);
					action.doubleClick(Adopted_AFF_Value).perform();
					Thread.sleep(2000);
					Adopted_TextBox.sendKeys("Yes");
					Thread.sleep(1000);
					Adopted_SelectValue.click();
					Adopted_LH_value.click();
					Save_button.click();
					Thread.sleep(100000);

				} else {
					test.log(Status.PASS, "Adopted AFF value is already YES ");
					System.out.println("Adopted AFF value is already YES");
				}
			}

		}
		test.log(Status.PASS, "After changing Adopted AFF value is :  " + Adopted_AFF_Value.getText());
	}

	public void Adoption_Prerequisite_Validation(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 14; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Product Dev. Center Old (Colorway)")) {

				String productdevcenter = ProductDevCenter_Value.getText();
				Assert.assertTrue(productdevcenter.equalsIgnoreCase("Global"));
				test.log(Status.INFO, "scrolled to Product Dev Center and the value is :  " + productdevcenter);
			}
			if (ColumnHeader.equals("Hub Offered To")) {

				String hubofferedto = HubOfferedTo_value.getText();
				Assert.assertTrue(hubofferedto.equalsIgnoreCase("Global"));
				test.log(Status.INFO, "scrolled to hubofferedto and the value is :  " + hubofferedto);
			}
			if (ColumnHeader.equals("Adopted? GB")) {

				String adoptedGBvalue = Adopted_GB_value.getText();
				Assert.assertTrue(adoptedGBvalue.equalsIgnoreCase("Yes"));
				test.log(Status.INFO, "scrolled to Adopted GB and the value is :  " + adoptedGBvalue);
			}
			if (ColumnHeader.equals("Adopted? LH")) {
				String adoptedLHvalue = Adopted_LH_value.getText();
				System.out.println(adoptedLHvalue);

				if (adoptedLHvalue.equalsIgnoreCase("No")) {
					test.log(Status.INFO, "scrolled to Adopted LH and the value is :  " + adoptedLHvalue);
					Thread.sleep(2000);
					Actions action = new Actions(driver);
					action.doubleClick(Adopted_LH_value).perform();
					Thread.sleep(2000);
					Adopted_TextBox.sendKeys("Yes");
					Adopted_SelectValue.click();
					Adopted_GB_value.click();
					Thread.sleep(2000);
					Save_button.click();
					WaitforPage(5000);
					test.log(Status.PASS, "Adopted LH value is changed and the value is  YES ");
					System.out.println("Adopted LH value changed and the value is YES");
				} else {
					test.log(Status.PASS, "Adopted LH value is already YES ");
					System.out.println("Adopted LH value is already YES");
				}
			}
		}
	}

	public void AdoptionAFF_Prerequisite_Validation(ExtentTest test) throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getAdoptionColumnHeaderValue();
		for (int i = 0; i < 15; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(1000);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Product Dev. Center Old (Colorway)")) {

				String productdevcenter = ProductDevCenter_Value.getText();
				Thread.sleep(5000);
				Assert.assertTrue(productdevcenter.equalsIgnoreCase("Global"));
				test.log(Status.INFO, "scrolled to Product Dev Center and the value is :  " + productdevcenter);
			}
			if (ColumnHeader.equals("Adopted? GB")) {

				String adoptedGBvalue = Adopted_GB_value.getText();
				Thread.sleep(2000);
				Assert.assertTrue(adoptedGBvalue.equalsIgnoreCase("Yes"));
				test.log(Status.INFO, "scrolled to Adopted GB and the value is :  " + adoptedGBvalue);
			}
			if (ColumnHeader.equals("Adopted? LH")) {

				String adoptedLHvalue = Adopted_LH_value.getText();
				Thread.sleep(2000);
				Assert.assertTrue(adoptedLHvalue.equalsIgnoreCase("Yes"));
				test.log(Status.INFO, "scrolled to Adopted LH and the value is :  " + adoptedLHvalue);
			}
		}
	}

	public void Affiliate_selection(String Affiliate_value, ExtentTest test) throws InterruptedException {
		Thread.sleep(2000);
		settings.click();
		Affiliate_DD.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@aria-label='" + Affiliate_value + "']")).click();
		test.log(Status.INFO, "Selected Affiliate Seasonal groups:  " + Affiliate_value);
		ApplyChanges.click();
		Thread.sleep(3000);

	}

	public void Adopted_AFF_Selection(ExtentTest test) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		String adoptedAFF = Adopted_AFF_Value.getText();
		System.out.println(adoptedAFF);
		if (adoptedAFF.equalsIgnoreCase("No")) {
			test.log(Status.INFO, "scrolled to Adopted AFF and the value is :  " + adoptedAFF);
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.doubleClick(Adopted_AFF_Value).perform();
			Thread.sleep(2000);
			Adopted_TextBox.sendKeys("Yes");
			Thread.sleep(2000);
			Adopted_SelectValue.click();
			Adopted_LH_value.click();
			Thread.sleep(2000);
			Save_button.click();
			test.log(Status.PASS, "After changing Adopted AFF value is :  " + Adopted_AFF_Value.getText());
		}

	}

//	public void scrollToLinesheetHeader(String columnName) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		int scrollAmount = 0;
//		boolean columnHeaderFound = false;
//
//		while (!columnHeaderFound) {
//			try {
//				js.executeScript(
//						"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft += " + scrollAmount);
//				WebElement columnHeader = driver
//						.findElement(By.xpath("//span[@ref='eText'][normalize-space()='" + columnName + "']"));
//				new Actions(driver).moveToElement(columnHeader).perform();
//				columnHeaderFound = true;
//			} catch (Exception e) {
//				scrollAmount += 800;
//				if (scrollAmount > 4000) {
//					throw new NoSuchElementException("Column header not found after scrolling.");
//				}
//			}
//		}
//	}

//	----------------------------------------------------------------------------------------------------------

	public void selectViewDropdown(String viewType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		System.out.println("string menu" + ":" + viewType);

		WebElement dropdownSymbol = new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(viewDropDown));
		dropdownSymbol.click();

		WebElement searchBox = new WebDriverWait(driver, 10).until(
				ExpectedConditions.elementToBeClickable(By.cssSelector(".p-dropdown-filter.p-inputtext.p-component")));
		searchBox.sendKeys(viewType);
		Thread.sleep(5000);

		WebElement option = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@aria-label='1. Adoption']")));
		option.click();

	}

	public void selectSeasonGroupAsGlobal(String globalVaue) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(globalDropDown));

		Actions actions = new Actions(driver);
		actions.moveToElement(globalDropDown).click().perform();
		WebElement option = driver.findElement(By.xpath("//span[@title='" + globalVaue.trim() + "']"));
		actions.moveToElement(option).click().perform();

		Thread.sleep(4000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();

		Thread.sleep(4000);

	}

	public void changeAdoptedStatusToYes(String columnName, WebElement filterButton) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		JavascriptExecutor js = (JavascriptExecutor) driver;

//		int scrollAmount = 0;
//		boolean columnHeaderFound = false;
//
//		while (!columnHeaderFound) {
//			try {
//				js.executeScript(
//						"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft += " + scrollAmount);
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=2500");

		WebElement columnHeader = driver
				.findElement(By.xpath("//span[@ref='eText'][normalize-space()='" + columnName + "']"));
		new Actions(driver).moveToElement(columnHeader).perform();
//				columnHeaderFound = true;
//			} catch (Exception e) {
//				scrollAmount += 2500;
//				if (scrollAmount > 3000) {
//					throw new NoSuchElementException("Column header not found after scrolling.");
//				}
//			}
//		}
//		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=100");
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(filterButton));
		js.executeScript("arguments[0].click();", filterButton);
		Thread.sleep(4000);

		try {
			WebElement selectAllCheckbox = driver.findElement(By.xpath(
					"//div[@class='ag-set-filter-list']/descendant::div[text()='Select All']/following::input[1]"));
			selectAllCheckbox.click();

			WebElement yesCheckbox = driver.findElement(
					By.xpath("//div[@class='ag-set-filter-list']/descendant::div[text()='Yes']/following::input[1]"));
			yesCheckbox.click();
		} catch (StaleElementReferenceException e) {
			WebElement selectAllCheckbox = driver.findElement(By.xpath(
					"//div[@class='ag-set-filter-list']/descendant::div[text()='Select All']/following::input[1]"));
			selectAllCheckbox.click();

			WebElement yesCheckbox = driver.findElement(
					By.xpath("//div[@class='ag-set-filter-list']/descendant::div[text()='Yes']/following::input[1]"));
			yesCheckbox.click();
		}

		Thread.sleep(4000);
	}

	public void changeTheAdoptedGBToYes() throws Exception {
		changeAdoptedStatusToYes("Adopted? GB", adoptedGBFilterButton);
	}

	public void changeTheAdoptedLHToYes() throws Exception {
		changeAdoptedStatusToYes("Adopted? LH", adoptedLH_Filter);
	}

	public void changeTheAdoptedAFFToYes() throws Exception {
		changeAdoptedStatusToYes("Adopted AFF", adoptedAFF_Filter);
	}

	public void selectlocalHubdropdownValue(String localHubValue) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(settingsIcon));
		settingsIcon.click();

		Thread.sleep(4000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(localHubDropDown));

		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		actions.moveToElement(localHubDropDown).click().perform();
		WebElement option = driver.findElement(By.xpath("//span[@title='" + localHubValue.trim() + "']"));
		actions.moveToElement(option).click().perform();

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();

		Thread.sleep(4000);

	}

	public void clickOnRun() throws Exception {

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(RunButton));
		RunButton.click();

	}

	public void selectAffiliateAaccordingToTheLocalHub_FromAffiliateDropDown(String affiliateValue) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(settingsIcon));
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

	public List<String> getProductNames() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");

		return productNames.stream().map(WebElement::getText).collect(Collectors.toList());

	}

	public void filterProductsByColorway(String filterType, String colorwayCode) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(settingsIcon));
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
		Thread.sleep(4000);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(colorwayCodeInput));
		actions.moveToElement(colorwayCodeInput).click().sendKeys(colorwayCode).perform();
		System.out.println("Colorway code is entered");

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		applyButton.click();

		Thread.sleep(4000);

	}

	public void displayTheFilteredProduct(String colorwayCode) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		int scrollAmount = 0;
		boolean columnHeaderFound = false;

		while (!columnHeaderFound) {
			try {
				js.executeScript(
						"document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft += " + scrollAmount);
				WebElement columnHeader = driver
						.findElement(By.xpath("//div[normalize-space()='" + colorwayCode.trim() + "']"));
				boolean isProductDisplayed = columnHeader.getText().contains(colorwayCode);
				if (isProductDisplayed) {
					System.out.println("Product is displayed in the Line Sheet");
				}
				columnHeaderFound = true;
			} catch (Exception e) {
				scrollAmount += 800;
				if (scrollAmount > 3000) {
					throw new NoSuchElementException("Product is not displayed in the Line Sheet");
				}
			}
		}

	}

	public void UpdateNRF_Attributes(String colorway, String LSEStockingvalue, String FirstMonthValue,
			String Targetmsrpvalue, String NRFclass, String NRFcolor, String NRFsizescale, ExtentTest test)
			throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);
		FilterTextbox.clear();
		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getNRF_ColumnHeaderValue();
		for (int i = 0; i < (header.size()); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("LSE Stocking CSC GB")) {
				Thread.sleep(2000);
				if (NRF_LSEStockingValue.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_LSEStockingValue).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(LSEStockingvalue);
					Thread.sleep(1000);
					view_selection.click();
					Thread.sleep(1000);
					NRF_LSEStockingValue.sendKeys(Keys.ENTER);

				} else {
					test.log(Status.INFO, " LSE stocking value is already filled ");
					System.out.println("LSE stocking value is already filled");
				}
			}
			if (ColumnHeader.equals("First on Floor Month GB")) {
				Thread.sleep(2000);
				if (NRF_FirstmonthOnFloorvalue.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_FirstmonthOnFloorvalue).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(FirstMonthValue);
					Thread.sleep(1000);
					view_selection.click();
					Thread.sleep(1000);
					NRF_FirstmonthOnFloorvalue.sendKeys(Keys.ENTER);

				} else {
					test.log(Status.INFO, " First floor value is already filled ");
					System.out.println("First floor value is already filled ");
				}
			}

			if (ColumnHeader.equals("Target Global MSRP")) {
				Thread.sleep(2000);
				Actions action = new Actions(driver);
				action.doubleClick(NRF_TargetGlobalMSRP).perform();
				Thread.sleep(2000);
				Targetmsrp_Textbox.clear();
				Targetmsrp_Textbox.sendKeys(Targetmsrpvalue);
				Thread.sleep(1000);
				NRF_TargetGlobalMSRP.sendKeys(Keys.ENTER);

			}
			if (ColumnHeader.equals("NRF Class (US Only) GB")) {
				Thread.sleep(2000);
				if (NRF_Classvalue.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_Classvalue).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(NRFclass);
					Thread.sleep(2000);
					view_selection.click();
					Thread.sleep(1000);
					NRF_Classvalue.sendKeys(Keys.ENTER);

				} else {
					test.log(Status.INFO, " NRF Class value is already filled ");
					System.out.println(" NRF Class value is already filled");
				}
			}

			if (ColumnHeader.equals("NRF Class (US Only) LH")) {
				Thread.sleep(2000);
				if (NRF_class_value_LH.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_class_value_LH).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(NRFclass);
					Thread.sleep(2000);
					view_selection.click();
					Thread.sleep(1000);
					NRF_class_value_LH.sendKeys(Keys.ENTER);

				} else {
					test.log(Status.INFO, " NRF Class value LH is already filled ");
					System.out.println(" NRF Class value LH is already filled");
				}
			}

			if (ColumnHeader.equals("NRF Color CD (US Only) GB")) {
				Thread.sleep(2000);
				if (NRF_ColorCD_value.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_ColorCD_value).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(NRFcolor);
					Thread.sleep(2000);
					view_selection.click();
					Thread.sleep(1000);
					NRF_ColorCD_value.sendKeys(Keys.ENTER);

				} else {
					test.log(Status.INFO, " NRF color CD value is already filled ");
					System.out.println(" NRF Color CD value is already filled");
				}
			}

			if (ColumnHeader.equals("NRF Color CD (US Only) LH")) {
				Thread.sleep(2000);
				if (NRF_colorCD_value_LH.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_colorCD_value_LH).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(NRFcolor);
					Thread.sleep(2000);
					view_selection.click();
					Thread.sleep(1000);
					NRF_colorCD_value_LH.sendKeys(Keys.ENTER);

				} else {
					test.log(Status.INFO, " NRF color CD LH value is already filled ");
					System.out.println(" NRF Color CD LH value is already filled");
				}
			}

			if (ColumnHeader.equals("NRF Size Scale (US Only) GB")) {
				Thread.sleep(2000);
				if (NRF_sizescale_value.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_sizescale_value).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(NRFsizescale);
					Thread.sleep(2000);
					view_selection.click();
					Thread.sleep(2000);
					NRF_ColorCD_value.click();
					Thread.sleep(2000);
					NRF_sizescale_value.sendKeys(Keys.ENTER);

				} else {
					test.log(Status.INFO, " NRF Size scale value is already filled ");
					System.out.println(" NRF Size scale value is already filled");
				}
			}
			if (ColumnHeader.equals("NRF Size Scale (US Only) LH")) {
				Thread.sleep(2000);
				if (NRF_sizescale_value_LH.getText().isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(NRF_sizescale_value_LH).perform();
					Thread.sleep(2000);
					NRF_Textbox.sendKeys(NRFsizescale);
					Thread.sleep(2000);
					view_selection.click();
					Thread.sleep(2000);
					NRF_colorCD_value_LH.click();
					Thread.sleep(2000);
					NRF_sizescale_value_LH.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					Save_button.click();
					Thread.sleep(30000);

				} else {
					test.log(Status.INFO, " NRF Size scale LH value is already filled ");
					System.out.println(" NRF Size scale LH value is already filled");
				}
			}

		}
		Thread.sleep(5000);
	}

	public void changeSeasonalGroupsLocalHub_Value(String localHubValue, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		colorway_value.click();
		Include_sources.click();
		SeasonGroups_Global.click();
		SeasonGroups_Global_value.click();
		test.log(Status.INFO, "Season Group As Global chosen");
		addSrceenShot("Season Group As Global chosen", test, Capture);
		Thread.sleep(2000);
		SeasonGroups_LocalHub.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@role='option']/span[@title='" + localHubValue + "']")).click();
		test.log(Status.INFO, "Local Hub selected: " + localHubValue + "in setting menu");
		addSrceenShot("Season Group As LH chosen", test, Capture);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		ApplyChanges.click();
		test.log(Status.INFO, "Clicked On Apply Button");
		addSrceenShot("Clicked On Apply Button", test, Capture);
		Thread.sleep(4000);
	}

	public void changeSeasonalGroupsAffiliate_Value(String localHubValue, String affiliateValue, ExtentTest test)
			throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		settings.click();
		level_DD.click();
		colorway_value.click();
		Include_sources.click();
		SeasonGroups_Global.click();
		SeasonGroups_Global_value.click();
		test.log(Status.INFO, "Season Group As Global chosen");
		addSrceenShot("Season Group As Global chosen", test, Capture);
		Thread.sleep(2000);
		SeasonGroups_LocalHub.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@role='option']/span[@title='" + localHubValue + "']")).click();
		test.log(Status.INFO, "Local Hub selected: " + localHubValue + "in setting menu");
		Thread.sleep(2000);
		Affiliate_DD.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@aria-label='" + affiliateValue + "']")).click();
		test.log(Status.INFO, "Local Hub selected: " + affiliateValue + "in setting menu");
		addSrceenShot("Season Group As Affiliate chosen", test, Capture);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(applyButton));
		ApplyChanges.click();
		test.log(Status.INFO, "Clicked On Apply Button");
		addSrceenShot("Clicked On Apply Button", test, Capture);
		Thread.sleep(4000);
	}

	@FindBy(xpath = "//input[@id='inputText']")
	private WebElement text_Input;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement text_box;

	@FindBy(xpath = "//div[@role='checkbox']")
	private WebElement Checkbox;

	public int MassEdit_CostWiseViewAttributes(String targetvolume, String globalmsrp, ExtentTest test)
			throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);
		int noofrecordsupdated = 0;
		ArrayList<String> header = new ArrayList<String>();
		header = getCostwise_ColumnHeaderValue();
		for (int i = 0; i < header.size() - 1; i++) {
			String ColumnHeader = header.get(i);
			Thread.sleep(300);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Target Volume [Colorway]")) {

				List<WebElement> TargetVolumeList = driver
						.findElements(By.xpath("//div[@col-id='colorway.lscoColorwayTargetVolume|~*~|Costwise']"));
				for (int j = 1; j <= TargetVolumeList.size() - 1; j++) {

					WebElement Targetvolume = driver.findElement(By.xpath(
							"(//div[@col-id='colorway.lscoColorwayTargetVolume|~*~|Costwise'])[" + (j + 1) + "]"));
					Actions action = new Actions(driver);
					action.doubleClick(Targetvolume).perform();
					Thread.sleep(1000);
					text_Input.clear();
					text_Input.sendKeys(targetvolume);
					action.sendKeys(Keys.ENTER).perform();

					noofrecordsupdated = noofrecordsupdated + i;
				}

			}
			if (ColumnHeader.equals("Global MSRP")) {

				List<WebElement> GlobalmsrpList = driver
						.findElements(By.xpath("//div[@col-id='colorway-season.lscoGlobalMSRP|~*~|Costwise']"));
				for (int j = 1; j <= GlobalmsrpList.size() - 1; j++) {

					WebElement Globalmsrp = driver.findElement(By
							.xpath("(//div[@col-id='colorway-season.lscoGlobalMSRP|~*~|Costwise'])[" + (j + 1) + "]"));
					Actions action = new Actions(driver);
					action.doubleClick(Globalmsrp).perform();
					Thread.sleep(1000);
					text_Input.clear();
					text_Input.sendKeys(globalmsrp);
					action.sendKeys(Keys.ENTER).perform();
				}

			}

		}
		Save_button.click();
		Thread.sleep(30000);
		test.log(Status.INFO, "MASS Editing for Target Volume and Global MSRP is completed");
		Thread.sleep(4000);
		return noofrecordsupdated;
	}

	public void Massupdate_Vendorlist(String vendor, ExtentTest test) throws InterruptedException {

		ArrayList<String> header = new ArrayList<String>();
		header = getSourceConfig_ColumnHeaderValue();
		for (int i = 0; i < header.size() - 1; i++) {
			String ColumnHeader = header.get(i);
			Thread.sleep(300);
			scroll(i + 3);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Vendor List")) {

				List<WebElement> VendorList = driver.findElements(By.xpath(
						"//div[@col-id='colorway-season.lscoVendorList|~*~|SourceConfig-LinkSourcetoColorway']"));
				for (int j = 1; j <= VendorList.size() - 1; j++) {

					WebElement vendors = driver.findElement(By.xpath(
							"(//div[@col-id='colorway-season.lscoVendorList|~*~|SourceConfig-LinkSourcetoColorway'])["
									+ (j + 1) + "]"));
					Actions action = new Actions(driver);
					action.doubleClick(vendors).perform();
					Thread.sleep(1000);
					text_box.clear();
					text_box.sendKeys(vendor);
					Checkbox.click();
					Thread.sleep(1000);
					action.sendKeys(Keys.ENTER).perform();

				}

				Save_button.click();

				new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//div[@col-id='colorway-season.lscoVendorList|~*~|SourceConfig-LinkSourcetoColorway']")));

				test.log(Status.INFO, "MASS Editing for Vendor List is done");
				Thread.sleep(4000);
			}
			if (ColumnHeader.equals("Source - Colorway Association Status")) {

				List<WebElement> SourceStatusList = driver.findElements(By.xpath(
						"//div[@col-id='colorway-season.lscoSourcePC9Status|~*~|SourceConfig-LinkSourcetoColorway']"));
				for (int k = 1; k <= SourceStatusList.size() - 1; k++) {

					WebElement status = driver.findElement(By.xpath(
							"(//div[@col-id='colorway-season.lscoSourcePC9Status|~*~|SourceConfig-LinkSourcetoColorway'])["
									+ (k + 1) + "]"));

					if (status.getText().equalsIgnoreCase("Success")) {
						System.out.println("MASS Editing for Vendor List is Success");
						test.log(Status.INFO, "MASS Editing for Vendor List is Success");

					}

				}

			}
		}

	}

////////////////////////p2___Anand_____/////////////////////////////

//	India_Kids	
	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement productName_textbox_IndiaKids;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[2]")
	private WebElement colorwayName_textbox__IndiaKids;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[3]")
	private WebElement colorwayCode_textbox_IndiaKids;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[4]")
	private WebElement productCode_textbox_IndiaKids;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[1]")
	private WebElement carryover_new_DD_selection_IndiaKids;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[2]")
	private WebElement available_DD_selection_IndiaKids;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[3]")
	private WebElement consumer_Group_1_DD_selection_IndiaKids;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[4]")
	private WebElement productDevCenter_DD_selection_IndiaKids;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement textBox_IndiaKids;

	@FindBy(xpath = "//div[@role='checkbox']")
	private WebElement checkbox_IndiaKids;

	
	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[1]")
	private WebElement productName_textbox_TP_Bnaglore;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[2]")
	private WebElement colorwayName_textbox__TP_Bnaglore;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[3]")
	private WebElement vendorID_textbox_TP_Bangalore;

	@FindBy(xpath = "(//input[@role='searchbox'])[1]")
	private WebElement garmentDeveloper_TP_Bangalore;

	@FindBy(xpath = "(//input[@role='searchbox'])[2]")
	private WebElement PDS_TP_Bangalore;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[1]")
	private WebElement productDevCenter_DD_selection_TP_Bangalore;

	@FindBy(xpath = "(//div[@id='multilistid']/preceding-sibling::div)[1]")
	private WebElement productDevCenter;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[2]")
	private WebElement available_DD_selection_TP_Bangalore;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[4]")
	private WebElement colorwayCode_textbox_TP_Bangalore;

	@FindBy(xpath = "(//attribute-filter//div/rfa-input-text/input)[5]")
	private WebElement productCode_textbox_TP_Bangalore;

	@FindBy(xpath = "(//div[@id='multilistid']//div[contains(@class,'p-element p-multiselect-label-container')])[3]")
	private WebElement techPack_Grouping_DD_selection_TP_Bangalore;

	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement textBox_TP_Bangalore;

	@FindBy(xpath = "//div[@role='checkbox']")
	private WebElement checkbox_TP_Bangalore;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement Select_FirstOption_TP_Bangalore;
	public void Enter_IndiaKidsFilterFieldsValues(String productname, String colorwayname, String colorwaycode,
			String productcode, String carryover, String available, String consumerGroup1, String productdevcenter,
			ExtentTest test) throws InterruptedException {

		productName_textbox_IndiaKids.sendKeys(productname);
		test.log(Status.INFO, "Productname Entered is " + productname);
		Thread.sleep(1000);

		colorwayName_textbox__IndiaKids.sendKeys(colorwayname);
		test.log(Status.INFO, "colorwayname Entered is " + colorwayname);
		Thread.sleep(1000);

		carryover_new_DD_selection_IndiaKids.click();
		Thread.sleep(500);
		test.log(Status.INFO, "carryover drop down is clicked");
		textBox_IndiaKids.sendKeys(carryover);
		Thread.sleep(500);
		test.log(Status.INFO, "carryover searche box value Entered is " + carryover);
		checkbox_IndiaKids.click();
		Thread.sleep(500);
		test.log(Status.INFO, "checkBox for carryover clicked ");
		Thread.sleep(1000);

		available_DD_selection_IndiaKids.click();
		Thread.sleep(500);
		test.log(Status.INFO, "available drop down is clicked");
		textBox_IndiaKids.sendKeys(available);
		Thread.sleep(500);
		test.log(Status.INFO, "available searche box value Entered is " + available);
		checkbox_IndiaKids.click();
//		Thread.sleep(500);
		test.log(Status.INFO, "checkBox for available clicked ");
		Thread.sleep(1000);

		colorwayCode_textbox_IndiaKids.sendKeys(colorwaycode);
		test.log(Status.INFO, "colorwaycode Entered is " + colorwaycode);
		Thread.sleep(1000);

		productCode_textbox_IndiaKids.sendKeys(productcode);
		test.log(Status.INFO, "productcode Entered is " + productcode);
		Thread.sleep(1000);

		consumer_Group_1_DD_selection_IndiaKids.click();
		Thread.sleep(500);
		test.log(Status.INFO, "consumerGroup1 drop down is clicked");
		textBox_IndiaKids.sendKeys(consumerGroup1);
		Thread.sleep(500);
		test.log(Status.INFO, "consumerGroup1 searche box value Entered is " + consumerGroup1);
		checkbox_IndiaKids.click();
		test.log(Status.INFO, "checkBox for consumerGroup1 clicked ");
		Thread.sleep(500);

		productDevCenter_DD_selection_IndiaKids.click();
		Thread.sleep(500);
		test.log(Status.INFO, "productdevcenter drop down is clicked");
		textBox_IndiaKids.sendKeys(productdevcenter);
		Thread.sleep(500);
		test.log(Status.INFO, "productdevcenter searche box value Entered is " + productdevcenter);
		checkbox_IndiaKids.click();
		test.log(Status.INFO, "checkBox for productdevcenter clicked ");
		Thread.sleep(1000);

		ApplyChanges.click();
		Thread.sleep(2000);

	}

	public void Enter_TP_BangaloreFilterFieldsValues(String productname, String colorwayname, String vendorId,
			String garmentdeveloper, String PDS, String ProductDevCenter, String available, String colorwaycode,
			String productcode, String Grouping, ExtentTest test) throws InterruptedException {

		productName_textbox_TP_Bnaglore.sendKeys(productname);
		test.log(Status.INFO, "Productname Entered is " + productname);
		Thread.sleep(1000);

		colorwayName_textbox__TP_Bnaglore.sendKeys(colorwayname);
		test.log(Status.INFO, "Productname Entered is " + colorwayname);
		Thread.sleep(1000);

		vendorID_textbox_TP_Bangalore.sendKeys(vendorId);
		test.log(Status.INFO, "Productname Entered is " + vendorId);
		Thread.sleep(2000);

//	garmentDeveloper_TP_Bangalore.sendKeys(garmentdeveloper);
//	test.log(Status.INFO, "Productname Entered is "+garmentdeveloper);
//	Thread.sleep(2000);

		garmentDeveloper_TP_Bangalore.sendKeys(garmentdeveloper);
		test.log(Status.INFO, "garmentdeveloper Entered is " + garmentdeveloper);
		Thread.sleep(4000);
		Select_FirstOption_TP_Bangalore.click();
		test.log(Status.INFO, "garmentdeveloper Selected is " + garmentdeveloper);
		Thread.sleep(2000);
		settings.click();

		PDS_TP_Bangalore.sendKeys(PDS);
		Thread.sleep(2000);
		test.log(Status.INFO, "PDS Entered is " + PDS);
		Select_FirstOption_TP_Bangalore.click();
		test.log(Status.INFO, "PDS Selected is " + garmentdeveloper);
		Thread.sleep(2000);
		settings.click();

		if (productDevCenter.getText().contains("Product Dev. Center")) {
			productDevCenter_DD_selection_TP_Bangalore.click();
			Thread.sleep(500);
			textBox_TP_Bangalore.sendKeys(ProductDevCenter);
			Thread.sleep(500);
			checkbox_TP_Bangalore.click();
			test.log(Status.INFO, "checkBox for available clicked ");
			Thread.sleep(1000);

		} else {
			System.out.println("Product Dev Center Is not Populating");
			test.log(Status.FAIL, "Product Dev Center Is not Populating");
		}

		available_DD_selection_TP_Bangalore.click();
		Thread.sleep(500);
		textBox_TP_Bangalore.sendKeys(available);
		Thread.sleep(500);
		checkbox_TP_Bangalore.click();
		test.log(Status.INFO, "checkBox for available clicked ");
		Thread.sleep(1000);

		colorwayCode_textbox_TP_Bangalore.sendKeys(colorwaycode);
		test.log(Status.INFO, "Productname Entered is " + colorwaycode);
		Thread.sleep(1000);

		productCode_textbox_TP_Bangalore.sendKeys(productcode);
		test.log(Status.INFO, "Productname Entered is " + productcode);
		Thread.sleep(1000);

		techPack_Grouping_DD_selection_TP_Bangalore.click();
		Thread.sleep(500);
		textBox_TP_Bangalore.sendKeys(Grouping);
		Thread.sleep(500);
		checkbox_TP_Bangalore.click();
		test.log(Status.INFO, "checkBox for available clicked ");
		Thread.sleep(1000);

		ApplyChanges.click();
		Thread.sleep(2000);

	}


}
