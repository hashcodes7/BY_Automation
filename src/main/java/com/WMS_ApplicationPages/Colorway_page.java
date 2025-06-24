package com.WMS_ApplicationPages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ReadDataSheet;

public class Colorway_page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public Colorway_page(WebDriver driver) {
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

	@FindBy(xpath = "(//div[@col-id='product.productName|~*~|1.Adoption'])[2]//a")
	private WebElement firstproduct;

	@FindBy(xpath = "(//name-cell-renderer[@class='ng-star-inserted'])[2]/a")
	private WebElement firstcolorway;

	@FindBy(xpath = "//div[@id='lscoBrand']//div")
	private WebElement Brand;

	@FindBy(xpath = "//div[@id='lscoBrand']/div[2]")
	private WebElement BrandValue;

	@FindBy(xpath = "//div[@id='lscoProductCategory']/div[1]")
	private WebElement ProductCategory;

	@FindBy(xpath = "//div[@id='lscoProductCategory']/div[2]")
	private WebElement ProductCategoryValue;

	@FindBy(xpath = "//div[@id='lscoConsumerGrp1']/div[1]")
	private WebElement Consumergrp1;

	@FindBy(xpath = "//div[@id='lscoConsumerGrp1']/div[2]")
	private WebElement Consumergrp1Value;

	@FindBy(xpath = "//div[@id='lscoProdSegmentEUR']/div[2]/a")
	private WebElement ProductsegmentationLSE;

	@FindBy(xpath = "//div[@id='lscoProdSegmentUS']/div[2]/a")
	private WebElement ProductsegmentationLSUS;

	@FindBy(xpath = "//button[@title='Options']")
	private WebElement settings;

	@FindBy(xpath = "//span[@id='pr_id_4_label']")
	private WebElement level_DD;

	@FindBy(xpath = "//button[@title='Apply Changes']")
	private WebElement ApplyChanges;

	@FindBy(xpath = "//li[@aria-label='Product']")
	private WebElement product_value;

	@FindBy(xpath = "//li[@aria-label='Colorway']")
	private WebElement colorway_value;

	@FindBy(xpath = "//select[@id='contextSKUId']")
	private WebElement select_colorway;

	@FindBy(xpath = "//div[@id='lscoConsumerProdHier']/div[2]")
	private WebElement Consumer_PH;

	@FindBy(xpath = "//div[@id='lscoBrandHierarchy']/div[2]")
	private WebElement BrandHierarchy_product;

	@FindBy(xpath = "//div[@id='lscoBrandHierarchyColorway']/div[2]")
	private WebElement BrandHierarchy_colorway;

	@FindBy(xpath = "//div[@id='lscoConcept']/div[2]")
	private WebElement Product_Concept;

	@FindBy(xpath = "//div[@id='lscoConceptColorway']/div[2]")
	private WebElement Colorway_Concept;

	@FindBy(xpath = "//div[@id='lscoBusinessUnit']/div[2]")
	private WebElement Product_BusinessUnit;

	@FindBy(xpath = "//div[@id='lscoBusinessUnitColorway']/div[2]")
	private WebElement Colorway_BusinessUnit;

//	--------------------------------create colorway-----------------------------------
	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement Action_dropdown;

	@FindBy(xpath = "//a[@id='updateSku']")
	private WebElement edit_colorway;

	@FindBy(xpath = "//a[@id='createAction']")
	private WebElement Create_Action;

	@FindBy(xpath = "//a[@id='createSku']")
	private WebElement Create_Colorway;

	@FindBy(xpath = "//a[contains(text(),'Colorway (Look/Color)')]")
	private WebElement LookColorLink;

	@FindBy(xpath = "//label[normalize-space()='Type']/following::div[1]")
	private WebElement ColorLookDropdown;

	@FindBy(xpath = "//input[@class='p-tree-filter p-inputtext p-component']")
	private WebElement InputColor;

	@FindBy(xpath = "//span[contains(text(),'Heathers')]")
	private WebElement SelectHeathers;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement SearchButton;

	@FindBy(xpath = "//div[@id='DateEditor']//input")
	private WebElement CreatedFrom_date;

	@FindBy(xpath = "(//a[@class='pointer-link ng-star-inserted'])[1]")
	private WebElement choosenFirstColor;

	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement ColorFrame;

	@FindBy(xpath = "//span[@id='select2-ptc_ref_6-container']/parent::span")
	private WebElement productseg_DD;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement productseg_value;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement Select;

	@FindBy(xpath = "//span[@id='select2-ptc_ref_5-container']")
	private WebElement productsegLSE_selectedvalue;

	@FindBy(xpath = "//span[@id='select2-ptc_ref_6-container']")
	private WebElement productsegLSUS_selectedvalue;

	@FindBy(xpath = "//span[@id='select2-ptc_ref_5-container']/parent::span")
	private WebElement productsegLSE_DD;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement productsegLSE_value;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement ColorwayName;

	@FindBy(xpath = "//ul[@class='select2-results__options']")
	private WebElement productsegLSE_select;

	@FindBy(xpath = "//span[@id='select2-ptc_str_25select-container']")
	private WebElement consumerGroup_Ext1_DD;

	@FindBy(xpath = "//span[@id='select2-ptc_str_26select-container']")
	private WebElement consumerGroup_Ext2_DD;

	@FindBy(xpath = "//a[text()='Fabric Mill:']")
	private WebElement FabricMill_hyperlink;

	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement Save_Button;

	@FindBy(xpath = "(//a[@id='createAnotherProduct'])[2]")
	private WebElement View_product;

	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement iframeColorLibraryframe;

	@FindBy(xpath = "//div[contains(text(),'Hub Offered To')]/following-sibling::div//span[@role='combobox']")
	private WebElement HubOfferedTo;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement HubOfferedTo_Textbox;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	private WebElement HubOfferedTo_value;

	@FindBy(xpath = "//div[@id='color']//div[2]/a")
	private WebElement colorlink;

	@FindBy(xpath = "//div[@id='productNavLink']")
	private WebElement productLink_left_panel;

	@FindBy(xpath = "//span[@id='thumbnailSwatch']//descendant::td[2]")
	private WebElement Thumbnail_color;

	@FindBy(xpath = "//table[@id='productSKUCard']//descendant::td[]/div")
	private WebElement color_thumbnail;

	@FindBy(xpath = "//div[@id='rfaGridImage']/img")
	private WebElement Heather_thumbnail;

	@FindBy(xpath = "(//div[@col-id='color.thumbnail|~*~|PrintandPattern'])[2]//span//div")
	private WebElement printsandpatterns_thumbnail;

	@FindBy(xpath = "//div[@id='lscoPDCValue']//div[2]")
	private WebElement ProductCenterValue;

	@FindBy(xpath = "//div[@id='lscoProdSegmentEUR']/div[2]/a")
	private WebElement ProductLSE_value;

	@FindBy(xpath = "//div[@id='lscoProdSegmentUS']//div/a")
	private WebElement ProductLSUS_value;

	@FindBy(xpath = "//div[@id='lscoProfitCtrEUR']/div[2]/a")
	private WebElement PC_EUROPE_value;

	@FindBy(xpath = "//div[@id='lscoProfitCtrUS']//div/a")
	private WebElement ProfitCenter_US_value;

	@FindBy(xpath = "//div[@id='lscoOrgnlDevSeason']/div[2]")
	private WebElement SeasonFirstIntroduced_value;

	@FindBy(xpath = "//div[@id='lscoPC5SeasonFirstIntroduced']/div[2]")
	private WebElement SeasonFirstIntroducedPC5_value;

	@FindBy(xpath = "//div[@id='lscoSeasonalLook']//div/a")
	private WebElement SeasonalLook_Link;

	@FindBy(xpath = "//div[@class='table-wrapper']//tr[2]/td[2]")
	private WebElement primary_indicator;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement colorway_DD;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement Colorway_Textbox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement select_colorwayoption;

	@FindBy(xpath = "//div[@id='lscoFabricMill']/div/a")
	private WebElement FabricMill_value;

	@FindBy(xpath = "//div[@id='lscoPrimaryFinish']/div[2]")
	private WebElement BlankFinish_value;

	@FindBy(xpath = "//div[@id='lscoLookPrimaryFabric']/div/a")
	private WebElement PrimaryFabric_value;

	@FindBy(xpath = "//div[@id='lscoLookPrimaryFabric']/div[2]")
	private WebElement BlankPrimaryFabric_value;

	@FindBy(xpath = "//div[@id='lscoPrimaryFinish']/div/a")
	private WebElement PrimaryFinish_value;

	@FindBy(xpath = "//div[@id='rfaGridImage']/img")
	private WebElement ExpectedThumbnail;

	@FindBy(xpath = "//a[@id='productthumbnailViewer']/img")
	private WebElement ActualThumbnail;

	@FindBy(xpath = "//div[@aria-label='LSCO']/button")
	private WebElement LSCOmenu;

	@FindBy(xpath = "//span[@id='select2-ptc_str_9-container']")
	private WebElement CustomClassification_DD;

	@FindBy(xpath = "//span[@id='select2-ptc_str_24select-container']")
	private WebElement ConsumerGroup_DD;

	@FindBy(xpath = "//span[@id='select2-ptc_str_25select-container']")
	private WebElement ConsumerGroupExt1_DD;

	@FindBy(xpath = "//span[@id='select2-ptc_str_26select-container']")
	private WebElement ConsumerGroupExt2_DD;

	@FindBy(xpath = "//div[contains(text(),'Product Marketing Name')]/following-sibling::div/input")
	private WebElement ProductMarketingName;

	@FindBy(xpath = "//span[@id='select2-ptc_str_38-container']")
	private WebElement MaterialType_DD;

	@FindBy(xpath = "//div[contains(text(),'Seasonal Direction')]//following::div[1]//input")
	private WebElement seasonalDirectionField;

	@FindBy(xpath = "//div[contains(text(),'GTM Track')]//following::div[1]")
	private WebElement gtmTrackField;

	@FindBy(xpath = "//div[contains(text(),'First Directive Month')]//following::div[1]")
	private WebElement firstDirectiveMonthField;

	@FindBy(xpath = "//div[contains(text(),'Last Season Offered')]//following::div[1]")
	private WebElement lastSeasonOfferedField;

	@FindBy(xpath = "//div[contains(text(),'Global On Floor Intent')]//following::div[1]")
	private WebElement globalOnFloorIntentField;

	@FindBy(xpath = "//div[contains(text(),'First Month on Floor')]//following::div[1]")
	private WebElement firstMonthOnFloorField;

	@FindBy(xpath = "//div[contains(text(),'Win At Marketplace So Hem')]//following::div[1]")
	private WebElement winAtMarketplaceSoHemField;

	@FindBy(xpath = "//div[contains(text(),'Win At Marketplace No Hem')]//following::div[1]")
	private WebElement winAtMarketplaceNoHemField;

	@FindBy(xpath = "//div[contains(text(),'Win At Marketplace Equatorial')]//following::div[1]")
	private WebElement winAtMarketplaceEquatorialField;

	@FindBy(xpath = "//div[contains(text(),'BLP Forecast')]//following::div[1]//input")
	private WebElement blpForecastField;

	@FindBy(xpath = "//div[contains(text(),'Equity MOQ Request')]//following::div[1]//input")
	private WebElement equityMOQRequestField;

	@FindBy(xpath = "//div[contains(text(),'Early Delivery')]//following::div[1]")
	private WebElement earlyDeliveryField;

	@FindBy(xpath = "//div[contains(text(),'LSUS Stocking CSC')]//following::div[1]")
	private WebElement lsusStockingCSCField;

	@FindBy(xpath = "//div[contains(text(),'Current Planned Lifecycle')]//following::div[1]")
	private WebElement currentPlannedLifecycleField;

	@FindBy(xpath = "//div[contains(text(),'Hero Outfit')]//following::div[1]")
	private WebElement heroOutfitField;

	@FindBy(xpath = "//div[contains(text(),'Product Price Positioning')]//following::div[1]")
	private WebElement productPricePositioningField;

	@FindBy(xpath = "//div[contains(text(),'Name')]/following::input[1]")
	private WebElement MaterailNameInput;

	@FindBy(xpath = "//a[contains(text(),'Primary Fabric')]")
	private WebElement primaryFabricLink;

	@FindBy(xpath = "//a[contains(text(),'Primary Finish Mill')]")
	private WebElement primaryFinishMillLink;

	@FindBy(xpath = "//a[contains(text(),'Primary Finish:')]")
	private WebElement primaryFinishLink;

	@FindBy(xpath = "//a[contains(text(),'Seasonal Look')]")
	private WebElement seasonalLookLink;

	@FindBy(xpath = "//a[contains(text(),'Fabric Mill')]")
	private WebElement fabricMillLink;

	@FindBy(xpath = "//iframe[@id='materiallibraryframe']")
	private WebElement iframeMateriallibrary_frame;

	@FindBy(xpath = "//a[contains(text(),'Size Grid Code')]")
	private WebElement sizeGridCodeLink;

	@FindBy(xpath = "(//a[contains(text(),'(choose)')])[1]")
	private WebElement optnSelect;

	@FindBy(xpath = "//td[contains(text(),'Name')]/following-sibling::td[1]/child::input[1]")
	private WebElement nameInput;

	@FindBy(xpath = "(//a[contains(text(),'Search')])[2]")
	private WebElement searchBtn;

	@FindBy(xpath = "//div[contains(text(),'Size Grid Code')]/following-sibling::div[1]/a")
	private WebElement sizeGridElement;

	@FindBy(xpath = "//span[@id='select2-splId-container']")
	private WebElement Season_DD;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement CustomClassification_textbox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement CustomClassification_select;

	@FindBy(xpath = "//div[@id='lscoProductCode']/div[2]")
	private WebElement product_code;

	@FindBy(xpath = "//span[@id='select2-ptc_str_19-container']")
	private WebElement ProductType_DD;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_21-container']")
	private WebElement ProductLifecycleGroup_DD;

	@FindBy(xpath = "//span[@id='select2-ptc_str_20-container']")
	private WebElement RigidIndicator_DD;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_68-container']")
	private WebElement LastSeasonOffered_DD;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_22-container']")
	private WebElement ProductPricePositioning_DD;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement ProductType_textbox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement ProductType_select;

	@FindBy(xpath = "//div[@id='lscoColorwayCode']//div[2]")
	private WebElement Colorway_code;

	@FindBy(xpath = "//div[@id='color']//div/a")
	private WebElement Colorway_name;

	@FindBy(xpath = "//span[@id='pr_id_2_label']")
	private WebElement linesheet_View;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c59-2']")
	private WebElement linesheet_View_textbox;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement view_selection;

	@FindBy(xpath = "//input[@id='imageFile']")
	private WebElement Thumbnail_choosefile;

//-----------------------------------------------------------------------------------	
	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement createColorwayDropdown;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement optionsContainerLocator;

	@FindBy(xpath = "//div[@id='lscoBrand']/div[@class='display-only-label']")
	//// div[@id='lscoBrand']/div[2]
	private WebElement productBrand;

	@FindBy(xpath = "//div[@id='lscoProductCategory']/div[@class='display-only-label']")
	// div[@id='lscoProductCategory']/div[2]
	private WebElement productCategory;

	@FindBy(xpath = "//div[@id='lscoConsumerGrp1']/div[@class='display-only-label']")
	// div[@id='lscoConsumerGrp1']/div[2]
	private WebElement consumerGroup;

	@FindBy(xpath = "//div[@id='lscoConsumerProdHier']//div[@class='display-only-label']")
	// div[@id='lscoConsumerProdHier']//div[2]
	private WebElement ConsumerPH;

	@FindBy(xpath = "//div[@id='lscoProdSegmentEUR']//div[@class='display-only-label']//a[1]")
	private WebElement lseProductSegmentationLink;

	@FindBy(xpath = "//div[@id='lscoProdSegmentUS']//div[@class='display-only-label']//a[1]")
	private WebElement lsusProductSegmentationLink;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement colourwayDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Product Type']/following-sibling::div")
	private WebElement productTypeDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Rigid Indicator']/following-sibling::div")
	private WebElement rigidBodyDropDown;

	@FindBy(xpath = "//div[normalize-space()='* Product Segmentation [LSE]']/following-sibling::div")
	private WebElement productSegmentationLSEDropDown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement ProductSeg_LSE_TextBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement ProductSeg_LSE_Selection;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement ProductSeg_LSUS_TextBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement ProductSeg_LSUS_Selection;

	@FindBy(xpath = "//div[normalize-space()='* Product Segmentation [LSUS]']/following-sibling::div")
	private WebElement productSegmentationLSUSDropDown;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[contains(text(), 'Hub Offered To')]/following-sibling::div")
	private WebElement hubOfferedToDropDown;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement HubOfferdTo_TextBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement HubOfferdTo_Selection;

	@FindBy(xpath = "//span[contains(text(), 'View Product')]")
	private WebElement viewProductButton;

	@FindBy(xpath = "//div[@class='error-message']")
	private WebElement errorMessage;

	@FindBy(xpath = "//body/form[@id='MAINFORM']/div[@id='allSpace']/div[@class='flex-content']/div[@id='contentDiv']/div[@class='themedPage']/div[1]")
	private WebElement uniqueElementLocator;

	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement threeDots;

	@FindBy(xpath = "//span[normalize-space()='Create...']")
	private WebElement createDropdown;

	@FindBy(xpath = "//span[normalize-space()='Create Colorway']")
	private WebElement createColorwayOption;

	@FindBy(xpath = "//div[contains(text(),'Name')]/following-sibling::div[1]//input[1]")
	private WebElement BFF_FG_nameInput;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	public void CreateColorway() throws Exception {

		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));

//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
		String mainWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!mainWindow.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
//		Set<String> handler = driver.getWindowHandles(); 
//		Iterator<String> it = handler.iterator();
//		String parentwindow = it.next();
//		String childwindow = it.next();
//		driver.switchTo().window(childwindow);
//		driver.manage().window().fullscreen();

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			// System.out.println("string menu" +":");
			driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Create...']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Create Colorway']")).click();
//		System.out.println("string menu" +":");
//		System.out.println("string menu" +":");
//		System.out.println("string menu" +":");
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@class='dropdown menu-icon']"))).perform();
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Create...']"))).perform();
//        driver.findElement(By.xpath("//span[normalize-space()='Create Colorway']")).click();

