package P0_TestCases;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import junit.framework.Assert;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC02_P0_Measurements_CreateTemplate extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	Measurements_Page MeasurementsPage;
	
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
			MeasurementsPage = new Measurements_Page(driver);
			
			setReport("TC02_P0 Create New Measurements Template");
		}
	}
	@Test(priority = 0, dataProvider = "TC02_P0_Measurements_CreateTemplate", dataProviderClass = DataProviders.class)

	public void TC_02_P0_CreateNewMeasurementsTemplate(String TestType,String template,String measurement_name,String measurement_type) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC02_P0 Create New Measurements Template:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_157 to TC_160");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+ URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MEASUREMENTS.menu());
			test.log(Status.INFO, "Clicked on Measurements menu ");
			addSrceenShot("Clicked on Measurements menu ", test, Capture);
			
			Thread.sleep(5000);

			MeasurementsPage.SelectTemplate(template);
			test.log(Status.INFO, "Template is selected: "+template);
			addSrceenShot("Template is selected ", test, Capture);
			
			MeasurementsPage.Create_New_Measurements_Template(measurement_name,measurement_type,test);
			test.log(Status.INFO, "New measurements template created with name:  "+measurement_name);
			addSrceenShot("New measurements template created  ", test, Capture);
			
			MeasurementsPage.Measurement_Template_Validation(measurement_name,test);
			test.log(Status.PASS, "Validated New measurements template "+measurement_name);
			addSrceenShot("Validated New measurements template  ", test, Capture);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);
					
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
