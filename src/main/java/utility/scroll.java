package utility;
import org.openqa.selenium.*;

import io.appium.java_client.ios.IOSDriver;
import resources.BaseiOS_RealDevice_With_BundleID;
import java.util.Map;

public class scroll {

	public static  void scrollToElement(By locator, IOSDriver driver) {
	    for (int i = 0; i < 35; i++) {
	        try {
	            WebElement ele = driver.findElement(locator);
	            if (ele.isDisplayed()) {
	                System.out.println("✅ Element found!");
	                return;
	            }
	        } catch (Exception ignored) {}

	        driver.executeScript("mobile: swipe", Map.of("direction", "up", "velocity", 200,"distance",0.3));

	        try { Thread.sleep(850); } catch (Exception ignored) {}
	    }
	    throw new RuntimeException("Element not found after scrolling");
	
	}
}