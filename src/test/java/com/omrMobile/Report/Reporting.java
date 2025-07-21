package com.omrMobile.Report;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	
	public static void generateJvmReport(String jsonFile) throws Exception{
		
		File file = new File(System.getProperty("user.dir")+"\\target");
		Properties prop= new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.properties"));
		Configuration config = new Configuration(file, "Mobile Testing");
		config.addClassifications("Platform", "Android");
		config.addClassifications("Version", "15");
		
		List<String> asList = new ArrayList<String>();
		asList.add(jsonFile);
		ReportBuilder re = new ReportBuilder(asList, config);
		re.generateReports();
	}

}
