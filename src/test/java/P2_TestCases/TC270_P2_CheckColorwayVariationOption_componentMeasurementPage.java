package P2_TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Color_Page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.Measurements_Page;

import com.WMS_ApplicationPages.ProductDetailsPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC270_P2_CheckColorwayVariationOption_componentMeasurementPage extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;
	ProductDetailsPage productDetailsPage;
	LineSheetPage lineSheetPage;
	Measurements_Page MeasurementsPage;
	ProductPage productPage;

	boolean Capture = true;

	/**
	 * Note: Ensure you are logged in as a Garment Developer user before executing this test case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(GarmentDeveloper_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			MeasurementsPage = new Measurements_Page(driver);
			productPage = new ProductPage(driver);

			setReport("TC270_P2_Check Colorway Variation Option  while creating component-Measurement page");
		}
	}

	@Test(priority = 0, dataProvider = "TC270_P2_CheckColorwayVariationOption_componentMeasurementPage", dataProviderClass = DataProviders.class)
	public void P2_TC270_CheckColorwayVariationOption(String TestType, String season, String productName,
			String sourceName, String specification, String measurementTemplateName, String measurementsetname,
			String sizes, String measurementType) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC270_P2_Check Colorway Variation Option  while creating component-Measurement page:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 specifications module from TC270 to TC273");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL " + GarmentDeveloper_URL);
			addSrceenShot("Login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addSrceenShot("Clicked on open Left panel", test, Capture);
			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2025 Female Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "TESTING PC9";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(lineSheetPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed");
			addSrceenShot("PC5 Details Page is displayed", test, Capture);
			Thread.sleep(5000);

//			String sourceName = "0WPQ8 - Primary -";
			productPage.selectSourceFromDropDown(sourceName, test);
			System.out.println("selected Source From The Sourcing Drop Down");
			test.log(Status.INFO, "selected Source From The Sourcing Drop Down" + sourceName);
			addSrceenShot("selected Source From The Sourcing Drop Down", test, Capture);

//			String specification = "S1 2025 - 0WPQ8 - TESTING PC9 -";
			MeasurementsPage.selectSpecifications(specification, test);
			System.out.println("Selected specifications " + specification);
			test.log(Status.INFO, "Selected specification " + specification);
			addSrceenShot("Selected specification " + specification, test, Capture);

			// Click on "Measurements" Tab
			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			System.out.println("Navigated to measurement page  ");
			addSrceenShot("Navigated to measurement page  ", test, Capture);

			// Click on create from Measurement Template
			MeasurementsPage.clickCreateFromTemplate();
			test.log(Status.INFO, "Clicked on create New Measurement Template");
			addSrceenShot("Clicked on create New Measurement Template", test, Capture);

			// Choose measurement template and check if "colorway variation" is checked by
			// default
//			String measurementTemplateName = "GLOBAL WMN XXS-X-XXL";
//			String measurementsetname = "Test_Aut_115";

			boolean isColorwayChecked = MeasurementsPage
					.chooseTemplateAndCheckColorwayVariation(measurementTemplateName, measurementsetname, test);
			if (isColorwayChecked) {
				System.out.println("Test Passed: 'Colorway Variation' is checked by default.");
				test.log(Status.PASS, "Test Passed: 'Colorway Variation' is checked by default.");
				addSrceenShot("'Colorway Variation' is checked by default", test, Capture);

			} else {
				System.out.println("Test Failed: 'Colorway Variation' is not checked by default.");
				test.log(Status.FAIL, "'Colorway Variation' is not checked by default.");
				addSrceenShot("'Colorway Variation' is not checked by default", test, Capture);

			}

			// Fill required attributes and save
//			String sizes = "L";
//			String measurementType = "BEFORE WASH";
			MeasurementsPage.fillAttributesAndSave(sizes, measurementType, test);

			// Verify that new Measurement has been created with correct components in
			// Colorway column
			boolean isCreated = MeasurementsPage.verifyMeasurementCreation(measurementsetname);
			if (isCreated) {
				System.out.println("Test Passed: 'Measurement Set' created successfully.");
				test.log(Status.PASS, "Test Passed: 'Measurement Set' created successfully.");
				addSrceenShot("'Measurement Set' created successfully", test, Capture);

			} else {
				System.out.println("Test Failed: Measurement creation failed.");
				test.log(Status.FAIL, "Test Failed: Measurement Set creation failed.");
				addSrceenShot("'Measurement Set' created failed", test, Capture);
			}
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);

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
