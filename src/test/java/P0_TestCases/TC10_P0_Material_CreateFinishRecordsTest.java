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
public class TC10_P0_Material_CreateFinishRecordsTest extends WMS_TestBase {

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
			setReport("TC10_P0_CreateFinishRecordsTestReport");
		}
	}

	@Test(priority = 0, dataProvider = "finishRecordsData", dataProviderClass = DataProviders.class)
	public void P0_TC10_Material_CreateFinishRecordsTest(String TestType, String typeOfFinishRecipe,
			String finishRecipeDescription, String seasonFirstIntroduced, String uom)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC10_P0_CreateFinishRecordsTestReport:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers material module from 145 to 148");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addScreenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addScreenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);

			materialPage.createNewMaterial();
			System.out.println("Clicked on Create New Material");
			test.log(Status.INFO, "Clicked on Create New Material");
			addScreenShot("Clicked on Create New Material", test, Capture);
			WaitforPage(4000);

			materialPage.chooseFinishRecipeType(typeOfFinishRecipe);
			System.out.println("Fabric type was choosen");
			test.log(Status.INFO, "Fabric type was choosen: " + typeOfFinishRecipe);
			addScreenShot("Fabric type was choosen", test, Capture);
			WaitforPage(4000);

			materialPage.enterFinishRecipeDescription(finishRecipeDescription);
			System.out.println("Entered Finish Recipe Description: " + finishRecipeDescription);
			test.log(Status.INFO, "Entered Finish Recipe Description: " + finishRecipeDescription);
			addScreenShot("Entered Finish Recipe Description: ", test, Capture);
			WaitforPage(4000);

			materialPage.enterSeasonFirstIntroduced(seasonFirstIntroduced);
			System.out.println("Entered Season First Introduced: " + seasonFirstIntroduced);
			test.log(Status.INFO, "Entered Season First Introduced: " + seasonFirstIntroduced);
			addScreenShot("Entered Season First Introduced", test, Capture);
			WaitforPage(4000);

			materialPage.enterUOM(uom);
			System.out.println("Entered UOM: " + uom);
			test.log(Status.INFO, "Entered UOM: " + uom);
			addScreenShot("Entered UOM", test, Capture);
			WaitforPage(4000);

			materialPage.saveMaterial();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addScreenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify that the new finish record is created
			boolean isRecordCreated = materialPage.isFinishRecordCreated(finishRecipeDescription, test);
			if (isRecordCreated) {
				System.out.println("New finish record is created successfully.");
				test.log(Status.PASS, "New finish record is created successfully.");
				addScreenShot("New finish record is created successfully", test, Capture);
			} else {
				System.out.println("Failed to create new finish record.");
				test.log(Status.FAIL, "Failed to create new finish record.");
				addScreenShot("Failed to create new finish record", test, Capture);
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