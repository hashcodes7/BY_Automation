package P0_TestCases;

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
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC10_P0_CreateMeasureSet_UsingTemplate extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Measurements_Page MeasurementsPage;
	LineSheetPage lineSheetPage;
	
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
			MeasurementsPage= new Measurements_Page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			
			setReport("TC10_P0 Create Measurement set using archived Measurement template");
		}
	}
	@Test(priority = 0, dataProvider = "TC10_P0_CreateMeasureSet_UsingTemplate", dataProviderClass = DataProviders.class)

	public void TC_10_P0_CreateMeasurementSet_UsingTemplate(String TestType,String season,String linesheetview,String filterproduct
			,String source,String specifications,String  measurementsetname,String template_name,String sizevalue,String measurementtype) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC10_P0 Create Measurement set using archived Measurement template:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_167 to TC_170");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+ URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
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

			MeasurementsPage.filter_product(filterproduct,test);
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
			
			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			addSrceenShot("Navigated to measurement page  ", test, Capture);
			System.out.println("Navigated to measurement page  ");

			MeasurementsPage.Create_NewMeasurementSet(measurementsetname,template_name,sizevalue,measurementtype,test);
			test.log(Status.PASS, "measurements is created with measurement name: "+measurementsetname);
			addSrceenShot("measurements is created with measurement name: "+measurementsetname, test, Capture);
			System.out.println("measurements is created with measurement name: "+measurementsetname);
			
			MeasurementsPage.measurementSetValidations(measurementsetname,test);
			test.log(Status.PASS, "Validations of Measurements completed");
			addSrceenShot("Validations of Measurements completed", test, Capture);
			System.out.println("Validations of Measurements completed");
			
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