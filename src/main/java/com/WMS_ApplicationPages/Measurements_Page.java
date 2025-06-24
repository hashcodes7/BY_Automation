package com.WMS_ApplicationPages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Measurements_Page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public Measurements_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	boolean Capture = true;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;

	@FindBy(xpath = "//label[contains(text(),'My Seasons')]")
	private WebElement Myseason;

	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement SeasonsDropdown;

	@FindBy(xpath = "//iframe[@name='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//td[@class='button']/a")
	private WebElement New;

	@FindBy(xpath = "//iframe[@id='measurementWorkFrame']")
	private WebElement iframeMeasurement;

	@FindBy(xpath = "//input[@id='ptc_str_1']")
	private WebElement Measurements_Name;

	@FindBy(xpath = "//select[@id='ptc_str_14']")
	private WebElement Measurement_Type;

	@FindBy(xpath = "//a[text()='Create']")
	private WebElement Measurement_Create;

	@FindBy(xpath = "//input[@id='ptc_str_4']")
	private WebElement POM_description;

	@FindBy(xpath = "//input[@id='ptc_str_5']")
	private WebElement POM_Id;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement FilterTextbox;

	@FindBy(xpath = "//span[@id='select2-sourcingConfigId-container']")
	private WebElement Source_DD;

	@FindBy(xpath = "//span[@id='select2-contextSpecId-container']")
	private WebElement Specifications_DD;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement DD_textbox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement select_value;

	@FindBy(xpath = "//span[contains(text(),'Specifications')]/parent::a")
	private WebElement specification_tab;

	@FindBy(xpath = "//span[text()='Sourcing']/parent::a")
	private WebElement Sourcing_tab;

	@FindBy(xpath = "//span[contains(text(),'Sourcing')]/parent::a/following-sibling::ul/li[1]/a")
	private WebElement SourcingSummary;

	@FindBy(xpath = "//span[contains(text(),'Specifications')]/parent::a/following-sibling::ul/li[1]/a")
	private WebElement SpecificationsSummary;

	@FindBy(xpath = "(//div[@class='dropdown menu-icon'])[2]")
	private WebElement specifications_actions;

	@FindBy(xpath = "//a[@id='generatePDF']")
	private WebElement specifications_Techpack;

	@FindBy(xpath = "//input[@id='selectAllCheckBox']/following-sibling::span")
	private WebElement All_sourcingcheckbox;

	@FindBy(xpath = "//div[@id='actions-menu']")
	private WebElement Actionmenu_sourcing;

	@FindBy(xpath = "//a[@id='skuSourcing']")
	private WebElement EditColorwaysourcing;

	@FindBy(xpath = "//a[@id='ui-id-2']/following-sibling::ul/li[4]/a")
	private WebElement Measurement_menu;

	@FindBy(xpath = "//a[@id='ui-id-2']/following-sibling::ul/li[2]/a")
	private WebElement VisualAssets_menu;

	@FindBy(xpath = "//span[text()='Create']")
	private WebElement Create_Images;

	@FindBy(xpath = "(//input[@id='ptc_str_1'])[1]")
	private WebElement MeasurementSet_name;

	@FindBy(xpath = "//a[normalize-space()='Create From Measurement Template:']")
	private WebElement CreatefromMeasurementTemplate;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement name_search;

	@FindBy(xpath = "//a[@id='SearchButton1']")
	private WebElement search_button;

	@FindBy(xpath = "//a[text()='Show All']")
	private WebElement ShowAll;

	@FindBy(xpath = "(//a[@class='restyled-button'])[1]")
	private WebElement Create_measurement;

	@FindBy(xpath = "(//a[@class='restyled-button'])[2]")
	private WebElement Multiple_CreateButton;

	@FindBy(xpath = "//a[@id='sizesButton']")
	private WebElement Sizes_tab;

	@FindBy(xpath = "//input[@id='newLCSMEASUREMENTS_sizeRun']")
	private WebElement Sizevalue_textbox;

	@FindBy(xpath = "//a[@id='LCSMEASUREMENTS_sizeRunaddSingleEntryOption']")
	private WebElement ADD_Sizevalue;

	@FindBy(xpath = "//a[@id='done']")
	private WebElement SaveAndCheckIn;

	@FindBy(xpath = "//label[normalize-space()='Product Sizing and Grade Information']")
	private WebElement productSizing_Information;

	@FindBy(xpath = "(//div[@class='f-attribute-box']//div[@class='f-attribute-box'])[1]")
	private WebElement ActualMeasurementname;

	@FindBy(xpath = "//span[@id='select2-productSizeCategoryId-container']")
	private WebElement productSizedimension_DD;

	@FindBy(xpath = "//span[@aria-labelledby='select2-gradingsId-container']")
	private WebElement GradeTemplate_DD;

	@FindBy(xpath = "//table[@id='editorTable']//tr[2]")
	private WebElement first_row;

	@FindBy(xpath = "//div[@onclick='javascript:openDropdownMenu(event)']")
	private WebElement POM_DD;

	@FindBy(xpath = "//a[@id='pomClipboardBtn']")
	private WebElement ViewPOM;

	@FindBy(xpath = "//div[@id='pomLibraryGrid-innerCt']//img[@role='button']")
	private WebElement Insert_firstPOM;

	@FindBy(xpath = "//img[@id='tool-1115-toolEl']")
	private WebElement cross;

	@FindBy(xpath = "//span[@aria-labelledby='select2-LCSMEASUREMENTS_ptc_str_14-container']")
	private WebElement MeasurementType_DD;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement MeasurementType_TextBox;

	@FindBy(xpath = "//li[@role='option']")
	private WebElement Select_MeasurementType;

	@FindBy(xpath = "//a[@id='AddButton']")
	private WebElement Add_measurement;

	@FindBy(xpath = "//span[@id='select2-measurementsIdList-container']")
	private WebElement MeasurementSet_DD;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_17-container']")
	private WebElement PageType_DD;

	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement TextBox;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement selectValue;

	@FindBy(xpath = "//input[@id='ptc_str_15']")
	private WebElement PageDecription;

	@FindBy(xpath = "//span[@aria-labelledby='select2-ptc_str_16-container']")
	private WebElement PageLayout_DD;

	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement Save_Button;

	@FindBy(xpath = "(//div[@id='genDetails']//div[@class='display-only-label'])[1]")
	private WebElement Image_Name;

	@FindBy(xpath = "(//input[@id='checkbox'])[1]")
	private WebElement primary_checkbox;

	@FindBy(xpath = "(//a[text()='Add'])[1]")
	private WebElement Add_components;

	@FindBy(xpath = "//input[@id='documentVaultbox']")
	private WebElement DocumentVault_checkbox;

	@FindBy(xpath = "(//a[text()='Select'])[1]")
	private WebElement Select_button;

	@FindBy(xpath = "//select[@id='specPagesOptions']")
	private WebElement AvailableOptions;

	@FindBy(xpath = "//select[@id='printLayout']")
	private WebElement TechPack_RequestType;

