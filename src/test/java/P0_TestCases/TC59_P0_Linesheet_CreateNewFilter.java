package P0_TestCases;

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

import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC59_P0_Linesheet_CreateNewFilter extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	Palette_Page palettePage;

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

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			palettePage = new Palette_Page(driver);

			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			lseProductSegmentationPage = new LSEProductSegmentationPage(driver);
			popUpPage = new PopUpPage(driver);
			colorWayPage = new ColorWayPage(driver);

			setReport("TC59_P0_Linesheet_ Filter Creation Verification");
		}
	}

	@Test(priority = 0, dataProvider = "linesheetFilterData", dataProviderClass = DataProviders.class)

	public void P0_TC59_Linesheet_CreateNewFilter(String TestType, String mySeasonType, String filterName,
			String attributeValue, String colorwayName) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC59_P0_Linesheet_ Filter Creation Verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers Linesheet- Views & Filters module from 117 to 119");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + Administrator_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String mySeasonType = "Levi's S1 2025 Female Accessories";
			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			lineSheetPage.clickCreateFilterButton();
			System.out.println("Clicked On Create filter button");
			test.log(Status.INFO, "Clicked On Filetr button");
			addSrceenShot("Clicked On Filter button", test, Capture);

//				String filterName = "TestFilter_nine";
			lineSheetPage.enterFilterName(filterName);
			System.out.println("Entered filter name");
			test.log(Status.INFO, "Entered filter name: " + filterName);
			addSrceenShot("Entered filter name", test, Capture);

			lineSheetPage.saveFilter();
			System.out.println("Clicked On Save Filter ");
			test.log(Status.INFO, "Clicked On Save Filter");
			addSrceenShot("Clicked On Save Filter", test, Capture);

//				String attributeValue = "Colorway\\Name";
//				String colorwayName = "blues";
			lineSheetPage.addToFilters(attributeValue, colorwayName, test);
			test.log(Status.INFO, "Added Filters: Attribute - " + attributeValue + ", Colorway - " + colorwayName);
			addSrceenShot("added all Filters", test, Capture);

			lineSheetPage.clickUpdateButton(test);
			test.log(Status.INFO, "Clicked on Update Button");
			addSrceenShot("Clicked on Update Button", test, Capture);

			lineSheetPage.clickReturnButton(test);
			test.log(Status.INFO, "Clicked on Return Button");
			addSrceenShot("Clicked on Return Button", test, Capture);

			lineSheetPage.clickFiltersDropdown(test);
			test.log(Status.INFO, "Clicked on Filters dropdown");
			addSrceenShot("Clicked on Filters dropdown", test, Capture);

			// Verify filter appears in search criteria
			boolean isFilterPresent = lineSheetPage.isFilterPresentInSearchCriteria(filterName, test);
			Assert.assertTrue(isFilterPresent, "Filter is not present in search criteria");
			test.log(Status.PASS, "Verified filter appears in search criteria: " + filterName);
			addSrceenShot("Verified filter appears in search criteria", test, Capture);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
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

//Assert.assertTrue(lineSheetPage.isFilterCreated(), "filter was not created successfully");
//System.out.println("filter was created successfully ");
//test.log(Status.INFO, "filter was created successfully");
//addSrceenShot("filter was created successfully", test, Capture);
