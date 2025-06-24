package AdditionalTestcases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
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
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

public class TC_SetUP_And_Activate_LSE_Linesheet extends WMS_TestBase {
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
	Techpack_pages Techpackpages;
	E2E_Pages E2EPages;
	boolean Capture = true;
	

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
			CNCP = new CreateNewColorPage(driver);
			CCP = new Copy_carryover_page(driver);
			lineSheetPage = new LineSheetPage(driver);
			Colorwaypage = new Colorway_page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			SetUpPage = new Set_Up_Page(driver);
			Techpackpages = new Techpack_pages(driver);
			E2EPages = new E2E_Pages(driver);
			setReport("TC_SetUP_And_Activate_LSE_Linesheet");
		}
	}

	public void initiateObj(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}

	public void initiateObj1(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}
	public void initiateObj2(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}
	public void initiateObj3(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}
	public void initiateObj4(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}
	public void initiateObj5(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}
	public void initiateObj6(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}
	public void initiateObj7(String url) throws InterruptedException {
		driver = invokeBrowser();
		LaunchSpecific_URL(url);
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		palettepage = new Palette_Page(driver);
		CNCP = new CreateNewColorPage(driver);
		CCP = new Copy_carryover_page(driver);
		lineSheetPage = new LineSheetPage(driver);
		Colorwaypage = new Colorway_page(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		SetUpPage = new Set_Up_Page(driver);
		Techpackpages = new Techpack_pages(driver);
		E2EPages = new E2E_Pages(driver);
	}
	@Test(priority = 0, dataProvider = "TC_SetUP_And_Activate_LSE_Linesheet", dataProviderClass = DataProviders.class)
	public void TC_SetUp_and_ActivateLSE_Linesheet(String TestType, String season, String product, String colormenu,
			String colorsubmenu, String filtercolor, String productsegLSUSvalue, String productsegLSEvalue,
			String classification, String producttype, String hubofferedto, String linesheetview, String consumergroup,
			String consumergroupext1, String consumergroupext2, String materialtype, String productmarketingname,
			String rigidindicator, String productlifecyclegroup, String lastseasonoffered,
			String productpricepositioning, String createddate, String filtermaterial, String merchfabrictype,
			String destroysampleInd, String collectionType, String capsule, String sizeGridCode,
			String currentPlannedLifecycle, String linesheetview_FLA, String linesheetview_LSUS, String globalVaue,
			String linesheetview_sizes, String localhub, String newSelectedSizesLH, String affiliate,
			String linesheetview_activation, String currentPlannedLifecycleAFF, String firstOnFloorMonthAFF,
			String dlvySelectedAFF, String ticketCode, String lsusStockingCSC, String targetAFFMSRP,
			String priceWhslAFF, String bucketCodeAFF, String newSelectedSizesAFF,String linesheetview_NRF,
			String LSEStockingvalue,String FirstMonthValue,String Targetmsrpvalue,String NRFclass,String NRFcolor,String NRFsizescale,String primaryfabric)
			throws Exception {
		if (CloseBrowser) {
			test = extent.createTest(":::TC_SetUP_And_Activate_LSE_Linesheet:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This Testcase covers - Creation of Colorway then SetUp and Activation of LSE for the same colorway");
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL : " + Global_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			WaitforPage(5000);
			LineSheetEditPage.filter_View_Change(linesheetview, test);
			System.out.println("Linesheet view changed to: " + linesheetview);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view is " + linesheetview, test, Capture);

			Colorwaypage.SelectProduct(product, test);
			test.log(Status.INFO, "product selected");
			addSrceenShot("product selected", test, Capture);

			Colorwaypage.Create_colorwayLink();
			System.out.println("Colorway page displayed");
			test.log(Status.INFO, "Colorway page displayed");
			addSrceenShot("Colorway page displayed", test, Capture);

//         if colorsubmenu element is not there just keep blank string ----------------------			
			String thumbnail = Colorwaypage.selectcolour(colormenu, colorsubmenu, filtercolor, test);
			System.out.println("color/look Selected ");
			test.log(Status.INFO, " color/look Selected");
			addSrceenShot("color/look Selected ", test, Capture);
			WaitforPage(4000);

			Colorwaypage.MandatoryColorwayDetails_ForLSESetUP(productsegLSUSvalue, productsegLSEvalue, classification,
					producttype, consumergroup, consumergroupext1, consumergroupext2, materialtype,
					productmarketingname, rigidindicator, merchfabrictype, destroysampleInd, collectionType, capsule,
					test);
			System.out.println("All mandatory fields filled");
			test.log(Status.INFO, "All mandatory fields filled");
			addSrceenShot("All mandatory fields filled", test, Capture);
			WaitforPage(4000);
			
			Colorwaypage.MandatoryFields_colorwaySeason_SetUpLSE(hubofferedto, productlifecyclegroup, lastseasonoffered,
					productpricepositioning, createddate, filtermaterial, sizeGridCode, currentPlannedLifecycle, primaryfabric, test);
			System.out.println("Colorway season fields selected and view product clicked");
			test.log(Status.INFO, "Colorway season fields selected and view product clicked");
			addSrceenShot("Colorway season fields selected and view product clicked", test, Capture);

			Thread.sleep(2000);
			String colorwayname = Colorwaypage.validateColorway_creation(filtercolor, test);
			System.out.println("Validated Colorway creation");
			test.log(Status.PASS, "Validated Colorway creation");
			addSrceenShot("Validated Colorway creation", test, Capture);

			Colorwaypage.Navigate_to_firstTab();
			System.out.println("Navigated to linesheet page");
			test.log(Status.INFO, "Navigated to linesheet page");
			addSrceenShot("Navigated to linesheet page", test, Capture);

//		-------------------------Method  for setuP LSE --------------------------------

			JavascriptExecutor js = (JavascriptExecutor) driver;

			Techpackpages.filterdata(colorwayname);
			test.log(Status.INFO, "colorway filtered " + colorwayname);
			addSrceenShot("colorway filtered " + colorwayname, test, Capture);
			System.out.println("colorway filtered " + colorwayname);

			Thread.sleep(5000);

			LineSheetEditPage.filter_View_Change(linesheetview_LSUS, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_LSUS);
			addSrceenShot("Linesheet view is " + linesheetview_LSUS, test, Capture);
			WaitforPage(5000);
			
			LineSheetEditPage.setting_colorway();

			E2EPages.Linesheet_SetUpLSE(test);
			test.log(Status.PASS, " LSE setup completed ");
			System.out.println(" LSE setup completed ");
			addSrceenShot(" LSE setup completed ", test, Capture);
			Thread.sleep(3000);

//			-------------------for Adoption at GB level--------------------------------------------------------

			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view is " + linesheetview, test, Capture);
			WaitforPage(5000);

			Techpackpages.filterdata(colorwayname);
			test.log(Status.INFO, "colorway filtered " + colorwayname);
			addSrceenShot("colorway filtered " + colorwayname, test, Capture);
			System.out.println("colorway filtered " + colorwayname);

			Thread.sleep(5000);

			js.executeScript("document.querySelector('.ag-body-horizontal-scroll-viewport').scrollLeft=0");

			lineSheetPage.selectSeasonGroupAsGlobal(globalVaue, test);
			System.out.println("SeasonGroup As Global choosen");
			test.log(Status.INFO, "selected SeasonGroup As Global choosen: " + globalVaue);
			addSrceenShot("selected SeasonGroup As Global choosen", test, Capture);
			Thread.sleep(3000);

			LineSheetEditPage.Change_AdoptedGB_value(test);
			System.out.println("Adopted GB value is changed to Yes");
			test.log(Status.INFO, "Adopted GB value is changed to Yes ");
			addSrceenShot("Adopted GB value is changed to Yes", test, Capture);

			Thread.sleep(5000);
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
			
//			--------------------------login using Local user------------------------------------------------	
//			--------------------------for adoption at Local level-------------------------------------------

			driver.close();
			Thread.sleep(2000);
//			initiateObj(Brussels_URL);
			initiateObj(Administrator_URL);
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + LocalHub_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);

			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view is " + linesheetview, test, Capture);
			WaitforPage(5000);
//			String colorwayname="0WPL4-0041 MILK HEATHER";
			LineSheetEditPage.changeLocalHub_Value(colorwayname, localhub, test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localhub);
			test.log(Status.INFO, "colorway value filtered: " + colorwayname);
			addSrceenShot("local hub selected and colorway value filtered", test, Capture);
			Thread.sleep(5000);

			Thread.sleep(5000);
			LineSheetEditPage.Change_AdoptedLH_Value(test);
			System.out.println("Adoption LH value changed to YES");
			test.log(Status.INFO, "Adoption LH value changed to YES");
			addSrceenShot("Adoption LH value changed to YES", test, Capture);

			Thread.sleep(5000);
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);

//			--------------------------login using affiliate user------------------------------------------------
//			--------------------------for adoption at Affiliate level-------------------------------------------
			
			driver.close();
			Thread.sleep(2000);
//			initiateObj1(Italy_Affiliate_URL);
			initiateObj6(Administrator_URL);
			
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + Administrator_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);

			WaitforPage(5000);
			LineSheetEditPage.filter_View_Change(linesheetview, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview);
			addSrceenShot("Linesheet view is " + linesheetview, test, Capture);
			WaitforPage(5000);
