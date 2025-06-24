package P2_TestCases;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_ApplicationPages.Colorway_page;
import com.WMS_ApplicationPages.Copy_carryover_page;
import com.WMS_ApplicationPages.CreateNewColorPage;
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_ApplicationPages.LineSheetPage;
import com.WMS_ApplicationPages.LineSheet_Edit_Page;
import com.WMS_ApplicationPages.MainMenuEnum;
import com.WMS_ApplicationPages.MainMenuPage;
import com.WMS_ApplicationPages.Palette_Page;
import com.WMS_ApplicationPages.ProductPage;
import com.WMS_ApplicationPages.Set_Up_Page;
import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

import Test_Rail.Test_Rail_Actions;
import resources.DataProviders;

@Test(enabled = true, groups= {"P2_TC"})
public class TC07_P2_ColorwaySeason_VerifyNoTriggerSent_LSE extends WMS_TestBase {
	WebDriver driver;
	DashboardPage dashboardPage;
	MainMenuPage mainMenuPage;
	Palette_Page palettepage;
	CreateNewColorPage CNCP;
	Copy_carryover_page CCP;
	Colorway_page Colorwaypage;
	LineSheetPage lineSheetPage;
	Set_Up_Page SetUpPage;
	ProductPage productPage;
	LineSheet_Edit_Page LineSheetEditPage;
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
			palettepage = new Palette_Page(driver);
			lineSheetPage = new LineSheetPage(driver);
			SetUpPage = new Set_Up_Page(driver);
			LineSheetEditPage = new LineSheet_Edit_Page(driver);
			Colorwaypage= new Colorway_page(driver);
			productPage = new ProductPage(driver);
			setReport("TC07_P2_ColorwaySeason_VerifyNoTriggerSent_LSE");
		}
	}

	@Test(priority = 0,dataProvider = "TC07_P2_ColorwaySeason_VerifyNoTriggerSent_LSE", dataProviderClass = DataProviders.class)
	public void P2_TC_07_VerifyNotrigger_LSE(String TestType,String season,String colorway,String linesheetview,String capsule,String materialType,  String consumerGroup, 
			String consumerGroupExt1,String consumerGroupExt2,String destroySampleInd, String profitCenterAPD,String productlifecyclegroup,String hubofferedto,String lastseasonoffered,
			String productpricepositioning,String createddate,String filtermaterial,String sizeGridCode,String currentPlannedLifecycle,String updatedBrandHierarchy, String updatedClassValue,
			String updatedSubClassValue, String updatedProSubCat1,String updatedProSubCat2, String updatedConsumer,String updatedConsumerGrp1, String updatedConsumerGrp2, 
			String updatedCustomsClassification) throws Exception{
		if (CloseBrowser) {
			test = extent.createTest(":::TC07_P2_ColorwaySeason_VerifyNoTriggerSent_LSE:::");
		}
		CloseBrowser = false;
		// ...............................browser launched time starts
		long startTime = System.nanoTime();

		try {
			test.log(Status.INFO, "This testcase covers TC_64 to TC_67");
			
			System.out.println("Browser Launched successfully");
			test.log(Status.INFO, "Browser Launched successfully");
			System.out.println("login to flex PLM application successfully");
			test.log(Status.INFO, "login to flex PLM application successfully "+URL);

			dashboardPage.openLeftPanel();
			test.log(Status.INFO, "Left panel opened");
			addSrceenShot("Left panel opened", test, Capture);
			
			mainMenuPage.ClickSeasonMenu(MainMenuEnum.SESSION.menu());
			test.log(Status.INFO, "My seasons menu clicked");
			addSrceenShot("Clicked on Main menu of My Seasons", test, Capture);
			
			SetUpPage.SeasonDropdown(season);
			test.log(Status.INFO, "season selected: "+season);
			addSrceenShot("season selected", test, Capture);

			lineSheetPage.selectLineSheet(MainMenuEnum.SESSION_LINE_SHEET.menu());
			test.log(Status.INFO, "Clicked on Line Sheets");
			addSrceenShot("Clicked on Line Sheets", test, Capture);
			
			LineSheetEditPage.filter_View_Change(linesheetview,test);
			test.log(Status.INFO, "Linesheet view changed to: Adoption");
			addSrceenShot("Linesheet view changed", test, Capture);
			
			SetUpPage.SelectColorway(colorway);
			test.log(Status.INFO, "colorway details page opened"+ colorway);
			addSrceenShot("colorway details page opened", test, Capture);
			
			SetUpPage.ClickEditColorwayseason();
			test.log(Status.INFO, "Colorway season edit page opened");
			addSrceenShot("Colorway season edit page opened", test, Capture);
			Thread.sleep(3000);
			
			SetUpPage.SetUpLSE(test);
			test.log(Status.INFO, "SetUP LSE is Completed");
			System.out.println("SetUP LSE is Completed");
			addSrceenShot("SetUP LSE is completed", test, Capture);
			Thread.sleep(4000);
			
			if (SetUpPage.validateLSEError() == false) {
				
				SetUpPage.validate_NoTriggerSent_LSE(test);
				System.out.println("Validation UnSuccessful for  SetUpLSE");
				test.log(Status.PASS, "Validation UnSuccessful for  SetUpLSE");
				addSrceenShot("Validation UnSuccessful for  SetUpLSE", test, Capture);
				Thread.sleep(3000);

				productPage.editProduct();
				System.out.println("clicked on edit product");
				test.log(Status.INFO, "clicked on edit product");
				addSrceenShot("clicked on edit product", test, Capture);

				productPage.updateProduct_SetUpLSE_LSUS(updatedBrandHierarchy, updatedClassValue, updatedSubClassValue,
						updatedProSubCat1, updatedProSubCat2, updatedConsumer, updatedConsumerGrp1, updatedConsumerGrp2,
						updatedCustomsClassification, test);
				System.out.println("All product fields updated");
				test.log(Status.INFO, "All product fields updated");
				addSrceenShot("All product fields updated", test, Capture);
				productPage.clickOnSave();

				SetUpPage.ClickEditColorway();
				test.log(Status.INFO, "Colorway season edit page opened");
				System.out.println("Colorway season edit page opened");
				addSrceenShot("Colorway season edit page opened", test, Capture);
				Thread.sleep(3000);
				
				
				SetUpPage.updateColorwayFields_SetUpLSE_LSUS(capsule, materialType, consumerGroup, consumerGroupExt1,
						consumerGroupExt2, destroySampleInd, profitCenterAPD, test);
				System.out.println("All Colorway fields updated");
				test.log(Status.INFO, "All Colorway fields updated");
				addSrceenShot("All Colorway fields updated", test, Capture);
				Thread.sleep(3000);

				SetUpPage.ClickEditColorwayseason();
				System.out.println("clicked on edit colorway season");
				test.log(Status.INFO, "clicked on edit colorway season");
				addSrceenShot("clicked on edit colorway season", test, Capture);
				Thread.sleep(3000);

				Colorwaypage.UpdatecolorwaySeason_SetUpLSE(hubofferedto, productlifecyclegroup, lastseasonoffered,
						productpricepositioning, createddate, filtermaterial, sizeGridCode, currentPlannedLifecycle,
						test);
				System.out.println("All Colorway season fields updated");
				test.log(Status.INFO, "All Colorway season fields updated");
				addSrceenShot("All Colorway season fields updated", test, Capture);
				Thread.sleep(3000);
				
				SetUpPage.ClickEditColorwayseason();
				test.log(Status.INFO, "Colorway season edit page opened");
				addSrceenShot("Colorway season edit page opened", test, Capture);

				SetUpPage.SetUpLSE(test);
				test.log(Status.INFO, "SetUP LSE is Completed");
				System.out.println("SetUP LSE is Completed");
				addSrceenShot("SetUP LSE is completed", test, Capture);
				Thread.sleep(4000);

				SetUpPage.ClickEditColorwayseason();
				test.log(Status.INFO, "Colorway season edit page opened");
				addSrceenShot("Colorway season edit page opened", test, Capture);

				SetUpPage.ValidationLSE(test);
				test.log(Status.PASS, "Validation successful for  SetUpLSE");
				addSrceenShot("Validation successful for  SetUpLSE", test, Capture);

			}

			dashboardPage.closeLeftPanel();
			System.out.println("Clicked on close Left plane");
			addSrceenShot("Clicked on close Left plane", test, Capture);
			
			dashboardPage.Logout();
			System.out.println("Logout successful");
			addSrceenShot("Clicked on Logout successful", test, Capture);
			
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
