package CreateMultiple_TestData;

import java.awt.AWTException;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BusinessObjectPage;

import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;

import com.WMS_Utilities.WMS_TestBase;

import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_CreateMultipleSeasonGroupToSKULink_VerifyStagingRowID extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	LineSheet_Edit_Page LineSheetEditPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	BusinessObjectPage businessObjectPage;

	boolean Capture = true;
	private String global_URL;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Global user before executing this test
	 * case
	 */

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Administrator_URL;
			LaunchSpecific_URL(global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			businessObjectPage = new BusinessObjectPage(driver);

			setReport("TC20_P3_Validate_StagingRowID_CreationOfSeasonGroupToSKULink");
		}
	}

	@Test(priority = 0, dataProvider = "Multiple_Staging_CreateSeasonGroupToSKULink", dataProviderClass = DataProviders.class)
	public void P3_TC20_CreateSeasonGroupAndAssociateColorway(String[][] testData)
			throws Exception {

		for (int i = 0; i < testData.length; i++) {
	        String[] data = testData[i];
	        String TestType = data[0];
	        String season = data[1];
	        String viewType = data[2];
	        String seasonGroupName = data[3];
	        String colorwayName = data[4];
	        String businessObjectType = data[5];
	        String actionType = data[6];
	        String messageTableValue = data[7];
	        String hierarchyValue = data[8];
	        
			if (CloseBrowser) {

				test = extent
						.createTest(":::TC20_P3_Validate_StagingRowID_CreationOfSeasonGroupToSKULink:::");

			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();
			System.out.println(startTime);
			try {

				test.log(Status.INFO,
						"This test case covers TestData_Scripts(P3) DV Integration (TC_Integration Staging  _020_create seasongrouptoskulink)");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addSrceenShot("Browser Launched", test, Capture);

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

				mainMenuPage.chooseMySeasonType(season);
				System.out.println("season type is choosen");
				test.log(Status.INFO, "season type is choosen: " + season);
				addSrceenShot("Season type is choosen", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.INFO, "Clicked on Line Sheets");
				addSrceenShot("Clicked on Line Sheets", test, Capture);

				lineSheetPage.selectViewDropdown(viewType);
				System.out.println("View type is choosen");
				test.log(Status.INFO, "View type is choosen: " + viewType);
				addSrceenShot("View type is choosen", test, Capture);

				// Step 1: Click on options icon
				lineSheetPage.clickOptionsIcon(test);
				System.out.println("Clicked on options icon");
				test.log(Status.INFO, "Clicked on options icon");
				addSrceenShot("Clicked on options icon", test, Capture);
				WaitforPage(2000);

				// Step 2: Click on create new season group icon
				lineSheetPage.clickCreateNewSeasonGroupIcon(test);
				System.out.println("Clicked on create new season group icon");
				test.log(Status.INFO, "Clicked on create new season group icon");
				addSrceenShot("Clicked on create new season group icon", test, Capture);
				WaitforPage(2000);

				// Step 3: Fill attributes (give Name in name field)
//			String seasonGroupName = "test_SG_01";
				lineSheetPage.fillSeasonGroupAttributes(seasonGroupName, test);
				System.out.println("Filled season group attributes with name: " + seasonGroupName);
				test.log(Status.INFO, "Filled season group attributes with name: " + seasonGroupName);
				addSrceenShot("Filled season group attributes", test, Capture);
				WaitforPage(2000);

				// Step 4: Click on create
				lineSheetPage.clickCreateButton(test);
				System.out.println("Clicked on create button");
				test.log(Status.INFO, "Clicked on create button");
				addSrceenShot("Clicked on create button", test, Capture);
				WaitforPage(2000);

				lineSheetPage.selectViewDropdown(viewType);
				System.out.println("View type is choosen");
				test.log(Status.INFO, "View type is choosen: " + viewType);
				addSrceenShot("View type is choosen", test, Capture);

				// Step 5: Verify season group creation in season group dropdown and selected
				lineSheetPage.verifySeasonGroupCreationAndSelect(seasonGroupName, test);
				System.out.println("Verified season group creation in dropdown and selected");
				test.log(Status.INFO, "Verified season group creation in dropdown and selected: " + seasonGroupName);
				addSrceenShot("Verified season group creation in dropdown and selected", test, Capture);
				WaitforPage(2000);

				// Step 6: Click on apply
				lineSheetPage.clickApplyButton(test);
				System.out.println("Clicked on apply button");
				test.log(Status.INFO, "Clicked on apply button");
				addSrceenShot("Clicked on apply button", test, Capture);
				WaitforPage(2000);

				// Associate colorway to season group
				// Step 1: Click on options icon
				lineSheetPage.clickOptionsIcon(test);
				System.out.println("Clicked on options icon");
				test.log(Status.INFO, "Clicked on options icon");
				addSrceenShot("Clicked on options icon", test, Capture);
				WaitforPage(2000);

				// Step 2: Click on add colorways option
				lineSheetPage.clickAddColorwaysOption(test);
				System.out.println("Clicked on add colorways option");
				test.log(Status.INFO, "Clicked on add colorways option");
				addSrceenShot("Clicked on add colorways option", test, Capture);
				WaitforPage(2000);

				lineSheetPage.select_ViewDropdown(viewType);
				System.out.println("View type is choosen");
				test.log(Status.INFO, "View type is choosen: " + viewType);
				addSrceenShot("View type is choosen", test, Capture);

				// Step 3: Filter colorway name and click on checkbox
//			String colorwayName = "0WPPT-0001 Test01";
				lineSheetPage.filter_Colorway(colorwayName, test);
				System.out.println("filtered By Colorway name: " + colorwayName);
				test.log(Status.INFO, "filtered By Colorway name: " + colorwayName);
				addSrceenShot("filtered By Colorway name", test, Capture);
				WaitforPage(2000);

				lineSheetPage.selectColorwayCheckbox(colorwayName, test);
				System.out.println("Selected colorway checkbox: " + colorwayName);
				test.log(Status.INFO, "Selected colorway checkbox: " + colorwayName);
				addSrceenShot("Selected colorway checkbox", test, Capture);
				WaitforPage(2000);

				// Capture the current time in GMT
				LocalDateTime saveTime = LocalDateTime.now(ZoneId.of("GMT"));
				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
				System.out.println(timeFormatter);

				String formattedDate = saveTime.format(dateFormatter);
				String formattedTime = saveTime.format(timeFormatter);
				String hourFrom = String.format("%02d", saveTime.getHour());
				String hourTo = String.format("%02d", saveTime.plusHours(1).getHour());

				// Log the exact GMT time and date
				test.log(Status.INFO, "Selected colorway checkbox and select option clicked at GMT time: "
						+ formattedTime + " on date: " + formattedDate);
				System.out.println("Selected colorway checkbox and select option clicked at GMT time: " + formattedTime
						+ " on date: " + formattedDate);
				addSrceenShot("Save button clicked", test, Capture);

				// Step 4: Click on select option
				lineSheetPage.clickSelectOption(test);
				System.out.println("Clicked on select option");
				test.log(Status.INFO, "Clicked on select option");
				addSrceenShot("Clicked on select option", test, Capture);
				WaitforPage(2000);

				// Step 5: Verify success message
				lineSheetPage.verifySuccessMessage(test);
				System.out.println("Verified success message: added successfully");
				test.log(Status.PASS, "Verified success message: added successfully");
				addSrceenShot("Verified success message", test, Capture);
				WaitforPage(4000);

				driver.manage().deleteAllCookies();
				driver.navigate().refresh();

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.INFO, "Clicked on open Left plane");
				addSrceenShot("Clicked on open Left plane", test, Capture);

				mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_BUSSINESS.menu(), true);
				addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
				System.out.println("Clicked on Business Object");
				test.log(Status.INFO, "Clicked on Business Object");
				addSrceenShot("Clicked on Business Object", test, Capture);
				WaitforPage(4000);

				businessObjectPage.chooseBusinessObjectType(businessObjectType);
				System.out.println("Business object type chosen: " + businessObjectType);
				test.log(Status.INFO, "Business object type chosen: " + businessObjectType);
				addSrceenShot("Business object type chosen", test, Capture);
				WaitforPage(4000);

				businessObjectPage.chooseActionType(actionType);
				System.out.println("Action type chosen: " + actionType);
				test.log(Status.INFO, "Action type chosen: " + actionType);
				addSrceenShot("Action type chosen", test, Capture);
				WaitforPage(4000);

				businessObjectPage.enterEventHourFrom(hourFrom);
				System.out.println("Event Hour From: " + hourFrom);
				test.log(Status.INFO, "Event Hour From: " + hourFrom);
				addSrceenShot("Event Hour From", test, Capture);
				WaitforPage(4000);

				businessObjectPage.enterEventHourTo(hourTo);
				System.out.println("Event Hour TO: " + hourTo);
				test.log(Status.INFO, "Event Hour TO: " + hourTo);
				addSrceenShot("Event Hour TO", test, Capture);
				WaitforPage(4000);

				businessObjectPage.enterCreatedDate(formattedDate);
				System.out.println("Entered Created Date: " + formattedDate);
				test.log(Status.INFO, "Entered Created Date: " + formattedDate);
				addSrceenShot("Entered Created Date", test, Capture);
				WaitforPage(4000);

//			String messageTableValue = "*LSCOSeasonGroupToSKULink*";
				businessObjectPage.enterMessageTable(messageTableValue);
				System.out.println("Entered Message Table: " + messageTableValue);
				test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
				addSrceenShot("Entered Created Date", test, Capture);
				WaitforPage(4000);

//			String hierarchyValue = "*LSCO\\Levis*";
				businessObjectPage.enterHierarchy(hierarchyValue);
				System.out.println("Entered Hierarchy: " + hierarchyValue);
				test.log(Status.INFO, "Entered Hierarchy: " + hierarchyValue);
				addSrceenShot("Entered Hierarchy", test, Capture);
				WaitforPage(4000);

				businessObjectPage.clickSearch();
				System.out.println("Clicked on Search");
				test.log(Status.INFO, "Clicked on Search");
				addSrceenShot("Clicked on Search", test, Capture);
				WaitforPage(4000);

				// Verify the staging row ID
				businessObjectPage.verifyStagingRowId(test);
				addSrceenShot("Staging Row ID is updated in LSCOTransactionTable", test, Capture);


				if (i == testData.length - 1) {
					// Last iteration, perform logout
					dashboardPage.closeLeftPanel();
					System.out.println("Clicked on close Left plane");
					test.log(Status.INFO, "Clicked on close Left plane");
					addSrceenShot("Clicked on close Left plane", test, Capture);

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.INFO, "Logout successful");
					addSrceenShot("Logout successful", test, Capture);
				} else {
					// Delete all cookies and Refresh the browser
					driver.manage().deleteAllCookies();
					driver.navigate().refresh();
				}
				
			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;
			}
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}
