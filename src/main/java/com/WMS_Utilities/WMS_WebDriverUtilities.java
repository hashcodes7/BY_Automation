package com.WMS_Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WMS_WebDriverUtilities extends WMS_TestBase {

	WebDriver driver;
	WebDriverWait wait;

	public WMS_WebDriverUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void toggleGridView(WebElement GridViewButton) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(GridViewButton));
			clickElement(GridViewButton);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString() + "0";
			System.out.println("Execution Time is  : " + SerialNo);

		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", GridViewButton);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString() + "0";
			System.out.println("Execution Time is  : " + SerialNo);

		}

	}

	public static String printExecutionTimeMinutes(long startTime, long endTime) {
		long time_ns = endTime - startTime;

		long durationInMs = TimeUnit.MILLISECONDS.convert(time_ns, TimeUnit.NANOSECONDS);

		long HH = TimeUnit.MILLISECONDS.toHours(durationInMs);
		long MM = TimeUnit.MILLISECONDS.toMinutes(durationInMs) % 60;
		long SS = TimeUnit.MILLISECONDS.toSeconds(durationInMs) % 60;

		String timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
		System.out.println(timeInHHMMSS);

		/*
		 * long time_min = TimeUnit.NANOSECONDS.toMinutes(time_ns);
		 * 
		 * 
		 * 
		 * if(time_min > 0) System.out.print(time_min % 60);
		 * 
		 * String str = String.format("%02d:%02d:%02d",
		 * TimeUnit.MILLISECONDS.toHours(time_ns),
		 * TimeUnit.MILLISECONDS.toMinutes(time_ns) -
		 * TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time_ns)),
		 * TimeUnit.MILLISECONDS.toSeconds(time_ns) -
		 * TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time_ns)));
		 * System.out.println(str);
		 */

		return timeInHHMMSS;

	}

	public static long printExecutionTimeSecounds(long startTime, long endTime) {
		long time_ns = endTime - startTime;

		long time_sec = TimeUnit.NANOSECONDS.toSeconds(time_ns);

		if (time_sec > 0)
			System.out.print(time_sec % 60);

		return time_sec;

	}

	public static String printExecutionTime(long startTime, long endTime) {
		long time_ns = endTime - startTime;

		long time_ms = TimeUnit.NANOSECONDS.toMillis(time_ns);
		long time_sec = TimeUnit.NANOSECONDS.toSeconds(time_ns);
		long time_min = TimeUnit.NANOSECONDS.toMinutes(time_ns);
		long time_hour = TimeUnit.NANOSECONDS.toHours(time_ns);

		System.out.print("Execution Time in Minutes :");
		if (time_hour > 0)
			System.out.print(time_hour + " Hours, ");
		if (time_min > 0)
			System.out.print(time_min % 60 + " Minutes, ");
		if (time_sec > 0)
			System.out.print(time_sec % 60 + " Seconds, ");
		if (time_ms > 0)
			System.out.print(time_ms % 1E+3 + " MicroSeconds, ");
		if (time_ns > 0)
			System.out.print(time_ns % 1E+6 + " NanoSeconds");
		return null;

	}

	public void enterText(WebElement element, String text) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + text + "';", element);

		}

	}

	public void enterText(WebElement element, String text, String text1) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text, "," + text1);
		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + text + "';", element, text1);

		}

	}

	public void mouseclick(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click().build().perform();

	}

	public void clickElement(WebElement element) {

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
			((Actions) element).click(element).perform();
		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			try {
				WaitforPage(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/* WaitforPage(3000); */
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			try {
				WaitforPage(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public void click(WebElement element, String elementName) {

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
			((Actions) element).click(element).perform();
			System.out.println("element name in click" + elementName);
		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			try {
				WaitforPage(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/* WaitforPage(3000); */
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			try {
				WaitforPage(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public void selectValueFromDropdown(WebElement element, String text) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectValueFromDropdown(WebElement element, int index) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public String getText(WebElement element) {
		String elementText = null;
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
			elementText = element.getText();
		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			elementText = (String) js.executeScript("return arguments[0].value;", element);
		}
		return elementText;

	}

	public void pressEnterKey(WebElement element) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void pressEnterKeyAWT(WebElement element) throws AWTException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void pressTabKey(WebElement element) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(Keys.TAB);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void moveToRequiredElement(String string, WebElement element) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click();
	}

	public void moveToRequiredElement(WebElement element) {

		WebElement ele = driver.findElement(By.xpath("<xpath>"));

		// Creating object of an Actions class
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();

	}

	public void acceptAlert() {

		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();
	}

	public void getAlertMessage() {

		@SuppressWarnings("unused")
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);

	}

	public String takeScreenshot(String screenShotName) throws IOException {
		// System.out.println("Test Case Failed");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Failed_Screenshots\\" + screenShotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}

	public void switchToWindows() throws InterruptedException {
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// Compare whether the main windows is not equal to child window. If not equal,
			// we will close.
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
			}

		}
	}

	public void ReturnTabSecound() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}

	public String Timer() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");// 333333333333333000000
		LocalDateTime now = LocalDateTime.now();
		String SerialNo = dtf.format(now).toString() + "0";
		System.out.println("Execution Time is  : " + SerialNo);
		return SerialNo;

	}

	public long TotalTimer(String time1, String time2) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("ss:mm:HH");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		long difference = date2.getTime() - date1.getTime();
		return difference;

	}

	public void ReturnTabThird() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));

	}

	public void ReturnBackTab(int tab) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
	}

	public void openNewTabs(int tab) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));

	}

	public void controlMainTab() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

	}

	public void closeCurrentWindow() throws InterruptedException {
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// Compare whether the main windows is not equal to child window. If not equal,
			// we will close.
			if (!mainWindow.equals(childWindow)) {
				driver.close();
				driver.switchTo().window(childWindow);

				System.out.println(driver.switchTo().window(childWindow).getTitle());
			}

		}
	}

	public boolean Display(WebElement element) {
		return element.isDisplayed();

	}

	public void RecordView(WebElement GridViewButton) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(GridViewButton));
			clickElement(GridViewButton);

		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", GridViewButton);

		}
	}

	public WebElement getShadowRoot(WebElement host) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowRoot2 = (WebElement) js.executeScript("return arguments[0].shadowRoot2", host);
		return shadowRoot2;
	}

	public ArrayList<String> getTeamContactsColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Name");
		HeaderValue.add("Product Code");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("Merchant");
		HeaderValue.add("PDS");
		HeaderValue.add("Garment Developer");
		HeaderValue.add("Designer");
		HeaderValue.add("Primary Fabric");
		
		return HeaderValue;

	}
	
	public ArrayList<String> getAdoptionColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("Hub Offered To");
		HeaderValue.add("Local Production");
		HeaderValue.add("Local Development For");
		HeaderValue.add("Adopted? GB");
		HeaderValue.add("Adopted? LH");
		HeaderValue.add("Adopted AFF");
		HeaderValue.add("Drop/Late Add Reason AFF");
		HeaderValue.add("Drop/Late Add Reason LH");
