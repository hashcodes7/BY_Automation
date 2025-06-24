package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.ArrayList;
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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_UpdateMultipleColorway_RigidIndicator extends WMS_TestBase {
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
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC_P3_UpdateMultipleColorway_RigidIndicator");
		}
	}

	@Test(priority = 0, dataProvider = "TC_P3_UpdateMultipleColorway_RigidIndicator", dataProviderClass = DataProviders.class)

	public void CreateMultipleColorway_Product(String[][] testData) throws Exception {

		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
//					String TestType = data[0];
			String season = data[1];
			String colorway = data[2];
			String linesheetview = data[3];

			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_UpdateMultipleColorway_RigidIndicator:::");
			}
			CloseBrowser = false;
			// ...............................browser launched time starts
			long startTime = System.nanoTime();

			try {
				test.log(Status.INFO, "This tescase covers TC_3 to TC_5");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully with URL: " + URL);

				dashboardPage.openLeftPanel();
				test.log(Status.INFO, "Left panel opened");
				addSrceenShot("Left panel opened", test, Capture);

				mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
				test.log(Status.INFO, "My seasons menu clicked");
				addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

				Colorwaypage.SeasonDropdown(season, test);
				test.log(Status.INFO, "season selected: " + season);
				addSrceenShot("season selected", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addSrceenShot("Clicked on Line Sheets", test, Capture);

				WaitforPage(5000);
				LineSheetEditPage.filter_View_Change(linesheetview, test);
				test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
				addSrceenShot("Linesheet view is " + linesheetview, test, Capture);
				Thread.sleep(2000);

				Colorwaypage.SelectColorway(colorway, test);
				System.out.println("Colorway selected: " + colorway);
				test.log(Status.INFO, "colorway details page opened ");
				addSrceenShot("colorway details page opened ", test, Capture);
				Thread.sleep(2000);

				String expectedrigidindicator = Colorwaypage.rigidIndicatorvalue(test);
				System.out.println("Expected Rigid indicator is  " + expectedrigidindicator);
				test.log(Status.INFO, "Expected Rigid indicator is  " + expectedrigidindicator);
				addSrceenShot("Expected Rigid indicator is  " + expectedrigidindicator, test, Capture);

				Colorwaypage.Validate_RigidIndicator_updatecolorway_AfterSetupLSE(expectedrigidindicator, test);
				test.log(Status.PASS, "Validation Successful for rigid indicator");
				System.out.println("Validation Successful for rigid indicator");
				addSrceenShot("Validation Successful for rigid indicator", test, Capture);

				if (i == testData.length - 1) {
					// Last iteration, perform logout

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addSrceenShot("Logout successful", test, Capture);

				} else {

					ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(0));
					driver.switchTo().window(tabs.get(1));
					driver.close(); // Close the second tab
					driver.switchTo().window(tabs.get(0));
					// Not the last iteration, refresh the browser
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