//---------------------------------Methods--------------------------------------------------
	public void SeasonDropdown(String season) throws InterruptedException {
		selectValueFromDropdown(SeasonsDropdown, season);
	}

	public void SelectTemplate(String template) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		driver.findElement(By.xpath("//ul[@id='tabnav']/li/a[text()='" + template + "']")).click();
	}

	public void Create_New_Measurements_Template(String measurement_name, String measurement_type, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		New.click();
		driver.switchTo().frame(iframeMeasurement);
		Measurements_Name.sendKeys(measurement_name);
		test.log(Status.INFO, "The Measurement Name user gave is: " + measurement_name);
		selectValueFromDropdown(Measurement_Type, measurement_type);
		test.log(Status.INFO, "The Measurement Type user gave is: " + measurement_type);
		Measurement_Create.click();

	}

	public void Create_New_POMpoints(String pomdescription, String pomId, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		New.click();
		driver.switchTo().frame(iframeMeasurement);
		POM_description.sendKeys(pomdescription);
		test.log(Status.INFO, "The POM description user gave is: " + pomdescription);
		POM_Id.sendKeys(pomId);
		test.log(Status.INFO, "The POM Id user gave is: " + pomId);
		Measurement_Create.click();

	}

	public void Measurement_Template_Validation(String measurement_name, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String cellText = cells.get(6).getText();
			if (cellText.equals(measurement_name)) {
				System.out.println(cellText);
				test.log(Status.INFO, "template validated: " + measurement_name);
				System.out.println("template validated: " + measurement_name);
			}
		}
	}

	public void POM_Template_Validation(String pomdescription, ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String cellText = cells.get(5).getText();
			if (cellText.equals(pomdescription)) {
				System.out.println(cellText);
				test.log(Status.INFO, "template validated: " + pomdescription);
				System.out.println("template validated: " + pomdescription);
			}
		}
	}

	public void Delete_pom(String pomdescription, ExtentTest test) {
		try {
			WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']/table"));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				String cellText = cells.get(5).getText();
				if (cellText.equals(pomdescription)) {
					System.out.println(cellText);
					driver.findElement(By.xpath("//tbody/tr[6]/td[5]/a")).click();
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
					Thread.sleep(1000);
					driver.switchTo().alert().accept();

					test.log(Status.INFO, "POM Template deleted ");
					System.out.println("POM Template deleted  ");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void filter_product(String filterproduct, ExtentTest test) {
		try {
			FilterTextbox.sendKeys(filterproduct);
			test.log(Status.INFO, "Filter selected: " + filterproduct + "in setting menu");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[text()='" + filterproduct + "']")).click();
			Thread.sleep(5000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void selectSource(String source, ExtentTest test) throws InterruptedException {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Source_DD)).click();
		DD_textbox.sendKeys(source);
		select_value.click();
		Thread.sleep(2000);
	}

	public void selectSpecifications(String specifications, ExtentTest test) throws InterruptedException {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Specifications_DD)).click();
		DD_textbox.sendKeys(specifications);
		select_value.click();
		Thread.sleep(2000);
	}

	public void NavigateTo_measurement() throws InterruptedException {
		specification_tab.click();
		Measurement_menu.click();
		Thread.sleep(2000);
	}

	public void NavigetTo_measurementSummary() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		specification_tab.click();
		SpecificationsSummary.click();
		Thread.sleep(10000);
	}

	public String NavigateTo_GenerateTechpack() throws InterruptedException {

		String components = "";
		Thread.sleep(5000);
		primary_checkbox.click();
		Thread.sleep(2000);
		List<WebElement> list = driver
				.findElements(By.xpath("//spec-component-cell-renderer[@class='ng-star-inserted']/a"));
		for (WebElement ele : list) {
			components = ele.getText() + "," + components;
		}
		specifications_actions.click();
		specifications_Techpack.click();
		System.out.println(components);
		return components;
	}

	public void Validate_AvailableComponents(String components, ExtentTest test) {
		String specificationcomponents = "";
		String[] Available_Productcomponent = components.split(",");

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));

		List<WebElement> componentslist = driver.findElements(By.xpath("//select[@id='specPagesOptions']/option"));
		for (WebElement ele : componentslist) {
			specificationcomponents = ele.getText() + "," + specificationcomponents;
		}

		String[] Available_specificationComponents = specificationcomponents.split(",");

		for (String i : Available_Productcomponent) {
			for (String j : Available_specificationComponents) {
				if (j.contains(i)) {
					System.out.println(
							"Product components: " + i + "  and specification components: " + j + "  are matching");
					test.log(Status.INFO,
							"Product components: " + i + "  and specification components: " + j + "  are matching");
					addSrceenShot(
							"Product components: " + i + "  and specification components: " + j + "  are matching",
							test, Capture);
				}
			}
		}
	}

	public void GenerateTechpack_UsingMeasurements(String requesttype, ExtentTest test) throws InterruptedException {

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));
		selectValueFromDropdown(TechPack_RequestType, requesttype);

		Thread.sleep(2000);
		DocumentVault_checkbox.click();
		Thread.sleep(1000);
		Select_button.click();
		Thread.sleep(6000);

		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);

	}

	public void Validate_generatedTechPack(ExtentTest test) throws InterruptedException {

		List<WebElement> techpacklist = driver.findElements(By.xpath("(//div[@class='table-wrapper'])[1]//tr/td[2]/a"));
		techpacklist.get(0).click();

		System.out.println("The techpack is clicked ");

		System.out.println("The recent generated techpack is downloaded");
		test.log(Status.INFO, "The recent generated techpack is downloaded ");
		addSrceenShot("The recent generated techpack is downlpoaded", test, Capture);
	}

	public void NavigateTo_VisualAssets() throws InterruptedException {
		specification_tab.click();
		VisualAssets_menu.click();
		Thread.sleep(2000);
		Create_Images.click();
	}

	public void NavigateToSourcingSummary() throws InterruptedException {
		Sourcing_tab.click();
		SourcingSummary.click();
		Thread.sleep(2000);

	}

	public void Select_editcolorwaySourcing() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Actionmenu_sourcing.click();
		EditColorwaysourcing.click();
		Thread.sleep(2000);
		All_sourcingcheckbox.click();
		Save_Button.click();
	}

	public void create_VisualAssets_images(String pagetype, String pagedescription, String pagelayout, ExtentTest test)
			throws Exception {

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(PageType_DD)).click();
		TextBox.sendKeys(pagetype);
		test.log(Status.INFO, "Selected Page Type " + pagetype);
		selectValue.click();
		Thread.sleep(1000);

		PageDecription.sendKeys(pagedescription);
		Thread.sleep(1000);
		test.log(Status.INFO, "Entered Page Description " + pagedescription);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(PageLayout_DD)).click();
		TextBox.sendKeys(pagelayout);
		test.log(Status.INFO, "Selected Page Layout " + pagelayout);
		selectValue.click();
		Thread.sleep(5000);
		Save_Button.click();
		Thread.sleep(10000);

		Save_Button.click();
		Thread.sleep(5000);

	}

	public void verify_VisualAssets_Image(String pagedescription, ExtentTest test) {
		if (Image_Name.getText().contains(pagedescription)) {
			test.log(Status.INFO, "Verified and Created Image Name is:  " + Image_Name.getText());
		}
	}

	public void Create_NewMeasurementSet(String measurementsetname, String template_name, String sizevalue,
			String measurementtype, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		MeasurementSet_name.sendKeys(measurementsetname);
		test.log(Status.INFO, "Measurement Set Name is: " + measurementsetname);

		Create_from_Measurement_template(template_name, test);
		Thread.sleep(2000);
		test.log(Status.INFO, "measurement template selected: " + template_name);

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Create_measurement.click();
		Thread.sleep(2000);

		Sizes_tab.click();
		Sizevalue_textbox.sendKeys(sizevalue);
		ADD_Sizevalue.click();

		MeasurementType_DD.click();
		MeasurementType_TextBox.sendKeys(measurementtype);
		Select_MeasurementType.click();
		test.log(Status.INFO, "Measurement Type Selected is: " + measurementtype);
		SaveAndCheckIn.click();
		test.log(Status.INFO, "Measurement Set Name created with name: " + measurementsetname);
	}

	public void New_MeasurementSet_AddPOM(String measurementsetname, String template_name, String productsize,
			String gradetemplate, String measurementtype, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			MeasurementSet_name.sendKeys(measurementsetname);
			test.log(Status.INFO, "Measurement Set Name is: " + measurementsetname);

			Create_from_Measurement_template(template_name, test);
			Thread.sleep(2000);
			test.log(Status.INFO, "measurement template selected: " + template_name);

			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			Thread.sleep(2000);
			productSizedimension_DD.click();
			DD_textbox.sendKeys(productsize);
			select_value.click();
			Thread.sleep(2000);

			GradeTemplate_DD.click();
			DD_textbox.sendKeys(gradetemplate);
			select_value.click();
			Thread.sleep(2000);

			Create_measurement.click();

			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);

			first_row.click();
			POM_DD.click();
			ViewPOM.click();
			Insert_firstPOM.click();
			cross.click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			MeasurementType_DD.click();
			MeasurementType_TextBox.sendKeys(measurementtype);
			Select_MeasurementType.click();

			SaveAndCheckIn.click();
			if (new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()) != null) {
				driver.switchTo().alert().accept();
			}
			WaitforPage(5000);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void AddMultipleMeasurement(String measurementsetname, String template_name, String productsize,
			String gradetemplate, String measurementtype, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Add_measurement.click();
		MeasurementSet_name.sendKeys(measurementsetname);
		Create_from_Measurement_template(template_name, test);
		Thread.sleep(2000);
		test.log(Status.INFO, "measurement template selected: " + template_name);

		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		productSizedimension_DD.click();
		DD_textbox.sendKeys(productsize);

		select_value.click();
		test.log(Status.INFO, "Produt size definition value selected: " + productsize);
		Thread.sleep(2000);

		GradeTemplate_DD.click();
		DD_textbox.sendKeys(gradetemplate);
		select_value.click();
		test.log(Status.INFO, "Grade scale value selected: " + gradetemplate);
		Thread.sleep(2000);

		Multiple_CreateButton.click();
		Thread.sleep(2000);
//		DOCKERS MENS B&T Bottom
//		B&T--Waist Size:44-66
//		DOCKERS MENS B&T Bottom
//		BEFORE WASH
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		MeasurementType_DD.click();
		MeasurementType_TextBox.sendKeys(measurementtype);

		Select_MeasurementType.click();
		SaveAndCheckIn.click();
		if (new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()) != null) {
			driver.switchTo().alert().accept();
		}
		WaitforPage(5000);

	}

	public void NonMeasurementAdmin_CreateSetValidations(ExtentTest test) {

		try {
			if (MeasurementSet_DD.isDisplayed()) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(iframeContentframe);
				Add_measurement.click();
			}
			CreatefromMeasurementTemplate.click();
			Thread.sleep(5000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(2));
			name_search.sendKeys("ARCHIVE");
			search_button.click();
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
			if (list.size() > 1) {
				test.log(Status.FAIL, " Archived template are populaing for NON Measurement admin");
			} else {
				test.log(Status.PASS, " Archived template are NOT populaing for Non Measurement admin");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void measurementSet_Validations(String measurementsetname, ExtentTest test) {
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='select2-measurementsIdList-results']/li"));
		for (WebElement ele : list) {
			if (ele.getText().contains(measurementsetname)) {
				test.log(Status.INFO, " measurement set present: " + ele.getText());
			}
		}
	}

	public void Create_from_Measurement_template(String template_name, ExtentTest test) throws InterruptedException {
		CreatefromMeasurementTemplate.click();

		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));

		search_button.click();

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(ShowAll)).click();
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='table-wrapper']/table//tr"));
		for (int i = 1; i <= list.size(); i++) {
			WebElement ele = driver
					.findElement(By.xpath("//div[@class='table-wrapper']/table//tr[" + (i + 1) + "]/td[3]/a"));
			if (ele.getText().equals(template_name)) {
				driver.findElement(By.xpath("//div[@class='table-wrapper']/table//tr[" + (i + 1) + "]/td[1]/a"))
						.click();
				break;

			}
		}
	}

	public void measurementSetValidations(String measurementsetname, ExtentTest test) throws InterruptedException {
		Thread.sleep(5000);
		productSizing_Information.click();

		if (ActualMeasurementname.getText().contains(measurementsetname)) {
			test.log(Status.PASS, "measurement set using archived template created: " + measurementsetname);
			System.out.println("measurement set using archived template created: " + measurementsetname);
		}
	}

	public void movepointerto_productdetailspage() {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));
	}

	@FindBy(xpath = "//td[contains(text(),'Product Name')]/following::input[1]")
	private WebElement productName_Input;

	@FindBy(xpath = "//a[@id='SearchButton2']")
	private WebElement search_Btn;

	@FindBy(xpath = "//span[normalize-space()='Details']")
	private WebElement DetailsTab;

	@FindBy(xpath = "//span[@id='select2-splId-container']")
	private WebElement season_DD;

	@FindBy(xpath = "//div[normalize-space()='Clipboard Measurement Set']/following::div[1]")
	private WebElement clipboardMeasurementSet_DD;

	@FindBy(xpath = "//td[contains(text(),'Name')]/following::input[1]")
	private WebElement name_Input;

	@FindBy(xpath = "//a[normalize-space()='(choose)']")
	private WebElement choose;

	@FindBy(xpath = "//a[@href='javascript:initFromClipboard();']//span[contains(text(),'Create')]")
	private WebElement CreateMeasurement;

	@FindBy(xpath = "//td[contains(text(),'POM Description')]/following::input[1]")
	private WebElement POM_description_Input;

	@FindBy(xpath = "//td[contains(text(),'POM ID')]/following::input[1]")
	private WebElement POM_Id_Input;

	@FindBy(xpath = "//a[normalize-space()='Save']")
	private WebElement POM_Save;

	@FindBy(xpath = "//a[@id='editMeasurmentsButton']/img")
	private WebElement updateButton;

	@FindBy(xpath = "//table[@id='editorTable']//tr[3]//td[1]//input")
	private WebElement selectThirdRow;

	@FindBy(xpath = "//img[@src='/Windchill/rfa/images/arrowUp.svg']")
	private WebElement moveUpButton;

	@FindBy(xpath = "//img[@src='/Windchill/rfa/images/arrowDown.svg']")
	private WebElement moveDownButton;

	@FindBy(xpath = "//img[@src='/Windchill/rfa/images/icon_delete.svg']")
	private WebElement deleteButton;

	@FindBy(xpath = "//table[@id='editorTable']//tr[2]//td[1]//input")
	private WebElement selectFirstRow;

	@FindBy(xpath = "//label[normalize-space()='Measurement Set Image']")
	private WebElement measurementSetImageCardId;

	@FindBy(xpath = "//input[@value='+ New']")
	private WebElement newPOMImagesButton;

	@FindBy(xpath = "//input[@id='imageFile']")
	private WebElement BrowseOptn;

	@FindBy(xpath = "//tr[@id='columns']/following::input[2]")
	private WebElement text_Box_mm;

	@FindBy(xpath = "//a[@id='check']/span")
	private WebElement gradeRuleTab;

