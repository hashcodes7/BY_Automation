package P0_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC04_P0_SCL_UpdateColorLookName extends WMS_TestBase{
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
			setReport("TC4_P0 Create Seasonal Look-check derived attributes and validate generic look created");
		}
	}
	
	@Test(priority = 0,dataProvider = "TC04_P0_SCL_UpdateColorLookName", dataProviderClass = DataProviders.class)
	public void P0_TC_10(String TestType,String colorname) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC4_P0 Create Seasonal Look-check derived attributes and validate generic look created:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();
		
		try {
			test.log(Status.INFO, "This Testcase covers TC_10");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, " libraries menu opened");
			addScreenShot("libraries menu opened", test, Capture);
			Thread.sleep(5000);
			

			CNCP.searchBox(colorname);
			test.log(Status.INFO, "Color name entered: "+colorname);
			addScreenShot("Color name entered", test, Capture);
			
			CNCP.searchButton();
			test.log(Status.INFO, "Search button clicked");
			addScreenShot("Search button clicked", test, Capture);
			
			CNCP.Action_update_DD();
			test.log(Status.INFO, "Update menu clicked");
			addScreenShot("Update menu clicked", test, Capture);
			
			CNCP.Validate_updatecolor(test);
			test.log(Status.PASS, "validated color/look name");
			addScreenShot("validated color/look name", test, Capture);
			
			CNCP.savebutton();
			test.log(Status.PASS, "Clicked on save button");
			addScreenShot("Clicked on save button", test, Capture);
			
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
