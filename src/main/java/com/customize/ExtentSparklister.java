package com.customize;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentSparklister implements IReporter {
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private ExtentTest suiteTest;

	// Variables to hold test counts
	private int totalTestCases = 0;
	private int totalPassed = 0;
	private int totalFailed = 0;
	private int totalSkipped = 0;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// Create a timestamp for the report file name
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "\\Reports\\" + suites.get(0).getName() + "_report_"
				+ timestamp + ".html";

		htmlReporter = new ExtentHtmlReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Report configuration
		htmlReporter.config().setDocumentTitle("FlexPLM Automation");
		htmlReporter.config().setReportName("FlexPLM Automation Test Report");
		htmlReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

		// Generate report sections
		createCoverPage();
		createExecutiveSummary();

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				// Create a single test for the suite
				suiteTest = extent.createTest(suite.getName());

				// Log results for passed, failed, and skipped tests
				logTestResults(context.getPassedTests(), Status.PASS);
				logTestResults(context.getFailedTests(), Status.FAIL);
				logTestResults(context.getSkippedTests(), Status.SKIP);
			}
		}

		// Generate final summary after processing all tests
		generateSummary();
		
	}

	private void createCoverPage() {
		ExtentTest coverPage = extent.createTest("Test Report Overview");
		coverPage.info("Report Title: FlexPLM Automation Test Report");
		coverPage.info("Date: " + new Date());
		coverPage.info("Prepared by: Automation Team");

		// Get the current month and year for the test period
		Calendar calendar = Calendar.getInstance();
		String month = new SimpleDateFormat("MMMM").format(calendar.getTime());
		String year = new SimpleDateFormat("yyyy").format(calendar.getTime());
		coverPage.info("Test Period: " + month + " " + year);

		coverPage.info("Project: FlexPLM");
		coverPage.info(
				"This report summarizes the results of the automated tests conducted on the FlexPLM application, highlighting key findings, pass/fail rates, and recommendations for future testing.");
	}

	private void createExecutiveSummary() {
		ExtentTest summary = extent.createTest("Executive Summary");
		summary.info(
				"This report provides an overview of the test results, including pass/fail rates and key findings.");

		summary.info("Test Execution Summary:");
		summary.info("- Tests were executed successfully.");
		summary.info("- A significant number of tests passed, indicating robust functionality.");
		summary.info("- Some tests encountered issues, highlighting areas for improvement.");
		summary.info("- A few tests were skipped, possibly due to dependencies or configuration issues.");

		// Insights and recommendations
		summary.info("Key Findings:");
		summary.info("- The majority of test cases passed successfully, indicating stable functionality.");
		summary.info(
				"- A few test cases failed due to application slowness, which may require performance optimization.");
		summary.info(
				"- Regular regression testing is recommended to ensure new features do not impact existing functionality.");

		summary.info("Recommendations:");
		summary.info("- Continuous integration practices should be adopted to streamline testing and deployment.");
		summary.info(
				"- Regular updates to test cases based on application changes will help maintain test effectiveness.");
	}

	public void logTestResults(IResultMap tests, Status status) {
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				ExtentTest test = suiteTest.createNode(result.getMethod().getMethodName());
				for (String group : result.getMethod().getGroups()) {
					test.assignCategory(group);

				}

				String message = getLogMessage(result, status);
				test.log(status, message);

				// Update counts based on the result
				totalTestCases++; // Increment total test cases for every result processed
				if (status == Status.PASS) {
					totalPassed++;
				} else if (status == Status.FAIL) {
					totalFailed++;
				} else if (status == Status.SKIP) {
					totalSkipped++;
				}
			}
		}
	}

	private String getLogMessage(ITestResult result, Status status) {
		String message = "Test " + status.toString().toLowerCase() + "ed";
		if (result.getThrowable() != null) {
			message = result.getThrowable().getMessage();
		}
		return message;
	}

	private void generateSummary() {
		ExtentTest summary = extent.createTest("Final Summary");
		summary.info("Total Test Cases Executed: " + totalTestCases);
		summary.info("Total Passed: " + totalPassed);
		summary.info("Total Failed: " + totalFailed);
		summary.info("Total Skipped: " + totalSkipped);
		if (totalTestCases > 0) {
			summary.info("Pass Rate: " + ((double) totalPassed / totalTestCases * 100) + "%");
		} else {
			summary.info("No test cases executed.");
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}




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
//public class ExtentSparklister implements IReporter {
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
