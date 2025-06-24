package E2E_Testcases;

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


import resources.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC311_P0_E2E_LookFinishRecipe extends WMS_TestBase {

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
			setReport("TC311_P0_E2E_Look Finish Recipe Linkage Verification");
		}
	}

	@Test(priority = 0, dataProvider = "lookFinishRecipeData", dataProviderClass = DataProviders.class)
	public void P0_TC11_E2E_LookFinishRecipe(String TestType, String seasonalLook, String lookFinishRecipe)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC311_P0_E2E_Look Finish Recipe Linkage Verification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers E2E module 311 to 312");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addSrceenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR_LOOK.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Color/Look");
			test.log(Status.INFO, "Clicked on Color/Look");
			WaitforPage(4000);

//			String seasonalLook = "Levi's S1 2025 Male Accessories  BFF__DDRK_T1_";
			seasonPage.searchSeasonalLook(seasonalLook, test);
			System.out.println("Searched for the seasonal Look");
			test.log(Status.INFO, "Searched for the seasonal Look: " + seasonalLook);
			addSrceenShot("Searched for the seasonal Look", test, Capture);
			WaitforPage(4000);

			seasonPage.clickOnEditLookInfo();
			System.out.println("Clicked on Edit under 'Look Information'");
			test.log(Status.INFO, "Clicked on Edit under 'Look Information'");
			addSrceenShot("Clicked on Edit under 'Look Information'", test, Capture);
			WaitforPage(4000);

//			String lookFinishRecipe = "236189 demo_Material_Aug05th";
			seasonPage.selectFinishRecipe(lookFinishRecipe, test);
			System.out.println("Selected Look Finish Recipe: " + lookFinishRecipe);
			test.log(Status.INFO, "Selected Look Finish Recipe: " + lookFinishRecipe);
			addSrceenShot("Selected Look Finish Recipe", test, Capture);
			WaitforPage(4000);

			boolean isFabricAutoPopulated = seasonPage.isFabricAutoPopulated(lookFinishRecipe, test);
			if (isFabricAutoPopulated) {
				System.out.println("Fabric is auto-populated in the Look info MOA table.");
				test.log(Status.PASS, "Fabric is auto-populated in the Look info MOA table.");
				addSrceenShot("Fabric is auto-populated in the Look info MOA table", test, Capture);
			} else {
				System.out.println("Fabric is not auto-populated in the Look info MOA table.");
				test.log(Status.FAIL, "Fabric is not auto-populated in the Look info MOA table.");
				addSrceenShot("Fabric is not auto-populated in the Look info MOA table", test, Capture);
			}
			WaitforPage(4000);

			boolean isLookFinishRecipeLinked = seasonPage.verifyLookFinishRecipeLine(lookFinishRecipe, test);
			if (isLookFinishRecipeLinked) {
				System.out.println(
						"Look finish recipe is lined to the Look info table successfully: " + lookFinishRecipe);
				test.log(Status.PASS,
						"Look finish recipe is lined to the Look info table successfully: " + lookFinishRecipe);
				addSrceenShot("Look finish recipe is lined to the Look info table successfully", test, Capture);
			} else {
				System.out.println("Look finish recipe is not lined to the Look info table.");
				test.log(Status.FAIL, "Look finish recipe is not lined to the Look info table.");
				addSrceenShot("Look finish recipe is not lined to the Look info table", test, Capture);
			}
			WaitforPage(4000);

			boolean isMaterialCodeLinked = seasonPage.verifyMaterialCodeLinkedToSeasonalLooks(lookFinishRecipe, test);
			if (isMaterialCodeLinked) {
				System.out.println("(Look finish recipe)Material code is linked to Seasonal Looks successfully.");
				test.log(Status.PASS, "(Look finish recipe)Material code is linked to Seasonal Looks successfully.");
				addSrceenShot("(Look finish recipe)Material code is linked to Seasonal Looks successfully.", test,
						Capture);
			} else {
				System.out.println("(Look finish recipe)Material code is not linked to Seasonal Looks successfully.");
				test.log(Status.FAIL,
						"(Look finish recipe)Material code is not linked to Seasonal Looks successfully.");
				addSrceenShot("(Look finish recipe)Material code is not linked to Seasonal Looks successfully.", test,
						Capture);
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