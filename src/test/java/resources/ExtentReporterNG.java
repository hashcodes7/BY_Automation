package resources;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 
public class ExtentReporterNG implements IReporter {
    ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
    
    
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    	
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\htmlreport.html");
       extent = new ExtentReports();
        
        extent.attachReporter(htmlReporter);
       
       htmlReporter.config().setDocumentTitle("WMS Automation");
       htmlReporter.config().setReportName("WMS Automation-Test Report");
        
        
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
 
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                
            }
        }
 
        
        
    }
 
 
    public void buildTestNodes(IResultMap tests, Status status) {
      
        ExtentTest test;
 
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());
              
 
                /*test.getTest(). = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());*/
 
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
 
                String message = "Test " + status.toString().toLowerCase() + "ed";
 
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
 
                test.log(status, message);
 
                
            }
        }
    }
 
    @SuppressWarnings("unused")
	private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();  
        
    }
}

//package resources;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.testng.IReporter;
//import org.testng.IResultMap;
//import org.testng.ISuite;
//import org.testng.ISuiteResult;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.xml.XmlSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class ExtentReporterNG implements IReporter {
//    ExtentReports extent;
//    ExtentHtmlReporter htmlReporter;
//    ExtentTest suiteTest; // Create a single test for the suite
//
//    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
////        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\htmlreport.html");
////        extent = new ExtentReports();
////        extent.attachReporter(htmlReporter);
//    	
//    	// Set the report path to the specified format
//        String reportPath = System.getProperty("user.dir") + "\\Reports\\" + suites.get(0).getName() + "_report.html";
//        htmlReporter = new ExtentHtmlReporter(reportPath);
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        htmlReporter.config().setDocumentTitle("WMS Automation");
//        htmlReporter.config().setReportName("WMS Automation-Test Report");
//
//        for (ISuite suite : suites) {
//            Map<String, ISuiteResult> result = suite.getResults();
//
//            for (ISuiteResult r : result.values()) {
//                ITestContext context = r.getTestContext();
//                
//                // Create a single test for the suite
//                suiteTest = extent.createTest(suite.getName());
//
//                // Log results for passed, failed, and skipped tests
//                logTestResults(context.getPassedTests(), Status.PASS);
//                logTestResults(context.getFailedTests(), Status.FAIL);
//                logTestResults(context.getSkippedTests(), Status.SKIP);
//            }
//        }
//
//        
//    }
//
//    public void logTestResults(IResultMap tests, Status status) {
//        if (tests.size() > 0) {
//            for (ITestResult result : tests.getAllResults()) {
//                ExtentTest test = suiteTest.createNode(result.getMethod().getMethodName()); // Create a node for each test
//                for (String group : result.getMethod().getGroups())
//                    test.assignCategory(group);
//
//                String message = "Test " + status.toString().toLowerCase() + "ed";
//                if (result.getThrowable() != null)
//                    message = result.getThrowable().getMessage();
//
//                test.log(status, message);
//            }
//        }
//    }
//
//    private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();
//    }
//}
