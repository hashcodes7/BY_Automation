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
import org.testng.Assert;
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
public class TC02_P0_Material_SetFabricContentAndVerifySorting extends WMS_TestBase {

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
			setReport("TC02_P0_Material_Fabric Content Selection and Sorting Verification");
		}
	}

	@Test(priority = 0, dataProvider = "fabricContentData", dataProviderClass = DataProviders.class)
	public void P0_TC_02_Material_Set_fabric_content_from_Branded_content_and_sorting_the_values_selected(
			String TestType, String typeOfFabric, String fabricType, String seasonFirstIntroduced,
			String fabricDescription, String uom, Map<String, String> fabricContents)
			throws Exception {
		try {
			if (true) {
				if (CloseBrowser) {
					test = extent
							.createTest(":::TC02_P0_Material_Fabric Content Selection and Sorting Verification:::");
				}

				CloseBrowser = false;

				// ...............................browser launched time starts

				long startTime = System.nanoTime();

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addScreenShot("Browser Launched successfully", test, Capture);

				test.log(Status.INFO, "This test case covers material module from 138 to 140");

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);
				addScreenShot("login to flex PLM application successfully", test, Capture);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addScreenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
				addScreenShot("Clicked on Main menu of Libraries", test, Capture);
				test.log(Status.INFO, "Clicked on Material");
				addScreenShot("Clicked on Material", test, Capture);
				WaitforPage(4000);

				materialPage.createNewMaterial();
				System.out.println("Clicked on Create New Material");
				test.log(Status.INFO, "Clicked on Create New Material");
				addScreenShot("Clicked on Create New Material", test, Capture);
				WaitforPage(4000);

				materialPage.chooseFabricType(typeOfFabric);
				System.out.println("Fabric type was choosen");
				test.log(Status.INFO, "Fabric type was choosen: " + typeOfFabric);
				addScreenShot("Fabric type was choosen", test, Capture);
				WaitforPage(4000);

				materialPage.enterFabricType(fabricType);
				System.out.println("Entered Fabric Type: " + fabricType);
				test.log(Status.INFO, "Entered Fabric Type: " + fabricType);
				addScreenShot("Entered Fabric Type", test, Capture);
				WaitforPage(4000);

				materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
				System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
				test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
				addScreenShot("Entered Season First Introduced", test, Capture);
				WaitforPage(4000);

				materialPage.enterFabricDescription(fabricDescription);
				System.out.println("Entered Fabric Description: " + fabricDescription);
				test.log(Status.INFO, "Entered Fabric Description: " + fabricDescription);
				addScreenShot("Entered Fabric Description", test, Capture);
				WaitforPage(4000);

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

				// Verify generic content values derived from branded content
				Map<String, Double> brandedContent = materialPage.getBrandedContent(test);
				Map<String, Double> genericContent = materialPage.getGenericContent();

				Map<String, Double> expectedGenericContent = new HashMap<>();
				for (Map.Entry<String, Double> entry : brandedContent.entrySet()) {
					String brandType = entry.getKey().split(" ")[0]; // Extract generic type from branded type
					expectedGenericContent.put(brandType,
							expectedGenericContent.getOrDefault(brandType, 0.0) + entry.getValue());
				}

				boolean isDerivedCorrectly = true;
				for (Map.Entry<String, Double> entry : genericContent.entrySet()) {
					String genericType = entry.getKey();
					double genericPercent = entry.getValue();
					if (!expectedGenericContent.containsKey(genericType)
							|| Math.abs(expectedGenericContent.get(genericType) - genericPercent) >= 0.1) {
						isDerivedCorrectly = false;
						test.log(Status.FAIL, "Generic content value for " + genericType
								+ " is not correctly derived from branded content.");
						System.out.println("Generic content value for " + genericType
								+ " is not correctly derived from branded content.");
					} else {
						test.log(Status.PASS, "Generic content value for " + genericType
								+ " is correctly derived from branded content.");
						System.out.println("Generic content value for " + genericType
								+ " is correctly derived from branded content.");
					}
				}

				Assert.assertTrue(isDerivedCorrectly,
						"Generic content values are not correctly derived from branded content.");
				test.log(Status.PASS, "Generic content values '" + genericContent
						+ "' are correctly derived from branded content " + brandedContent);

				genericContent = materialPage.getGenericContent();
				materialPage.verifySortedGenericContent(genericContent, test);
				test.log(Status.PASS,
						"Generic content values which are derived chosen are sorted out.." + genericContent);

			}

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