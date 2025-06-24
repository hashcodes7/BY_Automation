package E2E_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC318_P0_E2E_BulkBOMURL extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	Measurements_Page MeasurementsPage;
	E2E_Pages E2EPages;
	Colorway_page Colorwaypage;
	
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Admin_URL_STG);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			MeasurementsPage= new Measurements_Page(driver);
			E2EPages =new E2E_Pages(driver);
			Colorwaypage =new Colorway_page(driver);
			
			setReport("TC318_P0_E2E Download Bulk BOM URL");
		}
	}

	@Test( priority = 0, dataProvider = "TC318_P0_E2E_BulkBOMURL", dataProviderClass = DataProviders.class)
	public void P0_TC318_E2E_BulkBOMURL(String TestType,String season,String linesheetview,String sourcename) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC318_P0_E2E Download Bulk BOM URL:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_316");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+Admin_URL_STG);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "left panel opened");
			addSrceenShot("left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			LineSheetEditPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addSrceenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);
			
			WaitforPage(10000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.PASS, "Techpack Garment Developer view is selected ");
			addSrceenShot("Techpack Garment Developer view is selected ", test, Capture);
			System.out.println("Techpack Garment Developer view is selected ");
			
			Thread.sleep(2000);
			
			Techpackpages.filterdata(sourcename);
			test.log(Status.PASS, "Source filtered "+sourcename);
			addSrceenShot("Source filtered "+sourcename, test, Capture);
			System.out.println("Source filtered "+sourcename);
			
			Thread.sleep(5000);
			
			Techpackpages.Download_BULK_BOM_File(test);
			test.log(Status.PASS, "File is generated with download URL");
			addSrceenShot("File is generated with download URL", test, Capture);
			System.out.println("File is generated with download URL");
			
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

