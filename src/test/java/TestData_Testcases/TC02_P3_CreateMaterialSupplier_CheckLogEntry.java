package TestData_Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
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
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC02_P3_CreateMaterialSupplier_CheckLogEntry extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	LogEntry_page LogEntrypage;

	boolean Capture = true;
	private String pds_URL;
	private String admin_URL;

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
			setReport("TC02_P3_CreateMaterialSupplier_CheckLogEntry");
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
		materialPage = new MaterialPage(driver);
		LogEntrypage = new LogEntry_page(driver);
	}

	@Test(priority = 0, dataProvider = "TC02_P3_CreateMaterialSupplier_CheckLogEntry", dataProviderClass = DataProviders.class)
	public void P3_TC02_CreateMaterialSupplier_CheckLogEntry(String TestType, String materialType, String materialName,
			String supplier, String LogEntryObject, String event)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC02_P3_CreateMaterialSupplier_CheckLogEntry:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO,
					"This test case covers TestData_Scripts(P3) o9 ntegration (Create a Material changing the values of integrating attributes_SECOND ONE)");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL " + pds_URL);
			addScreenShot("Login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addScreenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			WaitforPage(4000);

			materialPage.selectMaterialType(materialType, test);
			System.out.println("Fabric Record Type Was choosen");
			test.log(Status.INFO, "Fabric Record Type Was choosen: " + materialType);
			addScreenShot("Fabric Record Type Was choosen", test, Capture);
			WaitforPage(4000);

			materialPage.searchMaterial(materialName, test);
			System.out.println("Searched for the Material");
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addScreenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);

			materialPage.clickOnMaterial(materialName);
			System.out.println("Ciicked On material: " + materialName);
			test.log(Status.INFO, "Ciicked On material: " + materialName);
			addScreenShot("Ciicked On material: ", test, Capture);

			materialPage.addSupplier(supplier, test);
			System.out.println("Searched and selected supplier");
			test.log(Status.INFO, "Searched and selected supplier:: " + supplier);
			addScreenShot("Searched and selected supplier:", test, Capture);
			WaitforPage(5000);

			// Capture the current time in GMT after adding supplier
			LocalDateTime saveTime = LocalDateTime.now(ZoneId.of("GMT"));
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String createddate = saveTime.format(dateFormatter);

			boolean isSupplierInDropdown = materialPage.verifySupplierInDropdown(supplier, test);
			if (isSupplierInDropdown) {
				System.out.println("Supplier appears in the dropdown menu for the material.");
				test.log(Status.PASS, "Verification: Supplier appears in the dropdown menu for the material.");
				addScreenShot("Supplier appears in the dropdown menu for the material", test, Capture);
			} else {
				System.out.println("Supplier does not appear in the dropdown menu for the material.");
				test.log(Status.FAIL, "Supplier does not appear in the dropdown menu for the material.");
				addScreenShot("Supplier does not appear in the dropdown menu for the material", test, Capture);
			}

			boolean isNoColorInDropdown = materialPage.verifyNoColorInDropdown(test);
			if (isNoColorInDropdown) {
				System.out.println("'No color' created under 'Colors' tab for the material-supplier combination");
				test.log(Status.PASS,
						"Verification: 'No color' created under 'Colors' tab for the material-supplier combination");
				addScreenShot("'No color' created under 'Colors' tab for the material-supplier combination", test,
						Capture);
			} else {
				System.out.println("'No color' does not appear in the Material color dropdown.");
				test.log(Status.FAIL, "'No color' does not appear in the Material color dropdown.");
				addScreenShot("'No color' does not appear in the Material color dropdown", test, Capture);
			}

			// Log the exact date
			test.log(Status.INFO, "material Supplier created on date: " + createddate);
			System.out.println("material Supplier created on date: " + createddate);
			addScreenShot("material Supplier created on date: ", test, Capture);

			WaitforPage(4000);
			driver.manage().deleteAllCookies();
			openNewTabAndSwitch();
			navigateToAdministratorURL();
			test.log(Status.INFO, "Open new tab and Navigate to the Administrative User for checking Log Entry: - URL - " + admin_URL);
			addScreenShot("Navigate to the Administrative User", test, Capture);
			Thread.sleep(4000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_LOG_ENTRY.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addScreenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(2000);

			LogEntrypage.select_LogEntryObject(LogEntryObject, test);
			System.out.println("Log Entry Object is selected ");
			test.log(Status.INFO, "Log Entry Object is selected");
			addScreenShot("Log Entry Object is selected", test, Capture);
			Thread.sleep(2000);

			LogEntrypage.Add_criteria(event, createddate, test);
			System.out.println("Criteria is added ");
			test.log(Status.INFO, "Criteria is added");
			addScreenShot("Criteria is added", test, Capture);
			Thread.sleep(2000);

			LogEntrypage.clickedFirst_viewdetails();
			System.out.println("view details page is opened ");
			test.log(Status.INFO, "view details page is opened ");

			Thread.sleep(3000);
			LogEntrypage.validate_Logdetails(event, LogEntryObject, test);
			System.out.println("Validation successful for Log Entry details ");
			test.log(Status.PASS, "Validation successful for Log Entry details");
			addScreenShot("Validation successful for Log Entry details", test, Capture);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);

		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}
