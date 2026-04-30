package resources;

import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseiOS_Simulator {
	
	public IOSDriver driver;
	private AppiumDriverLocalService service;
	@BeforeClass
	public void config() throws MalformedURLException, URISyntaxException, InterruptedException{
		service=new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		XCUITestOptions option =new XCUITestOptions();
		option.setApp("/users/raminkarimi/Downloads/UIKitCatalog.app");
		option.setPlatformName("IOS");
		option.setPlatformVersion("16.2");
		option.setDeviceName("iPhone 14");
		option.setUsePrebuiltWda(true);
		option.setWdaLaunchTimeout(Duration.ofSeconds(600));
		driver=new IOSDriver(new URI("http://127.0.0.1:4723").toURL(),option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
