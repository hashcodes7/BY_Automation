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
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC46_P1_Update_PC9_With_Non_Required_Attributes extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;

	LineSheet_Edit_Page LineSheetEditPage;
	Colorway_page colorWayPage;

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
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);

			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			colorWayPage = new Colorway_page(driver);

			setReport("TC46_P1 Verify_Update_PC9_With_Non_Required_Attributes_for_type_Levis_Accessories");
		}
	}

	@Test(priority = 0, dataProvider = "TC46_P1_Update_PC9", dataProviderClass = DataProviders.class)
	public void P1_TC46_Verify_Update_PC9_for_type_Levis_Male_Accessories_Non_Required_Attributes(String TestType,
			String season, String linesheetview, String colorway, String targetVolume, String collectionType,
			String capsule, String materialType, String performance, String consumerGroup, String consumerGroupExt1,
			String consumerGroupExt2, String destroySampleInd, String profitCenterAPD, String merchFabricType,
			String briefCode) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC46_P1 Verify_Update_PC9_With_Non_Required_Attributes_for_type_Levis_Accessories:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Colorway module TC46");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + Global_URL);
			addSrceenShot("login successful", test, Capture);

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
			WaitforPage(5000);

//			String linesheetview = "Adoption";
			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);
			WaitforPage(5000);

//			String colorway = "0WPRP-0009 DA077E SolidC123 BEDFORD CORD";
			Colorwaypage.SelectColorway(colorway, test);
			test.log(Status.INFO, "colorway details page opened ");
			addSrceenShot("colorway details page opened ", test, Capture);

			Colorwaypage.editColorWay();
			test.log(Status.INFO, "Clicked On Edit Colorway from the Menu");
			addSrceenShot("Clicked On Edit Colorway from the Menu", test, Capture);
			WaitforPage(5000);

			// All non mandatory feilds
//			String targetVolume = "17";
//			String collectionType = "Special Make up Promo";
//			String capsule = "Club";
//			String materialType = "Yarn";
//			String performance = "Cool";
//			String consumerGroup = "Total Mens";
//			String consumerGroupExt1 = "Adult Mens";
//			String consumerGroupExt2 = "Adult Mens Conventional";
//			String destroySampleInd = "Yes";
//			String profitCenterAPD = "No results found";
//			String merchFabricType = "CANVAS";
//			String briefCode = "BR201";

			Colorwaypage.updateNonMandatoryFields(targetVolume, collectionType, capsule, materialType, performance,
					consumerGroup, consumerGroupExt1, consumerGroupExt2, destroySampleInd, profitCenterAPD,
					merchFabricType, briefCode, test);
			System.out.println("Updated All NonMandatory Fields");
			test.log(Status.INFO, "Updated All NonMandatory Fields");
			addSrceenShot("Updated All NonMandatory Fields", test, Capture);
			WaitforPage(4000);

			colorWayPage.clickOnSave();
			System.out.println("Clicked On save Button");
			test.log(Status.INFO, "Clicked On save Button");
			addSrceenShot("Clicked On save Button", test, Capture);
			WaitforPage(4000);

			// Verify non-required attributes updated
			boolean areNonRequiredAttributesUpdated = Colorwaypage.verifyNonRequiredAttributesUpdated(targetVolume,
					collectionType, capsule, materialType, performance, merchFabricType, briefCode);
			Assert.assertTrue(areNonRequiredAttributesUpdated,
					"Non-required attributes were not updated successfully.");

			System.out.println("Verified non-required attributes updated successfully.");
			test.log(Status.PASS, "Verification: Non-required attributes updated successfully.");
			addSrceenShot("Verified non-required attributes updated successfully", test, Capture);

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