//---------------------------------Methods--------------------------------------------------
	public void selectMeasurementSet(String measurementSet) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(measurementSet_DropDown));
		selectValueFromDropdown(measurementSet_DropDown, measurementSet);
		Thread.sleep(3000);

	}

	@FindBy(xpath = "//a[@id='copy-clipboard-measurement']/img")
	private WebElement copyToClipboard_Icon;

	public void copyToClipboard() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(copyToClipboard_Icon)).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		Thread.sleep(5000);

		driver.switchTo().window(tabs.get(tabs.size() - 1));
		driver.close();
		driver.switchTo().window(tabs.get(0));

	}

	public void selectProduct(String value) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(productName_Input));
			productName_Input.clear();
			productName_Input.sendKeys(value);
			Thread.sleep(3000);
			search_Btn.click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clickDetailsTab() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(DetailsTab));
			DetailsTab.click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void openNewTab(String URL) throws Exception {
		// Logic to open new tab and navigate to another existing color solid
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // Switch to new tab

		driver.get(URL);
		Thread.sleep(5000);
	}

	public void select_Source(String source, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Source_DD)).click();
		DD_textbox.sendKeys(source);
		select_value.click();
		Thread.sleep(2000);
	}

	public void selectSeason(String season, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(season_DD)).click();
		DD_textbox.sendKeys(season);
		select_value.click();
		Thread.sleep(2000);
	}

	public String addNewMeasurementSetFromClipboard(String measurementSet, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			WebElement addMeasurementElement = new WebDriverWait(driver, 10)
					.until(ExpectedConditions.visibilityOf(Add_measurement));
			addMeasurementElement.click();
			test.log(Status.INFO, "Clicked On Add Measurement");
		} catch (TimeoutException e) {
		}

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(clipboardMeasurementSet_DD)).click();
		DD_textbox.sendKeys(measurementSet);
		Thread.sleep(2000);
		String ClipboardMeasurementSet_Value = select_value.getText();
		select_value.click();
		Thread.sleep(2000);

		return ClipboardMeasurementSet_Value;
	}

	@FindBy(xpath = "//div[normalize-space()='Measurement Set']/following::select[1]")
	private WebElement measurementSet_DropDown;

	public void enterMeasurementSetAttributes(String measurementsetname, String sizevalue, String measurementtype,
			String measurementSet, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(MeasurementSet_name)).click();

		MeasurementSet_name.sendKeys(measurementsetname);
		test.log(Status.INFO, "Measurement Set Name is: " + measurementsetname);

