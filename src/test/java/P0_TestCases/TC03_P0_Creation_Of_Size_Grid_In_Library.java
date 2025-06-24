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


import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC03_P0_Creation_Of_Size_Grid_In_Library extends WMS_TestBase {

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
			setReport("TC03_P0_Creation_Of_Size_Grid_In_Library");
		}
	}

	@Test(priority = 0, dataProvider = "sizeGridData", dataProviderClass = DataProviders.class)
	public void P0_TC03_Creation_Of_Size_Grid_In_Library(String TestType, String sizeGridName, String code,
			String sampleSize, String coreOrSeasonal, String SizeScale, String sizeGridStatus)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P0_Creation_Of_Size_Grid_In_Library:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers Sizing module from 231 to 235");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + Administrator_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);



			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_SIZEGRID.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Size Grid");
			test.log(Status.INFO, "Clicked on Size Grid");
			WaitforPage(4000);

			sizePage.clikOnNewBtn();
			test.log(Status.INFO, "Clicked on New button to create New Size Grid");
			addSrceenShot("New Size Grid creation started", test, Capture);

//			String sizeGridName = "Demo_sizeGrid02";
			sizePage.enterSizeGridName(sizeGridName, test);
			test.log(Status.INFO, "Entered Size Scale Name: "+sizeGridName);
			addSrceenShot("Entered Size Scale Name", test, Capture);

//			String code = "Code123";
			sizePage.enterCode(code, test);
			test.log(Status.INFO, "Entered Code: "+code);
			addSrceenShot("Entered Code", test, Capture);

//			String sampleSize = "22";
			sizePage.enterSampleSize(sampleSize, test);
			test.log(Status.INFO, "Entered Sample Size: "+sampleSize);
			addSrceenShot("Entered Sample Size", test, Capture);

//			String coreOrSeasonal = "Core";
			sizePage.selectCoreOrSeasonal(coreOrSeasonal, test);
			test.log(Status.INFO, "Selected Core/Seasonal: "+coreOrSeasonal);
			addSrceenShot("Selected Core/Seasonal", test, Capture);

			sizePage.clickOnSizeScale();
			test.log(Status.INFO, "Clicked On SizeScale");
			addSrceenShot("Clicked On SizeScale", test, Capture);

//			String SizeScale = "26X29-44X32";
			sizePage.selectSizeScale(SizeScale, test);
			test.log(Status.INFO, "Selected SizeScale: "+SizeScale);
			addSrceenShot("Selected SizeScale", test, Capture);

//			String sizeGridStatus = "Active";
			sizePage.selectSizeGridStatus(sizeGridStatus, test);
			test.log(Status.INFO, "Selected Size Grid Status: "+sizeGridStatus);
			addSrceenShot("Selected Size Grid Status", test, Capture);

			// Save the new size grid
			sizePage.clickSaveBtn(test);
			test.log(Status.INFO, "Clicked Save button to save the new Size Grid");
			addSrceenShot("New Size Grid saved", test, Capture);
		    test.log(Status.PASS, "New Size Grid '" + sizeGridName + "' created successfully");


			String actiondpdwnValue = "View / Update Size Grid";
			sizePage.viewAndUpdateSizeGrid(actiondpdwnValue, sizeGridName, test);
			test.log(Status.INFO, "Sizes attribute showed sizes you selected on View/Update Size Grid page.");
			addSrceenShot("Viewed and updated Size Grid", test, Capture);
			
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