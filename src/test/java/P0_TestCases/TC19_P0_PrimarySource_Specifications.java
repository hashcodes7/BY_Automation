package P0_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.WMS_ApplicationPages.SpecificationPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Excel_Utilities.DataProviders;

import org.openqa.selenium.JavascriptExecutor;
import junit.framework.Assert;

@Test(enabled = true, groups= {"P0_TC"})
public class TC19_P0_PrimarySource_Specifications extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	SeasonPage seasonPage;
	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	MainMenuPage mainMenuPage;
	SpecificationPage specificationPage;


	boolean Capture = true;


	List<HashMap<String, String>> data_ItemTable = null;

	String batchNo;
	public static XSSFSheet templatesheet = null;
	List<HashMap<String, String>> BaseTemplate = null;
	
	/**
	 * Note: Ensure you are logged in as a Admin user before executing
	 * this test case because pds user does not showing customsrc attr
	 */

	@BeforeMethod
	public void setUp() throws InterruptedException {
		if (CloseBrowser) {
			driver = invokeBrowser();
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			specificationPage = new SpecificationPage(driver);
			setReport("TC_19_Verify attributes on  create of  Primary Source  and Specification");
		}
	}

	@Test(priority = 0, dataProvider = "primarySource_Data", dataProviderClass = DataProviders.class)
	public void P0_TC_19(String TestType, String mySeasonType, String productName, String brandHierarchy,
			String proSubCat1, String proSubCat2, String classValue, String subClassValue, String consumer,
			String consumerGrp1, String consumerGrp2) throws Exception {

		if (CloseBrowser) {
			test = extent.createTest(":::TC_19_Verify attributes on  create of  Primary Source  and Specification:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addScreenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers Specification module from 246 to 249");

			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + Administrator_URL);
			addScreenShot("login to flex PLM application successfully", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addScreenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addScreenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String mySeasonType = "Levi's S1 2024 Male Accessories";
			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addScreenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addScreenShot("Clicked on Line Sheets", test, Capture);
			lineSheetPage.createProduct();
			WaitforPage(3000);

			lineSheetPage.createProduct();
			test.log(Status.INFO, "Clicked on Create New product");
			addScreenShot("Clicked on Create New product", test, Capture);
			WaitforPage(3000);

//			String productName = "SPECTEST_Demo_gn04";
			productPage.enterProductName(productName);
			test.log(Status.INFO, "Entered product Name successfully");
			addScreenShot("Entered product Name successfully", test, Capture);
			WaitforPage(3000);

//			String brandHierarchy = "Red Tab Global";
			productPage.selectBrandHierarchy(brandHierarchy);
			test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
			addScreenShot("Entered Brand Hierarchy value successfully", test, Capture);
			WaitforPage(3000);

//			String proSubCat1 = "Bags";
			productPage.selectProSubCat1(proSubCat1);
			test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
			addScreenShot("Entered product Sub Cat 1 successfully", test, Capture);
			WaitforPage(3000);

//			String proSubCat2 = "BackPack";
			productPage.selectProSubCat2(proSubCat2);
			test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
			addScreenShot("Entered product Sub Cat 2 successfully", test, Capture);
			WaitforPage(3000);

//			String classValue = "Belts";
			productPage.selectClass(classValue);
			test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
			addScreenShot("Entered class product Hierarchy successfully", test, Capture);
			WaitforPage(3000);

//			String subClassValue = "Reversible";
			productPage.selectSubClass(subClassValue);
			test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
			addScreenShot("Entered sub class product Hierarchy successfully", test, Capture);
			WaitforPage(3000);

//			String consumer = "Mens";
			productPage.selectConsumer(consumer);
			test.log(Status.INFO, "Entered consumer successfully: " + consumer);
			addScreenShot("Entered consumer successfully", test, Capture);
			WaitforPage(3000);

//			String consumerGrp1 = "Adult Mens";
			productPage.selectConsumerGrp1(consumerGrp1);
			test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
			addScreenShot("Entered consumer Group 1 successfully", test, Capture);
			WaitforPage(3000);

//			String consumerGrp2 = "Regular";
			productPage.selectConsumerGrp2(consumerGrp2);
			test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
			addScreenShot("Entered consumer Group 2 successfully", test, Capture);
			WaitforPage(3000);

			productPage.clikOnSaveBtn();
			test.log(Status.INFO, "Clicked on save button successfully");
			addScreenShot("Clicked on save button successfully", test, Capture);
			WaitforPage(2000);

			productPage.clikViewProduct();
			test.log(Status.INFO, "Clicked on View Product successfully");
			addScreenShot("Clicked on View Product successfully", test, Capture);
			WaitforPage(2000);

			String product_Name = productPage.getProductName();
			if (product_Name.equals(productName)) {
				test.log(Status.INFO, "Product name verification--- PC5 is created: " + productName);
				addScreenShot("Product name verification", test, Capture);
			} else {
				test.log(Status.FAIL, "Product name verification: Failed");
				addScreenShot("Product name verification", test, Capture);
			}

			specificationPage.sourcingSummary();
			test.log(Status.INFO, "sourcing summary page opens up");
			addScreenShot("opened sourcing summary page", test, Capture);

			specificationPage.sourcingValidations(test);
			test.log(Status.PASS, "verified the primary source attributes ");
			addScreenShot("primary source attributes verified", test, Capture);

			specificationPage.specificationSummary(test);
			test.log(Status.INFO, "specification summary page opens up");
			addScreenShot("opened specification summary page", test, Capture);

			specificationPage.specificationValidations(test);
			test.log(Status.PASS, "verified the primary specification attributes ");
			addScreenShot("primary specification attributes verified", test, Capture);

			WaitforPage(4000);

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			test.log(Status.INFO, "Clicked on close Left plane");
			addScreenShot("Clicked on close Left plane", test, Capture);

			dashboardPage.Logout();
			System.out.println("Logout successful");
			test.log(Status.INFO, "Logout successful");
			addScreenShot("Logout successful", test, Capture);

		} catch (Exception e) {
			System.out.println("Test case failed due to application slowness" + e);
		test.log(Status.FAIL, "Test case failed due to application slowness " + e);
		throw e;
		}

	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}