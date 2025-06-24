package TestData_Testcases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LogEntry_page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC01_P3_CreateProduct_CheckLogEntry extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	LogEntry_page LogEntrypage;

	boolean Capture = true;
	private String global_URL;
	private String admin_URL;



	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Global user before executing test case
	 * Need to check Log entry with Administrator User
	 */

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Global_URL_STG;
			LaunchSpecific_URL(global_URL);
			initializePages();
			setReport("TC01_P3_CreateProduct_CheckLogEntry");
		}
	}

	/**
	 * Navigate to the Administrator URL to check log entry because Global user does
	 * not have log entry access.
	 */

	public void navigateToAdministratorURL() throws InterruptedException {

		admin_URL = Admin_URL_STG;
		LaunchSpecific_URL(admin_URL);

	}

	public void initializePages() {
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		seasonPage = new SeasonPage(driver);
		productPage = new ProductPage(driver);
		lineSheetPage = new LineSheetPage(driver);
		createNewProductPage = new CreateNewProductPage(driver);
		LogEntrypage = new LogEntry_page(driver);
	}

	@Test(priority = 0, dataProvider = "TC01_P3_CreateProduct_CheckLogEntry", dataProviderClass = DataProviders.class)
	public void P3_TC01_CreateProduct_CheckLogEntry(String TestType, String season, String productName,
			String brandHierarchy, String proSubCat1, String proSubCat2, String classValue, String subClassValue,
			String consumer, String consumerGrp1, String consumerGrp2, String LogEntryObject, String event) throws Exception {

			if (CloseBrowser) {

				test = extent.createTest(":::TC01_P3_CreateProduct_CheckLogEntry:::");

			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();

			try {

				test.log(Status.INFO,
						"This test case covers TestData_Scripts(P3) PIM integration (Create a Product in Season)");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addSrceenShot("Browser Launched", test, Capture);

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: - URL -" + global_URL);
				addSrceenShot("Login successful", test, Capture);

				Thread.sleep(5000);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addSrceenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.clickOnMySeasons();
				test.log(Status.INFO, "Clicked on MySeasons");
				addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

				mainMenuPage.chooseMySeasonType(season);
				System.out.println("season type is choosen");
				test.log(Status.INFO, "season type is choosen: " + season);
				addSrceenShot("Season type is choosen", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addSrceenShot("Clicked on Line Sheets", test, Capture);

				lineSheetPage.createProduct();
				test.log(Status.INFO, "Clicked on Create New product");
				addSrceenShot("Clicked on Create New product", test, Capture);
				WaitforPage(4000);

				productPage.enterProductName(productName);
				test.log(Status.INFO, "Entered product Name successfully: "+productName);
				addSrceenShot("Entered product Name successfully", test, Capture);
				WaitforPage(4000);

				productPage.selectBrandHierarchy(brandHierarchy);
				test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
				addSrceenShot("Entered Brand Hierarchy value successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectProSubCat1(proSubCat1);
				test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
				addSrceenShot("Entered product Sub Cat 1 successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectProSubCat2(proSubCat2);
				test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
				addSrceenShot("Entered product Sub Cat 2 successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectClass(classValue);
				test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
				addSrceenShot("Entered class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectSubClass(subClassValue);
				test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
				addSrceenShot("Entered sub class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectConsumer(consumer);
				test.log(Status.INFO, "Entered consumer successfully: " + consumer);
				addSrceenShot("Entered consumer successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectConsumerGrp1(consumerGrp1);
				test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
				addSrceenShot("Entered consumer Group 1 successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectConsumerGrp2(consumerGrp2);
				test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
				addSrceenShot("Entered consumer Group 2 successfully", test, Capture);
				WaitforPage(5000);

				productPage.clikOnSaveBtn();
				test.log(Status.INFO, "Clicked on save button successfully");
				addSrceenShot("Clicked on save button successfully", test, Capture);
				WaitforPage(2000);

				// Capture the current time in GMT after click on save button
				LocalDateTime saveTime = LocalDateTime.now(ZoneId.of("GMT"));
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String createddate = saveTime.format(dateFormatter);

				productPage.clikViewProduct();
				test.log(Status.INFO, "Clicked on View Product successfully");
				addSrceenShot("Clicked on View Product successfully", test, Capture);
				WaitforPage(2000);

				// Verify product name
				String product_Name = productPage.getProductName();
				if (product_Name.equals(productName)) {
					test.log(Status.PASS, "Product name verification--- PC5 is created: " + productName);
					addSrceenShot("Product name verification", test, Capture);
				} else {
					test.log(Status.FAIL, "Product name verification: Failed");
					addSrceenShot("Product name verification", test, Capture);
				}

				// Log the exact date
				test.log(Status.INFO, "PC5 created on date: " + createddate);
				System.out.println("PC5 created on date: " + createddate);
				addSrceenShot("PC5 created on date", test, Capture);

				WaitforPage(4000);
				driver.manage().deleteAllCookies();
				openNewTabAndSwitch();
				navigateToAdministratorURL();
				test.log(Status.INFO, "Open new tab and Navigate to the Administrative User for checking Log Entry: - URL - " + admin_URL);
				addSrceenShot("Navigate to the Administrative User", test, Capture);
				Thread.sleep(4000);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addSrceenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_LOG_ENTRY.menu());
				test.log(Status.INFO, "Clicked on Libraries menu");
				addSrceenShot("Clicked on Libraries menu", test, Capture);

				Thread.sleep(2000);

				LogEntrypage.select_LogEntryObject(LogEntryObject, test);
				System.out.println("Log Entry Object is selected ");
				test.log(Status.INFO, "Log Entry Object is selected");
				addSrceenShot("Log Entry Object is selected", test, Capture);
				Thread.sleep(2000);

				LogEntrypage.Add_criteria(event, createddate, test);
				System.out.println("Criteria is added ");
				test.log(Status.INFO, "Criteria is added");
				addSrceenShot("Criteria is added", test, Capture);
				Thread.sleep(2000);

				LogEntrypage.clickedFirst_viewdetails();
				System.out.println("view details page is opened ");
				test.log(Status.INFO, "view details page is opened ");

				Thread.sleep(3000);
				LogEntrypage.validate_Logdetails(event, LogEntryObject, test);
				System.out.println("Validation successful for Log Entry details ");
				test.log(Status.PASS, "Validation successful for Log Entry details");
				addSrceenShot("Validation successful for Log Entry details", test, Capture);

				dashboardPage.closeLeftPanel();
				System.out.println("Clicked on close Left plane");
				test.log(Status.INFO, "Clicked on close Left plane");
				addSrceenShot("Clicked on close Left plane", test, Capture);

				dashboardPage.Logout();
				System.out.println("Logout successful");
				test.log(Status.INFO, "Logout successful");
				addSrceenShot("Logout successful", test, Capture);


			} catch (

			Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;
			} 
		}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
