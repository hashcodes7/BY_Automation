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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC274_P2_CheckColorwayVariationOption_componentsImagePage extends WMS_TestBase {

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

			setReport("TC274_P2_Check Colorway Variation Option  while creating components-Imeage page");
		}
	}

	@Test(priority = 0, dataProvider = "TC274_P2_CheckColorwayVariationOption_componentsImagePage", dataProviderClass = DataProviders.class)
	public void P2_TC274_CheckColorwayVariationOption_componentsImagePage(String TestType, String season,
			String productName, String sourceName, String specification, String pagetype, String pagedescription,
			String pagelayout, String imagePath) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC274_P2_Check Colorway Variation Option  while creating components-Imeage page:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P2 specifications module from TC274 to TC276");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL " + GarmentDeveloper_URL);
			addScreenShot("Login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addScreenShot("Clicked on open Left panel", test, Capture);
			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2025 Female Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addScreenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "TESTING PC9";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addScreenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(lineSheetPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed");
			addScreenShot("PC5 Details Page is displayed", test, Capture);
			Thread.sleep(5000);

//			String sourceName = "0WPQ8 - Primary -";
			productPage.selectSourceFromDropDown(sourceName, test);
			System.out.println("selected Source From The Sourcing Drop Down");
			test.log(Status.INFO, "selected Source From The Sourcing Drop Down" + sourceName);
			addScreenShot("selected Source From The Sourcing Drop Down", test, Capture);

//			String specification = "S1 2025 - 0WPQ8 - TESTING PC9 -";
			MeasurementsPage.selectSpecifications(specification, test);
			System.out.println("Selected specifications " + specification);
			test.log(Status.INFO, "Selected specification " + specification);
			addScreenShot("Selected specification " + specification, test, Capture);
			WaitforPage(5000);

			MeasurementsPage.NavigateToVisualAssets();
			test.log(Status.INFO, "Navigated to visual Assets page ");
			addScreenShot("Navigated to visual Assets page ", test, Capture);
			System.out.println("Navigated to visual Assets page ");
			WaitforPage(5000);

			// Click on create from Visual Assets Page
			MeasurementsPage.clickCreateImgFromVisualAssetsPage();
			test.log(Status.INFO, "Clicked on create Image Page From Visual Assets");
			addScreenShot("Clicked on create Image Page From Visual Assets", test, Capture);

			boolean isColorwayChecked = MeasurementsPage.CheckColorwayVariationOption(test);
			if (isColorwayChecked) {
				System.out.println("Test Passed: 'Colorway Variation' is checked by default.");
				test.log(Status.PASS, "Test Passed: 'Colorway Variation' is checked by default.");
				addScreenShot("'Colorway Variation' is checked by default", test, Capture);

			} else {
				System.out.println("Test Failed: 'Colorway Variation' is not checked by default.");
				test.log(Status.FAIL, "'Colorway Variation' is not checked by default.");
				addScreenShot("'Colorway Variation' is not checked by default", test, Capture);

			}

//			String pagetype = "Back Details";
//			String pagedescription = "Auto_test_Img_07";
//			String pagelayout = "1x2";
//			String imagePath = "C:\\Users\\2240786\\Downloads\\levis_logo.jpg";
			MeasurementsPage.fillAttributesAndAddImage(pagetype, pagedescription, pagelayout, imagePath, test);
			test.log(Status.INFO, "Attributes filled and image added");
			addScreenShot("Attributes filled and image added", test, Capture);
			System.out.println("Attributes filled and image added");

			// Verify that new image page has been created
			boolean isCreated = MeasurementsPage.isImagePageCreated(pagedescription,test);
			if (isCreated) {
				System.out.println("Test Passed: 'Image page' created: " + isCreated);
				test.log(Status.PASS, "Test Passed: 'Image page' created: " + isCreated);
				addScreenShot("'Image page' created", test, Capture);

			} else {
				System.out.println("Test Failed: 'Image page' not created: " + isCreated);
				test.log(Status.FAIL, "Test Failed: 'Image page' not created: " + isCreated);
				addScreenShot("'Image page' not created", test, Capture);
			}
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);

		} catch (Exception e) {
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
