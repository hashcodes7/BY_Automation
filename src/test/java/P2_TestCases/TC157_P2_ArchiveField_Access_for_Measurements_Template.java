package P2_TestCases;

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


import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC157_P2_ArchiveField_Access_for_Measurements_Template extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Measurements_Page MeasurementsPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Admin user before executing this test case
	 */
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			MeasurementsPage = new Measurements_Page(driver);

			setReport("TC157_P2_Archive Field Access for Measurement Admin user for Measurements Template");
		}
	}

	@Test(priority = 0, dataProvider = "TC157_P2_ArchiveField_Access_for_Measurements_Template", dataProviderClass = DataProviders.class)
	public void P2_TC157_ArchiveField_Access_for_Measurements_Template(String TestType, String template,
			String measurementTempName) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC157_P2_Archive Field Access for Measurement Admin user for Measurements Template:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers P2 Measurement module from  TC_157 to TC_159");

			System.out.println("Browser Launched successfully");
			
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully " + Administrator_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);

			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MEASUREMENTS.menu());
			test.log(Status.INFO, "Clicked on Measurements menu ");
			addSrceenShot("Clicked on Measurements menu ", test, Capture);

			Thread.sleep(5000);

//			String template = "Measurement Templates";
			MeasurementsPage.SelectTemplate(template);
			test.log(Status.INFO, "Template is selected: " + template);
			addSrceenShot("Template is selected ", test, Capture);

//			String measurementTempName = "Test_auto_02";
			MeasurementsPage.ClickUpdateMeasurementTemp(measurementTempName, test);
			System.out.println("Clicked on Update Measurement Templatate: " + measurementTempName);
			test.log(Status.INFO, "Clicked on Update Measurement Templatate: " + measurementTempName);
			addSrceenShot("Clicked on Update Measurements", test, Capture);

			MeasurementsPage.CheckArchiveField(test);
			test.log(Status.PASS, "Checked Archive field access for Measurement Templatate");
			addSrceenShot("Checked Archive field access ", test, Capture);

			MeasurementsPage.VerifyArchiveFieldNonEditable(test);
			test.log(Status.PASS, "Verified Archive field is non-editable");
			addSrceenShot("Verified Archive field is non-editable", test, Capture);

			WaitforPage(4000);
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
