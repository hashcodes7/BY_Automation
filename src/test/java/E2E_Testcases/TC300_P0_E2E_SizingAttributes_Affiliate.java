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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC300_P0_E2E_SizingAttributes_Affiliate extends WMS_TestBase {

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
	private String affiliate_URL;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	/**
	 * Note: Ensure you are logged in as a Affiliate user before executing this test
	 * case
	 */
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			affiliate_URL = AFF_URL_STG;
			LaunchSpecific_URL(affiliate_URL);
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

			setReport("TC300_E2E_AffiliateSizingAttributesUpdateVerification");
		}
	}

	@Test(priority = 0, dataProvider = "sizingAttributesAffiliateData", dataProviderClass = DataProviders.class)
	public void P0_TC05_E2E_SizingAttributes_Affiliate(String TestType, String mySeasonType, String productName,
			String viewType, String globalVaue, String localHubValue, String affiliateValue, String newSelectedSizesLH)
			throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC300_E2E_AffiliateSizingAttributesUpdateVerification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers E2E module 300");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + affiliate_URL);
			addScreenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String mySeasonType = "Levi's S1 2024 Female Accessories";
			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addScreenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

//			String viewType = "Size Selection";
			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addScreenShot("View type is choosen", test, Capture);

//			String productName = "Test_Product1";
			lineSheetPage.filterProduct(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addScreenShot("Clicked on product name", test, Capture);

//			String globalVaue = "Global";
			lineSheetPage.selectSeasonGroupAsGlobal(globalVaue, test);
			System.out.println("SeasonGroup As Global choosen");
			test.log(Status.INFO, "selected SeasonGroup As Global choosen: " + globalVaue);
			addScreenShot("selected SeasonGroup As Global choosen", test, Capture);

//			String localHubValue = "San Francisco ";
			lineSheetPage.selectlocalHubdropdownValue(localHubValue, test);
			System.out.println("localHubdropdownValue choosen");
			test.log(Status.INFO, "localHubdropdownValue choosen: " + localHubValue);
			addScreenShot("localHubdropdownValue choosen", test, Capture);

//			String affiliateValue = "US Wholesale";
			lineSheetPage.selectAffiliateAaccordingToTheLocalHub_FromAffiliateDropDown(affiliateValue);
			System.out.println(
					"Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub");
			test.log(Status.INFO,
					"Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub: "
							+ affiliateValue);
			addScreenShot("Selected the respective Affiliate from the  Affiliate dropdown according the the Local Hub",
					test, Capture);

//			String newSelectedSizesLH = "11:S, 13:S, 3:M, 4:S, 23M";
			lineSheetPage.editSelectedSizesAFF(newSelectedSizesLH, test);
			System.out.println("Updated 'Selected sizes-AFF'");
			test.log(Status.PASS, "Updated 'Selected sizes-AFF'");
			addScreenShot("Updated 'Selected sizes-AFF'", test, Capture);

			lineSheetPage.editSelectedSizesAFFLocked(test);
			System.out.println("Updated 'Selected sizes AFF Locked?'");
			test.log(Status.PASS, "Edited 'Selected sizes AFF Locked?'");
			addScreenShot("Edited 'Selected sizes AFF Locked?'", test, Capture);
			test.log(Status.PASS, "Sizing Attributes are Updated Successfully For Affiliate");
			WaitforPage(4000);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			// Note: The "Logout" dropdown menu is not visible for Affiliate users.
			// To make the "Logout" option visible, reduce the screen size by 10%.
			// This can be achieved by pressing "Control" and "-" keys together.
			ReduceScreenSizeBy10Percent();
			Thread.sleep(2000);

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
