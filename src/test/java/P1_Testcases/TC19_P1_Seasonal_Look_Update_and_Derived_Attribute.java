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
public class TC19_P1_Seasonal_Look_Update_and_Derived_Attribute extends WMS_TestBase {

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
			LaunchSpecific_URL(Design_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			color_Page = new Color_Page(driver);
			setReport("TC19_P1_Seasonal_Look_Update_and_Derived_Attribute_Validation");
		}
	}

	@Test(priority = 0, dataProvider = "TC19_P1_Seasonal_Look_Update_and_Derived_Attribute", dataProviderClass = DataProviders.class)
	public void P1_TC19_Seasonal_Look_Update_and_Derived_Attribute(String TestType, String colorLookType, String seasonalLook,
			String lookName, String colorFamily) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC19_P1_Seasonal_Look_Update_and_Derived_Attribute_Validation:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P1 color module from TC19 to TC21");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + Design_URL);

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

//			String colorLookType = "Seasonal Look";
			color_Page.clickOnColorLook(colorLookType, test);
			System.out.println("Clicked on Seasonal Look");
			test.log(Status.INFO, "Clicked on Seasonal Look");
			addSrceenShot("Clicked on Seasonal Look", test, Capture);
			WaitforPage(4000);

//			String seasonalLook = "Levi's S3 2025 Female Accessories 00407 STONEWASH 00407";
			color_Page.selectSeasonalLook(seasonalLook, test);
			System.out.println("Selected Seasonal Look: " + seasonalLook);
			test.log(Status.INFO, "Selected Seasonal Look: " + seasonalLook);
			addSrceenShot("Selected Seasonal Look", test, Capture);
			WaitforPage(4000);

			color_Page.clickOnUpdate();
			System.out.println("Clicked on Update Under Actions Drop Downn");
			test.log(Status.INFO, "Clicked on Update Under Actions Drop Downn");
			addSrceenShot("Clicked on Update Under Actions Drop Downn", test, Capture);
			WaitforPage(4000);

			// Modify attribute values
//			String lookName = "STONEWASH 23341";
//			String colorFamily = "Browns";
			color_Page.modifyAttributes(lookName, colorFamily);
			System.out.println("Modified attribute values: " + lookName + " " + colorFamily);
			test.log(Status.INFO, "Modified attribute values: " + lookName + " " + colorFamily);
			addSrceenShot("Modified attribute values", test, Capture);
			WaitforPage(4000);

			// Click on Save
			color_Page.clickOnSave();
			System.out.println("Clicked on Save");
			test.log(Status.INFO, "Clicked on Save");
			addSrceenShot("Clicked on Save", test, Capture);
			WaitforPage(4000);

			// Verify updated values
			boolean isUpdated = color_Page.verifyUpdatedValues(seasonalLook, lookName, colorFamily, test);
			if (isUpdated) {
				System.out.println("Seasonal Look updated successfully");
				test.log(Status.PASS, "Validation: Seasonal Look updated successfully");
				addSrceenShot("Seasonal Look updated successfully", test, Capture);
			} else {
				System.out.println("Failed to update Seasonal Look");
				test.log(Status.FAIL, "Failed to update Seasonal Look");
				addSrceenShot("Failed to update Seasonal Look", test, Capture);
			}

			boolean isColorNameCorrect = color_Page.verifyColorNameFormat(lookName, test);
			if (isColorNameCorrect) {
				System.out.println("Color Name format is correct");
				test.log(Status.PASS, "Validation: Color Name format is correct");
				addSrceenShot("Color Name format is correct", test, Capture);
			} else {
				System.out.println("Color Name format is incorrect");
				test.log(Status.FAIL, "Color Name format is incorrect");
				addSrceenShot("Color Name format is incorrect", test, Capture);
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