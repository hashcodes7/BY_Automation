package P0_TestCases;

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

@Test(enabled = true, groups= {"P0_TC"})
public class TC01_P0_Validate_ProductSegmentationLSE extends WMS_TestBase {
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
			LineSheetEditPage =new LineSheet_Edit_Page(driver);
			setReport("TC01_P0 Verify LSE Product Segmentation ");
		}
	}

	@Test(priority = 0,dataProvider = "Product_Segmentation_LSE", dataProviderClass = DataProviders.class)
	public void P0_TC_Product_001_Verify_LSE_Product_Segmentation_Create_PC9_for_type_Levis_MensBottoms(String TestType,String season,String colorway
			,String brand, String productcategory, String consumergroup_1, String productsegLSEvalue,String linesheetview) 
					throws Exception{
		
		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P0 Verify LSE Product Segmentation :::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully ");
			test.log(Status.INFO, "login to flex PLM application successfully "+URL);
			
			test.log(Status.INFO, "This testcase covers TC_11 and TC_12");

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addScreenShot("opened left panel", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "Season selected: "+season);
			addScreenShot("Season selected:"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addScreenShot("Linesheet view changed", test, Capture);
			
			Colorwaypage.SelectColorway(colorway,test);
			test.log(Status.INFO, "colorway selected is "+colorway);
			addScreenShot("colorway selected", test, Capture);
			Thread.sleep(3000);
			Colorwaypage.ValidatingLSEdetails(brand,colorway,productcategory,consumergroup_1,productsegLSEvalue,test);
			test.log(Status.PASS, "Product segmentation[LSE] values matched");
			addScreenShot("Product segmentation[LSE] values matched", test, Capture);
			
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
