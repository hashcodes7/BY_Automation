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
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import junit.framework.Assert;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC01_P1_VerifyAttributes_CreatePrintsandPatternsPage extends WMS_TestBase{
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Colorway_page Colorwaypage;
	CreateNewColorPage CNCP;
	
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
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
			CNCP = new CreateNewColorPage(driver);
			setReport("TC01_P1 Verify Attributes in Create Print and Patterns Color page");
		}
	}
	
	@Test(priority = 0,dataProvider = "TC01_P1_VerifyAttributes_CreatePrintsandPatternsPage", dataProviderClass = DataProviders.class)
	
	public void P1_TC01_Search_Printsandpatterns(String TestType,String colortype,String attributes) throws Exception {
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P1 Verify Attributes in Create Print and Patterns Color page:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			test.log(Status.INFO, "This testcase covers TC_03 and TC_04");
			
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
			CNCP.clickplussign();
			test.log(Status.INFO, "Clicked on Add color Sign");
			addSrceenShot("Clicked on Add color Sign", test, Capture);
			
			CNCP.SelectColorType(colortype,test);
			test.log(Status.INFO, "Clicked On: " +colortype+" and color page opened");
			addSrceenShot("Clicked On: " +colortype+" and color page opened", test, Capture);
			
			String title= driver.getTitle();
			System.out.println(title);
			Assert.assertTrue(title.equalsIgnoreCase("Create Color"));
			test.log(Status.INFO, "create colour page opened");
			
			Thread.sleep(5000);
			
			Colorwaypage.Validate_Create_PrintsandPatternsPage_Attributes(attributes,test);
			test.log(Status.PASS, "Validated create Prints and Patterns color page Attributes: "+attributes);
			System.out.println("Validated Prints and Patterns color page Attributes: "+attributes);
			addSrceenShot("Vlaidated create Prints and patterns page Attributes", test, Capture);

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
