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
public class TC260_P2_RemoveSourceToColorwayAssociationFromLinesheet extends WMS_TestBase {
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

			setReport("TC260_P2_Validate Removal of Source to Colorway Association from Linesheet");
		}
	}

	@Test(priority = 0, dataProvider = "TC260_P2_RemoveSourceToColorwayAssociationFromLinesheet", dataProviderClass = DataProviders.class)
	public void P2_TC260_RemoveSourceToColorwayAssociationFromLinesheet(String TestType, String season, String viewType,
			String colorWayName) throws Exception {
		if (CloseBrowser) {
			test = extent
					.createTest(":::TC260_P2_Validate Removal of Source to Colorway Association from Linesheet:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P2 Sourcing module 260 to 263");

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

//			String viewType = "Source Config - View/Edit/Remove Source to Colorway Link";
			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.PASS, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);

//			String colorWayName = "0WPNU-0000 *Test_copy*";
			lineSheetPage.filterProduct(colorWayName, test);
			System.out.println("Filtered By Colorway Name");
			test.log(Status.INFO, "Filtered By Col orway Name: " + colorWayName);
			addSrceenShot("Filtered By Colorway Name: ", test, Capture);

			sourcingPage.SelectColorway(test);
			test.log(Status.INFO, "colorway selected");
			addSrceenShot("colorway selected", test, Capture);

			sourcingPage.SelectIncludeAllSources(test);
			test.log(Status.INFO, "Include All Sources is selected");
			addSrceenShot("Include All Sources selected", test, Capture);

			sourcingPage.clickOnApply(test);
			test.log(Status.INFO, "clicked on apply button");
			addSrceenShot("clicked on apply button", test, Capture);

			String productName = sourcingPage.getProduct_Name(test);
			test.log(Status.INFO, "Product Name: " + productName);
			System.out.println("Product Name: " + productName);
			addSrceenShot("Product Name: " + productName, test, Capture);

			String sourceName = sourcingPage.setDelinkSourceToColorwayToYes(test);
			if (sourceName.isEmpty()) {
			    test.log(Status.FAIL, "Failed to set 'Delink Source to Colorway' to Yes");
			    addSrceenShot("Failed to set 'Delink Source to Colorway' to Yes", test, Capture);
			} else {
			    test.log(Status.PASS, "Set 'Delink Source to Colorway' to Yes");
			    addSrceenShot("'Delink Source to Colorway' set to Yes", test, Capture);
			}
			
			boolean isDlinkSourceVisible = sourcingPage.isDlinkSourceVisible(sourceName);
			Assert.assertFalse(isDlinkSourceVisible,
					"source -Colorway assiciation not visibled under 'View/Edit/Remove Source to Colorway' view.");
			test.log(Status.PASS,
					"source -Colorway assiciation not visibled under 'View/Edit/Remove Source to Colorway' view.");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");
			Thread.sleep(2000);

			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addSrceenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.INFO, "PC5 Details Page is displayed: " + productName);
			addSrceenShot("PC5 Details Page is displayed", test, Capture);

			productPage.selectSourceFromDropDown(sourceName, test);
			System.out.println("selected Source From The Sourcing Drop Down");
			test.log(Status.INFO, "selected Source From The Sourcing Drop Down" + sourceName);
			addSrceenShot("selected Source From The Sourcing Drop Down", test, Capture);

			// Verify if the colorway is appearing under 'Colorway' dropdown list
			boolean isColorwayVisible = sourcingPage.isColorwayVisibleUnderDropdown(colorWayName);
			Assert.assertTrue(isColorwayVisible, "The colorway is still visible under 'Colorway' dropdown list.");
			test.log(Status.PASS, "Validation passed: The colorway is not visible under 'Colorway' dropdown list.");

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