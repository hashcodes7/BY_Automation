package E2E_Testcases;

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

@Test(enabled = true, groups = { "E2E_TC" })
public class TC282_P0_E2E_SeasonCreation_FemaleAccessories extends WMS_TestBase {

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
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC282_P0_E2E_Verify_Levis_Female_Accessories season creation");
		}
	}

	    @Test(priority = 0, dataProvider = "levisFemaleAccessoriesData", dataProviderClass = DataProviders.class)
	    public void P0_TC282_E2E_SeasonCreation_FemaleAccessories(String TestType, String seasonType, String productType, String category, String gender, String brand, String year, String season, String seasonCode) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC282_P0_E2E_Verify_Levis_Female_Accessories season creation:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {
			System.out.println("Browser Launched successfully");
			test.log(Status.PASS, "Browser Launched successfully");
			addScreenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers E2E module from 282 to 284");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.PASS, "login to flex PLM application successfully: " + Global_URL);
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
			test.log(Status.INFO, "season type is choosen: " + seasonType);
			System.out.println("season type is choosen");
			addScreenShot("Season type is choosen", test, Capture);

			seasonPage.selectProductType(productType);
			test.log(Status.INFO, "product type is choosen: "+productType);
			System.out.println("product the product type");
			addScreenShot("product the product type", test, Capture);

//			String category = "Accessories";
			seasonPage.selectCategory(category);
			test.log(Status.INFO, "select Category is choosen: " + category);
			addScreenShot("selected the product type", test, Capture);

//			String gender = "Female";
			seasonPage.selectGender(gender);
			test.log(Status.INFO, " Gender is choosen: " + gender);
			addScreenShot("selected the product type", test, Capture);

//			String brand = "Levi's";
			seasonPage.selectBrand(brand);
			test.log(Status.INFO, "Brand is choosen: " + brand);
			addScreenShot("selected the Brand type", test, Capture);

//			String year = "2023";
			seasonPage.selectYear(year);
			test.log(Status.INFO, "Year is choosen: " + year);
			addScreenShot("selected the year", test, Capture);

//			String season = "S1";
			seasonPage.selectSeason(season);
			test.log(Status.INFO, "season  is choosen: " + season);
			addScreenShot("selected the season", test, Capture);

//			String seasonCode = "2023 Spring";
			seasonPage.selectSeasonCode(seasonCode);
			test.log(Status.INFO, "season code is choosen: " + seasonCode);
			addScreenShot("selected the Season Code", test, Capture);

			seasonPage.clikOnCreateBtn();
			test.log(Status.INFO, "cliked On Create Button");
			addScreenShot("cliked On Create Button", test, Capture);
			Thread.sleep(4000);

//			String expectedSeasonName = "Levi's S1 2023 Female Accessories";
			
			String expectedSeasonName = brand + " " + season + " " + year + " " + gender + " " + category;

			// Verify The Season Creation
			seasonPage.verifySeasonCreation(expectedSeasonName, test);
			test.log(Status.PASS, "Season is created successfully: " + expectedSeasonName);
			addScreenShot("Season verification successful", test, Capture);
			
			WaitforPage(4000);

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