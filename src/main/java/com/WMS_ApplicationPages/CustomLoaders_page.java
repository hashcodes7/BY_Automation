package com.WMS_ApplicationPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.opencsv.CSVReader;

import junit.framework.Assert;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CustomLoaders_page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public CustomLoaders_page(WebDriver driver) {
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

	@FindBy(xpath = "//a[@id='SearchButton1']")
	private WebElement SearchButton;

	@FindBy(xpath = "//a[text()='Loader Files']")
	private WebElement LoaderFile_Link;

	@FindBy(xpath = "//a[text()='Placement Loader']")
	private WebElement PlacementLoader_file;
	
	@FindBy(xpath = "//a[text()='Seasonal Look Bulk Loader']")
	private WebElement SeasonalLookLoader_file;

	@FindBy(xpath = "//a[text()='Placement_Loader_Template_Acc.csv']")
	private WebElement PlacementLoader_template;
	
	@FindBy(xpath = "//a[text()='Placement_Loader_Template.csv']")
	private WebElement PlacementLoader_template_staging;
	
	@FindBy(xpath = "//a[text()='Seasonal-Look-File-Uploader_V5.xlsx']")
	private WebElement SeasonalLook_Loader_template;

	@FindBy(xpath = "//select[@name='fileType']")
	private WebElement filetype_DD;

	@FindBy(xpath = "//input[@name='loadFile']")
	private WebElement choosefile;

	@FindBy(xpath = "//a[text()='Load']")
	private WebElement load;

	@FindBy(xpath = "(//a[text()='Load'])[2]")
	private WebElement Bulkload;

	@FindBy(xpath = "//input[@name='loadFileExcel']")
	private WebElement choosebulkfile;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoYield|~*~|PlacementView'])[2]")
	private WebElement usage_value;

	@FindBy(xpath = "(//div[@col-id='source.lscoVendor.lscoVendorID|~*~|PlacementView'])[2]")
	private WebElement VendorId_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoPrimaryFabric.lscoMaterialCode|~*~|PlacementView'])[2]")
	private WebElement MaterialCode_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoSupplierCode|~*~|PlacementView'])[2]")
	private WebElement MillSAPCode_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoAUS|~*~|PlacementView'])[2]")
	private WebElement AUS_GDV_value;

	@FindBy(xpath = "//input[@id='quickSearchText']")
	private WebElement FilterTextbox;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoProfitCtrAPD|~*~|4.SetUp-APD'])[2]//a")
	private WebElement profitcenterAPD_value;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoProfitCtrAPD|~*~|4.SetUp-APD'])[2]//a")
	private WebElement profitcenterAPD_valueLINK;

	@FindBy(xpath = "//td[@id='lscoProfitCenter']")
	private WebElement lscoprofitcenter;

	@FindBy(xpath = "(//div[@col-id='colorway.lscoTargetFOB|~*~|2.FLA-FinalizeDetails'])[2]")
	private WebElement TargetFOBValue;

	@FindBy(xpath = "//input[@id='inputText']")
	private WebElement Textbox;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement Save_button;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoMxGDV|~*~|PlacementView'])[2]//span")
	private WebElement MX_GDV_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoJapanGDV|~*~|PlacementView'])[2]//span")
	private WebElement JAPAN_GDV_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoChinaGDV|~*~|PlacementView'])[2]//span")
	private WebElement CHINA_GDV_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoCAGDV|~*~|PlacementView'])[2]//span")
	private WebElement CA_GDV_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoMalaGDV|~*~|PlacementView'])[2]//span")
	private WebElement MALA_GDV_value;

	@FindBy(xpath = "(//div[@col-id='colorway-season.lscoNewCarryover|~*~|PlacementView'])[2]")
	private WebElement Carryover_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoChangeReason|~*~|PlacementView'])[2]")
	private WebElement ChangeReason_value;

	@FindBy(xpath = "(//div[@col-id='colorway-source.lscoChangeComments|~*~|PlacementView'])[2]//span/span/pre")
	private WebElement ChangeComments_value;

//	--------------------------Methods---------------------------------------------

	public void SeasonDropdown(String season) throws InterruptedException {
		selectValueFromDropdown(SeasonsDropdown, season);
	}

	public void Download_LoaderPlacementFile(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			LoaderFile_Link.click();
			new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
			PlacementLoader_file.click();
			PlacementLoader_template.click();
			test.log(Status.INFO, "Navigated to Placement Loader Template and downloaded the Template");
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void Download_LoaderPlacementFile_staging(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			LoaderFile_Link.click();
			new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
			PlacementLoader_file.click();
			PlacementLoader_template_staging.click();
			test.log(Status.INFO, "Navigated to Placement Loader Template and downloaded the Template");
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void Download_BulkSeasonalLook_LoaderFile(ExtentTest test) throws InterruptedException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			LoaderFile_Link.click();
			new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
			SeasonalLookLoader_file.click();
			SeasonalLook_Loader_template.click();
			test.log(Status.INFO, "Navigated to Seasonal look Loader Template and downloaded the Template");
			Thread.sleep(8000);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void selectFileType(String filetype) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		selectValueFromDropdown(filetype_DD, filetype);
	}

	public void uploadFile(String filepath) {
		choosefile.sendKeys(filepath);
	}

	public void uploadbulkFile(String uploadfilepath) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		choosebulkfile.sendKeys(uploadfilepath);
	}

	public String ValidatePlacementLoaderResult(String resultfilepath) {
		String message = null;
		String result = null;
		try {
			load.click();
			Thread.sleep(8000);
			CSVReader readcsv = new CSVReader(new FileReader(resultfilepath));
			List<String[]> list = readcsv.readAll();
			int i = 0;
			for (String[] row : list) {
				for (String cell : row) {
					if (i == 0) {
						break;
					} else {
						if (row[9].equalsIgnoreCase("Error")) {
							message = "Error";
							result = message + "," + row[10];
							System.out.println(result);
							break;

						} else if (row[9].equalsIgnoreCase("Success")) {
							message = "Success";
							result = message + "," + row[10];
							System.out.println(message);
							break;
						}
					}
				}
				i++;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public String ValidateBulkColorResult(String resultFilepath) {

		String Result = null;
		try {

			Bulkload.click();
			Thread.sleep(15000);

			File file = new File(resultFilepath);
			FileInputStream inputStream = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet("Colorway");
			int numOfRows = sheet.getLastRowNum();
			System.out.println(numOfRows);
			for (int i = 1; i <= numOfRows; i++) {
				String Status = sheet.getRow(i).getCell(13).getStringCellValue();
				String Comments = sheet.getRow(i).getCell(14).getStringCellValue();
				Result = Status + "," + Comments;
				System.out.println(Result);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return Result;
	}

	public String ValidateBulkLookResult(String resultFilepath) {

		String Result = null;
		try {

			Bulkload.click();
			Thread.sleep(15000);

			File file = new File(resultFilepath);
			FileInputStream inputStream = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet("SeasonalLook-Upload");
			int numOfRows = sheet.getLastRowNum();
			System.out.println(numOfRows);
			for (int i = 1; i <= numOfRows; i++) {
				String Status = sheet.getRow(i).getCell(17).getStringCellValue();
				String Comments = sheet.getRow(i).getCell(18).getStringCellValue();
				String colorcode = sheet.getRow(i).getCell(2).getStringCellValue();
				Result = Status + "," + Comments + "," + colorcode;
				System.out.println(Result);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return Result;
	}

	public void ValidateBulkLook_UI(String lookname, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(5000);
		List<WebElement> colortype = driver.findElements(By.xpath(
				"//div[@col-id='color.typename|~*~|LookDataValidationView' and  contains(@class,'ag-cell-normal-height')]"));

		List<WebElement> listofLook = driver
				.findElements(By.xpath("//div[@col-id='color.name|~*~|LookDataValidationView']//a"));
		for (int i=0;i<listofLook.size();i++) {
			String colorname = listofLook.get(i).getText();
			
			for (int j = 0; j < (colortype.size() - 1); j++) {
				if (colorname.contains(lookname) && i==j) {
					System.out.println(colortype.get(i).getText());
					System.out.println(" The Look/SeasonalLook name present in UI is: " + colorname
							+ "  and colortype is: " + colortype.get(i).getText());
					test.log(Status.INFO, " The Look/SeasonalLook name present in UI is: " + colorname
							+ "  and colortype is: " + colortype.get(i).getText());
					addSrceenShot(" The Look/SeasonalLook name present in UI is: " + colorname + "  and colortype is: "
							+ colortype.get(i).getText(), test, Capture);
					
				}
				
			}
			

		}

	}

	public String ValidateMaterialPriceLoaderResult(String resultfilepath) {
		String message = null;
		String result = null;
		try {
			load.click();
			Thread.sleep(5000);
//			Set<String> allWindowHandles = driver.getWindowHandles();
//			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
//			driver.switchTo().window(tabs.get(1));
			Thread.sleep(5000);
			CSVReader readcsv = new CSVReader(new FileReader(resultfilepath));
			List<String[]> list = readcsv.readAll();
			int i = 0;
			for (String[] row : list) {
				for (String cell : row) {
					if (i == 0) {
						break;
					} else {
						if (row[14].equalsIgnoreCase("Error")) {
							message = "Error";
							result = message + "," + row[15];
							System.out.println(result);
							break;

						} else if (row[14].equalsIgnoreCase("Success")) {
							message = "Success";
							result = message + "," + row[15];
							System.out.println(message);
							break;
						}
					}
				}
				i++;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public String ValidateProfitCenterAPDLoaderResult(String resultfilepath) {
		String message = null;
		String result = null;
		try {
			load.click();
			Thread.sleep(5000);
//			Set<String> allWindowHandles = driver.getWindowHandles();
//			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
//			driver.switchTo().window(tabs.get(1));
			Thread.sleep(5000);
			CSVReader readcsv = new CSVReader(new FileReader(resultfilepath));
			List<String[]> list = readcsv.readAll();
			int i = 0;
			for (String[] row : list) {
				for (String cell : row) {
					if (i == 0) {
						break;
					} else {
						if (row[0].contains("ERROR")) {
							message = "ERROR";
							result = message + "," + row[1];
							System.out.println(result);
							break;

						} else if (row[0].equalsIgnoreCase("Success")) {
							message = "Success";
							result = message + "," + row[1];
							System.out.println(result);
							break;
						}
					}
				}
				i++;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public String Validate_TargetFOB_LoaderResult(String resultfilepath) {
		String message = null;
		String result = null;
		try {
			load.click();
			Thread.sleep(5000);
//			Set<String> allWindowHandles = driver.getWindowHandles();
//			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
//			driver.switchTo().window(tabs.get(1));
			Thread.sleep(5000);
			CSVReader readcsv = new CSVReader(new FileReader(resultfilepath));
			List<String[]> list = readcsv.readAll();
			int i = 0;
			for (String[] row : list) {
				for (String cell : row) {
					if (i == 0) {
						break;
					} else {
						if (row[0].contains("ERROR")) {
							message = "ERROR";
							result = message + "," + row[1];
							System.out.println(result);
							break;

						} else if (row[0].equalsIgnoreCase("Success")) {
							message = "Success";
							result = message + "," + row[1];
							System.out.println(result);
							break;
						}
					}
				}
				i++;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public void Validate_ProfitcenterAPD_linesheet(String colorway, String profitcenterAPD, ExtentTest test)
			throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getSetupAPDColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Profit Center [APD]")) {

				profitcenterAPD_valueLINK.click();
				test.log(Status.INFO, "Clicked on Profir center APD value link");

				Set<String> allWindowHandles = driver.getWindowHandles();
				ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
				driver.switchTo().window(tabs.get(1));

				if (lscoprofitcenter.getText().equals(profitcenterAPD)) {
					System.out.println("Profit Center APD value in loaderfile sheet is:  " + profitcenterAPD
							+ " and profit center APD value in UI is " + lscoprofitcenter.getText() + " are matching");
					test.log(Status.INFO, "Profit Center APD value in loaderfile sheet is:  " + profitcenterAPD
							+ " and profit center APD value in UI is " + lscoprofitcenter.getText() + " are matching");
					addSrceenShot("Profit Center APD value in loaderfile sheet is:  " + profitcenterAPD
							+ " and profit center APD value in UI is " + lscoprofitcenter.getText() + " are matching",
							test, Capture);
				}

				driver.switchTo().window(tabs.get(0));
				driver.switchTo().defaultContent();
				driver.switchTo().frame(iframeContentframe);
			}

		}

	}

	public void Validate_TargetFOB_Linesheet(String colorway, String targetFOB, ExtentTest test)
			throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getFLA_for_TargetFOBLinesheetheaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Target FOB")) {
				if (TargetFOBValue.getText().contains(targetFOB)) {
					System.out.println("Target FOB value in loaderfile sheet is:  " + targetFOB
							+ " and Target FOB value in UI is " + TargetFOBValue.getText() + " are matching");
					test.log(Status.INFO, "Target FOB value in loaderfile sheet is:  " + targetFOB
							+ " and Target FOB value in UI is " + TargetFOBValue.getText() + " are matching");
					addSrceenShot("Target FOB value in loaderfile sheet is:  " + targetFOB
							+ " and Target FOB value in UI is " + TargetFOBValue.getText() + " are matching", test,
							Capture);
				}
			}
		}
	}

	public void Validate_MX_GDV_linesheet(String colorway, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementviewColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("MX_GDV")) {
				System.out.println("MX_GDV value in Linesheet is:  " + MX_GDV_value.getText()
						+ "  after sending blank MX_GDV in placement loader file");
				test.log(Status.INFO, "MX_GDV value in Linesheet is:  " + MX_GDV_value.getText()
						+ "  after sending blank MX_GDV in placement loader file");
				addSrceenShot("MX_GDV value in Linesheet is:  " + MX_GDV_value.getText()
						+ "  after sending blank MX_GDV in placement loader file", test, Capture);
			}
		}
	}

	public void Prerequisite_Carryover(String colorway, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementviewColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("Carryover/New")) {
				if (Carryover_value.getText().equalsIgnoreCase("Carryover")) {
					System.out.println("Prerequisite validated and the value for carryover/new is :  "
							+ Carryover_value.getText());
					test.log(Status.INFO, "Prerequisite validated and the value for carryover/new is :  "
							+ Carryover_value.getText());
					addSrceenShot(
							"Prerequisite validated and the value for carryover/new is :  " + Carryover_value.getText(),
							test, Capture);
				}

			}
		}
	}

	public void Validate_PlacementAttributes_CarryoverColorway_linesheet(String colorway, String vendor_Id,
			String AusGdv_value, String MALAGdv_value, String usagevalue, String changereason_value,
			String changecomments_value, ExtentTest test) throws InterruptedException {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WaitforPage(5000);

			FilterTextbox.clear();
			FilterTextbox.sendKeys(colorway);

			ArrayList<String> header = new ArrayList<String>();
			header = getAttribute_PlacementAttributes_ColumnHeaderValue();
			for (int i = 0; i < header.size(); i++) {
				String ColumnHeader = header.get(i);
				scroll(i + 3);
				Thread.sleep(500);

				if (ColumnHeader.equals("Yield/Usage")) {
					Thread.sleep(2000);
					if (usage_value.getText().equals(usagevalue)) {
						test.log(Status.INFO,
								"The usage value is matching with the previous season colorway after carryover and the value is : "
										+ usage_value.getText());
						System.out.println(
								"The usage value is matching with the previous season colorway after carryover and the value is : "
										+ usage_value.getText());
					} else {
						test.log(Status.FAIL,
								"The usage value is Not matching with the previous season after carryover");
						System.out.println("The usage value is Not matching with the previous season after carryover");
					}

				}

				if (ColumnHeader.equals("AUS_GDV")) {
					String AUSGDV_value = AUS_GDV_value.getText();
					test.log(Status.INFO, "scrolled to AUS_GDV and the value is :  " + AUSGDV_value);
					System.out.println(AUSGDV_value);
					Thread.sleep(2000);
					if (AUSGDV_value.contains(AusGdv_value)) {
						test.log(Status.INFO,
								"The value for AUS_GDV is matching with the previous season colorway after carryover and the value is : "
										+ AUSGDV_value);
						System.out.println(
								"The value for AUS_GDV is matching with the previous season colorway after carryover and the value is : "
										+ AUSGDV_value);

					} else {
						test.log(Status.FAIL,
								"The value for AUS_GDV is Not matching with the previous season colorway after carryover  ");
						System.out.println(
								"The value for AUS_GDV is Not matching with the previous season colorway after carryover");
					}
				}
				if (ColumnHeader.equals("MALA_GDV")) {
					String MALAGDV_value = MALA_GDV_value.getText();
					test.log(Status.INFO, "scrolled to MALA_GDV and the value is :  " + MALAGDV_value);
					System.out.println(MALAGDV_value);
					Thread.sleep(2000);
					if (MALAGDV_value.contains(MALAGdv_value)) {
						test.log(Status.INFO,
								"The value for MALA_GDV is matching with the previous season colorway after carryover and the value is : "
										+ MALAGDV_value);
						System.out.println(
								"The value for MALA_GDV is matching with the previous season colorway after carryover and the value is : "
										+ MALAGDV_value);

					} else {
						test.log(Status.FAIL,
								"The value for MALA_GDV is Not matching with the previous season colorway after carryover ");
						System.out.println(
								"The value for MALA_GDV is Not matching with the previous season colorway after carryover  ");
					}
				}
				if (ColumnHeader.equals("Change Reason")) {
					String ChangeReasonvalue = ChangeReason_value.getText();
					test.log(Status.INFO, "scrolled to Change Reason and the value is :  " + ChangeReasonvalue);
					System.out.println(ChangeReasonvalue);
					Thread.sleep(2000);
					if (!ChangeReasonvalue.equalsIgnoreCase(changereason_value)) {
						test.log(Status.INFO,
								"The value for Change Reason is Not matching with the previous season colorway after carryover and the value is : "
										+ ChangeReason_value.getText());
						System.out.println(
								"The value for Change Reason is NOT matching with the previous season colorway after carryover and the value is : "
										+ ChangeReason_value.getText());

					} else {
						test.log(Status.FAIL,
								"The value for Change Reason is matching with the previous season colorway after carryover ");
						System.out.println(
								"The value for Change Reason is matching with the previous season colorway after carryover  ");
					}
				}
				if (ColumnHeader.equals("Change Comments")) {
					String ChangeCommentsvalue = ChangeComments_value.getText();
					test.log(Status.INFO, "scrolled to Change Reason and the value is :  " + ChangeCommentsvalue);
					System.out.println(ChangeCommentsvalue);
					Thread.sleep(2000);
					if (!ChangeCommentsvalue.equalsIgnoreCase(changecomments_value)) {
						test.log(Status.INFO,
								"The value for Change Comments is Not matching with the previous season colorway after carryover and the value is : "
										+ ChangeComments_value.getText());
						System.out.println(
								"The value for Change Comments is Not matching with the previous season colorway after carryover and the value is : "
										+ ChangeComments_value.getText());

					} else {
						test.log(Status.FAIL,
								"The value for Change Comments is matching with the previous season colorway after carryover ");
						System.out.println(
								"The value for Change Comments is matching with the previous season colorway after carryover  ");
					}
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Validate_JAPAN_GDV_linesheet(String colorway, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementviewColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("JAPAN_GDV")) {
				System.out.println("JAPAN_GDV value in Linesheet is:  " + JAPAN_GDV_value.getText()
						+ "  after sending blank JAPAN_GDV in placement loader file");
				test.log(Status.INFO, "JAPAN_GDV value in Linesheet is:  " + JAPAN_GDV_value.getText()
						+ "  after sending blank JAPAN_GDV in placement loader file");
				addSrceenShot("JAPAN_GDV value in Linesheet is:  " + JAPAN_GDV_value.getText()
						+ "  after sending blank JAPAN_GDV in placement loader file", test, Capture);
			}
		}
	}

	public void Validate_CHINA_GDV_linesheet(String colorway, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementviewColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("CHINA_GDV")) {
				System.out.println("CHINA_GDV value in Linesheet is:  " + CHINA_GDV_value.getText()
						+ "  after sending blank CHINA_GDV in placement loader file");
				test.log(Status.INFO, "CHINA_GDV value in Linesheet is:  " + CHINA_GDV_value.getText()
						+ "  after sending blank CHINA_GDV in placement loader file");
				addSrceenShot("CHINA_GDV value in Linesheet is:  " + CHINA_GDV_value.getText()
						+ "  after sending blank CHINA_GDV in placement loader file", test, Capture);
			}
		}
	}

	public void Validate_CA_GDV_linesheet(String colorway, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementviewColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("CA_GDV")) {
				System.out.println("CA_GDV value in Linesheet is:  " + CA_GDV_value.getText()
						+ "  after sending blank CA_GDV in placement loader file");
				test.log(Status.INFO, "CA_GDV value in Linesheet is:  " + CA_GDV_value.getText()
						+ "  after sending blank CA_GDV in placement loader file");
				addSrceenShot("CA_GDV value in Linesheet is:  " + CA_GDV_value.getText()
						+ "  after sending blank CA_GDV in placement loader file", test, Capture);
			}
		}
	}

	public void Validate_MALA_GDV_linesheet(String colorway, ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

		FilterTextbox.sendKeys(colorway);

		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementviewColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);

			if (ColumnHeader.equals("MALA_GDV")) {
				System.out.println("MALA_GDV value in Linesheet is:  " + MALA_GDV_value.getText()
						+ "  after sending blank MALA_GDV in placement loader file");
				test.log(Status.INFO, "MALA_GDV value in Linesheet is:  " + MALA_GDV_value.getText()
						+ "  after sending blank MALA_GDV in placement loader file");
				addSrceenShot("MALA_GDV value in Linesheet is:  " + MALA_GDV_value.getText()
						+ "  after sending blank MALA_GDV in placement loader file", test, Capture);
			}
		}
	}

	public void AttributeValidations(ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		driver.findElement(By.xpath("//input[@id='quickSearchText']")).sendKeys("A3510-0000");
		Thread.sleep(5000);
		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementColumnHeaderValue();
		for (int i = 0; i < 23; i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(1000);
			System.out.println(ColumnHeader);
			if (ColumnHeader.equals("Yield/Usage")) {
				Thread.sleep(5000);
				test.log(Status.INFO, "The usage value is: " + usage_value.getText());
				System.out.println("The usage value is: " + usage_value.getText());
			}
		}
	}

	public void VerifyAttributesValue_PlacementView(String vendor_Id, String materialcode, String millsapcode,
			String usagevalue, ExtentTest test) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WaitforPage(5000);

			ArrayList<String> header = new ArrayList<String>();
			header = getAttribute_PlacementAttributes_ColumnHeaderValue();
			for (int i = 0; i < header.size(); i++) {
				String ColumnHeader = header.get(i);
				scroll(i + 3);
				Thread.sleep(500);
				if (ColumnHeader.equals("Vendor ID")) {
					String Vendoridvalue = VendorId_value.getText();
					test.log(Status.INFO, "scrolled to Vendor Id and the value is :  " + Vendoridvalue);
					System.out.println(Vendoridvalue);
					Thread.sleep(2000);
					if (Vendoridvalue.equalsIgnoreCase(vendor_Id)) {
						test.log(Status.PASS, "The Vendor Id  value is: " + VendorId_value.getText());
						System.out.println("The Vendor Id value is: " + VendorId_value.getText());
					} else {
						test.log(Status.FAIL, "Vendor Id value do not match");
						System.out.println("Vendor Id value do not match");
					}
				}
				if (ColumnHeader.equals("Material Code")) {
					String Materialcodevalue = MaterialCode_value.getText();
					test.log(Status.INFO, "scrolled to Material code and the value is :  " + Materialcodevalue);
					System.out.println(Materialcodevalue);
					Thread.sleep(2000);
					if (Materialcodevalue.equalsIgnoreCase(materialcode)) {
						test.log(Status.PASS, "The MaterialCode  value is: " + MaterialCode_value.getText());
						System.out.println("The MaterialCode value is: " + MaterialCode_value.getText());
					} else {
						test.log(Status.FAIL, "Material code value do not match");
						System.out.println("Material code value do not match");
					}
				}
				if (ColumnHeader.equals("Placement Fabric - Mill SAP Code")) {
					String MillSapCode = MillSAPCode_value.getText();
					test.log(Status.INFO, "scrolled to Material code and the value is :  " + MillSapCode);
					System.out.println(MillSapCode);
					Thread.sleep(2000);
					if (MillSapCode.equalsIgnoreCase(millsapcode)) {
						test.log(Status.PASS, "The Mill sap Code  value is: " + MillSAPCode_value.getText());
						System.out.println("The Mill sap Code value is: " + MillSAPCode_value.getText());
					} else {
						test.log(Status.FAIL, "Mill sap Code value do not match");
						System.out.println("Mill sap Code value do not match");
					}
				}
				if (ColumnHeader.equals("Yield/Usage")) {
					Thread.sleep(2000);
					test.log(Status.INFO, "The usage value is: " + usage_value.getText());
					System.out.println("The usage value is: " + usage_value.getText());
					Actions action = new Actions(driver);
					action.doubleClick(usage_value).perform();
					Textbox.sendKeys(usagevalue);
					Save_button.click();
					test.log(Status.INFO, "The usage value after updating  is: " + usage_value.getText());
					System.out.println("The usage value after updating is: " + usage_value.getText());
				}

				if (ColumnHeader.equals("AUS_GDV")) {
					String AUSGDV_value = AUS_GDV_value.getText();
					test.log(Status.INFO, "scrolled to AUS_GDV and the value is :  " + AUSGDV_value);
					System.out.println(AUSGDV_value);
					Thread.sleep(2000);
					if (AUSGDV_value.equalsIgnoreCase("0")) {
						Actions action = new Actions(driver);
						action.doubleClick(AUS_GDV_value).perform();
						Textbox.sendKeys("1");
						Save_button.click();

					} else {
						Actions action = new Actions(driver);
						action.doubleClick(AUS_GDV_value).perform();
						Textbox.sendKeys("0");
						Save_button.click();
					}
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	///////////////////////////////////////////////////
	
	public void Validate_USAGE_YIELD_Linesheet(String colorway,ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		FilterTextbox.sendKeys(colorway);
		
		ArrayList<String> header = new ArrayList<String>();
		header = getPlacementviewColumnHeaderValue();
		for (int i = 0; i < header.size(); i++) {
			String ColumnHeader = header.get(i);
			scroll(i + 3);
			Thread.sleep(300);
			System.out.println(ColumnHeader);
			
			if (ColumnHeader.equals("Yield/Usage")) {
				System.out.println("USAGE/ YIELD value in Linesheet is:  "+usage_value.getText()+"  after sending blank USAGE/ YIELD value in placement loader file");
				test.log(Status.INFO,"USAGE/ YIELD value in Linesheet is:  "+usage_value.getText()+"  after sending blank USAGE/ YIELD value in placement loader file");
				addSrceenShot("USAGE/ YIELD value in Linesheet is:  "+usage_value.getText()+"  after sending blank USAGE/ YIELD value in placement loader file", test, Capture);
			}
		}	
	}

}
