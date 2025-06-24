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
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC191_P1_CreatePC9_usingPaletteColor extends WMS_TestBase {
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
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			palettepage = new Palette_Page(driver);
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage =new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			setReport("TC191_P1_CreatePC9_usingPaletteColor");
		}
	}

	@Test(priority = 0,dataProvider = "TC191_P1_CreatePC9_usingPaletteColor", dataProviderClass = DataProviders.class)
	public void P1_TC25_VerifyLookdetails_InCreatePC9(String TestType,String season,String product,String palettecolorname,String productsegLSUSvalue,
			String productsegLSEvalue,String classification,String producttype,String hubofferedto,String linesheetview) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC191_P1_CreatePC9_usingPaletteColor:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_60");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL: "+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			Colorwaypage.SeasonDropdown(season,test);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);
			
			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			WaitforPage(5000);
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: "+linesheetview);
			addSrceenShot("Linesheet view is "+linesheetview, test, Capture);
			Thread.sleep(2000);
			Colorwaypage.SelectProduct(product,test);
			test.log(Status.INFO, "product selected: "+product);
			addSrceenShot("product selected"+product, test, Capture);
			System.out.println("product selected"+product);
			Thread.sleep(2000);
			
			Colorwaypage.Create_colorwayLink();
			System.out.println("Colorway page displayed");
			test.log(Status.INFO, "Colorway page displayed");
			addSrceenShot("Colorway page displayed", test, Capture);
			Thread.sleep(2000);
			

			String thumbnail=Colorwaypage.create_Color_palette(palettecolorname,test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addSrceenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.MandatoryDetails(productsegLSUSvalue,productsegLSEvalue,classification,producttype,test);
			System.out.println("All required fields filled");
			test.log(Status.INFO, "All required fields filled");
			addSrceenShot("All required fields filled", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.colorwayseasonfield(hubofferedto,test);
			System.out.println("Colorway season fields selected and view product clicked");
			test.log(Status.INFO, "Colorway season fields selected and view product clicked");
			addSrceenShot("Colorway season fields selected and view product clicked", test, Capture);
			
			Colorwaypage.validateColorway_creation(palettecolorname, test);
			System.out.println("Validation successful for Colorway ");
			test.log(Status.PASS, "Validation successful for Colorway ");
			addSrceenShot("Validation successful for Colorway ", test, Capture);
			
			Colorwaypage.thumbnailValidations(test,thumbnail);
			System.out.println("Thumbnail Validation is Successful ");
			test.log(Status.PASS, "Thumbnail Validation is Successful");
			addSrceenShot("Thumbnail Validation is Successful", test, Capture);
			
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

