package P1_Testcases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC33_P1_Verify_Profit_Center_APD extends WMS_TestBase {
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
	private String global_URL;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Global_URL;
			LaunchSpecific_URL(global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);


			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC33_P1_Verify_Profit_Center_APD");
		}
	}

	@Test(priority = 0, dataProvider = "TC33_P1_Verify_Profit_Center_APD", dataProviderClass = DataProviders.class)
	public void P1_TC33_Verify_Profit_Center_APD(String TestType, String season, String linesheetview, String colorWay,
			String businessObject) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC33_P1_Verify_Profit_Center_APD:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers P1 Colorway module TC33");

			System.out.println("login to flex PLM application successfully ");
			test.log(Status.INFO, "login to flex PLM application successfully: URL -  " + global_URL);
			addSrceenShot("login successful", test, Capture);

			test.log(Status.INFO, "This test case covers P1 profit center module");

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2023 Male Accessories";
			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "Season selected: " + season);
			addSrceenShot("Season selected:" + season, test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(4000);

//			String linesheetview = "Adoption";
			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view changed", test, Capture);
			WaitforPage(5000);

//			String colorWay = "0WPGZ-0011 LUCEE TEST213";
			Colorwaypage.SelectColorway(colorWay, test);
			test.log(Status.INFO, "colorway selected is " + colorWay);
			addSrceenShot("colorway selected", test, Capture);
			WaitforPage(5000);

			Colorwaypage.editColorWay();
			test.log(Status.INFO, "Clicked On Edit Colorway from the Menu" + colorWay);
			addSrceenShot("Clicked On Edit Colorway from the Menu", test, Capture);
			WaitforPage(5000);

			// Store all profit center APD values in a list
			List<String> apdValues = Colorwaypage.getAPDValues(test);
			test.log(Status.INFO, "Stored APD values: " + String.join(", ", apdValues));
			addSrceenShot("Stored APD values", test, Capture);

			String Brand = Colorwaypage.getBrand();
			System.out.println("Brand Value: " + Brand);
			test.log(Status.INFO, "Brand Value: " + Brand);

			String ProductCategory = Colorwaypage.getProductCategory();
			System.out.println("Product Category Value: " + ProductCategory);
			test.log(Status.INFO, "Product Category Value: " + ProductCategory);

			String ConsumerPH = Colorwaypage.getConsumerPH();
			System.out.println("Consumer PH Value: " + ConsumerPH);
			test.log(Status.INFO, "Consumer Consumer PH Value: " + ConsumerPH);

			Colorwaypage.openNewTabAndNavigateToBusinessObject(global_URL, test);
			System.out.println("Opened new tab and navigated to the Business Object Library");
			test.log(Status.INFO, "Opened new tab and navigated to the Business Object Library");
			addSrceenShot("Opened new tab and navigated to the Business Object Library", test, Capture);
			WaitforPage(4000);

//			String businessObject = "Profit Center";
			Colorwaypage.selctBusinessObject(businessObject);
			System.out.println("Selected Business Object: " + businessObject);
			test.log(Status.INFO, "Selected Business Object: " + businessObject);
			addSrceenShot("Selected Business Object: ", test, Capture);
			WaitforPage(4000);

			Colorwaypage.fillProfitCenterDetails(Brand, ProductCategory, ConsumerPH, test);
			test.log(Status.INFO, "Filled in Profit Center details");
			addSrceenShot("Filled in Profit Center details", test, Capture);
			WaitforPage(4000);

			List<String> tableValues = Colorwaypage.getProfitCenterTableValues(test);
			test.log(Status.INFO, "Lookup Tables\\Profit Center table values: " + String.join(", ", tableValues));
			addSrceenShot("Lookup Tables\\Profit Center table values", test, Capture);

			boolean allValuesPresent = true;
			List<String> missingValues = new ArrayList<>();
			for (int i = 1; i < apdValues.size(); i++) {// Start from index 1 to skip the first empty value
				String normalizedAPDValue = apdValues.get(i);
				if (!normalizedAPDValue.contains("Levi's")) {
					normalizedAPDValue = normalizedAPDValue.replaceAll("Levi s", "Levi's");
				}
				if (!tableValues.contains(normalizedAPDValue)) {
					allValuesPresent = false;
					missingValues.add(apdValues.get(i));
				}
			}

			if (allValuesPresent) {
				test.log(Status.PASS, "All APD values are present in the Lookup Tables\\Profit Center table");
				test.log(Status.PASS, "Profit Center [APD] values are derived from Brand: " + Brand
						+ ", Product Category: " + ProductCategory + ", Consumer PH: " + ConsumerPH);
				addSrceenShot("All APD values are present in the Lookup Tables\\Profit Center table", test, Capture);
			} else {
				test.log(Status.FAIL, "Some APD values are missing in the Lookup Tables\\Profit Center table");
				addSrceenShot("Some APD values are missing in the Lookup Tables\\Profit Center table", test, Capture);
				test.log(Status.INFO, "Missing APD values: " + String.join(", ", missingValues));

			}
			WaitforPage(4000);

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
