package CreateMultiple_TestData;

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
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_SearchMultipleData_BomAPP_AllAttributes extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	BOM_Page BOMPage;

	boolean Capture = true;

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
			setReport("TC_P3_SearchMultipleData_BomAPP_AllAttributes");
		}
	}

	@Test(priority = 0, dataProvider = "TC_P3_SearchMultipleData_BomAPP_AllAttributes", dataProviderClass = DataProviders.class)

	public void TC_(String[][] testData) throws Exception {

		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
//				String TestType = data[0];
			String username = data[1];
			String password = data[2];
			String season = data[3];
			String colorwaycode = data[4];
			String productcode = data[5];
			String Merchant = data[6];
			String material = data[7];
			String available = data[8];
			String carryover = data[9];

			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_SearchMultipleData_BomAPP_AllAttributes:::");
			}
			CloseBrowser = false;
			// ...............................browser launched time starts
			long startTime = System.nanoTime();

			try {
				if (i == 0) {
					System.out.println("Browser Launched successfully");
					test.log(Status.INFO, "Browser Launched successfully");
					System.out.println("Login to flex PLM application successfully ");
					test.log(Status.INFO, "Login to flex PLM application successfully " + Administrator_URL);
					Thread.sleep(5000);

					BOMPage.navigateToBOMApp();
					test.log(Status.INFO, "Navigated to BOM App");
					System.out.println("Navigated to BOM App");
					addSrceenShot("Navigated to BOM App", test, Capture);

       //		    String username = "mankumar@levi.com";
					BOMPage.login(username, password, test);
					addSrceenShot("Logged into BOM App", test, Capture);

				}

				BOMPage.SearchUsingAttributes(season, colorwaycode, productcode, Merchant, material, available,
						carryover, test);
				System.out.println("Search using all required attributes are completed");
				test.log(Status.INFO, "Search using all required attributes are completed");
				addSrceenShot("Search using all required attributes are completed", test, Capture);

				BOMPage.Validate_BomsDetails(test);
				System.out.println("Validation successful for Searching in Bom APP using required attributes");
				test.log(Status.PASS, "Validation successful for Searching in Bom APP using required attributes");
				addSrceenShot("Validation successful for Searching in Bom APP using required attributes", test,
						Capture);

				if (i == testData.length - 1) {
					// Last iteration, perform logout
					BOMPage.logout(test);
					test.log(Status.INFO, "Logged out of BOM App");
					addSrceenShot("Logged out of BOM App", test, Capture);
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