//        new Actions(driver).moveToElement(threeDots).perform();
//        new Actions(driver).moveToElement(createDropdown).perform();
//        createColorwayOption.click();

		} catch (Exception e) {
//			System.out.println("string menu" +":");
		}
	}

	public void ClickColorwayLookColor() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LookColorLink));
		LookColorLink.click();

	}

	public void selectCreateColorwayFromMenu() throws InterruptedException {
		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement dropdownSymbol = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(createColorwayDropdown));
		dropdownSymbol.click();

		// dropdown options container
		WebElement optionsContainer = driver.findElement(By.xpath("//ul[@id='select2-contextSKUId-results']"));

		// Get all the options within the container
		List<WebElement> options = optionsContainer.findElements(By.tagName("li")); // Assuming each option is an 'li'
																					// element

		// Check if there are options available
		if (options.size() > 1) {
			options.get(1).click();
		}
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

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement textBox_Field;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement filteredOptn;

	public void selectProductType(String productTypeValue) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement productTypeElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(productTypeDropDown));
		// Scroll the element into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productTypeElement);
		productTypeElement.click();
		Thread.sleep(2000);
		textBox_Field.sendKeys(productTypeValue);
		Thread.sleep(3000);
		filteredOptn.click();
	}

	public void selectRigidIndicator(String rigidIndicatorValue) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(rigidBodyDropDown)).click();
		Thread.sleep(2000);
		textBox_Field.sendKeys(rigidIndicatorValue);
		Thread.sleep(3000);
		filteredOptn.click();

	}

	public void selectProductSegmentationLSE_DropDown(String productSegmentationLSE_Value) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(productSegmentationLSEDropDown));
		productSegmentationLSEDropDown.click();
		Thread.sleep(3000);
		ProductSeg_LSE_TextBox.sendKeys(productSegmentationLSE_Value);
		Thread.sleep(3000);
		ProductSeg_LSE_Selection.click();

	}

	public void selectProductSegmentationLSUS_DropDown(String productSegmentationLSUS_Value)
			throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(4000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(productSegmentationLSUSDropDown));
		Thread.sleep(4000);

		productSegmentationLSUSDropDown.click();
		Thread.sleep(4000);

		ProductSeg_LSUS_TextBox.sendKeys(productSegmentationLSUS_Value);
		Thread.sleep(4000);

		ProductSeg_LSUS_Selection.click();

	}

	public void clickOnSave() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveButton));

		saveButton.click();

	}

	public void selectHubOfferdToValue(String hubOfferdToValue) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(hubOfferedToDropDown));
		hubOfferedToDropDown.click();
		HubOfferdTo_TextBox.sendKeys(hubOfferdToValue);
		HubOfferdTo_Selection.click();

	}

	public void clickOnViewProduct() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(viewProductButton));

		viewProductButton.click();

	}

	public boolean isErrorMessageDisplayed() throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.isDisplayed();

	}

	public boolean isPC5DetailsPageDisplayed() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Details']")));

		return driver.findElement(By.xpath("//span[normalize-space()='Product Details']")).isDisplayed();
	}

	public void clickOnLSEProductSegmentationLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lseProductSegmentationLink));

		lseProductSegmentationLink.click();
	}

	public void clickOnLSUSProductSegmentationLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lsusProductSegmentationLink));

		lsusProductSegmentationLink.click();
	}

	// Getters for the product details
	public String getProductBrand() throws InterruptedException {

//		 JavascriptExecutor js = (JavascriptExecutor) driver;
//		    js.executeScript("document.body.style.zoom = '80%'");

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productBrand));
			return productBrand.getText();
		} catch (StaleElementReferenceException e) {
			// Handle the stale element reference exception
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			productBrand = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productBrand));
			return productBrand.getText();
		}
	}

	public String getProductCategory() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(productCategory));
		return productCategory.getText();
	}

	public String getConsumerGroup() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(consumerGroup));
		return consumerGroup.getText();
	}

	public String getConsumerPH() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ConsumerPH));
		return ConsumerPH.getText();
	}

//-----------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Product Name']")
	private WebElement ProductNameHeader;

	@FindBy(xpath = "//div[normalize-space()='Profit Center [APD]']/following-sibling::div")
	private WebElement profitCenter_APD;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement filterInput;

	@FindBy(xpath = "//div[@name='center']/descendant::div[4]/child::name-cell-renderer")
	private WebElement FilteredProductName;

	@FindBy(xpath = "//div[normalize-space()='Colorway Code']/following::div[1]")
	private WebElement pc9CodeElement;
	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement colourwayNameElement;
	@FindBy(xpath = "//a[normalize-space()='1890 XX501® JEANS']")
	private WebElement productNameElement;
	@FindBy(xpath = "//div[@id='lscoProdMarketingName']/child::div[2]")
	private WebElement productMarketingNameElement;
	@FindBy(xpath = "//div[normalize-space()='Colorway (Look/Color)']/following::div[1]/a")
	private WebElement linkToColorDetails;

	@FindBy(xpath = "//td[@id='lscoArtwork']")
	private WebElement lscoArtwork;

	@FindBy(xpath = "//td[@id='lscoColorName']")
	private WebElement lscoArtworkName;
	@FindBy(xpath = "//td[@id='lscoColorCombo']")
	private WebElement colorComboElement;
	@FindBy(xpath = "//td[@id='lscoPrintType']")
	private WebElement printTypeElement;

	@FindBy(xpath = "//div[@id='paletteTab']")
	private WebElement paletteTabButton;
	@FindBy(xpath = "//div[@class='tableDebuggerCls']/following::a/following::a[1]")
	private WebElement firstColorSelect;

	@FindBy(xpath = "//div[@id='siteNavLink']")
	private WebElement siteNavigationLink;

	@FindBy(xpath = "//label[normalize-space()='Filter']/following::p-dropdown")
	private WebElement filterDropDown;

	@FindBy(xpath = "//div[contains(text(),'Colorway Code')]/following-sibling::div")
	private WebElement colorwayCodeInput;

	@FindBy(xpath = "//div[@class='error-message']")
	private WebElement Reuse_errorMessage;

	@FindBy(xpath = "//div[@id='lscoSeasonalLook']/div[2]/a")
	private WebElement seasonalLook_value;

	@FindBy(xpath = "//a[text()='Edit']")
	private WebElement Editlook;

	@FindBy(xpath = "//td[@id='r1_lsocPrimaryIndicator']")
	private WebElement PrimaryIndicator;

	@FindBy(xpath = "//input[@id='ptc_bln_1box']")
	private WebElement PrimaryIndicator_checkbox;

	@FindBy(xpath = "//a[@id='saveCheckInButton']")
	private WebElement SaveandCheckIn;

	@FindBy(xpath = "//div[@id='collapseExpandButton']")
	private WebElement expand_product;

	@FindBy(xpath = "//div[@class='table-wrapper']//tr[2]/td[2]")
	private WebElement Primary_Indicator;

	@FindBy(xpath = "//div[@id='lscoConsumerGrp1']/div[2]")
	private WebElement ConsumerGroup_1;

	@FindBy(xpath = "//div[@id='lscoConsumerGrp2']/div[2]")
	private WebElement ConsumerGroup_2;

	@FindBy(xpath = "//div[@id='lscoConsumerGroupExt1']/div[2]")
	private WebElement ConsumerGroup_Ext1;

	@FindBy(xpath = "//div[@id='lscoConsumerGroupExt2']/div[2]")
	private WebElement ConsumerGroup_Ext2;

	@FindBy(xpath = "//div[@id='lscoConsumerProdHier']/div[2]")
	private WebElement ConsumerprodHierarchy;

	@FindBy(xpath = "//div[@id='lscoDestroySampleInd']/div[2]")
	private WebElement DestroySampleIndicator;

	@FindBy(xpath = "//img[@id='thumbnail']")
	private WebElement Thumbnail_img;

//-----------------------------Method ----------------------------------	

	public void SeasonDropdown(String season, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		selectValueFromDropdown(SeasonsDropdown, season);
		test.log(Status.INFO, "Season selected: " + season);
	}

	public void SelectProduct(String product, ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			settings.click();
			level_DD.click();
			product_value.click();
			ApplyChanges.click();
			FilterTextbox.sendKeys(product);
			Thread.sleep(5000);
			firstproduct.click();
			test.log(Status.INFO, "Product selected: " + product);
			WaitforPage(5000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void SelectColorway(String colorway, ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			settings.click();
			level_DD.click();
			colorway_value.click();
			ApplyChanges.click();
			FilterTextbox.clear();
			FilterTextbox.sendKeys(colorway);
			Thread.sleep(5000);
//			"1955 501 JEANS"
			firstcolorway.click();
			test.log(Status.INFO, "Colorway selected: " + colorway);
			WaitforPage(5000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void ValidatingLSEdetails(String Brand, String colorway, String Product_Category, String Consumer_group_1,
			String ProductSegmentationvalue, ExtentTest test) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			colorway_DD.click();
			Colorway_Textbox.sendKeys(colorway);
			select_colorwayoption.click();

			if (BrandValue.getText().equalsIgnoreCase(Brand)
					&& ProductCategoryValue.getText().equalsIgnoreCase(Product_Category)
					&& Consumergrp1Value.getText().equalsIgnoreCase(Consumer_group_1)) {
				Assert.assertTrue(ProductsegmentationLSE.getText().equals(ProductSegmentationvalue));
			}
			test.log(Status.INFO,
					"product segmentation[LSE] value from UI is: " + ProductsegmentationLSE.getText() + "for Brand:"
							+ BrandValue.getText() + ",ProductCategoryValue: " + ProductCategoryValue.getText()
							+ "and Consumergrp1Value: " + Consumergrp1Value.getText());
			test.log(Status.INFO,
					"product segmentation[LSE] value from Business Object is: " + ProductSegmentationvalue
							+ "for Brand:" + Brand + ",ProductCategoryValue: " + Product_Category
							+ "and Consumergrp1Value: " + Consumer_group_1);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void ValidatingLSUSdetails(String Brand, String colorway, String Product_Category, String consumer_PH,
			String ProductSegLSUSvalue, ExtentTest test) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			colorway_DD.click();
			Colorway_Textbox.sendKeys(colorway);
			select_colorwayoption.click();

			if (BrandValue.getText().equalsIgnoreCase(Brand)
					&& ProductCategoryValue.getText().equalsIgnoreCase(Product_Category)
					&& Consumer_PH.getText().equalsIgnoreCase(consumer_PH)) {
				Assert.assertTrue(ProductsegmentationLSUS.getText().equals(ProductSegLSUSvalue));

			}
			test.log(Status.INFO,
					"product segmentation[LSUS] value from UI is: " + ProductsegmentationLSUS.getText() + " for Brand:"
							+ BrandValue.getText() + ",ProductCategoryValue: " + ProductCategoryValue.getText()
							+ "and Consumer_PH: " + Consumer_PH.getText());
			test.log(Status.INFO,
					"product segmentation[LSUS] value from Business Object is: " + ProductSegLSUSvalue + " for Brand:"
							+ Brand + ",ProductCategoryValue: " + Product_Category + "and consumer_PH: " + consumer_PH);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void Create_colorwayLink() throws Exception {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Action_dropdown.click();
			Create_Action.click();
			Create_Colorway.click();
			WaitforPage(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String selectcolour(String colormenu, String colorsubmenu, String filtercolor, ExtentTest test)
			throws InterruptedException {
		String expectedthumbnail = null;
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(LookColorLink));
			LookColorLink.click();

			String parent = driver.getWindowHandle();
			System.out.println("parent window id is " + parent);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeColorLibraryframe);

			WebElement colorLookDropdown = new WebDriverWait(driver, 60)
					.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
			colorLookDropdown.click();

			test.log(Status.INFO, "Color menu selected: " + colormenu);
			LSCOmenu.click();
			List<WebElement> list = driver
					.findElements(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div"));
			for (WebElement ele : list) {
				if (ele.getAttribute("aria-label").equals(colormenu)) {
					if (colormenu.equals("Looks") || colormenu.equals("Sundry Color")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']"))
								.click();
					} else if (colormenu.equals("Colors") || colormenu.equals("Seasonal Look")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']/button"))
								.click();
						List<WebElement> col = driver.findElements(By
								.xpath("//div[@aria-label='" + colormenu + "']/following-sibling::ul/p-treenode//div"));
						for (WebElement submenu : col) {
							Thread.sleep(2000);
							if (submenu.getAttribute("aria-label").equals(colorsubmenu)) {
								test.log(Status.INFO, "Color submenu selected: " + colorsubmenu);
								submenu.click();
								Thread.sleep(2000);

							}
						}
					}
				}
			}
			SearchButton.click();
			if(colormenu.equals("Looks")) {
				Thread.sleep(15000);
			}
			Thread.sleep(30000);
			FilterTextbox.sendKeys(filtercolor);
			Thread.sleep(4000);
			test.log(Status.INFO, "filter Color value: " + filtercolor);

			if (colorsubmenu.equals("Heathers")) {
				expectedthumbnail = Heather_thumbnail.getAttribute("id");
				System.out.println(expectedthumbnail);
			} else if (colorsubmenu.equals("Prints and Patterns")) {
				expectedthumbnail = printsandpatterns_thumbnail.getAttribute("id");
			}

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();

			driver.switchTo().window(tabs.get(1));
		} catch (Exception e) {
			System.out.println(e);
		}
		return expectedthumbnail;
	}
	
	public void select_colour(String colormenu, String colorsubmenu, String filtercolor, ExtentTest test)
			throws InterruptedException {
		
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(LookColorLink));
			LookColorLink.click();

			String parent = driver.getWindowHandle();
			System.out.println("parent window id is " + parent);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeColorLibraryframe);

			WebElement colorLookDropdown = new WebDriverWait(driver, 60)
					.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
			colorLookDropdown.click();

			test.log(Status.INFO, "Color menu selected: " + colormenu);
			LSCOmenu.click();
			List<WebElement> list = driver
					.findElements(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div"));
			for (WebElement ele : list) {
				if (ele.getAttribute("aria-label").equals(colormenu)) {
					if (colormenu.equals("Looks") || colormenu.equals("Sundry Color")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']"))
								.click();
					} else if (colormenu.equals("Colors") || colormenu.equals("Seasonal Look")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']/button"))
								.click();
						List<WebElement> col = driver.findElements(By
								.xpath("//div[@aria-label='" + colormenu + "']/following-sibling::ul/p-treenode//div"));
						for (WebElement submenu : col) {
							Thread.sleep(2000);
							if (submenu.getAttribute("aria-label").equals(colorsubmenu)) {
								test.log(Status.INFO, "Color submenu selected: " + colorsubmenu);
								submenu.click();
								Thread.sleep(2000);

							}
						}
					}
				}
			}
			SearchButton.click();
			if(colormenu.equals("Looks")) {
				Thread.sleep(15000);
			}
			Thread.sleep(30000);
			FilterTextbox.sendKeys(filtercolor);
			Thread.sleep(4000);
			test.log(Status.INFO, "filter Color value: " + filtercolor);

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();
			driver.switchTo().window(tabs.get(1));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public void selectcolour_SeasonalLook(String colormenu, String colorsubmenu, String filtercolor,ExtentTest test) throws InterruptedException {
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(LookColorLink));
			LookColorLink.click();

			String parent = driver.getWindowHandle();
			System.out.println("parent window id is " + parent);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeColorLibraryframe);

			WebElement colorLookDropdown = new WebDriverWait(driver, 60)
					.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
			colorLookDropdown.click();

			test.log(Status.INFO, "Color menu selected: " + colormenu);
			LSCOmenu.click();
			List<WebElement> list = driver
					.findElements(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div"));
			for (WebElement ele : list) {
				if (ele.getAttribute("aria-label").equals(colormenu)) {
					if (colormenu.equals("Looks") || colormenu.equals("Sundry Color")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']"))
								.click();
					} else if (colormenu.equals("Colors") || colormenu.equals("Seasonal Look")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']/button"))
								.click();
						List<WebElement> col = driver.findElements(By
								.xpath("//div[@aria-label='" + colormenu + "']/following-sibling::ul/p-treenode//div"));
						for (WebElement submenu : col) {
							Thread.sleep(2000);
							if (submenu.getAttribute("aria-label").equals(colorsubmenu)) {
								test.log(Status.INFO, "Color submenu selected: " + colorsubmenu);
								submenu.click();
								Thread.sleep(2000);

							}
						}
					}
				}
			}

			BFF_FG_nameInput.sendKeys(filtercolor);
			Thread.sleep(2000);
			SearchButton.click();

			if (colorsubmenu.equals("Seasonal Look FG")) {
				Thread.sleep(30000);
			}
			Thread.sleep(12000);
//			FilterTextbox.sendKeys(filtercolor);
//			test.log(Status.INFO, "filter Color value: "+filtercolor);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", choosenFirstColor);

			driver.switchTo().window(tabs.get(1));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FindBy(xpath = "//div[@id='paletteTab']")
	private WebElement PaletteTab;
	// div[@id='paletteTab']

	public String create_Color_palette(String palettecolorname, ExtentTest test) throws InterruptedException {
		String expectedthumbnail = null;
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(LookColorLink));
			LookColorLink.click();

			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));

//			driver.switchTo().defaultContent();
//			driver.switchTo().frame(iframeColorLibraryframe);

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(PaletteTab)).click();
			Thread.sleep(2000);
			List<WebElement> Thumbnaillist = driver
					.findElements(By.xpath("//div[@id='paletteTabDiv']//table[2]//tbody//tbody/tr/td[2]"));
			List<WebElement> list = driver
					.findElements(By.xpath("//div[@id='paletteTabDiv']//table[2]//tbody//tbody/tr/td[3]/a"));
			List<WebElement> listchoose = driver.findElements(
					By.xpath("//div[@id='paletteTabDiv']//table[2]//tbody//tbody//td[1]/a[text()='(choose)']"));
			for (int i = 0; i <= list.size(); i++) {
				System.out.println(list.get(i).getText());
				if (list.get(i).getText().contains(palettecolorname)) {
					System.out.println(list.get(i).getText());
					Thread.sleep(2000);
					expectedthumbnail = Thumbnaillist.get(i + 1).getAttribute("bgcolor");
					System.out.println(expectedthumbnail);
					listchoose.get(i).click();
					System.out.println("color choosen");
					break;
				}
			}

			driver.switchTo().window(tabs.get(1));

		} catch (Exception e) {
			System.out.println(e);
		}
		return expectedthumbnail;
	}

	
	public void Create_ColorwayafterProductcreation() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Action_dropdown.click();
			Create_Action.click();
			Create_Colorway.click();
			WaitforPage(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String selectcolour_afterproductcreation(String colormenu, String colorsubmenu, String filtercolor, ExtentTest test)
			throws InterruptedException {
		String expectedthumbnail = null;
		try {
			new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(LookColorLink));
			LookColorLink.click();

			String parent = driver.getWindowHandle();
			System.out.println("parent window id is " + parent);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeColorLibraryframe);

			WebElement colorLookDropdown = new WebDriverWait(driver, 60)
					.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
			colorLookDropdown.click();

			test.log(Status.INFO, "Color menu selected: " + colormenu);
			LSCOmenu.click();
			List<WebElement> list = driver
					.findElements(By.xpath("(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div"));
			for (WebElement ele : list) {
				if (ele.getAttribute("aria-label").equals(colormenu)) {
					if (colormenu.equals("Looks") || colormenu.equals("Sundry Color")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']"))
								.click();
					} else if (colormenu.equals("Colors") || colormenu.equals("Seasonal Look")) {
						Thread.sleep(2000);
						driver.findElement(By.xpath(
								"(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='"
										+ colormenu + "']/button"))
								.click();
						List<WebElement> col = driver.findElements(By
								.xpath("//div[@aria-label='" + colormenu + "']/following-sibling::ul/p-treenode//div"));
						for (WebElement submenu : col) {
							Thread.sleep(2000);
							if (submenu.getAttribute("aria-label").equals(colorsubmenu)) {
								test.log(Status.INFO, "Color submenu selected: " + colorsubmenu);
								submenu.click();
								Thread.sleep(2000);

							}
						}
					}
				}
			}
			SearchButton.click();
			if(colormenu.equals("Looks")) {
				Thread.sleep(15000);
			}
			Thread.sleep(30000);
			FilterTextbox.sendKeys(filtercolor);
			Thread.sleep(4000);
			test.log(Status.INFO, "filter Color value: " + filtercolor);

			if (colorsubmenu.equals("Heathers")) {
				expectedthumbnail = Heather_thumbnail.getAttribute("id");
				System.out.println(expectedthumbnail);
			} else if (colorsubmenu.equals("Prints and Patterns")) {
				expectedthumbnail = printsandpatterns_thumbnail.getAttribute("id");
			}

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();

			driver.switchTo().window(tabs.get(0));
		} catch (Exception e) {
			System.out.println(e);
		}
		return expectedthumbnail;
	}
	
	public void MandatoryFields_colorwaySeason_SetUpLSE_afterproductcreation(String HubofferedTo,String productlifecyclegroup,String lastseasonoffered,
			String productpricepositioning,String createddate,String fabricmill,String sizeGridCode,String currentPlannedLifecycle,String primaryfabric,ExtentTest test) throws InterruptedException {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
	//------------------------------------------------------------------------------------------------------------------		
	//----------------------------------------Size selection--------------------------------------------------------		
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(sizeGridCodeLink));
			sizeGridCodeLink.click();
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
			nameInput.sendKeys(sizeGridCode);
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", searchBtn);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			test.log(Status.INFO, "Selected Size Grid Code: " + sizeGridCode);
			addSrceenShot("Selected Size Grid Code", test, Capture);
			driver.switchTo().window(tabs.get(0));
					
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primaryFabricLink)).click();
			ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeMateriallibrary_frame);
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
			Thread.sleep(5000);
			clearCriteria.click();
			Thread.sleep(2000);
			resetDefaults.click();
			MaterailNameInput.sendKeys(primaryfabric);
			js1.executeScript("arguments[0].click();", searchButton);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			driver.switchTo().window(tabs1.get(0));
			test.log(Status.INFO, "Selected Primary Fabric: " + primaryfabric);
			addSrceenShot("Selected Primary Fabric", test, Capture);

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			
			HubOfferedTo.click();
			HubOfferedTo_Textbox.sendKeys(HubofferedTo);
			test.log(Status.INFO, "Hub Offered To value selected: "+HubofferedTo);
			HubOfferedTo_value.click();
			
			LastSeasonOffered_DD.click();
			TextBox.sendKeys(lastseasonoffered);
			selectFirst.click();
			test.log(Status.INFO, "Last season offerred value selected: "+lastseasonoffered);
			
			ProductPricePositioning_DD.click();
			TextBox.sendKeys(productpricepositioning);
			selectFirst.click();
			test.log(Status.INFO, "Product Price positioning value selected: "+productpricepositioning);
			
