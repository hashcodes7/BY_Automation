package E2E_Testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WMS_Utilities.WMS_TestBase;
import com.aventstack.extentreports.Status;

@Test(enabled = true)
public class logtest extends WMS_TestBase {
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {
			driver = invokeBrowser();
			setReport("logtest");
	}

	@Test
	public void P0_TC02_E2E_ProductCreation() {
		test = extent.createTest(":::logtest");
		test.log(Status.INFO, "Entered consumer Group 1 successfully: " );
		test.log(Status.INFO, "Entered consumer Group 2 successfully: " );
		test.log(Status.INFO, "Clicked on save button successfully");
		test.log(Status.INFO, "Clicked on View Product successfully");
		test.log(Status.INFO, "Clicked on close Left plane");
		test.log(Status.INFO, "Logout successful");	
	}
	@AfterMethod
	public void setUpend() {
		
		driver.quit();
	}
}
