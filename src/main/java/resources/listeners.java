package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class listeners extends BaseiOS_RealDevice_With_BundleID implements ITestListener{
	ExtentTest test;  //object that represent single test case
    ExtentReports extent=extentReporterNG.getReportObject(); //create entry for the class for the entire report file
    AppiumDriver driver = null;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		
		 
		try {
			driver = (AppiumDriver) result.getTestClass()
			            .getRealClass()
			            .getField("driver")
			            .get(result.getInstance());
			
	       String destinationPath=getScreenShotPath(result.getMethod().getMethodName(),driver);
	       test.addScreenCaptureFromPath(destinationPath,result.getMethod().getMethodName());
			//test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
