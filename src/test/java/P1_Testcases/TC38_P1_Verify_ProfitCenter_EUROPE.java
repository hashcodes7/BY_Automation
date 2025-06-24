package P1_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
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


import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC38_P1_Verify_ProfitCenter_EUROPE extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;

	LineSheet_Edit_Page LineSheetEditPage;

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

			LineSheetEditPage = new LineSheet_Edit_Page(driver);

			setReport("TC38_P1 Verify Profit Center [EUROPE]");
		}
	}

	@Test(priority = 0, dataProvider = "TC38_P1_Verify_ProfitCenter_EUROPE", dataProviderClass = DataProviders.class)
	public void P1_TC38_Verify_Profit_Center_Europe_Create_PC9_for_type_Levis_MensBottoms(String TestType,
			String season, String linesheetview, String colorway, String productSegmentationLSE_Value)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC38_P1 Verify Profit Center [EUROPE]:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P1 Colorway module from TC38");

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

//			String colorway = "0WPRP-0000 HEATHER PINK";
			Colorwaypage.SelectColorway(colorway, test);
			test.log(Status.INFO, "colorway details page opened ");
			addSrceenShot("colorway details page opened ", test, Capture);

			Colorwaypage.editColorWay();
			test.log(Status.INFO, "Clicked On Edit Colorway from the Menu");
			addSrceenShot("Clicked On Edit Colorway from the Menu", test, Capture);
			WaitforPage(5000);

//			String productSegmentationLSE_Value = "A67 - LFB RT Accessories Handbags/Bags";
			Colorwaypage.selectProdSegLSE_DropDown(productSegmentationLSE_Value);
			System.out.println("Selected ProductSegmentationLSE value From DropDown");
			test.log(Status.INFO,
					"Selected ProductSegmentationLSE value From DropDown: " + productSegmentationLSE_Value);
			addSrceenShot("Selected ProductSegmentationLSE value From DropDown", test, Capture);
			WaitforPage(4000);

			Colorwaypage.clickOnsaveButton();
			test.log(Status.INFO, "Clicked On Save Button");
			addSrceenShot("Clicked On Save Button", test, Capture);
			WaitforPage(4000);

			Colorwaypage.ValidateProfitCenter_EUROPE(productSegmentationLSE_Value, test);
			test.log(Status.PASS, "Validation: Profit Center [EUROPE] is derived from Product Segmentation [LSE]");
			addSrceenShot("Profit Center [EUROPE] is derived from Product Segmentation [LSE]", test, Capture);
			
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
