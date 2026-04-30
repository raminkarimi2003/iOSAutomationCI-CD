package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.ios.IOSDriver;

public class webViewPage {

	IOSDriver driver;
	public webViewPage(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


@iOSXCUITFindBy(accessibility="Web View")
private WebElement webView;

@iOSXCUITFindBy(accessibility="This is HTML content inside a WKWebView .")
private WebElement elementText;

public void selectWebView()
{
	webView.click();
}

public String getElementText()
{
	return elementText.getAttribute("name");
}
}