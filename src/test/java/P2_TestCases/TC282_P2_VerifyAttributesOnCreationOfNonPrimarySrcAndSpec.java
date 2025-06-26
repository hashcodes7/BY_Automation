package P2_TestCases;

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
import org.testng.Assert;
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
import com.WMS_ApplicationPages.SourcingPage;
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC282_P2_VerifyAttributesOnCreationOfNonPrimarySrcAndSpec extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	SourcingPage sourcingPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;

	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;
	SpecificationPage specificationPage;

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
			productPage = new ProductPage(driver);
			sourcingPage = new SourcingPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			materialPage = new MaterialPage(driver);
			specificationPage = new SpecificationPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC282_P2_Verify attributes on  creation of  non Primary Source  and Specification");
		}
	}

	@Test(priority = 0, dataProvider = "TC282_P2_VerifyAttributesOnCreationOfNonPrimarySrcAndSpec", dataProviderClass = DataProviders.class)
	public void P2_TC282_VerifyAttributesOnCreationOfNonPrimarySrcAndSpec(String TestType, String season,
			String productName, String vendor) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC282_P2_Verify attributes on  creation of  non Primary Source  and Specification:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			test.log(Status.INFO, "This test case covers P2 Specfications module from 282 to 288");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + PDS_URL);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");
			addScreenShot("login successful", test, Capture);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2025 Female Accessories";
			mainMenuPage.chooseMySeasonType(season);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + season);
			addScreenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);

//			String productName = "1709LFA2";
			lineSheetPage.filterProductByName(productName, test);
			System.out.println("Clicked on product name");
			test.log(Status.INFO, "Clicked on product name: " + productName);
			addScreenShot("Clicked on product name", test, Capture);

			Assert.assertTrue(productPage.isPC5DetailsPageDisplayed(test), "PC5 Details Page is not displayed.");
			System.out.println("PC5 Details Page is displayed");
			test.log(Status.PASS, "PC5 Details Page is displayed: " + productName);
			addScreenShot("PC5 Details Page is displayed", test, Capture);

			productPage.selectSourcingTab();
			System.out.println("Selected Sourcing tab");
			test.log(Status.INFO, "Selected Sourcing tab");
			addScreenShot("Selected Sourcing tab", test, Capture);
			WaitforPage(4000);

			productPage.clickOnSummary();
			System.out.println("Clicked on Summary");
			test.log(Status.INFO, "Clicked on Summary");
			addScreenShot("Clicked on Summary", test, Capture);
			WaitforPage(4000);

			sourcingPage.selectCreateSourcingConfiguration();
			test.log(Status.INFO, "Navigated to Create Sourcing Configuration From Actions Drop Down");
			addScreenShot("Navigated to Create Sourcing Configuration From Actions Drop Down", test, Capture);

			productPage.clickOnVendorLink();
			test.log(Status.INFO, "Clicked On Vendor Hyperlink");
			addScreenShot("Clicked On Vendor Hyperlink", test, Capture);

//			String vendor = "BEALE INTL 4755 US";
			productPage.selectVendor(vendor, test);
			test.log(Status.INFO, "Selected Vendor: " + vendor);
			addScreenShot("Selected Vendor", test, Capture);

			productPage.clickOnSave();
			test.log(Status.INFO, "Clicked On Save Button ");
			addScreenShot("Clicked On save Button", test, Capture);

//			productPage.selectSourceFromDropDown(vendor, test);
//			System.out.println("selected Source From The Sourcing Drop Down");
//			test.log(Status.INFO, "selected Source From The Sourcing Drop Down" + vendor);
//			addScreenShot("selected Source From The Sourcing Drop Down", test, Capture);

			String sourceName = sourcingPage.getSourceName();
			test.log(Status.INFO, "Created Source: " + sourceName);
			System.out.println("Created Source: " + sourceName);

			productPage.selectSourceFromDropDown(sourceName, test);
			System.out.println("selected Source From The Sourcing Drop Down: " + sourceName);
			test.log(Status.INFO, "selected Source From The Sourcing Drop Down: " + sourceName);
			addScreenShot("selected Source From The Sourcing Drop Down", test, Capture);

			specificationPage.nonPrimarySourcingValidations(test);
			test.log(Status.PASS, "verified the non primary source attributes ");
			addScreenShot("non primary source attributes verified", test, Capture);

			String specificationName = sourcingPage.getSpecificationName();
			test.log(Status.INFO, "Created Specification: " + specificationName);
			System.out.println("Created Specification: " + specificationName);

			specificationPage.specification_Summary(test);
			test.log(Status.INFO, "specification summary page opens up");
			addScreenShot("opened specification summary page", test, Capture);

			specificationPage.selectSpecificationFromDropDown(specificationName, test);
			System.out.println("selected Specification From The Specification Drop Down: " + specificationName);
			test.log(Status.INFO, "selected Specification From The Specification Drop Down: " + specificationName);
			addScreenShot("selected Specification From The Specification Drop Down", test, Capture);

			specificationPage.nonPrimaryspecificationValidations(test);
			test.log(Status.PASS, "verified the non primary specification attributes ");
			addScreenShot("primary specification non attributes verified", test, Capture);

			WaitforPage(4000);
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

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