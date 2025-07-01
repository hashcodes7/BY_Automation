package smoketests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;


import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class ST_TC22_Update_Material extends WMS_TestBase{
	
	WebDriver driver;
	DashboardPage dashboardPage;
	MaterialPage materialPage;
	boolean Capture = true;

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(CurrentURL);
			dashboardPage = new DashboardPage(driver);
			materialPage=new MaterialPage(driver);
			setReport("ST_TC22_Update_Material_");
		}
	}
	@Test(priority = 0)
	public void ST_TC22_Update_Material_() throws Exception {
		if (CloseBrowser) {
			test = extent.createTest("::: ST_TC22_Update_Material_ :::"); 
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();
		
		try {
	    test.log(Status.INFO, "🚀 Starting execution of Test Case: TC_292 - FlexPLM Material Edit Flow");

	    System.out.println("Browser Launched successfully");
	    test.log(Status.INFO, "✅ Browser launched successfully");

	    System.out.println("login to flex PLM application successfully");
	    test.log(Status.INFO, "🔐 Logged into FlexPLM application at: " + CurrentURL);

	    test.log(Status.INFO, "📌 Executing header dropdown search for Material → FA773301 Knits_demo_Mat_stg_03");
	    dashboardPage.headerDropdownSearch("Material", "FA773301 Knits_demo_Mat_stg_03");

	    test.log(Status.INFO, "⏳ Waiting briefly before attempting edit operation");
	    Thread.sleep(5000);
	    System.out.println("1");

	    test.log(Status.INFO, "✏️ Initiating material page edit");
	    materialPage.editmaterialonPage();
	    test.log(Status.PASS, "🎯 Material edited successfully : FA773301");

	    test.log(Status.INFO, "🚪 Logging out of application");
	    dashboardPage.Logout();
	    System.out.println("Logout successful");
	    test.log(Status.INFO, "✅ Logged out successfully");

	    addScreenShot("📸 Clicked on Logout successful", test, Capture);
	    test.log(Status.INFO, "📎 Screenshot captured post logout");

	} catch (Exception e) {
	    System.out.println("Test case failed due to application slowness" + e);
	    test.log(Status.FAIL, "⚠️ Test case failed due to application slowness: " + e);
	    throw e;
	}
	}
	
	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}


}

