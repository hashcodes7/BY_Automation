package TestData_Testcases;

import static org.testng.Assert.assertNotNull;

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
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.LogEntry_page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC01_P3_CreateFabricTypeMaterial_CheckLogEntry extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;
	LogEntry_page LogEntrypage;

	boolean Capture = true;
	private String pds_URL;
	private String admin_URL;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a PDS user before executing this test case
	 * Need to check Log entry with Administrator User
	 */

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			pds_URL = PDS_URL;
			LaunchSpecific_URL(pds_URL);
			initializePages();
			setReport("TC01_P3_CreateFabricTypeMaterial_CheckLogEntry");
		}
	}

	/**
	 * Navigate to the Administrator URL to check log entry because PDS user does
	 * not have log entry access.
	 */

	public void navigateToAdministratorURL() throws InterruptedException {
		admin_URL = Administrator_URL;
		LaunchSpecific_URL(admin_URL);

	}

	public void initializePages() {
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		seasonPage = new SeasonPage(driver);
		productPage = new ProductPage(driver);
		lineSheetPage = new LineSheetPage(driver);
		materialPage = new MaterialPage(driver);
		createNewProductPage = new CreateNewProductPage(driver);
		LogEntrypage = new LogEntry_page(driver);
	}

	@Test(priority = 0, dataProvider = "TC01_P3_CreateMaterial_CheckLogEntry", dataProviderClass = DataProviders.class)
	public void P3_TC01_CreateFabricTypeMaterial_CheckLogEntry(String TestType, String typeOfFabric, String fabricType,
			String seasonFirstIntroduced, String fabricDescription, String uom, String LogEntryObject, String event, Map<String, String> fabricContents)
			throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P3_CreateFabricTypeMaterial_CheckLogEntry:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			test.log(Status.INFO,
					"This test case covers TestData_Scripts(P3) o9 ntegration (Create a Material changing the values of integrating attributes_FIRST ONE)");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + pds_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addSrceenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

			materialPage.createNewMaterial();
			System.out.println("Clicked on Create New Material");
			test.log(Status.INFO, "Clicked on Create New Material");
			addSrceenShot("Clicked on Create New Material", test, Capture);
			WaitforPage(4000);

			materialPage.chooseFabricType(typeOfFabric);
			System.out.println("Fabric type was choosen");
			test.log(Status.INFO, "Fabric type was choosen: " + typeOfFabric);
			addSrceenShot("Fabric type was choosen", test, Capture);
			WaitforPage(4000);

			materialPage.enterFabricType(fabricType);
			System.out.println("Entered Fabric Type: " + fabricType);
			test.log(Status.INFO, "Entered Fabric Type: " + fabricType);
			addSrceenShot("Entered Fabric Type", test, Capture);
			WaitforPage(4000);

			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
			addSrceenShot("Entered Season First Introduced", test, Capture);
			WaitforPage(4000);

			materialPage.enterFabricDescription(fabricDescription);
			System.out.println("Entered Fabric Description: " + fabricDescription);
			test.log(Status.INFO, "Entered Fabric Description: " + fabricDescription);
			addSrceenShot("Entered Fabric Description", test, Capture);
			WaitforPage(4000);

			materialPage.enterUOM(uom);
			System.out.println("Entered UOM: " + uom);
			test.log(Status.INFO, "Entered UOM: " + uom);
			addSrceenShot("Entered UOM", test, Capture);
			WaitforPage(4000);

			materialPage.setFabricContent(fabricContents, test);
			test.log(Status.INFO, "Fabric Contents: " + fabricContents.toString());
			addSrceenShot("Fabric Contents", test, Capture);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Capture the current time in GMT after click on save button
			LocalDateTime saveTime = LocalDateTime.now(ZoneId.of("GMT"));
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String createddate = saveTime.format(dateFormatter);

			boolean isMaterial_Created = materialPage.isMaterialCreated(fabricDescription, test);
			if (isMaterial_Created) {
				System.out.println("Material was created successfully.");
				test.log(Status.PASS, "Material was created successfully: " + fabricDescription);
				addSrceenShot("Material was created successfully.", test, Capture);
			} else {
				System.out.println("Failed to create new material.");
				test.log(Status.FAIL, "Failed to create new material.");
				addSrceenShot("Failed to create new material.", test, Capture);
			}

			// Log the exact date
			test.log(Status.INFO, "Material created on date: " + createddate);
			System.out.println("Material created on date: " + createddate);
			addSrceenShot("Material created on date", test, Capture);

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

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Test case failed due to exception: " + e.getMessage());
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}