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
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC15_P2_Linesheet_AdoptionLH_SetNO_Verify_Available extends WMS_TestBase {
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
			LaunchSpecific_URL(LocalHub_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			Colorwaypage = new Colorway_page(driver);
			setReport("TC15_P2_Linesheet_AdoptionLH_SetNO_Verify_Available");
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

	@Test( priority = 0, dataProvider = "TC15_P2_Linesheet_AdoptionLH_SetNO_Verify_Available", dataProviderClass = DataProviders.class)
	public void P2_TC15_Linesheet_Adoption_LH_SetNO(String TestType,String season,String linesheetview,String localhub
			,String filtercolorway,String globalValue) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC15_P2_Linesheet_AdoptionLH_SetNO_Verify_Available:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_101 to TC_104");
			
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
			LineSheetEditPage.changeLocalHub_Value(filtercolorway, localhub, test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localhub);
			test.log(Status.INFO, "colorway value filtered: " + filtercolorway);
			addSrceenShot("local hub selected and colorway value filtered", test, Capture);
			Thread.sleep(5000);

			LineSheetEditPage.Change_AdoptedLH_toNO(test);
			test.log(Status.INFO, "Adoption GB value changed to No");
			System.out.println("Adoption GB value changed to No");
			addSrceenShot("Adoption GB value changed to No", test, Capture);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");
			
			LineSheetEditPage.Validate_Available_Attribute( test);
			test.log(Status.PASS, "Validation Successful for Available? ");
			System.out.println("Validation Successful for Available?");
			addSrceenShot("Validation Successful for Available?", test, Capture);

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
