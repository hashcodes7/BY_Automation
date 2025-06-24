package AdditionalTestcases;
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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

public class TC_CreateColorway_SetUPLSE_LSUS extends WMS_TestBase {
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
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("CreateColorway_for SetUPLSE_LSUS");
		}
	}

	@Test(priority = 0,dataProvider = "TC_CreateColorway_SetUPLSE_LSUS", dataProviderClass = DataProviders.class)
	public void TC_Product_Verify__Create_PC9_for_type_Levis_MensBottoms(String TestType,String season,String product,String colormenu, 
			String colorsubmenu ,String filtercolor,String productsegLSUSvalue,String productsegLSEvalue,String classification,String producttype,String hubofferedto,
			String linesheetview,String consumergroup,String consumergroupext1,String consumergroupext2,String materialtype,String productmarketingname,String rigidindicator,
			String productlifecyclegroup,String lastseasonoffered,String productpricepositioning,String createddate,String filtermaterial,String merchfabrictype,
			String destroysampleInd,String collectionType,String capsule,String sizeGridCode,String currentPlannedLifecycle,String primaryfabric) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::CreateColorway_for SetUPLSE_LSUS:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully"+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			WaitforPage(5000);
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view is "+linesheetview, test, Capture);
			
			Colorwaypage.SelectProduct(product,test);
			test.log(Status.INFO, "product selected");
			addSrceenShot("product selected", test, Capture);

			Colorwaypage.Create_colorwayLink();
			System.out.println("Colorway page displayed");
			test.log(Status.INFO, "Colorway page displayed");
			addSrceenShot("Colorway page displayed", test, Capture);
			
//          if colorsubmenu element is not there just keep blank string ----------------------			
			String thumbnail=Colorwaypage.selectcolour(colormenu,colorsubmenu,filtercolor,test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addSrceenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.MandatoryColorwayDetails_ForLSESetUP( productsegLSUSvalue, productsegLSEvalue, classification, producttype,
					 consumergroup, consumergroupext1, consumergroupext2, materialtype,productmarketingname, rigidindicator,merchfabrictype,
					 destroysampleInd,collectionType,capsule ,test);
			System.out.println("All mandatory fields filled");
			test.log(Status.INFO, "All mandatory fields filled");
			addSrceenShot("All mandatory fields filled", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.MandatoryFields_colorwaySeason_SetUpLSE(hubofferedto, productlifecyclegroup, lastseasonoffered,
					 productpricepositioning, createddate, filtermaterial,sizeGridCode,currentPlannedLifecycle, primaryfabric,test);
			System.out.println("Colorway season fields selected and view product clicked");
			test.log(Status.INFO, "Colorway season fields selected and view product clicked");
			addSrceenShot("Colorway season fields selected and view product clicked", test, Capture);
			
			Thread.sleep(2000);
			Colorwaypage.validateColorway_creation( filtercolor, test);
			System.out.println("Validated Colorway creation");
			test.log(Status.PASS, "Validated Colorway creation");
			addSrceenShot("Validated Colorway creation", test, Capture);
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
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
