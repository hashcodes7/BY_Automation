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

import com.WMS_ApplicationPages.ColorDetailsPage;
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
public class TC05_P0_VerifyColorwayAndMarketingNames extends WMS_TestBase {

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
	ColorDetailsPage colorDetailsPage;

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
			palettePage = new Palette_Page(driver);

			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			lseProductSegmentationPage = new LSEProductSegmentationPage(driver);
			popUpPage = new PopUpPage(driver);
			colorWayPage = new ColorWayPage(driver);
			colorDetailsPage = new ColorDetailsPage(driver);

			setReport("TC05_P0_Colorway Name and Product Marketing Name Validation");
		}
	}

	@Test(priority = 0, dataProvider = "printAndPatternsData", dataProviderClass = DataProviders.class)

	public void P0_TC05_Validate_PrintAndPatterns(String TestType, String mySeasonType, String productName,
			String colourWayName) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC05_P0_Colorway Name and Product Marketing Name Validation:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts
		try {

			long startTime = System.nanoTime();

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);


			test.log(Status.INFO, "This test case covers colorway module from 22 to 24");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + Global_URL);
			addSrceenShot("login successful", test, Capture);


			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//				String mySeasonType = "Levi's S1 2025 Male Bottoms";
			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//				String productName = "1890 XX501® JEANS";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productDetailsPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed");
			addSrceenShot("PC5 Details Page is displayed", test, Capture);

//			String colourWayName = "90501-0230 new Blues 24";
			productDetailsPage.selectColorwayFromMenu(colourWayName, test);
			System.out.println("Clicked on Colorway From Menu");
			test.log(Status.INFO, "Clicked on Colorway From Menu: " + colourWayName);
			addSrceenShot("Clicked on Colorway From Menu", test, Capture);

			String pc9Code = productDetailsPage.getPc9Code(test);

			String actualColourwayName = productDetailsPage.getColourwayName(test);

			String product_Name = productDetailsPage.getProductName(test);

			String actualProductMarketingName = productDetailsPage.getProductMarketingName(test);

//			 Click the link to navigate to the color details page
//           ColorDetailsPage colorDetailsPage = productDetailsPage.clickOnColorDetailsLink();

			productDetailsPage.clickOnColorDetailsLink();

			String lscoArtworkFromColor = colorDetailsPage.getLscoArtwork(test);

			String lscoArtworkNameFromColor = colorDetailsPage.getLscoArtworkName(test);

			String colorCombo = colorDetailsPage.getColorCombo(test);

			String printType = colorDetailsPage.getPrintType(test);

			// Verify that the colourway name is derived correctly
			String expectedColourwayName = pc9Code + " " + lscoArtworkNameFromColor;

			// Verify that the Product Marketing Name is derived correctly
			String expectedProductMarketingName = product_Name + " " + lscoArtworkFromColor + " " + colorCombo + " "
					+ printType;

			Assert.assertEquals(actualColourwayName, expectedColourwayName, "Colourway name does not match.");
			System.out.println("Colorway name  is  derived from the PC9 Code  & LSCO Artwork Name from the color");
			test.log(Status.PASS, "Verified Colourway name: " + actualColourwayName);

			Assert.assertEquals(actualProductMarketingName, expectedProductMarketingName,
					"Product Marketing Name does not match.");
			System.out.println(
					"Product Marketing Name is  derived from the Product Name &  LSCO Artwork , Color Combo  and  Print Type from the color");
			test.log(Status.PASS, "Verified Product Marketing Name: " + actualProductMarketingName);

			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);
			
			
		} catch (

		Exception e) {
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