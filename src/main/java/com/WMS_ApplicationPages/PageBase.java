package com.WMS_ApplicationPages;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.plm.Utilities.ExtentUtility;
import com.plm.Utilities.PlmUtills;
import com.plm.Utilities.PropertyReader;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBase {
	File targetFile;
	public static String RB = "";
	public RemoteWebDriver remoteDriver;
	//public AppiumDriver appiumDriver;
	protected String toolName;
	protected static String appType;
	//TestBase t;
	String text;
	PropertyReader reader = new PropertyReader("PLM/propertyStore/PLMApplicationPOC.properties");

	/*
	 * public PageBase(ChromeDriver chromeDriver) { this.chromeDriver = driver;
	 * ElementLocatorFactory factory = new
	 * CustomElementLocatoryFactory(remoteDriver); PageFactory.initElements(factory,
	 * this); toolName = "Selenium"; }
	 * 
	 * public PageBase() { try { this.remoteDriver = remoteDriver;
	 * ElementLocatorFactory factory = new
	 * CustomElementLocatoryFactory(remoteDriver); PageFactory.initElements(factory,
	 * this); toolName = "Selenium"; } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 */

	public int count3 = 1, imagewidth1, imageheight1, imagewidth2, imageheight2;
	public static int n = 0;
	public String text1 = null;
	public String tool = null, webBrowser = null, chromeDriverPath = null, fireFoxDriverPath = null,
			IEDriverPath = null, deviceName = null, appName = null, appiumPort = null, deviceVersion = null,
			appPackage = null, appActivity = null, Android_Appium_Server_Path = null, appiumPort_Ios = null,
			devicePlatformName_Ios = null, deviceVersion_Ios = null, device_UDID = null, platformName = null,
			applicationPath = null, appiumURL = null, ParentWinhadleMob = null, ParentWinhadle = null,
			mobileCloud = null;

	public String getPort() throws Exception {
		ServerSocket socket = new ServerSocket(0);
		socket.setReuseAddress(true);
		String port = Integer.toString(socket.getLocalPort());
		socket.close();
		return port;
	}


	public ArrayList<Integer> getResolution(WebElement videoPlayerPathWE) {

		ArrayList<Integer> size = new ArrayList<Integer>();
		try {
			if (videoPlayerPathWE.isDisplayed()) {
				int ImageWidth = videoPlayerPathWE.getSize().getWidth();
				int ImageHeight = videoPlayerPathWE.getSize().getHeight();
				size.add(ImageWidth);
				size.add(ImageHeight);

			}
		} catch (Exception e) {

			try {
				// rg.logException("Taking Screenshots Fails", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

		return size;
	}


	public void takeScreenshot(String screenshotName, String videoPlayerPath) {

		try {
			WebElement ele = remoteDriver.findElement(By.xpath(videoPlayerPath));
			if (ele.isDisplayed()) {
				File screen = (File) ((TakesScreenshot) remoteDriver).getScreenshotAs(OutputType.FILE);

				int ImageWidth = ele.getSize().getWidth();
				int ImageHeight = ele.getSize().getHeight();
				Point point = ele.getLocation();
				int xcord = point.getX();
				int ycord = point.getY();
				BufferedImage img = ImageIO.read(screen);
				BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
				ImageIO.write(dest, "png", screen);
				FileUtils.copyFile(screen, new File("PhotoPassScreenshots/" + screenshotName + ".png"));
			}
		} catch (Exception e) {

			try {
				ExtentUtility.getTest().log(LogStatus.FAIL, e + " Taking Screenshots Fails ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}

	public void takeFullScreenshot(String screenshotName) {

		try {
			File screen = (File) ((TakesScreenshot) remoteDriver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screen, new File("PhotoPassScreenshots/" + screenshotName + ".png"));

		} catch (Exception e) {

			try {
				ExtentUtility.getTest().log(LogStatus.FAIL, e + " Taking Screenshots Fails ",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}

	public String takeScreenShot() {
		Calendar cal = Calendar.getInstance();
		long s = cal.getTimeInMillis();
		File screen = null;
		try {
			switch (toolName) {
//			case "Appium":
//				screen = (File) ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
//				break;
			case "Selenium":
				screen = (File) ((TakesScreenshot) remoteDriver).getScreenshotAs(OutputType.FILE);
				break;
			}
			FileUtils.copyFile(screen,
					new File("ReportGenerator/" + ExtentUtility.reportFolder + "/Screenshots/image" + s + ".png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return ("Screenshots//image" + s + ".png");
	}

	public void saveImage(String screenshotName, String videoPlayerPath) throws Exception {
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 120, 250);
		waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElement(By.xpath(videoPlayerPath))));
		String s1 = remoteDriver.findElement(By.xpath(videoPlayerPath)).getAttribute("src");
		URL url1 = new URL(s1);
		RenderedImage image1 = ImageIO.read(url1);
		ImageIO.write(image1, "png", new File("PhotoPassScreenshots/" + screenshotName + ".png"));
	}


	public void validateImage(String imageName1, String imageName2) throws Exception {

		try {
			String file1 = "PhotoPassScreenshots/" + imageName1 + "" + ".png";
			String file2 = "PhotoPassScreenshots/" + imageName2 + "" + ".png";
			Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
			Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

			PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

			int[] data1 = null;

			if (grab1.grabPixels()) {
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}

			int[] data2 = null;

			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}

			boolean result = java.util.Arrays.equals(data1, data2);

			if (result) {
				System.out.println("Result = Image validation - Pass ");
			} else {
				System.out.println("Result = Image validation - Fail ");

			}

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public void validateSlideImage(String imageName1, String imageName2) throws Exception {

		try {
			String file1 = "PhotoPassScreenshots/" + imageName1 + "" + ".png";
			String file2 = "PhotoPassScreenshots/" + imageName2 + "" + ".png";
			Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
			Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

			PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

			int[] data1 = null;

			if (grab1.grabPixels()) {
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}

			int[] data2 = null;

			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}

			boolean result = java.util.Arrays.equals(data1, data2);

			if (result) {
				System.out.println("Result = Slide Show Image validation - Fail ");

			} else {

				System.out.println("Result = Slide Show Image validation - Pass ");
			}

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public String getAppProperties(String key) throws IOException {
		String value = "";
		try {

			FileInputStream fileInputStream = new FileInputStream("data.properties");
			Properties property = new Properties();
			property.load(fileInputStream);

			value = property.getProperty(key);

			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public void hideKeyboard() throws Exception {
//		appiumDriver.hideKeyboard();
		System.out.println("back over");
	}

	public void enterUrl(String url) throws Exception {
		try {
			remoteDriver.get(url);
			Thread.sleep(3000);
			assertTrue("Application URL " + url + " has been launched and Browser value -" + "<small><b><i> [" + RB
					+ "]</b></i></small>", true);
			System.out.println("Application URL " + url + " has been launched");
		} catch (Exception exc) {
			exc.printStackTrace();

		}
	}

	public void clickPoint(WebElement e, String elementName) throws Exception {
		int xx = e.getLocation().x;
		int yy = e.getLocation().y;
		System.out.println("X Position : " + xx);
		System.out.println("Y Position : " + yy);
		clickCoordinates(xx, yy);
	}

	public void clickSave(WebElement e, String elementName) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.elementToBeClickable(e));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.elementToBeClickable(e));
				break;
			}
			Thread.sleep(3000);
			e.click();
			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on to the Element " + elementName + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, elementName + " not found",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(elementName + " not found");
		}

	}

	public void click(WebElement e, String elementName) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 80, 500);
//				wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(e)));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 80, 500);
				waitSelenium.until(ExpectedConditions.elementToBeClickable(e));
				break;
			}
			Thread.sleep(2000);
			e.click();
			Thread.sleep(1000);
//			if (CustomElementLocators.flag) {
//
//				File file = new File("ReportGenerator/" + ExtentUtility.reportFolder + "/HealedReport.html");
//				ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully");
//				CustomElementLocators.flag = false;
//			} else
//
//				ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully");

		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, elementName + "::-> Element not clickable at this moment "
					+ ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(elementName + " Element not clickable at this moment with exception  " + e);

		}

	}

	public boolean clickforverify(WebElement e, String elementName) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 80, 500);
//				wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(e)));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 80, 500);
				waitSelenium.until(ExpectedConditions.elementToBeClickable(e));
				break;
			}
			Thread.sleep(2000);
			/*
			 * JavascriptExecutor js = (JavascriptExecutor)remoteDriver; js.
			 * executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');"
			 * , e);
			 */
			e.click();
			Thread.sleep(1000);
			System.out.println("Clicked on element (" + elementName + ") successfully");

		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, elementName + " not found",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(elementName + " not found");
		}
		return true;
	}

	public void clickByJse(WebElement e, String elementName) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				// WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				JavascriptExecutor jse = (JavascriptExecutor) appiumDriver;
//				jse.executeScript("arguments[0].click();", e);
//				Thread.sleep(3000);
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 250);
				JavascriptExecutor jse1 = (JavascriptExecutor) remoteDriver;
				jse1.executeScript("arguments[0].click();", e);
				break;
			}
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println(elementName + " is clicked");

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, elementName + " not found",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(elementName + " not found");

		}

	}

	public void sendkeyJS(WebElement element, String value) {
		JavascriptExecutor jse = ((JavascriptExecutor) remoteDriver);
		jse.executeScript("arguments[0].value='" + value + "';", element);
	}

	public void clickWithoutSS(WebElement e) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOf(e));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 250);
				waitSelenium.until(ExpectedConditions.elementToBeClickable(e));
				break;
			}
			e.click();

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, e + " not found",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(e + " not found");

		}

	}

	public void clickHiddentElement(WebElement e, String elementName) throws Exception {
		try {
			switch (toolName) {
//
//			case "Appium":
//				JavascriptExecutor executor = (JavascriptExecutor) appiumDriver;
//				executor.executeScript("arguments[0].click();", e);
//				break;
			case "Selenium":
				JavascriptExecutor executor1 = (JavascriptExecutor) remoteDriver;
				executor1.executeScript("arguments[0].click();", e);
				break;
			}

			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + e + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, elementName + " not found",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(elementName + " not found");

		}

	}

	public void navigateToToC(String strToCLayer, String strToCItem) {
		try {
			switch (toolName) {

			case "Selenium":
				WebElement testElement = remoteDriver.findElement(By.cssSelector(
						"div[id='tocItemContainer" + strToCLayer + "'] > div > div > div[title='" + strToCItem + "']"));
				if (!testElement.isDisplayed()) {
					scrollTo(remoteDriver, testElement);
				}
				testElement.click();
				break;
//			case "Appium":
//				WebElement testElement1 = appiumDriver.findElement(By.cssSelector(
//						"div[id='tocItemContainer" + strToCLayer + "'] > div > div > div[title='" + strToCItem + "']"));
//				if (!testElement1.isDisplayed()) {
//					scrollTo(appiumDriver, testElement1);
//				}
//				testElement1.click();
//				break;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<WebElement> getList_ByClassName(WebElement element, String byValue) {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
//				wait.until(ExpectedConditions.visibilityOf(element));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 250);
				waitSelenium.until(ExpectedConditions.visibilityOf(element));
				break;

			}

		} catch (Exception exc) {

		}
		try {
			if (element.isDisplayed()) {
				List<WebElement> getList = element.findElements(By.className(byValue));

				return getList;
			} else
				return null;
		} catch (Exception exc) {

			return null;

		}
	}

	public void takeScreenshot_Native(WebElement ele, String screenshotName) throws IOException {
//		if (ele.isDisplayed()) {
//			File screen = (File) ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
//
//			int ImageWidth = ele.getSize().getWidth();
//			int ImageHeight = ele.getSize().getHeight();
//			Point point = ele.getLocation();
//			int xcord = point.getX();
//			int ycord = point.getY();
//			BufferedImage img = ImageIO.read(screen);
//			BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
//			ImageIO.write(dest, "png", screen);
//			FileUtils.copyFile(screen, new File("NativeApp_Screenshots/" + screenshotName + ".png"));
//		}
	}

	public void scrollTo(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('container id').scrollTop += 250;", "");
	}

	public String getCurrentUrl() throws Exception {
		String url = null;
		try {
			switch (toolName) {

//			case "Appium":
//				url = appiumDriver.getCurrentUrl();
//				break;
			case "Selenium":
				url = remoteDriver.getCurrentUrl();
				break;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on getting Current Url ",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);

		}
		return url;

	}

	public String fetchContentFromWebUI(String strCss) throws Exception {
		String strText = "";
		switch (toolName) {
		case "Selenium":
			System.out.println("Fetch content from web page");
			WebElement element = remoteDriver.findElement(By.cssSelector(strCss));
			WebElement testElement = remoteDriver.findElement(By.cssSelector("p[id^='p26']>span[id='word1']"));
			System.out.println("Font face/family in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-family"));
			String UIfontface = testElement.getCssValue("font-family");
			assertTrue("Font face/family in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-family"), true);
			System.out.println("Font size in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-size"));
			String UIfontSize = testElement.getCssValue("font-size");
			assertTrue("Font size in eBook for the text - The Language of Reaching Out: "
					+ testElement.getCssValue("font-size"), true);
			strText = element.getText();
			break;