//			-----------------------------------------------------------------------------------------
//			------------------------fabric mill value selection---------------------------------------
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricMillLink)).click();
			ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeMateriallibrary_frame);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
			Thread.sleep(5000);
			clearCriteria.click();
			Thread.sleep(2000);
			resetDefaults.click();
			MaterailNameInput.sendKeys(fabricmill);
			js1.executeScript("arguments[0].click();", searchButton);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			driver.switchTo().window(tabs2.get(0));
			test.log(Status.INFO, "Selected Fabric Mill: " + fabricmill);
			addSrceenShot("Selected Fabric Mill ", test, Capture);
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			currentPlannedLifecycleField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(currentPlannedLifecycle);
			Thread.sleep(3000);
			filtred_option.click();
			Thread.sleep(2000);
	
			View_product.click();
			Assert.assertTrue(driver.getTitle().equals("View Season Product Information"));
		}
	public void thumbnailValidations(ExtentTest test, String thumbnail) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeLeft);
			List<WebElement> list = driver.findElements(By.xpath("//table[@id='productSKUCard']//tr/td/div"));
			for (WebElement ele : list) {

				if (ele.getAttribute("style").contains(thumbnail)) {
					System.out.println("Color Thumbnail: " + thumbnail + " is present in colorway thumbnail");
					test.log(Status.INFO, "Color thumbnail: " + thumbnail + " is present in colorway thumbnail");
				}

			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

//			colorlink.click();
//			String actualthumbnail=ActualThumbnail.getAttribute("src");
//			System.out.println(thumbnail);
//			System.out.println(actualthumbnail);
//			test.log(Status.INFO, "Expected thumbnail value: " +thumbnail + " and Actual Thumbanailvalue: "+actualthumbnail);
//			
//			Assert.assertEquals(thumbnail, actualthumbnail);
//			test.log(Status.INFO, "PC9 color thumbnail is validated");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement field_searchBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement filtred_option;

	@FindBy(xpath = "//div[contains(text(),'Target Volume [Colorway]')]//following::div[1]//input")
	private WebElement targetVolumeField;

	@FindBy(xpath = "//div[contains(text(),'Collection Type')]//following::div[1]")
	private WebElement collectionTypeField;

	@FindBy(xpath = "//div[contains(text(),'Capsule')]//following::div[1]")
	private WebElement capsuleField;

	@FindBy(xpath = "//div[contains(text(),'Material Type')]//following::div[1]")
	private WebElement materialTypeField;

	@FindBy(xpath = "//div[contains(text(),'Performance')]//following::div[1]")
	private WebElement performanceField;

	@FindBy(xpath = "//div[normalize-space()='Consumer Group']/following::div[1]")
	private WebElement consumerGroupField;

	@FindBy(xpath = "//div[normalize-space()='Consumer Group Ext 1']/following::div[1]")
	private WebElement consumerGroupExt1Field;

	@FindBy(xpath = "//div[normalize-space()='Consumer Group Ext 2']/following::div[1]")
	private WebElement consumerGroupExt2Field;

	@FindBy(xpath = "//div[contains(text(),'Destroy Sample Ind')]//following::div[1]")
	private WebElement destroySampleIndField;

	@FindBy(xpath = "//div[contains(text(),'Profit Center [APD]')]//following::div[1]")
	private WebElement profitCenterAPDField;

	@FindBy(xpath = "//div[contains(text(),'Merch Fabric Type')]//following::div[1]")
	private WebElement merchFabricTypeField;

	@FindBy(xpath = "//div[contains(text(),'Brief Code')]//following::div[1]/textarea")
	private WebElement briefCodeField;

	public void MandatoryColorwayDetails_ForLSESetUP(String ProductSeg_LSUS, String ProductSeg_LSE,
			String classification, String producttype, String consumergroup, String consumergroupext1,
			String consumergroupext2, String materialtype, String productmarketingname, String rigidindicator,
			String merchfabrictype, String destroysampleInd, String collectionType, String capsule, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			productseg_DD.click();
			productseg_value.sendKeys(ProductSeg_LSUS);
			Select.click();
			test.log(Status.INFO,
					"Product segementation LSUS value selected: " + productsegLSUS_selectedvalue.getText());
			Thread.sleep(1000);

			productsegLSE_DD.click();
			productsegLSE_value.sendKeys(ProductSeg_LSE);
			Select.click();
			test.log(Status.INFO, " segementation LSE value selected: " + productsegLSE_selectedvalue.getText());
			Thread.sleep(1000);

			ProductType_DD.click();
			ProductType_textbox.sendKeys(producttype);
			Select.click();
			test.log(Status.INFO, "Product type value selected: " + ProductType_DD.getText());
			Thread.sleep(1000);

			CustomClassification_DD.click();
			CustomClassification_textbox.sendKeys(classification);
			Select.click();
			test.log(Status.INFO, "Custom classification value selected: " + CustomClassification_DD.getText());
			Thread.sleep(1000);

			ConsumerGroup_DD.click();
			Thread.sleep(3000);
			TextBox.sendKeys(consumergroup);
			Thread.sleep(2000);
			selectFirst.click();
			test.log(Status.INFO, "Consumer group value selected: " + consumergroup);
			Thread.sleep(1000);

			ConsumerGroupExt1_DD.click();
			Thread.sleep(3000);
			TextBox.sendKeys(consumergroupext1);
			Thread.sleep(3000);
			selectFirst.click();
			test.log(Status.INFO, "Consumer group EXT 1  value selected: " + consumergroupext1);
			Thread.sleep(1000);

			ConsumerGroupExt2_DD.click();
			Thread.sleep(3000);
			TextBox.sendKeys(consumergroupext2);
			Thread.sleep(3000);
			selectFirst.click();
			test.log(Status.INFO, "Consumer group EXT 2 value selected: " + consumergroupext2);
			Thread.sleep(1000);

			MaterialType_DD.click();
			TextBox.sendKeys(materialtype);
			selectFirst.click();
			test.log(Status.INFO, "Material type value selected: " + materialtype);
			Thread.sleep(1000);

			RigidIndicator_DD.click();
			TextBox.sendKeys(rigidindicator);
			selectFirst.click();
			test.log(Status.INFO, "Rigid Indicator value selected: " + RigidIndicator_DD.getText());

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(destroySampleIndField));
			destroySampleIndField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(destroysampleInd);
			Thread.sleep(3000);
			test.log(Status.INFO, "destroysampleInd  value selected: " + destroysampleInd);
			filtred_option.click();
			Thread.sleep(2000);

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(merchFabricTypeField));
			merchFabricTypeField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(merchfabrictype);

			Thread.sleep(3000);
			filtred_option.click();
			test.log(Status.INFO, "merchfabrictype  value selected: " + merchfabrictype);
			Thread.sleep(2000);

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(collectionTypeField));
			collectionTypeField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(collectionType);
			Thread.sleep(3000);
			filtred_option.click();
			test.log(Status.INFO, "collectionType  value selected: " + collectionType);
			Thread.sleep(2000);

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(capsuleField));
			capsuleField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(capsule);
			Thread.sleep(3000);
			filtred_option.click();
			test.log(Status.INFO, "capsule value selected: " + capsule);
			Thread.sleep(2000);

			Thread.sleep(1000);
			Save_Button.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void MandatoryColorwayDetails_ForAPDSetUP(String ProductSeg_LSUS, String ProductSeg_LSE,
			String classification, String producttype, String consumergroup, String consumergroupext1,
			String consumergroupext2, String materialtype, String productmarketingname, String rigidindicator,
			String merchfabrictype, String destroysampleInd, String collectionType, String capsule,String profitCenterAPD, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			productseg_DD.click();
			productseg_value.sendKeys(ProductSeg_LSUS);
			Select.click();
			test.log(Status.INFO,
					"Product segementation LSUS value selected: " + productsegLSUS_selectedvalue.getText());
			Thread.sleep(1000);

			productsegLSE_DD.click();
			productsegLSE_value.sendKeys(ProductSeg_LSE);
			Select.click();
			test.log(Status.INFO, " segementation LSE value selected: " + productsegLSE_selectedvalue.getText());
			Thread.sleep(1000);

			ProductType_DD.click();
			ProductType_textbox.sendKeys(producttype);
			Select.click();
			test.log(Status.INFO, "Product type value selected: " + ProductType_DD.getText());
			Thread.sleep(1000);

			CustomClassification_DD.click();
			CustomClassification_textbox.sendKeys(classification);
			Select.click();
			test.log(Status.INFO, "Custom classification value selected: " + CustomClassification_DD.getText());
			Thread.sleep(1000);

			ConsumerGroup_DD.click();
			Thread.sleep(3000);
			TextBox.sendKeys(consumergroup);
			Thread.sleep(2000);
			selectFirst.click();
			test.log(Status.INFO, "Consumer group value selected: " + consumergroup);
			Thread.sleep(1000);

			ConsumerGroupExt1_DD.click();
			Thread.sleep(3000);
			TextBox.sendKeys(consumergroupext1);
			Thread.sleep(3000);
			selectFirst.click();
			test.log(Status.INFO, "Consumer group EXT 1  value selected: " + consumergroupext1);
			Thread.sleep(1000);

			ConsumerGroupExt2_DD.click();
			Thread.sleep(3000);
			TextBox.sendKeys(consumergroupext2);
			Thread.sleep(3000);
			selectFirst.click();
			test.log(Status.INFO, "Consumer group EXT 2 value selected: " + consumergroupext2);
			Thread.sleep(1000);

			MaterialType_DD.click();
			TextBox.sendKeys(materialtype);
			selectFirst.click();
			test.log(Status.INFO, "Material type value selected: " + materialtype);
			Thread.sleep(1000);

			RigidIndicator_DD.click();
			TextBox.sendKeys(rigidindicator);
			selectFirst.click();
			test.log(Status.INFO, "Rigid Indicator value selected: " + RigidIndicator_DD.getText());

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(destroySampleIndField));
			destroySampleIndField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(destroysampleInd);
			Thread.sleep(3000);
			test.log(Status.INFO, "destroysampleInd  value selected: " + destroysampleInd);
			filtred_option.click();
			Thread.sleep(2000);

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(merchFabricTypeField));
			merchFabricTypeField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(merchfabrictype);

			Thread.sleep(3000);
			filtred_option.click();
			test.log(Status.INFO, "merchfabrictype  value selected: " + merchfabrictype);
			Thread.sleep(2000);

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(collectionTypeField));
			collectionTypeField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(collectionType);
			Thread.sleep(3000);
			filtred_option.click();
			test.log(Status.INFO, "collectionType  value selected: " + collectionType);
			Thread.sleep(2000);

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(capsuleField));
			capsuleField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(capsule);
			Thread.sleep(3000);
			filtred_option.click();
			test.log(Status.INFO, "capsule value selected: " + capsule);
			Thread.sleep(2000);
			
			try {
				new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(profitCenterAPDField));
				profitCenterAPDField.click();
				Thread.sleep(2000);
				field_searchBox.sendKeys(profitCenterAPD);
				Thread.sleep(3000);
				filtred_option.click();
				Thread.sleep(2000);
			} catch (Exception e) {
				
			}

			Thread.sleep(1000);
			Save_Button.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void UpdateColorwayseason_SAP_Attributes(String productlifecyclegroup,String lastseasonoffered,
			String currentPlannedLifecycle,ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		LastSeasonOffered_DD.click();
		TextBox.sendKeys(lastseasonoffered);
		selectFirst.click();
		test.log(Status.INFO, "Last season offerred value selected: "+lastseasonoffered);
		
		ProductLifecycleGroup_DD.click();
		TextBox.sendKeys(productlifecyclegroup);
		selectFirst.click();
		test.log(Status.INFO, "Product lifecycle group value selected: "+productlifecyclegroup);
		
		currentPlannedLifecycleField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(currentPlannedLifecycle);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		Save_Button.click();
		Thread.sleep(2000);
		
	}
	public void UpdatecolorwaySeason_SetUpLSE(String HubofferedTo,String productlifecyclegroup,String lastseasonoffered,
			String productpricepositioning,String createddate,String fabricmill,String sizeGridCode,String currentPlannedLifecycle,ExtentTest test) throws InterruptedException {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
	//------------------------------------------------------------------------------------------------------------------		
	//----------------------------------------Size selection--------------------------------------------------------		
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(sizeGridCodeLink));
			sizeGridCodeLink.click();
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(2));
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
			nameInput.sendKeys(sizeGridCode);
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", searchBtn);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			test.log(Status.INFO, "Selected Size Grid Code: " + sizeGridCode);
			addSrceenShot("Selected Size Grid Code", test, Capture);
			driver.switchTo().window(tabs.get(1));
					
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			HubOfferedTo.click();
			HubOfferedTo_Textbox.sendKeys(HubofferedTo);
			test.log(Status.INFO, "Hub Offered To value selected: "+HubofferedTo);
			HubOfferedTo_value.click();
			
			LastSeasonOffered_DD.click();
			TextBox.sendKeys(lastseasonoffered);
			selectFirst.click();
			test.log(Status.INFO, "Last season offerred value selected: "+lastseasonoffered);
			
			ProductPricePositioning_DD.click();
			TextBox.sendKeys(productpricepositioning);
			selectFirst.click();
			test.log(Status.INFO, "Product Price positioning value selected: "+productpricepositioning);
			
			ProductLifecycleGroup_DD.click();
			TextBox.sendKeys(productlifecyclegroup);
			selectFirst.click();
			test.log(Status.INFO, "Product lifecycle group value selected: "+productlifecyclegroup);
			
