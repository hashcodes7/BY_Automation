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

import Excel_Utilities.DataProviders;

@Test(enabled = true, groups= {"P3_TC"})
public class TC_P3_CreateMultipleFemaleProduct_ValidateUniqueProductCode extends WMS_TestBase {

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
			;
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC_P3_CreateMultipleFemaleProduct_ValidateUniqueProductCode");
		}
	}

	@Test(priority = 0, dataProvider = "Multple_CreateFemaleProduct_ValidateUniqueProductCode", dataProviderClass = DataProviders.class)

	public void P3_TC02_CreateFemaleProduct_ValidateUniqueProductCode(String[][] testData)
			throws Exception {

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

				test = extent.createTest(":::TC_P3_CreateMultipleFemaleProduct_ValidateUniqueProductCode:::");

			}

			CloseBrowser = false;

			// ...............................browser launched time starts

			long startTime = System.nanoTime();

			try {

				test.log(Status.INFO,
						"This test case covers TestData_Scripts(P3) Lucee 'TS01_PC5_Code Generation for Style code' ");

				System.out.println("Browser Launched successfully");
				test.log(Status.INFO, "Browser Launched successfully");
				addScreenShot("Browser Launched", test, Capture);

				System.out.println("login to flex PLM application successfully");
				test.log(Status.INFO, "login to flex PLM application successfully: " + global_URL);
				addScreenShot("Login successful", test, Capture);

				Thread.sleep(5000);

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

				try {

					lineSheetPage.createProduct();
					test.log(Status.INFO, "Clicked on Create New product");
					addScreenShot("Clicked on Create New product", test, Capture);
					WaitforPage(4000);

					productPage.enterProductName(productName);
					test.log(Status.INFO, "Entered product Name successfully: " + productName);
					addScreenShot("Entered product Name successfully", test, Capture);
					WaitforPage(4000);

					productPage.selectBrandHierarchy(brandHierarchy);
					test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
					addScreenShot("Entered Brand Hierarchy value successfully", test, Capture);
					WaitforPage(5000);

					productPage.selectProSubCat1(proSubCat1);
					test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
					addScreenShot("Entered product Sub Cat 1 successfully", test, Capture);
					WaitforPage(5000);

					productPage.selectProSubCat2(proSubCat2);
					test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
					addScreenShot("Entered product Sub Cat 2 successfully", test, Capture);
					WaitforPage(5000);

					productPage.selectClass(classValue);
					test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
					addScreenShot("Entered class product Hierarchy successfully", test, Capture);
					WaitforPage(5000);

					productPage.selectSubClass(subClassValue);
					test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
					addScreenShot("Entered sub class product Hierarchy successfully", test, Capture);
					WaitforPage(5000);

					productPage.selectConsumer(consumer);
					test.log(Status.INFO, "Entered consumer successfully: " + consumer);
					addScreenShot("Entered consumer successfully", test, Capture);
					WaitforPage(5000);

					productPage.selectConsumerGrp1(consumerGrp1);
					test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
					addScreenShot("Entered consumer Group 1 successfully", test, Capture);
					WaitforPage(5000);

					productPage.selectConsumerGrp2(consumerGrp2);
					test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
					addScreenShot("Entered consumer Group 2 successfully", test, Capture);
					WaitforPage(5000);

					productPage.clikOnSaveBtn();
					test.log(Status.INFO, "Clicked on save button successfully");
					addScreenShot("Clicked on save button successfully", test, Capture);
					WaitforPage(2000);

					productPage.clikViewProduct();
					test.log(Status.INFO, "Clicked on View Product successfully");
					addScreenShot("Clicked on View Product successfully", test, Capture);
					WaitforPage(2000);

					// Verify product name
					String product_Name = productPage.getProductName();
					if (product_Name.equals(productName)) {
						test.log(Status.PASS, "Product name verification--- PC5 is created: " + productName);
						addScreenShot("Product name verification", test, Capture);
					} else {
						test.log(Status.FAIL, "Product name verification: Failed");
						addScreenShot("Product name verification", test, Capture);
					}

					// Validate the product code generation
					String actualProductCode = productPage.getProductCode();
					if (actualProductCode != null && !actualProductCode.isEmpty()) {
						test.log(Status.PASS, "Unique product code is generated: " + actualProductCode);
						addScreenShot("Unique product code is generated: " + actualProductCode, test, Capture);
					} else {
						test.log(Status.FAIL, "Unique product code is not generated");
						addScreenShot("Unique product code is not generated", test, Capture);
					}

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
						 // Delete all cookies and Refresh the browser
						driver.manage().deleteAllCookies();
						driver.navigate().refresh();
					}

				} catch (Exception e) {
					System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;

				}

			} catch (

			Exception e) {
				System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;
			}
		}

	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}

}
