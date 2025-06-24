package P1_Testcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.SourcingPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;

@Test(enabled = true, groups= {"P1_TC"})
public class TC_011_MultipleColorwaySources extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	SourcingPage sourcingPage;
	SpecificationPage specificationPage;
	
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
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage =new LineSheet_Edit_Page(driver);
			sourcingPage = new SourcingPage(driver);
			specificationPage =new SpecificationPage(driver);
			setReport("TC_011 Multiple Colorways to Multiple sources association through Linesheet");
		}
	}

	@Test( priority = 0, dataProvider = "multiple_colorways_sources", dataProviderClass = DataProviders.class)

	public void P0_TC_008_multipleColorwaysSources(String TestType,String season,String linesheetview1,String linesheetview2,String productCode) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC_011 Multiple Colorways to Multiple sources association through Linesheet:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers from TC_261 to 263");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + URL);
			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "opened left panel");
			addSrceenShot("opened left panel", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "Season selected: "+season);
			addSrceenShot("Season selected:"+season, test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(linesheetview1,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview1);
			addSrceenShot("Linesheet view changed to: "+linesheetview1, test, Capture);
			WaitforPage(5000);
			
			sourcingPage.multiplecolorwaySourcesAssociation(test,productCode);
			test.log(Status.PASS, "multiple colorways associated to multiple sources successfully");
			addSrceenShot("multiple colorways associated to multiple sources successfully", test, Capture);
			WaitforPage(5000); 
			
			LineSheetEditPage.filter_View_Change(linesheetview2,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview2);
			addSrceenShot("Linesheet view changed to: "+linesheetview2, test, Capture);
			WaitforPage(5000);
			
			specificationPage.SelectColorway(test);
			test.log(Status.INFO, "colorway selected");
			addSrceenShot("colorway selected", test, Capture);
			
			specificationPage.SelectIncludeAllSources(test);
			test.log(Status.INFO, "Include All Sources is selected");
			addSrceenShot("Include All Sources selected", test, Capture); 
			
			specificationPage.clickOnApply(test);
			addSrceenShot("colorway selected", test, Capture); 
			
			sourcingPage.validateMultipleColorwaySourcesAssociation(test);
			test.log(Status.PASS, "multiple colorways associated to multiple sources are validated");
			addSrceenShot("multiple colorways associated to multiple sources are validated", test, Capture);
			WaitforPage(5000);
			
			
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