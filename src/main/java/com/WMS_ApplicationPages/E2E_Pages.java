package com.WMS_ApplicationPages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Keys;
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

public class E2E_Pages extends WMS_WebDriverUtilities {
	WebDriver driver;

	public E2E_Pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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

	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement Actions_menu;

	@FindBy(xpath = "//a[@id='addAction']")
	private WebElement Add_menu;

	@FindBy(xpath = "//a[@id='carryOverProduct']")
	private WebElement Carryover_product;

	@FindBy(xpath = "//a[@id='carryOverSKU']")
	private WebElement Carryover_colorways;

	@FindBy(xpath = "//select[@id='selectedSeason']")
	private WebElement SelectInitialseason;

	@FindBy(xpath = "//span[@id='pr_id_2_label']")
	private WebElement linesheet_View;

	@FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component ng-tns-c59-2']")
	private WebElement linesheet_View_textbox;

	@FindBy(xpath = "(//li[@role='option'])[1]")
	private WebElement view_selection;

	@FindBy(xpath = "//div[@ref='eCheckbox']//div/input")
	private WebElement Firstcheckbox;

	@FindBy(xpath = "//span[normalize-space()='Select']")
	private WebElement Select_button;

	@FindBy(xpath = "//div[@col-id='product.productName|~*~|1.Adoption']//a")
	private WebElement product_link;

	@FindBy(xpath = "//div[@col-id='colorway.skuName|~*~|1.Adoption']//a")
	private WebElement colorway_link;
	
	@FindBy(xpath = "//input[@id='imageFile']")
	private WebElement Browse_button;
	@FindBy(xpath = "//a[@id='saveButton']")
	private WebElement save_button;
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSUSValidation|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSUS_validation;
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSEValidation|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSE_validation;
	
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement validationCheckbox;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSUSCSTrigger|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSUS;
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSECSTrigger|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSE;
	
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement Save_button;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSUSStatus|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSUS_Status;
	
	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoLSEStatus|~*~|4.SetUp-LSE/LSA'])[2]")
	private WebElement setUpLSE_Status;
	
	@FindBy(xpath = "//div[@class='dropdown menu-icon']")
	private WebElement Action_dropdown;
	
	@FindBy(xpath = "//a[@id='updateSku']")
	private WebElement EditColorway;
	
	

//	---------------------------------------------------------------------------------------

