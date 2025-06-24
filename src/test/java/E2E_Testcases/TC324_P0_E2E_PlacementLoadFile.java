package E2E_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CustomLoaders_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Measurements_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC324_P0_E2E_PlacementLoadFile extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	Measurements_Page MeasurementsPage;
	E2E_Pages E2EPages;
	Colorway_page Colorwaypage;
	CustomLoaders_page customLoadersPage;
	
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
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			MeasurementsPage= new Measurements_Page(driver);
			E2EPages =new E2E_Pages(driver);
			Colorwaypage =new Colorway_page(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			
			setReport("TC324_P0_E2E Upload Placement file and verify the result");
		}
	}

	@Test( priority = 0, dataProvider = "TC324_P0_E2E_PlacementLoadFile", dataProviderClass = DataProviders.class)
	public void P0_TC324_E2E_VerifyPlacementFile(String TestType,String uploadFilepath,String resultFilepath,String filetype,String season, String linesheetview,
			String colorway,String vendor_Id,String materialcode,String millsapcode,String usagevalue) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC324_P0_E2E Upload Placement file and verify the result:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_324 and TC_325");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully - "+Admin_URL_STG);
			test.log(Status.INFO, "login to flex PLM application successfully - "+Admin_URL_STG);
					
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.REPORTS.menu(), MainMenuEnum.REPORTS_LoadFile.menu());
			test.log(Status.INFO, "Clicked on Reports Load file ");
			addSrceenShot("Clicked on Reports Load file ", test, Capture);
			
			WaitforPage(2000);
			
			customLoadersPage.selectFileType(filetype);
			test.log(Status.INFO, "File type selected is:  "+filetype);
			addSrceenShot("File type selected ", test, Capture);
			
			customLoadersPage.uploadFile(uploadFilepath);
			System.out.println("file uploaded");
			test.log(Status.INFO, "File uploaded");
			addSrceenShot("File uploaded", test, Capture);
			Thread.sleep(5000);
			
			String result=customLoadersPage.ValidatePlacementLoaderResult(resultFilepath);
			String[] str=result.split(",");
			if(str[0].equalsIgnoreCase("Error")) {
				test.log(Status.FAIL, "Result is: "+str[0]);
				test.log(Status.FAIL, "Message is: "+str[1]);
			}else {
				test.log(Status.PASS, "File is uploaded and The Result is: "+str[0]+"and message is: "+str[1]);
				System.out.println("File is uploaded and The Result is success");
				addSrceenShot("File is uploaded and The Result is success", test, Capture);
			}
			if(str[0].equalsIgnoreCase("Success")){
				mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
				test.log(Status.INFO, "My seasons menu clicked");
				addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
				
				MeasurementsPage.SeasonDropdown(season);
				test.log(Status.INFO, "Season value seleted:"+season);
				addSrceenShot("Season value seleted"+season, test, Capture);
				
				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addSrceenShot("Clicked on Line Sheets", test, Capture);
				
				dashboardPage.closeLeftPanel();
				test.log(Status.INFO, "Closed Left panel");
				addSrceenShot("Closed Left panel", test, Capture);
				
				Thread.sleep(1000); 

				LineSheetEditPage.filter_View_Change(linesheetview,test);
				test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
				addSrceenShot("Linesheet view changed", test, Capture);
				
				Thread.sleep(2000);
				
				Techpackpages.filterdata(colorway);
				test.log(Status.INFO, "Source filtered "+colorway);
				addSrceenShot("Source filtered "+colorway, test, Capture);
				System.out.println("Source filtered "+colorway);
				
				customLoadersPage.VerifyAttributesValue_PlacementView(vendor_Id,materialcode,millsapcode,usagevalue,test);
				test.log(Status.PASS, "verfied Placement attributes ");
				addSrceenShot("verfied Placement attributes  ", test, Capture);
				System.out.println("verfied Placement attributes ");
				
				

			}else {
				System.out.println("Got Error in Placement file");
				test.log(Status.FAIL, "Got Error in Placement file ");
			}
			
			
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

