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

import com.WMS_ApplicationPages.Palette_Page;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC07_P0_Create_Levis_Accessories_Seasonal_Palette extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	Palette_Page palettePage;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			palettePage = new Palette_Page(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC07_P0_Verify_Creation_Of_Levis_Accessories_Seasonal_Palette");
		}
	}

	@Test(priority = 0, dataProvider = "paletteCreationData", dataProviderClass = DataProviders.class)
	public void P0_TC07_Create_Levis_Male_Tops_Palette(String TestType, String seasonType, String prodCat1,
			String prodCat2, String brand, String capsule, String gender, String category, String reverseSeason)
			throws Exception {
		try {
			if (CloseBrowser) {

				test = extent.createTest(":::TC07_P0_Verify_Creation_Of_Levis_Accessories_Seasonal_Palette:::");
			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);
			
			test.log(Status.INFO, "This test case covers season module 225");


			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully");
			addScreenShot("login to flex PLM application successfully", test, Capture);

			Thread.sleep(5000);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addScreenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addScreenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_PALETTE.menu(), true);
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on palette");
			test.log(Status.INFO, "Clicked on palette");
			WaitforPage(4000);

			palettePage.clikOnNewBtn();
			test.log(Status.INFO, "Clicked on New button to create Palette");
			addScreenShot("New palette creation started", test, Capture);

//			String seasonType = "Dockers S3 2021 Female Bottoms";
			palettePage.selectSeason(seasonType, test);
			test.log(Status.INFO, "Season is chosen: " + seasonType);
			addScreenShot("Selected the season", test, Capture);

			palettePage.enterName(seasonType, test);
			test.log(Status.INFO, "Entered name: " + seasonType);
			addScreenShot("Entered name", test, Capture);

//			String prodCat1 = "Cold Winter";
			palettePage.selectProdCat1(prodCat1, test);
			test.log(Status.INFO, "Product Category 1 is chosen: " + prodCat1);
			addScreenShot("Selected Product Category 1", test, Capture);

//			String prodCat2 = "Blouses";
			palettePage.selectProdCat2(prodCat2, test);
			test.log(Status.INFO, "Product Category 2 is chosen: " + prodCat2);
			addScreenShot("Selected Product Category 2", test, Capture);

//			String brand = "Dockers";
			palettePage.selectBrand(brand, test);
			test.log(Status.INFO, "Brand is chosen: " + brand);
			addScreenShot("Selected Brand", test, Capture);

//			String capsule = "501";
			palettePage.selectCapsule(capsule, test);
			test.log(Status.INFO, "Capsule is chosen: " + capsule);
			addScreenShot("Selected Capsule", test, Capture);

//			String gender = "Female";
			palettePage.selectGender(gender, test);
			test.log(Status.INFO, "Gender is chosen: " + gender);
			addScreenShot("Selected Gender", test, Capture);

//			String category = "Tops";
			palettePage.selectCategory(category, test);
			test.log(Status.INFO, "Category is chosen: " + category);
			addScreenShot("Selected Category", test, Capture);

//			String reverseSeason = "Yes";
			palettePage.selectreverseSeason(reverseSeason, test);
			test.log(Status.INFO, "Reverse Season is chosen: " + reverseSeason);
			addScreenShot("Selected Reverse Season", test, Capture);

			palettePage.clikOnCreateBtn(test);
			test.log(Status.INFO, "Clicked on Create button");
			addScreenShot("Clicked on Create button", test, Capture);

			// Verify New Palette Page is created
            boolean isPalettePageDisplayed = palettePage.isNewPalettePageDisplayed(test);
            Assert.assertTrue(isPalettePageDisplayed, "New Palette Page is not displayed!");

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
