package TestData_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LogEntry_page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC01_P3_SeasonCreation_CheckLogEntry extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	LogEntry_page LogEntrypage ;
	Colorway_page Colorwaypage;
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
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			LogEntrypage=new LogEntry_page(driver);
			Colorwaypage =new Colorway_page(driver);
			setReport("TC01_P3_SeasonCreation_CheckLogEntry");
		}
	}

	@Test(priority = 0, dataProvider = "TC01_P3_SeasonCreation_CheckLogEntry", dataProviderClass = DataProviders.class)
	public void P0_TC01_CreateSeason_CheckLogEntry(String TestType, String seasonType, String productType, String Category,
			String Gender, String Brand, String Year, String season, String seasonCode,String createddate,
			String LogEntryObject, String event)
			throws Exception {

		if (CloseBrowser) {

			test = extent.createTest(":::TC01_P3_SeasonCreation_CheckLogEntry:::");
		}
		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers season module from 213 to 215");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + URL);
			addScreenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_Season.menu(), true);
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on season");
			test.log(Status.INFO, "Clicked on season");
			WaitforPage(4000);

			seasonPage.clikOnNewBtn();
			System.out.println("New season is successful");
			test.log(Status.INFO, "Clicked on New button to create season");
			addScreenShot("New season is successful", test, Capture);

//			String seasonType = "Levis";
			seasonPage.chooseSeasonType(seasonType);
			test.log(Status.INFO, "season type is choosen");
			System.out.println("season type is choosen");
			addScreenShot("Season type is choosen", test, Capture);

			seasonPage.selectProductType(productType);
			test.log(Status.INFO, "product type is choosen: "+productType);
			System.out.println("selected the product type: "+productType);
			addScreenShot("selected the product type", test, Capture);

//			String Category = "Accessories";
			seasonPage.selectCategory(Category);
			test.log(Status.INFO, "select Category is choosen");
			addScreenShot("selected the product type", test, Capture);

//			String Gender = "Male";
			seasonPage.selectGender(Gender);
			test.log(Status.INFO, " Gender is choosen");
			addScreenShot("selected the product type", test, Capture);

//			String Brand = "Levi's";
			seasonPage.selectBrand(Brand);
			test.log(Status.INFO, "Brand is choosen");
			addScreenShot("selected the Brand type", test, Capture);

//			String Year = "2022";
			seasonPage.selectYear(Year);
			test.log(Status.INFO, "Year is choosen");
			addScreenShot("selected the year", test, Capture);

//			String season = "S2";
			seasonPage.selectSeason(season);
			test.log(Status.INFO, "season  is choosen");
			addScreenShot("selected the season", test, Capture);

//			String seasonCode = "2022 Spring";
			seasonPage.selectSeasonCode(seasonCode);
			test.log(Status.INFO, "season code is choosen");
			addScreenShot("selected the Season Code", test, Capture);

			seasonPage.clikOnCreateBtn();
			test.log(Status.INFO, "cliked On Create Button");
			addScreenShot("cliked On Create Button", test, Capture);
			Thread.sleep(5000);
			String expectedSeasonName = Brand + " " + season + " " + Year + " " + Gender + " " + Category;
			String expectedSeasonStatus = "Active";
//			String expectedSeasonCode = "244";
			String yearLastTwoDigits = Year.substring(2);
			String seasonLastDigit = season.substring(season.length() - 1);
			String expectedSeasonCode = yearLastTwoDigits + seasonLastDigit;
			System.out.println("Expected Season Code: " + expectedSeasonCode);

			// Verify Season Name

			String actualSeasonName = seasonPage.getSeasonName(test);
			Assert.assertEquals(actualSeasonName, expectedSeasonName, "Season Name does not match!");
			test.log(Status.PASS, "Verified Season Name: " + actualSeasonName);
			addScreenShot("Verified Season Name", test, Capture);

			// Verify Season Status
			String actualSeasonStatus = seasonPage.getSeasonStatus(test);
			Assert.assertEquals(actualSeasonStatus, expectedSeasonStatus, "Season Status does not match!");
			test.log(Status.PASS, "Verified Season Status: " + actualSeasonStatus);
			addScreenShot("Verified Season Status", test, Capture);

			// Verify Season Code
			String actualSeasonCode = seasonPage.getSeasonCode(test);
			Assert.assertEquals(actualSeasonCode, expectedSeasonCode, "Season Code does not match!");
			test.log(Status.PASS, "Verified Season Code: " + actualSeasonCode);
			addScreenShot("Verified Season Code", test, Capture);
			
			driver.navigate().refresh();
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			

			// Verify Season appears in My Season Drop down
			boolean isSeasonInDropdown = seasonPage.isSeasonInDropdown(expectedSeasonName, test);
			Assert.assertTrue(isSeasonInDropdown, "Season does not appear in My Season Drop down!");
			test.log(Status.PASS, "Verified Season in dropdown: " + expectedSeasonName);
			addScreenShot("Verified Season in dropdown", test, Capture);

			test.log(Status.PASS, "Season is verified successfully with all attributes");
			addScreenShot("Season verification successful", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(),MainMenuEnum.LIBRARIES_LOG_ENTRY.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addScreenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(2000);
			
			LogEntrypage.select_LogEntryObject(LogEntryObject,test);
			System.out.println("Log Entry Object is selected ");
			test.log(Status.INFO, "Log Entry Object is selected");
			addScreenShot("Log Entry Object is selected", test, Capture);
			Thread.sleep(2000);

			LogEntrypage.Add_criteria(event,createddate,test);
			System.out.println("Criteria is added ");
			test.log(Status.INFO, "Criteria is added");
			addScreenShot("Criteria is added", test, Capture);
			Thread.sleep(2000);
			
			LogEntrypage.clickedFirst_viewdetails();
			System.out.println("view details page is opened ");
			test.log(Status.INFO, "view details page is opened ");
			
			Thread.sleep(3000);
			
			LogEntrypage.validate_Logdetails(event,LogEntryObject,test);
			System.out.println("Validation successful for Log Entry details ");
			test.log(Status.PASS, "Validation successful for Log Entry details");
			addScreenShot("Validation successful for Log Entry details", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);

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