//			-----------------------------------------------------------------------------------------
//			------------------------fabric mill value selection---------------------------------------
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricMillLink)).click();
			ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(2));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeMateriallibrary_frame);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
			Thread.sleep(5000);
			clearCriteria.click();
			Thread.sleep(2000);
			resetDefaults.click();
			MaterailNameInput.sendKeys(fabricmill);
			js1.executeScript("arguments[0].click();", searchButton);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			driver.switchTo().window(tabs1.get(1));
			test.log(Status.INFO, "Selected Fabric Mill: " + fabricmill);
			addSrceenShot("Selected Fabric Mill ", test, Capture);
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			currentPlannedLifecycleField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(currentPlannedLifecycle);
			Thread.sleep(3000);
			filtred_option.click();
			Thread.sleep(2000);
	
			Save_Button.click();
			Thread.sleep(2000);
	}
	
	

	public void MandatoryFields_colorwaySeason_SetUpLSE(String HubofferedTo,String productlifecyclegroup,String lastseasonoffered,
			String productpricepositioning,String createddate,String fabricmill,String sizeGridCode,String currentPlannedLifecycle,String primaryfabric,ExtentTest test) throws InterruptedException {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
	//------------------------------------------------------------------------------------------------------------------		
	//----------------------------------------Size selection--------------------------------------------------------		
			
			new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(sizeGridCodeLink));
			sizeGridCodeLink.click();
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(2));
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
			nameInput.sendKeys(sizeGridCode);
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", searchBtn);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			test.log(Status.INFO, "Selected Size Grid Code: " + sizeGridCode);
			addSrceenShot("Selected Size Grid Code", test, Capture);
			driver.switchTo().window(tabs.get(1));
					
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primaryFabricLink)).click();
			ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(2));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeMateriallibrary_frame);
			new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
			Thread.sleep(5000);
			clearCriteria.click();
			Thread.sleep(2000);
			resetDefaults.click();
			MaterailNameInput.sendKeys(primaryfabric);
			js1.executeScript("arguments[0].click();", searchButton);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			driver.switchTo().window(tabs1.get(1));
			test.log(Status.INFO, "Selected Primary Fabric: " + primaryfabric);
			addSrceenShot("Selected Primary Fabric", test, Capture);

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			
			
			HubOfferedTo.click();
			HubOfferedTo_Textbox.sendKeys(HubofferedTo);
			test.log(Status.INFO, "Hub Offered To value selected: "+HubofferedTo);
			HubOfferedTo_value.click();
			
			LastSeasonOffered_DD.click();
			TextBox.sendKeys(lastseasonoffered);
			selectFirst.click();
			test.log(Status.INFO, "Last season offerred value selected: "+lastseasonoffered);
			
			ProductPricePositioning_DD.click();
			TextBox.sendKeys(productpricepositioning);
			selectFirst.click();
			test.log(Status.INFO, "Product Price positioning value selected: "+productpricepositioning);
			
