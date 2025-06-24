package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BOM_Page;
import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CreateNewProductPage;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductDetailsPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;



import org.openqa.selenium.JavascriptExecutor;
import resources.DataProviders;

@Test(enabled = true, groups = { "P3_TC" })
public class TC_P3_BOMAPP_Multiple_Ability_to_search_partial_entry extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	BOM_Page BOMPage;
	LineSheetPage lineSheetPage;
	Colorway_page Colorwaypage;
	LineSheet_Edit_Page LineSheetEditPage;
	Colorway_page colorWayPage;
	ProductDetailsPage productDetailsPage;

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
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			colorWayPage = new Colorway_page(driver);
			productDetailsPage = new ProductDetailsPage(driver);

			setReport("TC_P3_Multiple_BOMAPP_Ability_to_search_partial_entry");
		}
	}

	@Test(priority = 0, dataProvider = "Multiple_BOMAPP_Ability_to_search_partial_entry", dataProviderClass = DataProviders.class)
	public void P3_TC33_BOMAPP_Ability_to_search_partial_entry(String[][] testData) throws Exception {
		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
			String TestType = data[0];
			String username = data[1];
			String password = data[2];
			String season = data[3];
			String PC9Code = data[4];
			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_Multiple_BOMAPP_Ability_to_search_partial_entry:::");
			}
			CloseBrowser = false;
			// ...............................browser launched time starts
			long startTime = System.nanoTime();

			try {
				if (i == 0) {
					dashboardPage.openLeftPanel();
					System.out.println("Clicked on open Left panel");
					test.log(Status.INFO, "Clicked on open Left panel");
					addSrceenShot("Clicked on open Left panel", test, Capture);

					// Navigate to BOM App
					BOMPage.navigateToBOMApp();
					test.log(Status.INFO, "Navigated to BOM App");
					addSrceenShot("Navigated to BOM App", test, Capture);

					// Login to BOM App
					BOMPage.login(username, password,test);
					addSrceenShot("Logged into BOM App", test, Capture);
				}

				// Select Season and Search for PC9 code
				BOMPage.selectSeason(season);
				test.log(Status.INFO, "Season selected: " + season);
				addSrceenShot("Season selected", test, Capture);

				BOMPage.searchForPC9(PC9Code, test);
				test.log(Status.INFO, "Searched for partial entry: " + PC9Code);
				addSrceenShot("Searched for partial entry", test, Capture);

				// Verify search results
				boolean isSearchSuccessful = BOMPage.verifySearchResults(PC9Code, test);
				if (isSearchSuccessful) {
					test.log(Status.PASS, "Search results are displayed correctly for partial entry: " + PC9Code);
					addSrceenShot("Search results displayed", test, Capture);
				} else {
					test.log(Status.FAIL, "No results found for partial entry: " + PC9Code);
					addSrceenShot("No results found", test, Capture);
				}

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