package Appium.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.webViewPage;
import io.appium.java_client.AppiumBy;
import resources.BaseiOS_RealDevice_With_BundleID;
import utility.scroll;

public class webView extends BaseiOS_RealDevice_With_BundleID{
    @Test
	public void WebView()
	{
    	By locator=(AppiumBy.accessibilityId("Web View"));
    	scroll.scrollToElement(locator,driver);
    	webViewPage webView=new webViewPage(driver);
    	webView.selectWebView();
	    Assert.assertEquals(webView.getElementText(), "This i HTML content inside a WKWebView .");
	}
}
