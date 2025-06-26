package P0_TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC04_P0_SCL_Create_seasonalBFFcolor extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	
	boolean Capture = true;

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			setReport("TC4_P0 Create Seasonal Look- create Seasonal BFF color ");
		}
	}
	@Test(priority = 0,dataProvider = "TC04_P0_SCL_Create_seasonalBFFcolor", dataProviderClass = DataProviders.class)
	public void P0_TC_9(String TestType,String season,String colortype,String redvalue, String bluevalue, String greenvalue, String colorfamily,String tier,String base,String facode,String createdfrom) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC4_P0 Create Seasonal Look- create Seasonal BFF color page:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();
		
		try {
			test.log(Status.INFO, "This Testcase covers TC_7 and TC_9");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "In libraries Color/Look menu clicked");
			addScreenShot("In libraries Color/Look menu clicked", test, Capture);
			
			Thread.sleep(5000);
			

			CNCP.clickplussign();
			test.log(Status.INFO, "Clicked on Add color sign");
			addScreenShot("Clicked on Add color sign", test, Capture);
			
			CNCP.SelectColorType(colortype,test);
			test.log(Status.INFO, "Clicked On: " +colortype+" and color page opened");
			addScreenShot("Clicked On: " +colortype+" and color page opened", test, Capture);
			
			String title=driver.getTitle();
			Assert.assertTrue(title.equalsIgnoreCase("Create Color"));
			test.log(Status.PASS, "Create colour page opened");
			
			CNCP.EnterSeasonalBFFValues(season,redvalue,bluevalue,greenvalue,colorfamily,tier,base,facode,createdfrom,test);
			test.log(Status.INFO, "All the required fields for seasonal color BFF is filled");
			addScreenShot("All the required fields for seasonal color BFF is filled", test, Capture);
			
			Thread.sleep(5000);
 			
			CNCP.clickcreatebutton();
			test.log(Status.INFO, "Seasonal color BFF is created");
			addScreenShot("Seasonal color BFF is created", test, Capture);
			
			Thread.sleep(5000);
			CNCP.VerifyViewColor(test);
			test.log(Status.PASS, "Validated fields in view color page");
			addScreenShot("Validated fields in view color page", test, Capture);	
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);
			
		}catch (Exception e) {
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
