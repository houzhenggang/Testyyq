package txh.com.yyq.sign;

import java.io.File;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SignInWeiXin extends UiAutomatorTestCase {
	UiDevice device;

	public SignInWeiXin(UiDevice uidevice) {
		device = uidevice;
	}

	/**
	 * 已登录微信： 1、授权应用商店使用微信登录
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void weixinSignIn() throws UiObjectNotFoundException {
		UiObject weixinSignIn = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/iv_login_weichat"));
		weixinSignIn.clickAndWaitForNewWindow();
		device.takeScreenshot(new File("sdcard/Download/clickweixin.png"));
		UiObject btnOk = new UiObject(new UiSelector().resourceId("btnOk"));
		btnOk.clickAndWaitForNewWindow();
		System.out.println("weixin signin sucessful!!");

	}

}
