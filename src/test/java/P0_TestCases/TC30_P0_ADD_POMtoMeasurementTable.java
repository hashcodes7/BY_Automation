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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC30_P0_ADD_POMtoMeasurementTable extends WMS_TestBase{
	
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
			
			setReport("TC30_P0 Create Measurement and ADD POM to measurement");
		}
	}
	@Test(priority = 0, dataProvider = "TC30_P0_ADD_POMtoMeasurementTable", dataProviderClass = DataProviders.class)
	public void TC_30_P0_ADD_POM_CreateMeasurementSet_UsingTemplate(String TestType,String season,String linesheetview,String filterproduct
			,String source,String specifications,String  measurementsetname,String template_name,String productsize,
			String gradetemplate,String measurementtype) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC30_P0 Create Measurement and ADD POM to measurement:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_174 to TC_182");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+ URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.PASS, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
//			String season="Levi's S1 2025 Female Accessories";
			MeasurementsPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addSrceenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.PASS, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);
			
			Thread.sleep(1000); 
			
//			String linesheetview="Adoption";
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);
			
//			String filterproduct="18_LSE";
			MeasurementsPage.filter_product(filterproduct,test);
			test.log(Status.INFO, "clicked on product "+filterproduct);
			addSrceenShot("clicked on product ", test, Capture);
			
//			String source="0WPJX";
			MeasurementsPage.selectSource(source,test);
			test.log(Status.INFO, "Selected source "+source);
			addSrceenShot("Selected source "+source, test, Capture);
			System.out.println("Selected source "+source);
			
//			String specifications="S1 2025 - 0WPJX - 18_LSE";
			MeasurementsPage.selectSpecifications(specifications,test);
			test.log(Status.INFO, "Selected specifications "+source);
			addSrceenShot("Selected specifications "+source, test, Capture);
			System.out.println("Selected specifications "+source);
			
			MeasurementsPage.NavigateTo_measurement();
			test.log(Status.INFO, "Navigated to measurement page ");
			addSrceenShot("Navigated to measurement page  ", test, Capture);
			System.out.println("Navigated to measurement page  ");
			
//			String  measurementsetname="Test_auto_04";
//			String template_name="DOCKERS-BIG-KNITS-H117";
//			String productsize="B&T--Waist Size:44-66";
//			String gradetemplate="Dockers";
//			String measurementtype="BEFORE WASH";
			MeasurementsPage.New_MeasurementSet_AddPOM(measurementsetname,template_name,productsize,gradetemplate,measurementtype,test);
			test.log(Status.PASS, "measurements is created with measurement name: "+measurementsetname);
			addSrceenShot("measurements is created with measurement name: "+measurementsetname, test, Capture);
			System.out.println("measurements is created with measurement name: "+measurementsetname);
			
			
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