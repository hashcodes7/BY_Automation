package P1_Testcases;

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

@Test(enabled = true, groups= {"P1_TC"})
public class TC230_P1_CreateSeasonalPalette extends WMS_TestBase {

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

			setReport("TC230_P1_CreateSeasonalPalette verification");
		}
	}

	@Test(priority = 0, dataProvider = "createPaletteData", dataProviderClass = DataProviders.class)
	public void P1_TC230_CreateSeasonalPalette(String TestType, String season, String paletteName, String seasonType,
			String category, String gender, String brand, String colorItem, String materialName,
			String materialColorName) throws Exception {

		if (CloseBrowser) {

			test = extent.createTest(":::TC230_P1_CreateSeasonalPalette verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers P1 Season module from TC230 to TC235");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + Administrator_URL);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S3 2024 Male Accessories";
			seasonPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen : " + season);
			addSrceenShot("Season type is choosen", test, Capture);

			seasonPage.clickOnPalette();
			test.log(Status.INFO, "Clicked on palette button");
			addSrceenShot("Clicked on pallet button", test, Capture);
			Thread.sleep(4000);

//			String paletteName = "Levi's S3 2024 Male Accessories";
//			String seasonType = "Levi's S3 2024 Male Accessories";
//			String category = "Tops";
//			String gender = "Male";
//			String brand = "Levi's";
			seasonPage.createPalette(paletteName, seasonType, brand, gender, category, test);
			test.log(Status.INFO, "Palette created: " + paletteName);
			addSrceenShot("Palette created", test, Capture);
			Thread.sleep(4000);

			String expectedPallteName = seasonPage.getPaletteName();
			Assert.assertEquals(paletteName, expectedPallteName);
			test.log(Status.PASS, "Seasonal Palette Was Created Successfully: " + expectedPallteName);
			addSrceenShot("Page title verified", test, Capture);
			Thread.sleep(4000);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_Season.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on season");
			test.log(Status.INFO, "Clicked on season");
			WaitforPage(4000);

			seasonPage.goToSeasonViewPage(season, test);
			addSrceenShot("Season View Page Was Opened", test, Capture);
			System.out.println("Season View Page Was Opened");
			test.log(Status.INFO, "Season View Page Was Opened");
			WaitforPage(4000);

			boolean isPaletteLinkPresent = seasonPage.isPaletteLinkPresent(paletteName, test);
			Assert.assertTrue(isPaletteLinkPresent, "Palette link is not present");
			test.log(Status.PASS, "Verified palette link is present: " + paletteName);
			addSrceenShot("Palette link verified", test, Capture);
			WaitforPage(4000);

			seasonPage.chooseMySeasonType(season);
			System.out.println("Season type is chosen");
			test.log(Status.INFO, "Season type is chosen: " + season);
			addSrceenShot("Season type is chosen", test, Capture);
			WaitforPage(4000);

			// Click on Palette from side menu
			seasonPage.clickOnPalette();
			test.log(Status.INFO, "Clicked on palette button");
			addSrceenShot("Clicked on palette button", test, Capture);
			Thread.sleep(4000);

//			String colorItem = "BFF_FA770833_DDRK_T3_";
			//QA//colorItem//BFF_FA770833_DDRK_T3_
			seasonPage.addColorsToPalette(colorItem, test);
			test.log(Status.INFO, "Colors added to palette: " + colorItem);
			addSrceenShot("Colors added to palette", test, Capture);
			Thread.sleep(4000);

			// Verification: Added selected colors to palette under Colors tab
			boolean isColorAdded = seasonPage.isColorAddedToPalette(colorItem, test);
			Assert.assertTrue(isColorAdded, "Selected colors were not added to the palette under Colors tab");
			test.log(Status.PASS, "Verified selected color was added to the palette under Colors tab");
			addSrceenShot("Verified selected color added to palette", test, Capture);
			Thread.sleep(4000);

//			String materialName = "236206 Test_ FinishRecepie";
			seasonPage.addMaterialsToPalette(materialName, test);
			test.log(Status.INFO, "Materials added to palette: " + materialName);
			addSrceenShot("Materials added to palette", test, Capture);
			Thread.sleep(4000);

			// Verification: Added selected material to palette under material tab
			boolean isMaterialAdded = seasonPage.isMaterialAddedToPalette(materialName, test);
			Assert.assertTrue(isMaterialAdded, "Selected Materials were not added to the palette under Colors tab");
			test.log(Status.PASS, "Verified selected Material was added to the palette under Materials tab");
			addSrceenShot("Verified selected material added to palette", test, Capture);
			Thread.sleep(4000);

//			String materialColorName = "236207 Demo_FinsihType_Material_01";
			seasonPage.addMaterialColorToPalette(materialColorName, test);
			test.log(Status.INFO, "Material Color added to palette: " + materialColorName);
			addSrceenShot("Material Color added to palette", test, Capture);
			Thread.sleep(4000);

			// Verification: Added selected material color to palette under material tab
			boolean isMaterialColorAdded = seasonPage.isMaterialColorAddedToPalette(materialColorName, test);
			Assert.assertTrue(isMaterialColorAdded,
					"Selected Material Color was not added to the palette under Colors tab");
			test.log(Status.PASS, "Verified selected Material Color was added to the palette under Materials tab");
			addSrceenShot("Verified selected material Color added to palette", test, Capture);
			Thread.sleep(4000);

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
