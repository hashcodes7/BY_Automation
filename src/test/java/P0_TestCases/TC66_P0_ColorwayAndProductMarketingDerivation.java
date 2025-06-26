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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class TC66_P0_ColorwayAndProductMarketingDerivation extends WMS_TestBase {

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
			setReport("TC66_P0_Product_ColorwayAndProductMarketingNameDerivation Verification");
		}
	}

	@Test(priority = 0, dataProvider = "colorwayAndProductData", dataProviderClass = DataProviders.class)
	public void P0_TC06_Product_Verify_ColorwayAndProductMarketingNameDerivation(String TestType, String mySeasonType,
			String productName, String colourWayName) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC66_P0_Product_ColorwayAndProductMarketingNameDerivation Verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers Product module from 210 to 212");

			//url=global
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: "+Global_URL);
			addScreenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String mySeasonType = "Levi's S1 2025 Male Bottoms";
			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addScreenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

			try {

//				String productName = "NTEST_AM_1";
				lineSheetPage.filterProductByName(productName, test);
				System.out.println("Clicked on product name");
				test.log(Status.INFO, "Clicked on product name: " + productName);
				addScreenShot("Clicked on product name", test, Capture);

				Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
				System.out.println("PC5 Details Page is displayed");
				test.log(Status.PASS, "PC5 Details Page is displayed: " + productName);
				addScreenShot("PC5 Details Page is displayed", test, Capture);

//				String colourWayName = "0WPM7-0001 BLACK HEATHER2 BRUSHED FLEECE";
				productPage.selectColorwayFromMenu(colourWayName, test);
				System.out.println("Clicked on Colorway From Menu");
				test.log(Status.INFO, "Clicked on Colorway From Menu: " + colourWayName);
				addScreenShot("Clicked on Colorway From Menu", test, Capture);

				// Extract details
				String pc9Code = productPage.getPc9Code(test);
				String actualColourwayName = productPage.getColourwayName(test);
				String product_Name = productPage.getProductName(test);
				String actualProductMarketingName = productPage.getProductMarketingName(test);
				String merchFabricType = productPage.getmerchFabricType(test);

				// Navigate to color details page
				productPage.clickOnColorDetailsLink();

				// Extract color details
				String lscoArtworkNameFromColor = productPage.getLscoArtworkName(test);

				// Verify colourway name
				String expectedColourwayName = pc9Code + " " + lscoArtworkNameFromColor + " " + merchFabricType;
				Assert.assertEquals(actualColourwayName, expectedColourwayName, "Colourway name does not match.");
				System.out.println(
						"Colorway name is derived from the PC9 Code & LSCO Artwork Name & MerchFabricType from the color");
				test.log(Status.PASS, "Verified Colourway name: " + actualColourwayName);
				test.log(Status.PASS,
						"Colorway name is derived from the PC9 Code & LSCO Artwork Name & MerchFabricType from the color : "
								+ actualColourwayName);

				// Verify product marketing name
				String expectedProductMarketingName = product_Name + " " + lscoArtworkNameFromColor + " "
						+ merchFabricType;
				Assert.assertEquals(actualProductMarketingName, expectedProductMarketingName,
						"Product Marketing Name does not match.");
				System.out.println(
						"Product Marketing Name is derived from the Product Name &  LSCO Artwork Name & MerchFabricType from the color");
				test.log(Status.PASS, "Verified Product Marketing Name: " + actualProductMarketingName);
				test.log(Status.PASS,
						"Product Marketing Name is derived from the Product Name &  LSCO Artwork Name & MerchFabricType from the color : "
								+ actualProductMarketingName);
				
				
				dashboardPage.Logout();
				System.out.println("Logout successful");
				test.log(Status.PASS, "Logout successful");
				addScreenShot("Logout successful", test, Capture);
				

			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;

			}

		} catch (

		Exception e) {
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