package com.omrMobile.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrMobile.Report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true,features = "src\\test\\resources")
public class TestRunner {

	@AfterClass
	public static void afterClass() throws Exception {
		Reporting.generateJvmReport(System.getProperty("user.dir")+"\\target");
	}
}
