package resources;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utility.jsonUtility;
import utility.selectServer;

public class BaseiOS_RealDevice_With_BundleID {
	
	public  IOSDriver driver;
	AppiumDriverLocalService service;
	protected static JSONObject data;
	Properties prop;
	@BeforeClass
	public void config() throws URISyntaxException, InterruptedException, IOException{
		 data=jsonUtility.getJson("src/test/java/Appium/TestData/data.json");
		
	    prop=new Properties();
        FileInputStream fs=new FileInputStream(data.getString("filePropertyPath")); // Extract file path from json
		prop.load(fs);
		String ipAdress=System.getProperty("ipAdress")!=null ? System.getProperty("ipAdress"):prop.getProperty("ipAdress");
		String port=prop.getProperty("port");
		
		service=selectServer.appiumStartServer(ipAdress, Integer.parseInt(port));		
		XCUITestOptions option =new XCUITestOptions();
		option.setPlatformName("IOS");
		option.setPlatformVersion(prop.getProperty("platformVersion"));
		option.setDeviceName(prop.getProperty("deviceName"));
		option.setAutomationName("xcuitest");
		option.setCapability("appium:xcodeSigningId", "iPhone Developer");
		option.setCapability("appium:udid", prop.getProperty("udid"));
		option.setBundleId(prop.getProperty("bundleID"));
		option.setUsePrebuiltWda(true);
		option.setCapability("appium:setUseNewWDA",false);
		option.setCapability("setClearSystemFiles", true);
		option.setCapability("showXcodeLog",true);
		option.setWdaLaunchTimeout(Duration.ofSeconds(280));
		driver=new IOSDriver(service.getUrl(),option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		
	}
	
	public String getScreenShotPath(String testcaseName, AppiumDriver driver) throws IOException {

	    File source = driver.getScreenshotAs(OutputType.FILE);

	    String basePath;

	    // Detect if running in Jenkins
	    if (System.getenv("JENKINS_HOME") != null) {
	        basePath = System.getProperty("user.dir") + "/test-output/screenshots/";
	    } else {
	        basePath = System.getProperty("user.dir") + "/Report/";
	    }

	    // Create directory if not exists
	    File dir = new File(basePath);
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }

	    String destinationFile = basePath + testcaseName + ".png";

	    FileUtils.copyFile(source, new File(destinationFile));

	    return destinationFile;
	}
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		driver.quit();
		Thread.sleep(1000);
		service.stop();
		Thread.sleep(1000);
	}

}
