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
public class TC302_P2_VerifyTechPackAndAddComponentsOptions extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	SourcingPage sourcingPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	SpecificationPage specificationPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Garment Developer user before executing this test case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(GarmentDeveloper_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			sourcingPage = new SourcingPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			specificationPage = new SpecificationPage(driver);
			materialPage = new MaterialPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC302_P2_Verify Tech Pack and Add Existing Components Options in Actions Drop Down");
		}
	}

	 @Test(priority = 0, dataProvider = "TC300_P2_VerifyTechPackAndAddComponentsOptions", dataProviderClass = DataProviders.class)
	    public void P2_TC302_VerifyTechPackAndAddComponentsOptions(String TestType, String season, String productName, String specificationName) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(
					":::TC302_P2_Verify Tech Pack and Add Existing Components Options in Actions Drop Down:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			test.log(Status.INFO, "This test case covers P2 Specification module from 302 to 305");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + GarmentDeveloper_URL);

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

			specificationPage.specification_Summary(test);
			System.out.println("specification summary page opens up");
			test.log(Status.INFO, "specification summary page opens up");
			addScreenShot("specification summary page opens up", test, Capture);
			WaitforPage(4000);

//			String specificationName = "S1 2025 - 0WP6Y - 2706LFA - 5160";
			specificationPage.selectSpecificationFromDropDown(specificationName, test);
			System.out.println("Selected Specification from drop down: " + specificationName);
            test.log(Status.INFO, "Selected Specification from drop down: " + specificationName);
            addScreenShot("Selected Specification from drop down", test, Capture);
            
            boolean isGenerateTechPackEnabled = specificationPage.isGenerateTechPackEnabled(test);
            boolean isAddExistingComponentsEnabled = specificationPage.isAddExistingComponentsEnabled(test);

            if (isGenerateTechPackEnabled && isAddExistingComponentsEnabled) {
                test.log(Status.PASS, "Verified: 'Generate Tech Pack' and 'Add Existing Components' options are enabled in Actions Drop Down.");
                addScreenShot("'Generate Tech Pack' and 'Add Existing Components' options are enabled", test, Capture);
            } else {
                test.log(Status.FAIL, "'Generate Tech Pack' and/or 'Add Existing Components' options are not enabled in Actions Drop Down.");
                addScreenShot("'Generate Tech Pack' and/or 'Add Existing Components' options are not enabled", test, Capture);
            }

            WaitforPage(4000);
            
            WaitforPage(4000);
            dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
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

