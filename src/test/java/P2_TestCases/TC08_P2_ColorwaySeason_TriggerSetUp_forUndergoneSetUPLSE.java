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
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC08_P2_ColorwaySeason_TriggerSetUp_forUndergoneSetUPLSE extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	Set_Up_Page SetUpPage;
	ProductPage productPage;
	LineSheet_Edit_Page LineSheetEditPage;
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			SetUpPage = new Set_Up_Page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Colorwaypage= new Colorway_page(driver);
			productPage = new ProductPage(driver);
			setReport("TC08_P2_ColorwaySeason_TriggerSetUp_forUndergoneSetUPLSE");
		}
	}
	
	public void initiateObj(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		lineSheetPage = new LineSheetPage(driver);
		SetUpPage = new Set_Up_Page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		Colorwaypage= new Colorway_page(driver);
		productPage = new ProductPage(driver);
		
	}

	@Test(priority = 0,dataProvider = "TC08_P2_ColorwaySeason_TriggerSetUp_forUndergoneSetUPLSE", dataProviderClass = DataProviders.class)
	public void P2_TC_08_TriggerSetUp_forUndergoneSetUPLSE(String TestType,String season,String colorway,String linesheetview,String productlifecyclegroup,String lastseasonoffered,
			String currentPlannedLifecycle) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC08_P2_ColorwaySeason_TriggerSetUp_forUndergoneSetUPLSE:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_68 to TC_71");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			SetUpPage.SeasonDropdown(season);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: Adoption");
			addSrceenShot("Linesheet view changed", test, Capture);
			
			SetUpPage.SelectColorway(colorway);
			test.log(Status.INFO, "colorway details page opened"+ colorway);
			addSrceenShot("colorway details page opened", test, Capture);
			
			SetUpPage.ValidateLSE_productdetailspage(test);
			test.log(Status.INFO, "Pre-requisite checked for SetUpLSE");
			System.out.println("Pre-requisite checked for SetUpLSE");
			addSrceenShot("Pre-requisite checked for SetUpLSE", test, Capture);
			
			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addSrceenShot("Colorway season edit page opened", test, Capture);
			Thread.sleep(3000);

			Colorwaypage.UpdateColorwayseason_SAP_Attributes( productlifecyclegroup, lastseasonoffered, currentPlannedLifecycle,test);
			System.out.println(" Colorway season  SAP Attributes are updated");
			test.log(Status.INFO, "  Colorway season SAP Attributes are updated");
			addSrceenShot(" Colorway season Attributes are updated", test, Capture);
			Thread.sleep(3000);
			
			SetUpPage.ClickEditColorwayseason();
			System.out.println("clicked on edit colorway season");
			test.log(Status.INFO, "clicked on edit colorway season");
			addSrceenShot("clicked on edit colorway season", test, Capture);
			Thread.sleep(3000);
			
			SetUpPage.setupLSE_with_updatedSAPattributes(test);
			test.log(Status.INFO, "Validated before editing any attributes value for SetUpLSE ");
			System.out.println("Validated before editing any attributes value  SetUpLSE");
			addSrceenShot("Validated before editing any attributes value SetUpLSE", test, Capture);
			Thread.sleep(5000);
			
//-------------------------------------------------------------------------------------------------------------			
//---------------------------------------Login AS ADMINISTRATOR--------------------------------------------------
//			driver.quit();
			Thread.sleep(2000);
			initiateObj(Administrator_URL);

//			Thread.sleep(300000);
			
			System.out.println("Browser Launched successfully for Administrator ");
			test.log(Status.INFO, "Browser Launched successfully for Administrator");
			System.out.println("login to flex PLM application successfully for Administrator");
			test.log(Status.INFO, "login to flex PLM application successfully with Administrator URL: "+URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			SetUpPage.SeasonDropdown(season);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: Adoption");
			addSrceenShot("Linesheet view changed", test, Capture);
			
			SetUpPage.SelectColorway(colorway);
			test.log(Status.INFO, "colorway details page opened"+ colorway);
			addSrceenShot("colorway details page opened", test, Capture);

			SetUpPage.ValidateLSE_productdetailspage(test);
			test.log(Status.PASS, "Validation successful for SetUpLSE");
			System.out.println("Validation successful for SetUpLSE");
			addSrceenShot("Validation successful for SetUpLSE", test, Capture);
			Thread.sleep(2000);
			
			SetUpPage.Validate_Administrator_Attributes_for_LSE(test);
			test.log(Status.PASS, "Validation successful for Administrator level Attributes for SetUpLSE");
			System.out.println("Validation successful for Administrator level Attributes for SetUpLSE");
			addSrceenShot("Validation successful for Administrator level Attributes for SetUpLSE", test, Capture);
			Thread.sleep(2000);

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
