package P2_TestCases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import com.WMS_ApplicationPages.ProductDetailsPage;
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC330_P2_VendorPortalOnlyViewAccessToTechpackgenerationPage extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	MaterialPage materialPage;
	Color_Page color_Page;
	VendorPortalPage vendorPage;
	LineSheetPage lineSheetPage;
	ProductDetailsPage productDetailsPage;
	SpecificationPage specificationPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Vendor user before executing this test case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(VendorPortal_URl);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			materialPage = new MaterialPage(driver);
			color_Page = new Color_Page(driver);
			vendorPage = new VendorPortalPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			specificationPage = new SpecificationPage(driver);

			setReport("TC330_P2_Verify Vendor Portal Only View Access To Techpack generation Page");
		}
	}

	@Test(priority = 0, dataProvider = "TC330_P2_VendorPortalOnlyViewAccessToTechpackgenerationPage", dataProviderClass = DataProviders.class)
	public void P2_TC330_VendorPortalOnlyViewAccessToTechpackgenerationPage(String TestType, String season,
			String productName, String colourWayName, String specificationName)
			throws Exception {
		if (CloseBrowser) {
			test = extent
					.createTest(":::TC330_P2_Verify Vendor Portal Only View Access To Techpack generation Page:::");
		}

		CloseBrowser = false;
		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P2 Vendor Portal module from TC330 to TC331");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: URL - " + VendorPortal_URl);
			addSrceenShot("login successful", test, Capture);

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

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "12th Aug PC9";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productDetailsPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed");
			addSrceenShot("PC5 Details Page is displayed", test, Capture);

//			String colourWayName = "0WPTE-0000 Color_Test_Acc_25";
			productDetailsPage.selectColorwayFromMenu(colourWayName, test);
			System.out.println("Clicked on Colorway From Menu");
			test.log(Status.INFO, "Clicked on Colorway From Menu: " + colourWayName);
			addSrceenShot("Clicked on Colorway From Menu", test, Capture);

			specificationPage.specification_Summary(test);
			System.out.println("specification summary page opens up");
			test.log(Status.INFO, "specification summary page opens up");
			addSrceenShot("specification summary page opens up", test, Capture);
			WaitforPage(4000);

//			String specificationName = "S1 2025 - 0WPTE - 12th Aug PC9 - 5159";
			specificationPage.selectSpecificationFromDropDown(specificationName, test);
			System.out.println("Selected Specification from drop down: " + specificationName);
			test.log(Status.INFO, "Selected Specification from drop down: " + specificationName);
			addSrceenShot("Selected Specification from drop down", test, Capture);
			WaitforPage(4000);

			vendorPage.clickGenerateTechpack();
			System.out.println("Clicked on Generate Techpack from the Specification Actions menu");
			test.log(Status.INFO, "Clicked on Generate Techpack from the Specification Actions menu");
			addSrceenShot("Clicked on Generate Techpack from the Specification Actions menu", test, Capture);

			boolean isDisplayed = vendorPage.verifyTechpackgenerationPage();
			if (isDisplayed) {
				test.log(Status.PASS, "Techpackgeneration page is displayed.");
				addSrceenShot("Techpackgeneration page is displayed", test, Capture);
			} else {
				test.log(Status.FAIL, "Techpackgeneration page is not displayed.");
				addSrceenShot("Techpackgeneration page is not displayed", test, Capture);
			}

			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(1));

			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
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
