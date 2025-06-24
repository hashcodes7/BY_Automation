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

@Test(enabled = true, groups= {"P0_TC"})
public class TC04_P0_Create_Levis_Female_Accessories_Season extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;

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
			setReport("TC04_P0_Verify_Levis_Female_Accessories_Season_Creation");
		}
	}

	@Test(priority = 0, dataProvider = "femaleSeasonCreationData", dataProviderClass = DataProviders.class)
	public void P0_TC04_Create_Levis_Female_Bottoms_Season(String TestType, String seasonType, String productType, String Category,
			String Gender, String Brand, String Year, String season, String seasonCode)
			throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC04_P0_Verify_Levis_Female_Accessories_Season_Creation:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers season module from 219 to 221");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: "+Administrator_URL);
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

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_Season.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on season");
			test.log(Status.INFO, "Clicked on season");
			WaitforPage(4000);

			seasonPage.clikOnNewBtn();
			System.out.println("New season is successful");
			test.log(Status.INFO, "Clicked on New button to create season");
			addSrceenShot("Clicked on New button to create season", test, Capture);

			// seasonPage.clikOnVerticalBtn();
//			String seasonType = "Levis";
			seasonPage.chooseSeasonType(seasonType);
			test.log(Status.INFO, "season type is choosen: " + seasonType);
			System.out.println("season type is choosen");
			addSrceenShot("Season type is choosen", test, Capture);

			seasonPage.selectProductType(productType);
			test.log(Status.INFO, "product type is choosen: "+productType);
			System.out.println("selected the product type: " + productType);
			addSrceenShot("selected the product type", test, Capture);

			// seasonPage.selectCategory1("Tops");
//			String Category = "Bottoms";
			seasonPage.selectCategory(Category);
			test.log(Status.INFO, "select Category is choosen: " + Category);
			addSrceenShot("select Category is choosen", test, Capture);

//			String gender = "Female";
			seasonPage.selectGender(Gender);
			test.log(Status.INFO, " Gender is choosen: " + Gender);
			addSrceenShot("Gender is choosen", test, Capture);

//			String Brand = "Levi's";
			seasonPage.selectBrand(Brand);
			test.log(Status.INFO, "Brand is choosen: " + Brand);
			addSrceenShot("Brand is choosen", test, Capture);

//			String Year = "2022";
			seasonPage.selectYear(Year);
			test.log(Status.INFO, "Year is choosen: " + Year);
			addSrceenShot("Year is choosen", test, Capture);

//			String season = "S1";
			seasonPage.selectSeason(season);
			test.log(Status.INFO, "season  is choosen: " + season);
			addSrceenShot("season  is choosen", test, Capture);

//			String seasonCode = "2021 Spring";
			seasonPage.selectSeasonCode(seasonCode);
			test.log(Status.INFO, "season code is choosen: " + seasonCode);
			addSrceenShot("season code is choosen", test, Capture);

			seasonPage.clikOnCreateBtn();
			test.log(Status.INFO, "Cliked On Create Button");
			addSrceenShot("Cliked On Create Button", test, Capture); // SeasonDetailsPage

			String expectedSeasonName = Brand + " " + season + " " + Year + " " + Gender + " " + Category;
			String expectedSeasonStatus = "Active";
			String yearLastTwoDigits = Year.substring(2);
			String seasonLastDigit = season.substring(season.length() - 1);
			String expectedSeasonCode = yearLastTwoDigits + seasonLastDigit;

			// Verify Season Name

			String actualSeasonName = seasonPage.getSeasonName(test);
			Assert.assertEquals(actualSeasonName, expectedSeasonName, "Season Name does not match!");
			test.log(Status.PASS, "Verified Season Name: " + actualSeasonName);
			addSrceenShot("Verified Season Name", test, Capture);

			// Verify Season Status
			String actualSeasonStatus = seasonPage.getSeasonStatus(test);
			Assert.assertEquals(actualSeasonStatus, expectedSeasonStatus, "Season Status does not match!");
			test.log(Status.PASS, "Verified Season Status: " + actualSeasonStatus);
			addSrceenShot("Verified Season Status", test, Capture);

			// Verify Season Code
			String actualSeasonCode = seasonPage.getSeasonCode(test);
			Assert.assertEquals(actualSeasonCode, expectedSeasonCode, "Season Code does not match!");
			test.log(Status.PASS, "Verified Season Code: " + actualSeasonCode);
			addSrceenShot("Verified Season Code", test, Capture);

			// Verify Season appears in My Season Drop down
			boolean isSeasonInDropdown = seasonPage.isSeasonInDropdown(expectedSeasonName, test);
			Assert.assertTrue(isSeasonInDropdown, "Season does not appear in My Season Drop down!");
			test.log(Status.PASS, "Verified Season in dropdown: " + expectedSeasonName);
			addSrceenShot("Verified Season in dropdown", test, Capture);

			test.log(Status.PASS, "Season is verified successfully with all attributes");
			addSrceenShot("Season verification successful", test, Capture);

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