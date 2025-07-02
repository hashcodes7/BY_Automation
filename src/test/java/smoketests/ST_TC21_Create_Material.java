package smoketests;

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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class ST_TC21_Create_Material extends WMS_TestBase {

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
			LaunchSpecific_URL(CurrentURL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC307_P0_Fabric_SubType_Material_Creation_Validation");
		}
	}

	@Test(priority = 0, dataProvider = "materialCreationData", dataProviderClass = DataProviders.class)
	public void ST_TC21_Create_Material_(String TestType, String typeOfFabric, String fabricType,
			String seasonFirstIntroduced, String fabricDescription, String uom, Map<String, String> fabricContents)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::ST_TC21_Create_Material_:::");
		}
		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers E2E module 307");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully " + CurrentURL);
			addScreenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
//			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu());
			mainMenuPage.LibraryMenu("Material");
			test.log(Status.INFO, "In libraries Color/Look menu clicked");
			addScreenShot("In libraries Color/Look menu clicked", test, Capture);
			mainMenuPage.libraryMaterialMenu("Libraries", "Material");
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addScreenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

			materialPage.createNewMaterial();
			System.out.println("Clicked on Create New Material");
			test.log(Status.INFO, "Clicked on Create New Material");
			addScreenShot("Clicked on Create New Material", test, Capture);
			WaitforPage(4000);

//			String typeOfFabric = "Knits";
			materialPage.chooseFabricType(typeOfFabric);
			System.out.println("Fabric type was choosen");
			test.log(Status.INFO, "Fabric type was choosen: " + typeOfFabric);
			addScreenShot("Fabric type was choosen", test, Capture);
			WaitforPage(4000);

//			String fabricType = "Double Knit";
			materialPage.enterFabricType(fabricType);
			System.out.println("Entered Fabric Type: " + fabricType);
			test.log(Status.INFO, "Entered Fabric Type: " + fabricType);
			addScreenShot("Entered Fabric Type", test, Capture);
			WaitforPage(4000);

//			String seasonFirstIntroduced = "2026 Fall";
			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
			addScreenShot("Entered Season First Introduced", test, Capture);
			WaitforPage(4000);

//			String fabricDescription = "Knits_demo_Material_Aug09th_01";
			materialPage.enterFabricDescription(fabricDescription);
			System.out.println("Entered Fabric Description: " + fabricDescription);
			test.log(Status.INFO, "Entered Fabric Description: " + fabricDescription);
			addScreenShot("Entered Fabric Description", test, Capture);
			WaitforPage(4000);

//			String uom = "centimeter";
			materialPage.enterUOM(uom);
			System.out.println("Entered UOM: " + uom);
			test.log(Status.INFO, "Entered UOM: " + uom);
			addScreenShot("Entered UOM", test, Capture);
			WaitforPage(4000);
			
			materialPage.setFabricContent(fabricContents, test);
			test.log(Status.INFO, "Fabric Contents: " + fabricContents.toString());
			addScreenShot("Fabric Contents", test, Capture);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addScreenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify The new material is created
			boolean isMaterial_Created = materialPage.isMaterialCreated(fabricDescription, test);
			if (isMaterial_Created) {
				System.out.println("Material was created successfully. : FA773301");
				test.log(Status.PASS, "Material was created successfully: " + fabricDescription);
				addScreenShot("Material was created successfully.", test, Capture);
			} else {
				System.out.println("Failed to create new material.");
				test.log(Status.FAIL, "Failed to create new material.");
				addScreenShot("Failed to create new material.", test, Capture);
			}
			WaitforPage(4000);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);

		} catch (

		Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
			test.log(Status.FAIL, "Test case failed due, check system reports");
		throw e;
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}