//		HeaderValue.add("Drop/Late Add Reason GB");
//		HeaderValue.add("Drop Date GB");
//		HeaderValue.add("Drop Date LH");
//		HeaderValue.add("Drop Date AFF");
//		HeaderValue.add("GB Dropped By");
//		HeaderValue.add("LH Dropped By");
//		HeaderValue.add("Aff Dropped By");
//		HeaderValue.add("Comments GB");
//		HeaderValue.add("Comments LH");
//		HeaderValue.add("Comments AFF");
//		HeaderValue.add("Colorway Code");
//		HeaderValue.add("Product Line");

		return HeaderValue;

	}
	
	public ArrayList<String> getAdoptionAFFColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("Hub Offered To");
		HeaderValue.add("Local Production");
		HeaderValue.add("Local Development For");
		HeaderValue.add("Adopted? GB");
		HeaderValue.add("Adopted? LH");
		HeaderValue.add("Adopted AFF");
		HeaderValue.add("Drop/Late Add Reason AFF");
//		HeaderValue.add("Drop/Late Add Reason LH");
//		HeaderValue.add("Drop/Late Add Reason GB");
//		HeaderValue.add("Drop Date GB");
//		HeaderValue.add("Drop Date LH");
//		HeaderValue.add("Drop Date AFF");
//		HeaderValue.add("GB Dropped By");
//		HeaderValue.add("LH Dropped By");
//		HeaderValue.add("Aff Dropped By");
//		HeaderValue.add("Comments GB");
//		HeaderValue.add("Comments LH");
//		HeaderValue.add("Comments AFF");
//		HeaderValue.add("Colorway Code");
//		HeaderValue.add("Product Line");

		return HeaderValue;

	}
	

	public ArrayList<String> getLinsheetLSUSColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Early Delivery");
//		HeaderValue.add("Adopted? GB");
//		HeaderValue.add("Adopted? LH");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("Set Up LSE - Run Validation");
		HeaderValue.add("Set Up LSE Validation Results");
		HeaderValue.add("Set Up LSE");
		HeaderValue.add("Set Up LSE Status");
		HeaderValue.add("Set Up LSE Feedback from SAP");
		HeaderValue.add("Set Up LSUS - Run Validation");
		HeaderValue.add("Set Up LSUS Validation Results");
		HeaderValue.add("Set Up LSUS");
		HeaderValue.add("Set Up LSUS Status");

		return HeaderValue;

	}
	public ArrayList<String> getLinesheetAPDColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Early Delivery");
		HeaderValue.add("Adopted AFF");
		HeaderValue.add("Profit Center [APD]");
		HeaderValue.add("Set Up LSE Status");
		HeaderValue.add("Set Up LSUS Status");
		HeaderValue.add("Set Up APD - Run Validation");
		HeaderValue.add("Set Up APD Validation Results");
		HeaderValue.add("Set Up APD");
		HeaderValue.add("Set Up APD Status");

		return HeaderValue;
	}
	
	public ArrayList<String> getLSUSColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Early Delivery");
