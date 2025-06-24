package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.LogEntry_page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_UpdateMultipleMassUpdate_CostwiseView_LogEntry extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	LogEntry_page LogEntrypage ;
	Techpack_pages Techpackpages;
	
	
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
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			LogEntrypage=new LogEntry_page(driver);
			Techpackpages = new Techpack_pages(driver);
			
			setReport(" TC_P3_UpdateMultipleMassUpdate_CostwiseView_LogEntry");
		}
	}

	@Test(priority = 0,dataProvider = "TC_P3_UpdateMultipleMassUpdate_CostwiseView_LogEntry", dataProviderClass = DataProviders.class)
		
		public void UpdateMultipleColorway_CostviewAttributes(String[][] testData) throws Exception {

			for (int i = 0; i < testData.length; i++) {
				String[] data = testData[i];
//					String TestType = data[0];
				String season = data[1];
				String filterdata = data[2];
				String linesheetview = data[3];
				String targetvolume = data[4];
				String globalmsrp = data[5];
				String createddate = data[6];
				String LogEntryObject = data[7];
				String event = data[8];
		
		
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC_P3_UpdateMultipleMassUpdate_CostwiseView_LogEntry:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This scenario covers 4 testcases(TC_01 to TC_04)");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully and teh URL is : "+Administrator_URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			WaitforPage(5000);
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view is "+linesheetview, test, Capture);
			
			Techpackpages.filterdata(filterdata);
			test.log(Status.INFO, "Data filtered " + filterdata);
			addSrceenShot("Data filtered " + filterdata, test, Capture);
			System.out.println("Data filtered " + filterdata);
			
			
			int noofrecords_Linesheet=LineSheetEditPage.MassEdit_CostWiseViewAttributes(targetvolume, globalmsrp,test);
			System.out.println("Mass edit is completed for costwise view ");
			test.log(Status.INFO, "Mass edit is completed for costwise view ");
			addSrceenShot("Mass edit is completed for costwise view ", test, Capture);
			Thread.sleep(5000);
			
			System.out.println(noofrecords_Linesheet);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_LOG_ENTRY.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addSrceenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(2000);
			
			LogEntrypage.select_LogEntryObject(LogEntryObject,test);
			System.out.println("Log Entry Object is selected ");
			test.log(Status.INFO, "Log Entry Object is selected");
			addSrceenShot("Log Entry Object is selected", test, Capture);
			Thread.sleep(2000);
			
			
			LogEntrypage.Add_criteria(event,createddate,test);
			System.out.println("Criteria is added ");
			test.log(Status.INFO, "Criteria is added");
			addSrceenShot("Criteria is added", test, Capture);
			Thread.sleep(2000);
			
			LogEntrypage.clickedFirst_viewdetails();
			System.out.println("view details page is opened ");
			test.log(Status.INFO, "view details page is opened ");
			
			Thread.sleep(3000);
			
			LogEntrypage.validate_Logdetails(event,LogEntryObject,test);
			System.out.println("Validation successful for Log Entry details ");
			test.log(Status.PASS, "Validation successful for Log Entry details");
			addSrceenShot("Validation successful for Log Entry details", test, Capture);
			
			 if (i == testData.length - 1) {
					// Last iteration, perform logout

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addSrceenShot("Logout successful", test, Capture);
					
				} else {
					
					// Not the last iteration, refresh the browser
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();		
				}
			
		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;
		}
			}
	}
	
	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
