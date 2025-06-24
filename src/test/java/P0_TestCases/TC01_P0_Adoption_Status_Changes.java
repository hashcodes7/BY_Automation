package P0_TestCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.ColorWayPage;
import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.E2E_Pages;
import com.WMS_ApplicationPages.LSEProductSegmentationPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_ApplicationPages.Techpack_pages;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P0_TC"})
public class TC01_P0_Adoption_Status_Changes extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheet_Edit_Page LineSheetEditPage;
	LineSheetPage lineSheetPage;

	boolean Capture = true;
	private String global_URL;
	private String localHub_URL;
	private String affiliate_URL;
	private String admin_URL;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	@BeforeMethod
	/**
	 * Note: Ensure you are logged in as a Global, Local And Affiliate users before
	 * executing this test case
	 */
	public void navigateToGlobalURL() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Global_URL_STG;
			LaunchSpecific_URL(global_URL);
			initializePages();
			setReport("TC01_P3_UpdateSeasonGroupColorway_CheckLogEntry");

		}
	}

	public void navigateToLocalHubURL() throws InterruptedException {
		driver = invokeBrowser();
		localHub_URL = Sanfrancisco_URl_STG;
		LaunchSpecific_URL(localHub_URL);
		initializePages();
	}

	public void navigateToAffiliateURL() throws InterruptedException {
		driver = invokeBrowser();
		affiliate_URL = AFF_URL_STG;
		LaunchSpecific_URL(affiliate_URL);
		initializePages();
	}

	public void initializePages() {
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		lineSheetPage = new LineSheetPage(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
	}

	@Test(priority = 0, dataProvider = "adoptionData", dataProviderClass = DataProviders.class)

	public void P0_TC01_Adoption_Status_Changes(String TestType, String mySeasonType, String viewType,
			String colorwayName, String globalVaue, String localHubValue, String affiliateValue)
			throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC01_P0_AdoptedGB_AdoptedLH_and_AdoptedAFF Status Changes Verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers linesheet module from 80 to 85");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + global_URL);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);

			lineSheetPage.filterProduct(colorwayName, test);
			System.out.println("filtered By Colorway name: " + colorwayName);
			test.log(Status.INFO, "filtered By Colorway name: " + colorwayName);
			addSrceenShot("filtered By Colorway name", test, Capture);

			lineSheetPage.selectSeasonGroupAsGlobal(globalVaue, test);
			System.out.println("value for Seasonal groups gloabl selected is: " + globalVaue);
			test.log(Status.INFO, "value for Seasonal groups gloabl selected is: " + globalVaue);
			addSrceenShot("value for Seasonal groups gloabl selected", test, Capture);

			lineSheetPage.changeTheAdoptedGBToYes(test);
			System.out.println("changed AdoptedGB to Yes");
			test.log(Status.PASS, "changed AdoptedGB to Yes");
			addSrceenShot("changed AdoptedGB to Yes", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);

//			--------------------------login using Local user------------------------------------------------	
//			--------------------------for adoption at Local level-------------------------------------------

			driver.close();
			Thread.sleep(2000);
			navigateToLocalHubURL();
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + localHub_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);

			lineSheetPage.filterProduct(colorwayName, test);
			System.out.println("filtered By Colorway name: " + colorwayName);
			test.log(Status.INFO, "filtered By Colorway name: " + colorwayName);
			addSrceenShot("filtered By Colorway name", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.changeSeasonalGroupsLocalHub_Value(localHubValue, test);
			test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localHubValue);
			addSrceenShot("value for Seasonal groups Local hub selected", test, Capture);
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
			navigateToAffiliateURL();
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully with URL :  " + affiliate_URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);

			lineSheetPage.filterProduct(colorwayName, test);
			System.out.println("filtered By Colorway name: " + colorwayName);
			test.log(Status.INFO, "filtered By Colorway name: " + colorwayName);
			addSrceenShot("filtered By Colorway name", test, Capture);
			WaitforPage(5000);

			LineSheetEditPage.changeSeasonalGroupsAffiliate_Value(localHubValue, affiliateValue, test);
			test.log(Status.INFO, "value for Seasonal groups Affiliate selected is: " + affiliateValue);
			addSrceenShot("value for Seasonal groups Affiliate selected", test, Capture);
			Thread.sleep(5000);

			LineSheetEditPage.Change_AdoptedAFF_Value(test);
			test.log(Status.PASS, "Adopted AFF value is changed to Yes");
			System.out.println("Adopted AFF value is changed to Yes");
			addSrceenShot("Adopted AFF value is changed to Yes", test, Capture);
			WaitforPage(5000);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);

			// Note: The "Logout" dropdown menu is not visible for Affiliate users.
			// To make the "Logout" option visible, reduce the screen size by 10%.
			// This can be achieved by pressing "Control" and "-" keys together.
			ReduceScreenSizeBy10Percent();
			Thread.sleep(2000);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addSrceenShot("Logout successful", test, Capture);


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
