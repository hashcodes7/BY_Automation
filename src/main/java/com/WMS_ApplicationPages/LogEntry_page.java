package com.WMS_ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WMS_Utilities.WMS_WebDriverUtilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class LogEntry_page extends WMS_WebDriverUtilities {
	WebDriver driver;

	public LogEntry_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	boolean Capture = true;
	@FindBy(xpath = "//iframe[@id='contentframe']")
	private WebElement iframeContentframe;

	@FindBy(xpath = "//select[@id='LCSLOGENTRY_ptc_str_11Options']")
	private WebElement Event;
	
	@FindBy(xpath = "(//a[text()='Add'])[3]")
	private WebElement Event_ADD;
	
	@FindBy(xpath = "//input[@id='LCSLOGENTRY_CREATESTAMPA2FromInput']")
	private WebElement Createddate;
	
	@FindBy(xpath = "//a[@id='SearchButton2']")
	private WebElement Searchbutton;
	
	@FindBy(xpath = "(//a[text()='(view details)'])[1]")
	private WebElement View_details;
	
	@FindBy(xpath = "//td[@id='lscoTransactionId']")
	private WebElement TransactionId;
	
	@FindBy(xpath = "//td[@id='lscoStatus']")
	private WebElement lscoStatus;
	
	@FindBy(xpath = "//td[@id='lscoFileName']")
	private WebElement JSONFilename;
	
	@FindBy(xpath = "//td[@id='lscoEvent']")
	private WebElement LSCOEvent;
	
	@FindBy(xpath = "//td[@id='lscoFlexObjectId']")
	private WebElement ObjectId;
	
	@FindBy(xpath = "//td[@id='lscoFilePath']")
	private WebElement JSONFilepath;
	
	@FindBy(xpath = "//td[@id='lscoSKU']/a")
	private WebElement Colorway;
	
	@FindBy(xpath = "//td[@id='lscoSeasonGroup']/a")
	private WebElement SeasonGroup;
	
	@FindBy(xpath = "//td[@id='lscoSeason']/a")
	private WebElement Season;
	
	@FindBy(xpath = "//td[@id='lscoProduct']/a")
	private WebElement Product;
	
	@FindBy(xpath = "//td[@id='lscoMaterial']/a")
	private WebElement Material;
	
	@FindBy(xpath = "//td[@id='lscoSupplier']/a")
	private WebElement MaterialSupplier;
	
	@FindBy(xpath = "//td[@id='lscoErrorDescription']/br[1]")
	private WebElement totalrecords;

	public void select_LogEntryObject(String LogEntryObject,ExtentTest test) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		if (LogEntryObject.equals("Colorway")) {
			driver.findElement(By.xpath("(//a[text()='"+LogEntryObject+"'])[2]")).click();
			test.log(Status.INFO, "Log entry selected is : "+LogEntryObject);
			System.out.println("Log entry selected is : "+LogEntryObject);
			
		}else {
			driver.findElement(By.xpath("//a[text()='"+LogEntryObject+"']")).click();
			test.log(Status.INFO, "Log entry selected is : "+LogEntryObject);
			System.out.println("Log entry selected is : "+LogEntryObject);
		}
		
	}
	
	public void Add_criteria(String event,String createddate,ExtentTest test) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		
		selectValueFromDropdown(Event, event);
		Event_ADD.click();
		
		Thread.sleep(3000);
		
		Createddate.sendKeys(createddate);
		Thread.sleep(6000);
		Searchbutton.click();
		
		Thread.sleep(5000);
		
		
		
	}
	
	public void clickedFirst_viewdetails() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(View_details));
		View_details.click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getTitle().equals("View Log Entry"));
	}
	
	public void validate_Logdetails(String event,String LogEntryObject,ExtentTest test) throws InterruptedException {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		Thread.sleep(2000);
		Assert.assertTrue(!TransactionId.getText().isEmpty());
		System.out.println("Transaction Id is populating and the value is :  "+TransactionId.getText());
		test.log(Status.INFO,"Transaction Id is populating and the value is :  "+TransactionId.getText());
		addSrceenShot("Transaction Id is populating and the value is :  "+TransactionId.getText(), test, Capture);
		
		Assert.assertTrue(lscoStatus.getText().equals("Open")|| lscoStatus.getText().equals("Success"));
		System.out.println("Event Status is populating and the value is :  "+lscoStatus.getText());
		test.log(Status.INFO,"Event Status is populating and the value is :  "+lscoStatus.getText());
		addSrceenShot("Event Status is populating and the value is :  "+lscoStatus.getText(), test, Capture);
		
		Assert.assertTrue(!JSONFilename.getText().isEmpty());
		System.out.println("JSONFilename is populating and the value is :  "+JSONFilename.getText());
		test.log(Status.INFO,"JSONFilename  is populating and the value is :  "+JSONFilename.getText());
		addSrceenShot("JSONFilename  is populating and the value is :  "+JSONFilename.getText(), test, Capture);
		
		Assert.assertTrue(LSCOEvent.getText().equals(event));
		System.out.println("event is populating and the value is :  "+LSCOEvent.getText());
		test.log(Status.INFO,"event is populating and the value is :  "+LSCOEvent.getText());
		addSrceenShot("event is populating and the value is :  "+LSCOEvent.getText(), test, Capture);
		
		Assert.assertTrue(!ObjectId.getText().isEmpty());
		System.out.println("ObjectId  is populating and the value is :  "+ObjectId.getText());
		test.log(Status.INFO,"ObjectId is populating and the value is :  "+ObjectId.getText());
		addSrceenShot("ObjectId is populating and the value is :  "+ObjectId.getText(), test, Capture);
		
		Assert.assertTrue(!JSONFilepath.getText().isEmpty());
		System.out.println("JSONFilepath is populating and the value is :  "+JSONFilepath.getText());
		test.log(Status.INFO,"JSONFilepath is populating and the value is :  "+JSONFilepath.getText());
		addSrceenShot("JSONFilepath is populating and the value is :  "+JSONFilepath.getText(), test, Capture);
		
		if (LogEntryObject.equals("Colorway")){
			Thread.sleep(1000);
			
			System.out.println("Colorway  is populating and the value is :  "+Colorway.getText());
			test.log(Status.INFO,"Colorway is populating and the value is :  "+Colorway.getText());
			addSrceenShot("Colorway is populating and the value is :  "+Colorway.getText(), test, Capture);
			
		}else if(LogEntryObject.equals("Colorway Season")){
			Thread.sleep(1000);
			System.out.println("Colorway  is populating and the value is :  "+Colorway.getText());
			test.log(Status.INFO,"Colorway is populating and the value is :  "+Colorway.getText());
			addSrceenShot("Colorway is populating and the value is :  "+Colorway.getText(), test, Capture);
			
			System.out.println("Season  is populating and the value is :  "+Season.getText());
			test.log(Status.INFO,"Season is populating and the value is :  "+Season.getText());
			addSrceenShot("Season is populating and the value is :  "+Season.getText(), test, Capture);
		}
		else if(LogEntryObject.equals("Linesheet")){
			Thread.sleep(1000);
			
			System.out.println("Season  is populating and the value is :  "+Season.getText());
			test.log(Status.INFO,"Season is populating and the value is :  "+Season.getText());
			addSrceenShot("Season is populating and the value is :  "+Season.getText(), test, Capture);
			
		}
		else if(LogEntryObject.equals("Material")){
			Thread.sleep(1000);
			System.out.println("Material  is populating and the value is :  "+Material.getText());
			test.log(Status.INFO,"Material is populating and the value is :  "+Material.getText());
			addSrceenShot("Material is populating and the value is :  "+Material.getText(), test, Capture);
			
		}
		else if(LogEntryObject.equals("Material Supplier")){
			Thread.sleep(1000);
			System.out.println("Material  is populating and the value is :  "+Material.getText());
			test.log(Status.INFO,"Material is populating and the value is :  "+Material.getText());
			addSrceenShot("Material is populating and the value is :  "+Material.getText(), test, Capture);
			
			System.out.println("MaterialSupplier  is populating and the value is :  "+MaterialSupplier.getText());
			test.log(Status.INFO,"MaterialSupplier is populating and the value is :  "+MaterialSupplier.getText());
			addSrceenShot("MaterialSupplier is populating and the value is :  "+MaterialSupplier.getText(), test, Capture);
		}
		else if(LogEntryObject.equals("Product")){
			Thread.sleep(1000);
			System.out.println("Product  is populating and the value is :  "+Product.getText());
			test.log(Status.INFO,"Product is populating and the value is :  "+Product.getText());
			addSrceenShot("Product is populating and the value is :  "+Product.getText(), test, Capture);
			
		}else if(LogEntryObject.equals("Season")){
			Thread.sleep(1000);
			System.out.println("Season  is populating and the value is :  "+Season.getText());
			test.log(Status.INFO,"Season is populating and the value is :  "+Season.getText());
			addSrceenShot("Season is populating and the value is :  "+Season.getText(), test, Capture);
			
		}else if(LogEntryObject.equals("Affiliate")){
			Thread.sleep(1000);
			System.out.println("Season  is populating and the value is :  "+Season.getText());
			test.log(Status.INFO,"Season is populating and the value is :  "+Season.getText());
			addSrceenShot("Season is populating and the value is :  "+Season.getText(), test, Capture);
			
			System.out.println("Product  is populating and the value is :  "+Product.getText());
			test.log(Status.INFO,"Product is populating and the value is :  "+Product.getText());
			addSrceenShot("Product is populating and the value is :  "+Product.getText(), test, Capture);
			
			System.out.println("Colorway  is populating and the value is :  "+Colorway.getText());
			test.log(Status.INFO,"Colorway is populating and the value is :  "+Colorway.getText());
			addSrceenShot("Colorway is populating and the value is :  "+Colorway.getText(), test, Capture);
			
			System.out.println("Season Group is populating and the value is :  "+SeasonGroup.getText());
			test.log(Status.INFO,"Season Group is populating and the value is :  "+SeasonGroup.getText());
			addSrceenShot("Season Group is populating and the value is :  "+SeasonGroup.getText(), test, Capture);
			
		}
		
		
	}
	public String ValidateRecords() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeContentframe);
		String noofrecords ;
		noofrecords   =totalrecords.getText().substring(14);
		System.out.println(noofrecords);
		return noofrecords;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
