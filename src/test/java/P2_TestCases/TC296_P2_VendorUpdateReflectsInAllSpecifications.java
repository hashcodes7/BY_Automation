package P2_TestCases;

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
import org.testng.Assert;
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
import com.WMS_ApplicationPages.SourcingPage;
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC296_P2_VendorUpdateReflectsInAllSpecifications extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	SourcingPage sourcingPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	SpecificationPage specificationPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a PDS user before executing this test
	 * case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			sourcingPage = new SourcingPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			specificationPage = new SpecificationPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("P2_TC296_TestReport_RepopulateVendorId_OnVendorChange_AllSpecifications");
		}
	}

	@Test(priority = 0, dataProvider = "TC296_P2_VendorUpdateReflectsInAllSpecifications", dataProviderClass = DataProviders.class)
	public void P2_TC296_VendorUpdateReflectsInAllSpecifications(String TestType, String season, String productName,
			String sourceName, String newVendor) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::P2_TC296_TestReport_RepopulateVendorId_OnVendorChange_AllSpecifications:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			test.log(Status.INFO, "This test case covers P2 Specification module from 296 to 301");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addSrceenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

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

//			String productName = "1709LFA2";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed: " + productName);
			addSrceenShot("PC5 Details Page is displayed", test, Capture);

//			String sourceName = "0WQFW -  - SURYAKIRAN INTL LTD 4451 IN";
			productPage.selectSourceFromDropDown(sourceName, test);
			System.out.println("Selected Source From Drop Down");
			test.log(Status.INFO, "Selected Source From Drop Down: " + sourceName);
			addSrceenShot("Selected Source From Drop Down", test, Capture);

			productPage.selectSourcingTab();
			System.out.println("Selected Sourcing tab");
			test.log(Status.INFO, "Selected Sourcing tab");
			addSrceenShot("Selected Sourcing tab", test, Capture);
			WaitforPage(4000);

			productPage.clickOnSummary();
			System.out.println("Clicked on Samples");
			test.log(Status.INFO, "Clicked on Samples");
			addSrceenShot("Clicked on Samples", test, Capture);
			WaitforPage(4000);

			productPage.clickOnUpdateSource();
			System.out.println("Clicked On Update Source ");
			test.log(Status.INFO, "Clicked On Update Source");
			addSrceenShot("Clicked On Update Source", test, Capture);
			WaitforPage(4000);

			productPage.clickOnVendorLink();
			test.log(Status.INFO, "Clicked On Vendor Hyperlink");
			addSrceenShot("Clicked On Vendor Hyperlink", test, Capture);

//			String newVendor = "HRD KURUWITA 3514 HDR -1 LK";
			productPage.selectVendor(newVendor, test);
			test.log(Status.INFO, "Updated source vendor to: " + newVendor);
			addSrceenShot("Updated source vendor", test, Capture);

			productPage.clickOnSave();
			test.log(Status.INFO, "Clicked On Save Button ");
			addSrceenShot("Clicked On save Button", test, Capture);

			String updatedSourceName = sourcingPage.getSourceName();
			test.log(Status.INFO, "Updated source name: " + updatedSourceName);
			addSrceenShot("Updated source name", test, Capture);

			String vendorId = extractVendorId(updatedSourceName);
			test.log(Status.INFO, "Extracted Vendor ID: " + vendorId);
			addSrceenShot("Extracted Vendor ID", test, Capture);

			// Verify vendor ID repopulation
			if (specificationPage.verifyVendorIdInSpecifications(vendorId, test)) {
				test.log(Status.PASS, "Vendor ID repopulated on all specifications associated with the source.");
				addSrceenShot("Vendor ID repopulated", test, Capture);
			} else {
				test.log(Status.FAIL, "Vendor ID not repopulated on all specifications.");
				addSrceenShot("Vendor ID not repopulated", test, Capture);
			}

			WaitforPage(4000);

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

	private String extractVendorId(String sourceName) {
		String[] parts = sourceName.split(" ");
		for (String part : parts) {
			if (part.matches("\\d+")) { // Check if the part is a number
				return part;
			}
		}
		return "";
	}

}