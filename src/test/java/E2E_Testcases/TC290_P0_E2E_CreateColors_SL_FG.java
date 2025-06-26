package E2E_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "E2E_TC" })
public class TC290_P0_E2E_CreateColors_SL_FG extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Techpack_pages Techpackpages;
	E2E_Pages E2EPages;
	Colorway_page Colorwaypage;
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
			LaunchSpecific_URL(Design_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			E2EPages=new E2E_Pages(driver);
			Colorwaypage =new Colorway_page(driver);
			CNCP = new CreateNewColorPage(driver);
			
			setReport("TC290_P0_E2E Create Colors -seasonal Look FG");
		}
	}

	@Test( priority = 0, dataProvider = "TC290_P0_E2E_CreateColors_SL_FG", dataProviderClass = DataProviders.class)
	public void P0_TC290_E2E_create_color_FG(String TestType,String season,String colortype,String redvalue, String bluevalue, String greenvalue, String colorfamily,String color,String finishtype,String lookname) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC290_P0_E2E Create Colors -seasonal Look FG:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_290");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully - "+URL);
			test.log(Status.INFO, "login to flex PLM application successfully  -"+URL);
							
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "In libraries Color/Look menu clicked");
			addScreenShot("In libraries Color/Look menu clicked", test, Capture);
			
			Thread.sleep(5000);

			CNCP.clickplussign();
			test.log(Status.INFO, "Clicked on Add color sign");
			addScreenShot("Clicked on Add color sign", test, Capture);
			
			CNCP.SelectColorType(colortype,test);
			test.log(Status.INFO, "Clicked On: " +colortype+" and color page opened");
			addScreenShot("Clicked On: " +colortype+" and color page opened", test, Capture);
			
			String title=driver.getTitle();
			Assert.assertTrue(title.equalsIgnoreCase("Create Color"));
			test.log(Status.INFO, "Create colour page opened");
			
			CNCP.EnterSeasonalFG_Values( season, redvalue,  bluevalue,  greenvalue,  colorfamily, color, finishtype, lookname, test);
			test.log(Status.INFO, "All the required fields for seasonal color BFF is filled");
			addScreenShot("All the required fields for seasonal color BFF is filled", test, Capture);
			
			Thread.sleep(5000);
 			
			CNCP.clickcreatebutton();
			test.log(Status.INFO, "Seasonal color FG is created");
			addScreenShot("Seasonal color FG is created", test, Capture);
			
			Thread.sleep(5000);
			CNCP.Validate_Color_FG(season,lookname,test);
			test.log(Status.PASS, "Validated fields in view color page");
			addScreenShot("Validated fields in view color page", test, Capture);
			
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
