package com.WMS_ApplicationPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.plm.Utilities.ReadDataSheet;
import com.relevantcodes.extentreports.LogStatus;

public class MainMenuPage extends WMS_WebDriverUtilities {
	WebDriver driver;

	public MainMenuPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeLeft;

	@FindBy(id = "siteNavLink")
	private WebElement siteLabel;
	
	@FindBy(xpath = "//iframe[@name='sidebarframe']")
	private WebElement iframeSidebar;


	@FindBy(xpath = "//select[@id='seasonSelectList']")
	private WebElement selectseason;
	
	
	@FindBy(xpath = "//label[normalize-space()='My Seasons']")
	private WebElement MySeasonsOption;
	
	@FindBy(xpath = "//a[normalize-space()='Line Sheet']")
	private WebElement LinesSheetoptn;
	
	
	@FindBy(xpath = "//label[normalize-space()='Favorites']")
	private WebElement FavoritesOption;
	
	@FindBy(xpath = "//label[@title='Seasons']")
	private WebElement SeasonsDropdown;

	String currentTest;
	ReadDataSheet rds = new ReadDataSheet();

	public void openSubMenu(String menu, String submenu) throws Exception {
		try {

			System.out.println("string menu" + menu + ":" + submenu);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeLeft);
			System.out.println("string menu" + menu + ":" + submenu);
			driver.findElement(By.xpath("//label[@title='" + menu + "']")).click();
			System.out.println("string menu" + menu + ":" + submenu);
			driver.findElement(By.xpath("//div[@id='seasonDevelopmentContent']/a[2]")).click();
			System.out.println("string menu" + menu + ":" + submenu);
			System.out.println("string menu" + menu + ":" + submenu);
		} catch (Exception e) {
			System.out.println("string menu" + menu + ":" + submenu);
			System.out.println("string menu" + menu + ":" + submenu);

		}
		/*
		 * clickElement("//label[@title='My Work']");
		 * clickElement("//label[@title='Season']");
		 */
		// click("//label[@title='" + menu + "']", menu);
	}

	public void openSubMenu1(String mainMenu, String submenu, boolean... season) throws Exception {
		try {
			this.driver.switchTo().defaultContent();
			this.driver.switchTo().frame(iframeLeft);
			driver.findElement(By.xpath("//label[@title='" + mainMenu + "']")).click();
			System.out.println("string menu" + mainMenu + ":" + submenu);
			String subMenuItems = "//label[@title='" + mainMenu + "']/../../div[@class='card-content']";
			this.waitForVisibilityOfElement(subMenuItems);
			driver.findElement(By.xpath("//label[@title='" + mainMenu
					+ "']/../../div[@class='card-content']//a[normalize-space()='" + submenu + "']")).click();
			System.out.println("string menu" + mainMenu + ":" + submenu);
			
			// driver.findElement(By.xpath("//label[@title='" + mainMenu +
			// "']/../../div[@class='card-content']//a[normalize-space()='Season']"
			// label[@title='Libraries']/../../div[@class='card-content']//a[normalize-space()='Season']
			/*
			 * if (season.length > 0) { this.scrollTo(subMenuItems + "//a[contains(@href,'"
			 * + submenu + "')]", (submenu)); this.click(subMenuItems +
			 * "//a[contains(@href,'" + submenu + "')]", (submenu)); } else {
			 * driver.findElement(By.xpath(subMenuItems + "//a[normalize-space()='" +
			 * submenu + "']")).click();
			 * 
			 * this.scrollTo(subMenuItems + "//a[normalize-space()='" + submenu + "']",
			 * (submenu)); this.click(subMenuItems + "//a[normalize-space()='" + submenu +
			 * "']", submenu);
			 * 
			 * System.out.println("string menu"+mainMenu +":"+subMenuItems); }
			 */
		} catch (Exception e) {
			System.out.println("string menu" + mainMenu + ":");
		}
	}

	/**
	 * Function to navigate to SubMenus
	 * 
	 * @param mainMenu
	 * @param submenu
	 * @throws Exception
	 */
	public void openSubMenu(String mainMenu, String submenu, boolean... season) throws Exception {
		this.driver.switchTo().defaultContent();
		this.driver.switchTo().frame(iframeLeft);
		this.click("//label[@title='" + mainMenu + "']", mainMenu);
		String subMenuItems = "//label[@title='" + mainMenu + "']/../../div[@class='card-content']";
		this.waitForVisibilityOfElement(subMenuItems);
		System.out.println("subMenuItems" + subMenuItems);
		if (season.length > 0) {
			System.out.println("season" + subMenuItems);
			this.scrollTo(subMenuItems + "//a[contains(@href,'" + submenu + "')]", (submenu));
			this.click(subMenuItems + "//a[contains(@href,'" + submenu + "')]", (submenu));
		} else {
			this.scrollTo(subMenuItems + "//a[normalize-space()='" + submenu + "']", (submenu));
			this.click(subMenuItems + "//a[normalize-space()='" + submenu + "']", submenu);
		}
	}

	public void scrollTo(String xpath, String element) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath(xpath)));
			String logMessage = "Scrolled to element " + element;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
			System.out.println("Clicked on open Left plane");
		} catch (Exception exc) {
			/*
			 * ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element"
			 * + element, ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			 */throw new Exception(exc + "Exception on scroll to element" + element);
		}

	}

	public WebElement findElementByXPath(String using) {
		return findElement("xpath", using);
	}

	private WebElement findElement(String string, String using) {
		// TODO Auto-generated method stub
		return null;
	}

	public void waitForVisibilityOfElement(String xpath) throws Exception {

		try {

			WebDriverWait waitSelenium = new WebDriverWait(driver, 120, 500);

			waitSelenium.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath))));

		} catch (Exception exc) {
			/*
			 * assertFalse(false, " element not yet loaded in the webpage " + exc);
			 * Assert.assertEquals(false, true);
			 */
		}

	}

	public void click(String xpath, String elementName) throws Exception {
		try {
			WebDriverWait waitSelenium = new WebDriverWait(driver, 60, 500);

			waitSelenium.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

			// driver.findElements(xpath).click();
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully"
			/* ExtentUtility.getTest().addScreenCapture(takeScreenShot()) */);

		} catch (ElementClickInterceptedException e) {

			// assertFalse(false, elementName + " -- is not clickable ");

		} catch (Exception exc) {

			/*
			 * assertFalse(false, elementName +
			 * "--->> element is not clickable at this moment due to ::-" +
			 * exc.getStackTrace()[0].getMethodName());
			 */
		}
	}

	/**
	 * Function to open the menu items
	 * 
	 * @param menu
	 * @throws Exception
	 */
	public void openMenuItems(String menu) throws Exception {
		driver.switchTo().frame(iframeLeft);
		clickElement("//label[@title='" + menu + "']");
		// click("//label[@title='" + menu + "']", menu);
	}

	private void clickElement(String string) {
		// TODO Auto-generated method stub

	}
	
	public void libraryColurmenu(String menu, String submenu) throws Exception {
		try {

			System.out.println("string menu" + menu + ":" + submenu);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeLeft);
			driver.findElement(By.xpath("//label[@title='" + menu + "']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Color/Look')]")).click();
			System.out.println(submenu +"clicked");
			System.out.println("string menu" + menu + ":" + submenu);
		} catch (Exception e) {
			System.out.println("string menu" + menu + ":" + submenu);

		}
}
	public void ClickSeasonMenu(String menu) {
		System.out.println("string menu" + menu);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		driver.findElement(By.xpath("//label[@title='" + menu + "']")).click();
	}
	
	public void LibraryMenu(String menu, String submenu) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeLeft);
			if (menu.equals("Reports")) {
				driver.findElement(By.xpath("(//label[@title='"+menu+"'])[2]")).click();
			}else {
				driver.findElement(By.xpath("//label[@title='"+menu+"']")).click();
			}
			driver.findElement(By.xpath("//a[contains(text(),'"+submenu+"')]")).click();
			System.out.println(submenu +" clicked");
			System.out.println("string menu" + menu + ":" + submenu);
		} catch (Exception e) {
			System.out.println("string menu" + menu + ":" + submenu);

		}
}
	public void LibraryMenu(String submenu) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframeLeft);
			driver.findElement(By.xpath("//a[contains(text(),'"+submenu+"')]")).click();
			System.out.println(submenu +" clicked");
			System.out.println("string menu" + ":" + submenu);
		} catch (Exception e) {
			System.out.println("string menu" + ":" + submenu);
 
		}
}
 
	public void clickOnMySeasons() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(MySeasonsOption));
		MySeasonsOption.click();

		
		
	}
	
	public void chooseMySeasonType(String mySeasonType) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(seasonDropdown);

		WebElement staticDropDown = driver.findElement(By.xpath("//select[@id='seasonSelectList']"));
		Select selectvalue = new Select(staticDropDown);
		selectvalue.selectByVisibleText(mySeasonType);
		
	}
	public void ClickOnLineSheet() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeSidebar);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(LinesSheetoptn));
		LinesSheetoptn.click();	
		
	}
	
	public void ClickLibrariesMenu(String menu) throws Exception{
		System.out.println("string menu" + menu);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		driver.findElement(By.xpath("//label[@title='" + menu + "']")).click();
		Thread.sleep(2000);
	}
	
	public void selectsubmenu(String submenu) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeLeft);
		System.out.println("string menu" + ":" + submenu);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='" +submenu+ "']")).click();
	}


}