//			String colorwayname="0WPL4-0052 CRAB APPLE HEATHER";
			LineSheetEditPage.changeLocalHub_Value(colorwayname, localhub, test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localhub);
			test.log(Status.INFO, "colorway value filtered: " + colorwayname);
			addSrceenShot("local hub selected and colorway value filtered", test, Capture);
			Thread.sleep(5000);

			LineSheetEditPage.Affiliate_selection(affiliate, test);
			test.log(Status.INFO, " Affiliate Selected: " + affiliate);
			System.out.println(" Affiliate Selected: " + affiliate);
			addSrceenShot("Affiliate Selected", test, Capture);
			Thread.sleep(5000);

			LineSheetEditPage.Change_AdoptedAFF_Value(test);
			test.log(Status.PASS, "Adopted AFF value is changed to Yes");
			System.out.println("Adopted AFF value is changed to Yes");
			addSrceenShot("Adopted AFF value is changed to Yes", test, Capture);

			WaitforPage(5000);
			
//		---------------------Login as Global User----------------------------------------------------------------------
//		--------------------------for Size change at Global level-------------------------------------------
			
			driver.close();
			Thread.sleep(2000);
			initiateObj2(Global_URL);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + Global_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			dashboardPage.closeLeftPanel();
			test.log(Status.INFO, "Closed Left panel");
			addSrceenShot("Closed Left panel", test, Capture);

			LineSheetEditPage.filter_View_Change(linesheetview_sizes, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_sizes);
			addSrceenShot("Linesheet view is " + linesheetview_sizes, test, Capture);
			WaitforPage(4000);

			Techpackpages.filterdata(colorwayname);
			test.log(Status.INFO, "colorway filtered " + colorwayname);
			addSrceenShot("colorway filtered " + colorwayname, test, Capture);
			System.out.println("colorway filtered " + colorwayname);

			Thread.sleep(5000);

			lineSheetPage.selectSeasonGroupAsGlobal(globalVaue, test);
			System.out.println("SeasonGroup As Global choosen");
			test.log(Status.INFO, "selected SeasonGroup As Global choosen: " + globalVaue);
			addSrceenShot("selected SeasonGroup As Global choosen", test, Capture);
			Thread.sleep(3000);


			lineSheetPage.selectAndVerifySizeGridCode(sizeGridCode, test);
			System.out.println("Sizing Attributes are Updated Successfully For Global");
			test.log(Status.PASS, "Sizing Attributes are Updated Successfully For Global");
			addSrceenShot("Sizing Attributes are Updated Successfully For Global", test, Capture);

			WaitforPage(5000);
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);

