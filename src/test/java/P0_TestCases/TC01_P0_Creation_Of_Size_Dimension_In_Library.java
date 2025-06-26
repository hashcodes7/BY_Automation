package P0_TestCases;

import static org.testng.Assert.assertNotNull;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.WMS_ApplicationPages.SizePage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC01_P0_Creation_Of_Size_Dimension_In_Library extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	SizePage sizePage;
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
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			sizePage = new SizePage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC01_P0_Creation_Of_Size_Dimension_In_Library");
		}
	}

	@Test(priority = 0, dataProvider = "sizeDimensionData", dataProviderClass = DataProviders.class)
	public void P0_TC0_Creation_Of_Size_Dimension_In_Library(String TestType, String dimensionName,
			String dimensionCode, String dimension_Name, List<String> sizes) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P0_Creation_Of_Size_Dimension_In_Library:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers Sizing module from 226 to 228");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + Administrator_URL);
			addScreenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_SIZEDIMENSION.menu(), true);
			addScreenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Size Dimension");
			test.log(Status.INFO, "Clicked on Size Dimension");
			WaitforPage(4000);

			sizePage.clikOnNewBtn();
			test.log(Status.INFO, "Clicked on New button to create New Size Dimention");
			addScreenShot("New Size Dimention creation started", test, Capture);

//			String dimensionName = "DimensionName001";
			sizePage.enterDimensionName(dimensionName, test);
			test.log(Status.INFO, "Entered Dimension Name");
			addScreenShot("Entered Dimension Name", test, Capture);

//			String dimensionCode = "DimensionCode123";
			sizePage.enterDimensionCode(dimensionCode, test);
			test.log(Status.INFO, "Entered Dimension Code");
			addScreenShot("Entered Dimension Code", test, Capture);

//			String dimension_Name = "DimensionName_0023";
			sizePage.enterDimension_Name(dimension_Name, test);
			test.log(Status.INFO, "Entered Dimension Name");
			addScreenShot("Entered Dimension Name", test, Capture);

//			List<String> sizes = Arrays.asList("32", "34", "36");
			sizePage.addMultipleSizes(sizes, test);
			test.log(Status.INFO, "Entered and Added Multiple Sizes");
			addScreenShot("Entered and Added Multiple Sizes", test, Capture);

			// Save the new size dimension
			sizePage.clickSaveBtn(test);
			test.log(Status.INFO, "Clicked Save button to save the new Size Dimension");
			addScreenShot("New Size Dimension saved", test, Capture);

			sizePage.selectSizeDimension(MainMenuEnum.LIBRARIES_SIZEDIMENSION.menu());
			test.log(Status.INFO, "Clicked on Size Dimension");
			addScreenShot("Clicked on Size Dimension", test, Capture);

			// Verify the new size dimension is created successfully
			boolean isCreated = sizePage.verifySizeDimensionCreation(dimensionName, test);
			if (isCreated) {
				test.log(Status.PASS, "New Size Dimension is created successfully");
				addScreenShot("New Size Dimension is created successfully", test, Capture);
			} else {
				test.log(Status.FAIL, "Failed to create New Size Dimension");
				addScreenShot("Failed to create New Size Dimension", test, Capture);
			}

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);

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