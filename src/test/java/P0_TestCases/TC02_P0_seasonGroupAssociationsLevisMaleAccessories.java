package P0_TestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC02_P0_seasonGroupAssociationsLevisMaleAccessories extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC02_P0_Validation_Of_Levis_Male_Accessories_Season_Group_Association_SearchResults");
			// SeasonGroupAssociationSearchResultsReport
		}
	}

	@Test(priority = 0, dataProvider = "maleSeasonSearchData", dataProviderClass = DataProviders.class)
	public void orderAllocation(String TestType, String searchValue) throws Exception {
		try {
			if (CloseBrowser) {

				test = extent.createTest(
						":::TC02_P0_Validation_Of_Levis_Male_Accessories_Season_Group_Association_SearchResults:::");
			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();

			System.out.println("Browser Launched successfully");
			test.log(Status.PASS, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers season module from 217 to 218");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully");
			addSrceenShot("login to flex PLM application successfully", test, Capture);
			Thread.sleep(5000);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addSrceenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addSrceenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(),
					MainMenuEnum.LIBRARIES_SEASONGROUPASSOCIATION.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on season group association");
			test.log(Status.INFO, "Clicked on season group association");
			WaitforPage(4000);

//            String searchValue = "Levi's S1 2022 Male Accessories";
			seasonPage.quickSearchText(searchValue, test);
			test.log(Status.INFO, "Performed quick search with value: " + searchValue);
			addSrceenShot("Performed quick search", test, Capture);

			seasonPage.verifyAffiliatevalues(test);
			System.out.println("Verified affiliate values");
			test.log(Status.PASS, "Verified affiliate values");
			addSrceenShot("Verified affiliate values", test, Capture);

			seasonPage.verifyLocalHubvalues(test);
			System.out.println("Verified local hub values");
			test.log(Status.PASS, "Verified local hub values");
			addSrceenShot("Verified local hub values", test, Capture);

			seasonPage.verifyGlobalvalues(test);
			System.out.println("Verified global values");
			test.log(Status.PASS, "Verified global values");
			addSrceenShot("Verified global values", test, Capture);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
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