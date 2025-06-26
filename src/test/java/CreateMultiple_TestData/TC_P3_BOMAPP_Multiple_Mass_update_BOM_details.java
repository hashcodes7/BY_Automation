package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BOM_Page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CreateNewProductPage;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;

@Test(enabled = true, groups = { "P3_TC" })
public class TC_P3_BOMAPP_Multiple_Mass_update_BOM_details extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	BOM_Page BOMPage;

	boolean Capture = true;
	private String adimin_URL;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			adimin_URL = Administrator_URL;
			LaunchSpecific_URL(adimin_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			BOMPage = new BOM_Page(driver);
			setReport("TC_P3_BOMAPP_Multiple_Mass_update_BOM_details");
		}
	}

	@Test(priority = 0, dataProvider = "Multiple_BOMAPP_Mass_update_BOM_details", dataProviderClass = DataProviders.class)

	public void P3_TC37_BOMAPP_Mass_update_BOM_details(String[][] testData) throws Exception {
		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
			String TestType = data[0];
			String username = data[1];
			String password = data[2];
			String season = data[3];
			String PC5Code = data[4];
			String newQuantity = data[5];
			String newRemarks = data[6];
			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_BOMAPP_Multiple_Mass_update_BOM_details:::");
			}
			CloseBrowser = false;
			// ...............................browser launched time starts
			startKeepScreenAwake();
			long startTime = System.nanoTime();

			try {
				if (i == 0) {

					test.log(Status.INFO,
							"This test case covers TestData_Scripts(P3) BOM app (TC_37_Mass update BOM details)");

					System.out.println("Browser Launched successfully");
					test.log(Status.INFO, "Browser Launched successfully");

					System.out.println("Login to flex PLM application successfully ");
					test.log(Status.INFO, "Login to flex PLM application successfully " + adimin_URL);
					addScreenShot("Login successful", test, Capture);
					Thread.sleep(5000);

					BOMPage.navigateToBOMApp();
					test.log(Status.INFO, "Navigated to BOM App");
					addScreenShot("Navigated to BOM App", test, Capture);

					BOMPage.login(username, password, test);
					addScreenShot("Logged into BOM App", test, Capture);

				}

				// Select Season and Search for PC9 code
//			String season = "Levi's S1 2025 Female Accessories";
				BOMPage.selectSeason(season);
				test.log(Status.INFO, "Season selected: " + season);
				addScreenShot("Season selected", test, Capture);

    //			String PC5Code = "000AG";
				BOMPage.searchForPC9(PC5Code, test);
				test.log(Status.INFO, "Searched for PC5: " + PC5Code);
				test.log(Status.INFO, "Selected all Boms");
				addScreenShot("Searched for PC5", test, Capture);


				BOMPage.MassUpdate_BomDetails(test, newQuantity, newRemarks);
				test.log(Status.PASS, "BOM Details are updated and validated for bulk data");
				addScreenShot("BOM Details are updated and validated for bulk data", test, Capture);

				if (i == testData.length - 1) {
					// Last iteration, perform logout
					BOMPage.logout(test);
					test.log(Status.INFO, "Logged out of BOM App");
					addScreenShot("Logged out of BOM App", test, Capture);
				}

			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
				test.log(Status.FAIL, "Test case failed due to application slowness " + e);
				throw e;
			}finally {
				stopKeepScreenAwake();
			}
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}