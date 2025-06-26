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
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC195_P1_Measurements_Critical_Dropdown_Functionality extends WMS_TestBase {

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

			setReport("TC195_P1_Measurements_Critical Dropdown Functionality");
		}
	}

	@Test(priority = 0, dataProvider = "measurementsCriticalDropdownData", dataProviderClass = DataProviders.class)
	public void P1_TC195_Measurements_Critical_Dropdown_Functionality(String TestType, String season, String productName,
			String specification, String measurementSet, String criticality, String pomID, String pomDescription,
			String tolPlusCell, String tolMinusCell) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC195_P1_Measurements_Critical Dropdown Functionality:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 measurment module from TC195 to TC202");

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

//			String season = "Levi's S1 2024 Male Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addScreenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "Test060524";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addScreenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed: " + productName);
			addScreenShot("PC5 Details Page is displayed", test, Capture);

			MeasurementsPage.clickDetailsTab();
			test.log(Status.INFO, "Clicked on Details tab");
			addScreenShot("Clicked on Details tab", test, Capture);

//			String source = "0WOZV - Primary -";
//			MeasurementsPage1.select_Source(source, test);
//			System.out.println("Selected Primary source " + source);
//			test.log(Status.INFO, "Selected Primary source " + source);
//			addScreenShot("Selected Primary source " + source, test, Capture);

//			String specification = "S1 2024 - 0WOZV - Test060524 -";
			MeasurementsPage.selectSpecifications(specification, test);
			System.out.println("Selected specifications " + specification);
			test.log(Status.INFO, "Selected specification " + specification);
			addScreenShot("Selected specification " + specification, test, Capture);

			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			System.out.println("Navigated to measurement page  ");
			addScreenShot("Navigated to measurement page  ", test, Capture);

//			String measurementSet = "001 : test_auto_21";
			MeasurementsPage.selectMeasurementSet(measurementSet);
			test.log(Status.INFO, "Selected measurement set: " + measurementSet);
			addScreenShot("Selected measurement set: " + measurementSet, test, Capture);

			MeasurementsPage.clickUpdate();
			test.log(Status.INFO, "Clicked on Update");
			addScreenShot("Clicked on Update", test, Capture);

			MeasurementsPage.checkCriticalityColumn();
			test.log(Status.INFO, "Checked Criticality column");
			addScreenShot("Checked Criticality column", test, Capture);

			// Select Critical from the Criticality Column drop-down update cells Under
			// measurement Set table

//			String criticality = "Critical";
//			String pomID = "AB1";
//			String pomDescription = "ACROSS BACK WIDTH, at Yoke";
//			String tolPlusCell = "0.375";
//			String tolMinusCell = "0.375";

			MeasurementsPage.selectCriticalAndUpdateCells(criticality, pomID, pomDescription, tolPlusCell,
					tolMinusCell, test);
			test.log(Status.INFO,
					"Selected Critical and updated cells under measurment table with values: Criticality = "
							+ criticality + ", POM ID = " + pomID + ", POM Description = " + pomDescription
							+ ", Tolerance Plus = " + tolPlusCell + ", Tolerance Minus = " + tolMinusCell);
			addScreenShot("Selected Critical And Updated cells", test, Capture);

			// Validation after Save and Check
			Assert.assertTrue(MeasurementsPage.isCriticalityUpdated(pomID, criticality),
					"Criticality was not updated correctly.");
			test.log(Status.INFO, "Criticality updated correctly for POM ID: " + pomID);
			test.log(Status.PASS, "System successfully allowed the user to update the row In Measurment Set Table");

			addScreenShot("Criticality updated correctly", test, Capture);

			// Verification for critical sizes
			Assert.assertTrue(MeasurementsPage.areCriticalSizesSaved(pomID, tolPlusCell, tolMinusCell),
					"Critical sizes were not saved correctly.");
			test.log(Status.PASS, "Critical sizes saved correctly");
			addScreenShot("Critical sizes Were saved correctly", test, Capture);

			MeasurementsPage.clickUpdate();
			test.log(Status.INFO, "Clicked on Update");
			addScreenShot("Clicked on Update", test, Capture);

			// Select Critical from the Criticality Column drop-down update cells Under
			// measurement Set table

			MeasurementsPage.clickedOnGradeRuleTab();
			test.log(Status.INFO, "Clicked on Grade Rule Tab");
			addScreenShot("Clicked on Grade Rule Tab", test, Capture);

			MeasurementsPage.selectCriticalAndUpdateCells(criticality, pomID, pomDescription, tolPlusCell,
					tolMinusCell, test);
			test.log(Status.INFO,
					"Selected Critical and updated cells under grade rule table with values: Criticality = "
							+ criticality + ", POM ID = " + pomID + ", POM Description = " + pomDescription
							+ ", Tolerance Plus = " + tolPlusCell + ", Tolerance Minus = " + tolMinusCell);
			addScreenShot("Selected Critical And Updated cells", test, Capture);

			// Validation after Save and Check
			Assert.assertTrue(MeasurementsPage.isCriticalityUpdated(pomID, criticality),
					"Criticality was not updated correctly.");
			test.log(Status.INFO, "Criticality updated correctly for POM ID: " + pomID);
			test.log(Status.PASS, "System successfully allowed the user to update the row In grade rule tab");

			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left panel");
			test.log(Status.INFO, "Clicked on close Left panel");
			addScreenShot("Clicked on close Left panel", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);

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

//MeasurementsPage1.clickChooseFile();
//test.log(Status.INFO, "Clicked on Choose File");
//addScreenShot("Clicked on Choose File", test, Capture);
