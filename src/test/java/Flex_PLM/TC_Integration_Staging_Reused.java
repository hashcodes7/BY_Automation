package Flex_PLM;

import static org.testng.Assert.assertNotNull;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.BusinessObjectPage;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.MaterialPage;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

public class TC_Integration_Staging_Reused extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	BusinessObjectPage businessObjectPage;
	LineSheetPage lineSheetPage;
	MaterialPage materialPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;
	public Test_Rail_Actions testactions = new Test_Rail_Actions();

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
			businessObjectPage = new BusinessObjectPage(driver);
			setReport("TC_Integration_Staging_Reused");
		}
	}

	@Test(priority = 0, dataProvider = "fabricRecordsData", dataProviderClass = DataProviders.class)
	public void TC__Integration_Staging_Reused(String TestType, String typeOfFabric, String fabricType,
			String seasonFirstIntroduced, String fabricDescription, String uom, Map<String, String> fabricContents)
			throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC_Integration_Staging_Reused:::");
		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();
		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers material module from 134 to 137");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully" + URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			System.out.println("login successful");
			test.log(Status.INFO, "login successful");

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.openSubMenu1(MainMenuEnum.LIBRARIES.menu(), MainMenuEnum.LIBRARIES_MATERIAL.menu(), true);
			addSrceenShot("Clicked on Main menu of Libraries", test, Capture);
			System.out.println("Clicked on Material");
			test.log(Status.INFO, "Clicked on Material");
			addSrceenShot("Clicked on Material", test, Capture);
			WaitforPage(4000);	
			
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1)); // Switch to new tab

			driver.get(URL); 
			Thread.sleep(4000);
			addSrceenShot("Opened URL", test, Capture);
			
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


			String businessObjectType =  "LSCOTransactionTable";
			businessObjectPage.chooseBusinessObjectType(businessObjectType);
		    System.out.println("Business object type chosen: "+businessObjectType);
		    test.log(Status.INFO, "Business object type chosen: "+businessObjectType);
		    addSrceenShot("Business object type chosen", test, Capture);
		    WaitforPage(4000);

			String actionType =  "Create";
			businessObjectPage.chooseActionType(actionType);
		    System.out.println("Action type chosen: "+actionType);
		    test.log(Status.INFO, "Action type chosen: "+actionType);
		    addSrceenShot("Action type chosen", test, Capture);
		    WaitforPage(4000);
		    
			String createdDate =  "10/09/2024";
		    businessObjectPage.enterCreatedDate(createdDate);
		    System.out.println("Entered Created Date: " + createdDate);
		    test.log(Status.INFO, "Entered Created Date: " + createdDate);
		    addSrceenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    
		    String messageTableValue =  "*LSCOMaterial*";
		    businessObjectPage.enterMessageTable(messageTableValue);
		    System.out.println("Entered Message Table: " + messageTableValue);
		    test.log(Status.INFO, "Entered Message Table: " + messageTableValue);
		    addSrceenShot("Entered Created Date", test, Capture);
		    WaitforPage(4000);
		    
		    String hierarchyValue =  "*LSCO\\Fabric\\Knits*";
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
		    
		    

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Test case failed due to exception: " + e.getMessage());
		}
	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}