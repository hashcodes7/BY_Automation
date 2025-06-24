package P2_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CustomLoaders_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC01_P2_CustomLoaders_CreateLooks_usingLoaders extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	CustomLoaders_page customLoadersPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	
	boolean Capture = true;

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			customLoadersPage = new CustomLoaders_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			setReport("TC01_P2_CustomLoaders_CreateLooks_usingLoaders");
		}
	}

	@Test(priority = 0,dataProvider = "TC01_P2_CustomLoaders_CreateLooks_usingLoaders", dataProviderClass = DataProviders.class)
	public void P2_TC_02_CustomLoaders_CreateLooks(String TestType,String uploadFilepath,String resultFilepath,String lookname) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P2_CustomLoaders_CreateLooks_usingLoaders:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This Testcase covers TC_90 to TC_93 and TC_95");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully"+URL);
			test.log(Status.INFO, "login to flex PLM application successfully and the URL is: "+URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.LibraryMenu(MainMenuEnum.REPORTS.menu(), MainMenuEnum.REPORTS_LoadFile.menu());
			test.log(Status.INFO, "Clicked on Reports Load file ");
			addSrceenShot("Clicked on Reports Load file ", test, Capture);
			
			customLoadersPage.uploadbulkFile(uploadFilepath);
			System.out.println("file uploaded");
			test.log(Status.INFO, "File uploaded");
			addSrceenShot("File uploaded", test, Capture);
			
			Thread.sleep(2000);
			
			String result=customLoadersPage.ValidateBulkLookResult(resultFilepath);
			String[] str=result.split(",");
			if(str[0].equalsIgnoreCase("Failed")) {
				test.log(Status.FAIL, "Result is: "+str[0]);
				test.log(Status.FAIL, "Message is: "+str[1]);
			}else {
				
				test.log(Status.PASS, "File is uploaded and The Result is: "+str[0]+"and message is: "+str[1]);
				test.log(Status.INFO, "colorcode is: "+str[2]);
				System.out.println("colorcode is: " +str[2]);
				System.out.println("File is uploaded and The Result is success");
				
//---------------for Look check---------------------------------------------------------------
				String colorcode=str[2];
				
				mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
				test.log(Status.INFO, "Clicked on Libraries menu");
				addSrceenShot("Clicked on Libraries menu", test, Capture);
				
				String colorname="*"+colorcode+"*";
				CNCP.searchBox(colorname);
				test.log(Status.INFO, "Color name entered: "+colorname);
				addSrceenShot("Color name entered", test, Capture);
				
				CNCP.searchButton();
				test.log(Status.INFO, "Search button clicked");
				addSrceenShot("Search button clicked", test, Capture);
				
				
//-----------------				lookname same as the lookname given in loader files----------------------------------

				customLoadersPage.ValidateBulkLook_UI(lookname,test);
				System.out.println("Validation successful for the Look created");
				test.log(Status.PASS, "Validation successful for the Look created");
				addSrceenShot("Validation successful for the Look created", test, Capture);

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
