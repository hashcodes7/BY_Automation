package P2_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC24_P2_Techpack_CSTeschpack_download extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	
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
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			
			setReport("TC24_P2_Techpack_CSTeschpack_download");
		}
	}

	@Test( priority = 0, dataProvider = "TC24_P2_Techpack_CSTeschpack_download", dataProviderClass = DataProviders.class)
	public void P2_TC24_CS_TechPack(String TestType,String season,String linesheetview,String sourcename,String specstatus,String techpackoptions) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC24_P2_Techpack_CSTeschpack_download:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_293 and TC_294 of P1 testcases and TC_317 of P2");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+URL);

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
			test.log(Status.PASS, "linesheet view selected- "+linesheetview);
			addScreenShot("linesheet view selected- "+linesheetview, test, Capture);
			System.out.println("linesheet view selected- "+linesheetview);
			Thread.sleep(5000);
			
//			String filtervalue="0WPJ8 - - Active";
			Techpackpages.filterdata(sourcename);
			test.log(Status.PASS, "product filtered "+sourcename);
			addScreenShot("product filtered "+sourcename, test, Capture);
			System.out.println("product filtered "+sourcename);
			
//			Thread.sleep(5000);
			
			Techpackpages.Download_Techpack_File(specstatus,techpackoptions,test);
			test.log(Status.PASS, "File downloaded ");
			addScreenShot("File downloaded ", test, Capture);
			System.out.println("File downloaded ");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("document.body.style.zoom = '80%';");

			
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