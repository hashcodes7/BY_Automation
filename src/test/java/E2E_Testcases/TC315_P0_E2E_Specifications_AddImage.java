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
import com.WMS_ApplicationPages.CustomLoaders_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC315_P0_E2E_Specifications_AddImage  extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	Measurements_Page MeasurementsPage;
	E2E_Pages E2EPages;
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
			LaunchSpecific_URL(Admin_URL_STG);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			MeasurementsPage= new Measurements_Page(driver);
			E2EPages =new E2E_Pages(driver);
			Colorwaypage =new Colorway_page(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			
			setReport("TC315_P0_E2E Add Image Specifications");
		}
	}

	@Test( priority = 0, dataProvider = "TC315_P0_E2E_Specifications_AddImage", dataProviderClass = DataProviders.class)
	public void P0_TC324_E2E_VerifyPlacementFile(String TestType,String season, String linesheetview,
			String filterproduct,String source,String specifications,String pagetype,String pagedescription,String pagelayout) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC315_P0_E2E Add Image Specifications:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_315");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully - "+Admin_URL_STG);
			test.log(Status.INFO, "login to flex PLM application successfully - "+Admin_URL_STG);
					
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			MeasurementsPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addSrceenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);
			
			Thread.sleep(1000); 

			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);

			Colorwaypage.SelectProduct(filterproduct, test);
			test.log(Status.INFO, "clicked on product "+filterproduct);
			addSrceenShot("clicked on product ", test, Capture);
			
			MeasurementsPage.selectSource(source,test);
			test.log(Status.INFO, "Selected source "+source);
			addSrceenShot("Selected source "+source, test, Capture);
			System.out.println("Selected source "+source);

			MeasurementsPage.selectSpecifications(specifications,test);
			test.log(Status.INFO, "Selected specifications "+specifications);
			addSrceenShot("Selected specifications "+specifications, test, Capture);
			System.out.println("Selected specifications "+specifications);
			
			MeasurementsPage.NavigateTo_VisualAssets();
			test.log(Status.INFO, "Navigated to visual Assets page ");
			addSrceenShot("Navigated to visual Assets page ", test, Capture);
			System.out.println("Navigated to visual Assets page ");
			
			MeasurementsPage.create_VisualAssets_images(pagetype, pagedescription, pagelayout, test);
			test.log(Status.INFO, "Created Image  through visual Assets page ");
			addSrceenShot("Created Image  through visual Assets page ", test, Capture);
			System.out.println("Created Image  through visual Assets page");
			
			Thread.sleep(4000);
			MeasurementsPage.verify_VisualAssets_Image(pagedescription,test);
			test.log(Status.PASS, "Verified created Image");
			addSrceenShot("Verified created Image ", test, Capture);
			System.out.println("Verified created Image");

			
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

