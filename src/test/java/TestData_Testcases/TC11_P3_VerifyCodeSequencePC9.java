package TestData_Testcases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.ColorWayPage;
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

@Test(enabled = true, groups= {"P3_TC"})
public class TC11_P3_VerifyCodeSequencePC9 extends WMS_TestBase {

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
			setReport("TC11_TD_VerifyCodeSequencePC9");
		}
	}

	@Test(priority = 0, dataProvider = "TC11_TD_VerifyCodeSequencePC9", dataProviderClass = DataProviders.class)
	public void P0_TC_Product_004_Verify__Create_PC9_for_type_Levis_MensBottoms(String TestType, String season,
			String product, String colormenu, String colorsubmenu, String filtercolor, String productsegLSUSvalue,
			String productsegLSEvalue, String classification, String producttype, String hubofferedto,
			String linesheetview, String filtercolor2) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC11_TD_VerifyCodeSequencePC9 for type Levis Womeens accessories:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_168");

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

//          if colorsubmenu element is not there just keep blank string ----------------------			
			Colorwaypage.selectcolour(colormenu, colorsubmenu, filtercolor, test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addScreenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);

			Colorwaypage.MandatoryDetails(productsegLSUSvalue, productsegLSEvalue, classification, producttype, test);
			System.out.println("All mandatory fields filled");
			test.log(Status.INFO, "All mandatory fields filled");
			addScreenShot("All mandatory fields filled", test, Capture);
			WaitforPage(4000);

			Colorwaypage.colorwayseasonfield(hubofferedto, test);
			System.out.println("Colorway season fields selected and view product clicked");
			test.log(Status.INFO, "Colorway season fields selected and view product clicked");
			addScreenShot("Colorway season fields selected and view product clicked", test, Capture);

			Thread.sleep(5000);

			String code1 = Colorwaypage.getColorwayCode();
			System.out.println("Colorway Code is displayed");
			System.out.println("colorway Code: " + code1);
			test.log(Status.INFO, "Colorway Code displayed " + code1);
			addScreenShot("Colorway Code displayed", test, Capture);

			Thread.sleep(2000);

			Colorwaypage.Create_colorwayLink();
			System.out.println("Colorway page displayed");
			test.log(Status.INFO, "Colorway page displayed");
			addScreenShot("Colorway page displayed", test, Capture);

//          if colorsubmenu element is not there just keep blank string ----------------------			
			Colorwaypage.selectcolour(colormenu, colorsubmenu, filtercolor2, test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addScreenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);

			Colorwaypage.MandatoryDetails(productsegLSUSvalue, productsegLSEvalue, classification, producttype, test);
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

			String code2 = Colorwaypage.getColorwayCode();
			System.out.println("Colorway Code is displayed");
			System.out.println("colorway Code: " + code2);
			test.log(Status.INFO, "Colorway Code displayed " + code2);
			addScreenShot("Colorway Code displayed", test, Capture);

			ArrayList<String> elements = new ArrayList<String>();
			elements.add(code1);
			elements.add(code2);

			for (int i = 0; i < elements.size() - 1; i++) {
				int codeL1 = Integer.parseInt(elements.get(i).substring(6));
				int codeL2 = Integer.parseInt(elements.get(i + 1).substring(6));
				// Verify if the codes are in sequence

				if (codeL2 == codeL1 + 1) {

					System.out.println("Colorway codes are in sequence.");
					test.log(Status.PASS, "Colorway codes are in sequence: " + code1 + " -> " + code2);
					addScreenShot("Colorway codes are in sequence", test, Capture);

				} else {

					System.out.println("Colorway codes are not in sequence.");
					test.log(Status.FAIL, "Colorway codes are not in sequence: " + code1 + " -> " + code2);
					addScreenShot("Colorway codes are not in sequence", test, Capture);

				}

			}

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);

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
