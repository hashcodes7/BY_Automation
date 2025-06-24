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
import com.WMS_ApplicationPages.Colorway_page;
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
public class TC03_P0_Validate_ProfitCenter_Creation extends WMS_TestBase {

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
	Colorway_page Colorwaypage;

	boolean Capture = true;
	private String global_URL;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;


	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Global_URL;
			LaunchSpecific_URL(global_URL);
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
			Colorwaypage = new Colorway_page(driver);

			setReport("TC03_P0_Profit Center Values Validation");
		}
	}

	@Test(priority = 0, dataProvider = "profitCenterData", dataProviderClass = DataProviders.class)

	public void P0_TC03_Validate_ProfitCenter_Creation(String TestType, String mySeasonType, String productName, String businessObject) throws Exception {
				if (CloseBrowser) {

					test = extent.createTest(":::TC03_P0_Profit Center Creation Verification:::");

				}

				CloseBrowser = false;

				// ...............................browser launched time starts

				long startTime = System.nanoTime();
				try {

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addSrceenShot("Browser Launched successfully", test, Capture);

				
				test.log(Status.INFO, "This test case covers colorway module from 16 to 18");


				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: " +global_URL);
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
				test.log(Status.INFO, "season type is choosen: "+mySeasonType);
				addSrceenShot("Season type is choosen", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addSrceenShot("Clicked on Line Sheets", test, Capture);

//				String productName = "1890 XX501® JEANS";
				lineSheetPage.filterProductByName(productName, test);
				System.out.println("Clicked on product name");
				test.log(Status.INFO, "Clicked on product name: " +productName);
				addSrceenShot("Clicked on product name", test, Capture);

				Assert.assertTrue(productDetailsPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
				System.out.println("PC5 Details Page is displayed");
				test.log(Status.PASS, "PC5 Details Page is displayed");
				addSrceenShot("PC5 Details Page is displayed", test, Capture);
				
				productDetailsPage.CreateColorway();
				System.out.println("Clicked on Create Colorway");
				test.log(Status.INFO, "Clicked on Create Colorway");
				addSrceenShot("Clicked on Create Colorway", test, Capture);
				WaitforPage(4000);

				// Store all profit center APD values in a list
				List<String> apdValues = Colorwaypage.getAPDValues(test);
				test.log(Status.INFO, "Stored APD values: " + String.join(", ", apdValues));
				addSrceenShot("Stored APD values", test, Capture);

				String Brand = Colorwaypage.getBrand();
				System.out.println("Brand Value: " + Brand);
				test.log(Status.INFO, "Brand Value: " + Brand);

				String ProductCategory = Colorwaypage.getProductCategory();
				System.out.println("Product Category Value: " + ProductCategory);
				test.log(Status.INFO, "Product Category Value: " + ProductCategory);

				String ConsumerPH = Colorwaypage.getConsumerPH();
				System.out.println("Consumer PH Value: " + ConsumerPH);
				test.log(Status.INFO, "Consumer Consumer PH Value: " + ConsumerPH);

				Colorwaypage.openNewTabAndNavigateToBusinessObject(global_URL, test);
				System.out.println("Opened new tab and navigated to the Business Object Library");
				test.log(Status.INFO, "Opened new tab and navigated to the Business Object Library");
				addSrceenShot("Opened new tab and navigated to the Business Object Library", test, Capture);
				WaitforPage(4000);

//				String businessObject = "Profit Center";
				Colorwaypage.selctBusinessObject(businessObject);
				System.out.println("Selected Business Object: " + businessObject);
				test.log(Status.INFO, "Selected Business Object: " + businessObject);
				addSrceenShot("Selected Business Object: ", test, Capture);
				WaitforPage(4000);

				Colorwaypage.fillProfitCenterDetails(Brand, ProductCategory, ConsumerPH, test);
				test.log(Status.INFO, "Filled in Profit Center details");
				addSrceenShot("Filled in Profit Center details", test, Capture);
				WaitforPage(4000);

				List<String> tableValues = Colorwaypage.getProfitCenterTableValues(test);
				test.log(Status.INFO, "Lookup Tables\\Profit Center table values: " + String.join(", ", tableValues));
				addSrceenShot("Lookup Tables\\Profit Center table values", test, Capture);

				boolean allValuesPresent = true;
				List<String> missingValues = new ArrayList<>();
				for (int i = 1; i < apdValues.size(); i++) {// Start from index 1 to skip the first empty value
					String normalizedAPDValue = apdValues.get(i);
					if (!normalizedAPDValue.contains("Levi's")) {
						normalizedAPDValue = normalizedAPDValue.replaceAll("Levi s", "Levi's");
					}
					if (!tableValues.contains(normalizedAPDValue)) {
						allValuesPresent = false;
						missingValues.add(apdValues.get(i));
					}
				}

				if (allValuesPresent) {
					test.log(Status.PASS, "All APD values are present in the Lookup Tables\\Profit Center table");
					test.log(Status.PASS, "Profit Center [APD] values are derived from Brand: " + Brand
							+ ", Product Category: " + ProductCategory + ", Consumer PH: " + ConsumerPH);
					addSrceenShot("All APD values are present in the Lookup Tables\\Profit Center table", test, Capture);
				} else {
					test.log(Status.FAIL, "Some APD values are missing in the Lookup Tables\\Profit Center table");
					addSrceenShot("Some APD values are missing in the Lookup Tables\\Profit Center table", test, Capture);
					test.log(Status.INFO, "Missing APD values: " + String.join(", ", missingValues));

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