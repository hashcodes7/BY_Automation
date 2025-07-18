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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC49_P0_CreateMultipleMesurementSet extends WMS_TestBase{
	
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
			
			setReport("TC49_P0 Create Multiple Measurement set");
		}
	}
	@Test(priority = 0, dataProvider = "TC49_P0_CreateMultipleMesurementSet", dataProviderClass = DataProviders.class)
	public void TC_49_P0_CreateMultipleMeasurementSet(String TestType,String season,String linesheetview,String filterproduct
			,String source,String specifications,String  measurementsetname,String template_name,String productsize,
			String gradetemplate,String measurementtype) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC49_P0 Create Multiple Measurement set:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_183 to TC_186");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+ URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addScreenShot("opened left panel", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.PASS, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
//			String season="Levi's S1 2025 Female Accessories";
			MeasurementsPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addScreenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.PASS, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addScreenShot("Closed Left panel", test, Capture);
			
			Thread.sleep(1000); 

			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addScreenShot("Linesheet view changed", test, Capture);
			

			MeasurementsPage.filter_product(filterproduct,test);
			test.log(Status.INFO, "clicked on product "+filterproduct);
			addScreenShot("clicked on product ", test, Capture);
			

			MeasurementsPage.selectSource(source,test);
			test.log(Status.INFO, "Selected source "+source);
			addScreenShot("Selected source "+source, test, Capture);
			System.out.println("Selected source "+source);
			
			Thread.sleep(2000);
			

			MeasurementsPage.selectSpecifications(specifications,test);
			test.log(Status.INFO, "Selected specifications "+source);
			addScreenShot("Selected specifications "+source, test, Capture);
			System.out.println("Selected specifications "+source);
			
			Thread.sleep(2000);
			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			addScreenShot("Navigated to measurement page  ", test, Capture);
			System.out.println("Navigated to measurement page  ");
			
			MeasurementsPage.AddMultipleMeasurement( measurementsetname, template_name, productsize, gradetemplate, measurementtype, test);
			test.log(Status.PASS, "measurement is created with measurement name: "+measurementsetname);
			addScreenShot("measurement is created with measurement name: "+measurementsetname, test, Capture);
			System.out.println("measurement is created with measurement name: "+measurementsetname);
			
			MeasurementsPage.measurementSet_Validations(measurementsetname,test);
			test.log(Status.PASS, "Validated measurement set  "+measurementsetname);
			addScreenShot("Validated measurement set  "+measurementsetname, test, Capture);
			System.out.println("Validated measurement set "+measurementsetname);
			
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
