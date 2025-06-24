package P1_Testcases;

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
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC05_P1_AssociateSolidColorsToFabrics extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;

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
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			setReport("TC03_P1_Verify_AssociateSolidColorsToFabrics");
		}
	}

	@Test(priority = 0, dataProvider = "AssociateSolidColorsToFabrics", dataProviderClass = DataProviders.class)
	public void P1_TC05_VerifyFabricColorAssociation(String TestType, String materialType, String materialName, String supplierName, String colorType,
			String colorItem) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P1_Verify_AssociateSolidColorsToFabrics:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P1 color module from TC05 to TC11");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + PDS_URL);
			addSrceenShot("login successful", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addSrceenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);
			
//			String materialType = "Fabric";
			materialPage.selectMaterialType(materialType, test);
			System.out.println("Fabric Record Type Was choosen");
			test.log(Status.INFO, "Fabric Record Type Was choosen: " + materialType);
			addSrceenShot("Fabric Record Type Was choosen", test, Capture);
			WaitforPage(4000);

//			String materialName = "FA771032 Knits_demo_Material_AM_01";
			materialPage.chooseMaterial(materialName);
			System.out.println("Searched for the Material: " + materialName);
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addSrceenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);
			
			materialPage.clickOnMaterial(materialName);
			System.out.println("Ciicked On material: "+materialName);
			test.log(Status.INFO, "Ciicked On material: " + materialName);
			addSrceenShot("Ciicked On material: ", test, Capture);

//			String supplierName = "ACCESSORIES BAGS & COSMETICS ";
			color_Page.selectSupplierFromDropDown(supplierName, test);
			System.out.println("Clicked on supplier From Drop Down");
			test.log(Status.INFO, "Clicked on supplier From Drop Down: " + supplierName);
			addSrceenShot("Clicked on Source From Drop Down", test, Capture);

			color_Page.selectColorsTab();
			System.out.println("Selected Color tab");
			test.log(Status.INFO, "Selected Color tab");
			addSrceenShot("Selected Color tab", test, Capture);
			WaitforPage(4000);

//			String colorType = "solid colors";
//			String colorItem = "104 DRESS BLUES";
			color_Page.addMultipleColors(colorType, colorItem, test);
			System.out.println("Added desired solidcolor to fabric record: " + colorItem);
			test.log(Status.INFO, "Added desired solidcolor to fabric record: " + colorItem);
			addSrceenShot("Added multiple colors", test, Capture);
			WaitforPage(4000);

			// Click on Details tab
			color_Page.selectDetailsTab();
			System.out.println("Selected Details tab");
			test.log(Status.INFO, "Selected Details tab");
			addSrceenShot("Selected Details tab", test, Capture);
			WaitforPage(4000);

			color_Page.validateColorInDropdown(colorItem, test);
			System.out.println("Color is visible in material/supplier record");
			test.log(Status.PASS, "Validation: Color is visible in material/supplier record");
			addSrceenShot("Color is visible in material/supplier record", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);

		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness: " + e);
			test.log(Status.FAIL, "Test case failed due to application slowness");
			addSrceenShot("Test case failed due to application slowness", test, Capture);
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