//		HeaderValue.add("Adopted? GB");
//		HeaderValue.add("Adopted? LH");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("Set Up LSE - Run Validation");
		HeaderValue.add("Set Up LSE Validation Results");
		HeaderValue.add("Set Up LSE");
		HeaderValue.add("Set Up LSE Status");
		HeaderValue.add("Set Up LSE Feedback from SAP");
		HeaderValue.add("Set Up LSUS - Run Validation");
		HeaderValue.add("Set Up LSUS Validation Results");
		HeaderValue.add("Set Up LSUS");
		HeaderValue.add("Set Up LSUS Status");

		return HeaderValue;

	}
	public ArrayList<String> getNRF_ColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Code");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("LSE Stocking CSC GB");
		HeaderValue.add("First on Floor Month GB");
		HeaderValue.add("Bucket Code GB");
		HeaderValue.add("Target Global MSRP");
		HeaderValue.add("Current Planned Lifecycle GB");
		HeaderValue.add("NRF Class (US Only) GB");
		HeaderValue.add("NRF Class (US Only) LH");
		HeaderValue.add("NRF Class (US Only) AFF");
		HeaderValue.add("NRF Color CD (US Only) GB");
		HeaderValue.add("NRF Color CD (US Only) LH");
		HeaderValue.add("NRF Color CD (US Only) AFF");
		HeaderValue.add("NRF Size Scale (US Only) GB");
		HeaderValue.add("NRF Size Scale (US Only) LH");
		HeaderValue.add("NRF Size Scale (US Only) AFF");

		return HeaderValue;

	}
	
	public ArrayList<String> getAdoptionLinesheetheaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Product Dev. Center");
//		HeaderValue.add("Product Dev. Center Old (Product)");
//		HeaderValue.add("Product Dev. Center Old (Colorway)");
		HeaderValue.add("Hub Offered To");
		HeaderValue.add("Local Production");
		HeaderValue.add("Local Development For");
		HeaderValue.add("Adopted? GB");
		HeaderValue.add("Adopted? LH");
		HeaderValue.add("Adopted AFF");
//		HeaderValue.add("Drop/Late Add Reason AFF");
//		HeaderValue.add("Drop/Late Add Reason LH");
		HeaderValue.add("Drop/Late Add Reason GB");
		HeaderValue.add("Comments GB");
		HeaderValue.add("Drop Date GB");
		HeaderValue.add("Drop Date LH");
		HeaderValue.add("Drop Date AFF");
		HeaderValue.add("GB Dropped By");
		HeaderValue.add("LH Dropped By");
		HeaderValue.add("Aff Dropped By");
