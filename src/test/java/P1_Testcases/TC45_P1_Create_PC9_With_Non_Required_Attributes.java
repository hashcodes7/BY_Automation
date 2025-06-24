package P1_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;

import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC45_P1_Create_PC9_With_Non_Required_Attributes extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;

	Colorway_page colorWayPage;
	ProductDetailsPage productDetailsPage;
	PopUpPage popUpPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);

			colorWayPage = new Colorway_page(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			popUpPage = new PopUpPage(driver);

			setReport("TC45_P1 Verify_Create_PC09_With_Non_Required_Attributesfor_type_Levis_Accessories");
		}
	}

	@Test(priority = 0, dataProvider = "pc9CreationData", dataProviderClass = DataProviders.class)
	public void P1_TC45_Verify_Create_PC9_for_type_Levis_MensBottoms(String TestType, String season, String productName,
			String colorName, String productTypeValue, String rigidIndicatorValue, String productSegmentationLSE_Value,
			String productSegmentationLSUS_Value, String targetVolume, String collectionType, String capsule,
			String materialType, String performance, String consumerGroup, String consumerGroupExt1,
			String consumerGroupExt2, String destroySampleInd, String profitCenterAPD, String merchFabricType,
			String briefCode, String hubOfferdToValue, String sizeGridCode, String primaryFabric,
			String seasonalDirection, String gtmTrack, String firstDirectiveMonth, String lastSeasonOffered,
			String globalOnFloorIntent, String firstMonthOnFloor, String winAtMarketplaceSoHem,
			String winAtMarketplaceNoHem, String winAtMarketplaceEquatorial, String blpForecast,
			String equityMOQRequest, String earlyDelivery, String lsusStockingCSC, String currentPlannedLifecycle,
			String heroOutfit, String productPricePositioning, String primaryFinishMill, String primaryFinish,
			String fabricMill, String seasonalLook) throws Exception {
		if (CloseBrowser) {
			test = extent
					.createTest(":::TC45_P1 Verify_Create_PC09_With_Non_Required_Attributesfor_type_Levis_Accessories:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers P1 Colorway module TC_45");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + Global_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2024 Male Accessories";
			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "0908LMA";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productDetailsPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.INFO, "PC5 Details Page is displayed");
			addSrceenShot("PC5 Details Page is displayed", test, Capture);

			productDetailsPage.CreateColorway();
			System.out.println("Clicked on Create Colorway");
			test.log(Status.INFO, "Clicked on Create Colorway");
			addSrceenShot("Clicked on Create Colorway", test, Capture);
			WaitforPage(4000);

			colorWayPage.ClickColorwayLookColor();
			System.out.println("Clicked on Colorway(Look/Color)");
			test.log(Status.INFO, "Clicked on Colorway(Look/Color)");
			addSrceenShot("Colorway(Look/Color)", test, Capture);
			WaitforPage(4000);

//			String colorName = "04U DA077E SolidC123";
			Colorwaypage.select_Color(colorName, test);
			System.out.println("Selected Color: " + colorName);
			test.log(Status.INFO, "Selected  Color: " + colorName);
			addSrceenShot("Selected Color", test, Capture);
			WaitforPage(4000);

			// All mandatory feilds
//			String productTypeValue = "Product";
			colorWayPage.selectProductType(productTypeValue);
			System.out.println("selected ProductType");
			test.log(Status.INFO, "Selected Product Type: " + productTypeValue);
			addSrceenShot("Selected Product Type", test, Capture);
			WaitforPage(4000);

//			String rigidIndicatorValue = "Rigid";
			colorWayPage.selectRigidIndicator(rigidIndicatorValue);
			System.out.println("selected RigidIndicator");
			test.log(Status.INFO, "Selected Rigid Indicator : " + rigidIndicatorValue);
			addSrceenShot("Selected Product Type", test, Capture);
			WaitforPage(4000);

//			String productSegmentationLSE_Value = "A66 - LFB RT Accessories Belts";
			colorWayPage.selectProductSegmentationLSE_DropDown(productSegmentationLSE_Value);
			System.out.println("Selected ProductSegmentationLSE value From DropDown");
			test.log(Status.INFO,
					"Selected ProductSegmentationLSE value From DropDown: " + productSegmentationLSE_Value);
			addSrceenShot("Selected ProductSegmentationLSE value From DropDown", test, Capture);
			WaitforPage(4000);

//			String productSegmentationLSUS_Value = "5 - LFK Boys 8-20 Discontinued Licensed";
			colorWayPage.selectProductSegmentationLSUS_DropDown(productSegmentationLSUS_Value);
			System.out.println("Selected ProductSegmentationLSUS value From DropDown");
			test.log(Status.INFO,
					"Selected ProductSegmentationLSUS value From DropDown: " + productSegmentationLSUS_Value);
			test.log(Status.INFO, "Entered All Mandatory Feilds ");
			addSrceenShot("Selected ProductSegmentationLSUS value From DropDown", test, Capture);
			WaitforPage(4000);

			// All non mandatory feilds
//			String targetVolume = "19";
//			String collectionType = "Standard Collection";
//			String capsule = "Alt 5 Pocket Styled";
//			String materialType = "Knit";
//			String performance = "All season Tech";
//			String consumerGroup = "Total Kids";
//			String consumerGroupExt1 = "Boys";
//			String consumerGroupExt2 = "Regular Boys";
//			String destroySampleInd = "No";
//			String profitCenterAPD = "- Levi s Male Accessories Belts";
//			String merchFabricType = "BEDFORD CORD";
//			String briefCode = "BR123";

			Colorwaypage.fillNonMandatoryFields(targetVolume, collectionType, capsule, materialType, performance,
					consumerGroup, consumerGroupExt1, consumerGroupExt2, destroySampleInd, profitCenterAPD,
					merchFabricType, briefCode, test);
			System.out.println("Filled All NonMandatory Fields");
			test.log(Status.INFO, "Filled All NonMandatory Fields");
			addSrceenShot("Filled All NonMandatory Fields", test, Capture);
			WaitforPage(4000);

			colorWayPage.clickOnSave();
			System.out.println("Clicked On save Button");
			test.log(Status.INFO, "Clicked On save Button");
			addSrceenShot("Clicked On save Button", test, Capture);
			WaitforPage(4000);

//			String hubOfferdToValue = "Global";
			colorWayPage.selectHubOfferdToValue(hubOfferdToValue);
			System.out.println("selected HubOfferd To Value");
			test.log(Status.INFO, "selected HubOfferd To Value : " + hubOfferdToValue);
			addSrceenShot("selected HubOfferd To Value", test, Capture);
			WaitforPage(4000);

			// All non required fields on Colorway Season Page

//			String sizeGridCode = "0-13s, 0-17m - JNRS09";
//			String primaryFabric = "FA771022 demo_material_01";
//			String seasonalDirection = "SD4";
//			String gtmTrack = "Insights to Brief";
//			String firstDirectiveMonth = "January";
//			String lastSeasonOffered = "S3 2027";
//			String globalOnFloorIntent = "COR";
//			String firstMonthOnFloor = "January";
//			String winAtMarketplaceSoHem = "ADB Key Look";
//			String winAtMarketplaceNoHem = "ADB Key Look";
//			String winAtMarketplaceEquatorial = "ADB Key Look";
//			String blpForecast = "12";
//			String equityMOQRequest = "21";
//			String earlyDelivery = "No";
//			String lsusStockingCSC = "GENCO";
//			String currentPlannedLifecycle = "1-2 months";
//			String heroOutfit = "No";
//			String productPricePositioning = "TIER 1";
//			String primaryFinishMill = "236206 Test_ FinishRecepie";
//			String primaryFinish = "236191 Demo_material_01_aug06";
//			String fabricMill = "236191 Demo_material_01_aug06";
//			String seasonalLook = "Levi's S1 2024 Female Accessories *BRITISH KHAKI NEW PK*";

			Colorwaypage.fillNonMandatoryFieldsOfColorwaySeasonPage(sizeGridCode, primaryFabric, seasonalDirection,
					gtmTrack, firstDirectiveMonth, lastSeasonOffered, globalOnFloorIntent, firstMonthOnFloor,
					winAtMarketplaceSoHem, winAtMarketplaceNoHem, winAtMarketplaceEquatorial, blpForecast,
					equityMOQRequest, earlyDelivery, lsusStockingCSC, currentPlannedLifecycle, heroOutfit,
					productPricePositioning, primaryFinishMill, primaryFinish, fabricMill, seasonalLook, test);
			System.out.println("Filled All Non Mandatory Fields Of Colorway Season Page");
			test.log(Status.INFO, "Filled All Non Mandatory Fields Of Colorway Season Page");
			addSrceenShot("Filled All Non Mandatory Fields Of Colorway Season Page", test, Capture);
			WaitforPage(4000);

			colorWayPage.clickOnViewProduct();
			System.out.println("Clicked On ViewProduct");
			test.log(Status.INFO, "Clicked On View Product");
			addSrceenShot("Clicked On View Product", test, Capture);
			WaitforPage(4000);

			// Verify PC9 creation and non-required attributes
			boolean isPC9Created = Colorwaypage.verifyPC9Creation(test);
			boolean areNonRequiredAttributesFilled = Colorwaypage.verifyNonRequiredAttributes(collectionType,
					seasonalDirection, test);

			Assert.assertTrue(isPC9Created, "PC9 was not created successfully.");
			System.out.println("PC9 was created successfully.");
			test.log(Status.PASS, "Verification: PC9 was created successfully.");
			addSrceenShot("PC9 was created successfully.", test, Capture);

			Assert.assertTrue(areNonRequiredAttributesFilled,
					"Non-required attributes were not filled in successfully.");
			System.out.println("Non-required attributes were filled successfully.");
			test.log(Status.PASS, "Verification: Non-required attributes were filled successfully.");
			addSrceenShot("Non-required attributes were filled successfully.", test, Capture);

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
