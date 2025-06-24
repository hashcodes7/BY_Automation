package P1_Testcases;

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

@Test(enabled = true, groups= {"P1_TC"})
public class TC203_P1_Measurements_Move_Delete_Row extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;
	ProductDetailsPage productDetailsPage;
	LineSheetPage lineSheetPage;
	Measurements_Page MeasurementsPage;


	boolean Capture = true;

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


			setReport("TC203_P1_ Move and Delete Row on Measurement Set");
		}
	}

	@Test(priority = 0, dataProvider = "moveDeleteRowData", dataProviderClass = DataProviders.class)
	public void P1_TC203_MoveDeleteRow(String TestType, String product, String season, String source, String specification,
			String measurementSet) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC203_P1_ Move and Delete Row on Measurement Set:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 measurment module from TC203 to TC206");

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

			MeasurementsPage.clickUpdate();
			test.log(Status.INFO, "Clicked on Update");
			addSrceenShot("Clicked on Update", test, Capture);

			MeasurementsPage.selectRowToMove();
			test.log(Status.INFO, "Selected row to move");
			addSrceenShot("Selected row to move", test, Capture);

			MeasurementsPage.moveRowUp();
			test.log(Status.PASS, "Moved row up");
			addSrceenShot("Moved row up", test, Capture);

			MeasurementsPage.moveRowDown();
			test.log(Status.PASS, "Moved row down");
			addSrceenShot("Moved row down", test, Capture);

			// Delete the first row on the measurement set
			MeasurementsPage.selectFirstRowToDelete();
			test.log(Status.INFO, "Selected first row to delete");
			addSrceenShot("Selected first row to delete", test, Capture);

//	        MeasurementsPage1.deleteRow(test);
//	        test.log(Status.INFO, "Deleted first row");
//	        addSrceenShot("Deleted first row", test, Capture);

			// Verify row deletion
			boolean isRowDeleted = MeasurementsPage.deleteRowAndVerifyFirstRowDeletion(test);
			if (isRowDeleted) {
				test.log(Status.PASS, "First row successfully deleted. Verification passed.");
				addSrceenShot("First row successfully deleted", test, Capture);
			} else {
				test.log(Status.FAIL, "First row deletion failed. Verification failed.");
				addSrceenShot("First row deletion failed", test, Capture);
			}

			// Wait and close left panel
			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left panel");
			test.log(Status.INFO, "Clicked on close Left panel");
			addSrceenShot("Clicked on close Left panel", test, Capture);

			// Logout
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
