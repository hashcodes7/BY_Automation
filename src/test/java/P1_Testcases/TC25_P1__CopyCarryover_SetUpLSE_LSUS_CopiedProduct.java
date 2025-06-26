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
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC25_P1__CopyCarryover_SetUpLSE_LSUS_CopiedProduct extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Set_Up_Page SetUpPage;
	
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
			SetUpPage = new Set_Up_Page(driver);

			setReport("TC25_P1__CopyCarryover_SetUpLSE_LSUS_CopiedProduct");
		}
	}

	@Test(priority = 0,dataProvider = "TC25_P1__CopyCarryover_SetUpLSE_LSUS_CopiedProduct", dataProviderClass = DataProviders.class)
	public void P1_TC_carryover_25_SetUpLSE_LSUS(String TestType,String season,String colorway,String linesheetview) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC25_P1__CopyCarryover_SetUpLSE_LSUS_CopiedProduct:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_80 to TC_82");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully and URL is:  "+URL);

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
			addScreenShot("Linesheet view changed", test, Capture);
			
			Colorwaypage.SelectColorway(colorway,test);
			test.log(Status.INFO, "colorway details page opened ");
			addScreenShot("colorway details page opened ", test, Capture);

			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addScreenShot("Colorway season edit page opened", test, Capture);
			
			SetUpPage.Validate_blankSetUp_Attributes(test);
			System.out.println("Validation successful for blank LSE and LSUS validation results");
			test.log(Status.PASS, "Validation successful for blank LSE and LSUS validation results");
			addScreenShot("Validation successful for blank LSE and LSUS validation results", test, Capture);

			SetUpPage.SetUpLSE(test);
			System.out.println("SetUP LSE is Completed");
			test.log(Status.INFO, "SetUP LSE is Completed");
			addScreenShot("SetUP LSE is completed", test, Capture);
			
			SetUpPage.ClickEditColorwayseason();
			System.out.println("Colorway season edit page opened");
			test.log(Status.INFO, "Colorway season edit page opened");
			addScreenShot("Colorway season edit page opened", test, Capture);
			
			SetUpPage.ValidationLSE(test);
			System.out.println("Validation successful for SetUpLSE");
			test.log(Status.PASS, "Validation successful for SetUpLSE");
			addScreenShot("Validation of SetUpLSE", test, Capture);
			
			Thread.sleep(2000);
			SetUpPage.SetUpLSUS(test);
			System.out.println("SetUP LSUS is Completed");
			test.log(Status.INFO, "SetUP LSUS is completed");
			addScreenShot("SetUP LSUS is completed", test, Capture);
			
			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addScreenShot("Colorway season edit page opened", test, Capture);
			Thread.sleep(2000);
			
			SetUpPage.ValidationLSUS(test);
			test.log(Status.PASS, "Validation successful for SetUpLSUS");
			addScreenShot("Validation of SetUpLSUS", test, Capture);
			
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

