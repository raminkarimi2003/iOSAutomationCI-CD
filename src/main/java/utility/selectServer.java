package utility;

import java.io.File;
import java.time.Duration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import resources.BaseiOS_RealDevice_With_BundleID;

public class selectServer extends BaseiOS_RealDevice_With_BundleID {
	static AppiumDriverLocalService service;
	public static AppiumDriverLocalService appiumStartServer(String ipAdress, int port)
	{
		service=new AppiumServiceBuilder()
				.withAppiumJS(new File(data.getString("appiumJS")))  // get appium.JS from Json 
				.withIPAddress(ipAdress).usingPort(port).withTimeout(Duration.ofSeconds(60)).build();
		service.start();
		return service;
	}
}