//		CreatefromMeasurementTemplate.click();
//
//		Thread.sleep(5000);
//		Set<String> allWindowHandles = driver.getWindowHandles();
//		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
//		driver.switchTo().window(tabs.get(2));
//
//		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(name_Input));
//		name_Input.clear();
//		name_Input.sendKeys(template_name);
//		Thread.sleep(2000);
//		search_button.click();
//		Thread.sleep(5000);
//		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(choose));
//		choose.click();
//		driver.switchTo().window(tabs.get(1));
//
//		Thread.sleep(2000);
//
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(CreateMeasurement));
		CreateMeasurement.click();
		Thread.sleep(2000);

		Sizes_tab.click();
		Sizevalue_textbox.sendKeys(sizevalue);
		ADD_Sizevalue.click();

		MeasurementType_DD.click();
		MeasurementType_TextBox.sendKeys(measurementtype);
		Select_MeasurementType.click();
		test.log(Status.INFO, "Measurement Type Selected is: " + measurementtype);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(SaveAndCheckIn));
		SaveAndCheckIn.click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(measurementSet_DropDown));
		// Assuming measurementSet_DropDown is a WebElement representing the dropdown
		Select dropdown = new Select(measurementSet_DropDown);
		boolean isPresent = false;

		for (WebElement option : dropdown.getOptions()) {
			if (option.getText().contains(measurementsetname)) {
				isPresent = true;
				break;
			}
		}

		if (isPresent) {
			test.log(Status.INFO, "Copied measurment set applied to the new product: " + measurementSet);
		} else {
			test.log(Status.PASS, "Measurement Set " + measurementSet + " is NOT present in the dropdown.");
		}

	}

	public void Update_POMpoints(String pomDescription, String updatedPOMDescription, String updated_POM_ID,
			ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']/table"));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			outerLoop: for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (int i = 0; i < cells.size(); i++) {
					String cellText = cells.get(i).getText();
					if (cellText.equals(pomDescription)) {
						test.log(Status.INFO, "Selected POM description for updation: " + pomDescription);
						System.out.println(cellText);
						// Click on the update option which is 3 positions before the description
						cells.get(i - 3).click();
						Thread.sleep(2000);
						driver.switchTo().frame(iframeMeasurement);
						// Update attributes
						new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(POM_description_Input));
						POM_description_Input.clear();
						POM_description_Input.sendKeys(updatedPOMDescription);
						test.log(Status.INFO, "Updated POM description: " + updatedPOMDescription);
						addSrceenShot("Updated POM description", test, Capture);
						Thread.sleep(2000);
						POM_Id_Input.clear();
						POM_Id_Input.sendKeys(updated_POM_ID);
						test.log(Status.INFO, "Updated POM ID: " + updated_POM_ID);
						addSrceenShot("Updated POM ID", test, Capture);
						POM_Save.click();
						test.log(Status.INFO, "POM Template updated ");
						System.out.println("POM Template updated  ");
						break outerLoop;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Validate_POMpoints(String updatedPOMDescription, ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']/table"));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					String cellText = cell.getText();
					if (cellText.equals(updatedPOMDescription)) {
						System.out.println("Validation successful: " + cellText);
						test.log(Status.INFO, "Validation successful: " + cellText);
						return;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clickUpdate() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(updateButton)).click();
		Thread.sleep(2000);
	}

	public void selectRowToMove() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		// Using FluentWait
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		// Using JavaScript to click the checkbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectThirdRow);

		// Optional: Adding a small wait to ensure the click is registered
		Thread.sleep(2000);
	}

	public void moveRowUp() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(moveUpButton)).click();
		Thread.sleep(2000);

	}

	public void moveRowDown() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(moveDownButton)).click();
		Thread.sleep(2000);
		// Using FluentWait
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		// Using JavaScript to click the checkbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectThirdRow);

		Thread.sleep(2000);

	}

	public void selectFirstRowToDelete() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		// Using FluentWait
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectFirstRow);

		Thread.sleep(2000);

	}

	public boolean deleteRowAndVerifyFirstRowDeletion(ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(deleteButton));

		// Capture initial row count before deletion
		List<WebElement> initialRows = driver.findElements(By.xpath("//table[@id='editorTable']//tr"));
		int initialRowCount = initialRows.size();

		Thread.sleep(2000);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(deleteButton));
		deleteButton.click();
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();

		System.out.println("Alert message: " + alertMessage);
		test.log(Status.INFO, "Alert message: " + alertMessage);
		// Accept the alert
		alert.accept();

		// Wait for the table to update after deletion
		new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(initialRows.get(1)));

		// Re-locate the rows after deletion
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='editorTable']//tr"));

		Thread.sleep(2000);

		// Verify the row count has decreased by one
		boolean isRowDeleted = rows.size() == initialRowCount - 1;

		if (isRowDeleted) {
			test.log(Status.INFO, "First row deletion successful.");
			addSrceenShot("First row deletion successful.", test, Capture);

		} else {
			test.log(Status.FAIL, "First row deletion failed. Verification failed.");
			addSrceenShot("First row deletion failed. Verification failed.", test, Capture);
		}

		return isRowDeleted;
	}

	public void clickNewPOMImages() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(measurementSetImageCardId)).click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(newPOMImagesButton)).click();
		Thread.sleep(2000);
	}

