package E2E_Testcases;

import static org.testng.Assert.assertEquals;

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

import com.WMS_ApplicationPages.ColorWayPage;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LSEProductSegmentationPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC302_P0_E2E_Colorway_Activation_LSA extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	ProductDetailsPage productDetailsPage;
	LSEProductSegmentationPage lseProductSegmentationPage;
	PopUpPage popUpPage;
	ColorWayPage colorWayPage;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Affiliate user before executing this test
	 * case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(AFF_URL_STG);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			lseProductSegmentationPage = new LSEProductSegmentationPage(driver);
			popUpPage = new PopUpPage(driver);
			colorWayPage = new ColorWayPage(driver);

			setReport("TC302_P0_E2E_Verification_Of_Activation_LSA_Linesheet");
		}
	}

	@Test(priority = 0, dataProvider = "colorwayCodeData", dataProviderClass = DataProviders.class)
	public void P0_TC302_E2E_ColorwayCodeActivation(String TestType, String mySeasonType, String viewType, String colorWay,
			String affiliateValue, String currentPlannedLifecycleAFF, String firstOnFloorMonthAFF,
			String dlvySelectedAFF, String ticketCode, String lsusStockingCSC, String targetAFFMSRP,
			String priceWhslAFF, String bucketCodeAFF) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC302_P0_E2E_Verification_Of_Activation_LSA_Linesheet:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers E2E module 302");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + AFF_URL_STG);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);
			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);

			lineSheetPage.filterProduct(colorWay, test);
			System.out.println("Filtred ColorWay");
			test.log(Status.INFO, "Filtred ColorWay: " + colorWay);
			addSrceenShot("Filtred ColorWay: ", test, Capture);

//			String affiliateValue = "US Retail";
			lineSheetPage.selectAffiliateAaccordingToTheLocalHub_FromAffiliateDropDown(affiliateValue);
			System.out.println(
					"Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub");
			test.log(Status.INFO,
					"Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub: "
							+ affiliateValue);
			addSrceenShot("Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub",
					test, Capture);


			lineSheetPage.updateAttributes(currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF,
					ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF, bucketCodeAFF, test);

			lineSheetPage.verifyActivation(test);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
			// Note: The "Logout" dropdown menu is not visible for Affiliate users.
			// To make the "Logout" option visible, reduce the screen size by 10%.
			// This can be achieved by pressing "Control" and "-" keys together.
			ReduceScreenSizeBy10Percent();
			Thread.sleep(2000);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);
			
			

		} catch (Exception e) {
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
