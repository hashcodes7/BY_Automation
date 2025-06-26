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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC248_P1_ApplySizeGridToNEW_PC9_Prior_to_Setup extends WMS_TestBase {
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

			setReport("TC248_P1_Verify_SizeGrid_Selection_And_Attributes_For_NEW_PC9_On_ColorwaySeasonPage");
		}
	}

	@Test(priority = 0, dataProvider = "sizeGridData_NEW_PC9_Prior_to_Setup", dataProviderClass = DataProviders.class)
	public void P1_TC248_ApplySizeGridToNEW_PC9_Prior_to_Setup(String TestType, String season, String linesheetview, String colorway,
			String sizeGridCode) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC248_P1_SizeGrid_Selection_And_Attributes_For_NEW_PC9_On_ColorwaySeasonPage_Verification:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Sizing module TC248");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + Global_URL);
			addScreenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2024 Male Accessories";
			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addScreenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

//			String linesheetview = "Adoption";
			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addScreenShot("Linesheet view changed", test, Capture);
			WaitforPage(5000);

//			String colorway = "0WPW6-0000 DA077E SolidC123";
			Colorwaypage.SelectColorway(colorway, test);
			test.log(Status.INFO, "colorway details page opened ");
			addScreenShot("colorway details page opened ", test, Capture);

			Colorwaypage.editColorWaySeasonPage();
			test.log(Status.INFO, "Clicked On Edit Colorway - Season from the Menu");
			addScreenShot("Clicked On Edit Colorway - Season from the Menu", test, Capture);
			WaitforPage(5000);

//			String sizeGridCode = "0-13s, 0-17m - JNRS09";
			Colorwaypage.chooseSizeGridCode(sizeGridCode, test);
			test.log(Status.INFO, "Size Grid Code Was Choosen: " + sizeGridCode);
			addScreenShot("Size Grid Code Was Choosen", test, Capture);

			colorWayPage.clickOnSave();
			System.out.println("Clicked On save Button");
			test.log(Status.INFO, "Clicked On save Button");
			addScreenShot("Clicked On save Button", test, Capture);
			WaitforPage(4000);

			// Verification step
			String appliedSizeGridCode = Colorwaypage.getAppliedSizeGridCode(test);
			Assert.assertEquals(appliedSizeGridCode, sizeGridCode, "Size grid code does not match!");
			System.out.println("Verified that the chosen size grid code is applied on the colorway-season page.");
			test.log(Status.PASS, "Verified that the chosen size grid code is applied on the colorway-season page.");
			addScreenShot("Verified that the chosen size grid code is applied on the colorway-season page.", test,
					Capture);

			// Call the method to verify auto-populated values
			Colorwaypage.verifySizeGridAttributes(sizeGridCode, test);
			test.log(Status.PASS, "Sample size, size scale code, and selected sizes are the same as in the size grid.");

			WaitforPage(4000);

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
