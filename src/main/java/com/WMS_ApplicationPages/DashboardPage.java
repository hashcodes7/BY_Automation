package com.WMS_ApplicationPages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import com.WMS_Utilities.WMS_WebDriverUtilities;

public class DashboardPage extends WMS_WebDriverUtilities {
		WebDriver driver;
		
		public DashboardPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
	@FindBy(xpath = "//iframe[@id='contentframe']")
	private WebElement iframeContentframe;
	
	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeftPanel;

	@FindBy(xpath = "//iframe[@name='headerframe']")
	private WebElement iframeHeader;

	@FindBy(xpath = "//div[@id='pinbutton']")
	private WebElement pinbutton;
	
	@FindBy(xpath = "//div[@class='x-tool x-tool-unpin collapseExpandAndPin']")
	private WebElement pinbuttonclose;

	
	@FindBy(xpath = "//div[@id='userLabelDiv']")
	private WebElement UserNameLabel;
	
	@FindBy(xpath = "//select[@id='quickLinkSelectionId']")
	private WebElement quickLinkDropdown;
	

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(xpath = "//div[@id='allSpace']")
	private WebElement dashboardElement;

	@FindBy(xpath = "//select[@id='quickLinkSelectionId']")
	private WebElement logout;


	@FindBy(xpath = "//center[contains(text(),'Logged Out')]")
	private WebElement logoutText;
	
	@FindBy(xpath = "//div[@id='siteNavLink']")
	private WebElement siteNavigationLink;

	String currentTest;

	
	public void openLeftPanel() throws InterruptedException {
		
				driver.switchTo().frame(iframeLeftPanel);
				new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(pinbutton));
				clickElement(pinbutton);
				//return new MainMenuPage(driver);			
}
	
	public void closeLeftPanel() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(pinbuttonclose));
		clickElement(pinbuttonclose);
}
	public void updatebutton() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

WebElement dropdown = driver.findElement(By.xpath("//select[@onchange='evalList(this)']"));
System.out.println("2");

Select select = new Select(dropdown);
select.selectByVisibleText("Update"); // Clean and exact text
System.out.println("3");
Thread.sleep(5000);

}

	public void saveButton() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);

WebElement saveButton = driver.findElement(By.id("saveButton"));
saveButton.click();


}
	
	public void logoutDropdown() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeHeader);
		//if (Display(quickLinkDropdown)) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(quickLinkDropdown));
			
			try {
				Select logoutvalue = new Select(quickLinkDropdown);
				logoutvalue.selectByVisibleText("Logout");
				logoutvalue.selectByValue("logout");
			} catch (Exception e) {
				Select logoutvalue = new Select(driver.findElement(By.name("Logout")));
				logoutvalue.selectByVisibleText("Logout");
		}

	}

	public void headerDropdownSearch(String dropdownOption, String searchText) throws Exception {
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(iframeHeader);
	    System.out.println("🔄 Switched to iframeHeader");

	    // Locate the dropdown and select the option dynamically
	    WebElement dropdown = driver.findElement(By.id("searchDropDownSelect"));
	    selectValueFromDropdown(dropdown, dropdownOption);

	    // Locate the search field and send input dynamically
	    WebElement searchField = driver.findElement(By.id("searchField"));
	    System.out.println("✅ Dropdown selected: " + dropdownOption);
	    sendInputToTextField(searchField, searchText, "Search Field");
        Thread.sleep(2000);
	}
	public void sendInputToTextField(WebElement element, String enterText, String elementName) throws Exception {
	    System.out.println("📩 Sending input to: " + elementName);
	    Thread.sleep(500);
	    try {
	        element.clear();
	        String wrappedText = "*" + enterText + "*";
	        element.sendKeys(wrappedText);
	        Thread.sleep(1000);
	        element.sendKeys(Keys.ENTER);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeContentframe);
			WebElement h1 = driver.findElement(By.tagName("h1"));
			if (h1.getText().contains("Internal Server Error")) {
			    System.out.println("Detected 500 Internal Server Error via <h1>");
			}	Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);
	    } catch (Exception e) {
	        String message = "Text entry for " + elementName + " was unsuccessful ❌";
	        throw new Exception(message);
	    }
	}

	
	public void listElementsInFrame() {
	        driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeHeader);
	        System.out.println("switched to ");
	        // Fetch all elements inside the frame
	        List<WebElement> elements = driver.findElements(By.xpath("//*"));
	        System.out.println("Total elements inside frame header: " + elements.size());

	        // Print tag and trimmed text for each element
	        for (WebElement elem : elements) {
	            String tag = elem.getTagName();
	            String text = elem.getText().trim();
	            System.out.println("Tag: " + tag + (text.isEmpty() ? "" : ", Text: " + text));
	        }
	}
	
	public void Logout() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeHeader);
		System.out.println("string menu");
		Alert a1 = null;
		try {
			this.selectValueFromDropdown(logout, "Logout");
			Thread.sleep(1000);
			a1 = driver.switchTo().alert();
			// a1.dismiss();
			a1.accept();
			Thread.sleep(1000);
			if (isAlertPresent(driver)) {
				System.out.println("Alert is present");
				driver.switchTo().alert().accept();
			}
		} catch (UnhandledAlertException e) {
			Thread.sleep(1000);
			a1.accept();
			assertThat(this.Display(logoutText));
			// softAssertFalse(false, "error.occur while logout" + e);
		}
	}
	  public static boolean isAlertPresent(WebDriver driver) {
	        try {
	            driver.switchTo().alert();
	            return true;
	        } catch (NoAlertPresentException e) {
	            return false;
	        }
	    }
	
	public void clickOnSiteNavigationLink() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeftPanel);
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(siteNavigationLink));
		clickElement(siteNavigationLink);
 
}
	private void assertThat(boolean display) {
		// TODO Auto-generated method stub
		
	}
	
}
