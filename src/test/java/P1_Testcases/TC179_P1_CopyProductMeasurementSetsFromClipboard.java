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
public class TC179_P1_CopyProductMeasurementSetsFromClipboard extends WMS_TestBase {

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


			setReport("TC179_P1_Copy Product Measurement Sets from Clipboard");
		}
	}

	@Test(priority = 0, dataProvider = "copyProductMeasurementData", dataProviderClass = DataProviders.class)
	public void P1_TC179_CopyProductMeasurementSetsFromClipboard(String TestType, String product, String season, String specification,
			String measurementSet, String newProduct, String seasonOfNewProd, String specOfNewProd,
			String measurementsetname, String sizevalue, String measurementtype)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC179_P1_Copy Product Measurement Sets from Clipboard:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 measurment module from TC179 to TC185");

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

//			String product = "Test060524";
			MeasurementsPage.selectProduct(product);
			test.log(Status.INFO, "Product selected: " + product);
			addSrceenShot("Product selected: " + product, test, Capture);

			MeasurementsPage.clickDetailsTab();
			test.log(Status.INFO, "Clicked on Details tab");
			addSrceenShot("Clicked on Details tab", test, Capture);

//			String season = "Levi's S1 2024 Male Accessories";
			MeasurementsPage.selectSeason(season, test);
			System.out.println("Selected season " + season);
			test.log(Status.INFO, "Selected season " + season);
			addSrceenShot("Selected season " + season, test, Capture);

//			String source = "0WOZV - Primary -";
//			MeasurementsPage1.select_Source(source, test);
//			System.out.println("Selected source " + source);
//			test.log(Status.INFO, "Selected source " + source);
//			addSrceenShot("Selected source " + source, test, Capture);

			// Step 4: Select a Specification from Specifications drop down
//			String specification = "S1 2024 - 0WOZV - Test060524 -";
			MeasurementsPage.selectSpecifications(specification, test);
			System.out.println("Selected specifications " + specification);
			test.log(Status.INFO, "Selected specification " + specification);
			addSrceenShot("Selected specification " + specification, test, Capture);

			// Step 5: Click on "Measurements" Tab
			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			System.out.println("Navigated to measurement page  ");
			addSrceenShot("Navigated to measurement page  ", test, Capture);

			// Step 6: Select a Measurement Set from "View Measurement Set"
//			String measurementSet = "002 : TEST_AUTO_22";
			MeasurementsPage.selectMeasurementSet(measurementSet);
			test.log(Status.INFO, "Selected measurement set: " + measurementSet);
			addSrceenShot("Selected measurement set: " + measurementSet, test, Capture);

			// Step 7: From the "Actions" drop down, click on "Copy To Clipboard"
			MeasurementsPage.copyToClipboard();
			test.log(Status.INFO, "Copied measurement set to clipboard: " + measurementSet);
			addSrceenShot("Copied measurement set to clipboard: " + measurementSet, test, Capture);

			MeasurementsPage.openNewTab(URL);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addSrceenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_PRODUCT.menu(), true);
			addSrceenShot("Clicked on Product Under Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Product Under Main menu of Libraries ");
			test.log(Status.INFO, "Clicked on Product Under Main menu of Libraries ");
			WaitforPage(4000);

			// Step 8: Navigate to Product where you want to use the measurement
//			String newProduct = "Test061224";
			MeasurementsPage.selectProduct(newProduct);
			test.log(Status.INFO, "New Product selected: " + product);
			addSrceenShot("New Product selected: " + product, test, Capture);

//			String seasonOfNewProd = "Levi's S1 2024 Male Accessories";
			MeasurementsPage.selectSeason(seasonOfNewProd, test);
			System.out.println("Selected season for new product" + seasonOfNewProd);
			test.log(Status.INFO, "Selected season for new product: " + seasonOfNewProd);
			addSrceenShot("Selected season for new product " + seasonOfNewProd, test, Capture);

//			String sourceOfNewProd = "0WP1T - Primary -";
//			MeasurementsPage1.select_Source(source, test);
//			System.out.println("Selected Primary source Of new product: " + sourceOfNewProd);
//			test.log(Status.INFO, "Selected Primary source Of new product: " + sourceOfNewProd);
//			addSrceenShot("Selected Primary source " + sourceOfNewProd, test, Capture);

			// Step 4: Select a Specification from Specifications drop down
//			String specOfNewProd = "S1 2024 - 0WP1T - Test061224 -";
			MeasurementsPage.selectSpecifications(specOfNewProd, test);
			System.out.println("Selected specification of new product: " + specOfNewProd);
			test.log(Status.INFO, "Selected specification of new product: " + specOfNewProd);
			addSrceenShot("Selected specification " + specOfNewProd, test, Capture);

			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			System.out.println("Navigated to measurement page  ");
			addSrceenShot("Navigated to measurement page  ", test, Capture);

			String copiedmeasurementValue = MeasurementsPage.addNewMeasurementSetFromClipboard(measurementSet, test);
			test.log(Status.INFO, "Added new measurement set from clipboard: " + copiedmeasurementValue);
			addSrceenShot("Added new measurement set from clipboard: " + copiedmeasurementValue, test, Capture);
			System.out.println("Added new measurement set from clipboard");

			// Step 10: Enter required attributes and save
//			String measurementsetname = "Test_Demo_Mes_01";
//			String sizevalue = "22";
//			String measurementtype = "BEFORE WASH";

			MeasurementsPage.enterMeasurementSetAttributes(measurementsetname, sizevalue, measurementtype,
					measurementSet, test);
			test.log(Status.PASS, "Measurement set copied and applied to new product: " + measurementsetname);
			addSrceenShot("Measurement set copied and applied to new product: " + measurementsetname, test, Capture);

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