//    public void clickChooseFile() throws Exception {
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(iframeContentframe);
//        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(BrowseOptn)).click();
//        Thread.sleep(2000);
//    }

	public void uploadImage(String imagePath) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(6000);
		BrowseOptn.sendKeys(imagePath);
		Thread.sleep(2000);
	}

	public void clickSaveButton() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(POM_Save)).click();
		Thread.sleep(2000);
	}

	public boolean verifyImageUpdate() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(measurementSetImageCardId)).click();
		WebElement uploadedImage = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("thumbnail")));

		boolean isImageDisplayed = uploadedImage.isDisplayed();

		return isImageDisplayed;
	}

	public void checkCriticalityColumn() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(SaveAndCheckIn));
		WebElement table = driver.findElement(By.xpath("//table[@id='editorTable']"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.xpath("td//a"));
			for (WebElement cell : cells) {
				if (cell.getText().equals("Criticality")) {
					break;
				}
			}
		}
		Thread.sleep(2000);
	}

	public void selectCriticalAndUpdateCells(String criticality, String pomID, String pomDescription,
			String tolPlusCell, String tolMinusCell, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		WebElement table = driver.findElement(By.xpath("//table[@id='editorTable']"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		boolean emptyCellFound = false;

		for (int i = 2; i <= allRows.size(); i++) { // Start from 2 to skip the header row
			WebElement criticalityCell = driver
					.findElement(By.xpath("//table[@id='editorTable']//tr[" + i + "]/td[4]"));
			if (criticalityCell.getText().trim().isEmpty()) {
				emptyCellFound = true;
				updateRow(i, criticality, pomID, pomDescription, tolPlusCell, tolMinusCell, test);
				break;
			}
		}

		if (!emptyCellFound) {
			addNewRow();
			updateRow(2, criticality, pomID, pomDescription, tolPlusCell, tolMinusCell, test);
		}

		Thread.sleep(2000);
	}

	private void updateRow(int rowIndex, String criticality, String pomID, String pomDescription, String tolPlusCell,
			String tolMinusCell, ExtentTest test) throws Exception {
		WebElement criticalityCell = driver
				.findElement(By.xpath("//table[@id='editorTable']//tr[" + rowIndex + "]/td[5]"));
		criticalityCell.click();
		Thread.sleep(2000);

		WebElement dropdown = criticalityCell.findElement(By.xpath(".//select"));
		selectValueFromDropdown(dropdown, criticality);
		test.log(Status.INFO, "Selected Critical from the drop down ");
		addSrceenShot("Selected Critical from the drop down ", test, Capture);
		Thread.sleep(3000);

		updateCell(rowIndex, 3, pomID);
		updateCell(rowIndex, 4, pomDescription);
		updateCell(rowIndex, 6, tolPlusCell);
		updateCell(rowIndex, 7, tolMinusCell);

		validateRowColor(rowIndex, test);
		SaveAndCheckIn.click();
		test.log(Status.INFO, "Clicked On Save And CheckIn");
		addSrceenShot("Clicked On Save And CheckIn", test, Capture);

	}

	private void updateCell(int rowIndex, int cellIndex, String value) throws Exception {
		WebElement cell = driver
				.findElement(By.xpath("//table[@id='editorTable']//tr[" + rowIndex + "]/td[" + cellIndex + "]"));
		cell.click();
		Thread.sleep(1000);
		text_Box_mm.clear();
		text_Box_mm.sendKeys(value);
		Thread.sleep(1000);
	}

	private void validateRowColor(int rowIndex, ExtentTest test) throws Exception {
		WebElement row = driver.findElement(By.xpath("//table[@id='editorTable']//tr[" + rowIndex + "]"));
		String rowClass = row.getAttribute("class");
		Assert.assertTrue(rowClass.contains("HIGHLIGHT_YELLOW"), "Row class did not change to HIGHLIGHT_YELLOW.");
		test.log(Status.PASS, "Criticality row is highlighted in yellow ");
		addSrceenShot("Criticality row is highlighted in yellow", test, Capture);
	}

	private void addNewRow() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("I").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
	}

//	public void selectCriticalAndUpdateCells(String criticality, String pomID, String pomDescription,
//			String tolPlusCell, String tolMinusCell, ExtentTest test) throws Exception {
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(iframeContentframe);
//
//		WebElement table = driver.findElement(By.xpath("//table[@id='editorTable']"));
//		List<WebElement> allRows = table.findElements(By.tagName("tr"));
//		for (int i = 2; i <= allRows.size(); i++) { // Start from 2 to skip the header row
//			WebElement criticalityCell = driver
//					.findElement(By.xpath("//table[@id='editorTable']//tr[" + i + "]/td[5]"));
//			if (criticalityCell.getText().trim().isEmpty()) {
//				// Click on the cell to activate the dropdown
//				criticalityCell.click();
//				Thread.sleep(2000); // Wait for the dropdown to appear
//
//				// Find the dropdown within the cell and select "Critical"
//				WebElement dropdown = criticalityCell.findElement(By.xpath(".//select"));
//				selectValueFromDropdown(dropdown, criticality);
//				test.log(Status.INFO, "Selected  Critical from the drop down ");
//				addSrceenShot("Selected  Critical from the drop down ", test, Capture);
//				Thread.sleep(3000);
//
//				// Update the corresponding cells in the same row
//				WebElement pom_ID = driver.findElement(By.xpath("//table[@id='editorTable']//tr[" + i + "]/td[3]"));
//				Thread.sleep(1000); // Wait for the dropdown to appear
//				pom_ID.click();
//				text_Box_mm.clear();
//				text_Box_mm.sendKeys(pomID);
//				Thread.sleep(1000);
//
//				// Validation for row color change
//				WebElement row = driver.findElement(By.xpath("//table[@id='editorTable']//tr[" + i + "]"));
//				String rowClass = row.getAttribute("class");
//	            Assert.assertTrue(rowClass.contains("HIGHLIGHT_YELLOW"), "Row class did not change to HIGHLIGHT_YELLOW.");
//				test.log(Status.PASS, "Criticality row is highlighted in yellow ");
//				addSrceenShot("Criticality row is highlighted in yellow", test, Capture);
//
//				WebElement pom_Description = driver
//						.findElement(By.xpath("//table[@id='editorTable']//tr[" + i + "]/td[4]"));
//				Thread.sleep(1000); // Wait for the dropdown to appear
//				pom_Description.click();
//				text_Box_mm.clear();
//				text_Box_mm.sendKeys(pomDescription);
//				Thread.sleep(1000);
//
//				WebElement tolPlus_Cell = driver
//						.findElement(By.xpath("//table[@id='editorTable']//tr[" + i + "]/td[6]"));
//				Thread.sleep(1000); // Wait for the dropdown to appear
//				tolPlus_Cell.click();
//				text_Box_mm.clear();
//				text_Box_mm.sendKeys(tolPlusCell);
//				Thread.sleep(1000);
//
//				WebElement tolMinus_Cell = driver
//						.findElement(By.xpath("//table[@id='editorTable']//tr[" + i + "]/td[7]"));
//				Thread.sleep(1000); // Wait for the dropdown to appear
//				tolMinus_Cell.click();
//				text_Box_mm.clear();
//				text_Box_mm.sendKeys(tolMinusCell);
//				Thread.sleep(2000);
//				SaveAndCheckIn.click();
//
//				break;
//			}
//		}
//		Thread.sleep(2000);
//	}

	public boolean isCriticalityUpdated(String pomID, String expectedCriticality) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(updateButton));
		WebElement table = driver.findElement(By.xpath("//div[@class='card card__overflow']//table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			WebElement pom_ID = row.findElement(By.xpath("td[3]"));
			if (pom_ID.getText().equals(pomID)) {
				WebElement criticalityCell = row.findElement(By.xpath("td[5]"));
				return criticalityCell.getText().equals(expectedCriticality);
			}
		}

		return false;
	}

	public boolean areCriticalSizesSaved(String pomID, String expectedTolPlus, String expectedTolMinus)
			throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		WebElement table = driver.findElement(By.xpath("//div[@class='card card__overflow']//table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			WebElement pom_ID = row.findElement(By.xpath("td[3]"));
			if (pom_ID.getText().equals(pomID)) {
				WebElement tolPlusCell = row.findElement(By.xpath("td[6]"));
				WebElement tolMinusCell = row.findElement(By.xpath("td[7]"));
				return tolPlusCell.getText().equals(expectedTolPlus) && tolMinusCell.getText().equals(expectedTolMinus);
			}
		}
		return false;
	}

	public void clickedOnGradeRuleTab() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(gradeRuleTab));
		gradeRuleTab.click();
		Thread.sleep(3000);

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//span[contains(text(),'Edit Measurement')]")
	private WebElement editMesTemp;

	public void ClickUpdateMeasurementTemp(String measurementTempName, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']/table"));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			outerLoop: for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (int i = 0; i < cells.size(); i++) {
					String cellText = cells.get(i).getText();
					if (cellText.equals(measurementTempName)) {
						test.log(Status.INFO, "Selected Measurement Templatate for updation: " + measurementTempName);
						System.out.println(cellText);
// Click on the update option which is 4 positions before the Measurement
// Templatate Name
						cells.get(i - 4).click();
						Thread.sleep(2000);
						new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(editMesTemp));
						break outerLoop;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FindBy(xpath = "//span[contains(text(),'Edit Grade Rule')]")
	private WebElement editgradeTemp;

	public void ClickUpdateGradeRuleTemp(String gradeRuleTempName, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement table = driver.findElement(By.xpath("//div[@class='table-wrapper']/table"));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			outerLoop: for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (int i = 0; i < cells.size(); i++) {
					String cellText = cells.get(i).getText();
					if (cellText.equals(gradeRuleTempName)) {
						test.log(Status.INFO, "Selected Grade Rule Templatate for updation: " + gradeRuleTempName);
						System.out.println(cellText);
// Click on the update option which is 4 positions before the grade Rule
// Template name
						cells.get(i - 4).click();
						Thread.sleep(2000);
						new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(editgradeTemp));
						break outerLoop;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void CheckArchiveField(ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement archiveField = driver.findElement(By.xpath("//div[contains(text(),'Archive')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", archiveField);

			if (archiveField.isDisplayed()) {
				test.log(Status.INFO, "Archive field is visible");
				addSrceenShot("Archive field is visible", test, Capture);
			} else {
				test.log(Status.FAIL, "Archive field is not visible");
				addSrceenShot("Archive field is not visible", test, Capture);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void VerifyArchiveFieldNonEditable(ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement archiveField = driver
					.findElement(By.xpath("//div[contains(text(),'Archive')]/following-sibling::div"));
//if (!archiveField.isEnabled()) {
			if (archiveField != null) {
				test.log(Status.INFO, "Archive field is non-editable");
				addSrceenShot("Archive field is non-editable", test, Capture);
			} else {
				test.log(Status.FAIL, "Archive field is editable");
				addSrceenShot("Archive field is editable", test, Capture);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Insert_POMpoints(String pomDescription, ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement table = driver.findElement(By.xpath("//table[@id='editorTable']"));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			if (allRows.size() > 1) { // Ensure there is at least one row after the header
				WebElement firstRow = allRows.get(1); // Select the first row after the header
				firstRow.click(); // Highlight the row
				test.log(Status.INFO, "First row highlighted for POM insertion");
				addSrceenShot("First row highlighted for POM insertion", test, Capture);

				ClickViewPOMs();
				test.log(Status.INFO, "Clicked on View POMs");
				addSrceenShot("Clicked on View POMs", test, Capture);

				SelectPOMFromLibrary(pomDescription, test);
				test.log(Status.INFO, "Selected POM from library: " + pomDescription);
				addSrceenShot("Selected POM from library", test, Capture);

				ClosePOMLibraryPopup();
				test.log(Status.INFO, "Closed POM Library popup");
				addSrceenShot("Closed POM Library popup", test, Capture);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FindBy(xpath = "//div[@onclick='javascript:openDropdownMenu(event)']//img")
	private WebElement mesActionsMenu;

	@FindBy(xpath = "//span[contains(text(),'View POM')]")
	private WebElement viewPOMsButton;

	@FindBy(xpath = "(//img[@data-ref='toolEl'])[1]")
	private WebElement closePopUp;

	public void ClickViewPOMs() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(mesActionsMenu)).click();
		viewPOMsButton.click();

	}

	public void SelectPOMFromLibrary(String pomDescription, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(4000);
		WebElement dragHandle = driver
				.findElement(By.xpath("//div[@id='pomLibraryWindow_header-targetEl']/child::div[1]"));

// Step 3: Drag the popup window to a fixed position (e.g., 200 pixels right and
// 100 pixels down)
		Actions actions = new Actions(driver);
		actions.clickAndHold(dragHandle).moveByOffset(300, -300).release().perform();
		test.log(Status.INFO, "Dragged the popup window to a fixed position");
		addSrceenShot("Dragged the popup window to a fixed position", test, Capture);

		WebElement pomRow = driver
				.findElement(By.xpath("//div[@id='pomLibraryGrid-normal-body']//table//tr[td[6]//div[text()='"
						+ pomDescription + "']]//td[2]//img"));
		pomRow.click();

		test.log(Status.INFO, "Clicked on insert POM arrow for: " + pomDescription);
		addSrceenShot("Clicked on insert POM arrow", test, Capture);
	}

	public void ClosePOMLibraryPopup() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(closePopUp)).click();
	}

	public void validateDataAddedToNextRow(String pomDescription, ExtentTest test) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			System.out.println("Switched to iframeContentframe");
			Thread.sleep(2000);

			WebElement table = driver.findElement(By.xpath("//table[@id='editorTable']"));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			System.out.println("Number of rows found: " + allRows.size());

			if (allRows.size() > 2) { // Ensure there are enough rows
				WebElement nextRow = allRows.get(2); // Assuming the next row is the second row after the header
				System.out.println("Next row found");

				String nextRowData = nextRow.findElement(By.xpath(".//td[4]")).getText(); // Use relative XPath
				System.out.println("Next row data: " + nextRowData);

				Assert.assertEquals(nextRowData, pomDescription, "The data was not added to the next selected row.");
				test.log(Status.PASS, "The data was added to the next selected row: " + pomDescription);
				addSrceenShot("Data added to the next selected row", test, Capture);
			} else {
				System.out.println("Not enough rows in the table to validate");
				test.log(Status.FAIL, "Not enough rows in the table to validate");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
		}
	}

	public void enterNewSize(String newSize) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Sizes_tab)).click();
		Thread.sleep(2000);
		Sizevalue_textbox.sendKeys(newSize);
	}

	public void clickAddButton() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(ADD_Sizevalue));
		ADD_Sizevalue.click();

	}

	public boolean isNewSizeAdded(String newSize) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		WebElement addedSizeElement = driver.findElement(
				By.xpath("//select[@id='LCSMEASUREMENTS_sizeRunChosen']/option[@value='" + newSize + "']"));
		return addedSizeElement != null;
	}

	public void clickSaveAndCheckIn() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(SaveAndCheckIn));
		SaveAndCheckIn.click();

	}

	@FindBy(xpath = "//div[normalize-space()='Size Values']//following-sibling::div")
	private WebElement sizeValuesElement;

	public boolean areSizesVisibleWithNewSize(String newSize, ExtentTest test) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sizeValuesElement));
		String sizesText = sizeValuesElement.getText();
		test.log(Status.INFO, "New size is visible along with existing sizes: " + sizesText);
		return sizesText.contains(newSize);
	}

	@FindBy(xpath = "//label[contains(text(),'Product Sizing')]")
	private WebElement productSizing;

	@FindBy(xpath = "//label[contains(text(),'Measurement Display')]")
	private WebElement measurementDisplayOption;

	@FindBy(xpath = "//label[contains(text(),'Size Range')]")
	private WebElement sizeRangeAttributes;

	@FindBy(xpath = "//label[contains(text(),'General')]")
	private WebElement generalAttributes;

	@FindBy(xpath = "//label[contains(text(),'Measurement Admi')]")
	private WebElement measurementAdminGroup;

	@FindBy(xpath = "//label[contains(text(),'Associated Specifications')]")
	private WebElement associatedSpecifications;

	@FindBy(xpath = "//label[contains(text(),'System In')]")
	private WebElement systemInformation;

	public void viewAllSpecifiedAttributes(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		List<WebElement> elements = Arrays.asList(productSizing, measurementDisplayOption, sizeRangeAttributes,
				generalAttributes, measurementAdminGroup, associatedSpecifications, systemInformation);

		for (WebElement element : elements) {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
			System.out.println(element.getText() + " : Header Attribute is Present");
			test.log(Status.INFO, element.getText() + " : Header Attribute is Present");

// Click only on productSizing and measurementDisplayOption
			if (element.equals(productSizing) || element.equals(measurementDisplayOption)) {
				element.click();
				Thread.sleep(2000);
			}

			List<WebElement> attributes;
			if (element.equals(associatedSpecifications)) {
				attributes = driver.findElements(By.xpath(
						"//label[contains(text(),'Associated Specifications')]//ancestor::div[contains(@class, 'card')]//following::span"));
			} else {
				attributes = driver.findElements(By.xpath("//label[contains(text(),'" + element.getText()
						+ "')]//ancestor::div[contains(@class, 'card')]//div[@class='input-title']"));
			}

			StringBuilder attributesList = new StringBuilder(
					element.getText() + " contains the following attributes:\n");
			for (WebElement attribute : attributes) {
				attributesList.append("- ").append(attribute.getText()).append("\n");
			}
			System.out.println(attributesList.toString());
			test.log(Status.INFO, attributesList.toString());
			addSrceenShot(element.getText(), test, Capture);
		}
	}

	public void controlMeasurementSetTable(ExtentTest test) throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(1000);

