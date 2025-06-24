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

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC223_P2_Create_Levis_NON_LSE_Affiliate_Season_Collection extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;

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
			setReport("TC223_P2_Verify_Levis_NON_LSE_Affiliate_Season_Collection_Creation");
		}
	}

	@Test(priority = 0, dataProvider = "TC223_P2_Create_Levis_NON_LSE_Affiliate_Season_Collection", dataProviderClass = DataProviders.class)
	public void P2_TC223_Create_Levis_NON_LSE_Affiliate_Season_Collection(String TestType, String seasonCollectionName,
			String collectionId, String collectionDesc, String seasonDesc, String bookBeginDate, String bookEndDate,
			String shipBeginDate, String shipEndDate, String theme, String themeDesc, String affiliateAdoptGroup,
			String collectionType, String brand, String year, String season) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC223_P2_Verify_Levis_NON_LSE_Affiliate_Season_Collection_Creation:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers season module from 221 to 222");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + URL);
			addSrceenShot("login successful", test, Capture);

			Thread.sleep(5000);
			// dashboardPage.logoutDropdown();
			//
			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_SEASON_COLLECTION.menu(),
					true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on season collection");
			test.log(Status.INFO, "Clicked on season collection");
			WaitforPage(4000);

			seasonPage.clikOnNewBtn();
			System.out.println("Clicked on New button to create Season Collection");
			test.log(Status.INFO, "Clicked on New button to create Season Collection");
			addSrceenShot("Clicked on New button to create Season Collection", test, Capture);


//			String seasonCollectionName = "S1 26 JAPAN LEVI'S";
//			String collectionId = "1360";
//			String collectionDesc = "JAPAN LEVI'S";
//			String seasonDesc = "S1 26";
//			String bookBeginDate = "09/17/2024";
//			String bookEndDate = "12/31/2033";
//			String shipBeginDate = "05/14/2025";
//			String shipEndDate = "12/31/2033";
//			String theme = "0001";
//			String themeDesc = "LEVI'S";
//			String affiliateAdoptGroup = "Levi Strauss Japan GDV (Levis)";
//			String collectionType = "Local";
//			String brand = "Levi's";
//			String year = "2026";
//			String season = "S1";

			seasonPage.fillSeasonCollectionForm(seasonCollectionName, collectionId, collectionDesc, seasonDesc,
					bookBeginDate, bookEndDate, shipBeginDate, shipEndDate, theme, themeDesc, affiliateAdoptGroup,
					collectionType, brand, year, season, test);
			System.out.println("Filled All Season Collection Attributes");
			test.log(Status.INFO, "Filled All Season Collection Attributes");
			addSrceenShot("Filled All Season Collection Attributes", test, Capture);

			seasonPage.clikOnCreate_Btn();
			test.log(Status.INFO, "New Season Collection Created Successfully");
			addSrceenShot("New Season Collection Created Successfully", test, Capture);

			boolean isValid = seasonPage.validateSeasonCollection(seasonCollectionName, collectionId, collectionDesc,
					seasonDesc, bookBeginDate, bookEndDate, shipBeginDate, shipEndDate, theme, themeDesc,
					affiliateAdoptGroup, collectionType, brand, year, season, test);
			Assert.assertTrue(isValid, "Season Collection validation failed!");
			test.log(Status.PASS, "Season Collection is verified successfully with all attributes");
			addSrceenShot("Season Collection verification successful", test, Capture);

			// Validate Season Code
			String expectedSeasonCode = year.substring(2) + season.replaceAll("\\D", "");
			String actualSeasonCode = seasonPage.get_SeasonCode(test);
			Assert.assertEquals(actualSeasonCode, expectedSeasonCode, "Season Code does not match!");
			test.log(Status.PASS, "Verified Season Code: " + actualSeasonCode);
			addSrceenShot("Verified Season Code", test, Capture);

			// Refresh page and ensure no SAP integration
			seasonPage.refreshPageAndValidateNoSAPIntegration(seasonCollectionName, test);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);

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