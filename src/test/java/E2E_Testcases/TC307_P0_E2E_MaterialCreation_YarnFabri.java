package E2E_Testcases;

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
public class TC307_P0_E2E_MaterialCreation_YarnFabri extends WMS_TestBase {

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
			LaunchSpecific_URL("https://wcadmin:wcadmindev12@flexplmdev3.levi.com/Windchill/rfa/jsp/main/Main.jsp");
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
	public void P0_TC06_E2E_MaterialCreation_YarnFabri(String TestType, String typeOfFabric, String fabricType,
			String seasonFirstIntroduced, String fabricDescription, String uom, Map<String, String> fabricContents)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC307_P0_E2E_Fabric_SubType_Material_Creation_Validation:::");
		}
		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers E2E module 307");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			System.out.println("logout successful");
			test.log(Status.INFO, "logout successful");

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_Season.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);

			materialPage.selectMaterial(MainMenuEnum.LIBRARIES_MATERIAL.menu());
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addSrceenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

			materialPage.createNewMaterial();
			System.out.println("Clicked on Create New Material");
			test.log(Status.INFO, "Clicked on Create New Material");
			addSrceenShot("Clicked on Create New Material", test, Capture);
			WaitforPage(4000);

//			String typeOfFabric = "Knits";
			materialPage.chooseFabricType(typeOfFabric);
			System.out.println("Fabric type was choosen");
			test.log(Status.INFO, "Fabric type was choosen: " + typeOfFabric);
			addSrceenShot("Fabric type was choosen", test, Capture);
			WaitforPage(4000);

//			String fabricType = "Double Knit";
			materialPage.enterFabricType(fabricType);
			System.out.println("Entered Fabric Type: " + fabricType);
			test.log(Status.INFO, "Entered Fabric Type: " + fabricType);
			addSrceenShot("Entered Fabric Type", test, Capture);
			WaitforPage(4000);

//			String seasonFirstIntroduced = "2026 Fall";
			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
			addSrceenShot("Entered Season First Introduced", test, Capture);
			WaitforPage(4000);

//			String fabricDescription = "Knits_demo_Material_Aug09th_01";
			materialPage.enterFabricDescription(fabricDescription);
			System.out.println("Entered Fabric Description: " + fabricDescription);
			test.log(Status.INFO, "Entered Fabric Description: " + fabricDescription);
			addSrceenShot("Entered Fabric Description", test, Capture);
			WaitforPage(4000);

//			String uom = "centimeter";
			materialPage.enterUOM(uom);
			System.out.println("Entered UOM: " + uom);
			test.log(Status.INFO, "Entered UOM: " + uom);
			addSrceenShot("Entered UOM", test, Capture);
			WaitforPage(4000);

//			// fabricContentType and their Percentages
//			Map<String, String> fabricContents = new HashMap<>();
//			fabricContents.put("Cashmere", "23.00");
//			fabricContents.put("Elastane", "42.00");
//			fabricContents.put("Polyester (Aerolite)", "5.00");
//			fabricContents.put("Polyester (Coolmax All Season)", "10.00");
//			fabricContents.put("Cotton (Generic)", "20.00");
			materialPage.setFabricContent(fabricContents, test);
			test.log(Status.INFO, "Fabric Contents: " + fabricContents.toString());
			addSrceenShot("Fabric Contents", test, Capture);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify The new material is created
			boolean isMaterial_Created = materialPage.isMaterialCreated(fabricDescription, test);
			if (isMaterial_Created) {
				System.out.println("Material was created successfully.");
				test.log(Status.PASS, "Material was created successfully: " + fabricDescription);
				addSrceenShot("Material was created successfully.", test, Capture);
			} else {
				System.out.println("Failed to create new material.");
				test.log(Status.FAIL, "Failed to create new material.");
				addSrceenShot("Failed to create new material.", test, Capture);
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

		} catch (

		Exception e) {
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