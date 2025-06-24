package P0_TestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC42_P0_Initiate_FitBlock_Sample_Request extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
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
			LaunchSpecific_URL(Fit_developer_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("P0_TC42_Initiate_FitBlock_Sample_Request");
		}
	}

	@Test(priority = 0, dataProvider = "fitBlockSampleData", dataProviderClass = DataProviders.class)
	public void P0_TC42_Initiate_FitBlock_Sample_Request(String TestType, String productName, String requestName,
			String quantity, String sampleRequestType) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::P0_TC42_Initiate_FitBlock_Sample_Request:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers Product module from 205 to 209");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + Fit_developer_URL);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addSrceenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_PRODUCT.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			test.log(Status.INFO, "Clicked on Main menu of Libraries");
			System.out.println("Clicked on season group association");
			test.log(Status.INFO, "Clicked on Product");
			WaitforPage(4000);

//			String productName = "FIT 102 Women Boyfriend shirt";
			productPage.filterProductByName(productName);
			System.out.println("Fit Block Record Was Selected");
			test.log(Status.INFO, "Fit Block Record Was Selected: " + productName);
			addSrceenShot("Fit Block Record Was Selected", test, Capture);

			productPage.selectSourcingTab();
			System.out.println("Selected Sourcing tab");
			test.log(Status.INFO, "Selected Sourcing tab");
			addSrceenShot("Selected Sourcing tab", test, Capture);
			WaitforPage(4000);

			productPage.clickOnSamples();
			System.out.println("Clicked on Samples");
			test.log(Status.INFO, "Clicked on Samples");
			addSrceenShot("Clicked on Samples", test, Capture);
			WaitforPage(4000);

			productPage.selectSource();
			test.log(Status.INFO, "Source was selected successfully");
			addSrceenShot("Source was selected successfully", test, Capture);
			WaitforPage(4000);

			productPage.selectSpecifications();
			test.log(Status.INFO, "Specification was selected successfully");
			addSrceenShot("Specification was selected successfully", test, Capture);
			WaitforPage(4000);

			productPage.clickOnNewSamples();
			System.out.println("Clicked on New Samples");
			test.log(Status.INFO, "Clicked on New Samples");
			addSrceenShot("Clicked on New Samples", test, Capture);
			WaitforPage(4000);

			// Fill in mandatory fields
//			String requestName = "Sample Request automation7";
//			String quantity = "5";
//			String sampleRequestType = "Fit Development";

			productPage.enterRequestName(requestName);
			System.out.println("Entered Request Name: " + requestName);
			test.log(Status.INFO, "Entered Request Name: " + requestName);
			addSrceenShot("Entered Request Name", test, Capture);
			WaitforPage(2000);

			productPage.selectSampleRequestType(sampleRequestType);
			System.out.println("Sample Request Type Was Selected: " + sampleRequestType);
			test.log(Status.INFO, "Sample Request Type Was Selected: " + sampleRequestType);
			addSrceenShot("Sample Request Type Was Selected", test, Capture);
			WaitforPage(2000);

			productPage.enterQuantity(quantity);
			System.out.println("Entered Quantity: " + quantity);
			test.log(Status.INFO, "Entered Quantity: " + quantity);
			addSrceenShot("Entered Quantity", test, Capture);
			WaitforPage(2000);

			productPage.clickOnCreate();
			System.out.println("Clicked on Create");
			test.log(Status.INFO, "Clicked on Create");
			test.log(Status.INFO, "Updated Required Data");
			addSrceenShot("Clicked on Create", test, Capture);
			WaitforPage(4000);

			productPage.clickOnSave();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);

			// Navigate to Product, Sourcing, and Samples sections to verify
			productPage.navigateToProduct();
			System.out.println("Navigated to Product");
			test.log(Status.INFO, "Navigated to Product");
			addSrceenShot("Navigated to Product", test, Capture);
			WaitforPage(4000);

			productPage.selectSourcingTab();
			System.out.println("Selected Sourcing tab");
			test.log(Status.INFO, "Selected Sourcing tab");
			addSrceenShot("Selected Sourcing tab", test, Capture);
			WaitforPage(4000);

			productPage.clickOnSamples();
			System.out.println("Clicked on Samples");
			test.log(Status.INFO, "Clicked on Samples");
			addSrceenShot("Clicked on Samples", test, Capture);
			WaitforPage(4000);

			// Verification step
			boolean isSampleRequestDisplayed = productPage.isSampleRequestDisplayed(requestName);
			if (isSampleRequestDisplayed) {
				System.out.println("New sample request reference is displayed on the Product/Sourcing/Sample page");
				test.log(Status.PASS, "New sample request reference is displayed on the Product/Sourcing/Sample page: "
						+ requestName);
				addSrceenShot("New sample request reference is displayed", test, Capture);
			} else {
				System.out.println("New sample request reference is NOT displayed on the Product/Sourcing/Sample page");
				test.log(Status.FAIL,
						"New sample request reference is NOT displayed on the Product/Sourcing/Sample page");
				addSrceenShot("New sample request reference is NOT displayed", test, Capture);
			}

			WaitforPage(4000);

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