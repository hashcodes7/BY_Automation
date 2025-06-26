package P2_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Color_Page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC327_P2_VendorPortal_UpdateMaterialColorDevelopmentSamples extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;
	VendorPortalPage vendorPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Vendor user before executing this test case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(VendorPortal_URl);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			vendorPage = new VendorPortalPage(driver);

			setReport("TC327_P2_Vendor Portal_Update of records under Material Color Development Samples");
		}
	}

	@Test(priority = 0, dataProvider = "TC327_P2_VendorPortal_UpdateMaterialColorDevelopmentSamples", dataProviderClass = DataProviders.class)
	public void P2_TC327_VendorPortal_UpdateMaterialColorDevelopmentSamples(String TestType, String sampleType,
			String airwayBill, String shippedDate, String vendorComments) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC327_P2_Vendor Portal_Update of records under Material Color Development Samples:::");
		}

		CloseBrowser = false;
		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P2 Vendor Portal module from TC327 to TC328");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + VendorPortal_URl);
			addScreenShot("login successful", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);
			WaitforPage(4000);
			
			mainMenuPage.selectsubmenu(MainMenuEnum.LIBRARIES_SAMPLE.menu());
			System.out.println("Clicked on sample Under Material");
			test.log(Status.INFO, "Clicked on sample Under Material");
			addScreenShot("Clicked on sample Under Material", test, Capture);
			WaitforPage(5000);

//			String sampleType = "Color Development";
			vendorPage.chooseMaterialColorDevelopment(sampleType, test);
			test.log(Status.INFO, "Clicked on the type Sample Material Color Development");
			addScreenShot("Clicked on the type Sample Material Color Development", test, Capture);
			WaitforPage(4000);

			vendorPage.clickOnSearchTab();
			test.log(Status.INFO, "clicked on search tab");
			addScreenShot("clicked on search tab", test, Capture);
			WaitforPage(4000);

			vendorPage.clickUpdateResults();
			test.log(Status.INFO, "Clicked on Update Results option");
			addScreenShot("Clicked on Update Results option", test, Capture);
			WaitforPage(4000);

//			String airwayBill = "AWB1234";
//			String shippedDate = "10/09/2024";
//			String vendorComments = "Sample comments for testing.";

			vendorPage.updateAWBNumber(airwayBill);
			test.log(Status.INFO, "Updated AWB# from Vendor: " + airwayBill);
			addScreenShot("Updated AWB#", test, Capture);
			WaitforPage(4000);

			vendorPage.updateShippedDate(shippedDate);
			test.log(Status.INFO, "Updated Shipped Date: " + shippedDate);
			addScreenShot("Updated Shipped Date", test, Capture);
			WaitforPage(4000);

			vendorPage.updateVendorComments(vendorComments);
			test.log(Status.INFO, "Updated Vendor Comments: " + vendorComments);
			addScreenShot("Updated Vendor Comments", test, Capture);
			WaitforPage(4000);

			vendorPage.clickSave();
			test.log(Status.INFO, "Clicked on Save");
			addScreenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			boolean isUpdated = vendorPage.verifyUpdates(airwayBill, shippedDate, vendorComments);
			if (isUpdated) {
				test.log(Status.PASS, "Attributes updated successfully.");
				addScreenShot("Attributes updated successfully.", test, Capture);
			} else {
				test.log(Status.FAIL, "Failed to update attributes.");
				addScreenShot("Failed to update attributes.", test, Capture);
			}

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

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
