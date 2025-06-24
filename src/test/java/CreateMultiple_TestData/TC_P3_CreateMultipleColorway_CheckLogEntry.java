package CreateMultiple_TestData;

import java.awt.AWTException;
import java.util.ArrayList;
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
import com.WMS_ApplicationPages.LogEntry_page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_CreateMultipleColorway_CheckLogEntry extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	LogEntry_page LogEntrypage;
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

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
			LogEntrypage = new LogEntry_page(driver);
			setReport("TC_P3_CreateMultipleColorway_CheckLogEntry");
		}
	}

	@Test(priority = 0, dataProvider = "CreateMultipleColorway_ExistingProducts", dataProviderClass = DataProviders.class)

	public void CreateMultipleColorway_Product(String[][] testData) throws Exception {

		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
//				String TestType = data[0];
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
			String consumergroup = data[12];
			String consumergroupext1 = data[13];
			String consumergroupext2 = data[14];
			String materialtype = data[15];
			String productmarketingname = data[16];
			String rigidindicator = data[17];
			String productlifecyclegroup = data[18];
			String lastseasonoffered = data[19];
			String productpricepositioning = data[20];
			String createddate = data[21];
			String filtermaterial = data[22];
			String merchfabrictype = data[23];
			String destroysampleInd = data[24];
			String collectionType = data[25];
			String capsule = data[26];
			String sizeGridCode = data[27];
			String currentPlannedLifecycle = data[28];
			String primaryfabric = data[29];
			String LogEntryObject = data[30];
			String event = data[31];

			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_CreateMultipleColorway_CheckLogEntry:::");
			}
			CloseBrowser = false;
			// ...............................browser launched time starts
			long startTime = System.nanoTime();

			try {

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully" + URL);

				dashboardPage.openLeftPanel();
				test.log(Status.INFO, "Left panel opened");
				addSrceenShot("Left panel opened", test, Capture);

				mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
				test.log(Status.INFO, "My seasons menu clicked");
				addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

				Colorwaypage.SeasonDropdown(season, test);
				test.log(Status.INFO, "season selected: " + season);
				addSrceenShot("season selected", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addSrceenShot("Clicked on Line Sheets", test, Capture);

				WaitforPage(5000);
				LineSheetEditPage.filter_View_Change(linesheetview, test);
				test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
				addSrceenShot("Linesheet view is " + linesheetview, test, Capture);

				Colorwaypage.SelectProduct(product, test);
				test.log(Status.INFO, "product selected");
				addSrceenShot("product selected", test, Capture);

				Colorwaypage.Create_colorwayLink();
				System.out.println("Colorway page displayed");
				test.log(Status.INFO, "Colorway page displayed");
				addSrceenShot("Colorway page displayed", test, Capture);

//          if colorsubmenu element is not there just keep blank string ----------------------			
				String thumbnail = Colorwaypage.selectcolour(colormenu, colorsubmenu, filtercolor, test);
				System.out.println("color/look Selected ");
				test.log(Status.INFO, " color/look Selected");
				addSrceenShot("color/look Selected ", test, Capture);
				WaitforPage(4000);

				Colorwaypage.MandatoryColorwayDetails_ForLSESetUP(productsegLSUSvalue, productsegLSEvalue,
						classification, producttype, consumergroup, consumergroupext1, consumergroupext2, materialtype,
						productmarketingname, rigidindicator, merchfabrictype, destroysampleInd, collectionType,
						capsule, test);
				System.out.println("All mandatory fields filled");
				test.log(Status.INFO, "All mandatory fields filled");
				addSrceenShot("All mandatory fields filled", test, Capture);
				WaitforPage(4000);

				Colorwaypage.MandatoryFields_colorwaySeason_SetUpLSE(hubofferedto, productlifecyclegroup,
						lastseasonoffered, productpricepositioning, createddate, filtermaterial, sizeGridCode,
						currentPlannedLifecycle, primaryfabric, test);
				System.out.println("Colorway season fields selected and view product clicked");
				test.log(Status.INFO, "Colorway season fields selected and view product clicked");
				addSrceenShot("Colorway season fields selected and view product clicked", test, Capture);

				Thread.sleep(2000);
				Colorwaypage.validateColorway_creation(filtercolor, test);
				System.out.println("Validated Colorway creation");
				test.log(Status.PASS, "Validated Colorway creation");
				addSrceenShot("Validated Colorway creation", test, Capture);
				
				
				
				Colorwaypage.Navigate_to_firstTab();
				System.out.println("Navigated to linesheet page");
				test.log(Status.INFO, "Navigated to linesheet page");
				addSrceenShot("Navigated to linesheet page", test, Capture);
				
				mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_LOG_ENTRY.menu());
				test.log(Status.INFO, "Clicked on Libraries menu");
				addSrceenShot("Clicked on Libraries menu", test, Capture);

				Thread.sleep(2000);
				
				LogEntrypage.select_LogEntryObject(LogEntryObject,test);
				System.out.println("Log Entry Object is selected ");
				test.log(Status.INFO, "Log Entry Object is selected");
				addSrceenShot("Log Entry Object is selected", test, Capture);
				Thread.sleep(2000);
				
				
				LogEntrypage.Add_criteria(event,createddate,test);
				System.out.println("Criteria is added ");
				test.log(Status.INFO, "Criteria is added");
				addSrceenShot("Criteria is added", test, Capture);
				Thread.sleep(2000);
				
				LogEntrypage.clickedFirst_viewdetails();
				System.out.println("view details page is opened ");
				test.log(Status.INFO, "view details page is opened ");
				
				Thread.sleep(3000);
				
				LogEntrypage.validate_Logdetails(event,LogEntryObject,test);
				System.out.println("Validation successful for Log Entry details ");
				test.log(Status.PASS, "Validation successful for Log Entry details");
				addSrceenShot("Validation successful for Log Entry details", test, Capture);

				 if (i == testData.length - 1) {
						// Last iteration, perform logout

						dashboardPage.Logout();
						System.out.println("Logout successful");
						test.log(Status.INFO, "Logout successful");
						addSrceenShot("Logout successful", test, Capture);
						
					} else {
						
						ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
					    driver.switchTo().window(tabs.get(0));
					    driver.switchTo().window(tabs.get(1));
					    driver.close(); // Close the second tab
					    driver.switchTo().window(tabs.get(0));
						// Not the last iteration, refresh the browser
						driver.manage().deleteAllCookies();
						driver.navigate().refresh();		
					}

			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
			test.log(Status.FAIL, "Test case failed due to application slowness");
			throw e;
			}
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
