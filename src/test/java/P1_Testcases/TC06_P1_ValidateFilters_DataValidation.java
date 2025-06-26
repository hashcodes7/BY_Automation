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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC06_P1_ValidateFilters_DataValidation extends WMS_TestBase {
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
			
			setReport("TC06_P1_ValidateFilters_DataValidation");
		}
	}
	@Test(priority = 0, dataProvider = "TC06_P1_ValidateFilters_DataValidation", dataProviderClass = DataProviders.class)
	public void P1_TC_06_ValidateLinesheet_Datavalidation_Filter(String TestType,String season,String filterValue,String expectedAttributes,String activate) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC06_P1_ValidateFilters_DataValidation :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_111 to TC_114");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully and URL is: "+URL);
					
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
			WaitforPage(5000);

			LineSheetEditPage.Linesheetfilter(filterValue);
			test.log(Status.INFO, "Filter selected is: "+filterValue);
			addScreenShot("Filter selected is: "+filterValue, test, Capture);
			
			LineSheetEditPage.Validate_FilterAttributes_DataValidation(expectedAttributes,test);
			test.log(Status.PASS, "All the attributes are present according to the filter option ");
			addScreenShot("All the attributes are present according to the filter option  ", test, Capture);
			
			LineSheetEditPage.Enter_DataValidationFilter_values(activate,test);
			System.out.println("Entered/selected all the fields for filtering linesheet using filter option");
			test.log(Status.INFO, "Entered/selected all the fields for filtering linesheet using filter option");
			addScreenShot("Entered/selected all the fields for filtering linesheet using filter option ", test, Capture);
			
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
