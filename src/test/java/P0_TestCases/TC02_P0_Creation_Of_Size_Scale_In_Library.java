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
public class TC02_P0_Creation_Of_Size_Scale_In_Library extends WMS_TestBase {

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
			setReport("TC02_P0_Creation_Of_Size_Scale_In_Library");
		}
	}

	@Test(priority = 0, dataProvider = "sizeScaleData", dataProviderClass = DataProviders.class)
	public void P0_TC02_Creation_Of_Size_Scale_In_Library(String TestType, String sizeScaleName,
			String columnAbbreviation, String columnDimension, String columnName, String sizeScaleCode,
			String rowAbbreviation, String rowDimension, String rowName, String description)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC02_P0_Creation_Of_Size_Scale_In_Library:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers material Sizing from 229 to 230");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + Administrator_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_SIZESCALE.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Size Scale");
			test.log(Status.INFO, "Clicked on Size Scale");
			WaitforPage(4000);

			sizePage.clikOnNewBtn();
			test.log(Status.INFO, "Clicked on New button to create New Size Dimention");
			addSrceenShot("New Size Dimention creation started", test, Capture);

//			String sizeScaleName = "Automation_demo_01";
			sizePage.enterSizeScaleName(sizeScaleName, test);
			test.log(Status.INFO, "Entered Size Scale Name");
			addSrceenShot("Entered Size Scale Name", test, Capture);

//			String columnAbbreviation = "ColAbbr12";
			sizePage.enterColumnAbbreviation(columnAbbreviation, test);
			test.log(Status.INFO, "Entered Column Abbreviation: " + columnAbbreviation);
			addSrceenShot("Entered Column Abbreviation", test, Capture);

			sizePage.clickOnColumnDimension();
			test.log(Status.INFO, "Clicked On ColumnDimension");
			addSrceenShot("Clicked On ColumnDimension", test, Capture);

//			String columnDimension = "Global Apparel Dim1";
			sizePage.selectColumnDimension(columnDimension, test);
			test.log(Status.INFO, "Selected Column Dimension: " + columnDimension);
			addSrceenShot("Selected Column Dimension", test, Capture);

//			String columnName = "ColName12";
			sizePage.enterColumnName(columnName, test);
			test.log(Status.INFO, "Entered Column Name: " + columnName);
			addSrceenShot("Entered Column Name", test, Capture);

			sizePage.ClickOnGlobalDimension();
			test.log(Status.INFO, "Global Dimension Check Box Enabled");
			addSrceenShot("Global Dimension Enabled", test, Capture);

//			String sizeScaleCode = "ScaleCode123";
			sizePage.enterSizeScaleCode(sizeScaleCode, test);
			test.log(Status.INFO, "Entered Size Scale Code: " + sizeScaleCode);
			addSrceenShot("Entered Size Scale Code", test, Capture);

//			String rowAbbreviation = "RowAbbr12";
			sizePage.enterRowAbbreviation(rowAbbreviation, test);
			test.log(Status.INFO, "Entered Row Abbreviation: " + rowAbbreviation);
			addSrceenShot("Entered Row Abbreviation", test, Capture);

			sizePage.clickOnRowDimension();
			test.log(Status.INFO, "Clicked On RowDimension Link");
			addSrceenShot("Clicked On RowDimension Link", test, Capture);

//			String rowDimension = "Global Apparel Dim1";
			sizePage.selectRowDimension(rowDimension, test);
			test.log(Status.INFO, "Selected RowDimension value: " + rowDimension);
			addSrceenShot("Selected RowDimension value", test, Capture);

//			String rowName = "RowName12";
			sizePage.enterRowName(rowName, test);
			test.log(Status.INFO, "Entered Row Name: " + rowName);
			addSrceenShot("Entered Row Name", test, Capture);

//			String description = "Description12";
			sizePage.enterDescription(description, test);
			test.log(Status.INFO, "Entered Description: " + description);
			addSrceenShot("Entered Description", test, Capture);

			// Save the new size scale
			sizePage.clickSaveBtn(test);
			test.log(Status.INFO, "Clicked Save button to save the new Size Scale");
			addSrceenShot("New Size Scale saved", test, Capture);

			sizePage.selectSizeScale(MainMenuEnum.LIBRARIES_SIZESCALE.menu());
			test.log(Status.INFO, "Clicked on Size Scale");
			addSrceenShot("Clicked on Size Scale", test, Capture);

			// Verify the new size scale is created successfully
			boolean isCreated = sizePage.verifySizeScaleCreation(sizeScaleName, test);
			if (isCreated) {
				test.log(Status.PASS, "New Size Scale is created successfully");
				addSrceenShot("New Size Scale is created successfully", test, Capture);
			} else {
				test.log(Status.FAIL, "Failed to create New Size Scale");
				addSrceenShot("Failed to create New Size Scale", test, Capture);
			}

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