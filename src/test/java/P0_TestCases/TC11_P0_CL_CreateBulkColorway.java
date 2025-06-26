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
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC11_P0_CL_CreateBulkColorway extends WMS_TestBase {
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
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			
			setReport("TC11_P0 Create BulkColorway using Custom Loaders");
		}
	}

	@Test(priority = 0,dataProvider = "TC11_P0_CL_CreateBulkColorway", dataProviderClass = DataProviders.class)
	public void P0_TC_010_Verify_CustomLoader_for_Placement(String TestType,String uploadFilepath,String resultFilepath) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC11_P0 Create BulkColorway using Custom Loaders:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers TC_71 to TC_74 and TC_76 to TC_78");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully"+URL);
			test.log(Status.INFO, "login to flex PLM application successfully  "+URL);
					
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.REPORTS.menu(), MainMenuEnum.REPORTS_LoadFile.menu());
			test.log(Status.INFO, "Clicked on Reports Load file ");
			addScreenShot("Clicked on Reports Load file ", test, Capture);
			
			WaitforPage(2000);
			customLoadersPage.uploadbulkFile(uploadFilepath);
			System.out.println("file uploaded");
			test.log(Status.INFO, "File uploaded");
			addScreenShot("File uploaded", test, Capture);
			
			Thread.sleep(2000);
			String result=customLoadersPage.ValidateBulkColorResult(resultFilepath);
			String[] str=result.split(",");
			if(str[0].equalsIgnoreCase("Error")) {
				test.log(Status.FAIL, "Status is: "+str[0]);
				test.log(Status.FAIL, "Comments is: "+str[1]);
			}else {
				test.log(Status.PASS, "File is uploaded and The Result is success");
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
