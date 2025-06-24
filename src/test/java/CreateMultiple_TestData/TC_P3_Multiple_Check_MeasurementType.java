package CreateMultiple_TestData;

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
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.DataProviders;


@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_Multiple_Check_MeasurementType extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;
	ProductDetailsPage productDetailsPage;
	LineSheetPage lineSheetPage;
	Measurements_Page MeasurementsPage;

	boolean Capture = true;
	private String garmentDeveloper_URL;

	/**
	 * Note: Ensure you are logged in as a Garment Developer user before executing
	 * this test case
	 */

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			garmentDeveloper_URL = GarmentDeveloper_URL;
			LaunchSpecific_URL(garmentDeveloper_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			MeasurementsPage = new Measurements_Page(driver);

			setReport("TC_P3_Multiple_Check_MeasurementType");
		}
	}

	@Test(priority = 0, dataProvider = "Multiple_Check_MeasurementType", dataProviderClass = DataProviders.class)
	public void TC41_P3_Check_MeasurementType(String[][] testData) throws Exception {

		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
			String product = data[1];
			String season = data[2];
			String source = data[3];
			String specification = data[4];
			String measurementSet = data[5];

			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_Multiple_Check_MeasurementType:::");
			}

			CloseBrowser = false;

			try {

				test.log(Status.INFO,
						"This test case covers TestData_Scripts(P3) Quonda 'Tc_001_Measurement Sets in PLM Environment' ");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addSrceenShot("Browser Launched successfully", test, Capture);

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: URL " + garmentDeveloper_URL);
				addSrceenShot("Login successful", test, Capture);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left panel");
				test.log(Status.INFO, "Clicked on open Left panel");
				addSrceenShot("Clicked on open Left panel", test, Capture);

				mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_PRODUCT.menu(), true);
				addSrceenShot("Clicked on Product Under Main menu of Libraries", test, Capture);
				System.out.println("Clicked on Product Under Main menu of Libraries ");
				test.log(Status.INFO, "Clicked on Product Under Main menu of Libraries ");
				WaitforPage(4000);

//			String product = "2706LFA";
				MeasurementsPage.selectProduct(product);
				test.log(Status.INFO, "Product selected: " + product);
				addSrceenShot("Product selected: " + product, test, Capture);

				MeasurementsPage.clickDetailsTab();
				test.log(Status.INFO, "Clicked on Details tab");
				addSrceenShot("Clicked on Details tab", test, Capture);

//			String season = "Levi's S1 2025 Female Accessories";
				MeasurementsPage.selectSeason(season, test);
				System.out.println("Selected season " + season);
				test.log(Status.INFO, "Selected season " + season);
				addSrceenShot("Selected season " + season, test, Capture);

//			String source = "Primary";
				MeasurementsPage.select_Source(source, test);
				System.out.println("Selected Primary source " + source);
				test.log(Status.INFO, "Selected Primary source " + source);
				addSrceenShot("Selected Primary source " + source, test, Capture);

//			String specification = "S1 2025 - 0WP6Y - 2706LFA -";
				MeasurementsPage.selectSpecifications(specification, test);
				System.out.println("Selected specifications " + specification);
				test.log(Status.INFO, "Selected specification " + specification);
				addSrceenShot("Selected specification " + specification, test, Capture);

				MeasurementsPage.NavigateTo_measurement();
				test.log(Status.INFO, "Navigated to measurement page ");
				System.out.println("Navigated to measurement page  ");
				addSrceenShot("Navigated to measurement page  ", test, Capture);

//			String measurementSet = "004 : Test_auto_05";
				MeasurementsPage.selectMeasurementSet(measurementSet);
				test.log(Status.INFO, "Selected measurement set: " + measurementSet);
				addSrceenShot("Selected measurement set: " + measurementSet, test, Capture);

				// Check the measurement type
				String measurementType = MeasurementsPage.getMeasurementType();
				test.log(Status.INFO, "Measurement type: " + measurementType);
				addSrceenShot("Measurement type: " + measurementType, test, Capture);

				// Validate the measurement type is not empty
				if (measurementType == null || measurementType.isEmpty()) {
					test.log(Status.FAIL, "Measurement type is empty");
					addSrceenShot("Measurement type is empty", test, Capture);
					throw new AssertionError("Measurement type should not be empty");
				} else {
					test.log(Status.PASS, "Measurement type is not empty: " + measurementType);
					addSrceenShot("Measurement type is not empty: " + measurementType, test, Capture);
				}

				if (i == testData.length - 1) {
					// Last iteration, perform logout
					dashboardPage.closeLeftPanel();
					System.out.println("Clicked on close Left plane");
					test.log(Status.INFO, "Clicked on close Left plane");
					addSrceenShot("Clicked on close Left plane", test, Capture);

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addSrceenShot("Logout successful", test, Capture);
				} else {
					// Not the last iteration, switch to the first tab, close the second tab, and
					// refresh the browser
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();
				}

			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
				test.log(Status.FAIL, "Test case failed due to application slowness");
				throw e;
			}
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}