//			-----------------------------------------------------------------------------------------
//			------------------------fabric mill value selection---------------------------------------
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricMillLink)).click();
			ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(2));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeMateriallibrary_frame);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
			Thread.sleep(9000);
			clearCriteria.click();
			Thread.sleep(2000);
			resetDefaults.click();
			MaterailNameInput.sendKeys(fabricmill);
			js1.executeScript("arguments[0].click();", searchButton);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
			js1.executeScript("arguments[0].click();", optnSelect);
			driver.switchTo().window(tabs2.get(1));
			test.log(Status.INFO, "Selected Fabric Mill: " + fabricmill);
			addSrceenShot("Selected Fabric Mill ", test, Capture);
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			currentPlannedLifecycleField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(currentPlannedLifecycle);
			Thread.sleep(3000);
			filtred_option.click();
			Thread.sleep(2000);
	
			View_product.click();
			Assert.assertTrue(driver.getTitle().equals("View Season Product Information"));
		}
		
	

	public void colorwayseasonfield(String HubofferedTo, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			HubOfferedTo.click();
			HubOfferedTo_Textbox.sendKeys(HubofferedTo);
			test.log(Status.INFO, "Hub Offered To value selected: " + HubofferedTo);
			HubOfferedTo_value.click();
			View_product.click();
			Assert.assertTrue(driver.getTitle().equals("View Season Product Information"));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void MandatoryDetails(String ProductSeg_LSUS, String ProductSeg_LSE, String classification,
			String producttype, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			productseg_DD.click();
			productseg_value.sendKeys(ProductSeg_LSUS);
			Select.click();
			test.log(Status.INFO,
					"Product segementation LSUS value selected: " + productsegLSUS_selectedvalue.getText());
			Thread.sleep(1000);

			productsegLSE_DD.click();
			productsegLSE_value.sendKeys(ProductSeg_LSE);
			Select.click();
			test.log(Status.INFO, "" + " segementation LSE value selected: " + productsegLSE_selectedvalue.getText());
			Thread.sleep(1000);

			ProductType_DD.click();
			ProductType_textbox.sendKeys(producttype);
			Select.click();
			test.log(Status.INFO, "Product type value selected: " + ProductType_DD.getText());
			Thread.sleep(1000);

			CustomClassification_DD.click();
			CustomClassification_textbox.sendKeys(classification);
			Select.click();
			test.log(Status.INFO, "Custom classification value selected: " + CustomClassification_DD.getText());
			Thread.sleep(1000);

			Thread.sleep(1000);
			Save_Button.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void add_rigidindicatorvalueinCreatePC9(String rigidindicator, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		RigidIndicator_DD.click();
		TextBox.sendKeys(rigidindicator);
		selectFirst.click();
		test.log(Status.INFO, "Rigid Indicator value selected: " + RigidIndicator_DD.getText());
	}

	public void requiredAttributes(String ProductSeg_LSUS, String ProductSeg_LSE, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		productseg_DD.click();
		productseg_value.sendKeys(ProductSeg_LSUS);
		Select.click();
		test.log(Status.INFO, "Product segementation LSUS value selected: " + productsegLSUS_selectedvalue.getText());
		Thread.sleep(1000);

		productsegLSE_DD.click();
		productsegLSE_value.sendKeys(ProductSeg_LSE);
		productsegLSE_select.click();
		test.log(Status.INFO, "Product segementation LSE value selected: " + productsegLSE_selectedvalue.getText());
		Thread.sleep(1000);

		Save_Button.click();
		Thread.sleep(3000);
	}
	

	public void Validate_StagingId(ExtentTest test) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		if(Colorway_StagingId.isDisplayed() && ColorwaySeason_StagingId.isDisplayed()) {
			System.out.println("Staging Id at colorway level is:"+Colorway_StagingId.getText()  +" and colorway season is:"+ ColorwaySeason_StagingId.getText());
			test.log(Status.INFO,"Staging Id at colorway level is:"+Colorway_StagingId.getText()  +" and colorway season is:"+ ColorwaySeason_StagingId.getText());
			addSrceenShot("Staging Id at colorway level is:"+Colorway_StagingId.getText()  +" and colorway season is:"+ ColorwaySeason_StagingId.getText(), test, Capture);
		}else {
			System.out.println("Staging Id id not Populating ");
			test.log(Status.FAIL,"Staging Id id not Populating ");
			addSrceenShot("Staging Id id not Populating ", test, Capture);
		}
	}



	
	public void NavigateTo_updatecolorway() throws Exception {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Action_dropdown.click();
		edit_colorway.click();
		Thread.sleep(1000);
	}

	public String rigidIndicatorvalue(ExtentTest test) {
		String Expectedrigidindicator = "";

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Expectedrigidindicator = details_rigidindicator_value.getText();

		return Expectedrigidindicator;
	}

	public void Validate_RigidIndicator_updatecolorway_AfterSetupLSE(String rigidindicator, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Action_dropdown.click();
			edit_colorway.click();
			Thread.sleep(2000);
//			update rigid indicator-----------
			if (RigidIndicator_DD.getText().equalsIgnoreCase("Normal Product")) {
				RigidIndicator_DD.click();
				TextBox.sendKeys("Rigid");
				selectFirst.click();
				System.out.println("Rigid indicator value updated to: Rigid");
				test.log(Status.INFO, "Rigid indicator value updated to: Rigid");
				Save_Button.click();
			} else {
				RigidIndicator_DD.click();
				TextBox.sendKeys("Normal Product");
				selectFirst.click();
				System.out.println("Rigid indicator value updated to: Normal Product");
				test.log(Status.INFO, "Rigid indicator value updated to: Normal Product");
				Save_Button.click();
			}

//			validating rigid indicator---------------------------------------
			String Actualrigidindicator = details_rigidindicator_value.getText();

			if (Actualrigidindicator.equals(rigidindicator)) {
				System.out.println("Rigid indicator value did not changed and the value is: " + Actualrigidindicator);
				test.log(Status.INFO,
						"Rigid indicator value did not changed and the value is: " + Actualrigidindicator);
				addSrceenShot("Rigid indicator value did not changed and the value is: " + Actualrigidindicator, test,
						Capture);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@FindBy(xpath = "//div[@id='lscoRigidInd']/div[2]")
	private WebElement details_rigidindicator_value;

	@FindBy(xpath = "//input[@id='quickSearchInput_ptc_ref_18']")
	private WebElement Designer_TextBox;

	@FindBy(xpath = "//input[@id='quickSearchInput_ptc_ref_17']")
	private WebElement merchant_TextBox;

	@FindBy(xpath = "//input[@id='quickSearchInput_ptc_ref_14']")
	private WebElement Garmentdeveloper_TextBox;

	@FindBy(xpath = "//input[@id='quickSearchInput_ptc_ref_19']")
	private WebElement FieldPDS_TextBox;

	@FindBy(xpath = "//div[@id='selector_Table']/div[2]")
	private WebElement SelectFirstValue;

	@FindBy(xpath = "(//div[@id='lscoDesignerNew'])//div/a")
	private WebElement designerValue;

	@FindBy(xpath = "(//div[@id='lscoMerchantNew'])//div/a")
	private WebElement MerchantValue;

	@FindBy(xpath = "(//div[@id='lscoGarmentDeveloperObjRefNew'])//div/a")
	private WebElement GarmentDeveloperValue;

	@FindBy(xpath = "(//div[@id='lscoFieldPDSNew'])//div/a")
	private WebElement FieldPDSValue;
	
	@FindBy(xpath = "//div[@id='siteNavLink']")
	private WebElement Site;
	

	public void SiteClick() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		Site.click();
	}
	public void Validate_TeamContactsvalue(String merchant, String fieldPDS, String garmentdeveloper, String designer,
			ExtentTest test) {
		if (designerValue.getText().equals(designer)) {
			System.out.println("Designer value is updated and the value is: " + designerValue.getText());
			test.log(Status.INFO, "Designer value is updated and the value is: " + designerValue.getText());
			addSrceenShot("Designer value is updated and the value is: " + designerValue.getText(), test, Capture);
		}
		if (MerchantValue.getText().equals(merchant)) {
			System.out.println("Merchant value is updated and the value is: " + MerchantValue.getText());
			test.log(Status.INFO, "Merchant value is updated and the value is: " + MerchantValue.getText());
			addSrceenShot("Merchant value is updated and the value is: " + MerchantValue.getText(), test, Capture);
		}
		if (FieldPDSValue.getText().equals(fieldPDS)) {
			System.out.println("Field PDS value is updated and the value is: " + FieldPDSValue.getText());
			test.log(Status.INFO, "Field PDS value is updated and the value is: " + FieldPDSValue.getText());
			addSrceenShot("Field PDS value is updated and the value is: " + FieldPDSValue.getText(), test, Capture);

		}
		if (GarmentDeveloperValue.getText().equals(garmentdeveloper)) {
			System.out.println(
					"Garmment developer value is updated and the value is: " + GarmentDeveloperValue.getText());
			test.log(Status.INFO,
					"Garmment developer value is updated and the value is: " + GarmentDeveloperValue.getText());
			addSrceenShot("Garmment developer value is updated and the value is: " + GarmentDeveloperValue.getText(),
					test, Capture);

		}
	}

	@FindBy(xpath = "//a[text()='Designer:']")
	private WebElement Designer;
 
	@FindBy(xpath = "//a[text()='Merchant:']")
	private WebElement merchant;
 
	@FindBy(xpath = "//a[text()='Garment Developer:']")
	private WebElement Garmentdeveloper;
 
	@FindBy(xpath = "//a[text()='Field PDS:']")
	private WebElement FieldPDS;
	
	@FindBy(xpath = "//a[@id='SearchButton1']")
	private WebElement Searchbutton;
	
	@FindBy(xpath = "//td[@class='SEARCH_RESULTS_BAR']/span/a[contains(text(),'Show All')]")
	private WebElement ShowALL;
	
	public void select_designer(String designer,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		Designer.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Searchbutton)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ShowALL)).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
		for(int i=1;i<=list.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[2]/a"));
			if(ele.getText().equals(designer)) {
				test.log(Status.INFO, "developername selected: "+designer);
				driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[1]/a")).click();
				break;
			}
		}
		driver.switchTo().window(tabs.get(1));
	}
	
	public void select_PDS(String fieldPDS,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		FieldPDS.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Searchbutton)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ShowALL)).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
		for(int i=1;i<=list.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[2]/a"));
			if(ele.getText().equals(fieldPDS)) {
				test.log(Status.INFO, "developername selected: "+fieldPDS);
				driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[1]/a")).click();
				break;
			}
		}
		
		driver.switchTo().window(tabs.get(1));
	}
	
	public void select_Merchant(String merchant,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		FieldPDS.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Searchbutton)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ShowALL)).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
		for(int i=1;i<=list.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[2]/a"));
			if(ele.getText().equals(merchant)) {
				test.log(Status.INFO, "developername selected: "+merchant);
				driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[1]/a")).click();
				break;
			}
		}
		
		driver.switchTo().window(tabs.get(1));
	}
	
	public void select_Garmentdeveloper(String garmentdeveloper,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		FieldPDS.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));
		
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Searchbutton)).click();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ShowALL)).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
		for(int i=1;i<=list.size();i++) {
			WebElement ele=driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[2]/a"));
			if(ele.getText().equals(garmentdeveloper)) {
				test.log(Status.INFO, "developername selected: "+garmentdeveloper);
				driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr["+(i+1)+"]/td[1]/a")).click();
				break;
			}
		}
		
		driver.switchTo().window(tabs.get(1));
	}
	
	public void Update_PDS_GD_merchant_designer_value(String merchant, String fieldPDS, String garmentdeveloper,
			String designer, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		select_designer(designer,test);
		Thread.sleep(2000);
		test.log(Status.INFO, "Designer value selected: " + designer);
		
		select_PDS(fieldPDS,test);
		Thread.sleep(2000);
		test.log(Status.INFO, "Field PDS value selected: " + fieldPDS);
		
		select_Merchant(merchant,test);
		Thread.sleep(2000);
		test.log(Status.INFO, "Merchant value selected: " + merchant);
		
		
		select_Garmentdeveloper(garmentdeveloper,test);
		Thread.sleep(2000);
		test.log(Status.INFO, "Garment developer value selected: " + garmentdeveloper);
		
		Save_Button.click();
		Thread.sleep(3000);
 
	}

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement TextBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement selectFirst;

	@FindBy(xpath = "//div[@id='lscoProductDevCenter']/div[2]")
	private WebElement product_productdevcenter;

	@FindBy(xpath = "//div[@id='lscoPDCValue']/div[2]")
	private WebElement colorway_productdevcenter;

	public void validate_ProductDevCenter(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		String colorway_productdevcentervalue = colorway_productdevcenter.getText();

		System.out.println("Product dev center at Colorway level based on user profile is :  " + colorway_productdevcentervalue);
		test.log(Status.INFO, "Product dev center at Colorway level based on user profile is :  " + colorway_productdevcentervalue);
		addSrceenShot("Product dev center at Colorway level based on user profile is :  " + colorway_productdevcentervalue,
				test, Capture);
	}

	public void Validate_CreatedBFF_FG_Colorway(ExtentTest test) {

		String ActualcolorwayName = Colorway_Name.getText();

		System.out.println("colorway name is   " + ActualcolorwayName);
		test.log(Status.INFO, "colorway name is   " + ActualcolorwayName);
		addSrceenShot("colorway name is   " + ActualcolorwayName, test, Capture);
	}

	public void UpdateValue_consumergroupExt_1_2(String consumergroupext1, String consumergroupext2, ExtentTest test)
			throws InterruptedException {
		consumerGroup_Ext1_DD.click();
		TextBox.sendKeys(consumergroupext1);
		selectFirst.click();
		test.log(Status.INFO, "Consumer group Ext 1 value selected: " + consumergroupext1);
		Thread.sleep(1000);

		consumerGroup_Ext2_DD.click();
		TextBox.sendKeys(consumergroupext2);
		selectFirst.click();
		test.log(Status.INFO, "Consumer group Ext 2 value selected: " + consumergroupext2);
		Thread.sleep(1000);
		Save_Button.click();
		Thread.sleep(3000);

	}

	public void Validate_ReuseSeasonalLookcolor(String filtercolor, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		if (Colorway_name.getText().contains(filtercolor)) {
			System.out.println("Same colorway color is successfully updated in PC9  " + Colorway_name.getText());
			test.log(Status.INFO, "Same colorway color is successfully updated in PC9  " + Colorway_name.getText());
			addSrceenShot("Same colorway color is successfully updated in PC9  " + Colorway_name.getText(), test,
					Capture);
		}
	}

	public void Navigate_to_firstTab() {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

	}

	public void NavigateTo_ColorLink() throws InterruptedException {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		colorlink.click();
		Thread.sleep(2000);

	}

	public void NavigateTo_UpdatecolorPC9() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		selectValueFromDropdown(Actions, "Update");

		Thread.sleep(2000);

	}

	public void UploadThumbnail_PrintsandPatternsColor(String filepath) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thumbnail_choosefile.sendKeys(filepath);

		Save_Button.click();
		Thread.sleep(3000);

	}

	public void ValidateUploadedThumbnail_printsandPatternsColor(ExtentTest test) {

		System.out
				.println("Thumbnail uploaded for Prints and patterns color in PC9 and after uploading the src value is "
						+ Thumbnail_img.getAttribute("src"));
		test.log(Status.INFO,
				"Thumbnail uploaded for Prints and patterns color in PC9 and after uploading the src value is "
						+ Thumbnail_img.getAttribute("src"));
		addSrceenShot("Thumbnail uploaded for Prints and patterns color in PC9 and after uploading the src value is "
				+ Thumbnail_img.getAttribute("src"), test, Capture);

	}

	public void Validate_Colorname_ProductMarketingName(ExtentTest test) {

		String colorwaycode = colorway_code.getText();
		String colorname = Color_Name.getText();
		String ExpectedColorwayName = colorwaycode + " " + colorname;
		String ActualcolorwayName = Colorway_Name.getText();

		if (ActualcolorwayName.equals(ExpectedColorwayName)) {
			System.out.println("colorway name is derived from colorway code and color name   " + ActualcolorwayName);
			test.log(Status.INFO, "colorway name is derived from colorway code and color name   " + ActualcolorwayName);
			addSrceenShot("colorway name is derived from colorway code and color name   ", test, Capture);
		}
		String ActualproductMarketingName = ProductMarketing_Name.getText();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);

		String productName = Product_Name.getText();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		String ExpectedProductMarketingName = productName + " " + colorname;

		if (ActualproductMarketingName.equals(ExpectedProductMarketingName)) {
			System.out.println("product Marketing name is derived from product name and color name   "
					+ ActualproductMarketingName);
			test.log(Status.INFO, "product Marketing name is derived from product name and color name   "
					+ ActualproductMarketingName);
			addSrceenShot("product Marketing name is derived from product name and color name   ", test, Capture);

		}
		if (seasonalLook_value.isDisplayed()) {
			System.out.println("Seasonal Look value for same season is:   " + seasonalLook_value.getText());
			test.log(Status.INFO, "Seasonal Look value for same season is: " + seasonalLook_value.getText());
			addSrceenShot("Seasonal Look value for same season", test, Capture);

//			seasonalLook_value.click();
//			
//			if(Primary_Indicator.getText().equalsIgnoreCase("No")) {
//				Editlook.click();
//				PrimaryIndicator.click();
//				PrimaryIndicator_checkbox.click();
//				SaveandCheckIn.click();
//			}
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame(iframeLeft);
//			Product_Name.click();
//			Thread.sleep(3000);
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame(iframeContentframe);
//			
//			colorway_DD.click();
//			Colorway_Textbox.sendKeys(colorway);
//			select_colorwayoption.click();

		}

	}

	public void ValidateseasonalLook_attributes(ExtentTest test) throws Exception {

		if (FabricMill_value.isDisplayed()) {
			System.out.println("Fabric Mill value is:   " + FabricMill_value.getText());
			test.log(Status.INFO, "Fabric Mill value is:  " + FabricMill_value.getText());
			addSrceenShot("Fabric Mill value is:  " + FabricMill_value.getText(), test, Capture);
		}
		if (PrimaryFabric_value.isDisplayed()) {
			System.out.println("Primary Fabric value is:   " + PrimaryFabric_value.getText());
			test.log(Status.INFO, "Primary Fabric value is:  " + PrimaryFabric_value.getText());
			addSrceenShot("Primary Fabric value is:  " + PrimaryFabric_value.getText(), test, Capture);
		}
		if (PrimaryFinish_value.isDisplayed()) {
			System.out.println("Primary finish value  is:  " + PrimaryFinish_value.getText());
			test.log(Status.INFO, "Primary finish value  is:   " + PrimaryFinish_value.getText());
			addSrceenShot("Primary finish value  is:   " + PrimaryFinish_value.getText(), test, Capture);
		}

	}

	public void Validate_Reuse_CreatePC9color(ExtentTest test) {
		if (Reuse_errorMessage.getText().contains("Value for Product Marketing Name must be unique")) {
			System.out.println("Getting Error:-  " + Reuse_errorMessage.getText());
			test.log(Status.PASS, "Getting Error:-  " + Reuse_errorMessage.getText());
			addSrceenShot("Getting Error:- " + Reuse_errorMessage.getText(), test, Capture);
		}
	}

	public String validateColorway_creation(String palettecolorname, ExtentTest test) {
		String colorwaycodename = "";
		String colorwayname = ColorwayName.getText().substring(11);
		colorwaycodename = ColorwayName.getText();
		System.out.println("The colorway generated with name : " + ColorwayName.getText());
		test.log(Status.INFO, "The colorway generated with name : " + ColorwayName.getText());
		addSrceenShot("The colorway generated with name : " + ColorwayName.getText(), test, Capture);
		return colorwaycodename;
	}

	public void Validate_UpdatePC9_SeasonalBFF(String productsegLSUSvalue, String productsegLSEvalue, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		if (ProductsegmentationLSE.getText().equals(productsegLSEvalue)) {
			System.out.println("Product Segementation LSE (UI) value is " + ProductsegmentationLSE.getText()
					+ " and Product Segmentation LSE value is " + productsegLSEvalue + "  are matching");
			test.log(Status.INFO, "Product Segementation LSE (UI) value is " + ProductsegmentationLSE.getText()
					+ " and Product Segmentation LSE value is " + productsegLSEvalue + "  are matching");
			addSrceenShot(
					"Product Segementation LSE (UI) value is " + ProductsegmentationLSE.getText()
							+ " and Product Segmentation LSE value is " + productsegLSEvalue + "  are matching",
					test, Capture);

		}
		if (ProductsegmentationLSUS.getText().equals(productsegLSUSvalue)) {
			System.out.println("Product Segementation LSUS (UI) value is " + ProductsegmentationLSUS.getText()
					+ " and Product Segmentation LSUS value is " + productsegLSUSvalue + "  are matching");
			test.log(Status.INFO, "Product Segementation LSUS (UI) value is " + ProductsegmentationLSUS.getText()
					+ " and Product Segmentation LSUS value is " + productsegLSUSvalue + "  are matching");
			addSrceenShot(
					"Product Segementation LSUS (UI) value is " + ProductsegmentationLSUS.getText()
							+ " and Product Segmentation LSUS value is " + productsegLSUSvalue + "  are matching",
					test, Capture);
		}
	}

	public void Validate_BlankSeasonalAttributes_value(ExtentTest test) {
		if (BlankPrimaryFabric_value.getText().isBlank()) {
			System.out.println("primary fabric value is Blank");
			test.log(Status.INFO, "primary fabric value is Blank ");
		}
		if (BlankFinish_value.getText().isBlank()) {
			System.out.println("primary Finish value is Blank");
			test.log(Status.INFO, " primary Finish value is Blank");
		}
	}

	public void validateProductCenter(ExtentTest test) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			String PC_Value = ProductCenterValue.getText();
			if (PC_Value.equals("Global")) {
				System.out.println(PC_Value + " is derived from user profile and set of PC9");
				test.log(Status.INFO, PC_Value + " is derived from user profile and set of PC9");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_57-container']/span")
	private WebElement ColorwayStatus_check;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_57-container']")
	private WebElement colorwaystatus_dd;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_61-container']")
	private WebElement ComponentsCarryoverNow_DD;

	public void select_colorway_carryovercomponetsNow() throws InterruptedException {
		if (ColorwayStatus_check.getAttribute("title").equals("Locked")) {
			colorwaystatus_dd.click();
			Colorway_Textbox.sendKeys("Unlocked");
			select_colorwayoption.click();
		}

		Thread.sleep(2000);
		ComponentsCarryoverNow_DD.click();
		Colorway_Textbox.sendKeys("Yes");
		select_colorwayoption.click();

		Thread.sleep(2000);

		Save_Button.click();

	}

	public void ValidateProfitCenter_Europe() {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(ProductLSE_value));
			String LSE_value = ProductLSE_value.getText().substring(0, 3);
			System.out.println(LSE_value);
			String PCE_value = PC_EUROPE_value.getText().substring(0, 3);
			System.out.println(PCE_value);
			Assert.assertEquals(LSE_value, PCE_value);
			System.out.println(LSE_value + "and" + PCE_value + " are matching");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void ValidateProfitCenter_US(ExtentTest test) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(ProductLSUS_value));
			String LSUS_value = ProductLSUS_value.getText().substring(0, 3);
			System.out.println(LSUS_value);
			String PCUS_value = ProfitCenter_US_value.getText().substring(0, 3);
			System.out.println(PCUS_value);
			Assert.assertEquals(LSUS_value, PCUS_value);
			System.out.println(LSUS_value + "and" + PCUS_value + " are matching");
			test.log(Status.INFO, LSUS_value + "and" + PCUS_value + " are matching");
			addSrceenShot(LSUS_value + "and" + PCUS_value + " are matching", test, Capture);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Validate_SeasonFirstIntroduced(ExtentTest test) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String seasonfirstintroduced = SeasonFirstIntroduced_value.getText();
		String seasonintroducedPC5 = SeasonFirstIntroducedPC5_value.getText();
		if (seasonfirstintroduced.equals(seasonintroducedPC5)) {
			System.out.println("seasonfirstintroduced value is " + seasonfirstintroduced
					+ " and seasonintroducedPC5 value is " + seasonintroducedPC5 + "  are matching");
			test.log(Status.INFO, "seasonfirstintroduced value is " + seasonfirstintroduced
					+ " and seasonintroducedPC5 value is " + seasonintroducedPC5 + "  are matching");
			addSrceenShot("seasonfirstintroduced value is " + seasonfirstintroduced
					+ " and seasonintroducedPC5 value is " + seasonintroducedPC5 + "  are matching", test, Capture);
		}
	}

	public void Validate_BrandHierarchyValue(ExtentTest test) {

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String productBrandHierarchy = BrandHierarchy_product.getText();
		String colorwayBrandHierarchy = BrandHierarchy_colorway.getText();
		if (productBrandHierarchy.equals(colorwayBrandHierarchy)) {
			System.out.println("product brand hierarchy value is " + productBrandHierarchy
					+ " and Colorway brand Hierarchy value is " + colorwayBrandHierarchy + "  are matching");
			test.log(Status.INFO, "product brand hierarchy value is " + productBrandHierarchy
					+ " and Colorway brand Hierarchy value is " + colorwayBrandHierarchy + "  are matching");
			addSrceenShot(
					"product brand hierarchy value is " + productBrandHierarchy
							+ " and Colorway brand Hierarchy value is " + colorwayBrandHierarchy + "  are matching",
					test, Capture);
		}

	}

	@FindBy(xpath = "//div[text()='lscoInStaging Colorway']/following-sibling::div")
	private WebElement Colorway_StagingId;

	@FindBy(xpath = "//div[text()='lscoInStaging SKUSeasonLink']/following-sibling::div")
	private WebElement ColorwaySeason_StagingId;

	public void Validate_Concept_Attributes(ExtentTest test) {
		String productConcept = Product_Concept.getText();
		String colorwayConcept = Colorway_Concept.getText();
		if (productConcept.equals(colorwayConcept)) {
			System.out.println("product Concept attribute value is " + productConcept
					+ " and Colorway Concept Attribute value is " + colorwayConcept + "  are matching");
			test.log(Status.INFO, "product Concept attribute value is " + productConcept
					+ " and Colorway Concept Attribute value is " + colorwayConcept + "  are matching");
			addSrceenShot("product Concept attribute value is " + productConcept
					+ " and Colorway Concept Attribute value is " + colorwayConcept + "  are matching", test, Capture);
		}
	}

	public void Validate_BusinessUnit(ExtentTest test) {
		String productBusinessUnit = Product_BusinessUnit.getText();
		String colorwayBusinessUnit = Colorway_BusinessUnit.getText();
		if (productBusinessUnit.equals(colorwayBusinessUnit)) {
			System.out.println("product Business Unit value is " + productBusinessUnit
					+ " and Colorway Business Unit value is " + colorwayBusinessUnit + "  are matching");
			test.log(Status.INFO, "product Business Unit value is " + productBusinessUnit
					+ " and Colorway Business Unit value is " + colorwayBusinessUnit + "  are matching");
			addSrceenShot("product Business Unit value is " + productBusinessUnit
					+ " and Colorway Business Unit value is " + colorwayBusinessUnit + "  are matching", test, Capture);
		}
	}

	public void Validate_ConsumerGroupExt(ExtentTest test) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String consumergroup1 = ConsumerGroup_1.getText();
		String consumergroup2 = ConsumerGroup_2.getText();
		String consumergroupExt1 = ConsumerGroup_Ext1.getText();
		String consumergroupExt2 = ConsumerGroup_Ext2.getText();
		if (consumergroup1.equals(consumergroupExt1)) {
			System.out.println("consumergroup1 value is " + consumergroup1 + " and consumergroupExt1 value is  "
					+ consumergroupExt1 + "  are matching");
			test.log(Status.INFO, "consumergroup1 value is " + consumergroup1 + " and consumergroupExt1 value is  "
					+ consumergroupExt1 + "  are matching");
			addSrceenShot("consumergroup1 value is " + consumergroup1 + " and consumergroupExt1 value is  "
					+ consumergroupExt1 + "  are matching", test, Capture);
		}
		if (consumergroup2.equals(consumergroupExt2)) {
			System.out.println("consumergroup2 value is " + consumergroup2 + " and consumergroupExt2 value is  "
					+ consumergroupExt2 + "  are matching");
			test.log(Status.INFO, "consumergroup2 value is " + consumergroup2 + " and consumergroupExt2 value is  "
					+ consumergroupExt2 + "  are matching");
			addSrceenShot("consumergroup2 value is " + consumergroup2 + " and consumergroupExt2 value is  "
					+ consumergroupExt2 + "  are matching", test, Capture);
		}

	}

	public void Validate_ConsumerGroupExt_UpdatePC9(String consumergroupext2, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String consumergroup1 = ConsumerGroup_1.getText();
		String consumergroup2 = ConsumerGroup_2.getText();
		String consumergroupExt1 = ConsumerGroup_Ext1.getText();
		String consumergroupExt2 = ConsumerGroup_Ext2.getText();
		if (consumergroup1.contains(consumergroupExt1)) {
			System.out.println("consumergroup1 value is " + consumergroup1 + " and consumergroupExt1 value is  "
					+ consumergroupExt1 + "  are matching");
			test.log(Status.INFO, "consumergroup1 value is " + consumergroup1 + " and consumergroupExt1 value is  "
					+ consumergroupExt1 + "  are matching");
			addSrceenShot("consumergroup1 value is " + consumergroup1 + " and consumergroupExt1 value is  "
					+ consumergroupExt1 + "  are matching", test, Capture);
		}
		if (consumergroup2.equals("Regular")) {
			if (consumergroupExt2.contains(consumergroupext2)) {
				System.out.println("consumergroup2 value is " + consumergroup2 + " and consumergroupExt2 value is  "
						+ consumergroupExt2 + "  are matching");
				test.log(Status.INFO, "consumergroup2 value is " + consumergroup2 + " and consumergroupExt2 value is  "
						+ consumergroupExt2 + "  are matching");
				addSrceenShot("consumergroup2 value is " + consumergroup2 + " and consumergroupExt2 value is  "
						+ consumergroupExt2 + "  are matching", test, Capture);
			}
		}

	}

	public void Validate_DestroySampleIndicator(ExtentTest test) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String ConsumerHirarchy = ConsumerprodHierarchy.getText();
		String DestroySample = DestroySampleIndicator.getText();

		if (ConsumerHirarchy.equals("Mens") || ConsumerHirarchy.equals("Womens")) {
			Assert.assertTrue(DestroySample.equalsIgnoreCase("No"));
			System.out.println("Consumer Prod Hierarchy value is : " + ConsumerHirarchy
					+ " and DestroySample value is : " + DestroySample);
			test.log(Status.INFO, "Consumer Prod Hierarchy value is : " + ConsumerHirarchy
					+ " and DestroySample value is : " + DestroySample);
			addSrceenShot("Consumer prod Hierarchy value is : " + ConsumerHirarchy + " and DestroySample value is : "
					+ DestroySample, test, Capture);
		}
		if (ConsumerHirarchy.equals("Boys") || ConsumerHirarchy.equals("Girls")) {
			Assert.assertTrue(DestroySample.equalsIgnoreCase("Yes"));
			System.out.println("Consumer prod Hierarchy value is : " + ConsumerHirarchy
					+ " and DestroySample value is : " + DestroySample);
			test.log(Status.INFO, "Consumer prod Hierarchy value is : " + ConsumerHirarchy
					+ " and DestroySample value is : " + DestroySample);
			addSrceenShot("Consumer prod Hierarchy value is : " + ConsumerHirarchy + " and DestroySample value is : "
					+ DestroySample, test, Capture);
		}

	}

	public void ValidateCarryover_ColorwayAttributes(String finalseason, String linesheetview, String copiedproduct,
			ExtentTest test) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			String Actualproduct_productBusinessUnit = Product_BusinessUnit.getText();
			String Actualproduct_productcategory = ProductCategoryValue.getText();
			String Actualproduct_productcode = product_code.getText();
			String Actualproduct_brandvalue = BrandValue.getText();
			Thread.sleep(2000);

			driver.switchTo().window(tabs.get(0));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeLeft);

			selectValueFromDropdown(SeasonsDropdown, finalseason);
			test.log(Status.INFO, "Season selected: " + finalseason);

			driver.findElement(By.xpath("//div[@id='seasonDevelopmentContent']/a[2]")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Thread.sleep(10000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(linesheet_View));
			linesheet_View.click();
			linesheet_View_textbox.sendKeys(linesheetview);
			Thread.sleep(2000);
			view_selection.click();

			settings.click();
			level_DD.click();
			product_value.click();
			ApplyChanges.click();
			FilterTextbox.sendKeys(copiedproduct);
			Thread.sleep(5000);
			firstproduct.click();
			test.log(Status.INFO, "Product selected: " + copiedproduct);
			WaitforPage(5000);

			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			String copiedproduct_productBusinessUnit = Product_BusinessUnit.getText();
			String copiedproduct_productcategory = ProductCategoryValue.getText();
			String copiedproduct_productcode = product_code.getText();
			String copiedproduct_brandvalue = BrandValue.getText();

			if (copiedproduct_productBusinessUnit.equals(Actualproduct_productBusinessUnit)) {
				System.out.println("Actual product -product business unit is:  " + Actualproduct_productBusinessUnit
						+ "--------- Copied product-poduct businessunit is: " + copiedproduct_productBusinessUnit
						+ "---  are matching");
				test.log(Status.INFO,
						"Actual product -product business unit is:  " + Actualproduct_productBusinessUnit
								+ "----- Copied product-poduct businessunit is: " + copiedproduct_productBusinessUnit
								+ "---  are matching");
				addSrceenShot("Actual product -product business unit is:  " + Actualproduct_productBusinessUnit
						+ "------- Copied product-poduct businessunit is: " + copiedproduct_productBusinessUnit
						+ "---  are matching", test, Capture);
			}
			if (copiedproduct_productcategory.equals(Actualproduct_productBusinessUnit)) {
				System.out.println("Actual product -product category is:  " + Actualproduct_productcategory
						+ "-------- Copied product-poduct category is: " + copiedproduct_productcategory
						+ "---  are matching");
				test.log(Status.INFO,
						"Actual product -product category is:  " + Actualproduct_productcategory
								+ "------- Copied product-poduct category is: " + copiedproduct_productcategory
								+ "---  are matching");
				addSrceenShot("Actual product -product category is:  " + Actualproduct_productcategory
						+ "-------- Copied product-poduct category is: " + copiedproduct_productcategory
						+ "---  are matching", test, Capture);
			}
			if (!copiedproduct_productcode.equals(Actualproduct_productcode)) {
				System.out.println("Actual product -product code is:  " + Actualproduct_productcode
						+ "----------- Copied product-poduct code is: " + copiedproduct_productcode
						+ "---  are not matching");
				test.log(Status.INFO,
						"Actual product -product code is:  " + Actualproduct_productcode
								+ "--------- Copied product-poduct code is: " + copiedproduct_productcode
								+ " --- are not matching");
				addSrceenShot("Actual product -product code is:  " + Actualproduct_productcode
						+ " -----------Copied product-poduct code is: " + copiedproduct_productcode
						+ " --- are not matching", test, Capture);
			}
			if (copiedproduct_brandvalue.equals(Actualproduct_brandvalue)) {
				System.out.println("Actual product -product brand value is:  " + Actualproduct_brandvalue
						+ "-------- Copied product-poduct brand value is: " + copiedproduct_brandvalue
						+ "---  are matching");
				test.log(Status.INFO,
						"Actual product -product brand value is:  " + Actualproduct_brandvalue
								+ "-------- Copied product-poduct brand value is: " + copiedproduct_brandvalue
								+ "---  are matching");
				addSrceenShot("Actual product -product brand value is:  " + Actualproduct_brandvalue
						+ "--------- Copied product-poduct brand value is: " + copiedproduct_brandvalue
						+ "---  are matching", test, Capture);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

//		String colorwaycode=colorway_code.getText();
//		String colorname=Color_Name.getText();
//		String ExpectedColorwayName= colorwaycode+" "+colorname;
//		String ActualcolorwayName=Colorway_Name.getText();
//		

	}

	public void ClickSeasonalLook() {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(SeasonalLook_Link)).click();
//			SeasonalLook_Link.click();	
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void ValidateSeasonalLookAttributes() {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Assert.assertTrue(primary_indicator.getText().equalsIgnoreCase("Yes"));
			driver.navigate().back();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Assert.assertTrue(FabricMill_value.isDisplayed());
			System.out
					.println("Primary fabric Mill value is displayed and the value is: " + FabricMill_value.getText());
			Assert.assertTrue(PrimaryFabric_value.isDisplayed());
			System.out.println("Primary fabric value is displayed and the value is: " + FabricMill_value.getText());
			Assert.assertTrue(PrimaryFinish_value.isDisplayed());
			System.out.println("Primary finish value is displayed and the value is: " + PrimaryFinish_value.getText());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	-----------------------------------------------------------------------------------------------------

	public void filterProductByName(String productName) throws Exception {

		driver.switchTo().defaultContent();

		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(ProductNameHeader));

		filterInput.clear();

		filterInput.sendKeys(productName);

		FilteredProductName.click();

	}

	public void selectColorwayFromMenu(String colourWayName) throws InterruptedException {

		driver.switchTo().defaultContent();

		driver.switchTo().frame(iframeContentframe);

		WebElement dropdownSymbol = new WebDriverWait(driver, 120).until(

				ExpectedConditions.elementToBeClickable(createColorwayDropdown));

		dropdownSymbol.click();

		WebElement searchBox = new WebDriverWait(driver, 10)

				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='searchbox']")));

		searchBox.sendKeys(colourWayName);

		WebElement option = new WebDriverWait(driver, 10)

				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option']")));

		option.click();

	}

	public void validateDetails(String Brand, String Product_Category, String Consumer_PH, String Profit_Center_APD)
			throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// Validate the details
		try {
			boolean isBrandValid = productBrand.getText().equalsIgnoreCase(Brand);
			boolean isCategoryValid = productCategory.getText().equalsIgnoreCase(Product_Category);
			boolean isConsumerPHValid = ConsumerPH.getText().equalsIgnoreCase(Consumer_PH);
			boolean isProfitCenterValid = profitCenter_APD.getText().equals(Profit_Center_APD);
			if (isBrandValid && isCategoryValid && isConsumerPHValid) {
				Assert.assertTrue(isProfitCenterValid, "Profit Center APD does not match!");

			} else {
				throw new AssertionError("One or more details do not match!");
			}
		} catch (Exception e) {
			System.err.println("Validation failed: " + e.getMessage());
			throw e;
		}
	}

	public String getPc9Code() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(pc9CodeElement));

		return pc9CodeElement.getText();
	}

	public String getColourwayName() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(colourwayNameElement));

		return colourwayNameElement.getText();
	}

	public String getProductName() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(productNameElement));

		return productNameElement.getText();
	}

	public String getProductMarketingName() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(productMarketingNameElement));

		return productMarketingNameElement.getText();
	}

	public Colorway_page clickOnColorDetailsLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(linkToColorDetails));
		linkToColorDetails.click();
		return new Colorway_page(driver);
	}

	public String getLscoArtwork() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(lscoArtwork));
		return lscoArtwork.getText();
	}

	public String getLscoArtworkName() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(lscoArtworkName));
		return lscoArtworkName.getText();
	}

	public String getColorCombo() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(colorComboElement));
		return colorComboElement.getText();
	}

	public String getPrintType() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(printTypeElement));
		return printTypeElement.getText();
	}

	public boolean isColorwayCodeDisplayed() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(pc9CodeElement));
		return pc9CodeElement.isDisplayed();
	}

	public String getColorwayCode() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(pc9CodeElement));
		return pc9CodeElement.getText();
	}

	public void selectSundrycolour() throws InterruptedException {

		String parent = driver.getWindowHandle();
		System.out.println("parent window id is " + parent);

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));
		String thirdwindowId = driver.getWindowHandle();
		System.out.println("third window Id " + thirdwindowId);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeColorLibraryframe);

		WebElement colorLookDropdown = new WebDriverWait(driver, 180)
				.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
		colorLookDropdown.click();

		WebElement searchInput = driver
				.findElement(By.xpath("//input[@class='p-tree-filter p-inputtext p-component']"));
		searchInput.sendKeys("Sundry Color");

		WebElement sundryColorOption = driver.findElement(By.xpath("//span[contains(text(),'Sundry Color')]"));
		sundryColorOption.click();

		WebElement searchButton = driver.findElement(By.xpath("//span[normalize-space()='Search']"));
		searchButton.click();

		new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();

		driver.switchTo().window(tabs.get(1));
	}

	public void editColorway() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
