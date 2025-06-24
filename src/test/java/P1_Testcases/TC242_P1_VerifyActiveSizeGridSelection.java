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


import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC242_P1_VerifyActiveSizeGridSelection extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;

	LineSheet_Edit_Page LineSheetEditPage;
	Colorway_page colorWayPage;

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
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);

			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			colorWayPage = new Colorway_page(driver);

			setReport("TC242_P1_Verify_Active_Size_Grid_Selection_On_PC9_ColorwaySeasonPage");
		}
	}

	@Test(priority = 0, dataProvider = "sizeGridData_P1", dataProviderClass = DataProviders.class)
	public void P1_TC242_VerifyActiveSizeGridSelection(String TestType, String season, String linesheetview,
			String colorway, String sizeGridCode) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC242_P1_Verify_Active_Size_Grid_Selection_On_PC9_ColorwaySeasonPage:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Sizing module from TC242 To TC243");

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

//			String colorway = "0WPJ9-0001 MOJAVE DESERT";
			//QA//colorway//0WPIT-0004 HONEYCOMB
			//dev//colorway//0WP5T-0001 test print Cloud dancer
			Colorwaypage.SelectColorway(colorway, test);
			test.log(Status.INFO, "colorway details page opened ");
			addSrceenShot("colorway details page opened ", test, Capture);

			Colorwaypage.editColorWaySeasonPage();
			test.log(Status.INFO, "Clicked On Edit Colorway - Season from the Menu");
			addSrceenShot("Clicked On Edit Colorway - Season from the Menu", test, Capture);
			WaitforPage(5000);

//			String sizeGridCode = "22 - 34 x 26, 28, 30, 32, 34, 36";
			Colorwaypage.chooseSizeGridCode(sizeGridCode, test);
			test.log(Status.INFO, "Size Grid Code Was Choosen: " + sizeGridCode);
			addSrceenShot("Size Grid Code Was Choosen", test, Capture);

			colorWayPage.clickOnSave();
			System.out.println("Clicked On save Button");
			test.log(Status.INFO, "Clicked On save Button");
			addSrceenShot("Clicked On save Button", test, Capture);
			WaitforPage(4000);

			// Verification step
			String appliedSizeGridCode = Colorwaypage.getAppliedSizeGridCode(test);
			Assert.assertEquals(appliedSizeGridCode, sizeGridCode, "Size grid code does not match!");
			System.out.println("Verified that the chosen size grid code is applied on the colorway-season page.");
			test.log(Status.PASS, "Verified that the chosen size grid code is applied on the colorway-season page.");
			addSrceenShot("Verified that the chosen size grid code is applied on the colorway-season page.", test,
					Capture);

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
