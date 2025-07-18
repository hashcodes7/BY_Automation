package P1_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CustomLoaders_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC58_P1_Placement_ValidateBlank_JAPAN_GDV_value extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	CustomLoaders_page customLoadersPage;
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
			lineSheetPage = new LineSheetPage(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			
			setReport("TC58_P1_Placement_ValidateBlank_JAPAN_GDV_value");
		}
	}

	@Test(priority = 0,dataProvider = "TC58_P1_Placement_ValidateBlank_JAPAN_GDV_value", dataProviderClass = DataProviders.class)
	public void P1_TC_58_Placement_Blank_JAPAN_GDV_value(String TestType,String uploadFilepath,String resultFilepath,String filetype,String season
			,String colorway,String linesheetview) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC58_P1_Placement_ValidateBlank_JAPAN_GDV_value:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This Testcase covers TC_208");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully"+Admin_URL_STG);
			test.log(Status.INFO, "login to flex PLM application successfully and the URL is: "+Admin_URL_STG);
			
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.REPORTS.menu(), MainMenuEnum.REPORTS_LoadFile.menu());
			test.log(Status.INFO, "Clicked on Reports Load file ");
			addScreenShot("Clicked on Reports Load file ", test, Capture);
			
			WaitforPage(2000);
			customLoadersPage.selectFileType(filetype);
			test.log(Status.INFO, "File type selected is:   "+filetype);
			addScreenShot("File type selected ", test, Capture);
			
			customLoadersPage.uploadFile(uploadFilepath);
			System.out.println("file uploaded");
			test.log(Status.INFO, "File uploaded");
			addScreenShot("File uploaded", test, Capture);
			Thread.sleep(5000);
			
			String result=customLoadersPage.ValidatePlacementLoaderResult(resultFilepath);
			String[] str=result.split(",");
			if(str[0].equalsIgnoreCase("Error")) {
				test.log(Status.INFO, "Result is: "+str[0]);
				test.log(Status.INFO, "Message is: "+str[1]);
			}else {
				test.log(Status.PASS, "File is uploaded and The Result is: "+str[0]+"and message is: "+str[1]);
				System.out.println("File is uploaded and The Result is success");
				addScreenShot("File is uploaded and The Result is success", test, Capture);
				
				mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
				test.log(Status.INFO, "My seasons menu clicked");
				addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

				LineSheetEditPage.SeasonDropdown(season);
				test.log(Status.INFO, "Season value seleted:"+season);
				addScreenShot("Season value seleted"+season, test, Capture);
				
				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addScreenShot("Clicked on Line Sheets", test, Capture);
				
				LineSheetEditPage.filter_View_Change(linesheetview,test);
				test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
				addScreenShot("Linesheet view is "+linesheetview, test, Capture);
				WaitforPage(5000);
				
				customLoadersPage.Validate_JAPAN_GDV_linesheet(colorway,test);
				test.log(Status.PASS, "Validation successful for JAPAN_GDV value");
				System.out.println("Validation successful for JAPAN_GDV value");
				addScreenShot("Validation successful for JAPAN_GDV value", test, Capture);
				
			}
			
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

