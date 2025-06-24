package P0_TestCases;

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
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC18_P0_SetUpLSUS extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	Set_Up_Page SetUpPage;
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
			palettepage = new Palette_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			SetUpPage = new Set_Up_Page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC18_P0_Create Levis Product and setup at LSUS");
		}
	}

	@Test(priority = 0,dataProvider = "TC18_P0_SetUpLSUS", dataProviderClass = DataProviders.class)
	public void P0_TC_18_Create_Levis_Product_and_setup_a_LSUS(String TestType,String season,String colorway) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC18_P0_Create Levis Product and setup at LSUS:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_46");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.PASS, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			SetUpPage.SeasonDropdown(season);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			LineSheetEditPage.filter_View_Change("Adoption",test);
			test.log(Status.INFO, "Linesheet view changed to: Adoption");
			addSrceenShot("Linesheet view changed", test, Capture);
			
			SetUpPage.SelectColorway(colorway);
			test.log(Status.INFO, "colorway details page opened "+ colorway);
			addSrceenShot("colorway details page opened", test, Capture);
			Thread.sleep(2000);
			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addSrceenShot("Colorway season edit page opened", test, Capture);
			Thread.sleep(2000);
			SetUpPage.SetUpLSUS(test);
			test.log(Status.INFO, "SetUP LSUS is completed");
			addSrceenShot("SetUP LSUS is completed", test, Capture);
			Thread.sleep(2000);
			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addSrceenShot("Colorway season edit page opened", test, Capture);
			Thread.sleep(2000);
			SetUpPage.ValidationLSUS(test);
			test.log(Status.PASS, "Validation successful of SetUpLSUS");
			addSrceenShot("Validation of SetUpLSUS", test, Capture);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
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
