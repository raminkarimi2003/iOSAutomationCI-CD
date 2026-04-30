package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {

	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"//Report//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Result");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ramin Karimi");
		return extent;
		
	}
	
}
