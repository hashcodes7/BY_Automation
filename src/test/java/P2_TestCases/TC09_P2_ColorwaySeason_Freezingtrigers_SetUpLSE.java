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
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC09_P2_ColorwaySeason_Freezingtrigers_SetUpLSE extends WMS_TestBase {
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
			lineSheetPage = new LineSheetPage(driver);
			SetUpPage = new Set_Up_Page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Colorwaypage= new Colorway_page(driver);
			productPage = new ProductPage(driver);
			setReport("TC09_P2_ColorwaySeason_Freezingtrigers_SetUpLSE");
		}
	}

	@Test(priority = 0,dataProvider = "TC09_P2_ColorwaySeason_Freezingtrigers_SetUpLSE", dataProviderClass = DataProviders.class)
	public void P2_TC_09_Freezingtrigers_LSE(String TestType,String season,String colorway,String linesheetview,String productlifecyclegroup,String lastseasonoffered,
			String currentPlannedLifecycle) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC09_P2_ColorwaySeason_Freezingtrigers_SetUpLSE:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_72 to TC_75");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			SetUpPage.SeasonDropdown(season);
			test.log(Status.INFO, "season selected: "+season);
			addScreenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: Adoption");
			addScreenShot("Linesheet view changed", test, Capture);
			
			SetUpPage.SelectColorway(colorway);
			test.log(Status.INFO, "colorway details page opened"+ colorway);
			addScreenShot("colorway details page opened", test, Capture);
			
			SetUpPage.ValidateLSE_productdetailspage(test);
			test.log(Status.INFO, "Pre-requisite checked for SetUpLSE");
			System.out.println("Pre-requisite checked for SetUpLSE");
			addScreenShot("Pre-requisite checked for SetUpLSE", test, Capture);
			
			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addScreenShot("Colorway season edit page opened", test, Capture);
			Thread.sleep(3000);
			
			SetUpPage.UncheckBox_SetUpLSE(test);
			test.log(Status.INFO, "Checkbox unchecked for SetUpLSE for already setup LSE");
			System.out.println("Checkbox unchecked for SetUpLSE for already setup LSE");
			addScreenShot("Checkbox unchecked for SetUpLSE for already setup LSE", test, Capture);
			Thread.sleep(5000);
			
			SetUpPage.ValidateLSE_productdetailspage(test);
			test.log(Status.PASS, "Validated before editing any attributes value for SetUpLSE ");
			System.out.println("Validated before editing any attributes value  SetUpLSE");
			addScreenShot("Validated before editing any attributes value SetUpLSE", test, Capture);
			Thread.sleep(3000);
			
			SetUpPage.ClickEditColorwayseason();
			System.out.println("clicked on edit colorway season");
			test.log(Status.INFO, "clicked on edit colorway season");
			addScreenShot("clicked on edit colorway season", test, Capture);
			Thread.sleep(3000);

			Colorwaypage.UpdateColorwayseason_SAP_Attributes( productlifecyclegroup, lastseasonoffered, currentPlannedLifecycle,test);
			System.out.println(" Colorway season  SAP Attributes are updated");
			test.log(Status.INFO, "  Colorway season SAP Attributes are updated");
			addScreenShot(" Colorway season Attributes are updated", test, Capture);
			Thread.sleep(5000);
			
			SetUpPage.ClickEditColorwayseason();
			System.out.println("clicked on edit colorway season");
			test.log(Status.INFO, "clicked on edit colorway season");
			addScreenShot("clicked on edit colorway season", test, Capture);
			Thread.sleep(3000);
			
			SetUpPage.setupLSE_with_updatedSAPattributes(test);
			test.log(Status.INFO, "SetUpLSE is done again ");
			System.out.println("SetUpLSE is done again");
			addScreenShot("SetUpLSE is done again", test, Capture);
			Thread.sleep(3000);
			
			SetUpPage.ValidationLSE(test);
			test.log(Status.PASS, "Validation successful for  SetUpLSE after updating SAP attributes");
			addScreenShot("Validation successful for  SetUpLSE after updating SAP attributes", test, Capture);
			
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
