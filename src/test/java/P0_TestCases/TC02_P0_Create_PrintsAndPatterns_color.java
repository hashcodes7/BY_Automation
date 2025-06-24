package P0_TestCases;

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
import junit.framework.Assert;

@Test(enabled = true, groups= {"P0_TC"})
public  class TC02_P0_Create_PrintsAndPatterns_color extends WMS_TestBase{
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
			setReport("TC02_Create Print and Patterns Color and and check derived attributes");
		}
	}
	
	@Test(priority = 0,dataProvider = "Create_Colors_PrintsandPatterns", dataProviderClass = DataProviders.class)
	
	public void P0_TC_6(String TestType,String season,String redvalue, String bluevalue, String greenvalue, String artworkname, 
			String colorfamily,String artworkcode, String patterntype, String colorcombo, String developer,String colortype) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC02_Create Print and Patterns Color and and check derived attributes:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			test.log(Status.INFO, "This testcase covers TC_5 and TC_6");
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

			Thread.sleep(5000);

			CNCP.clickplussign();
			test.log(Status.INFO, "Clicked on Add color Sign");
			addSrceenShot("Clicked on Add color Sign", test, Capture);
			
			CNCP.SelectColorType(colortype,test);
			test.log(Status.INFO, "Clicked On: " +colortype+" and color page opened");
			addSrceenShot("Clicked On: " +colortype+" and color page opened", test, Capture);
			
			String title= driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.equalsIgnoreCase("Create Color"));
			test.log(Status.PASS, "create colour page opened");
			
			Thread.sleep(5000);
			
			CNCP.createcolorPrintsandPatterns(redvalue,bluevalue,greenvalue,artworkname,artworkcode,colorfamily,patterntype,colorcombo,developer,test);
			test.log(Status.INFO, "All the required fields are filled");
			addSrceenShot("All the required fields are filled", test, Capture);
			
			CNCP.clickcreatebutton();
			test.log(Status.INFO, "Colour created under Prints and patterns");
			
			Thread.sleep(3000);
			CNCP.PrintsandPatterns_color_validation(artworkname,test);
			test.log(Status.PASS, "Validation is successful");
			addSrceenShot("Validation is successful", test, Capture);
			
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
