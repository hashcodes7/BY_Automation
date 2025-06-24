package com.WMS_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class WMS_Test {

	
	  @Test
	  public void testGuru99TakeScreenShot() throws Exception{
		  
		  WebDriver driver = new ChromeDriver(); 
	  
		  System.setProperty("webdriver.chrome.driver","C:\\Sandip\\chromedriver_win32\\chromedriver.exe");
		  
		 
	  
	  //goto url
	  
	  driver.get("https://levis.sce.manh.com/");
	  
	  //Call take screenshot function
	  
	  this.takeSnapShot(driver, "C:\\Users\\2027814\\OneDrive - Cognizant\\testScreenshots.png") ;
	  
	  }
	 

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception

     */

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
    	
    	
    	

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
                
                System.out.println(fileWithPath);

    }

}