//		System.out.println("string menu" +":");
		driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Edit Colorway']")).click();

	}

//---------------------------------------------------P1 methods---------------------------------------------
//	----------------------------------------------------------------------------------------------------------
//	--------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "(//ul[@class='p-treenode-children ng-star-inserted'])[2]/p-treenode//div[@aria-label='Colors']/button")
	private WebElement color_menu;

	@FindBy(xpath = "//div[@aria-label='Prints and Patterns']")
	private WebElement PrintsandPatterns_menu;

	@FindBy(xpath = "(//div[@id='DateEditor']//span/input)[1]")
	private WebElement createdFrom;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement filtercolor;

	@FindBy(xpath = "(//div[@col-id='color.name|~*~|PrintandPattern'])[2]//a")
	private WebElement clickfirstcolor;

	@FindBy(xpath = "//tbody/tr/td[@class='FORMLABEL']/a")
	private WebElement developerattibutes;

	@FindBy(xpath = "//tbody/tr/td[@id='lscoColorName']")
	private WebElement Artwork_name;

	@FindBy(xpath = "//div[@aria-label='Heathers']")
	private WebElement Heathers_menu;

	@FindBy(xpath = "//div[@role='gridcell']//a[@class='ng-star-inserted']")
	private WebElement FirstHeather_color;

	@FindBy(xpath = "//td[@class='PAGEHEADINGTEXT']/select")
	private WebElement Actions;

	@FindBy(xpath = "//input[@name='redValue']")
	private WebElement Red_value;

	@FindBy(xpath = "(//td[@class='DISPLAYTEXT'])[1]")
	private WebElement color_name;

	public void select_printsandPatterns(String createdfrom) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement colorLookDropdown = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
		colorLookDropdown.click();
		LSCOmenu.click();
		color_menu.click();
		PrintsandPatterns_menu.click();
		Thread.sleep(2000);
		createdFrom.sendKeys(createdfrom);
		createdFrom.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	public void select_Heathers(String createdfrom) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement colorLookDropdown = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
		colorLookDropdown.click();
		LSCOmenu.click();
		color_menu.click();
		Heathers_menu.click();
		Thread.sleep(2000);
		createdFrom.sendKeys(createdfrom);
		createdFrom.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	public void filtercolor(String colorname) {
		filtercolor.sendKeys(colorname);

	}

	public void click_Heathers_color() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getcolor_heathers_ColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("LS&Co. Color")) {
				FirstHeather_color.click();
				Thread.sleep(3000);
			}
		}
	}

	public void updateHeathercolor(String newcolorname) throws InterruptedException {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		selectValueFromDropdown(Actions, "Update");
		updatecolor_name.clear();
		updatecolor_name.sendKeys(newcolorname);
		Save_Button.click();
		Thread.sleep(3000);

	}

	@FindBy(xpath = "//input[@id='ptc_str_5']")
	private WebElement updatecolor_name;
	@FindBy(xpath = "(//td[@id='lscoColorName'])[1]")
	private WebElement LSCOcolor_name;
	@FindBy(xpath = "(//td[@id='lscoColorCode'])[1]")
	private WebElement LSCOcolor_code;

	@FindBy(xpath = "(//td[@id='lscoBrand']/following-sibling::td)[2]")
	private WebElement LSCOsearch_code;

	@FindBy(xpath = "//div[@id='lscoColorwayCode']//div[@class='display-only-label']")
	private WebElement colorway_code;

	@FindBy(xpath = "//div[@id='color']//div[@class='display-only-label']/a")
	private WebElement Color_Name;

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement Colorway_Name;

	@FindBy(xpath = "//div[@id='lscoProdMarketingName']/div[@class='display-only-label']")
	private WebElement ProductMarketing_Name;

	@FindBy(xpath = "//div[@id='navHeader']/a")
	private WebElement Product_Name;

	public void Validate_colorname_searchcode(ExtentTest test) {

		String colorname = color_name.getText();
		String LSCOcolorname = LSCOcolor_name.getText();
		String LSCOcolorcode = LSCOcolor_code.getText();
		if (colorname.equals(LSCOcolorcode + " " + LSCOcolorname)) {
			System.out.println("color name is validated and the colorname is:" + colorname);
			test.log(Status.PASS, "color name is validated and the colorname is:" + colorname);
			addSrceenShot("color name is validated and the colorname is:" + colorname, test, Capture);
		}
		if (LSCOsearch_code.getText().equals(LSCOcolorname + " " + LSCOcolorcode)) {
			System.out.println("search code is validated and the searchcode is:" + LSCOsearch_code.getText());
			test.log(Status.PASS, "search code is validated and the search code is:" + LSCOsearch_code.getText());
			addSrceenShot("search code is validated and the search code is:" + LSCOsearch_code.getText(), test,
					Capture);
		}

	}

	public void clickcolor() {
		clickfirstcolor.click();
	}

	public void Validate_PrintsandPatterns_details_Attributes(String attributes, ExtentTest test) {

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String[] attributesarray = attributes.split(",");

		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[@class='FORMLABEL']"));
		for (WebElement Attributes : list) {
			String ActualAttributes = Attributes.getText();
			for (String ExpectedAttributes : attributesarray) {
				if (ActualAttributes.contains(ExpectedAttributes)) {
					System.out.println(ExpectedAttributes + " : attribute is present");
					test.log(Status.INFO, ExpectedAttributes + " : attribute is present");
					addSrceenShot("Attribute is present" + ExpectedAttributes, test, Capture);
				}

			}
		}

	}

	public void Validate_Create_PrintsandPatternsPage_Attributes(String attributes, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		String[] attributesarray = attributes.split(",");

		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[@class='REQUIRED']"));
		list.add(driver.findElement(By.xpath("//tbody/tr/td[@class='FORMLABEL']/a")));

		for (WebElement Attributes : list) {
			String ActualAttributes = Attributes.getText();

			for (String ExpectedAttributes : attributesarray) {
				if (ActualAttributes.equals(ExpectedAttributes)) {
					System.out.println(ExpectedAttributes + " : attribute is Mandatory and present");
					test.log(Status.INFO, ExpectedAttributes + " : attribute is Mandatory and  present");
					addSrceenShot("Attribute is mandatory and present" + ExpectedAttributes, test, Capture);
				}
			}
		}

	}

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeftPanel;

	@FindBy(xpath = "//div[@id='pinbutton']")
	private WebElement pinbutton;

	@FindBy(xpath = "//label[normalize-space()='Libraries']")
	private WebElement librariesoptn;

	@FindBy(xpath = "//a[normalize-space()='Business Object']")
	private WebElement businessObjectoptn;

	@FindBy(xpath = "//a[@id='SearchButton2']")
	private WebElement searchbutton_2;

	@FindBy(xpath = "//td[contains(text(),'Brand')]/following::select[1]")
	private WebElement brandDropdown;

	@FindBy(xpath = "//td[contains(text(),'Product Category')]/following::select[1]")
	private WebElement productCategoryDropdown;

	@FindBy(xpath = "//td[contains(text(),'Consumer Group 1')]/following::select[1]")
	private WebElement consumerGroup1Dropdown;

	@FindBy(xpath = "//td[contains(text(),'Consumer PH')]/following::select[1]")
	private WebElement consumerPHDropdown;

	@FindBy(xpath = "//td[contains(text(),'Brand')]/following::a[1]")
	private WebElement addBrandButton;

	@FindBy(xpath = "//td[contains(text(),'Product Category')]/following::a[1]")
	private WebElement addProductCategoryButton;

	@FindBy(xpath = "//td[contains(text(),'Consumer Group 1')]/following::a[1]")
	private WebElement addConsumerGroup1Button;

	@FindBy(xpath = "//td[contains(text(),'Consumer PH')]/following::a[1]")
	private WebElement addConsumerPHButton;

	@FindBy(xpath = "//a[normalize-space()='Product Segmentation Code']")
	private WebElement prodsegCode;

	@FindBy(xpath = "//span[normalize-space()='Hide/Show Columns']")
	private WebElement hideColButton;

	@FindBy(xpath = "//div[contains(text(), 'Profit Center [US]')]/following-sibling::div/a")
	private WebElement getProfitCenterUS_Value;

	@FindBy(xpath = "//div[contains(text(), 'Profit Center [EUROPE]')]/following-sibling::div/a")
	private WebElement getProfitCenterEUROPE_Value;

	@FindBy(xpath = "//iframe[@id='colorlibraryframe']")
	private WebElement iframeMateriallibraryframe;

	@FindBy(xpath = "//input[@class='p-tree-filter p-inputtext p-component']")
	private WebElement searchInput;

	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='LS&Co. Color']/following::input[1]")
	private WebElement lscoColornameSearchField;

	@FindBy(xpath = "//div[@class='input-title'][normalize-space()='Name']/following::input[1]")
	private WebElement nameSearchField;

	@FindBy(xpath = "//span[normalize-space()='Clear Criteria']")
	private WebElement clearCriteria;

	@FindBy(xpath = "//span[normalize-space()='Reset Defaults']")
	private WebElement resetDefaults;

	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement searchButton;

	public void editColorWay() throws Exception {
		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colourwayDropDown));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Edit Colorway']")).click();
		Thread.sleep(2000);
		addSrceenShot("Clicked On Edit Colorway from the Menu", test, Capture);

	}

