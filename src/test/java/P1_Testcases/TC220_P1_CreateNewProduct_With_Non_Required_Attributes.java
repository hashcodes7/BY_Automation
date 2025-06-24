package P1_Testcases;

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

@Test(enabled = true, groups= {"P1_TC"})
public class TC220_P1_CreateNewProduct_With_Non_Required_Attributes extends WMS_TestBase {

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

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Global_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			setReport("TC220_P1_CreateNewProductWithNonRequiredAttributes Verification");
		}
	}

	@Test(priority = 0, dataProvider = "createProductData", dataProviderClass = DataProviders.class)
	public void P1_TC220_CreateNewProduct(String TestType, String season, String productName, String brandHierarchy,
			String classValue, String subClassValue, String proSubCat1, String proSubCat2, String consumer,
			String consumerGrp1, String consumerGrp2, String customsClassification,
			String includeMerchFabricTypeinCWName, String codeType, String productType,
			String productReportCharacteristics, String dimensions, String typeOfClosure, String fitReference,
			String capacity) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC220_P1_CreateNewProductWithNonRequiredAttributes Verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			test.log(Status.INFO, "This test case covers P1 Material module from TC220 to TC223");

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			// URL : LEVIS_GLOBAL
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: - URL -" + Global_URL);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String season = "Levi's S1 2023 Male Accessories";
			//qa//season//Levi's S1 2023 Male Accessories
			//dev//season//Levi's S1 2024 Male Accessories
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

//				String productName = "New_Test_Aum_04";
				productPage.enterProductName(productName);
				test.log(Status.INFO, "Entered product Name successfully");
				addSrceenShot("Entered product Name successfully", test, Capture);
				WaitforPage(4000);

//				String brandHierarchy = "Red Tab Global";
				productPage.selectBrandHierarchy(brandHierarchy);
				test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
				addSrceenShot("Entered Brand Hierarchy value successfully", test, Capture);
				WaitforPage(5000);

//				String classValue = "Belts";
				productPage.selectClass(classValue);
				test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
				addSrceenShot("Entered class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

//				String subClassValue = "Reversible";
				productPage.selectSubClass(subClassValue);
				test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
				addSrceenShot("Entered sub class product Hierarchy successfully", test, Capture);
				WaitforPage(5000);

//				String proSubCat1 = "Bags";
				productPage.selectProSubCat1(proSubCat1);
				test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
				addSrceenShot("Entered product Sub Cat 1 successfully", test, Capture);
				WaitforPage(5000);

//				String proSubCat2 = "Backpack";
				productPage.selectProSubCat2(proSubCat2);
				test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
				addSrceenShot("Entered product Sub Cat 2 successfully", test, Capture);
				WaitforPage(5000);

//				String consumer = "Boys";
				productPage.selectConsumer(consumer);
				test.log(Status.INFO, "Entered consumer successfully: " + consumer);
				addSrceenShot("Entered consumer successfully", test, Capture);
				WaitforPage(5000);

//				String consumerGrp1 = "Boys Infant";
				productPage.selectConsumerGrp1(consumerGrp1);
				test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
				addSrceenShot("Entered consumer Group 1 successfully", test, Capture);
				WaitforPage(5000);

//				String consumerGrp2 = "Regular";
				productPage.selectConsumerGrp2(consumerGrp2);
				test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
				addSrceenShot("Entered consumer Group 2 successfully", test, Capture);
				WaitforPage(5000);

//				String customsClassification = "Accessories";
				productPage.selectcustomsClassification(customsClassification);
				test.log(Status.INFO, "Entered Customs Classification successfully: " + customsClassification);
				test.log(Status.INFO, "Filled All Mandatory Fields");
				addSrceenShot("Entered Customs Classification successfully", test, Capture);
				WaitforPage(5000);

				// All non mandatory feilds
//				String includeMerchFabricTypeinCWName = "No";
//				String codeType = "Normal";
//				String productType = "Product";
//				String productReportCharacteristics = "5 Pocket";
//				String dimensions = "10x5x2";
//				String typeOfClosure = "Buckle";
//				String fitReference = "Not Applicable";
//				String capacity = "19";

				productPage.fillNonMandatoryFieldsinCreateProduct(includeMerchFabricTypeinCWName, codeType, productType,
						productReportCharacteristics, dimensions, typeOfClosure, fitReference, capacity, test);
				System.out.println("Filled All NonMandatory Fields");
				test.log(Status.INFO, "Filled All NonMandatory Fields");
				addSrceenShot("Filled All NonMandatory Fields", test, Capture);
				WaitforPage(4000);

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
				WaitforPage(4000);

				boolean areNonRequiredAttributesFilled = productPage.verifyNonRequiredAttributes(codeType,
						productReportCharacteristics, dimensions, typeOfClosure, fitReference, capacity, test);
				Assert.assertTrue(areNonRequiredAttributesFilled,
						"Non-required attributes were not filled in successfully.");
				System.out.println("Non-required attributes were filled successfully.");
				test.log(Status.PASS, "Verification: Non-required attributes were filled successfully.");
				addSrceenShot("Non-required attributes were filled successfully.", test, Capture);

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
