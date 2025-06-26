package E2E_Testcases;

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

import com.WMS_ApplicationPages.BOM_Page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CreateNewProductPage;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC304_305_E2E_Update_BOM_Details extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	BOM_Page BOMPage;

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
			BOMPage = new BOM_Page(driver);
			setReport("TC_05_Process_Flow_BOM_Details_Update_Perform_Mass_Change");
		}
	}

	@Test( priority = 0, dataProvider = "BOM_App_Data", dataProviderClass = DataProviders.class)

	public void P0_TC_05_updateBOM(String TestType,String Season,String PC9_1,String Component,String ComponentLoc,String Remarks,String Material,String PC9_2,String Qty,String NewRemarks) throws Exception {
//	@Test( priority = 0)
//	public void P0_TC_05_updateBOM()throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC_05_Process_Flow_BOM_Details_Update_Perform_Mass_Change:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers from TC_304 to 305");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + URL);
			Thread.sleep(5000);

			BOMPage.openBomApp(test);
			test.log(Status.PASS, "BOM App is opened");
			addScreenShot("BOM App is opened", test, Capture); 
			
			BOMPage.updateBomDetails(test,Season,PC9_1,Component,ComponentLoc,Remarks,Material);
			test.log(Status.PASS, "BOM Details are updated and validated");
			addScreenShot("BOM Details are updated and validated", test, Capture); 
			
			BOMPage.MassUpdateBomDetails(test,Season,PC9_2,Qty,NewRemarks);
			test.log(Status.PASS, "BOM Details are updated and validated for bulk data");
			addScreenShot("BOM Details are updated and validated for bulk data", test, Capture); 
			
			
		} catch (Exception e) {
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