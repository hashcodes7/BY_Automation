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
public class TC36_P0_Placements_UpdatingMultiplePlacementValue extends WMS_TestBase {
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
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC36_P0 update Placement value for multiple enteries");
		}
	}

	@Test(priority = 0,dataProvider = "TC36_P0_Placements_UpdatingMultiplePlacementValue", dataProviderClass = DataProviders.class)
	public void TC36_P0_Placements_Updatin_placements_values(String TestType,String uploadFilepath,String resultFilepath,String filetype,String season,
			String linesheetview,String uploadFilePath_update,String resultfilepath_update) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC36_P0 update Placement value for multiple enteries:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This Testcase covers TC_192 to TC_194");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully "+URL);
			test.log(Status.INFO, "login to flex PLM application successfully "+URL);		
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.REPORTS.menu(), MainMenuEnum.REPORTS_LoadFile.menu());
			test.log(Status.INFO, "Clicked on Reports Load file ");
			addSrceenShot("Clicked on Reports Load file ", test, Capture);
			
			WaitforPage(2000);
			
			customLoadersPage.selectFileType(filetype);
			test.log(Status.INFO, "File type selected is:   "+filetype);
			addSrceenShot("File type selected ", test, Capture);
			
			customLoadersPage.uploadFile(uploadFilepath);
			System.out.println("file uploaded");
			test.log(Status.INFO, "File uploaded");
			addSrceenShot("File uploaded", test, Capture);
			Thread.sleep(5000);
			
			String result=customLoadersPage.ValidatePlacementLoaderResult(resultFilepath);
			String[] str=result.split(",");
			if(str[0].equalsIgnoreCase("Success")) {
				test.log(Status.INFO, "File is uploaded and The Result is: "+str[0]+"and message is: "+str[1]);
				System.out.println("File is uploaded and The Result is success");
				addSrceenShot("File is uploaded and The Result is success", test, Capture);
			}
			
			Thread.sleep(10000);
			
//-------------uploading again different file in which for the same product user have changed an attribute value like Yield Usage---------
			
			customLoadersPage.selectFileType(filetype);
			test.log(Status.INFO, "File type selected is:   "+filetype);
			addSrceenShot("File type selected ", test, Capture);
			
			customLoadersPage.uploadFile(uploadFilePath_update);
			System.out.println("file Re-uploaded");
			test.log(Status.INFO, "File Re-uploaded");
			addSrceenShot("File Re-uploaded", test, Capture);
			Thread.sleep(5000);
			
			String updateresult=customLoadersPage.ValidatePlacementLoaderResult(resultfilepath_update);
			String[] str1=updateresult.split(",");
			if(str1[0].equalsIgnoreCase("Success")) {
				test.log(Status.PASS, "The Result for the updated file is: "+str1[0]+"and message is: "+str1[1]);
				System.out.println("The Result for the updated file is:   "+str1[0]+"and message is: "+str1[1]);
				addSrceenShot("The Result for the updated file is: "+str1[0]+"and message is: "+str1[1], test, Capture);
			}
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
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
