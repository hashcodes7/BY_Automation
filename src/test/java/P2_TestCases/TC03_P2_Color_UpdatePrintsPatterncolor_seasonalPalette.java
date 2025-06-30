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
public class TC03_P2_Color_UpdatePrintsPatterncolor_seasonalPalette  extends WMS_TestBase {
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
			setReport("TC03_P2_Color_UpdatePrintsPatterncolor_seasonalPalette");
		}
	}

	@Test(priority = 0,dataProvider = "TC03_P2_Color_UpdatePrintsPatterncolor_seasonalPalette", dataProviderClass = DataProviders.class)
	public void P2_TC03_UpdatePrintsPatterncolor_seasonalPalette(String TestType,String season, String colorname,String artworkcode,
			String artworkname) 
					throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC03_P2_Color_UpdatePrintsPatterncolor_seasonalPalette:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This tescase covers TC_06 and TC_07");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL: "+URL);
			
			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addScreenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addScreenShot("My seasons menu clicked", test, Capture);
			
			palettepage.SeasonDropdown(season);
			System.out.println("Season value seleted:"+season);
			test.log(Status.INFO, "Season value seleted:"+season);
			addScreenShot("Season value seleted"+season, test, Capture);

			palettepage.palettemenu();
			System.out.println("Clicked on Palette");
			test.log(Status.INFO, "Clicked on Palette");
			addScreenShot("Clicked on Palette", test, Capture);
			
			palettepage.Click_PrintsandPatterns_color(colorname,test);
			System.out.println("color details page opened");
			test.log(Status.INFO, "color details page opened");
			addScreenShot("color details page opened", test, Capture);
			
			Thread.sleep(2000);
			palettepage.NavigateTo_updatecolorPage();
			System.out.println("Navigated to Update color page");
			test.log(Status.INFO, "Navigated to Update color page");
			addScreenShot("Navigated to Update color page", test, Capture);
			
			palettepage.update_colorAttributes(artworkcode, artworkname, test);
			System.out.println("Updated Attributes for prints and patterns color");
			test.log(Status.INFO, "Updated Attributes for prints and patterns color");
			addScreenShot("Updated Attributes for prints and patterns color", test, Capture);
			
			palettepage.validate_UpdatedAttributes(artworkcode, artworkname, test);
			System.out.println("Validation successful for updated Attributes for prints and patterns color");
			test.log(Status.PASS, "Validation successful for updated Attributes for prints and patterns color");
			addScreenShot("Validation successful for updated Attributes for prints and patterns color", test, Capture);
			
			
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