//		case "Appium":
//			System.out.println("Fetch content from web page");
////			WebElement element1 = appiumDriver.findElement(By.cssSelector(strCss));
////			WebElement testElement1 = appiumDriver.findElement(By.cssSelector("p[id^='p26']>span[id='word1']"));
//			System.out.println("Font face/family in eBook for the text - The Language of Reaching Out: "
//					+ testElement1.getCssValue("font-family"));
//			UIfontface = testElement1.getCssValue("font-family");
//			assertTrue("Font face/family in eBook for the text - The Language of Reaching Out: "
//					+ testElement1.getCssValue("font-family"), true);
//			System.out.println("Font size in eBook for the text - The Language of Reaching Out: "
//					+ testElement1.getCssValue("font-size"));
//			UIfontSize = testElement1.getCssValue("font-size");
//			assertTrue("Font size in eBook for the text - The Language of Reaching Out: "
//					+ testElement1.getCssValue("font-size"), true);
//			strText = element1.getText();
//			break;
		}
		return strText;
	}

	public void clickByCSS(String e, String text) throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//
//				List<WebElement> li = appiumDriver.findElementsByCssSelector(e);
//
//				break;
			case "Selenium":
				remoteDriver.findElementByCssSelector(e).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + e + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);

		}

	}

	public void clickWithoutWait(WebElement e, String elementName) throws Exception {
		try {

			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOf(e));
//				break;
			case "Selenium":
				break;
			}
			e.click();
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + e + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);

		}

	}

	public void clickWithoutWait(String xpath, String elementName) throws Exception {
		try {

			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath(xpath)));
//				appiumDriver.findElementByXPath(xpath).click();
//				break;
			case "Selenium":
				Thread.sleep(3000);
				remoteDriver.findElementByXPath(xpath).click();
				break;
			}

			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}

	}

	public void clickLinkTest(String xpath, String elementName) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//				appiumDriver.findElementByXPath(xpath).click();
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);

				waitSelenium.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

				remoteDriver.findElementByLinkText(xpath).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public void click(String xpath, String elementName) throws Exception {
		try {
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);

			waitSelenium.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

			remoteDriver.findElementByXPath(xpath).click();
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully"
			/* ExtentUtility.getTest().addScreenCapture(takeScreenShot()) */);

		} catch (ElementClickInterceptedException e) {

			assertFalse(false, elementName + " -- is not clickable ");

		} catch (Exception exc) {

			assertFalse(false, elementName + "--->> element is not clickable at this moment due to ::-"
					+ exc.getStackTrace()[0].getMethodName());
		}
	}

	public void scrollbar() {
		EventFiringWebDriver event = new EventFiringWebDriver(remoteDriver);
		event.executeScript("document.querySelector('#contentDiv').scrollTop=600");
	}

	public void scrollRight() throws Exception {
//		PlmUtills.switchContentFrame(remoteDriver);
//		this.scrollTo("//a[contains(text(),'New')]", "");
//		this.click("//a[contains(text(),'New')]", "New");
//		PlmUtills.switchMeasurementFrame(remoteDriver);
//		this.scrollTo("//input[@name='ptc_str_9']", "input feild");
	}

	public void clickbyid(String id, String elementName) throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				appiumDriver.findElementById(id).click();
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 100, 1000);
				remoteDriver.findElementById(id).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {

			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);

		}
	}

	public void clickbyClassName(String className, String elementName) throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
