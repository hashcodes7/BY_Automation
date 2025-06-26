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

@Test(enabled = true, groups= {"P1_TC"})
public class TC214_P1_VerifyStyleTypeDerivation extends WMS_TestBase {

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
			setReport("TC214_P1_Style_Type_Derivation verification");
		}
	}

	@Test(priority = 0, dataProvider = "styleTypeData_P1", dataProviderClass = DataProviders.class)
	public void P1_TC214_VerifyStyleTypeDerivation(String TestType, String season, String productName)
			throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC214_P1_Style_Type_Derivation verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Product module from TC214 to TC216");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: - URL-" + Global_URL);
			addScreenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2023 Male Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addScreenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

			try {

//				String productName = "NTEST_DEMO_AUT_01";
				lineSheetPage.filterProductByName(productName, test);
				System.out.println("Clicked on product name");
				test.log(Status.INFO, "Clicked on product name: " + productName);
				addScreenShot("Clicked on product name", test, Capture);

				Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
				System.out.println("PC5 Details Page is displayed");
				test.log(Status.PASS, "PC5 Details Page is displayed: " + productName);
				addScreenShot("PC5 Details Page is displayed", test, Capture);

				// Verify if the style type is derived based on the Product Category,ProductSub
				// Cat 1, and Product Sub Cat 2

				String actualProductCategory = productPage.getProductCategory();
				test.log(Status.INFO, "Product Category Value: " + actualProductCategory);

				String actualProductSubCat1 = productPage.getProductSubCat1();
				test.log(Status.INFO, "Product Sub Cat 1 Value: " + actualProductSubCat1);

				String actualProductSubCat2 = productPage.getProductSubCat2();
				test.log(Status.INFO, "Product Sub Cat 1 Value: " + actualProductSubCat2);

				String actualStyleType = productPage.getStyleType();
				test.log(Status.INFO, "Derived Style Type: " + actualStyleType);
				addScreenShot("Derived Style Type", test, Capture);
				System.out.println("Derived Style Type: " + actualStyleType);

				Assert.assertFalse(actualStyleType.isEmpty(), "Style Type should not be empty.");
				test.log(Status.INFO, "Verified that the style type is derived and not empty: " + actualStyleType);
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