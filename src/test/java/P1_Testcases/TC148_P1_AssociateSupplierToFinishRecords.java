package P1_Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC148_P1_AssociateSupplierToFinishRecords extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;

	boolean Capture = true;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			setReport("TC148_P1_AssociateSupplierToFinishRecords verification");
		}
	}

	@Test(priority = 0, dataProvider = "associateSupplier_FinishRecords_Data", dataProviderClass = DataProviders.class)
	public void P1_TC147_AssociateSupplierToFinishRecords(String TestType, String materialType, String materialName, String supplier)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC148_P1_AssociateSupplierToFinishRecords verification:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 material modulel from TC148 to TC153");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + PDS_URL);
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

//			String supplier = "123test    SUPPLIER";
			materialPage.addSupplier(supplier, test);
			System.out.println("Searched and selected supplier");
			test.log(Status.INFO, "Searched and selected supplier:: " + supplier);
			addSrceenShot("Searched and selected supplier:", test, Capture);
			WaitforPage(5000);

			boolean isSupplierInDropdown = materialPage.verifySupplierInDropdown(supplier, test);
			if (isSupplierInDropdown) {
				System.out.println("Supplier appears in the dropdown menu for the material.");
				test.log(Status.PASS, "Validation: Supplier appears in the dropdown menu for the material.");
				addSrceenShot("Supplier appears in the dropdown menu for the material", test, Capture);
			} else {
				System.out.println("Supplier does not appear in the dropdown menu for the material.");
				test.log(Status.FAIL, "Supplier does not appear in the dropdown menu for the material.");
				addSrceenShot("Supplier does not appear in the dropdown menu for the material", test, Capture);
			}
			
			WaitforPage(4000);
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