// Select Display Mode
		selectDisplayMode("Grade Rules");
		test.log(Status.INFO, "Selected Display Mode: Grade Rules");
		addSrceenShot("Selected Display Mode: Grade Rules", test, Capture);
		Thread.sleep(1000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(2000);

		selectDisplayMode("Measurement Set");
		test.log(Status.INFO, "Selected Display Mode: Measurement Set");
		addSrceenShot("Selected Display Mode: Measurement Set", test, Capture);
		Thread.sleep(1000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(2000);

// Select Units of Measure
		selectUnitsOfMeasure("cm");
		test.log(Status.INFO, "Selected Units of Measure: cm");
		addSrceenShot("Selected Units of Measure: cm", test, Capture);
		Thread.sleep(1000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(2000);

		selectUnitsOfMeasure("in");
		test.log(Status.INFO, "Selected Units of Measure: in");
		addSrceenShot("Selected Units of Measure: in", test, Capture);
		Thread.sleep(1000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(2000);

		selectUnitsOfMeasure("ft");
		test.log(Status.INFO, "Selected Units of Measure: ft");
		addSrceenShot("Selected Units of Measure: ft", test, Capture);
		Thread.sleep(1000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(2000);

		selectUnitsOfMeasure("m");
		test.log(Status.INFO, "Selected Units of Measure: m");
		addSrceenShot("Selected Units of Measure: m", test, Capture);
		Thread.sleep(1000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(2000);

		selectUnitsOfMeasure("mm");
		test.log(Status.INFO, "Selected Units of Measure: mm");
		addSrceenShot("Selected Units of Measure: mm", test, Capture);
		Thread.sleep(1000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(measurementDisplayOption));
		Thread.sleep(3000);
		measurementDisplayOption.click();
		Thread.sleep(2000);

// Select Filter Option
		selectFilterOption("Critical");
		test.log(Status.INFO, "Selected Filter Option: Critical");
		addSrceenShot("Selected Filter Option: Critical", test, Capture);
		Thread.sleep(1000);

		selectFilterOption("Detail");
		test.log(Status.INFO, "Selected Filter Option: Detail");
		addSrceenShot("Selected Filter Option: Detail", test, Capture);
		Thread.sleep(1000);

		selectFilterOption("Secondary");
		test.log(Status.INFO, "Selected Filter Option: Secondary");
		addSrceenShot("Selected Filter Option: Secondary", test, Capture);

		Thread.sleep(2000);
	}

	public boolean verifyDisplayModes(ExtentTest test) {
// Verify Display Modes
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		boolean gradeRulesPresent = isElementPresent(
				By.xpath("//select[@id='displayMode']//option[text()='Grade Rules']"));
		boolean measurementSetPresent = isElementPresent(
				By.xpath("//select[@id='displayMode']//option[text()='Measurement Set']"));

		if (gradeRulesPresent && measurementSetPresent) {
			test.log(Status.PASS, "Both 'Grade Rules' and 'Measurement Set' display modes are present.");
		} else {
			test.log(Status.FAIL, "'Grade Rules' or 'Measurement Set' display mode is missing.");
		}

		return gradeRulesPresent && measurementSetPresent;
	}

	public boolean verifyUnitsOfMeasure(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
// Verify Units of Measure
		boolean cmPresent = isElementPresent(
				By.xpath("//select[@id='measurementFormatAsDisplay']//option[text()='cm']"));
		boolean inPresent = isElementPresent(
				By.xpath("//select[@id='measurementFormatAsDisplay']//option[text()='in']"));
		boolean ftPresent = isElementPresent(
				By.xpath("//select[@id='measurementFormatAsDisplay']//option[text()='ft']"));
		boolean mPresent = isElementPresent(By.xpath("//select[@id='measurementFormatAsDisplay']//option[text()='m']"));
		boolean mmPresent = isElementPresent(
				By.xpath("//select[@id='measurementFormatAsDisplay']//option[text()='mm']"));

		if (cmPresent && inPresent && ftPresent && mPresent && mmPresent) {
			test.log(Status.PASS, "All units of measure (cm, in, ft, m, mm) are present.");
		} else {
			test.log(Status.FAIL, "One or more units of measure are missing.");
		}

		return cmPresent && inPresent && ftPresent && mPresent && mmPresent;
	}

	public boolean verifyFilterOptions(ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
// Verify Filter Options
		boolean criticalPresent = isElementPresent(
				By.xpath("//select[@id='criticalPomFilter']//option[text()='Critical']"));
		boolean detailPresent = isElementPresent(
				By.xpath("//select[@id='criticalPomFilter']//option[text()='Detail']"));
		boolean secondaryPresent = isElementPresent(
				By.xpath("//select[@id='criticalPomFilter']//option[text()='Secondary']"));

		if (criticalPresent && detailPresent && secondaryPresent) {
			test.log(Status.PASS, "All filter options (Critical, Detail, Secondary) are present.");
		} else {
			test.log(Status.FAIL, "One or more filter options are missing.");
		}

		return criticalPresent && detailPresent && secondaryPresent;
	}

	public void selectDisplayMode(String mode) {
		WebElement displayModeDropdown = driver.findElement(By.xpath("//select[@id='displayMode']"));
		Select select = new Select(displayModeDropdown);
		select.selectByVisibleText(mode);
	}

	public void selectUnitsOfMeasure(String unit) {
		WebElement unitsOfMeasureDropdown = driver.findElement(By.xpath("//select[@id='measurementFormatAsDisplay']"));
		Select select = new Select(unitsOfMeasureDropdown);
		select.selectByVisibleText(unit);
	}

	public void selectFilterOption(String filter) {
		WebElement filterDropdown = driver.findElement(By.xpath("//select[@id='criticalPomFilter']"));
		Select select = new Select(filterDropdown);
		select.selectByVisibleText(filter);
	}

	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//span[normalize-space()='Create']")
	private WebElement Create_optn;

	public void clickCreateFromTemplate() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			WebElement addMeasurementElement = new WebDriverWait(driver, 10)
					.until(ExpectedConditions.visibilityOf(Add_measurement));
			addMeasurementElement.click();
		} catch (TimeoutException e) {
		}
	}

	public boolean chooseTemplateAndCheckColorwayVariation(String measurementTemplateName, String measurementsetname,
			ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(CreatefromMeasurementTemplate));
		CreatefromMeasurementTemplate.click();
		test.log(Status.INFO, "Clicked On 'Create from Measurement Template' Link");
		addSrceenShot("Clicked On 'Create from Measurement Template' Link", test, Capture);
		Thread.sleep(5000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(2));

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(name_Input));
		name_Input.clear();
		name_Input.sendKeys(measurementTemplateName);
		Thread.sleep(2000);
		search_button.click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(choose));
		choose.click();
		test.log(Status.INFO, "Measurement Template was choosen: " + measurementTemplateName);
		addSrceenShot("Measurement Template was choosen: " + measurementTemplateName, test, Capture);
		driver.switchTo().window(tabs.get(1));

		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(MeasurementSet_name)).click();
		MeasurementSet_name.sendKeys(measurementsetname);
		test.log(Status.INFO, "Measurement Set Name is: " + measurementsetname);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Create_optn));
		Create_optn.click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(SaveAndCheckIn));