//		
//		HeaderValue.add("Comments LH");
//		HeaderValue.add("Comments AFF");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Drop/Late Add Reason LH");
		HeaderValue.add("Product Line");

		return HeaderValue;
	}
	
	public ArrayList<String> getPlacementColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("Product Name");
		HeaderValue.add("Color Code");
		HeaderValue.add("Colorway (Look/Color)");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Product Category");
		HeaderValue.add("Gender");
		HeaderValue.add("Capsule");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("Available ?");
		HeaderValue.add("Vendor");
		HeaderValue.add("Vendor ID");
		HeaderValue.add("Country");
		HeaderValue.add("Supplier Region");
		HeaderValue.add("Fabric Code -Mill Placement");
		HeaderValue.add("Placement Fabric Mill");
		HeaderValue.add("Material Code");
		HeaderValue.add("Placement Fabric - Mill SAP Code");
		HeaderValue.add("Generic Content");
		HeaderValue.add("Material Country of Origin");
		HeaderValue.add("Supplier Article No.");
		HeaderValue.add("PDS");
		HeaderValue.add("Yield/Usage");
		

		return HeaderValue;

	}
	
	public ArrayList<String> getSetupAPDColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Early Delivery");
		HeaderValue.add("Profit Center [APD]");
		HeaderValue.add("Set Up LSE Status");


		return HeaderValue;

	}
	public ArrayList<String> getPlacementviewColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("Product Name");
		HeaderValue.add("Color Code");
		HeaderValue.add("Colorway (Look/Color)");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Product Category");
		HeaderValue.add("Gender");
		HeaderValue.add("Capsule");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("Available ?");
		HeaderValue.add("Vendor");
		HeaderValue.add("Vendor ID");
		HeaderValue.add("Country");
		HeaderValue.add("Supplier Region");
		HeaderValue.add("Fabric Code -Mill Placement");
		HeaderValue.add("Placement Fabric Mill");
		HeaderValue.add("Material Code");
		HeaderValue.add("Placement Fabric - Mill SAP Code");
		HeaderValue.add("Generic Content");
		HeaderValue.add("Material Country of Origin");
		HeaderValue.add("Supplier Article No.");
		HeaderValue.add("PDS");
		HeaderValue.add("Yield/Usage");
		HeaderValue.add("Material type");
		HeaderValue.add("Product Price Positioning");
		HeaderValue.add("Finish Complexity");
		HeaderValue.add("Brand");
		HeaderValue.add("Nominated?");
		HeaderValue.add("Full Package Developed?");
		HeaderValue.add("AUS_GDV");
		HeaderValue.add("US_GDV");
		HeaderValue.add("INDIA_GDV");
		HeaderValue.add("PK_GDV");
		HeaderValue.add("SA_GDV");
		HeaderValue.add("MX_GDV");
		HeaderValue.add("JAPAN_GDV");
		HeaderValue.add("CHINA_GDV");
		HeaderValue.add("CA_GDV");
		HeaderValue.add("KOREA_GDV");
		HeaderValue.add("MALA_GDV");
		HeaderValue.add("INDO_GDV");
		HeaderValue.add("BR_GDV");
		HeaderValue.add("PHIL_GDV");
		HeaderValue.add("TAIWAN_GDV");
		HeaderValue.add("HK_GDV");
		HeaderValue.add("Sum of Source Mix");
		HeaderValue.add("Change Reason");
		HeaderValue.add("Change Comments");
		HeaderValue.add("Early Delivery");
		
		return HeaderValue;

	}
	
	
	public ArrayList<String> getTechpack_PD_ColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Sourcing Configuration Name");
		HeaderValue.add("Spec Status");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Early Delivery");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("TechPack Options");
		HeaderValue.add("Include PC9 in Tech-Pack?");
		HeaderValue.add("Generate TechPack Status");
		HeaderValue.add("Techpack Error Message");
		HeaderValue.add("Proto BOM Generated Date");
		HeaderValue.add("Proto BOM URL");
		HeaderValue.add("Bulk BOM Generated Date");
		HeaderValue.add("Bulk BOM URL");
		HeaderValue.add("(Retired) Colorway BOM Techpack URL");
		
		return HeaderValue;

	}
	
	public ArrayList<String> getCostwise_ColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Vendor ID");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Dev. Center Old (Product)");
		HeaderValue.add("Product Dev. Center Old (Colorway)");
		HeaderValue.add("Product Name");
		HeaderValue.add("Color Code");
		HeaderValue.add("Colorway (Look/Color)");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Product Category");
		HeaderValue.add("Gender");
		HeaderValue.add("Capsule");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("Available ?");
		HeaderValue.add("Vendor");
		HeaderValue.add("PDS Old (Product)");
		HeaderValue.add("PDS Old (Colorway)");
		HeaderValue.add("Material Type Old (Product)");
		HeaderValue.add("Material Type Old (Colorway)");
		HeaderValue.add("Product Price Positioning");
		HeaderValue.add("Primary Finish");
		HeaderValue.add("Finish Complexity");
		HeaderValue.add("Brand");
		HeaderValue.add("Brand Hierarchy");
		HeaderValue.add("Class (Product Hierarchy)");
		HeaderValue.add("Sub Class (Product Hierarchy)");
		HeaderValue.add("Current Planned Lifecycle");
		HeaderValue.add("GTM Track");
		HeaderValue.add("Early Delivery");
		HeaderValue.add("Fabric Mill");
		HeaderValue.add("Primary Fabric");
		HeaderValue.add("Carryover From Season");
		HeaderValue.add("CSVendor?");
		HeaderValue.add("Target Volume [Colorway]");
		HeaderValue.add("Target COGS");
		HeaderValue.add("Merch Target IMU");
		HeaderValue.add("Global MSRP");
		HeaderValue.add("Merch Fabric Description");
		return HeaderValue;

	}
	
	
	
	public ArrayList<String> getTechpack_GD_ColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Sourcing Configuration Name");
		HeaderValue.add("Spec Status");
		HeaderValue.add("TechPack Options");
		HeaderValue.add("Generate TechPack Status");
		HeaderValue.add("Components - Product");
		HeaderValue.add("Components - Colorway");
		HeaderValue.add("TechPack Grouping");
		HeaderValue.add("Garment TechPack URL");
		HeaderValue.add("GD TechPack Generated Date");
		HeaderValue.add("Techpack Error Message");
		
		return HeaderValue;

	}
	
	public ArrayList<String> getSourceConfig_ColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Name");
		HeaderValue.add("Product Code");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Colorway Code");
		HeaderValue.add("Vendor List");
		HeaderValue.add("Link Source-Colorway?");
		HeaderValue.add("Source - Colorway Association Status");
		
		return HeaderValue;

	}
	
	public ArrayList<String> getSizeSelectionColumnHeaderValue() {
		ArrayList<String> HeaderValue = new ArrayList<String>();
		HeaderValue.add("Product Type");
		HeaderValue.add("Product Code");
		HeaderValue.add("Product Name");
		HeaderValue.add("Colorway Name");
		HeaderValue.add("Internal Name");
		HeaderValue.add("Available ?");
		HeaderValue.add("Carryover/New");
		HeaderValue.add("Product Dev. Center");
		HeaderValue.add("Hub Offered To");
		HeaderValue.add("Capsule");
		HeaderValue.add("Adopted? GB");
		HeaderValue.add("Comm. Sample Type");
		HeaderValue.add("Sample Size");
		HeaderValue.add("Size Grid Code");
		HeaderValue.add("Sizes");
		HeaderValue.add("Selected Sizes GB");
 
 
		return HeaderValue;
 
	}
