package CreateMultiple_TestData;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import com.WMS_ApplicationPages.LogEntry_page;
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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups = { "P3_TC" })
public class TC_P3_Multiple_UpdateSeasonGroupColorway_CheckLogEntry extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheet_Edit_Page LineSheetEditPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	LogEntry_page LogEntrypage;

	boolean Capture = true;
	private String global_URL;
	private String localHub_URL;
	private String affiliate_URL;
	private String admin_URL;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Global, Local And Affiliate users before
	 * executing this test case
	 */
	@BeforeMethod
	public void navigateToGlobalURL() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Global_URL;
			LaunchSpecific_URL(global_URL);
			initializePages();
			setReport("TC_P3_Multiple_UpdateSeasonGroupColorway_CheckLogEntry");

		}
	}

	public void navigateToLocalHubURL() throws InterruptedException {
		driver = invokeBrowser();
		localHub_URL = LocalHub_URL;
		LaunchSpecific_URL(localHub_URL);
		initializePages();
	}

	public void navigateToAffiliateURL() throws InterruptedException {
		driver = invokeBrowser();
		affiliate_URL = Affiliate_URL;
		LaunchSpecific_URL(affiliate_URL);
		initializePages();
	}

	/**
	 * Navigate to the Administrator URL to check log entry because Global user does
	 * not have log entry access.
	 */

	public void navigateToAdministratorURL() throws InterruptedException {
		admin_URL = Administrator_URL;
		LaunchSpecific_URL(admin_URL);
	}

	public void initializePages() {
		dashboardPage = new DashboardPage(driver);
		mainMenuPage = new MainMenuPage(driver);
		lineSheetPage = new LineSheetPage(driver);
		LineSheetEditPage = new LineSheet_Edit_Page(driver);
		LogEntrypage = new LogEntry_page(driver);
	}

	@Test(priority = 0, dataProvider = "Multiple_UpdateSeasonGroupColorway_CheckLogEntry", dataProviderClass = DataProviders.class)

	public void P3_TC01_UpdateSeasonGroupColorway_CheckLogEntry(String[][] testData) throws Exception {
		for (int i = 0; i < testData.length; i++) {
			String[] data = testData[i];
			String TestType = data[0];
			String season = data[1];
			String viewType = data[2];
			String colorwayName = data[3];
			String globalVaue = data[4];
			String localHubValue = data[5];
			String affiliateValue = data[6];
			String LogEntryObject = data[7];
			String event = data[8];

			if (CloseBrowser) {

				test = extent.createTest(":::TC_P3_Multiple_UpdateSeasonGroupColorway_CheckLogEntry:::");

			}

			CloseBrowser = false;

			startKeepScreenAwake();
			// ...............................browser launched time starts

			long startTime = System.nanoTime();
			try {

				test.log(Status.INFO, "This test case covers linesheet module from 80 to 85");
				Thread.sleep(5000);

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addScreenShot("Browser Launched", test, Capture);

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: - URL -" + global_URL);
				addScreenShot("Login successful", test, Capture);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addScreenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.clickOnMySeasons();
				test.log(Status.INFO, "Clicked on MySeasons");
				addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

				mainMenuPage.chooseMySeasonType(season);
				System.out.println("season type is choosen");
				test.log(Status.INFO, "season type is choosen: " + season);
				addScreenShot("Season type is choosen", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addScreenShot("Clicked on Line Sheets", test, Capture);

				lineSheetPage.selectViewDropdown(viewType);
				System.out.println("View type is choosen");
				test.log(Status.INFO, "View type is choosen: " + viewType);
				addScreenShot("View type is choosen", test, Capture);

				lineSheetPage.filterProduct(colorwayName, test);
				System.out.println("filtered By Colorway name: " + colorwayName);
				test.log(Status.INFO, "filtered By Colorway name: " + colorwayName);
				addScreenShot("filtered By Colorway name", test, Capture);

				lineSheetPage.selectSeasonGroupAsGlobal(globalVaue, test);
				System.out.println("value for Seasonal groups gloabl selected is: " + globalVaue);
				test.log(Status.INFO, "value for Seasonal groups gloabl selected is: " + globalVaue);
				addScreenShot("value for Seasonal groups gloabl selected", test, Capture);

				lineSheetPage.changeTheAdoptedGBToYes(test);
				System.out.println("changed AdoptedGB to Yes");
				test.log(Status.PASS, "changed AdoptedGB to Yes");
				addScreenShot("changed AdoptedGB to Yes", test, Capture);

				dashboardPage.Logout();
				System.out.println("Logout successful");
				test.log(Status.INFO, "Logout successful");
				addScreenShot("Logout successful", test, Capture);

//			--------------------------login using Local user------------------------------------------------	
//			--------------------------for adoption at Local level-------------------------------------------

				driver.close();
				Thread.sleep(2000);
				navigateToLocalHubURL();

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addScreenShot("Browser Launched", test, Capture);

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: - URL -" + localHub_URL);
				addScreenShot("Login successful", test, Capture);

				dashboardPage.openLeftPanel();
				test.log(Status.INFO, "Left panel opened");
				addScreenShot("Left panel opened", test, Capture);

				mainMenuPage.clickOnMySeasons();
				test.log(Status.INFO, "Clicked on MySeasons");
				addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

				mainMenuPage.chooseMySeasonType(season);
				System.out.println("season type is choosen");
				test.log(Status.INFO, "season type is choosen: " + season);
				addScreenShot("Season type is choosen", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addScreenShot("Clicked on Line Sheets", test, Capture);

				lineSheetPage.selectViewDropdown(viewType);
				System.out.println("View type is choosen");
				test.log(Status.INFO, "View type is choosen: " + viewType);
				addScreenShot("View type is choosen", test, Capture);

				lineSheetPage.filterProduct(colorwayName, test);
				System.out.println("filtered By Colorway name: " + colorwayName);
				test.log(Status.INFO, "filtered By Colorway name: " + colorwayName);
				addScreenShot("filtered By Colorway name", test, Capture);
				WaitforPage(5000);

				LineSheetEditPage.changeSeasonalGroupsLocalHub_Value(localHubValue, test);
				test.log(Status.INFO, "value for Seasonal groups Local hub selected is: " + localHubValue);
				addScreenShot("value for Seasonal groups Local hub selected", test, Capture);
				Thread.sleep(5000);

				Thread.sleep(5000);
				LineSheetEditPage.Change_AdoptedLH_Value(test);
				System.out.println("Adoption LH value changed to YES");
				test.log(Status.INFO, "Adoption LH value changed to YES");
				addScreenShot("Adoption LH value changed to YES", test, Capture);

				Thread.sleep(5000);
				dashboardPage.Logout();
				System.out.println("Logout successful");
				addScreenShot("Clicked on Logout successful", test, Capture);

//			--------------------------login using affiliate user------------------------------------------------
//			--------------------------for adoption at Affiliate level-------------------------------------------
				driver.close();
				Thread.sleep(2000);
				navigateToAffiliateURL();

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addScreenShot("Browser Launched", test, Capture);

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: - URL -" + affiliate_URL);
				addScreenShot("Login successful", test, Capture);

				dashboardPage.openLeftPanel();
				test.log(Status.INFO, "Left panel opened");
				addScreenShot("Left panel opened", test, Capture);

				mainMenuPage.clickOnMySeasons();
				test.log(Status.INFO, "Clicked on MySeasons");
				addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

				mainMenuPage.chooseMySeasonType(season);
				System.out.println("season type is choosen");
				test.log(Status.INFO, "season type is choosen: " + season);
				addScreenShot("Season type is choosen", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addScreenShot("Clicked on Line Sheets", test, Capture);

				lineSheetPage.selectViewDropdown(viewType);
				System.out.println("View type is choosen");
				test.log(Status.INFO, "View type is choosen: " + viewType);
				addScreenShot("View type is choosen", test, Capture);

				lineSheetPage.filterProduct(colorwayName, test);
				System.out.println("filtered By Colorway name: " + colorwayName);
				test.log(Status.INFO, "filtered By Colorway name: " + colorwayName);
				addScreenShot("filtered By Colorway name", test, Capture);
				WaitforPage(5000);

				LineSheetEditPage.changeSeasonalGroupsAffiliate_Value(localHubValue, affiliateValue, test);
				test.log(Status.INFO, "value for Seasonal groups Affiliate selected is: " + affiliateValue);
				addScreenShot("value for Seasonal groups Affiliate selected", test, Capture);
				Thread.sleep(5000);

				LineSheetEditPage.Change_AdoptedAFF_Value(test);
				test.log(Status.PASS, "Adopted AFF value is changed to Yes");
				System.out.println("Adopted AFF value is changed to Yes");
				addScreenShot("Adopted AFF value is changed to Yes", test, Capture);
				WaitforPage(5000);

				// Capture the current time in GMT after changing adopted AFF value to yes
				LocalDateTime saveTime = LocalDateTime.now(ZoneId.of("GMT"));
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String createddate = saveTime.format(dateFormatter);

				// Log the exact date
				test.log(Status.INFO, "Adopted AFF value updated on date: " + createddate);
				System.out.println("Adopted AFF value updated on date: " + createddate);
				addScreenShot("Adopted AFF value updated on date: ", test, Capture);

				/**
				 * Open new tab and login using Administrator user for checking LogEntry
				 */

				driver.manage().deleteAllCookies();
				openNewTabAndSwitch();
				navigateToAdministratorURL();
				test.log(Status.INFO,
						"Open new tab and Navigate to the Administrative User for checking Log Entry: - URL - "
								+ admin_URL);
				addScreenShot("Navigate to the Administrative User", test, Capture);
				Thread.sleep(4000);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addScreenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.LibraryMenu(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_LOG_ENTRY.menu());
				test.log(Status.INFO, "Clicked on Libraries menu");
				addScreenShot("Clicked on Libraries menu", test, Capture);

				Thread.sleep(2000);

				LogEntrypage.select_LogEntryObject(LogEntryObject, test);
				System.out.println("Log Entry Object is selected ");
				test.log(Status.INFO, "Log Entry Object is selected");
				addScreenShot("Log Entry Object is selected", test, Capture);
				Thread.sleep(2000);

				LogEntrypage.Add_criteria(event, createddate, test);
				System.out.println("Criteria is added ");
				test.log(Status.INFO, "Criteria is added");
				addScreenShot("Criteria is added", test, Capture);
				Thread.sleep(2000);

				LogEntrypage.clickedFirst_viewdetails();
				System.out.println("view details page is opened ");
				test.log(Status.INFO, "view details page is opened ");

				Thread.sleep(3000);
				LogEntrypage.validate_Logdetails(event, LogEntryObject, test);
				System.out.println("Validation successful for Log Entry details ");
				test.log(Status.PASS, "Validation successful for Log Entry details");
				addScreenShot("Validation successful for Log Entry details", test, Capture);

				if (i == testData.length - 1) {
					// Last iteration, perform logout
					dashboardPage.closeLeftPanel();
					System.out.println("Clicked on close Left plane");
					test.log(Status.INFO, "Clicked on close Left plane");
					addScreenShot("Clicked on close Left plane", test, Capture);

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addScreenShot("Logout successful", test, Capture);
				} else {
				    // Not the last iteration, switch to the first tab, close the second tab, and navigate to global url
					switchToFirstTabAndCloseSecond();
					driver.manage().deleteAllCookies();
					driver.navigate().to(global_URL);
				}
				
			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
				test.log(Status.FAIL, "Test case failed due to application slowness " + e);
				throw e;
			}finally {
				stopKeepScreenAwake();
			}
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}
