package P0_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC34_P0_Specifications_CarryoverAttributes extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	SpecificationPage specificationPage;
	MainMenuPage mainMenuPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	Colorway_page Colorwaypage;
	Measurements_Page MeasurementsPage;
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Admin_URL_STG);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			specificationPage = new SpecificationPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			Colorwaypage =new Colorway_page(driver);
			MeasurementsPage= new Measurements_Page(driver);
			setReport("TC34_P0 Verify carryover specifications Attributes ");
		}
	}

	@Test(priority = 0, dataProvider = "TC34_P0_Specifications_CarryoverAttributes", dataProviderClass = DataProviders.class)
	public void P0_TC34_CarryoverAttributes(String TestType, String season, String linesheetview,String filterproduct,
			String source,String specifications)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC34_P0 Verify carryover specifications Attributes:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers Specifications module from TC_257 to TC_262");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " +Admin_URL_STG);
			addScreenShot("login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			LineSheetEditPage.SeasonDropdown(season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addScreenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addScreenShot("Closed Left panel", test, Capture);
			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addScreenShot("Linesheet view changed", test, Capture);
			
			MeasurementsPage.filter_product(filterproduct, test);
			test.log(Status.INFO, "product selected"+filterproduct);
			addScreenShot("product selected", test, Capture);
			
			String components=specificationPage.CheckComponents_CarriedOver(test);
			System.out.println("Linesheet Components checked");
			test.log(Status.INFO, " Linesheet Components checked");
			addScreenShot("Linesheet Components checked", test, Capture);
			WaitforPage(4000);
			
			MeasurementsPage.selectSource(source,test);
			test.log(Status.INFO, "Selected source "+source);
			addScreenShot("Selected source "+source, test, Capture);
			System.out.println("Selected source "+source);

			MeasurementsPage.selectSpecifications(specifications,test);
			test.log(Status.INFO, "Selected specifications "+source);
			addScreenShot("Selected specifications "+source, test, Capture);
			System.out.println("Selected specifications "+source);
			
			specificationPage.NavigateToSpecifications_Summary();
			test.log(Status.INFO, "Navigated to specifications summary page ");
			addScreenShot("Navigated to specifications summary page  ", test, Capture);
			System.out.println("Navigated to specifications summary page  ");
			
			
			String productpage_components=specificationPage.Components_FromProductsDetails();
			test.log(Status.INFO, "Components from product specifications summary page is fetched ");
			addScreenShot("Components from product specifications summary page is fetched  ", test, Capture);
			System.out.println("Components from product specifications summary page is fetched  ");
			
			Thread.sleep(3000);
			test.log(Status.INFO, " Comparing components from both linesheet and summary page ");
			String[] linesheet_components=components.split(",");
			String[] detailspage_components=productpage_components.split(",");
			for (String comp1:linesheet_components) {
				for(String comp2:detailspage_components) {
					if(comp1.equals(comp2)) {
						System.out.println(comp1+" is present in both linesheet and specifications summary page");
						test.log(Status.PASS, comp1+" is present in both linesheet and specifications summary page");
					}
				}
			}
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
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
