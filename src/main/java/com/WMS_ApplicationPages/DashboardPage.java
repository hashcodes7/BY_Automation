package com.WMS_ApplicationPages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.Status;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.relevantcodes.extentreports.LogStatus;

public class DashboardPage extends WMS_WebDriverUtilities {
		WebDriver driver;
		
		public DashboardPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		

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
	
	public void logoutDropdown() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeHeader);
		//if (Display(quickLinkDropdown)) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(quickLinkDropdown));
			
			try {
				Select logoutvalue = new Select(quickLinkDropdown);
				logoutvalue.selectByVisibleText("Logout");
				logoutvalue.selectByValue("logout");
				//clickElement(quickLinkDropdown);
			} catch (Exception e) {
				
				Select logoutvalue = new Select(driver.findElement(By.name("Logout")));
				logoutvalue.selectByVisibleText("Logout");
				/*
				 * JavascriptExecutor js = (JavascriptExecutor) driver;
				 * js.executeScript("arguments[0].click();", packStationDropdownElement);
				 */
			//}
		}

	}
	
	public void Logout() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeHeader);
		System.out.println("string menu");
		/*
		 * driver.findElement(By.xpath("//label[@title='" + menu + "']")).click();
		 * driver.findElement(By.xpath("//a[text()='" + submenu + "']")).click();
		 */
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
