package P1_Testcases;

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

import com.WMS_ApplicationPages.Color_Page;
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

@Test(enabled = true, groups= {"P1_TC"})
public class TC12_P1_UpdateSolidColorWithSameColorLookID extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	Color_Page color_Page;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Colorist_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			color_Page = new Color_Page(driver);
			setReport("TC12_P1_Update Solid Color with Same Color Look ID");
		}
	}

	@Test(priority = 0, dataProvider = "TC12_P1_UpdateSolidColorWithSameColorLookID", dataProviderClass = DataProviders.class)
	public void P0_TC11_E2E_LookFinishRecipe(String TestType, String colorLookType, String solidColor_1,
			String solidColor_2) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC04_P1_Update Solid Color with Same Color Look ID:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P1 color module from TC12 to TC13");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + Colorist_URL);

			System.out.println("Logged in as colorist");
			test.log(Status.INFO, "Logged in as colorist");
			addSrceenShot("Logged in as colorist", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR_LOOK.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Color/Look");
			test.log(Status.INFO, "Clicked on Color/Look");
			WaitforPage(4000);

//			String colorLookType = "Solid Colors";
			color_Page.clickOnColorLook(colorLookType, test);
			System.out.println("Clicked on Solid Colors");
			test.log(Status.INFO, "Clicked on Solid Colors");
			addSrceenShot("Clicked on Solid Colors", test, Capture);
			WaitforPage(4000);

//			String solidColor_1 = "DA077E SolidC123";
			color_Page.selectLook(solidColor_1, test);
			System.out.println("Selected Existing SoliD Color_1: " + solidColor_1);
			test.log(Status.INFO, "Selected Existing SoliD Color_1: " + solidColor_1);
			addSrceenShot("Selected Existing SoliD Color_1", test, Capture);
			WaitforPage(4000);

			color_Page.viewColorRecord(test);
			System.out.println("Viewed color record Of: " + solidColor_1);
			test.log(Status.INFO, "Viewed color record Of: " + solidColor_1);
			addSrceenShot("Viewed color record", test, Capture);
			WaitforPage(4000);

			String colorName = color_Page.getColorNameValue();
			String colorFamily = color_Page.getColorFamily();

			color_Page.openNewTabAndNavigateToColor(URL, test);
			System.out.println("Opened new tab and navigated to the Color/Look Under Library");
			test.log(Status.INFO, "Opened new tab and navigated to the Color/Look Under Library");
			addSrceenShot("Opened new tab and navigated to the Color/Look Under Library", test, Capture);
			WaitforPage(4000);

			color_Page.clickOnColorLook(colorLookType, test);
			System.out.println("Clicked on Solid Colors");
			test.log(Status.INFO, "Clicked on Solid Colors");
			addSrceenShot("Clicked on Solid Colors", test, Capture);
			WaitforPage(4000);

//			String solidColor_2 = "DA077M Solid1234";
			color_Page.selectLook(solidColor_2, test);
			System.out.println("Selected Existing SoliD Color_2: " + solidColor_2);
			test.log(Status.INFO, "Selected Existing SoliD Color_2: " + solidColor_2);
			addSrceenShot("Selected Existing SoliD Color_2", test, Capture);
			WaitforPage(4000);

			color_Page.clickOnUpdate();
			System.out.println("Clicked on Update Under Actions Drop Downn");
			test.log(Status.INFO, "Clicked on Update Under Actions Drop Downn");
			addSrceenShot("Clicked on Update Under Actions Drop Downn", test, Capture);
			WaitforPage(4000);

			color_Page.UpdateAttributes(colorName, colorFamily);
			System.out.println("Updated attribute values: " + colorName + " " + colorFamily);
			test.log(Status.INFO, "Updated attribute values");
			addSrceenShot("Updated attribute values", test, Capture);
			WaitforPage(4000);

			color_Page.clickOnSave();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify uniqueness exception
			String exceptionMessage = color_Page.getExceptionMessage(test);
			if (exceptionMessage.contains("Two colors cannot have same")) {
				System.out.println("System throws uniqueness exception and color cannot be created");
				test.log(Status.PASS, "Validation: System throws uniqueness exception and color cannot be created");
				addSrceenShot("Uniqueness exception", test, Capture);
			} else {
				System.out.println("Test failed: Uniqueness exception not thrown");
				test.log(Status.FAIL, "Test failed: Uniqueness exception not thrown");
				addSrceenShot("Test failed", test, Capture);
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