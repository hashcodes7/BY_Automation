package P0_TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
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
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC17_P0_CopyProduct extends WMS_TestBase{
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	Colorway_page Colorwaypage;
	
	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP =new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Colorwaypage = new Colorway_page(driver);
			setReport("TC17_P0 Copy product to a new season of same brand");
		}
	}
	@Test(priority = 0,dataProvider = "TC17_P0_CopyProduct", dataProviderClass = DataProviders.class)
	public void P0_TC_017_Copy_product_to_a_new_season_of_same_brand(String TestType,String season,String product,String newseason,String filtervalue,String newname) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC17_P0 Copy product to a new season of same brand:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();	
		try {
			test.log(Status.INFO, "This testcase covers TC_53 to TC_58");
			
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
			
			CCP.SeasonDropdown(season);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(filtervalue,test);
			test.log(Status.INFO, "Linesheet view changed to: "+filtervalue);
			addSrceenShot("Linesheet view changed", test, Capture);
			
			Colorwaypage.SelectProduct(product, test);
			test.log(Status.INFO, "Product details got displayed");
			addSrceenShot("Product details got displayed", test, Capture);
			
//			String newname=product+"_"+String.valueOf(Math.random()*5);
			CCP.CopyProduct(newname,newseason,test);
			test.log(Status.INFO, "New Season selected and all the Attributes are selected");
			addSrceenShot("New Season selected and all the Attributes are selected", test, Capture);
			WaitforPage(5000);
			
			CCP.Update_productName(test, newname);
			test.log(Status.INFO, "Product Name Updated and copied to a new season");
			addSrceenShot("Product Name Updated and copied to a new season", test, Capture);
			WaitforPage(5000);
			
			CCP.Validate_CopyProduct(newname,test);
			test.log(Status.PASS, "Validated copied product");
			addSrceenShot("Validated copied product", test, Capture);
			System.out.println("Validated copied product");
			
		
			
			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
			
			
		}catch (Exception e) {
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
