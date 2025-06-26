package TestData_Testcases;

import java.awt.AWTException;
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
public class TC19_P3_Staging_CreateColorway_VerifyStagingId extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	LogEntry_page LogEntrypage ;
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
			LaunchSpecific_URL(Admin_URL_STG);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			LogEntrypage=new LogEntry_page(driver);
			businessObjectPage = new BusinessObjectPage(driver);
			setReport(" TC19_P3_Staging_CreateColorway_VerifyStagingId");
		}
	}

	@Test(priority = 0,dataProvider = "TC19_P3_Staging_CreateColorway_VerifyStagingId", dataProviderClass = DataProviders.class)
	public void P3_TC19_CreateColorway_VerifyStagingId(String TestType,String season,String product,String colormenu, 
			String colorsubmenu ,String filtercolor,String productsegLSUSvalue,String productsegLSEvalue,String classification,String producttype,String hubofferedto,
			String linesheetview,String consumergroup,String consumergroupext1,String consumergroupext2,String materialtype,String productmarketingname,String rigidindicator,
			String productlifecyclegroup,String lastseasonoffered,String productpricepositioning,String createddate,String filtermaterial,String merchfabrictype,
			String destroysampleInd,String collectionType,String capsule,String sizeGridCode,String currentPlannedLifecycle,String primaryfabric,String businessObjectType,
			String actionType,String messageTableValue,String hierarchyValue) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC19_P3_Staging_CreateColorway_VerifyStagingId:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+Admin_URL_STG);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "season selected: "+season);
			addScreenShot("season selected", test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			WaitforPage(5000);
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addScreenShot("Linesheet view is "+linesheetview, test, Capture);
			
			Colorwaypage.SelectProduct(product,test);
			test.log(Status.INFO, "product selected");
			addScreenShot("product selected", test, Capture);

			Colorwaypage.Create_colorwayLink();
			System.out.println("Colorway page displayed");
			test.log(Status.INFO, "Colorway page displayed");
			addScreenShot("Colorway page displayed", test, Capture);
			
//          if colorsubmenu element is not there just keep blank string ----------------------			
			String thumbnail=Colorwaypage.selectcolour(colormenu,colorsubmenu,filtercolor,test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addScreenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.MandatoryColorwayDetails_ForLSESetUP( productsegLSUSvalue, productsegLSEvalue, classification, producttype,
					 consumergroup, consumergroupext1, consumergroupext2, materialtype,productmarketingname, rigidindicator,merchfabrictype,
					 destroysampleInd,collectionType,capsule ,test);
			System.out.println("All mandatory fields filled");
			test.log(Status.INFO, "All mandatory fields filled");
			addScreenShot("All mandatory fields filled", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.MandatoryFields_colorwaySeason_SetUpLSE(hubofferedto, productlifecyclegroup, lastseasonoffered,
					 productpricepositioning, createddate, filtermaterial,sizeGridCode,currentPlannedLifecycle, primaryfabric,test);
			System.out.println("Colorway season fields selected and view product clicked");
			test.log(Status.INFO, "Colorway season fields selected and view product clicked");
			addScreenShot("Colorway season fields selected and view product clicked", test, Capture);
			
			Thread.sleep(2000);
			Colorwaypage.validateColorway_creation( filtercolor, test);
			System.out.println("Validated Colorway creation");
			test.log(Status.PASS, "Validated Colorway creation");
			addScreenShot("Validated Colorway creation", test, Capture);
					
			Colorwaypage.Navigate_to_firstTab();
			System.out.println("Navigated to linesheet page");
			test.log(Status.INFO, "Navigated to linesheet page");
			addScreenShot("Navigated to linesheet page", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_BUSSINESS.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addScreenShot("Clicked on Libraries menu", test, Capture);
			System.out.println("Clicked on Business Object");
			test.log(Status.INFO, "Clicked on Business Object");
			addScreenShot("Clicked on Business Object", test, Capture);
			WaitforPage(4000);

			businessObjectPage.chooseBusinessObjectType(businessObjectType);
		    System.out.println("Business object type chosen: "+businessObjectType);
		    test.log(Status.INFO, "Business object type chosen: "+businessObjectType);
		    addScreenShot("Business object type chosen", test, Capture);
		    WaitforPage(4000);


			businessObjectPage.chooseActionType(actionType);
		    System.out.println("Action type chosen: "+actionType);
		    test.log(Status.INFO, "Action type chosen: "+actionType);
		    addScreenShot("Action type chosen", test, Capture);
		    WaitforPage(4000);
		    

		    businessObjectPage.enterCreatedDate(createddate);
		    System.out.println("Entered Created Date: " + createddate);
		    test.log(Status.INFO, "Entered Created Date: " + createddate);
		    addScreenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    

		    businessObjectPage.enterMessageTable(messageTableValue);
		    System.out.println("Entered Message Table: " + messageTableValue);
		    test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
		    addScreenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    

		    businessObjectPage.enterHierarchy(hierarchyValue);
		    System.out.println("Entered Hierarchy: " + hierarchyValue);
		    test.log(Status.INFO, "Entered Hierarchy: " + hierarchyValue);
		    addScreenShot("Entered Hierarchy", test, Capture);
		    WaitforPage(4000);
		    
		    businessObjectPage.clickSearch();
		    System.out.println("Clicked on Search");
		    test.log(Status.INFO, "Clicked on Search");
		    addScreenShot("Clicked on Search", test, Capture);
		    WaitforPage(4000);
		    
		 // Verify the staging row ID
		    businessObjectPage.verifyStagingRowId(test);
		    System.out.println("Validation successful for Staging row Id for Create color");
		    test.log(Status.INFO, "Validation successful for Staging row Id for Create color");
		    addScreenShot("Validation successful for Staging row Id for Create color", test, Capture);
		    

			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);
			

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Test case failed due to exception: " + e.getMessage());
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}