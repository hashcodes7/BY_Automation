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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC01_P0_Palette_CreateNewFilter extends WMS_TestBase {

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

			setReport("TC01_P0_Palette_CreateNewFilter verification");
		}
	}

	@Test(priority = 0, dataProvider = "paletteFilterData", dataProviderClass = DataProviders.class)

	public void P0_TC01_Palette_CreateNewFilter(String TestType, String mySeasonType, String inputName, String attributeValue, String colorCodeNumber) throws Exception {
		
				if (CloseBrowser) {

					test = extent.createTest(":::TC01_P0_Palette_CreateNewFilter verification:::");

				}

				CloseBrowser = false;

				// ...............................browser launched time starts

				long startTime = System.nanoTime();
				try {

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addScreenShot("Browser Launched", test, Capture);

				
				test.log(Status.INFO, "This test case covers color module from 01 to 02");


				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: " + Administrator_URL);
				addScreenShot("Login successful", test, Capture);


				Thread.sleep(5000);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addScreenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.clickOnMySeasons();
				test.log(Status.INFO, "Clicked on MySeasons");
				addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//				String mySeasonType = "Levi's S1 2025 Female Accessories";
				seasonPage.chooseMySeasonType(mySeasonType);
				System.out.println("season type is choosen");
				test.log(Status.INFO, "season type is choosen : " + mySeasonType);
				addScreenShot("Season type is choosen", test, Capture);

				seasonPage.clickOnPalette();
				test.log(Status.INFO, "Clicked on palette button");
				addScreenShot("Clicked on pallet button", test, Capture);
				Thread.sleep(4000);

				String title = driver.getTitle();
				System.out.println(title);
				test.log(Status.INFO, "Page title: " + title);
				Assert.assertTrue(title.equalsIgnoreCase("SeasonPalette"), "Title is not SeasonPalette");
				test.log(Status.INFO, "Verified page title is 'SeasonPalette'");
				addScreenShot("Page title verified", test, Capture);


				// Create new filter
				palettePage.clickCreateNewFilterIcon();
				test.log(Status.INFO, "Clicked on Create NewFilter Icon");
				addScreenShot("Clicked on Create New Filter Icon", test, Capture);

//				String inputName = "new_filter_130";
				palettePage.enterFilterData(inputName);
				test.log(Status.INFO, "Entered Filter Data : " + inputName);
				addScreenShot("Entered Filter Data", test, Capture);

				palettePage.clickCreateButton();
				test.log(Status.INFO, "Clicked on Create Button");
				addScreenShot("Clicked on Create Button", test, Capture);

//				String attributeValue = "Color/Look\\Body Color\\Color Code";
//				String colorCodeNumber = "234564";
				palettePage.addToFilters(attributeValue, colorCodeNumber);
				test.log(Status.INFO, "Added all Filters: " + attributeValue + " = " + colorCodeNumber);
				addScreenShot("added all Filters", test, Capture);

				palettePage.clickUpdateButton();
				test.log(Status.INFO, "Clicked on Update Button");
				addScreenShot("Clicked on Update Button", test, Capture);

				palettePage.clickReturnButton();
				test.log(Status.INFO, "Clicked on Return Button");
				addScreenShot("Clicked on Return Button", test, Capture);
				WaitforPage(4000);

				// Verify filter appears in search criteria
				boolean isFilterPresent = palettePage.isFilterPresentInSearchCriteria(inputName, test);
				addScreenShot("Verified filter appears in search criteria", test, Capture);
				Assert.assertTrue(isFilterPresent, "Filter is not present in search criteria");
				test.log(Status.PASS, "Verified filter appears in search criteria ");
				
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
