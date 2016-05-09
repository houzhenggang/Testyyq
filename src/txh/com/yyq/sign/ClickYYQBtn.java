package txh.com.yyq.sign;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ClickYYQBtn extends UiAutomatorTestCase {
	public static void main(String[] args) {
		String jarName = "ClickYYQBtn";
		String testClass = "txh.com.yyq.sign.ClickYYQBtn";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		clickyyqBtn();
		Logout();
	}
	/**
	 * 点击详情页的一元抢：
	 * 1、点击-
	 * 2、点击+
	 * 3、点击-
	 * 4、点击一元抢
	 * 5、点击微信登录
	 * @throws UiObjectNotFoundException
	 */
	public void clickyyqBtn() throws UiObjectNotFoundException {
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject proIcon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_iv_icon"));
		proIcon.clickAndWaitForNewWindow();
		UiObject yyqBtn = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_btn_in_indiana_normal"));
		yyqBtn.click();

		UiObject reduce = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_inindiana_iv_in_indiana_reduce"));
		UiObject add = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_inindiana_iv_in_indiana_add"));
		UiObject count = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_inindiana_item_et_count"));
		System.out.println("before click +/- ,count is :" + count.getText());
		reduce.click();
		System.out.println("after click - ,count is :" + count.getText());
		add.click();
		add.click();
		System.out.println("after click two + ,count is :" + count.getText());
		reduce.click();
		UiObject yyqBtn2 = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_yyq_detail_btn_in_indiana"));
		yyqBtn2.click();
		SignInWeiXin signweixin = new SignInWeiXin(getUiDevice());
		signweixin.weixinSignIn();
		sleep(3500);
		yyqBtn2.click();
		sleep(2000);

	}

	/**
	 * 注销： 1、点击我的 2、点击注销
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void Logout() throws UiObjectNotFoundException {
		ExitGfan exit = new ExitGfan(getUiDevice());
		exit.exit();
	}

}
