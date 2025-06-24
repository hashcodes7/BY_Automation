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


import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC329_P2_VendorPortalAccessToSamplesProductFit extends WMS_TestBase {
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

			setReport("TC329_P2_Vendor Portal Access To Samples Product Fit");
		}
	}

	@Test(priority = 0, dataProvider = "TC329_P2_VendorPortalAccessToSamplesProductFit", dataProviderClass = DataProviders.class)
	public void P2_TC329_VendorPortalAccessToSamplesProductFit(String TestType, String sampleType)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC329_P2_Vendor Portal Access To Samples Product Fit:::");
		}

		CloseBrowser = false;
		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P2 Vendor Portal module from TC329");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + VendorPortal_URl);
			addSrceenShot("login successful", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);
			WaitforPage(4000);
			
			mainMenuPage.selectsubmenu(MainMenuEnum.LIBRARIES_SAMPLE.menu());
			System.out.println("Clicked on sample Under Material");
			test.log(Status.INFO, "Clicked on sample Under Material");
			addSrceenShot("Clicked on sample Under Material", test, Capture);
			WaitforPage(5000);

//			String sampleType = "Fit";
			vendorPage.chooseMaterialColorDevelopment(sampleType, test);
			test.log(Status.INFO, "Clicked on Sample Product Fit");
			addSrceenShot("Clicked on Sample Product Fit", test, Capture);
			WaitforPage(4000);

			vendorPage.clickOnSearchTab();
			test.log(Status.INFO, "clicked on search tab");
			addSrceenShot("clicked on search tab", test, Capture);

			boolean isDisplayed = vendorPage.verifyProductFitSearchPage();
			if (isDisplayed) {
				test.log(Status.PASS, "Product Fit Search Page is displayed.");
				addSrceenShot("clicked on search tab", test, Capture);
			} else {
				test.log(Status.FAIL, "Product Fit Search Page is not displayed.");
				addSrceenShot("clicked on search tab", test, Capture);
			}

			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
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
