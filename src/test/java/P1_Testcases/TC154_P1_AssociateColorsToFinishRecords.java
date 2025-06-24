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


import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC154_P1_AssociateColorsToFinishRecords extends WMS_TestBase {
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
			setReport("TC154_P1_AssociateColorsToFinishRecords verification");
		}
	}

	@Test(priority = 0, dataProvider = "associateColorsData", dataProviderClass = DataProviders.class)
	public void P1_TC154_AssociateColorsToFinishRecords(String TestType, String materialType, String materialName, String supplierName,
			String colorItem) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC154_P1_AssociateColorsToFinishRecords verification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Material module from TC154 to TC160");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

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

//			String materialType = "Look Finish Recipe";
			materialPage.selectMaterialType(materialType, test);
			System.out.println("Finish Record Type Was choosen");
			test.log(Status.INFO, "Finish Record Type Was choosen: " + materialType);
			addSrceenShot("Finish Record Type Was choosen", test, Capture);
			WaitforPage(4000);

//			String materialName = "236207 Demo_FinsihType_Material_01";
			materialPage.searchMaterial(materialName, test);
			System.out.println("Searched for the Material");
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addSrceenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);
			
			materialPage.clickOnMaterial(materialName);
			System.out.println("Ciicked On material: "+materialName);
			test.log(Status.INFO, "Ciicked On material: " + materialName);
			addSrceenShot("Ciicked On material: ", test, Capture);

//			String supplierName = "123test    SUPPLIER";
			color_Page.selectSupplierFromDropDown(supplierName, test);
			System.out.println("Clicked on supplier From Drop Down");
			test.log(Status.INFO, "Clicked on supplier From Drop Down: " + supplierName);
			addSrceenShot("Clicked on Source From Drop Down", test, Capture);

			color_Page.selectColorsTab();
			System.out.println("Selected Color tab");
			test.log(Status.INFO, "Selected Color tab");
			addSrceenShot("Selected Color tab", test, Capture);
			WaitforPage(4000);

//			String colorItem = "04U DA077E SolidC123";
			color_Page.addColorToMaterialRecord(colorItem, test);
			System.out.println("Added desired solidcolor to finish record: " + colorItem);
			test.log(Status.INFO, "Added desired solidcolor to finish record: "+colorItem);
			addSrceenShot("Added desired solidcolor to finish record", test, Capture);
			WaitforPage(4000);

			// Click on Details tab
			color_Page.selectDetailsTab();
			System.out.println("Selected Details tab");
			test.log(Status.INFO, "Selected Details tab");
			addSrceenShot("Selected Details tab", test, Capture);
			WaitforPage(4000);

			color_Page.validateColorInDropdown(colorItem, test);
			System.out.println("Color found in Material/Supplier screen");
			test.log(Status.PASS, "Validation: Color found in Material/Supplier screen: " + colorItem);
			addSrceenShot("Color found in Material/Supplier screen", test, Capture);

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
