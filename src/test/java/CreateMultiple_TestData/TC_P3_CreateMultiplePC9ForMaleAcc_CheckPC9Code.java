package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "P3_TC" })
public class TC_P3_CreateMultiplePC9ForMaleAcc_CheckPC9Code extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Global user before executing test case
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC_P3_CreateMultiplePC9ForMaleAccessories_CheckPC9Code");
		}
	}

	@Test(priority = 0, dataProvider = "TC13_P3_CreatePC9ForMaleAcc_CheckPC9Code", dataProviderClass = DataProviders.class)
	public void P0_TC_Product_004_Verify__Create_PC9_for_type_Levis_MensBottoms(String[][] testData)
			throws Exception {

		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
			String season = data[1];
			String product = data[2];
			String colormenu = data[3];
			String colorsubmenu = data[4];
			String filtercolor = data[5];
			String productsegLSUSvalue = data[6];
			String productsegLSEvalue = data[7];
			String classification = data[8];
			String producttype = data[9];
			String hubofferedto = data[10];
			String linesheetview = data[11];

			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_CreateMultiplePC9ForMaleAccessories_CheckPC9Code:::");
			}
			CloseBrowser = false;
			// ...............................browser launched time starts
			long startTime = System.nanoTime();

			try {
				test.log(Status.INFO, "This tescase covers TC_170");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully" + Administrator_URL);

				dashboardPage.openLeftPanel();
				test.log(Status.INFO, "Left panel opened");
				addScreenShot("Left panel opened", test, Capture);

				mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
				test.log(Status.INFO, "My seasons menu clicked");
				addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

				Colorwaypage.SeasonDropdown(season, test);
				test.log(Status.INFO, "season selected: " + season);
				addScreenShot("season selected", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addScreenShot("Clicked on Line Sheets", test, Capture);

				WaitforPage(5000);
				LineSheetEditPage.filter_View_Change(linesheetview, test);
				test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
				addScreenShot("Linesheet view is " + linesheetview, test, Capture);

				Colorwaypage.SelectProduct(product, test);
				test.log(Status.INFO, "product selected");
				addScreenShot("product selected", test, Capture);

				Colorwaypage.Create_colorwayLink();
				System.out.println("Colorway page displayed");
				test.log(Status.INFO, "Colorway page displayed");
				addScreenShot("Colorway page displayed", test, Capture);

				Colorwaypage.select_colour(colormenu, colorsubmenu, filtercolor, test);
				System.out.println("color/look Selected ");
				test.log(Status.INFO, " color/look Selected");
				addScreenShot("color/look Selected ", test, Capture);
				WaitforPage(4000);

				Colorwaypage.MandatoryDetails(productsegLSUSvalue, productsegLSEvalue, classification, producttype,
						test);
				System.out.println("All mandatory fields filled");
				test.log(Status.INFO, "All mandatory fields filled");
				addScreenShot("All mandatory fields filled", test, Capture);
				WaitforPage(4000);

				Colorwaypage.colorwayseasonfield(hubofferedto, test);
				System.out.println("Colorway season fields selected and view product clicked");
				test.log(Status.INFO, "Colorway season fields selected and view product clicked");
				addScreenShot("Colorway season fields selected and view product clicked", test, Capture);

				Thread.sleep(2000);
				Colorwaypage.validateColorway_creation(filtercolor, test);
				System.out.println("Validated Colorway creation");
				test.log(Status.PASS, "Validated Colorway creation");
				addScreenShot("Validated Colorway creation", test, Capture);

				String PC9Code = Colorwaypage.getColorwayCode();
				if (!PC9Code.isEmpty() && !PC9Code.equals("0")) {
					System.out.println("colorway Code: " + PC9Code);
					test.log(Status.PASS, "Colorway Code displayed " + PC9Code);
					addScreenShot("Colorway Code displayed", test, Capture);
				} else {
					System.out.println("Colorway Code Is not displayed");
					test.log(Status.FAIL, "Colorway Code Is not displayed");
					addScreenShot("Colorway Code not displayed", test, Capture);
				}

				if (i == testData.length - 1) {
					// Last iteration, perform logout
					dashboardPage.closeLeftPanel();
					System.out.println("Clicked on close Left plane");
					test.log(Status.INFO, "Clicked on close Left plane");
					addScreenShot("Clicked on close Left plane", test, Capture);

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addScreenShot("Logout successful", test, Capture);
					
				} else {
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();
				}

			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;
			}
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
