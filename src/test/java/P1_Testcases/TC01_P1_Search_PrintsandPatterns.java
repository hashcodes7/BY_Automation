package P1_Testcases;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;
import junit.framework.Assert;
@Test(enabled = true, groups = { "Color_Scenarios" })
public class TC01_P1_Search_PrintsandPatterns  extends WMS_TestBase{
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Colorway_page Colorwaypage;
	
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
			Colorwaypage =new Colorway_page(driver);
			setReport("TC01_P1 Search Print and Patterns Color and and verify attributes");
		}
	}
	
	@Test(priority = 0,dataProvider = "TC01_P1_Search_PrintsandPatterns", dataProviderClass = DataProviders.class)
	
	public void P1_TC01_Search_Printsandpatterns(String TestType,String colorname,String createdfrom,String attributes) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P1 Search Print and Patterns Color and and verify attributes:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			test.log(Status.INFO, "This testcase covers TC_01 and TC_02");
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+ URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addSrceenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(3000);

			Colorwaypage.select_printsandPatterns(createdfrom);
			test.log(Status.INFO, "Created from date selected: "+createdfrom);
			System.out.println("Created from date selected: "+createdfrom);
			addSrceenShot("Created from date selected", test, Capture);
			
			Colorwaypage.filtercolor(colorname);
			test.log(Status.INFO, "Filtered color selected: "+colorname);
			System.out.println("Filtered color selected: "+colorname);
			addSrceenShot("Filtered color selected", test, Capture);
			
			Colorwaypage.clickcolor();
			test.log(Status.INFO, "Clicked on first color");
			System.out.println("Clicked on first color");
			addSrceenShot("Clicked on first color", test, Capture);
				
			Colorwaypage.Validate_PrintsandPatterns_details_Attributes(attributes,test);
			test.log(Status.PASS, "Validated Prints and Patterns color Attributes: "+attributes);
			System.out.println("Validated Prints and Patterns color Attributes: "+attributes);
			addSrceenShot("Vlaidated Prints and patterns Attributes", test, Capture);

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
