package P2_TestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.ColorDetailsPage;
import com.WMS_ApplicationPages.ColorWayPage;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LSEProductSegmentationPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;

import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC216_P2_Product_BusinessObjects_ConsumerMapping_LookTables extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductDetailsPage productDetailsPage;

	ProductPage productPage;
	LineSheetPage lineSheetPage;
	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Admin user before executing this test
	 * case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);

			setReport("TC216_P2_Product_BusinessObjects_ConsumerMapping_LookTables");
		}
	}

	@Test(priority = 0, dataProvider = "TC216_P2_Product_BusinessObjects_ConsumerMapping_LookTables", dataProviderClass = DataProviders.class)
	public void P2_TC216_Product_BusinessObjects_ConsumerMapping_LookTables(String TestType, String businessObject)
			throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC216_P2_Product_BusinessObjects_ConsumerMapping_LookTables:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			test.log(Status.INFO, "This test case covers P2 Product module from TC216 to TC217");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + Administrator_URL);
			addSrceenShot("login successful", test, Capture);

			// Verify FlexPLM homepage is displayed
			Assert.assertTrue(productPage.isHomePageDisplayed(), "FlexPLM homepage is not displayed.");
			System.out.println("FlexPLM homepage is displayed");
			test.log(Status.PASS, "FlexPLM homepage is displayed");
			addSrceenShot("FlexPLM homepage is displayed", test, Capture);

			Thread.sleep(5000);
			productPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_BUSSINESS.menu(), true);
			addSrceenShot("Clicked on 'Business Object' Under Main menu of Libraries", test, Capture);
			System.out.println("Clicked on 'Business Object' Under Main menu of Libraries");
			test.log(Status.INFO, "Clicked on Business Object Under Main menu of Libraries");
			WaitforPage(4000);

//			String businessObject = "Consumer Mapping";
			productPage.navigateToConsumerMapping(businessObject, test);
			System.out.println("Navigated to 'Consumer Mappings'");
			test.log(Status.INFO, "Navigated to 'Consumer Mappings''");
			addSrceenShot("Navigated to 'Consumer Mappings'", test, Capture);
			WaitforPage(4000);

			productPage.verifyLookupTablesCombinations(test);
			System.out.println("All Lookup tables combinations are displayed");
			test.log(Status.PASS, "All Lookup tables combinations are displayed");
			addSrceenShot("All Lookup tables combinations are displayed", test, Capture);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);

		} catch (

		Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;
		}

	}

	@AfterMethod
	public void setUpend() {
		if (driver != null) {

			
			driver.quit();
		}
	}
}