package txh.com.yyq.sign;

import java.io.File;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SignQQ extends UiAutomatorTestCase {
	UiDevice device;

	public SignQQ(UiDevice uidevice) {
		device = uidevice;
	}

	/**
	 * 已登录QQ： 1、授权机锋应用商店使用QQ登录
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void signInqq() throws UiObjectNotFoundException {
		UiObject qq = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/iv_login_QQ"));
		qq.clickAndWaitForNewWindow();
		UiObject qqbtn = new UiObject(
				new UiSelector().resourceId("com.tencent.mobileqq:id/name"));
		qqbtn.clickAndWaitForNewWindow();
		device.takeScreenshot(new File("sdcard/Download/afterqqlogin.pgn"));

	}

}
