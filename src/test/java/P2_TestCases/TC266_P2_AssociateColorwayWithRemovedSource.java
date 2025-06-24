package P2_TestCases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.SourcingPage;
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;



import org.openqa.selenium.JavascriptExecutor;
import resources.DataProviders;


@Test(enabled = true, groups= {"P2_TC"})
public class TC266_P2_AssociateColorwayWithRemovedSource extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	SpecificationPage specificationPage;
	MainMenuPage mainMenuPage;
	SourcingPage sourcingPage;

	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	/**
	 * Note: Ensure you are logged in as a Admin user before executing this test
	 * case because PDS user doesn't have Dlink sourece - colorway? header
	 */
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			specificationPage = new SpecificationPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			sourcingPage = new SourcingPage(driver);

			setReport("TC266_P2_Validate Remove source from season and  then associate colorway with removed source");
		}
	}

	@Test(priority = 0, dataProvider = "TC266_P2_AssociateColorwayWithRemovedSource", dataProviderClass = DataProviders.class)
	public void P2_TC266_AssociateColorwayWithRemovedSource(String TestType, String season, String productName,
			String sourceName, String viewType1, String viewType2) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC266_P2_Validate Remove source from season and  then associate colorway with removed source:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P2 Sourcing module 266 to 269");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + Administrator_URL);
			addSrceenShot("login successful", test, Capture);

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

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "DU_Test04";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(lineSheetPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed");
			addSrceenShot("PC5 Details Page is displayed", test, Capture);
			Thread.sleep(5000);

//			String sourceName = "ACCESSORIES BAGS & COSMETICS";
			productPage.selectSourceFromDropDown(sourceName, test);
			System.out.println("selected Source From The Sourcing Drop Down");
			test.log(Status.INFO, "selected Source From The Sourcing Drop Down" + sourceName);
			addSrceenShot("selected Source From The Sourcing Drop Down", test, Capture);

			productPage.selectSourcingTab();
			System.out.println("Selected Sourcing tab");
			test.log(Status.INFO, "Selected Sourcing tab");
			addSrceenShot("Selected Sourcing tab", test, Capture);
			WaitforPage(4000);

			productPage.clickOnSummary();
			System.out.println("Clicked on Samples");
			test.log(Status.INFO, "Clicked on Samples");
			addSrceenShot("Clicked on Samples", test, Capture);
			WaitforPage(4000);

			sourcingPage.removeSourceFromSeason(test);
			test.log(Status.INFO, "removed source from season");
			addSrceenShot("removed source from season", test, Capture);

			// Validation
			boolean isSourceRemoved = sourcingPage.isSourceRemovedFromDropDown(sourceName);
			Assert.assertTrue(isSourceRemoved, "The removed source is still visible on Source config drop down.");
			test.log(Status.PASS, "Validation passed: The removed source is not visible on Source config drop down.");

			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
			driver.switchTo().window(tabs.get(0));

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//			String viewType1 = "Source Config - View/Edit/Remove Source to Colorway Link";
			lineSheetPage.selectViewDropdown(viewType1);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType1);
			addSrceenShot("View type is choosen", test, Capture);

//			String productName = "0608LFA234";
			lineSheetPage.filterProduct(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			sourcingPage.SelectColorway(test);
			test.log(Status.INFO, "colorway selected");
			addSrceenShot("colorway selected", test, Capture);

			sourcingPage.SelectIncludeAllSources(test);
			test.log(Status.INFO, "Include All Sources is selected");
			addSrceenShot("Include All Sources selected", test, Capture);

			sourcingPage.clickOnApply(test);
			addSrceenShot("clicked on apply button", test, Capture);

			boolean isRemovedSourceVisible = sourcingPage.isRemovedSourceVisible(sourceName);
			Assert.assertFalse(isRemovedSourceVisible,
					"The removed source is still visible under 'View/Edit/Remove Source to Colorway' view.");
			test.log(Status.PASS,
					"Validation passed: The removed source is not visible under 'View/Edit/Remove Source to Colorway' view.");

//			String viewType2 = "Source Config - Link Source to Colorway";
			lineSheetPage.selectViewDropdown(viewType2);
			System.out.println("View type is choosen");
			test.log(Status.PASS, "View type is choosen: " + viewType2);
			addSrceenShot("View type is choosen", test, Capture);

			// Link the removed source in "Link Source to Colorway" view
			sourcingPage.linkSourceToColorway(sourceName, test);
			test.log(Status.PASS, "Validation passed: Linked the removed source to Colorway");
			addSrceenShot("Linked the removed source to Colorway", test, Capture);

			// Verify success message
			sourcingPage.verifySuccessMessage(test);
			test.log(Status.PASS, "Verified success message");
			addSrceenShot("Verified success message", test, Capture);

			lineSheetPage.selectViewDropdown(viewType1);
			System.out.println("View type is choosen");
			test.log(Status.PASS, "View type is choosen: " + viewType1);
			addSrceenShot("View type is choosen", test, Capture);

			lineSheetPage.filterProduct(productName, test);
			System.out.println("Filtered by product name");
			test.log(Status.INFO, "Filtered by product name: " + productName);
			addSrceenShot("Filtered by product name", test, Capture);

//			 Check if the source is associated with the colorway/product
			boolean isSourceLinked = sourcingPage.isSourceLinkedToColorway(sourceName, test);
			Assert.assertTrue(isSourceLinked, "The source is not associated with the colorway/product.");
			test.log(Status.PASS, "Validation passed: The source is associated with the colorway/product.");

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