package TestData_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC02_P3_ActivateColorway_LSE extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Set_Up_Page SetUpPage;
	Techpack_pages Techpackpages;
	E2E_Pages E2EPages;
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
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			SetUpPage = new Set_Up_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			E2EPages = new E2E_Pages(driver);
			setReport("TC02_P3_ActivateColorway_LSE");
		}
	}

	@Test(priority = 0, dataProvider = "TC02_P3_ActivateColorway_LSE", dataProviderClass = DataProviders.class)
	public void TC_SetUp_and_ActivateLSE_Linesheet(String TestType, String season, String colorway, String affiliate,
			String linesheetview_activation, String currentPlannedLifecycleAFF, String firstOnFloorMonthAFF,
			String dlvySelectedAFF, String ticketCode, String lsusStockingCSC, String targetAFFMSRP,
			String priceWhslAFF, String bucketCodeAFF)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC02_P3_ActivateColorway_LSE:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers - Creation of Colorway then SetUp and Activation of LSE for the same colorway");
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + Administrator_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.filter_View_Change(linesheetview_activation, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_activation);
			addSrceenShot("Linesheet view is " + linesheetview_activation, test, Capture);
			WaitforPage(5000);
			
			Techpackpages.filterdata(colorway);
			test.log(Status.INFO, "colorway filtered " + colorway);
			addSrceenShot("colorway filtered " + colorway, test, Capture);
			System.out.println("colorway filtered " + colorway);
			
			LineSheetEditPage.Affiliate_selection(affiliate, test);
			test.log(Status.INFO, " Affiliate Selected: " + affiliate);
			System.out.println(" Affiliate Selected: " + affiliate);
			addSrceenShot("Affiliate Selected", test, Capture);
			Thread.sleep(5000);

			lineSheetPage.updateAttributes_ActivateValidation_LSE(currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF,
					ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF, bucketCodeAFF, test);

			test.log(Status.INFO, "All mandatory attributes are filled for Activate LSE and activation is complete");
			System.out.println("All mandatory attributes are filled for Activate LSE and activation is complete");
			addSrceenShot("All mandatory attributes are filled for Activate LSE and activation is complete", test,
					Capture);

			lineSheetPage.Activation_RunValidation_LSE(test);
			test.log(Status.PASS, "Validation successful for Activate LSE");
			System.out.println("Validation successful for Activate LSE");
			addSrceenShot("Validation successful for Activate LSE", test, Capture);
			Thread.sleep(5000);

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

}
