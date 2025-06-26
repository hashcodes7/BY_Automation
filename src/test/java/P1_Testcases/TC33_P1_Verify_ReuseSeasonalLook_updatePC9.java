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
public class TC33_P1_Verify_ReuseSeasonalLook_updatePC9  extends WMS_TestBase {
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
			LaunchSpecific_URL(Admin_URL_STG);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC33_P1 Verify Reuse of seasonal Look color while updating colorway");
		}
	}

	@Test(priority = 0,dataProvider = "TC33_P1_Verify_ReuseSeasonalLook_updatePC9", dataProviderClass = DataProviders.class)
	public void P1_TC_Product_33_Verify_Reuse_SeasonalLookColor(String TestType,String season,String colorway,String colormenu, 
			String colorsubmenu,String filtercolor,String productsegLSUSvalue,String productsegLSEvalue,String linesheetview,String createddate) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC33_P1 Verify Reuse of seasonal Look color while updating colorway:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_37");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL: "+Admin_URL_STG);
			
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
			
			Colorwaypage.SelectColorway(colorway,test);
			test.log(Status.INFO, "colorway selected: "+colorway);
			addScreenShot("colorway selected"+colorway, test, Capture);
			System.out.println("colorway selected"+colorway);
			
			Colorwaypage.NavigateTo_updatecolorway();
			System.out.println("Navigated to Edit colorway page ");
			test.log(Status.INFO, " Navigated to Edit colorway page ");
			addScreenShot("Navigated to Edit colorway page ", test, Capture);
			
//          if colorsubmenu element is not there just keep blank string ----------------------			
			Colorwaypage.selectcolour_SeasonalLook(colormenu,colorsubmenu,filtercolor,test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addScreenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.requiredAttributes(productsegLSUSvalue,productsegLSEvalue,test);
			System.out.println("All mandatory fields filled");
			test.log(Status.INFO, "All mandatory fields filled");
			addScreenShot("All mandatory fields filled", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.Validate_ReuseSeasonalLookcolor(filtercolor,test);
			System.out.println("Validation successful");
			test.log(Status.PASS, "Validation successful");
			addScreenShot("Validation successful", test, Capture);
			
			Thread.sleep(2000);

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
