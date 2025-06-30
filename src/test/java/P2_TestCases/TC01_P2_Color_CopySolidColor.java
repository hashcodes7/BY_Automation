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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC01_P2_Color_CopySolidColor extends WMS_TestBase {
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
			LaunchSpecific_URL(URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC01_P2_Color_CopySolidColor");
		}
	}

	@Test(priority = 0,dataProvider = "TC01_P2_Color_CopySolidColor", dataProviderClass = DataProviders.class)
	public void P2_TC01_Color_CopySolidColor(String TestType,String colormenu, String colorsubmenu,String filtercolor,
			String newcolorname) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC01_P2_Color_CopySolidColor:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_01 and TC_02");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL: "+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.libraryColurmenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_COLOR.menu());
			test.log(Status.INFO, "Clicked on Libraries menu");
			addScreenShot("Clicked on Libraries menu", test, Capture);

			Thread.sleep(2000);
			
			CNCP.SelectColorLook_colorpage(colormenu ,colorsubmenu,filtercolor, test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addScreenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);
			
			CNCP.Click_Solids_Color();
			System.out.println("Solid color page opened");
			test.log(Status.INFO, " Solid color page opened");
			addScreenShot("Solid color page opened ", test, Capture);
			
			Thread.sleep(2000);
			CNCP.NavigateTo_CopyColorPage();
			System.out.println("Navigated to copy color page");
			test.log(Status.INFO, " Navigated to copy color page");
			addScreenShot("Navigated to copy color page", test, Capture);

			Thread.sleep(2000);
			CNCP.Copy_SolidColor(newcolorname);
			System.out.println("Solid color copied");
			test.log(Status.INFO, " Solid color copied");
			addScreenShot("Solid color copied", test, Capture);
		
			Thread.sleep(2000);
			CNCP.Validate_CopiedColor(newcolorname, test);
			System.out.println("Validation successful for copy Solid color");
			test.log(Status.PASS, " Validation successful for copy Solid color");
			addScreenShot("Validation successful for copy Solid color", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
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

