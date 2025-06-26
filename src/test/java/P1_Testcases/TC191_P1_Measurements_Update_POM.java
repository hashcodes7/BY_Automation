package P1_Testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;

import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public  class TC191_P1_Measurements_Update_POM extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
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
			LaunchSpecific_URL(GarmentDeveloper_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			MeasurementsPage= new Measurements_Page(driver);
			setReport("TC191_P1 Update POM points of Measure from Libraries");
		}
	}
	@Test(priority = 0, dataProvider = "updatePOMpointsData", dataProviderClass = DataProviders.class)
    public void TC_191_P1_UpdateNewPOMpoints(String TestType, String template, String pomDescription, String updatedPOMDescription, String updatedId) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC191_P1 Update POM points of Measure from Libraries:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers P1 Measurement module from  TC_191 to TC_192");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+ GarmentDeveloper_URL);
			addScreenShot("login to flex PLM application successfully", test, Capture);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addScreenShot("opened left panel", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MEASUREMENTS.menu());
			test.log(Status.INFO, "Clicked on Measurements menu ");
			addScreenShot("Clicked on Measurements menu ", test, Capture);
			
			Thread.sleep(5000);

//			String template = "POM Library";
	        MeasurementsPage.SelectTemplate(template);
	        test.log(Status.INFO, "Template is selected: " + template);
	        addScreenShot("Template is selected ", test, Capture);
	        
//			String pomDescription = "POM_Demo_AUG_01";
//			String updatedPOMDescription = "POM_Demo_02";
//			String updatedId = "341";
	        MeasurementsPage.Update_POMpoints(pomDescription,updatedPOMDescription, updatedId, test);
	        test.log(Status.INFO, "Updated POM template from " + pomDescription + " to " + updatedPOMDescription + " with ID " + updatedId);	        
	        addScreenShot("POM template updated ", test, Capture);

	        MeasurementsPage.Validate_POMpoints(updatedPOMDescription, test);
	        test.log(Status.PASS, "Validated updated POM template: " + updatedPOMDescription);
	        addScreenShot("Validated updated POM template ", test, Capture);
	        
	        WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);
	        
	        
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