//				appiumDriver.findElementByClassName(className).click();
//
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 100, 1000);
				remoteDriver.findElementByClassName(className).click();
				break;
			}
			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {

			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);

		}
	}

	public void clickByElementName(String name, String elementName) throws Exception {

		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
//				appiumDriver.findElementByName(name).click();
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.elementToBeClickable(By.name(name)));
				remoteDriver.findElementByName(name).click();
				break;
			}

			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {

			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);

		}
	}

	public void clickAlert() throws Exception {
		try {
			remoteDriver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			Alert a1 = remoteDriver.switchTo().alert();
			a1.accept();
		} catch (UnhandledAlertException f) {
			try {
				Alert alert = remoteDriver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
			} catch (NoAlertPresentException exc) {

				ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
						exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				throw new Exception(exc);
			}
		}
	}

	public void dragAndDrop(WebElement e1, WebElement e2) throws Exception {

		try {
			switch (toolName) {
//			case "Appium":
//				Actions action = new Actions(appiumDriver);
//				action.dragAndDrop(e1, e2).perform();
//
//				break;
			case "Selenium":
				Actions action1 = new Actions(remoteDriver);
				action1.dragAndDrop(e1, e2).perform();

				break;
			}

		} catch (Exception exc) {
			exc.printStackTrace();

			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on Drag element",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);

		}
	}

	public String getPageTitle() throws Exception {

		String pageTitle = "";
		if (toolName.equalsIgnoreCase("Selenium")) {
			pageTitle = remoteDriver.getTitle();
		} 
//		else {
//			Thread.sleep(5000);
//			pageTitle = appiumDriver.getTitle();
//
//		}

		return pageTitle;

	}

	public String getText(WebElement e, String elementName) throws Exception {

		switch (toolName) {
//		case "Appium":
//			WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//			wait.until(ExpectedConditions.visibilityOf(e));
//			break;
		case "Selenium":
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
			break;
		}
		String text = e.getText();
		ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return text;

	}

	public String getValue(WebElement e, String elementName) throws Exception {

		switch (toolName) {
//		case "Appium":
//			WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//			wait.until(ExpectedConditions.visibilityOf(e));
//			break;
		case "Selenium":
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
			break;
		}

		String text = e.getAttribute("value");
		ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return text;

	}

	public String getText(WebElement e) throws Exception {
		switch (toolName) {
//		case "Appium":
//			WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//			wait.until(ExpectedConditions.visibilityOf(e));
//			break;
		case "Selenium":
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
			break;
		}

		String text = e.getText().trim();
		return text;
	}

	public String getText(String xpath) throws Exception {
		String text = null;
		JavascriptExecutor jse = (JavascriptExecutor) remoteDriver;
		WebElement element = remoteDriver.findElement(By.xpath(xpath));
		text = jse.executeScript("return arguments[0].text", element).toString();
		return text;
	}

	public String getAttributeValue(WebElement e, String attribute) throws Exception {
		String text;
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
		waitSelenium.until(ExpectedConditions.visibilityOf(e));
		try {
			text = e.getAttribute(attribute);
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.INFO,
					exc + "Warning* Exception on getting the attribute value " + attribute,
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			text = "";
		}
		return text;
	}

	public void clickMultipleButtons(WebElement tab, WebElement pause, String elementName) throws Exception {

		try {
			Thread.sleep(20000);
			if (elementIsDisplayed(pause, "pausebutton")) {
				pause.click();
			} else {
				tab.click();
				pause.click();
			}
			Thread.sleep(10000);

			ExtentUtility.getTest().log(LogStatus.PASS, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, exc + "Exception on clicking webelement",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}

	}

	public void switchToCurrentWindowTitle() throws InterruptedException {
		try {

			switch (toolName) {
//			case "Appium":
//				Thread.sleep(10000);
//				int size = appiumDriver.getWindowHandles().size();
//				for (String winHandle : appiumDriver.getWindowHandles()) {
//					appiumDriver.switchTo().window(winHandle);
//				}

//				break;
			case "Selenium":
				for (String winHandle : remoteDriver.getWindowHandles()) {
					remoteDriver.switchTo().window(winHandle);
					Thread.sleep(5000);
				}
				break;
			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	public String sendPostRequest(String apiName, String cookie, String payload) {
		StringBuffer jsonString = new StringBuffer();

		try {
			URL url = new URL(
					"https://disneydev7.service-now.com/api/x_wadm_wdpr_cast_c/v1/wdpr_cp_svc_castchoir/" + apiName);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Cookie", cookie);
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}
			br.close();
			connection.disconnect();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return jsonString.toString();
	}

	public StringBuffer getServiceResponse(String serviceUrl) throws Exception {
		String output = null;
		StringBuffer outputResponse = null;
		try {
			Thread.sleep(5000);
			URL url = new URL(serviceUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("source-appl-id", "6");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Accept-Resolution", "thumb, medium, high");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			} else {

			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			// String output;
			System.out.println("Response from Server .... \n");
			PrintWriter out = new PrintWriter("Response/" + "response.txt");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if (output.contains("mediaThumb")) {
				}
				if (output.contains("width")) {
				}

				if (output.contains("height")) {
				}
				out.println(output);
			}

			conn.disconnect();
		} catch (Exception ex) {
		}

		return outputResponse;

	}

	public void selectOPtionByVisibleText(WebElement e, String text, String elementName) throws Exception {
		Thread.sleep(5000);

		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 80, 500);
//				wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(e)));
//
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 80, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
				break;
			}

			e.click();
			Select sl = new Select(e);
			sl.selectByVisibleText(text);

			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully");
			ExtentUtility.getTest().log(LogStatus.PASS, "Selecting element from :" + elementName + "::->" + text
					+ ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			Assert.assertEquals(true, false);
			ExtentUtility.getTest().log(LogStatus.FAIL, elementName + "::-> dropdown values are not available  "
					+ ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(elementName + " not found because of ::->" + exc.getStackTrace());

		}
	}

	public List<String> getAllOptionsInDropDown(WebElement dropDown) {
		Select dropDownValue = new Select(dropDown);
		dropDownValue.getOptions();
		List<String> dropDownVal = dropDownValue.getOptions().stream().map(dd -> dd.getText())
				.collect(Collectors.toList());
		return dropDownVal;
	}

	public void switchToWindowTitle() throws Exception {

		try {

			switch (toolName) {
//			case "Appium":
//				Thread.sleep(10000);
//				int size = appiumDriver.getWindowHandles().size();
//				ParentWinhadleMob = appiumDriver.getWindowHandle();
//				for (String winHandle : appiumDriver.getWindowHandles()) {
//					appiumDriver.switchTo().window(winHandle);
//				}
//
//				break;
			case "Selenium":
				ParentWinhadle = remoteDriver.getWindowHandle();
				for (String winHandle : remoteDriver.getWindowHandles()) {
					remoteDriver.switchTo().window(winHandle);

				}
				break;
			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	public void switchToParentWindowTitle() throws Exception {

		try {

			switch (toolName) {
//			case "Appium":
//				Thread.sleep(10000);
//				appiumDriver.close();
//				appiumDriver.switchTo().window(ParentWinhadleMob);
//
//				break;
			case "Selenium":
				remoteDriver.close();
				remoteDriver.switchTo().window(ParentWinhadle);
				break;
			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	public void selectOPtionByVisibleText(WebElement e, String text) throws InterruptedException {
		Thread.sleep(5000);
		e.click();
		Select sl = new Select(e);
		sl.selectByVisibleText(text);

	}

	public void selectOPtionByIndex(WebElement e, int value) throws InterruptedException {
		Thread.sleep(3000);
		Select sl = new Select(e);
		sl.selectByIndex(value);

	}

	public void selectOPtionByValue(WebElement e, String value) throws InterruptedException {
		Thread.sleep(3000);
		Select sl = new Select(e);
		sl.selectByValue(value);
	}

	public void switchToFrame(String frameId) throws Exception {

		try {

			switch (toolName) {
//			case "Appium":
//				Thread.sleep(5000);
//				appiumDriver.switchTo().frame(frameId);
//
//				break;
			case "Selenium":

				remoteDriver.switchTo().frame(frameId);
				break;
			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	public void switchToFrame(int frameId) throws Exception {

		try {

			switch (toolName) {
//			case "Appium":
//				Thread.sleep(5000);
//				appiumDriver.switchTo().frame(frameId);
//
//				break;
			case "Selenium":

				remoteDriver.switchTo().frame(frameId);
				break;
			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	public void switchToParentFrame() throws Exception {

		try {

			switch (toolName) {
//			case "Appium":
//				Thread.sleep(5000);
//				appiumDriver.switchTo().parentFrame();
//
//				break;
			case "Selenium":

				remoteDriver.switchTo().parentFrame();
				break;

			}
		}

		catch (org.openqa.selenium.NoSuchWindowException exc) {
			exc.printStackTrace();
		}

	}

	public String getParentWindow() throws Exception {
		String parentWindow = null;

		if (toolName.equalsIgnoreCase("Selenium")) {
			parentWindow = remoteDriver.getWindowHandle();
		}
//		else if (toolName.equalsIgnoreCase("Appium")) {
//			parentWindow = appiumDriver.getWindowHandle();
//		} 
		return parentWindow;
	}

	public void switchToParentWindow(String parentWindow) throws Exception {


		if (toolName.equalsIgnoreCase("Selenium")) {
			remoteDriver.close();
			remoteDriver.switchTo().window(parentWindow);
		}
//		else if (toolName.equalsIgnoreCase("Appium")) {
//			appiumDriver.close();
//			appiumDriver.switchTo().window(parentWindow);
//		}
	}

	public WebElement getElement(String xpath) throws Exception {
		switch (toolName) {
//		case "Appium":
//			WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//			wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath(xpath)));
//			WebElement we = appiumDriver.findElementByXPath(xpath);
//			return we;
		case "Selenium":
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));
			WebElement weSelenium = remoteDriver.findElementByXPath(xpath);
			return weSelenium;
		}

		ExtentUtility.getTest().log(LogStatus.PASS, " Get text on webelement successful",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		return null;

	}

	public List<WebElement> getElements(String xpath) throws Exception {
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
		waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));
		List<WebElement> weSelenium = remoteDriver.findElementsByXPath(xpath);
		ExtentUtility.getTest().log(LogStatus.PASS, " Get text on webelement successful");
		return weSelenium;

	}

	public boolean verifyText(WebElement e, String value) throws Exception {
		switch (toolName) {
//		case "Appium":
//			WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//			wait.until(ExpectedConditions.visibilityOf(e));
//			break;
		case "Selenium":
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
			break;
		}
		if (e.getText().contains(value)) {
			ExtentUtility.getTest().log(LogStatus.PASS, "  Verified Element successful ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return true;
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Verified webelement",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return false;
		}

	}

	public String getTextValue(String xpath) throws Exception {
		WebElement element = this.getElement(xpath);
		return element.getText();
	}

	public void enterText(WebElement element, String data, String elementName) throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
//				break;
			case "Selenium":
				// Thread.sleep(1000);
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 100, 250);
				// element.wait(100000);;
				waitSelenium.until(ExpectedConditions.visibilityOf(element));
				break;
			}

			element.clear();
			element.sendKeys(data);
//			if (CustomElementLocators.flag) {
//				File file = new File("ReportGenerator/" + ExtentUtility.reportFolder + "/HealedReport.html");
//				/*
//				 * ExtentUtility.getTest().log(LogStatus.PASS, "Enter text in " + elementName +
//				 * " successful <a href='file://"+file.getAbsolutePath()
//				 * +"'><img alt src='file://D:\\DTAP_WS\\UAF\\Healed_icon.png' height=\"25\" width=\"70\"></a>"
//				 * , ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
//				 */
//				ExtentUtility.getTest().log(LogStatus.INFO,
//						"Entered text (" + data + ") in " + elementName + " successfully");
//				CustomElementLocators.flag = false;
//			} else
//				ExtentUtility.getTest().log(LogStatus.INFO, " Entered text (" + data + ") in " + elementName
//						+ " successfully"/* ,ExtentUtility.getTest().addScreenCapture(takeScreenShot()) */);
			System.out.println(" Entered text in " + elementName + " successfully");
		} catch (Exception exc) {

			ExtentUtility.getTest().log(LogStatus.FAIL,
					"The value entered is >>" + data + "<< in XPATH mentioned " + element
							+ "::-> for which exception is displayed as " + exc.getStackTrace()[0]
							+ ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception("The value entered is " + data + " in XPATH mentioned " + element
					+ "::-> for which exception is displayed as " + exc);
		}

	}

	public void clearText(WebElement element) {
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 100, 250);
		waitSelenium.until(ExpectedConditions.visibilityOf(element));
		element.clear();
	}

	public void assertTrue(String message) throws Exception {
		ExtentUtility.getTest().log(LogStatus.PASS,
				message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	}

	public void assertFalse(String message) throws Exception {
		ExtentUtility.getTest().log(LogStatus.FAIL,
				message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	}

	public boolean navToSubMenu(String subMenu) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				System.out.println("Navigate to" + subMenu + "menu.");
//				appiumDriver.findElement(By.cssSelector("div[title='" + subMenu + "']")).click();
//				System.out.println("Navigated to sub-menu '" + subMenu + "'");
//				break;
			case "Selenium":
				System.out.println("Navigate to" + subMenu + "menu.");
				remoteDriver.findElement(By.cssSelector("div[title='" + subMenu + "']")).click();
				System.out.println("Navigated to sub-menu '" + subMenu + "'");
				break;
			}

		} catch (Exception exc) {
			System.out.println("Unable to navigate to the sub menu, due to - " + exc.getMessage());
			exc.printStackTrace();
			return false;
		}
		return true;
	}

	public void switchFrame() {
		if (remoteDriver.toString().contains("chrome")) {
			remoteDriver.switchTo().frame(2);
		} else {
			remoteDriver.switchTo().frame(0);
		}
	}

	public void switchToFrame() {
		System.out.println("remoteDriver.toString()" + remoteDriver.toString());
		if (remoteDriver.toString().contains("ie")) {
			remoteDriver.switchTo().frame(2);
		} else {
			remoteDriver.switchTo().frame(0);
		}
	}

	public void clearSystemCache() throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				appiumDriver.manage().deleteAllCookies();
//				break;
			case "Selenium":
				remoteDriver.manage().deleteAllCookies();
				break;
			}
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Clear Cookies ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + " Clear Cookies ");
		}

	}

	public boolean elementIsDisplayed(WebElement e, String ElementName) throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOf(e));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 250);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
				break;

			}

			return true;

		} catch (Exception exc) {
			return false;
		}

	}

	public void isDisplayed1(WebElement e, String ElementName) throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