public void scroll(Integer column) {
	try {
		WebElement element= driver.findElement(By.xpath("//ancestor::div[@class='ag-center-cols-container']//div[@aria-colindex='"+column+"']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}catch(Exception e) {
		System.out.println(e);
	}
}
	
public ArrayList<String> getcolor_heathers_ColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Color Thumbnail");
	HeaderValue.add("Color Code");
	HeaderValue.add("LS&Co. Color Name");
	HeaderValue.add("Color Family");
	HeaderValue.add("Provider Color Code");
	HeaderValue.add("Provider Color Name");
	HeaderValue.add("Standard Provider");
	HeaderValue.add("Color Type");
	HeaderValue.add("LS&Co. Color");
	
	return HeaderValue;

}

public ArrayList<String> getcolor_Solids_ColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Color Thumbnail");
	HeaderValue.add("Provider Color Code");
	HeaderValue.add("LS&Co. Color Name");
	HeaderValue.add("Standard Provider");
	HeaderValue.add("Provider Color Name");
	HeaderValue.add("Color Family");
	HeaderValue.add("Brand");
	HeaderValue.add("Color Type");
	HeaderValue.add("LS&Co. Color");
	
	return HeaderValue;

}

public ArrayList<String> getActiveLSAColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Name");
	HeaderValue.add("Product Code");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Available ?");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("GTM Track");
	HeaderValue.add("Early Delivery");
	HeaderValue.add("Early Delivery");
	HeaderValue.add("Adopted AFF");
	HeaderValue.add("Selected Sizes AFF");
	HeaderValue.add("Selected Sizes AFF");
	HeaderValue.add("Current Planned Lifecycle AFF");
	HeaderValue.add("Demand Attribute AFF");
	HeaderValue.add("First On Floor Month AFF");
	HeaderValue.add("Dlvy Selected - AFF");
	HeaderValue.add("Dlvy Start Date - AFF");
	HeaderValue.add("Dlvy End Date - AFF");
	HeaderValue.add("Ticket Code AFF");
	HeaderValue.add("LSUS Stocking CSC AFF");
	HeaderValue.add("Target AFF MSRP");
	HeaderValue.add("Price Whsl AFF");
	HeaderValue.add("Product Price Position AFF");
	HeaderValue.add("Bucket Code AFF");
	HeaderValue.add("Season Collection");
	HeaderValue.add("Set Up LSUS");
	HeaderValue.add("Set Up LSUS Status");
	HeaderValue.add("Activate - Run Validation");
	HeaderValue.add("Activate Validation Results");
	HeaderValue.add("Activate");
	HeaderValue.add("Activate Validation Status");
	HeaderValue.add("Colorway Code");

	return HeaderValue;

}

public ArrayList<String> getActivateLSEColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Code");
	HeaderValue.add("Product Name");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Available ?");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("GTM Track");
	HeaderValue.add("Early Delivery");
//	HeaderValue.add("Adopted? LH");
	HeaderValue.add("Adopted AFF");
	HeaderValue.add("Selected Sizes AFF");
	HeaderValue.add("Current Planned Lifecycle AFF");
	HeaderValue.add("Demand Attribute AFF");
	HeaderValue.add("First On Floor Month AFF");
	HeaderValue.add("Dlvy Selected - AFF");
	HeaderValue.add("Dlvy Start Date - AFF");
	HeaderValue.add("Dlvy End Date - AFF");
	HeaderValue.add("Target AFF MSRP");
	HeaderValue.add("Price Whsl AFF");
	HeaderValue.add("Product Price Position AFF");
	HeaderValue.add("Bucket Code AFF");
	HeaderValue.add("LSUS Stocking CSC");
	HeaderValue.add("Season Collection");
	HeaderValue.add("Set Up LSE");
	HeaderValue.add("Set Up LSE Status");
	HeaderValue.add("Activate - Run Validation");
	HeaderValue.add("Activate Validation Results");
	HeaderValue.add("Activate");
	HeaderValue.add("Activate Validation Status");
	HeaderValue.add("SAP Feedback For Activate");
	HeaderValue.add("Colorway Code");

	return HeaderValue;

}
public ArrayList<String> getActivateAPDColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Code");
	HeaderValue.add("Product Name");
	HeaderValue.add("Colorway Name");
