package com.mas.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
		
	public static ExtentReports ExtentReport()
	
	{
		String file = System.getProperty("user.dir")+"\\Reports\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("Automation Test Results");
		reporter.config().setReportName("Web Automation Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Analyst", "Ramesh Chellappa");
		return extent;
		
	}

}
