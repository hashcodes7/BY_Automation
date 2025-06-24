package P1_Testcases;

import java.awt.AWTException;
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
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC08_P1_ValidateFilters_GlobalFilter extends WMS_TestBase {
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
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			
			setReport("TC08_P1_ValidateFilters_GlobalFilter");
		}
	}
	@Test(priority = 0, dataProvider = "TC08_P1_ValidateFilters_GlobalFilter", dataProviderClass = DataProviders.class)
	public void P0_TC_08_ValidateLinesheet_Global_Filter(String TestType,String season,String filterValue,String expectedAttributes
			,String colorwayname,String colorwaycode,String linesheetview) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC08_P1_ValidateFilters_GlobalFilter :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_115 to TC_118");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully and URL is: "+URL);
					
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			LineSheetEditPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addSrceenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);
			WaitforPage(10000);

			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view is "+linesheetview, test, Capture);
			WaitforPage(5000);
			
			LineSheetEditPage.Change_Global_Value();
			System.out.println("Global value selected");
			test.log(Status.INFO, "Global value selected");
			addSrceenShot("Global value selected", test, Capture);

			LineSheetEditPage.Linesheetfilter(filterValue);
			test.log(Status.INFO, "Filter selected is: "+filterValue);
			addSrceenShot("Filter selected is: "+filterValue, test, Capture);
			
			LineSheetEditPage.Filters_Attribute_Validation(expectedAttributes,test);
			System.out.println("All the attributes are present according to the filter option");
			test.log(Status.PASS, "All the attributes are present according to the filter option ");
			addSrceenShot("All the attributes are present according to the filter option  ", test, Capture);

			LineSheetEditPage.Enter_GlobalFiltervalues(colorwayname,colorwaycode,test);
			System.out.println("Entered/selected all the fields for filtering linesheet using filter option");
			test.log(Status.INFO, "Entered/selected all the fields for filtering linesheet using filter option");
			addSrceenShot("Entered/selected all the fields for filtering linesheet using filter option ", test, Capture);
			
			LineSheetEditPage.validate_filteredLinesheet(test);
			System.out.println("Validation successful for filter option"+filterValue);
			test.log(Status.PASS, "Validation successful for filter option"+filterValue);
			addSrceenShot("Validation successful for filter option"+filterValue, test, Capture);

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
