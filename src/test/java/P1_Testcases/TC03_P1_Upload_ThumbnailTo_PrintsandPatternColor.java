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
public class TC03_P1_Upload_ThumbnailTo_PrintsandPatternColor extends WMS_TestBase {
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
			setReport("TC03_P1_Upload_ThumbnailTo_PrintsandPatternColor");
		}
	}

	@Test(priority = 0,dataProvider = "TC03_P1_Upload_ThumbnailTo_PrintsandPatternColor", dataProviderClass = DataProviders.class)
	public void P1_TC03_UploadThumbnail_printsandPatternscolor_PC9(String TestType,String season,String colorway,String linesheetview,String filepath) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P1_Upload_ThumbnailTo_PrintsandPatternColor:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_17 and TC_18");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL: "+URL);
			
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
			Thread.sleep(2000);
			
			Colorwaypage.SelectColorway(colorway,test);
			System.out.println("Colorway selected: "+colorway);
			test.log(Status.INFO, "colorway details page opened ");
			addScreenShot("colorway details page opened ", test, Capture);
			Thread.sleep(2000);
			
			Colorwaypage.NavigateTo_ColorLink();
			System.out.println("Navigated to colorlink ");
			test.log(Status.INFO, "Navigated to colorlink  ");
			addScreenShot("Navigated to colorlink  ", test, Capture);
			Thread.sleep(2000);
			
			Colorwaypage.NavigateTo_UpdatecolorPC9();
			System.out.println("Navigated to update color ");
			test.log(Status.INFO, "Navigated to update color  ");
			addScreenShot("Navigated to update color  ", test, Capture);
			Thread.sleep(2000);
			
			Colorwaypage.UploadThumbnail_PrintsandPatternsColor(filepath);
			System.out.println("Thumbnail is uploaded");
			test.log(Status.INFO, "Thumbnail is uploaded ");
			addScreenShot("Thumbnail is uploaded ", test, Capture);
			Thread.sleep(2000);
		
			Colorwaypage.ValidateUploadedThumbnail_printsandPatternsColor(test);
			System.out.println("Validation successful for uploading thumbnail for Prints and Patterns color");
			test.log(Status.PASS, "Validation successful for uploading thumbnail for Prints and Patterns color");
			addScreenShot("Validation successful for uploading thumbnail for Prints and Patterns color", test, Capture);
			
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
