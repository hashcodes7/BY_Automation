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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.ColorWayPage;
import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.CreateNewProductPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LSEProductSegmentationPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;

import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.PopUpPage;
import com.WMS_ApplicationPages.ProductDetailsPage;

import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.SeasonPage;
import com.WMS_Utilities.WMS_TestBase;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P1_TC"})
public class TC99_P1_Adoption_Product_Colorway_Creation extends WMS_TestBase {

	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	SeasonPage seasonPage;
	Palette_Page palettePage;

	ProductPage productPage;
	LineSheetPage lineSheetPage;
	CreateNewProductPage createNewProductPage;
	ProductDetailsPage productDetailsPage;
	LSEProductSegmentationPage lseProductSegmentationPage;
	PopUpPage popUpPage;
	Colorway_page colorWayPage;

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
			LaunchSpecific_URL(Administrator_URL);
			dashboardPage = new DashboardPage(driver);
			mainMenuPage = new MainMenuPage(driver);
			seasonPage = new SeasonPage(driver);
			palettePage = new Palette_Page(driver);

			productPage = new ProductPage(driver);
			lineSheetPage = new LineSheetPage(driver);
			createNewProductPage = new CreateNewProductPage(driver);
			productDetailsPage = new ProductDetailsPage(driver);
			lseProductSegmentationPage = new LSEProductSegmentationPage(driver);
			popUpPage = new PopUpPage(driver);
			colorWayPage = new Colorway_page(driver);

