package P1_Testcases;

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
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC33_P1_Specifications_carryoverColorway extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	E2E_Pages E2EPages;
	Measurements_Page MeasurementsPage;
	Colorway_page Colorwaypage;
	Set_Up_Page SetUpPage;
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
			E2EPages=new E2E_Pages(driver);
			MeasurementsPage= new Measurements_Page(driver);
			Colorwaypage =new Colorway_page(driver);
			SetUpPage = new Set_Up_Page(driver);
			setReport("TC33_Specifications_carryoverColorway");
		}
	}

	@Test( priority = 0, dataProvider = "TC33_Specifications_carryoverColorway", dataProviderClass = DataProviders.class)
	public void P0_TC_286_Carryover_PC5(String TestType,String to_season,String from_season,String linesheetview,String garmentlineshettview,String colorwayname
			,String source,String specifications,String pagetype,String pagedescription,String pagelayout) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC33_Specifications_carryoverColorway :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_272 to TC_275");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+Admin_URL_STG);
							
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
//			
//			E2EPages.Select_CarryOvercolorways();
//			test.log(Status.INFO, "Selected carryover colorway menu ");
//			addSrceenShot("Selected carryover colorway menu ", test, Capture);
//			System.out.println("Selected carryover colorway menu ");
//			
//			Thread.sleep(3000);
//			E2EPages.SelectInitialSeason(from_season);	
//			test.log(Status.INFO, "Initail season selected "+from_season);
//			addSrceenShot("Initail season selected "+from_season, test, Capture);
//			System.out.println("Initail season selected "+from_season);
//			
//			Thread.sleep(3000);
//			Techpackpages.filterdata(colorwayname);
//			test.log(Status.INFO, "colorway filtered "+colorwayname);
//			addSrceenShot("colorwayname filtered "+colorwayname, test, Capture);
//			System.out.println("colorwayname filtered "+colorwayname);
//			
//			E2EPages.SelectCarryovercolorway();
//			test.log(Status.INFO, "selected colorway for copycarryover and carryover completed ");
//			addSrceenShot("selected colorway for copycarryover and carryover completed", test, Capture);
//			System.out.println("selected colorway for copycarryover and carryover completed");
//			
////			Thread.sleep(3000);
////			Techpackpages.filterdata(colorwayname);
////			test.log(Status.INFO, "colorway filtered "+colorwayname);
////			addSrceenShot("colorwayname filtered "+colorwayname, test, Capture);
////			System.out.println("colorwayname filtered "+colorwayname);
////			
////			LineSheetEditPage.filter_View_Change(garmentlineshettview,test);
////			test.log(Status.INFO, "Linesheet view changed to: Garment");
////			addSrceenShot("Linesheet view changed", test, Capture);
////			
////			LineSheetEditPage.Validate_carryovercolorway_garmentdeveloperview(test);
////			System.out.println("Validation successful for carryover Colorway ");
////			test.log(Status.PASS, "Validation successful for carryover Colorway ");
////			addSrceenShot("Validation successful for carryover Colorway ", test, Capture);
////			
////			LineSheetEditPage.filter_View_Change(linesheetview,test);
////			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
////			addSrceenShot("Linesheet view changed", test, Capture);
//			
//			Thread.sleep(6000);
//			Colorwaypage.SelectColorway(colorwayname,test);
//			System.out.println("Colorway selected: "+colorwayname);
//			test.log(Status.INFO, "colorway details page opened ");
//			addSrceenShot("colorway details page opened ", test, Capture);
//			Thread.sleep(2000);
//			
//			MeasurementsPage.selectSource(source,test);
//			test.log(Status.PASS, " source is present  "+source);
//			addSrceenShot("source is present "+source, test, Capture);
//			System.out.println("source is present "+source);
//
//			MeasurementsPage.selectSpecifications(specifications,test);
//			test.log(Status.PASS, " specifications is present  "+specifications);
//			addSrceenShot(" specifications is present  "+specifications, test, Capture);
//			System.out.println("specifications is present  "+specifications);
//			WaitforPage(5000);
//			MeasurementsPage.NavigateToSourcingSummary();
//			test.log(Status.PASS, " Navigated to sourcing summary page  ");
//			addSrceenShot(" Navigated to sourcing summary page  ", test, Capture);
//			System.out.println("Navigated to sourcing summary page ");
//
//			WaitforPage(5000);
//			MeasurementsPage.Select_editcolorwaySourcing();
//			test.log(Status.PASS, " selected colorway for sourcing ");
//			addSrceenShot(" selected colorway for sourcing  ", test, Capture);
//			System.out.println("selected colorway for sourcing  ");
//
//			WaitforPage(5000);
//			MeasurementsPage.NavigateTo_VisualAssets();
//			test.log(Status.INFO, "Navigated to visual Assets page ");
//			addSrceenShot("Navigated to visual Assets page ", test, Capture);
//			System.out.println("Navigated to visual Assets page ");
//			
//			WaitforPage(5000);
//			MeasurementsPage.create_VisualAssets_images(pagetype, pagedescription, pagelayout, test);
//			test.log(Status.INFO, "Created Image  through visual Assets page ");
//			addSrceenShot("Created Image  through visual Assets page ", test, Capture);
//			System.out.println("Created Image  through visual Assets page");
//			
//			MeasurementsPage.verify_VisualAssets_Image(pagedescription,test);
//			test.log(Status.PASS, "Verified created Image");
//			addSrceenShot("Verified created Image ", test, Capture);
//			System.out.println("Verified created Image");
//			
//			Colorwaypage.Navigate_to_firstTab();
//			System.out.println("Navigated to Linesheet ");
//			test.log(Status.INFO, "Navigated to Linesheet ");
//			addSrceenShot("Navigated to Linesheet ", test, Capture);
			
			Colorwaypage.SelectColorway(colorwayname,test);
			System.out.println("Colorway selected: "+colorwayname);
			test.log(Status.INFO, "colorway details page opened ");
			addSrceenShot("colorway details page opened ", test, Capture);
			Thread.sleep(2000);
			
			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addSrceenShot("Colorway season edit page opened", test, Capture);

			Colorwaypage.select_colorway_carryovercomponetsNow();
			System.out.println("Carryover components now at colorway level is set to YES ");
			test.log(Status.INFO, "Carryover components now at colorway level is set to YES");
			addSrceenShot("Carryover components now at colorway level is set to YES ", test, Capture);
			
			Colorwaypage.Navigate_to_firstTab();
			System.out.println("Navigated to Linesheet ");
			test.log(Status.INFO, "Navigated to Linesheet ");
			addSrceenShot("Navigated to Linesheet ", test, Capture);
			
			LineSheetEditPage.filter_View_Change(garmentlineshettview,test);
			test.log(Status.INFO, "Linesheet view changed to: Garment");
			addSrceenShot("Linesheet view changed", test, Capture);
			
			LineSheetEditPage.Validate_componentscolorway_linesheet(test);
			System.out.println("Validation successful for carryover Colorway ");
			test.log(Status.PASS, "Validation successful for carryover Colorway ");
			addSrceenShot("Validation successful for carryover Colorway ", test, Capture);
			
			
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
