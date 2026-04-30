package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class alertViewPage {
	
	IOSDriver driver;
	String message=null;
	
	public alertViewPage(IOSDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	  
	}
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertView;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Text Entry']")
	private WebElement textEntry;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField")
	private WebElement textInput;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement dismiss_dlg;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name=='Confirm / Cancel'`]")
	private WebElement confirm;
	
	@iOSXCUITFindBy(accessibility="A message should be a short, complete sentence.")
	private WebElement confirmationMessage;
	
	@iOSXCUITFindBy(accessibility="Confirm")
	private WebElement dissmis_dlg;
	
	public void selectAlertView()
	{
		alertView.click();
	}
	
	public void fillTextLable(String text)
	{
		textEntry.click();
		textInput.sendKeys(text);	
		dismiss_dlg.click();
	}
	
	public String selectConfirmAndVerify()
	{
		confirm.click();
		message=confirmationMessage.getText();
		return message;
	}
	
	public void dissmis_dlg()
	{
		dissmis_dlg.click();
	}
}
