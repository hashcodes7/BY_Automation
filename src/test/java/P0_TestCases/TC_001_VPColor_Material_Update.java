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

@Test(enabled = true, groups= {"P0_TC"})
public class TC_001_VPColor_Material_Update extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	VendorPortalPage vendorPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			vendorPage = new VendorPortalPage(driver);
			setReport("TC_Vendor_Portal_001_Validate VP Color and Material update");
		}
	}

	@Test( priority = 0, dataProvider = "Vendor_Portal_Data", dataProviderClass = DataProviders.class)

	public void P0_TC_02_vendor_masster_update(String TestType,String vendorId,String material,String color,String materialCode) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC_Vendor_Portal_001_Validate VP Color and Material update:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers from TC_274 to 281");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + URL);
			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu());
			test.log(Status.INFO, "Clicked on Material menu ");
			addScreenShot("Clicked on material menu ", test, Capture);
			Thread.sleep(4000);
			
			vendorPage.materialPage(test, material);
			test.log(Status.INFO, "material page is opened");
			addScreenShot("material page opened", test, Capture);
			Thread.sleep(5000);
			
			vendorPage.materialUpdate(test);
			test.log(Status.PASS, "material information is updated and validated");
			addScreenShot("material information updated and validated", test, Capture);
			Thread.sleep(5000); 
			
			vendorPage.materialSupplierUpdate(test);
			test.log(Status.PASS, "material supplier information is updated and validated");
			addScreenShot("material supplier information updated and validated", test, Capture);
			Thread.sleep(5000); 
			
			vendorPage.addColorToMaterial(test,color);
			test.log(Status.PASS, "added & validated color to the material");
			addScreenShot("added & validated color to the material", test, Capture);
			Thread.sleep(5000); 
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);
			
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