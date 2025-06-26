package P0_TestCases;

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

@Test(enabled = true, groups= {"P0_TC"})
public class TC10_P0_CL_Placement_Part2 extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
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
			customLoadersPage = new CustomLoaders_page(driver);
			
			setReport("TC10_P0 Verify CustomLoader for Placement PART_2");
		}
	}

	@Test(priority = 0,dataProvider = "TC10_P0_CL_Placement_Part2", dataProviderClass = DataProviders.class)
	public void P0_TC_010_Verify_CustomLoader_for_Placement(String TestType,String uploadFilepath,String resultFilepath,String filetype) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC10_P0 Verify CustomLoader for Placement_PART_2:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This Testcase covers TC_66 to TC_70");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully"+Admin_URL_STG);
			test.log(Status.INFO, "login to flex PLM application successfully"+Admin_URL_STG);
					
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
				test.log(Status.FAIL, "Result is: "+str[0]);
				test.log(Status.FAIL, "Message is: "+str[1]);
			}else {
				test.log(Status.PASS, "File is uploaded and The Result is: "+str[0]+"and message is: "+str[1]);
				System.out.println("File is uploaded and The Result is success");
				addScreenShot("File is uploaded and The Result is success", test, Capture);
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