//	HeaderValue.add("Internal Name");
	HeaderValue.add("Available ?");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("GTM Track");
	HeaderValue.add("Early Delivery");
	HeaderValue.add("Adopted AFF");
	HeaderValue.add("Selected Sizes AFF");
	HeaderValue.add("Current Planned Lifecycle AFF");
	HeaderValue.add("Demand Attribute AFF");
	HeaderValue.add("First On Floor Month AFF");
	HeaderValue.add("Dlvy Selected - AFF");
	HeaderValue.add("Dlvy Start Date - AFF");
	HeaderValue.add("Dlvy End Date - AFF");
	HeaderValue.add("Season Collection");
	HeaderValue.add("Target AFF MSRP");
	HeaderValue.add("Price Whsl AFF");
	HeaderValue.add("Product Price Position AFF");
	HeaderValue.add("Set Up APD - Run Validation");
	HeaderValue.add("Set Up APD");
	HeaderValue.add("Set Up APD Validation Results");
	HeaderValue.add("Set Up APD Status");
	HeaderValue.add("Activate - Run Validation");
	HeaderValue.add("Activate Validation Results");
	HeaderValue.add("Activate");
	HeaderValue.add("Activate Validation Status");
	HeaderValue.add("Colorway Code");

	return HeaderValue;

}

public ArrayList<String> getSizeSelection_LH_ColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Code");
	HeaderValue.add("Product Name");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Available ?");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("Product Dev. Center");
	HeaderValue.add("Hub Offered To");
	HeaderValue.add("Capsule");
	HeaderValue.add("Adopted? GB");
	HeaderValue.add("Adopted? LH");
	HeaderValue.add("Sample Size");
	HeaderValue.add("Size Grid Code");
	HeaderValue.add("Sizes");
	HeaderValue.add("Selected Sizes GB");
	HeaderValue.add("Selected Sizes Error Message GB");
	HeaderValue.add("Selected Sizes LH");
	HeaderValue.add("Selected Sizes LH Locked?");
	return HeaderValue;

}
public ArrayList<String> getSizeSelection_AFF_ColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Code");
	HeaderValue.add("Product Name");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Available ?");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("Product Dev. Center");
	HeaderValue.add("Hub Offered To");
	HeaderValue.add("Capsule");
	HeaderValue.add("Adopted? GB");
	HeaderValue.add("Adopted? LH");
	HeaderValue.add("Sample Size");
	HeaderValue.add("Size Grid Code");
	HeaderValue.add("Sizes");
	HeaderValue.add("Selected Sizes GB");
	HeaderValue.add("Selected Sizes Error Message GB");
	HeaderValue.add("Selected Sizes LH");
	HeaderValue.add("Selected Sizes LH Locked?");
	HeaderValue.add("Selected Sizes Error Message LH");
	HeaderValue.add("Selected Sizes AFF");
	HeaderValue.add("Selected Sizes AFF Locked?");

	return HeaderValue;

}

