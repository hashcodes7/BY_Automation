package P2_TestCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.SourcingPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC257_P2_AssociateColorwaySource_sourceAlreadyAssociatedToPC5 extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	Palette_Page palettePage;

	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	ProductDetailsPage productDetailsPage;
	LSEProductSegmentationPage lseProductSegmentationPage;
	PopUpPage popUpPage;
	ColorWayPage colorWayPage;
	SourcingPage sourcingPage;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a PDS user before executing this test
	 * case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(PDS_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			palettePage = new Palette_Page(driver);

			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			lseProductSegmentationPage = new LSEProductSegmentationPage(driver);
			sourcingPage = new SourcingPage(driver);
			popUpPage = new PopUpPage(driver);
			colorWayPage = new ColorWayPage(driver);

			setReport(
					"TC257_P2_Associate Colorway with source from linesheet assuming source is already associated to PC5");
		}
	}

	@Test(priority = 0, dataProvider = "TC257_P2_AssociateColorwaySource_sourceAlreadyAssociatedToPC5", dataProviderClass = DataProviders.class)
    public void P2_TC257_AssociateColorwaySource_sourceAlreadyAssociatedToPC5(String TestType, String season, String viewType, String colorWayName, List<String> vendorNames) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(
					":::TC257_P2_Associate Colorway with source from linesheet assuming source is already associated to PC5:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers sourcing module from TC257 to TC259");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + PDS_URL);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2025 Female Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addSrceenShot("Season type is choosen", test, Capture);
			WaitforPage(4000);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(4000);

//			String viewType = "Source Config - Link Source to Colorway";
			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);
			WaitforPage(4000);

//			String colorWayName = "0WPK5-0003 *Test_copy*";
			lineSheetPage.filterProduct(colorWayName, test);
			System.out.println("Filtred By Colorway name");
			test.log(Status.INFO, "Filtred By Colorway name: " + colorWayName);
			addSrceenShot("Filtred By Colorway name", test, Capture);
			WaitforPage(4000);

//			List<String> vendorNames = Arrays.asList("ACCESORIOS GLOBALES, S.A.", "ACCESSORIES BAGS & COSMETICS");
			sourcingPage.selectVendors_FromList(vendorNames, test);
			test.log(Status.INFO, "Selected vendors from Vendor List");
			addSrceenShot("Selected vendors from Vendor List", test, Capture);
			WaitforPage(4000);

			sourcingPage.clickOnSaveBtn();
			System.out.println("Clicked On save button");
			test.log(Status.INFO, "Clicked On Save button");
			addSrceenShot("Clicked On Save button", test, Capture);
			WaitforPage(4000);

			// Verify the view page after saving the linesheet
			boolean isVendorListBlank = sourcingPage.isVendorListBlank();
			test.log(Status.PASS, "Verification: Vendor List is blank: " + isVendorListBlank);
			addSrceenShot("Vendor List is blank", test, Capture);
			WaitforPage(4000);

			// Verify success message
			sourcingPage.verifySuccessMessage(test);
			test.log(Status.PASS, "Verified 'Source to Colorway Association Status' set as 'Success'.");
			addSrceenShot("'Source to Colorway Association Status' set as 'Success'", test, Capture);
			
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
