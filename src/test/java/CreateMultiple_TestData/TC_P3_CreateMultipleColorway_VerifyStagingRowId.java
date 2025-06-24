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

import com.WMS_ApplicationPages.BusinessObjectPage;
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
public class TC_P3_CreateMultipleColorway_VerifyStagingRowId extends WMS_TestBase {
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
	BusinessObjectPage businessObjectPage;
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
			businessObjectPage = new BusinessObjectPage(driver);
			setReport(" TC_P3_CreateMultipleColorway_VerifyStagingRowId");
		}
	}

	@Test(priority = 0, dataProvider = "CreateMultipleColorway_VerifyStagingRowId", dataProviderClass = DataProviders.class)

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
			String businessObjectType= data[30];
			String actionType= data[31];
			String messageTableValue= data[32];
			String hierarchyValue= data[33];
			

			if (CloseBrowser) {
				test = extent.createTest(":::TC_P3_CreateMultipleColorway_VerifyStagingRowId:::");
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
				
				mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_BUSSINESS.menu());
				test.log(Status.INFO, "Clicked on Libraries menu");
				addSrceenShot("Clicked on Libraries menu", test, Capture);
				System.out.println("Clicked on Business Object");
				test.log(Status.INFO, "Clicked on Business Object");
				addSrceenShot("Clicked on Business Object", test, Capture);
				WaitforPage(4000);

				businessObjectPage.chooseBusinessObjectType(businessObjectType);
			    System.out.println("Business object type chosen: "+businessObjectType);
			    test.log(Status.INFO, "Business object type chosen: "+businessObjectType);
			    addSrceenShot("Business object type chosen", test, Capture);
			    WaitforPage(4000);


				businessObjectPage.chooseActionType(actionType);
			    System.out.println("Action type chosen: "+actionType);
			    test.log(Status.INFO, "Action type chosen: "+actionType);
			    addSrceenShot("Action type chosen", test, Capture);
			    WaitforPage(4000);
			    

			    businessObjectPage.enterCreatedDate(createddate);
			    System.out.println("Entered Created Date: " + createddate);
			    test.log(Status.INFO, "Entered Created Date: " + createddate);
			    addSrceenShot("Entered Created Date", test, Capture);
			    WaitforPage(4000);
			    

			    businessObjectPage.enterMessageTable(messageTableValue);
			    System.out.println("Entered Message Table: " + messageTableValue);
			    test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
			    addSrceenShot("Entered Created Date", test, Capture);
			    WaitforPage(4000);
			    

			    businessObjectPage.enterHierarchy(hierarchyValue);
			    System.out.println("Entered Hierarchy: " + hierarchyValue);
			    test.log(Status.INFO, "Entered Hierarchy: " + hierarchyValue);
			    addSrceenShot("Entered Hierarchy", test, Capture);
			    WaitforPage(4000);
			    
			    businessObjectPage.clickSearch();
			    System.out.println("Clicked on Search");
			    test.log(Status.INFO, "Clicked on Search");
			    addSrceenShot("Clicked on Search", test, Capture);
			    WaitforPage(4000);
			    
			 // Verify the staging row ID
			    businessObjectPage.verifyStagingRowId(test);
			    System.out.println("Validation successful for Staging row Id for Create color");
			    test.log(Status.INFO, "Validation successful for Staging row Id for Create color");
			    addSrceenShot("Validation successful for Staging row Id for Create color", test, Capture);
			    


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
