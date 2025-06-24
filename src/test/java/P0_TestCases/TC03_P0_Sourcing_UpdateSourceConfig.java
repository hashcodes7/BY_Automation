package P0_TestCases;
 
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.SourcingPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;
 

import resources.DataProviders;
 
@Test(enabled = true, groups= {"P0_TC"})
public class TC03_P0_Sourcing_UpdateSourceConfig extends WMS_TestBase {
 
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	SourcingPage sourcingPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
 
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;
 
	boolean Capture = true;

 
	List<HashMap<String, String>> data_ItemTable = null;
 
	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
 
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			sourcingPage = new SourcingPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC03_P0_Sourcing_UpdateSourceConfig verification");
		}
	}
 
	@Test(priority = 0, dataProvider = "updateSourceConfigData", dataProviderClass = DataProviders.class)
	public void P0_TC03_Sourcing_UpdateSourceConfig(String TestType, String productName, String seasonType,
			String sourceName, String vendor) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P0_Sourcing_UpdateSourceConfig verification:::");
		}
 
		CloseBrowser = false;
 
		// ...............................browser launched time starts
 
		long startTime = System.nanoTime();
		try {
 
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);
 
			test.log(Status.INFO, "This test case covers P0 Sourcing module from 239 to 241");
 
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
 
			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addSrceenShot("login successful", test, Capture);
 
			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);
 
			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_PRODUCT.menu(), true);
			test.log(Status.INFO, "Clicked on Main menu of Libraries");
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on product ");
			test.log(Status.INFO, "Clicked on product");
			WaitforPage(4000);
 
//			String productName = "2006LFA12345";
			productPage.filterProductByName(productName);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);
 
//			String seasonType = "Levi's S3 2024 Female Accessories";
			productPage.selectSeasonType(seasonType);
			test.log(Status.INFO, "Selected Season successfully: " + seasonType);
			addSrceenShot("Selected Season successfully", test, Capture);
			WaitforPage(5000);
 
//			String sourceName = "ADVANCE DENIM CO LTD 603190 CN";
			productPage.selectSourceFromDropDown(sourceName, test);
			System.out.println("Selected Source From Drop Down");
			test.log(Status.INFO, "Selected Source From Drop Down: " + sourceName);
			addSrceenShot("Selected Source From Drop Down", test, Capture);
 
			productPage.selectSourcingTab();
			System.out.println("Selected Sourcing tab");
			test.log(Status.INFO, "Selected Sourcing tab");
			addSrceenShot("Selected Sourcing tab", test, Capture);
			WaitforPage(4000);
 
			productPage.clickOnSummary();
			System.out.println("Clicked on Samples");
			test.log(Status.INFO, "Clicked on Samples");
			addSrceenShot("Clicked on Samples", test, Capture);
			WaitforPage(4000);
 
			productPage.clickOnUpdateSource();
			System.out.println("Clicked On Update Source ");
			test.log(Status.INFO, "Clicked On Update Source");
			addSrceenShot("Clicked On Update Source", test, Capture);
			WaitforPage(4000);
 
			productPage.clickOnVendorLink();
			test.log(Status.INFO, "Clicked On Vendor Hyperlink");
			addSrceenShot("Clicked On Vendor Hyperlink", test, Capture);
 
//			String vendor = "AMHOT INTL INC 601004 JP";
			productPage.selectVendor(vendor, test);
			test.log(Status.INFO, "Selected Vendor: " + vendor);
			addSrceenShot("Selected Vendor", test, Capture);
 
			productPage.clickOnSave();
			test.log(Status.INFO, "Clicked On Save Button ");
			addSrceenShot("Clicked On save Button", test, Capture);
 
			// Verify that the newly selected source is added to the product with its sourcing details updated
			String actualSourceName = productPage.verifySourceDetails(sourceName, test);
			if (actualSourceName != null && actualSourceName.contains(vendor)) {
				System.out.println(
						"The newly selected source is added to the product with its sourcing details updated.");
				test.log(Status.PASS,
						"Verification: The newly selected source is added to the product with its sourcing details updated: "
								+ actualSourceName);
				addSrceenShot("Source Details Updated", test, Capture);
			} else if (productPage.isVendorAlreadySourceConfigured()) {
                test.log(Status.WARNING, "Vendor is already source configured to Product'" + productName);
                addSrceenShot("Vendor was already selected", test, Capture);
            } else {
				System.out.println("Failed to update the source details.");
				test.log(Status.FAIL, "Failed to update the source details.");
				addSrceenShot("Source Details Update Failed", test, Capture);
			}
 
			
			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);
 
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