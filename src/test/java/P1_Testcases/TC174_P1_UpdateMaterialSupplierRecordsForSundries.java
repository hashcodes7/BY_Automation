package P1_Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Color_Page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC174_P1_UpdateMaterialSupplierRecordsForSundries extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;

	boolean Capture = true;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			setReport("TC174_P1_Update Material Supplier Records For Sundries");
		}
	}

	@Test(priority = 0, dataProvider = "updateMaterialSupplierData", dataProviderClass = DataProviders.class)
	public void P1_TC174_UpdateMaterialSupplierRecordsForSundries(String TestType, String materialType, String materialName,
			String supplierName, String supplierArticleNo, String supplierDescription, String minimumPerColorUOM,
			String approvalDate_MMDDYYYY, String MinimumPerOrderUOM, String materialCountryOfOrigin, String IncoTerms,
			String testResults, String labTestReportNumber, String physicalTestPassed, String minimumPerColor,
			String performanceTestPass, String minimumsPerOrder, String leadTimeProductionCalendardays,
			String uomConversionFactor, String leadTimeSampleCalendardays, String MaterialPrice)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC174_P1_Update Material Supplier Records For Sundries:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 material module from TC174 to TC178");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL " + PDS_URL);
			addSrceenShot("Login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addSrceenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			WaitforPage(4000);

//			String materialType = "Buttons";
			materialPage.selectMaterialType(materialType, test);
			System.out.println("Fabric Record Type Was choosen");
			test.log(Status.INFO, "Fabric Record Type Was choosen: " + materialType);
			addSrceenShot("Fabric Record Type Was choosen", test, Capture);
			WaitforPage(4000);

//			String materialName = "S231113 Button Demo_sundries_material_01";
			materialPage.searchMaterial(materialName, test);
			System.out.println("Searched for the Material");
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addSrceenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);
			
			materialPage.clickOnMaterial(materialName);
			System.out.println("Ciicked On material: "+materialName);
			test.log(Status.INFO, "Ciicked On material: " + materialName);
			addSrceenShot("Ciicked On material: ", test, Capture);

//			String supplierName = "3M INDUSTRIAL ADHESIVE & TAPES 603112 US";
			color_Page.selectSupplierFromDropDown(supplierName, test);
			System.out.println("Clicked on supplier From Drop Down");
			test.log(Status.INFO, "Clicked on supplier From Drop Down: " + supplierName);
			addSrceenShot("Clicked on Source From Drop Down", test, Capture);

			materialPage.updateMaterialSupplier(test);
			System.out.println("Clicked on Update Material/Supplier");
			test.log(Status.INFO, "Clicked on Update Material/Supplier");
			addSrceenShot("Clicked on Update Material/Supplier", test, Capture);
			WaitforPage(4000);

//			String supplierArticleNo = "23145";
//			String supplierDescription = "DEMO_sup";
//			String minimumPerColorUOM = "each";
//			String approvalDate_MMDDYYYY = "08/20/2024";
//			String MinimumPerOrderUOM = "each";
//			String materialCountryOfOrigin = "India";
//			String IncoTerms = "FOB";
//			String testResults = "pa123";
//			String labTestReportNumber = "1";
//			String physicalTestPassed = "Pass";
//			String minimumPerColor = "1";
//			String performanceTestPass = "Pass";
//			String minimumsPerOrder = "3";
//			String leadTimeProductionCalendardays = "26";
//			String uomConversionFactor = "1";
//			String leadTimeSampleCalendardays = "13";
//			String MaterialPrice = "25";

			materialPage.enterMaterialSupplierAttributesSundries(supplierArticleNo, supplierDescription,
					minimumPerColorUOM, approvalDate_MMDDYYYY, MinimumPerOrderUOM, materialCountryOfOrigin, IncoTerms,
					testResults, labTestReportNumber, physicalTestPassed, minimumPerColor, performanceTestPass,
					minimumsPerOrder, leadTimeProductionCalendardays, uomConversionFactor, leadTimeSampleCalendardays,
					MaterialPrice, test);
			System.out.println("Entered and edited data for all material/supplier level attributes");
			test.log(Status.INFO, "Entered and edited data for all material/supplier level attributes");
			addSrceenShot("Entered and edited data for all material/supplier level attributes", test, Capture);
			WaitforPage(4000);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			materialPage.validateMaterialSupplierInformationAndPrice(materialCountryOfOrigin, MaterialPrice, test);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left panel");
			test.log(Status.INFO, "Clicked on close Left panel");
			addSrceenShot("Clicked on close Left panel", test, Capture);

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
