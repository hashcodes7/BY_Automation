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

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CustomLoaders_page;
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
public class TC69_P2_Placement_VerifyPlacementAttributes_Carryover extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	Colorway_page Colorwaypage;
	CustomLoaders_page customLoadersPage;
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
			Colorwaypage = new Colorway_page(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			setReport("TC69_P2_Placement_VerifyPlacementAttributes_Carryover");
		}
	}


	@Test( priority = 0, dataProvider = "TC69_P2_Placement_VerifyPlacementAttributes_Carryover", dataProviderClass = DataProviders.class)
	public void P2_TC69_Linesheet_VerifyPlacementAttributes_Carryover(String TestType,String season,String linesheetview,String filtercolorway,String vendor_Id,String AusGdv_value,
			String MALAGdv_value,String usagevalue,String changereason_value,String changecomments_value) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC69_P2_Placement_VerifyPlacementAttributes_Carryover:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_191 and TC_192");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+URL);

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
			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);
			
			Thread.sleep(5000);
			
			LineSheetEditPage.remove_filters();
			test.log(Status.INFO, "Removed Filter");
			System.out.println("Removed Filter");
			addSrceenShot("Removed Filter", test, Capture);
			
			customLoadersPage.Prerequisite_Carryover(filtercolorway,test);
			test.log(Status.INFO, "Validation successful for pre-requisite");
			System.out.println("Validation successful for pre-requisite");
			addSrceenShot("Validation successful for pre-requisite", test, Capture);
			Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");
			Thread.sleep(4000);
			
			customLoadersPage.Validate_PlacementAttributes_CarryoverColorway_linesheet(filtercolorway, vendor_Id, AusGdv_value, MALAGdv_value, usagevalue, changereason_value,changecomments_value,test);
			test.log(Status.PASS, "Validation successful for Placement Attributes after carryover");
			System.out.println("Validation successful for Placement Attributes after carryover");
			addSrceenShot("Validation successful for Placement Attributes after carryover", test, Capture);
			
			
			dashboardPage.Logout();
			test.log(Status.INFO, "Logout successful");
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
