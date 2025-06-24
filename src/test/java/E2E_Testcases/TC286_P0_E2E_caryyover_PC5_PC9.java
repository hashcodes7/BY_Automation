package E2E_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC286_P0_E2E_caryyover_PC5_PC9 extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	E2E_Pages E2EPages;
	
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			E2EPages=new E2E_Pages(driver);
			
			setReport("TC286_P0_E2E Carryover PC5 and PC9");
		}
	}

	@Test( priority = 0, dataProvider = "TC286_P0_E2E_caryyover_PC5_PC9", dataProviderClass = DataProviders.class)
	public void P0_TC_286_Carryover_PC5(String TestType,String to_season,String from_season,String linesheetview,String productname,String colorwayname) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC286_P0_E2E Carryover PC5 and PC9 :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_286");
			
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
			
			LineSheetEditPage.SeasonDropdown(to_season);
			test.log(Status.INFO, "Season value seleted:"+to_season);
			addSrceenShot("Season value seleted"+to_season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);
			
			Thread.sleep(5000);
			
			E2EPages.Select_CarryOverProduct();
			test.log(Status.INFO, "Selected carryover products menu ");
			addSrceenShot("Selected carryover products menu ", test, Capture);
			System.out.println("Selected carryover products menu ");
			
			Thread.sleep(3000);
			E2EPages.SelectInitialSeason(from_season);	
			test.log(Status.INFO, "Initail season selected "+from_season);
			addSrceenShot("Initail season selected "+from_season, test, Capture);
			System.out.println("Initail season selected "+from_season);
			
			Thread.sleep(3000);
			Techpackpages.filterdataa(productname);
			test.log(Status.INFO, "product filtered "+productname);
			addSrceenShot("product filtered "+productname, test, Capture);
			System.out.println("product filtered "+productname);
			
			Thread.sleep(3000);
			E2EPages.SelectCarryoverProduct();
			test.log(Status.PASS, "selected product for copycarryover and carryover completed ");
			addSrceenShot("selected product for copycarryover and carryover completed", test, Capture);
			System.out.println("selected product for copycarryover and carryover completed");
				
//			--------------------Carryover Colorway---------------------------------------------
			
			E2EPages.Select_CarryOvercolorways();
			test.log(Status.INFO, "Selected carryover colorway menu ");
			addSrceenShot("Selected carryover colorway menu ", test, Capture);
			System.out.println("Selected carryover colorway menu ");
			
			Thread.sleep(3000);
			E2EPages.SelectInitialSeason(from_season);
			test.log(Status.INFO, "Initail season selected "+from_season);
			addSrceenShot("Initail season selected "+from_season, test, Capture);
			System.out.println("Initail season selected "+from_season);
			
			Thread.sleep(3000);
			Techpackpages.filterdataa(colorwayname);
			test.log(Status.INFO, "colorway filtered "+colorwayname);
			addSrceenShot("colorwayname filtered "+colorwayname, test, Capture);
			System.out.println("colorwayname filtered "+colorwayname);
			
			E2EPages.SelectCarryovercolorway();
			test.log(Status.PASS, "selected colorway for copycarryover and carryover completed ");
			addSrceenShot("selected colorway for copycarryover and carryover completed", test, Capture);
			System.out.println("selected colorway for copycarryover and carryover completed");
			
//			---------Validating the PC5 and PC9 are carried over in the season -------------------
			
			Thread.sleep(3000);
			E2EPages.validate_CarriedOver_PC5_PC9(productname,colorwayname);
			test.log(Status.PASS, "Validated PC5 and PC9 carried over ");
			addSrceenShot("Validated PC5 and PC9 carried over", test, Capture);
			System.out.println("Validated PC5 and PC9 carried over");
			
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
