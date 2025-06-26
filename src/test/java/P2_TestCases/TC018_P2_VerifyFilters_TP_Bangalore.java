package P2_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC018_P2_VerifyFilters_TP_Bangalore extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
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
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			
			setReport("TC018_P2_VerifyFilters_TP_Bangalore");
		}
	}
	@Test(priority = 0, dataProvider = "TC018_P2_VerifyFilters_TP_Bangalore", dataProviderClass = DataProviders.class)
	public void P2_TC_010_ValidateLinesheet_TP_Bangalore_Filter(String TestType, String season, String filterValue, String expectedAttributes, String productname, String colorwayname, String colorwaycode, String productcode, String linesheetview, String PDS, String ProductDevCenter, String vendorId,  String available, String garmentdeveloper, String Grouping) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC018_P2_VerifyFilters_TP_Bangalore :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers P2 TC_117 to TC_120");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully and URL is: "+Administrator_URL);
					
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

			LineSheetEditPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addScreenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addScreenShot("Closed Left panel", test, Capture);
			WaitforPage(10000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addScreenShot("Linesheet view is "+linesheetview, test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.Linesheetfilter(filterValue);
			test.log(Status.INFO, "Filter selected is: "+filterValue);
			addScreenShot("Filter selected is: "+filterValue, test, Capture);
			
			LineSheetEditPage.Filters_Attribute_Validation(expectedAttributes,test);
			System.out.println("All the attributes are present according to the filter option");
			test.log(Status.PASS, "All the attributes are present according to the filter option ");
			addScreenShot("All the attributes are present according to the filter option  ", test, Capture);
			
			
			LineSheetEditPage.Enter_TP_BangaloreFilterFieldsValues(productname, colorwayname, vendorId, garmentdeveloper, PDS, ProductDevCenter, available, colorwaycode, productcode, Grouping, test);
			System.out.println("Entered/selected all the fields for filtering linesheet using filter option - India Kids");
			test.log(Status.INFO, "Entered/selected all the fields for filtering linesheet using filter option - India Kids");
			addScreenShot("Entered/selected all the fields for filtering linesheet using filter option - India Kids ", test, Capture);
			Thread.sleep(5000);
			
			LineSheetEditPage.validate_filteredLinesheet(test);
			System.out.println("Validation successful for filter option"+filterValue);
			test.log(Status.PASS, "Validation successful for filter option"+filterValue);
			addScreenShot("Validation successful for filter option"+filterValue, test, Capture);

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
