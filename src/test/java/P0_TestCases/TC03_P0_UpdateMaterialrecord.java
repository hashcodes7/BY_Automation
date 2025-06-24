package P0_TestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC03_P0_UpdateMaterialrecord extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
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
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC03_P0_Material Record Update Verification");
		}
	}

	@Test(priority = 0, dataProvider = "updateMaterialData", dataProviderClass = DataProviders.class)
	public void P0_TC_03_Material_Update_Material_record(String TestType, String materialName, String fabricType,
			String seasonFirstIntroduced, String fabricDescription, String uom, Map<String, String> fabricContents)
			throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P0_Material Record Update Verification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers material module from 141 to 144");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
			addSrceenShot("login successful", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			System.out.println("logout successful");
			test.log(Status.INFO, "logout successful");

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material under Libraries");
			WaitforPage(4000);

			materialPage.chooseMaterial(materialName);
			System.out.println("Material was choosen " + materialName);
			test.log(Status.INFO, "Material was choosen: " + materialName);
			addSrceenShot("Material was choosen", test, Capture);
			WaitforPage(4000);

			materialPage.clickOnEditMaterial();
			System.out.println("clicked On Edit Material");
			test.log(Status.INFO, "clicked On Edit Material");
			addSrceenShot("clicked On Edit Material", test, Capture);
			WaitforPage(4000);

			materialPage.enterFabricType(fabricType);
			System.out.println("Updated Fabric Type: " + fabricType);
			test.log(Status.INFO, "Updated Fabric Type: " + fabricType);
			addSrceenShot("Updated Fabric Type", test, Capture);
			WaitforPage(4000);

			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Updated Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Updated Season First Introduced: " + seasonFirstIntroduced);
			addSrceenShot("Updated Season First Introduced", test, Capture);
			WaitforPage(4000);

			materialPage.enterFabricDescription(fabricDescription);
			System.out.println("Updated Fabric Description: " + fabricDescription);
			test.log(Status.INFO, "Updated Fabric Description: " + fabricDescription);
			addSrceenShot("Updated Fabric Description", test, Capture);
			WaitforPage(4000);

			materialPage.enterUOM(uom);
			System.out.println("Updated UOM: " + uom);
			test.log(Status.INFO, "Updated UOM: " + uom);
			addSrceenShot("Updated UOM", test, Capture);
			WaitforPage(4000);

			materialPage.removeChosenContents();
			System.out.println("Chosen Contents removed ");
			test.log(Status.INFO, "Chosen Contents removed");
			addSrceenShot("Chosen Contents removed", test, Capture);
			WaitforPage(4000);

			materialPage.setFabricContent(fabricContents, test);
			test.log(Status.INFO, "Updated Fabric Contents: " + fabricContents.toString());
			addSrceenShot("Updated Fabric Contents", test, Capture);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			String materialCode = materialPage.getMaterialCode(test);
			System.out.println("Captured Material Code: " + materialCode);
			test.log(Status.INFO, "Captured Material Code: " + materialCode);
			addSrceenShot("Captured Material Code", test, Capture);

			// Verification step for Material Code
			if (materialCode != null && !materialCode.isEmpty()) {
				System.out.println("Material updated successfully");
				test.log(Status.PASS, "Material updated successfully");
				addSrceenShot("Material updated successfully", test, Capture);

				// verification step
				boolean isMaterialUpdated = materialPage.verifyMaterialUpdate(fabricType, seasonFirstIntroduced,
						fabricDescription, uom, test);
				if (isMaterialUpdated) {
					System.out.println("Material attributes updated successfully");
					test.log(Status.PASS, "Material attributes updated successfully");
					addSrceenShot("Material attributes updated successfully", test, Capture);
				} else {
					System.out.println("Material attributes update failed.");
					test.log(Status.FAIL, "Material attributes update failed.");
					addSrceenShot("Material attributes update failed", test, Capture);
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

			} else {
				System.out.println("Material Updation failed.");
				test.log(Status.FAIL, "Material Updation failed.");
				addSrceenShot("Material Updation failed", test, Capture);
			}
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