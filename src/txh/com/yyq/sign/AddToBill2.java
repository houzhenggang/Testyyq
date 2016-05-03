package txh.com.yyq.sign;

import java.io.File;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AddToBill2 extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "AddToBill2";
		String testClass = "txh.com.yyq.sign.AddToBill2";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testCase()throws UiObjectNotFoundException{
		addBill2();
	}

	public void addBill2() throws UiObjectNotFoundException {
		UiDevice device = getUiDevice();
		UiObject addBill = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_buy"));
		addBill.clickAndWaitForNewWindow();
		SignInWeiXin signweixin = new SignInWeiXin(getUiDevice());
		signweixin.weixinSignIn();
		sleep(3500);
		device.takeScreenshot(new File("sdcard/Download/afterweixinlogin.png"));

	}

}
