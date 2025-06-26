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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC316_317_P0_E2E_BulkTechPackONLY_URL extends WMS_TestBase {
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
			
			setReport("TC317_P0_E2E Download BULK TechPack only URL");
		}
	}

	@Test( priority = 0, dataProvider = "TC317_P0_E2E_TechPackONLY_URL", dataProviderClass = DataProviders.class)
	public void P0_TC317_E2E_proto_TechPackONLY_URL(String TestType,String season,String linesheetview,String productname) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC317_P0_E2E Download BULK TechPack only URL:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_316 and TC_317");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+Admin_URL_STG);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "left panel opened");
			addScreenShot("left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			LineSheetEditPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addScreenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addScreenShot("Closed Left panel", test, Capture);
			
			WaitforPage(10000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Techpack Garment Developer view is selected ");
			addScreenShot("Techpack Garment Developer view is selected ", test, Capture);
			System.out.println("Techpack Garment Developer view is selected ");
			
			Thread.sleep(2000);
			
//			String filtervalue="testprod4";
			Techpackpages.filterdata(productname);
			test.log(Status.INFO, "product filtered "+productname);
			addScreenShot("product filtered "+productname, test, Capture);
			System.out.println("product filtered "+productname);
			
			Thread.sleep(5000);
			
			Techpackpages.Download_BulkTechpack_File(test);
			test.log(Status.PASS, "File downloaded ");
			addScreenShot("File downloaded ", test, Capture);
			System.out.println("File downloaded ");
//			
//			dashboardPage.closeLeftPanel();
//			System.out.println("Clicked on close Left plane");
//			addScreenShot("Clicked on close Left plane", test, Capture);
//			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);
			
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

