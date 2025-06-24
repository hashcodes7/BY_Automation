package P1_Testcases;

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

import com.WMS_ApplicationPages.CarryoverPage;
import com.WMS_ApplicationPages.Colorway_page;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.SourcingPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC_007_CarryoverColorway extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	SourcingPage sourcingPage;
	CarryoverPage carryoverPage;
	
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
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage =new LineSheet_Edit_Page(driver);
			sourcingPage = new SourcingPage(driver);
			carryoverPage =new CarryoverPage(driver);
			setReport("TC_007 Carryover Colorways which had sources associated (Colorway is associated to 5 sources)");
		}
	}

	@Test( priority = 0, dataProvider = "carryover_colorway", dataProviderClass = DataProviders.class)

	public void P0_TC_007_carryover_colorway(String TestType,String toSeason,String fromSeason,String linesheetview1,String productCode,String colorwayname,String linesheetview2,String linesheetview3) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC_007 Carryover Colorways which had sources associated (Colorway is associated to 5 sources):::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers from TC_249 to TC_252");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + URL);
			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(toSeason,test);
			test.log(Status.INFO, "Season selected: "+toSeason);
			addSrceenShot("Season selected:"+toSeason, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview1,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview1);
			addSrceenShot("Linesheet view changed to: "+linesheetview1, test, Capture);
			WaitforPage(5000);
			
			carryoverPage.Select_CarryOvercolorways();
			test.log(Status.INFO, "Selected carryover colorway menu ");
			addSrceenShot("Selected carryover colorway menu ", test, Capture);
			System.out.println("Selected carryover colorway menu ");
			
			Thread.sleep(3000);
			carryoverPage.SelectInitialSeason(fromSeason);	
			test.log(Status.INFO, "Initail season selected "+fromSeason);
			addSrceenShot("Initail season selected "+fromSeason, test, Capture);
			System.out.println("Initail season selected "+fromSeason);
			
			carryoverPage.filterdata(colorwayname);
			test.log(Status.INFO, "colorway filtered "+colorwayname);
			addSrceenShot("colorwayname filtered "+colorwayname, test, Capture);
			System.out.println("colorwayname filtered "+colorwayname);
			
			carryoverPage.SelectCarryovercolorway();
			test.log(Status.PASS, "selected colorway for copycarryover and carryover completed ");
			addSrceenShot("selected colorway for copycarryover and carryover completed", test, Capture);
			System.out.println("selected colorway for copycarryover and carryover completed"); 
			
			sourcingPage.validateCarryovercolorway(test);
			test.log(Status.PASS, "colorway carried over to new season successfully ");
			addSrceenShot("colorway carried over to new season successfully", test, Capture); 
						
			Colorwaypage.SeasonDropdown(fromSeason,test);
			test.log(Status.INFO, "Season selected: "+fromSeason);
			addSrceenShot("Season selected:"+fromSeason, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			WaitforPage(5000);
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			
			LineSheetEditPage.filter_View_Change(linesheetview3,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview3);
			WaitforPage(5000);
			addSrceenShot("Linesheet view changed to: "+linesheetview3, test, Capture);
			
			
			sourcingPage.validateCarryoverColorwayFields(test,productCode);
			test.log(Status.PASS, "vendor and source colorway fields are set to blank");
			addSrceenShot("vendor and source colorway fields are set to blank", test, Capture); 
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			WaitforPage(5000);
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			
			LineSheetEditPage.filter_View_Change(linesheetview2,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview2);
			addSrceenShot("Linesheet view changed to: "+linesheetview2, test, Capture);
			
			sourcingPage.getSourceAssociatedValues(test,productCode);
			
			Colorwaypage.SeasonDropdown(toSeason,test);
			test.log(Status.INFO, "Season selected: "+toSeason);
			addSrceenShot("Season selected:"+toSeason, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			WaitforPage(5000);
			addSrceenShot("Clicked on Line Sheets", test, Capture);
						
			LineSheetEditPage.filter_View_Change(linesheetview2,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview2);
			WaitforPage(5000);
			addSrceenShot("Linesheet view changed to: "+linesheetview2, test, Capture);
						
			sourcingPage.validateCarryoverColorwaySources(test,productCode);
			test.log(Status.PASS, "carryover colorway associated to same sources");
			WaitforPage(5000);
			addSrceenShot("carryover colorway associated to same sources", test, Capture);
						
			
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