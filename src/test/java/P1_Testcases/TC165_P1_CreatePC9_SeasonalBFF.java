package P1_Testcases;

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

@Test(enabled = true, groups= {"P1_TC"})
public class TC165_P1_CreatePC9_SeasonalBFF extends WMS_TestBase {
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
			setReport("TC165_P1_CreatePC9_SeasonalBFF");
		}
	}

	@Test(priority = 0,dataProvider = "TC165_P1_CreatePC9_SeasonalBFF", dataProviderClass = DataProviders.class)
	public void P1_TC165_CreatePC9_SeasonalBFF(String TestType,String season,String product,String colormenu, 
			String colorsubmenu,String filtercolor,String productsegLSUSvalue,String productsegLSEvalue,String classification,
			String producttype,String linesheetview,String hubofferedto,String rigidindicator,String createddate) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC165_P1_CreatePC9_SeasonalBFF:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_44");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL: "+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
//			first scenario - create PC9 for Look color for same season
			
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
			Thread.sleep(2000);
			Colorwaypage.SelectProduct(product,test);
			test.log(Status.INFO, "product selected: "+product);
			addScreenShot("product selected"+product, test, Capture);
			System.out.println("product selected"+product);
			Thread.sleep(2000);
			Colorwaypage.Create_colorwayLink();
			System.out.println("Colorway page displayed");
			test.log(Status.INFO, "Colorway page displayed");
			addScreenShot("Colorway page displayed", test, Capture);
			Thread.sleep(2000);
//          if colorsubmenu element is not there just keep blank string ----------------------			
			Colorwaypage.selectcolour_SeasonalLook(colormenu,colorsubmenu,filtercolor,test);
			System.out.println("Seasonal Look color/look Selected ");
			test.log(Status.INFO, " Seasonal Look color/look Selected");
			addScreenShot("Seasonal Look color/look Selected ", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.MandatoryDetails(productsegLSUSvalue,productsegLSEvalue,classification,producttype,test);
			System.out.println("All required fields filled");
			test.log(Status.INFO, "All required fields filled");
			addScreenShot("All required fields filled", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.colorwayseasonfield(hubofferedto,test);
			System.out.println("Colorway season fields selected and view product clicked");
			test.log(Status.INFO, "Colorway season fields selected and view product clicked");
			addScreenShot("Colorway season fields selected and view product clicked", test, Capture);
			
			Colorwaypage.Validate_CreatedBFF_FG_Colorway(test);
			test.log(Status.PASS, "Validation Successful for Colorway name");
			addScreenShot("Validation Successful for colorway name", test, Capture);
			
			Colorwaypage.validate_ProductDevCenter(test);
			test.log(Status.PASS, "Validation Successful for product dev center");
			addScreenShot("Validation Successful for product dev center", test, Capture);
			
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
