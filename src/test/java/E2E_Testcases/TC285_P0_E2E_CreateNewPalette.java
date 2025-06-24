package E2E_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

public class TC285_P0_E2E_CreateNewPalette extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;

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
			setReport("TC285_P0_E2E_Create_new_palette");
		}
	}

	@Test( priority = 0, dataProvider = "TC285_P0_E2E_Create_new_palette", dataProviderClass = DataProviders.class)
	
	public void P0_TC285_E2E_Createpallete(String TestType,String season,String palettename) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC285_P0_E2E_Create_new_palette:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers TC_285");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully "+Administrator_URL);

			Thread.sleep(5000);
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("My seasons menu clicked", test, Capture);
			
			palettepage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addSrceenShot("Season value seleted"+season, test, Capture);

			palettepage.palettemenu();
			test.log(Status.INFO, "Clicked on Palette");
			addSrceenShot("Clicked on Palette", test, Capture);
			
			palettepage.Click_CreateNewPalette();
			test.log(Status.INFO, "Clicked on create new palette");
			addSrceenShot("Clicked on create new Palette", test, Capture);
			
			palettepage.Fill_CreateNewPalette(palettename);
			test.log(Status.INFO, "Filled name for create new palette");
			addSrceenShot("Filled name for create new palette", test, Capture);
			
			palettepage.Validate_PaletteCreation(palettename,test);
			test.log(Status.PASS, "Validation successful for create new palette");
			addSrceenShot("Validation successful for create new palette", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.PASS, "Logout successful");
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
