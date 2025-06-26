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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC143_P1_UpdateMaterialSupplierAttributes extends WMS_TestBase {

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
			setReport("TC143_P1_UpdateMaterialSupplierAttributes verification");
		}
	}

	@Test(priority = 0, dataProvider = "materialSupplierAttributesData", dataProviderClass = DataProviders.class)
	public void P1_TC143_UpdateMaterialSupplierAttributes(String TestType, String materialType, String materialName,
			String supplierName, String materialCountryOfOrigin, String fabricCuttableWidth,
			String fabricCuttableWidthUOM, String supplierArticleNo, String uomConversionFactor,
			String fabricPurchaseWeight, String fabricPurchaseWeightUOM, String fabricMill) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC143_P1_UpdateMaterialSupplierAttributes verification:::");
		}

		CloseBrowser = false;

		try {

			test.log(Status.INFO, "This test case covers P1 material module from TC143 to TC147");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL " + PDS_URL);
			addScreenShot("Login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left panel");
			test.log(Status.INFO, "Clicked on open Left panel");
			addScreenShot("Clicked on open Left panel", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			WaitforPage(4000);

//			String materialType = "Finish Recipe";
			materialPage.selectMaterialType(materialType, test);
			System.out.println("Fabric Record Type Was choosen");
			test.log(Status.INFO, "Fabric Record Type Was choosen: " + materialType);
			addScreenShot("Fabric Record Type Was choosen", test, Capture);
			WaitforPage(4000);

//			String materialName = "236190 Demo_material_Aug06";
			// *****Finish Recipe*****//236190 Demo_material_Aug06
			// *****Yarn*****//FA190632 CTS PROD N1_yarn type
			// ****Fabric****//FA771023 Test_Fabric_0608
			materialPage.searchMaterial(materialName, test);
			System.out.println("Searched for the Material");
			test.log(Status.INFO, "Searched for the Material: " + materialName);
			addScreenShot("Searched for the Material", test, Capture);
			WaitforPage(4000);
			
			materialPage.clickOnMaterial(materialName);
			System.out.println("Ciicked On material: "+materialName);
			test.log(Status.INFO, "Ciicked On material: " + materialName);
			addScreenShot("Ciicked On material: ", test, Capture);

//			String supplierName = "3M INDUSTRIAL ADHESIVE & TAPES 603112 US";
			// ****Finish Recipe*****//AALFS UNO SA 3996 NI
			// ****Yarn*****//AALFS UNO SA 3996 NI
			// ****Fabric****//Dummy 000000
			color_Page.selectSupplierFromDropDown(supplierName, test);
			System.out.println("Clicked on supplier From Drop Down");
			test.log(Status.INFO, "Clicked on supplier From Drop Down: " + supplierName);
			addScreenShot("Clicked on Source From Drop Down", test, Capture);

			String materialPageUOM = materialPage.extractUOMFromMaterialPage();
			System.out.println("Extracted UOM From MaterialPage: " + materialPageUOM);
			test.log(Status.INFO, "Extracted UOM From MaterialPage: " + materialPageUOM);
			addScreenShot("Extracted UOM From MaterialPage", test, Capture);

//			String fabricMill = "236190 Demo_material_Aug06";
			materialPage.selectFabricMillForFinishRecipeMaterial(fabricMill, test);
			addScreenShot("Selected Fabric Mill", test, Capture);

			materialPage.updateMaterialSupplier(test);
			System.out.println("Clicked on Update Material/Supplier");
			test.log(Status.INFO, "Clicked on Update Material/Supplier");
			addScreenShot("Clicked on Update Material/Supplier", test, Capture);
			WaitforPage(4000);

//			String materialCountryOfOrigin = "Argentina";
//			String fabricCuttableWidth = "2";
//			String fabricCuttableWidthUOM = "inches";
//			String supplierArticleNo = "12345";
//			String uomConversionFactor = "1";
//			String fabricPurchaseWeight = "2";
//			String fabricPurchaseWeightUOM = "each";

			materialPage.enterMaterialSupplierAttributes(materialCountryOfOrigin, fabricCuttableWidth,
					fabricCuttableWidthUOM, supplierArticleNo, uomConversionFactor, fabricPurchaseWeight,
					fabricPurchaseWeightUOM, materialPageUOM, test);
			System.out.println("Entered and edited data for all material/supplier level attributes");
			test.log(Status.PASS, "Entered and edited data for all material/supplier level attributes");
			addScreenShot("Entered and edited data for all material/supplier level attributes", test, Capture);
			WaitforPage(4000);

			materialPage.saveMaterial();
			System.out.println("Edited Data Is Saved Successfully");
			test.log(Status.INFO, "Edited Data Is Saved Successfully");
			addScreenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left panel");
			test.log(Status.INFO, "Clicked on close Left panel");
			addScreenShot("Clicked on close Left panel", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);

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
