package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_TestBase;

public class Framework_Utilities extends WMS_TestBase{
	WebDriver driver;
	WebDriverWait wait;

	public Framework_Utilities(WebDriver driver) {
		this.driver = driver;
	}	
	public void toggleGridView(WebElement GridViewButton) {
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(GridViewButton));
			clickElement(GridViewButton);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString()+"0";
			System.out.println("Execution Time is  : "+SerialNo);

		} catch (Exception e) {
			System.out.println("Connection timeout exception");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", GridViewButton);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString()+"0";
			System.out.println("Execution Time is  : "+SerialNo);

		}

	}
	 public static String printExecutionTimeMinutes(long startTime, long endTime)
	    {
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
	 
	 public static long printExecutionTimeSecounds(long startTime, long endTime)
	    {
	        long time_ns = endTime - startTime;
	        
	        
	        long time_sec = TimeUnit.NANOSECONDS.toSeconds(time_ns);
	        

	        if(time_sec > 0)
	            System.out.print(time_sec % 60);
	       
	        
			return time_sec;
	        
	       
	    }

	 public static String printExecutionTime(long startTime, long endTime)
	    {
	        long time_ns = endTime - startTime;
	        
	        
	        long time_ms = TimeUnit.NANOSECONDS.toMillis(time_ns);
	        long time_sec = TimeUnit.NANOSECONDS.toSeconds(time_ns);
	        long time_min = TimeUnit.NANOSECONDS.toMinutes(time_ns);
	        long time_hour = TimeUnit.NANOSECONDS.toHours(time_ns);

	        System.out.print("Execution Time in Minutes :");
	        if(time_hour > 0)
	            System.out.print(time_hour + " Hours, ");
	        if(time_min > 0)
	            System.out.print(time_min % 60 + " Minutes, ");
	        if(time_sec > 0)
	            System.out.print(time_sec % 60 + " Seconds, ");
	        if(time_ms > 0)
	            System.out.print(time_ms % 1E+3 + " MicroSeconds, ");
	        if(time_ns > 0)
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
	
	public void enterText(WebElement element, String text,String text1) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text,","+text1);
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

	public void clickElement(WebElement element){

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
	
	public void click(WebElement element, String elementName){

		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
			((Actions) element).click(element).perform();
			System.out.println("element name in click"+elementName);
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

	//Creating object of an Actions class
	Actions action = new Actions(driver);

	//Performing the mouse hover action on the target element.
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
		//System.out.println("Test Case Failed");
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

	
	 
	 
	 public void ReturnTabSecound () {
		
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 
		  }
	 
	 public String Timer () {
			
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");// 333333333333333000000
			LocalDateTime now = LocalDateTime.now();
			String SerialNo = dtf.format(now).toString()+"0";
			System.out.println("Execution Time is  : "+SerialNo);
			return SerialNo;
		 
		  }
	 
	 
	 
	 
	 public long TotalTimer (String time1,String time2) throws ParseException {
			
		 
		 SimpleDateFormat format = new SimpleDateFormat("ss:mm:HH");
		 Date date1 = format.parse(time1);
		 Date date2 = format.parse(time2);
		 long difference = date2.getTime() - date1.getTime();
		return difference; 
		 
		  }
	
	 
	 public void ReturnTabThird () {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(2));
		 
		  }
	 
	
	 public void ReturnBackTab (int tab) {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(tab));
		  }
	 
	 public void openNewTabs (int tab) {
		 ((JavascriptExecutor) driver).executeScript("window.open()");
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(tab));
		 
		  }
	 
	
	 public void controlMainTab () {
		
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
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  WebElement shadowRoot2 = (WebElement) js.executeScript("return arguments[0].shadowRoot2", host);
		  return shadowRoot2;
		}
}

