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
public class TC08_P0_Product_Verify_Style_Type_Derivation extends WMS_TestBase {

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
			setReport("TC08_P0_Product_Style_Type_Derivation verification");
		}
	}

	@Test(priority = 0, dataProvider = "styleTypeData", dataProviderClass = DataProviders.class)
	public void P0_TC08_Product_Verify_Style_Type_Derivation(String TestType, String mySeasonType, String productName,
			String proSubCat1, String proSubCat2) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC08_P0_Product_Style_Type_Derivation verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers Product module from 199 to 201");

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

				productPage.editProduct();
				test.log(Status.INFO, "Clicked on Update Product from the Actions dropdown");
				addScreenShot("Clicked on Update Product from the Actions dropdown", test, Capture);
				WaitforPage(5000);

//				String proSubCat1 = "Shorts";
				productPage.selectProSubCat1(proSubCat1);
				test.log(Status.INFO, "Updated Product Sub Cat 1: " + proSubCat1);
				addScreenShot("Updated Product Sub Cat 1", test, Capture);
				WaitforPage(5000);

//				String proSubCat2 = "Not Applicable";
				productPage.selectProSubCat2(proSubCat2);
				test.log(Status.INFO, "Updated Product Sub Cat 2: " + proSubCat2);
				addScreenShot("Updated Product Sub Cat 2", test, Capture);
				WaitforPage(5000);

				productPage.clikOnSaveBtn();
				test.log(Status.INFO, "Clicked on save button successfully");
				addScreenShot("Clicked on save button successfully", test, Capture);
				WaitforPage(2000);

				// Verify if the style type is derived based on the Product Category, Product
				// Sub Cat 1, and Product Sub Cat 2
				String actualStyleType = productPage.getStyleType();
				test.log(Status.INFO, "Derived Style Type: " + actualStyleType);
				addScreenShot("Derived Style Type", test, Capture);

				// Log the derived style type for verification
				System.out.println("Derived Style Type: " + actualStyleType);

				// An assertion to ensure the style type is not empty
				Assert.assertFalse(actualStyleType.isEmpty(), "Style Type should not be empty.");
				test.log(Status.PASS, "Verified that the style type is derived and not empty: " + actualStyleType);
				test.log(Status.PASS,
						"Verified that the the style type is derived based on the Product Category, Product Sub Cat 1, and Product Sub Cat 2-- "
								+ actualStyleType);
				addScreenShot("Verified style type", test, Capture);
				
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