//	public List<String> getAPDValues(ExtentTest test) {
//		List<String> apdValues = new ArrayList<>();
//
//		try {
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame(iframeContentframe);
//
//			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(profitCentDropDown));
//			profitCentDropDown.click();
//			List<WebElement> apdElements = driver.findElements(By.xpath(
//					"//div[contains(text(), 'Profit Center [APD]')]/following-sibling::div/following::li"));
//
//			for (WebElement element : apdElements) {
//				apdValues.add(element.getText());
//			}
//			Thread.sleep(200);
//			test.log(Status.INFO, "Profit Center [APD] values retrieved: " + String.join(", ", apdValues));
//			addSrceenShot("Profit Center [APD] values retrieved", test, Capture);
//
//		} catch (Exception e) {
//			test.log(Status.FAIL, "Failed to retrieve APD values due to exception: " + e.getMessage());
//			addSrceenShot("Failed to retrieve LSUS values", test, Capture);
//			System.out.println(e);
//		}
//		return apdValues;
//	}

	@FindBy(xpath = "//div[contains(text(), 'Profit Center [APD]')]/following-sibling::div")
	private WebElement profitCentDropDown;

	public List<String> getAPDValues(ExtentTest test) {
		List<String> apdValues = new ArrayList<>();

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(profitCentDropDown));
			profitCentDropDown.click();
			List<WebElement> apdElements = driver.findElements(
					By.xpath("//div[contains(text(), 'Profit Center [APD]')]/following-sibling::div/following::li"));

			for (WebElement element : apdElements) {
				String text = element.getText();
				// Check if the text contains the apostrophe
				if (!text.contains("Levi's")) {
					// Normalize the text by adding the apostrophe where it's missing
					text = text.replaceAll("Levi s", "Levi's");
				}
				apdValues.add(text);
			}
			Thread.sleep(200);
			test.log(Status.INFO, "Profit Center [APD] values retrieved: " + String.join(", ", apdValues));
			addSrceenShot("Profit Center [APD] values retrieved", test, Capture);

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to retrieve APD values due to exception: " + e.getMessage());
			addSrceenShot("Failed to retrieve APD values", test, Capture);
			System.out.println(e);
		}
		return apdValues;
	}

	public List<String> getLSUSValues(ExtentTest test) {
		List<String> lsusValues = new ArrayList<>();

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productSegmentationLSUSDropDown));
			productSegmentationLSUSDropDown.click();
			List<WebElement> lsusElements = driver.findElements(By.xpath(
					"//div[contains(text(), 'Product Segmentation [LSUS]')]/following-sibling::div/following::li"));

			for (WebElement element : lsusElements) {
				lsusValues.add(element.getText());
			}
			Thread.sleep(200);
			test.log(Status.INFO, "LSUS values retrieved: " + String.join(", ", lsusValues));
			addSrceenShot("LSUS values retrieved", test, Capture);

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to retrieve LSUS values due to exception: " + e.getMessage());
			addSrceenShot("Failed to retrieve LSUS values", test, Capture);
			System.out.println(e);
		}
		return lsusValues;
	}

	public List<String> getLSEValues(ExtentTest test) {
		List<String> lseValues = new ArrayList<>();

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productSegmentationLSEDropDown));
			productSegmentationLSEDropDown.click();
			List<WebElement> lseElements = driver.findElements(By.xpath(
					"//div[contains(text(), 'Product Segmentation [LSE]')]/following-sibling::div/following::li"));

			for (WebElement element : lseElements) {
				lseValues.add(element.getText());
			}

			test.log(Status.INFO, "LSE values retrieved: " + String.join(", ", lseValues));
			addSrceenShot("LSE values retrieved", test, Capture);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to retrieve LSE values due to exception: " + e.getMessage());
			addSrceenShot("Failed to retrieve LSE values", test, Capture);
			System.out.println(e);
		}
		return lseValues;
	}

	public String getBrand() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(BrandValue));
		String getBrand_Value = BrandValue.getText();
		return getBrand_Value;
	}

	public String get_ProductCategory() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ProductCategory));
		String getProductCategory_Value = ProductCategory.getText();
		return getProductCategory_Value;
	}

	public String getConsumerGroup1() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Consumergrp1));
		String getConsumerGroup1_Value = Consumergrp1.getText();
		return getConsumerGroup1_Value;
	}

	public String getConsumer_PH() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(Consumer_PH));
		String getConsumer_PH_Value = Consumer_PH.getText();
		return getConsumer_PH_Value;
	}

	public void openNewTabAndNavigateToBusinessObject(String URL, ExtentTest test) throws InterruptedException {

		// Logic to open new tab and navigate to another existing color solid
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2)); // Switch to new tab

		driver.get(URL); // Navigate to the color look library URL
		Thread.sleep(4000);
		addSrceenShot("Opened URL", test, Capture);
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pinbutton));
		clickElement(pinbutton);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(librariesoptn));
		librariesoptn.click();
		Thread.sleep(2000);
		addSrceenShot("Clicked On library", test, Capture);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(businessObjectoptn));
		businessObjectoptn.click();
		Thread.sleep(2000);
		addSrceenShot("Opened new tab and navigated to the Business Object Library", test, Capture);
	}

	public void selctBusinessObject(String businessObject) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchbutton_2));
		WebElement business_Object = driver
				.findElement(By.xpath("//a[normalize-space()='" + businessObject.trim() + "']"));
		business_Object.click();
		Thread.sleep(2000);
	}

	public void fillProductSegmentationLSUSDetails(String brand, String productCategory, String ConsumerPH,
			ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandDropdown));
			Select brandSelect = new Select(brandDropdown);
			brandSelect.selectByVisibleText(brand);
			test.log(Status.INFO, "Brand selected: " + brand);
			Thread.sleep(2000);
			addBrandButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Brand button");
			addSrceenShot("Clicked Add Brand button", test, Capture);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productCategoryDropdown));
			Select productCategorySelect = new Select(productCategoryDropdown);
			productCategorySelect.selectByVisibleText(productCategory);
			test.log(Status.INFO, "Product Category selected: " + productCategory);
			Thread.sleep(2000);
			addProductCategoryButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Product Category button");
			addSrceenShot("Clicked Add Product Category button", test, Capture);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerPHDropdown));
			Select consumerPHSelect = new Select(consumerPHDropdown);
			consumerPHSelect.selectByVisibleText(ConsumerPH);
			test.log(Status.INFO, "Consumer Group 1 selected: " + ConsumerPH);
			Thread.sleep(2000);
			addConsumerPHButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Consumer PH button");
			addSrceenShot("Clicked Add Consumer PH button", test, Capture);

			Thread.sleep(2000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", searchbutton_2);
			searchbutton_2.click();
			test.log(Status.INFO, "Clicked on Search button");
			addSrceenShot("Clicked on Search button", test, Capture);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fill Product Segmentation details due to exception: " + e.getMessage());
			addSrceenShot("Failed to fill Product Segmentation details", test, Capture);
			System.out.println(e);
		}
	}

	public void fillProfitCenterDetails(String brand, String productCategory, String ConsumerPH, ExtentTest test)
			throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandDropdown));
			Select brandSelect = new Select(brandDropdown);
			brandSelect.selectByVisibleText(brand);
			test.log(Status.INFO, "Brand selected: " + brand);
			Thread.sleep(2000);
			addBrandButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Brand button");
			addSrceenShot("Clicked Add Brand button", test, Capture);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productCategoryDropdown));
			Select productCategorySelect = new Select(productCategoryDropdown);
			productCategorySelect.selectByVisibleText(productCategory);
			test.log(Status.INFO, "Product Category selected: " + productCategory);
			Thread.sleep(2000);
			addProductCategoryButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Product Category button");
			addSrceenShot("Clicked Add Product Category button", test, Capture);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerPHDropdown));
			Select consumerPHSelect = new Select(consumerPHDropdown);
			consumerPHSelect.selectByVisibleText(ConsumerPH);
			test.log(Status.INFO, "Consumer Group 1 selected: " + ConsumerPH);
			Thread.sleep(2000);
			addConsumerPHButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Consumer PH button");
			addSrceenShot("Clicked Add Consumer PH button", test, Capture);

			Thread.sleep(2000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", searchbutton_2);
			searchbutton_2.click();
			test.log(Status.INFO, "Clicked on Search button");
			addSrceenShot("Clicked on Search button", test, Capture);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fill Product Segmentation details due to exception: " + e.getMessage());
			addSrceenShot("Failed to fill Product Segmentation details", test, Capture);
			System.out.println(e);
		}
	}

	public void fillProductSegmentationLSEDetails(String brand, String productCategory, String consumerGroup1,
			ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(brandDropdown));
			Select brandSelect = new Select(brandDropdown);
			brandSelect.selectByVisibleText(brand);
			test.log(Status.INFO, "Brand selected: " + brand);
			Thread.sleep(2000);
			addBrandButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Brand button");
			addSrceenShot("Clicked Add Brand button", test, Capture);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productCategoryDropdown));
			Select productCategorySelect = new Select(productCategoryDropdown);
			productCategorySelect.selectByVisibleText(productCategory);
			test.log(Status.INFO, "Product Category selected: " + productCategory);
			Thread.sleep(2000);
			addProductCategoryButton.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Product Category button");
			addSrceenShot("Clicked Add Product Category button", test, Capture);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(consumerGroup1Dropdown));
			Select consumerGroup1Select = new Select(consumerGroup1Dropdown);
			consumerGroup1Select.selectByVisibleText(consumerGroup1);
			test.log(Status.INFO, "Consumer Group 1 selected: " + consumerGroup1);
			Thread.sleep(2000);
			addConsumerGroup1Button.click();
			Thread.sleep(2000);
			test.log(Status.INFO, "Clicked Add Consumer Group 1 button");
			addSrceenShot("Clicked Add Consumer Group 1 button", test, Capture);

			Thread.sleep(2000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", searchbutton_2);
			searchbutton_2.click();
			test.log(Status.INFO, "Clicked on Search button");
			addSrceenShot("Clicked on Search button", test, Capture);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to fill Product Segmentation details due to exception: " + e.getMessage());
			addSrceenShot("Failed to fill Product Segmentation details", test, Capture);
			System.out.println(e);
		}
	}

	public List<String> getTableValues(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		List<String> tableValues = new ArrayList<>();
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(prodsegCode));
			List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='table-wrapper']//tr/td[1]/a"));
			for (WebElement row : tableRows) {
				tableValues.add(row.getText());
			}
			test.log(Status.INFO,
					"Lookup Tables\\Product Segmentation table values retrieved: " + String.join(", ", tableValues));
			addSrceenShot("Lookup Tables\\Product Segmentation table values retrieved", test, Capture);
		} catch (Exception e) {
			test.log(Status.FAIL,
					"Failed to retrieve Lookup Tables\\Product Segmentation table values due to exception: "
							+ e.getMessage());
			addSrceenShot("Failed to retrieve LSE values", test, Capture);
			System.out.println(e);
		}
		return tableValues;
	}

	public List<String> getProfitCenterTableValues(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		List<String> tableValues = new ArrayList<>();
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(hideColButton));
			List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='table-wrapper']//tr/td[1]/a"));
			for (WebElement row : tableRows) {
				tableValues.add(row.getText());
			}
			test.log(Status.INFO,
					"Lookup Tables\\Profit Center table values retrieved: " + String.join(", ", tableValues));
			addSrceenShot("Lookup Tables\\Profit Center table values retrieved", test, Capture);
		} catch (Exception e) {
			test.log(Status.FAIL,
					"Failed to retrieve Lookup Tables\\Profit Center table values due to exception: " + e.getMessage());
			addSrceenShot("Failed to retrieve Profit Center values", test, Capture);
			System.out.println(e);
		}
		return tableValues;
	}

	public void selectProdSegLSUS_DropDown(String productSegmentationLSUS_Value) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(productSegmentationLSUSDropDown));
		productSegmentationLSUSDropDown.click();
		Thread.sleep(3000);
		ProductSeg_LSUS_TextBox.sendKeys(productSegmentationLSUS_Value);
		Thread.sleep(2000);
		ProductSeg_LSUS_Selection.click();

	}

	public void selectProdSegLSE_DropDown(String productSegmentationLSE_Value) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(productSegmentationLSEDropDown));
		productSegmentationLSEDropDown.click();
		Thread.sleep(3000);
		ProductSeg_LSE_TextBox.sendKeys(productSegmentationLSE_Value);
		Thread.sleep(2000);
		ProductSeg_LSE_Selection.click();

	}

	public void clickOnsaveButton() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();

	}

	public void ValidateProfitCenter_US(String productSegmentationLSUS_Value, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(getProfitCenterUS_Value));

			String actualProfitCenter = getProfitCenterUS_Value.getText();

			// Check if any word from Product Segmentation [LSUS] is present in Profit
			// Center[US]
			boolean isWordsPresent = isAnyWordsPresentInProfitCenter_US(productSegmentationLSUS_Value,
					actualProfitCenter);

			if (isWordsPresent) {
				test.log(Status.INFO, "Profit Center [US]: " + actualProfitCenter
						+ "  is derived from Product Segmentation [LSUS]: " + productSegmentationLSUS_Value + "");
				addSrceenShot("Profit Center [US] value verified successfully", test, Capture);
			} else {
				test.log(Status.FAIL, "Profit Center [US]: " + actualProfitCenter
						+ "  is not derived from Product Segmentation [LSUS]: " + productSegmentationLSUS_Value + "");
				addSrceenShot("Profit Center [US] value verification failed", test, Capture);
			}

			// Assert the condition
			Assert.assertTrue(isWordsPresent,
					"No words from Product Segmentation [LSUS] is present in Profit Center [US]!");

		} catch (Exception e) {
			test.log(Status.FAIL, "Verification failed due to exception: " + e.getMessage());
			addSrceenShot("Verification failed", test, Capture);
			throw e;
		}
	}

	private boolean isAnyWordsPresentInProfitCenter_US(String productSegmentation, String profitCenter) {
		String[] words = productSegmentation.split(" ");
		for (String word : words) {
			if (profitCenter.contains(word)) {
				return true;
			}
		}
		return false;
	}

	public void ValidateProfitCenter_EUROPE(String productSegmentationLSE_Value, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(getProfitCenterEUROPE_Value));

			String actualProfitCenter = getProfitCenterEUROPE_Value.getText();

			// Check if any word from Product Segmentation [LSE] is present in Profit
			// Center[EUROPE]
			boolean isWordsPresent = isAnyWordsPresentInProfitCenter_EUROPE(productSegmentationLSE_Value,
					actualProfitCenter);

			if (isWordsPresent) {
				test.log(Status.INFO, "Profit Center [EUROPE]:- " + actualProfitCenter
						+ "  is derived from Product Segmentation [LSE]:- " + productSegmentationLSE_Value + " ");
				addSrceenShot("Profit Center [EUROPE] value verified successfully", test, Capture);
			} else {
				test.log(Status.FAIL, "No words from Product Segmentation [LSUS] is present in Profit Center [US]");
				addSrceenShot("Profit Center [EUROPE] value verification failed", test, Capture);
			}

			// Assert the condition
			Assert.assertTrue(isWordsPresent,
					"No words from Product Segmentation [LSUS] is present in Profit Center [EUROPE]!");

		} catch (Exception e) {
			test.log(Status.FAIL, "Verification failed due to exception: " + e.getMessage());
			addSrceenShot("Verification failed", test, Capture);
			throw e;
		}
	}

	private boolean isAnyWordsPresentInProfitCenter_EUROPE(String productSegmentation, String profitCenter) {
		String[] words = productSegmentation.split(" ");
		for (String word : words) {
			if (profitCenter.contains(word)) {
				return true;
			}
		}
		return false;
	}

	public void enterMandatoryDetails(String rigidIndicatorValue, String productSegmentationLSE_Value,
			String productSegmentationLSUS_Value, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			Thread.sleep(3000);
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(rigidBodyDropDown));
			rigidBodyDropDown.click();

			WebElement optionsContainer2 = driver
					.findElement(By.xpath("//li[text()='" + rigidIndicatorValue.trim() + "']"));
			optionsContainer2.click();

			Thread.sleep(3000);
			new WebDriverWait(driver, 60)
					.until(ExpectedConditions.elementToBeClickable(productSegmentationLSEDropDown));
			productSegmentationLSEDropDown.click();
			Thread.sleep(3000);
			ProductSeg_LSE_TextBox.sendKeys(productSegmentationLSE_Value);
			Thread.sleep(2000);
			ProductSeg_LSE_Selection.click();

			Thread.sleep(3000);
			new WebDriverWait(driver, 60)
					.until(ExpectedConditions.elementToBeClickable(productSegmentationLSUSDropDown));
			Thread.sleep(4000);

			productSegmentationLSUSDropDown.click();
			Thread.sleep(4000);

			ProductSeg_LSUS_TextBox.sendKeys(productSegmentationLSUS_Value);
			Thread.sleep(4000);

			ProductSeg_LSUS_Selection.click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void selectPrintPatternColor(String colorLookType, String printPatternColor, ExtentTest test)
			throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(LookColorLink));
		LookColorLink.click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);
		Thread.sleep(15000);

