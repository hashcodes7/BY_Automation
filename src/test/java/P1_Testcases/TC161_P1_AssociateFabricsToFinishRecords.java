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
public class TC161_P1_AssociateFabricsToFinishRecords extends WMS_TestBase {
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
			setReport("TC161_P1_AssociateFabricsToFinishRecords verification");
		}
	}

	@Test(priority = 0, dataProvider = "associateFabricsData", dataProviderClass = DataProviders.class)
	public void P1_TC161_AssociateFabricsToFinishRecords(String TestType, String materialType, String materialName, String fabric)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC161_P1_AssociateFabricsToFinishRecords verification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Material module from TC161 to TC166");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + PDS_URL);
			addScreenShot("login successful", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addScreenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

//			String materialType = "Look Finish Recipe";
			materialPage.selectMaterialType(materialType, test);
			System.out.println("Finish Record Type Was choosen");
			test.log(Status.INFO, "Finish Record Type Was choosen: " + materialType);
			addScreenShot("Finish Record Type Was choosen", test, Capture);
			WaitforPage(4000);

//			String materialName = "236207 Demo_FinsihType_Material_01";
			materialPage.searchMaterial(materialName, test);
			System.out.println("Searched for the Material");
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addScreenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);
			
			materialPage.clickOnMaterial(materialName);
			System.out.println("Ciicked On material: "+materialName);
			test.log(Status.INFO, "Ciicked On material: " + materialName);
			addScreenShot("Ciicked On material: ", test, Capture);

			materialPage.clickOnEditMaterial();
			System.out.println("clicked On Edit Material");
			test.log(Status.INFO, "clicked On Edit Material");
			addScreenShot("clicked On Edit Material", test, Capture);
			WaitforPage(4000);

//			String fabric = "234029 demo_Material_01";
			materialPage.selectFabric_Mill(fabric, test);
			test.log(Status.INFO, "Selected Fabric Mill: " + fabric);
			addScreenShot("Selected Fabric Mill", test, Capture);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addScreenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Validate that the fabric is added to the General Attributes section
			materialPage.validateFabricInGeneralAttributes(fabric, test);
			System.out.println("Fabric found in General Attributes section");
			addScreenShot("Fabric found in General Attributes section", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);

		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness: " + e);
			test.log(Status.FAIL, "Test case failed due to application slowness " + e);
			addScreenShot("Test case failed due to application slowness", test, Capture);
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
