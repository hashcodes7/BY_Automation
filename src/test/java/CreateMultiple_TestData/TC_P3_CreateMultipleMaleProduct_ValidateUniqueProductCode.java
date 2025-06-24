package CreateMultiple_TestData;

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
import org.testng.Assert;
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


import resources.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_CreateMultipleMaleProduct_ValidateUniqueProductCode extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;

	boolean Capture = true;
	private String global_URL;


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
			global_URL = Global_URL_STG;
			LaunchSpecific_URL(global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC_P3_CreateMultipleMaleProduct_ValidateUniqueProductCode");
		}
	}

	@Test(priority = 0, dataProvider = "Multple_CreateMaleProduct_ValidateUniqueProductCode", dataProviderClass = DataProviders.class)

	public void P3_TC01_CreateMaleProduct_ValidateUniqueProductCode(String[][] testData) throws Exception {

		for (int i = 0; i < testData.length; i++) {
	        String[] data = testData[i];
	        String season = data[1];
	        String productName = data[2];
	        String brandHierarchy = data[3];
	        String proSubCat1 = data[4];
	        String proSubCat2 = data[5];
	        String classValue = data[6];
	        String subClassValue = data[7];
	        String consumer = data[8];
	        String consumerGrp1 = data[9];
	        String consumerGrp2 = data[10];

			if (CloseBrowser) {

				test = extent.createTest(":::TC_P3_CreateMultipleMaleProduct_ValidateUniqueProductCode:::");

			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();

			try {

				test.log(Status.INFO,
						"This test case covers TestData_Scripts(P3) Lucee 'TS01_PC5_Code Generation for Style code' ");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addSrceenShot("Browser Launched", test, Capture);

				// URL : LEVIS_GLOBAL
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

				try {

					lineSheetPage.createProduct();
					test.log(Status.INFO, "Clicked on Create New product");
					addSrceenShot("Clicked on Create New product", test, Capture);
					WaitforPage(4000);

					productPage.enterProductName(productName);
					test.log(Status.INFO, "Entered product Name successfully: " + productName);
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
						test.log(Status.PASS, "Product name verification--- PC5 is created: " + productName);
						addSrceenShot("Product name verification", test, Capture);
					} else {
						test.log(Status.FAIL, "Product name verification: Failed");
						addSrceenShot("Product name verification", test, Capture);
					}

					// Validate the product code generation
					String actualProductCode = productPage.getProductCode();
					if (actualProductCode != null && !actualProductCode.isEmpty()) {
						test.log(Status.PASS, "Unique product code is generated: " + actualProductCode);
						addSrceenShot("Unique product code is generated: " + actualProductCode, test, Capture);
					} else {
						test.log(Status.FAIL, "Unique product code is not generated");
						addSrceenShot("Unique product code is not generated", test, Capture);
					}

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

			} catch (

			Exception e) {
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
