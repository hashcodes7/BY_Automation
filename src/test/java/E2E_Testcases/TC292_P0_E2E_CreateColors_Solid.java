package E2E_Testcases;

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
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC292_P0_E2E_CreateColors_Solid extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL("https://wcadmin:wcadmindev12@flexplmdev.levi.com/Windchill/rfa/jsp/main/Main.jsp");
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			setReport("TC292_P0_E2E Create colors- create solid color ");
		}
	}
	@Test(priority = 0,dataProvider = "TC292_P0_E2E_CreateColors_Solid", dataProviderClass = DataProviders.class)
	public void P0_TC_292_E2E_CreateColors_Solid(String TestType,String colortype,String redvalue, String bluevalue, String greenvalue, 
			String colorfamily,String standardprovider, String colorcode, String colorname, String providercolorname) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC292_P0_E2E Create colors- create solid color :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();
		
		try {
			test.log(Status.INFO, "This Testcase covers TC_292");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "In libraries Color/Look menu clicked");
			addSrceenShot("In libraries Color/Look menu clicked", test, Capture);
			
			Thread.sleep(5000);
			
//			CNCP.selectColor(MainMenuEnum.LIBRARIES_COLOR.menu());
//			test.log(Status.INFO, "Clicked on color/look");
//			addSrceenShot("Clicked on color/look", test, Capture);

			CNCP.clickplussign();
			test.log(Status.INFO, "Clicked on Add color sign");
			addSrceenShot("Clicked on Add color sign", test, Capture);
			
//		Solid Colors	
			
			CNCP.SelectColorType(colortype,test);
			test.log(Status.INFO, "Clicked On: " +colortype+" and color page opened");
			addSrceenShot("Clicked On: " +colortype+" and color page opened", test, Capture);			
			
			
			String title=driver.getTitle();
			Assert.assertTrue(title.equalsIgnoreCase("Create Color"));
			test.log(Status.PASS, "Create colour page opened");
			
			CNCP.EnterSolidColors_Values(redvalue, bluevalue, greenvalue, colorfamily, standardprovider, colorcode,colorname,
					providercolorname,test);
			test.log(Status.INFO, "All the required fields for seasonal color BFF is filled");
			addSrceenShot("All the required fields for seasonal color BFF is filled", test, Capture);
			
			Thread.sleep(5000);
 			
			CNCP.clickcreatebutton();
			test.log(Status.INFO, "color is created");
			addSrceenShot(" color is created", test, Capture);
			
			Thread.sleep(5000);
			CNCP.Validate_SolidColors(colorname,test);
			test.log(Status.PASS, "Validated fields in view color page");
			addSrceenShot("Validated fields in view color page", test, Capture);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
				
			
		}catch (Exception e) {
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