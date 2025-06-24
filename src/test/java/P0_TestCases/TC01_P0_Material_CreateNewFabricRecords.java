package P0_TestCases;

import static org.testng.Assert.assertNotNull;

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

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC01_P0_Material_CreateNewFabricRecords extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

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
			setReport("TC01_P0_Material_Fabric Records Creation Validation");
		}
	}

	@Test(priority = 0, dataProvider = "fabricRecordsData", dataProviderClass = DataProviders.class)
	public void P0_TC_01_Material_Create_New_Fabric_Records(String TestType, String typeOfFabric, String fabricType,
			String seasonFirstIntroduced, String fabricDescription, String uom, Map<String, String> fabricContents)
			throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P0_Material_Fabric Records Creation Validation:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers material module from 134 to 137");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addSrceenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

			materialPage.createNewMaterial();
			System.out.println("Clicked on Create New Material");
			test.log(Status.INFO, "Clicked on Create New Material");
			addSrceenShot("Clicked on Create New Material", test, Capture);
			WaitforPage(4000);

			materialPage.chooseFabricType(typeOfFabric);
			System.out.println("Fabric type was choosen");
			test.log(Status.INFO, "Fabric type was choosen: " + typeOfFabric);
			addSrceenShot("Fabric type was choosen", test, Capture);
			WaitforPage(4000);

			materialPage.enterFabricType(fabricType);
			System.out.println("Entered Fabric Type: " + fabricType);
			test.log(Status.INFO, "Entered Fabric Type: " + fabricType);
			addSrceenShot("Entered Fabric Type", test, Capture);
			WaitforPage(4000);

			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
			addSrceenShot("Entered Season First Introduced", test, Capture);
			WaitforPage(4000);

			materialPage.enterFabricDescription(fabricDescription);
			System.out.println("Entered Fabric Description: " + fabricDescription);
			test.log(Status.INFO, "Entered Fabric Description: " + fabricDescription);
			addSrceenShot("Entered Fabric Description", test, Capture);
			WaitforPage(4000);

			materialPage.enterUOM(uom);
			System.out.println("Entered UOM: " + uom);
			test.log(Status.INFO, "Entered UOM: " + uom);
			addSrceenShot("Entered UOM", test, Capture);
			WaitforPage(4000);

			materialPage.setFabricContent(fabricContents, test);
			test.log(Status.INFO, "Fabric Contents: " + fabricContents.toString());
			addSrceenShot("Fabric Contents", test, Capture);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify the material code and Raymark fiber code
			String materialCode = materialPage.getMaterialCode(test);
			String raymarkFiberCode = materialPage.getRaymarkFiberCode(test);

			// Log the material creation success message
			String successMessage = "Material created successfully with attributes: Material Code - " + materialCode
					+ ", Raymark Fiber Code - " + raymarkFiberCode;
			System.out.println(successMessage);
			test.log(Status.PASS, successMessage);
			addSrceenShot("Material Created Successfully", test, Capture);

			// Add assertions to verify the codes and log the results
			try {
				assertNotNull(materialCode, "Material Code should not be null");
				test.log(Status.PASS, "Material Code is not null: " + materialCode);
			} catch (AssertionError e) {
				test.log(Status.FAIL, "Material Code is null");
				throw e;
			}

			try {
				assertNotNull(raymarkFiberCode, "Raymark Fiber Code should not be null");
				test.log(Status.PASS, "Raymark Fiber Code is not null: " + raymarkFiberCode);
			} catch (AssertionError e) {

			}
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Test case failed due to exception: " + e.getMessage());
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}