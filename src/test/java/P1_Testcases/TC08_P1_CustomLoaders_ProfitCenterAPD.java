package P1_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.bouncycastle.math.ec.custom.sec.SecT113R1Curve;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
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
public class TC08_P1_CustomLoaders_ProfitCenterAPD extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	CustomLoaders_page customLoadersPage;
	Colorway_page Colorwaypage;
	
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
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			
			setReport("TC08_P1_CustomLoaders_ProfitCenterAPD");
		}
	}

	@Test(priority = 0,dataProvider = "TC08_P1_CustomLoaders_ProfitCenterAPD", dataProviderClass = DataProviders.class)
	public void P1_TC_08_Verify_CustomLoader_for_ProfitcenterAPD(String TestType,String uploadFilepath,String resultFilepath,String filetype,String season,
			String linesheetview,String colorway,String profitcenterAPD) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC08_P1_CustomLoaders_ProfitCenterAPD:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This Testcase covers TC_87 and TC_92");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully   "+Admin_URL_STG);
			test.log(Status.INFO, "login to flex PLM application successfully and URL is: "+Admin_URL_STG);
					
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
			
			String result=customLoadersPage.ValidateProfitCenterAPDLoaderResult(resultFilepath);
			String[] str=result.split(",");
			if(str[0].equalsIgnoreCase("Error")) {
				test.log(Status.INFO, "Result is: "+str[0]);
				test.log(Status.INFO, "Message is: "+str[1]);
				
				customLoadersPage.selectFileType(filetype);
				test.log(Status.INFO, "File type selected is:   "+filetype);
				addScreenShot("File type selected ", test, Capture);
//				in this 30 seconds try to change the value and save it and delete the logfile ------------
				Thread.sleep(30000);

				customLoadersPage.uploadFile(uploadFilepath);
				System.out.println("file Re-uploaded");
				test.log(Status.INFO, "File Re-uploaded");
				addScreenShot("File Re-uploaded", test, Capture);
				Thread.sleep(5000);
				
				String anotherresult=customLoadersPage.ValidateProfitCenterAPDLoaderResult(resultFilepath);
				String[] str1=anotherresult.split(",");
				if(str1[0].equalsIgnoreCase("Error")) {
					test.log(Status.INFO, "Result is: "+str1[0]);
					test.log(Status.INFO, "Message is: "+str1[1]);

				}else {
					test.log(Status.PASS, "File is re-uploaded and The Result is: "+str1[0]+"and message is: "+str1[1]);
					System.out.println("File is re-uploaded and The Result is success");
					addScreenShot("File is re-uploaded and The Result is success", test, Capture);
				}

			}else {
				test.log(Status.PASS, "File is uploaded and The Result is: "+str[0]+"and message is: "+str[1]);
				System.out.println("File is uploaded and The Result is success");
				addScreenShot("File is uploaded and The Result is success", test, Capture);
				
			}
			
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
			
			
			customLoadersPage.Validate_ProfitcenterAPD_linesheet(colorway,profitcenterAPD,test);
			System.out.println("Validation successful for Profit center APD");
			test.log(Status.PASS, "Validation successful for Profit center APD");
			addScreenShot("Validation successful for Profit center APD", test, Capture);
			
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