			setReport("TC99_P1_Product and Colorway Creation and Adoption Verification");
		}
	}

	@Test(priority = 0, dataProvider = "TC99_P1_Adoption_Product_Colorway_Creation", dataProviderClass = DataProviders.class)

	public void P0_TC01_Adoption_Product_Colorway_Creation(String TestType, String mySeasonType, String productName,
			String brandHierarchy, String classValue, String subClassValue, String proSubCat1, String proSubCat2,
			String consumer, String consumerGrp1, String consumerGrp2, String colorName, String productTypeValue,
			String rigidIndicatorValue, String productSegmentationLSE_Value, String productSegmentationLSUS_Value,
			String hubOfferdToValue, String viewType, String filterType) throws Exception {
		if (CloseBrowser) {

			test = extent.createTest(":::TC99_P1_Product and Colorway Creation and Adoption Verification:::");

		}

		CloseBrowser = false;

		// ...............................browser launched time starts

		long startTime = System.nanoTime();

		try {

			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			addSrceenShot("Browser Launched", test, Capture);

			test.log(Status.INFO, "This test case covers linesheet P1 module TC99 to TC106");

			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully: " + Administrator_URL);
			addSrceenShot("Login successful", test, Capture);

			Thread.sleep(5000);

			dashboardPage.openLeftPanel();
			System.out.println("Clicked on open Left plane");
			test.log(Status.INFO, "Clicked on open Left plane");
			addSrceenShot("Clicked on open Left plane", test, Capture);

			mainMenuPage.clickOnMySeasons();
			test.log(Status.INFO, "Clicked on MySeasons");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);

			mainMenuPage.chooseMySeasonType(mySeasonType);
			System.out.println("season type is choosen");
			test.log(Status.INFO, "season type is choosen: " + mySeasonType);
			addSrceenShot("Season type is choosen", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

			lineSheetPage.createProduct();
			test.log(Status.INFO, "Clicked on Create New product");
			addSrceenShot("Clicked on Create New product", test, Capture);

//				String productName = "Test_Demo_Product_01";
			productPage.enterProductName(productName);
			test.log(Status.INFO, "Entered product Name successfully: " + productName);
			addSrceenShot("Entered product Name successfully", test, Capture);
			WaitforPage(4000);

//			String brandHierarchy = "Red Tab Global";
			productPage.selectBrandHierarchy(brandHierarchy);
			test.log(Status.INFO, "Entered Brand Hierarchy value successfully: " + brandHierarchy);
			addSrceenShot("Entered Brand Hierarchy value successfully", test, Capture);
			WaitforPage(5000);

//			String classValue = "Jeans";
			productPage.selectClass(classValue);
			test.log(Status.INFO, "Entered class product Hierarchy successfully: " + classValue);
			addSrceenShot("Entered class product Hierarchy successfully", test, Capture);
			WaitforPage(5000);

//			String subClassValue = "Bootcut or Flare";
			productPage.selectSubClass(subClassValue);
			test.log(Status.INFO, "Entered sub class product Hierarchy successfully: " + subClassValue);
			addSrceenShot("Entered sub class product Hierarchy successfully", test, Capture);
			WaitforPage(5000);
			
//			String proSubCat1 = "Alternative Lengths";
			productPage.selectProSubCat1(proSubCat1);
			test.log(Status.INFO, "Entered product Sub Cat 1 successfully: " + proSubCat1);
			addSrceenShot("Entered product Sub Cat 1 successfully", test, Capture);
			WaitforPage(5000);

//			String proSubCat2 = "Not Applicable";
			productPage.selectProSubCat2(proSubCat2);
			test.log(Status.INFO, "Entered product Sub Cat 2 successfully: " + proSubCat2);
			addSrceenShot("Entered product Sub Cat 2 successfully", test, Capture);
			WaitforPage(5000);

//			String consumer = "Mens";
			productPage.selectConsumer(consumer);
			test.log(Status.INFO, "Entered consumer successfully: " + consumer);
			addSrceenShot("Entered consumer successfully", test, Capture);
			WaitforPage(5000);

//			String consumerGrp1 = "Adult Mens";
			productPage.selectConsumerGrp1(consumerGrp1);
			test.log(Status.INFO, "Entered consumer Group 1 successfully: " + consumerGrp1);
			addSrceenShot("Entered consumer Group 1 successfully", test, Capture);
			WaitforPage(5000);

//			String consumerGrp2 = "Regular";
			productPage.selectConsumerGrp2(consumerGrp2);
			test.log(Status.INFO, "Entered consumer Group 2 successfully: " + consumerGrp2);
			addSrceenShot("Entered consumer Group 2 successfully", test, Capture);
			WaitforPage(5000);

//				productPage.selectCostomsClassification();
//				test.log(Status.INFO, "Entered Costoms Classification successfully");
//				addSrceenShot("Entered Costoms Classification", test, Capture);
//				WaitforPage(2000);

			productPage.clikOnSaveBtn();
			test.log(Status.INFO, "Clicked on save button successfully");
			addSrceenShot("Clicked on save button successfully", test, Capture);
			WaitforPage(2000);

			productPage.clikOnViewProduct();
			test.log(Status.INFO, "Clicked on view product successfully");
			addSrceenShot("Clicked on view product successfully", test, Capture);
			WaitforPage(4000);
			
			// Verify product name
			String product_Name = productPage.getProductName();
			if (product_Name.equals(productName)) {
				test.log(Status.PASS, "Product name verification--- PC5 is created: " + product_Name);
				addSrceenShot("Product name verification", test, Capture);
			} else {
				test.log(Status.FAIL, "Product name verification: Failed");
				addSrceenShot("Product name verification", test, Capture);
			}
			

			productDetailsPage.CreateColorway();
			System.out.println("Clicked on Create Colorway");
			test.log(Status.INFO, "Clicked on Create Colorway");
			addSrceenShot("Clicked on Create Colorway", test, Capture);
			WaitforPage(4000);

			colorWayPage.ClickColorwayLookColor();
			System.out.println("Clicked on Colorway(Look/Color)");
			test.log(Status.INFO, "Clicked on Colorway(Look/Color)");
			addSrceenShot("Colorway(Look/Color)", test, Capture);
			WaitforPage(4000);

			popUpPage.select_Color(colorName,test);
			System.out.println("Selected Color");
			test.log(Status.INFO, "Selected  Color");
			addSrceenShot("Selected Color", test, Capture);
			WaitforPage(4000);

//				String productTypeValue="Product";
			colorWayPage.selectProductType(productTypeValue);
			System.out.println("selected ProductType");
			test.log(Status.INFO, "Selected Product Type: " + productTypeValue);
			addSrceenShot("Selected Product Type", test, Capture);
			WaitforPage(4000);

//				String rigidIndicatorValue="Rigid";
			colorWayPage.selectRigidIndicator(rigidIndicatorValue);
			System.out.println("selected RigidIndicator");
			test.log(Status.INFO, "Selected Rigid Indicator : " + rigidIndicatorValue);
			addSrceenShot("Selected Product Type", test, Capture);
			WaitforPage(4000);

//				String productSegmentationLSE_Value="A11 - LM Collaborations Alt Length Bottoms";
			colorWayPage.selectProductSegmentationLSE_DropDown(productSegmentationLSE_Value);
			System.out.println("Selected ProductSegmentationLSE value From DropDown");
			test.log(Status.INFO,
					"Selected ProductSegmentationLSE value From DropDown: " + productSegmentationLSE_Value);
			addSrceenShot("Selected ProductSegmentationLSE value From DropDown", test, Capture);
			WaitforPage(4000);

//				String productSegmentationLSUS_Value="13 - LFM Guys Discontinued Other";
			colorWayPage.selectProductSegmentationLSUS_DropDown(productSegmentationLSUS_Value);
			System.out.println("Selected ProductSegmentationLSUS value From DropDown");
			test.log(Status.INFO,
					"Selected ProductSegmentationLSUS value From DropDown: " + productSegmentationLSUS_Value);
			addSrceenShot("Selected ProductSegmentationLSUS value From DropDown", test, Capture);
			WaitforPage(4000);

			colorWayPage.clickOnSave();
			System.out.println("Clicked On save Button");
			test.log(Status.INFO, "Clicked On save Button");
			addSrceenShot("Clicked On save Button", test, Capture);
			WaitforPage(4000);

//				String hubOfferdToValue = "Global";
			colorWayPage.selectHubOfferdToValue(hubOfferdToValue);
			System.out.println("selected HubOfferd To Value");
			test.log(Status.INFO, "selected HubOfferd To Value : " + hubOfferdToValue);
			addSrceenShot("selected HubOfferd To Value", test, Capture);
			WaitforPage(4000);

			colorWayPage.clickOnViewProduct();
			System.out.println("clicked On ViewProduct");
			test.log(Status.INFO, "Clicked On View Product");
			addSrceenShot("Clicked On View Product", test, Capture);
			WaitforPage(4000);
			
			boolean isPC9Created = colorWayPage.verifyPC9Creation(test);
			Assert.assertTrue(isPC9Created, "PC9 was not created successfully.");

			String colorwayCode = productDetailsPage.getColorwayCode(test);
			System.out.println("Colorway code retrieved: " + colorwayCode);
			test.log(Status.INFO, "Colorway code retrieved");
			addSrceenShot("Colorway code retrieved", test, Capture);
			WaitforPage(4000);

			dashboardPage.clickOnSiteNavigationLink();
			System.out.println("clicked On Site Navigation Link ");
			test.log(Status.INFO, "clicked On Site Navigation Link");
			addSrceenShot("clicked On Site Navigation Link", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);

//				String viewType ="1. Adoption";
			lineSheetPage.selectViewDropdown(viewType);
			System.out.println("View type is choosen");
			test.log(Status.INFO, "View type is choosen: " + viewType);
			addSrceenShot("View type is choosen", test, Capture);

//				String filterType ="BFF Linked FG ";
			lineSheetPage.filterProductsByColorway(filterType, colorwayCode, test);
			System.out.println("The Product Is filtered By Its Colorway code");
			test.log(Status.INFO, "The Product Is filtered By Its Colorway code: " + filterType + "=" + colorwayCode);
			addSrceenShot("The Product Is filtered By Its Colorway code", test, Capture);

			lineSheetPage.displayTheFilteredProduct(colorwayCode, test);
			System.out.println("The product Is displayed In the LineSheet: "+productName);
			test.log(Status.PASS, "Verification: The product Is displayed In the LineSheet: "+productName);
			addSrceenShot("The product Is displayed In the LineSheet", test, Capture);

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
