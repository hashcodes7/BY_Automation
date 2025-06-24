package TestData_Testcases;

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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BusinessObjectPage;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;


import resources.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC18_P3_Staging_CreateProduct_VerifyStagingID extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	BusinessObjectPage businessObjectPage;

	boolean Capture = true;
	private String global_URL;



	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	/**
	 * Note: Ensure you are logged in as a Global user before executing this test case
	 */
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			global_URL = Global_URL;
			LaunchSpecific_URL(global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			businessObjectPage = new BusinessObjectPage(driver);
			setReport("TC18_P3_validate_StagingRowID_CreateProduct");
		}
	}

	@Test(priority = 0, dataProvider = "TC18_P3_Integration_Staging_CreateProduct", dataProviderClass = DataProviders.class)
	public void P0_TC02_E2E_ProductCreation(String TestType, String season, String productName, String brandHierarchy,
			String proSubCat1, String proSubCat2, String classValue, String subClassValue, String consumer,
			String consumerGrp1, String consumerGrp2, String businessObjectType, String actionType, String messageTableValue, String hierarchyValue) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC18_P3_Staging_CreateProduct:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO,"This test case covers TestData_Scripts(P3) DV Integration (TC_Integration Staging  _018_Create Product)");

			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: "+global_URL);
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

			try {

				lineSheetPage.createProduct();
				test.log(Status.INFO, "Clicked on Create New product");
				addSrceenShot("Clicked on Create New product", test, Capture);
				WaitforPage(4000);

				productPage.enterProductName(productName);
				test.log(Status.INFO, "Entered product Name successfully");
				addSrceenShot("Entered product Name successfully", test, Capture);
				WaitforPage(4000);

				productPage.selectBrandHierarchy(brandHierarchy);
				test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
				addSrceenShot("Entered Brand Hierarchy value successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectProSubCat1(proSubCat1);
				test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
				addSrceenShot("Entered product Sub Cat 1 successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectProSubCat2(proSubCat2);
				test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
				addSrceenShot("Entered product Sub Cat 2 successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectClass(classValue);
				test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
				addSrceenShot("Entered class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectSubClass(subClassValue);
				test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
				addSrceenShot("Entered sub class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectConsumer(consumer);
				test.log(Status.INFO, "Entered consumer successfully: " + consumer);
				addSrceenShot("Entered consumer successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectConsumerGrp1(consumerGrp1);
				test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
				addSrceenShot("Entered consumer Group 1 successfully", test, Capture);
				WaitforPage(5000);

				productPage.selectConsumerGrp2(consumerGrp2);
				test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
				addSrceenShot("Entered consumer Group 2 successfully", test, Capture);
				WaitforPage(5000);

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
				test.log(Status.INFO, "Save button clicked at GMT time: " + formattedTime + " on date: " + formattedDate);
				System.out.println("Save button clicked at GMT time: " + formattedTime + " on date: " + formattedDate);
				addSrceenShot("Save button clicked", test, Capture);
				
				productPage.clikOnSaveBtn();
				test.log(Status.INFO, "Clicked on save button successfully");
				addSrceenShot("Clicked on save button successfully", test, Capture);
				WaitforPage(2000);

				productPage.clikViewProduct();
				test.log(Status.INFO, "Clicked on View Product successfully");
				addSrceenShot("Clicked on View Product successfully", test, Capture);
				WaitforPage(2000);

				// Verify product name
				String product_Name = productPage.getProductName();
				if (product_Name.equals(productName)) {
					test.log(Status.PASS, "Product name verification--- PC5 is created: " + product_Name);
					addSrceenShot("Product name verification", test, Capture);
				} else {
					test.log(Status.FAIL, "Product name verification: Failed");
					addSrceenShot("Product name verification", test, Capture);
				}
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

//				String messageTableValue = "*LSCOProduct*";
				businessObjectPage.enterMessageTable(messageTableValue);
				System.out.println("Entered Message Table: " + messageTableValue);
				test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
				addSrceenShot("Entered Created Date", test, Capture);
				WaitforPage(4000);

//				String hierarchyValue = "*LSCO\\Levis*";
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

				dashboardPage.closeLeftPanel();
				System.out.println("Clicked on close Left plane");
				test.log(Status.INFO, "Clicked on close Left plane");
				addSrceenShot("Clicked on close Left plane", test, Capture);

				dashboardPage.Logout();
				System.out.println("Logout successful");
				test.log(Status.INFO, "Logout successful");
				addSrceenShot("Logout successful", test, Capture);
				

			} catch (Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;

			}

		} catch (

		Exception e) {
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
