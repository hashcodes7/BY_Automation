package E2E_Testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.ColorWayPage;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LSEProductSegmentationPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;

import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC299_P0_E2E_SizingAttributes_Local extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
//	PalettePage palettePage;

	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	ProductDetailsPage productDetailsPage;
	LSEProductSegmentationPage lseProductSegmentationPage;
	PopUpPage popUpPage;
	ColorWayPage colorWayPage;

	boolean Capture = true;
	private String localHub_URL; 



	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	/**
	 * Note: Ensure you are logged in as a Local user before executing this test
	 * case
	 */
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			localHub_URL = Sanfrancisco_URl_STG;
			LaunchSpecific_URL(localHub_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
//			palettePage = new PalettePage(driver);

			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			lseProductSegmentationPage = new LSEProductSegmentationPage(driver);
			popUpPage = new PopUpPage(driver);
			colorWayPage = new ColorWayPage(driver);

			setReport("TC299_E2E_LocalSizingAttributesUpdateVerification");
		}
	}

	@Test(priority = 0, dataProvider = "sizingAttributesData_Local", dataProviderClass = DataProviders.class)
	public void P0_TC04_E2E_SizingAttributes_Local(String TestType, String mySeasonType, String productName,
			String viewType, String globalVaue, String localHubValue, String newSelectedSizesLH)
			throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC299_E2E_LocalSizingAttributesUpdateVerification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers E2E module 299");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + localHub_URL);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String mySeasonType = "Levi's S1 2024 Female Accessories";
			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//			String viewType = "Size Selection";
			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);

//			String productName = "Test_Product1";
			lineSheetPage.filterProduct(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

//			String globalVaue = "Global";
			lineSheetPage.selectSeasonGroupAsGlobal(globalVaue, test);
			System.out.println("SeasonGroup As Global choosen");
			test.log(Status.INFO, "selected SeasonGroup As Global choosen: " + globalVaue);
			addSrceenShot("selected SeasonGroup As Global choosen", test, Capture);

//			String localHubValue = "San Francisco ";
			lineSheetPage.selectlocalHubdropdownValue(localHubValue, test);
			System.out.println("localHubdropdownValue choosen");
			test.log(Status.INFO, "localHubdropdownValue choosen: " + localHubValue);
			addSrceenShot("localHubdropdownValue choosen", test, Capture);

			// Edit 'Selected sizes-LH'
//			String newSelectedSizesLH = "1:M, 0:S, 3:S";
			lineSheetPage.editSelectedSizesLH(newSelectedSizesLH, test);
			System.out.println("Updated 'Selected sizes-LH'");
			test.log(Status.PASS, "Updated 'Selected sizes-LH'");
			addSrceenShot("Updated 'Selected sizes-LH'", test, Capture);

			lineSheetPage.editSelectedSizesLHLocked(test);
			System.out.println("Edited 'Selected sizes LH Locked?'");
			test.log(Status.PASS, "Edited 'Selected sizes LH Locked?'");
			addSrceenShot("Edited 'Selected sizes LH Locked?'", test, Capture);
			test.log(Status.PASS, "Sizing Attributes are Updated Successfully For Local");

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
