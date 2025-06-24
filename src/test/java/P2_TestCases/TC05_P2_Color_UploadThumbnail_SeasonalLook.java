package P2_TestCases;

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

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC05_P2_Color_UploadThumbnail_SeasonalLook extends WMS_TestBase {
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
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Design_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC05_P2_Color_UploadThumbnail_SeasonalLook");
		}
	}

	@Test(priority = 0,dataProvider = "TC05_P2_Color_UploadThumbnail_SeasonalLook", dataProviderClass = DataProviders.class)
	public void P2_TC05_UploadThumbnail_seasonalLook(String TestType,String season,String colormenu, String colorsubmenu,String filtercolor
			,String filepath,String linesheetview,String colorway,String filename) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC05_P2_Color_UploadThumbnail_SeasonalLook:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_14 to TC_16");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL: "+Design_URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addSrceenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(2000);
			
			CNCP.SelectSeasonalColorLook_colorpage(colormenu ,colorsubmenu,filtercolor, test);
			System.out.println("Seasonal color/look Selected ");
			test.log(Status.INFO, "Seasonal color/look Selected");
			addSrceenShot("Seasonal color/look Selected ", test, Capture);
			WaitforPage(4000);
			
			palettepage.NavigateTo_updatecolorPage();
			System.out.println("Navigated to Update color page");
			test.log(Status.INFO, "Navigated to Update color page");
			addSrceenShot("Navigated to Update color page", test, Capture);
			
			String Expectedthumbnail=palettepage.UploadThumbnail(filepath,test);
			System.out.println("Thumbnail updated for color");
			test.log(Status.INFO, "Thumbnail updated for color");
			addSrceenShot("Thumbnail updated for color", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("My seasons menu clicked", test, Capture);
			
			palettepage.SeasonDropdown(season);
			System.out.println("Season value seleted:"+season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addSrceenShot("Season value seleted"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view is "+linesheetview, test, Capture);
			Thread.sleep(2000);
			
			
//			String colorway="0WPJ8-0025 Test MISTED YELLOW";
			Colorwaypage.SelectColorway(colorway,test);
			test.log(Status.INFO, "colorway selected: "+colorway);
			addSrceenShot("colorway selected"+colorway, test, Capture);
			System.out.println("colorway selected"+colorway);
			Thread.sleep(2000);
			
			palettepage.Validate_thumbnailColor(filename,Expectedthumbnail,test);
			test.log(Status.PASS, "Validation successful for thumbnail ");
			addSrceenShot("Validation successful for thumbnail", test, Capture);
			System.out.println("Validation successful for thumbnail");
			Thread.sleep(2000);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
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