//			--------------------------login using Local user------------------------------------------------	
//			--------------------------for Size change at Local level-------------------------------------------

			driver.close();
			Thread.sleep(2000);
			initiateObj3(Administrator_URL);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + LocalHub_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.filter_View_Change(linesheetview_sizes, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_sizes);
			addSrceenShot("Linesheet view is " + linesheetview_sizes, test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.changeLocalHub_Value(colorwayname, localhub, test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localhub);
			test.log(Status.INFO, "colorway value filtered: " + colorwayname);
			addSrceenShot("local hub selected and colorway value filtered", test, Capture);

			lineSheetPage.editSelectedSizesLH(newSelectedSizesLH, test);
			System.out.println("Edited 'Selected sizes-LH'");
			test.log(Status.PASS, "Edited 'Selected sizes-LH'" + newSelectedSizesLH);
			addSrceenShot("Edited 'Selected sizes-LH'", test, Capture);

			lineSheetPage.editSelectedSizesLHLocked(test);
			System.out.println("Edited 'Selected sizes LH Locked?'");
			test.log(Status.PASS, "Edited 'Selected sizes LH Locked?'");
			addSrceenShot("Edited 'Selected sizes LH Locked?'", test, Capture);
			test.log(Status.PASS, "Sizing Attributes are Updated Successfully For Local");

			WaitforPage(4000);
						
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
//
//		--------------------------login using affiliate user------------------------------------------------
//		--------------------------for Size change at Affiliate level-------------------------------------------
//
			driver.close();
			Thread.sleep(2000);
//			initiateObj4(Italy_Affiliate_URL);
			initiateObj4(Administrator_URL);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + Affiliate_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.filter_View_Change(linesheetview_sizes, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_sizes);
			addSrceenShot("Linesheet view is " + linesheetview_sizes, test, Capture);
			WaitforPage(5000);
			
//			String colorwayname= "0WQ8L-0003 ULTRAVIOLET HEATHER";
			LineSheetEditPage.changeLocalHub_Value(colorwayname, localhub, test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localhub);
			test.log(Status.INFO, "colorway value filtered: " + colorwayname);
			addSrceenShot("local hub selected and colorway value filtered", test, Capture);
			Thread.sleep(5000);

			LineSheetEditPage.Affiliate_selection(affiliate, test);
			test.log(Status.INFO, " Affiliate Selected: " + affiliate);
			System.out.println(" Affiliate Selected: " + affiliate);
			addSrceenShot("Affiliate Selected", test, Capture);
			Thread.sleep(5000);

			lineSheetPage.editSelectedSizesAFF(newSelectedSizesAFF, test);
			System.out.println("Edited 'Selected sizes-AFF'");
			test.log(Status.PASS, "Edited 'Selected sizes-AFF'" + newSelectedSizesLH);
			addSrceenShot("Edited 'Selected sizes-AFF'", test, Capture);

			lineSheetPage.editSelectedSizesAFFLocked(test);
			System.out.println("Edited 'Selected sizes AFF Locked?'");
			test.log(Status.PASS, "Edited 'Selected sizes AFF Locked?'");
			addSrceenShot("Edited 'Selected sizes AFF Locked?'", test, Capture);
			test.log(Status.PASS, "Sizing Attributes are Updated Successfully For Affiliate");
			WaitforPage(4000);

			
//			----------------------------------login As Administrator user--------------------------------------
//			-------------------------------------Add NRF Values------------------------------------------------
			driver.close();
			Thread.sleep(2000);
			initiateObj5(Administrator_URL);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + Affiliate_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.filter_View_Change(linesheetview_NRF, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_NRF);
			addSrceenShot("Linesheet view is " + linesheetview_NRF, test, Capture);
			WaitforPage(5000);
			
			String colorwaycode=colorwayname.substring(0, 11);
			LineSheetEditPage.changeLocalHub_Value(colorwaycode, localhub, test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localhub);
			test.log(Status.INFO, "colorway value filtered: " + colorwayname);
			addSrceenShot("local hub selected and colorway value filtered", test, Capture);
			Thread.sleep(5000);

			LineSheetEditPage.Affiliate_selection(affiliate, test);
			test.log(Status.INFO, " Affiliate Selected: " + affiliate);
			System.out.println(" Affiliate Selected: " + affiliate);
			addSrceenShot("Affiliate Selected", test, Capture);
			Thread.sleep(5000);

			
			LineSheetEditPage.UpdateNRF_Attributes( colorwaycode, LSEStockingvalue, FirstMonthValue, Targetmsrpvalue, NRFclass, NRFcolor, NRFsizescale, test);
			System.out.println("NRF Attributes are Updated Successfully");
			test.log(Status.PASS, "NRF Attributes are Updated Successfully ");
			addSrceenShot("NRF Attributes are Updated Successfully", test, Capture);
			
			Thread.sleep(5000);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
			
			
//			--------------------------login using affiliate user------------------------------------------------	
			driver.close();
			Thread.sleep(2000);
//			initiateObj6(Italy_Affiliate_URL);
			initiateObj6(Administrator_URL);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + Affiliate_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			Colorwaypage.SeasonDropdown(season, test);
			test.log(Status.INFO, "season selected: " + season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.filter_View_Change(linesheetview_activation, test);
			test.log(Status.INFO, "Linesheet view changed to: " + linesheetview_activation);
			addSrceenShot("Linesheet view is " + linesheetview_activation, test, Capture);
			WaitforPage(5000);
			
			Techpackpages.filterdata(colorwayname);
			test.log(Status.INFO, "colorway filtered " + colorwayname);
			addSrceenShot("colorway filtered " + colorwayname, test, Capture);
			System.out.println("colorway filtered " + colorwayname);
			
			LineSheetEditPage.Affiliate_selection(affiliate, test);
			test.log(Status.INFO, " Affiliate Selected: " + affiliate);
			System.out.println(" Affiliate Selected: " + affiliate);
			addSrceenShot("Affiliate Selected", test, Capture);
			Thread.sleep(5000);

			lineSheetPage.updateAttributes_ActivateLSE(currentPlannedLifecycleAFF, firstOnFloorMonthAFF, dlvySelectedAFF,
					ticketCode, lsusStockingCSC, targetAFFMSRP, priceWhslAFF, bucketCodeAFF, test);

			test.log(Status.INFO, "All mandatory attributes are filled for Activate LSE and activation is complete");
			System.out.println("All mandatory attributes are filled for Activate LSE and activation is complete");
			addSrceenShot("All mandatory attributes are filled for Activate LSE and activation is complete", test,
					Capture);
			

			lineSheetPage.verifyActivation_LSE(test);
			test.log(Status.PASS, "Validation successful for Activate LSE");
			System.out.println("Validation successful for Activate LSE");
			addSrceenShot("Validation successful for Activate LSE", test, Capture);
			Thread.sleep(10000);

			

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
