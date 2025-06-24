package P2_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Color_Page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC319_P2_VendorPortalAccessAndUpdate_DocumentsCreatedByVendor extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;
	VendorPortalPage vendorPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Vendor user before executing this test case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(VendorPortal_URl);
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			vendorPage = new VendorPortalPage(driver);

			setReport("TC319_P2_Vendor Portal Access And Update Document Created By Vendor");
		}
	}

    @Test(priority = 0, dataProvider = "TC319_P2_VendorPortalAccessAndUpdate_DocumentsCreatedByVendor", dataProviderClass = DataProviders.class)
    public void P2_TC319_VendorPortalAccessAndUpdate_DocumentsCreatedByVendor(String TestType, String documentType, String vendorDOCName, String newVendorName, String newDescription, String newDocumentType, String newLSCoDeveloper) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC319_P2_Vendor Portal Access And Update Document Created By Vendor:::");
		}

		CloseBrowser = false;
		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P2 Vendor Portal module from TC319 to TC321");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + VendorPortal_URl);
			addSrceenShot("login successful", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);
			WaitforPage(5000);

			mainMenuPage.selectsubmenu(MainMenuEnum.LIBRARIES_RETAILDOCUMENT.menu());
			test.log(Status.INFO, "Clicked on Retail Document");
			addSrceenShot("Clicked on Retail Document", test, Capture);
			WaitforPage(5000);
			
			System.out.println("Clicked on Retail Document Under Material");
			test.log(Status.INFO, "Clicked on Retail Document Under Material");
			addSrceenShot("Clicked on Retail Document Under Material", test, Capture);
			WaitforPage(4000);
			

			vendorPage.selectvendorDocumentsAndclickOnSearch(documentType, test);
			test.log(Status.INFO, "Vendor Document Search page opened");
			addSrceenShot("Vendor Document Search page opened", test, Capture);

//			String vendorDOCName = "Concept Presentations Test6";
			vendorPage.clickOnDocumentName(vendorDOCName);
			test.log(Status.INFO, "Clicked on Vendor Document Name");
			addSrceenShot("Clicked on Vendor Document Name", test, Capture);
			

			vendorPage.clickOnUpdateInActionsMenu();
			test.log(Status.INFO, "Clicked on Update in Actions menu");
			addSrceenShot("Clicked on Update in Actions menu", test, Capture);

//			String newVendorName = "ARVIND LIMITED 5151 IN";
//			String newDescription = "Test10";
//			String newDocumentType = "Dry Process Sheets";
//			String newLSCoDeveloper = "4403";

			vendorPage.updateAttributes(newVendorName, newDescription, newDocumentType, newLSCoDeveloper, test);
			test.log(Status.INFO, "Updated all the required attributes");
			addSrceenShot("Updated all the required attributes", test, Capture);

			WaitforPage(2000);
			vendorPage.clickOnSaveButton();
			test.log(Status.INFO, "Clicked on Save button");
			addSrceenShot("Clicked on Save button", test, Capture);

			vendorPage.verifyUpdatedAttributes(newVendorName, newDescription, newDocumentType, newLSCoDeveloper);
			test.log(Status.PASS, "Verified all the updated attributes on the Document update page");
	        addSrceenShot("Verified all the updated attributes on the Document update page", test, Capture);
	        
	    	WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
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
