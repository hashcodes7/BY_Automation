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
			addSrceenShot("Browser Launched successfully", test, Capture);

			test.log(Status.INFO, "This test case covers Specification module from 246 to 249");

			System.out.println("Login to flex PLM application successfully ");
			test.log(Status.INFO, "Login to flex PLM application successfully " + Administrator_URL);
			addSrceenShot("login to flex PLM application successfully", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

//			String mySeasonType = "Levi's S1 2024 Male Accessories";
			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			lineSheetPage.createProduct();
			WaitforPage(3000);

			lineSheetPage.createProduct();
			test.log(Status.INFO, "Clicked on Create New product");
			addSrceenShot("Clicked on Create New product", test, Capture);
			WaitforPage(3000);

//			String productName = "SPECTEST_Demo_gn04";
			productPage.enterProductName(productName);
			test.log(Status.INFO, "Entered product Name successfully");
			addSrceenShot("Entered product Name successfully", test, Capture);
			WaitforPage(3000);

//			String brandHierarchy = "Red Tab Global";
			productPage.selectBrandHierarchy(brandHierarchy);
			test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
			addSrceenShot("Entered Brand Hierarchy value successfully", test, Capture);
			WaitforPage(3000);

//			String proSubCat1 = "Bags";
			productPage.selectProSubCat1(proSubCat1);
			test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
			addSrceenShot("Entered product Sub Cat 1 successfully", test, Capture);
			WaitforPage(3000);

//			String proSubCat2 = "BackPack";
			productPage.selectProSubCat2(proSubCat2);
			test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
			addSrceenShot("Entered product Sub Cat 2 successfully", test, Capture);
			WaitforPage(3000);

//			String classValue = "Belts";
			productPage.selectClass(classValue);
			test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
			addSrceenShot("Entered class product Hierarchy successfully", test, Capture);
			WaitforPage(3000);

//			String subClassValue = "Reversible";
			productPage.selectSubClass(subClassValue);
			test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
			addSrceenShot("Entered sub class product Hierarchy successfully", test, Capture);
			WaitforPage(3000);

//			String consumer = "Mens";
			productPage.selectConsumer(consumer);
			test.log(Status.INFO, "Entered consumer successfully: " + consumer);
			addSrceenShot("Entered consumer successfully", test, Capture);
			WaitforPage(3000);

//			String consumerGrp1 = "Adult Mens";
			productPage.selectConsumerGrp1(consumerGrp1);
			test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
			addSrceenShot("Entered consumer Group 1 successfully", test, Capture);
			WaitforPage(3000);

//			String consumerGrp2 = "Regular";
			productPage.selectConsumerGrp2(consumerGrp2);
			test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
			addSrceenShot("Entered consumer Group 2 successfully", test, Capture);
			WaitforPage(3000);

			productPage.clikOnSaveBtn();
			test.log(Status.INFO, "Clicked on save button successfully");
			addSrceenShot("Clicked on save button successfully", test, Capture);
			WaitforPage(2000);

			productPage.clikViewProduct();
			test.log(Status.INFO, "Clicked on View Product successfully");
			addSrceenShot("Clicked on View Product successfully", test, Capture);
			WaitforPage(2000);

			String product_Name = productPage.getProductName();
			if (product_Name.equals(productName)) {
				test.log(Status.INFO, "Product name verification--- PC5 is created: " + productName);
				addSrceenShot("Product name verification", test, Capture);
			} else {
				test.log(Status.FAIL, "Product name verification: Failed");
				addSrceenShot("Product name verification", test, Capture);
			}

			specificationPage.sourcingSummary();
			test.log(Status.INFO, "sourcing summary page opens up");
			addSrceenShot("opened sourcing summary page", test, Capture);

			specificationPage.sourcingValidations(test);
			test.log(Status.PASS, "verified the primary source attributes ");
			addSrceenShot("primary source attributes verified", test, Capture);

			specificationPage.specificationSummary(test);
			test.log(Status.INFO, "specification summary page opens up");
			addSrceenShot("opened specification summary page", test, Capture);

			specificationPage.specificationValidations(test);
			test.log(Status.PASS, "verified the primary specification attributes ");
			addSrceenShot("primary specification attributes verified", test, Capture);

			WaitforPage(4000);

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

	}

	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}