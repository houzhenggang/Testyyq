package txh.com.yyq.sign;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
/**
 * 一元抢首页-微信登录登录-注销
 * 1、进入一元抢首页 2、加入清单 3、登录 4、注销
 * @author xiaohua
 *
 */
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
		Logout();
	}

	public void addBill2() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
//		UiDevice device = getUiDevice();
		UiObject addBill = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_buy"));
		addBill.clickAndWaitForNewWindow();
		SignInWeiXin signweixin = new SignInWeiXin(getUiDevice());
		signweixin.weixinSignIn();
		sleep(3500);
//		device.takeScreenshot(new File("sdcard/Download/afterweixinlogin.png"));

	}
	/**
	 * 注销：
	 * 1、点击我的  2、点击注销
	 * @throws UiObjectNotFoundException
	 */
	public void Logout()throws UiObjectNotFoundException{
		ExitGfan exit = new ExitGfan(getUiDevice());
		exit.exit();
	}

}
