package P2_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;

import org.openqa.selenium.JavascriptExecutor;
import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC135_P2_CreateColorRecordsforSundriesButton extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	MaterialPage materialPage;
	SeasonPage seasonPage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	
	/**
	 * Note: Ensure you are logged in as a Admin user before executing this test case
	 */

	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			materialPage = new MaterialPage(driver);
			seasonPage = new SeasonPage(driver);

			setReport("TC135_P2_Create_Color_Records_for_Sundry Color_Verification");
		}
	}

	@Test(priority = 0, dataProvider = "TC135_P2_CreateColorRecordsforSundriesButton", dataProviderClass = DataProviders.class)
    public void P2_TC135_CreateColorRecordsforSundriesButton(String TestType, String season, String actionValue, String colorType, String colorName, String lSAndCo_ColorName, String colorFamily, String colorStatus, String seasonFirstIntroduced, String imagePath) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC135_P2_Create_Color_Records_for_Sundry Color_Verification:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers P2 material module from TC135 and TC146");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + Administrator_URL);

			Thread.sleep(5000);
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("My seasons menu clicked", test, Capture);

//			String season = "Levi's S1 2024 Male Accessories";
			seasonPage.chooseMySeasonType(season);
			System.out.println("season type was choosen");
			test.log(Status.INFO, "season type was choosen : " + season);
			addSrceenShot("Season type was choosen", test, Capture);

			seasonPage.clickOnPalette();
			test.log(Status.INFO, "Clicked on palette button");
			addSrceenShot("Clicked on pallet button", test, Capture);
			Thread.sleep(4000);

			materialPage.selectColorsTab();
			System.out.println("Selected Color tab");
			test.log(Status.INFO, "Selected Color tab");
			addSrceenShot("Selected Color tab", test, Capture);
			WaitforPage(4000);
			
//			String actionvalue = "Create New Color";
			materialPage.action_DropDown(actionValue);
			test.log(Status.INFO, "Choosen 'Create New Color' from action menu");
			addSrceenShot("Choosen 'Create New Color' from action menu", test, Capture);
			WaitforPage(4000);

//			String colorType = "Sundry Color";
			materialPage.chooseColorType(colorType);
			System.out.println("Color type was choosen: ");
			test.log(Status.INFO, "Color type was choosen: ");
			addSrceenShot("Color type was choosen", test, Capture);
			WaitforPage(4000);

			
//			String colorName = "solidABC1234";
//			String lSAndCo_ColorName  = "new_test_colorName01";
//			String colorFamily = "Blues";
//			String colorStatus = "Active";
//			String seasonFirstIntroduced = "2024 Fall";

			materialPage.EnterValues(colorName, lSAndCo_ColorName, colorFamily, colorStatus, seasonFirstIntroduced, test);
			test.log(Status.INFO, "All the required values are filled");
			addSrceenShot("All the required values are filled", test, Capture);

//			String imagePath = "C:\\Users\\2240786\\Downloads\\levis_logo.jpg";
			materialPage.chooseColorThumbnail(imagePath);
			test.log(Status.INFO, "Color Thumbnail was selected: " + imagePath);
			addSrceenShot("Color Thumbnail was selected: " + imagePath, test, Capture);
			
			materialPage.clickOnCreate();
			test.log(Status.INFO, "Clicked On Create Button");
			addSrceenShot("Clicked On Create Button", test, Capture);
			WaitforPage(4000);
			
			// Verify the new color record is created
	        boolean isColorRecordCreated = materialPage.isColorRecordCreated(colorName, test);
	        Assert.assertTrue(isColorRecordCreated, "New color record is not created");
	        test.log(Status.PASS, "New color record is created");
	        
	        // Navigate to Color Details Page
	        materialPage.navigateToColorDetailsPage(colorName);
	        test.log(Status.INFO, "Navigated to Color Details Page");
	        addSrceenShot("Navigated to Color Details Page", test, Capture);
			WaitforPage(4000);
	        
	        // Verify the color staging ID
			boolean actualColorStagingID = materialPage.getColorStagingID();
			Assert.assertTrue(actualColorStagingID, "Color staging ID is not updated correctly");
			test.log(Status.PASS, "Color staging ID is updated correctly");
	        addSrceenShot("Color staging ID is updated correctly", test, Capture);

			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);

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