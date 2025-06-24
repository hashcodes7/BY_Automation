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
import com.WMS_ApplicationPages.VendorPortalPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC35_P1_CopyCarryover_ValidateAttributes extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	CreateNewColorPage newColorPage;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Copy_carryover_page CCP;
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
			newColorPage = new CreateNewColorPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage =new LineSheet_Edit_Page(driver);
			CCP = new Copy_carryover_page(driver);
			
			setReport("TC35_P1_CopyCarryover_ValidateAttributes");
		}
	}

	@Test( priority = 0, dataProvider = "TC35_P1_CopyCarryover_ValidateAttributes", dataProviderClass = DataProviders.class)

	public void P0_TC_35_attributesValidation(String TestType,String season,String linesheetview, String colorwayCode) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC35_P1_CopyCarryover_ValidateAttributes:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers TC_83");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully and The URL is: " + URL);
			Thread.sleep(5000);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "Season selected: "+season);
			addSrceenShot("Season selected:"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			WaitforPage(5000);
			addSrceenShot("Clicked on Line Sheets", test, Capture);
						
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			WaitforPage(5000);
			addSrceenShot("Linesheet view changed to: "+linesheetview, test, Capture);
						
			CCP.copycarryoverAttributeValidation(test,colorwayCode);
			test.log(Status.PASS, "Validation successful for Attributes of copied product");
			WaitforPage(5000);
			addSrceenShot("Validation successful for Attributes of copied product", test, Capture);
			
					
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