package Appium.TestCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import resources.BaseiOS_RealDevice_With_BundleID;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.alertViewPage;

public class alertView extends BaseiOS_RealDevice_With_BundleID {
	//public class alertView extends BaseiOS_Simulator {	
	@Test
	public void AlertView() throws InterruptedException
	{
		alertViewPage alertView=new alertViewPage(driver);
		alertView.selectAlertView();
        alertView.fillTextLable(data.getString("input"));
		String text=alertView.selectConfirmAndVerify();
	    AssertJUnit.assertEquals(text,"A message should be a short, complete sentence." );
	    alertView.dissmis_dlg();
	}

}