//		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(ColorLookDropdown));
//		ColorLookDropdown.click();
//		test.log(Status.INFO, "Clicked on Color Look dropdown");
//		addSrceenShot("Clicked on Color Look dropdown", test, Capture);
//
//		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchInput));
//		searchInput.sendKeys(colorLookType);
//		test.log(Status.INFO, "Entered color type: " + colorLookType);
//		addSrceenShot("Entered color type", test, Capture);
//		Thread.sleep(3000);
//
//		WebElement colorType = driver.findElement(By.xpath("//span[contains(text(),'" + colorLookType.trim() + "')]"));
//		colorType.click();
//		Thread.sleep(2000);
//		ColorLookDropdown.click();
//		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(lscoColornameSearchField));
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(nameSearchField));
		System.out.println("name search feild found");
		Thread.sleep(10000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		Thread.sleep(5000);
		nameSearchField.sendKeys(printPatternColor);
		System.out.println("Look ID: " + printPatternColor);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchButton));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
		test.log(Status.INFO, "Clicked on search button");
		addSrceenShot("Clicked on search button again", test, Capture);
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();
		driver.switchTo().window(tabs.get(1));

	}

	public void fillNonMandatoryFields(String targetVolume, String collectionType, String capsule, String materialType,
			String performance, String consumerGroup, String consumerGroupExt1, String consumerGroupExt2,
			String destroySampleInd, String profitCenterAPD, String merchFabricType, String briefCode, ExtentTest test)
			throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);
		// Fill in non-mandatory fields
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(targetVolumeField));
		targetVolumeField.sendKeys(targetVolume);
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(collectionTypeField));
		collectionTypeField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(collectionType);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(capsuleField));
		capsuleField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(capsule);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(materialTypeField));
		materialTypeField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(materialType);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(performanceField));
		performanceField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(performance);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(consumerGroupField));
		consumerGroupField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroup);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(3000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(consumerGroupExt1Field));
		consumerGroupExt1Field.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroupExt1);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(3000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(consumerGroupExt2Field));
		consumerGroupExt2Field.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroupExt2);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(destroySampleIndField));
		destroySampleIndField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(destroySampleInd);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(merchFabricTypeField));
		merchFabricTypeField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(merchFabricType);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(briefCodeField));
		briefCodeField.sendKeys(briefCode);
		Thread.sleep(2000);
		Thread.sleep(2000);

		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(profitCenterAPDField));
			profitCenterAPDField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(profitCenterAPD);
			Thread.sleep(3000);
			filtred_option.click();
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		// Log all fields in one line
		test.log(Status.INFO,
				"Filled Non-Mandatory Fields: Target Volume: " + targetVolume + ", Collection Type: " + collectionType
						+ ", Capsule: " + capsule + ", Material Type: " + materialType + ", Performance: " + performance
						+ ", Consumer Group: " + consumerGroup + ", Consumer Group Ext1: " + consumerGroupExt1
						+ ", Consumer Group Ext2: " + consumerGroupExt2 + ", Destroy Sample Ind: " + destroySampleInd
						+ ", Profit Center APD: " + profitCenterAPD + ", Merch Fabric Type: " + merchFabricType
						+ ", Brief Code: " + briefCode);
		addSrceenShot("Filled Non-Mandatory Fields", test, Capture);

	}

	public void fillNonMandatoryFieldsOfColorwaySeasonPage(String sizeGridCode, String primaryFabric,
			String seasonalDirection, String gtmTrack, String firstDirectiveMonth, String lastSeasonOffered,
			String globalOnFloorIntent, String firstMonthOnFloor, String winAtMarketplaceSoHem,
			String winAtMarketplaceNoHem, String winAtMarketplaceEquatorial, String blpForecast,
			String equityMOQRequest, String earlyDelivery, String lsusStockingCSC, String currentPlannedLifecycle,
			String heroOutfit, String productPricePositioning, String primaryFinishMill, String primaryFinish,
			String fabricMill, String seasonalLook, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);
		// Fill in mandatory fields
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(sizeGridCodeLink));
		sizeGridCodeLink.click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(sizeGridCode);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		driver.switchTo().window(tabs.get(1));
		test.log(Status.INFO, "Selected Size Grid Code: " + sizeGridCode);
		addSrceenShot("Selected Size Grid Code", test, Capture);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primaryFabricLink)).click();
		ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(2));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibrary_frame);
		new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
		Thread.sleep(5000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		MaterailNameInput.sendKeys(primaryFabric);
		js.executeScript("arguments[0].click();", searchButton);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		driver.switchTo().window(tabs1.get(1));
		test.log(Status.INFO, "Selected Primary Fabric: " + primaryFabric);
		addSrceenShot("Selected Primary Fabric", test, Capture);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(seasonalDirectionField));
		seasonalDirectionField.sendKeys(seasonalDirection);
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gtmTrackField));
		gtmTrackField.click();
		Thread.sleep(3000);
		field_searchBox.sendKeys(gtmTrack);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(firstDirectiveMonthField));
		firstDirectiveMonthField.click();
		Thread.sleep(3000);
		field_searchBox.sendKeys(firstDirectiveMonth);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lastSeasonOfferedField));
		lastSeasonOfferedField.click();
		Thread.sleep(3000);
		field_searchBox.sendKeys(lastSeasonOffered);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(globalOnFloorIntentField));
		globalOnFloorIntentField.click();
		Thread.sleep(3000);
		field_searchBox.sendKeys(globalOnFloorIntent);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement earlyDeliveryElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(earlyDeliveryField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", earlyDeliveryElement);
		earlyDeliveryElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(earlyDelivery);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement lsusStockingCSCElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(lsusStockingCSCField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lsusStockingCSCElement);
		lsusStockingCSCElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(lsusStockingCSC);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement currentPlannedLifecycleElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(currentPlannedLifecycleField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				currentPlannedLifecycleElement);
		currentPlannedLifecycleElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(currentPlannedLifecycle);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement heroOutfitElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(heroOutfitField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", heroOutfitElement);
		heroOutfitElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(heroOutfit);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement productPricePositioningElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(productPricePositioningField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				productPricePositioningElement);
		productPricePositioningElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(productPricePositioning);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primaryFinishMillLink)).click();
		ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(2));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibrary_frame);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
		Thread.sleep(5000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		MaterailNameInput.sendKeys(primaryFinishMill);
		js.executeScript("arguments[0].click();", searchButton);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		driver.switchTo().window(tabs2.get(1));
		test.log(Status.INFO, "Selected Primary Finish Mill: " + primaryFinishMill);
		addSrceenShot("Selected Primary Finish Mill", test, Capture);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(primaryFinishLink)).click();
		ArrayList<String> tabs3 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs3.get(2));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibrary_frame);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
		Thread.sleep(5000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		MaterailNameInput.sendKeys(primaryFinish);
		js.executeScript("arguments[0].click();", searchButton);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		driver.switchTo().window(tabs3.get(1));
		test.log(Status.INFO, "Selected Primary Finish: " + primaryFinish);
		addSrceenShot("Selected Primary Finish ", test, Capture);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(fabricMillLink)).click();
		ArrayList<String> tabs4 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs4.get(2));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibrary_frame);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
		Thread.sleep(5000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		MaterailNameInput.sendKeys(fabricMill);
		js.executeScript("arguments[0].click();", searchButton);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		driver.switchTo().window(tabs4.get(1));
		test.log(Status.INFO, "Selected Fabric Mill: " + fabricMill);
		addSrceenShot("Selected Fabric Mill ", test, Capture);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(seasonalLookLink)).click();
		ArrayList<String> tabs5 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs5.get(2));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(MaterailNameInput));
		Thread.sleep(5000);
		clearCriteria.click();
		Thread.sleep(2000);
		resetDefaults.click();
		MaterailNameInput.sendKeys(seasonalLook);
		js.executeScript("arguments[0].click();", searchButton);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);
		driver.switchTo().window(tabs5.get(1));
		test.log(Status.INFO, "Selected Seasonal Look: " + seasonalLook);
		addSrceenShot("Selected Seasonal Look ", test, Capture);

		// Log all fields in one line
		test.log(Status.INFO, "Filled Non-Mandatory Fields of Colorway Season Page: Seasonal Direction: "
				+ seasonalDirection + ", GTM Track: " + gtmTrack + ", First Directive Month: " + firstDirectiveMonth
				+ ", Last Season Offered: " + lastSeasonOffered + ", Global On Floor Intent: " + globalOnFloorIntent
				+ ", First Month On Floor: " + firstMonthOnFloor + ", Win At Marketplace So Hem: "
				+ winAtMarketplaceSoHem + ", Win At Marketplace No Hem: " + winAtMarketplaceNoHem
				+ ", Win At Marketplace Equatorial: " + winAtMarketplaceEquatorial + ", BLP Forecast: " + blpForecast
				+ ", Equity MOQ Request: " + equityMOQRequest + ", Early Delivery: " + earlyDelivery
				+ ", LSUS Stocking CSC: " + lsusStockingCSC + ", Current Planned Lifecycle: " + currentPlannedLifecycle
				+ ", Hero Outfit: " + heroOutfit + ", Product Price Positioning: " + productPricePositioning);
		addSrceenShot("Filled Non-Mandatory Fields of Colorway Season Page", test, Capture);

	}

	@FindBy(xpath = "//span[@id='select2-contextSKUId-container']")
	private WebElement pc9Element;

	public boolean verifyPC9Creation(ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9Element));
		String pc9Element_value = pc9Element.getText();
		test.log(Status.INFO, "PC9 was created successfully: " + pc9Element_value);
		return pc9Element.isDisplayed();
	}

	public boolean verifyNonRequiredAttributes(String collectionType, String seasonalDirection, ExtentTest test)
			throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(pc9Element));

		boolean isCollectionTypeCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Collection Type')]/following-sibling::div")).getText()
				.equals(collectionType);

		boolean isSeasonalDirectionCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Seasonal Direction')]/following-sibling::div")).getText()
				.equals(seasonalDirection);

		return isCollectionTypeCorrect && isSeasonalDirectionCorrect;
	}

	public void select_Color(String colorName, ExtentTest test) throws InterruptedException {

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeMateriallibraryframe);
		Thread.sleep(15000);

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
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();
		driver.switchTo().window(tabs.get(1));

	}
	
	public void selectColor(String colorName, ExtentTest test) throws InterruptedException {
		Thread.sleep(5000);
        switchToWindowByTitle("Chooser:  Color");
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
		Thread.sleep(3000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(choosenFirstColor)).click();
		Thread.sleep(2000);
        switchToWindowByTitle("CreateColorway");

	}

	public void updateNonMandatoryFields(String targetVolume, String collectionType, String capsule,
			String materialType, String performance, String consumerGroup, String consumerGroupExt1,
			String consumerGroupExt2, String destroySampleInd, String profitCenterAPD, String merchFabricType,
			String briefCode, ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(5000);
		// Fill in non-mandatory fields
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(targetVolumeField));
		targetVolumeField.clear();
		targetVolumeField.sendKeys(targetVolume);
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(collectionTypeField));
		collectionTypeField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(collectionType);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement capsuleFieldElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(capsuleField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", capsuleFieldElement);
		capsuleFieldElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(capsule);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement materialTypeFieldElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(materialTypeField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", materialTypeFieldElement);
		materialTypeFieldElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(materialType);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(performanceField));
		performanceField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(performance);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(consumerGroupField));
		consumerGroupField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroup);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(3000);

		WebElement consumerGroupExt1FieldElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(consumerGroupExt1Field));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", materialTypeFieldElement);
		consumerGroupExt1FieldElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroupExt1);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(3000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(consumerGroupExt2Field));
		consumerGroupExt2Field.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(consumerGroupExt2);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(destroySampleIndField));
		destroySampleIndField.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(destroySampleInd);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		WebElement merchFabricTypeFieldElement = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(merchFabricTypeField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchFabricTypeFieldElement);
		merchFabricTypeFieldElement.click();
		Thread.sleep(2000);
		field_searchBox.sendKeys(merchFabricType);
		Thread.sleep(3000);
		filtred_option.click();
		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(briefCodeField));
		briefCodeField.clear();
		briefCodeField.sendKeys(briefCode);
		Thread.sleep(2000);

		try {
			profitCenterAPDField.click();
			Thread.sleep(2000);
			field_searchBox.sendKeys(profitCenterAPD);
			Thread.sleep(3000);
			filtred_option.click();
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		// Log all fields in one line
		test.log(Status.INFO,
				"Updated Non-Mandatory Fields: Target Volume: " + targetVolume + ", Collection Type: " + collectionType
						+ ", Capsule: " + capsule + ", Material Type: " + materialType + ", Performance: " + performance
						+ ", Consumer Group: " + consumerGroup + ", Consumer Group Ext1: " + consumerGroupExt1
						+ ", Consumer Group Ext2: " + consumerGroupExt2 + ", Destroy Sample Ind: " + destroySampleInd
						+ ", Profit Center APD: " + profitCenterAPD + ", Merch Fabric Type: " + merchFabricType
						+ ", Brief Code: " + briefCode);
		addSrceenShot("Updated Non-Mandatory Fields", test, Capture);

	}

	public boolean verifyNonRequiredAttributesUpdated(String targetVolume, String collectionType, String capsule,
			String materialType, String performance, String merchFabricType, String briefCode)
			throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(10000);
		// Add logic to verify non-required attributes
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(pc9Element));

		boolean isTargetVolumeCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Target Volume')]/following-sibling::div")).getText()
				.equals(targetVolume);
		boolean isCollectionTypeCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Collection Type')]/following-sibling::div")).getText()
				.equals(collectionType);
		boolean isCapsuleCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Capsule')]/following-sibling::div")).getText()
				.equals(capsule);
		boolean isMaterialTypeCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Material Type')]/following-sibling::div")).getText()
				.equals(materialType);
		boolean isPerformanceCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Performance')]/following-sibling::div")).getText()
				.equals(performance);
		boolean isMerchFabricTypeCorrect = driver
				.findElement(By.xpath("//div[normalize-space()='Merch Fabric Type']/following-sibling::div")).getText()
				.equals(merchFabricType);
		boolean isBriefCodeCorrect = driver
				.findElement(By.xpath("//div[contains(text(),'Brief Code')]/following-sibling::div")).getText()
				.equals(briefCode);

		return isTargetVolumeCorrect && isCollectionTypeCorrect && isCapsuleCorrect && isMaterialTypeCorrect
				&& isPerformanceCorrect && isMerchFabricTypeCorrect && isBriefCodeCorrect;
	}

	public void editColorWaySeasonPage() throws Exception {

		String ParentWinhadle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(colourwayDropDown));

		driver.findElement(By.xpath("//div[@class='dropdown menu-icon']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Edit Colorway-Season']")).click();
		Thread.sleep(2000);

	}

	public void chooseSizeGridCode(String sizeGridCode, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(sizeGridCodeLink));
		sizeGridCodeLink.click();
		test.log(Status.INFO, "Clicked On size Grid Code Link");
		addSrceenShot("Clicked On size Grid Code Link", test, Capture);

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(nameInput));
		nameInput.sendKeys(sizeGridCode);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(optnSelect));
		js.executeScript("arguments[0].click();", optnSelect);

		driver.switchTo().window(tabs.get(1));
		test.log(Status.INFO, "Selected Size Grid Code: " + sizeGridCode);
		addSrceenShot("Selected Size Grid Code", test, Capture);

	}

	public String getAppliedSizeGridCode(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(sizeGridElement));

		String appliedSizeGridCode = sizeGridElement.getText();

		test.log(Status.INFO, "Applied Size Grid Code: " + appliedSizeGridCode);
		System.out.println("Applied Size Grid Code: " + appliedSizeGridCode);

		return appliedSizeGridCode;
	}

	@FindBy(xpath = "//div[contains(text(),'Size Scale Code')]/following-sibling::div[1]")
	private WebElement getSizeScaleCode;

	@FindBy(xpath = "//div[contains(text(),'Sample Size')]/following-sibling::div[1]")
	private WebElement getSampleSize;

	@FindBy(xpath = "//div[contains(text(),'Selected Sizes')]/following-sibling::div[1]")
	private WebElement getSelectedSizes;

	public void verifyAutoPopulatedValues(String sizeGridCode, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// Retrieve the auto-populated values
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getSizeScaleCode));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getSampleSize));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getSelectedSizes));

		String sizeScaleCode = getSizeScaleCode.getText();
		String sampleSize = getSampleSize.getText();
		String selectedSizes = getSelectedSizes.getText();

		// Log the auto-populated values
		if (sizeScaleCode != null && !sizeScaleCode.isEmpty()) {
			test.log(Status.PASS, "Size Scale Code is populated: " + sizeScaleCode);
		} else {
			test.log(Status.FAIL, "Size Scale Code is not populated.");
		}
		addSrceenShot("Size Scale Code", test, Capture);

		if (sampleSize != null && !sampleSize.isEmpty()) {
			test.log(Status.PASS, "Sample Size is populated: " + sampleSize);
		} else {
			test.log(Status.FAIL, "Sample Size is not populated.");
		}
		addSrceenShot("Sample Size", test, Capture);

		if (selectedSizes != null && !selectedSizes.isEmpty()) {
			test.log(Status.PASS, "Selected Sizes are populated: " + selectedSizes);
		} else {
			test.log(Status.FAIL, "Selected Sizes are not populated.");
		}
		addSrceenShot("Selected Sizes", test, Capture);
	}

	@FindBy(xpath = "//td[@class='PAGEHEADINGTITLE']")
	private WebElement sizeGridDetailsElement;

	@FindBy(xpath = "//td[contains(text(),'Sample Size')]/following-sibling::td[1]")
	private WebElement sampleSize;

	@FindBy(xpath = "//td[contains(text(),'Sizes')]/following-sibling::td[1]")
	private WebElement selectedSizes;

	@FindBy(xpath = "//td[contains(text(),'Size Scale Code')]/following-sibling::td[1]")
	private WebElement sizeScaleCode;

	@FindBy(xpath = "//td[contains(text(),'Size Scale')]/following-sibling::td[1]/a")
	private WebElement sizeScaleLink;

	@FindBy(xpath = "//td[@class='PAGEHEADINGTITLE']")
	private WebElement sizeScaleDetailsElement;

	public void verifySizeGridAttributes(String sizeGridCode, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Retrieve the auto-populated values
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getSizeScaleCode));
		wait.until(ExpectedConditions.visibilityOf(getSampleSize));
		wait.until(ExpectedConditions.visibilityOf(getSelectedSizes));

		String expectedSizeScaleCode = getSizeScaleCode.getText();
		String expectedSampleSize = getSampleSize.getText();
		String expectedSelectedSizes = getSelectedSizes.getText();

		wait.until(ExpectedConditions.visibilityOf(sizeGridElement));
		String appliedSizeGridCode = sizeGridElement.getText();
		sizeGridElement.click();
		test.log(Status.INFO, "Size Grid Value Link Clicked: " + appliedSizeGridCode);

		wait.until(ExpectedConditions.visibilityOf(sizeGridDetailsElement));
		test.log(Status.INFO, "Size Grid Details: " + sizeGridCode + " - page Opened");

		wait.until(ExpectedConditions.visibilityOf(sampleSize));
		String sampleSizeInSizeGrid = sampleSize.getText();
		test.log(Status.INFO, "Sample Size value In The Size Grid: " + sampleSizeInSizeGrid);

		wait.until(ExpectedConditions.visibilityOf(selectedSizes));
		String selectedSizesInSizeGrid = selectedSizes.getText();
		test.log(Status.INFO, "Selected Sizes value In The Size Grid: " + selectedSizesInSizeGrid);

		// Verify and log the sample size
		if (sampleSizeInSizeGrid.equals(expectedSampleSize)) {
			test.log(Status.PASS, "Populated Sample Size is the same in the Size Grid. Populated Sample Size: "
					+ expectedSampleSize + ", Sample Size in Size Grid: " + sampleSizeInSizeGrid);
		} else {
			test.log(Status.FAIL, "Populated Sample Size is not the same in the Size Grid. Populated Sample Size: "
					+ expectedSampleSize + ", Sample Size in Size Grid: " + sampleSizeInSizeGrid);
		}
		addSrceenShot("Sample Size", test, Capture);

		// Verify and log the selected sizes
		if (selectedSizesInSizeGrid.equals(expectedSelectedSizes)) {
			test.log(Status.PASS, "Populated Selected Sizes are the same in the Size Grid. Populated Selected Sizes: "
					+ expectedSelectedSizes + ", Selected Sizes in Size Grid: " + selectedSizesInSizeGrid);
		} else {
			test.log(Status.FAIL,
					"Populated Selected Sizes are not the same in the Size Grid. Populated Selected Sizes: "
							+ expectedSelectedSizes + ", Selected Sizes in Size Grid: " + selectedSizesInSizeGrid);
		}
		addSrceenShot("Selected Sizes", test, Capture);

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(sizeScaleLink));
		sizeScaleLink.click();
		test.log(Status.INFO, "Size Scale Value Clicked: " + appliedSizeGridCode);

		wait.until(ExpectedConditions.visibilityOf(sizeScaleDetailsElement));
		test.log(Status.INFO, "Size Scale Details page Opened");

		wait.until(ExpectedConditions.visibilityOf(sizeScaleCode));
		String sizeScaleCodeInSizeGrid = sizeScaleCode.getText();
		test.log(Status.PASS, "Size Scale Code in the Size Grid: " + sizeScaleCodeInSizeGrid);

		// Verify and log the size scale code
		if (sizeScaleCodeInSizeGrid.equals(expectedSizeScaleCode)) {
			test.log(Status.PASS, "Populated Size Scale Code is the same in the Size Grid. Populated Size Scale Code: "
					+ expectedSizeScaleCode + ", Size Scale Code in Size Grid: " + sizeScaleCodeInSizeGrid);
		} else {
			test.log(Status.FAIL,
					"Populated Size Scale Code is not the same in the Size Grid. Populated Size Scale Code: "
							+ expectedSizeScaleCode + ", Size Scale Code in Size Grid: " + sizeScaleCodeInSizeGrid);
		}
		addSrceenShot("Size Scale Code", test, Capture);
	}

}
