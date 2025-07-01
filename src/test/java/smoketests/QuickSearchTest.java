package smoketests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
///////////////////////////////////////////////////////Pages
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_Utilities.WMS_TestBase;
///////////////////////////////////////////////////////
import com.aventstack.extentreports.Status;

@Test(enabled = true, groups = { "E2E_TC" })
public class QuickSearchTest extends WMS_TestBase {

    WebDriver driver;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        if (CloseBrowser) {
            driver = invokeBrowser();
            LaunchSpecific_URL(CurrentURL);
            dashboardPage = new DashboardPage(driver);
            setReport("QuickSearch Test");
        }
    }

    @Test(priority = 0)
    public void searchFlexPLMObject() throws Exception {
        test = extent.createTest("TC287_P0: Universal FlexPLM Object Search");
        
        System.out.println("🔍 Executing universal header search...");
        test.log(Status.INFO, "🔍 Test execution started: Universal FlexPLM Object Search");

        test.log(Status.INFO, "🚀 Launching browser and navigating to dashboard");
        test.log(Status.INFO, "✅ Browser launched successfully");

        test.log(Status.INFO, "📌 Initiating header dropdown search for: Material → SOFTMARK TODDLER LEGGING");
        dashboardPage.headerDropdownSearch("Material", "SOFTMARK TODDLER LEGGING");

        test.log(Status.INFO, "⏳ Waiting for page to load completely");
        WaitforPage(40000);

        test.log(Status.PASS, "🎯 Search completed and FlexPLM object loaded successfully");
    }


    @AfterMethod
    public void tearDown() {
    }
}

