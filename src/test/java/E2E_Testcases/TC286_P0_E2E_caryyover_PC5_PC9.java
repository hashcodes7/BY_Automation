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

import Excel_Utilities.DataProviders;

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
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			LineSheetEditPage.SeasonDropdown(to_season);
			test.log(Status.INFO, "Season value seleted:"+to_season);
			addScreenShot("Season value seleted"+to_season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addScreenShot("Linesheet view changed", test, Capture);
			
			Thread.sleep(5000);
			
			E2EPages.Select_CarryOverProduct();
			test.log(Status.INFO, "Selected carryover products menu ");
			addScreenShot("Selected carryover products menu ", test, Capture);
			System.out.println("Selected carryover products menu ");
			
			Thread.sleep(3000);
			E2EPages.SelectInitialSeason(from_season);	
			test.log(Status.INFO, "Initail season selected "+from_season);
			addScreenShot("Initail season selected "+from_season, test, Capture);
			System.out.println("Initail season selected "+from_season);
			
			Thread.sleep(3000);
			Techpackpages.filterdataa(productname);
			test.log(Status.INFO, "product filtered "+productname);
			addScreenShot("product filtered "+productname, test, Capture);
			System.out.println("product filtered "+productname);
			
			Thread.sleep(3000);
			E2EPages.SelectCarryoverProduct();
			test.log(Status.PASS, "selected product for copycarryover and carryover completed ");
			addScreenShot("selected product for copycarryover and carryover completed", test, Capture);
			System.out.println("selected product for copycarryover and carryover completed");
				
//			--------------------Carryover Colorway---------------------------------------------
			
			E2EPages.Select_CarryOvercolorways();
			test.log(Status.INFO, "Selected carryover colorway menu ");
			addScreenShot("Selected carryover colorway menu ", test, Capture);
			System.out.println("Selected carryover colorway menu ");
			
			Thread.sleep(3000);
			E2EPages.SelectInitialSeason(from_season);
			test.log(Status.INFO, "Initail season selected "+from_season);
			addScreenShot("Initail season selected "+from_season, test, Capture);
			System.out.println("Initail season selected "+from_season);
			
			Thread.sleep(3000);
			Techpackpages.filterdataa(colorwayname);
			test.log(Status.INFO, "colorway filtered "+colorwayname);
			addScreenShot("colorwayname filtered "+colorwayname, test, Capture);
			System.out.println("colorwayname filtered "+colorwayname);
			
			E2EPages.SelectCarryovercolorway();
			test.log(Status.PASS, "selected colorway for copycarryover and carryover completed ");
			addScreenShot("selected colorway for copycarryover and carryover completed", test, Capture);
			System.out.println("selected colorway for copycarryover and carryover completed");
			
//			---------Validating the PC5 and PC9 are carried over in the season -------------------
			
			Thread.sleep(3000);
			E2EPages.validate_CarriedOver_PC5_PC9(productname,colorwayname);
			test.log(Status.PASS, "Validated PC5 and PC9 carried over ");
			addScreenShot("Validated PC5 and PC9 carried over", test, Capture);
			System.out.println("Validated PC5 and PC9 carried over");
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);
			
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
