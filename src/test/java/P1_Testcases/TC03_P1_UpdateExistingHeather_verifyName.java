package P1_Testcases;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;
@Test(enabled = true, groups = { "Color_Scenarios" })
public class TC03_P1_UpdateExistingHeather_verifyName extends WMS_TestBase{
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
			setReport("TC03_P1 Update Heathers Color and verify attributes");
		}
	}
	
	@Test(priority = 0,dataProvider = "TC03_P1_UpdateExistingHeather_verifyName", dataProviderClass = DataProviders.class)
	
	public void P1_TC03_Update_Heathers(String TestType,String colorname,String createdfrom,String newcolorname) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P1 Update Heathers Color and verify attributes:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			test.log(Status.INFO, "This testcase covers TC_14 to TC_16");
			
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

			Colorwaypage.select_Heathers(createdfrom);
			test.log(Status.INFO, "Created from date selected: "+createdfrom);
			System.out.println("Created from date selected: "+createdfrom);
			addSrceenShot("Created from date selected", test, Capture);
			
			Colorwaypage.filtercolor(colorname);
			test.log(Status.INFO, "Filtered color selected: "+colorname);
			System.out.println("Filtered color selected: "+colorname);
			addSrceenShot("Filtered color selected", test, Capture);
			
			Colorwaypage.click_Heathers_color();
			test.log(Status.INFO, "Clicked heathers color");
			System.out.println("Clicked heathers color");
			addSrceenShot("Clicked heathers color ", test, Capture);
			
			Colorwaypage.updateHeathercolor(newcolorname);
			test.log(Status.INFO, "Updated heathers color name and the color name is:   "+newcolorname);
			System.out.println("Updated heathers color name and the color name is:   "+newcolorname);
			addSrceenShot("Updated heathers color name and the color name is:   "+newcolorname, test, Capture);
			
			Colorwaypage.Validate_colorname_searchcode(test);
			test.log(Status.PASS, "Validated colorname and searchcode successfully ");
			System.out.println("Validated colorname and searchcode successfully ");
			addSrceenShot("Validated colorname and searchcode successfully", test, Capture);
	
			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, " Logout successful");
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
