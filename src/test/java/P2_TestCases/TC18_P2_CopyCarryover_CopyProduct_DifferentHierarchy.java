package P2_TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC18_P2_CopyCarryover_CopyProduct_DifferentHierarchy extends WMS_TestBase{
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	LineSheetPage lineSheetPage;
	LineSheet_Edit_Page LineSheetEditPage;
	ProductPage productPage;
	boolean Capture = true;

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP =new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			productPage = new ProductPage(driver);
			setReport("TC18_P2_CopyCarryover_CopyProduct_DifferentHierarchy");
		}
	}
	@Test(priority = 0,dataProvider = "TC18_P2_CopyCarryover_CopyProduct_DifferentHierarchy", dataProviderClass = DataProviders.class)
	public void P0_TC_018_Copy_product_differentHierarchy(String TestType,String season,String product,String newseason,String filtervalue,String newname,
			String updatedBrandHierarchy, String updatedClassValue,String updatedSubClassValue, String updatedProSubCat1,
			String updatedProSubCat2, String updatedConsumer,String updatedConsumerGrp1, String updatedConsumerGrp2, String updatedCustomsClassification) throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC18_P2_CopyCarryover_CopyProduct_DifferentHierarchy:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();	
		try {
			test.log(Status.INFO, "This testcase covers TC_53 to TC_58");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");	
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+Global_URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			CCP.SeasonDropdown(season);
			test.log(Status.INFO, "season selected: "+season);
			addScreenShot("season selected", test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			
			WaitforPage(5000);
			
			LineSheetEditPage.filter_View_Change(filtervalue,test);
			test.log(Status.INFO, "Linesheet view changed to: "+filtervalue);
			addScreenShot("Linesheet view changed", test, Capture);
			
			CCP.openProduct(product);
			test.log(Status.INFO, "Product details got displayed");
			addScreenShot("Product details got displayed", test, Capture);
			
//			String newname=product+"_"+String.valueOf(Math.random()*5);
			CCP.CopyProduct(newname,newseason,test);
			test.log(Status.INFO, "New Season selected and all the Attributes are selected");
			addScreenShot("New Season selected and all the Attributes are selected", test, Capture);
			WaitforPage(5000);
			
			CCP.UpdateAllMandatoryFields(newname, updatedBrandHierarchy,  updatedClassValue, updatedSubClassValue,  updatedProSubCat1,
					 updatedProSubCat2,  updatedConsumer, updatedConsumerGrp1,  updatedConsumerGrp2,  updatedCustomsClassification,test);
			test.log(Status.INFO, "Product Name Updated and copied to a new season");
			addScreenShot("Product Name Updated and copied to a new season", test, Capture);
			WaitforPage(5000);
	
			CCP.Validate_CopyProduct(newname,test);
			test.log(Status.PASS, "Validated copied product");
			addScreenShot("Validated copied product", test, Capture);
			System.out.println("Validated copied product");
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addScreenShot("Clicked on Logout successful", test, Capture);
			
			
		}catch (Exception e) {
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
