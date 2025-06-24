package TestData_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BOM_Page;
import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CreateNewProductPage;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductDetailsPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;



import org.openqa.selenium.JavascriptExecutor;
import resources.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC27_P3_BOMAPP_VerifyDataSyncFromFlexPLM extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	BOM_Page BOMPage;
	LineSheetPage lineSheetPage;
	Colorway_page Colorwaypage;
	LineSheet_Edit_Page LineSheetEditPage;
	Colorway_page colorWayPage;
	ProductDetailsPage productDetailsPage;

	boolean Capture = true;
	private String adimin_URL;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			adimin_URL = Administrator_URL;
			LaunchSpecific_URL(adimin_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			BOMPage = new BOM_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			colorWayPage = new Colorway_page(driver);
			productDetailsPage = new ProductDetailsPage(driver);

			setReport("TC27_P3_BOMAPP_VerifyDataSyncFromFlexPLM");
		}
	}

	@Test(priority = 0, dataProvider = "TC27_P3_BOMAPP_VerifyDataSyncFromFlexPLM", dataProviderClass = DataProviders.class)
	public void P3_TC27_BOMAPP_VerifyDataSyncFromFlexPLM(String TestType, String username, String password,
			String season, String productName, String colorName, String productTypeValue, String rigidIndicatorValue,
			String productSegmentationLSE_Value, String productSegmentationLSUS_Value, String hubOfferdToValue)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC27_P3_BOMAPP_VerifyDataSyncFromFlexPLM:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO,
					"This test case covers TestData_Scripts(P3) BOM app (TC_27_BOMs from FlexPLM are correct)");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + adimin_URL);
			addSrceenShot("Login successful", test, Capture);
			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productDetailsPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.INFO, "PC5 Details Page is displayed");
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
			WaitforPage(4000);

//			String colorName = "1839 BLUFF HEATHER3";
			Colorwaypage.select_Color(colorName, test);
			System.out.println("Selected Color: " + colorName);
			test.log(Status.INFO, "Selected  Color: " + colorName);
			addSrceenShot("Selected Color", test, Capture);
			WaitforPage(4000);

			// All mandatory feilds
//			String productTypeValue = "Product";
			colorWayPage.selectProductType(productTypeValue);
			System.out.println("selected ProductType");
			test.log(Status.INFO, "Selected Product Type: " + productTypeValue);
			addSrceenShot("Selected Product Type", test, Capture);
			WaitforPage(4000);

//			String rigidIndicatorValue = "Normal Product";
			colorWayPage.selectRigidIndicator(rigidIndicatorValue);
			System.out.println("selected RigidIndicator");
			test.log(Status.INFO, "Selected Rigid Indicator : " + rigidIndicatorValue);
			addSrceenShot("Selected Product Type", test, Capture);
			WaitforPage(4000);

//			String productSegmentationLSE_Value = "A66 - LFB RT Accessories Belts";
			colorWayPage.selectProductSegmentationLSE_DropDown(productSegmentationLSE_Value);
			System.out.println("Selected ProductSegmentationLSE value From DropDown");
			test.log(Status.INFO,
					"Selected ProductSegmentationLSE value From DropDown: " + productSegmentationLSE_Value);
			addSrceenShot("Selected ProductSegmentationLSE value From DropDown", test, Capture);
			WaitforPage(4000);

//			String productSegmentationLSUS_Value = "5 - LFK Boys 8-20 Discontinued Licensed";
			colorWayPage.selectProductSegmentationLSUS_DropDown(productSegmentationLSUS_Value);
			System.out.println("Selected ProductSegmentationLSUS value From DropDown");
			test.log(Status.INFO,
					"Selected ProductSegmentationLSUS value From DropDown: " + productSegmentationLSUS_Value);
			test.log(Status.INFO, "Entered All Mandatory Feilds ");
			addSrceenShot("Selected ProductSegmentationLSUS value From DropDown", test, Capture);
			WaitforPage(4000);

			colorWayPage.clickOnSave();
			System.out.println("Clicked On save Button");
			test.log(Status.INFO, "Clicked On save Button");
			addSrceenShot("Clicked On save Button", test, Capture);
			WaitforPage(4000);

//			String hubOfferdToValue = "Global";
			colorWayPage.selectHubOfferdToValue(hubOfferdToValue);
			System.out.println("selected HubOfferd To Value");
			test.log(Status.INFO, "selected HubOfferd To Value : " + hubOfferdToValue);
			addSrceenShot("selected HubOfferd To Value", test, Capture);
			WaitforPage(4000);

			colorWayPage.clickOnViewProduct();
			System.out.println("Clicked On ViewProduct");
			test.log(Status.INFO, "Clicked On View Product");
			addSrceenShot("Clicked On View Product", test, Capture);
			WaitforPage(4000);

			// Verify PC9 creation and non-required attributes
			boolean isPC9Created = Colorwaypage.verifyPC9Creation(test);
			Assert.assertTrue(isPC9Created, "PC9 was not created successfully.");
			System.out.println("PC9 was created successfully.");
			test.log(Status.PASS, "Verification: PC9 was created successfully.");
			addSrceenShot("PC9 was created successfully.", test, Capture);

			String PC9Code = Colorwaypage.getColorwayCode();
			System.out.println("Colorway Code of the created colorway: " + PC9Code);
			test.log(Status.INFO, "Colorway Code of the created colorway: " + PC9Code);
			addSrceenShot("Colorway Code displayed", test, Capture);

			// Navigate to BOM App
			BOMPage.navigate_ToBOMApp();
			test.log(Status.INFO, "Navigated to BOM App");
			addSrceenShot("Navigated to BOM App", test, Capture);

			// Login to BOM App
//			String username = "mankumar@levi.com";
			BOMPage.login(username, password,test);
			addSrceenShot("Logged into BOM App", test, Capture);

			// Select Season and Search for PC9 code
			BOMPage.selectSeason(season);
			test.log(Status.INFO, "Season selected: " + season);
			addSrceenShot("Season selected", test, Capture);

			BOMPage.searchForPC9(PC9Code, test);
			test.log(Status.INFO, "Searched for PC9: " + PC9Code);
			addSrceenShot("Searched for PC9", test, Capture);

			// Check BOM Results menu and click if not "0 of 0 BOMs"
			boolean isBOMClicked = BOMPage.checkAndClickBOM();
			if (isBOMClicked) {
				test.log(Status.INFO, "Clicked on BOM Results menu");
				addSrceenShot("Clicked on BOM Results menu", test, Capture);

				// Extract and check BOM text
				String bomText = BOMPage.extractBOMText();
				Assert.assertTrue(bomText.contains(PC9Code), "BOM text is not correct");
				test.log(Status.INFO, "BOM text is correct");
				test.log(Status.PASS, "Created Colorway In FlexPLM updated in BOM app " + bomText);
				addSrceenShot("BOM text is correct", test, Capture);

			} else {
				test.log(Status.FAIL, "BOM not updated in BOM app");
			}
			
			BOMPage.logout(test);
			test.log(Status.INFO, "Logged out of BOM App");
			addSrceenShot("Logged out of BOM App", test, Capture);
			

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