//				wait.until(ExpectedConditions.visibilityOf(e));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 30, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
				break;

			}
			ExtentUtility.getTest().log(LogStatus.PASS, ElementName + " is displayed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, exc.toString(),
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc);
		}
	}

	public boolean elementIsDisplayed(WebElement e) throws Exception {
		try {
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 50, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(e));
		} catch (Exception exc) {
			return false;
		}
		return true;

	}

	public boolean AllelementIsDisplayed(List<WebElement> elements) throws Exception {
		try {
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 50, 500);
			waitSelenium.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception exc) {
			return false;
		}
		return true;

	}

	public boolean elementIsEnabled(WebElement e) throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
//				wait.until(ExpectedConditions.visibilityOf(e));
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
			}

			return true;
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Get element visibilty failed ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return false;
		}
	}

	public boolean elementIsDisplayed(String xpath, String ElementName) throws Exception {

		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
//				wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath(xpath)));
//				if (appiumDriver.findElementByXPath(xpath).isDisplayed()) {
//					ExtentUtility.getTest().log(LogStatus.PASS, ElementName + " is displayed",
//							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
//
//				}
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 30, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));
				if (remoteDriver.findElementByXPath(xpath).isDisplayed()) {
					ExtentUtility.getTest().log(LogStatus.PASS, ElementName + " is displayed",
							ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				}
				break;
			}

		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Element visibilty failed ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return false;

		}
		return true;

	}

	public boolean elementIsDisplayed(String xpath) throws Exception {

		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
//				wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath(xpath)));
//
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 30, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));

				break;
			}

		} catch (Exception exc) {

			return false;

		}
		return true;

	}

	public boolean elementIsDisplayedByName(String name) throws Exception {

		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 30, 500);
