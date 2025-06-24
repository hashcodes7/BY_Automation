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

import Test_Rail.Test_Rail_Actions;

import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC_001_VPColor_Material_Update extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	VendorPortalPage vendorPage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
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
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu());
			test.log(Status.INFO, "Clicked on Material menu ");
			addSrceenShot("Clicked on material menu ", test, Capture);
			Thread.sleep(4000);
			
			vendorPage.materialPage(test, material);
			test.log(Status.INFO, "material page is opened");
			addSrceenShot("material page opened", test, Capture);
			Thread.sleep(5000);
			
			vendorPage.materialUpdate(test);
			test.log(Status.PASS, "material information is updated and validated");
			addSrceenShot("material information updated and validated", test, Capture);
			Thread.sleep(5000); 
			
			vendorPage.materialSupplierUpdate(test);
			test.log(Status.PASS, "material supplier information is updated and validated");
			addSrceenShot("material supplier information updated and validated", test, Capture);
			Thread.sleep(5000); 
			
			vendorPage.addColorToMaterial(test,color);
			test.log(Status.PASS, "added & validated color to the material");
			addSrceenShot("added & validated color to the material", test, Capture);
			Thread.sleep(5000); 
			
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