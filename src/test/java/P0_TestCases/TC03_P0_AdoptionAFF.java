package P0_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC03_P0_AdoptionAFF extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	
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
			
			setReport("TC03_P0 Adoption at AFF Levis- change Adopted AFF to YES ");
		}
	}

	@Test( priority = 0, dataProvider = "TC03_P0_AdoptionAFF", dataProviderClass = DataProviders.class)
	public void P0_TC_03_Adoption_at_AFF_Levis_FG_PDC_GB_HOT_GB(String TestType,String season,String linesheetview,String localhub
			,String filtercolorway,String affiliate) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P0 Adoption at AFF Levis- change Adopted AFF to YES :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_98 to TC_100");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+URL);
							
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
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
			
			
			LineSheetEditPage.changeLocalHub_Value(filtercolorway,localhub,test);
			test.log(Status.INFO, "Seasonal groups are selected according to TestCase Criteria in Setting");
			addSrceenShot("Seasonal groups are selected according to TestCase Criteria in setting", test, Capture);
			Thread.sleep(2000);
			
			LineSheetEditPage.AdoptionAFF_Prerequisite_Validation(test);
			test.log(Status.PASS, " Value of product dev center,AdoptedGb and AdoptedLH is Validated");
			addSrceenShot("Value of product dev center,AdoptedGb and AdoptedLH is Validated", test, Capture);
			
			Thread.sleep(5000);

			LineSheetEditPage.Affiliate_selection(affiliate,test);
			test.log(Status.INFO, " Affiliate Selected");
			addSrceenShot("Affiliate Selected", test, Capture);
			Thread.sleep(3000);
			LineSheetEditPage.Adopted_AFF_Selection(test);
			test.log(Status.PASS, "Adopted AFF value is changed to Yes");
			addSrceenShot("Adopted AFF value is changed to Yes", test, Capture);
			
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
