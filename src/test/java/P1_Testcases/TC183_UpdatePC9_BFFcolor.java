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
public class TC183_UpdatePC9_BFFcolor extends WMS_TestBase {
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
			setReport("TC183_UpdatePC9_BFFcolor" );
		}
	}

	@Test(priority = 0,dataProvider = "TC183_UpdatePC9_BFFcolor", dataProviderClass = DataProviders.class)
	public void P1_TC_Product_183_Update_PC9BFFcolor(String TestType,String season,String colorway,String linesheetview,String productsegLSUSvalue,String productsegLSEvalue) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC183_UpdatePC9_BFFcolor:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_59");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully and URL is:  "+URL);

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
			addScreenShot("Linesheet view changed", test, Capture);
			
			Colorwaypage.SelectColorway(colorway,test);
			System.out.println("Colorway selected: "+colorway);
			test.log(Status.INFO, "colorway details page opened ");
			addScreenShot("colorway details page opened ", test, Capture);
			
			Colorwaypage.NavigateTo_updatecolorway();
			System.out.println("Navigated to Edit colorway page ");
			test.log(Status.INFO, " Navigated to Edit colorway page ");
			addScreenShot("Navigated to Edit colorway page ", test, Capture);
			
//          if colorsubmenu element(Looks/Sundry) is not there just keep Looks/Sundry string ----------------------			
			
			Colorwaypage.requiredAttributes(productsegLSUSvalue,productsegLSEvalue,test);
			System.out.println("Product segmentation LSE and LSUS fields Updated");
			test.log(Status.INFO, "Product segmentation LSE and LSUS fields Updated");
			addScreenShot("Product segmentation LSE and LSUS fields Updated", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.Validate_UpdatePC9_SeasonalBFF(productsegLSUSvalue,productsegLSEvalue,test);
			System.out.println("Validation successful for Product segmentation LSE and LSUS fields");
			test.log(Status.INFO, "Validation successful for Product segmentation LSE and LSUS fields");
			addScreenShot("Validation successful for Product segmentation LSE and LSUS fields", test, Capture);
						
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