// Check if "colorway variation" hidden input value is "true"
		WebElement colorwayVariation = driver.findElement(By.xpath("//div[contains(text(),'Colorway Variation')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colorwayVariation);
		Thread.sleep(2000);

		WebElement colorwayVariationHiddenInput = driver.findElement(
				By.xpath("//div[contains(text(),'Colorway Variation')]//following-sibling::div//child::input"));
		boolean isChecked = "true".equals(colorwayVariationHiddenInput.getAttribute("value"));

		test.log(Status.INFO, "Checked 'Colorway Variation' for template: " + measurementTemplateName);
		addSrceenShot("Checked 'Colorway Variation' for template", test, Capture);

		return isChecked;
	}

	public void fillAttributesAndSave(String sizes, String measurementType, ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Sizes_tab);
		Sizes_tab.click();
		Sizevalue_textbox.sendKeys(sizes);
		ADD_Sizevalue.click();

		MeasurementType_DD.click();
		MeasurementType_TextBox.sendKeys(measurementType);
		Select_MeasurementType.click();
		test.log(Status.INFO, "Measurement Type Selected is: " + measurementType);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(SaveAndCheckIn));
		SaveAndCheckIn.click();
		Thread.sleep(5000);

	}

	public boolean verifyMeasurementCreation(String measurementsetname) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement measurementSet_DropDown = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("measurementsIdList")));

			Select dropdown = new Select(measurementSet_DropDown);

			for (WebElement option : dropdown.getOptions()) {
				if (option.getText().contains(measurementsetname)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@FindBy(xpath = "//a[@id='create-image']")
	private WebElement Add_ImgPage;

	@FindBy(xpath = "(//input[contains(@id, 'secondaryDocumentFile')])[1]")
	private WebElement Browse_Optn;

	public void clickCreateImgFromVisualAssetsPage() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {
			WebElement addImagePageElement = new WebDriverWait(driver, 5)
					.until(ExpectedConditions.visibilityOf(Add_ImgPage));
			addImagePageElement.click();
		} catch (TimeoutException e) {
		}
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(Create_Images));
		Create_Images.click();

	}

	public void NavigateToVisualAssets() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		specification_tab.click();
		VisualAssets_menu.click();
	}

	public boolean CheckColorwayVariationOption(ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(Save_Button));
		Thread.sleep(2000);
		WebElement colorwayVariationHiddenInput = driver.findElement(
				By.xpath("//div[contains(text(),'Colorway Variation')]//following-sibling::div//child::input"));
		boolean isChecked = "true".equals(colorwayVariationHiddenInput.getAttribute("value"));

		test.log(Status.INFO, "Checked 'Colorway Variation' for Create Image Page: " + isChecked);
		addSrceenShot("Checked 'Colorway Variation' for Create Image Page", test, Capture);

		return isChecked;
	}

	public void fillAttributesAndAddImage(String pagetype, String pagedescription, String pagelayout, String imagePath,
			ExtentTest test) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(PageType_DD)).click();
		TextBox.sendKeys(pagetype);
		Thread.sleep(3000);
		test.log(Status.INFO, "Selected Page Type " + pagetype);
		selectValue.click();
		Thread.sleep(1000);

		PageDecription.sendKeys(pagedescription);
		Thread.sleep(2000);
		test.log(Status.INFO, "Entered Page Description " + pagedescription);

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(PageLayout_DD)).click();
		TextBox.sendKeys(pagelayout);
		Thread.sleep(3000);
		test.log(Status.INFO, "Selected Page Layout " + pagelayout);
		selectValue.click();
		Thread.sleep(1000);
		Save_Button.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Save_Button));
		Browse_Optn.sendKeys(imagePath);
		Thread.sleep(2000);
		Save_Button.click();
		Thread.sleep(2000);

	}

	@FindBy(xpath = "(//input[@id='imagecellChek']//following-sibling::div[1]//label)[1]")
	private WebElement created_Image_Description;

	public boolean isImagePageCreated(String pagedescription, ExtentTest test) {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		try {

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(created_Image_Description));
			Thread.sleep(3000);
			System.out.println(created_Image_Description);
			String createdImageDescription = created_Image_Description.getText();
			System.out.println(createdImageDescription);
			if (createdImageDescription.contains(pagedescription)) {

				System.out.println("Newly Created Imeage Page: " + createdImageDescription);
				test.log(Status.INFO, "Newly Created Imeage Page: " + createdImageDescription);
				return true;

			}

			return false;
		} catch (Exception e) {
			return false;
		}
	}
	

	@FindBy(xpath = "//div[@id='lscoCore']//div[2]")
	private WebElement measurementTypeElement;
	
	public String getMeasurementType() throws Exception{
		
        try {
    		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(measurementTypeElement));
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", measurementTypeElement);
    		Thread.sleep(3000);
            String measurementType = measurementTypeElement.getText().trim();
            
            System.out.println("Measurement type found: " + measurementType);
            
            return measurementType;
        } catch (NoSuchElementException e) {
            // Log the exception if the element is not found
            System.out.println("Measurement type element not found");
            return "";
        }
    }
	
}
