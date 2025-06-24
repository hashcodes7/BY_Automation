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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC05_P2_Linesheet_Adoption_DropGB_LH extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
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
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			Colorwaypage = new Colorway_page(driver);
			setReport("TC05_P2_Linesheet_Adoption_DropGB_LH");
		}
	}
	
	public void initiateObj(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		lineSheetPage = new LineSheetPage(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		Colorwaypage = new Colorway_page(driver);

}

	@Test( priority = 0, dataProvider = "TC05_P2_Linesheet_Adoption_DropGB_LH", dataProviderClass = DataProviders.class)
	public void P2_TC05_E2E_Linesheet_Adoption_DropGB(String TestType,String season,String linesheetview,String localhub
			,String filtercolorway,String globalValue) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC05_P2_Linesheet_Adoption_DropGB_LH:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_96 to TC_100");
			
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
			
			lineSheetPage.selectSeasonGroupAsGlobal(globalValue, test);
			System.out.println("SeasonGroup As Global choosen");
			test.log(Status.INFO, "selected SeasonGroup As Global choosen: " + globalValue);
			addSrceenShot("selected SeasonGroup As Global choosen", test, Capture);

			Thread.sleep(5000);
			
			Techpackpages.filterdata(filtercolorway);
			test.log(Status.INFO, "colorway filtered "+filtercolorway);
			addSrceenShot("colorway filtered "+filtercolorway, test, Capture);
			System.out.println("colorway filtered "+filtercolorway);
			
			
			LineSheetEditPage.Change_AdoptedGB_value_toDROPPED(test);
			test.log(Status.PASS, "Adoption GB value changed to Dropped");
			System.out.println("Adoption GB value changed to Dropped");
			addSrceenShot("Adoption GB value changed to Dropped", test, Capture);
			
			
			dashboardPage.Logout();
			test.log(Status.INFO, "Logout successful");
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
//			--------------------------login using Local user------------------------------------------------	
			

			driver.close();
			Thread.sleep(2000);
			initiateObj(LocalHub_URL);
		
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  "+LocalHub_URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);
			
			js.executeScript("document.body.style.zoom = '100%';");
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view is "+linesheetview, test, Capture);
			WaitforPage(5000);
			
			LineSheetEditPage.changeLocalHub_Value(filtercolorway,localhub,test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: "+localhub);
			test.log(Status.INFO, "colorway value filtered: "+filtercolorway);
			addSrceenShot("local hub selected and colorway value filtered", test, Capture);
			WaitforPage(5000);
			
			LineSheetEditPage.Validate_AdoptedLH_DroppedValue(test);
			test.log(Status.PASS, "Updation and Validation successful for Adopted LH");
			System.out.println("Updation and Validation successful for Adopted LH");
			addSrceenShot("Updation and Validation successful for Adopted LH", test, Capture);

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
