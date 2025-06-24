package TestData_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BOM_Page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC29_P3_BomAPP_Search_UsingAllAttributes extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	BOM_Page BOMPage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			BOMPage = new BOM_Page(driver);
			setReport("TC29_P3_BomAPP_Search_UsingAllAttributes");
		}
	}

	@Test(priority = 0, dataProvider = "TC29_P3_BomAPP_Search_UsingAllAttributes", dataProviderClass = DataProviders.class)

	public void P3_TC29_BOMAPP_SeasrchUsingAllAttributes(String TestType, String username, String password,
			String season, String colorwaycode, String productcode, String Merchant, String material, String available,
			String carryover) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC29_P3_BomAPP_Search_UsingAllAttributes:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + Administrator_URL);
			Thread.sleep(5000);

			BOMPage.navigateToBOMApp();
			test.log(Status.INFO, "Navigated to BOM App");
			System.out.println("Navigated to BOM App");
			addSrceenShot("Navigated to BOM App", test, Capture);

			BOMPage.login(username, password, test);
			addSrceenShot("Logged into BOM App", test, Capture);

			BOMPage.SearchUsingAttributes(season, colorwaycode, productcode, Merchant, material, available, carryover,
					test);
			System.out.println("Search using all required attributes are completed");
			test.log(Status.INFO, "Search using all required attributes are completed");
			addSrceenShot("Search using all required attributes are completed", test, Capture);

			BOMPage.Validate_BomsDetails(test);
			System.out.println("Validation successful for Searching in Bom APP using required attributes");
			test.log(Status.PASS, "Validation successful for Searching in Bom APP using required attributes");
			addSrceenShot("Validation successful for Searching in Bom APP using required attributes", test, Capture);

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