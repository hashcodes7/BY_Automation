package CreateMultiple_TestData;

import static org.testng.Assert.assertNotNull;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BusinessObjectPage;
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

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_CreateMultipleFabricTypeMaterial_VerifyStagingRowID extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	BusinessObjectPage businessObjectPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;
	private String pds_URL;



	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a PDS user before executing this test case
	 */

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			pds_URL = PDS_URL;
			LaunchSpecific_URL(pds_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			businessObjectPage = new BusinessObjectPage(driver);
			setReport("TC_P3_CreateMultipleFabricTypeMaterial_VerifyStagingRowID");
		}
	}

	@Test(priority = 0, dataProvider = "Multiple_StagingID_CreateFabricTypeMaterial", dataProviderClass = DataProviders.class)
	public void P3_TC12_Integration_Staging_CreateMaterial(String[][] testData)
			throws Exception {

		for (int i = 0; i < testData.length; i++) {
	        String[] data = testData[i];
	        String TestType = data[0];
	        String typeOfFabric = data[1];
	        String fabricType = data[2];
	        String seasonFirstIntroduced = data[3];
	        String fabricDescription = data[4];
	        String uom = data[5];
	        String businessObjectType = data[6];
	        String actionType = data[7];
	        String messageTableValue = data[8];
	        String hierarchyValue = data[9];
	        Map<String, String> fabricContents = new HashMap<>();
	        for (int j = 10; j < data.length; j += 2) {
	            fabricContents.put(data[j], data[j + 1]);
	        }

			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_CreateMultipleFabricTypeMaterial_VerifyStagingRowID:::");
			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();
			try {

				test.log(Status.INFO,
						"This test case covers TestData_Scripts(P3) DV Integration (TC_Integration Staging  _012_Create Material)");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addSrceenShot("Browser Launched successfully", test, Capture);

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully" + pds_URL);
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

				// Capture the current time in GMT
				LocalDateTime saveTime = LocalDateTime.now(ZoneId.of("GMT"));
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
				System.out.println(timeFormatter);

				String formattedDate = saveTime.format(dateFormatter);
				String formattedTime = saveTime.format(timeFormatter);
				String hourFrom = String.format("%02d", saveTime.getHour());
				String hourTo = String.format("%02d", saveTime.plusHours(1).getHour());

				// Log the exact GMT time and date
				test.log(Status.INFO,
						"Save button clicked at GMT time: " + formattedTime + " on date: " + formattedDate);
				System.out.println("Save button clicked at GMT time: " + formattedTime + " on date: " + formattedDate);
				addSrceenShot("Save button clicked", test, Capture);

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

				// Verify the material code and Raymark fiber code
				String materialCode = materialPage.getMaterialCode(test);
				String raymarkFiberCode = materialPage.getRaymarkFiberCode(test);

				// Log the material creation success message
				String successMessage = "Material created successfully with attributes: Material Code - " + materialCode
						+ ", Raymark Fiber Code - " + raymarkFiberCode;
				System.out.println(successMessage);
				test.log(Status.PASS, successMessage);
				addSrceenShot("Material Created Successfully", test, Capture);
				WaitforPage(4000);

				driver.manage().deleteAllCookies();
				driver.navigate().refresh();

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addSrceenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_BUSSINESS.menu(), true);
				addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
				System.out.println("Clicked on Business Object");
				test.log(Status.INFO, "Clicked on Business Object");
				addSrceenShot("Clicked on Business Object", test, Capture);
				WaitforPage(4000);

				businessObjectPage.chooseBusinessObjectType(businessObjectType);
				System.out.println("Business object type chosen: " + businessObjectType);
				test.log(Status.INFO, "Business object type chosen: " + businessObjectType);
				addSrceenShot("Business object type chosen", test, Capture);
				WaitforPage(4000);

				businessObjectPage.chooseActionType(actionType);
				System.out.println("Action type chosen: " + actionType);
				test.log(Status.INFO, "Action type chosen: " + actionType);
				addSrceenShot("Action type chosen", test, Capture);
				WaitforPage(4000);

				businessObjectPage.enterEventHourFrom(hourFrom);
				System.out.println("Event Hour From: " + hourFrom);
				test.log(Status.INFO, "Event Hour From: " + hourFrom);
				addSrceenShot("Event Hour From", test, Capture);
				WaitforPage(4000);

				businessObjectPage.enterEventHourTo(hourTo);
				System.out.println("Event Hour TO: " + hourTo);
				test.log(Status.INFO, "Event Hour TO: " + hourTo);
				addSrceenShot("Event Hour TO", test, Capture);
				WaitforPage(4000);

				businessObjectPage.enterCreatedDate(formattedDate);
				System.out.println("Entered Created Date: " + formattedDate);
				test.log(Status.INFO, "Entered Created Date: " + formattedDate);
				addSrceenShot("Entered Created Date", test, Capture);
				WaitforPage(4000);

//			String messageTableValue = "*LSCOMaterial*";
				businessObjectPage.enterMessageTable(messageTableValue);
				System.out.println("Entered Message Table: " + messageTableValue);
				test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
				addSrceenShot("Entered Created Date", test, Capture);
				WaitforPage(4000);

//			String hierarchyValue = "*LSCO\\Fabric\\Knits*";
				businessObjectPage.enterHierarchy(hierarchyValue);
				System.out.println("Entered Hierarchy: " + hierarchyValue);
				test.log(Status.INFO, "Entered Hierarchy: " + hierarchyValue);
				addSrceenShot("Entered Hierarchy", test, Capture);
				WaitforPage(4000);

				businessObjectPage.clickSearch();
				System.out.println("Clicked on Search");
				test.log(Status.INFO, "Clicked on Search");
				addSrceenShot("Clicked on Search", test, Capture);
				WaitforPage(4000);

				// Verify the staging row ID
				businessObjectPage.verifyStagingRowId(test);
				addSrceenShot("Staging Row ID is updated in LSCOTransactionTable", test, Capture);

				if (i == testData.length - 1) {
					// Last iteration, perform logout
					dashboardPage.closeLeftPanel();
					System.out.println("Clicked on close Left plane");
					test.log(Status.INFO, "Clicked on close Left plane");
					addSrceenShot("Clicked on close Left plane", test, Capture);

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addSrceenShot("Logout successful", test, Capture);
				} else {
					// Delete all cookies and Refresh the browser
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();
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