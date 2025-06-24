package P0_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;



import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC01_P0_Palette_CreateColor extends WMS_TestBase {
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
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			setReport("TC1_P0 Palette- Create Color Records for Heathers Solid");
		}
	}

	@Test( priority = 0, dataProvider = "Create_New_Colors", dataProviderClass = DataProviders.class)
	
	public void P0_TC_4(String TestType,String season,String actionvalue,String redvalue, String bluevalue, String greenvalue, String colorname, 
			String colorfamily,String standardprovider, String colorcode, String providercolorname) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC1_P0 Palette- Create Color Records for Heathers Solid:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers TC_3 and TC_4");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully "+URL);

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
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);
						
			palettepage.action_DD(actionvalue);
			test.log(Status.INFO, "Create new colour seleted for "+ actionvalue);
			addSrceenShot("create new colour seleted", test, Capture);
			
			WaitforPage(5000);

			palettepage.heathers();
			test.log(Status.INFO, "Heathers colore page opened");
			addSrceenShot("Heathers colore page opened", test, Capture);

			CNCP.EnterValues(redvalue, bluevalue, greenvalue, colorname, colorfamily, standardprovider, colorcode,
					providercolorname,test);
			test.log(Status.INFO, "All the required values are filled");
			addSrceenShot("All the required values are filled", test, Capture);
			
			CNCP.clickcreatebutton();
			test.log(Status.INFO, "Clicked on Create button");
			addSrceenShot("Clicked on Create button", test, Capture);
					
			WaitforPage(5000);
			
			String Title= driver.getTitle();
			Assert.assertEquals(Title, "View Palette");
			test.log(Status.PASS, "Color created and the page title is View palette");
			
			CNCP.color_validation(colorname,test);
			test.log(Status.PASS, "Validation is successful");
			addSrceenShot("Validation is successful", test, Capture);
			
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