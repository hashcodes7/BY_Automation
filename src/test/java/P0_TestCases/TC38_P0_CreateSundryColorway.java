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
public class TC38_P0_CreateSundryColorway extends WMS_TestBase {

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
			launchUrl();
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

			setReport("TC38_P0_ Sundry Colorway Creation Error Validation");
		}
	}

	@Test(priority = 0, dataProvider = "sundryColorwayData", dataProviderClass = DataProviders.class)

	public void P0_TC38_CreateSundryColorway(String TestType, String mySeasonType, String productName, String colorType, String sundryColorName, String productSegmentationLSE_Value, String productSegmentationLSUS_Value) throws Exception {
				if (CloseBrowser) {

					test = extent.createTest(":::TC38_P0_ Sundry Colorway Creation Error Validation:::");

				}

				CloseBrowser = false;

				// ...............................browser launched time starts

				long startTime = System.nanoTime();
				try {

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
	            addSrceenShot("Browser Launched successfully", test, Capture);

				
				test.log(Status.INFO, "This test case covers color module from 37 to 39");


				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: " +URL);
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
//				String mySeasonType = "Levi's S1 2023 Male Accessories";
				mainMenuPage.chooseMySeasonType(mySeasonType);
				System.out.println("season type is choosen");
				test.log(Status.INFO, "season type is choosen: " +mySeasonType);
				addSrceenShot("Season type is choosen", test, Capture);

				mainMenuPage.ClickOnLineSheet();
				System.out.println("Clicked On LineSheet");
				test.log(Status.INFO, "Clicked On LineSheet");
				addSrceenShot("Clicked On LineSheet", test, Capture);

//				String productName = "1890 XX501® JEANS";
				lineSheetPage.filterProductByName(productName, test);
				System.out.println("Clicked on product name");
				test.log(Status.INFO, "Clicked on product name: " +productName);
				addSrceenShot("Clicked on product name", test, Capture);
				
				Assert.assertTrue(productDetailsPage.isPC5DetailsPageDisplayed(test),
						"PC5 Details Page is not displayed.");
				System.out.println("PC5 Details Page is displayed");
				test.log(Status.PASS, "PC5 Details Page is displayed");
				addSrceenShot("PC5 Details Page is displayed", test, Capture);


				productDetailsPage.CreateColorway();
				System.out.println("Clicked on Create Colorway");
				test.log(Status.INFO, "Clicked on Create Colorway");
				addSrceenShot("Clicked on Create Colorway", test, Capture);
				WaitforPage(4000);

				colorWayPage.ClickColorwayLookColor();
				System.out.println("Clicked on Colorway(Look/Color)");
				test.log(Status.INFO, "Clicked on Colorway(Look/Color)");
				addSrceenShot("Colorway(Look/Color)", test, Capture);

//				String colorType ="Sundry Color";
//				String sundryColorName ="Sundry Color";

				popUpPage.selectSundrycolour(colorType, sundryColorName);
				System.out.println("Selected Sundry Color");
				test.log(Status.INFO, "Selected Sundry Color: " +colorType);
				addSrceenShot("Selected Sundry Color", test, Capture);
				WaitforPage(4000);

//				String productSegmentationLSE_Value="A11 - LM Collaborations Alt Length Bottoms";
				colorWayPage.selectProductSegmentationLSE_DropDown(productSegmentationLSE_Value);
				System.out.println("Selected ProductSegmentationLSE value From DropDown");
				test.log(Status.INFO, "Selected ProductSegmentationLSE value From DropDown: " +productSegmentationLSE_Value);
				addSrceenShot("Selected ProductSegmentationLSE value From DropDown", test, Capture);
				WaitforPage(4000);
                
//				String productSegmentationLSUS_Value="13 - LFM Guys Discontinued Other";
				colorWayPage.selectProductSegmentationLSUS_DropDown(productSegmentationLSUS_Value);
				System.out.println("Selected ProductSegmentationLSUS value From DropDown");
				test.log(Status.INFO, "Selected ProductSegmentationLSUS value From DropDown: " +productSegmentationLSUS_Value);
				addSrceenShot("Selected ProductSegmentationLSUS value From DropDown", test, Capture);
				WaitforPage(4000);
				
				colorWayPage.clickOnSave();
				System.out.println("Clicked On save Button");
				test.log(Status.INFO, "Clicked On save Button");
				addSrceenShot("Clicked On save Button", test, Capture);
				WaitforPage(10000);

				boolean isErrorDisplayed = colorWayPage.isErrorMessageDisplayed();
				System.out.println("Checking if error message is displayed.");
				test.log(Status.PASS, "Checking if error message is displayed: " +isErrorDisplayed);
				addSrceenShot("Checking if error message is displayed", test, Capture);



				Assert.assertTrue(isErrorDisplayed, "Error message is not displayed");
				if (isErrorDisplayed) {
					System.out.println("Error message is displayed: Sundry Color is an invalid Type for PC9. Please choose valid Color/Look : Test INFOed");
					test.log(Status.PASS, "Error message is displayed: Sundry Color is an invalid Type for PC9. Please choose valid Color/Look : Test INFOed");
					addSrceenShot("Error message displayed", test, Capture);

				} else {
					System.out.println("Error message is not displayed: Test Failed");
			        test.log(Status.FAIL, "Error message is not displayed: Test Failed");
			        addSrceenShot("Error message not displayed", test, Capture);
			        }
				
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
