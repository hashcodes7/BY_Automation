package P2_TestCases;

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

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;

@Test(enabled = true, groups= {"P2_TC"})
public class TC277_P2_RemoveComponentFromProductAndColorwaySections extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	SpecificationPage specificationPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Garment Developer user before executing this test case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(GarmentDeveloper_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			specificationPage = new SpecificationPage(driver);
			setReport("TC277_P2_Verify Remove component from the components Product and components-Colorway list.");
		}
	}

	@Test(priority = 0, dataProvider = "TC277_P2_RemoveComponentFromProductAndColorwaySections", dataProviderClass = DataProviders.class)
	public void P2_TC277_RemoveComponentFromProductAndColorwaySections(String TestType, String season, String viewType,
			String colorWayName) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(
					":::TC277_P2_Verify Remove component from the components Product and components-Colorway list:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This test case covers P2 Specification module from 277");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + GarmentDeveloper_URL);
			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addScreenShot("opened left panel", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2025 Male Accessories";
			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "Season selected: " + season);
			addScreenShot("Season selected:" + season, test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

//			String viewType = "Techpack Generation: Garment Developer View";
			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addScreenShot("View type is choosen", test, Capture);

//			String colorWayName = "0WQ55 -  - ACCESORIOS GLOBALES, S.A.  4965   GT";
			lineSheetPage.filterByColorway(colorWayName, test);
			test.log(Status.INFO, "Filtered ColorWay by name: " + colorWayName);
			addScreenShot("Filtered ColorWay by name: ", test, Capture);

			specificationPage.removeComponentFromProductSection(test);
			test.log(Status.PASS, "Test Passed: Verify Remove Component From Components-Product list");
			addScreenShot("Verify Remove Component From Components-Product list", test, Capture);

			specificationPage.removeComponentFromColorwaySection(test);
			test.log(Status.PASS, "Test Passed: Verify Remove Component From Components-Colorway list");
			addScreenShot("Verify Remove Component From Components-Colorway list", test, Capture);

			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
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
