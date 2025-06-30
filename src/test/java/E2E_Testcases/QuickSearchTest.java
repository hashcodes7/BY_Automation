package E2E_Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
///////////////////////////////////////////////////////Pages
import com.WMS_ApplicationPages.DashboardPage;
import com.WMS_Utilities.WMS_TestBase;
///////////////////////////////////////////////////////

@Test(enabled = true, groups = { "E2E_TC" })
public class QuickSearchTest extends WMS_TestBase {

    WebDriver driver;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        if (CloseBrowser) {
            driver = invokeBrowser();
            LaunchSpecific_URL(URL);
            dashboardPage = new DashboardPage(driver);
            setReport("QuickSearch Test");
        }
    }

    @Test(priority = 0)
    public void searchFlexPLMObject() throws Exception {
        test = extent.createTest("TC287_P0: Universal FlexPLM Object Search");
        System.out.println("🔍 Executing universal header search...");
        dashboardPage.headerDropdownSearch("Material", "SOFTMARK TODDLER LEGGING"); // Change as needed
        WaitforPage(40000);
    }

    @AfterMethod
    public void tearDown() {
    }
}

