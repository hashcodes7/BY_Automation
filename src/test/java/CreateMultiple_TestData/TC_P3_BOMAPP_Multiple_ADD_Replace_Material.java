package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BOM_Page;
import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CreateNewProductPage;

import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductDetailsPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;

import org.openqa.selenium.JavascriptExecutor;
import resources.DataProviders;

@Test(enabled = true, groups = { "P3_TC" })
public class TC_P3_BOMAPP_Multiple_ADD_Replace_Material extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	BOM_Page BOMPage;
	LineSheetPage lineSheetPage;
	Colorway_page Colorwaypage;
	LineSheet_Edit_Page LineSheetEditPage;
	Colorway_page colorWayPage;
	ProductDetailsPage productDetailsPage;

	boolean Capture = true;
	private String adimin_URL;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			adimin_URL = Administrator_URL;
			LaunchSpecific_URL(adimin_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			BOMPage = new BOM_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			colorWayPage = new Colorway_page(driver);
			productDetailsPage = new ProductDetailsPage(driver);

			setReport("TC_P3_BOMAPP_Multiple_ADD_Replace_Material");
		}
	}

	@Test(priority = 0, dataProvider = "Multiple_BOMAPP_ADD_Replace_Material", dataProviderClass = DataProviders.class)
	public void P3_TC35_36_BOMAPP_ADD_Replace_Material(String[][] testData) throws Exception {
		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
			String TestType = data[0];
			String username = data[1];
			String password = data[2];
			String season = data[3];
			String PC9Code = data[4];
			String materialType = data[5];
			String component = data[6];
			String componentLocation = data[7];
			String remarks = data[8];
			String quantity = data[9];
			String newMaterial = data[10];
			String replaceMaterial = data[11];
			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_BOMAPP_Multiple_ADD_Replace_Material:::");
			}
			CloseBrowser = false;
			// ...............................browser launched time starts
			long startTime = System.nanoTime();

			try {
				if (i == 0) {

					test.log(Status.INFO,
							"This test case covers TestData_Scripts(P3) BOM app (TC_35_Apply materials individually AND TC_36_Search and replace BOM details)");

					System.out.println("Browser Launched successfully");
					test.log(Status.INFO, "Browser Launched successfully");

					System.out.println("Login to flex PLM application successfully ");
					test.log(Status.INFO, "Login to flex PLM application successfully " + adimin_URL);
					addSrceenShot("Login successful", test, Capture);
					Thread.sleep(5000);

					dashboardPage.openLeftPanel();
					System.out.println("Clicked on open Left plane");
					test.log(Status.INFO, "Clicked on open Left plane");
					addSrceenShot("Clicked on open Left plane", test, Capture);

					BOMPage.navigateToBOMApp();
					test.log(Status.INFO, "Navigated to BOM App");
					addSrceenShot("Navigated to BOM App", test, Capture);

					BOMPage.login(username, password, test);
					addSrceenShot("Logged into BOM App", test, Capture);

				}

				// Select Season and Search for PC9 code
				BOMPage.selectSeason(season);
				test.log(Status.INFO, "Season selected: " + season);
				addSrceenShot("Season selected", test, Capture);

				// String PC9Code = "0WPOB-0001";
				BOMPage.searchForPC9(PC9Code, test);
				test.log(Status.INFO, "Searched for PC9: " + PC9Code);
				addSrceenShot("Searched for PC9", test, Capture);

				if (i == 0) {
					// Choose Material Type
					// String materialType = "Fabric";
					BOMPage.selectMaterialType(materialType, test);
					test.log(Status.INFO, "Material type selected: " + materialType);
					addSrceenShot("Material type selected", test, Capture);
				} else {

					BOMPage.select_MaterialType(materialType, test);
					test.log(Status.INFO, "Material type selected: " + materialType);
					addSrceenShot("Material type selected", test, Capture);
				}

				// Add Material Type Subsection
				BOMPage.addMaterialSubsection(test);
				test.log(Status.INFO, "Added  " + materialType + " subsection");
				addSrceenShot("Added " + materialType + " subsection", test, Capture);

				// Fill in Component Details
//			String component = "biasTape";
//			String componentLocation = "back";
//			String remarks = "Test";
//			String quantity = "0.01";

				BOMPage.fillComponentDetails(component, componentLocation, remarks, quantity, test);
				test.log(Status.INFO, "Filled component details");
				addSrceenShot("Filled component details", test, Capture);

				// Add Subsection
				BOMPage.clickAddSubsection(test);
				test.log(Status.INFO, "Clicked on Add Subsection");
				addSrceenShot("Clicked on Add Subsection", test, Capture);

				// Find Material by Name
//			String newMaterial = "FA118683";
				BOMPage.findMaterialByName(newMaterial, test);
				test.log(Status.INFO, "Searched for the new material: " + newMaterial);
				addSrceenShot("Searched for the new material", test, Capture);

				// Drag Material into Subsection
				BOMPage.dragMaterialIntoSubsection(newMaterial, test);
				test.log(Status.INFO, "Dragged material into subsection");
				test.log(Status.PASS, "New material was Added to the BOM successfully");
				addSrceenShot("material was Added successfully", test, Capture);

				// Find Material by Name
//			String replaceMaterial = "FA167434";
				BOMPage.findReplaceMaterialByName(replaceMaterial, test);
				test.log(Status.INFO, "Searched for the replace material: " + replaceMaterial);
				addSrceenShot("Searched for replace material", test, Capture);

				// Drag Material into Subsection
				BOMPage.replaceMaterialIntoDropZonelistItem(replaceMaterial, test);
				test.log(Status.INFO, "material was replaced to the BOM successfully");
				test.log(Status.PASS, "material was replaced to the BOM successfully");
				addSrceenShot("material was replaced to the BOM successfully", test, Capture);

				if (i == testData.length - 1) {
					// Last iteration, perform logout
					BOMPage.logout(test);
					test.log(Status.INFO, "Logged out of BOM App");
					addSrceenShot("Logged out of BOM App", test, Capture);

				}

			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
				test.log(Status.FAIL, "Test case failed due to application slowness");
				throw e;
			}
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}