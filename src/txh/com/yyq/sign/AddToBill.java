package txh.com.yyq.sign;


import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AddToBill extends UiAutomatorTestCase {
//	UiDevice device;
//	public AddToBill(UiDevice uidevice){
//		device = uidevice;
//	}

	public static void main(String[] args) {
		String jarName = "AddToBill";
		String testClass = "txh.com.yyq.sign.AddToBill";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testCase()throws UiObjectNotFoundException{
		addBill();
		Logout();
	}

	/**
	 * 未登录-加入清单-登录： 1、点击应用商店首页加入清单 2、调用SignInMappn进行登录
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void addBill() throws UiObjectNotFoundException {
//		UiDevice device = getUiDevice();
		UiObject addBill = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_tv_buy"));
		addBill.clickAndWaitForNewWindow();
		SignInMappn signinmappn = new SignInMappn(getUiDevice());
		signinmappn.signIn();
		addBill.click();
//		device.takeScreenshot(new File("sdcard/Download/clickaddBill.png"));

	}
	/**
	 * 注销：
	 * 1、点击一元抢进入一元抢首页 2、点击我的 3、点击注销
	 * @throws UiObjectNotFoundException
	 */
	public void Logout()throws UiObjectNotFoundException{
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		ExitGfan exit = new ExitGfan(getUiDevice());
		exit.exit();
	}

}
