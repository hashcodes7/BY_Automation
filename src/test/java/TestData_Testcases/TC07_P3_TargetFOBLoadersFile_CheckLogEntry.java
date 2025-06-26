package TestData_Testcases;

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
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.LogEntry_page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC07_P3_TargetFOBLoadersFile_CheckLogEntry extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	CustomLoaders_page customLoadersPage;
	Colorway_page Colorwaypage;
	LogEntry_page LogEntrypage ;
	LineSheet_Edit_Page LineSheetEditPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			LogEntrypage=new LogEntry_page(driver);
			setReport("TC07_P3_TargetFOBLoadersFile_CheckLogEntry");
		}
	}

	@Test(priority = 0, dataProvider = "TC07_P3_TargetFOBLoadersFile_CheckLogEntry", dataProviderClass = DataProviders.class)
	public void P3_TC_07_TargetFOB_CheckLogEntry(String TestType, String uploadFilepath, String resultFilepath,
			String filetype, String season, String linesheetview, String colorway, String targetFOB, String createddate,
			String LogEntryObject, String event) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC07_P3_TargetFOBLoadersFile_CheckLogEntry:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This Testcase covers TC_84 and TC_89");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully" + Administrator_URL);
			test.log(Status.INFO, "login to flex PLM application successfully and URL is: " + Administrator_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);

			mainMenuPage.LibraryMenu(MainMenuEnum.REPORTS.menu(), MainMenuEnum.REPORTS_LoadFile.menu());
			test.log(Status.INFO, "Clicked on Reports Load file ");
			addScreenShot("Clicked on Reports Load file ", test, Capture);

			WaitforPage(2000);

			customLoadersPage.selectFileType(filetype);
			test.log(Status.INFO, "File type selected is:   " + filetype);
			addScreenShot("File type selected ", test, Capture);

			customLoadersPage.uploadFile(uploadFilepath);
			System.out.println("file uploaded");
			test.log(Status.INFO, "File uploaded");
			addScreenShot("File uploaded", test, Capture);
			Thread.sleep(5000);

			String result = customLoadersPage.Validate_TargetFOB_LoaderResult(resultFilepath);
			String[] str = result.split(",");
			if (str[0].equalsIgnoreCase("Error")) {
				test.log(Status.INFO, "Result is: " + str[0]);
				test.log(Status.INFO, "Message is: " + str[1]);

			} else {
				test.log(Status.PASS, "File is uploaded and The Result is: " + str[0] + "and message is: " + str[1]);
				System.out.println("File is uploaded and The Result is success");
				addScreenShot("File is uploaded and The Result is success", test, Capture);

				mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
				test.log(Status.INFO, "My seasons menu clicked");
				addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

				Colorwaypage.SeasonDropdown(season, test);
				test.log(Status.INFO, "season selected: " + season);
				addScreenShot("season selected", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addScreenShot("Clicked on Line Sheets", test, Capture);

				WaitforPage(5000);

				LineSheetEditPage.filter_View_Change(linesheetview, test);
				test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
				addScreenShot("Linesheet view changed", test, Capture);

				customLoadersPage.Validate_TargetFOB_Linesheet(colorway, targetFOB, test);
				System.out.println("Validation successful for Target FOB");
				test.log(Status.PASS, "Validation successful for Target FOB");
				addScreenShot("Validation successful for Target FOB", test, Capture);
				
				mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_LOG_ENTRY.menu());
				test.log(Status.INFO, "Clicked on Libraries menu");
				addScreenShot("Clicked on Libraries menu", test, Capture);

				Thread.sleep(2000);
				
				LogEntrypage.select_LogEntryObject(LogEntryObject,test);
				System.out.println("Log Entry Object is selected ");
				test.log(Status.INFO, "Log Entry Object is selected");
				addScreenShot("Log Entry Object is selected", test, Capture);
				Thread.sleep(2000);

				LogEntrypage.Add_criteria(event,createddate,test);
				System.out.println("Criteria is added ");
				test.log(Status.INFO, "Criteria is added");
				addScreenShot("Criteria is added", test, Capture);
				Thread.sleep(2000);
				
				LogEntrypage.clickedFirst_viewdetails();
				System.out.println("view details page is opened ");
				test.log(Status.INFO, "view details page is opened ");
				
				Thread.sleep(3000);
				
				LogEntrypage.validate_Logdetails(event,LogEntryObject,test);
				System.out.println("Validation successful for Log Entry details ");
				test.log(Status.PASS, "Validation successful for Log Entry details");
				addScreenShot("Validation successful for Log Entry details", test, Capture);
				
				dashboardPage.Logout();
				System.out.println("Logout successful");
				addScreenShot("Clicked on Logout successful", test, Capture);
		
			}

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