//				wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByName(name)));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByName(name)));
				break;
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
		return true;

	}

	public void clickCoordinates(final int x, final int y) {
		switch (toolName) {
//		case "Appium":
//			appiumDriver.executeScript("mobile: tap", new HashMap<String, Integer>() {
//				{
//					put("tapCount", (int) 1);
//					put("touchCount", (int) 1);
//					put("duration", (int) 0.5);
//					put("x", x);
//					put("y", y);
//				}
//			});
//			break;
		case "Selenium":
			remoteDriver.executeScript("mobile: tap", new HashMap<String, Integer>() {
				{
					put("tapCount", (int) 1);
					put("touchCount", (int) 1);
					put("duration", (int) 0.5);
					put("x", x);
					put("y", y);
				}
			});
			break;
		}
	}

	public void keyBoardActions(String text) {
		switch (toolName) {
//		case "Appium":
//			if (text.equalsIgnoreCase("return"))
//				appiumDriver.findElementByName(text).click();
//			else {
//				for (int i = 0; i < text.length(); i++) {
//					String alp = text.substring(i, i + 1);
//					appiumDriver.findElementByName(alp).click();
//				}
//			}
		case "Selenium":
			if (text.equalsIgnoreCase("return"))
				remoteDriver.findElementByName(text).click();
			else {
				for (int i = 0; i < text.length(); i++) {
					String alp = text.substring(i, i + 1);
					remoteDriver.findElementByName(alp).click();
				}
			}
		}

	}

	public void scrollToExact(String key) throws Exception {
		try {
//			switch (toolName) {
//			case "Appium":
//				((ScrollsTo) appiumDriver).scrollToExact(key);
//				break;
//			case "Selenium":
//				((ScrollsTo) remoteDriver).scrollToExact(key);
//				break;
//			}
			ExtentUtility.getTest().log(LogStatus.PASS, "scroll to element " + "" + key + "" + " successful",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element" + key,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on scroll to element" + key);
		}

	}

	public void scrollPage(String side, int key) throws Exception {
		try {
			switch (toolName) {
			case "Appium":

				break;
			case "Selenium":
				JavascriptExecutor jse = (JavascriptExecutor) remoteDriver;
				if (side.equalsIgnoreCase("Up"))
					jse.executeScript("scroll(0, " + key + ");");
				else {
					int key1 = (-key);
					jse.executeScript("scroll(0, " + key1 + ");");
				}
				break;
			}
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, " Exception on scroll to element ",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Get element visibilty failed ");

		}

	}

	public void accessNotification() {
//		AndroidDriver android = (AndroidDriver) this.appiumDriver;
//		android.openNotifications();

	}

	public void setDataConnection(boolean enable) {
//		if (this.appiumDriver instanceof AndroidDriver) {
//			AndroidDriver android = (AndroidDriver) this.appiumDriver;
//			NetworkConnectionSetting setting = android.getNetworkConnection();
//			setting.dataEnabled();
//			android.setNetworkConnection(setting);
//			String mode = enable ? "ON" : "OFF";
//			System.out.println("Current Status of data network:" + setting.dataEnabled());
//		}
	}

	public void setAirplaneConnection(boolean enable) {
//		if (this.appiumDriver instanceof AndroidDriver) {
//			AndroidDriver android = (AndroidDriver) this.appiumDriver;
//			NetworkConnectionSetting setting = android.getNetworkConnection();
//
//			setting.setAirplaneMode(true);
//
//			android.setNetworkConnection(setting);
//			String mode = enable ? "ON" : "OFF";
//		}
	}

	public void setWifiConnection(boolean enable) {
		System.out.println("before +++++");
//		if (this.appiumDriver instanceof AndroidDriver) {
//			System.out.println("inside +++++");
//			AndroidDriver android = (AndroidDriver) this.appiumDriver;
//			NetworkConnectionSetting setting = android.getNetworkConnection();
//			setting.setWifi(enable);
//			android.setNetworkConnection(setting);
//			System.out.println("Current Status of wifi:" + setting.wifiEnabled());
//			String mode = enable ? "ON" : "OFF";
//		}
	}

	public void keyboardActions(WebElement e, Keys key) {

		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOf(e));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
				waitSelenium.until(ExpectedConditions.elementToBeClickable(e));
				break;
			}
			e.sendKeys(key);

		} catch (Exception exc) {

		}

	}

	public void dragAndDropElement(String dragFromXpath, String dragToXpath, int xOffset, int yOffset)
			throws Exception {
		WebElement dragFrom = remoteDriver.findElementByXPath(dragFromXpath);
		WebElement dragTo = remoteDriver.findElementByXPath(dragToXpath);
		System.out.println(
				"dragFrom =" + dragFrom + " dragTo = " + dragTo + "xOffset = " + xOffset + " yOffset =" + yOffset);
		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Fullscreen page so selenium coordinates work
		robot.mouseMove(200, 200);
		robot.mousePress(InputEvent.BUTTON1_MASK);

		// Get size of elements
		org.openqa.selenium.Dimension fromSize = dragFrom.getSize();
		org.openqa.selenium.Dimension toSize = dragTo.getSize();

		// Get centre distance
		int xCentreFrom = fromSize.width / 2;
		int yCentreFrom = fromSize.height / 2;
		int xCentreTo = toSize.width / 2;
		int yCentreTo = toSize.height / 2;

		Point toLocation = dragTo.getLocation();
		Point fromLocation = dragFrom.getLocation();
		System.out.println(fromLocation.toString());

		// Make Mouse coordinate centre of element
		toLocation.x += xOffset + xCentreTo;
		toLocation.y += yOffset + yCentreTo;
		fromLocation.x += xOffset + xCentreFrom;
		fromLocation.y += yOffset + yCentreFrom;

		System.out.println(fromLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(fromLocation.x, fromLocation.y);
		// Thread.sleep(10000);
		// robot.mouseMove(175,250);

		// Thread.sleep(1000);
		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);

		// robot.mousePress(InputEvent.
		// Drag events require more than one movement to register
		// Just appearing at destination doesn't work so move halfway first
		robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x,
				((toLocation.y - fromLocation.y) / 2) + fromLocation.y);

		// Move to final position
		for (double i = (toLocation.x / 2); i < toLocation.x;) {
			robot.mouseMove((int) i, toLocation.y);
			i = i + 10;
		}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		ExtentUtility.getTest().log(LogStatus.PASS, " Drag element successful",
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

	}

	public void scrollTo(String xpath, String element) throws Exception {
		try {
			((JavascriptExecutor) remoteDriver).executeScript("arguments[0].scrollIntoView();",
					remoteDriver.findElement(By.xpath(xpath)));
			String logMessage = "Scrolled to element " + element;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element" + element,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on scroll to element" + element);
		}

	}

	public void scrollTo(WebElement e, String element) throws Exception {
		try {
			((JavascriptExecutor) remoteDriver).executeScript("arguments[0].scrollIntoView();", e);
			String logMessage = "Scrolled to element " + element;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on scroll to element" + element,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "::-> Exception on scroll to element" + element);
		}

	}

	public void moveToElement(String xpath1, String xpath2, String elementName) throws Exception {
		Actions actions;
		try {

			switch (toolName) {

//			case "Appium":
//				actions = new Actions(appiumDriver);
//				actions.moveToElement(appiumDriver.findElementByXPath(xpath1)).build().perform();
//				break;
			case "Selenium":
				actions = new Actions(remoteDriver);
				actions.moveToElement(remoteDriver.findElementByXPath(xpath1))
						.moveToElement(remoteDriver.findElementByXPath(xpath2)).build().perform();
				actions.click().build().perform();
				break;
			}

			String logMessage = "Moved to element " + elementName;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Move to element" + elementName,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on Move to element" + elementName);

		}
	}

	public void moveToElement(WebElement element, String elementName) throws Exception {
		Actions actions;
		try {

			switch (toolName) {

//			case "Appium":
//				actions = new Actions(appiumDriver);
//				actions.moveToElement(element).build().perform();
//				break;
			case "Selenium":
				actions = new Actions(remoteDriver);
				actions.moveToElement(element).build().perform();
				break;
			}

			String logMessage = "Moved to element " + elementName;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Move to element" + elementName,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on Move to element" + elementName);
		}
	}

	public void moveToElementClick(WebElement element, String elementName) throws Exception {
		Actions actions;
		try {
			actions = new Actions(remoteDriver);
			actions.moveToElement(element).click().build().perform();
			String logMessage = "Moved to element " + elementName;
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception exc) {
			ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on Move to element" + elementName,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(exc + "Exception on Move to element" + elementName);
		}
	}

	public void assertTrue(String msg, boolean cond) throws Exception {
		if (cond) {
			ExtentUtility.getTest().log(LogStatus.PASS, msg,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		} else {
			ExtentUtility.getTest().log(LogStatus.FAIL, msg,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(msg);
		}
	}

	public void message(String msg) throws Exception {
		ExtentUtility.getTest().log(LogStatus.INFO, msg);
	}

	public void assertTrueOnly(boolean condition, String mes) throws Exception {
		if (condition)
			ExtentUtility.getTest().log(LogStatus.PASS, mes);
	}

	public void assertTrue(boolean condition, String mes) throws Exception {
		if (condition)
			ExtentUtility.getTest().log(LogStatus.PASS, mes);
	}

	public void assertThat(boolean condition, String passMsg, String failedMsg, boolean... screenShot)
			throws Exception {
		if (condition) {
			if (screenShot.length > 0)

				ExtentUtility.getTest().log(LogStatus.PASS, "<font color=green>" + passMsg + "</u></i></b>" + "</font>"
						+ ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			else
				try {
					ExtentUtility.getTest().log(LogStatus.PASS, passMsg);
				} catch (Exception e) {
				}
		} else {
			try {
				ExtentUtility.getTest().log(LogStatus.FAIL, "<font color=fail>" + failedMsg + "</font>"
						+ ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} catch (Exception e) {
				throw new Exception(failedMsg + " failed with the exception " + e.getStackTrace()[1].getLineNumber());
				// or
				// assertFalse(false, failedMsg);
			}

		}
	}

	public void assertFalse(boolean condition, String message) throws Exception {
		ExtentUtility.getTest().log(LogStatus.FAIL,
				message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception(message);
	}

	public void assertEquals(String message, Object expected, Object actual) throws Exception {
		if (expected == null && actual == null) {
			return;
		}
		if (expected != null && expected.equals(actual)) {
			return;
		}
		ExtentUtility.getTest().log(LogStatus.FAIL,
				"Strings are not matched...Excepted is :" + expected + " but actual is :" + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception("Strings are not matched...Excepted is :" + expected + " but actual is :" + actual);
	}

	public void assertEquals(String expected, String actual) throws Exception {
		if (expected == null && actual == null) {
			return;
		}
		if (expected != null && expected.equals(actual)) {
			return;
		}
		ExtentUtility.getTest().log(LogStatus.FAIL,
				"Strings are not matched...Excepted is :" + expected + " but actual is :" + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception("Strings are not matched...Excepted is :" + expected + " but actual is :" + actual);
	}

	public void assertEquals(String message, String expected, String actual) throws Exception {
		if (expected == null && actual == null) {
			ExtentUtility.getTest().log(LogStatus.PASS,
					message + "...Excepted is :" + expected + " and actual is :" + actual + " is displayed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));

			return;
		}
		if (expected != null && expected.equals(actual)) {
			ExtentUtility.getTest().log(LogStatus.PASS,
					message + "...Excepted is :" + expected + " and actual is :" + actual + " is displayed",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			return;
		}
		ExtentUtility.getTest().log(LogStatus.FAIL,
				"Strings are not matched...Excepted is :" + expected + " but actual is :" + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception("Strings are not matched...Excepted is :" + expected + " but actual is :" + actual);
	}

	public void assertEquals(String message, double expected, double actual, double delta) throws Exception {
		if (Double.compare(expected, actual) == 0) {
			return;
		}
		if (!(Math.abs(expected - actual) <= delta)) {
			ExtentUtility.getTest().log(LogStatus.FAIL, message + actual,
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}

	public void clickEscape() {
		Actions action = new Actions(remoteDriver);
		action.sendKeys(Keys.ESCAPE);
	}

	public void selectAllActions() {
		Actions action = new Actions(remoteDriver);
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.build().perform();
	}

	public void assertEquals(String message, long expected, long actual) throws Exception {
		if (new Long(expected) != null && new Long(expected).equals(new Long(actual))) {
			return;
		}
		ExtentUtility.getTest().log(LogStatus.FAIL, message + actual,
				ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		throw new Exception(message);
	}

	public void waitForPageLoad() {
		switch (toolName) {

//		case "Appium":
//			WebDriverWait wait = new WebDriverWait(appiumDriver, 60 * 15);
//			wait.until(new ExpectedCondition<Boolean>() {
//				public Boolean apply(WebDriver wdriver) {
//					return ((JavascriptExecutor) appiumDriver).executeScript("return document.readyState")
//							.equals("complete");
//				}
//			});
//			break;
		case "Selenium":
			WebDriverWait wait1 = new WebDriverWait(remoteDriver, 60 * 15);
			wait1.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					return ((JavascriptExecutor) remoteDriver).executeScript("return document.readyState")
							.equals("complete");
				}
			});
			break;

		}
	}

	public void waitFor(int wait_time) throws InterruptedException {
		Thread.sleep(wait_time * 1000);
	}

	public void waitForVisibilityOfElement(WebElement e) throws Exception {
		try {
			switch (toolName) {

//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.visibilityOf(e));
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 1000, 500);
				waitSelenium.until(ExpectedConditions.visibilityOf(e));
				break;
			}

		} catch (Exception exc) {
			assertFalse(false, " failed as the element" + e + " is not visible");
			Assert.assertEquals(true, false);
		}
	}

	public boolean waitForElement(WebElement element) throws Exception {
		boolean statusOfTheElement = false;
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 50, 500);
		try {
			WebElement waitElement = waitSelenium.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfTheElement = true;
			}
		} catch (Exception ex) {

			statusOfTheElement = false;
		}
		return statusOfTheElement;

	}

	public boolean waitForElement(String xpath) throws Exception {
		boolean statusOfTheElement = false;
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 50, 500);
		try {
			WebElement waitElement = waitSelenium
					.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfTheElement = true;
			}
		} catch (Exception ex) {
			statusOfTheElement = false;
		}
		return statusOfTheElement;
	}

	public boolean waitForElementForUserRoles(String xpath) throws Exception {
		boolean statusOfTheElement = false;
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 15, 10);
		try {
			WebElement waitElement = waitSelenium
					.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfTheElement = true;
			}
		} catch (Exception ex) {
			statusOfTheElement = false;
		}
		return statusOfTheElement;
	}

	public boolean waitForElementForUserRoles(WebElement element) throws Exception {
		boolean statusOfTheElement = false;
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 15, 10);
		try {
			WebElement waitElement = waitSelenium.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfTheElement = true;
			}
		} catch (Exception ex) {

			statusOfTheElement = false;
		}
		return statusOfTheElement;

	}

	public boolean waitForInvisibilityOfElement(String xpath) throws Exception {
		boolean statusOfTheElement = true;
		WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 1000, 500);
		try {
			WebElement waitElement = waitSelenium
					.until(ExpectedConditions.visibilityOf(remoteDriver.findElementByXPath(xpath)));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfTheElement = false;
			}
		} catch (Exception ex) {
			statusOfTheElement = true;
			assertFalse(true, " Failed to load the element with the xpath " + xpath + "with the exception named::->"
					+ ex.getClass());
		}
		return statusOfTheElement;
	}

	public void doubleClickOnString(WebElement element, String strNextWord) throws AWTException {
		JavascriptExecutor js = null;
		final String JS_GET_WORD_RECT = "var ele=arguments[0], word=arguments[1], rg=document.createRange();   "
				+ "for(var c=ele.firstChild, i; c; c=c.nextSibling){                     "
				+ "  if(c.nodeType != 3 || (i=c.nodeValue.indexOf(word)) < 0) continue;  "
				+ "  rg.setStart(c, i); rg.setEnd(c, i + word.length);                   "
				+ "  var r = ele.getBoundingClientRect(), rr = rg.getClientRects()[0];   "
				+ "  return { left: (rr.left-r.left) | 0, top: (rr.top-r.top) | 0,       "
				+ "           width: rr.width | 0, height: rr.height | 0 };              " + "};";

		switch (toolName) {

//		case "Appium":
//			js = (JavascriptExecutor) appiumDriver;
//			break;

		case "Selenium":
			js = (JavascriptExecutor) remoteDriver;
			break;
		}
		// Get the text element
		// WebElement element = driver.findElement(By.cssSelector("#p4-textid2 >
		// span.p4-styleid2"));

		// Get the relative position/size {left, top, width, height} for the
		// word - strNextWord
		Map rect = (Map) js.executeScript(JS_GET_WORD_RECT, element, strNextWord);

		// Define a relative click point for the previous word "below"
		Long offset_x = (long) rect.get("left") - (long) rect.get("width") / 2;
		Long offset_y = (long) rect.get("top") + (long) rect.get("height") / 2;

		System.out.println(offset_x.intValue());
		System.out.println(offset_y.intValue());

		switch (toolName) {

//		case "Appium":
//			// Double click the word
//			System.out.println("before press");
//			new Actions(appiumDriver).moveToElement(element, offset_x.intValue(), offset_y.intValue()).doubleClick()
//					.build().perform();
//
//			System.out.println("after press");
//
//			break;

		case "Selenium":
			// Double click the word
			new Actions(remoteDriver).moveToElement(element, offset_x.intValue(), offset_y.intValue()).doubleClick()
					.perform();
			break;
		}

	}

	public void waitForAjax(int timeoutInSeconds) {

		try {
			if (remoteDriver instanceof JavascriptExecutor) {
				JavascriptExecutor jsDriver = (JavascriptExecutor) remoteDriver;
				Boolean ajaxCondtn = false;
				for (int i = 0; i < timeoutInSeconds; i++) {
					for (int j = 0; j < 20; j++) {
						try {

							ajaxCondtn = (Boolean) jsDriver.executeScript("return window.jQuery != undefined");

							if (ajaxCondtn)
								break;
							else
								Thread.sleep(1000);
						} catch (Exception e) {

						}
					}

					if (!ajaxCondtn)
						continue;
					Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");

					if (numberOfAjaxConnections instanceof Long) {
						Long n = (Long) numberOfAjaxConnections;

						if (n.longValue() == 0L)
							break;
					}
					Thread.sleep(1000);
				}
			} else {
				System.out.println("Web driver: " + remoteDriver + " cannot execute javascript");
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public void WaitForAjax() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) remoteDriver;
		if ((Boolean) executor.executeScript("return window.jQuery != undefined")) {
			while (!(Boolean) executor.executeScript("return jQuery.active == 0")) {
				Thread.sleep(1000);
			}
		}
		return;
	}

	public void javaScriptClick(String elements, RemoteWebDriver remoteDriver) {
		WebElement weSelenium = remoteDriver.findElementByXPath(elements);
		JavascriptExecutor executor = (JavascriptExecutor) remoteDriver;
		executor.executeScript("arguments[0].click();", elements);
	}

	public void actionClick(String elements, RemoteWebDriver remoteDriver) {
		Actions builder = new Actions(remoteDriver);
		builder.moveToElement(remoteDriver.findElement(By.xpath(elements))).click().build().perform();
	}

	public boolean isAlertPresent() throws Exception {
		try {
			switch (toolName) {
//			case "Appium":
//				WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//				wait.until(ExpectedConditions.alertIsPresent());
//				;
//				break;
			case "Selenium":
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 250);
				waitSelenium.until(ExpectedConditions.alertIsPresent());
				break;

			}
			return true;
		} catch (UnhandledAlertException e) {
			try {
				Alert alert = remoteDriver.switchTo().alert();
				alert.accept();
			} catch (NoAlertPresentException exc) {
				exc.printStackTrace();

			}
			return false;

		}
	}

	public void uploadafile(WebElement element, String value) {
		element.sendKeys(value);
	}

	public boolean listofelementsIsDisplayed(List<WebElement> e) throws Exception {
		try {
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 50, 500);
			waitSelenium.until(ExpectedConditions.visibilityOfAllElements(e));
		} catch (Exception exc) {
			return false;
		}
		return true;

	}

	public void softAssertThat(boolean condition, String passMsg, String failedMsg, boolean... screenShot)
			throws Exception {
		if (condition) {
			if (screenShot.length > 0)
				try {
					ExtentUtility.getTest().log(LogStatus.PASS,
							passMsg + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				} catch (Exception e) {
				}
			else
				try {
					ExtentUtility.getTest().log(LogStatus.PASS, passMsg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
			try {
				ExtentUtility.getTest().log(LogStatus.FAIL,
						failedMsg + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void softAssertFalse(boolean condition, String message) throws Exception {
		ExtentUtility.getTest().log(LogStatus.FAIL,
				message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	}

	public void waitForClickable(WebElement e) throws Exception {
		boolean result = e.isEnabled() && e.isDisplayed();
		if (result == true) {
			try {
				switch (toolName) {

//				case "Appium":
//					WebDriverWait wait = new WebDriverWait(appiumDriver, 60, 500);
//					wait.until(ExpectedConditions.elementToBeClickable(e));
//					break;
				case "Selenium":
					WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 1000, 500);
					waitSelenium.until(ExpectedConditions.elementToBeClickable(e));
					break;
				}

			} catch (Exception exc) {
				exc.printStackTrace();
				ExtentUtility.getTest().log(LogStatus.FAIL, "Exception on waiting for webelement",
						ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
				throw new Exception(exc + "Exception on waiting for webelement");
			}
		}
	}

	public void waitForAll_DropdDownPopulated(String xpath1) {
		try {
			WebDriverWait w = new WebDriverWait(remoteDriver, 100);
			w.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath(xpath1), By.tagName("option")));
		} catch (Exception ex) {
			System.out.println("dropdown values are still not available");
		}

	}

	public void waitForAll_DropdDownPopulated(WebElement e) {
		if (e.isDisplayed()) {
			try {

				WebDriverWait w = new WebDriverWait(remoteDriver, 30);
				w.until(ExpectedConditions.visibilityOf(e));
				w.until(ExpectedConditions.presenceOfNestedElementsLocatedBy((By) e, By.tagName("option")));
			} catch (Exception ex) {
				System.out.println("dropdown values are still not auto-populated");
			}
		}

	}

	public String getPathForDownloadFile() {
		targetFile = new File(
				System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
		String name1 = targetFile.getName();
		return name1;
	}

	public File getFile() {
		targetFile = new File(
				System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
		return targetFile;
	}

	public static void deleteFile(File element) {
		if (element.isDirectory()) {
			for (File sub : element.listFiles()) {
				deleteFile(sub);
			}
		}
		element.delete();
	}

	public void verifyIfFileExitsWithTheExtension(String extension) throws Throwable {
		Thread.sleep(3000);
		String contents[] = getFile().list();
		System.out.println("List of files and directories in the specified directory:");
		for (int i = 0; i < contents.length; i++) {
			System.out.println(contents[i]);
			String passMessage = "Test Passed: File created with name " + contents[i];
			String failedMessage = "Test Failed: Download failed for the file with extenstion" + contents[i];
			String filename = contents[i];
			assertThat(filename.contains(extension), passMessage, failedMessage, true);
		}
	}

	public void scrollByWebElementCoordinate(WebElement e, String elementName) {
		Point point = e.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();
		((JavascriptExecutor) remoteDriver).executeScript("window.scrollBy(" + xcord + ", " + ycord + ");");
	}

	public void selectWithVisisbleText(WebElement element, String visibleText, String details) throws Exception {
		Thread.sleep(1000);
		try {
			Select size_Category = new Select(element);
			size_Category.selectByVisibleText(visibleText);
			String logMessage = "Value selected in '" + details + "' is " + "('" + visibleText + "')";
			ExtentUtility.getTest().log(LogStatus.INFO,
					logMessage + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			;
		} catch (Exception e) {
			String message = "Value which is not selected for '" + details + "' is " + "'" + visibleText + "'";
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}

	public void selectWithIndexValue(WebElement element, int value, String details) throws Exception {
		Thread.sleep(1000);
		try {
			Select size_Category = new Select(element);
			size_Category.selectByIndex(value);
			String logMessage = size_Category.getFirstSelectedOption().getText() + " value is selected in ->" + details
					+ " dropdown";
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception e) {
			String message = "Dropdown value not selected for ::->" + details;
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}

	public String getTextWithoutJse(String xpath) throws Exception {
		String text = null;
		try {
			WebElement element = remoteDriver.findElement(By.xpath(xpath));
			text = element.getText();
			String logMessage = "Input text fetched is ('" + text + "')";
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception e) {
			String message = "Failed to retrieve the text '" + text + "'";
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
		return text;
	}

	public void click(String xpath, String[] elementName) throws Exception {
		try {
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);

			waitSelenium.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

			remoteDriver.findElementByXPath(xpath).click();
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully");

		} catch (ElementClickInterceptedException e) {

			assertFalse(false, elementName + " -- is not clickable ");

		} catch (Exception exc) {

			assertFalse(false, elementName + "--->> element is not clickable at this moment due to ::-"
					+ exc.getStackTrace()[0].getMethodName());
		}
	}

	/**
	 * @param dropdownSelect
	 * @param value
	 * @param type
	 * @throws Exception
	 */
	public void selectProductDropdown(String dropdownAttribute, String dropdownValue) throws Exception {
		try {
			this.moveToElement(
					this.getElement("//div[contains(text(),'" + dropdownAttribute + "')]/following::span[1]"),
					"Move to" + dropdownAttribute);
			this.click("//div[contains(text(),'" + dropdownAttribute + "')]/following::span[1]",
					"Product dropdown :-" + dropdownAttribute);
			this.click("//li[contains(text(),'" + dropdownValue.trim() + "')]",
					"Selecting :-" + dropdownValue + " " + "In" + " " + dropdownAttribute);
		} catch (Exception e) {
			String message = "Text entered for " + dropdownValue + " is not successfull ";
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}
	public void selectProductDropdownbyXpath(String xpath, String dropdownValue) throws Exception {
		try {
		this.moveToElement(this.getElement(xpath),
				"Move to Element" );
		this.click(xpath,
				"Product dropdown :-");
		this.click("//li[contains(text(),'"+dropdownValue.trim()+"')]",
				"Selecting :-" + dropdownValue + " " + "In" + "Product dropdown");
		}
		catch (Exception e) {
			String message = "Text entered for " + dropdownValue + " is not successfull ";
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}
	

	/**
	 * @param dropdownAttribute
	 * @param values
	 * @param dropdowntype
	 * @throws Exception
	 */
	public void selectMultiListProductDropdown(String dropdownAttribute, String[] values) throws Exception {
		try {
			this.moveToElement(
					this.getElement("//div[contains(text(),'" + dropdownAttribute + "')]/following::span[1]"),
					"Move to" + dropdownAttribute);
			this.click("//div[contains(text(),'" + dropdownAttribute + "')]/following::span[1]",
					"Product dropdown :-" + dropdownAttribute);
			int i = 1;
			for (String value : values) {
				String listattr = "//li[contains(text(),'" + value.trim() + "')][1]";
				if (i == 4)
					this.click("//li[contains(text(),'" + value.trim() + "')][1]",
							"Selecting :-" + value + " " + "In" + " " + dropdownAttribute);
				else if (this.getAttributeValue(this.getElement(listattr), "aria-selected").equals("false"))
					this.click("//li[contains(text(),'" + value.trim() + "')][1]",
							"Selecting :-" + value + " " + "In" + " " + dropdownAttribute);
				i++;
			}
		} catch (Exception e) {
			this.click("//div[contains(text(),'"+dropdownAttribute+"')]/following::span[1]",
					"Product dropdown :-" + dropdownAttribute);
			ExtentUtility.getTest().log(LogStatus.FAIL, "Error encounter while editing the values in dropdown "
					+ dropdownAttribute + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
		}
	}

	/**
	 * @param dropdownSelect
	 * @param type
	 * @param expectDDValues
	 * @throws Exception
	 */
	public void verifyProductDynamicDropdownValidation(String dropdownAttribute, String dropdowntype,
			String[] expectDDValues) throws Exception {
		this.moveToElement(this.getElement("//div[contains(text(),'" + dropdownAttribute + "')]/following::span[1]"),
				dropdowntype);
		this.click("//div[contains(text(),'" + dropdownAttribute + "')]/following::span[1]", dropdowntype);
		Thread.sleep(2000);
		List<String> ddValues = remoteDriver
				.findElements(By.xpath("//div[contains(text(),'" + dropdownAttribute + "')]/following::li")).stream()
				.map(WebElement::getText).collect(Collectors.toList());
		System.out.println(ddValues);
		boolean result = PlmUtills.compareTwoList(expectDDValues, ddValues);
//		this.assertThat(result,
//				dropdowntype + "drop down values are matched with expected " + Arrays.toString(expectDDValues),
//				dropdowntype + "drop down values are not matched with expected " + Arrays.toString(expectDDValues),
//				true);
	}

	/**
	 * @param values
	 * @param productValues
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void verifyMultiListProductValues(String[] values, WebElement productValues) throws Exception {
//		PlmUtills.switchContentFrame(remoteDriver);
//		this.moveToElement(productValues, "move to" + productValues.getText());
//		List<String> multiListValues = Arrays.asList(this.getText(productValues).split(","));
//		boolean result = PlmUtills.compareTwoList(values, multiListValues);
//		assertThat(result, "Product Multi list values are updated successfully " + multiListValues,
//				"Product Multi List values are not updated successfully " + multiListValues, true);
	}

	public String getTextWithoutJse(WebElement element) throws Exception {
		String text = null;
		try {
			text = element.getText();
			String logMessage = "Input text fetched is ('" + text + "')";
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception e) {
			String message = "Failed to retrieve the text '" + text + "'";
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
		return text;
	}

	public void sendInputToTextField(WebElement element, String enterText, String elementName) throws Exception {
		Thread.sleep(500);
		try {
			element.clear();
			element.sendKeys(enterText);
			String logMessage = "Text entered (" + enterText + ") for " + elementName + " is successfull ";
			ExtentUtility.getTest().log(LogStatus.INFO, logMessage);
		} catch (Exception e) {

			String message = "Text entered for " + elementName + " is not successfull ";
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}

	public String futureDate(String format, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, count);
		Date tomorrow = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String tomorrowAsString = dateFormat.format(tomorrow);
		return tomorrowAsString;
	}

	public void customizedInfo(String message) {
		ExtentUtility.getTest().log(LogStatus.PASS, "<font color=blue>" + "<b>" + message + "</b>" + "</font>"
				+ ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
	}

	public String getAttributeValueXpath(String xpath, String attribute) throws Exception {
		try {
			WebElement element = remoteDriver.findElement(By.xpath(xpath));
			WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 500);
			waitSelenium.until(ExpectedConditions.visibilityOf(element));
			text = element.getAttribute(attribute);
		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.INFO,
					exc + "Warning* Exception on getting the attribute value " + attribute,
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			text = "";
		}
		return text;
	}

	public void highLightElementInColour(String xpath) {
		WebElement element = remoteDriver.findElement(By.xpath(xpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) remoteDriver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", element);
	}

	public void highLightElementInColour(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) remoteDriver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", element);
	}

	public void selectDrodpownValues(String xpath, String text) throws Exception {
		WebElement element = remoteDriver.findElement(By.xpath(xpath));
		try {
			this.click(element, text);
			element.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		} catch (Exception e1) {
			String message = "unable to click on the element " + text;
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}

	}

	public void selectDrodpownValues(WebElement element, String text) throws Exception {
		try {
			this.click(element, text);
			element.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		} catch (Exception e1) {
			String message = "unable to click on the element " + text;
			ExtentUtility.getTest().log(LogStatus.FAIL,
					message + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(message);
		}
	}

	public void clickByJse(String xpath, String elementName) throws Exception {
		try {
			switch (toolName) {

			case "Selenium":
				WebElement e = remoteDriver.findElement(By.xpath(xpath));
				WebDriverWait waitSelenium = new WebDriverWait(remoteDriver, 60, 250);
				JavascriptExecutor jse1 = (JavascriptExecutor) remoteDriver;
				jse1.executeScript("arguments[0].click();", e);
				break;
			}
			ExtentUtility.getTest().log(LogStatus.INFO, "Clicked on element (" + elementName + ") successfully",
					ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			System.out.println(elementName + " is clicked");

		} catch (Exception exc) {
			exc.printStackTrace();
			ExtentUtility.getTest().log(LogStatus.FAIL, elementName + " not found",
					exc.toString() + ExtentUtility.getTest().addScreenCapture(takeScreenShot()));
			throw new Exception(elementName + " not found");

		}

	}
}