	public void Select_CarryOverProduct() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Actions_menu.click();
		Add_menu.click();
		Carryover_product.click();
	}

	public void Select_CarryOvercolorways() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Actions_menu.click();
		Add_menu.click();
		Carryover_colorways.click();
	}

	public void SelectInitialSeason(String initialseason) throws InterruptedException {
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(1));

		selectValueFromDropdown(SelectInitialseason, initialseason);
	}

	public void linesheet_view(String linesheetview) throws InterruptedException {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(linesheet_View));

		linesheet_View.click();
		linesheet_View_textbox.sendKeys(linesheetview);
		Thread.sleep(2000);
		view_selection.click();
	}

	public void SelectCarryoverProduct() throws InterruptedException {
		Firstcheckbox.click();
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Firstcheckbox)).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Select_button)).click();
		Thread.sleep(2000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
	}

	public void SelectCarryovercolorway() throws InterruptedException {
		Firstcheckbox.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Select_button)).click();
		
		Thread.sleep(3000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
		driver.switchTo().window(tabs.get(0));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		Thread.sleep(2000);
	}

	public void validate_CarriedOver_PC5_PC9(String productname, String colorwayname) {
		FilterTextbox.sendKeys(colorwayname);
		String actualProduct = product_link.getText();
		String actualColorway = colorway_link.getText();

		if (actualProduct.contains(productname)) {
			System.out.println(actualProduct + " Product is carried over to a new season");
			test.log(Status.INFO, actualProduct + " Product is carried over to a new season");
		}
		if (actualColorway.contains(colorwayname)) {
			System.out.println(actualColorway + " colorway is carried over to a new season");
			test.log(Status.INFO, actualColorway + " colorway is carried over to a new season");
		}

	}

	public void Linesheet_SetUpLSUS(ExtentTest test) throws InterruptedException {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Thread.sleep(5000);

			ArrayList<String> header = new ArrayList<String>();
			header = getLinsheetLSUSColumnHeaderValue();
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
					if (LSUSValidation.equalsIgnoreCase("No") || LSUSValidation.isEmpty()) {
						Actions action = new Actions(driver);
						action.doubleClick(setUpLSUS_validation).perform();
						Thread.sleep(2000);
						validationCheckbox.click();
						
						
					}else {
						test.log(Status.FAIL, " Set UP LSUS validation value is already YES ");
						System.out.println("Set UP LSUS validation value is already YES");
					}
				}
				if (ColumnHeader.equals("Set Up LSUS")) {
					String LSUSValue = setUpLSUS.getText();
					test.log(Status.INFO, "Set Up LSUS  value is :  " + LSUSValue);
					System.out.println(LSUSValue);
					Thread.sleep(2000);
					if (LSUSValue.equalsIgnoreCase("No") || LSUSValue.isEmpty()) {
						Actions action = new Actions(driver);
						action.doubleClick(setUpLSUS).perform();
						Thread.sleep(2000);
						validationCheckbox.click();
						Save_button.click();
						Thread.sleep(10000);
					}else {
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
					if (LSUSStatus.contains("No Validation Error") || LSUSStatus.isEmpty()) {
						test.log(Status.PASS, " LSUS Set Up is done with no Error  ");
						System.out.println("LSUS Set Up is done with no Error");
					}else {
						test.log(Status.PASS, " Validation Error ");
						System.out.println("Validation Error");
					}
				}
		
			}
	
		}
	
	public void Linesheet_SetUpLSE(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getLinsheetLSUSColumnHeaderValue();
		for (int i = 0; i < (header.size()); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(500);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Set Up LSE - Run Validation")) {
				String LSEValidation = setUpLSE_validation.getText();
				test.log(Status.INFO, "LSE validation value is :  " + LSEValidation);
				System.out.println(LSEValidation);
				Thread.sleep(2000);
				if (LSEValidation.equalsIgnoreCase("No") || LSEValidation.isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(setUpLSE_validation).perform();
					Thread.sleep(2000);
					validationCheckbox.click();
					
					
				}else {
					test.log(Status.FAIL, " Set UP LSE validation value is already YES ");
					System.out.println("Set UP LSE validation value is already YES");
				}
			}
			if (ColumnHeader.equals("Set Up LSE")) {
				String LSEValue = setUpLSE.getText();
				test.log(Status.INFO, "Set Up LSE  value is :  " + LSEValue);
				System.out.println(LSEValue);
				Thread.sleep(2000);
				if (LSEValue.equalsIgnoreCase("No") || LSEValue.isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(setUpLSE).perform();
					Thread.sleep(2000);
					validationCheckbox.click();
					Save_button.click();
					Thread.sleep(10000);
				}else {
					test.log(Status.FAIL, " Set UP LSE value is already YES ");
					System.out.println("Set UP LSE value is already YES");
				}	
			}
			
			if (ColumnHeader.equals("Set Up LSE Status")) {
				Thread.sleep(2000);
				String LSEStatus = setUpLSE_Status.getText();
				test.log(Status.INFO, "Set Up LSE Status is :  " + LSEStatus);
				System.out.println(LSEStatus);
				Thread.sleep(2000);
				if (LSEStatus.contains("No Validation Error")|| LSEStatus.contains("Processing")) {
					test.log(Status.PASS, " LSE Set Up is done with no Error  ");
					System.out.println("LSE Set Up is done with no Error");
				}else {
					test.log(Status.FAIL, " Validation Error ");
					System.out.println("Validation Error");
				}
			}
	
		}

	}
	@FindBy(xpath = "(//div[@col-id='colorway.lscoProfitCtrAPD|~*~|4.SetUp-APD'])[2]//a")
	private WebElement ProfitCenter_APD;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAPDValidation|~*~|4.SetUp-APD'])[2]")
	private WebElement Setup_APD_Validation;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoTriggerSAPforCSPO|~*~|4.SetUp-APD'])[2]")
	private WebElement Setup_APD;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAPDValidationReport|~*~|4.SetUp-APD'])[2]")
	private WebElement Setup_APD_Validation_result;
	
	@FindBy(xpath = "(//div[@col-id='SGSKU2715891966.lscoAPDSetupStatus|~*~|4.SetUp-APD'])[2]")
	private WebElement Setup_APD_Status;
	
	@FindBy(xpath = "//input[@role='searchbox']")
	private WebElement search_Box;
 
	@FindBy(xpath = "//li[@role='option']/child::span")
	private WebElement filteredOptn;
	
	private boolean Capture;
	
	
	public void Linesheet_SetUpAPD(String profitcenterAPD,ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);

		ArrayList<String> header = new ArrayList<String>();
		header = getLinesheetAPDColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(200);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Profit Center [APD]")) {
				String profitcenterapd_value = ProfitCenter_APD.getText();
				test.log(Status.INFO, " Profit center APD value is :  " + profitcenterapd_value);
				System.out.println(profitcenterapd_value);
				Thread.sleep(2000);
				if ( profitcenterapd_value.isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(ProfitCenter_APD).perform();
					Thread.sleep(4000);
					search_Box.click();
					Thread.sleep(2000);
					search_Box.clear();
					search_Box.sendKeys(profitcenterAPD);
					Thread.sleep(7000);
					new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(filteredOptn));
					filteredOptn.click();
					search_Box.sendKeys(Keys.RETURN);
					Thread.sleep(10000);
					Save_button.click();
					Thread.sleep(20000);
	 
					System.out.println("Profit center value is selected");
					addSrceenShot("profit center APD Value is selected " , test, Capture);
					test.log(Status.INFO, "profit center APD Value is selected : " + profitcenterAPD);

				}else {
					System.out.println("Profit center value is already Populated");
					addSrceenShot("profit center APD Value is already Populated " , test, Capture);
					test.log(Status.INFO, "profit center APD Value is already Populated : " + profitcenterAPD);
				}
			}
			if (ColumnHeader.equals("Set Up APD - Run Validation")) {
				String APDValidation = Setup_APD_Validation.getText();
				test.log(Status.INFO, "APD validation value is :  " + APDValidation);
				System.out.println(APDValidation);
				Thread.sleep(2000);
				if (APDValidation.equalsIgnoreCase("No") || APDValidation.isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(Setup_APD_Validation).perform();
					Thread.sleep(2000);
					validationCheckbox.click();
					Setup_APD_Validation.sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					Save_button.click();
					Thread.sleep(40000);
					
				}else {
					test.log(Status.INFO, " Set UP APD validation value is already YES ");
					System.out.println("Set UP APD validation value is already YES");
				}
			}
			
			if (ColumnHeader.equals("Set Up APD Validation Results")) {
				Thread.sleep(2000);
				String APDValidationResult = Setup_APD_Validation_result.getText();
				test.log(Status.INFO, "Set Up APD Validation result is :  " + APDValidationResult);
				System.out.println(APDValidationResult);
				Thread.sleep(2000);
				if (APDValidationResult.isEmpty()) {
					test.log(Status.INFO, " APD validation result shows no Error  ");
					System.out.println("APD validation result shows no Error");
				}else {
					test.log(Status.FAIL, " Validation Error ");
					System.out.println("Validation Error");
				}
			}
			
			
			if (ColumnHeader.equals("Set Up APD")) {
				String APDValue = Setup_APD.getText();
				test.log(Status.INFO, "Set Up LSUS  value is :  " + APDValue);
				System.out.println(APDValue);
				Thread.sleep(2000);
				if (APDValue.equalsIgnoreCase("No") || APDValue.isEmpty()) {
					Actions action = new Actions(driver);
					action.doubleClick(Setup_APD).perform();
					Thread.sleep(2000);
					validationCheckbox.click();
					Setup_APD.sendKeys(Keys.ENTER);
					Save_button.click();
					Thread.sleep(40000);
				}else {
					test.log(Status.FAIL, " Set UP APD value is already YES");
					System.out.println("Set UP APD value is already YES");
				}	
			}
			
			if (ColumnHeader.equals("Set Up APD Status")) {
				Thread.sleep(5000);
				String APDStatus = Setup_APD_Status.getText();
				test.log(Status.INFO, "Set Up APD Status is :  " + APDStatus);
				System.out.println(APDStatus);
				Thread.sleep(2000);
				if (APDStatus.contains("No Error")|| APDStatus.isEmpty()) {
					test.log(Status.PASS, " APD Set Up is done with no Error  ");
					System.out.println("APD Set Up is done with no Error");
				}else {
					test.log(Status.FAIL, " Validation Error ");
					System.out.println("Validation Error");
				}
			}
	
		}

	}
	
	public void Click_EditColorway() {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			Action_dropdown.click();
			EditColorway.click();
			WaitforPage(5000);		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void upload_Thumbnail(String filepath) throws Exception {
		Browse_button.sendKeys(filepath);
		Thread.sleep(2000);
		save_button.click();
		Thread.sleep(3000);
	}
	
	
	
	
	
}
