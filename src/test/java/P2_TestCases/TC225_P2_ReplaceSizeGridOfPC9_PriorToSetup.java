package P2_TestCases;

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
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC225_P2_ReplaceSizeGridOfPC9_PriorToSetup extends WMS_TestBase {

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
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Global user before executing this test
	 * case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Global_URL);
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

			setReport("TC225_P2_Replace Size Grid of PC9 with a Size Grid that has MORE sizes_Prior to Setup");
		}
	}

	@Test(priority = 0, dataProvider = "TC225_P2_ReplaceSizeGridOfPC9_PriorToSetup", dataProviderClass = DataProviders.class)
    public void P2_TC225_ReplaceSizeGridOfPC9_PriorToSetup(String TestType, String season, String viewType, String colorWayName, String globalVaue, String localHubValue, String affiliateValue, String newSizeGridCode) throws Exception {
		if (CloseBrowser) {


			test = extent.createTest(":::TC225_P2_Replace Size Grid of PC9 with a Size Grid that has MORE sizes_Prior to Setup:::");

		
		}
	CloseBrowser=false;

	// ...............................browser launched time starts

	long startTime = System.nanoTime();
	
	try
	{

		test.log(Status.INFO, "This test case covers P2 Sizing module TC225 TO TC228");

		System.out.println("Browser Launched successfully");
		test.log(Status.INFO, "Browser Launched successfully");
		addSrceenShot("Browser Launched", test, Capture);

		System.out.println("login to flex PLM application successfully");
		test.log(Status.INFO, "login to flex PLM application successfully: " + Global_URL);
		addSrceenShot("Login successful", test, Capture);

		Thread.sleep(5000);

		dashboardPage.openLeftPanel();
		System.out.println("Clicked on open Left plane");
		test.log(Status.INFO, "Clicked on open Left plane");
		addSrceenShot("Clicked on open Left plane", test, Capture);

		mainMenuPage.clickOnMySeasons();
		test.log(Status.INFO, "Clicked on MySeasons");
		addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//		String season = "Levi's S1 2025 Male Accessories";
		mainMenuPage.chooseMySeasonType(season);
		System.out.println("season type is choosen");
		test.log(Status.INFO, "season type is choosen: " + season);
		addSrceenShot("Season type is choosen", test, Capture);

		lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
		test.log(Status.INFO, "Clicked on Line Sheets");
		addSrceenShot("Clicked on Line Sheets", test, Capture);

//		String viewType = "Size Selection";
		lineSheetPage.selectViewDropdown(viewType);
		System.out.println("View type is choosen");
		test.log(Status.INFO, "View type is choosen: " + viewType);
		addSrceenShot("View type is choosen", test, Capture);

//		String colorWayName = "0WPVY-0019 *CLOUD NEW 1 PK*";
		lineSheetPage.filterByColorway(colorWayName, test);
		test.log(Status.INFO, "Filtered ColorWay by name: " + colorWayName);
		addSrceenShot("Filtered ColorWay by name: ", test, Capture);
		addSrceenShot("Filtered ColorWay by name", test, Capture);

//		String globalVaue = "Global";
//		String localHubValue = "San Francisco";
//		String affiliateValue = "US Online";

		lineSheetPage.selectSeasonGroups_GB_LH_AFF_Values(globalVaue, localHubValue, affiliateValue, test);
		System.out.println("Season Groups values(GB_LH_AFF) choosen");
		test.log(Status.INFO, "Season Groups values(GB_LH_AFF) choosen");
		addSrceenShot("Season Groups values(GB_LH_AFF) choosen", test, Capture);

//		String newSizeGridCode = "22 - 34 x 28, 30, 32, 34, 36";
		lineSheetPage.replaceSizeGrid(newSizeGridCode, test);
		System.out.println("Size Grid replaced successfully");
		test.log(Status.PASS, "Size Grid replaced successfully: " + newSizeGridCode);
		addSrceenShot("Size Grid replaced successfully", test, Capture);
		WaitforPage(4000);

		// Verify new size grid, sample size, and size scale code on colorway-season
		// page
		lineSheetPage.verifySizeGridDetailsOnColorwaySeasonPage(newSizeGridCode, test);
		System.out.println("Verified size grid details on colorway-season page");
		test.log(Status.PASS, "Verified size grid details on colorway-season page: " + newSizeGridCode);
		addSrceenShot("Verified size grid details on colorway-season page", test, Capture);

		dashboardPage.closeLeftPanel();
		System.out.println("Clicked on close Left plane");
		test.log(Status.INFO, "Clicked on close Left plane");
		addSrceenShot("Clicked on close Left plane", test, Capture);

		dashboardPage.Logout();
		System.out.println("Logout successful");
		test.log(Status.INFO, "Logout successful");
		addSrceenShot("Logout successful", test, Capture);

	}catch(
	Exception e)
	{
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
