

package smoketests;

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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class ST_TC12_Update_Color extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	String methodname="ST_TC02_Update_Color_";
	
	boolean Capture = true;

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(CurrentURL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			setReport("ST_TC12_Update_Color_");
		}
	}
	@Test(priority = 0)
	public void ST_TC12_Update_Color_() throws Exception {
		if (CloseBrowser) {
			test = extent.createTest("::: ST_TC12_Update_Color_ :::"); 
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();
		
		try {
		    test.log(Status.INFO, "🧪 This test case covers TC_292 – FlexPLM Seasonal Color Creation and Validation");

		    System.out.println("Browser Launched successfully");
		    test.log(Status.INFO, "Browser launched successfully");

		    System.out.println("login to flex PLM application successfully");
		    test.log(Status.INFO, "Logged into FlexPLM application at: " + CurrentURL);

		    test.log(Status.INFO, "Searching for Color/Look object: AutomationTest_05");
		    dashboardPage.headerDropdownSearch("Color/Look", "AutomationTest_05");
		    Thread.sleep(5000);
		    System.out.println("1");

		    test.log(Status.INFO, "Clicking the Update button to begin editing");
		    dashboardPage.updatebutton();
		    System.out.println("4");

		    test.log(Status.INFO, "Entering single-value seasonal color data");
		    CNCP.EnterSingleValue(test);
		    test.log(Status.INFO, "All required fields for seasonal color BFF filled");
		    System.out.println("5");
		    Thread.sleep(5000);

		    test.log(Status.INFO, "Saving the Color/Look object");
		    CNCP.savebutton();
		    test.log(Status.PASS, "Color Updated successfully : AutomationTest_05");
		    addScreenShot("Color is Updated", test, Capture);
		    System.out.println("6");

		    Thread.sleep(5000);
		    test.log(Status.INFO, "Validating fields in the View Color page");
		    CNCP.Validate_SolidColors("colorname", test);
		    test.log(Status.PASS, "View Color page validation completed");
		    addScreenShot("Validated fields in view color page", test, Capture);
		    Thread.sleep(5000);
		    System.out.println("7");

		    test.log(Status.INFO, "Logging out of FlexPLM");
		    dashboardPage.Logout();
		    System.out.println("Logout successful");
		    test.log(Status.INFO, "Logout successful");
		    addScreenShot("Clicked on Logout successful", test, Capture);

		} catch (Exception e) {
		    System.out.println("Test case failed due to application slowness" + e);
		    test.log(Status.FAIL, "Test case failed due, check system reports");
		    throw e;
		}
	}
	
	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}

