package Flex_PLM;

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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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


import junit.framework.Assert;
import resources.DataProviders;

@Test(enabled = true, groups = { "Single_Orders" })
public class PC5_Create_Update extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;

	int CartSlot = 6;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			launchUrl();
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("PC5 Create and update from Line Sheet");
		}
	}

	@Test( priority = 0, dataProvider = "SinglesBagOrder_Cartoon", dataProviderClass = DataProviders.class)

	public void orderAllocation(String OrderNumber, String OrderNumber2, String CompleteSpecs, String CompleteSpecs2,
			String CompleteSpecs3, String CompleteSpecs4, String CompleteSpecs5, String CompleteSpecs6,
			String CompleteSpecs7, String TotUserKey, String LocationKey, String CARTKEY, String CompleteSpecs8,
			String CompleteSpecs9, String PackStation) throws Exception {
		try {
			if (!OrderNumber.equals(" ")) {
				if (CloseBrowser) {

					test = extent.createTest(":::PC5 Create and update from Line Sheet:::");

				}

				CloseBrowser = false;

				// ...............................browser launched time starts

				long startTime = System.nanoTime();

				System.out.println("Browser Launched successfully");
				test.log(Status.PASS, "Browser Launched successfully");

				System.out.println("login to flex PLM application successfully");
				test.log(Status.PASS, "login to flex PLM application successfully");

				Thread.sleep(5000);

				dashboardPage.openLeftPanel();
				System.out.println("Clicked on open Left plane");
				test.log(Status.PASS, "Clicked on open Left plane");
				addSrceenShot("Clicked on open Left plane", test, Capture);
				// mainMenuPage.openSubMenu(MainMenuEnum.LIBRARIES.menu(),
				// MainMenuEnum.LIBRARIES_Season.menu());

				mainMenuPage.openSubMenu(MainMenuEnum.SESSION.menu(), MainMenuEnum.SESSION_LINE_SHEET.menu());
				addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

				lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
				test.log(Status.PASS, "Clicked on Line Sheets");
				addSrceenShot("Clicked on Line Sheets", test, Capture);
				try {

					lineSheetPage.createProduct();
					test.log(Status.PASS, "Clicked on Create New product");
					addSrceenShot("Clicked on Create New product", test, Capture);

					String productName = "TST7";
					productPage.enterProductName(productName);
					test.log(Status.PASS, "Entered product Name successfully");
					addSrceenShot("Entered product Name successfully", test, Capture);
					WaitforPage(4000);

//					productPage.selectBrandHierarchy();
//					test.log(Status.PASS, "Entered Brand Hierarchy value successfully");
//					addSrceenShot("Entered Brand Hierarchy value successfully", test, Capture);
//					WaitforPage(2000);
//
//					productPage.selectProSubCat1();
//					test.log(Status.PASS, "Entered product Sub Cat 1 successfully");
//					addSrceenShot("Entered product Sub Cat 1 successfully", test, Capture);
//					WaitforPage(2000);
//
//					productPage.selectClass();
//					test.log(Status.PASS, "Entered class product Hierarcy successfully");
//					addSrceenShot("Entered class product Hierarcy successfully", test, Capture);
//					WaitforPage(2000);
//
//					productPage.selectSubClass();
//					test.log(Status.PASS, "Entered sub class product Hierarcy successfully");
//					addSrceenShot("Entered sub class product Hierarcy successfully", test, Capture);
//					WaitforPage(2000);
//
//					productPage.selectConsumer();
//					test.log(Status.PASS, "Entered consumer successfully");
//					addSrceenShot("Entered consumer successfully", test, Capture);
//					WaitforPage(2000);
//
//					productPage.selectConsumerGrp1();
//					test.log(Status.PASS, "Entered consumer Group 1 successfully");
//					addSrceenShot("Entered consumer Group 1 successfully", test, Capture);
//					WaitforPage(2000);
//
//					productPage.selectConsumerGrp2();
//					test.log(Status.PASS, "Entered product Name successfully");
//					addSrceenShot("Entered product Name successfully", test, Capture);
//					WaitforPage(2000);

					productPage.clikOnSaveBtn();
					test.log(Status.PASS, "Clicked on save button successfully");
					addSrceenShot("Clicked on save button successfully", test, Capture);
					WaitforPage(2000);

					/*
					 * productPage.clikOnLineSheet(); test.log(Status.PASS,
					 * "Clicked on Go to Line sheet successfully");
					 * addSrceenShot("Clicked on Go to Line sheet successfully", test, Capture);
					 * WaitforPage(2000);
					 */

					productPage.clikViewProduct();
					test.log(Status.PASS, "Clicked on View Product successfully");
					addSrceenShot("Clicked on View Product successfully", test, Capture);
					WaitforPage(2000);

					productPage.editProduct();
					test.log(Status.PASS, "Clicked on edit Product");
					addSrceenShot("Clicked on edit Product", test, Capture);

					productPage.selectCapsule();
					test.log(Status.PASS, "Updated capsule value successfully");
					addSrceenShot("Updated capsule value successfully", test, Capture);
					WaitforPage(2000);

					productPage.clikOnSaveBtn();
					test.log(Status.PASS, "Clicked on save button successfully");
					addSrceenShot("Clicked on save button successfully", test, Capture);
					WaitforPage(2000);

					productPage.clikCreatedProduct(productName);
					test.log(Status.PASS, "Clicked on created product successfully :" + productName);
					addSrceenShot("Clicked on created product successfully", test, Capture);

					dashboardPage.closeLeftPanel();
					System.out.println("Clicked on close Left plane");
					test.log(Status.PASS, "Clicked on close Left plane");
					addSrceenShot("Clicked on close Left plane", test, Capture);

					dashboardPage.Logout();
					System.out.println("Logout successful");
					test.log(Status.PASS, "Logout successful");
					addSrceenShot("Logout successful", test, Capture);

				} catch (Exception e) {
					System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness");
		throw e;

				}
			}
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