public ArrayList<String> getFLA_FinalizeDetails_LinesheetheaderValue() {
	ArrayList<String> HeaderValue= new ArrayList<String>();
	
	HeaderValue.add("Product Line");
	HeaderValue.add("Class (Product Hierarchy)");
	HeaderValue.add("Sub Class (Product Hierarchy)");
	HeaderValue.add("Product Name");
	HeaderValue.add("Product Code");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Carryover/New PC5");
//	HeaderValue.add("Season First Introduced");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Color Code");
//	HeaderValue.add("Colorway (Look/Color)");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("Available ?");
	HeaderValue.add("Adopted? GB");
	HeaderValue.add("GTM Track");
	HeaderValue.add("Early Delivery");
	HeaderValue.add("Win At Marketplace No Hem");
	HeaderValue.add("Product Price Positioning");
	HeaderValue.add("Target Volume [Colorway]");
	HeaderValue.add("Target Global MSRP");
	HeaderValue.add("Target FOB");
	HeaderValue.add("Primary Fabric");
	HeaderValue.add("Branded Content");
	HeaderValue.add("Fabric Sustainable?");	
	HeaderValue.add("Sustainability Type");
	HeaderValue.add("Fabric Performance");
	HeaderValue.add("Performance Message");
	HeaderValue.add("Fabric Mill");
	HeaderValue.add("Generic Content");
	HeaderValue.add("After Wash Fabric  Weight");
	HeaderValue.add("Capsule");
	HeaderValue.add("Hero Outfit");
	HeaderValue.add("Equity MOQ Request");
	HeaderValue.add("Current Planned Lifecycle");
	HeaderValue.add("First Month on Floor");
	HeaderValue.add("First Directive Month");
	HeaderValue.add("Season First Introduced");
	HeaderValue.add("Last Season Offered");
	HeaderValue.add("Dlvy Selected - GB");
	HeaderValue.add("Dlvy Start Date - GB");
	HeaderValue.add("Dlvy End Date - GB");
	HeaderValue.add("Consumer Group 1");
	HeaderValue.add("Consumer Group 2");
	HeaderValue.add("Product Category");
	HeaderValue.add("Fit Reference");
	HeaderValue.add("Size Grid Code");
	HeaderValue.add("Product Dev. Center");
	HeaderValue.add("Hub Offered To");
	HeaderValue.add("Local Production");
	HeaderValue.add("Product Report Characteristics");
	HeaderValue.add("Product Segmentation [LSE]");
	HeaderValue.add("Product Segmentation [LSUS]");
	HeaderValue.add("Profit Center [APD]");
	HeaderValue.add("Merchant");
	HeaderValue.add("LSUS Stocking CSC");
	HeaderValue.add("Code Type");
	HeaderValue.add("Dimensions");
	HeaderValue.add("Collection Type");
	HeaderValue.add("Type of closure");
	HeaderValue.add("Capacity");
//	HeaderValue.add("Blank Linked");
//	HeaderValue.add("Construction");
//	HeaderValue.add("Performance");
//	HeaderValue.add("Special Tab Color");
//	HeaderValue.add("Equity");
//	HeaderValue.add("Global Fit Platform");
//	HeaderValue.add("Waist/Rise");
//	HeaderValue.add("Front Fly Opening");
//	HeaderValue.add("Leg Opening");
//	HeaderValue.add("Comm. Sample Type");
//	HeaderValue.add("Product Dev. Center Old (Colorway)");
//	HeaderValue.add("Local Development For");	
//	HeaderValue.add("Merchant Old (Colorway)");
//	HeaderValue.add("Extended Sizes");
//	HeaderValue.add("Comments");
//	HeaderValue.add("Activate Validation Status");
//	HeaderValue.add("Non-Denim Color");
//	HeaderValue.add("Stretch Type");	
//	HeaderValue.add("Product Story");
//	HeaderValue.add("Hem Type");
//	HeaderValue.add("Destruction");
//	HeaderValue.add("Selvedge");
	
	return HeaderValue;
	
}
public ArrayList<String> linkSourceToColorwayColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Name");
	HeaderValue.add("Product Code");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("Vendor List");
	HeaderValue.add("Source - Colorway Association Status");

	return HeaderValue;

}

public ArrayList<String> getFLA_for_TargetFOBLinesheetheaderValue() {
	ArrayList<String> HeaderValue= new ArrayList<String>();
	
	HeaderValue.add("Product Line");
	HeaderValue.add("Class (Product Hierarchy)");
	HeaderValue.add("Sub Class (Product Hierarchy)");
	HeaderValue.add("Product Name");
	HeaderValue.add("Product Code");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Carryover/New PC5");
	HeaderValue.add("Internal Name");
	HeaderValue.add("SAP FFC Code");
	HeaderValue.add("Color Code");
//	HeaderValue.add("Colorway (Look/Color)");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("Available ?");
	HeaderValue.add("GTM Track");
	HeaderValue.add("Early Delivery");
	HeaderValue.add("Win At Marketplace No Hem");
	HeaderValue.add("Product Price Positioning");
	HeaderValue.add("Target Volume [Colorway]");
	HeaderValue.add("Global MSRP");
	HeaderValue.add("Target FOB");


	return HeaderValue;

}
public ArrayList<String> getAttribute_PlacementAttributes_ColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("Product Code");
	HeaderValue.add("Product Dev. Center");
	HeaderValue.add("Product Name");
	HeaderValue.add("Color Code");
	HeaderValue.add("Colorway (Look/Color)");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Product Category");
	HeaderValue.add("Gender");
	HeaderValue.add("Capsule");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("Available ?");
	HeaderValue.add("Vendor");
	HeaderValue.add("Vendor ID");
	HeaderValue.add("Country");
	HeaderValue.add("Supplier Region");
	HeaderValue.add("Fabric Code -Mill Placement");
	HeaderValue.add("Placement Fabric Mill");
	HeaderValue.add("Material Code");
	HeaderValue.add("Placement Fabric - Mill SAP Code");
	HeaderValue.add("Generic Content");
	HeaderValue.add("Material Country of Origin");
	HeaderValue.add("Supplier Article No.");
	HeaderValue.add("PDS");
	HeaderValue.add("Yield/Usage");
	HeaderValue.add("Material type");
	HeaderValue.add("Product Price Positioning");
	HeaderValue.add("Finish Complexity");
	HeaderValue.add("Brand");
	HeaderValue.add("Nominated?");
	HeaderValue.add("Full Package Developed?");
	HeaderValue.add("AUS_GDV");
	HeaderValue.add("US_GDV");
	HeaderValue.add("INDIA_GDV");
	HeaderValue.add("PK_GDV");
	HeaderValue.add("SA_GDV");
	HeaderValue.add("MX_GDV");
	HeaderValue.add("JAPAN_GDV");
	HeaderValue.add("CHINA_GDV");
	HeaderValue.add("CA_GDV");
	HeaderValue.add("KOREA_GDV");
	HeaderValue.add("MALA_GDV");
	HeaderValue.add("INDO_GDV");
	HeaderValue.add("BR_GDV");
	HeaderValue.add("PHIL_GDV");
	HeaderValue.add("TAIWAN_GDV");
	HeaderValue.add("HK_GDV");
	HeaderValue.add("Sum of Source Mix");
	HeaderValue.add("Change Reason");
	HeaderValue.add("Change Comments");
	HeaderValue.add("Early Delivery");

	
	
	return HeaderValue;

}

public ArrayList<String> ViewEditRemoveSourceToColorwayColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Name");
	HeaderValue.add("Product Code");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("CSVendor?");
	HeaderValue.add("Full Package Developed?");
	HeaderValue.add("Vendor");
 
	return HeaderValue;
}
public ArrayList<String> dlinkSourceToColorwayColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Name");
	HeaderValue.add("Product Code");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("CSVendor?");
	HeaderValue.add("Full Package Developed?");
	HeaderValue.add("Vendor");
	HeaderValue.add("Delink Source-Colorway?");
 
	return HeaderValue;
}
public ArrayList<String> TechpackGenerationPDViewColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Name");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Sourcing Configuration Name");
	HeaderValue.add("Spec Status");
	HeaderValue.add("GTM Track");
	HeaderValue.add("Early Delivery");
	HeaderValue.add("Product Dev. Center");
	HeaderValue.add("TechPack Options");
	HeaderValue.add("Include PC9 in Tech-Pack?");
	HeaderValue.add("Generate TechPack Status");
	HeaderValue.add("Techpack Error Message");
	HeaderValue.add("Proto BOM Generated Date");
	HeaderValue.add("Proto BOM URL");
	HeaderValue.add("Bulk BOM Generated Date");
	HeaderValue.add("Bulk BOM URL");
	HeaderValue.add("(Retired) Colorway BOM Techpack URL");
	HeaderValue.add("(Retired) BOM TechPack Generated Date");
	
	return HeaderValue;
}


////////////////////////////////////////////////////////////////////////////////////////

public ArrayList<String> getSizeSelectionAT_GB_LH_AFF_ColumnHeaderValue() {
	ArrayList<String> HeaderValue = new ArrayList<String>();
	HeaderValue.add("Product Type");
	HeaderValue.add("Product Code");
	HeaderValue.add("Product Name");
	HeaderValue.add("Colorway Name");
	HeaderValue.add("Internal Name");
	HeaderValue.add("Available ?");
	HeaderValue.add("Carryover/New");
	HeaderValue.add("Product Dev. Center");
	HeaderValue.add("Hub Offered To");
	HeaderValue.add("Capsule");
	HeaderValue.add("Adopted? GB");
	HeaderValue.add("Adopted? LH");
	HeaderValue.add("Adopted AFF");
	HeaderValue.add("Comm. Sample Type");
	HeaderValue.add("Sample Size");
	HeaderValue.add("Size Grid Code");
	HeaderValue.add("Sizes");
	HeaderValue.add("Selected Sizes GB");
	HeaderValue.add("Selected Sizes Error Message GB");
	HeaderValue.add("Selected Sizes LH");
	HeaderValue.add("Selected Sizes LH Locked?");
	HeaderValue.add("Selected Sizes Error Message LH");
	HeaderValue.add("Selected Sizes AFF");
	HeaderValue.add("Selected Sizes AFF Locked?");
	HeaderValue.add("Selected Sizes Error Message AFF");
	HeaderValue.add("Size Grid Error Message");
	HeaderValue.add("Colorway Code");
	HeaderValue.add("Set Up LSE");
	HeaderValue.add("Set Up LSUS");

	return HeaderValue;

}

public void switchToWindowByTitle(String title) {
    for (String handle : driver.getWindowHandles()) {
        driver.switchTo().window(handle);
        if (driver.getTitle().contains(title)) {
            break;
        }
    }
}

}
